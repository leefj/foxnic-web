package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_LANG;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.system.meta.LangMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 语言条目
 * <p>语言条目 , 数据表 sys_lang 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-11-02 16:57:31
 * @sign E85D3CEDBBC451ED453DD8A0A304F635
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_lang")
@ApiModel(description = "语言条目 ; 语言条目 , 数据表 sys_lang 的PO类型")
public class Lang extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_LANG.$TABLE;
	
	/**
	 * 编码键：编码键
	*/
	@Id
	@ApiModelProperty(required = true,value="编码键" , notes = "编码键" , example = "00-054efed6f2-94ea")
	private String code;
	
	/**
	 * 默认：默认
	*/
	@ApiModelProperty(required = false,value="默认" , notes = "默认" , example = "风险等级")
	private String defaults;
	
	/**
	 * 简体中文：简体中文
	*/
	@ApiModelProperty(required = false,value="简体中文" , notes = "简体中文")
	private String zhCn;
	
	/**
	 * 中文(台湾)：中文(台湾)
	*/
	@ApiModelProperty(required = false,value="中文(台湾)" , notes = "中文(台湾)")
	private String zhTw;
	
	/**
	 * 英文美国：英文美国
	*/
	@ApiModelProperty(required = false,value="英文美国" , notes = "英文美国" , example = "AAAA")
	private String enUs;
	
	/**
	 * 英文英国：英文英国
	*/
	@ApiModelProperty(required = false,value="英文英国" , notes = "英文英国")
	private String enGb;
	
	/**
	 * 混淆专用：混淆专用
	*/
	@ApiModelProperty(required = false,value="混淆专用" , notes = "混淆专用")
	private String confuse;
	
	/**
	 * 是否有效：是否有效
	*/
	@ApiModelProperty(required = true,value="是否有效" , notes = "是否有效" , example = "1")
	private Integer valid;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2021-07-25 12:24:17")
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
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "0")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "1")
	private Integer version;
	
	/**
	 * 中文(香港)：中文(香港)
	*/
	@ApiModelProperty(required = false,value="中文(香港)" , notes = "中文(香港)")
	private String zhHk;
	
	/**
	 * 中文(澳门)：中文(澳门)
	*/
	@ApiModelProperty(required = false,value="中文(澳门)" , notes = "中文(澳门)")
	private String zhMo;
	
	/**
	 * 韩语：韩语
	*/
	@ApiModelProperty(required = false,value="韩语" , notes = "韩语")
	private String koKr;
	
	/**
	 * 日语：日语
	*/
	@ApiModelProperty(required = false,value="日语" , notes = "日语")
	private String jaJp;
	
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
	 * 获得 简体中文<br>
	 * 简体中文
	 * @return 简体中文
	*/
	public String getZhCn() {
		return zhCn;
	}
	
	/**
	 * 设置 简体中文
	 * @param zhCn 简体中文
	 * @return 当前对象
	*/
	public Lang setZhCn(String zhCn) {
		this.zhCn=zhCn;
		return this;
	}
	
	/**
	 * 获得 中文(台湾)<br>
	 * 中文(台湾)
	 * @return 中文(台湾)
	*/
	public String getZhTw() {
		return zhTw;
	}
	
	/**
	 * 设置 中文(台湾)
	 * @param zhTw 中文(台湾)
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
	public String getEnGb() {
		return enGb;
	}
	
	/**
	 * 设置 英文英国
	 * @param enGb 英文英国
	 * @return 当前对象
	*/
	public Lang setEnGb(String enGb) {
		this.enGb=enGb;
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
	 * 获得 中文(香港)<br>
	 * 中文(香港)
	 * @return 中文(香港)
	*/
	public String getZhHk() {
		return zhHk;
	}
	
	/**
	 * 设置 中文(香港)
	 * @param zhHk 中文(香港)
	 * @return 当前对象
	*/
	public Lang setZhHk(String zhHk) {
		this.zhHk=zhHk;
		return this;
	}
	
	/**
	 * 获得 中文(澳门)<br>
	 * 中文(澳门)
	 * @return 中文(澳门)
	*/
	public String getZhMo() {
		return zhMo;
	}
	
	/**
	 * 设置 中文(澳门)
	 * @param zhMo 中文(澳门)
	 * @return 当前对象
	*/
	public Lang setZhMo(String zhMo) {
		this.zhMo=zhMo;
		return this;
	}
	
	/**
	 * 获得 韩语<br>
	 * 韩语
	 * @return 韩语
	*/
	public String getKoKr() {
		return koKr;
	}
	
	/**
	 * 设置 韩语
	 * @param koKr 韩语
	 * @return 当前对象
	*/
	public Lang setKoKr(String koKr) {
		this.koKr=koKr;
		return this;
	}
	
	/**
	 * 获得 日语<br>
	 * 日语
	 * @return 日语
	*/
	public String getJaJp() {
		return jaJp;
	}
	
	/**
	 * 设置 日语
	 * @param jaJp 日语
	 * @return 当前对象
	*/
	public Lang setJaJp(String jaJp) {
		this.jaJp=jaJp;
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
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Lang duplicate(boolean all) {
		org.github.foxnic.web.domain.system.meta.LangMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.system.meta.LangMeta.$$proxy$$();
		inst.setZhCn(this.getZhCn());
		inst.setCode(this.getCode());
		inst.setZhTw(this.getZhTw());
		inst.setEnUs(this.getEnUs());
		inst.setZhHk(this.getZhHk());
		inst.setZhMo(this.getZhMo());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setEnGb(this.getEnGb());
		inst.setJaJp(this.getJaJp());
		inst.setVersion(this.getVersion());
		inst.setValid(this.getValid());
		inst.setConfuse(this.getConfuse());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setDefaults(this.getDefaults());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setKoKr(this.getKoKr());
		inst.clearModifies();
		return inst;
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
		Lang po = create();
		EntityContext.copyProperties(po,langMap);
		po.clearModifies();
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
		Lang po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Lang，等同于 new
	 * @return Lang 对象
	*/
	@Transient
	public static Lang create() {
		return new org.github.foxnic.web.domain.system.meta.LangMeta.$$proxy$$();
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
			this.setZhCn(DataParser.parse(String.class, map.get(LangMeta.ZH_CN)));
			this.setCode(DataParser.parse(String.class, map.get(LangMeta.CODE)));
			this.setZhTw(DataParser.parse(String.class, map.get(LangMeta.ZH_TW)));
			this.setEnUs(DataParser.parse(String.class, map.get(LangMeta.EN_US)));
			this.setZhHk(DataParser.parse(String.class, map.get(LangMeta.ZH_HK)));
			this.setZhMo(DataParser.parse(String.class, map.get(LangMeta.ZH_MO)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(LangMeta.UPDATE_TIME)));
			this.setEnGb(DataParser.parse(String.class, map.get(LangMeta.EN_GB)));
			this.setJaJp(DataParser.parse(String.class, map.get(LangMeta.JA_JP)));
			this.setVersion(DataParser.parse(Integer.class, map.get(LangMeta.VERSION)));
			this.setValid(DataParser.parse(Integer.class, map.get(LangMeta.VALID)));
			this.setConfuse(DataParser.parse(String.class, map.get(LangMeta.CONFUSE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(LangMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(LangMeta.DELETED)));
			this.setDefaults(DataParser.parse(String.class, map.get(LangMeta.DEFAULTS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(LangMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(LangMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(LangMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(LangMeta.DELETE_BY)));
			this.setKoKr(DataParser.parse(String.class, map.get(LangMeta.KO_KR)));
			// others
			return true;
		} else {
			try {
				this.setZhCn( (String)map.get(LangMeta.ZH_CN));
				this.setCode( (String)map.get(LangMeta.CODE));
				this.setZhTw( (String)map.get(LangMeta.ZH_TW));
				this.setEnUs( (String)map.get(LangMeta.EN_US));
				this.setZhHk( (String)map.get(LangMeta.ZH_HK));
				this.setZhMo( (String)map.get(LangMeta.ZH_MO));
				this.setUpdateTime( (Date)map.get(LangMeta.UPDATE_TIME));
				this.setEnGb( (String)map.get(LangMeta.EN_GB));
				this.setJaJp( (String)map.get(LangMeta.JA_JP));
				this.setVersion( (Integer)map.get(LangMeta.VERSION));
				this.setValid( (Integer)map.get(LangMeta.VALID));
				this.setConfuse( (String)map.get(LangMeta.CONFUSE));
				this.setCreateBy( (String)map.get(LangMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(LangMeta.DELETED));
				this.setDefaults( (String)map.get(LangMeta.DEFAULTS));
				this.setCreateTime( (Date)map.get(LangMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(LangMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(LangMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(LangMeta.DELETE_BY));
				this.setKoKr( (String)map.get(LangMeta.KO_KR));
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
			this.setZhCn(DataParser.parse(String.class, r.getValue(LangMeta.ZH_CN)));
			this.setCode(DataParser.parse(String.class, r.getValue(LangMeta.CODE)));
			this.setZhTw(DataParser.parse(String.class, r.getValue(LangMeta.ZH_TW)));
			this.setEnUs(DataParser.parse(String.class, r.getValue(LangMeta.EN_US)));
			this.setZhHk(DataParser.parse(String.class, r.getValue(LangMeta.ZH_HK)));
			this.setZhMo(DataParser.parse(String.class, r.getValue(LangMeta.ZH_MO)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(LangMeta.UPDATE_TIME)));
			this.setEnGb(DataParser.parse(String.class, r.getValue(LangMeta.EN_GB)));
			this.setJaJp(DataParser.parse(String.class, r.getValue(LangMeta.JA_JP)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(LangMeta.VERSION)));
			this.setValid(DataParser.parse(Integer.class, r.getValue(LangMeta.VALID)));
			this.setConfuse(DataParser.parse(String.class, r.getValue(LangMeta.CONFUSE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(LangMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(LangMeta.DELETED)));
			this.setDefaults(DataParser.parse(String.class, r.getValue(LangMeta.DEFAULTS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(LangMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(LangMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(LangMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(LangMeta.DELETE_BY)));
			this.setKoKr(DataParser.parse(String.class, r.getValue(LangMeta.KO_KR)));
			return true;
		} else {
			try {
				this.setZhCn( (String)r.getValue(LangMeta.ZH_CN));
				this.setCode( (String)r.getValue(LangMeta.CODE));
				this.setZhTw( (String)r.getValue(LangMeta.ZH_TW));
				this.setEnUs( (String)r.getValue(LangMeta.EN_US));
				this.setZhHk( (String)r.getValue(LangMeta.ZH_HK));
				this.setZhMo( (String)r.getValue(LangMeta.ZH_MO));
				this.setUpdateTime( (Date)r.getValue(LangMeta.UPDATE_TIME));
				this.setEnGb( (String)r.getValue(LangMeta.EN_GB));
				this.setJaJp( (String)r.getValue(LangMeta.JA_JP));
				this.setVersion( (Integer)r.getValue(LangMeta.VERSION));
				this.setValid( (Integer)r.getValue(LangMeta.VALID));
				this.setConfuse( (String)r.getValue(LangMeta.CONFUSE));
				this.setCreateBy( (String)r.getValue(LangMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(LangMeta.DELETED));
				this.setDefaults( (String)r.getValue(LangMeta.DEFAULTS));
				this.setCreateTime( (Date)r.getValue(LangMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(LangMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(LangMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(LangMeta.DELETE_BY));
				this.setKoKr( (String)r.getValue(LangMeta.KO_KR));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}