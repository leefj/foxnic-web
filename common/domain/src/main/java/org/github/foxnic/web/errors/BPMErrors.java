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
    public static final String  STATUS_CAN_NOT_SAVE = PREFIX + "01";

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
            new ErrorDesc(STATUS_CAN_NOT_SAVE, "当前流程状态不允许暂存");
//            new ErrorDesc(DEFINE_FILE_READ_ERROR, "流程定义文件读取失败");
//            new ErrorDesc(DEPLOY_ERROR, "流程部署失败");
//            new ErrorDesc(DEFINE_FILE_ID_NOT_MATCH, "流程文件ID与之前的不匹配");
        } catch (Exception e) {}
    }
}
