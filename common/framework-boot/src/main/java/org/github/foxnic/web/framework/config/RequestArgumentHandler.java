package org.github.foxnic.web.framework.config;

import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.dao.entity.Entity;
import com.github.foxnic.springboot.mvc.ControllerAspector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RequestArgumentHandler {

    @Autowired
    private ControllerAspector aspector;

    @PostConstruct
    public void initMethod(){

        aspector.addArgHandler(args -> {

            for (Object arg : args) {
                if(arg instanceof Entity) {
                    Integer i= BeanUtil.getFieldValue(arg,"pageIndex",Integer.class);
                    if(i==null) {
                        BeanUtil.setFieldValue(arg,"pageIndex",1);
                    }
                    i= BeanUtil.getFieldValue(arg,"pageSize",Integer.class);
                    if(i==null) {
                        BeanUtil.setFieldValue(arg,"pageSize",10);
                    }
                }
            }

            return args;
        });

    }

}
