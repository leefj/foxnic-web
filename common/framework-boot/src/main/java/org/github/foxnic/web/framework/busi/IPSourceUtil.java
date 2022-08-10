package org.github.foxnic.web.framework.busi;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.network.HttpClient;

public class IPSourceUtil {

    private static LocalCache<String, String> IP_CACHE = new LocalCache();
    private static final String queryApiUrl = "https://opendata.baidu.com/api.php?resource_id=6006&co=&oe=utf8&query=";

    public static String query(String ip) {
        String location = IP_CACHE.get(ip);
        if (location == null) {
            location = queryByApi(ip);
            IP_CACHE.put(ip, location);
        }
        return location;
    }

    private static String queryByApi(String ip) {
        HttpClient client = new HttpClient();
        try {
            String result = client.get(queryApiUrl + ip);
            JSONObject json = JSONObject.parseObject(result);
            if (json.getInteger("status") == 0) {
                JSONArray data = json.getJSONArray("data");
                if (data != null) {
                    if (data.size() == 0) {
                        return null;
                    } else {
                        return data.getJSONObject(0).getString("location");
                    }
                } else {
                    return null;
                }
            } else {
                return "ip_error";
            }
        } catch (Exception e) {
            Logger.exception("IP 查询异常", e);
            return null;
        }

    }

    public static void main(String[] args) {
        String loc = query("218.75.85.210");
        System.out.println(loc);
    }

}
