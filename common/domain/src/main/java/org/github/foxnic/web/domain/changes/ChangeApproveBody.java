package org.github.foxnic.web.domain.changes;

import org.github.foxnic.web.constants.enums.changes.ApprovalAction;

import java.util.Date;
import java.util.List;

public class ChangeApproveBody {

    private String changeDefinitionCode;
    private Date startTime=new Date();

    private List<String> nextNodeApproverIds;

    private String approverId;
    private String approverName;
    private ApprovalAction approvalAction;
    private String changeInstanceId;
    private String opinion;


    public ChangeApproveBody(String changeDefinitionCode) {
        this.changeDefinitionCode = changeDefinitionCode;
    }

    public String getChangeDefinitionCode() {
        return changeDefinitionCode;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }


    public List<String> getNextNodeApproverIds() {
        return nextNodeApproverIds;
    }

    public void setNextNodeApproverIds(List<String> nextNodeApproverIds) {
        this.nextNodeApproverIds = nextNodeApproverIds;
    }

    public String getApproverId() {
        return approverId;
    }

    public void setApproverId(String approverId) {
        this.approverId = approverId;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }
    public ApprovalAction getApprovalAction() {
        return approvalAction;
    }

    public void setApprovalAction(ApprovalAction approvalAction) {
        this.approvalAction = approvalAction;
    }

    public String getChangeInstanceId() {
        return changeInstanceId;
    }

    public void setChangeInstanceId(String changeInstanceId) {
        this.changeInstanceId = changeInstanceId;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
