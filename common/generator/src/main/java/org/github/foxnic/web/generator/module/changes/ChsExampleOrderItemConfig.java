package org.github.foxnic.web.generator.module.changes;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.CHS_EXAMPLE_ORDER_ITEM;
import org.github.foxnic.web.generator.module.BaseCodeConfig;


public class ChsExampleOrderItemConfig extends BaseCodeConfig<CHS_EXAMPLE_ORDER_ITEM> {

	public ChsExampleOrderItemConfig() {
		super(PREFIX_CHANGES,CHS_EXAMPLE_ORDER_ITEM.$TABLE,"chs_", 3);
	}

	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {

	}

	@Override
	public void configFields(ViewOptions view) {

	}

	@Override
	public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
		form.columnLayout(new Object[]{
				CHS_EXAMPLE_ORDER_ITEM.PRODUCT_NAME,CHS_EXAMPLE_ORDER_ITEM.PRICE,CHS_EXAMPLE_ORDER_ITEM.QUANTITY
		});
	}

	@Override
	public void configList(ViewOptions view, ListOptions list) {
		list.disableMargin();
		list.columnLayout(CHS_EXAMPLE_ORDER_ITEM.PRODUCT_NAME,CHS_EXAMPLE_ORDER_ITEM.PRICE,CHS_EXAMPLE_ORDER_ITEM.QUANTITY);
	}

	@Override
	public void configSearch(ViewOptions view, SearchAreaOptions search) {
		search.disable();
	}

	@Override
	public void configOverrides() {

		//文件生成覆盖模式
		context.overrides()
			.setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
			.setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
			.setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
			.setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
			.setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
			.setExtendJsFile(WriteMode.COVER_EXISTS_FILE);

	}

}
