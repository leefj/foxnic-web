package org.github.foxnic.web.domain.changes;

import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.entity.Entity;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.sql.meta.DBTable;
import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.db.FoxnicWeb.CHS_EXAMPLE_ORDER;
import org.github.foxnic.web.constants.enums.changes.ChangeStatus;
import org.github.foxnic.web.constants.enums.changes.ChangeType;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;



/**
 * 变更示例订单
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-30 16:34:12
 * @sign 9B0D224725AE9D00DE96DB8F8D493737
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
	private ChangeStatus chsStatusEnum;
	
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
	private String chsId;
	
	/**
	 * 流程ID：流程ID
	*/
	@ApiModelProperty(required = false,value="流程ID" , notes = "流程ID")
	private String procId;
	
	/**
	 * 流程概要：流程概要
	*/
	@ApiModelProperty(required = false,value="流程概要" , notes = "流程概要")
	private String procSummary;
	
	/**
	 * 审批节点概要：审批节点概要
	*/
	@ApiModelProperty(required = false,value="审批节点概要" , notes = "审批节点概要")
	private String procNodeSummary;
	
	/**
	 * 订单明细：订单明细
	*/
	@ApiModelProperty(required = false,value="订单明细" , notes = "订单明细")
	private List<ExampleOrderItem> items;
	
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
			this.chsType=null;
		} else {
			this.chsType=chsTypeEnum.code();
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
	public ChangeStatus getChsStatusEnum() {
		if(this.chsStatusEnum==null) {
			this.chsStatusEnum = (ChangeStatus) EnumUtil.parseByCode(ChangeStatus.values(),chsStatus);
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
		this.chsStatusEnum= (ChangeStatus) EnumUtil.parseByCode(ChangeStatus.values(),chsStatus) ;
		if(StringUtil.hasContent(chsStatus) && this.chsStatusEnum==null) {
			throw new IllegalArgumentException( chsStatus + " is not one of ChangeStatus");
		}
		return this;
	}
	
	/**
	 * 设置 变更状态的投影属性，等同于设置 变更状态
	 * @param chsStatusEnum 变更状态
	 * @return 当前对象
	*/
	@Transient
	public ExampleOrder setChsStatusEnum(ChangeStatus chsStatusEnum) {
		if(chsStatusEnum==null) {
			this.chsStatus=null;
		} else {
			this.chsStatus=chsStatusEnum.code();
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
	public String getChsId() {
		return chsId;
	}
	
	/**
	 * 设置 变更ID
	 * @param chsId 变更ID
	 * @return 当前对象
	*/
	public ExampleOrder setChsId(String chsId) {
		this.chsId=chsId;
		return this;
	}
	
	/**
	 * 获得 流程ID<br>
	 * 流程ID
	 * @return 流程ID
	*/
	public String getProcId() {
		return procId;
	}
	
	/**
	 * 设置 流程ID
	 * @param procId 流程ID
	 * @return 当前对象
	*/
	public ExampleOrder setProcId(String procId) {
		this.procId=procId;
		return this;
	}
	
	/**
	 * 获得 流程概要<br>
	 * 流程概要
	 * @return 流程概要
	*/
	public String getProcSummary() {
		return procSummary;
	}
	
	/**
	 * 设置 流程概要
	 * @param procSummary 流程概要
	 * @return 当前对象
	*/
	public ExampleOrder setProcSummary(String procSummary) {
		this.procSummary=procSummary;
		return this;
	}
	
	/**
	 * 获得 审批节点概要<br>
	 * 审批节点概要
	 * @return 审批节点概要
	*/
	public String getProcNodeSummary() {
		return procNodeSummary;
	}
	
	/**
	 * 设置 审批节点概要
	 * @param procNodeSummary 审批节点概要
	 * @return 当前对象
	*/
	public ExampleOrder setProcNodeSummary(String procNodeSummary) {
		this.procNodeSummary=procNodeSummary;
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