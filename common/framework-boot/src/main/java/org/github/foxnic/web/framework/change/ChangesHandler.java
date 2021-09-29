package org.github.foxnic.web.framework.change;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.domain.changes.ChangeEvent;

public abstract class ChangesHandler {

    /**
     * 如果返回成功，调用后续步骤
     * */
    public abstract Result onEvent(ChangeEvent event);

}
