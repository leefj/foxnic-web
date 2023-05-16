package org.github.foxnic.web.domain.bpm;

import java.util.List;

public class SyncInfo {


    public SyncInfo(List<String> processInstanceCamundaIds) {
        this.processInstanceCamundaIds = processInstanceCamundaIds;
    }

    public List<String> getProcessInstanceCamundaIds() {
        return processInstanceCamundaIds;
    }

    public int getSynchronizedProcessInstanceCount() {
        return synchronizedProcessInstanceCount;
    }

    public void setSynchronizedProcessInstanceCount(int synchronizedProcessInstanceCount) {
        this.synchronizedProcessInstanceCount = synchronizedProcessInstanceCount;
    }

    public int getSynchronizedTaskCount() {
        return synchronizedTaskCount;
    }

    public void setSynchronizedTaskCount(int synchronizedTaskCount) {
        this.synchronizedTaskCount = synchronizedTaskCount;
    }

    private List<String> processInstanceCamundaIds;
    private int synchronizedProcessInstanceCount=0;
    private int synchronizedTaskCount=0;
}
