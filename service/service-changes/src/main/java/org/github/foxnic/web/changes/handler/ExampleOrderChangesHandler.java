package org.github.foxnic.web.changes.handler;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.changes.service.IExampleOrderItemService;
import org.github.foxnic.web.changes.service.IExampleOrderService;
import org.github.foxnic.web.constants.enums.changes.ApprovalEventType;
import org.github.foxnic.web.domain.changes.ChangeData;
import org.github.foxnic.web.domain.changes.ChangeEvent;
import org.github.foxnic.web.domain.changes.ExampleOrder;
import org.github.foxnic.web.framework.change.ChangesHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//@Component
public class ExampleOrderChangesHandler extends ChangesHandler {

    @Autowired
    private IExampleOrderService orderService;

    @Autowired
    private IExampleOrderItemService orderItemService;





    @Override
    public Result onEvent(ChangeEvent event) {

        //如果变更创建成功
        if(event.getEventTypeEnum() == ApprovalEventType.create_success) {
            //获取变更数据
            ChangeData changeData= event.getInstance().getDataAfter();
            //把变更数据转换成实体
            List<ExampleOrder> orders=this.cast(changeData);
            for (ExampleOrder order : orders) {
                //创建用于同步数据库的实体，更新相关的字段值
                ExampleOrder orderToUpdate=ExampleOrder.create();
                orderToUpdate.setId(order.getId())
                        //设置变更ID
                        .setChangeInstanceId(event.getInstance().getId())
                        //更新订单状态
                        .setChsStatusEnum(event.getInstance().getStatusEnum())
                        //更新订单最后审批人
                        .setLatestApproverId(event.getApproverId())
                        .setLatestApproverName(event.getApproverName())
                        //设置下一节点审批人
                        .setNextApproverIds(event.getSimpleNextApproverIds())
                        .setNextApproverNames(event.getSimpleNextApproverNames())
                        //更新订单流程概要
                        .setSummary("提交审批");
                //执行更新
                orderService.updateDirtyFields(orderToUpdate);
            }
        }

        return ErrorDesc.success();
    }


}
