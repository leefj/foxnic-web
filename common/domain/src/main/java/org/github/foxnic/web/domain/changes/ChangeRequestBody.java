package org.github.foxnic.web.domain.changes;

import com.github.foxnic.dao.entity.Entity;
import org.github.foxnic.web.constants.enums.changes.ChangeType;
import org.github.foxnic.web.domain.bpm.Assignee;

import java.util.*;

public class ChangeRequestBody {

    private String changeDefinitionCode;
    private ChangeType type;
    private Date startTime=new Date();
    private String dataType;

    private List<? extends Entity> dataBefore=new ArrayList<>();
    private List<? extends Entity> dataAfter=new ArrayList<>();

    private List<Assignee> nextNodeAssignees;


    private String approverId;
    private String approverName;

    private List<String> billIds;

    private String opinion;

    public ChangeRequestBody(String changeDefinitionCode, ChangeType type) {
        this.changeDefinitionCode = changeDefinitionCode;
        this.type = type;
    }

    public String getChangeDefinitionCode() {
        return changeDefinitionCode;
    }

    public void setDataBefore(List<? extends Entity> list) {
        dataBefore=list;
    }

    public void setDataAfter(List<? extends Entity> list) {
        dataAfter=list;
    }

    public void setDataBefore(Entity entity) {
        dataBefore=Arrays.asList(entity);
    }

    public void setDataAfter(Entity entity) {
        dataAfter=Arrays.asList(entity);
    }

    public List<? extends Entity> getDataBefore() {
        return dataBefore;
    }

    public List<? extends Entity> getDataAfter() {
        return dataAfter;
    }

    public ChangeType getType() {
        return type;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public List<Assignee> getNextNodeAppovers() {
        return nextNodeAssignees;
    }

    public void setNextNodeAppovers(List<Assignee> nextNodeAssignees) {
        this.nextNodeAssignees = nextNodeAssignees;
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

    public List<String> getBillIds() {
        return billIds;
    }

    public void setBillIds(List<String> billIds) {
        this.billIds = billIds;
    }

    public void setDataType(Class<? extends Entity> dataType) {
        this.dataType = dataType.getName();
    }

    public String getDataType() {
        return dataType;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
