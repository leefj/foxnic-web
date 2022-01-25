package org.github.foxnic.web.system.controller;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.dao.spec.DBSequence;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.oauth.meta.UserMeta;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("UnitTestController")
public class UnitTestController {

    /**
     * 注入DAO对象
     * */
    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;

    @PostMapping("/service-system/unit-test/sequence")
    public Result sequence() {
        String sequenceId="qualityReportId";
        String val = null;
        try {
            DBSequence sequence=dao.getSequence(sequenceId);
            val=sequence.next();
            dao.execute("insert into sys_sequence_test (sequence_id,sequence_value,create_time) values(?,?,?)",sequenceId,val,new Date());
            return ErrorDesc.success().data(val);
        } catch (Exception e) {
            val = "error:"+ IDGenerator.getSnowflakeIdString();
            dao.execute("insert into sys_sequence_test (sequence_id,sequence_value,exception,create_time) values(?,?,?,?)",sequenceId,val, StringUtil.toString(e),new Date());
            return ErrorDesc.exception(e);
        }
    }

    @PostMapping("/service-system/unit-test/join-user-menu")
    public Result joinUserMenu() {
        //User user=UserServiceProxy.api().getById("110588348101165911").data();
        User admin=dao.queryEntity(User.create().setId("110588348101165911"));
        User user1=dao.queryEntity(User.create().setId("515567129194397696"));

//        //
//        dao.fill(admin).with(UserMeta.MENUS)
//                .execute();
//
//        //
//        dao.fill(user1).with(UserMeta.MENUS)
//                .execute();

        //
        List<User> users=dao.queryEntities(User.class,"select * from sys_user where name like ?","%e%");
        dao.fill(users).with(UserMeta.MENUS)
                .execute();

        Map<String,String> map=new HashMap<>();
//        map.put(admin.getName(),"M="+admin.getMenus().size());
//        map.put(user1.getName(),"M="+admin.getMenus().size());

        return ErrorDesc.success().data(map);
    }

    @PostMapping("/service-system/unit-test/invalid-user-menu")
    public Result invalidUserMenu(String act) {
        String userId="110588348101165911";
        if(act.equals("sys_user:update")) {
            User user=dao.queryEntity(User.create().setId(userId));
            user.setLastLoginTime(new Date());
            dao.updateEntity(user, SaveMode.DIRTY_FIELDS);
        }
        return ErrorDesc.success();
    }

}
