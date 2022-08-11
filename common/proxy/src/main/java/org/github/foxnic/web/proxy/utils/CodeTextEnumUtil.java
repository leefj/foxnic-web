package org.github.foxnic.web.proxy.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.EnumUtil;
import org.springframework.stereotype.Service;

@Service
public class CodeTextEnumUtil {

	private LocalCache<String, JSONArray> cache=new LocalCache<String, JSONArray>();

	/**
	 * 将符合规范的枚举转换成 JSONArray
	 * */
	public JSONArray toArray(String enumName) throws Exception {
		return toArray(enumName,false);
	}
	/**
	 * 将符合规范的枚举转换成 JSONArray
	 * */
	public JSONArray toArray(String enumName,boolean  all) throws Exception {

		if(StringUtil.isBlank(enumName)) {
			return new JSONArray();
		}
		JSONArray array=cache.get(enumName+":"+all);
		if(array!=null) {
			return array;
		}
		array=new JSONArray();
		CodeTextEnum[] values= EnumUtil.getValues(enumName);//   (Object[])m.invoke(m, null);
		for (CodeTextEnum e : values) {
			if(!all) {
				if (!e.display()) continue;
			}
			 JSONObject item=new JSONObject();
			 item.put("code", e.code());
			 item.put("text", e.text());
			 array.add(item);
		}
		cache.put(enumName, array);
		return array;
	}



}
