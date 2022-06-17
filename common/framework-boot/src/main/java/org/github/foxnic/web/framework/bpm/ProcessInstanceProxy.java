package org.github.foxnic.web.framework.bpm;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import org.github.foxnic.web.proxy.camunda.CamundaProcessServiceProxy;

import java.util.HashMap;
import java.util.Map;

public class ProcessInstanceProxy {

    private ProcessInstance processInstance;

    public ProcessInstanceProxy(String processInstanceId) {
        try {
            Result<ProcessInstance> result = BpmAssistant.getProcessInstanceById(processInstanceId);
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
     * 刷新流程实例数据
     * */
    public void refresh() {
        try {
            Result<ProcessInstance> result = BpmAssistant.getProcessInstanceById(processInstance.getId());
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
