package org.github.foxnic.web.proxy.utils;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.domain.system.DbCache;
import org.github.foxnic.web.domain.system.DbCacheVO;
import org.github.foxnic.web.proxy.system.DbCacheServiceProxy;
import org.github.foxnic.web.session.SessionUser;

import javax.servlet.http.HttpServletRequest;
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
    public static List<DbCache> getList(DbCacheVO sample) {
        init();
        Result<List<DbCache>> result=proxy.queryList(sample);
        if(result==null) return null;
        if(result.failure()) return null;
        return result.data();
    }

    /**
     * 获得行宽配置信息
     * */
    public static JSONObject getLayUITableWidthConfig(HttpServletRequest request, SessionUser user) {
        if(user==null) return null;
        String uri=request.getRequestURI();
        DbCacheVO sample=new DbCacheVO();
        sample.setCatalog("layui-table-column-width");
        sample.setArea(uri);
        sample.setOwnerType("user");
        sample.setOwnerId(user.getUserId());
        List<DbCache> list = DBCacheProxyUtil.getList(sample);
        //如果没有，则从任意账户获取
        if(list==null || list.isEmpty()) {
            sample.setOwnerId(null);
            list = DBCacheProxyUtil.getList(sample);
        }
        JSONObject json=new JSONObject();
        String[] tmp=null;
        String tableId=null;
        for (DbCache c : list) {
            tmp=c.getId().split("#");
            tableId=tmp[1];
            json.put(tableId,JSONObject.parseObject(c.getValue()));
        }
        return json;
    }

}
