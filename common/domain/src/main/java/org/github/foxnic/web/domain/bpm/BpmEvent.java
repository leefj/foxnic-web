package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import org.github.foxnic.web.constants.enums.bpm.BpmEventType;
import org.github.foxnic.web.constants.enums.bpm.CamundaNodeType;

import java.util.Map;

public class BpmEvent<PO> {


    /**
     * 流程事件类型
     * */
    private BpmEventType eventType;

    /**
     * 用于接收回调事件的控制器名称
     * */
    private String controllerClassName;


    private ProcessInstance processInstance;



    /**
     * 当前节点ID
     * */
    private String nodeId;

    /**
     * 当前节点
     * */
    private ProcessDefinitionNode currentNode;

    /**
     * 流程节点类型
     * */
    private CamundaNodeType nodeType;

    /**
     * 流程变量
     * */
    private Map<String,Object> variables;

    /**
     * 当前审批人帐号
     * */
    private String approverUserId;

    /**
     * 当前审批人员工ID
     * */
    private String approverEmployeeId;

    private TaskApproval taskApproval;

    /**
     * 节点审批是否完成，在此节点上没有待办任务
     * */
    private Boolean isNodeEnd;

    private PO parameter=null;

    /***
     * 请求接口提交的参数
     * */
    public PO getParameter() {
        return parameter;
    }

    public void setParameter(PO parameter) {
        this.parameter = parameter;
    }

    public BpmEventType getEventType() {
        return eventType;
    }

    public void setEventType(BpmEventType eventType) {
        this.eventType = eventType;
    }

    public String getNodeId() {
        return nodeId;
    }

    public String getCamundaNodeId() {
        if(this.getCurrentNode()==null) return null;
        return this.getCurrentNode().getCamundaNodeId();
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }

    public String getApproverUserId() {
        return approverUserId;
    }

    public void setApproverUserId(String approverUserId) {
        this.approverUserId = approverUserId;
    }

    public String getApproverEmployeeId() {
        return approverEmployeeId;
    }

    public void setApproverEmployeeId(String approverEmployeeId) {
        this.approverEmployeeId = approverEmployeeId;
    }

    public String getControllerClassName() {
        return controllerClassName;
    }

    public void setControllerClassName(String controllerClassName) {
        this.controllerClassName = controllerClassName;
    }


    public ProcessInstance getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstance processInstance) {
        this.processInstance = processInstance;
    }

    public CamundaNodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(CamundaNodeType nodeType) {
        this.nodeType = nodeType;
    }

    public ProcessDefinitionNode getCurrentNode() {
        return currentNode;
    }


    /**
     * 节点审批是否完成，在此节点上没有待办任务
     * */
    public Boolean isNodeEnd() {
        return isNodeEnd;
    }

    public void setNodeEnd(Boolean nodeEnd) {
        isNodeEnd = nodeEnd;
    }

    public void setCurrentNode(ProcessDefinitionNode currentNode) {
        this.currentNode = currentNode;
    }

    public BpmActionResult getActionResult() {
        BpmActionResult result=new BpmActionResult();
        ErrorDesc.fill(result, CommonError.SUCCESS);
        result.setVariables(this.getVariables());
        return result;
    }


    /**
     * 获得默认单据ID，复杂单据可使用  this.getProcessInstance().getBillIds() 方法获取
     * */
    public String getBillId() {
        if(this.getProcessInstance()==null) return null;
        if(this.getProcessInstance().getBillIds()==null) return null;
        if(this.getProcessInstance().getBillIds().isEmpty()) return null;
        return this.getProcessInstance().getBillIds().get(0);
    }

    public void setTaskApproval(TaskApproval taskApproval) {
        this.taskApproval=taskApproval;
    }

    public TaskApproval getTaskApproval() {
        return taskApproval;
    }
}
