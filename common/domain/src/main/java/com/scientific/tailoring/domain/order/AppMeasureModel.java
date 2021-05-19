package com.scientific.tailoring.domain.order;

import io.swagger.annotations.ApiModelProperty;



/**
 * 测量模型(聚合字典转换等)
 * @author 李方捷
 * @since 2021-05-17 01:24:39
 * @sign E78FEE27E0807C1C620916D22AE56796
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AppMeasureModel extends Measure {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 性别(描述)
	*/
	@ApiModelProperty(required = false,value="性别(描述)" , notes = "")
	private String bodySexLabel;
	
	/**
	 * body表的ID字段
	*/
	@ApiModelProperty(required = false,value="body表的ID字段" , notes = "")
	private Long bid;
	
	/**
	 * 状态标签
	*/
	@ApiModelProperty(required = false,value="状态标签" , notes = "")
	private String statusLabel;
	
	/**
	 * 姓名
	*/
	@ApiModelProperty(required = false,value="姓名" , notes = "")
	private String bodyName;
	
	/**
	 * 部门
	*/
	@ApiModelProperty(required = false,value="部门" , notes = "")
	private String bodyDept;
	
	/**
	 * 性别
	*/
	@ApiModelProperty(required = false,value="性别" , notes = "")
	private String bodySex;
	
	/**
	 * 身高
	*/
	@ApiModelProperty(required = false,value="身高" , notes = "")
	private Integer bodyHeight;
	
	/**
	 * 获得 性别(描述)<br>
	 * @return 性别(描述)
	*/
	public String getBodySexLabel() {
		return bodySexLabel;
	}
	
	/**
	 * 设置 性别(描述)
	 * @param bodySexLabel 性别(描述)
	 * @return 当前对象
	*/
	public AppMeasureModel setBodySexLabel(String bodySexLabel) {
		this.bodySexLabel=bodySexLabel;
		return this;
	}
	
	/**
	 * 添加 性别(描述)
	 * @param bodySexLabel 性别(描述)
	 * @return 当前对象
	*/
	
	/**
	 * 获得 body表的ID字段<br>
	 * @return body表的ID字段
	*/
	public Long getBid() {
		return bid;
	}
	
	/**
	 * 设置 body表的ID字段
	 * @param bid body表的ID字段
	 * @return 当前对象
	*/
	public AppMeasureModel setBid(Long bid) {
		this.bid=bid;
		return this;
	}
	
	/**
	 * 添加 body表的ID字段
	 * @param bid body表的ID字段
	 * @return 当前对象
	*/
	
	/**
	 * 获得 状态标签<br>
	 * @return 状态标签
	*/
	public String getStatusLabel() {
		return statusLabel;
	}
	
	/**
	 * 设置 状态标签
	 * @param statusLabel 状态标签
	 * @return 当前对象
	*/
	public AppMeasureModel setStatusLabel(String statusLabel) {
		this.statusLabel=statusLabel;
		return this;
	}
	
	/**
	 * 添加 状态标签
	 * @param statusLabel 状态标签
	 * @return 当前对象
	*/
	
	/**
	 * 获得 姓名<br>
	 * @return 姓名
	*/
	public String getBodyName() {
		return bodyName;
	}
	
	/**
	 * 设置 姓名
	 * @param bodyName 姓名
	 * @return 当前对象
	*/
	public AppMeasureModel setBodyName(String bodyName) {
		this.bodyName=bodyName;
		return this;
	}
	
	/**
	 * 添加 姓名
	 * @param bodyName 姓名
	 * @return 当前对象
	*/
	
	/**
	 * 获得 部门<br>
	 * @return 部门
	*/
	public String getBodyDept() {
		return bodyDept;
	}
	
	/**
	 * 设置 部门
	 * @param bodyDept 部门
	 * @return 当前对象
	*/
	public AppMeasureModel setBodyDept(String bodyDept) {
		this.bodyDept=bodyDept;
		return this;
	}
	
	/**
	 * 添加 部门
	 * @param bodyDept 部门
	 * @return 当前对象
	*/
	
	/**
	 * 获得 性别<br>
	 * @return 性别
	*/
	public String getBodySex() {
		return bodySex;
	}
	
	/**
	 * 设置 性别
	 * @param bodySex 性别
	 * @return 当前对象
	*/
	public AppMeasureModel setBodySex(String bodySex) {
		this.bodySex=bodySex;
		return this;
	}
	
	/**
	 * 添加 性别
	 * @param bodySex 性别
	 * @return 当前对象
	*/
	
	/**
	 * 获得 身高<br>
	 * @return 身高
	*/
	public Integer getBodyHeight() {
		return bodyHeight;
	}
	
	/**
	 * 设置 身高
	 * @param bodyHeight 身高
	 * @return 当前对象
	*/
	public AppMeasureModel setBodyHeight(Integer bodyHeight) {
		this.bodyHeight=bodyHeight;
		return this;
	}
	
	/**
	 * 添加 身高
	 * @param bodyHeight 身高
	 * @return 当前对象
	*/
}