package org.github.foxnic.web.framework.bpm;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.constants.enums.bpm.ApprovalResult;
import org.github.foxnic.web.constants.enums.bpm.TaskStatus;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.bpm.*;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.proxy.bpm.TaskServiceProxy;
import org.github.foxnic.web.proxy.camunda.CamundaProcessServiceProxy;

import java.util.*;

public class ProcessDelegate {

    private ProcessInstance processInstance;
    private List<String> billIds;
    private String processDefinitionId;
    private User user;

    /**
     * 从已有的流程实例ID，创建 ProcessDelegate
     * */
    public static ProcessDelegate createFromExistsProcess(String processInstanceId, User user) {
        ProcessDelegate delegate=new ProcessDelegate();
        try {
            delegate.user=user;
            Result<ProcessInstance> result = BpmAssistant.getProcessInstanceById(processInstanceId,user);
            if(result.success()) {
                delegate.processInstance=result.data();
            } else {
                throw new RuntimeException(result.message());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return delegate;
    }

    public static ProcessDelegate createFromExistsProcess(ProcessInstance processInstance, User user) {
        ProcessDelegate delegate=new ProcessDelegate();
        delegate.user=user;
        delegate.processInstance=processInstance;
        return delegate;
    }

    /**
     * 创建一个 ProcessDelegate 用于发起新流程
     * */
    public ProcessDelegate createNewProcess(String processDefinitionId, String billId, User user) {
        ProcessDelegate delegate=new ProcessDelegate();
        delegate.user=user;
        delegate.processDefinitionId=processDefinitionId;
        delegate.billIds=Arrays.asList(billId);
        return delegate;
    }

    /**
     * 从表单与业务单据为已存在的流程实例 创建 ProcessDelegate
     * */
    public static ProcessDelegate createFromExistsBill(String formDefinitionCode, String billId, User user) {
        ProcessDelegate proxy=new ProcessDelegate();
        try {
            proxy.user=user;
            Result<List<ProcessInstance>> result = BpmAssistant.getProcessInstanceByBill(formDefinitionCode, Arrays.asList(billId));
            if(result.success()) {
                List<ProcessInstance> list=result.getData();
                if(list==null || list.isEmpty()) {
                    throw new IllegalArgumentException("表单 "+formDefinitionCode+" 的业务单据 "+billId+"未关联到有效的流程");
                } else if(list.size()==1) {
                    proxy.processInstance=list.get(0);
                } else {
                    throw new IllegalArgumentException("表单 "+formDefinitionCode+" 的业务单据 "+billId+"发现已关联到多个流程");
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
     * */
    public List<ProcessDefinitionNode> getTodoNodes() {
        List<ProcessDefinitionNode> list=new ArrayList<>();
        for (Task task : processInstance.getTasks()) {
            if(task.getStatusEnum()== TaskStatus.todo){
                list.add(task.getNode());
            }
        }
        return list;
    }

    /**
     * 是否为待审的节点
     * */
    public boolean isTodoNodes(String camundaNodeId) {
        for (Task task : processInstance.getTasks()) {
            if(task.getStatusEnum()== TaskStatus.todo && task.getNode().getCamundaNodeId().equals(camundaNodeId)){
                return true;
            }
        }
        return false;
    }

    /**
     * 是否为当前账户的待审节点
     * */
    public boolean isCurrentUserTodoNode(String camundaNodeId) {
        for (Task task : processInstance.getUserTasks()) {
            if(task.getStatusEnum()== TaskStatus.todo && task.getNode().getCamundaNodeId().equals(camundaNodeId)){
                return true;
            }
        }
        return false;
    }

    /**
     * 刷新流程实例数据
     * */
    public void refresh() {
        try {
            Result<ProcessInstance> result = BpmAssistant.getProcessInstanceById(processInstance.getId(),this.user);
            if(result.success()) {
                processInstance=result.data();
            } else {
                throw new RuntimeException(result.message());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 设置流程变量
     * */
    public Result setVariable(String variableName, Object variableValue) {
        Map<String,Object> variables = new HashMap<>();
        variables.put(variableName,variableValue);
        return setVariable(variables);
    }

    /**
     * 设置流程变量
     * */
    public Result setVariable(Map<String,Object> variables) {
        return CamundaProcessServiceProxy.api().setVariables(processInstance.getId(),variables);
    }

    /**
     * 流程暂存
     * */
    public Result temporarySave(ProcessInstanceVO processInstanceVO) {
        throw new RuntimeException("待实现");
    }

    /**
     * 流程启动
     * */
    public Result start(ProcessStartVO processStartVO) {
        throw new RuntimeException("待实现");
    }

    /**
     * 流程撤回
     * */
    public Result fetchBack(ProcessFetchBackVO fetchBackVO) {
        throw new RuntimeException("待实现");
    }

    /**
     * 流程废弃
     * */
    public Result abandonProcess(ProcessAbandonVO processAbandonVO) {
        throw new RuntimeException("待实现");
    }

    /**
     * 处理待办任务
     * */
    public Result processTask(TaskProcessVO taskProcessVO) {
        return TaskServiceProxy.api().processTask(taskProcessVO);
    }


    /**
     * 处理待办任务(当前审批人不涉及时跳过审批)
     * */
    public Result skipTask(String taskId,UnifiedUserType assigneeType,String assigneeId,String assigneeUserId,String comment,Map<String,Object> variables) {
        if(variables==null) variables=new HashMap<>();
        TaskProcessVO taskProcessVO=new TaskProcessVO();
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
     * */
    public Result skipTask(String taskId,UnifiedUserType assigneeType,String assigneeId,String comment,Map<String,Object> variables) {
        return skipTask(taskId,assigneeType,assigneeId,user.getId(),comment,variables);
    }


    }
