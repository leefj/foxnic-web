package com.scientific.tailoring.product.page;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import com.scientific.tailoring.product.service.IProductFabricService;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:27
 * 商品面料关系 模版页面
 */

@Controller("PrdProductFabricPageController")
@RequestMapping(ProductFabricPageController.prefix)
public class ProductFabricPageController extends SuperController {
	
	public static final String prefix="pages/product/product_fabric";

	@Autowired
	private IProductFabricService productFabricService;

	/**
	 * 商品面料关系 功能主页面
	 */
	@RequiresPermissions("PrdProductFabric:page:list")
	@RequestMapping("/product_fabric_list.html")
	public String list(Model model,String productId,HttpServletRequest request) {
		model.addAttribute("productId", productId);
		return prefix+"/product_fabric_list";
	}

	/**
	 * 商品面料关系 表单页面
	 */
	@RequiresPermissions("PrdProductFabric:page:form")
	@RequestMapping("/product_fabric_form.html")
	public String form(Model model) {
		return prefix+"/product_fabric_form";
	}
}