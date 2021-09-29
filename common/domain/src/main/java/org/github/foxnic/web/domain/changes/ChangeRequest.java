package org.github.foxnic.web.domain.changes;

import com.github.foxnic.dao.entity.Entity;
import org.github.foxnic.web.constants.enums.changes.ChangeType;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChangeRequest {

    private String changeDefinitionCode;
    private String dataIdBefore;

    private String dataIdAfter;
    private String dataType;
    private String dataTable;
    private ChangeType type;
    private Date startTime=new Date();

    private Map<String,List<? extends Entity>> dataBefore=new HashMap<>();
    private Map<String,List<? extends Entity>> dataAfter=new HashMap<>();

    private Entity targetData;

    public ChangeRequest(String changeDefinitionCode,ChangeType type) {
        this.changeDefinitionCode = changeDefinitionCode;
        this.type = type;
    }


    public String getChangeDefinitionCode() {
        return changeDefinitionCode;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(Class<? extends Entity> dataType) {
        this.dataType = dataType.getName();
    }

    public String getDataIdBefore() {
        return dataIdBefore;
    }

    public void setDataId(String dataIdBefore,String dataIdAfter) {
        this.dataIdBefore = dataIdBefore;
        this.dataIdAfter = dataIdAfter;
    }

    private void setDataBefore(Class<? extends Entity> dataType, List<? extends Entity> list) {
        dataBefore.put(dataType.getName(),list);
    }

    private void setDataAfter(Class<? extends Entity> dataType, List<? extends Entity> list) {
        dataAfter.put(dataType.getName(),list);
    }

    public void setTargetData(Entity targetData) {
        this.targetData = targetData;
    }

    public Entity getTargetData() {
        return targetData;
    }

    public Map<String, List<? extends Entity>> getDataBefore() {
        return dataBefore;
    }

    public Map<String, List<? extends Entity>> getDataAfter() {
        return dataAfter;
    }

    public String getDataTable() {
        return dataTable;
    }

    public void setDataTable(String dataTable) {
        this.dataTable = dataTable;
    }

    public String getDataIdAfter() {
        return dataIdAfter;
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

}
