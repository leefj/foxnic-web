package org.github.foxnic.web.oauth.session;

import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.session.SessionPermission;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Map;

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

	public String[] getAuthedRoles() {
		return ((SessionPermissionImpl)permission()).getAuthedRoles();
	}

	@Override
	public String getPassword() {
		if(this.user==null) {
			throw new IllegalArgumentException("缺少 user 对象");
		}
		return this.user.getPasswd();
	}

	@Override
	public String getUsername() {
		if(this.user==null) {
			throw new IllegalArgumentException("缺少 user 对象");
		}
		return this.user.getAccount();
	}

	@Override
	public String getRealName() {
		if(this.user==null) {
			throw new IllegalArgumentException("缺少 user 对象");
		}
		if(StringUtil.hasContent(this.user.getRealName())){
			return this.user.getRealName();
		}
		return this.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		if(this.user==null) {
			throw new IllegalArgumentException("缺少 user 对象");
		}
		if(this.user.getValid()==null) {
			Logger.error("数据库连接字符串可能未加入 tinyInt1isBit 参数，要求 tinyInt1isBit=false");
		}
		if(this.user.getValid()==null || this.user.getDeleted()==null) return false;
		return this.user.getValid()==1 && this.user.getDeleted()==0;
	}

	@Override
	public boolean isAccountNonLocked() {
		if(this.user==null) {
			throw new IllegalArgumentException("缺少 user 对象");
		}
		if(this.user.getValid()==null) {
			Logger.error("数据库连接字符串可能未加入 tinyInt1isBit 参数，要求 tinyInt1isBit=false");
		}
		if(this.user.getValid()==null || this.user.getDeleted()==null) return false;
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
		if(this.user==null) {
			throw new IllegalArgumentException("缺少 user 对象");
		}
		if(this.user.getValid()==null) {
			Logger.error("数据库连接字符串可能未加入 tinyInt1isBit 参数，要求 tinyInt1isBit=false");
		}
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

	public void setSessionOnlineId(String onlineId) {
		this.sessionOnlineId = onlineId;
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


	private Map<String,String> menuRoleRelation;

	public SessionPermission permission() {
		if(permission==null) permission=new SessionPermissionImpl(this.getUser(),menuRoleRelation);
		this.menuRoleRelation=permission.getMenuRoleRelation();
		return permission;
	}

	@Override
	public String getUserId() {
		if (this.user == null) {
			throw new IllegalArgumentException("缺少 user 对象");
		}
		return this.user.getId();
	}

	@Override
	public String getLanguage() {
		if (this.user == null) {
			throw new IllegalArgumentException("缺少 user 对象");
		}
		return this.user.getLanguage();
	}

}
