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
import com.github.foxnic.sql.expr.In;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.changes.service.IExampleOrderItemService;
import org.github.foxnic.web.changes.service.IExampleOrderService;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.enums.changes.ApprovalAction;
import org.github.foxnic.web.constants.enums.changes.ApprovalStatus;
import org.github.foxnic.web.constants.enums.changes.ChangeType;
import org.github.foxnic.web.domain.bpm.Appover;
import org.github.foxnic.web.domain.changes.*;
import org.github.foxnic.web.framework.change.ChangesAssistant;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

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
	//在变更类型定义中定义的代码
	public static final String CHANGE_DEFINITION_CODE="EXAMPLE_ORDER_CHANGE";
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
		exampleOrder.setChsTypeEnum(ChangeType.create);
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


	private void syncOrder(String id,ChangeEvent event) {
		ExampleOrder order4Update=ExampleOrder.create();
		order4Update.setId(id)
				//设置变更ID
				.setChangeInstanceId(event.getInstance().getId())
				//更新订单状态
				.setChsStatusEnum(event.getInstance().getStatusEnum())
				//更新订单最后审批人
				.setLatestApproverId(event.getApproverId())
				.setLatestApproverName(event.getApproverName())
				//设置下一节点审批人
				.setNextApproverIds(event.getSimpleNextApproverIds())
				.setNextApproverNames(event.getSimpleNextApproverNames())
				//更新订单流程概要
				.setSummary(event.getDefinition().getName()+","+event.getApproveActionEnum().text());
		//执行更新
		this.update(order4Update,SaveMode.BESET_FIELDS);
	}

	/**
	 * 批量启动审批
	 * */
	@Override
	public Result startProcess(ProcessStartVO startVO) {
		Result result=new Result();
		for (String id : startVO.getBillIds()) {
			Result<ChangeEvent> r=startProcess(id);
			if(r.failure()) {
				result.addError(r);
			} else {
				// 处理逻辑
				ChangeEvent event=r.data();
				syncOrder(id,event);
			}
		}
		return result;
	}

	/**
	 * 启动审批
	 * */
	public Result startProcess(String id) {

		//变更后数据
		ExampleOrder orderAfter=this.getById(id);
		if(orderAfter==null) {
			return ErrorDesc.failure().message("订单不存在");
		}
		//校验是否勾选的订单都处于待审批状态
		if(orderAfter.getChsStatusEnum()!= ApprovalStatus.drafting) {
			return ErrorDesc.failure().message("订单状态错误,无法提交审批");
		}
		//关联订单明细
		this.join(orderAfter, ExampleOrderItem.class);
		List<String> billIds=Arrays.asList(orderAfter.getId());

		//变更前数据
		ExampleOrder orderBefore=this.getById(orderAfter.getSourceId());
		this.join(orderBefore, ExampleOrderItem.class);


		//创建变更辅助工具
		ChangesAssistant assistant=new ChangesAssistant(this);
		ChangeRequestBody requestBody=new ChangeRequestBody(CHANGE_DEFINITION_CODE, ChangeType.create);

		//设置当前提交人
		requestBody.setApproverId(SessionUser.getCurrent().getActivatedEmployeeId());
		requestBody.setApproverName(SessionUser.getCurrent().getRealName());

		//可按数据情况，设置不同的审批人；若未设置审批人，则按变更配置中的审批人执行；
		//后续可按审批人对接待办体系
		List<Appover> employeeApprovers=assistant.getEmployeeApproversById("E001","488741245229731840");
		List<Appover> bpmRoleApprovers1=assistant.getBpmRoleApproversById("498946989573017600","498947090244702209");
		List<Appover> bpmRoleApprovers2=assistant.getBpmRoleApproversByCode("drafter","approver");

		List<Appover> appovers=new ArrayList<>();
		appovers.addAll(employeeApprovers);
		appovers.addAll(bpmRoleApprovers1);
		appovers.addAll(bpmRoleApprovers2);

		requestBody.setNextNodeAppovers(appovers);

		//
		requestBody.setDataType(ExampleOrder.class);
		//设置变更前数据,simple审批模式仅支持单据的独立审批
		requestBody.setDataBefore(orderBefore);
		//设置变更后数据,simple审批模式仅支持单据的独立审批
		requestBody.setDataAfter(orderAfter);
		//设置审批单据号
		requestBody.setBillIds(billIds);
		//设置审批意见
		requestBody.setOpinion(requestBody.getOpinion());
		//发起审批
		Result result= assistant.request(requestBody);
		return result;
	}

	@Override
	public Result approve(ProcessApproveVO approveVO) {
		Result result=new Result();
		if(approveVO.getInstanceIds()==null || approveVO.getInstanceIds().isEmpty()) {
			return result.success(false).message("至少指定一个变更ID");
		}

		In in=new In(FoxnicWeb.CHS_EXAMPLE_ORDER.CHANGE_INSTANCE_ID,approveVO.getInstanceIds());

		List<ExampleOrder> orders=this.queryList(in.toConditionExpr());
		Map<String,List<ExampleOrder>> ordersMap= CollectorUtil.groupBy(orders,ExampleOrder::getChangeInstanceId);

		for (Map.Entry<String,List<ExampleOrder>> e : ordersMap.entrySet()) {
			Result<ChangeEvent > r=this.approve(e.getKey(),e.getValue(),approveVO.getAction(),approveVO.getOpinion());
			if(r.failure()){
				result.addError(r);
			} else {
				//同步订状态
				ChangeEvent event=r.data();
				for (ExampleOrder exampleOrder : e.getValue()) {
					syncOrder(exampleOrder.getId(),event);
				}
			}
		}
		return result;
	}


	public Result approve(String instanceId, List<ExampleOrder> orders,String approveAction,String opinion) {

		ApprovalAction action=ApprovalAction.parseByCode(approveAction);
		//审批数据

		if(orders==null || orders.isEmpty()) {
			return ErrorDesc.failure().message("订单不存在");
		}
		ExampleOrder order=orders.get(0);

		ChangeApproveBody approveBody=new ChangeApproveBody(CHANGE_DEFINITION_CODE);
		//设置变更ID
		approveBody.setChangeInstanceId(order.getChangeInstanceId());
		//设置当前提交人
		approveBody.setApproverId(SessionUser.getCurrent().getActivatedEmployeeId());
		approveBody.setApproverName(SessionUser.getCurrent().getRealName());
		approveBody.setApprovalAction(action);
		//设置审批意见
		approveBody.setOpinion(opinion);

		//创建变更辅助工具
		ChangesAssistant assistant=new ChangesAssistant(this);
		//发起审批
		Result result= assistant.approve(approveBody);
		//
		return result;
	}

	/**
	 * 改变订单审批状态，使其变成可编辑的草稿；具体需要使其以何种方式转换成草稿视业务而定
	 * */
	@Override
	public Result draft(ProcessStartVO startVO) {
		List<ExampleOrder> orders=this.getByIds(startVO.getBillIds());
		Result result = new Result();
		for (ExampleOrder order : orders) {
			if(order.getChsStatusEnum()==null || order.getChsStatusEnum()==ApprovalStatus.passed || order.getChsStatusEnum()==ApprovalStatus.abandoned) {
				order.setChangeInstanceId(null);
				order.setChsStatusEnum(ApprovalStatus.drafting);
				order.setSummary("起草");
			} else {
				result.addError(ErrorDesc.failure().message("当前审批状态不允许起草"));
			}
		}
		if(result.failure()) {
			return result;
		}

		this.updateList(orders,SaveMode.DIRTY_FIELDS);

		return result;
	}


	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}
