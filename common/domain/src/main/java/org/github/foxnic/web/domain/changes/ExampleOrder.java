package org.github.foxnic.web.domain.changes;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.CHS_EXAMPLE_ORDER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
import org.github.foxnic.web.constants.enums.changes.ChangeType;
import javax.persistence.Transient;
import org.github.foxnic.web.constants.enums.changes.ApprovalStatus;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import java.util.ArrayList;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 变更示例订单
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-02 08:50:55
 * @sign 7D9B96AB853530FD4D6F5B17F7A499D3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "chs_example_order")
public class ExampleOrder extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =CHS_EXAMPLE_ORDER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 标题：标题
	*/
	@ApiModelProperty(required = false,value="标题" , notes = "标题")
	private String title;
	
	/**
	 * 订单编号：订单编号
	*/
	@ApiModelProperty(required = false,value="订单编号" , notes = "订单编号")
	private String code;
	
	/**
	 * 下单时间：下单时间
	*/
	@ApiModelProperty(required = false,value="下单时间" , notes = "下单时间")
	private Date orderTime;
	
	/**
	 * 买家ID：买家ID
	*/
	@ApiModelProperty(required = false,value="买家ID" , notes = "买家ID")
	private String buyerId;
	
	/**
	 * 收件地址：收件地址
	*/
	@ApiModelProperty(required = false,value="收件地址" , notes = "收件地址")
	private String address;
	
	/**
	 * 总金额：总金额
	*/
	@ApiModelProperty(required = false,value="总金额" , notes = "总金额")
	private BigDecimal amount;
	
	/**
	 * 变更类型：变更类型
	*/
	@ApiModelProperty(required = false,value="变更类型" , notes = "变更类型")
	private String chsType;
	@Transient
	private ChangeType chsTypeEnum;
	
	/**
	 * 变更状态：变更状态
	*/
	@ApiModelProperty(required = false,value="变更状态" , notes = "变更状态")
	private String chsStatus;
	@Transient
	private ApprovalStatus chsStatusEnum;
	
	/**
	 * 变更版本号：变更版本号
	*/
	@ApiModelProperty(required = false,value="变更版本号" , notes = "变更版本号")
	private Integer chsVersion;
	
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
	 * 来源ID：来源ID
	*/
	@ApiModelProperty(required = false,value="来源ID" , notes = "来源ID")
	private String sourceId;
	
	/**
	 * 变更ID：变更ID
	*/
	@ApiModelProperty(required = false,value="变更ID" , notes = "变更ID")
	private String changeInstanceId;
	
	/**
	 * 流程概要：流程概要
	*/
	@ApiModelProperty(required = false,value="流程概要" , notes = "流程概要")
	private String summary;
	
	/**
	 * 最后审批人账户ID：最后审批人账户ID
	*/
	@ApiModelProperty(required = false,value="最后审批人账户ID" , notes = "最后审批人账户ID")
	private String latestApproverId;
	
	/**
	 * 最后审批人姓名：最后审批人姓名
	*/
	@ApiModelProperty(required = false,value="最后审批人姓名" , notes = "最后审批人姓名")
	private String latestApproverName;
	
	/**
	 * 下一节点审批人：下一节点审批人
	*/
	@ApiModelProperty(required = false,value="下一节点审批人" , notes = "下一节点审批人")
	private String nextApproverIds;
	
	/**
	 * 下一个审批节点审批人姓名：用逗号隔开
	*/
	@ApiModelProperty(required = false,value="下一个审批节点审批人姓名" , notes = "用逗号隔开")
	private String nextApproverNames;
	
	/**
	 * 订单明细：订单明细
	*/
	@ApiModelProperty(required = false,value="订单明细" , notes = "订单明细")
	private List<ExampleOrderItem> items;
	
	/**
	 * 采购人：采购人
	*/
	@ApiModelProperty(required = false,value="采购人" , notes = "采购人")
	private Employee buyerEmployee;
	
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
	public ExampleOrder setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 标题<br>
	 * 标题
	 * @return 标题
	*/
	public String getTitle() {
		return title;
	}
	
	/**
	 * 设置 标题
	 * @param title 标题
	 * @return 当前对象
	*/
	public ExampleOrder setTitle(String title) {
		this.title=title;
		return this;
	}
	
	/**
	 * 获得 订单编号<br>
	 * 订单编号
	 * @return 订单编号
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 订单编号
	 * @param code 订单编号
	 * @return 当前对象
	*/
	public ExampleOrder setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 下单时间<br>
	 * 下单时间
	 * @return 下单时间
	*/
	public Date getOrderTime() {
		return orderTime;
	}
	
	/**
	 * 设置 下单时间
	 * @param orderTime 下单时间
	 * @return 当前对象
	*/
	public ExampleOrder setOrderTime(Date orderTime) {
		this.orderTime=orderTime;
		return this;
	}
	
	/**
	 * 获得 买家ID<br>
	 * 买家ID
	 * @return 买家ID
	*/
	public String getBuyerId() {
		return buyerId;
	}
	
	/**
	 * 设置 买家ID
	 * @param buyerId 买家ID
	 * @return 当前对象
	*/
	public ExampleOrder setBuyerId(String buyerId) {
		this.buyerId=buyerId;
		return this;
	}
	
	/**
	 * 获得 收件地址<br>
	 * 收件地址
	 * @return 收件地址
	*/
	public String getAddress() {
		return address;
	}
	
	/**
	 * 设置 收件地址
	 * @param address 收件地址
	 * @return 当前对象
	*/
	public ExampleOrder setAddress(String address) {
		this.address=address;
		return this;
	}
	
	/**
	 * 获得 总金额<br>
	 * 总金额
	 * @return 总金额
	*/
	public BigDecimal getAmount() {
		return amount;
	}
	
	/**
	 * 设置 总金额
	 * @param amount 总金额
	 * @return 当前对象
	*/
	public ExampleOrder setAmount(BigDecimal amount) {
		this.amount=amount;
		return this;
	}
	
	/**
	 * 获得 变更类型<br>
	 * 变更类型
	 * @return 变更类型
	*/
	public String getChsType() {
		return chsType;
	}
	
	/**
	 * 获得 变更类型 的投影属性<br>
	 * 等价于 getChsType 方法，获得对应的枚举类型
	 * @return 变更类型
	*/
	@Transient
	public ChangeType getChsTypeEnum() {
		if(this.chsTypeEnum==null) {
			this.chsTypeEnum = (ChangeType) EnumUtil.parseByCode(ChangeType.values(),chsType);
		}
		return this.chsTypeEnum ;
	}
	
	/**
	 * 设置 变更类型
	 * @param chsType 变更类型
	 * @return 当前对象
	*/
	public ExampleOrder setChsType(String chsType) {
		this.chsType=chsType;
		this.chsTypeEnum= (ChangeType) EnumUtil.parseByCode(ChangeType.values(),chsType) ;
		if(StringUtil.hasContent(chsType) && this.chsTypeEnum==null) {
			throw new IllegalArgumentException( chsType + " is not one of ChangeType");
		}
		return this;
	}
	
	/**
	 * 设置 变更类型的投影属性，等同于设置 变更类型
	 * @param chsTypeEnum 变更类型
	 * @return 当前对象
	*/
	@Transient
	public ExampleOrder setChsTypeEnum(ChangeType chsTypeEnum) {
		if(chsTypeEnum==null) {
			this.setChsType(null);
		} else {
			this.setChsType(chsTypeEnum.code());
		}
		this.chsTypeEnum=chsTypeEnum;
		return this;
	}
	
	/**
	 * 获得 变更状态<br>
	 * 变更状态
	 * @return 变更状态
	*/
	public String getChsStatus() {
		return chsStatus;
	}
	
	/**
	 * 获得 变更状态 的投影属性<br>
	 * 等价于 getChsStatus 方法，获得对应的枚举类型
	 * @return 变更状态
	*/
	@Transient
	public ApprovalStatus getChsStatusEnum() {
		if(this.chsStatusEnum==null) {
			this.chsStatusEnum = (ApprovalStatus) EnumUtil.parseByCode(ApprovalStatus.values(),chsStatus);
		}
		return this.chsStatusEnum ;
	}
	
	/**
	 * 设置 变更状态
	 * @param chsStatus 变更状态
	 * @return 当前对象
	*/
	public ExampleOrder setChsStatus(String chsStatus) {
		this.chsStatus=chsStatus;
		this.chsStatusEnum= (ApprovalStatus) EnumUtil.parseByCode(ApprovalStatus.values(),chsStatus) ;
		if(StringUtil.hasContent(chsStatus) && this.chsStatusEnum==null) {
			throw new IllegalArgumentException( chsStatus + " is not one of ApprovalStatus");
		}
		return this;
	}
	
	/**
	 * 设置 变更状态的投影属性，等同于设置 变更状态
	 * @param chsStatusEnum 变更状态
	 * @return 当前对象
	*/
	@Transient
	public ExampleOrder setChsStatusEnum(ApprovalStatus chsStatusEnum) {
		if(chsStatusEnum==null) {
			this.setChsStatus(null);
		} else {
			this.setChsStatus(chsStatusEnum.code());
		}
		this.chsStatusEnum=chsStatusEnum;
		return this;
	}
	
	/**
	 * 获得 变更版本号<br>
	 * 变更版本号
	 * @return 变更版本号
	*/
	public Integer getChsVersion() {
		return chsVersion;
	}
	
	/**
	 * 设置 变更版本号
	 * @param chsVersion 变更版本号
	 * @return 当前对象
	*/
	public ExampleOrder setChsVersion(Integer chsVersion) {
		this.chsVersion=chsVersion;
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
	public ExampleOrder setTenantId(String tenantId) {
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
	public ExampleOrder setCreateBy(String createBy) {
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
	public ExampleOrder setCreateTime(Date createTime) {
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
	public ExampleOrder setUpdateBy(String updateBy) {
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
	public ExampleOrder setUpdateTime(Date updateTime) {
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
	public ExampleOrder setDeleted(Integer deleted) {
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
	public ExampleOrder setDeleteBy(String deleteBy) {
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
	public ExampleOrder setDeleteTime(Date deleteTime) {
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
	public ExampleOrder setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 来源ID<br>
	 * 来源ID
	 * @return 来源ID
	*/
	public String getSourceId() {
		return sourceId;
	}
	
	/**
	 * 设置 来源ID
	 * @param sourceId 来源ID
	 * @return 当前对象
	*/
	public ExampleOrder setSourceId(String sourceId) {
		this.sourceId=sourceId;
		return this;
	}
	
	/**
	 * 获得 变更ID<br>
	 * 变更ID
	 * @return 变更ID
	*/
	public String getChangeInstanceId() {
		return changeInstanceId;
	}
	
	/**
	 * 设置 变更ID
	 * @param changeInstanceId 变更ID
	 * @return 当前对象
	*/
	public ExampleOrder setChangeInstanceId(String changeInstanceId) {
		this.changeInstanceId=changeInstanceId;
		return this;
	}
	
	/**
	 * 获得 流程概要<br>
	 * 流程概要
	 * @return 流程概要
	*/
	public String getSummary() {
		return summary;
	}
	
	/**
	 * 设置 流程概要
	 * @param summary 流程概要
	 * @return 当前对象
	*/
	public ExampleOrder setSummary(String summary) {
		this.summary=summary;
		return this;
	}
	
	/**
	 * 获得 最后审批人账户ID<br>
	 * 最后审批人账户ID
	 * @return 最后审批人账户ID
	*/
	public String getLatestApproverId() {
		return latestApproverId;
	}
	
	/**
	 * 设置 最后审批人账户ID
	 * @param latestApproverId 最后审批人账户ID
	 * @return 当前对象
	*/
	public ExampleOrder setLatestApproverId(String latestApproverId) {
		this.latestApproverId=latestApproverId;
		return this;
	}
	
	/**
	 * 获得 最后审批人姓名<br>
	 * 最后审批人姓名
	 * @return 最后审批人姓名
	*/
	public String getLatestApproverName() {
		return latestApproverName;
	}
	
	/**
	 * 设置 最后审批人姓名
	 * @param latestApproverName 最后审批人姓名
	 * @return 当前对象
	*/
	public ExampleOrder setLatestApproverName(String latestApproverName) {
		this.latestApproverName=latestApproverName;
		return this;
	}
	
	/**
	 * 获得 下一节点审批人<br>
	 * 下一节点审批人
	 * @return 下一节点审批人
	*/
	public String getNextApproverIds() {
		return nextApproverIds;
	}
	
	/**
	 * 设置 下一节点审批人
	 * @param nextApproverIds 下一节点审批人
	 * @return 当前对象
	*/
	public ExampleOrder setNextApproverIds(String nextApproverIds) {
		this.nextApproverIds=nextApproverIds;
		return this;
	}
	
	/**
	 * 获得 下一个审批节点审批人姓名<br>
	 * 用逗号隔开
	 * @return 下一个审批节点审批人姓名
	*/
	public String getNextApproverNames() {
		return nextApproverNames;
	}
	
	/**
	 * 设置 下一个审批节点审批人姓名
	 * @param nextApproverNames 下一个审批节点审批人姓名
	 * @return 当前对象
	*/
	public ExampleOrder setNextApproverNames(String nextApproverNames) {
		this.nextApproverNames=nextApproverNames;
		return this;
	}
	
	/**
	 * 获得 订单明细<br>
	 * 订单明细
	 * @return 订单明细
	*/
	public List<ExampleOrderItem> getItems() {
		return items;
	}
	
	/**
	 * 设置 订单明细
	 * @param items 订单明细
	 * @return 当前对象
	*/
	public ExampleOrder setItems(List<ExampleOrderItem> items) {
		this.items=items;
		return this;
	}
	
	/**
	 * 添加 订单明细
	 * @param item 订单明细
	 * @return 当前对象
	*/
	public ExampleOrder addItem(ExampleOrderItem item) {
		if(this.items==null) items=new ArrayList<>();
		this.items.add(item);
		return this;
	}
	
	/**
	 * 获得 采购人<br>
	 * 采购人
	 * @return 采购人
	*/
	public Employee getBuyerEmployee() {
		return buyerEmployee;
	}
	
	/**
	 * 设置 采购人
	 * @param buyerEmployee 采购人
	 * @return 当前对象
	*/
	public ExampleOrder setBuyerEmployee(Employee buyerEmployee) {
		this.buyerEmployee=buyerEmployee;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ExampleOrder , 转换好的 ExampleOrder 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ExampleOrder , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ExampleOrder
	 * @param exampleOrderMap 包含实体信息的 Map 对象
	 * @return ExampleOrder , 转换好的的 ExampleOrder 对象
	*/
	@Transient
	public static ExampleOrder createFrom(Map<String,Object> exampleOrderMap) {
		if(exampleOrderMap==null) return null;
		ExampleOrder po = EntityContext.create(ExampleOrder.class, exampleOrderMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ExampleOrder
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ExampleOrder , 转换好的的 ExampleOrder 对象
	*/
	@Transient
	public static ExampleOrder createFrom(Object pojo) {
		if(pojo==null) return null;
		ExampleOrder po = EntityContext.create(ExampleOrder.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ExampleOrder，等同于 new
	 * @return ExampleOrder 对象
	*/
	@Transient
	public static ExampleOrder create() {
		return EntityContext.create(ExampleOrder.class);
	}
}