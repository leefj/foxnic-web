package org.github.foxnic.web.domain.system.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.system.CodeExampleRole;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-15 12:13:19
 * @sign 47C729DE9E5D71611FE1BD93AF0A8B6B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CodeExampleRoleMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleRole,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleRole.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 属主ID , 类型: java.lang.String
	*/
	public static final String EXAMPLE_ID="exampleId";
	
	/**
	 * 属主ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleRole,java.lang.String> EXAMPLE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleRole.class ,EXAMPLE_ID, java.lang.String.class, "属主ID", "属主ID", java.lang.String.class, null);
	
	/**
	 * 角色ID , 类型: java.lang.String
	*/
	public static final String ROLE_ID="roleId";
	
	/**
	 * 角色ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleRole,java.lang.String> ROLE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleRole.class ,ROLE_ID, java.lang.String.class, "角色ID", "角色ID", java.lang.String.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleRole,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleRole.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , EXAMPLE_ID , ROLE_ID , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.CodeExampleRole {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CodeExampleRole setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 属主ID
		 * @param exampleId 属主ID
		 * @return 当前对象
		*/
		public CodeExampleRole setExampleId(String exampleId) {
			super.change(EXAMPLE_ID,super.getExampleId(),exampleId);
			super.setExampleId(exampleId);
			return this;
		}
		
		/**
		 * 设置 角色ID
		 * @param roleId 角色ID
		 * @return 当前对象
		*/
		public CodeExampleRole setRoleId(String roleId) {
			super.change(ROLE_ID,super.getRoleId(),roleId);
			super.setRoleId(roleId);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public CodeExampleRole setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}