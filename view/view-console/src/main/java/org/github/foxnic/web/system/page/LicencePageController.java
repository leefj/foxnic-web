package org.github.foxnic.web.system.page;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.code.CodeBuilder;
import com.github.foxnic.commons.json.JSONUtil;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.proxy.system.LicenceServiceProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller("LicencePageController")
@RequestMapping(LicencePageController.prefix)
public class LicencePageController {

    public static final String prefix="business/system/licence";

    /**
     * 系统配置 表单页面
     */
    @RequestMapping("/licence.html")
    public String licence(Model model,String all) {
        Boolean displayAll= DataParser.parseBoolean(all);
        if(displayAll==null) displayAll=false;
        Result<JSONObject> result=LicenceServiceProxy.api().get();
        JSONObject licence=result.data();
        List<String> code=new ArrayList<>();
        if(result.success() && licence!=null && !licence.isEmpty()) {
            if(!displayAll) {
                licence.remove("menuExcludeData");
                JSONObject dataLimit = licence.getJSONObject("dataLimit");
                if (dataLimit != null) {
                    for (String key : dataLimit.keySet()) {
                        JSONObject item = dataLimit.getJSONObject(key);
                        item.remove("table");
                        item.remove("tolerance");
                        item.remove("condition");
                    }
                }
            }

            result=LicenceServiceProxy.api().getLicenceItems();
            JSONObject items=result.data();
            String json=JSONUtil.format(licence);
            String[] lines=json.split("\n");
            String desc=null;
            for (String line : lines) {
                desc=getDesc(items,line);
                code.add("<li>"+line+"&nbsp;&nbsp;<span style='color:#999;'>"+desc+"</span></li>");
            }



        } else {
            code.add("<li>许可证不可用</li>");
        }
        model.addAttribute("licence", StringUtil.join(code,""));
        return prefix+"/licence";
    }

    private String getDesc(JSONObject licenceItems,String jsonPart) {
        for (String key : licenceItems.keySet()) {
            if(jsonPart.contains("\""+key+"\"")){
                return licenceItems.getJSONObject(key).getString("desc");
            }
        }
        return "";
    }


}
