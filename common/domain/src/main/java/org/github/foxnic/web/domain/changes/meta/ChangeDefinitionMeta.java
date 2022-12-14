package org.github.foxnic.web.domain.changes.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.changes.ChangeDefinition;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-25 11:44:54
 * @sign 2B9B7D09BE1141B8BAF240A6BE61CB3E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ChangeDefinitionMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeDefinition,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeDefinition.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeDefinition,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeDefinition.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 代码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 代码 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeDefinition,java.lang.String> CODE_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeDefinition.class ,CODE, java.lang.String.class, "代码", "代码", java.lang.String.class, null);
	
	/**
	 * 审批模式 , 类型: java.lang.String
	*/
	public static final String MODE="mode";
	
	/**
	 * 审批模式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeDefinition,java.lang.String> MODE_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeDefinition.class ,MODE, java.lang.String.class, "审批模式", "审批模式", java.lang.String.class, null);
	
	/**
	 * 默认审批人信息JSONArray格式 , 适用于简单审批模式 , 类型: java.lang.String
	*/
	public static final String SIMPLE_APPROVERS="simpleApprovers";
	
	/**
	 * 默认审批人信息JSONArray格式 , 适用于简单审批模式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeDefinition,java.lang.String> SIMPLE_APPROVERS_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeDefinition.class ,SIMPLE_APPROVERS, java.lang.String.class, "默认审批人信息JSONArray格式", "适用于简单审批模式", java.lang.String.class, null);
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final String VALID="valid";
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeDefinition,java.lang.Integer> VALID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeDefinition.class ,VALID, java.lang.Integer.class, "是否有效", "是否有效", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeDefinition,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeDefinition.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeDefinition,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeDefinition.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeDefinition,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeDefinition.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeDefinition,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeDefinition.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeDefinition,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeDefinition.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeDefinition,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeDefinition.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeDefinition,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeDefinition.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeDefinition,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeDefinition.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , CODE , MODE , SIMPLE_APPROVERS , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.changes.ChangeDefinition {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ChangeDefinition setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public ChangeDefinition setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 代码
		 * @param code 代码
		 * @return 当前对象
		*/
		public ChangeDefinition setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 审批模式
		 * @param mode 审批模式
		 * @return 当前对象
		*/
		public ChangeDefinition setMode(String mode) {
			super.change(MODE,super.getMode(),mode);
			super.setMode(mode);
			return this;
		}
		
		/**
		 * 设置 默认审批人信息JSONArray格式
		 * @param simpleApprovers 默认审批人信息JSONArray格式
		 * @return 当前对象
		*/
		public ChangeDefinition setSimpleApprovers(String simpleApprovers) {
			super.change(SIMPLE_APPROVERS,super.getSimpleApprovers(),simpleApprovers);
			super.setSimpleApprovers(simpleApprovers);
			return this;
		}
		
		/**
		 * 设置 是否有效
		 * @param valid 是否有效
		 * @return 当前对象
		*/
		public ChangeDefinition setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ChangeDefinition setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ChangeDefinition setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ChangeDefinition setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ChangeDefinition setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ChangeDefinition setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ChangeDefinition setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ChangeDefinition setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public ChangeDefinition setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}