package org.github.foxnic.web.framework.bpm;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.constants.enums.bpm.ApprovalResult;
import org.github.foxnic.web.constants.enums.bpm.PriorityLevel;
import org.github.foxnic.web.constants.enums.bpm.TaskStatus;
import org.github.foxnic.web.constants.enums.changes.ApprovalStatus;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.bpm.*;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.proxy.bpm.BpmIdentityServiceProxy;
import org.github.foxnic.web.proxy.bpm.TaskServiceProxy;
import org.github.foxnic.web.proxy.camunda.CamundaProcessServiceProxy;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;

import java.util.*;

public class ProcessDelegate {

    private ProcessInstance processInstance;
    private List<String> billIds;
    private String processDefinitionId;
    private User user;

    /**
     * 从已有的流程实例ID，创建 ProcessDelegate
     */
    public static ProcessDelegate createFromExistsProcess(String processInstanceId, String account) {
        ProcessDelegate delegate = new ProcessDelegate();
        try {
            delegate.user = getUser(account);
            Result<ProcessInstance> result = BpmAssistant.getProcessInstanceById(processInstanceId, delegate.user);
            if (result.success()) {
                delegate.processInstance = result.data();
            } else {
                throw new RuntimeException(result.message());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return delegate;
    }

    public static ProcessDelegate createFromExistsProcess(ProcessInstance processInstance, String account) {
        ProcessDelegate delegate = new ProcessDelegate();
        delegate.user = getUser(account);
        delegate.processInstance = processInstance;
        return delegate;
    }

    private static User getUser(String account) {
        Result<User> userResult = UserServiceProxy.api().getByAccount(account);
        if (userResult.failure() || userResult.data() == null) {
            throw new RuntimeException("账户不存在");
        }
        User user = userResult.data();
        return user;
    }

    /**
     * 创建一个 ProcessDelegate 用于发起新流程
     */
    public static ProcessDelegate createFromProcessDefinition(String processDefinitionCode, String account) {
        ProcessDelegate delegate = new ProcessDelegate();

        ProcessDefinition processDefinition = BpmAssistant.getProcessDefinitionByCode(processDefinitionCode);
        if(processDefinition==null) {
            throw new RuntimeException("缺少流程定义");
        }
        delegate.user = getUser(account);
        delegate.processDefinitionId = processDefinition.getId();
        return delegate;
    }

    /**
     * 从表单与业务单据为已存在的流程实例 创建 ProcessDelegate
     */
    public static ProcessDelegate createFromExistsBill(String formDefinitionCode, String billId, String account) {
        ProcessDelegate proxy = new ProcessDelegate();
        try {
            proxy.user = getUser(account);
            Result<List<ProcessInstance>> result = BpmAssistant.getProcessInstanceByBill(formDefinitionCode, Arrays.asList(billId));
            if (result.success()) {
                List<ProcessInstance> list = result.getData();
                if (list == null || list.isEmpty()) {
                    throw new IllegalArgumentException("表单 " + formDefinitionCode + " 的业务单据 " + billId + "未关联到有效的流程");
                } else if (list.size() == 1) {
                    proxy.processInstance = list.get(0);
                } else {
                    throw new IllegalArgumentException("表单 " + formDefinitionCode + " 的业务单据 " + billId + "发现已关联到多个流程");
                }

            } else {
                throw new RuntimeException(result.message());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return proxy;
    }


    /**
     * 获得待审批的节点清单
     */
    public List<ProcessDefinitionNode> getTodoNodes() {
        List<ProcessDefinitionNode> list = new ArrayList<>();
        for (Task task : processInstance.getTasks()) {
            if (task.getStatusEnum() == TaskStatus.todo) {
                list.add(task.getNode());
            }
        }
        return list;
    }

    /**
     * 是否为待审的节点
     */
    public boolean isTodoNodes(String camundaNodeId) {
        for (Task task : processInstance.getTasks()) {
            if (task.getStatusEnum() == TaskStatus.todo && task.getNode().getCamundaNodeId().equals(camundaNodeId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否为当前账户的待审节点
     */
    public boolean isCurrentUserTodoNode(String camundaNodeId) {
        for (Task task : processInstance.getUserTasks()) {
            if (task.getStatusEnum() == TaskStatus.todo && task.getNode().getCamundaNodeId().equals(camundaNodeId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 刷新流程实例数据
     */
    public void refresh() {
        if(this.processInstance==null) return;
        try {
            Result<ProcessInstance> result = BpmAssistant.getProcessInstanceById(processInstance.getId(), this.user);
            if (result.success()) {
                processInstance = result.data();
            } else {
                throw new RuntimeException(result.message());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 设置流程变量
     */
    public Result setVariable(String variableName, Object variableValue) {
        Map<String, Object> variables = new HashMap<>();
        variables.put(variableName, variableValue);
        return setVariable(variables);
    }

    /**
     * 设置流程变量
     */
    public Result setVariable(Map<String, Object> variables) {
        return CamundaProcessServiceProxy.api().setVariables(processInstance.getId(), variables);
    }


    /**
     * 获得审批人身份信息
     * */
    public List<Assignee> getIdentities(UnifiedUserType unifiedUserType) {
        return getIdentities(this.user.getId(),unifiedUserType);
    }

    /**
     * 获得审批人身份信息
     * */
    public List<Assignee> getIdentities(String userId,UnifiedUserType unifiedUserType) {
        Result<List<Assignee>> result= BpmIdentityServiceProxy.api().getIdentities(userId,unifiedUserType.code());
        if(result.failure()) {
            throw new RuntimeException(result.message());
        }
        return result.data();
    }

    public Result<ProcessInstance> temporarySave(String title,String billId) {
        return temporarySave(title,UnifiedUserType.employee,PriorityLevel.normal,billId);
    }

    public Result<ProcessInstance> temporarySave(String title, UnifiedUserType drafterType,String billId) {
        return temporarySave(title,drafterType,PriorityLevel.normal,billId);
    }

    public Result<ProcessInstance> temporarySave(String title, UnifiedUserType drafterType, PriorityLevel priority,String billId) {
        // 指定起草人并获得其身份，身份类型按实际需求传入，UnifiedUserType 枚举中定义的其中一种
        List<Assignee> assignees = this.getIdentities(drafterType);
        if (assignees.isEmpty()) {
            throw new RuntimeException(this.user.getAccount() + " 身份信息缺失");
        }
        this.billIds = Arrays.asList(billId);
        Assignee assignee = assignees.get(0);
        ProcessInstanceVO processInstanceVO = new ProcessInstanceVO();
        processInstanceVO.setTitle(title);
        processInstanceVO.setDrafterTypeEnum(assignee.getType());
        processInstanceVO.setDrafterId(assignee.getId());
        processInstanceVO.setPriority(priority.code());
        processInstanceVO.setBillIds(this.billIds);
        Result<ProcessInstance> result=temporarySave(processInstanceVO);
        if(result.success()) {
               this.processInstance=result.data();
        }
        return result;
    }

    /**
     * 流程暂存
     */
    public Result<ProcessInstance> temporarySave(ProcessInstanceVO processInstanceVO) {

        if(StringUtil.isBlank(processInstanceVO.getProcessDefinitionId())) {
            processInstanceVO.setProcessDefinitionId(this.processDefinitionId);
        }
        if(processInstanceVO.getBillIds()==null || processInstanceVO.getBillIds().isEmpty()) {
            processInstanceVO.setBillIds(this.billIds);
        }

        if(StringUtil.isBlank(processInstanceVO.getTenantId())) {
            processInstanceVO.setTenantId(this.user.getActivatedTenant().getOwnerTenantId());
        }

        if(StringUtil.isBlank(processInstanceVO.getDrafterUserId())) {
            processInstanceVO.setDrafterUserId(this.user.getId());
        }

        if(this.processInstance!=null) {
            this.refresh();
            if(this.processInstance.getApprovalStatusEnum() != ApprovalStatus.drafting) {
                throw new RuntimeException("流程实例已存在，且当前状态不允许暂存");
            }
        }
        Result<ProcessInstance> result=BpmAssistant.temporarySave(processInstanceVO,this.user);
        if(result.success()) {
            this.processInstance=result.data();
        }
        return result;
    }

    /**
     * 流程启动
     */
    public Result<ProcessInstance> start() {
        if(this.processInstance==null) {
            throw new RuntimeException("流程实例不存在，请先暂存流程实例");
        }
        refresh();
        if(this.processInstance.getApprovalStatusEnum()!=ApprovalStatus.drafting) {
            throw new RuntimeException("当前流程实例已经启动，不允许再次启动流程");
        }
        ProcessStartVO processStartVO = new ProcessStartVO();
        processStartVO.setProcessInstanceId(this.processInstance.getId());
        return BpmAssistant.startProcessInstance(processStartVO,user);
    }

    /**
     * 流程撤回
     */
    public Result fetchBack(ProcessFetchBackVO fetchBackVO) {
        throw new RuntimeException("待实现");
    }

    /**
     * 流程废弃
     */
    public Result abandonProcess(ProcessAbandonVO processAbandonVO) {
        throw new RuntimeException("待实现");
    }

    /**
     * 处理待办任务
     * @param taskProcessVO  流程审批参数
     */
    public Result processTask(TaskProcessVO taskProcessVO) {
        return TaskServiceProxy.api().processTask(taskProcessVO);
    }


    /**
     * 处理待办任务(当前审批人不涉及时跳过审批)
     */
    public Result skipTask(String taskId, UnifiedUserType assigneeType, String assigneeId, String assigneeUserId, String comment, Map<String, Object> variables) {
        if (variables == null) variables = new HashMap<>();
        TaskProcessVO taskProcessVO = new TaskProcessVO();
        taskProcessVO.setTaskId(taskId);
        taskProcessVO.setResultEnum(ApprovalResult.skip);
        taskProcessVO.setVariables(variables);
        taskProcessVO.setAssigneeUserId(assigneeUserId);
        taskProcessVO.setAssigneeType(assigneeType.code());
        taskProcessVO.setAssigneeId(assigneeId);
        taskProcessVO.setTenantId(processInstance.getTenantId());
        taskProcessVO.setComment(comment);
        return processTask(taskProcessVO);
    }

    /**
     * 处理待办任务(当前审批人不涉及时跳过审批)
     */
    public Result skipTask(String taskId, UnifiedUserType assigneeType, String assigneeId, String comment, Map<String, Object> variables) {
        return skipTask(taskId, assigneeType, assigneeId, user.getId(), comment, variables);
    }


}
