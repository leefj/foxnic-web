package org.github.foxnic.web.domain.changes;

import com.github.foxnic.dao.entity.Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChangeRequest {

    private String changeDefinitionCode;
    private String targetId;
    private String targetType;
    private String targetTable;
    private Map<String,List<? extends Entity>> dataBefore=new HashMap<>();
    private Map<String,List<? extends Entity>> dataAfter=new HashMap<>();

    private Entity targetData;

    public String getChangeDefinitionCode() {
        return changeDefinitionCode;
    }

    public void setChangeDefinitionCode(String changeDefinitionCode) {
        this.changeDefinitionCode = changeDefinitionCode;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(Class<? extends Entity> targetType) {
        this.targetType = targetType.getName();
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
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

    public String getTargetTable() {
        return targetTable;
    }

    public void setTargetTable(String targetTable) {
        this.targetTable = targetTable;
    }

}
