package org.github.foxnic.web.proxy.utils;

import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class ImplConfigUtil {

    private static final String CONFIG_KEY_PREFIX="modules";
    private static final String CONFIG_KEY_IMPL="impl";
    private static final String CONFIG_SUBJECT_DEFAULT="default";
    private static final String CONFIG_SUBJECT_TENANT="tenant";
    private static final String CONFIG_SUBJECT_USER="user";

    public static interface ViewKeyHandler {
        String key(SessionUser user,String key);
    }

    private static final Map<String,ViewKeyHandler> CONFIG_SUBJECT_PRIORITY = new LinkedHashMap<>();
    static {
        CONFIG_SUBJECT_PRIORITY.put(CONFIG_SUBJECT_USER,(session,key)->{
            if(session==null) {
                return key;
            }
            return key+"."+session.getUser().getAccount();
        });
        CONFIG_SUBJECT_PRIORITY.put(CONFIG_SUBJECT_TENANT,(session,key)->{
            if(session==null) {
                return key;
            }
            return key+"."+session.getActivatedTenantId();
        });
        CONFIG_SUBJECT_PRIORITY.put(CONFIG_SUBJECT_DEFAULT,(session,key)->{return key;});
    }

    public static String getViewImpl(HandlerMethod method, SessionUser user) {
        String ctrlName=method.getMethod().getDeclaringClass().getName();
        String methodName=method.getMethod().getName();
        String baseKey=CONFIG_KEY_PREFIX+"."+ctrlName+"."+CONFIG_KEY_IMPL;
        String key = null;
        for (Map.Entry<String,ViewKeyHandler> subject : CONFIG_SUBJECT_PRIORITY.entrySet()) {
            key=baseKey+"."+subject.getKey();
            key=subject.getValue().key(user,key)+"."+methodName;
            String value=SystemConfigProxyUtil.getString(key);
            if(StringUtil.hasContent(value))
                return value;
        }
        return null;
    }

    public static String getServiceImpl(Class serviceIntfType,SessionUser user) {
        String intfName=serviceIntfType.getName();
        String baseKey=CONFIG_KEY_PREFIX+"."+intfName+"."+CONFIG_KEY_IMPL;
        String key = null;
        for (Map.Entry<String,ViewKeyHandler> subject : CONFIG_SUBJECT_PRIORITY.entrySet()) {
            key=baseKey+"."+subject.getKey();
            key=subject.getValue().key(user,key);
            String value=SystemConfigProxyUtil.getString(key);
            if(StringUtil.hasContent(value))
                return value;
        }
        return null;
    }



}
