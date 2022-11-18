package org.github.foxnic.web.framework.mq;

import com.github.foxnic.commons.reflect.ReflectUtil;

import java.lang.reflect.Method;

public interface MessageListener {



    void onMessage(String message);
}
