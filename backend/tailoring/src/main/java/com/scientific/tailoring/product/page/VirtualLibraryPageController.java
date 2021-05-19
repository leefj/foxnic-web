package com.scientific.tailoring.product.page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.product.service.IVirtualLibraryService;


/**
 * @author 李方捷
 * @since 2021-04-08 03:46:44
 * 虚拟试衣 模版页面
 */

@Controller("PrdVirtualLibraryPageController")
@RequestMapping(VirtualLibraryPageController.prefix)
public class VirtualLibraryPageController extends SuperController {
	
	public static final String prefix="pages/product/virtual_library";

	@Autowired
	private IVirtualLibraryService virtualLibraryService;

	/**
	 * 虚拟试衣 功能主页面
	 */
	@RequiresPermissions("PrdVirtualLibrary:page:list")
	@RequestMapping("/virtual_library_list.html")
	public String list(Model model) {
		return prefix+"/virtual_library_list";
	}

	/**
	 * 虚拟试衣 表单页面
	 */
	@RequiresPermissions("PrdVirtualLibrary:page:form")
	@RequestMapping("/virtual_library_form.html")
	public String form(Model model) {
		return prefix+"/virtual_library_form";
	}
}