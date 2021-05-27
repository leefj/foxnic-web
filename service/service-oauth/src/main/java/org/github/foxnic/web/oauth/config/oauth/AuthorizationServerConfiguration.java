package org.github.foxnic.web.oauth.config.oauth;

import javax.sql.DataSource;

import org.github.foxnic.web.oauth.config.handler.OauthUserApprovalHandler;
import org.github.foxnic.web.oauth.service.IOauthClientService;
import org.github.foxnic.web.oauth.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

import com.github.foxnic.springboot.spring.SpringUtil;


 

/**
 * 授权服务器配置
 * */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	/**
	 * 
	 * */
    @Autowired
    private TokenStore tokenStore;

//    @Autowired
//    private DefaultTokenServices tokenServices;


    /**
     * 客户端信息加载服务，由 CustomJdbcClientDetailsService 实现
     * */
//    @Autowired
//    private ClientDetailsService clientDetailsService;


    @Autowired
    private IOauthClientService clientService;


    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;


    @Autowired
    private IUserService userDetailsService;


    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(getClientDetailsService());
    }


//    /*
//     * JDBC TokenStore
//     */
//    @Bean
//    public TokenStore tokenStore(DataSource dataSource) {
//        return new JdbcTokenStore(dataSource);
//    }

    /*
     * Redis TokenStore (有Redis场景时使用)
     */
//    @Bean
//    public TokenStore tokenStore(RedisConnectionFactory connectionFactory) {
//        final RedisTokenStore redisTokenStore = new RedisTokenStore(connectionFactory);
//        //prefix
//        redisTokenStore.setPrefix(RESOURCE_ID);
//        return redisTokenStore;
//    }


    @Bean
    public ClientDetailsService clientDetailsService(DataSource dataSource) {
        return new CustomJdbcClientDetailsService(dataSource);
    }


    @Bean
    public AuthorizationCodeServices authorizationCodeServices(DataSource dataSource) {
        return new JdbcAuthorizationCodeServices(dataSource);
    }
    
    
    private DefaultTokenServices getTokenService() {
    	return SpringUtil.getBean(DefaultTokenServices.class);
    }
    
    private ClientDetailsService getClientDetailsService() {
    	return SpringUtil.getBean(ClientDetailsService.class);
    }
    
    


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenServices(getTokenService())
                .tokenStore(tokenStore)
                .authorizationCodeServices(authorizationCodeServices)
                .userDetailsService(userDetailsService)
                .userApprovalHandler(userApprovalHandler())
                .authenticationManager(authenticationManager);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        // real 值可自定义
        oauthServer.realm("spring-oauth-server")
                // 支持 client_credentials 的配置
                .allowFormAuthenticationForClients();
    }

    @Bean
    public OAuth2RequestFactory oAuth2RequestFactory() {
        return new DefaultOAuth2RequestFactory(getClientDetailsService());
    }


    @Bean
    public UserApprovalHandler userApprovalHandler() {
    	 
        OauthUserApprovalHandler userApprovalHandler = new OauthUserApprovalHandler();
        userApprovalHandler.setOauthService(clientService);
        userApprovalHandler.setTokenStore(tokenStore);
        userApprovalHandler.setClientDetailsService(getClientDetailsService());
        userApprovalHandler.setRequestFactory(oAuth2RequestFactory());
        return userApprovalHandler;
    }

}



class CustomJdbcClientDetailsService extends JdbcClientDetailsService {

	/**
	 * 查询客户端信息的语句
	 * */
    private static final String SELECT_CLIENT_DETAILS_SQL = "select id client_id, client_secret, resource_ids, scope, authorized_grant_types, " +
            "web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, auto_approve autoapprove " +
            "from sys_oauth_client where id = ? and valid = 0 and deleted=0";


    public CustomJdbcClientDetailsService(DataSource dataSource) {
        super(dataSource);
        setSelectClientDetailsSql(SELECT_CLIENT_DETAILS_SQL);
    }


}