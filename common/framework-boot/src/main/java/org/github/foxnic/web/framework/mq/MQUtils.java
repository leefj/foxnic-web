package org.github.foxnic.web.framework.mq;

import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.reflect.ReflectUtil;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.springframework.jms.annotation.JmsListener;

import java.lang.reflect.Method;

public class MQUtils {



    public static JmsListener getMQConfigInfo() {
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
                    JmsListener ann = m.getAnnotation(JmsListener.class);
                    if(ann!=null) return ann;
                } catch (NoSuchMethodException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return null;
    }

}
