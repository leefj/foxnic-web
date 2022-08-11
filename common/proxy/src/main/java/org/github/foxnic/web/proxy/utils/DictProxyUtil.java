package org.github.foxnic.web.proxy.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.DictItemVO;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictProxyUtil {

    private static DictItemServiceProxy proxy;

    private static void  init() {
       if(proxy==null) proxy=DictItemServiceProxy.api();
    }


    /**
     * 按类别和分组获取
     * */
    public static List<DictItem> getList(String dictCode) {
        init();
        DictItemVO sample=new DictItemVO();
        sample.setDictCode(dictCode);
        if(StringUtil.isBlank(sample.getSortField())) {
            sample.setSortField(DictItemMeta.SORT);
            sample.setSortType("ASC");
        }
        Result<List<DictItem>> result=proxy.queryList(sample);
        if(result==null) return null;
        if(result.failure()) return null;
        return result.data();
    }

    public static DictItem getDictItem(String dictCode,String itemCode) {
        init();
        DictItemVO sample=new DictItemVO();
        sample.setDictCode(dictCode);
        sample.setCode(itemCode);
        Result<List<DictItem>> result=proxy.queryList(sample);
        if(result==null) return null;
        if(result.failure()) return null;
        if( result.data().isEmpty()) return null;
        return  result.data().get(0);
    }

    public JSONArray toArray(String dictCode) {
        JSONArray array=new JSONArray();
        List<DictItem> list=getList(dictCode);
        for (DictItem e : list) {
            JSONObject item=new JSONObject();
            item.put("code", e.getCode());
            item.put("text", e.getLabel());
            array.add(item);
        }
        return  array;
    }



}
