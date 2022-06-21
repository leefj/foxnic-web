package org.github.foxnic.web.proxy.bpm;

import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;

/**
 * 接收流程事件回调的控制器需要实现此接口
 * */
public interface BpmCallbackController {
    BpmActionResult onProcessCallback(BpmEvent event);
}
