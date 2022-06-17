package org.github.foxnic.web.framework.bpm;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.concurrent.task.QuartzTaskManager;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.reflect.ReflectUtil;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
import org.github.foxnic.web.proxy.bpm.ProcessInstanceServiceProxy;
import org.github.foxnic.web.proxy.camunda.CamundaProcessServiceProxy;

import java.lang.reflect.Method;
import java.util.*;

public class BpmAssistant {

    /**
     * 流程实例ID
     */
    public static final String BPM_PROCESS_INSTANCE_ID = "bpmProcessInstanceId";

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



    public static Result<ProcessInstance> getProcessInstanceById(String processInstanceId) {
        return  ProcessInstanceServiceProxy.api().getById(processInstanceId);
    }

    public static Result<ProcessInstance> getProcessInstanceByCamundaId(String camundaProcessInstanceId) {
        return  ProcessInstanceServiceProxy.api().getByCamundaProcessId(camundaProcessInstanceId);
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
                return controller.handleBpmCallback(event);
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
