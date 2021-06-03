package org.github.foxnic.web.oauth.config.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 * @author 李方捷
 * @since  2021-06-02
 */
@Configuration
public class SessionUserServiceConfiguration {

	@Bean
	public UserDetailsManager userDetailsManager() {
		return new SessionUserDetailsManager();
	}

}
