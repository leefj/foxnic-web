package com.scientific.tailoring.system.page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import com.scientific.tailoring.system.service.IDictService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:24
 * 数据字典 模版页面
 */

@Controller("SysDictPageController")
@RequestMapping(DictPageController.prefix)
public class DictPageController extends SuperController {
	
	public static final String prefix="pages/system/dict";

	@Autowired
	private IDictService dictService;

	/**
	 * 数据字典 功能主页面
	 */
	@RequiresPermissions("SysDict:page:list")
	@RequestMapping("/dict_list.html")
	public String list(Model model) {
		return prefix+"/dict_list";
	}

	/**
	 * 数据字典 表单页面
	 */
	@RequiresPermissions("SysDict:page:form")
	@RequestMapping("/dict_form.html")
	public String form(Model model) {
		return prefix+"/dict_form";
	}
}