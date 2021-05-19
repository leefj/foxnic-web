package com.tailoring.generator.constants;

import java.util.List;
import java.util.Map;

import com.github.foxnic.commons.code.JavaClassFile;
import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.commons.project.maven.MavenProject;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.generatorV2.builder.constants.EnumClassFile;
import com.github.foxnic.generatorV2.config.EnumConfig;
import com.github.foxnic.sql.entity.naming.DefaultNameConvertor;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.scientific.tailoring.constants.db.Tailoring.SYS_CONFIG;
import com.scientific.tailoring.constants.db.Tailoring.SYS_DICT;
import com.scientific.tailoring.constants.db.Tailoring.SYS_DICT_ITEM;
import com.scientific.tailoring.constants.db.Tailoring.SYS_ROLE;
import com.tailoring.generator.config.Configs;
import com.tailoring.generator.config.ProjectConstants;

/**
 * 为以usr_开头的表生成代码
 */
public class EnumGenerator  {
	
	DefaultNameConvertor nc=new DefaultNameConvertor();
 
	
	
	public static void main(String[] args) throws Exception {
		EnumGenerator g = new EnumGenerator();
	 
		g.buildEnums();

		//
	}
	
	private Configs configs;
	private DAO dao;
	
	public EnumGenerator() {
		this.configs=new Configs();
		this.dao=this.configs.getDAO();
	}

 
	/**
	 * 生成DBMeta数据
	 * */
	private void buildEnums() {
		 
		
		
		//系统配置 sys_config
		EnumConfig info=new EnumConfig(SYS_CONFIG.CODE,SYS_CONFIG.NAME , new ConditionExpr("deleted=0"));
		new EnumClassFile(dao,configs.getDomianProject(),info,ProjectConstants.DOMAIN_CONSTANTS_PACKAGE,"SystemEnum").save(true);
		
		//字典 sys_dict
		info=new EnumConfig(SYS_DICT.CODE, SYS_DICT.NAME , new ConditionExpr("deleted=0"));
		new EnumClassFile(dao,configs.getDomianProject(),info,ProjectConstants.DOMAIN_CONSTANTS_PACKAGE,"DictEnum").save(true);
		
		//生成字典枚举
		RcdSet rs=dao.query("select * from sys_dict_item where deleted=0 order by dict_code,sort asc");
		Map<String,List<Rcd>> gps=rs.getGroupedMap(SYS_DICT_ITEM.DICT_CODE,String.class);
		for (String dictCode : gps.keySet()) {
			List<Rcd> g=gps.get(dictCode);
			String clsName=nc.getClassName(dictCode, 0);
			new DictItemBuilder(configs.getDomianProject(),ProjectConstants.DOMAIN_CONSTANTS_PACKAGE, clsName, g).save(true);
		}
		
		//角色 sys_role
		info=new EnumConfig(SYS_ROLE.CODE, SYS_ROLE.NAME , new ConditionExpr("deleted=0"));
		new EnumClassFile(dao,configs.getDomianProject(),info,ProjectConstants.DOMAIN_CONSTANTS_PACKAGE,"RoleEnum").save(true);

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
		code.ln(" * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。");
		code.ln("*/");
		code.ln("");
		
		code.ln("public enum "+this.getSimpleName()+" {");
			 
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
		
		addJavaDoc(1,"从字符串转换成当前枚举类型，使用 valueOf 方法可能导致偏差，建议不要使用");
		code.ln(1,"public static "+this.getSimpleName()+" parse(String code) {");
		code.ln(2,"for ("+this.getSimpleName()+" dn : "+this.getSimpleName()+".values()) {");
		code.ln(3,"if(code.equals(dn.code())) return dn;");
		code.ln(2,"}");
		code.ln(2,"return null;");
		code.ln(1,"}");
		
		code.ln("}");
 
	}
 
}
