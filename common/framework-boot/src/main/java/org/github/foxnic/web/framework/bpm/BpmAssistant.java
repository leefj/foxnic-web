package org.github.foxnic.web.framework.bpm;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.concurrent.task.QuartzTaskManager;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.ReflectUtil;
import org.github.foxnic.web.constants.enums.changes.ApprovalStatus;
import org.github.foxnic.web.domain.bpm.*;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.framework.proxy.ProxyContext;
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
import org.github.foxnic.web.proxy.bpm.ProcessInstanceServiceProxy;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Method;
import java.util.*;

public class BpmAssistant {

    /**
     * 流程实例ID
     */
    public static final String BPM_PROCESS_INSTANCE_ID = "bpmProcessInstanceId";

    public static final String INNER_DRAFTER = "#$DRAFTER:__";



    /**
     * 流程管理员角色
     * */
    public static final String ROLE_BPM_ADMIN="bpm_admin";

    private static BPMSyncWorker syncWorker=new BPMSyncWorker();

    private static QuartzTaskManager taskManager=new QuartzTaskManager(3);

    public static void startBpmDataSync(){
        taskManager.doIntervalTask(new Runnable() {
            @Override
            public void run() {
                syncWorker.doSync();
            }
        },3000);
    }

    public static Result sync(String processInstanceId,int delay) {
        // 调用同步
        return syncWorker.doSync(Arrays.asList(processInstanceId),delay);
    }


    public <T> Map<T,List<ProcessInstance>> getProcessByBillIds(Set<T> billIds) {
        // 待实现
        return null;
    }


    public static Result<ProcessInstance> getProcessInstanceById(String processInstanceId, User user) {
        if(user!=null && user.getAccount()!=null) {
            ProxyContext.init();
            ProxyContext.setCallerAccount(user.getAccount());
        }
        return  ProcessInstanceServiceProxy.api().getById(processInstanceId);
    }

    public static Result<ProcessInstance> getProcessInstanceByCamundaId(String camundaProcessInstanceId) {
        return  ProcessInstanceServiceProxy.api().getByCamundaProcessId(camundaProcessInstanceId);
    }


    public static Result<List<ProcessInstance>> getProcessInstanceByBill(String formDefinitionCode, List<String> billIds) {
        return  ProcessInstanceServiceProxy.api().getProcessInstanceByBill(formDefinitionCode,billIds,null);
    }

