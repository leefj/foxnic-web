package org.github.foxnic.web.system.page;

import org.github.foxnic.web.framework.view.controller.ViewController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 系统配置表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-15 17:25:48
*/

@Controller("LayUIPageController")
@RequestMapping(LayUIPageController.prefix)
public class LayUIPageController extends ViewController  {

	public static final String prefix="business/system/layui";

	/**
	 * 系统配置 表单页面
	 */
	@RequestMapping("/table_custom_dialog.html")
	public String login(Model model) {
		//
		return prefix+"/table_custom_dialog";
	}
}
