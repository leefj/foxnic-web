package org.github.foxnic.web.generator.module.example;

import com.github.foxnic.api.query.MatchType;
import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.config.ActionConfig;
import com.github.foxnic.generator.builder.view.config.Tab;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.ExampleTables.*;
import org.github.foxnic.web.constants.enums.DictEnum;
import org.github.foxnic.web.constants.enums.dict.Sex;
import org.github.foxnic.web.constants.enums.system.Language;
import org.github.foxnic.web.constants.enums.system.MenuType;
import org.github.foxnic.web.constants.enums.system.SystemConfigType;
import org.github.foxnic.web.domain.oauth.Resourze;
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.oauth.meta.ResourzeMeta;
import org.github.foxnic.web.domain.oauth.meta.RoleMeta;
import org.github.foxnic.web.domain.system.meta.CodeExampleMeta;
import org.github.foxnic.web.domain.system.meta.CodeExampleVOMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.proxy.oauth.ResourzeServiceProxy;
import org.github.foxnic.web.proxy.oauth.RoleServiceProxy;
import org.github.foxnic.web.system.service.ICodeExampleRoleService;


public class ExampleNewsConfig extends BaseCodeConfig<EXAMPLE_NEWS> {



	/**
	 * 配置模型，为 po 和 vo 添加 额外的属性等
	 * */
	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {

	}

	/**
	 * 配置字段
	 * */
	@Override
	public void configFields(ViewOptions view) {

		view.field(EXAMPLE_NEWS.CONTENT).form().textArea();

	}

	/**
	 * 配置源码覆盖
	 * */
	@Override
	public void configOverrides() {
		//文件生成覆盖模式
		context.overrides()
			.setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
			.setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
			.setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
			.setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
			.setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
			.setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS);
	}

	/**
	 * 配置服务代码
	 * */
	@Override
	public void configService(ServiceOptions service) {

	}


	/**
	 * 配置 List 表格
	 * */
	@Override
	public void configList(ViewOptions view,ListOptions list) {

	}

	/**
	 * 配置表单
	 * */
	@Override
	public void configForm(ViewOptions view,FormOptions form) {

	}

	/**
	 * 配置搜索
	 * */
	@Override
	public void configSearch(ViewOptions view,SearchAreaOptions search) {

	}


	public ExampleNewsConfig() {
		super("service-example",EXAMPLE_NEWS.$TABLE,"example_", 3);
	}




}
