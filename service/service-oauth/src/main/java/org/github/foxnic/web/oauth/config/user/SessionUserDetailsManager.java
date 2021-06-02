package org.github.foxnic.web.oauth.config.user;

import java.util.HashMap;
import java.util.Map;

import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.oauth.service.IUserService;
import org.github.foxnic.web.oauth.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 * 代理 {@link org.springframework.security.provisioning.UserDetailsManager} 所有功能
 *
 * @author dax
 */
public class SessionUserDetailsManager implements UserDetailsManager {
	
	@Autowired
	private IUserService userService;
 
    /**
     * Create user.
     *
     * @param user the user
     */
    public void createUser(UserDetails user) {
         System.out.println();
    }


    /**
     * Update user.
     *
     * @param user the user
     */
    public void updateUser(UserDetails user) {
    	System.out.println();
    }


    /**
     * Delete user.
     *
     * @param username the username
     */
    public void deleteUser(String username) {
    	System.out.println();
    }


    /**
     * Change password.
     *
     * @param oldPassword the old password
     * @param newPassword the new password
     */
    public void changePassword(String oldPassword, String newPassword) {
        Authentication currentUser = SecurityContextHolder.getContext()
                .getAuthentication();

        if (currentUser == null) {
            // This would indicate bad coding somewhere
            throw new AccessDeniedException(
                    "Can't change password as no Authentication object found in context "
                            + "for current user.");
        }

        String username = currentUser.getName();

        UserDetails user = this.loadUserByUsername(username);


        if (user == null) {
            throw new IllegalStateException("Current user doesn't exist in database.");
        }

        //TODO  实现具体的更新密码逻辑
    }


    /**
     * User exists boolean.
     *
     * @param username the username
     * @return the boolean
     */
    public boolean userExists(String username) {
    	System.out.println();
    	return true;
    }


    /**
     * Load user by username user details.
     *
     * @param username the username
     * @return the user details
     * @throws UsernameNotFoundException the username not found exception
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	User user=userService.getUserByIdentity(username);
    	if(user==null) {
    		throw new UsernameNotFoundException("无效账户 [" + username + "]");
    	}
    	return new SessionUser(user);
    }
    
    


}
