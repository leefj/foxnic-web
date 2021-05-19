package com.scientific.tailoring.domain.crm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.scientific.tailoring.constants.db.Tailoring.CRM_COMPANY;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 01:13:37
 * @sign 53D2C66F4638DF83F5A839EE92C03263
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "crm_company")
public class Company extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =CRM_COMPANY.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(required = true,value="ID" , notes = "ID")
	private Long id;
	
	/**
	 * 公司名称：公司名称
	*/
	@ApiModelProperty(required = false,value="公司名称" , notes = "公司名称")
	private String name;
	
	/**
	 * 统一社会信用代码：统一社会信用代码
	*/
	@ApiModelProperty(required = false,value="统一社会信用代码" , notes = "统一社会信用代码")
	private String unifySocialCode;
	
	/**
	 * 营业执照图片地址：营业执照图片地址
	*/
	@ApiModelProperty(required = false,value="营业执照图片地址" , notes = "营业执照图片地址")
	private String licensePhoto;
	
	/**
	 * 经营范围：经营范围
	*/
	@ApiModelProperty(required = false,value="经营范围" , notes = "经营范围")
	private String businessRange;
	
	/**
	 * 营业期限开始日期：营业期限开始日期
	*/
	@ApiModelProperty(required = false,value="营业期限开始日期" , notes = "营业期限开始日期")
	private String termStartDate;
	
	/**
	 * 营业期限结束日期：营业期限结束日期
	*/
	@ApiModelProperty(required = false,value="营业期限结束日期" , notes = "营业期限结束日期")
	private Date termEndDate;
	
	/**
	 * 合同生效时间：合同生效时间
	*/
	@ApiModelProperty(required = false,value="合同生效时间" , notes = "合同生效时间")
	private Date contractStartDate;
	
	/**
	 * 合同状态：合同状态
	*/
	@ApiModelProperty(required = false,value="合同状态" , notes = "合同状态")
	private String contractStatus;
	
	/**
	 * 公司类型：供应商/客户
	*/
	@ApiModelProperty(required = false,value="公司类型" , notes = "供应商/客户")
	private String type;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private Long createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private Long updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
	private Boolean deleted;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private Long deleteBy;
	
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
	 * 获得 ID<br>
	 * 属性说明 : ID
	 * @return ID
	*/
	public Long getId() {
		return id;
	}
	
	/**
	 * 设置 ID
	 * @param id ID
	 * @return 当前对象
	*/
	public Company setId(Long id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 添加 ID
	 * @param id ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 公司名称<br>
	 * 属性说明 : 公司名称
	 * @return 公司名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 公司名称
	 * @param name 公司名称
	 * @return 当前对象
	*/
	public Company setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 添加 公司名称
	 * @param name 公司名称
	 * @return 当前对象
	*/
	
	/**
	 * 获得 统一社会信用代码<br>
	 * 属性说明 : 统一社会信用代码
	 * @return 统一社会信用代码
	*/
	public String getUnifySocialCode() {
		return unifySocialCode;
	}
	
	/**
	 * 设置 统一社会信用代码
	 * @param unifySocialCode 统一社会信用代码
	 * @return 当前对象
	*/
	public Company setUnifySocialCode(String unifySocialCode) {
		this.unifySocialCode=unifySocialCode;
		return this;
	}
	
	/**
	 * 添加 统一社会信用代码
	 * @param unifySocialCode 统一社会信用代码
	 * @return 当前对象
	*/
	
	/**
	 * 获得 营业执照图片地址<br>
	 * 属性说明 : 营业执照图片地址
	 * @return 营业执照图片地址
	*/
	public String getLicensePhoto() {
		return licensePhoto;
	}
	
	/**
	 * 设置 营业执照图片地址
	 * @param licensePhoto 营业执照图片地址
	 * @return 当前对象
	*/
	public Company setLicensePhoto(String licensePhoto) {
		this.licensePhoto=licensePhoto;
		return this;
	}
	
	/**
	 * 添加 营业执照图片地址
	 * @param licensePhoto 营业执照图片地址
	 * @return 当前对象
	*/
	
	/**
	 * 获得 经营范围<br>
	 * 属性说明 : 经营范围
	 * @return 经营范围
	*/
	public String getBusinessRange() {
		return businessRange;
	}
	
	/**
	 * 设置 经营范围
	 * @param businessRange 经营范围
	 * @return 当前对象
	*/
	public Company setBusinessRange(String businessRange) {
		this.businessRange=businessRange;
		return this;
	}
	
	/**
	 * 添加 经营范围
	 * @param businessRange 经营范围
	 * @return 当前对象
	*/
	
	/**
	 * 获得 营业期限开始日期<br>
	 * 属性说明 : 营业期限开始日期
	 * @return 营业期限开始日期
	*/
	public String getTermStartDate() {
		return termStartDate;
	}
	
	/**
	 * 设置 营业期限开始日期
	 * @param termStartDate 营业期限开始日期
	 * @return 当前对象
	*/
	public Company setTermStartDate(String termStartDate) {
		this.termStartDate=termStartDate;
		return this;
	}
	
	/**
	 * 添加 营业期限开始日期
	 * @param termStartDate 营业期限开始日期
	 * @return 当前对象
	*/
	
	/**
	 * 获得 营业期限结束日期<br>
	 * 属性说明 : 营业期限结束日期
	 * @return 营业期限结束日期
	*/
	public Date getTermEndDate() {
		return termEndDate;
	}
	
	/**
	 * 设置 营业期限结束日期
	 * @param termEndDate 营业期限结束日期
	 * @return 当前对象
	*/
	public Company setTermEndDate(Date termEndDate) {
		this.termEndDate=termEndDate;
		return this;
	}
	
	/**
	 * 添加 营业期限结束日期
	 * @param termEndDate 营业期限结束日期
	 * @return 当前对象
	*/
	
	/**
	 * 获得 合同生效时间<br>
	 * 属性说明 : 合同生效时间
	 * @return 合同生效时间
	*/
	public Date getContractStartDate() {
		return contractStartDate;
	}
	
	/**
	 * 设置 合同生效时间
	 * @param contractStartDate 合同生效时间
	 * @return 当前对象
	*/
	public Company setContractStartDate(Date contractStartDate) {
		this.contractStartDate=contractStartDate;
		return this;
	}
	
	/**
	 * 添加 合同生效时间
	 * @param contractStartDate 合同生效时间
	 * @return 当前对象
	*/
	
	/**
	 * 获得 合同状态<br>
	 * 属性说明 : 合同状态
	 * @return 合同状态
	*/
	public String getContractStatus() {
		return contractStatus;
	}
	
	/**
	 * 设置 合同状态
	 * @param contractStatus 合同状态
	 * @return 当前对象
	*/
	public Company setContractStatus(String contractStatus) {
		this.contractStatus=contractStatus;
		return this;
	}
	
	/**
	 * 添加 合同状态
	 * @param contractStatus 合同状态
	 * @return 当前对象
	*/
	
	/**
	 * 获得 公司类型<br>
	 * 属性说明 : 供应商/客户
	 * @return 公司类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 公司类型
	 * @param type 公司类型
	 * @return 当前对象
	*/
	public Company setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 添加 公司类型
	 * @param type 公司类型
	 * @return 当前对象
	*/
	
	/**
	 * 获得 创建人ID<br>
	 * 属性说明 : 创建人ID
	 * @return 创建人ID
	*/
	public Long getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public Company setCreateBy(Long createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 添加 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 创建时间<br>
	 * 属性说明 : 创建时间
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
	public Company setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 添加 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	
	/**
	 * 获得 修改人ID<br>
	 * 属性说明 : 修改人ID
	 * @return 修改人ID
	*/
	public Long getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public Company setUpdateBy(Long updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 添加 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 修改时间<br>
	 * 属性说明 : 修改时间
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
	public Company setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 添加 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	
	/**
	 * 获得 是否已删除<br>
	 * 属性说明 : 是否已删除
	 * @return 是否已删除
	*/
	public Boolean isDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 等价于 isDeleted 方法，为兼容 Swagger 需要
	 * 属性说明 : 是否已删除
	 * @return 是否已删除
	*/
	public Boolean getDeleted() {
		return this.deleted;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public Company setDeleted(Boolean deleted) {
		this.deleted=deleted;
		return this;
	}
	
	/**
	 * 添加 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	
	/**
	 * 获得 删除人ID<br>
	 * 属性说明 : 删除人ID
	 * @return 删除人ID
	*/
	public Long getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public Company setDeleteBy(Long deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 添加 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 删除时间<br>
	 * 属性说明 : 删除时间
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
	public Company setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 添加 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	
	/**
	 * 获得 数据版本号<br>
	 * 属性说明 : 数据版本号
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
	public Company setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 添加 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Company , 转换好的 Company 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Company , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 Company
	 * @param companyMap 包含实体信息的 Map 对象
	 * @return Company , 转换好的的 Company 对象
	*/
	@Transient
	public static Company createFrom(Map<String,Object> companyMap) {
		if(companyMap==null) return null;
		Company po = EntityContext.create(Company.class, companyMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Company
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Company , 转换好的的 Company 对象
	*/
	@Transient
	public static Company createFrom(Object pojo) {
		if(pojo==null) return null;
		Company po = EntityContext.create(Company.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Company，等同于 new
	 * @return Company 对象
	*/
	@Transient
	public static Company create() {
		return new Company();
	}
}