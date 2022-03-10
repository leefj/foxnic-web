package org.github.foxnic.web.framework.proxy;

import com.github.foxnic.springboot.spring.SpringUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class ProxyContext {

    private InheritableThreadLocal<String> identity = new InheritableThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return null;
        }
    };

    /**
     * 在 Proxy 调用接口时，设置操作人 可以是ID，账户和手机号
     * */
    public static void setOperator(String identity) {
        SpringUtil.getBean(ProxyContext.class).identity.set(identity);
    }

    public static String getOperator() {
        return SpringUtil.getBean(ProxyContext.class).identity.get();
    }


}
