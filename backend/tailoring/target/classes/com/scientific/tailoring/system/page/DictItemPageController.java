package com.scientific.tailoring.system.page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.system.service.IDictItemService;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:24
 * 数据字典条目 模版页面
 */

@Controller("SysDictItemPageController")
@RequestMapping(DictItemPageController.prefix)
public class DictItemPageController extends SuperController {
	
	public static final String prefix="pages/system/dict_item";

	@Autowired
	private IDictItemService dictItemService;

	/**
	 * 数据字典条目 功能主页面
	 */
	@RequiresPermissions("SysDictItem:page:list")
	@RequestMapping("/dict_item_list.html")
	public String list(Model model) {
		return prefix+"/dict_item_list";
	}

	/**
	 * 数据字典条目 表单页面
	 */
	@RequiresPermissions("SysDictItem:page:form")
	@RequestMapping("/dict_item_form.html")
	public String form(Model model) {
		return prefix+"/dict_item_form";
	}
}