package org.github.foxnic.web.domain.notify.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.notify.SmsLog;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-03-10 11:31:33
 * @sign 3BEF11EC1BD6E3E463541AF3DC4A7289
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SmsLogMeta {
	
	/**
	 * id , 类型: java.lang.Integer
	*/
	public static final String ID="id";
	
	/**
	 * id , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLog,java.lang.Integer> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLog.class ,ID, java.lang.Integer.class, "id", "id", java.lang.Integer.class, null);
	
	/**
	 * 模版ID , 类型: java.lang.String
	*/
	public static final String TEMPLATE_ID="templateId";
	
	/**
	 * 模版ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLog,java.lang.String> TEMPLATE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLog.class ,TEMPLATE_ID, java.lang.String.class, "模版ID", "模版ID", java.lang.String.class, null);
	
	/**
	 * 短信通道 , 类型: java.lang.String
	*/
	public static final String CHANEL="chanel";
	
	/**
	 * 短信通道 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLog,java.lang.String> CHANEL_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLog.class ,CHANEL, java.lang.String.class, "短信通道", "短信通道", java.lang.String.class, null);
	
	/**
	 * 账户 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 账户 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLog,java.lang.String> USER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLog.class ,USER_ID, java.lang.String.class, "账户", "账户", java.lang.String.class, null);
	
	/**
	 * 参数 , 类型: java.lang.String
	*/
	public static final String PARAMS="params";
	
	/**
	 * 参数 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLog,java.lang.String> PARAMS_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLog.class ,PARAMS, java.lang.String.class, "参数", "参数", java.lang.String.class, null);
	
	/**
	 * 手机号 , 类型: java.lang.String
	*/
	public static final String PHONE="phone";
	
	/**
	 * 手机号 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLog,java.lang.String> PHONE_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLog.class ,PHONE, java.lang.String.class, "手机号", "手机号", java.lang.String.class, null);
	
	/**
	 * 短信内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 短信内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLog,java.lang.String> CONTENT_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLog.class ,CONTENT, java.lang.String.class, "短信内容", "短信内容", java.lang.String.class, null);
	
	/**
	 * 是否成功 , 类型: java.lang.Integer
	*/
	public static final String SUCCESS="success";
	
	/**
	 * 是否成功 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLog,java.lang.Integer> SUCCESS_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLog.class ,SUCCESS, java.lang.Integer.class, "是否成功", "是否成功", java.lang.Integer.class, null);
	
	/**
	 * 相应 , 类型: java.lang.String
	*/
	public static final String RESPONSE="response";
	
	/**
	 * 相应 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLog,java.lang.String> RESPONSE_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLog.class ,RESPONSE, java.lang.String.class, "相应", "相应", java.lang.String.class, null);
	
	/**
	 * 异常 , 类型: java.lang.String
	*/
	public static final String ERROR="error";
	
	/**
	 * 异常 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLog,java.lang.String> ERROR_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLog.class ,ERROR, java.lang.String.class, "异常", "异常", java.lang.String.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLog,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLog.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLog,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLog.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLog,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLog.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLog,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLog.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLog,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLog.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLog,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLog.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLog,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLog.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLog,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLog.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.notify.SmsLog,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.notify.SmsLog.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TEMPLATE_ID , CHANEL , USER_ID , PARAMS , PHONE , CONTENT , SUCCESS , RESPONSE , ERROR , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.notify.SmsLog {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 id
		 * @param id id
		 * @return 当前对象
		*/
		public SmsLog setId(Integer id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 模版ID
		 * @param templateId 模版ID
		 * @return 当前对象
		*/
		public SmsLog setTemplateId(String templateId) {
			super.change(TEMPLATE_ID,super.getTemplateId(),templateId);
			super.setTemplateId(templateId);
			return this;
		}
		
		/**
		 * 设置 短信通道
		 * @param chanel 短信通道
		 * @return 当前对象
		*/
		public SmsLog setChanel(String chanel) {
			super.change(CHANEL,super.getChanel(),chanel);
			super.setChanel(chanel);
			return this;
		}
		
		/**
		 * 设置 账户
		 * @param userId 账户
		 * @return 当前对象
		*/
		public SmsLog setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 参数
		 * @param params 参数
		 * @return 当前对象
		*/
		public SmsLog setParams(String params) {
			super.change(PARAMS,super.getParams(),params);
			super.setParams(params);
			return this;
		}
		
		/**
		 * 设置 手机号
		 * @param phone 手机号
		 * @return 当前对象
		*/
		public SmsLog setPhone(String phone) {
			super.change(PHONE,super.getPhone(),phone);
			super.setPhone(phone);
			return this;
		}
		
		/**
		 * 设置 短信内容
		 * @param content 短信内容
		 * @return 当前对象
		*/
		public SmsLog setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 是否成功
		 * @param success 是否成功
		 * @return 当前对象
		*/
		public SmsLog setSuccess(Integer success) {
			super.change(SUCCESS,super.getSuccess(),success);
			super.setSuccess(success);
			return this;
		}
		
		/**
		 * 设置 相应
		 * @param response 相应
		 * @return 当前对象
		*/
		public SmsLog setResponse(String response) {
			super.change(RESPONSE,super.getResponse(),response);
			super.setResponse(response);
			return this;
		}
		
		/**
		 * 设置 异常
		 * @param error 异常
		 * @return 当前对象
		*/
		public SmsLog setError(String error) {
			super.change(ERROR,super.getError(),error);
			super.setError(error);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public SmsLog setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public SmsLog setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public SmsLog setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public SmsLog setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public SmsLog setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public SmsLog setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public SmsLog setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public SmsLog setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public SmsLog setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public SmsLog clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public SmsLog duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setUpdateTime(this.getUpdateTime());
			inst.setTemplateId(this.getTemplateId());
			inst.setParams(this.getParams());
			inst.setError(this.getError());
			inst.setUserId(this.getUserId());
			inst.setVersion(this.getVersion());
			inst.setChanel(this.getChanel());
			inst.setContent(this.getContent());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setPhone(this.getPhone());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setSuccess(this.getSuccess());
			inst.setResponse(this.getResponse());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.clearModifies();
			return inst;
		}

	}
}