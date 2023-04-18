package org.github.foxnic.web.framework.proxy;

import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.framework.cluster.ClusterToken;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class ProxyContext {

    public static final String PROXY_CONTEXT_ATTRIBUTE_KEY="$FIXNIC_WEB_PROXY_CONTEXT";

    private static InheritableThreadLocal<ProxyContext> CONTEXT_HOLDER = new InheritableThreadLocal<ProxyContext>() {
        @Override
        protected ProxyContext initialValue() {
            return null;
        }
    };

    public static ProxyContext getInstance() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(attributes!=null) {
            return (ProxyContext)attributes.getAttribute(PROXY_CONTEXT_ATTRIBUTE_KEY, RequestAttributes.SCOPE_REQUEST);
        } else {
            return CONTEXT_HOLDER.get();
        }
    }

    public static void init() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(attributes!=null) {
            attributes.setAttribute(PROXY_CONTEXT_ATTRIBUTE_KEY, new ProxyContext(), RequestAttributes.SCOPE_REQUEST);
        } else {
            CONTEXT_HOLDER.set(new ProxyContext());
        }
    }



    private static final  LocalCache<String,String> USER_IDS=new LocalCache<>();


    public ProxyContext() {

    }

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
     * 是否忽略错误信息，不打印异常或不抛出异常，默认 false
     * */
    private boolean ignoreCallError=false;

    /**
     * 在 Proxy 调用接口前，设置操作人(主调方)账户
     * @param  account 操作人账户
     * */
    public static void setCallerAccount(String account) {
        ProxyContext context = getInstance();
        if(context==null) ProxyContext.init();
        context = getInstance();
        context.callerAccount = account;
    }

    /**
     * 获得通过 getCallerAccount 设置的操作人(主调方)账户
     * */
    public static String getCallerAccount() {
        ProxyContext context = getInstance();
        if(context==null) return null;
        return context.callerAccount;
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
        DAO dao = SpringUtil.getBean(DBConfigs.PRIMARY_DAO,DAO.class);
        if(dao==null) {
            dao = SpringUtil.getBean(DAO.class);
        }
        userId = dao.queryString("select id from sys_user where account=?", account);
        USER_IDS.put(account, userId);
        return userId;
    }

    /**
     * 在调用时，是否忽略错误信息，不打印异常或不抛出异常，默认 false
     * */
    public static void setIgnoreCallError(boolean ignoreCallError) {
        ProxyContext context = getInstance();
        if(context==null) ProxyContext.init();
        context = getInstance();
        context.ignoreCallError=ignoreCallError;
    }

    /**
     * 是否忽略错误信息，不打印异常或不抛出异常，默认 false
     * */
    public static boolean isIgnoreCallError() {
        ProxyContext context = getInstance();
        if(context==null) return false;
        return context.ignoreCallError;
    }

    /**
     * 作为被调方时当前操作人账户
     * */
    public static String getCalleeAccount() {
        ProxyContext context = getInstance();
        if(context==null) return null;
        return context.calleeAccount;
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
        ProxyContext context = getInstance();
        if(context==null) return null;
        return context.calleeTenantId;
    }

    /**
     * 设置被调方信息
     * */
    public static void initCallee(ClusterToken token) {
        ProxyContext context = getInstance();
        if(context==null) return;
        context.calleeAccount=token.getAccount();
        context.calleeTenantId=token.getTenantId();
    }



}
