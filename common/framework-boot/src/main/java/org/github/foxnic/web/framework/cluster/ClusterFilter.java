package org.github.foxnic.web.framework.cluster;

import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.framework.proxy.ProxyContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class ClusterFilter implements Filter {

    private static ClusterConfig configs=null;

    private DAO dao;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.configs=new ClusterConfig();
    }

    public static boolean isInvokeFromCluster(HttpServletRequest request) {
        handlerClusterRequest(request);
        Boolean flag=(Boolean)request.getAttribute(ClusterProxy.INVOKE_FROM_CLUSTER);
        if(flag==null) flag=false;
        return flag;
    }

    public static void handlerClusterRequest(HttpServletRequest request) {

        Boolean isClusterHandled=(Boolean)request.getAttribute(ClusterProxy.IS_CLUSTER_HANDLED);
        if(isClusterHandled!=null && isClusterHandled) return;

        // 判断内部集群的情况
        String clusterKey = request.getHeader(ClusterProxy.CLUSTER_KEY);
        if(clusterKey!=null && clusterKey.equals(configs.getKey())) {
            ProxyContext.init();
            String clusterToken = request.getHeader(ClusterProxy.CLUSTER_TOKEN);
            ClusterToken token=ClusterToken.fromToken(clusterToken);
            Logger.setTID(token.getTid());
            ProxyContext.initCallee(token);
            request.setAttribute(ClusterProxy.INVOKE_FROM_CLUSTER,true);
        }
        request.setAttribute(ClusterProxy.IS_CLUSTER_HANDLED,true);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 借宝地一用
        if(dao==null) {
            dao=SpringUtil.getBean(DAO.class);
        }
        dao.resumePrintThreadSQL(true);

        handlerClusterRequest((HttpServletRequest)request);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
