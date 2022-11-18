package org.github.foxnic.web.system.service.impl;

import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.Insert;
import com.github.foxnic.sql.expr.Update;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.framework.mq.MQLogger;
import org.github.foxnic.web.framework.mq.MQUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;

@Service
public class MQLoggerImpl  implements MQLogger {

    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;

    @Override
    public Long start(String message) {
        JmsListener jmsListener = MQUtils.getMQConfigInfo();
        Long id= IDGenerator.getSnowflakeId();
        Insert insert=new Insert("sys_mq_log");
        insert.set("id",id).set("message",message).set("receive_time",new Timestamp(System.currentTimeMillis()));
        if(jmsListener!=null) {
            insert.set("destination",jmsListener.destination());
            insert.set("message_type",jmsListener.containerFactory());
        }
        dao.execute(insert);
        return id;
    }

    @Override
    public Long result(Long id, boolean success, String result) {
        Update update=new Update("sys_mq_log");
        update.where("id=?",id);
        update.set("success",success?1:0).set("result",result).set("finish_time",new Timestamp(System.currentTimeMillis()));
        dao.execute(update);
        return id;
    }

    @Override
    public Long exception(Long id, Exception e) {
        Update update=new Update("sys_mq_log");
        update.where("id=?",id);
        update.set("errors", StringUtil.toString(e)).set("success",0).set("result","失败").set("finish_time",new Timestamp(System.currentTimeMillis()));
        dao.execute(update);
        return id;
    }
}
