package org.github.foxnic.web.domain.changes;

import com.github.foxnic.dao.entity.Entity;
import org.github.foxnic.web.constants.enums.changes.ChangeType;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChangeRequestBody {

    private String changeDefinitionCode;
    private ChangeType type;
    private Date startTime=new Date();

    private Map<String,List<? extends Entity>> dataBefore=new HashMap<>();
    private Map<String,List<? extends Entity>> dataAfter=new HashMap<>();


    public ChangeRequestBody(String changeDefinitionCode, ChangeType type) {
        this.changeDefinitionCode = changeDefinitionCode;
        this.type = type;
    }

    public String getChangeDefinitionCode() {
        return changeDefinitionCode;
    }

    public void setDataBefore(Class<? extends Entity> dataType, List<? extends Entity> list) {
        dataBefore.put(dataType.getName(),list);
    }

    public void setDataAfter(Class<? extends Entity> dataType, List<? extends Entity> list) {
        dataAfter.put(dataType.getName(),list);
    }

    public Map<String, List<? extends Entity>> getDataBefore() {
        return dataBefore;
    }

    public Map<String, List<? extends Entity>> getDataAfter() {
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

}
