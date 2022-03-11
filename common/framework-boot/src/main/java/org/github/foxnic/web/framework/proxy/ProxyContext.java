package org.github.foxnic.web.framework.proxy;

import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.framework.cluster.ClusterToken;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class ProxyContext {

    private static final  LocalCache<String,String> USER_IDS=new LocalCache<>();

    /**
     * 主调方账户
     * */
    private String callerAccount = null ;

    /**
     * 被调方账户
     * */
    private String calleeAccount = null ;

    /**
     * 被调方账户当前租户ID
     * */
    private String calleeTenantId = null ;

    /**
     * 在 Proxy 调用接口前，设置操作人(主调方)账户
     * @param  account 操作人账户
     * */
    public static void setCallerAccount(String account) {
        SpringUtil.getBean(ProxyContext.class).callerAccount = account;
    }

    /**
     * 获得通过 setCallerAccount 设置的操作人(主调方)账户
     * */
    public static String getCallerAccount() {
        return SpringUtil.getBean(ProxyContext.class).callerAccount;
    }

    /**
     * 获得通过 setCallerAccount 设置的操作人(主调方)账户ID
     */
    public static String getCallerId() {
        return getUserId(getCallerAccount());
    }

    /**
     * 获得通过 setCallerAccount 设置的操作人(主调方)账户ID
     */
    public static String getUserId(String account) {
        if (account == null) return null;
        //
        String userId = USER_IDS.get(account);
        if (userId != null) return userId;
        //
        DAO dao = SpringUtil.getBean(DAO.class);
        userId = dao.queryString("select id from sys_user where name=?", account);
        USER_IDS.put(account, userId);
        return userId;
    }


    /**
     * 作为被调方时当前操作人账户
     * */
    public static String getCalleeAccount() {
        return SpringUtil.getBean(ProxyContext.class).calleeAccount;
    }

    /**
     * 作为被调方时当前操作人账户ID
     * */
    public static String getCalleeId() {
        return getUserId(getCalleeAccount());
    }

    /**
     * 作为被调方时当前操作人账户的租户ID
     * */
    public static String getCalleeTenantId() {
        return SpringUtil.getBean(ProxyContext.class).calleeTenantId;
    }


    public static void initCallee(ClusterToken token) {
        SpringUtil.getBean(ProxyContext.class).calleeAccount=token.getAccount();
        SpringUtil.getBean(ProxyContext.class).calleeTenantId=token.getTenantId();
    }









}
