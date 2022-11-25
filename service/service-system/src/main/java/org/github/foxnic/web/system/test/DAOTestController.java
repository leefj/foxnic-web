package org.github.foxnic.web.system.test;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.*;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_DEMO_LEAVE;
import org.github.foxnic.web.domain.bpm.DemoLeaveVO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController("DAOTestController")
public class DAOTestController {

    /**
     * 注入DAO对象
     * */
    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;


    @PostMapping("/service-system/unit-test/dao/long-sql-1")
    public Result longSQL1() {

        String[] sqlArr={
            "select * from (" ,
                "select t.process_instance_id,task_id,t.status task_status, u.id user_id,u.account,u.real_name,a.assignee_type,a.assignee_id,p.name assignee_name " ,
                "from sys_user u" ,
                "join sys_user_tenant ut on u.id=ut.user_id" ,
                "join hrm_employee e on e.id=ut.employee_id" ,
                "join hrm_person p on e.person_id=p.id" ,
                "join sys_busi_role_member rm on e.id=rm.member_id and rm.member_type='employee'" ,
                "join sys_busi_role r on r.id=rm.role_id and r.valid=1" ,
                "join bpm_task_assignee a on a.assignee_type='busi_role' and a.assignee_id=r.id" ,
                "and ut.owner_tenant_id='T001' and real_name like ? and u.create_time>?" ,
                "join bpm_task t on t.id=a.task_id" ,
                "where u.deleted=0 and ut.deleted=0 and a.deleted=0 and t.deleted=0  and r.deleted=0" ,
                "union all" ,
                "select t.process_instance_id,task_id,t.status task_status, u.id user_id,u.account,u.real_name,a.assignee_type,a.assignee_id,p.full_name assignee_name from sys_user u" ,
                "join sys_user_tenant ut on u.id=ut.user_id" ,
                "join hrm_employee e on e.id=ut.employee_id" ,
                "join hrm_employee_position ep on e.id=ep.employee_id" ,
                "join hrm_position p on p.id=ep.position_id and p.valid=1" ,
                "join bpm_task_assignee a on a.assignee_type='position' and a.assignee_id=p.id" ,
                "join bpm_task t on t.id=a.task_id" ,
                "where u.deleted=0 and ut.deleted=0 and a.deleted=0 and t.deleted=0  and p.deleted=0 and ep.deleted=0" ,
                "union all" ,
                "select t.process_instance_id,task_id,t.status task_status, u.id user_id,u.account,u.real_name,a.assignee_type,a.assignee_id,u.real_name assignee_name from sys_user u" ,
                "join bpm_task_assignee a on a.assignee_type='user' and a.assignee_id=u.id" ,
                "join bpm_task t on t.id=a.task_id" ,
                "where u.deleted=0 and a.deleted=0 and t.deleted=0" ,
                "and t.node_name like ?" ,
            ") t" ,
            "where assignee_type=?"
        };

        // 实际情况是外部传入的参数，这里简化处理为之际赋值
        Date date= DataParser.parseDate("2021-05-13 12:16:00");

        Expr select=new Expr(SQL.joinSQLs(sqlArr),"%管理%",date,"%审批%","position");

        RcdSet rs=dao.query(select);

        return ErrorDesc.success().data(rs.toJSONArrayWithJSONObject());
    }

