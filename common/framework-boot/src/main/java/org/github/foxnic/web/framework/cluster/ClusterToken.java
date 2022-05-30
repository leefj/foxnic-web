package org.github.foxnic.web.framework.cluster;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ClusterToken {

    private String account;
    private String serviceName;
    private String tid;
    private String tenantId;
    private long time=System.currentTimeMillis();

    private String sessionId;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String toToken() {
        String json= JSON.toJSONString(this);
        return json;
    }

    public static ClusterToken fromToken(String token) {
        return JSONObject.parseObject(token,ClusterToken.class);
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
