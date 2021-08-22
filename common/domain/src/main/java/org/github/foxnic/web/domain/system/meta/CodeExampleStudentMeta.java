package org.github.foxnic.web.domain.system.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.system.CodeExampleStudent;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-22 08:53:44
 * @sign 34A6DC6B3AD32F6CD23568A0F7DE3FC8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CodeExampleStudentMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleStudent,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleStudent.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 属主ID , 类型: java.lang.String
	*/
	public static final String EXAMPLE_ID="exampleId";
	
	/**
	 * 属主ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleStudent,java.lang.String> EXAMPLE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleStudent.class ,EXAMPLE_ID, java.lang.String.class, "属主ID", "属主ID", java.lang.String.class, null);
	
	/**
	 * 学生姓名 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 学生姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleStudent,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleStudent.class ,NAME, java.lang.String.class, "学生姓名", "学生姓名", java.lang.String.class, null);
	
	/**
	 * 年龄 , 类型: java.lang.String
	*/
	public static final String AGE="age";
	
	/**
	 * 年龄 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleStudent,java.lang.String> AGE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleStudent.class ,AGE, java.lang.String.class, "年龄", "年龄", java.lang.String.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleStudent,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleStudent.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , EXAMPLE_ID , NAME , AGE , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.CodeExampleStudent {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CodeExampleStudent setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 属主ID
		 * @param exampleId 属主ID
		 * @return 当前对象
		*/
		public CodeExampleStudent setExampleId(String exampleId) {
			super.change(EXAMPLE_ID,super.getExampleId(),exampleId);
			super.setExampleId(exampleId);
			return this;
		}
		
		/**
		 * 设置 学生姓名
		 * @param name 学生姓名
		 * @return 当前对象
		*/
		public CodeExampleStudent setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 年龄
		 * @param age 年龄
		 * @return 当前对象
		*/
		public CodeExampleStudent setAge(String age) {
			super.change(AGE,super.getAge(),age);
			super.setAge(age);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public CodeExampleStudent setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}