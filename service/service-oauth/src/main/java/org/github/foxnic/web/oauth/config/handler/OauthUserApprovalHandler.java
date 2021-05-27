package org.github.foxnic.web.oauth.config.handler;

import org.github.foxnic.web.domain.oauth.OauthClient;
import org.github.foxnic.web.oauth.service.IOauthClientService;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.endpoint.AuthorizationEndpoint;
 
/**
 * @author 李方捷
 */
public class OauthUserApprovalHandler extends TokenStoreUserApprovalHandler {

    private IOauthClientService clientService;

    public OauthUserApprovalHandler() {

    }

    /**
     * 判断登录用户是否被授权(审批过)，如果未授权，则跳转到授权页面<br>
     * 用户点击授权或拒绝都会调用此方法再次进行验证
     * */
    public boolean isApproved(AuthorizationRequest authorizationRequest, Authentication userAuthentication) {
        
    	//如果审批通过
    	if (super.isApproved(authorizationRequest, userAuthentication)) {
            return true;
        }
    	
        if (!userAuthentication.isAuthenticated()) {
            return false;
        }

        OauthClient clientDetails = clientService.getById(authorizationRequest.getClientId());
        return clientDetails != null && clientDetails.getTrusted()==1;

    }

    public void setOauthService(IOauthClientService clientService) {
        this.clientService = clientService;
    }
}
