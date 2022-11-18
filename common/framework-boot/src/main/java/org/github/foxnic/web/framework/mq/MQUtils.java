package org.github.foxnic.web.framework.mq;

import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.reflect.ReflectUtil;
import com.github.foxnic.springboot.spring.SpringUtil;

import java.lang.reflect.Method;

public class MQUtils {


    public static final String JMS_LISTENER_CLASS_NAME=  "org.springframework.jms.annotation.JmsListener";
    private static Class JMS_LISTENER_CLASS=  null;

    public static String[] getMQConfigInfo() {
        if(JMS_LISTENER_CLASS == null) {
            JMS_LISTENER_CLASS= ReflectUtil.forName(JMS_LISTENER_CLASS_NAME);
        }
        StackTraceElement[] es=(new Throwable()).getStackTrace();
        Method m = null;
        String[] info= null;
        for (StackTraceElement e : es) {
            Class type= ReflectUtil.forName(e.getClassName());
            if(type==null) continue;
            if(ReflectUtil.isSubType(MessageListener.class,type)) {
                try {
                    m = type.getDeclaredMethod("onMessage", String.class);
                    if(m==null) return null;
                    Object ann= m.getAnnotation(JMS_LISTENER_CLASS);
                    String destination= BeanUtil.getFieldValue(ann,"destination",String.class);
                    info=new String[2];
                    if(destination.startsWith("${") && destination.endsWith("}")) {
                        destination=destination.substring(2,destination.length()-1);
                        destination= SpringUtil.getEnvProperty(destination);
                        info[0] = destination;
                    }
                    String containerFactory= BeanUtil.getFieldValue(ann,"containerFactory",String.class);
                    if(containerFactory.startsWith("${") && containerFactory.endsWith("}")) {
                        containerFactory=containerFactory.substring(2,containerFactory.length()-1);
                        containerFactory= SpringUtil.getEnvProperty(containerFactory);
                        info[1] = containerFactory;
                    }
                    return info;
                } catch (NoSuchMethodException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return null;
    }

}
