package com.scientific.tailoring.system.page;
import com.scientific.tailoring.system.service.IAreaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:25
 * 区域 模版页面
 */

@Controller("SysAreaPageController")
@RequestMapping(AreaPageController.prefix)
public class AreaPageController extends SuperController {
	
	public static final String prefix="pages/system/area";

	@Autowired
	private IAreaService areaService;

	/**
	 * 区域 功能主页面
	 */
	@RequiresPermissions("SysArea:page:list")
	@RequestMapping("/area_list.html")
	public String list(Model model) {
		return prefix+"/area_list";
	}

	/**
	 * 区域 表单页面
	 */
	@RequiresPermissions("SysArea:page:form")
	@RequestMapping("/area_form.html")
	public String form(Model model) {
		return prefix+"/area_form";
	}
}