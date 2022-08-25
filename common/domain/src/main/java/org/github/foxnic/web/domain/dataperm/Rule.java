package org.github.foxnic.web.domain.dataperm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.DP_RULE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.List;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 数据权限规则
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-25 11:12:12
 * @sign DB0380B37004D61BDEDE602959A9EC06
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "dp_rule")
public class Rule extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =DP_RULE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * po类型：po类型
	*/
	@ApiModelProperty(required = false,value="po类型" , notes = "po类型")
	private String poType;
	
	/**
	 * 代码：代码
	*/
	@ApiModelProperty(required = false,value="代码" , notes = "代码")
	private String code;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 规则版本号：规则版本号
	*/
	@ApiModelProperty(required = false,value="规则版本号" , notes = "规则版本号")
	private Integer versionNo;
	
	/**
	 * 是否生效：相同的代码仅可以有一个是生效的
	*/
	@ApiModelProperty(required = false,value="是否生效" , notes = "相同的代码仅可以有一个是生效的")
	private Integer valid;
	
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
	 * 约束范围列表：约束范围列表
	*/
	@ApiModelProperty(required = false,value="约束范围列表" , notes = "约束范围列表")
	private List<RuleRange> ranges;
	
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
	public Rule setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 po类型<br>
	 * po类型
	 * @return po类型
	*/
	public String getPoType() {
		return poType;
	}
	
	/**
	 * 设置 po类型
	 * @param poType po类型
	 * @return 当前对象
	*/
	public Rule setPoType(String poType) {
		this.poType=poType;
		return this;
	}
	
	/**
	 * 获得 代码<br>
	 * 代码
	 * @return 代码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 代码
	 * @param code 代码
	 * @return 当前对象
	*/
	public Rule setCode(String code) {
		this.code=code;
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
	public Rule setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 规则版本号<br>
	 * 规则版本号
	 * @return 规则版本号
	*/
	public Integer getVersionNo() {
		return versionNo;
	}
	
	/**
	 * 设置 规则版本号
	 * @param versionNo 规则版本号
	 * @return 当前对象
	*/
	public Rule setVersionNo(Integer versionNo) {
		this.versionNo=versionNo;
		return this;
	}
	
	/**
	 * 获得 是否生效<br>
	 * 相同的代码仅可以有一个是生效的
	 * @return 是否生效
	*/
	public Integer getValid() {
		return valid;
	}
	
	/**
	 * 设置 是否生效
	 * @param valid 是否生效
	 * @return 当前对象
	*/
	public Rule setValid(Integer valid) {
		this.valid=valid;
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
	public Rule setNotes(String notes) {
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
	public Rule setCreateBy(String createBy) {
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
	public Rule setCreateTime(Date createTime) {
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
	public Rule setUpdateBy(String updateBy) {
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
	public Rule setUpdateTime(Date updateTime) {
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
	public Rule setDeleted(Integer deleted) {
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
	public Rule setDeleted(Boolean deletedBool) {
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
	public Rule setDeleteBy(String deleteBy) {
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
	public Rule setDeleteTime(Date deleteTime) {
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
	public Rule setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 约束范围列表<br>
	 * 约束范围列表
	 * @return 约束范围列表
	*/
	public List<RuleRange> getRanges() {
		return ranges;
	}
	
	/**
	 * 设置 约束范围列表
	 * @param ranges 约束范围列表
	 * @return 当前对象
	*/
	public Rule setRanges(List<RuleRange> ranges) {
		this.ranges=ranges;
		return this;
	}
	
	/**
	 * 添加 约束范围列表
	 * @param range 约束范围列表
	 * @return 当前对象
	*/
	public Rule addRange(RuleRange... range) {
		if(this.ranges==null) ranges=new ArrayList<>();
		this.ranges.addAll(Arrays.asList(range));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Rule , 转换好的 Rule 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Rule , 转换好的 PoJo 对象
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
	public Rule clone() {
		return EntityContext.clone(Rule.class,this);
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Rule clone(boolean deep) {
		return EntityContext.clone(Rule.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Rule
	 * @param ruleMap 包含实体信息的 Map 对象
	 * @return Rule , 转换好的的 Rule 对象
	*/
	@Transient
	public static Rule createFrom(Map<String,Object> ruleMap) {
		if(ruleMap==null) return null;
		Rule po = EntityContext.create(Rule.class, ruleMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Rule
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Rule , 转换好的的 Rule 对象
	*/
	@Transient
	public static Rule createFrom(Object pojo) {
		if(pojo==null) return null;
		Rule po = EntityContext.create(Rule.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Rule，等同于 new
	 * @return Rule 对象
	*/
	@Transient
	public static Rule create() {
		return EntityContext.create(Rule.class);
	}
}