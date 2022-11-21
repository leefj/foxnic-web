package org.github.foxnic.web.framework.mq;

public interface IMQLogger {
    Long start(String message);
    Long result(Long id,boolean success,String result);
    Long exception(Long id,Throwable e);



}
