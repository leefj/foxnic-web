package org.github.foxnic.web.constants.enums.system;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.entity.Entity;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Position;
import org.github.foxnic.web.domain.oauth.User;

/**
 * 对系统内出现的人员或人员集合进行分类
 * */
public enum UnifiedUserType implements CodeTextEnum {

	user("账户", User.class),
	sys_role("功能角色", org.github.foxnic.web.domain.oauth.Role.class),
	employee("员工", Employee.class),
	position("岗位", Position.class),
	busi_role("业务角色", org.github.foxnic.web.domain.bpm.Role.class);

	private Class<? extends Entity> entityType;
	private String text;


	private UnifiedUserType(String text,Class<? extends Entity> entityType)  {
		this.entityType=entityType;
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public Class<? extends Entity> getEntityType() {
		return entityType;
	}

	public static UnifiedUserType parseByCode(String code) {
		return (UnifiedUserType) EnumUtil.parseByCode(UnifiedUserType.values(),code);
	}

}
