package org.github.foxnic.web.oauth.config.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 * @author dax
 */
@Configuration
public class SessionUserServiceConfiguration {

	@Bean
	public UserDetailsManager userDetailsManager() {
		
		SessionUserDetailsManager mngr = new SessionUserDetailsManager();
		
//		UserDetails felordcn = User.withUsername("leefj").password("{noop}123456")
//				.authorities(AuthorityUtils.NO_AUTHORITIES).build();
//		mngr.createUser(felordcn);
		
		return mngr;
	}

}
