package org.github.foxnic.web.domain.bpm;

import io.swagger.annotations.ApiModel;
import org.github.foxnic.web.constants.enums.bpm.ApprovalResult;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.Map;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;
import org.github.foxnic.web.domain.bpm.meta.TaskProcessVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 任务处理参数
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-05-16 15:57:41
 * @sign F8E4341433D6AFEAAC598139A999A1FE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel()
public class TaskProcessVO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 任务ID：任务ID
	*/
	private String taskId;
	
	/**
	 * 审批人账户ID：审批人账户
	*/
	private String assigneeUserId;
	
	/**
	 * 审批人身份类型：审批人身份类型
	*/
	private String assigneeType;
	
	/**
	 * 审批人身份ID：审批人身份ID
	*/
	private String assigneeId;
	
	/**
	 * 审批结果：审批结果
	*/
	private String result;
	@Transient
	@EnumFor("result")
	private ApprovalResult resultEnum;
	
	/**
	 * 审批意见：审批意见
	*/
	private String comment;
	
	/**
	 * 流程参数：流程参数
	*/
	private Map<String,Object> variables;
	
	/**
	 * 租户ID：租户ID
	*/
	private String tenantId;
	
	/**
	 * 流程跳转的目标节点ID：流程跳转的目标节点ID
	*/
	private String jumpToNodeId;
	
	/**
	 * 附件ID清单：附件ID清单
	*/
	private List<String> attachmentFileIds;
	
	/**
	 * 转办人清单：转办人清单
	*/
	private List<Assignee> transferTo;
	
	/**
	 * 获得 任务ID<br>
	 * 任务ID
	 * @return 任务ID
	*/
	public String getTaskId() {
		return taskId;
	}
	
	/**
	 * 设置 任务ID
	 * @param taskId 任务ID
	 * @return 当前对象
	*/
	public TaskProcessVO setTaskId(String taskId) {
		this.taskId=taskId;
		return this;
	}
	
	/**
	 * 获得 审批人账户ID<br>
	 * 审批人账户
	 * @return 审批人账户ID
	*/
	public String getAssigneeUserId() {
		return assigneeUserId;
	}
	
	/**
	 * 设置 审批人账户ID
	 * @param assigneeUserId 审批人账户ID
	 * @return 当前对象
	*/
	public TaskProcessVO setAssigneeUserId(String assigneeUserId) {
		this.assigneeUserId=assigneeUserId;
		return this;
	}
	
	/**
	 * 获得 审批人身份类型<br>
	 * 审批人身份类型
	 * @return 审批人身份类型
	*/
	public String getAssigneeType() {
		return assigneeType;
	}
	
	/**
	 * 设置 审批人身份类型
	 * @param assigneeType 审批人身份类型
	 * @return 当前对象
	*/
	public TaskProcessVO setAssigneeType(String assigneeType) {
		this.assigneeType=assigneeType;
		return this;
	}
	
	/**
	 * 获得 审批人身份ID<br>
	 * 审批人身份ID
	 * @return 审批人身份ID
	*/
	public String getAssigneeId() {
		return assigneeId;
	}
	
	/**
	 * 设置 审批人身份ID
	 * @param assigneeId 审批人身份ID
	 * @return 当前对象
	*/
	public TaskProcessVO setAssigneeId(String assigneeId) {
		this.assigneeId=assigneeId;
		return this;
	}
	
	/**
	 * 获得 审批结果<br>
	 * 审批结果
	 * @return 审批结果
	*/
	public String getResult() {
		return result;
	}
	
	/**
	 * 获得 审批结果 的投影属性<br>
	 * 等价于 getResult 方法，获得对应的枚举类型
	 * @return 审批结果
	*/
	@Transient
	public ApprovalResult getResultEnum() {
		if(this.resultEnum==null) {
			this.resultEnum = (ApprovalResult) EnumUtil.parseByCode(ApprovalResult.values(),result);
		}
		return this.resultEnum ;
	}
	
	/**
	 * 设置 审批结果
	 * @param result 审批结果
	 * @return 当前对象
	*/
	@JsonProperty("result")
	public TaskProcessVO setResult(String result) {
		this.result=result;
		this.resultEnum= (ApprovalResult) EnumUtil.parseByCode(ApprovalResult.values(),result) ;
		if(StringUtil.hasContent(result) && this.resultEnum==null) {
			throw new IllegalArgumentException( result + " is not one of ApprovalResult");
		}
		return this;
	}
	
	/**
	 * 设置 审批结果的投影属性，等同于设置 审批结果
	 * @param resultEnum 审批结果
	 * @return 当前对象
	*/
	@Transient
	public TaskProcessVO setResultEnum(ApprovalResult resultEnum) {
		if(resultEnum==null) {
			this.setResult(null);
		} else {
			this.setResult(resultEnum.code());
		}
		this.resultEnum=resultEnum;
		return this;
	}
	
	/**
	 * 获得 审批意见<br>
	 * 审批意见
	 * @return 审批意见
	*/
	public String getComment() {
		return comment;
	}
	
	/**
	 * 设置 审批意见
	 * @param comment 审批意见
	 * @return 当前对象
	*/
	public TaskProcessVO setComment(String comment) {
		this.comment=comment;
		return this;
	}
	
	/**
	 * 获得 流程参数<br>
	 * 流程参数
	 * @return 流程参数
	*/
	public Map<String,Object> getVariables() {
		return variables;
	}
	
	/**
	 * 设置 流程参数
	 * @param variables 流程参数
	 * @return 当前对象
	*/
	public TaskProcessVO setVariables(Map<String,Object> variables) {
		this.variables=variables;
		return this;
	}
	
	/**
	 * 添加 流程参数
	 * @param key 键
	 * @param variable 流程参数
	 * @return 当前对象
	*/
	public TaskProcessVO putVariable(String key,Object variable) {
		if(this.variables==null) this.variables=new HashMap<>();
		this.variables.put(key ,variable);
		return this;
	}
	
	/**
	 * 获得 租户ID<br>
	 * 租户ID
	 * @return 租户ID
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户ID
	 * @param tenantId 租户ID
	 * @return 当前对象
	*/
	public TaskProcessVO setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 流程跳转的目标节点ID<br>
	 * 流程跳转的目标节点ID
	 * @return 流程跳转的目标节点ID
	*/
	public String getJumpToNodeId() {
		return jumpToNodeId;
	}
	
	/**
	 * 设置 流程跳转的目标节点ID
	 * @param jumpToNodeId 流程跳转的目标节点ID
	 * @return 当前对象
	*/
	public TaskProcessVO setJumpToNodeId(String jumpToNodeId) {
		this.jumpToNodeId=jumpToNodeId;
		return this;
	}
	
	/**
	 * 获得 附件ID清单<br>
	 * 附件ID清单
	 * @return 附件ID清单
	*/
	public List<String> getAttachmentFileIds() {
		return attachmentFileIds;
	}
	
	/**
	 * 设置 附件ID清单
	 * @param attachmentFileIds 附件ID清单
	 * @return 当前对象
	*/
	public TaskProcessVO setAttachmentFileIds(List<String> attachmentFileIds) {
		this.attachmentFileIds=attachmentFileIds;
		return this;
	}
	
	/**
	 * 添加 附件ID清单
	 * @param attachmentFileId 附件ID清单
	 * @return 当前对象
	*/
	public TaskProcessVO addAttachmentFileId(String... attachmentFileId) {
		if(this.attachmentFileIds==null) attachmentFileIds=new ArrayList<>();
		this.attachmentFileIds.addAll(Arrays.asList(attachmentFileId));
		return this;
	}
	
	/**
	 * 获得 转办人清单<br>
	 * 转办人清单
	 * @return 转办人清单
	*/
	public List<Assignee> getTransferTo() {
		return transferTo;
	}
	
	/**
	 * 设置 转办人清单
	 * @param transferTo 转办人清单
	 * @return 当前对象
	*/
	public TaskProcessVO setTransferTo(List<Assignee> transferTo) {
		this.transferTo=transferTo;
		return this;
	}
	
	/**
	 * 添加 转办人清单
	 * @param entity 转办人清单
	 * @return 当前对象
	*/
	public TaskProcessVO addTransferTo(Assignee... entity) {
		if(this.transferTo==null) transferTo=new ArrayList<>();
		this.transferTo.addAll(Arrays.asList(entity));
		return this;
	}

	/**
	 * 创建一个 TaskProcessVO，等同于 new
	 * @return TaskProcessVO 对象
	*/
	@Transient
	public static TaskProcessVO create() {
		return new TaskProcessVO();
	}

	/**
	 * 将 Map 转换成 TaskProcessVO
	 * @param taskMap 包含实体信息的 Map 对象
	 * @return TaskProcessVO , 转换好的的 Task 对象
	*/
	@Transient
	public static TaskProcessVO createFrom(Map<String,Object> taskMap) {
		if(taskMap==null) return null;
		TaskProcessVO po = new TaskProcessVO();
		BeanUtil.copy(taskMap,po);
		return po;
	}

	/**
	 * 将 Pojo 转换成 TaskProcessVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return TaskProcessVO , 转换好的的 Task 对象
	*/
	@Transient
	public static TaskProcessVO createFrom(Object pojo) {
		if(pojo==null) return null;
		TaskProcessVO po = new TaskProcessVO();
		BeanUtil.copy(pojo,po,true);
		return po;
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public TaskProcessVO duplicate(boolean all) {
		TaskProcessVO inst = new TaskProcessVO();
		// others
			inst.setResult(this.getResult());
			inst.setVariables(this.getVariables());
			inst.setJumpToNodeId(this.getJumpToNodeId());
			inst.setAttachmentFileIds(this.getAttachmentFileIds());
			inst.setAssigneeUserId(this.getAssigneeUserId());
			inst.setTenantId(this.getTenantId());
			inst.setComment(this.getComment());
			inst.setAssigneeType(this.getAssigneeType());
			inst.setTransferTo(this.getTransferTo());
			inst.setAssigneeId(this.getAssigneeId());
			inst.setTaskId(this.getTaskId());
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public TaskProcessVO clone() {
		return BeanUtil.clone(this,false);
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public TaskProcessVO clone(boolean deep) {
		return BeanUtil.clone(this,deep);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return TaskProcessVO , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)EntityContext.create((Class<? extends Entity>) pojoType,this);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			// others
			this.setResult(DataParser.parse(String.class, map.get(TaskProcessVOMeta.RESULT)));
			this.setJumpToNodeId(DataParser.parse(String.class, map.get(TaskProcessVOMeta.JUMP_TO_NODE_ID)));
			this.setAssigneeUserId(DataParser.parse(String.class, map.get(TaskProcessVOMeta.ASSIGNEE_USER_ID)));
			this.setTenantId(DataParser.parse(String.class, map.get(TaskProcessVOMeta.TENANT_ID)));
			this.setComment(DataParser.parse(String.class, map.get(TaskProcessVOMeta.COMMENT)));
			this.setAssigneeType(DataParser.parse(String.class, map.get(TaskProcessVOMeta.ASSIGNEE_TYPE)));
			this.setAssigneeId(DataParser.parse(String.class, map.get(TaskProcessVOMeta.ASSIGNEE_ID)));
			this.setTaskId(DataParser.parse(String.class, map.get(TaskProcessVOMeta.TASK_ID)));
			return true;
		} else {
			try {
				// others
				this.setResult( (String)map.get(TaskProcessVOMeta.RESULT));
				this.setJumpToNodeId( (String)map.get(TaskProcessVOMeta.JUMP_TO_NODE_ID));
				this.setAssigneeUserId( (String)map.get(TaskProcessVOMeta.ASSIGNEE_USER_ID));
				this.setTenantId( (String)map.get(TaskProcessVOMeta.TENANT_ID));
				this.setComment( (String)map.get(TaskProcessVOMeta.COMMENT));
				this.setAssigneeType( (String)map.get(TaskProcessVOMeta.ASSIGNEE_TYPE));
				this.setAssigneeId( (String)map.get(TaskProcessVOMeta.ASSIGNEE_ID));
				this.setTaskId( (String)map.get(TaskProcessVOMeta.TASK_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			return true;
		} else {
			try {
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}