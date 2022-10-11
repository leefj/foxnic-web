package org.github.foxnic.web.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.swagger.ErrorCode;
import com.github.foxnic.api.swagger.ErrorCodes;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicParameters;
import com.github.xiaoymin.knife4j.annotations.DynamicResponseParameters;
import io.swagger.annotations.*;
import org.github.foxnic.web.domain.example.AddressModel;
import org.github.foxnic.web.domain.example.AddressPureModel;
import org.github.foxnic.web.domain.example.AddressVO;
import org.github.foxnic.web.domain.example.meta.AddressVOMeta;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.proxy.example.AddressServiceProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@InDoc
@Api(tags = "功能示例/接口示例")
@RestController("ApiDocDemoController")
public class ApiDocDemoController {


    /**
     * Post-示例
     * <p>方法描述</p>
     * @param address 地址对象 , 地址基本信息
     * @param model 地址模型 , 地址的扩展信息
     * @param userMap 账户对象Map
     * @return  Result&lt;List&lt;AddressPureModel&gt;&gt; 地址列表
     */
    @ApiOperation(value = "Post-示例",notes = "方法描述")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "address" , value = "地址对象" , required = true , dataTypeClass=AddressVO.class , example = "{}"),
            @ApiImplicitParam(name = "model" , value = "地址模型" , required = false , dataTypeClass= List.class , example = "[]"),
            @ApiImplicitParam(name = "userMap" , value = "账户对象Map" , required = false , dataTypeClass= Map.class , example = "{}"),
    })
    @ApiOperationSupport(order=16,author="李方捷 , leefangjie@qq.com")
    @PostMapping("/service-example/example-api/new-name-2")
    @ErrorCodes({
            @ErrorCode(code = CommonError.CAPTCHA_EXPIRED,name = "动态码错误",desc = "需要输入正确的验证码", solutions = {
                    "解决方案-1",
                    "解决方案-2",
                    "解决方案-3"
            }),
            @ErrorCode(code = CommonError.DATA_REPETITION,name = "数据重复",desc = "请确认数据是否重复", solutions = {
                    "解决方案-A",
                    "解决方案-B",
                    "解决方案-C"
            }),
            @ErrorCode(code = CommonError.DATA_NOT_EXISTS),
    })
    public Result<List<AddressPureModel>> newApiName2(AddressVO address , List<AddressModel> model , Map<String, User> userMap) {
        Result<List<AddressPureModel>> result = new Result<>();
        // TODO 实现 方法描述 逻辑
        return result;
    }

    @ApiOperation(value = "示例-1",responseContainer = "Result",response = Result.class)
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
            @DynamicParameter(name = "dy-x-1",value = "dy-x-1-name",required = true,dataTypeClass = String.class,example = "dy-x-1-example"

            ),
            @DynamicParameter(name = "dy-x-2",value = "dy-x-2-name",required = true,dataTypeClass = Menu.class,example = "{}")
    })
    @PostMapping("/service-example/example-api/demo2")
    public Result demo2(AddressVO addressVO) {
        return ErrorDesc.success();
    }


    @PostMapping("/service-example/example-api/demo3")
    @ApiOperation(value = "jdk-Map-动态参数")
    @DynamicParameters(name = "CreateOrderHashMapModel",properties = {
            @DynamicParameter(name = "name01",value = "注解id",example = "X000111",required = true,dataTypeClass = Integer.class),
            @DynamicParameter(name = "name31",value = "订单编号-gson",dataTypeClass = String.class),
            @DynamicParameter(name = "name11",value = "订单编号1-gson",dataTypeClass = String.class),
    })
    @DynamicResponseParameters(name = "CreateOrderHashMapModeResult",properties = {
            @DynamicParameter(name = "name0",value = "注解id",example = "X000111",required = true,dataTypeClass = Integer.class),
            @DynamicParameter(name = "name3",value = "订单编号-gson",dataTypeClass = Date.class),
            @DynamicParameter(name = "name1",value = "订单编号1-gson",dataTypeClass = BigDecimal.class),
    })
    public Map createOrder1235332(@RequestBody HashMap map){
        return null;
    }

}
