package org.github.foxnic.web.changes.service.approval;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.changes.service.*;
import org.github.foxnic.web.constants.enums.bpm.ApproverType;
import org.github.foxnic.web.constants.enums.changes.ApprovalAction;
import org.github.foxnic.web.constants.enums.changes.ApprovalEventType;
import org.github.foxnic.web.constants.enums.changes.ApprovalMode;
import org.github.foxnic.web.constants.enums.changes.ApprovalStatus;
import org.github.foxnic.web.constants.enums.hrm.FavouriteItemType;
import org.github.foxnic.web.domain.bpm.Appover;
import org.github.foxnic.web.domain.changes.*;
import org.github.foxnic.web.framework.change.ChangesAssistant;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.*;

@Component
public class SimpleApproval implements IApproval {

    @Autowired
    private IChangeDefinitionService changeDefinitionService;

    @Autowired
    private IChangeInstanceService changeInstanceService;

    @Autowired
    private IChangeEventService changeEventService;

    @Autowired
    private IChangeBillService changeBillService;

    @Autowired
    private IChangeDataService changeDataService;


    @Override
    public Result<ChangeEvent> request(ChangeRequestBody request, ChangeDefinition definition) {

        Result<ChangeEvent> result=new Result<>();

        // 基本的校验
        if(definition.getModeEnum() == ApprovalMode.simple && request.getDataAfter().size()>1) {
            result.success(false).message("简单模式不支持单据的合并审批");
            return result;
        }

        //创建虚拟节点ID
        String simpleNodeId= IDGenerator.getSnowflakeIdString();
        //创建变更事件
        ChangeEvent event=new ChangeEvent();
        event.setNotifyTime(new Timestamp(System.currentTimeMillis()));
        event.setApproverId(request.getApproverId());
        event.setApproverName(request.getApproverName());
        event.setRequestData(JSON.toJSONString(request));
        event.setOpinion(request.getOpinion());
        event.setSimpleNodeId(simpleNodeId);

        //处理审批人
        List<Appover> appovers=request.getNextNodeAppovers();
        //设置默认审批人
        if(appovers==null) {
            appovers=this.getDefaultApprovers(definition);
        }
        appovers=distinctApprover(appovers);
        //审批人校验
        if(appovers==null || appovers.isEmpty()) {
            result.success(false).message("未指定审批人");
            return result;
        }

        //创建并设置变更实例
        ChangeInstance instance=new ChangeInstance();
        instance.setDefinitionId(definition.getId());
        instance.setMode(definition.getMode());
        instance.setStatusEnum(ApprovalStatus.approving);
        instance.setTypeEnum(request.getType());
        instance.setStartTime(request.getStartTime());
        instance.setDrafterId(request.getApproverId());
        instance.setDrafterName(request.getApproverName());
        instance.setSimpleNodeId(simpleNodeId);
        instance.setSimpleApprovers(JSON.toJSONString(appovers));

        //保存变更实例
        Result cr=changeInstanceService.insert(instance);
        if(cr.failure()) {
            return cr.message("变更实例保存失败");
        }

        //保存变更单据号
        for (String billId : request.getBillIds()) {
            ChangeBill changeBill=new ChangeBill();
            changeBill.setInstanceId(instance.getId());
            changeBill.setDefinitionId(instance.getDefinitionId());
            changeBill.setBillId(billId);
            changeBillService.insert(changeBill);
        }

        //保存变更前的数据
        if(request.getDataBefore()!=null && !request.getDataBefore().isEmpty()) {
            ChangeData changeData=new ChangeData();
            changeData.setDataType(request.getDataType());
            changeData.setData(JSON.toJSONString(request.getDataBefore()));
            changeData.setInstanceId(instance.getId());
            changeData.setTimePoint(0);
            changeDataService.insert(changeData);
            //设置数据为空，减少返回的数据量
            instance.setDataBefore(changeData);
        }
        //保存变更后的数据
        if(request.getDataAfter()!=null && !request.getDataAfter().isEmpty()) {
            ChangeData changeData=new ChangeData();
            changeData.setDataType(request.getDataType());
            changeData.setData(JSON.toJSONString(request.getDataAfter()));
            changeData.setInstanceId(instance.getId());
            changeData.setTimePoint(1);
            changeDataService.insert(changeData);
            //设置数据为空，减少返回的数据量
            instance.setDataAfter(changeData);
        }

        event.setNotifyTime(new Timestamp(System.currentTimeMillis()));
        event.setInstanceId(instance.getId());
        event.setEventTypeEnum(ApprovalEventType.create_success);
        event.setApproveActionEnum(ApprovalAction.submit);
        event.setInstance(instance);
        event.setDefinition(definition);
        event.setApproverId(SessionUser.getCurrent().getUserId());
        event.setApproverName(SessionUser.getCurrent().getRealName());
        event.setNotifyData(JSON.toJSONString(event));
        Result er=changeEventService.insert(event);
        if(er.failure()) {
            throw new RuntimeException("保存变更事件失败");
        }

//        通过redis发送变更事件
//        boolean suc=redis.set(ChangesAssistant.CHANGES_NOTIFY_PREFIX+event.getId(),event,ChangesAssistant.EXPIRE_SECONDS);
//        if(suc) {
//            redis.notifyDataChange(ChangesAssistant.CHANGES_CHANNEL_EVENT_PREFIX + event.getId());
//        } else {
//            throw new RuntimeException("data notify error");
//        }

        result.success(true).data(event);
        return result;
    }

