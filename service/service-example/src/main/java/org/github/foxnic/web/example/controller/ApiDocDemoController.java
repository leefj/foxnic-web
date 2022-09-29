package org.github.foxnic.web.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicParameters;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.domain.example.AddressVO;
import org.github.foxnic.web.domain.example.meta.AddressVOMeta;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.proxy.example.AddressServiceProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@InDoc
@Api(tags = "功能示例/接口示例")
@RestController("ApiDocDemoController")
public class ApiDocDemoController {


    @ApiOperation(value = "示例-1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = AddressVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028267108274176"),
            @ApiImplicitParam(name = AddressVOMeta.NAME , value = "收件人姓名" , required = false , dataTypeClass=String.class , example = "李方捷"),
            @ApiImplicitParam(name = AddressVOMeta.PHONE_NUMBER , value = "收件人手机" , required = false , dataTypeClass=String.class , example = "1234567333"),
            @ApiImplicitParam(name = AddressVOMeta.ADDRESS , value = "收件地址" , required = false , dataTypeClass=String.class , example = "浙江省宁波市鄞州区鄞县大道二号"),
            @ApiImplicitParam(name = AddressVOMeta.REGION_TYPE , value = "类型" , required = true , dataTypeClass=String.class),
            @ApiImplicitParam(name = AddressVOMeta.REGION_LOCATION , value = "地区位置" , required = false , dataTypeClass=String.class),
    })
    @ApiOperationSupport(order=1 , author="李方捷 , leefangjie@qq.com")
    @PostMapping("/service-example/example-api/demo1")
    public Result demo1(AddressVO addressVO) {
        return ErrorDesc.success();
    }


    @ApiOperation(value = "示例-2")
    @ApiOperationSupport(order=2 , author="李方捷 , leefangjie@qq.com")
    @ApiImplicitParams({
            @ApiImplicitParam(name = AddressVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028267108274176"),
            @ApiImplicitParam(name = AddressVOMeta.NAME , value = "收件人姓名" , required = false , dataTypeClass=String.class , example = "李方捷"),
            @ApiImplicitParam(name = AddressVOMeta.PHONE_NUMBER , value = "收件人手机" , required = false , dataTypeClass=String.class , example = "1234567333"),
            @ApiImplicitParam(name = AddressVOMeta.ADDRESS , value = "收件地址" , required = false , dataTypeClass=String.class , example = "浙江省宁波市鄞州区鄞县大道二号"),
            @ApiImplicitParam(name = AddressVOMeta.REGION_TYPE , value = "类型" , required = true , dataTypeClass=String.class),
            @ApiImplicitParam(name = AddressVOMeta.REGION_LOCATION , value = "地区位置" , required = false , dataTypeClass=String.class),
    })
    @DynamicParameters( name = "dy-x",properties = {
            @DynamicParameter(name = "dy-x-1",value = "dy-x-1-name",required = true,dataTypeClass = String.class,example = "dy-x-1-example"),
            @DynamicParameter(name = "dy-x-2",value = "dy-x-2-name",required = true,dataTypeClass = Menu.class,example = "{}")
    })
    @PostMapping("/service-example/example-api/demo2")
    public Result demo2(AddressVO addressVO) {
        return ErrorDesc.success();
    }

}
