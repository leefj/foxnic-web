package org.github.foxnic.web.framework.starter;

import com.github.foxnic.commons.busi.id.SnowflakeIdWorker;
import com.github.foxnic.commons.concurrent.task.SimpleTaskManager;
import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.commons.network.Machine;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.spring.SpringUtil;
import com.github.foxnic.sql.expr.Insert;
import com.github.foxnic.sql.expr.Update;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_NODE;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.framework.environment.Environment;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Component
public class StartupRegister implements ApplicationListener<ApplicationStartedEvent> {

    public static final  Integer HEART_BEAT_INTERVAL=5000;

    /**
     * 注入DAO对象
     * */
    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;



    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        Environment.getEnvironment().ready();
        SimpleTaskManager tm=new SimpleTaskManager(1);
        tm.doIntervalTask(new Runnable() {
            @Override
            public void run() {
                beat();
            }
        },HEART_BEAT_INTERVAL);
        //
        SimpleTaskManager.doParallelTask(new Runnable() {
            @Override
            public void run() {
                register();
            }
        });

    }


    private void invalidNodes() {

        this.dao.pausePrintThreadSQL();
        Update update=new Update(SYS_NODE.$NAME);
        update.set(SYS_NODE.IS_UP,0)
                .where().and("id!=?",SpringUtil.getNodeInstanceId())
        .and(SYS_NODE.IS_UP+"=1").and(SYS_NODE.HEART_BEAT_TIME+"<?", DateUtil.addMilliseconds(new Date(),-4 * HEART_BEAT_INTERVAL));

        this.dao.execute(update);
        this.dao.resumePrintThreadSQL();

    }

    private void beat() {

        invalidNodes();

        Update update=new Update(SYS_NODE.$NAME);
        update.set(SYS_NODE.IS_UP,1)
                .set(SYS_NODE.HEART_BEAT_TIME,new Date())
        .where().and("id=?",SpringUtil.getNodeInstanceId());

        dao.pausePrintThreadSQL();
        dao.execute(update);
    }

    private void register() {


        invalidNodes();




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
        .set(SYS_NODE.HOST_NAME,Machine.getHostName());


        dao.pausePrintThreadSQL();
        //
        dao.execute(insert);
        registerSnowflake();
        //
        dao.resumePrintThreadSQL();


    }

    private void registerSnowflake() {
        RcdSet rs=dao.query("select concat(datacenter_id,'-',worker_id) dw  from sys_node where is_up=1 and datacenter_id is not null and worker_id is not null");
        List<String> ps=rs.getValueList("dw",String.class);
        Integer datacenterId=null;
        Integer workerId=null;
        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 31; j++) {
               if(!ps.contains(i+"-"+j)){
                   datacenterId=i;
                   workerId=j;
                   break;
               };
            }
            if(datacenterId!=null) break;
        }

        if(datacenterId==null) {
            throw new RuntimeException("无法获得合适的雪花ID参数");
        }

        SnowflakeIdWorker.setDefaultDatacenterId(datacenterId);
        SnowflakeIdWorker.setDefaultWorkerId(workerId);

        Update update=new Update(SYS_NODE.$NAME);
        update.set(SYS_NODE.DATACENTER_ID,datacenterId)
                .set(SYS_NODE.WORKER_ID,workerId)
                .where().and("id=?",SpringUtil.getNodeInstanceId());

        dao.execute(update);
    }
}
