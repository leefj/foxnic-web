package com.scientific.tailoring.product.page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import com.scientific.tailoring.product.service.IProductLabelService;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:27
 * 商品标签关系 模版页面
 */

@Controller("PrdProductLabelPageController")
@RequestMapping(ProductLabelPageController.prefix)
public class ProductLabelPageController extends SuperController {
	
	public static final String prefix="pages/product/product_label";

	@Autowired
	private IProductLabelService productLabelService;

	/**
	 * 商品标签关系 功能主页面
	 */
	@RequiresPermissions("PrdProductLabel:page:list")
	@RequestMapping("/product_label_list.html")
	public String list(Model model) {
		return prefix+"/product_label_list";
	}

	/**
	 * 商品标签关系 表单页面
	 */
	@RequiresPermissions("PrdProductLabel:page:form")
	@RequestMapping("/product_label_form.html")
	public String form(Model model) {
		return prefix+"/product_label_form";
	}
}