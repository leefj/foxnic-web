package org.github.foxnic.web.oauth.session;

import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.session.SessionPermission;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 
 * @author 李方捷
 * @since  2021-06-02
 * */
public class SessionUserImpl extends SessionUser implements UserDetails, CredentialsContainer {
 
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	private String sessionOnlineId;
	
	
	public static final  String SESSION_ONLINE_ID_KEY="SESSION_ONLINE_ID_KEY";
	
//	public static final String ROLE_PERMITTED="ROLE_PERMITTED";
// 
//	private static List<GrantedAuthority>  ROLES_PERMITTED=Arrays.asList(new SimpleGrantedAuthority(ROLE_PERMITTED));
  
	private transient SessionPermissionImpl permission = null;
 
	public SessionUserImpl(User user) {
		this.user=user;
	}

	@Override
	public void eraseCredentials() {
		this.user.setPasswd("******");
	}
 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return ((SessionPermissionImpl)permission()).getAuthorities();
	}

	public String[] getAuthoritieRoles() {
		return ((SessionPermissionImpl)permission()).getAuthoritieRoles();
	}

	@Override
	public String getPassword() {
		return this.user.getPasswd();
	}

	@Override
	public String getUsername() {
		return this.user.getName();
	}

	@Override
	public String getRealName() {
		if(StringUtil.hasContent(this.user.getActivatedEmployeeName())){
			return this.user.getActivatedEmployeeName();
		}
		return this.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.user.getValid()==1 && this.user.getDeleted()==0;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.user.getValid()==1 && this.user.getDeleted()==0;
	}

	/**
	 * 认证是否过期
	 * */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.user.getValid()==1 && this.user.getDeleted()==0;
	}

	public User getUser() {
		return user;
	}

	public String getSessionOnlineId() {
		return sessionOnlineId;
	}

	@Override
	public String getCacheKey() {
		if(user!=null) {
			return user.getCacheKey();
		}
		return null;
	}

	public void setSessionOnlineId(String token) {
		this.sessionOnlineId = token;
	}
	
	
	
	
	/**
	 * 获得当前登录的账户
	 * */
	public static SessionUserImpl getCurrent() {
		SecurityContext context = SecurityContextHolder.getContext();
        if(context==null || context.getAuthentication()==null || !context.getAuthentication().isAuthenticated()) {
        	 return null;
        }
        Object principal=context.getAuthentication().getPrincipal();
        if(principal==null || !(principal instanceof SessionUserImpl)) {
        	return null;
        }
        SessionUserImpl userDetail=(SessionUserImpl)principal;
        return userDetail;
	}

	public SessionPermission permission() {
		if(permission==null) permission=new SessionPermissionImpl(this);
		return permission;
	}

	@Override
	public String getUserId() {
		 return this.user.getId();
	}

	@Override
	public String getLanguage() {
		return this.user.getLanguage();
	}
 
}
