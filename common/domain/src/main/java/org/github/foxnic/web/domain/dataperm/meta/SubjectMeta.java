package org.github.foxnic.web.domain.dataperm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.dataperm.Subject;
import java.util.Date;
import org.github.foxnic.web.domain.dataperm.SubjectProperty;
import java.util.List;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-30 08:27:46
 * @sign D6588F7919A16E4D6426EE2D6A1294E5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SubjectMeta {
	
	/**
	 * 代码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 代码 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.Subject,java.lang.String> CODE_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.Subject.class ,CODE, java.lang.String.class, "代码", "代码", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.Subject,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.Subject.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.Subject,java.lang.String> TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.Subject.class ,TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.Subject,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.Subject.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.Subject,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.Subject.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.Subject,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.Subject.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.Subject,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.Subject.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.Subject,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.Subject.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.Subject,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.Subject.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.Subject,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.Subject.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.Subject,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.Subject.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 属性列表 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.dataperm.SubjectProperty
	*/
	public static final String PROPERTIES="properties";
	
	/**
	 * 属性列表 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.dataperm.SubjectProperty
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.Subject,org.github.foxnic.web.domain.dataperm.SubjectProperty> PROPERTIES_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.Subject.class ,PROPERTIES, java.util.List.class, "属性列表", "属性列表", org.github.foxnic.web.domain.dataperm.SubjectProperty.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ CODE , NAME , TYPE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , PROPERTIES };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.dataperm.Subject {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 代码
		 * @param code 代码
		 * @return 当前对象
		*/
		public Subject setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public Subject setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public Subject setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Subject setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Subject setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Subject setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Subject setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Subject setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Subject setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Subject setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Subject setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 属性列表
		 * @param properties 属性列表
		 * @return 当前对象
		*/
		public Subject setProperties(List<SubjectProperty> properties) {
			super.change(PROPERTIES,super.getProperties(),properties);
			super.setProperties(properties);
			return this;
		}
	}
}