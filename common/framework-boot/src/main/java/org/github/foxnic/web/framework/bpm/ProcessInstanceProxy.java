package org.github.foxnic.web.framework.bpm;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.constants.enums.bpm.TaskStatus;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionNode;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import org.github.foxnic.web.domain.bpm.Task;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.proxy.camunda.CamundaProcessServiceProxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessInstanceProxy {

    private ProcessInstance processInstance;
    private User user;

    public ProcessInstanceProxy(String processInstanceId, User user) {
        try {
            this.user=user;
            Result<ProcessInstance> result = BpmAssistant.getProcessInstanceById(processInstanceId,user);
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

}
