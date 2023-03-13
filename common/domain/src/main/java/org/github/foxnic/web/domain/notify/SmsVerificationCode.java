package org.github.foxnic.web.domain.notify;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_SMS_VERIFICATION_CODE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.notify.meta.SmsVerificationCodeMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 短信验证码
 * <p>短信验证码 , 数据表 sys_sms_verification_code 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-03-10 11:31:34
 * @sign CF1E7C94E744DA6E94B2E29D2D0F07AA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_sms_verification_code")
@ApiModel(description = "短信验证码 ; 短信验证码 , 数据表 sys_sms_verification_code 的PO类型")
public class SmsVerificationCode extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_SMS_VERIFICATION_CODE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 验证主题：验证主题
	*/
	@ApiModelProperty(required = false,value="验证主题" , notes = "验证主题")
	private String topic;
	
	/**
	 * 短信通道：短信通道
	*/
	@ApiModelProperty(required = false,value="短信通道" , notes = "短信通道")
	private String userId;
	
	/**
	 * 手机号：手机号
	*/
	@ApiModelProperty(required = false,value="手机号" , notes = "手机号")
	private String phone;
	
	/**
	 * 短信内容：短信内容
	*/
	@ApiModelProperty(required = false,value="短信内容" , notes = "短信内容")
	private String code;
	
	/**
	 * 过期时间：过期时间
	*/
	@ApiModelProperty(required = false,value="过期时间" , notes = "过期时间")
	private Date expireTime;
	
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
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public SmsVerificationCode setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 验证主题<br>
	 * 验证主题
	 * @return 验证主题
	*/
	public String getTopic() {
		return topic;
	}
	
	/**
	 * 设置 验证主题
	 * @param topic 验证主题
	 * @return 当前对象
	*/
	public SmsVerificationCode setTopic(String topic) {
		this.topic=topic;
		return this;
	}
	
	/**
	 * 获得 短信通道<br>
	 * 短信通道
	 * @return 短信通道
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 短信通道
	 * @param userId 短信通道
	 * @return 当前对象
	*/
	public SmsVerificationCode setUserId(String userId) {
		this.userId=userId;
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
	public SmsVerificationCode setPhone(String phone) {
		this.phone=phone;
		return this;
	}
	
	/**
	 * 获得 短信内容<br>
	 * 短信内容
	 * @return 短信内容
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 短信内容
	 * @param code 短信内容
	 * @return 当前对象
	*/
	public SmsVerificationCode setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 过期时间<br>
	 * 过期时间
	 * @return 过期时间
	*/
	public Date getExpireTime() {
		return expireTime;
	}
	
	/**
	 * 设置 过期时间
	 * @param expireTime 过期时间
	 * @return 当前对象
	*/
	public SmsVerificationCode setExpireTime(Date expireTime) {
		this.expireTime=expireTime;
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
	public SmsVerificationCode setTenantId(String tenantId) {
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
	public SmsVerificationCode setCreateBy(String createBy) {
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
	public SmsVerificationCode setCreateTime(Date createTime) {
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
	public SmsVerificationCode setUpdateBy(String updateBy) {
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
	public SmsVerificationCode setUpdateTime(Date updateTime) {
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
	public SmsVerificationCode setDeleted(Integer deleted) {
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
	public SmsVerificationCode setDeleted(Boolean deletedBool) {
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
	public SmsVerificationCode setDeleteBy(String deleteBy) {
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
	public SmsVerificationCode setDeleteTime(Date deleteTime) {
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
	public SmsVerificationCode setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return SmsVerificationCode , 转换好的 SmsVerificationCode 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SmsVerificationCode , 转换好的 PoJo 对象
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
	public SmsVerificationCode clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SmsVerificationCode duplicate(boolean all) {
		org.github.foxnic.web.domain.notify.meta.SmsVerificationCodeMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.notify.meta.SmsVerificationCodeMeta.$$proxy$$();
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

	/**
	 * 克隆当前对象
	*/
	@Transient
	public SmsVerificationCode clone(boolean deep) {
		return EntityContext.clone(SmsVerificationCode.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SmsVerificationCode
	 * @param smsVerificationCodeMap 包含实体信息的 Map 对象
	 * @return SmsVerificationCode , 转换好的的 SmsVerificationCode 对象
	*/
	@Transient
	public static SmsVerificationCode createFrom(Map<String,Object> smsVerificationCodeMap) {
		if(smsVerificationCodeMap==null) return null;
		SmsVerificationCode po = create();
		EntityContext.copyProperties(po,smsVerificationCodeMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 SmsVerificationCode
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SmsVerificationCode , 转换好的的 SmsVerificationCode 对象
	*/
	@Transient
	public static SmsVerificationCode createFrom(Object pojo) {
		if(pojo==null) return null;
		SmsVerificationCode po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 SmsVerificationCode，等同于 new
	 * @return SmsVerificationCode 对象
	*/
	@Transient
	public static SmsVerificationCode create() {
		return new org.github.foxnic.web.domain.notify.meta.SmsVerificationCodeMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(SmsVerificationCodeMeta.CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SmsVerificationCodeMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, map.get(SmsVerificationCodeMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SmsVerificationCodeMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SmsVerificationCodeMeta.CREATE_BY)));
			this.setExpireTime(DataParser.parse(Date.class, map.get(SmsVerificationCodeMeta.EXPIRE_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SmsVerificationCodeMeta.DELETED)));
			this.setPhone(DataParser.parse(String.class, map.get(SmsVerificationCodeMeta.PHONE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SmsVerificationCodeMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SmsVerificationCodeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SmsVerificationCodeMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(SmsVerificationCodeMeta.TENANT_ID)));
			this.setTopic(DataParser.parse(String.class, map.get(SmsVerificationCodeMeta.TOPIC)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SmsVerificationCodeMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(SmsVerificationCodeMeta.ID)));
			// others
			return true;
		} else {
			try {
				this.setCode( (String)map.get(SmsVerificationCodeMeta.CODE));
				this.setUpdateTime( (Date)map.get(SmsVerificationCodeMeta.UPDATE_TIME));
				this.setUserId( (String)map.get(SmsVerificationCodeMeta.USER_ID));
				this.setVersion( (Integer)map.get(SmsVerificationCodeMeta.VERSION));
				this.setCreateBy( (String)map.get(SmsVerificationCodeMeta.CREATE_BY));
				this.setExpireTime( (Date)map.get(SmsVerificationCodeMeta.EXPIRE_TIME));
				this.setDeleted( (Integer)map.get(SmsVerificationCodeMeta.DELETED));
				this.setPhone( (String)map.get(SmsVerificationCodeMeta.PHONE));
				this.setCreateTime( (Date)map.get(SmsVerificationCodeMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(SmsVerificationCodeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(SmsVerificationCodeMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(SmsVerificationCodeMeta.TENANT_ID));
				this.setTopic( (String)map.get(SmsVerificationCodeMeta.TOPIC));
				this.setDeleteBy( (String)map.get(SmsVerificationCodeMeta.DELETE_BY));
				this.setId( (String)map.get(SmsVerificationCodeMeta.ID));
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
			this.setCode(DataParser.parse(String.class, r.getValue(SmsVerificationCodeMeta.CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SmsVerificationCodeMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, r.getValue(SmsVerificationCodeMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SmsVerificationCodeMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SmsVerificationCodeMeta.CREATE_BY)));
			this.setExpireTime(DataParser.parse(Date.class, r.getValue(SmsVerificationCodeMeta.EXPIRE_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SmsVerificationCodeMeta.DELETED)));
			this.setPhone(DataParser.parse(String.class, r.getValue(SmsVerificationCodeMeta.PHONE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SmsVerificationCodeMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SmsVerificationCodeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SmsVerificationCodeMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SmsVerificationCodeMeta.TENANT_ID)));
			this.setTopic(DataParser.parse(String.class, r.getValue(SmsVerificationCodeMeta.TOPIC)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SmsVerificationCodeMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(SmsVerificationCodeMeta.ID)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(SmsVerificationCodeMeta.CODE));
				this.setUpdateTime( (Date)r.getValue(SmsVerificationCodeMeta.UPDATE_TIME));
				this.setUserId( (String)r.getValue(SmsVerificationCodeMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(SmsVerificationCodeMeta.VERSION));
				this.setCreateBy( (String)r.getValue(SmsVerificationCodeMeta.CREATE_BY));
				this.setExpireTime( (Date)r.getValue(SmsVerificationCodeMeta.EXPIRE_TIME));
				this.setDeleted( (Integer)r.getValue(SmsVerificationCodeMeta.DELETED));
				this.setPhone( (String)r.getValue(SmsVerificationCodeMeta.PHONE));
				this.setCreateTime( (Date)r.getValue(SmsVerificationCodeMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(SmsVerificationCodeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(SmsVerificationCodeMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(SmsVerificationCodeMeta.TENANT_ID));
				this.setTopic( (String)r.getValue(SmsVerificationCodeMeta.TOPIC));
				this.setDeleteBy( (String)r.getValue(SmsVerificationCodeMeta.DELETE_BY));
				this.setId( (String)r.getValue(SmsVerificationCodeMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}