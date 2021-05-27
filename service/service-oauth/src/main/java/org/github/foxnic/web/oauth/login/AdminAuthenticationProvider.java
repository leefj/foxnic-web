package org.github.foxnic.web.oauth.login;

import java.util.Date;

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
 *  <p> 自定义认证处理 </p>
 *
 * @description :
 * @author : zhengqing
 * @date : 2019/10/12 14:49
 */
@Component
public class AdminAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    IUserService userDetailsService;
    
    @Autowired
    ISessionOnlineService onlineService;
   

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取前端表单中输入后返回的用户名、密码
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        SOSUserDetails userInfo = (SOSUserDetails) userDetailsService.loadUserByUsername(userName);

        String salt=userInfo.getUser().getSalt();
//        String userId=userInfo.getUser().getId();
        
        //核对密码
        boolean isValid = PasswordUtils.isValidPassword(password, userInfo.getPassword(), salt);
        // 验证密码
        if (!isValid) {
            throw new BadCredentialsException("密码错误");
        }

        // 前后端分离情况下 处理逻辑...
        // 更新登录令牌
        String token = PasswordUtils.encodePassword(System.currentTimeMillis() + salt, salt);
        userInfo.setToken(token);
        //User user = userDetailsService.getById(userId);//  userMapper.selectById(userInfo.getCurrentUserInfo().getId());
        //user.setToken(token);
        
        SessionOnline online=new SessionOnline();
        online.setToken(token);
        online.setOnline(1);
        online.setLoginTime(new Date());
        onlineService.insert(online);
        
        //userDetailsService.update(user,SaveMode.DIRTY_FIELDS);
        //userMapper.updateById(user);
//        userInfo.getUser().setToken(token);
       
        return new UsernamePasswordAuthenticationToken(userInfo, password, userInfo.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
