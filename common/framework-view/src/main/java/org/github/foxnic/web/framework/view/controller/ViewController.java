package org.github.foxnic.web.framework.view.controller;

import org.github.foxnic.web.session.SessionUser;

public class ViewController {

    private SessionUser sessionUser;

    /**
     * 获得当前登录 SessionUser
     * */
    public SessionUser getCurrentUer() {
       if(sessionUser==null) sessionUser=SessionUser.getCurrent();
       return  sessionUser;
    }

}
