package org.github.foxnic.web.domain.changes;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.CHS_CHANGE_DEFINITION;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.enums.changes.ApprovalMode;
import javax.persistence.Transient;
import java.util.Date;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 变更定义
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-02 09:07:40
 * @sign 3218AA84200BE1D2A45EC967705EEF21
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "chs_change_definition")
public class ChangeDefinition extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =CHS_CHANGE_DEFINITION.$TABLE;
	
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
	 * 代码：代码
	*/
	@ApiModelProperty(required = false,value="代码" , notes = "代码")
	private String code;
	
	/**
	 * 审批模式：审批模式
	*/
	@ApiModelProperty(required = false,value="审批模式" , notes = "审批模式")
	private String mode;
	@Transient
	private ApprovalMode modeEnum;
	
	/**
	 * 默认审批人ID：适用于简单审批模式
	*/
	@ApiModelProperty(required = false,value="默认审批人ID" , notes = "适用于简单审批模式")
	private String simpleApproverIds;
	
	/**
	 * 审批逻辑：适用于简单审批模式
	*/
	@ApiModelProperty(required = false,value="审批逻辑" , notes = "适用于简单审批模式")
	private String simpleApprovalLogic;
	
	/**
	 * 审批处理类：审批处理类
	*/
	@ApiModelProperty(required = false,value="审批处理类" , notes = "审批处理类")
	private String simpleHandler;
	
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
	public ChangeDefinition setId(String id) {
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
	public ChangeDefinition setName(String name) {
		this.name=name;
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
	public ChangeDefinition setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 审批模式<br>
	 * 审批模式
	 * @return 审批模式
	*/
	public String getMode() {
		return mode;
	}
	
	/**
	 * 获得 审批模式 的投影属性<br>
	 * 等价于 getMode 方法，获得对应的枚举类型
	 * @return 审批模式
	*/
	@Transient
	public ApprovalMode getModeEnum() {
		if(this.modeEnum==null) {
			this.modeEnum = (ApprovalMode) EnumUtil.parseByCode(ApprovalMode.values(),mode);
		}
		return this.modeEnum ;
	}
	
	/**
	 * 设置 审批模式
	 * @param mode 审批模式
	 * @return 当前对象
	*/
	public ChangeDefinition setMode(String mode) {
		this.mode=mode;
		this.modeEnum= (ApprovalMode) EnumUtil.parseByCode(ApprovalMode.values(),mode) ;
		if(StringUtil.hasContent(mode) && this.modeEnum==null) {
			throw new IllegalArgumentException( mode + " is not one of ApprovalMode");
		}
		return this;
	}
	
	/**
	 * 设置 审批模式的投影属性，等同于设置 审批模式
	 * @param modeEnum 审批模式
	 * @return 当前对象
	*/
	@Transient
	public ChangeDefinition setModeEnum(ApprovalMode modeEnum) {
		if(modeEnum==null) {
			this.setMode(null);
		} else {
			this.setMode(modeEnum.code());
		}
		this.modeEnum=modeEnum;
		return this;
	}
	
	/**
	 * 获得 默认审批人ID<br>
	 * 适用于简单审批模式
	 * @return 默认审批人ID
	*/
	public String getSimpleApproverIds() {
		return simpleApproverIds;
	}
	
	/**
	 * 设置 默认审批人ID
	 * @param simpleApproverIds 默认审批人ID
	 * @return 当前对象
	*/
	public ChangeDefinition setSimpleApproverIds(String simpleApproverIds) {
		this.simpleApproverIds=simpleApproverIds;
		return this;
	}
	
	/**
	 * 获得 审批逻辑<br>
	 * 适用于简单审批模式
	 * @return 审批逻辑
	*/
	public String getSimpleApprovalLogic() {
		return simpleApprovalLogic;
	}
	
	/**
	 * 设置 审批逻辑
	 * @param simpleApprovalLogic 审批逻辑
	 * @return 当前对象
	*/
	public ChangeDefinition setSimpleApprovalLogic(String simpleApprovalLogic) {
		this.simpleApprovalLogic=simpleApprovalLogic;
		return this;
	}
	
	/**
	 * 获得 审批处理类<br>
	 * 审批处理类
	 * @return 审批处理类
	*/
	public String getSimpleHandler() {
		return simpleHandler;
	}
	
	/**
	 * 设置 审批处理类
	 * @param simpleHandler 审批处理类
	 * @return 当前对象
	*/
	public ChangeDefinition setSimpleHandler(String simpleHandler) {
		this.simpleHandler=simpleHandler;
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
	public ChangeDefinition setValid(Integer valid) {
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
	public ChangeDefinition setCreateBy(String createBy) {
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
	public ChangeDefinition setCreateTime(Date createTime) {
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
	public ChangeDefinition setUpdateBy(String updateBy) {
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
	public ChangeDefinition setUpdateTime(Date updateTime) {
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
	public ChangeDefinition setDeleted(Integer deleted) {
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
	public ChangeDefinition setDeleteBy(String deleteBy) {
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
	public ChangeDefinition setDeleteTime(Date deleteTime) {
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
	public ChangeDefinition setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ChangeDefinition , 转换好的 ChangeDefinition 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ChangeDefinition , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ChangeDefinition
	 * @param changeDefinitionMap 包含实体信息的 Map 对象
	 * @return ChangeDefinition , 转换好的的 ChangeDefinition 对象
	*/
	@Transient
	public static ChangeDefinition createFrom(Map<String,Object> changeDefinitionMap) {
		if(changeDefinitionMap==null) return null;
		ChangeDefinition po = EntityContext.create(ChangeDefinition.class, changeDefinitionMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ChangeDefinition
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ChangeDefinition , 转换好的的 ChangeDefinition 对象
	*/
	@Transient
	public static ChangeDefinition createFrom(Object pojo) {
		if(pojo==null) return null;
		ChangeDefinition po = EntityContext.create(ChangeDefinition.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ChangeDefinition，等同于 new
	 * @return ChangeDefinition 对象
	*/
	@Transient
	public static ChangeDefinition create() {
		return EntityContext.create(ChangeDefinition.class);
	}
}