package org.github.foxnic.web.system.test;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.constants.enums.bpm.PriorityLevel;
import org.github.foxnic.web.constants.enums.dict.LeaveType;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.bpm.*;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.framework.bpm.BpmAssistant;
import org.github.foxnic.web.framework.bpm.ProcessDelegate;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.proxy.bpm.DemoLeaveServiceProxy;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import com.github.foxnic.api.swagger.ApiParamSupport;

@RestController("BPMTestController")
public class BPMTestController {

    /**
     * 注入DAO对象
     */
    @Resource(name = DBConfigs.PRIMARY_DAO)
    private DAO dao = null;

    private static String FORM_DEFINITION_CODE = "foxnic-leave";

    /**
     * 起草人
     */
    private static String DRAFTER = "qiaof";

    /**
     * 暂存
     */
    @PostMapping("/service-system/unit-test/bpm/save")
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(String billId, String title, Integer days, String reason) {
        if(StringUtil.isBlank(billId)) {
            billId= IDGenerator.getSnowflakeIdString();
        }
        // 第一步：创建或保存业务单据
        DemoLeave demoLeave = DemoLeaveServiceProxy.api().getById(billId).data();
        if (demoLeave == null) {
            demoLeave = new DemoLeave();
        }

        demoLeave.setType(LeaveType.L02.code());
        demoLeave.setReason(reason);
        Date begin = new Date();
        Date end = DateUtil.addDays(begin, days);
        demoLeave.setBeginTime(begin);
        demoLeave.setEndTime(end);
        demoLeave.setId(billId);
        // 转VO去保存
        DemoLeaveVO demoLeaveVO = demoLeave.toPojo(DemoLeaveVO.class);
        Result saveResult = DemoLeaveServiceProxy.api().save(demoLeaveVO);
        if (saveResult.failure()) {
            return ErrorDesc.failure().message("保存单据失败");
        }

        // 第三步：根据表单定义代码创建流程代理
        ProcessDelegate process = ProcessDelegate.createFromProcessDefinition(FORM_DEFINITION_CODE, DRAFTER);

        // 流程暂存
        return process.temporarySave(title,billId);
    }

    /**
     * 流程启动
     */
    @PostMapping("/service-system/unit-test/bpm/start")
    public Result start(String processInstanceId) {

        ProcessDelegate process = ProcessDelegate.createFromExistsProcess(processInstanceId, DRAFTER);
        process.start();
        return ErrorDesc.success();
    }



}
