package org.github.foxnic.web.system.theme;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.code.CodeBuilder;
import com.github.foxnic.commons.environment.BrowserType;
import com.github.foxnic.commons.io.StreamUtil;
import com.github.foxnic.commons.json.JSONUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.constants.enums.system.YesNo;
import org.github.foxnic.web.domain.system.DbCache;
import org.github.foxnic.web.domain.system.DbCacheVO;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.github.foxnic.web.proxy.utils.DBCacheProxyUtil;
import org.github.foxnic.web.proxy.utils.SystemConfigProxyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Controller("PearThemeSupport")
public class PearThemeSupport extends ViewController {


    public static final String PEAR_SUPPORT_JS = "/console/pear/component/pear/css/pear-support.js";
    public static final String SUPPORT_CSS = "/console/pear/component/pear/css/pear-support.css";

    public static final String PEAR_THEME_PREFIX = "/console/pear/component/pear/color/pear-theme-";

    public static final String PEAR_THEME_RESOURCE_PREFIX = "/static/console/pear/component/pear/color/pear-theme-";
    public static final String TABLE_NO_SPLIT_LINE_RESOURCE_CSS = "/static/console/pear/component/pear/color/table-no-split-line.css";

    @GetMapping(PEAR_SUPPORT_JS)
    public void pearJs(HttpServletResponse response) throws Exception {
        CodeBuilder js = new CodeBuilder();
        response.getWriter().print(js.toString());
    }

    @GetMapping(SUPPORT_CSS)
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
        Integer id=json.getInteger("theme-color");
        response.sendRedirect(PEAR_THEME_PREFIX +id+".css");

    }

    @GetMapping(PEAR_THEME_PREFIX+"{index}.css")
    public void pearThemeCss(HttpServletResponse response,HttpServletRequest request,@PathVariable String index) throws Exception {
        String path=PEAR_THEME_RESOURCE_PREFIX+index+".css";
        InputStream inputStream = this.getClass().getResourceAsStream(path);
        String css=StreamUtil.input2string(inputStream,"UTF-8");
        inputStream.close();
        response.getWriter().print(css);
        YesNo tableSplitLine=SystemConfigProxyUtil.getEnum(SystemConfigEnum.SYSTEM_UI_TABLE_SPLIT_LINE,YesNo.class);
        if(tableSplitLine==null) {
            tableSplitLine=YesNo.no;
        }
        if(tableSplitLine==YesNo.no) {
            inputStream = this.getClass().getResourceAsStream(TABLE_NO_SPLIT_LINE_RESOURCE_CSS);
            css=StreamUtil.input2string(inputStream,"UTF-8");
            response.getWriter().print(css);
        }

    }

    @GetMapping("/assets/css/login-ext.css")
    public void loginCss(HttpServletResponse response,HttpServletRequest request) throws Exception {

        if(response.isCommitted()) {
            Logger.info("Response Is Committed");
            return;
        }

        String bgImage= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_LOGIN_BACKGROUND);
        String[] bgImages=bgImage.split("\\|");
        bgImage=bgImages[0];

        int interval=5*bgImages.length;
        int span=100/bgImages.length;

        List<String> frames=new ArrayList<>();
        int percent=0;
        for (String image : bgImages) {
            if(StringUtil.isBlank(image)) continue;

            percent+=span * 0.4;
            frames.add(percent+"% {background:url("+image+");background-repeat:no-repeat;background-size:cover;}");
            percent+=span * 0.17;
            frames.add(percent+"% {background:url("+image+");background-repeat:no-repeat;background-size:cover;}");
            percent+=span * 0.4;
            frames.add(percent+"% {background:url("+image+");background-repeat:no-repeat;background-size:cover;}");
        }
        frames.add("100% {background:url("+bgImage+");background-repeat:no-repeat;background-size:cover;}");

        BrowserType browserType=BrowserType.parseByRequest(request);

        CodeBuilder css=new CodeBuilder();

        css.ln(".body-background {");
        css.ln(1,"background-image:url('"+bgImage+"');background-repeat:no-repeat;background-size:cover;");
        if(browserType!=BrowserType.FIREFOX) {
            css.ln(1, "animation:bg-frames " + interval + "s ease-in-out 2s infinite;");
            css.ln(1, "-webkit-animation:bg-frames " + interval + "s ease-in-out 2s infinite;");
        }
        css.ln("}");

        css.ln("@keyframes bg-frames {");
        for (String frame : frames) {
            css.ln(1,frame);
        }
        css.ln("}");

        css.ln("@-webkit-keyframes bg-frames {");
        for (String frame : frames) {
            css.ln(1,frame);
        }
        css.ln("}");

        css.ln("@-moz-keyframes bg-frames {");
        for (String frame : frames) {
            css.ln(1,frame);
        }
        css.ln("}");


        response.getWriter().print(css.toString());
    }

}
