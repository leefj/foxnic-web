package org.github.foxnic.web.system.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("LicencePageController")
@RequestMapping(LicencePageController.prefix)
public class LicencePageController {

    public static final String prefix="business/system/licence";

    /**
     * 系统配置 表单页面
     */
    @RequestMapping("/licence.html")
    public String login(Model model) {
        //
        return prefix+"/licence";
    }

}
