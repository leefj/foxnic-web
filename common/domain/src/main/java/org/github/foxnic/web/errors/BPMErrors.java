package org.github.foxnic.web.errors;

import com.github.foxnic.api.error.ErrorDefinition;
import com.github.foxnic.api.error.ErrorDesc;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BPMErrors extends ErrorDefinition {

    // 设定前缀
    private static final String PREFIX = "BPM-";

    /**
     * 当前流程状态不允许暂存
     */
    public static final String   PROCESS_INSTANCE_STATUS_CAN_NOT_SAVE = PREFIX + "01";

    /**
     * 当前流程状态不允许启动
     */
    public static final String   PROCESS_INSTANCE_STATUS_CAN_NOT_START = PREFIX + "02";

    /**
     * 流程实例不存在
     */
    public static final String  PROCESS_INSTANCE_NOT_EXISTS = PREFIX + "03";


    /**
     * 流程实例配置数据错误
     */
    public static final String  PROCESS_INSTANCE_NOT_READY_FOR_START = PREFIX + "04";

//    /**
//     * 流程定义文件读取失败
//     */
//    public static final String DEFINE_FILE_READ_ERROR = PREFIX + "02";
//
//
//    /**
//     * 流程定义文件读取失败
//     */
//    public static final String DEPLOY_ERROR = PREFIX + "03";
//
//    /**
//     * 流程定义文件读取失败
//     */
//    public static final String DEFINE_FILE_ID_NOT_MATCH = PREFIX + "04";

    @Override
    @PostConstruct
    public void init() {
        try {
            new ErrorDesc(PROCESS_INSTANCE_STATUS_CAN_NOT_SAVE, "当前流程状态不允许暂存");
            new ErrorDesc(PROCESS_INSTANCE_STATUS_CAN_NOT_START, "当前流程状态不允许启动");
            new ErrorDesc(PROCESS_INSTANCE_NOT_EXISTS, "流程实例不存在");
            new ErrorDesc(PROCESS_INSTANCE_NOT_READY_FOR_START, "流程数据错误");
        } catch (Exception e) {}
    }
}
