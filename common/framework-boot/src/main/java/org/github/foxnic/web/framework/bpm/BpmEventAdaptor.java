package org.github.foxnic.web.framework.bpm;

import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.entity.Entity;
import com.github.foxnic.dao.entity.ISimpleIdService;
import org.github.foxnic.web.constants.enums.bpm.BpmEventType;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;

public abstract class BpmEventAdaptor<E extends Entity,S extends ISimpleIdService> {


    private  S service;

    public BpmEventAdaptor(S service) {
        this.service=service;
    }

    protected S service() {
        return service;
    }

    /**
     * 获得表单数据
     * */
    protected E getFormData(BpmEvent event) {
        E form = null;
        if(StringUtil.hasContent(event.getBillId())) {
            form=(E)this.service().getById(event.getBillId());
        }
        return form;
    }

    public BpmActionResult onProcessCallback(BpmEvent event) {
        BpmEventType eventType = event.getEventType();

        if (eventType == BpmEventType.TEMPORARY_SAVE_START) {
            return onTemporarySaveStart(event);
        } else if (eventType == BpmEventType.TEMPORARY_SAVE_END) {
            return onTemporarySaveEnd(event);
        } else if (eventType == BpmEventType.PROCESS_SUBMIT_START) {
            return onProcessSubmitStart(event);
        } else if (eventType == BpmEventType.PROCESS_SUBMIT_END) {
            return onProcessSubmitEnd(event);
        } else if (eventType == BpmEventType.TASK_START) {
            return onTaskStart(event);
        } else if (eventType == BpmEventType.TASK_END) {
            return onTaskEnd(event);
        } else if (eventType == BpmEventType.NODE_START) {
            return onNodeStart(event);
        } else if (eventType == BpmEventType.NODE_END) {
            return onNodeEnd(event);
        } else if (eventType == BpmEventType.FETCH_BACK_START) {
            return onFetchBackStart(event);
        } else if (eventType == BpmEventType.FETCH_BACK_END) {
            return onFetchBackEnd(event);
        } else if (eventType == BpmEventType.JUMP_START) {
            return onJumpStart(event);
        } else if (eventType == BpmEventType.JUMP_END) {
            return onJumpEnd(event);
        } else if (eventType == BpmEventType.DELEGATE_START) {
            return onDelegateStart(event);
        } else if (eventType == BpmEventType.DELEGATE_END) {
            return onDelegateEnd(event);
        } else if (eventType == BpmEventType.PROCESS_ABANDON_START) {
            return onProcessAbandonStart(event);
        } else if (eventType == BpmEventType.PROCESS_ABANDON_END) {
            return onProcessAbandonEnd(event);
        } else {
            return event.getActionResult();
        }
    }


    /***
     * 流程暂存开始，通过返回 BpmActionResult  的 success 或  failure 控制暂存过程是否继续进行
     * */
    protected BpmActionResult onTemporarySaveStart(BpmEvent event) {
        return event.getActionResult();
    }

    /***
     * 流程暂存结束
     * */
    protected BpmActionResult onTemporarySaveEnd(BpmEvent event) {
        return event.getActionResult();
    }

    /***
     * 流程提交/启动开始，通过返回 BpmActionResult  的 success 或  failure 控制流程提交/启动过程是否继续进行
     * */
    protected BpmActionResult onProcessSubmitStart(BpmEvent event) {
        return event.getActionResult();
    }

    /***
     * 流程提交/启动结束，返回值无意义
     * */
    protected BpmActionResult onProcessSubmitEnd(BpmEvent event) {
        return event.getActionResult();
    }

    /***
     * 流程待办开始，通过返回 BpmActionResult  的 success 或  failure 控制流程待办处理过程是否继续进行
     * */
    protected BpmActionResult onTaskStart(BpmEvent event) {
        return event.getActionResult();
    }

    /***
     * 流程待办结束，返回值无意义
     * */
    protected BpmActionResult onTaskEnd(BpmEvent event) {
        return event.getActionResult();
    }

    /***
     * 流程节点执行前，此事件由 camunda 提供，返回值仅记录无意义
     * */
    protected BpmActionResult onNodeStart(BpmEvent event) {
        return event.getActionResult();
    }

    /***
     * 流程节点执行后，此事件由 camunda 提供，返回值仅记录无意义
     * */
    protected BpmActionResult onNodeEnd(BpmEvent event) {
        return event.getActionResult();
    }

    /***
     * 流程撤回开始，通过返回 BpmActionResult  的 success 或  failure 控制流程撤回处理过程是否继续进行
     * */
    protected BpmActionResult onFetchBackStart(BpmEvent event) {
        return event.getActionResult();
    }

    /***
     * 流程撤回结束，返回值无意义
     * */
    protected BpmActionResult onFetchBackEnd(BpmEvent event) {
        return event.getActionResult();
    }

    /***
     * 流程跳转开始，通过返回 BpmActionResult  的 success 或  failure 控制流程跳转处理过程是否继续进行
     * */
    protected BpmActionResult onJumpStart(BpmEvent event) {
        return event.getActionResult();
    }

    /***
     * 流程跳转结束， 返回值无意义
     * */
    protected BpmActionResult onJumpEnd(BpmEvent event) {
        return event.getActionResult();
    }

    /***
     * 流程转办开始，通过返回 BpmActionResult  的 success 或  failure 控制流程转办处理过程是否继续进行
     * */
    protected BpmActionResult onDelegateStart(BpmEvent event) {
        return event.getActionResult();
    }

    /***
     * 流程转办处理结束，返回值无意义
     * */
    protected BpmActionResult onDelegateEnd(BpmEvent event) {
        return event.getActionResult();
    }

    /***
     * 流程废弃开始，通过返回 BpmActionResult  的 success 或  failure 控制流程废弃处理过程是否继续进行
     * */
    protected BpmActionResult onProcessAbandonStart(BpmEvent event) {
        return event.getActionResult();
    }

    /***
     * 流程废弃结束，返回值无意义
     * */
    protected BpmActionResult onProcessAbandonEnd(BpmEvent event) {
        return event.getActionResult();
    }

}
