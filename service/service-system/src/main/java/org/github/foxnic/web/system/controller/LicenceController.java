package org.github.foxnic.web.system.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.springboot.Licence;
import com.github.foxnic.springboot.mvc.RequestParameter;
import org.github.foxnic.web.framework.licence.LicenceProxy;
import org.github.foxnic.web.proxy.system.LicenceServiceProxy;
import org.github.foxnic.web.proxy.utils.StorageProxyUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Map;

@RestController("SysLicenceController")
public class LicenceController {

    @PostMapping(LicenceServiceProxy.IMPORT)
    public Result importLicence() {
        String fileId= RequestParameter.get().getString("fileId");
        byte[] bytes=StorageProxyUtil.getFileData(fileId);
        LicenceProxy.LICENCE_DATA= new String(bytes);
        while (LicenceProxy.LICENCE_DATA!=null) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
        LicenceProxy.reset();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        return ErrorDesc.success();
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

    /**
     * 获取语言条目
     */
    @RequestMapping(LicenceServiceProxy.GET_LICENCE_ITEMS)
    public Result<JSONObject> getLicenceItems() {
        Result<JSONObject> result=new Result<>();
        result.success(true).data(JSONObject.parseObject(JSON.toJSONString(Licence.getItems())));
        return result;
    }

}
