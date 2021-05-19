package com.scientific.tailoring.order.service.impl;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.foxnic.commons.busi.id.SequenceType;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.CollectorUtil;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.Expr;
import com.github.foxnic.sql.expr.In;
import com.github.foxnic.sql.expr.OrderBy;
import com.scientific.tailoring.constants.db.Tailoring.ODR_ORDER;
import com.scientific.tailoring.constants.enums.dict.OrderStatus;
import com.scientific.tailoring.domain.crm.Company;
import com.scientific.tailoring.domain.order.AppOrderModel;
import com.scientific.tailoring.domain.order.Measure;
import com.scientific.tailoring.domain.order.Order;
import com.scientific.tailoring.domain.order.OrderVO;
import com.scientific.tailoring.domain.system.DictItem;
import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.order.service.IMeasureService;
import com.scientific.tailoring.order.service.IOrderService;
import com.scientific.tailoring.system.service.IAreaService;
import com.scientific.tailoring.system.service.IDictService;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-22 01:32:54
*/

@Service("OdrOrderServiceImpl")
public class OrderServiceImpl extends SuperService<Order> implements IOrderService {
	
	
	@Autowired
	private IDictService dictService;

	@Autowired
	private IAreaService areaService;

	@Autowired
	private IMeasureService measureService;
	
	
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
	
	/**
	 * 生成主键值
	 * */
	@Override
	public Object generateId(Field field) {
		return null;
	}
	
	/**
	 * 按主键删除订单
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , Order对象
	 */
	public boolean deleteByIdPhysical(Long id) {
		Order order = new Order();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		order.setId(id);
		return dao.deleteEntity(order);
	}
	
	/**
	 * 按主键删除订单
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , Order对象
	 */
	public boolean deleteByIdLogical(Long id) {
		Order order = new Order();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		order.setId(id);
		order.setDeleted(true);
		order.setDeleteBy((Long)dao.getDBTreaty().getLoginUserId());
		order.setDeleteTime(new Date());
		return dao.updateEntity(order,SaveMode.NOT_NULL_FIELDS);
	}
	
	@Override
	public boolean insert(Order entity) {
		String seqId=ODR_ORDER.$NAME+"."+ODR_ORDER.ORDER_NO;
		if(!dao.isSequenceExists(seqId)) {
			dao.createSequence(seqId, SequenceType.DAI, 3);
		}
		String orderNo=dao.getNextSequenceValue(seqId);
		entity.setOrderNo(orderNo);
		entity.setStatus(OrderStatus.TODO.code());
		return super.insert(entity);
	}
	
	/**
	 * 按主键获取订单
	 *
	 * @param id ID
	 * @return 查询结果 , Order对象
	 */
	public Order getById(Long id) {
		Order sample = new Order();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}
	
	@Override
	public PagedList<Order> queryPagedList(Order sample, int pageSize, int pageIndex) {
		ConditionExpr ce=this.buildQueryCondition(sample);
		if(sample instanceof OrderVO) {
			OrderVO vo=(OrderVO)sample;
			if("companyName".equals(vo.getSearchField()) && !StringUtil.isBlank(vo.getSearchValue())) {
				ce.and("exists (select 1 from crm_company where name like ? and company_id=crm_company.id)","%"+vo.getSearchValue()+"%");
			}
		}
		PagedList<Order> list=super.queryPagedList(sample,ce,OrderBy.byDesc(ODR_ORDER.CREATE_TIME),pageSize, pageIndex);
		dao.join(list, Measure.class,Company.class,DictItem.class);
		dao.join(list, Measure.class);
		return list;
	}
	

	@Override
	public PagedList<AppOrderModel> queryPagedEntities4App(Long companyId, OrderVO sample, Integer pageSize,
			Integer pageIndex) {
		Expr select=new Expr("select o.*,c.name company_name from odr_order o,crm_company c where c.id=o.company_id and o.deleted=0 and o.company_id=? order by o.create_time desc",companyId);
		PagedList<AppOrderModel> list=dao.queryPagedEntities(AppOrderModel.class,select, pageSize, pageIndex);
		if(list.size()==0) return list;
		List<Long> orderIds=CollectorUtil.collectList(list,AppOrderModel::getId);
		
		//设置产品图片
		select=new Expr("select order_id,img.file_id image_id from odr_product p1,prd_product p2,prd_product_image img where p1.product_id=p2.id and img.product_id=p2.id");
		In in=new In("order_id",orderIds);
		select.append(in.toConditionExpr());
		select.append("order by p2.id , img.is_chief desc,img.create_time asc");
		RcdSet images=dao.query(select);
		Map<Long,List<Rcd>> gImg= images.getGroupedMap("order_id", Long.class);
		//量体汇总
		Map<Long,Map<String,Integer>> summary=measureService.groupByOrderStatus(orderIds);
		for (AppOrderModel o : list) {
			List<Rcd> imgs=gImg.get(o.getId());
			if(imgs!=null && imgs.size()>0) {
				o.setImageId(imgs.get(0).getLong("image_id"));
			}
			Map<String,Integer> sum=summary.get(o.getId());
			o.setStatusSummary(sum);
		}

		//状态
		dictService.translate("order_status",list,AppOrderModel::getStatus,AppOrderModel::setStatusName); 

		areaService.translate(list,AppOrderModel::getProvinceId,AppOrderModel::setProvinceName);
		areaService.translate(list,AppOrderModel::getCityId,AppOrderModel::setCityName);
		areaService.translate(list,AppOrderModel::getAreaId,AppOrderModel::setAreaName);
		areaService.translate(list,AppOrderModel::getTownId,AppOrderModel::setTownName);

		for (AppOrderModel o : list) {
			o.setFullAddress(o.getProvinceName()+o.getCityName()+o.getAreaName()+o.getTownName()+o.getAddressDetail());
		}


		return list;
	}





}