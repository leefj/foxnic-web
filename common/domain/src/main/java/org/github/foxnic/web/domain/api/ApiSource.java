package org.github.foxnic.web.domain.api;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_API_SOURCE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 接口数据来源定义
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-14 16:40:35
 * @sign 7B03FD741333F01EACEC3B2444650F44
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_api_source")
public class ApiSource extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_API_SOURCE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 接口地址：接口地址
	*/
	@ApiModelProperty(required = false,value="接口地址" , notes = "接口地址")
	private String apiUrl;
	
	/**
	 * 账户：账户
	*/
	@ApiModelProperty(required = false,value="账户" , notes = "账户")
	private String userName;
	
	/**
	 * 密码：密码
	*/
	@ApiModelProperty(required = false,value="密码" , notes = "密码")
	private String password;
	
	/**
	 * 是否有效：是否有效
	*/
	@ApiModelProperty(required = false,value="是否有效" , notes = "是否有效")
	private Integer valid;
	
	/**
	 * API数据：API数据
	*/
	@ApiModelProperty(required = false,value="API数据" , notes = "API数据")
	private String apiData;
	
	/**
	 * 目录结构：目录结构
	*/
	@ApiModelProperty(required = false,value="目录结构" , notes = "目录结构")
	private String navDir;
	
	/**
	 * 取数时间：取数时间
	*/
	@ApiModelProperty(required = false,value="取数时间" , notes = "取数时间")
	private Date fetchTime;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	public ApiSource setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public ApiSource setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 接口地址<br>
	 * 接口地址
	 * @return 接口地址
	*/
	public String getApiUrl() {
		return apiUrl;
	}
	
	/**
	 * 设置 接口地址
	 * @param apiUrl 接口地址
	 * @return 当前对象
	*/
	public ApiSource setApiUrl(String apiUrl) {
		this.apiUrl=apiUrl;
		return this;
	}
	
	/**
	 * 获得 账户<br>
	 * 账户
	 * @return 账户
	*/
	public String getUserName() {
		return userName;
	}
	
	/**
	 * 设置 账户
	 * @param userName 账户
	 * @return 当前对象
	*/
	public ApiSource setUserName(String userName) {
		this.userName=userName;
		return this;
	}
	
	/**
	 * 获得 密码<br>
	 * 密码
	 * @return 密码
	*/
	public String getPassword() {
		return password;
	}
	
	/**
	 * 设置 密码
	 * @param password 密码
	 * @return 当前对象
	*/
	public ApiSource setPassword(String password) {
		this.password=password;
		return this;
	}
	
	/**
	 * 获得 是否有效<br>
	 * 是否有效
	 * @return 是否有效
	*/
	public Integer getValid() {
		return valid;
	}
	
	/**
	 * 设置 是否有效
	 * @param valid 是否有效
	 * @return 当前对象
	*/
	public ApiSource setValid(Integer valid) {
		this.valid=valid;
		return this;
	}
	
	/**
	 * 获得 API数据<br>
	 * API数据
	 * @return API数据
	*/
	public String getApiData() {
		return apiData;
	}
	
	/**
	 * 设置 API数据
	 * @param apiData API数据
	 * @return 当前对象
	*/
	public ApiSource setApiData(String apiData) {
		this.apiData=apiData;
		return this;
	}
	
	/**
	 * 获得 目录结构<br>
	 * 目录结构
	 * @return 目录结构
	*/
	public String getNavDir() {
		return navDir;
	}
	
	/**
	 * 设置 目录结构
	 * @param navDir 目录结构
	 * @return 当前对象
	*/
	public ApiSource setNavDir(String navDir) {
		this.navDir=navDir;
		return this;
	}
	
	/**
	 * 获得 取数时间<br>
	 * 取数时间
	 * @return 取数时间
	*/
	public Date getFetchTime() {
		return fetchTime;
	}
	
	/**
	 * 设置 取数时间
	 * @param fetchTime 取数时间
	 * @return 当前对象
	*/
	public ApiSource setFetchTime(Date fetchTime) {
		this.fetchTime=fetchTime;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 备注
	 * @param notes 备注
	 * @return 当前对象
	*/
	public ApiSource setNotes(String notes) {
		this.notes=notes;
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
	public ApiSource setCreateBy(String createBy) {
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
	public ApiSource setCreateTime(Date createTime) {
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
	public ApiSource setUpdateBy(String updateBy) {
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
	public ApiSource setUpdateTime(Date updateTime) {
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
	public ApiSource setDeleted(Integer deleted) {
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
	public ApiSource setDeleted(Boolean deletedBool) {
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
	public ApiSource setDeleteBy(String deleteBy) {
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
	public ApiSource setDeleteTime(Date deleteTime) {
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
	public ApiSource setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ApiSource , 转换好的 ApiSource 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ApiSource , 转换好的 PoJo 对象
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
	public ApiSource clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ApiSource duplicate(boolean all) {
		org.github.foxnic.web.domain.api.meta.ApiSourceMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.api.meta.ApiSourceMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setApiData(this.getApiData());
		inst.setNavDir(this.getNavDir());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserName(this.getUserName());
		inst.setVersion(this.getVersion());
		inst.setValid(this.getValid());
		inst.setPassword(this.getPassword());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setApiUrl(this.getApiUrl());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setFetchTime(this.getFetchTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ApiSource clone(boolean deep) {
		return EntityContext.clone(ApiSource.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ApiSource
	 * @param apiSourceMap 包含实体信息的 Map 对象
	 * @return ApiSource , 转换好的的 ApiSource 对象
	*/
	@Transient
	public static ApiSource createFrom(Map<String,Object> apiSourceMap) {
		if(apiSourceMap==null) return null;
		ApiSource po = create();
		EntityContext.copyProperties(po,apiSourceMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 ApiSource
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ApiSource , 转换好的的 ApiSource 对象
	*/
	@Transient
	public static ApiSource createFrom(Object pojo) {
		if(pojo==null) return null;
		ApiSource po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 ApiSource，等同于 new
	 * @return ApiSource 对象
	*/
	@Transient
	public static ApiSource create() {
		return new org.github.foxnic.web.domain.api.meta.ApiSourceMeta.$$proxy$$();
	}
}