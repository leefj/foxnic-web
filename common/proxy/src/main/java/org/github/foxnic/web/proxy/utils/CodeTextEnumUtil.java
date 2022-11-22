package org.github.foxnic.web.proxy.utils;

import com.alibaba.fastjson.JSONArray;
import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.EnumUtil;
import org.springframework.stereotype.Component;

@Component
public class CodeTextEnumUtil {

    private LocalCache<String, JSONArray> cache = new LocalCache<String, JSONArray>();

    /**
     * 将符合规范的枚举转换成 JSONArray
     */
    public JSONArray toArray(String enumName) throws Exception {
        return toArray(enumName, false);
    }


    /**
     * 将符合规范的枚举转换成 JSONArray
     */
    public JSONArray toArray(String enumName, String languageContext) throws Exception {
        return toArray(enumName, false, languageContext);
    }


    /**
     * 将符合规范的枚举转换成 JSONArray
     */
    public JSONArray toArray(String enumName, boolean all) throws Exception {
        return toArray(enumName, all, null);
    }

    /**
     * 将符合规范的枚举转换成 JSONArray
     */
    public JSONArray toArray(String enumName, boolean all, String languageContext) throws Exception {

        if (StringUtil.isBlank(languageContext)) {
            String[] parts = enumName.split("\\.");
            languageContext = "enum:" + parts[parts.length - 1];
        }

        if (StringUtil.isBlank(enumName)) {
            return new JSONArray();
        }
        JSONArray array = cache.get(enumName + ":" + all);
        if (array != null) {
            return array;
        }
        array = new JSONArray();
        CodeTextEnum[] values = EnumUtil.getValues(enumName);//   (Object[])m.invoke(m, null);
        for (CodeTextEnum e : values) {
            if (!all) {
                if (!e.display()) continue;
            }
            array.add(e.toJSONObject(languageContext));
        }
        cache.put(enumName, array);
        return array;
    }


}
