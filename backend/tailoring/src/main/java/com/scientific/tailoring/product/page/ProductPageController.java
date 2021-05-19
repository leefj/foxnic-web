package com.scientific.tailoring.product.page;
import com.scientific.tailoring.product.service.IProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:27
 * 商品 模版页面
 */

@Controller("PrdProductPageController")
@RequestMapping(ProductPageController.prefix)
public class ProductPageController extends SuperController {
	
	public static final String prefix="pages/product/product";

	@Autowired
	private IProductService productService;

	/**
	 * 商品 功能主页面
	 */
	@RequiresPermissions("PrdProduct:page:list")
	@RequestMapping("/product_list.html")
	public String list(Model model) {
		return prefix+"/product_list";
	}

	/**
	 * 商品 表单页面
	 */
	@RequiresPermissions("PrdProduct:page:form")
	@RequestMapping("/product_form.html")
	public String form(Model model) {
		return prefix+"/product_form";
	}
}