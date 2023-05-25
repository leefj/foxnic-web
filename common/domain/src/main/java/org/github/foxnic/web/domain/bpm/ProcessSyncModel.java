package org.github.foxnic.web.domain.bpm;

import java.io.Serializable;
import java.util.List;

public class ProcessSyncModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public String getProcessInstanceId() {
        if(callback==null) return null;
        return callback.getBpmProcessInstanceId();
    }

    private ProcessInstance processInstance;

    private EventCallback callback;
    private List<Task> tasks;

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public ProcessInstance getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstance processInstance) {
        this.processInstance = processInstance;
    }

    public void setCallback(EventCallback callback) {
        this.callback = callback;
    }

    public EventCallback getCallback() {
        return callback;
    }

    private List<String> taskDefinitionKeys;

    public List<String> getTaskDefinitionKeys() {
        return taskDefinitionKeys;
    }

    public void setTaskDefinitionKeys(List<String> taskDefinitionKeys) {
        this.taskDefinitionKeys = taskDefinitionKeys;
    }
}
