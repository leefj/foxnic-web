package com.scientific.tailoring.order.page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import com.scientific.tailoring.order.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;

import javax.servlet.http.HttpServletRequest;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:28
 * 订单商品关系 模版页面
 */

@Controller("OdrProductPageController")
@RequestMapping(ProductPageController.prefix)
public class ProductPageController extends SuperController {
	
	public static final String prefix="pages/order/product";

	@Autowired
	private IProductService productService;

	/**
	 * 订单商品关系 功能主页面
	 */
	@RequiresPermissions("OdrProduct:page:list")
	@RequestMapping("/product_list.html")
	public String list(Model model, String orderId, HttpServletRequest request) {
		model.addAttribute("orderId", orderId);
		return prefix+"/product_list";
	}

	/**
	 * 订单商品关系 表单页面
	 */
	@RequiresPermissions("OdrProduct:page:form")
	@RequestMapping("/product_form.html")
	public String form(Model model) {
		return prefix+"/product_form";
	}
}