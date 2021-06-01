package org.github.foxnic.web.framework.security.controller;

import javax.servlet.http.HttpServletResponse;

import org.github.foxnic.web.framework.security.service.IValidateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import com.wf.captcha.utils.CaptchaUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 验证码提供
 * @author 李方捷
 * @date 2021/03/18
 */
@Api(tags = "验证码服务")
@ApiSort(1)
@Controller
@RequestMapping(ValidateCodeController.VCODE_URI)
public class ValidateCodeController {
 
	public static final String VCODE_URI="/security/validate-code";
	
	@Autowired
	private IValidateCodeService validateCodeService;
    /**
     * 创建验证码
     *
     * @throws Exception
     */
	@ApiOperation(value = "获取验证码图片")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "deviceId" , value = "客户端唯一码" , required = true , dataTypeClass=String.class),
	})
	@NotNull(name = "deviceId")
    @GetMapping("/{deviceId}")
    public void createCode(@PathVariable String deviceId, HttpServletResponse response) throws Exception {
        Assert.notNull(deviceId, "机器码不能为空");
        // 设置请求头为输出图片类型
        CaptchaUtil.setHeader(response);
        // 三个参数分别为宽、高、位数
        //GifCaptcha gifCaptcha = new GifCaptcha(100, 35, 4);
        SpecCaptcha gifCaptcha = new SpecCaptcha(100, 35, 4);
        
        // 设置类型：字母数字混合
        gifCaptcha.setCharType(Captcha.TYPE_DEFAULT);
        // 保存验证码
        validateCodeService.saveValidateCode(deviceId, gifCaptcha.text().toLowerCase());
        // 输出图片流
        gifCaptcha.out(response.getOutputStream());
    }
 
}
