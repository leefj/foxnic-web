package org.github.foxnic.web.changes.handler;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.changes.service.IExampleOrderItemService;
import org.github.foxnic.web.changes.service.IExampleOrderService;
import org.github.foxnic.web.constants.enums.changes.ChangeEventType;
import org.github.foxnic.web.domain.changes.ChangeEvent;
import org.github.foxnic.web.framework.change.ChangesHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExampleOrderChangesHandler extends ChangesHandler {

    @Autowired
    private IExampleOrderService orderService;

    @Autowired
    private IExampleOrderItemService orderItemService;

    @Override
    public Result onEvent(ChangeEvent event) {

        //如果变更创建成功
        if(event.getEventTypeEnum() == ChangeEventType.create_success) {

        }

        return ErrorDesc.success();
    }


}
