package org.github.foxnic.web.framework.change;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.reflect.ReflectUtil;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.domain.changes.ChangeApproveBody;
import org.github.foxnic.web.domain.changes.ChangeEvent;
import org.github.foxnic.web.domain.changes.ChangeRequestBody;

import java.lang.reflect.Method;

public class ChangesAssistant {

    public static final long  EXPIRE_SECONDS=60 * 30;
    public static final String CHANGES_CHANNEL_EVENT_PREFIX = "foxnic:channel:changes:notify:";
    public static final String CHANGES_NOTIFY_PREFIX = "foxnic:changes:event:notify:";

    public static final String CHANGES_CHANNEL_RESPONSE_PREFIX = "foxnic:channel:changes:response:";
    public static final String CHANGES_RESPONSE_PREFIX = "foxnic:changes:event:response:";

    private static final String PROXY_NAME="org.github.foxnic.web.proxy.changes.ChangeInstanceServiceProxy";

    private DAO dao;
    private static Object proxy;
    private static Method methodRequest=null;
    private static Method methodApprove=null;

    /**
     * 从变更主表对用的 Service 创建变更工具
     * */
    public ChangesAssistant(SuperService service) {
        this.dao=service.dao();
        if(proxy==null) {
            Class proxyType = ReflectUtil.forName(PROXY_NAME);
            try {
                Method api = proxyType.getDeclaredMethod("api");
                proxy = api.invoke(null);
                methodRequest = proxy.getClass().getMethod("request", ChangeRequestBody.class);
                methodApprove = proxy.getClass().getMethod("approve", ChangeApproveBody.class);
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    /**
     * 启动变更
     * */
    public Result<ChangeEvent> request(ChangeRequestBody request) {
        Result<ChangeEvent>  result = null;
        try {
            result = (Result<ChangeEvent>)methodRequest.invoke(proxy,request);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 变更审批
     * */
    public Result<ChangeEvent> approve(ChangeApproveBody approveBody) {
        Result<ChangeEvent>  result = null;
        try {
            result = (Result<ChangeEvent>)methodApprove.invoke(proxy,approveBody);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
