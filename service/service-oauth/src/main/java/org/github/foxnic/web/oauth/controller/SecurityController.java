package org.github.foxnic.web.oauth.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.swagger.*;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicResponseParameters;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.constants.enums.system.MenuType;
import org.github.foxnic.web.domain.oauth.*;
import org.github.foxnic.web.domain.oauth.meta.MenuMeta;
import org.github.foxnic.web.domain.oauth.meta.MenuVOMeta;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.oauth.service.IMenuService;
import org.github.foxnic.web.oauth.service.IRoleMenuService;
import org.github.foxnic.web.proxy.oauth.MenuServiceProxy;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.tokens.Token;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-01 09:27:29
 * @version
 */
@InDoc
@Api(tags = "认证服务/安全接口")
@ApiSort(0)
@RestController("SecurityController")
public class SecurityController {



    /**
     * 账户登录
     */
    @ApiOperation(value = "账户登录")
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true,ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = UserServiceProxy.LOGIN_URI)
    @PostMapping(UserServiceProxy.LOGIN_URI)
    @DynamicResponseParameters(name = "LoginModel",properties = {
            @DynamicParameter(name = "user",value = "账户",example = "{}",dataTypeClass = User.class),
            @DynamicParameter(name = "sessionId",value = "会话ID",example = "{}",dataTypeClass = String.class),
            @DynamicParameter(name = "token",value = "Token",example = "{accessToken:\"access-token\",refreshToken:\"refresh-token\"}",dataTypeClass = TokenModel.class),
    })
    @ErrorCodes({
            @ErrorCode(code = CommonError.USER_NOT_EXISTS),
            @ErrorCode(code = CommonError.PASSWORD_INVALID),
            @ErrorCode(code = CommonError.USER_BLOCKED),
            @ErrorCode(code = CommonError.CREDENTIALS_EXPIRED),
            @ErrorCode(code = CommonError.USER_EXPIRED),
            @ErrorCode(code = CommonError.USER_DISABLED),
            @ErrorCode(code = CommonError.PERMISSION_REQUIRED)

    })
    public Map login(LoginIdentityVO identityVO) {
        return null;
    }


    /**
     * 账户登出
     */
    @ApiOperation(value = "账户登出")
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = UserServiceProxy.LOGOUT_URI)
    @PostMapping(UserServiceProxy.LOGOUT_URI)
    public Result logout() {
        return ErrorDesc.success();
    }


}
