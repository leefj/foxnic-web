package org.github.foxnic.web.framework.change;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.ReflectUtil;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import org.github.foxnic.web.domain.changes.ChangeRequest;

import java.lang.reflect.Method;

public class ChangesAssistant {

    public static final long  EXPIRE_SECONDS=60 * 30;
    public static final String CHANGES_CHANNEL_EVENT_PREFIX = "foxnic:channel:changes:notify:";
    public static final String CHANGES_NOTIFY_PREFIX = "foxnic:changes:event:notify:";

    public static final String CHANGES_CHANNEL_RESPONSE_PREFIX = "foxnic:channel:changes:response:";
    public static final String CHANGES_RESPONSE_PREFIX = "foxnic:changes:event:response:";

    private static final String PROXY_NAME="org.github.foxnic.web.proxy.changes.ChangeInstanceServiceProxy";

    private DAO dao;
    private String table;
    private Object proxy;
    private Method methodRequest=null;

    /**
     * 从变更主表对用的 Service 创建变更工具
     * */
    public ChangesAssistant(SuperService service) {
        this.dao=service.dao();
        this.table=service.table();
        Class proxyType= ReflectUtil.forName(PROXY_NAME);
        try {
            Method api=proxyType.getDeclaredMethod("api");
            proxy= api.invoke(null);
            methodRequest=proxy.getClass().getMethod("request",ChangeRequest.class);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 启动变更
     * */
    public Result request(ChangeRequest request) {
        if(StringUtil.isBlank(request.getDataTable())) {
            request.setDataTable(table);
        } else {
            if(!table.equalsIgnoreCase(request.getDataTable())) {
                throw new IllegalArgumentException("表名不一致");
            }
        }
        Result<ChangeInstance>  result = null;
        try {
            result = (Result<ChangeInstance>)methodRequest.invoke(proxy,request);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
