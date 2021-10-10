package org.github.foxnic.web.changes.service.impl;


import com.alibaba.fastjson.JSON;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.changes.service.*;
import org.github.foxnic.web.constants.enums.changes.ApprovalAction;
import org.github.foxnic.web.constants.enums.changes.ApprovalEventType;
import org.github.foxnic.web.constants.enums.changes.ApprovalMode;
import org.github.foxnic.web.constants.enums.changes.ApprovalStatus;
import org.github.foxnic.web.domain.changes.*;
import org.github.foxnic.web.framework.cache.RedisUtil;
import org.github.foxnic.web.framework.change.ChangesAssistant;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 变更实例表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-29 10:50:33
 * @version
*/


@Service("ChsChangeInstanceService")
public class ChangeInstanceServiceImpl extends SuperService<ChangeInstance> implements IChangeInstanceService {
	
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
	private IChangeDefinitionService definitionService;

	@Autowired
	private IChangeEventService eventService;

	@Autowired
	private IChangeDataService dataService;

	@Autowired
	private IChangeBillService billService;
	
	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}


	@Autowired
	private  RedisUtil redis;

	/**
	 * 插入实体
	 * @param changeInstance 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(ChangeInstance changeInstance) {
		Result r=super.insert(changeInstance);
		return r;
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param changeInstanceList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<ChangeInstance> changeInstanceList) {
		return super.insertList(changeInstanceList);
	}
	
	
	/**
	 * 按主键删除 变更实例
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		ChangeInstance changeInstance = new ChangeInstance();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		changeInstance.setId(id);
		try {
			boolean suc = dao.deleteEntity(changeInstance);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 变更实例
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		ChangeInstance changeInstance = new ChangeInstance();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		changeInstance.setId(id);
		changeInstance.setDeleted(dao.getDBTreaty().getTrueValue());
		changeInstance.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		changeInstance.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(changeInstance,SaveMode.NOT_NULL_FIELDS);
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
	 * @param changeInstance 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(ChangeInstance changeInstance , SaveMode mode) {
		Result r=super.update(changeInstance , mode);
		return r;
	}
	
	/**
	 * 更新实体集，事务内
	 * @param changeInstanceList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<ChangeInstance> changeInstanceList , SaveMode mode) {
		return super.updateList(changeInstanceList , mode);
	}
	
	
	/**
	 * 按主键更新字段 变更实例
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
	 * 按主键获取 变更实例
	 *
	 * @param id 主键
	 * @return ChangeInstance 数据对象
	 */
	public ChangeInstance getById(String id) {
		ChangeInstance sample = new ChangeInstance();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<ChangeInstance> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<ChangeInstance> queryList(ChangeInstance sample) {
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
	public PagedList<ChangeInstance> queryPagedList(ChangeInstance sample, int pageSize, int pageIndex) {
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
	public PagedList<ChangeInstance> queryPagedList(ChangeInstance sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param changeInstance 数据对象
	 * @return 判断结果
	 */
	public Result<ChangeInstance> checkExists(ChangeInstance changeInstance) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(changeInstance, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(ChangeInstance sample) {
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

	/**
	 * 发起变更请求
	 * */
	@Override
	@Transactional
	public Result<ChangeEvent> request(ChangeRequestBody request) {
		Result<ChangeEvent> result=new Result<>();

		if(StringUtil.isBlank(request.getApproverId()) || StringUtil.isBlank(request.getApproverName())) {
			result.success(false).message("未指定当前审批人");
			//
			return result;
		}

		String simpleNodeId=IDGenerator.getSnowflakeIdString();

		ChangeEvent event=new ChangeEvent();
		event.setNotifyTime(new Timestamp(System.currentTimeMillis()));
		event.setApproverId(request.getApproverId());
		event.setApproverName(request.getApproverName());
		event.setRequestData(JSON.toJSONString(request));
		event.setOpinion(request.getOpinion());
		event.setSimpleNodeId(simpleNodeId);

		ChangeDefinition definition=definitionService.getByCode(request.getChangeDefinitionCode());
		if(definition==null) {
			result.success(false).message("变更 "+request.getChangeDefinitionCode()+" 未定义");
			//
			event.setEventTypeEnum(ApprovalEventType.internal_error);
			event.setSuccess(0);
			event.setErrors(JSON.toJSONString(result));
			eventService.insert(event);
			//
			return result;
		}

		if(definition.getValid()==0) {
			result.success(false).message("变更 "+request.getChangeDefinitionCode()+" 未启用");
			//
			event.setEventTypeEnum(ApprovalEventType.internal_error);
			event.setSuccess(0);
			event.setErrors(JSON.toJSONString(result));
			eventService.insert(event);
			//
			return result;
		}

		if(definition.getModeEnum()== ApprovalMode.bpm) {
			result.success(false).message("暂不支持流程引擎模式");
			return result;
		}

		if(definition.getModeEnum() == ApprovalMode.simple && request.getDataAfter().size()>1) {
			result.success(false).message("简单模式不是单据的合并审批");
			return result;
		}

		//设置默认审批人
		if(request.getNextNodeAppovers()==null) {
			String defaultApproverIds=definition.getSimpleApproverIds();
			if(defaultApproverIds!=null) {
				//TODO 待处理
				//request.setNextNodeEmployeeApproverIds(Arrays.asList(defaultApproverIds.split(",")));
			}
		}



		//审批人判断
		if(request.getNextNodeAppovers()==null || request.getNextNodeAppovers().isEmpty()) {
			result.success(false).message("未指定审批人");
			//
			event.setEventTypeEnum(ApprovalEventType.internal_error);
			event.setSuccess(0);
			event.setErrors(JSON.toJSONString(result));
			eventService.insert(event);
			//
			return result;
		}

		//转换审批人
//		Result<List<Employee>> employeeResult=EmployeeServiceProxy.api().getByIds(request.getNextNodeEmployeeApproverIds());
//		if(employeeResult.failure()) {
//			return result.success(false).message(employeeResult.message());
//		}
//		Map<String,String> empNames= CollectorUtil.collectMap(employeeResult.data(),Employee::getId,(emp)->{
//			if(emp.getPerson()!=null) return emp.getPerson().getName();
//			return emp.getId();
//		});
//		List<String> nextNodeApproverNames=new ArrayList<>();
//		for (String id : request.getNextNodeEmployeeApproverIds()) {
//			String name=empNames.get(id);
//			if(name!=null) nextNodeApproverNames.add(name);
//			else nextNodeApproverNames.add(id);
//		}
//		event.setSimpleNextApproverIds(StringUtil.join(request.getNextNodeEmployeeApproverIds()));
//		event.setSimpleNextApproverNames(StringUtil.join(nextNodeApproverNames,","));


		//设置变更实例
		ChangeInstance instance=new ChangeInstance();
		instance.setDefinitionId(definition.getId());
		instance.setMode(definition.getMode());
		instance.setStatusEnum(ApprovalStatus.approving);
		instance.setTypeEnum(request.getType());
		instance.setStartTime(request.getStartTime());
		instance.setDrafterId(request.getApproverId());
		instance.setDrafterName(request.getApproverName());


		if(instance.getModeEnum()==ApprovalMode.simple) {
			instance.setSimpleNodeId(simpleNodeId);
//			instance.setSimpleApproveLogic(definition.getSimpleApprovalLogic());
			instance.setSimpleNextApproverIds(event.getSimpleNextApproverIds());
			instance.setSimpleNextApproverNames(event.getSimpleNextApproverNames());
		}
		//
		Result cr=this.insert(instance);
		if(cr.failure()) {
			return cr;
		}

		ChangeBill changeBill=new ChangeBill();
		for (String billId : request.getBillIds()) {
			changeBill.setInstanceId(instance.getId());
			changeBill.setBillId(billId);
			billService.insert(changeBill);
		}

		//保存变更前的数据
		if(request.getDataBefore()!=null && !request.getDataBefore().isEmpty()) {
			ChangeData changeData=new ChangeData();
			changeData.setDataType(request.getDataType());
			changeData.setData(JSON.toJSONString(request.getDataBefore()));
			changeData.setInstanceId(instance.getId());
			changeData.setTimePoint(0);
			dataService.insert(changeData);
			instance.setDataBefore(changeData);
		}
		//保存变更后的数据
		if(request.getDataAfter()!=null && !request.getDataAfter().isEmpty()) {

			ChangeData changeData=new ChangeData();
			changeData.setDataType(request.getDataType());
			changeData.setData(JSON.toJSONString(request.getDataAfter()));
			changeData.setInstanceId(instance.getId());
			changeData.setTimePoint(1);
			dataService.insert(changeData);
			instance.setDataAfter(changeData);
		}


		if(cr.success()) {
			event.setNotifyTime(new Timestamp(System.currentTimeMillis()));
			event.setInstanceId(instance.getId());
			event.setEventTypeEnum(ApprovalEventType.create_success);
			event.setApproveActionEnum(ApprovalAction.submit);
			event.setInstance(instance);
			event.setDefinition(definition);
			event.setApproverId(SessionUser.getCurrent().getUserId());
			event.setApproverName(SessionUser.getCurrent().getRealName());
			event.setNotifyData(JSON.toJSONString(event));
			Result er=eventService.insert(event);
			if(er.failure()) {
				throw new RuntimeException("保存变更事件失败");
			}
			//通过redis发送变更事件
			boolean suc=redis.set(ChangesAssistant.CHANGES_NOTIFY_PREFIX+event.getId(),event,ChangesAssistant.EXPIRE_SECONDS);
			if(suc) {
				redis.notifyDataChange(ChangesAssistant.CHANGES_CHANNEL_EVENT_PREFIX + event.getId());
			} else {
				throw new RuntimeException("data notify error");
			}
		} else {
			result.success(false).message("变更实例创建失败");
			return result;
		}
		//
		result.success(true).data(event);
		return result;
	}

//	private boolean checkApprover() {
//
//	}

	@Override
	public Result<ChangeEvent> approve(ChangeApproveBody request) {

		Result<ChangeEvent> result=new Result<>();

		ChangeInstance instance=this.getById(request.getChangeInstanceId());
		if(instance==null) {
			return result.success(false).message("流程实例不存在");
		}

		ChangeDefinition definition=definitionService.getByCode(request.getChangeDefinitionCode());

		ChangeEvent event=new ChangeEvent();
		event.setNotifyTime(new Timestamp(System.currentTimeMillis()));
		event.setApproverId(request.getApproverId());
		event.setApproverName(request.getApproverName());
		event.setRequestData(JSON.toJSONString(request));
		event.setNotifyTime(new Timestamp(System.currentTimeMillis()));
		event.setInstanceId(instance.getId());
		event.setEventTypeEnum(ApprovalEventType.revoke_success);
		event.setInstance(instance);
		event.setApproveActionEnum(request.getApprovalAction());
		event.setDefinition(definition);
		event.setApproverId(SessionUser.getCurrent().getUserId());
		event.setApproverName(SessionUser.getCurrent().getRealName());
		event.setNotifyData(JSON.toJSONString(event));
		event.setOpinion(request.getOpinion());

		List<String> nextApproverIds = Arrays.asList(instance.getSimpleNextApproverIds().split(","));

		String simpleNodeId=IDGenerator.getSnowflakeIdString();

		//撤回
		if(request.getApprovalAction()== ApprovalAction.revoke) {
			//检查当前状态:可撤回审批中的流程，其它状态的不可撤回
			if(instance.getStatusEnum() != ApprovalStatus.approving) {
				return result.success(false).message("当前审批状态无法撤回流程");
			}
			//可操作人判定
			if(!instance.getDrafterId().equals(request.getApproverId())){
				return result.success(false).message("您不是当前审批的起草人，无权撤回流程");
			}
			//切换节点
			event.setSimpleNodeId(simpleNodeId);
			instance.setSimpleNodeId(simpleNodeId);
			//设置审批动作后的状态
			instance.setStatusEnum(ApprovalStatus.drafting);
			this.updateDirtyFields(instance);
		}
		//废弃
		if(request.getApprovalAction()== ApprovalAction.abandon) {
			//检查当前状态:已废弃、已通过的 不允许废弃
			if(instance.getStatusEnum() == ApprovalStatus.abandoned || instance.getStatusEnum() == ApprovalStatus.passed) {
				return result.success(false).message("当前审批状态无法废弃流程");
			}
			//可操作人判定
			if(!instance.getDrafterId().equals(request.getApproverId())){
				return result.success(false).message("您不是当前审批的起草人，无权废弃流程");
			}
			//切换节点
			event.setSimpleNodeId(simpleNodeId);
			instance.setSimpleNodeId(simpleNodeId);
			//设置审批动作后的状态
			instance.setStatusEnum(ApprovalStatus.abandoned);
			this.updateDirtyFields(instance);
		}

		//驳回
		if(request.getApprovalAction()== ApprovalAction.reject) {
			//检查当前状态:已废弃、已通过的 不允许废弃
			if(instance.getStatusEnum() != ApprovalStatus.approving) {
				return result.success(false).message("当前审批状态无法驳回");
			}
			//可操作人判定
			if(!nextApproverIds.contains(request.getApproverId())) {
				return result.success(false).message("您不是当前审批人，不允许驳回");
			}
			//切换节点
			event.setSimpleNodeId(simpleNodeId);
			instance.setSimpleNodeId(simpleNodeId);
			//设置审批动作后的状态
			instance.setStatusEnum(ApprovalStatus.rejected);
			this.updateDirtyFields(instance);
		}

		//驳回
		if(request.getApprovalAction()== ApprovalAction.submit) {
			//检查当前状态:已废弃、已通过的 不允许废弃
			if(instance.getStatusEnum() != ApprovalStatus.approving && instance.getStatusEnum() != ApprovalStatus.rejected) {
				return result.success(false).message("当前审批状态无法提交");
			}
			//可操作人判定
			if(!instance.getDrafterId().equals(request.getApproverId())){
				return result.success(false).message("您不是当前审批的起草人，无权再次提交流程");
			}
			//切换节点
			event.setSimpleNodeId(simpleNodeId);
			instance.setSimpleNodeId(simpleNodeId);
			//设置审批动作后的状态
			instance.setStatusEnum(ApprovalStatus.approving);
			this.updateDirtyFields(instance);
		}

		//同意
		if(request.getApprovalAction()== ApprovalAction.agree) {
			//检查当前状态:不是审批中的不允许同意
			if(instance.getStatusEnum() != ApprovalStatus.approving) {
				return result.success(false).message("当前审批状态无法同意");
			}
			//可操作人判定
			if(!nextApproverIds.contains(request.getApproverId())) {
				return result.success(false).message("您不是当前审批人，不允许同意");
			}

//			if(instance.getSimpleApproveLogicEnum()== ApprovalLogic.any) {
				//切换节点
				event.setSimpleNodeId(simpleNodeId);
				instance.setSimpleNodeId(simpleNodeId);
				//设置审批动作后的状态
				instance.setStatusEnum(ApprovalStatus.passed);
//			} else if(instance.getSimpleApproveLogicEnum()== ApprovalLogic.all) {
//				//检查是否全员通过
//				List<ChangeEvent> events=eventService.queryList(
//						ChangeEvent.create()
//							.setInstanceId(instance.getId())
//							.setSimpleNodeId(instance.getSimpleNodeId())
//							.setApproveActionEnum(ApprovalAction.agree)
//				);
//				List<String> agreedApproverIds = CollectorUtil.collectList(events,ChangeEvent::getApproverId);
//				nextApproverIds.removeAll(agreedApproverIds);
//				if(nextApproverIds.isEmpty()){
//					//切换节点
//					event.setSimpleNodeId(simpleNodeId);
//					instance.setSimpleNodeId(simpleNodeId);
//					//设置审批动作后的状态
//					instance.setStatusEnum(ApprovalStatus.passed);
//				}
//			}
			this.updateDirtyFields(instance);
		}

		//
		Result er=eventService.insert(event);
		if(er.failure()) return er;
		//
		return result.success(true).data(event);
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}