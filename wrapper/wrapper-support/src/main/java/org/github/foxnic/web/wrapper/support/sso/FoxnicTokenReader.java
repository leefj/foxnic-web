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
    /**
     * 从请求中读取账户
     * */
    @Override
    public String readUserId(HttpServletRequest request) {
        // 读取token
        String account=request.getParameter("account");
        // 把读取的 token 转换为 userId
        Result<User> userResult = UserServiceProxy.api().getByAccount(account);
        if(userResult.failure()) return null;
        if(userResult.data()==null) return null;
        // 最终返回 userId
        return userResult.data().getId();
    }

    /**
     * 从请求中读取用户指定的语言
     * */
    @Override
    public Language readLanguage(HttpServletRequest request) {
        String lang=request.getParameter("lang");
        Language language=Language.parseByCode(lang);
        if(language==null) {
            language=Language.zh_cn;
        }
        return language;
    }
}
