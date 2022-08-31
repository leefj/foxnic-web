package org.github.foxnic.web.framework.cluster;

import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.mvc.ParameterFilter;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.framework.proxy.ProxyContext;
import org.springframework.web.context.ContextLoader;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


public class ClusterFilter implements Filter {

    private static ClusterConfig configs=null;

    private static ClusterFilter clusterFilter;

    public ServletContext servletContext;

    public ServletContext getServletContext() {
        return servletContext;
    }

    public static ClusterFilter getInstance() {
        return clusterFilter;
    }
    private DAO dao;

    public ClusterFilter() {
        clusterFilter=this;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.configs=new ClusterConfig();
        clusterFilter=this;
        this.servletContext=filterConfig.getServletContext();

    }

    public static boolean isInvokeFromCluster(HttpServletRequest request) {
        handlerClusterRequest(request);
        Boolean flag=(Boolean)request.getAttribute(ClusterProxy.INVOKE_FROM_CLUSTER);
        if(flag==null) flag=false;
        return flag;
    }

    private List filters = null;

    public List filters() {
        return filters;
    }

    private static long latestHandleTime=0;

    /**
     * 最后一次处理时间
     * */
    public static long getLatestHandleTime() {
        return latestHandleTime;
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

        latestHandleTime = System.currentTimeMillis();

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 借宝地一用
        if(dao==null) {
            dao=SpringUtil.getBean(DAO.class);
        }
        if (this.filters == null) {
            this.filters = (List) BeanUtil.getFieldValue(chain, "filters");
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
