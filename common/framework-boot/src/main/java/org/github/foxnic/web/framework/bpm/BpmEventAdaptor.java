package org.github.foxnic.web.framework.bpm;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.entity.Entity;
import com.github.foxnic.dao.entity.ISimpleIdService;
import com.github.foxnic.dao.meta.DBTableMeta;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.constants.enums.bpm.BpmEventType;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import org.github.foxnic.web.proxy.bpm.ProcessInstanceRemindServiceProxy;

public abstract class BpmEventAdaptor<E extends Entity,S extends ISimpleIdService> {


    private  S service;

    private DAO dao;

    public BpmEventAdaptor(S service) {
        this.service=service;
        this.dao=this.service.dao();
    }

    public S service() {
        return service;
    }

    public DAO dao() {
        return dao;
    }



    /**
     * 获得表单数据
     * */
    protected E getFormData(BpmEvent event) {
        E form = null;
        if(StringUtil.hasContent(event.getBillId())) {
            DBTableMeta tm=this.dao().getTableMeta(this.service().table());
            Class idType= String.class;
            if(tm!=null && tm.getPKColumnCount()==1) {
                idType=tm.getPKColumns().get(0).getDBDataType().getType();
            }
            form=(E)this.service().getById(DataParser.parse(idType,event.getBillId()));
        }
        return form;
    }

    public BpmActionResult onProcessCallback(BpmEvent event) {
        BpmEventType eventType = event.getEventType();
        String processInstanceId= null;
        String noteId = null;
        if(event.getProcessInstance()!=null) {
            processInstanceId = event.getProcessInstance().getId();
        }
        if(event.getCurrentNode()!=null) {
            noteId = event.getCurrentNode().getId();
        }
        if (eventType == BpmEventType.temporary_save_start) {
            return onTemporarySaveStart(event);
        } else if (eventType == BpmEventType.temporary_save_end) {
            return onTemporarySaveEnd(event);
        } else if (eventType == BpmEventType.process_submit_start) {
            return onProcessSubmitStart(event);
        } else if (eventType == BpmEventType.process_submit_end) {
            return onProcessSubmitEnd(event);
        } else if (eventType == BpmEventType.task_start) {
            return onTaskStart(event);
        } else if (eventType == BpmEventType.task_end) {
            return onTaskEnd(event);
        } else if (eventType == BpmEventType.node_start) {
            try {
                ProcessInstanceRemindServiceProxy.api().processNodeStart(processInstanceId,noteId);
            } catch (Exception e) {
                Logger.exception(e);
            }
            return onNodeStart(event);
        } else if (eventType == BpmEventType.node_end) {
            try {
                ProcessInstanceRemindServiceProxy.api().processNodeStart(processInstanceId,noteId);
            } catch (Exception e) {
                Logger.exception(e);
            }
            return onNodeEnd(event);
        } else if (eventType == BpmEventType.fetch_back_start) {
            return onFetchBackStart(event);
        } else if (eventType == BpmEventType.fetch_back_end) {
            return onFetchBackEnd(event);
        } else if (eventType == BpmEventType.jump_start) {
            return onJumpStart(event);
        } else if (eventType == BpmEventType.jump_end) {
            return onJumpEnd(event);
        } else if (eventType == BpmEventType.delegate_start) {
            return onDelegateStart(event);
        } else if (eventType == BpmEventType.delegate_end) {
            return onDelegateEnd(event);
        } else if (eventType == BpmEventType.process_abandon_start) {
            return onProcessAbandonStart(event);
        } else if (eventType == BpmEventType.process_abandon_end) {
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
