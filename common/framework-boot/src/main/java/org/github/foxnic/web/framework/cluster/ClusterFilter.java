package org.github.foxnic.web.framework.cluster;

import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.framework.proxy.ProxyContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class ClusterFilter implements Filter {

    private ClusterConfig configs=null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.configs=new ClusterConfig();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 判断内部集群的情况
        String clusterKey = ((HttpServletRequest)request).getHeader(ClusterProxy.CLUSTER_KEY);
        if(clusterKey!=null && clusterKey.equals(configs.getKey())) {
            String clusterToken = ((HttpServletRequest)request).getHeader(ClusterProxy.CLUSTER_TOKEN);
            ClusterToken token=ClusterToken.fromToken(clusterToken);
            Logger.setTID(token.getTid());
            ProxyContext.initCallee(token);
        }

        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
