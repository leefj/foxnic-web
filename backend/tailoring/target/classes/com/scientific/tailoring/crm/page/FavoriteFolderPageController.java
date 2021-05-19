package com.scientific.tailoring.crm.page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.crm.service.IFavoriteFolderService;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:26
 * 商品收藏分类 模版页面
 */

@Controller("CrmFavoriteFolderPageController")
@RequestMapping(FavoriteFolderPageController.prefix)
public class FavoriteFolderPageController extends SuperController {
	
	public static final String prefix="pages/crm/favorite_folder";

	@Autowired
	private IFavoriteFolderService favoriteFolderService;

	/**
	 * 商品收藏分类 功能主页面
	 */
	@RequiresPermissions("CrmFavoriteFolder:page:list")
	@RequestMapping("/favorite_folder_list.html")
	public String list(Model model) {
		return prefix+"/favorite_folder_list";
	}

	/**
	 * 商品收藏分类 表单页面
	 */
	@RequiresPermissions("CrmFavoriteFolder:page:form")
	@RequestMapping("/favorite_folder_form.html")
	public String form(Model model) {
		return prefix+"/favorite_folder_form";
	}
}