package org.github.foxnic.web.changes.service.approval;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.changes.service.IApproval;
import org.github.foxnic.web.domain.changes.*;
import org.springframework.stereotype.Component;

@Component
public class BpmApproval implements IApproval {

    @Override
    public Result<ChangeEvent> request(ChangeRequestBody request, ChangeDefinition definition) {
        Result<ChangeEvent> result=new Result<>();
        result.success(false).message("暂不支持流程引擎模式");
        return result;
    }

    @Override
    public Result<ChangeEvent> approve(ChangeApproveBody request, ChangeDefinition definition, ChangeInstance instance) {
        Result<ChangeEvent> result=new Result<>();
        result.success(false).message("暂不支持流程引擎模式");
        return result;
    }

}