    @Override
    public Result<ChangeEvent> approve(ChangeApproveBody request, ChangeDefinition definition,ChangeInstance instance) {

        Result<ChangeEvent> result=new Result<>();
        //创建审批事件
        ChangeEvent event=new ChangeEvent();
        event.setNotifyTime(new Timestamp(System.currentTimeMillis()));
        event.setApproverId(request.getApproverId());
        event.setApproverName(request.getApproverName());
        event.setRequestData(JSON.toJSONString(request));
        event.setNotifyTime(new Timestamp(System.currentTimeMillis()));
        event.setInstanceId(instance.getId());
        event.setInstance(instance);
        event.setApproveActionEnum(request.getApprovalAction());
        event.setDefinition(definition);
        event.setApproverId(SessionUser.getCurrent().getUserId());
        event.setApproverName(SessionUser.getCurrent().getRealName());
        event.setNotifyData(JSON.toJSONString(event));
        event.setOpinion(request.getOpinion());

        //创建虚拟节点ID
        String simpleNodeId=IDGenerator.getSnowflakeIdString();
        //撤回
        if(request.getApprovalAction()== ApprovalAction.revoke) {
            //检查当前状态:可撤回审批中的流程，其它状态的不可撤回
            if(instance.getStatusEnum() == ApprovalStatus.passed  //已通过，不允许撤回
                    || instance.getStatusEnum() == ApprovalStatus.abandoned  // 已废弃，不允许撤回
                    || instance.getStatusEnum() == ApprovalStatus.drafting //草稿，没必要撤回
            ) {
                return result.success(false).message("当前审批状态["+instance.getStatusEnum().text()+"]无法撤回流程");
            }
            //可操作人判定
            if(!instance.getDrafterId().equals(request.getApproverId())){
                return result.success(false).message("非起草人，无权撤回流程");
            }
            //切换节点
            event.setSimpleNodeId(simpleNodeId);
            event.setEventTypeEnum(ApprovalEventType.revoke_success);

            instance.setSimpleNodeId(simpleNodeId);
            //设置审批动作后的状态
            instance.setStatusEnum(ApprovalStatus.drafting);
            instance.setFinishTime(null);
            changeInstanceService.updateDirtyFields(instance);
        }
        //废弃
        else if(request.getApprovalAction()== ApprovalAction.abandon) {
            //检查当前状态:已废弃、已通过的 不允许废弃
            if(instance.getStatusEnum() == ApprovalStatus.abandoned  // 已废弃的，没必要再次废弃
                    || instance.getStatusEnum() == ApprovalStatus.passed  // 已通过的不允许废弃
            ) {
                return result.success(false).message("当前审批状态["+instance.getStatusEnum().text()+"]无法废弃流程");
            }
            //可操作人判定
            if(!instance.getDrafterId().equals(request.getApproverId())) {
                return result.success(false).message("非起草人，无权废弃流程");
            }
            //切换节点
            event.setSimpleNodeId(simpleNodeId);
            event.setEventTypeEnum(ApprovalEventType.abandon_success);
            instance.setSimpleNodeId(simpleNodeId);
            //设置审批动作后的状态
            instance.setStatusEnum(ApprovalStatus.abandoned);
            instance.setFinishTime(new Date());
            changeInstanceService.updateDirtyFields(instance);
        }
        //驳回
        else if(request.getApprovalAction()== ApprovalAction.reject) {
            //获得当前流程审批人
            List<Appover> simpleInstanceAppovers = this.getSimpleInstanceApprovers(instance);
            //检查当前状态: 只有审批中的才允许驳回
            if(instance.getStatusEnum() != ApprovalStatus.approving) {
                return result.success(false).message("当前审批状态["+instance.getStatusEnum().text()+"]无法驳回");
            }
            //可操作人判定
            if(!isSimpleInstanceApprover(simpleInstanceAppovers,request.getApproverId())) {
                return result.success(false).message("非当前审批人，不允许驳回");
            }
            //切换节点
            event.setSimpleNodeId(simpleNodeId);
            event.setEventTypeEnum(ApprovalEventType.reject_success);
            instance.setSimpleNodeId(simpleNodeId);
            //设置审批动作后的状态
            instance.setStatusEnum(ApprovalStatus.rejected);
            changeInstanceService.updateDirtyFields(instance);
        }
        //驳回
        else if(request.getApprovalAction()== ApprovalAction.submit) {
            //检查当前状态:已废弃、已通过的 不允许废弃
            if( instance.getStatusEnum() == ApprovalStatus.abandoned  // 废弃的不允许再次提交，要先起草，再提交
                    || instance.getStatusEnum() == ApprovalStatus.approving // 审批中的无需再次提交
                    || instance.getStatusEnum() == ApprovalStatus.passed // 已经通过的，再次提交没有意义
            ) {
                return result.success(false).message("当前审批状态["+instance.getStatusEnum().text()+"]无法提交");
            }
            //可操作人判定
            if(!instance.getDrafterId().equals(request.getApproverId())){
                return result.success(false).message("非起草人，提交审批");
            }
            //切换节点
            event.setSimpleNodeId(simpleNodeId);
            event.setEventTypeEnum(ApprovalEventType.reject_success);

            instance.setSimpleNodeId(simpleNodeId);
            //设置审批动作后的状态
            instance.setStatusEnum(ApprovalStatus.approving);
            instance.setFinishTime(null);
            changeInstanceService.updateDirtyFields(instance);
        }
        //同意
        else if(request.getApprovalAction()== ApprovalAction.agree) {
            //获得当前流程审批人
            List<Appover> simpleInstanceAppovers = this.getSimpleInstanceApprovers(instance);
            //检查当前状态: 只有审批中的才能同意
            if(instance.getStatusEnum() != ApprovalStatus.approving) {
                return result.success(false).message("当前审批状态["+instance.getStatusEnum().text()+"]无法同意");
            }
            //可操作人判定
            if(!isSimpleInstanceApprover(simpleInstanceAppovers,request.getApproverId())) {
                return result.success(false).message("非当前审批人，不允许审批");
            }
            //切换节点
            event.setSimpleNodeId(simpleNodeId);
            event.setEventTypeEnum(ApprovalEventType.agree_success);
            instance.setSimpleNodeId(simpleNodeId);
            //设置审批动作后的状态
            instance.setStatusEnum(ApprovalStatus.passed);
            instance.setFinishTime(new Date());
            changeInstanceService.updateDirtyFields(instance);
        }
        //
        else {
            result.success(false).message("操作不支持");
            return result;
        }
        //
        Result er=changeEventService.insert(event);
        if(er.failure()) return er;
        //
        return result.success(true).data(event);
    }


