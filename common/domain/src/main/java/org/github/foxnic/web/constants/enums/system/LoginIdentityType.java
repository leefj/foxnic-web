package org.github.foxnic.web.constants.enums.system;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.sql.expr.Expr;
import com.github.foxnic.sql.expr.SQL;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.constants.db.FoxnicWeb.HRM_EMPLOYEE;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_USER;

/**
 * 对系统内出现的人员或人员集合进行分类
 * */
public enum LoginIdentityType implements CodeTextEnum {

	user_id("账户ID", SYS_USER.ID),
	user_account("账户",SYS_USER.ACCOUNT),
	user_phone("账户手机号",SYS_USER.PHONE),
	employee_badge("员工工号", HRM_EMPLOYEE.BADGE) {
		@Override
		public SQL getQuerySQL(String fields, String identity) {
			return this.getEmployeeQuerySQL(fields,identity);
		}
	};

	public static final String USER_TABLE_ALIAS="u";

	public static final String IDENTITY_TYPE_FIELD="identity_type";

	private static final String BASIC_EMPLOYEE_SQL= SQL.joinSQLs(
			"select {{fields}} from sys_user u",
			"join sys_user_tenant ut on u.id=ut.user_id",
			"join sys_tenant t on ut.owner_tenant_id=t.id",
			"join hrm_company c on t.company_id=c.id ",
			"join hrm_employee e on e.id=ut.employee_id and e.tenant_id=ut.owner_tenant_id and e.company_id=c.id",
			"where u.deleted=0 and u.valid=1 ",
			"and ut.deleted=0 and ut.activated=1 ",
			"and t.deleted=0 and t.valid=1",
			"and c.deleted=0 and c.valid=1",
			"and e.deleted=0 "
	);



	private String text;
	private DBField identityField;
	private LoginIdentityType(String text,DBField identityField)  {
		this.text=text;
		this.identityField=identityField;
	}

	public DBField getIdentityField() {
		return identityField;
	}

	public SQL getQuerySQL(String fields, String identity) {
		return new Expr("select ? "+IDENTITY_TYPE_FIELD+","+fields+" from sys_user "+USER_TABLE_ALIAS+" where "+identityField.name()+"=? and deleted=0 and valid=1",this.code(),identity);
	}

	protected SQL getEmployeeQuerySQL(String fields, String identity) {
		return new Expr(BASIC_EMPLOYEE_SQL.replace("{{fields}}","? "+IDENTITY_TYPE_FIELD+","+fields)+" and e."+this.getIdentityField().name()+"=?",this.code(),identity);
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public static LoginIdentityType parseByCode(String code) {
		return (LoginIdentityType) EnumUtil.parseByCode(LoginIdentityType.values(),code);
	}

}
