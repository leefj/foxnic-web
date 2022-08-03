package org.github.foxnic.web.system.theme;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.code.CodeBuilder;
import com.github.foxnic.commons.json.JSONUtil;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.domain.system.DbCache;
import org.github.foxnic.web.domain.system.DbCacheVO;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.github.foxnic.web.proxy.utils.DBCacheProxyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller("PearThemeSupport")
public class PearThemeSupport extends ViewController {


    @GetMapping("/console/pear/component/pear/css/pear-support.js")
    public void pearJs(HttpServletResponse response) throws Exception {
        CodeBuilder js = new CodeBuilder();
        js.ln("alert('pear')");
        response.getWriter().print(js.toString());
    }

    @GetMapping("/console/pear/component/pear/css/pear-support.css")
    public void pearCss(HttpServletResponse response) throws Exception {
        if(this.getCurrentUer()==null) return;

        DbCacheVO sample=new DbCacheVO();
        sample.setCatalog("theme");
        sample.setArea("pear-config");
        sample.setOwnerType("user");
        sample.setOwnerId(this.getCurrentUer().getUserId());
        List<DbCache> list = DBCacheProxyUtil.getList(sample);
        if(list.isEmpty()) return;
        DbCache cache=list.get(0);
        String cfg=cache.getValue();
        if(StringUtil.isBlank(cfg)) return;
        JSONObject json= JSONUtil.parseJSONObject(cfg);
        Integer id=json.getInteger("id");
        response.sendRedirect("/console/pear/component/pear/color/pear-theme-"+id+".css");

    }

}
