package org.github.foxnic.web.oauth.authentication;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * <p> 认证管理器 </p>
 *
 * @author : 李方捷
 * @description :
 * @date : 2021/05/28
 */
@Component
public class UserAuthenticationManager implements AuthenticationManager {

    private final UserAuthenticationProvider userAuthenticationProvider;

    public UserAuthenticationManager(UserAuthenticationProvider userAuthenticationProvider) {
        this.userAuthenticationProvider = userAuthenticationProvider;
    }

    /**
     * 获得前端认证信息，并认证
     * */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Authentication result = userAuthenticationProvider.authenticate(authentication);
        if (Objects.nonNull(result)) {
            return result;
        }
        throw new ProviderNotFoundException("账户认证失败");
    }

}
