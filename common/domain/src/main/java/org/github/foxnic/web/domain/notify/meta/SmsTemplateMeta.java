package org.github.foxnic.web.domain.notify.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.notify.SmsTemplate;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-03-10 11:43:43
 * @sign 45FC35568034F302A0CDE1DD7C20DE8D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SmsTemplateMeta {
	
	/**
	 * id , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * id , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsTemplate,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsTemplate.class ,ID, java.lang.String.class, "id", "id", java.lang.String.class, null);
	
	/**
	 * 模版代码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 模版代码 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsTemplate,java.lang.String> CODE_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsTemplate.class ,CODE, java.lang.String.class, "模版代码", "模版代码", java.lang.String.class, null);
	
	/**
	 * 模版名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 模版名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsTemplate,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsTemplate.class ,NAME, java.lang.String.class, "模版名称", "模版名称", java.lang.String.class, null);
	
	/**
	 * 短信通道 , 类型: java.lang.String
	*/
	public static final String CHANEL_TYPE="chanelType";
	
	/**
	 * 短信通道 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsTemplate,java.lang.String> CHANEL_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsTemplate.class ,CHANEL_TYPE, java.lang.String.class, "短信通道", "短信通道", java.lang.String.class, null);
	
	/**
	 * 模版代码 , 类型: java.lang.String
	*/
	public static final String CHANEL_CODE="chanelCode";
	
	/**
	 * 模版代码 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsTemplate,java.lang.String> CHANEL_CODE_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsTemplate.class ,CHANEL_CODE, java.lang.String.class, "模版代码", "模版代码", java.lang.String.class, null);
	
	/**
	 * 模版内容 , 类型: java.lang.String
	*/
	public static final String TEMPLATE="template";
	
	/**
	 * 模版内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsTemplate,java.lang.String> TEMPLATE_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsTemplate.class ,TEMPLATE, java.lang.String.class, "模版内容", "模版内容", java.lang.String.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsTemplate,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsTemplate.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsTemplate,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsTemplate.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsTemplate,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsTemplate.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsTemplate,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsTemplate.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsTemplate,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsTemplate.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsTemplate,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsTemplate.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsTemplate,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsTemplate.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsTemplate,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsTemplate.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsTemplate,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsTemplate.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , NAME , CHANEL_TYPE , CHANEL_CODE , TEMPLATE , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.notify.SmsTemplate {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 id
		 * @param id id
		 * @return 当前对象
		*/
		public SmsTemplate setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 模版代码
		 * @param code 模版代码
		 * @return 当前对象
		*/
		public SmsTemplate setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 模版名称
		 * @param name 模版名称
		 * @return 当前对象
		*/
		public SmsTemplate setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 短信通道
		 * @param chanelType 短信通道
		 * @return 当前对象
		*/
		public SmsTemplate setChanelType(String chanelType) {
			super.change(CHANEL_TYPE,super.getChanelType(),chanelType);
			super.setChanelType(chanelType);
			return this;
		}
		
		/**
		 * 设置 模版代码
		 * @param chanelCode 模版代码
		 * @return 当前对象
		*/
		public SmsTemplate setChanelCode(String chanelCode) {
			super.change(CHANEL_CODE,super.getChanelCode(),chanelCode);
			super.setChanelCode(chanelCode);
			return this;
		}
		
		/**
		 * 设置 模版内容
		 * @param template 模版内容
		 * @return 当前对象
		*/
		public SmsTemplate setTemplate(String template) {
			super.change(TEMPLATE,super.getTemplate(),template);
			super.setTemplate(template);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public SmsTemplate setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public SmsTemplate setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public SmsTemplate setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public SmsTemplate setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public SmsTemplate setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public SmsTemplate setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public SmsTemplate setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public SmsTemplate setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public SmsTemplate setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public SmsTemplate clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public SmsTemplate duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setTemplate(this.getTemplate());
			inst.setCode(this.getCode());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setChanelType(this.getChanelType());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setChanelCode(this.getChanelCode());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.clearModifies();
			return inst;
		}

	}
}