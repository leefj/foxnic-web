package org.github.foxnic.web.framework.cluster;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.proxy.ParameterNames;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.github.foxnic.web.framework.proxy.ProxyContext;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.BeanUtils;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

@Component
public class ClusterProxy {


    private static final LocalCache<String,String> CLUSTER_SESSION_IDS=new LocalCache<>();

    public static final String CLUSTER_KEY = "$cluster_key";
    public static final String CLUSTER_TOKEN = "$cluster_token";
    public static final String INVOKE_FROM_CLUSTER = "$invoke_from_cluster";
    public static final String IS_CLUSTER_HANDLED = "$is_cluster_handled";

    private ClusterConfig configs=null;

    @PostConstruct
    void init() {
        configs=new ClusterConfig();
    }

    public Object invoke(Object proxy, Method method, Object[] args) {

        RequestMapping requestMapping=method.getAnnotation(RequestMapping.class);
        if(requestMapping==null) {
            throw new IllegalArgumentException(method.getDeclaringClass().getName()+"."+method.getName() + " 方法上未发现 RequestMapping");
        }
        // 可继续细化
        String[] values=requestMapping.value();
        if(values==null || values.length==0 || StringUtil.isBlank(values[0])) {
            throw new IllegalArgumentException(method.getDeclaringClass().getName()+"."+method.getName() + " 方法上未发现 RequestMapping 的地址映射");
        }
        // 可继续细化
        RequestMethod[] methods=requestMapping.method();
        RequestMethod requestMethod=RequestMethod.POST;
        if(methods!=null && methods.length>0) {
            requestMethod=methods[0];
        }

        String url=values[0];
        url=StringUtil.removeFirst(url,"/");
        String prefix=url.split("/")[0];

        ClusterConfig.EndPoint ep= configs.getEndPoint(prefix);

        url=StringUtil.joinUrl(ep.getUrl(),url);


        Parameter[] params = method.getParameters();
        String body = null;
        // 如果只有一个参数，并且不是简单类型
        if(params.length==1 && args[0]!=null && !BeanUtils.isSimpleValueType(args[0].getClass())) {
            Object value=args[0];
            body = JSON.toJSONString(value);
        } else {
            ParameterNames parameterNames=method.getAnnotation(ParameterNames.class);
            if(parameterNames==null) {
                throw new RuntimeException(method.getDeclaringClass().getName()+"."+method.getName()+" 缺少 ParameterNames 注解");
            }
            String[] paramNames = parameterNames.value();
            paramNames=(new DefaultParameterNameDiscoverer()).getParameterNames(method);
            JSONObject   ps = new JSONObject();
            for (int i = 0; i < params.length; i++) {
                ps.put(paramNames[i], args[i]);
            }
            body = ps.toJSONString();
        }
        return request(url,requestMethod,body);
    }

    /**
     * 请求外部节点接口
     */
    private Object request(String url, RequestMethod requestMethod, String body) {

        Logger.info("\n\npost "+url+"\n"+body+"\n");

        SessionUser sessionUser = SessionUser.getCurrent();
        Map<String, String> headers = new HashMap<>();
        headers.put(CLUSTER_KEY, this.configs.getKey());

        ClusterToken token = new ClusterToken();
        token.setServiceName((String) SpringUtil.getApplicationName());
        token.setTid(Logger.getTID());

        String operator = null;
        // 优先考虑 ProxyContext 中的操作人
        if (ProxyContext.getCallerAccount() != null) {
            operator = ProxyContext.getCallerAccount();
        }

        if (operator == null && sessionUser != null) {
            operator = sessionUser.getUsername();
        }
        if(sessionUser!=null) {
            token.setTenantId(sessionUser.getActivatedTenantId());
        }
        token.setAccount(operator);
        token.setSessionId(CLUSTER_SESSION_IDS.get(operator));

        headers.put(CLUSTER_TOKEN, token.toToken());

        if (requestMethod == RequestMethod.POST) {

            String ret = post(url, body, headers, operator);
            if (ret == null) return null;
            if (ret.startsWith("{") && ret.endsWith("}")) {
                Result result = ErrorDesc.fromJSON(ret);
                return result;
            } else {
                throw new RuntimeException("不支持的返回值");
            }

        } else {
            throw new RuntimeException("尚不支持");
        }
    }


    private static String post(String url, String data, Map<String, String> headers, String operator) {

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

            // 构建 post 请求
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "application/json");
            httpPost.setEntity(new StringEntity(data));

            String sessionId = CLUSTER_SESSION_IDS.get(operator);
            if (StringUtil.hasContent(sessionId)) {
                headers.put("Cookie", "JSESSIONID=" + sessionId);
            }

            // 添加 header
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    httpPost.addHeader(entry.getKey(), entry.getValue());
                }
            }

            // 请求并响应
            CloseableHttpResponse response = httpClient.execute(httpPost);
            // 读取 SessionId
            Header[] responseHeaders = response.getAllHeaders();
            for (Header header : responseHeaders) {

                if (header.getName().equals("Set-Cookie")) {
                    HeaderElement[] els = header.getElements();
                    for (HeaderElement el : els) {
                        if (el.getName().equals("JSESSIONID") && operator != null) {
                            CLUSTER_SESSION_IDS.put(operator, el.getValue());
                        }
                    }
                }

            }

            // 读取相应报文
            if (response.getStatusLine().getStatusCode() == 200) {  // 如果请求成功
                try (BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()))) {
                    String result = "";
                    String tmp = null;
                    while ((tmp = bufferedReader.readLine()) != null) {
                        result += tmp;
                    }
                    return result;
                }
            }

        } catch (Exception e) {
            Logger.error("Cluster 请求失败", e);
            return null;
        }
        return null;

    }

}
