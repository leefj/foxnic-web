package com.scientific.tailoring.order.page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import com.scientific.tailoring.order.service.IMeasureDataService;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:28
 * 测量数据发聩 模版页面
 */

@Controller("OdrMeasureDataPageController")
@RequestMapping(MeasureDataPageController.prefix)
public class MeasureDataPageController extends SuperController {
	
	public static final String prefix="pages/order/measure_data";

	@Autowired
	private IMeasureDataService measureDataService;

	/**
	 * 测量数据发聩 功能主页面
	 */
	@RequiresPermissions("OdrMeasureData:page:list")
	@RequestMapping("/measure_data_list.html")
	public String list(Model model) {
		return prefix+"/measure_data_list";
	}

	/**
	 * 测量数据发聩 表单页面
	 */
	@RequiresPermissions("OdrMeasureData:page:form")
	@RequestMapping("/measure_data_form.html")
	public String form(Model model) {
		return prefix+"/measure_data_form";
	}
}