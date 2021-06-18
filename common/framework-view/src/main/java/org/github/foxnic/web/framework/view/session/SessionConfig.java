package org.github.foxnic.web.framework.view.session;


import org.github.foxnic.web.proxy.utils.SessionUserProxyUtil;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionConfig implements ApplicationContextAware  {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        SessionUser.configGetInView(()->{
            return getInMonadicApp();
        });

    }

    /**
     * 单体应用模式下获得 SessionUser
     * */
    private  SessionUser getInMonadicApp(){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        SessionUser user=null;
        HttpSession session=request.getSession();
        if(session!=null) {
            user=(SessionUser)session.getAttribute("SESSEION-USER");
        }
        if(user==null) {
            user= SessionUserProxyUtil.getSessionUser(request);
            session.setAttribute("SESSEION-USER",user);
        }

        return user;
    }

}
