package org.github.foxnic.web.domain.dataperm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.DP_RULE_CONDITION;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import com.github.foxnic.api.dataperm.ConditionNodeType;
import javax.persistence.Transient;
import com.github.foxnic.api.dataperm.LogicType;
import com.github.foxnic.api.dataperm.ExprType;
import java.util.Date;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 数据权限规则范围条件
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-06 06:07:05
 * @sign 7A5354E3A28843E02CFA13476D252C14
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "dp_rule_condition")
public class RuleCondition extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =DP_RULE_CONDITION.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 抬头：抬头
	*/
	@ApiModelProperty(required = false,value="抬头" , notes = "抬头")
	private String title;
	
	/**
	 * 应用条件：SpringEL表达式，返回 true / false
	*/
	@ApiModelProperty(required = false,value="应用条件" , notes = "SpringEL表达式，返回 true / false")
	private String conditionExpr;
	
	/**
	 * 应用条件测试值：JSON
	*/
	@ApiModelProperty(required = false,value="应用条件测试值" , notes = "JSON")
	private String conditionTestValue;
	
	/**
	 * 规则ID：规则ID
	*/
	@ApiModelProperty(required = false,value="规则ID" , notes = "规则ID")
	private String ruleId;
	
	/**
	 * range：id
	*/
	@ApiModelProperty(required = false,value="range" , notes = "id")
	private String rangeId;
	
	/**
	 * 层级路径：层级路径
	*/
	@ApiModelProperty(required = false,value="层级路径" , notes = "层级路径")
	private String hierarchy;
	
	/**
	 * 上级ID：上级ID
	*/
	@ApiModelProperty(required = false,value="上级ID" , notes = "上级ID")
	private String parentId;
	
	/**
	 * 查询的属性路径：查询的属性路径
	*/
	@ApiModelProperty(required = false,value="查询的属性路径" , notes = "查询的属性路径")
	private String queryProperty;
	
	/**
	 * 查询字段：查询字段
	*/
	@ApiModelProperty(required = false,value="查询字段" , notes = "查询字段")
	private String queryField;
	
	/**
	 * 节点类型：逻辑组/表达式
	*/
	@ApiModelProperty(required = true,value="节点类型" , notes = "逻辑组/表达式")
	private String type;
	@Transient
	private ConditionNodeType typeEnum;
	
	/**
	 * 前置逻辑关系：and/or
	*/
	@ApiModelProperty(required = false,value="前置逻辑关系" , notes = "and/or")
	private String logic;
	@Transient
	private LogicType logicEnum;
	
	/**
	 * 表达式类型：表达式类型
	*/
	@ApiModelProperty(required = false,value="表达式类型" , notes = "表达式类型")
	private String exprType;
	@Transient
	private ExprType exprTypeEnum;
	
	/**
	 * 是否生效：相同的代码仅可以有一个是生效的
	*/
	@ApiModelProperty(required = false,value="是否生效" , notes = "相同的代码仅可以有一个是生效的")
	private Integer valid;
	
	/**
	 * 变量：数组或Map结构
	*/
	@ApiModelProperty(required = false,value="变量" , notes = "数组或Map结构")
	private String variables;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序")
	private Integer sort;
	
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
	public RuleCondition setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 抬头<br>
	 * 抬头
	 * @return 抬头
	*/
	public String getTitle() {
		return title;
	}
	
	/**
	 * 设置 抬头
	 * @param title 抬头
	 * @return 当前对象
	*/
	public RuleCondition setTitle(String title) {
		this.title=title;
		return this;
	}
	
	/**
	 * 获得 应用条件<br>
	 * SpringEL表达式，返回 true / false
	 * @return 应用条件
	*/
	public String getConditionExpr() {
		return conditionExpr;
	}
	
	/**
	 * 设置 应用条件
	 * @param conditionExpr 应用条件
	 * @return 当前对象
	*/
	public RuleCondition setConditionExpr(String conditionExpr) {
		this.conditionExpr=conditionExpr;
		return this;
	}
	
	/**
	 * 获得 应用条件测试值<br>
	 * JSON
	 * @return 应用条件测试值
	*/
	public String getConditionTestValue() {
		return conditionTestValue;
	}
	
	/**
	 * 设置 应用条件测试值
	 * @param conditionTestValue 应用条件测试值
	 * @return 当前对象
	*/
	public RuleCondition setConditionTestValue(String conditionTestValue) {
		this.conditionTestValue=conditionTestValue;
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
	public RuleCondition setRuleId(String ruleId) {
		this.ruleId=ruleId;
		return this;
	}
	
	/**
	 * 获得 range<br>
	 * id
	 * @return range
	*/
	public String getRangeId() {
		return rangeId;
	}
	
	/**
	 * 设置 range
	 * @param rangeId range
	 * @return 当前对象
	*/
	public RuleCondition setRangeId(String rangeId) {
		this.rangeId=rangeId;
		return this;
	}
	
	/**
	 * 获得 层级路径<br>
	 * 层级路径
	 * @return 层级路径
	*/
	public String getHierarchy() {
		return hierarchy;
	}
	
	/**
	 * 设置 层级路径
	 * @param hierarchy 层级路径
	 * @return 当前对象
	*/
	public RuleCondition setHierarchy(String hierarchy) {
		this.hierarchy=hierarchy;
		return this;
	}
	
	/**
	 * 获得 上级ID<br>
	 * 上级ID
	 * @return 上级ID
	*/
	public String getParentId() {
		return parentId;
	}
	
	/**
	 * 设置 上级ID
	 * @param parentId 上级ID
	 * @return 当前对象
	*/
	public RuleCondition setParentId(String parentId) {
		this.parentId=parentId;
		return this;
	}
	
	/**
	 * 获得 查询的属性路径<br>
	 * 查询的属性路径
	 * @return 查询的属性路径
	*/
	public String getQueryProperty() {
		return queryProperty;
	}
	
	/**
	 * 设置 查询的属性路径
	 * @param queryProperty 查询的属性路径
	 * @return 当前对象
	*/
	public RuleCondition setQueryProperty(String queryProperty) {
		this.queryProperty=queryProperty;
		return this;
	}
	
	/**
	 * 获得 查询字段<br>
	 * 查询字段
	 * @return 查询字段
	*/
	public String getQueryField() {
		return queryField;
	}
	
	/**
	 * 设置 查询字段
	 * @param queryField 查询字段
	 * @return 当前对象
	*/
	public RuleCondition setQueryField(String queryField) {
		this.queryField=queryField;
		return this;
	}
	
	/**
	 * 获得 节点类型<br>
	 * 逻辑组/表达式
	 * @return 节点类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 获得 节点类型 的投影属性<br>
	 * 等价于 getType 方法，获得对应的枚举类型
	 * @return 节点类型
	*/
	@Transient
	public ConditionNodeType getTypeEnum() {
		if(this.typeEnum==null) {
			this.typeEnum = (ConditionNodeType) EnumUtil.parseByCode(ConditionNodeType.values(),type);
		}
		return this.typeEnum ;
	}
	
	/**
	 * 设置 节点类型
	 * @param type 节点类型
	 * @return 当前对象
	*/
	public RuleCondition setType(String type) {
		this.type=type;
		this.typeEnum= (ConditionNodeType) EnumUtil.parseByCode(ConditionNodeType.values(),type) ;
		if(StringUtil.hasContent(type) && this.typeEnum==null) {
			throw new IllegalArgumentException( type + " is not one of ConditionNodeType");
		}
		return this;
	}
	
	/**
	 * 设置 节点类型的投影属性，等同于设置 节点类型
	 * @param typeEnum 节点类型
	 * @return 当前对象
	*/
	@Transient
	public RuleCondition setTypeEnum(ConditionNodeType typeEnum) {
		if(typeEnum==null) {
			this.setType(null);
		} else {
			this.setType(typeEnum.code());
		}
		this.typeEnum=typeEnum;
		return this;
	}
	
	/**
	 * 获得 前置逻辑关系<br>
	 * and/or
	 * @return 前置逻辑关系
	*/
	public String getLogic() {
		return logic;
	}
	
	/**
	 * 获得 前置逻辑关系 的投影属性<br>
	 * 等价于 getLogic 方法，获得对应的枚举类型
	 * @return 前置逻辑关系
	*/
	@Transient
	public LogicType getLogicEnum() {
		if(this.logicEnum==null) {
			this.logicEnum = (LogicType) EnumUtil.parseByCode(LogicType.values(),logic);
		}
		return this.logicEnum ;
	}
	
	/**
	 * 设置 前置逻辑关系
	 * @param logic 前置逻辑关系
	 * @return 当前对象
	*/
	public RuleCondition setLogic(String logic) {
		this.logic=logic;
		this.logicEnum= (LogicType) EnumUtil.parseByCode(LogicType.values(),logic) ;
		if(StringUtil.hasContent(logic) && this.logicEnum==null) {
			throw new IllegalArgumentException( logic + " is not one of LogicType");
		}
		return this;
	}
	
	/**
	 * 设置 前置逻辑关系的投影属性，等同于设置 前置逻辑关系
	 * @param logicEnum 前置逻辑关系
	 * @return 当前对象
	*/
	@Transient
	public RuleCondition setLogicEnum(LogicType logicEnum) {
		if(logicEnum==null) {
			this.setLogic(null);
		} else {
			this.setLogic(logicEnum.code());
		}
		this.logicEnum=logicEnum;
		return this;
	}
	
	/**
	 * 获得 表达式类型<br>
	 * 表达式类型
	 * @return 表达式类型
	*/
	public String getExprType() {
		return exprType;
	}
	
	/**
	 * 获得 表达式类型 的投影属性<br>
	 * 等价于 getExprType 方法，获得对应的枚举类型
	 * @return 表达式类型
	*/
	@Transient
	public ExprType getExprTypeEnum() {
		if(this.exprTypeEnum==null) {
			this.exprTypeEnum = (ExprType) EnumUtil.parseByCode(ExprType.values(),exprType);
		}
		return this.exprTypeEnum ;
	}
	
	/**
	 * 设置 表达式类型
	 * @param exprType 表达式类型
	 * @return 当前对象
	*/
	public RuleCondition setExprType(String exprType) {
		this.exprType=exprType;
		this.exprTypeEnum= (ExprType) EnumUtil.parseByCode(ExprType.values(),exprType) ;
		if(StringUtil.hasContent(exprType) && this.exprTypeEnum==null) {
			throw new IllegalArgumentException( exprType + " is not one of ExprType");
		}
		return this;
	}
	
	/**
	 * 设置 表达式类型的投影属性，等同于设置 表达式类型
	 * @param exprTypeEnum 表达式类型
	 * @return 当前对象
	*/
	@Transient
	public RuleCondition setExprTypeEnum(ExprType exprTypeEnum) {
		if(exprTypeEnum==null) {
			this.setExprType(null);
		} else {
			this.setExprType(exprTypeEnum.code());
		}
		this.exprTypeEnum=exprTypeEnum;
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
	public RuleCondition setValid(Integer valid) {
		this.valid=valid;
		return this;
	}
	
	/**
	 * 获得 变量<br>
	 * 数组或Map结构
	 * @return 变量
	*/
	public String getVariables() {
		return variables;
	}
	
	/**
	 * 设置 变量
	 * @param variables 变量
	 * @return 当前对象
	*/
	public RuleCondition setVariables(String variables) {
		this.variables=variables;
		return this;
	}
	
	/**
	 * 获得 排序<br>
	 * 排序
	 * @return 排序
	*/
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 排序
	 * @param sort 排序
	 * @return 当前对象
	*/
	public RuleCondition setSort(Integer sort) {
		this.sort=sort;
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
	public RuleCondition setNotes(String notes) {
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
	public RuleCondition setCreateBy(String createBy) {
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
	public RuleCondition setCreateTime(Date createTime) {
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
	public RuleCondition setUpdateBy(String updateBy) {
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
	public RuleCondition setUpdateTime(Date updateTime) {
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
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public RuleCondition setDeleted(Integer deleted) {
		this.deleted=deleted;
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
	public RuleCondition setDeleteBy(String deleteBy) {
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
	public RuleCondition setDeleteTime(Date deleteTime) {
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
	public RuleCondition setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return RuleCondition , 转换好的 RuleCondition 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return RuleCondition , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 RuleCondition
	 * @param ruleConditionMap 包含实体信息的 Map 对象
	 * @return RuleCondition , 转换好的的 RuleCondition 对象
	*/
	@Transient
	public static RuleCondition createFrom(Map<String,Object> ruleConditionMap) {
		if(ruleConditionMap==null) return null;
		RuleCondition po = EntityContext.create(RuleCondition.class, ruleConditionMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 RuleCondition
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return RuleCondition , 转换好的的 RuleCondition 对象
	*/
	@Transient
	public static RuleCondition createFrom(Object pojo) {
		if(pojo==null) return null;
		RuleCondition po = EntityContext.create(RuleCondition.class,pojo);
		return po;
	}

	/**
	 * 创建一个 RuleCondition，等同于 new
	 * @return RuleCondition 对象
	*/
	@Transient
	public static RuleCondition create() {
		return EntityContext.create(RuleCondition.class);
	}
}