    private List<Appover> getSimpleInstanceApprovers(ChangeInstance instance) {
        List<Appover> appovers=new ArrayList<>();
        JSONArray array=JSONArray.parseArray(instance.getSimpleApprovers());
        for (int i = 0; i < array.size(); i++) {
            JSONObject itm=array.getJSONObject(i);
            Appover appover=new Appover(itm.getString("id"),itm.getString("code"),itm.getString("name"), ApproverType.parseByCode(itm.getString("type")));
            appovers.add(appover);
        }
        return appovers;
    }

    private Boolean isSimpleInstanceApprover(List<Appover> simpleInstanceAppovers,String employeeId) {
        List<String> roleIds=new ArrayList<>();
        for (Appover appover : simpleInstanceAppovers) {
            if(appover.getType()==ApproverType.employee) {
                if(appover.getId().equals(employeeId)) return true;
            } else if(appover.getType()==ApproverType.bpm_role) {
                roleIds.add(appover.getId());
            }
        }
        if(!roleIds.isEmpty()) {
            ChangesAssistant changesAssistant=new ChangesAssistant(this.changeInstanceService);
            //校验员工是否属于指定的流程角色
            boolean flag=changesAssistant.isEmployeeInBpmRole(employeeId,roleIds);
            if(flag) return true;
        }
        return false;
    }

