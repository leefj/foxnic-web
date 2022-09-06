package org.github.foxnic.web.domain.dataperm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.DP_RULE_RANGE;
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
 * 数据权限规则范围
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:45:34
 * @sign D27FAC8770628CC1CEAB77456B7B2D86
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "dp_rule_range")
public class RuleRange extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =DP_RULE_RANGE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 规则ID：规则ID
	*/
	@ApiModelProperty(required = false,value="规则ID" , notes = "规则ID")
	private String ruleId;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 是否生效：相同的代码仅可以有一个是生效的
	*/
	@ApiModelProperty(required = false,value="是否生效" , notes = "相同的代码仅可以有一个是生效的")
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
	 * 条件列表：用于构建条件语句
	*/
	@ApiModelProperty(required = false,value="条件列表" , notes = "用于构建条件语句")
	private List<RuleCondition> conditions;
	
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
	public RuleRange setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 规则ID<br>
	 * 规则ID
	 * @return 规则ID
	*/
	public String getRuleId() {
		return ruleId;
	}
	
	/**
	 * 设置 规则ID
	 * @param ruleId 规则ID
	 * @return 当前对象
	*/
	public RuleRange setRuleId(String ruleId) {
		this.ruleId=ruleId;
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
	public RuleRange setName(String name) {
		this.name=name;
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
	public RuleRange setValid(Integer valid) {
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
	public RuleRange setCreateBy(String createBy) {
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
	public RuleRange setCreateTime(Date createTime) {
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
	public RuleRange setUpdateBy(String updateBy) {
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
	public RuleRange setUpdateTime(Date updateTime) {
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
	public RuleRange setDeleted(Integer deleted) {
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
	public RuleRange setDeleted(Boolean deletedBool) {
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
	public RuleRange setDeleteBy(String deleteBy) {
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
	public RuleRange setDeleteTime(Date deleteTime) {
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
	public RuleRange setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 条件列表<br>
	 * 用于构建条件语句
	 * @return 条件列表
	*/
	public List<RuleCondition> getConditions() {
		return conditions;
	}
	
	/**
	 * 设置 条件列表
	 * @param conditions 条件列表
	 * @return 当前对象
	*/
	public RuleRange setConditions(List<RuleCondition> conditions) {
		this.conditions=conditions;
		return this;
	}
	
	/**
	 * 添加 条件列表
	 * @param condition 条件列表
	 * @return 当前对象
	*/
	public RuleRange addCondition(RuleCondition... condition) {
		if(this.conditions==null) conditions=new ArrayList<>();
		this.conditions.addAll(Arrays.asList(condition));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return RuleRange , 转换好的 RuleRange 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return RuleRange , 转换好的 PoJo 对象
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
	public RuleRange clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public RuleRange duplicate(boolean all) {
		org.github.foxnic.web.domain.dataperm.meta.RuleRangeMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.dataperm.meta.RuleRangeMeta.$$proxy$$();
		inst.setValid(this.getValid());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setRuleId(this.getRuleId());
		inst.setVersion(this.getVersion());
		if(all) {
			inst.setConditions(this.getConditions());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public RuleRange clone(boolean deep) {
		return EntityContext.clone(RuleRange.class,this,deep);
	}

	/**
	 * 将 Map 转换成 RuleRange
	 * @param ruleRangeMap 包含实体信息的 Map 对象
	 * @return RuleRange , 转换好的的 RuleRange 对象
	*/
	@Transient
	public static RuleRange createFrom(Map<String,Object> ruleRangeMap) {
		if(ruleRangeMap==null) return null;
		RuleRange po = EntityContext.create(RuleRange.class, ruleRangeMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 RuleRange
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return RuleRange , 转换好的的 RuleRange 对象
	*/
	@Transient
	public static RuleRange createFrom(Object pojo) {
		if(pojo==null) return null;
		RuleRange po = EntityContext.create(RuleRange.class,pojo);
		return po;
	}

	/**
	 * 创建一个 RuleRange，等同于 new
	 * @return RuleRange 对象
	*/
	@Transient
	public static RuleRange create() {
		return EntityContext.create(RuleRange.class);
	}
}