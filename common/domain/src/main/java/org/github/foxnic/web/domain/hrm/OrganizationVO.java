package org.github.foxnic.web.domain.hrm;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;



/**
 * null
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-16 13:01:44
 * @sign 3177C6804E73E487E59DEE7E72C104C9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class OrganizationVO extends Organization {

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
	 * 模糊搜索字段
	*/
	@ApiModelProperty(required = false,value="模糊搜索字段" , notes = "")
	private String fuzzyField;
	
	/**
	 * 搜索的值
	*/
	@ApiModelProperty(required = false,value="搜索的值" , notes = "")
	private String searchValue;
	
	/**
	 * 排序字段
	*/
	@ApiModelProperty(required = false,value="排序字段" , notes = "")
	private String sortField;
	
	/**
	 * 排序方式
	*/
	@ApiModelProperty(required = false,value="排序方式" , notes = "")
	private String sortType;
	
	/**
	 * 主键清单：用于接收批量主键参数
	*/
	@ApiModelProperty(required = false,value="主键清单" , notes = "用于接收批量主键参数")
	private List<String> ids;
	
	/**
	 * 是否加载所有子孙节点：1：是；0：否
	*/
	@ApiModelProperty(required = false,value="是否加载所有子孙节点" , notes = "1：是；0：否")
	private Integer isLoadAllDescendants;
	
	/**
	 * 根节点ID：根节点ID
	*/
	@ApiModelProperty(required = false,value="根节点ID" , notes = "根节点ID")
	private String rootId;
	
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
	public OrganizationVO setPageIndex(Integer pageIndex) {
		this.pageIndex=pageIndex;
		return this;
	}
	
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
	public OrganizationVO setPageSize(Integer pageSize) {
		this.pageSize=pageSize;
		return this;
	}
	
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
	public OrganizationVO setSearchField(String searchField) {
		this.searchField=searchField;
		return this;
	}
	
	/**
	 * 获得 模糊搜索字段<br>
	 * @return 模糊搜索字段
	*/
	public String getFuzzyField() {
		return fuzzyField;
	}
	
	/**
	 * 设置 模糊搜索字段
	 * @param fuzzyField 模糊搜索字段
	 * @return 当前对象
	*/
	public OrganizationVO setFuzzyField(String fuzzyField) {
		this.fuzzyField=fuzzyField;
		return this;
	}
	
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
	public OrganizationVO setSearchValue(String searchValue) {
		this.searchValue=searchValue;
		return this;
	}
	
	/**
	 * 获得 排序字段<br>
	 * @return 排序字段
	*/
	public String getSortField() {
		return sortField;
	}
	
	/**
	 * 设置 排序字段
	 * @param sortField 排序字段
	 * @return 当前对象
	*/
	public OrganizationVO setSortField(String sortField) {
		this.sortField=sortField;
		return this;
	}
	
	/**
	 * 获得 排序方式<br>
	 * @return 排序方式
	*/
	public String getSortType() {
		return sortType;
	}
	
	/**
	 * 设置 排序方式
	 * @param sortType 排序方式
	 * @return 当前对象
	*/
	public OrganizationVO setSortType(String sortType) {
		this.sortType=sortType;
		return this;
	}
	
	/**
	 * 获得 主键清单<br>
	 * 用于接收批量主键参数
	 * @return 主键清单
	*/
	public List<String> getIds() {
		return ids;
	}
	
	/**
	 * 设置 主键清单
	 * @param ids 主键清单
	 * @return 当前对象
	*/
	public OrganizationVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public OrganizationVO addId(String id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.add(id);
		return this;
	}
	
	/**
	 * 获得 是否加载所有子孙节点<br>
	 * 1：是；0：否
	 * @return 是否加载所有子孙节点
	*/
	public Integer getIsLoadAllDescendants() {
		return isLoadAllDescendants;
	}
	
	/**
	 * 设置 是否加载所有子孙节点
	 * @param isLoadAllDescendants 是否加载所有子孙节点
	 * @return 当前对象
	*/
	public OrganizationVO setIsLoadAllDescendants(Integer isLoadAllDescendants) {
		this.isLoadAllDescendants=isLoadAllDescendants;
		return this;
	}
	
	/**
	 * 获得 根节点ID<br>
	 * 根节点ID
	 * @return 根节点ID
	*/
	public String getRootId() {
		return rootId;
	}
	
	/**
	 * 设置 根节点ID
	 * @param rootId 根节点ID
	 * @return 当前对象
	*/
	public OrganizationVO setRootId(String rootId) {
		this.rootId=rootId;
		return this;
	}
}