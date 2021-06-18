package org.github.foxnic.web.framework.feign;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.bean.BeanUtil;

import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

@SuppressWarnings("restriction")
public class FeignResultDecoder implements Decoder {
	
	private static Map<String,Class>  TYPE_CACHE=new  ConcurrentHashMap<String, Class>();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
		if (response.body() == null) {
            throw new DecodeException(response.status(), "没有返回有效的数据", response.request());
        }
        String bodyStr = Util.toString(response.body().asReader(Util.UTF_8));
        JSONObject json=JSONObject.parseObject(bodyStr);
        
        Result result=new Result();
        
        result.success(json.getBoolean("success"));
        result.message(json.getString("message"));
        result.code(json.getString("code"));
        
 
        
        ParameterizedTypeImpl typeImpl=(ParameterizedTypeImpl)type;
        Type[] gTypes=typeImpl.getActualTypeArguments();
        Class gType=null;
        if(gTypes!=null && gTypes.length==1) {
        	try {
				gType=(Class)gTypes[0];
			} catch (Exception e) {
				ParameterizedTypeImpl pType=(ParameterizedTypeImpl)gTypes[0];
				gType=pType.getRawType();
			}
        } else {
        	String dType=json.getString("dataType");
        	if(!StringUtils.isBlank(dType)) {
        		gType=TYPE_CACHE.get(dType);
        		if(gType==null) {
	        		try {
						gType=Class.forName(dType);
						TYPE_CACHE.put(dType,gType);
					} catch (ClassNotFoundException e) {
						throw new RuntimeException(e);
					}
        		}
        	}
        }
        
        String data=json.getString("data");
        if(gType!=null && !StringUtils.isBlank(data)) {
	        if(JSONObject.class.equals(gType)) {
	    		result.data(JSONObject.parseObject(data));
	    	} else if(JSONArray.class.equals(gType)) {
	    		result.data(JSONArray.parseArray(data));
	    	} else {
	    		result.data(JSON.parseObject(data, gType));
	    	}
        }
        
        JSONObject extra=json.getJSONObject("extra");
        for (String key : extra.keySet()) {
			BeanUtil.setFieldValue(result.extra(), key, extra.get(key));
		}
       
       
         
        return result;
	}

}
