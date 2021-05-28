package org.github.foxnic.web.oauth.authentication;

import java.util.Date;

import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_USER;
import org.github.foxnic.web.domain.oauth.SessionOnline;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.oauth.domain.SOSUserDetails;
import org.github.foxnic.web.oauth.service.ISessionOnlineService;
import org.github.foxnic.web.oauth.service.IUserService;
import org.github.foxnic.web.oauth.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.github.foxnic.dao.data.SaveMode;

/**
 *  <p> 自定义账户认证处理器 </p>
 *
 * @description : 对接数据库，进行身份认证
 * @author : 李方捷
 * @date : 2021/05/28 14:49
 */
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    IUserService userDetailsService;
    
    @Autowired
    ISessionOnlineService onlineService;
   

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 前端传入的用户名、密码
        String identity = (String) authentication.getPrincipal();
        String passwd = (String) authentication.getCredentials();

        SOSUserDetails userInfo = (SOSUserDetails) userDetailsService.loadUserByUsername(identity);
        String salt=userInfo.getUser().getSalt();
        //核对密码
        boolean isValid = PasswordUtils.isValidPassword(passwd, userInfo.getPassword(), salt);
        // 验证密码
        if (!isValid) {
            throw new BadCredentialsException("密码错误");
        }
        // Token
        String token = PasswordUtils.encodePassword(System.currentTimeMillis() + salt, salt);
        userInfo.setToken(token);
        userDetailsService.update(SYS_USER.LAST_LOGIN_TIME, new Date(), userInfo.getUser().getId());
        
        //
        SessionOnline online=new SessionOnline();
        online.setToken(token);
        online.setOnline(1);
        online.setLoginTime(new Date());
        onlineService.insert(online);
        //
        return new UsernamePasswordAuthenticationToken(userInfo, passwd, userInfo.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
