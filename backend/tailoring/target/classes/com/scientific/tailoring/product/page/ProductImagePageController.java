package com.scientific.tailoring.product.page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.product.service.IProductImageService;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:27
 * 商品图片 模版页面
 */

@Controller("PrdProductImagePageController")
@RequestMapping(ProductImagePageController.prefix)
public class ProductImagePageController extends SuperController {
	
	public static final String prefix="pages/product/product_image";

	@Autowired
	private IProductImageService productImageService;

	/**
	 * 商品图片 功能主页面
	 */
	@RequiresPermissions("PrdProductImage:page:list")
	@RequestMapping("/product_image_list.html")
	public String list(Model model) {
		return prefix+"/product_image_list";
	}

	/**
	 * 商品图片 表单页面
	 */
	@RequiresPermissions("PrdProductImage:page:form")
	@RequestMapping("/product_image_form.html")
	public String form(Model model) {
		return prefix+"/product_image_form";
	}
}