package org.github.foxnic.web.wrapper.support.sso;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.framework.sso.TokenReader;
import org.github.foxnic.web.language.Language;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class FoxnicTokenReader extends TokenReader {

    @Override
    public String readUserId(HttpServletRequest request) {
        String account=request.getParameter("account");
        Result<User> userResult = UserServiceProxy.api().getByAccount(account);
        if(userResult.failure()) return null;
        if(userResult.data()==null) return null;
        return userResult.data().getId();
    }

    @Override
    public Language readLanguage(HttpServletRequest request) {
        return Language.zh_cn;
    }




}
