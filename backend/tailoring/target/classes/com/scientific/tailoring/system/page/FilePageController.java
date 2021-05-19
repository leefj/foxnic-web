package com.scientific.tailoring.system.page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.scientific.tailoring.system.service.IFileService;
import com.github.foxnic.springboot.mvc.Result;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:25
 * 系统文件 模版页面
 */

@Controller("SysFilePageController")
@RequestMapping(FilePageController.prefix)
public class FilePageController extends SuperController {
	
	public static final String prefix="pages/system/file";

	@Autowired
	private IFileService fileService;

	/**
	 * 系统文件 功能主页面
	 */
	@RequiresPermissions("SysFile:page:list")
	@RequestMapping("/file_list.html")
	public String list(Model model) {
		return prefix+"/file_list";
	}

	/**
	 * 系统文件 表单页面
	 */
	@RequiresPermissions("SysFile:page:form")
	@RequestMapping("/file_form.html")
	public String form(Model model) {
		return prefix+"/file_form";
	}
}