    @PostMapping("/service-system/unit-test/dao/long-sql-2")
    public Result longSQL2() {

        String[] sqlArr={
                "select * from (" ,
                "select t.process_instance_id,task_id,t.status task_status, u.id user_id,u.account,u.real_name,a.assignee_type,a.assignee_id,p.name assignee_name " ,
                "from sys_user u" ,
                "join sys_user_tenant ut on u.id=ut.user_id" ,
                "join hrm_employee e on e.id=ut.employee_id" ,
                "join hrm_person p on e.person_id=p.id" ,
                "join sys_busi_role_member rm on e.id=rm.member_id and rm.member_type='employee'" ,
                "join sys_busi_role r on r.id=rm.role_id and r.valid=1" ,
                "join bpm_task_assignee a on a.assignee_type='busi_role' and a.assignee_id=r.id" ,
                "and ut.owner_tenant_id='T001' and real_name like :P1 and u.create_time>:P2" ,
                "join bpm_task t on t.id=a.task_id" ,
                "where u.deleted=0 and ut.deleted=0 and a.deleted=0 and t.deleted=0  and r.deleted=0" ,
                "union all" ,
                "select t.process_instance_id,task_id,t.status task_status, u.id user_id,u.account,u.real_name,a.assignee_type,a.assignee_id,p.full_name assignee_name from sys_user u" ,
                "join sys_user_tenant ut on u.id=ut.user_id" ,
                "join hrm_employee e on e.id=ut.employee_id" ,
                "join hrm_employee_position ep on e.id=ep.employee_id" ,
                "join hrm_position p on p.id=ep.position_id and p.valid=1" ,
                "join bpm_task_assignee a on a.assignee_type='position' and a.assignee_id=p.id" ,
                "join bpm_task t on t.id=a.task_id" ,
                "where u.deleted=0 and ut.deleted=0 and a.deleted=0 and t.deleted=0  and p.deleted=0 and ep.deleted=0" ,
                "union all" ,
                "select t.process_instance_id,task_id,t.status task_status, u.id user_id,u.account,u.real_name,a.assignee_type,a.assignee_id,u.real_name assignee_name from sys_user u" ,
                "join bpm_task_assignee a on a.assignee_type='user' and a.assignee_id=u.id" ,
                "join bpm_task t on t.id=a.task_id" ,
                "where u.deleted=0 and a.deleted=0 and t.deleted=0" ,
                "and t.node_name like :P3" ,
                ") t" ,
                "where assignee_type=:P4"
        };

        // 实际情况是外部传入的参数，这里简化处理为之际赋值
        Date date= DataParser.parseDate("2021-05-13 12:16:00");

        Map<String,Object> param= MapUtil.asStringKeyMap(
                "P1","%管理%",
                "P2",date,
                "P3","%审批%",
                "P4","position"
        );

        // 日志打印
        // 断点调试
        Expr select=new Expr(SQL.joinSQLs(sqlArr),param);

        RcdSet rs=dao.query(select);

        return ErrorDesc.success().data(rs.toJSONArrayWithJSONObject());
    }

    @PostMapping("/service-system/unit-test/dao/long-sql-3")
    public Result longSQL3() {

        // 实际情况是外部传入的参数，这里简化处理为之际赋值
        Date date= DataParser.parseDate("2021-06-13 12:16:00");
        Map<String,Object> param= MapUtil.asStringKeyMap(
                "P1","%管理%",
                "P2",date,
                "P3","%审批%",
                "P4","position"
        );

        // 1、按ID获取与执行语句
        // 2、热加载
        // 3、多库兼容
        String sql=dao.getSQL("#my-select-1");
        Expr select=new Expr(sql,param);

        RcdSet rs=dao.query(select);

        return ErrorDesc.success().data(rs.toJSONArrayWithJSONObject());
    }


    @PostMapping("/service-system/unit-test/dao/setter-1")
    public Result setter1() {

        String id=IDGenerator.getSnowflakeIdString();

        // 方式 -1
        String insertStr="insert into bpm_demo_leave " +
                "( id , type , begin_time , end_time , reason ) " +
                "values (?,?,?,?,?)";

        Expr insert0=new Expr(insertStr,id,"type-1",new Date(),new Date(),"天气不错，出去旅游");
        int i=dao.execute(insert0);


        // 方式 -2
        id=IDGenerator.getSnowflakeIdString();
        Insert insert = new Insert("bpm_demo_leave");
        insert.set("id", id)
                .set("type", "type-1")
                .set("begin_time", new Date())
                .set("end_time", new Date())
                .set("reason", "天气不错，出去旅游");

        i=dao.execute(insert);

        Update update=new Update("bpm_demo_leave");
        update.set("type", "type-1")
                .set("begin_time", new Date())
                .set("end_time", new Date())
                .set("reason", "天气不错，出去旅游")
                .where().and("id=?",id);

        i=dao.execute(update);

        return ErrorDesc.success();
    }


