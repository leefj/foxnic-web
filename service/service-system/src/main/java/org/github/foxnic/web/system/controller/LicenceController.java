package org.github.foxnic.web.system.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.io.FileUtil;
import org.github.foxnic.web.framework.licence.LicenceProxy;
import org.github.foxnic.web.proxy.system.LicenceServiceProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController("SysLicenceController")
public class LicenceController {

    @PostMapping(LicenceServiceProxy.IMPORT)
    public Result importLicence() {

        File file=new File("D:\\leefj\\workspace\\git-base\\foxnic-grant\\licence\\community\\community.lic");
        LicenceProxy.LICENCE_DATA= FileUtil.readText(file);
        while (LicenceProxy.LICENCE_DATA!=null) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
        LicenceProxy.reset();

        JSONObject licence=LicenceProxy.getLicence();

        return ErrorDesc.success().data(licence);
    }

    /**
     * 获取语言条目
     */
    @RequestMapping(LicenceServiceProxy.GET)
    public Result<JSONObject> get() {
        Result<JSONObject> result=new Result<>();
        result.success(true).data(LicenceProxy.getLicence());
        return result;
    }

}
