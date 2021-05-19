package com.scientific.tailoring.domain.order;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 01:24:39
 * @sign 213B2BE0994D2B0EDAA4F9C3530AC370
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MeasureFileVO extends MeasureFile {

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
	private List<Integer> ids;
	
	/**
	 * 测量文件清单
	*/
	@ApiModelProperty(required = false,value="测量文件清单" , notes = "")
	private List<MeasureFile> measureFiles;
	
	/**
	 * 测量人员ID
	*/
	@ApiModelProperty(required = false,value="测量人员ID" , notes = "")
	private Long bodyId;
	
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
	public MeasureFileVO setPageIndex(Integer pageIndex) {
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
	public MeasureFileVO setPageSize(Integer pageSize) {
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
	public MeasureFileVO setSearchField(String searchField) {
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
	public MeasureFileVO setSearchValue(String searchValue) {
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
	public List<Integer> getIds() {
		return ids;
	}
	
	/**
	 * 设置 主键清单
	 * @param ids 主键清单
	 * @return 当前对象
	*/
	public MeasureFileVO setIds(List<Integer> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param ids 主键清单
	 * @return 当前对象
	*/
	public MeasureFileVO addId(Integer id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.add(id);
		return this;
	}
	
	/**
	 * 获得 测量文件清单<br>
	 * @return 测量文件清单
	*/
	public List<MeasureFile> getMeasureFiles() {
		return measureFiles;
	}
	
	/**
	 * 设置 测量文件清单
	 * @param measureFiles 测量文件清单
	 * @return 当前对象
	*/
	public MeasureFileVO setMeasureFiles(List<MeasureFile> measureFiles) {
		this.measureFiles=measureFiles;
		return this;
	}
	
	/**
	 * 添加 测量文件清单
	 * @param measureFiles 测量文件清单
	 * @return 当前对象
	*/
	public MeasureFileVO addMeasureFile(MeasureFile measureFile) {
		if(this.measureFiles==null) measureFiles=new ArrayList<>();
		this.measureFiles.add(measureFile);
		return this;
	}
	
	/**
	 * 获得 测量人员ID<br>
	 * @return 测量人员ID
	*/
	public Long getBodyId() {
		return bodyId;
	}
	
	/**
	 * 设置 测量人员ID
	 * @param bodyId 测量人员ID
	 * @return 当前对象
	*/
	public MeasureFileVO setBodyId(Long bodyId) {
		this.bodyId=bodyId;
		return this;
	}
	
	/**
	 * 添加 测量人员ID
	 * @param bodyId 测量人员ID
	 * @return 当前对象
	*/
}