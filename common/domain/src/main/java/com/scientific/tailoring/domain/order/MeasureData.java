package com.scientific.tailoring.domain.order;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.scientific.tailoring.constants.db.Tailoring.ODR_MEASURE_DATA;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 01:24:39
 * @sign D30E522BC5ED8CC0B20E09EA17724260
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "odr_measure_data")
public class MeasureData extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =ODR_MEASURE_DATA.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(required = true,value="ID" , notes = "ID")
	private Long id;
	
	/**
	 * 测量ID：测量ID
	*/
	@ApiModelProperty(required = false,value="测量ID" , notes = "测量ID")
	private Long measureId;
	
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
	 * 测量类型：净体 body , 着装 outfit
	*/
	@ApiModelProperty(required = true,value="测量类型" , notes = "净体 body , 着装 outfit")
	private String resultType;
	
	/**
	 * 领围：领围
	*/
	@ApiModelProperty(required = false,value="领围" , notes = "领围")
	private BigDecimal lingWei;
	
	/**
	 * 胸围：胸围
	*/
	@ApiModelProperty(required = false,value="胸围" , notes = "胸围")
	private BigDecimal xiongWei;
	
	/**
	 * 腰围：腰围
	*/
	@ApiModelProperty(required = false,value="腰围" , notes = "腰围")
	private BigDecimal yaoWei;
	
	/**
	 * 腹围：腹围
	*/
	@ApiModelProperty(required = false,value="腹围" , notes = "腹围")
	private BigDecimal fuWei;
	
	/**
	 * 右上臂围：右上臂围
	*/
	@ApiModelProperty(required = false,value="右上臂围" , notes = "右上臂围")
	private BigDecimal youShangBiWei;
	
	/**
	 * 右下臂围：右下臂围
	*/
	@ApiModelProperty(required = false,value="右下臂围" , notes = "右下臂围")
	private BigDecimal youXiaBiWei;
	
	/**
	 * 左上臂围：左上臂围
	*/
	@ApiModelProperty(required = false,value="左上臂围" , notes = "左上臂围")
	private BigDecimal zuoShangBiWei;
	
	/**
	 * 左下臂围：左下臂围
	*/
	@ApiModelProperty(required = false,value="左下臂围" , notes = "左下臂围")
	private BigDecimal zuoXiaBiWei;
	
	/**
	 * 右上腿围：右上腿围
	*/
	@ApiModelProperty(required = false,value="右上腿围" , notes = "右上腿围")
	private BigDecimal youShangTuiWei;
	
	/**
	 * 右下腿围：右下腿围
	*/
	@ApiModelProperty(required = false,value="右下腿围" , notes = "右下腿围")
	private BigDecimal youXiaTuiWei;
	
	/**
	 * 左上腿围：左上腿围
	*/
	@ApiModelProperty(required = false,value="左上腿围" , notes = "左上腿围")
	private BigDecimal zuoShangTuiWei;
	
	/**
	 * 左下腿围：左下腿围
	*/
	@ApiModelProperty(required = false,value="左下腿围" , notes = "左下腿围")
	private BigDecimal zuoXiaTuiWei;
	
	/**
	 * 身高：身高
	*/
	@ApiModelProperty(required = false,value="身高" , notes = "身高")
	private BigDecimal shenGao;
	
	/**
	 * 肩宽：肩宽
	*/
	@ApiModelProperty(required = false,value="肩宽" , notes = "肩宽")
	private BigDecimal jianKuan;
	
	/**
	 * 背长：背长
	*/
	@ApiModelProperty(required = false,value="背长" , notes = "背长")
	private BigDecimal beiChang;
	
	/**
	 * 颈椎点高：颈椎点高
	*/
	@ApiModelProperty(required = false,value="颈椎点高" , notes = "颈椎点高")
	private BigDecimal jingZhuiDianGao;
	
	/**
	 * 腰围高：腰围高
	*/
	@ApiModelProperty(required = false,value="腰围高" , notes = "腰围高")
	private BigDecimal yaoWeiGao;
	
	/**
	 * 臀高：臀高
	*/
	@ApiModelProperty(required = false,value="臀高" , notes = "臀高")
	private BigDecimal tunGao;
	
	/**
	 * 臀围：臀围
	*/
	@ApiModelProperty(required = false,value="臀围" , notes = "臀围")
	private BigDecimal tunWei;
	
	/**
	 * 裤长：裤长
	*/
	@ApiModelProperty(required = false,value="裤长" , notes = "裤长")
	private BigDecimal kuChang;
	
	/**
	 * 左臂长：左臂长
	*/
	@ApiModelProperty(required = false,value="左臂长" , notes = "左臂长")
	private BigDecimal zuoBiChang;
	
	/**
	 * 右臂长：右臂长
	*/
	@ApiModelProperty(required = false,value="右臂长" , notes = "右臂长")
	private BigDecimal youBiChang;
	
	/**
	 * 右上臂长：右上臂长
	*/
	@ApiModelProperty(required = false,value="右上臂长" , notes = "右上臂长")
	private BigDecimal youShangBiChang;
	
	/**
	 * 右下臂长：右下臂长
	*/
	@ApiModelProperty(required = false,value="右下臂长" , notes = "右下臂长")
	private BigDecimal youXiaBiChang;
	
	/**
	 * 左上臂长：左上臂长
	*/
	@ApiModelProperty(required = false,value="左上臂长" , notes = "左上臂长")
	private BigDecimal zuoShangBiChang;
	
	/**
	 * 左下臂长：左下臂长
	*/
	@ApiModelProperty(required = false,value="左下臂长" , notes = "左下臂长")
	private BigDecimal zuoXiaBiChang;
	
	/**
	 * 右腿长：右腿长
	*/
	@ApiModelProperty(required = false,value="右腿长" , notes = "右腿长")
	private BigDecimal youTuiChang;
	
	/**
	 * 左腿长：左腿长
	*/
	@ApiModelProperty(required = false,value="左腿长" , notes = "左腿长")
	private BigDecimal zuoTuiChang;
	
	/**
	 * 右上腿长：右上腿长
	*/
	@ApiModelProperty(required = false,value="右上腿长" , notes = "右上腿长")
	private BigDecimal youShangTuiChang;
	
	/**
	 * 右下腿长：右下腿长
	*/
	@ApiModelProperty(required = false,value="右下腿长" , notes = "右下腿长")
	private BigDecimal youXiaTuiChang;
	
	/**
	 * 左上腿长：左上腿长
	*/
	@ApiModelProperty(required = false,value="左上腿长" , notes = "左上腿长")
	private BigDecimal zuoShangTuiChang;
	
	/**
	 * 左下腿长：左下腿长
	*/
	@ApiModelProperty(required = false,value="左下腿长" , notes = "左下腿长")
	private BigDecimal zuoXiaTuiChang;
	
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
	public MeasureData setId(Long id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 添加 ID
	 * @param id ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 测量ID<br>
	 * 属性说明 : 测量ID
	 * @return 测量ID
	*/
	public Long getMeasureId() {
		return measureId;
	}
	
	/**
	 * 设置 测量ID
	 * @param measureId 测量ID
	 * @return 当前对象
	*/
	public MeasureData setMeasureId(Long measureId) {
		this.measureId=measureId;
		return this;
	}
	
	/**
	 * 添加 测量ID
	 * @param measureId 测量ID
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
	public MeasureData setCreateBy(Long createBy) {
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
	public MeasureData setCreateTime(Date createTime) {
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
	public MeasureData setUpdateBy(Long updateBy) {
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
	public MeasureData setUpdateTime(Date updateTime) {
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
	public MeasureData setDeleted(Boolean deleted) {
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
	public MeasureData setDeleteBy(Long deleteBy) {
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
	public MeasureData setDeleteTime(Date deleteTime) {
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
	public MeasureData setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 添加 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	
	/**
	 * 获得 测量类型<br>
	 * 属性说明 : 净体 body , 着装 outfit
	 * @return 测量类型
	*/
	public String getResultType() {
		return resultType;
	}
	
	/**
	 * 设置 测量类型
	 * @param resultType 测量类型
	 * @return 当前对象
	*/
	public MeasureData setResultType(String resultType) {
		this.resultType=resultType;
		return this;
	}
	
	/**
	 * 添加 测量类型
	 * @param resultType 测量类型
	 * @return 当前对象
	*/
	
	/**
	 * 获得 领围<br>
	 * 属性说明 : 领围
	 * @return 领围
	*/
	public BigDecimal getLingWei() {
		return lingWei;
	}
	
	/**
	 * 设置 领围
	 * @param lingWei 领围
	 * @return 当前对象
	*/
	public MeasureData setLingWei(BigDecimal lingWei) {
		this.lingWei=lingWei;
		return this;
	}
	
	/**
	 * 添加 领围
	 * @param lingWei 领围
	 * @return 当前对象
	*/
	
	/**
	 * 获得 胸围<br>
	 * 属性说明 : 胸围
	 * @return 胸围
	*/
	public BigDecimal getXiongWei() {
		return xiongWei;
	}
	
	/**
	 * 设置 胸围
	 * @param xiongWei 胸围
	 * @return 当前对象
	*/
	public MeasureData setXiongWei(BigDecimal xiongWei) {
		this.xiongWei=xiongWei;
		return this;
	}
	
	/**
	 * 添加 胸围
	 * @param xiongWei 胸围
	 * @return 当前对象
	*/
	
	/**
	 * 获得 腰围<br>
	 * 属性说明 : 腰围
	 * @return 腰围
	*/
	public BigDecimal getYaoWei() {
		return yaoWei;
	}
	
	/**
	 * 设置 腰围
	 * @param yaoWei 腰围
	 * @return 当前对象
	*/
	public MeasureData setYaoWei(BigDecimal yaoWei) {
		this.yaoWei=yaoWei;
		return this;
	}
	
	/**
	 * 添加 腰围
	 * @param yaoWei 腰围
	 * @return 当前对象
	*/
	
	/**
	 * 获得 腹围<br>
	 * 属性说明 : 腹围
	 * @return 腹围
	*/
	public BigDecimal getFuWei() {
		return fuWei;
	}
	
	/**
	 * 设置 腹围
	 * @param fuWei 腹围
	 * @return 当前对象
	*/
	public MeasureData setFuWei(BigDecimal fuWei) {
		this.fuWei=fuWei;
		return this;
	}
	
	/**
	 * 添加 腹围
	 * @param fuWei 腹围
	 * @return 当前对象
	*/
	
	/**
	 * 获得 右上臂围<br>
	 * 属性说明 : 右上臂围
	 * @return 右上臂围
	*/
	public BigDecimal getYouShangBiWei() {
		return youShangBiWei;
	}
	
	/**
	 * 设置 右上臂围
	 * @param youShangBiWei 右上臂围
	 * @return 当前对象
	*/
	public MeasureData setYouShangBiWei(BigDecimal youShangBiWei) {
		this.youShangBiWei=youShangBiWei;
		return this;
	}
	
	/**
	 * 添加 右上臂围
	 * @param youShangBiWei 右上臂围
	 * @return 当前对象
	*/
	
	/**
	 * 获得 右下臂围<br>
	 * 属性说明 : 右下臂围
	 * @return 右下臂围
	*/
	public BigDecimal getYouXiaBiWei() {
		return youXiaBiWei;
	}
	
	/**
	 * 设置 右下臂围
	 * @param youXiaBiWei 右下臂围
	 * @return 当前对象
	*/
	public MeasureData setYouXiaBiWei(BigDecimal youXiaBiWei) {
		this.youXiaBiWei=youXiaBiWei;
		return this;
	}
	
	/**
	 * 添加 右下臂围
	 * @param youXiaBiWei 右下臂围
	 * @return 当前对象
	*/
	
	/**
	 * 获得 左上臂围<br>
	 * 属性说明 : 左上臂围
	 * @return 左上臂围
	*/
	public BigDecimal getZuoShangBiWei() {
		return zuoShangBiWei;
	}
	
	/**
	 * 设置 左上臂围
	 * @param zuoShangBiWei 左上臂围
	 * @return 当前对象
	*/
	public MeasureData setZuoShangBiWei(BigDecimal zuoShangBiWei) {
		this.zuoShangBiWei=zuoShangBiWei;
		return this;
	}
	
	/**
	 * 添加 左上臂围
	 * @param zuoShangBiWei 左上臂围
	 * @return 当前对象
	*/
	
	/**
	 * 获得 左下臂围<br>
	 * 属性说明 : 左下臂围
	 * @return 左下臂围
	*/
	public BigDecimal getZuoXiaBiWei() {
		return zuoXiaBiWei;
	}
	
	/**
	 * 设置 左下臂围
	 * @param zuoXiaBiWei 左下臂围
	 * @return 当前对象
	*/
	public MeasureData setZuoXiaBiWei(BigDecimal zuoXiaBiWei) {
		this.zuoXiaBiWei=zuoXiaBiWei;
		return this;
	}
	
	/**
	 * 添加 左下臂围
	 * @param zuoXiaBiWei 左下臂围
	 * @return 当前对象
	*/
	
	/**
	 * 获得 右上腿围<br>
	 * 属性说明 : 右上腿围
	 * @return 右上腿围
	*/
	public BigDecimal getYouShangTuiWei() {
		return youShangTuiWei;
	}
	
	/**
	 * 设置 右上腿围
	 * @param youShangTuiWei 右上腿围
	 * @return 当前对象
	*/
	public MeasureData setYouShangTuiWei(BigDecimal youShangTuiWei) {
		this.youShangTuiWei=youShangTuiWei;
		return this;
	}
	
	/**
	 * 添加 右上腿围
	 * @param youShangTuiWei 右上腿围
	 * @return 当前对象
	*/
	
	/**
	 * 获得 右下腿围<br>
	 * 属性说明 : 右下腿围
	 * @return 右下腿围
	*/
	public BigDecimal getYouXiaTuiWei() {
		return youXiaTuiWei;
	}
	
	/**
	 * 设置 右下腿围
	 * @param youXiaTuiWei 右下腿围
	 * @return 当前对象
	*/
	public MeasureData setYouXiaTuiWei(BigDecimal youXiaTuiWei) {
		this.youXiaTuiWei=youXiaTuiWei;
		return this;
	}
	
	/**
	 * 添加 右下腿围
	 * @param youXiaTuiWei 右下腿围
	 * @return 当前对象
	*/
	
	/**
	 * 获得 左上腿围<br>
	 * 属性说明 : 左上腿围
	 * @return 左上腿围
	*/
	public BigDecimal getZuoShangTuiWei() {
		return zuoShangTuiWei;
	}
	
	/**
	 * 设置 左上腿围
	 * @param zuoShangTuiWei 左上腿围
	 * @return 当前对象
	*/
	public MeasureData setZuoShangTuiWei(BigDecimal zuoShangTuiWei) {
		this.zuoShangTuiWei=zuoShangTuiWei;
		return this;
	}
	
	/**
	 * 添加 左上腿围
	 * @param zuoShangTuiWei 左上腿围
	 * @return 当前对象
	*/
	
	/**
	 * 获得 左下腿围<br>
	 * 属性说明 : 左下腿围
	 * @return 左下腿围
	*/
	public BigDecimal getZuoXiaTuiWei() {
		return zuoXiaTuiWei;
	}
	
	/**
	 * 设置 左下腿围
	 * @param zuoXiaTuiWei 左下腿围
	 * @return 当前对象
	*/
	public MeasureData setZuoXiaTuiWei(BigDecimal zuoXiaTuiWei) {
		this.zuoXiaTuiWei=zuoXiaTuiWei;
		return this;
	}
	
	/**
	 * 添加 左下腿围
	 * @param zuoXiaTuiWei 左下腿围
	 * @return 当前对象
	*/
	
	/**
	 * 获得 身高<br>
	 * 属性说明 : 身高
	 * @return 身高
	*/
	public BigDecimal getShenGao() {
		return shenGao;
	}
	
	/**
	 * 设置 身高
	 * @param shenGao 身高
	 * @return 当前对象
	*/
	public MeasureData setShenGao(BigDecimal shenGao) {
		this.shenGao=shenGao;
		return this;
	}
	
	/**
	 * 添加 身高
	 * @param shenGao 身高
	 * @return 当前对象
	*/
	
	/**
	 * 获得 肩宽<br>
	 * 属性说明 : 肩宽
	 * @return 肩宽
	*/
	public BigDecimal getJianKuan() {
		return jianKuan;
	}
	
	/**
	 * 设置 肩宽
	 * @param jianKuan 肩宽
	 * @return 当前对象
	*/
	public MeasureData setJianKuan(BigDecimal jianKuan) {
		this.jianKuan=jianKuan;
		return this;
	}
	
	/**
	 * 添加 肩宽
	 * @param jianKuan 肩宽
	 * @return 当前对象
	*/
	
	/**
	 * 获得 背长<br>
	 * 属性说明 : 背长
	 * @return 背长
	*/
	public BigDecimal getBeiChang() {
		return beiChang;
	}
	
	/**
	 * 设置 背长
	 * @param beiChang 背长
	 * @return 当前对象
	*/
	public MeasureData setBeiChang(BigDecimal beiChang) {
		this.beiChang=beiChang;
		return this;
	}
	
	/**
	 * 添加 背长
	 * @param beiChang 背长
	 * @return 当前对象
	*/
	
	/**
	 * 获得 颈椎点高<br>
	 * 属性说明 : 颈椎点高
	 * @return 颈椎点高
	*/
	public BigDecimal getJingZhuiDianGao() {
		return jingZhuiDianGao;
	}
	
	/**
	 * 设置 颈椎点高
	 * @param jingZhuiDianGao 颈椎点高
	 * @return 当前对象
	*/
	public MeasureData setJingZhuiDianGao(BigDecimal jingZhuiDianGao) {
		this.jingZhuiDianGao=jingZhuiDianGao;
		return this;
	}
	
	/**
	 * 添加 颈椎点高
	 * @param jingZhuiDianGao 颈椎点高
	 * @return 当前对象
	*/
	
	/**
	 * 获得 腰围高<br>
	 * 属性说明 : 腰围高
	 * @return 腰围高
	*/
	public BigDecimal getYaoWeiGao() {
		return yaoWeiGao;
	}
	
	/**
	 * 设置 腰围高
	 * @param yaoWeiGao 腰围高
	 * @return 当前对象
	*/
	public MeasureData setYaoWeiGao(BigDecimal yaoWeiGao) {
		this.yaoWeiGao=yaoWeiGao;
		return this;
	}
	
	/**
	 * 添加 腰围高
	 * @param yaoWeiGao 腰围高
	 * @return 当前对象
	*/
	
	/**
	 * 获得 臀高<br>
	 * 属性说明 : 臀高
	 * @return 臀高
	*/
	public BigDecimal getTunGao() {
		return tunGao;
	}
	
	/**
	 * 设置 臀高
	 * @param tunGao 臀高
	 * @return 当前对象
	*/
	public MeasureData setTunGao(BigDecimal tunGao) {
		this.tunGao=tunGao;
		return this;
	}
	
	/**
	 * 添加 臀高
	 * @param tunGao 臀高
	 * @return 当前对象
	*/
	
	/**
	 * 获得 臀围<br>
	 * 属性说明 : 臀围
	 * @return 臀围
	*/
	public BigDecimal getTunWei() {
		return tunWei;
	}
	
	/**
	 * 设置 臀围
	 * @param tunWei 臀围
	 * @return 当前对象
	*/
	public MeasureData setTunWei(BigDecimal tunWei) {
		this.tunWei=tunWei;
		return this;
	}
	
	/**
	 * 添加 臀围
	 * @param tunWei 臀围
	 * @return 当前对象
	*/
	
	/**
	 * 获得 裤长<br>
	 * 属性说明 : 裤长
	 * @return 裤长
	*/
	public BigDecimal getKuChang() {
		return kuChang;
	}
	
	/**
	 * 设置 裤长
	 * @param kuChang 裤长
	 * @return 当前对象
	*/
	public MeasureData setKuChang(BigDecimal kuChang) {
		this.kuChang=kuChang;
		return this;
	}
	
	/**
	 * 添加 裤长
	 * @param kuChang 裤长
	 * @return 当前对象
	*/
	
	/**
	 * 获得 左臂长<br>
	 * 属性说明 : 左臂长
	 * @return 左臂长
	*/
	public BigDecimal getZuoBiChang() {
		return zuoBiChang;
	}
	
	/**
	 * 设置 左臂长
	 * @param zuoBiChang 左臂长
	 * @return 当前对象
	*/
	public MeasureData setZuoBiChang(BigDecimal zuoBiChang) {
		this.zuoBiChang=zuoBiChang;
		return this;
	}
	
	/**
	 * 添加 左臂长
	 * @param zuoBiChang 左臂长
	 * @return 当前对象
	*/
	
	/**
	 * 获得 右臂长<br>
	 * 属性说明 : 右臂长
	 * @return 右臂长
	*/
	public BigDecimal getYouBiChang() {
		return youBiChang;
	}
	
	/**
	 * 设置 右臂长
	 * @param youBiChang 右臂长
	 * @return 当前对象
	*/
	public MeasureData setYouBiChang(BigDecimal youBiChang) {
		this.youBiChang=youBiChang;
		return this;
	}
	
	/**
	 * 添加 右臂长
	 * @param youBiChang 右臂长
	 * @return 当前对象
	*/
	
	/**
	 * 获得 右上臂长<br>
	 * 属性说明 : 右上臂长
	 * @return 右上臂长
	*/
	public BigDecimal getYouShangBiChang() {
		return youShangBiChang;
	}
	
	/**
	 * 设置 右上臂长
	 * @param youShangBiChang 右上臂长
	 * @return 当前对象
	*/
	public MeasureData setYouShangBiChang(BigDecimal youShangBiChang) {
		this.youShangBiChang=youShangBiChang;
		return this;
	}
	
	/**
	 * 添加 右上臂长
	 * @param youShangBiChang 右上臂长
	 * @return 当前对象
	*/
	
	/**
	 * 获得 右下臂长<br>
	 * 属性说明 : 右下臂长
	 * @return 右下臂长
	*/
	public BigDecimal getYouXiaBiChang() {
		return youXiaBiChang;
	}
	
	/**
	 * 设置 右下臂长
	 * @param youXiaBiChang 右下臂长
	 * @return 当前对象
	*/
	public MeasureData setYouXiaBiChang(BigDecimal youXiaBiChang) {
		this.youXiaBiChang=youXiaBiChang;
		return this;
	}
	
	/**
	 * 添加 右下臂长
	 * @param youXiaBiChang 右下臂长
	 * @return 当前对象
	*/
	
	/**
	 * 获得 左上臂长<br>
	 * 属性说明 : 左上臂长
	 * @return 左上臂长
	*/
	public BigDecimal getZuoShangBiChang() {
		return zuoShangBiChang;
	}
	
	/**
	 * 设置 左上臂长
	 * @param zuoShangBiChang 左上臂长
	 * @return 当前对象
	*/
	public MeasureData setZuoShangBiChang(BigDecimal zuoShangBiChang) {
		this.zuoShangBiChang=zuoShangBiChang;
		return this;
	}
	
	/**
	 * 添加 左上臂长
	 * @param zuoShangBiChang 左上臂长
	 * @return 当前对象
	*/
	
	/**
	 * 获得 左下臂长<br>
	 * 属性说明 : 左下臂长
	 * @return 左下臂长
	*/
	public BigDecimal getZuoXiaBiChang() {
		return zuoXiaBiChang;
	}
	
	/**
	 * 设置 左下臂长
	 * @param zuoXiaBiChang 左下臂长
	 * @return 当前对象
	*/
	public MeasureData setZuoXiaBiChang(BigDecimal zuoXiaBiChang) {
		this.zuoXiaBiChang=zuoXiaBiChang;
		return this;
	}
	
	/**
	 * 添加 左下臂长
	 * @param zuoXiaBiChang 左下臂长
	 * @return 当前对象
	*/
	
	/**
	 * 获得 右腿长<br>
	 * 属性说明 : 右腿长
	 * @return 右腿长
	*/
	public BigDecimal getYouTuiChang() {
		return youTuiChang;
	}
	
	/**
	 * 设置 右腿长
	 * @param youTuiChang 右腿长
	 * @return 当前对象
	*/
	public MeasureData setYouTuiChang(BigDecimal youTuiChang) {
		this.youTuiChang=youTuiChang;
		return this;
	}
	
	/**
	 * 添加 右腿长
	 * @param youTuiChang 右腿长
	 * @return 当前对象
	*/
	
	/**
	 * 获得 左腿长<br>
	 * 属性说明 : 左腿长
	 * @return 左腿长
	*/
	public BigDecimal getZuoTuiChang() {
		return zuoTuiChang;
	}
	
	/**
	 * 设置 左腿长
	 * @param zuoTuiChang 左腿长
	 * @return 当前对象
	*/
	public MeasureData setZuoTuiChang(BigDecimal zuoTuiChang) {
		this.zuoTuiChang=zuoTuiChang;
		return this;
	}
	
	/**
	 * 添加 左腿长
	 * @param zuoTuiChang 左腿长
	 * @return 当前对象
	*/
	
	/**
	 * 获得 右上腿长<br>
	 * 属性说明 : 右上腿长
	 * @return 右上腿长
	*/
	public BigDecimal getYouShangTuiChang() {
		return youShangTuiChang;
	}
	
	/**
	 * 设置 右上腿长
	 * @param youShangTuiChang 右上腿长
	 * @return 当前对象
	*/
	public MeasureData setYouShangTuiChang(BigDecimal youShangTuiChang) {
		this.youShangTuiChang=youShangTuiChang;
		return this;
	}
	
	/**
	 * 添加 右上腿长
	 * @param youShangTuiChang 右上腿长
	 * @return 当前对象
	*/
	
	/**
	 * 获得 右下腿长<br>
	 * 属性说明 : 右下腿长
	 * @return 右下腿长
	*/
	public BigDecimal getYouXiaTuiChang() {
		return youXiaTuiChang;
	}
	
	/**
	 * 设置 右下腿长
	 * @param youXiaTuiChang 右下腿长
	 * @return 当前对象
	*/
	public MeasureData setYouXiaTuiChang(BigDecimal youXiaTuiChang) {
		this.youXiaTuiChang=youXiaTuiChang;
		return this;
	}
	
	/**
	 * 添加 右下腿长
	 * @param youXiaTuiChang 右下腿长
	 * @return 当前对象
	*/
	
	/**
	 * 获得 左上腿长<br>
	 * 属性说明 : 左上腿长
	 * @return 左上腿长
	*/
	public BigDecimal getZuoShangTuiChang() {
		return zuoShangTuiChang;
	}
	
	/**
	 * 设置 左上腿长
	 * @param zuoShangTuiChang 左上腿长
	 * @return 当前对象
	*/
	public MeasureData setZuoShangTuiChang(BigDecimal zuoShangTuiChang) {
		this.zuoShangTuiChang=zuoShangTuiChang;
		return this;
	}
	
	/**
	 * 添加 左上腿长
	 * @param zuoShangTuiChang 左上腿长
	 * @return 当前对象
	*/
	
	/**
	 * 获得 左下腿长<br>
	 * 属性说明 : 左下腿长
	 * @return 左下腿长
	*/
	public BigDecimal getZuoXiaTuiChang() {
		return zuoXiaTuiChang;
	}
	
	/**
	 * 设置 左下腿长
	 * @param zuoXiaTuiChang 左下腿长
	 * @return 当前对象
	*/
	public MeasureData setZuoXiaTuiChang(BigDecimal zuoXiaTuiChang) {
		this.zuoXiaTuiChang=zuoXiaTuiChang;
		return this;
	}
	
	/**
	 * 添加 左下腿长
	 * @param zuoXiaTuiChang 左下腿长
	 * @return 当前对象
	*/

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MeasureData , 转换好的 MeasureData 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MeasureData , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 MeasureData
	 * @param measureDataMap 包含实体信息的 Map 对象
	 * @return MeasureData , 转换好的的 MeasureData 对象
	*/
	@Transient
	public static MeasureData createFrom(Map<String,Object> measureDataMap) {
		if(measureDataMap==null) return null;
		MeasureData po = EntityContext.create(MeasureData.class, measureDataMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 MeasureData
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MeasureData , 转换好的的 MeasureData 对象
	*/
	@Transient
	public static MeasureData createFrom(Object pojo) {
		if(pojo==null) return null;
		MeasureData po = EntityContext.create(MeasureData.class,pojo);
		return po;
	}

	/**
	 * 创建一个 MeasureData，等同于 new
	 * @return MeasureData 对象
	*/
	@Transient
	public static MeasureData create() {
		return new MeasureData();
	}
}