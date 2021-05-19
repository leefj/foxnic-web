package com.scientific.tailoring.order.page;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import com.scientific.tailoring.order.service.IMeasureService;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:28
 * 订单测量信息 模版页面
 */

@Controller("OdrMeasurePageController")
@RequestMapping(MeasurePageController.prefix)
public class MeasurePageController extends SuperController {
	
	public static final String prefix="pages/order/measure";

	@Autowired
	private IMeasureService measureService;

	/**
	 * 订单测量信息 功能主页面
	 */
	@RequiresPermissions("OdrMeasure:page:list")
	@RequestMapping("/measure_list.html")
	public String list(Model model, String orderId, HttpServletRequest request) {
		model.addAttribute("orderId", orderId);
		return prefix+"/measure_list";
	}

	/**
	 * 订单测量信息 表单页面
	 */
	@RequiresPermissions("OdrMeasure:page:form")
	@RequestMapping("/measure_form.html")
	public String form(Model model) {
		return prefix+"/measure_form";
	}
}