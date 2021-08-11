package org.github.foxnic.web.framework.starter;

import com.github.foxnic.commons.concurrent.task.SimpleTaskManager;
import com.github.foxnic.commons.network.Machine;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.spring.SpringUtil;
import com.github.foxnic.sql.expr.Insert;
import com.github.foxnic.sql.expr.Update;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_NODE;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class StartupRegister implements ApplicationListener<ApplicationStartedEvent> {

    /**
     * 注入DAO对象
     * */
    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;



    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        SimpleTaskManager tm=new SimpleTaskManager(1);
        tm.doIntervalTask(new Runnable() {
            @Override
            public void run() {
                beat();
            }
        },5000);
        //
        SimpleTaskManager.doParallelTask(new Runnable() {
            @Override
            public void run() {
                register();
            }
        });

    }

    private void beat() {

        Update update=new Update(SYS_NODE.$NAME);
        update.set(SYS_NODE.IS_UP,1)
                .set(SYS_NODE.HEART_BEAT_TIME,new Date())
        .where().and("id=?",SpringUtil.getNodeInstanceId());

        dao.setPrintThreadSQL(false);
        dao.execute(update);
    }

    private void register() {




        Insert insert=new Insert(SYS_NODE.$NAME);
        insert.set(SYS_NODE.ID, SpringUtil.getNodeInstanceId())
        .set(SYS_NODE.HOST_ID, Machine.getIdentity())
        .set(SYS_NODE.APPLICATION_NAME,SpringUtil.getApplicationName())
        .set(SYS_NODE.PORT,SpringUtil.getEnvProperty("server.port"))
        .set(SYS_NODE.PROCESS_ID,SpringUtil.getProcessId())
        .set(SYS_NODE.START_TIME,new Date())
        .set(SYS_NODE.IS_UP,1)
        .set(SYS_NODE.HEART_BEAT_TIME,new Date())
        .set(SYS_NODE.IP,Machine.getIp())
        .set(SYS_NODE.HOST_NAME,Machine.getHostName())
        ;

        dao.setPrintThreadSQL(false);
        dao.execute(insert);
        dao.setPrintThreadSQL(true);



    }
}
