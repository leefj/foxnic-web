package org.github.foxnic.web.constants.enums.system;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 资源访问控制类型
 * */
public enum CommonAction implements CodeTextEnum {
	CREATE("创建"),
	RETRIEVE("检索"),
	UPDATE("更新"),
	DELETE("删除"),
	DEPLOY("部署"),
	AUDIT("审核");
	private String text;

	private CommonAction(String text) {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return this.text;
	}

	@Override
	public String description() {
		return this.text;
	}

	public static CommonAction parseByCode(String code) {
		return (CommonAction) EnumUtil.parseByCode(CommonAction.values(),code);
	}
}
