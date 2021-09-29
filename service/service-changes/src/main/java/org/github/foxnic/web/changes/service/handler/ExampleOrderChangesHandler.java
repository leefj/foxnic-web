package org.github.foxnic.web.changes.service.handler;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.domain.changes.ChangeEvent;
import org.github.foxnic.web.framework.change.ChangesHandler;
import org.springframework.stereotype.Component;

@Component
public class ExampleOrderChangesHandler extends ChangesHandler {

    @Override
    public Result onEvent(ChangeEvent event) {
        return ErrorDesc.success();
    }


}
