package org.github.foxnic.web.framework.bpm;

import com.github.foxnic.api.transter.Result;

import java.util.Arrays;

public class BpmAssistant {

    private static BPMSyncWorker syncWorker=new BPMSyncWorker();

    private String processInstanceId;

    public BpmAssistant(String processInstanceId) {
        this.processInstanceId=processInstanceId;
    }

    public Result sync(int delay) {
        // 调用同步
        return syncWorker.doSync(Arrays.asList(processInstanceId),delay);
    }



}
