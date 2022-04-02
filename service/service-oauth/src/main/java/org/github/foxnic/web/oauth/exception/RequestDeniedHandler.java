package org.github.foxnic.web.oauth.exception;

import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.collection.CollectorUtil;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.Resourze;
import org.github.foxnic.web.oauth.service.IMenuService;
import org.github.foxnic.web.oauth.service.IResourzeService;
import org.github.foxnic.web.oauth.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * 请求访问被拒绝时的处理逻辑
 * @author 李方捷
 * @since  2021-06-02
 */
@Component
public class RequestDeniedHandler implements AccessDeniedHandler {

    @Autowired
    private IResourzeService resourzeService;

    @Autowired
    private IMenuService menuService;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        List<Resourze> matchs=resourzeService.getMatchd(request);

        String uri=request.getRequestURI();
        String method=request.getMethod();
        Result result=ErrorDesc.failure(CommonError.PERMISSION_REQUIRED);
        if(matchs.size()==0) {
            result.message("资源 "+method+" , "+uri+" 未定义，请联系开发人员");
            result.addSolution("需要开发人员在开发时定义，并与菜单关联");
        } else {
            List<Menu> menus=menuService.getRelatedMenus(CollectorUtil.collectList(matchs,Resourze::getId));
            if(menus.isEmpty()) {
                result.message("资源 "+method+" , "+uri+" 未关联到菜单，请联系开发人员");
                result.addSolution("需要开发人员将资源与菜单关联");
            } else {
                result.message("资源 "+method+" , "+uri+" 未授权，需要为角色勾选相关菜单");
                for (Menu menu : menus) {
                    result.addSolution("请为角色勾选菜单 : "+ menu.getAncestorsNamePath());
                }

            }
        }
		ResponseUtil.writeOK(response, result);
    }

}
