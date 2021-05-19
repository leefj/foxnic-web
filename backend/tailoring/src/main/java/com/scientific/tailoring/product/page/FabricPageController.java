package com.scientific.tailoring.product.page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.scientific.tailoring.product.service.IFabricService;
import com.github.foxnic.springboot.mvc.Result;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:27
 * 面料 模版页面
 */

@Controller("PrdFabricPageController")
@RequestMapping(FabricPageController.prefix)
public class FabricPageController extends SuperController {
	
	public static final String prefix="pages/product/fabric";

	@Autowired
	private IFabricService fabricService;

	/**
	 * 面料 功能主页面
	 */
	@RequiresPermissions("PrdFabric:page:list")
	@RequestMapping("/fabric_list.html")
	public String list(Model model) {
		return prefix+"/fabric_list";
	}

	/**
	 * 面料 表单页面
	 */
	@RequiresPermissions("PrdFabric:page:form")
	@RequestMapping("/fabric_form.html")
	public String form(Model model) {
		return prefix+"/fabric_form";
	}
}