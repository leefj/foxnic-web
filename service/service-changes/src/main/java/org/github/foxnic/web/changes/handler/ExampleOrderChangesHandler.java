package org.github.foxnic.web.changes.handler;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.changes.service.IExampleOrderItemService;
import org.github.foxnic.web.changes.service.IExampleOrderService;
import org.github.foxnic.web.constants.enums.changes.ChangeEventType;
import org.github.foxnic.web.constants.enums.changes.ChangeStatus;
import org.github.foxnic.web.domain.changes.ChangeData;
import org.github.foxnic.web.domain.changes.ChangeEvent;
import org.github.foxnic.web.domain.changes.ExampleOrder;
import org.github.foxnic.web.framework.change.ChangesHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
            List<ChangeData> list= event.getInstance().getDataAfter();
            for (ChangeData cd : list) {
                if(cd.getDataType().equals(ExampleOrder.class)) {
                    ExampleOrder order=this.cast(cd);
                    ExampleOrder orderToUpdate=ExampleOrder.create();
                    orderToUpdate.setId(order.getId())
                            .setChsStatusEnum(ChangeStatus.approving)
                            .setProcNodeSummary("提交审批");
                    orderService.updateDirtyFields(orderToUpdate);
                }
            }
        }

        return ErrorDesc.success();
    }


}
