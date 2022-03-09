package org.github.foxnic.web.framework.cluster;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.network.HttpClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.lang.reflect.Method;

@Component
public class ClusterProxy {

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

        return request(url,requestMethod,args);
    }

    private Object request(String url, RequestMethod requestMethod,Object[] args) {
        HttpClient client=new HttpClient();
        if(requestMethod==RequestMethod.POST) {
            JSONObject param=new JSONObject();
            try {
                Object ret=client.postJSONObject(url,param);
                return ret;
            } catch (IOException e) {
                Logger.error("调用其它节点方法异常",e);
            }
        }
        return null;
    }

}
