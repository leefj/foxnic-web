package com.scientific.tailoring.domain.order;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 01:37:00
 * @sign 3D694695520895F867969C1DFE038E7C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MeasureDimensionModel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 数据库字段名
	*/
	@ApiModelProperty(required = false,value="数据库字段名" , notes = "")
	private String dbField;
	
	/**
	 * 实体内的属性名
	*/
	@ApiModelProperty(required = false,value="实体内的属性名" , notes = "")
	private String property;
	
	/**
	 * 标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "")
	private String label;
	
	/**
	 * 值
	*/
	@ApiModelProperty(required = false,value="值" , notes = "")
	private BigDecimal value;
	
	/**
	 * 获得 数据库字段名<br>
	 * @return 数据库字段名
	*/
	public String getDbField() {
		return dbField;
	}
	
	/**
	 * 设置 数据库字段名
	 * @param dbField 数据库字段名
	 * @return 当前对象
	*/
	public MeasureDimensionModel setDbField(String dbField) {
		this.dbField=dbField;
		return this;
	}
	
	/**
	 * 添加 数据库字段名
	 * @param dbField 数据库字段名
	 * @return 当前对象
	*/
	
	/**
	 * 获得 实体内的属性名<br>
	 * @return 实体内的属性名
	*/
	public String getProperty() {
		return property;
	}
	
	/**
	 * 设置 实体内的属性名
	 * @param property 实体内的属性名
	 * @return 当前对象
	*/
	public MeasureDimensionModel setProperty(String property) {
		this.property=property;
		return this;
	}
	
	/**
	 * 添加 实体内的属性名
	 * @param property 实体内的属性名
	 * @return 当前对象
	*/
	
	/**
	 * 获得 标签<br>
	 * @return 标签
	*/
	public String getLabel() {
		return label;
	}
	
	/**
	 * 设置 标签
	 * @param label 标签
	 * @return 当前对象
	*/
	public MeasureDimensionModel setLabel(String label) {
		this.label=label;
		return this;
	}
	
	/**
	 * 添加 标签
	 * @param label 标签
	 * @return 当前对象
	*/
	
	/**
	 * 获得 值<br>
	 * @return 值
	*/
	public BigDecimal getValue() {
		return value;
	}
	
	/**
	 * 设置 值
	 * @param value 值
	 * @return 当前对象
	*/
	public MeasureDimensionModel setValue(BigDecimal value) {
		this.value=value;
		return this;
	}
	
	/**
	 * 添加 值
	 * @param value 值
	 * @return 当前对象
	*/
}