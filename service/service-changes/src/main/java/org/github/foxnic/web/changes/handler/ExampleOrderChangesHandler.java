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
            //获取变更数据
            List<ChangeData> list= event.getInstance().getDataAfter();
            for (ChangeData changeData : list) {
                //把变更数据转换成实体
                List<ExampleOrder> orders=this.cast(changeData);
                for (ExampleOrder order : orders) {
                    //创建用于同步数据库的实体，更新相关的字段值
                    ExampleOrder orderToUpdate=ExampleOrder.create();
                    orderToUpdate.setId(order.getId())
                            //设置变更ID
                            .setChsId(event.getInstance().getId())
                            //更新订单状态
                            .setChsStatusEnum(ChangeStatus.approving)
                            //更新订单最后审批人
                            .setLatestApproverId(event.getApproverId())
                            .setLatestApproverName(event.getApproverName())
                            //更新订单流程概要
                            .setProcNodeSummary("提交审批");
                    //执行更新
                    orderService.updateDirtyFields(orderToUpdate);
                }
            }
        }

        return ErrorDesc.success();
    }


}
