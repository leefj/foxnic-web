package com.scientific.tailoring.domain.order;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 01:24:39
 * @sign 2DF44C7B8D828E5BB12284EBEE05A8DB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MeasureVO extends Measure {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 页码
	*/
	@ApiModelProperty(required = false,value="页码" , notes = "")
	private Integer pageIndex;
	
	/**
	 * 分页大小
	*/
	@ApiModelProperty(required = false,value="分页大小" , notes = "")
	private Integer pageSize;
	
	/**
	 * 搜索字段
	*/
	@ApiModelProperty(required = false,value="搜索字段" , notes = "")
	private String searchField;
	
	/**
	 * 搜索的值
	*/
	@ApiModelProperty(required = false,value="搜索的值" , notes = "")
	private String searchValue;
	
	/**
	 * 主键清单：用于接收批量主键参数
	*/
	@ApiModelProperty(required = false,value="主键清单" , notes = "用于接收批量主键参数")
	private List<Long> ids;
	
	/**
	 * 姓名
	*/
	@ApiModelProperty(required = false,value="姓名" , notes = "")
	private String bodyName;
	
	/**
	 * body表的ID字段
	*/
	@ApiModelProperty(required = false,value="body表的ID字段" , notes = "")
	private Long bid;
	
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
	 * 状态列表：指定需要过滤的状态类型
	*/
	@ApiModelProperty(required = false,value="状态列表" , notes = "指定需要过滤的状态类型")
	private List<String> statusList;
	
	/**
	 * 测量类型：净体body;着装outfit
	*/
	@ApiModelProperty(required = false,value="测量类型" , notes = "净体body;着装outfit")
	private String measureType;
	
	/**
	 * 获得 页码<br>
	 * @return 页码
	*/
	public Integer getPageIndex() {
		return pageIndex;
	}
	
	/**
	 * 设置 页码
	 * @param pageIndex 页码
	 * @return 当前对象
	*/
	public MeasureVO setPageIndex(Integer pageIndex) {
		this.pageIndex=pageIndex;
		return this;
	}
	
	/**
	 * 添加 页码
	 * @param pageIndex 页码
	 * @return 当前对象
	*/
	
	/**
	 * 获得 分页大小<br>
	 * @return 分页大小
	*/
	public Integer getPageSize() {
		return pageSize;
	}
	
	/**
	 * 设置 分页大小
	 * @param pageSize 分页大小
	 * @return 当前对象
	*/
	public MeasureVO setPageSize(Integer pageSize) {
		this.pageSize=pageSize;
		return this;
	}
	
	/**
	 * 添加 分页大小
	 * @param pageSize 分页大小
	 * @return 当前对象
	*/
	
	/**
	 * 获得 搜索字段<br>
	 * @return 搜索字段
	*/
	public String getSearchField() {
		return searchField;
	}
	
	/**
	 * 设置 搜索字段
	 * @param searchField 搜索字段
	 * @return 当前对象
	*/
	public MeasureVO setSearchField(String searchField) {
		this.searchField=searchField;
		return this;
	}
	
	/**
	 * 添加 搜索字段
	 * @param searchField 搜索字段
	 * @return 当前对象
	*/
	
	/**
	 * 获得 搜索的值<br>
	 * @return 搜索的值
	*/
	public String getSearchValue() {
		return searchValue;
	}
	
	/**
	 * 设置 搜索的值
	 * @param searchValue 搜索的值
	 * @return 当前对象
	*/
	public MeasureVO setSearchValue(String searchValue) {
		this.searchValue=searchValue;
		return this;
	}
	
	/**
	 * 添加 搜索的值
	 * @param searchValue 搜索的值
	 * @return 当前对象
	*/
	
	/**
	 * 获得 主键清单<br>
	 * 属性说明 : 用于接收批量主键参数
	 * @return 主键清单
	*/
	public List<Long> getIds() {
		return ids;
	}
	
	/**
	 * 设置 主键清单
	 * @param ids 主键清单
	 * @return 当前对象
	*/
	public MeasureVO setIds(List<Long> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param ids 主键清单
	 * @return 当前对象
	*/
	public MeasureVO addId(Long id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.add(id);
		return this;
	}
	
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
	public MeasureVO setBodyName(String bodyName) {
		this.bodyName=bodyName;
		return this;
	}
	
	/**
	 * 添加 姓名
	 * @param bodyName 姓名
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
	public MeasureVO setBid(Long bid) {
		this.bid=bid;
		return this;
	}
	
	/**
	 * 添加 body表的ID字段
	 * @param bid body表的ID字段
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
	public MeasureVO setBodyDept(String bodyDept) {
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
	public MeasureVO setBodySex(String bodySex) {
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
	public MeasureVO setBodyHeight(Integer bodyHeight) {
		this.bodyHeight=bodyHeight;
		return this;
	}
	
	/**
	 * 添加 身高
	 * @param bodyHeight 身高
	 * @return 当前对象
	*/
	
	/**
	 * 获得 状态列表<br>
	 * 属性说明 : 指定需要过滤的状态类型
	 * @return 状态列表
	*/
	public List<String> getStatusList() {
		return statusList;
	}
	
	/**
	 * 设置 状态列表
	 * @param statusList 状态列表
	 * @return 当前对象
	*/
	public MeasureVO setStatusList(List<String> statusList) {
		this.statusList=statusList;
		return this;
	}
	
	/**
	 * 添加 状态列表
	 * @param statusList 状态列表
	 * @return 当前对象
	*/
	public MeasureVO addStatus(String status) {
		if(this.statusList==null) statusList=new ArrayList<>();
		this.statusList.add(status);
		return this;
	}
	
	/**
	 * 获得 测量类型<br>
	 * 属性说明 : 净体body;着装outfit
	 * @return 测量类型
	*/
	public String getMeasureType() {
		return measureType;
	}
	
	/**
	 * 设置 测量类型
	 * @param measureType 测量类型
	 * @return 当前对象
	*/
	public MeasureVO setMeasureType(String measureType) {
		this.measureType=measureType;
		return this;
	}
	
	/**
	 * 添加 测量类型
	 * @param measureType 测量类型
	 * @return 当前对象
	*/
}