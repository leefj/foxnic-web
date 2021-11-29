package org.github.foxnic.web.domain.hrm;

import com.github.foxnic.api.model.CompositeParameter;
import com.github.foxnic.commons.bean.BeanUtil;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;



/**
 * 组织层级
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-29 17:12:26
 * @sign E0D27372A47B51669D48690ECC93B690
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
	 * 已修改字段
	*/
	@ApiModelProperty(required = false,value="已修改字段" , notes = "")
	private List<String> dirtyFields;

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
	 * 根节点id或code：根节点id
	*/
	@ApiModelProperty(required = false,value="根节点id或code" , notes = "根节点id")
	private String root;

	/**
	 * 呈现模式：呈现模式:pos,org,com,dept
	*/
	@ApiModelProperty(required = false,value="呈现模式" , notes = "呈现模式:pos,org,com,dept")
	private String targetType;

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
	 * 获得 已修改字段<br>
	 * @return 已修改字段
	*/
	public List<String> getDirtyFields() {
		return dirtyFields;
	}

	/**
	 * 设置 已修改字段
	 * @param dirtyFields 已修改字段
	 * @return 当前对象
	*/
	public OrganizationVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}

	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public OrganizationVO addDirtyField(String dirtyField) {
		if(this.dirtyFields==null) dirtyFields=new ArrayList<>();
		this.dirtyFields.add(dirtyField);
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
	 * 获得 根节点id或code<br>
	 * 根节点id
	 * @return 根节点id或code
	*/
	public String getRoot() {
		return root;
	}

	/**
	 * 设置 根节点id或code
	 * @param root 根节点id或code
	 * @return 当前对象
	*/
	public OrganizationVO setRoot(String root) {
		this.root=root;
		return this;
	}

	/**
	 * 获得 呈现模式<br>
	 * 呈现模式:pos,org,com,dept
	 * @return 呈现模式
	*/
	public String getTargetType() {
		return targetType;
	}

	/**
	 * 设置 呈现模式
	 * @param targetType 呈现模式
	 * @return 当前对象
	*/
	public OrganizationVO setTargetType(String targetType) {
		this.targetType=targetType;
		return this;
	}
	@Transient
	private CompositeParameter $compositeParameter;
	/**
	 * 获得解析后的复合查询参数
	 */
	@Transient
	public CompositeParameter getCompositeParameter() {
		if($compositeParameter!=null) return  $compositeParameter;
		$compositeParameter=new CompositeParameter(this.getSearchValue(),BeanUtil.toMap(this));
		return  $compositeParameter;
	}
}
