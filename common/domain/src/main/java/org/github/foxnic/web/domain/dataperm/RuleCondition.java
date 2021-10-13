package org.github.foxnic.web.domain.dataperm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.DP_RULE_CONDITION;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 数据权限规则范围条件
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-13 15:51:45
 * @sign BD026648FFC1F832F36F9BB7E937310F
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
	 * range：id
	*/
	@ApiModelProperty(required = false,value="range" , notes = "id")
	private String rangeId;
	
	/**
	 * 上级ID：上级ID
	*/
	@ApiModelProperty(required = false,value="上级ID" , notes = "上级ID")
	private String parentId;
	
	/**
	 * 数据表：数据表
	*/
	@ApiModelProperty(required = false,value="数据表" , notes = "数据表")
	private String dataTable;
	
	/**
	 * 表达式类型：表达式类型
	*/
	@ApiModelProperty(required = false,value="表达式类型" , notes = "表达式类型")
	private String exprType;
	
	/**
	 * 逻辑关系可选值：and/or
	*/
	@ApiModelProperty(required = false,value="逻辑关系可选值" , notes = "and/or")
	private String logic;
	
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
	 * 获得 数据表<br>
	 * 数据表
	 * @return 数据表
	*/
	public String getDataTable() {
		return dataTable;
	}
	
	/**
	 * 设置 数据表
	 * @param dataTable 数据表
	 * @return 当前对象
	*/
	public RuleCondition setDataTable(String dataTable) {
		this.dataTable=dataTable;
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
	 * 设置 表达式类型
	 * @param exprType 表达式类型
	 * @return 当前对象
	*/
	public RuleCondition setExprType(String exprType) {
		this.exprType=exprType;
		return this;
	}
	
	/**
	 * 获得 逻辑关系可选值<br>
	 * and/or
	 * @return 逻辑关系可选值
	*/
	public String getLogic() {
		return logic;
	}
	
	/**
	 * 设置 逻辑关系可选值
	 * @param logic 逻辑关系可选值
	 * @return 当前对象
	*/
	public RuleCondition setLogic(String logic) {
		this.logic=logic;
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