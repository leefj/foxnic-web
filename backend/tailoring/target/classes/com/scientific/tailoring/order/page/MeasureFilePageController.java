package com.scientific.tailoring.order.page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.scientific.tailoring.order.service.IMeasureFileService;
import com.github.foxnic.springboot.mvc.Result;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:28
 * 测量文件采集 模版页面
 */

@Controller("OdrMeasureFilePageController")
@RequestMapping(MeasureFilePageController.prefix)
public class MeasureFilePageController extends SuperController {
	
	public static final String prefix="pages/order/measure_file";

	@Autowired
	private IMeasureFileService measureFileService;

	/**
	 * 测量文件采集 功能主页面
	 */
	@RequiresPermissions("OdrMeasureFile:page:list")
	@RequestMapping("/measure_file_list.html")
	public String list(Model model) {
		return prefix+"/measure_file_list";
	}

	/**
	 * 测量文件采集 表单页面
	 */
	@RequiresPermissions("OdrMeasureFile:page:form")
	@RequestMapping("/measure_file_form.html")
	public String form(Model model) {
		return prefix+"/measure_file_form";
	}
}