    /**
     * 获得默认审批人
     * */
    private List<Appover> getDefaultApprovers(ChangeDefinition definition) {
        String defaultApproves=definition.getSimpleApprovers();
        List<Appover> defaultApprovers=new ArrayList<>();
        if(StringUtil.isBlank(defaultApproves)) return defaultApprovers;
        //
        List<String> empIds=new ArrayList<>();
        List<String> roleIds=new ArrayList<>();
        //
        JSONArray defaultApprover=JSONArray.parseArray(defaultApproves);
        for (int i = 0; i < defaultApprover.size(); i++) {
            JSONObject itm=defaultApprover.getJSONObject(i);
            FavouriteItemType approverType= FavouriteItemType.parseByCode(itm.getString("targetId"));
            String approverId=itm.getString("targetId");
            if(approverType==FavouriteItemType.employee) {
                empIds.add(approverId);
            }
            if(approverType==FavouriteItemType.bpm_role) {
                roleIds.add(approverId);
            }
            System.out.println();
        }
        //创建辅助工具
        ChangesAssistant changesAssistant=new ChangesAssistant(this.changeInstanceService);

        if(!empIds.isEmpty()) {
            List<Appover> appovers=changesAssistant.getEmployeeApproversById(empIds.toArray(new String[0]));
            defaultApprovers.addAll(appovers);
        }
        if(!roleIds.isEmpty()) {
            List<Appover> appovers=changesAssistant.getBpmRoleApproversById(roleIds.toArray(new String[0]));
            defaultApprovers.addAll(appovers);
        }
        return defaultApprovers;
    }

    /**
     * 审批人去重
     * */
    private List<Appover> distinctApprover(List<Appover> appovers) {
        List<Appover> distinct=new ArrayList<>();
        Set<String> keys=new HashSet<>();
        //
        String key=null;
        for (Appover appover : appovers) {
            key=appover.getType().code()+":"+appover.getId();
            if(keys.contains(key)) continue;
            distinct.add(appover);
        }
        //
        return distinct;
    }

}
