package org.github.foxnic.web.proxy.utils;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.domain.system.DbCache;
import org.github.foxnic.web.domain.system.DbCacheVO;
import org.github.foxnic.web.proxy.system.DbCacheServiceProxy;

import java.util.List;

public class DBCacheProxyUtil {

    private static DbCacheServiceProxy proxy;

    private static void  init() {
       if(proxy==null) proxy=DbCacheServiceProxy.api();
    }

    /**
     * 按 ID 获取
     * */
    public static String getById(String id) {
        init();
        Result<DbCache> result=proxy.getById(id);
        if(result==null) return null;
        if(result.failure()) return null;
        return result.data().getValue();
    }

    /**
     * 按类别和分组获取
     * */
    public static List<DbCache> getByCatalogAndGroup(String catalog,String group) {
        init();
        DbCacheVO sample=new DbCacheVO();
        sample.setCatalog(catalog).setGroup(group);
        Result<List<DbCache>> result=proxy.queryList(sample);
        if(result==null) return null;
        if(result.failure()) return null;
        return result.data();
    }

}
