package com.scientific.tailoring.crm.page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import com.scientific.tailoring.crm.service.IFavoriteProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;


/**
 * @author 李方捷
 * @since 2021-04-15 01:33:21
 * 商品收藏 模版页面
 */

@Controller("CrmFavoriteProductPageController")
@RequestMapping(FavoriteProductPageController.prefix)
public class FavoriteProductPageController extends SuperController {
	
	public static final String prefix="pages/crm/favorite_product";

	@Autowired
	private IFavoriteProductService favoriteProductService;

	/**
	 * 商品收藏 功能主页面
	 */
	@RequiresPermissions("CrmFavoriteProduct:page:list")
	@RequestMapping("/favorite_product_list.html")
	public String list(Model model) {
		return prefix+"/favorite_product_list";
	}

	/**
	 * 商品收藏 表单页面
	 */
	@RequiresPermissions("CrmFavoriteProduct:page:form")
	@RequestMapping("/favorite_product_form.html")
	public String form(Model model) {
		return prefix+"/favorite_product_form";
	}
}