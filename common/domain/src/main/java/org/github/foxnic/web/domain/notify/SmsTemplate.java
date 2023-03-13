package org.github.foxnic.web.domain.notify;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_SMS_TEMPLATE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.notify.meta.SmsTemplateMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 短信模版
 * <p>短信模版 , 数据表 sys_sms_template 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-03-10 11:43:43
 * @sign 45FC35568034F302A0CDE1DD7C20DE8D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_sms_template")
@ApiModel(description = "短信模版 ; 短信模版 , 数据表 sys_sms_template 的PO类型")
public class SmsTemplate extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_SMS_TEMPLATE.$TABLE;
	
	/**
	 * id：id
	*/
	@Id
	@ApiModelProperty(required = true,value="id" , notes = "id")
	private String id;
	
	/**
	 * 模版代码：模版代码
	*/
	@ApiModelProperty(required = false,value="模版代码" , notes = "模版代码")
	private String code;
	
	/**
	 * 模版名称：模版名称
	*/
	@ApiModelProperty(required = false,value="模版名称" , notes = "模版名称")
	private String name;
	
	/**
	 * 短信通道：短信通道
	*/
	@ApiModelProperty(required = false,value="短信通道" , notes = "短信通道")
	private String chanelType;
	
	/**
	 * 模版代码：模版代码
	*/
	@ApiModelProperty(required = false,value="模版代码" , notes = "模版代码")
	private String chanelCode;
	
	/**
	 * 模版内容：模版内容
	*/
	@ApiModelProperty(required = false,value="模版内容" , notes = "模版内容")
	private String template;
	
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
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 id
	 * @param id id
	 * @return 当前对象
	*/
	public SmsTemplate setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 模版代码<br>
	 * 模版代码
	 * @return 模版代码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 模版代码
	 * @param code 模版代码
	 * @return 当前对象
	*/
	public SmsTemplate setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 模版名称<br>
	 * 模版名称
	 * @return 模版名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 模版名称
	 * @param name 模版名称
	 * @return 当前对象
	*/
	public SmsTemplate setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 短信通道<br>
	 * 短信通道
	 * @return 短信通道
	*/
	public String getChanelType() {
		return chanelType;
	}
	
	/**
	 * 设置 短信通道
	 * @param chanelType 短信通道
	 * @return 当前对象
	*/
	public SmsTemplate setChanelType(String chanelType) {
		this.chanelType=chanelType;
		return this;
	}
	
	/**
	 * 获得 模版代码<br>
	 * 模版代码
	 * @return 模版代码
	*/
	public String getChanelCode() {
		return chanelCode;
	}
	
	/**
	 * 设置 模版代码
	 * @param chanelCode 模版代码
	 * @return 当前对象
	*/
	public SmsTemplate setChanelCode(String chanelCode) {
		this.chanelCode=chanelCode;
		return this;
	}
	
	/**
	 * 获得 模版内容<br>
	 * 模版内容
	 * @return 模版内容
	*/
	public String getTemplate() {
		return template;
	}
	
	/**
	 * 设置 模版内容
	 * @param template 模版内容
	 * @return 当前对象
	*/
	public SmsTemplate setTemplate(String template) {
		this.template=template;
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
	public SmsTemplate setTenantId(String tenantId) {
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
	public SmsTemplate setCreateBy(String createBy) {
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
	public SmsTemplate setCreateTime(Date createTime) {
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
	public SmsTemplate setUpdateBy(String updateBy) {
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
	public SmsTemplate setUpdateTime(Date updateTime) {
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
	public SmsTemplate setDeleted(Integer deleted) {
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
	public SmsTemplate setDeleted(Boolean deletedBool) {
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
	public SmsTemplate setDeleteBy(String deleteBy) {
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
	public SmsTemplate setDeleteTime(Date deleteTime) {
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
	public SmsTemplate setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return SmsTemplate , 转换好的 SmsTemplate 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SmsTemplate , 转换好的 PoJo 对象
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
	public SmsTemplate clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SmsTemplate duplicate(boolean all) {
		org.github.foxnic.web.domain.notify.meta.SmsTemplateMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.notify.meta.SmsTemplateMeta.$$proxy$$();
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

	/**
	 * 克隆当前对象
	*/
	@Transient
	public SmsTemplate clone(boolean deep) {
		return EntityContext.clone(SmsTemplate.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SmsTemplate
	 * @param smsTemplateMap 包含实体信息的 Map 对象
	 * @return SmsTemplate , 转换好的的 SmsTemplate 对象
	*/
	@Transient
	public static SmsTemplate createFrom(Map<String,Object> smsTemplateMap) {
		if(smsTemplateMap==null) return null;
		SmsTemplate po = create();
		EntityContext.copyProperties(po,smsTemplateMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 SmsTemplate
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SmsTemplate , 转换好的的 SmsTemplate 对象
	*/
	@Transient
	public static SmsTemplate createFrom(Object pojo) {
		if(pojo==null) return null;
		SmsTemplate po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 SmsTemplate，等同于 new
	 * @return SmsTemplate 对象
	*/
	@Transient
	public static SmsTemplate create() {
		return new org.github.foxnic.web.domain.notify.meta.SmsTemplateMeta.$$proxy$$();
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
			this.setTemplate(DataParser.parse(String.class, map.get(SmsTemplateMeta.TEMPLATE)));
			this.setCode(DataParser.parse(String.class, map.get(SmsTemplateMeta.CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SmsTemplateMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SmsTemplateMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SmsTemplateMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SmsTemplateMeta.DELETED)));
			this.setChanelType(DataParser.parse(String.class, map.get(SmsTemplateMeta.CHANEL_TYPE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SmsTemplateMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SmsTemplateMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SmsTemplateMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(SmsTemplateMeta.NAME)));
			this.setChanelCode(DataParser.parse(String.class, map.get(SmsTemplateMeta.CHANEL_CODE)));
			this.setTenantId(DataParser.parse(String.class, map.get(SmsTemplateMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SmsTemplateMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(SmsTemplateMeta.ID)));
			// others
			return true;
		} else {
			try {
				this.setTemplate( (String)map.get(SmsTemplateMeta.TEMPLATE));
				this.setCode( (String)map.get(SmsTemplateMeta.CODE));
				this.setUpdateTime( (Date)map.get(SmsTemplateMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(SmsTemplateMeta.VERSION));
				this.setCreateBy( (String)map.get(SmsTemplateMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(SmsTemplateMeta.DELETED));
				this.setChanelType( (String)map.get(SmsTemplateMeta.CHANEL_TYPE));
				this.setCreateTime( (Date)map.get(SmsTemplateMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(SmsTemplateMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(SmsTemplateMeta.DELETE_TIME));
				this.setName( (String)map.get(SmsTemplateMeta.NAME));
				this.setChanelCode( (String)map.get(SmsTemplateMeta.CHANEL_CODE));
				this.setTenantId( (String)map.get(SmsTemplateMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(SmsTemplateMeta.DELETE_BY));
				this.setId( (String)map.get(SmsTemplateMeta.ID));
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
			this.setTemplate(DataParser.parse(String.class, r.getValue(SmsTemplateMeta.TEMPLATE)));
			this.setCode(DataParser.parse(String.class, r.getValue(SmsTemplateMeta.CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SmsTemplateMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SmsTemplateMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SmsTemplateMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SmsTemplateMeta.DELETED)));
			this.setChanelType(DataParser.parse(String.class, r.getValue(SmsTemplateMeta.CHANEL_TYPE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SmsTemplateMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SmsTemplateMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SmsTemplateMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(SmsTemplateMeta.NAME)));
			this.setChanelCode(DataParser.parse(String.class, r.getValue(SmsTemplateMeta.CHANEL_CODE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SmsTemplateMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SmsTemplateMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(SmsTemplateMeta.ID)));
			return true;
		} else {
			try {
				this.setTemplate( (String)r.getValue(SmsTemplateMeta.TEMPLATE));
				this.setCode( (String)r.getValue(SmsTemplateMeta.CODE));
				this.setUpdateTime( (Date)r.getValue(SmsTemplateMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(SmsTemplateMeta.VERSION));
				this.setCreateBy( (String)r.getValue(SmsTemplateMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(SmsTemplateMeta.DELETED));
				this.setChanelType( (String)r.getValue(SmsTemplateMeta.CHANEL_TYPE));
				this.setCreateTime( (Date)r.getValue(SmsTemplateMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(SmsTemplateMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(SmsTemplateMeta.DELETE_TIME));
				this.setName( (String)r.getValue(SmsTemplateMeta.NAME));
				this.setChanelCode( (String)r.getValue(SmsTemplateMeta.CHANEL_CODE));
				this.setTenantId( (String)r.getValue(SmsTemplateMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(SmsTemplateMeta.DELETE_BY));
				this.setId( (String)r.getValue(SmsTemplateMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}