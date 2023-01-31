package org.github.foxnic.web.framework.view.controller;

import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class ViewController {

    private SessionUser sessionUser;

    /**
     * 获得当前登录 SessionUser
     * */
    public SessionUser getCurrentUer() {
       if(sessionUser==null) sessionUser=SessionUser.getCurrent();
       return  sessionUser;
    }

    public String getForkDir() {
        HttpServletRequest request=this.getRequest();
        if(request==null) return null;
        String fork=request.getParameter("fork");
        return fork;
    }

    public String getTemplatePath(String prefix,String suffix) {
        String forkDir=getForkDir();
        prefix= StringUtil.trim(prefix,"/");
        suffix= StringUtil.trim(suffix,"/");
        if(StringUtil.isBlank(forkDir)) {
            return prefix+"/"+suffix;
        } else {
            return prefix+"/"+forkDir+"/"+suffix;
        }
    }


    public HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(attributes!=null) {
            return attributes.getRequest();
        } else {
            return null;
        }
    }

}
