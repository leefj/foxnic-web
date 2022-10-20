package org.github.foxnic.web.system.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.encrypt.Base64Util;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.springboot.Licence;
import com.github.foxnic.springboot.mvc.RequestParameter;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import org.github.foxnic.web.framework.licence.LicenceProxy;
import org.github.foxnic.web.proxy.system.LicenceServiceProxy;
import org.github.foxnic.web.proxy.utils.StorageProxyUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Map;

@InDoc
@Api(tags = "系统服务/许可证")
@ApiSort(0)
@RestController("SysLicenceController")
public class LicenceController {

    @PostMapping(LicenceServiceProxy.IMPORT)
    public Result importLicence() {
        Long t=System.currentTimeMillis();
        String data= RequestParameter.get().getString("data");
        if(data==null) return ErrorDesc.failure();
        data= Base64Util.decode(data);
        LicenceProxy.LICENCE_DATA= data;
        while (LicenceProxy.LICENCE_DATA!=null) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
        LicenceProxy.reset();
        t=5100-(System.currentTimeMillis()-t);
        try {
            Thread.sleep(t);
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
        JSONObject json=LicenceProxy.getModuleConfig("hrm");
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
