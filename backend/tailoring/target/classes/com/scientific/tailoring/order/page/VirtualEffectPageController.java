package com.scientific.tailoring.order.page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.order.service.IVirtualEffectService;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:29
 * 虚拟效果视频展示 模版页面
 */

@Controller("OdrVirtualEffectPageController")
@RequestMapping(VirtualEffectPageController.prefix)
public class VirtualEffectPageController extends SuperController {
	
	public static final String prefix="pages/order/virtual_effect";

	@Autowired
	private IVirtualEffectService virtualEffectService;

	/**
	 * 虚拟效果视频展示 功能主页面
	 */
	@RequiresPermissions("OdrVirtualEffect:page:list")
	@RequestMapping("/virtual_effect_list.html")
	public String list(Model model) {
		return prefix+"/virtual_effect_list";
	}

	/**
	 * 虚拟效果视频展示 表单页面
	 */
	@RequiresPermissions("OdrVirtualEffect:page:form")
	@RequestMapping("/virtual_effect_form.html")
	public String form(Model model) {
		return prefix+"/virtual_effect_form";
	}
}