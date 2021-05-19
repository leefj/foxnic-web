package com.scientific.tailoring.order.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.meta.DBColumnMeta;
import com.github.foxnic.dao.meta.DBTableMeta;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.Expr;
import com.github.foxnic.sql.expr.In;
import com.github.foxnic.sql.expr.OrderBy;
import com.github.foxnic.sql.expr.SQL;
import com.github.foxnic.sql.expr.Select;
import com.scientific.tailoring.constants.db.Tailoring.ODR_MEASURE;
import com.scientific.tailoring.constants.db.Tailoring.ODR_MEASURE_DATA;
import com.scientific.tailoring.constants.enums.dict.MeasureStatus;
import com.scientific.tailoring.domain.order.AppMeasureModel;
import com.scientific.tailoring.domain.order.BodyVO;
import com.scientific.tailoring.domain.order.Measure;
import com.scientific.tailoring.domain.order.MeasureDimensionModel;
import com.scientific.tailoring.domain.order.MeasureVO;
import com.scientific.tailoring.domain.system.DictItem;
import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.order.service.IBodyService;
import com.scientific.tailoring.order.service.IMeasureService;
import com.scientific.tailoring.system.service.IDictService;
import com.scientific.tailoring.system.service.ILangService;

/**
 * <p>
 * 订单测量信息表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-22 04:19:26
*/

@Service("OdrMeasureServiceImpl")
public class MeasureServiceImpl extends SuperService<Measure> implements IMeasureService {
	
	@Autowired
	private IDictService dictService;
	
	@Autowired
	private IBodyService bodyService;
	
	@Autowired
	private ILangService langService;
	
	
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
	
	/**
	 * 按主键删除订单测量信息
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , Measure对象
	 */
	public boolean deleteByIdPhysical(Long id) {
		Measure measure = new Measure();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		measure.setId(id);
		return dao.deleteEntity(measure);
	}
	
	/**
	 * 按主键删除订单测量信息
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , Measure对象
	 */
	public boolean deleteByIdLogical(Long id) {
		Measure measure = new Measure();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		measure.setId(id);
		measure.setDeleted(true);
		measure.setDeleteBy((Long)dao.getDBTreaty().getLoginUserId());
		measure.setDeleteTime(new Date());
		return dao.updateEntity(measure,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 按主键获取订单测量信息
	 *
	 * @param id ID
	 * @return 查询结果 , Measure对象
	 */
	public Measure getById(Long id) {
		Measure sample = new Measure();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}
	
	@Override
	public PagedList<Measure> queryPagedList(Measure sample, OrderBy orderBy,int pageSize, int pageIndex) {
		PagedList<Measure> list=super.queryPagedList(sample, orderBy,pageSize, pageIndex);
		dao.join(list, DictItem.class);
		return list;
	}
	
	private Expr getBasicQuerySQL(Long orderId) {
		return new Expr("select b.id bid,b.body_name,b.body_dept,b.body_sex,b.body_height, m.* FROM odr_body b left join odr_measure m  on m.body_id=b.id and m.order_id=b.order_id and m.deleted=0 where b.deleted=0 and b.order_id=?",orderId);
	}
	
	@Override
	public PagedList<MeasureVO> queryPagedList(MeasureVO sample,int pageSize, int pageIndex) {
		Expr select=getBasicQuerySQL(sample.getOrderId());
		BodyVO bodyVo=sample.toPojo(BodyVO.class);
		ConditionExpr ce=bodyService.buildQueryCondition(bodyVo, "b");
		select.append(ce.startWithAnd());
		select.append("order by b.create_time desc,body_id");
		PagedList<MeasureVO> list=this.dao.queryPagedEntities(MeasureVO.class, select, pageSize, pageIndex);
		dao.join(list, DictItem.class);
		return list;
	}
	

	@Override
	public Map<Long, Map<String, Integer>> groupByOrderStatus(List<Long> orderIds) {
		In in=new In("b.order_id",orderIds);
		String[] sub= {
				"select order_id,status,count(1) summary from (",
				"select b.order_id,IFNULL(status,'todo') status  from odr_body b ",
				"left join odr_measure m on  m.body_id=b.id and m.deleted=0 and b.order_id=m.order_id",
				"where  b.deleted=0 and "+in.getListParameterSQL()+" ) x",
				"group by order_id,status"
		};
	 
		Expr select =new Expr(SQL.joinSQLs(sub),in.getListParameters());
 
		RcdSet rs=dao.query(select);
		Map<Long, Map<String, Integer>> maps=new HashMap<>();
		for (Rcd r: rs) {
			Map<String, Integer> map=maps.get(r.getLong("order_id"));
			if(map==null) {
				map=new HashMap<>();
				maps.put(r.getLong("order_id"),map);
			}
			map.put(r.getString("status"),r.getInteger("summary"));
		}
		return maps;
	}

	@Override
	public PagedList<AppMeasureModel> queryPagedEntities4App(Long orderId, List<String> status, Integer pageSize,
			Integer pageIndex) {
 
		In in=new In("status", status);
		boolean hasTodo=false;
		for (String s : status) {
			if(MeasureStatus.TODO.code().equals(s)) {
				hasTodo=true;
			}
		}
		
		Expr select=getBasicQuerySQL(orderId);
		ConditionExpr ce=new ConditionExpr();
		ce.and("( "+in.getListParameterSQL()+(hasTodo? " or status is null ":"")+")",in.getListParameters());
		select.appendIf(ce.startWithAnd());
		select.append(OrderBy.byDescNullsLast("m.create_time"));
 
		PagedList<AppMeasureModel> list=dao.queryPagedEntities(AppMeasureModel.class, select,pageSize,pageIndex);
		for (AppMeasureModel m : list) {
			if(m.getStatus()==null) {
				m.setStatus(MeasureStatus.TODO.code());
			}
		}
 
		dictService.translate("measure_status", list, AppMeasureModel::getStatus, AppMeasureModel::setStatusLabel);
		 
		return list;
	}

	@Override
	public List<MeasureDimensionModel> getMeasureDimensions() {
		DBTableMeta tm=dao.getTableMeta(ODR_MEASURE_DATA.$NAME);
		List<MeasureDimensionModel> list=new ArrayList<MeasureDimensionModel>();
		for (DBColumnMeta cm : tm.getColumns()) {
			MeasureDimensionModel m=new MeasureDimensionModel();
			if(!cm.getJDBCDataType().equals("DECIMAL")) continue;
			m.setDbField(cm.getColumn());
			m.setProperty(cm.getColumnVarName()); 
			m.setLabel(langService.translate(cm.getLabel()));
			list.add(m);
		}
		return list;
	}

	@Override
	public void updateStatus(Long measureId, String status) {
		dao.update(ODR_MEASURE.$NAME)
		.set(ODR_MEASURE.STATUS,status)
		.where().andEquals(ODR_MEASURE.ID,measureId)
		.top().execute();
	}

}