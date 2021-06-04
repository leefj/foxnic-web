package org.github.foxnic.web.oauth.captcha;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

import java.util.Collection;

/**
 * 验证码认证凭据.
 * @author felord.cn
 */
public class CaptchaAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private final Object principal;
    private String captcha;

    /**
     * 此构造函数用来初始化未授信凭据.
     *
     * @param principal   the principal
     * @param captcha the captcha
     * @see CaptchaAuthenticationToken#CaptchaAuthenticationToken(Object, String, Collection)
     */
    public CaptchaAuthenticationToken(Object principal, String captcha) {
        super(null);
        this.principal =  principal;
        this.captcha = captcha;
        setAuthenticated(false);
    }

    /**
     * 此构造函数用来初始化授信凭据.
     *
     * @param principal       the principal
     * @param captcha     the captcha
     * @param authorities the authorities
     * @see CaptchaAuthenticationToken#CaptchaAuthenticationToken(Object, String)
     */
    public CaptchaAuthenticationToken(Object principal, String captcha,
                                      Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.captcha = captcha;
        super.setAuthenticated(true); // must use super, as we override
    }

    public Object getCredentials() {
        return this.captcha;
    }

    public Object getPrincipal() {
        return this.principal;
    }

    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException(
                    "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }

        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        captcha = null;
    }
}
