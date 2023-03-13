package org.github.foxnic.web.domain.notify.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.notify.SmsVerificationCode;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-03-10 11:31:34
 * @sign CF1E7C94E744DA6E94B2E29D2D0F07AA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SmsVerificationCodeMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsVerificationCode,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsVerificationCode.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 验证主题 , 类型: java.lang.String
	*/
	public static final String TOPIC="topic";
	
	/**
	 * 验证主题 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsVerificationCode,java.lang.String> TOPIC_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsVerificationCode.class ,TOPIC, java.lang.String.class, "验证主题", "验证主题", java.lang.String.class, null);
	
	/**
	 * 短信通道 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 短信通道 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsVerificationCode,java.lang.String> USER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsVerificationCode.class ,USER_ID, java.lang.String.class, "短信通道", "短信通道", java.lang.String.class, null);
	
	/**
	 * 手机号 , 类型: java.lang.String
	*/
	public static final String PHONE="phone";
	
	/**
	 * 手机号 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsVerificationCode,java.lang.String> PHONE_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsVerificationCode.class ,PHONE, java.lang.String.class, "手机号", "手机号", java.lang.String.class, null);
	
	/**
	 * 短信内容 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 短信内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsVerificationCode,java.lang.String> CODE_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsVerificationCode.class ,CODE, java.lang.String.class, "短信内容", "短信内容", java.lang.String.class, null);
	
	/**
	 * 过期时间 , 类型: java.util.Date
	*/
	public static final String EXPIRE_TIME="expireTime";
	
	/**
	 * 过期时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsVerificationCode,java.util.Date> EXPIRE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsVerificationCode.class ,EXPIRE_TIME, java.util.Date.class, "过期时间", "过期时间", java.util.Date.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsVerificationCode,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsVerificationCode.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsVerificationCode,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsVerificationCode.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsVerificationCode,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsVerificationCode.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsVerificationCode,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsVerificationCode.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsVerificationCode,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsVerificationCode.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsVerificationCode,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsVerificationCode.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsVerificationCode,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsVerificationCode.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsVerificationCode,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsVerificationCode.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsVerificationCode,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsVerificationCode.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TOPIC , USER_ID , PHONE , CODE , EXPIRE_TIME , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.notify.SmsVerificationCode {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public SmsVerificationCode setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 验证主题
		 * @param topic 验证主题
		 * @return 当前对象
		*/
		public SmsVerificationCode setTopic(String topic) {
			super.change(TOPIC,super.getTopic(),topic);
			super.setTopic(topic);
			return this;
		}
		
		/**
		 * 设置 短信通道
		 * @param userId 短信通道
		 * @return 当前对象
		*/
		public SmsVerificationCode setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 手机号
		 * @param phone 手机号
		 * @return 当前对象
		*/
		public SmsVerificationCode setPhone(String phone) {
			super.change(PHONE,super.getPhone(),phone);
			super.setPhone(phone);
			return this;
		}
		
		/**
		 * 设置 短信内容
		 * @param code 短信内容
		 * @return 当前对象
		*/
		public SmsVerificationCode setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 过期时间
		 * @param expireTime 过期时间
		 * @return 当前对象
		*/
		public SmsVerificationCode setExpireTime(Date expireTime) {
			super.change(EXPIRE_TIME,super.getExpireTime(),expireTime);
			super.setExpireTime(expireTime);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public SmsVerificationCode setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public SmsVerificationCode setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public SmsVerificationCode setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public SmsVerificationCode setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public SmsVerificationCode setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public SmsVerificationCode setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public SmsVerificationCode setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public SmsVerificationCode setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public SmsVerificationCode setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public SmsVerificationCode clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public SmsVerificationCode duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setCode(this.getCode());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setUserId(this.getUserId());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setExpireTime(this.getExpireTime());
			inst.setDeleted(this.getDeleted());
			inst.setPhone(this.getPhone());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setTopic(this.getTopic());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.clearModifies();
			return inst;
		}

	}
}