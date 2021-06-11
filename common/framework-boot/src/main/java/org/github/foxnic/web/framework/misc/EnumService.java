package org.github.foxnic.web.framework.misc;

import java.lang.reflect.Method;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.reflect.ReflectUtil;

@Service
public class EnumService {

	private LocalCache<String, JSONArray> cache=new LocalCache<String, JSONArray>();
	
	/**
	 * 将符合规范的枚举转换成 JSONArray
	 * */
	public JSONArray toArray(String enumName) throws Exception {
		JSONArray array=cache.get(enumName);
		if(array!=null) {
			return array;
		}
		Class cls=ReflectUtil.forName(enumName);
		if(cls==null) {
			array = new JSONArray();
			cache.put(enumName, array);
			return array;
		}
		Method m=cls.getDeclaredMethod("values");
		if(m==null) {
			array = new JSONArray();
			cache.put(enumName, array);
			return array;
		}
		array=new JSONArray();
		Object[] values=(Object[])m.invoke(m, null);
		for (Object object : values) {
			 JSONObject item=new JSONObject();
			 item.put("code", BeanUtil.getFieldValue(object, "code"));
			 item.put("text", BeanUtil.getFieldValue(object, "text"));
			 array.add(item);
		}
		cache.put(enumName, array);
		return array;
		
	}
	
}
