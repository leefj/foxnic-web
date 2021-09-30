package org.github.foxnic.web.changes.service.impl;


import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.changes.service.IExampleOrderItemService;
import org.github.foxnic.web.changes.service.IExampleOrderService;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.enums.changes.ChangeStatus;
import org.github.foxnic.web.constants.enums.changes.ChangeType;
import org.github.foxnic.web.domain.changes.ChangeRequestBody;
import org.github.foxnic.web.domain.changes.ExampleOrder;
import org.github.foxnic.web.domain.changes.ExampleOrderItem;
import org.github.foxnic.web.framework.change.ChangesAssistant;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 变更示例订单表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-28 16:54:53
 * @version
*/


@Service("ChsExampleOrderService")
public class ExampleOrderServiceImpl extends SuperService<ExampleOrder> implements IExampleOrderService {
	
	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }

	@Autowired
	private IExampleOrderItemService orderItemService;


	
	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}
	
	/**
	 * 插入实体
	 * @param exampleOrder 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(ExampleOrder exampleOrder) {
		//创建订单，标记变更状态等信息
		exampleOrder.setChsVersion(1);
		exampleOrder.setChsStatusEnum(ChangeStatus.prepare);
		exampleOrder.setChsTypeEnum(ChangeType.create);
		exampleOrder.setProcSummary("采购下单");
		exampleOrder.setOrderTime(new Date());
		Result r=super.insert(exampleOrder);
		return r;
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param exampleOrderList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<ExampleOrder> exampleOrderList) {
		return super.insertList(exampleOrderList);
	}
	
	
	/**
	 * 按主键删除 变更示例订单
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		ExampleOrder exampleOrder = new ExampleOrder();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		exampleOrder.setId(id);
		try {
			boolean suc = dao.deleteEntity(exampleOrder);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 变更示例订单
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		ExampleOrder exampleOrder = new ExampleOrder();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		exampleOrder.setId(id);
		exampleOrder.setDeleted(dao.getDBTreaty().getTrueValue());
		exampleOrder.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		exampleOrder.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(exampleOrder,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 更新实体
	 * @param exampleOrder 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(ExampleOrder exampleOrder , SaveMode mode) {
		Result r=super.update(exampleOrder , mode);
		return r;
	}
	
	/**
	 * 更新实体集，事务内
	 * @param exampleOrderList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<ExampleOrder> exampleOrderList , SaveMode mode) {
		return super.updateList(exampleOrderList , mode);
	}
	
	
	/**
	 * 按主键更新字段 变更示例订单
	 *
	 * @param id 主键
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	} 
	
	
	/**
	 * 按主键获取 变更示例订单
	 *
	 * @param id 主键
	 * @return ExampleOrder 数据对象
	 */
	public ExampleOrder getById(String id) {
		ExampleOrder sample = new ExampleOrder();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<ExampleOrder> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<ExampleOrder> queryList(ExampleOrder sample) {
		return super.queryList(sample);
	}
	
	
	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<ExampleOrder> queryPagedList(ExampleOrder sample, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, pageSize, pageIndex);
	}
	
	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @param condition 其它条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<ExampleOrder> queryPagedList(ExampleOrder sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param exampleOrder 数据对象
	 * @return 判断结果
	 */
	public Result<ExampleOrder> checkExists(ExampleOrder exampleOrder) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(exampleOrder, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(ExampleOrder sample) {
		return super.exportExcel(sample);
	}

	@Override
	public ExcelWriter exportExcelTemplate() {
		return super.exportExcelTemplate();
	}

	@Override
	public List<ValidateResult> importExcel(InputStream input,int sheetIndex,boolean batch) {
		return super.importExcel(input,sheetIndex,batch);
	}

	@Override
	public void calcAmount(String orderId) {
		Double amount=dao.queryDouble("select sum(price * quantity) from "+orderItemService.table()+" where order_id=? and deleted=0",orderId);
		this.update(FoxnicWeb.CHS_EXAMPLE_ORDER.AMOUNT,amount,orderId);
	}

	@Override
	public Result startApprove(List<String> ids) {

		//变更后数据
		List<ExampleOrder> ordersAfter=this.getByIds(ids);
		if(ordersAfter.size()==0) {
			return ErrorDesc.failure().message("订单不存在");
		}
		//校验是否勾选的订单都处于待审批状态
		for (ExampleOrder order : ordersAfter) {
			if(order.getChsStatusEnum()!=ChangeStatus.prepare) {
				return ErrorDesc.failure().message("订单状态错误");
			}
		}
		//关联订单明细
		this.join(ordersAfter, ExampleOrderItem.class);

		//变更前数据
		List<String> idsBefore= CollectorUtil.collectList(ordersAfter,ExampleOrder::getSourceId);
		List<ExampleOrder> ordersBefore=this.getByIds(idsBefore);
		this.join(ordersBefore, ExampleOrderItem.class);

		//创建变更辅助工具
		ChangesAssistant assistant=new ChangesAssistant(this);
		ChangeRequestBody requestBody=new ChangeRequestBody("EXAMPLE_ORDER_CHANGE", ChangeType.create);

		//设置变更前数据
		requestBody.setDataBefore(ExampleOrder.class,ordersBefore);
		//设置变更后数据
		requestBody.setDataAfter(ExampleOrder.class,ordersAfter);

		Result result= assistant.request(requestBody);
		return result;
	}



	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}