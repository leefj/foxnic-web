package org.github.foxnic.web.domain.notify;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_SMS_LOG;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.notify.meta.SmsLogMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 短信日志
 * <p>短信日志 , 数据表 sys_sms_log 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-03-10 11:31:33
 * @sign 3BEF11EC1BD6E3E463541AF3DC4A7289
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_sms_log")
@ApiModel(description = "短信日志 ; 短信日志 , 数据表 sys_sms_log 的PO类型")
public class SmsLog extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_SMS_LOG.$TABLE;
	
	/**
	 * id：id
	*/
	@Id
	@ApiModelProperty(required = true,value="id" , notes = "id")
	private Integer id;
	
	/**
	 * 模版ID：模版ID
	*/
	@ApiModelProperty(required = false,value="模版ID" , notes = "模版ID")
	private String templateId;
	
	/**
	 * 短信通道：短信通道
	*/
	@ApiModelProperty(required = false,value="短信通道" , notes = "短信通道")
	private String chanel;
	
	/**
	 * 账户：账户
	*/
	@ApiModelProperty(required = false,value="账户" , notes = "账户")
	private String userId;
	
	/**
	 * 参数：参数
	*/
	@ApiModelProperty(required = false,value="参数" , notes = "参数")
	private String params;
	
	/**
	 * 手机号：手机号
	*/
	@ApiModelProperty(required = false,value="手机号" , notes = "手机号")
	private String phone;
	
	/**
	 * 短信内容：短信内容
	*/
	@ApiModelProperty(required = false,value="短信内容" , notes = "短信内容")
	private String content;
	
	/**
	 * 是否成功：是否成功
	*/
	@ApiModelProperty(required = false,value="是否成功" , notes = "是否成功")
	private Integer success;
	
	/**
	 * 相应：相应
	*/
	@ApiModelProperty(required = false,value="相应" , notes = "相应")
	private String response;
	
	/**
	 * 异常：异常
	*/
	@ApiModelProperty(required = false,value="异常" , notes = "异常")
	private String error;
	
	/**
	 * 租户ID：租户ID
	*/
	@ApiModelProperty(required = true,value="租户ID" , notes = "租户ID")
	private String tenantId;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;
	
	/**
	 * 获得 id<br>
	 * id
	 * @return id
	*/
	public Integer getId() {
		return id;
	}
	
	/**
	 * 设置 id
	 * @param id id
	 * @return 当前对象
	*/
	public SmsLog setId(Integer id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 模版ID<br>
	 * 模版ID
	 * @return 模版ID
	*/
	public String getTemplateId() {
		return templateId;
	}
	
	/**
	 * 设置 模版ID
	 * @param templateId 模版ID
	 * @return 当前对象
	*/
	public SmsLog setTemplateId(String templateId) {
		this.templateId=templateId;
		return this;
	}
	
	/**
	 * 获得 短信通道<br>
	 * 短信通道
	 * @return 短信通道
	*/
	public String getChanel() {
		return chanel;
	}
	
	/**
	 * 设置 短信通道
	 * @param chanel 短信通道
	 * @return 当前对象
	*/
	public SmsLog setChanel(String chanel) {
		this.chanel=chanel;
		return this;
	}
	
	/**
	 * 获得 账户<br>
	 * 账户
	 * @return 账户
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 账户
	 * @param userId 账户
	 * @return 当前对象
	*/
	public SmsLog setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 参数<br>
	 * 参数
	 * @return 参数
	*/
	public String getParams() {
		return params;
	}
	
	/**
	 * 设置 参数
	 * @param params 参数
	 * @return 当前对象
	*/
	public SmsLog setParams(String params) {
		this.params=params;
		return this;
	}
	
	/**
	 * 获得 手机号<br>
	 * 手机号
	 * @return 手机号
	*/
	public String getPhone() {
		return phone;
	}
	
	/**
	 * 设置 手机号
	 * @param phone 手机号
	 * @return 当前对象
	*/
	public SmsLog setPhone(String phone) {
		this.phone=phone;
		return this;
	}
	
	/**
	 * 获得 短信内容<br>
	 * 短信内容
	 * @return 短信内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 短信内容
	 * @param content 短信内容
	 * @return 当前对象
	*/
	public SmsLog setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 是否成功<br>
	 * 是否成功
	 * @return 是否成功
	*/
	public Integer getSuccess() {
		return success;
	}
	
	/**
	 * 设置 是否成功
	 * @param success 是否成功
	 * @return 当前对象
	*/
	public SmsLog setSuccess(Integer success) {
		this.success=success;
		return this;
	}
	
	/**
	 * 获得 相应<br>
	 * 相应
	 * @return 相应
	*/
	public String getResponse() {
		return response;
	}
	
	/**
	 * 设置 相应
	 * @param response 相应
	 * @return 当前对象
	*/
	public SmsLog setResponse(String response) {
		this.response=response;
		return this;
	}
	
	/**
	 * 获得 异常<br>
	 * 异常
	 * @return 异常
	*/
	public String getError() {
		return error;
	}
	
	/**
	 * 设置 异常
	 * @param error 异常
	 * @return 当前对象
	*/
	public SmsLog setError(String error) {
		this.error=error;
		return this;
	}
	
	/**
	 * 获得 租户ID<br>
	 * 租户ID
	 * @return 租户ID
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户ID
	 * @param tenantId 租户ID
	 * @return 当前对象
	*/
	public SmsLog setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public SmsLog setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public SmsLog setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public SmsLog setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public SmsLog setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除 的投影属性<br>
	 * 等价于 getDeleted 方法，获得对应的枚举类型
	 * @return 是否已删除
	*/
	@Transient
	public Boolean isDeleted() {
		if(this.deletedBool==null) {
			this.deletedBool=DataParser.parseBoolean(deleted);
		}
		return this.deletedBool ;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	@JsonProperty("deleted")
	public SmsLog setDeleted(Integer deleted) {
		this.deleted=deleted;
		this.deletedBool=DataParser.parseBoolean(deleted);
		return this;
	}
	
	/**
	 * 设置 是否已删除的投影属性，等同于设置 是否已删除
	 * @param deletedBool 是否已删除
	 * @return 当前对象
	*/
	@Transient
	public SmsLog setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public SmsLog setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public SmsLog setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public SmsLog setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return SmsLog , 转换好的 SmsLog 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SmsLog , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
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
		org.github.foxnic.web.domain.notify.meta.SmsLogMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.notify.meta.SmsLogMeta.$$proxy$$();
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

	/**
	 * 克隆当前对象
	*/
	@Transient
	public SmsLog clone(boolean deep) {
		return EntityContext.clone(SmsLog.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SmsLog
	 * @param smsLogMap 包含实体信息的 Map 对象
	 * @return SmsLog , 转换好的的 SmsLog 对象
	*/
	@Transient
	public static SmsLog createFrom(Map<String,Object> smsLogMap) {
		if(smsLogMap==null) return null;
		SmsLog po = create();
		EntityContext.copyProperties(po,smsLogMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 SmsLog
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SmsLog , 转换好的的 SmsLog 对象
	*/
	@Transient
	public static SmsLog createFrom(Object pojo) {
		if(pojo==null) return null;
		SmsLog po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 SmsLog，等同于 new
	 * @return SmsLog 对象
	*/
	@Transient
	public static SmsLog create() {
		return new org.github.foxnic.web.domain.notify.meta.SmsLogMeta.$$proxy$$();
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SmsLogMeta.UPDATE_TIME)));
			this.setTemplateId(DataParser.parse(String.class, map.get(SmsLogMeta.TEMPLATE_ID)));
			this.setParams(DataParser.parse(String.class, map.get(SmsLogMeta.PARAMS)));
			this.setError(DataParser.parse(String.class, map.get(SmsLogMeta.ERROR)));
			this.setUserId(DataParser.parse(String.class, map.get(SmsLogMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SmsLogMeta.VERSION)));
			this.setChanel(DataParser.parse(String.class, map.get(SmsLogMeta.CHANEL)));
			this.setContent(DataParser.parse(String.class, map.get(SmsLogMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SmsLogMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SmsLogMeta.DELETED)));
			this.setPhone(DataParser.parse(String.class, map.get(SmsLogMeta.PHONE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SmsLogMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SmsLogMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SmsLogMeta.DELETE_TIME)));
			this.setSuccess(DataParser.parse(Integer.class, map.get(SmsLogMeta.SUCCESS)));
			this.setResponse(DataParser.parse(String.class, map.get(SmsLogMeta.RESPONSE)));
			this.setTenantId(DataParser.parse(String.class, map.get(SmsLogMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SmsLogMeta.DELETE_BY)));
			this.setId(DataParser.parse(Integer.class, map.get(SmsLogMeta.ID)));
			// others
			return true;
		} else {
			try {
				this.setUpdateTime( (Date)map.get(SmsLogMeta.UPDATE_TIME));
				this.setTemplateId( (String)map.get(SmsLogMeta.TEMPLATE_ID));
				this.setParams( (String)map.get(SmsLogMeta.PARAMS));
				this.setError( (String)map.get(SmsLogMeta.ERROR));
				this.setUserId( (String)map.get(SmsLogMeta.USER_ID));
				this.setVersion( (Integer)map.get(SmsLogMeta.VERSION));
				this.setChanel( (String)map.get(SmsLogMeta.CHANEL));
				this.setContent( (String)map.get(SmsLogMeta.CONTENT));
				this.setCreateBy( (String)map.get(SmsLogMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(SmsLogMeta.DELETED));
				this.setPhone( (String)map.get(SmsLogMeta.PHONE));
				this.setCreateTime( (Date)map.get(SmsLogMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(SmsLogMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(SmsLogMeta.DELETE_TIME));
				this.setSuccess( (Integer)map.get(SmsLogMeta.SUCCESS));
				this.setResponse( (String)map.get(SmsLogMeta.RESPONSE));
				this.setTenantId( (String)map.get(SmsLogMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(SmsLogMeta.DELETE_BY));
				this.setId( (Integer)map.get(SmsLogMeta.ID));
				// others
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SmsLogMeta.UPDATE_TIME)));
			this.setTemplateId(DataParser.parse(String.class, r.getValue(SmsLogMeta.TEMPLATE_ID)));
			this.setParams(DataParser.parse(String.class, r.getValue(SmsLogMeta.PARAMS)));
			this.setError(DataParser.parse(String.class, r.getValue(SmsLogMeta.ERROR)));
			this.setUserId(DataParser.parse(String.class, r.getValue(SmsLogMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SmsLogMeta.VERSION)));
			this.setChanel(DataParser.parse(String.class, r.getValue(SmsLogMeta.CHANEL)));
			this.setContent(DataParser.parse(String.class, r.getValue(SmsLogMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SmsLogMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SmsLogMeta.DELETED)));
			this.setPhone(DataParser.parse(String.class, r.getValue(SmsLogMeta.PHONE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SmsLogMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SmsLogMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SmsLogMeta.DELETE_TIME)));
			this.setSuccess(DataParser.parse(Integer.class, r.getValue(SmsLogMeta.SUCCESS)));
			this.setResponse(DataParser.parse(String.class, r.getValue(SmsLogMeta.RESPONSE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SmsLogMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SmsLogMeta.DELETE_BY)));
			this.setId(DataParser.parse(Integer.class, r.getValue(SmsLogMeta.ID)));
			return true;
		} else {
			try {
				this.setUpdateTime( (Date)r.getValue(SmsLogMeta.UPDATE_TIME));
				this.setTemplateId( (String)r.getValue(SmsLogMeta.TEMPLATE_ID));
				this.setParams( (String)r.getValue(SmsLogMeta.PARAMS));
				this.setError( (String)r.getValue(SmsLogMeta.ERROR));
				this.setUserId( (String)r.getValue(SmsLogMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(SmsLogMeta.VERSION));
				this.setChanel( (String)r.getValue(SmsLogMeta.CHANEL));
				this.setContent( (String)r.getValue(SmsLogMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(SmsLogMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(SmsLogMeta.DELETED));
				this.setPhone( (String)r.getValue(SmsLogMeta.PHONE));
				this.setCreateTime( (Date)r.getValue(SmsLogMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(SmsLogMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(SmsLogMeta.DELETE_TIME));
				this.setSuccess( (Integer)r.getValue(SmsLogMeta.SUCCESS));
				this.setResponse( (String)r.getValue(SmsLogMeta.RESPONSE));
				this.setTenantId( (String)r.getValue(SmsLogMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(SmsLogMeta.DELETE_BY));
				this.setId( (Integer)r.getValue(SmsLogMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}