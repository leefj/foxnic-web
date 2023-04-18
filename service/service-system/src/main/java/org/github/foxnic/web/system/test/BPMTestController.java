package org.github.foxnic.web.system.test;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.spec.DAO;
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
        // 第二步：指定起草人并获得其 User 对象作为流程操作人
        Result<User> userResult = UserServiceProxy.api().getByAccount(DRAFTER);
        if (userResult.failure() || userResult.data() == null) {
            return ErrorDesc.failure().message("账户不存在");
        }
        User user = userResult.data();
        ProcessDefinition processDefinition = BpmAssistant.getProcessDefinitionByCode(FORM_DEFINITION_CODE,user);
        if(processDefinition==null) {
            return ErrorDesc.failure().message("缺少流程定义");
        }
        // 第三步：根据表单定义代码创建流程代理
        ProcessDelegate process = ProcessDelegate.createFromProcessDefinition(processDefinition.getId(), demoLeave.getId(), user);
        // 指定起草人并获得其身份，身份类型按实际需求传入，UnifiedUserType 枚举中定义的其中一种
        List<Assignee> assignees = process.getIdentities(UnifiedUserType.employee);
        if (assignees.isEmpty()) {
            return ErrorDesc.failure().message("身份信息缺失");
        }
        // 视情况而定，此处示例使用第一个
        Assignee assignee = assignees.get(0);
        // 第四步：组装请求 VO，并调用暂存接口
        ProcessInstanceVO processInstanceVO = new ProcessInstanceVO();
        processInstanceVO.setTitle(title);
        processInstanceVO.setDrafterTypeEnum(assignee.getType());
        processInstanceVO.setDrafterId(assignee.getId());


        // 流程暂存
        return process.temporarySave(processInstanceVO);
    }

    /**
     * 流程启动
     */
    @PostMapping("/service-system/unit-test/bpm/start")
    public Result start(String processInstanceId) {

        Result<User> userResult = UserServiceProxy.api().getByAccount(DRAFTER);
        if (userResult.failure() || userResult.data() == null) {
            return ErrorDesc.failure().message("账户不存在");
        }
        User user = userResult.data();

        ProcessDelegate process = ProcessDelegate.createFromExistsProcess(processInstanceId, user);
        process.start();
        return ErrorDesc.success();
    }



}
