package com.scientific.tailoring.order.page;
import com.scientific.tailoring.order.service.IOrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;


/**
 * @author 李方捷
 * @since 2021-04-15 01:58:23
 * 订单 模版页面
 */

@Controller("OdrOrderPageController")
@RequestMapping(OrderPageController.prefix)
public class OrderPageController extends SuperController {
	
	public static final String prefix="pages/order/order";

	@Autowired
	private IOrderService orderService;

	/**
	 * 订单 功能主页面
	 */
	@RequiresPermissions("OdrOrder:page:list")
	@RequestMapping("/order_list.html")
	public String list(Model model) {
		return prefix+"/order_list";
	}

	/**
	 * 订单 表单页面
	 */
	@RequiresPermissions("OdrOrder:page:form")
	@RequestMapping("/order_form.html")
	public String form(Model model) {
		return prefix+"/order_form";
	}
}