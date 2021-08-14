package org.github.foxnic.web.storage.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 系统文件 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-26 11:05:39
*/

@Controller("SysFilePageController")
@RequestMapping(FilePageController.prefix)
public class FilePageController {
	
	public static final String prefix="business/storage/file";

	/**
	 * 系统文件 功能主页面
	 */
	@RequestMapping("/file_list.html")
	public String list(Model model) {
		return prefix+"/file_list";
	}

	/**
	 * 系统文件 表单页面
	 */
	@RequestMapping("/file_form.html")
	public String form(Model model , String id) {
		return prefix+"/file_form";
	}
}