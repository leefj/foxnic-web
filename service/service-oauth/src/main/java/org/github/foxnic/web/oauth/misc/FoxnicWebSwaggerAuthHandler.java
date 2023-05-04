package org.github.foxnic.web.oauth.misc;

import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.springboot.api.swagger.data.SwaggerAuthHandler;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Component;

@Component
public class FoxnicWebSwaggerAuthHandler implements SwaggerAuthHandler {

    @Override
    public Result checkAuth(String group) {
        SessionUser user=SessionUser.getCurrent();
        if(user==null) {
            return ErrorDesc.failure(CommonError.PERMISSION_REQUIRED);
        } else {
            return ErrorDesc.success();
        }
    }
}
