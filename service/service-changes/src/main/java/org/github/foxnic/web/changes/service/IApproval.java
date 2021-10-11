package org.github.foxnic.web.changes.service;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.domain.changes.*;
import org.springframework.transaction.annotation.Transactional;

public interface IApproval {

    /**
     * 请求(启动)变更
     * */
    @Transactional
    Result<ChangeEvent> request(ChangeRequestBody request, ChangeDefinition definition);

    /**
     * 执行审批动作
     * */
    @Transactional
    Result<ChangeEvent> approve(ChangeApproveBody request, ChangeDefinition definition, ChangeInstance instance);

}
