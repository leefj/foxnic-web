package org.github.foxnic.web.framework.mq;


import com.github.foxnic.springboot.spring.SpringUtil;

public  class MQLogger {
    public static MQLogger get() {
        return new MQLogger(SpringUtil.getBean(IMQLogger.class));
    }

    private Long id = null;
    private IMQLogger impl = null;
    public MQLogger(IMQLogger impl) {
        this.impl = impl;
    }

    public Long start(String message) {
        this.id= impl.start(message);
        return id;
    }

    public Long result(boolean success, String result) {
        return impl.result(id,success,result);
    }

    public Long exception(Throwable e) {
        return impl.exception(id,e);
    }
}
