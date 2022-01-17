package org.github.foxnic.web.system.controller;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.dao.spec.DBSequence;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

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

}
