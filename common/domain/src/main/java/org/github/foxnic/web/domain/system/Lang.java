package org.github.foxnic.web.domain.system;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_LANG;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 语言条目
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-25 11:24:19
 * @sign BD215A94BAF4EA9816BBB98144045EDA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_lang")
public class Lang extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_LANG.$TABLE;

	/**
	 * 编码键：编码键
	*/
	@Id
	@ApiModelProperty(required = true,value="编码键" , notes = "编码键")
	private String code;

	/**
	 * 默认：默认
	*/
	@ApiModelProperty(required = false,value="默认" , notes = "默认")
	private String defaults;

	/**
	 * 简体中文(大陆)：简体中文(大陆)
	*/
	@ApiModelProperty(required = false,value="简体中文(大陆)" , notes = "简体中文(大陆)")
	private String zhCh;

	/**
	 * 繁体中文(台湾)：繁体中文(台湾)
	*/
	@ApiModelProperty(required = false,value="繁体中文(台湾)" , notes = "繁体中文(台湾)")
	private String zhTw;

	/**
	 * 英文美国：英文美国
	*/
	@ApiModelProperty(required = false,value="英文美国" , notes = "英文美国")
	private String enUs;

	/**
	 * 英文英国：英文英国
	*/
	@ApiModelProperty(required = false,value="英文英国" , notes = "英文英国")
	private String enUk;

	/**
	 * 混淆专用：混淆专用
	*/
	@ApiModelProperty(required = false,value="混淆专用" , notes = "混淆专用")
	private String confuse;

	/**
	 * 是否有效：是否有效
	*/
	@ApiModelProperty(required = true,value="是否有效" , notes = "是否有效")
	private Integer valid;

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
	 * 获得 编码键<br>
	 * 编码键
	 * @return 编码键
	*/
	public String getCode() {
		return code;
	}

	/**
	 * 设置 编码键
	 * @param code 编码键
	 * @return 当前对象
	*/
	public Lang setCode(String code) {
		this.code=code;
		return this;
	}

	/**
	 * 获得 默认<br>
	 * 默认
	 * @return 默认
	*/
	public String getDefaults() {
		return defaults;
	}

	/**
	 * 设置 默认
	 * @param defaults 默认
	 * @return 当前对象
	*/
	public Lang setDefaults(String defaults) {
		this.defaults=defaults;
		return this;
	}

	/**
	 * 获得 简体中文(大陆)<br>
	 * 简体中文(大陆)
	 * @return 简体中文(大陆)
	*/
	public String getZhCh() {
		return zhCh;
	}

	/**
	 * 设置 简体中文(大陆)
	 * @param zhCh 简体中文(大陆)
	 * @return 当前对象
	*/
	public Lang setZhCh(String zhCh) {
		this.zhCh=zhCh;
		return this;
	}

	/**
	 * 获得 繁体中文(台湾)<br>
	 * 繁体中文(台湾)
	 * @return 繁体中文(台湾)
	*/
	public String getZhTw() {
		return zhTw;
	}

	/**
	 * 设置 繁体中文(台湾)
	 * @param zhTw 繁体中文(台湾)
	 * @return 当前对象
	*/
	public Lang setZhTw(String zhTw) {
		this.zhTw=zhTw;
		return this;
	}

	/**
	 * 获得 英文美国<br>
	 * 英文美国
	 * @return 英文美国
	*/
	public String getEnUs() {
		return enUs;
	}

	/**
	 * 设置 英文美国
	 * @param enUs 英文美国
	 * @return 当前对象
	*/
	public Lang setEnUs(String enUs) {
		this.enUs=enUs;
		return this;
	}

	/**
	 * 获得 英文英国<br>
	 * 英文英国
	 * @return 英文英国
	*/
	public String getEnUk() {
		return enUk;
	}

	/**
	 * 设置 英文英国
	 * @param enUk 英文英国
	 * @return 当前对象
	*/
	public Lang setEnUk(String enUk) {
		this.enUk=enUk;
		return this;
	}

	/**
	 * 获得 混淆专用<br>
	 * 混淆专用
	 * @return 混淆专用
	*/
	public String getConfuse() {
		return confuse;
	}

	/**
	 * 设置 混淆专用
	 * @param confuse 混淆专用
	 * @return 当前对象
	*/
	public Lang setConfuse(String confuse) {
		this.confuse=confuse;
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
	public Lang setValid(Integer valid) {
		this.valid=valid;
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
	public Lang setCreateBy(String createBy) {
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
	public Lang setCreateTime(Date createTime) {
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
	public Lang setUpdateBy(String updateBy) {
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
	public Lang setUpdateTime(Date updateTime) {
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
	public Lang setDeleted(Integer deleted) {
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
	public Lang setDeleted(Boolean deletedBool) {
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
	public Lang setDeleteBy(String deleteBy) {
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
	public Lang setDeleteTime(Date deleteTime) {
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
	public Lang setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Lang , 转换好的 Lang 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Lang , 转换好的 PoJo 对象
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
	public Lang clone() {
		return EntityContext.clone(Lang.class,this);
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Lang clone(boolean deep) {
		return EntityContext.clone(Lang.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Lang
	 * @param langMap 包含实体信息的 Map 对象
	 * @return Lang , 转换好的的 Lang 对象
	*/
	@Transient
	public static Lang createFrom(Map<String,Object> langMap) {
		if(langMap==null) return null;
		Lang po = EntityContext.create(Lang.class, langMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Lang
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Lang , 转换好的的 Lang 对象
	*/
	@Transient
	public static Lang createFrom(Object pojo) {
		if(pojo==null) return null;
		Lang po = EntityContext.create(Lang.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Lang，等同于 new
	 * @return Lang 对象
	*/
	@Transient
	public static Lang create() {
		return EntityContext.create(Lang.class);
	}
}
