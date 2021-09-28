package org.github.foxnic.web.changes.service.impl;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.constants.enums.changes.ChangeStatus;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import org.github.foxnic.web.domain.changes.ChangesHandler;
import org.github.foxnic.web.domain.changes.DataDelta;
import org.github.foxnic.web.domain.changes.DataUnit;

public class ExampleOrderChangesHandler extends ChangesHandler {

    @Override
    public Result onStatusChange(ChangeInstance instance, DataUnit dataBefore, DataUnit dataAfter, DataDelta delta, ChangeStatus statusBefore, ChangeStatus statusAfter) {
        return ErrorDesc.success();
    }

}