    @PostMapping("/service-system/unit-test/dao/setter-2")
    public Result setter2() {



        String id=IDGenerator.getSnowflakeIdString();

        // 字段变了怎么办？
        Insert insert = new Insert(BPM_DEMO_LEAVE.$NAME);
        insert.set(BPM_DEMO_LEAVE.ID, id)
                .set(BPM_DEMO_LEAVE.TYPE, "type-1")
                .set(BPM_DEMO_LEAVE.BEGIN_TIME, new Date())
                .set(BPM_DEMO_LEAVE.END_TIME, new Date())
                .set(BPM_DEMO_LEAVE.REASON, "天气不错，出去旅游");

        int i=dao.execute(insert);

        Update update=new Update(BPM_DEMO_LEAVE.$NAME);
        update.set(BPM_DEMO_LEAVE.TYPE, "type-1")
                .set(BPM_DEMO_LEAVE.BEGIN_TIME, new Date())
                .set(BPM_DEMO_LEAVE.END_TIME, new Date())
                .set(BPM_DEMO_LEAVE.REASON, "天气不错，出去旅游")
                .where().andEquals(BPM_DEMO_LEAVE.ID,id);

        int j=dao.execute(update);
        return ErrorDesc.success().data("insert="+i+",update="+j);
    }


    @PostMapping("/service-system/unit-test/dao/setter-3")
    public Result setter3() {


        String id=IDGenerator.getSnowflakeIdString();

        Setter setter= null;
        if(id==null) {
            setter=new Insert(BPM_DEMO_LEAVE.$NAME);
            setter.set(BPM_DEMO_LEAVE.ID, id);
        } else {
            setter=(new Update(BPM_DEMO_LEAVE.$NAME))
                    .where().andEquals(BPM_DEMO_LEAVE.ID,id).top();
        }


        setter.set(BPM_DEMO_LEAVE.TYPE, "type-1")
                .set(BPM_DEMO_LEAVE.BEGIN_TIME, new Date())
                .set(BPM_DEMO_LEAVE.END_TIME, new Date())
                .set(BPM_DEMO_LEAVE.REASON, "天气不错，出去旅游");


        int i=dao.execute(setter);



        return ErrorDesc.success().data(i);
    }

    @PostMapping("/service-system/unit-test/dao/query-1")
    public Result query1(DemoLeaveVO demoLeaveVO) {

        RcdSet rsA=dao.query("select redidual_price from  foxnic.eam_asset_depreciation_detail where id=1");
        for (Rcd r : rsA) {
            BigDecimal redidual_price_DEC=r.getBigDecimal("redidual_price");
            System.out.println("redidual_price_DEC ="+redidual_price_DEC);
            BigDecimal s_original_price_DEC=r.getBigDecimal("s_original_price");
            System.out.println("s_original_price_DEC ="+s_original_price_DEC);

            String redidual_price_STR=r.getString("redidual_price");
            System.out.println("redidual_price_STR ="+redidual_price_STR);
            String s_original_price_STR=r.getString("s_original_price");
            System.out.println("s_original_price_STR ="+s_original_price_STR);

            System.out.println();
        }


        // Java Mapper
        String where="";
        if(!StringUtil.isBlank(demoLeaveVO.getId())) {
           where += " id = ?";
        }
        if(demoLeaveVO.getBeginTime()!=null) {
            where += " begin_time > ?";
        }



        ConditionExpr conditionExpr = new ConditionExpr();
        conditionExpr.ignore("").andIf("id = ?", demoLeaveVO.getId());
        conditionExpr.andIf("begin_time > ?" , demoLeaveVO.getBeginTime());
        conditionExpr.ignore("all").andIf("type = ?", demoLeaveVO.getType());
        conditionExpr.ignore("%null%").andIf("reason like ?","%"+demoLeaveVO.getReason()+"%");
        conditionExpr.ignore("9").andLike("REASON",demoLeaveVO.getReason());


        Expr select= new Expr("select * from bpm_demo_leave where applicant_id=?",demoLeaveVO.getApplicantId());

        select=select.append(conditionExpr);

        RcdSet rs=dao.query(select);
//        SaveMode


        Map<String,Object> map=new HashMap<>();
        map.put("select",select.getSQL());
        map.put("conditionExpr",conditionExpr.getSQL());
        map.put("data",rs.toJSONArrayWithJSONObject());

        dao.beginTransaction();
        dao.commit();
        dao.rollback();


        return ErrorDesc.success().data(map);

    }



}
