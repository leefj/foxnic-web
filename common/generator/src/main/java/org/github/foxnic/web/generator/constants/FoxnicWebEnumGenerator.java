package org.github.foxnic.web.generator.constants;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.code.JavaClassFile;
import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.commons.project.maven.MavenProject;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.generator.builder.constants.EnumClassFile;
import com.github.foxnic.generator.config.EnumConfig;
import com.github.foxnic.generator.config.GlobalSettings;
import com.github.foxnic.sql.entity.naming.DefaultNameConvertor;
import com.github.foxnic.sql.expr.ConditionExpr;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_CONFIG;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_DICT;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_DICT_ITEM;
import org.github.foxnic.web.generator.config.FoxnicWebConfigs;

import java.util.List;
import java.util.Map;

public class FoxnicWebEnumGenerator  {

	DefaultNameConvertor nc=new DefaultNameConvertor();

	/**
	 * 运行main函数生成代码
	 * */
	public static void main(String[] args) throws Exception {
		FoxnicWebEnumGenerator g = new FoxnicWebEnumGenerator();
		g.buildEnums();
	}

	private FoxnicWebConfigs configs;
	private DAO dao;

	public FoxnicWebEnumGenerator() {
		this.configs=new FoxnicWebConfigs("service-system");
		this.dao=this.configs.getDAO();
	}


	/**
	 * 生成DBMeta数据
	 * */
	private void buildEnums() {

		String dcp=this.configs.getProjectConfigs().getDomainConstantsPackage();

		//系统配置 sys_config
		EnumConfig info=new EnumConfig(SYS_CONFIG.CODE,SYS_CONFIG.NAME , new ConditionExpr("deleted=0 and code not like 'EAM_%' and code not like 'OPS_%'"));
		new EnumClassFile(dao,configs.getDomainProject(),info,dcp,"SystemConfigEnum").save(true);

		//字典 sys_dict
		info=new EnumConfig(SYS_DICT.CODE, SYS_DICT.NAME , new ConditionExpr("deleted=0 and module in ('system','hrm','463397133957988352')"));
		new EnumClassFile(dao,configs.getDomainProject(),info,dcp,"DictEnum").save(true);

		//生成字典枚举
		RcdSet rs=dao.query("select * from sys_dict_item where deleted=0 and dict_id in (select id from sys_dict where deleted=0 and module in ('system','hrm','463397133957988352') ) order by dict_code,sort asc");
		Map<String,List<Rcd>> gps=rs.getGroupedMap(SYS_DICT_ITEM.DICT_CODE,String.class);
		for (String dictCode : gps.keySet()) {
			List<Rcd> g=gps.get(dictCode);
			String clsName=nc.getClassName(dictCode, 0);
			new DictItemBuilder(configs.getDomainProject(),dcp, clsName, g).save(true);
		}

		//角色 sys_role
//		info=new EnumConfig(SYS_ROLE.CODE, SYS_ROLE.NAME , new ConditionExpr("deleted=0"));
//		new EnumClassFile(dao,configs.getDomianProject(),info,dcp,"RoleEnum").save(true);

	}

}





class DictItemBuilder extends JavaClassFile {

	private List<Rcd> items;

	public DictItemBuilder(MavenProject domainProject,String domainConstsPackage,String className,List<Rcd> items) {
		super(domainProject, domainConstsPackage+".enums.dict", className);
		this.items=items;
	}

	protected void buildBody() {

		//加入注释
		code.ln("/**");
		code.ln(" * @since "+DateUtil.getFormattedTime(false));
		code.ln(" * @author "+GlobalSettings.instance().getAuthor());
		code.ln(" * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。");
		code.ln("*/");
		code.ln("");

		this.addImport(CodeTextEnum.class);

		code.ln("public enum "+this.getSimpleName()+"  implements CodeTextEnum {");

		for (Rcd r : items) {
			String name=r.getString(SYS_DICT_ITEM.CODE);
			name=name.replace('.', '_');
			String text=r.getString(SYS_DICT_ITEM.LABEL);
			addJavaDoc(1,text);
			code.ln(1,name.trim().toUpperCase()+"(\""+name+"\" , \""+text+"\"),");
		}
		code.ln(1,";");

		code.ln(1,"");
		code.ln(1,"private String code;");
		code.ln(1,"private String text;");
		code.ln(1,"private "+this.getSimpleName()+"(String code,String text)  {");
		code.ln(2,"this.code=code;");
		code.ln(2,"this.text=text;");
		code.ln(1,"}");

		code.ln(1,"");
		code.ln(1,"public String code() {");
		code.ln(2,"return code;");
		code.ln(1,"}");

		code.ln(1,"");
		code.ln(1,"public String text() {");
		code.ln(2,"return text;");
		code.ln(1,"}");

		addJavaDoc(1,"从字符串转换成当前枚举类型");
		code.ln(1,"public static "+this.getSimpleName()+" parseByCode(String code) {");
		code.ln(2,"return ("+this.getSimpleName()+") EnumUtil.parseByCode("+this.getSimpleName()+".values(),code);");
		code.ln(1,"}");
		code.ln("}");

		this.addImport(EnumUtil.class);

	}

}
