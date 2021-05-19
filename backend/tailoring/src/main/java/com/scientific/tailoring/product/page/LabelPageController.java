package com.scientific.tailoring.product.page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.scientific.tailoring.product.service.ILabelService;
import com.github.foxnic.springboot.mvc.Result;


/**
 * @author 李方捷
 * @since 2021-04-02 02:59:28
 * 产品标签 模版页面
 */

@Controller("PrdLabelPageController")
@RequestMapping(LabelPageController.prefix)
public class LabelPageController extends SuperController {
	
	public static final String prefix="pages/product/label";

	@Autowired
	private ILabelService labelService;

	/**
	 * 产品标签 功能主页面
	 */
	@RequiresPermissions("PrdLabel:page:list")
	@RequestMapping("/label_list.html")
	public String list(Model model) {
		return prefix+"/label_list";
	}

	/**
	 * 产品标签 表单页面
	 */
	@RequiresPermissions("PrdLabel:page:form")
	@RequestMapping("/label_form.html")
	public String form(Model model) {
		return prefix+"/label_form";
	}
}