package org.github.foxnic.web.system.test;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.dao.spec.DBSequence;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.framework.licence.LicenceProxy;
import org.github.foxnic.web.proxy.camunda.CamundaUserServiceProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RestController("UnitTestController")
public class UnitTestController {

    /**
     * 注入DAO对象
     * */
    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;

    @PostMapping("/service-system/unit-test/sequence")
    public Result sequence() {
//        String sequenceId="qualityReportId";
        String sequenceId="TEST-004";



//        File file=new File("D:\\leefj\\workspace\\git-base\\foxnic-grant\\licence\\community\\community.lic");
//        LicenceProxy.LICENCE_DATA= FileUtil.readText(file);

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



    @PostMapping("/service-system/unit-test/cluster-1")
    public Result cluster1() {
        SessionUser user=SessionUser.getCurrent();
        Result result= CamundaUserServiceProxy.api().getById("123");
        return ErrorDesc.success().data(result.data());
    }

    @PostMapping("/service-system/unit-test/update-licence-local")
    public Result updateLicenceLocal() {
        File file=new File("D:\\leefj\\workspace\\git-base\\foxnic-grant\\licence\\community\\community.lic");

        LicenceProxy.LICENCE_DATA= FileUtil.readText(file);
        while (LicenceProxy.LICENCE_DATA!=null) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
        LicenceProxy.reset();

        JSONObject licence=LicenceProxy.getLicence();

        return ErrorDesc.success().data(licence);
    }


}