    /**
     * 连接流程实例
     * */
    public static <E>  void joinProcess(List<E> billList, String formCode) {

        Map<String,E> map = BeanUtil.toMap(billList,"id");
        Set<String> billIds= BeanUtil.getFieldValueSet(billList,"id",String.class);
        List<String> billIdList=new ArrayList<>(billIds);
        Result<List<ProcessInstance>> result = BpmAssistant.getProcessInstanceByBill(formCode,billIdList);
        if(result.failure()) return;
        List<ProcessInstance> list=result.data();
        for (ProcessInstance processInstance : list) {
            List<String> processInstanceBillIds=processInstance.getBillIds();
            if(processInstanceBillIds==null || processInstanceBillIds.isEmpty()) continue;
            for (String processInstanceBillId : processInstanceBillIds) {
                E bill=map.get(processInstanceBillId);
                if(bill==null) continue;
                List<ProcessInstance> currentProcessList=BeanUtil.getFieldValue(bill,"currentProcessList",List.class);
                if(currentProcessList==null) currentProcessList=new ArrayList<>();
                List<ProcessInstance> historicProcessList=BeanUtil.getFieldValue(bill,"historicProcessList",List.class);
                if(historicProcessList==null) historicProcessList=new ArrayList<>();


                if(processInstance.getApprovalStatusEnum()== ApprovalStatus.drafting
                        || processInstance.getApprovalStatusEnum()== ApprovalStatus.approving
                        || processInstance.getApprovalStatusEnum()== ApprovalStatus.error
                        || processInstance.getApprovalStatusEnum()== ApprovalStatus.rejected ) {
                    // 加入当前清单
                    currentProcessList.add(processInstance);

                } else if(processInstance.getApprovalStatusEnum()== ApprovalStatus.abandoned
                        || processInstance.getApprovalStatusEnum()== ApprovalStatus.completed ) {
                    // 加入历史清单
                    historicProcessList.add(processInstance);
                }

                BeanUtil.setFieldValue(bill,"currentProcessList",currentProcessList);
                BeanUtil.setFieldValue(bill,"historicProcessList",historicProcessList);

            }
        }


        // 设置默认流程
        ProcessInstance defaultProcess=null;
        for (E bill : billList) {
            defaultProcess =  null;
            List<ProcessInstance> currentProcessList=BeanUtil.getFieldValue(bill,"currentProcessList",List.class);
            List<ProcessInstance> historicProcessList=BeanUtil.getFieldValue(bill,"historicProcessList",List.class);

            if(defaultProcess==null) {
                defaultProcess = findFirstProcessByStatus(currentProcessList, ApprovalStatus.approving);
            }
            if(defaultProcess==null) {
                defaultProcess = findFirstProcessByStatus(currentProcessList, ApprovalStatus.drafting);
            }
            if(defaultProcess==null) {
                defaultProcess = findFirstProcessByStatus(currentProcessList, ApprovalStatus.rejected);
            }
            if(defaultProcess==null) {
                defaultProcess = findFirstProcessByStatus(currentProcessList, ApprovalStatus.error);
            }

            if(defaultProcess==null) {
                defaultProcess = findFirstProcessByStatus(historicProcessList, ApprovalStatus.completed);
            }

            if(defaultProcess==null) {
                defaultProcess = findFirstProcessByStatus(historicProcessList, ApprovalStatus.abandoned);
            }
            BeanUtil.setFieldValue(bill,"defaultProcess",defaultProcess);
        }

    }

    private static ProcessInstance findFirstProcessByStatus(List<ProcessInstance> list,ApprovalStatus status) {
        if(list==null || list.isEmpty()) return null;
        for (ProcessInstance processInstance : list) {
            if(processInstance.getApprovalStatusEnum()==status) {
                return processInstance;
            }
        }
        return null;
    }


    /**
     * 调度回调事件
     * */
    public static BpmActionResult dispatchEvent(BpmEvent event) {
        if(event.getProcessInstance()==null) {
            throw new IllegalArgumentException("缺少流程实例数据");
        }
        if(event.getProcessInstance().getFormDefinition()==null) {
            throw new IllegalArgumentException("缺少表单定义数据");
        }

        Class proxyClass=getCallbackProxyClass(event.getProcessInstance().getFormDefinition().getCallbackController());
        if(proxyClass==null) {
            throw new IllegalArgumentException("流程回调控制器无效");
        }

        try {
            Method apiMethod = proxyClass.getDeclaredMethod("api");
            if(apiMethod==null) {
                throw new IllegalArgumentException("流程回调控制器无效，缺少 api 方法");
            }
            Object instance=apiMethod.invoke(null);
            if(instance instanceof BpmCallbackController) {
                BpmCallbackController controller=(BpmCallbackController)instance;
                return controller.onProcessCallback(event);
            } else {
                throw new IllegalArgumentException("流程回调控制器无效，未实现 BpmCallbackController ");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("流程回调处理异常",e);
        }

    }


    public static Class getCallbackProxyClass(String callbackController) {

        String[] parts=callbackController.split("\\.");
        String modulePkg=parts[parts.length-3];
        String className=parts[parts.length-1];
        className= StringUtil.removeLast(className,"Controller")+"ServiceProxy";
        List<String> partList=new ArrayList<>();
        partList.addAll(Arrays.asList(parts));
        partList=partList.subList(0,partList.size()-3);
        partList.add("proxy");
        partList.add(modulePkg);
        partList.add(className);

        Class proxyClass=ReflectUtil.forName(StringUtil.join(partList,"."));

        return proxyClass;

    }
}
