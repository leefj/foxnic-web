package org.github.foxnic.web.framework.view.filter;


import com.github.foxnic.commons.environment.BrowserType;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class ViewFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        BrowserType browserType= BrowserType.parseByRequest(request);
        if(browserType==BrowserType.IE) {
            response.setContentType("text/html;");
            response.getWriter().println(
                    "<div style='width:100%;display:flex;justify-content:center;margin-top:100px'>" +
                    "<h2 style='color:#f56c6c;'>IE IS NOT SUPPORT</h2>" +
                    "</div>"
            );
            return;
        }
        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
