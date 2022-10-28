package org.github.foxnic.web.domain.system.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.system.Config;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:38:48
 * @sign 27EBC9E6C100042BE51E6D0BFBBA68AE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ConfigMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Config,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Config.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * Profile , Profile Id , 类型: java.lang.String
	*/
	public static final String PROFILE_ID="profileId";
	
	/**
	 * Profile , Profile Id , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Config,java.lang.String> PROFILE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Config.class ,PROFILE_ID, java.lang.String.class, "Profile", "Profile Id", java.lang.String.class, null);
	
	/**
	 * 分类代码 , 关联 sys_config_catalog 数据字典 , 类型: java.lang.String
	*/
	public static final String CATALOG_CODE="catalogCode";
	
	/**
	 * 分类代码 , 关联 sys_config_catalog 数据字典 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Config,java.lang.String> CATALOG_CODE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Config.class ,CATALOG_CODE, java.lang.String.class, "分类代码", "关联 sys_config_catalog 数据字典", java.lang.String.class, null);
	
	/**
	 * 配置键 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 配置键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Config,java.lang.String> CODE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Config.class ,CODE, java.lang.String.class, "配置键", "配置键", java.lang.String.class, null);
	
	/**
	 * 配置名 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 配置名 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Config,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Config.class ,NAME, java.lang.String.class, "配置名", "配置名", java.lang.String.class, null);
	
	/**
	 * 数据类型 , 由开发人员在库中指定，包括 String,Integer,DateTime,Double,Enum,Dict , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 数据类型 , 由开发人员在库中指定，包括 String,Integer,DateTime,Double,Enum,Dict , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Config,java.lang.String> TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Config.class ,TYPE, java.lang.String.class, "数据类型", "由开发人员在库中指定，包括 String,Integer,DateTime,Double,Enum,Dict", java.lang.String.class, null);
	
	/**
	 * 类型描述 , 类型: java.lang.String
	*/
	public static final String TYPE_DESC="typeDesc";
	
	/**
	 * 类型描述 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Config,java.lang.String> TYPE_DESC_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Config.class ,TYPE_DESC, java.lang.String.class, "类型描述", "类型描述", java.lang.String.class, null);
	
	/**
	 * 配置值 , 类型: java.lang.String
	*/
	public static final String VALUE="value";
	
	/**
	 * 配置值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Config,java.lang.String> VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Config.class ,VALUE, java.lang.String.class, "配置值", "配置值", java.lang.String.class, null);
	
	/**
	 * 是否生效 , 类型: java.lang.Integer
	*/
	public static final String VALID="valid";
	
	/**
	 * 是否生效 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Config,java.lang.Integer> VALID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Config.class ,VALID, java.lang.Integer.class, "是否生效", "是否生效", java.lang.Integer.class, null);
	
	/**
	 * 说明 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Config,java.lang.String> NOTES_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Config.class ,NOTES, java.lang.String.class, "说明", "说明", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Config,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Config.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Config,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Config.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Config,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Config.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Config,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Config.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Config,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Config.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Config,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Config.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Config,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Config.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Config,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Config.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PROFILE_ID , CATALOG_CODE , CODE , NAME , TYPE , TYPE_DESC , VALUE , VALID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.Config {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Config setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 Profile
		 * @param profileId Profile
		 * @return 当前对象
		*/
		public Config setProfileId(String profileId) {
			super.change(PROFILE_ID,super.getProfileId(),profileId);
			super.setProfileId(profileId);
			return this;
		}
		
		/**
		 * 设置 分类代码
		 * @param catalogCode 分类代码
		 * @return 当前对象
		*/
		public Config setCatalogCode(String catalogCode) {
			super.change(CATALOG_CODE,super.getCatalogCode(),catalogCode);
			super.setCatalogCode(catalogCode);
			return this;
		}
		
		/**
		 * 设置 配置键
		 * @param code 配置键
		 * @return 当前对象
		*/
		public Config setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 配置名
		 * @param name 配置名
		 * @return 当前对象
		*/
		public Config setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 数据类型
		 * @param type 数据类型
		 * @return 当前对象
		*/
		public Config setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 类型描述
		 * @param typeDesc 类型描述
		 * @return 当前对象
		*/
		public Config setTypeDesc(String typeDesc) {
			super.change(TYPE_DESC,super.getTypeDesc(),typeDesc);
			super.setTypeDesc(typeDesc);
			return this;
		}
		
		/**
		 * 设置 配置值
		 * @param value 配置值
		 * @return 当前对象
		*/
		public Config setValue(String value) {
			super.change(VALUE,super.getValue(),value);
			super.setValue(value);
			return this;
		}
		
		/**
		 * 设置 是否生效
		 * @param valid 是否生效
		 * @return 当前对象
		*/
		public Config setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 说明
		 * @param notes 说明
		 * @return 当前对象
		*/
		public Config setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Config setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Config setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Config setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Config setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Config setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Config setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Config setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Config setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public Config clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public Config duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setCode(this.getCode());
			inst.setTypeDesc(this.getTypeDesc());
			inst.setNotes(this.getNotes());
			inst.setCatalogCode(this.getCatalogCode());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setType(this.getType());
			inst.setVersion(this.getVersion());
			inst.setValid(this.getValid());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setProfileId(this.getProfileId());
			inst.setName(this.getName());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setValue(this.getValue());
			inst.clearModifies();
			return inst;
		}

	}
}