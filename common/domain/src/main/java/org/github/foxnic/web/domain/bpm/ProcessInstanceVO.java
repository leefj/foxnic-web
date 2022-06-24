package org.github.foxnic.web.domain.bpm;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.github.foxnic.api.model.CompositeParameter;
import javax.persistence.Transient;
import com.github.foxnic.commons.bean.BeanUtil;



/**
 * 流程实例
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-06-24 13:50:06
 * @sign DEDB9EC722B9B23BC314911B41474B11
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessInstanceVO extends ProcessInstance {

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
	 * 已审批人ID清单：查询已审批人ID清单
	*/
	@ApiModelProperty(required = false,value="已审批人ID清单" , notes = "查询已审批人ID清单")
	private List<String> approvedUserIds;
	
	/**
	 * 待审批人ID清单：查询待审批人ID清单
	*/
	@ApiModelProperty(required = false,value="待审批人ID清单" , notes = "查询待审批人ID清单")
	private List<String> approvingUserIds;
	
	/**
	 * 是否我的流程：是否我的流程
	*/
	@ApiModelProperty(required = false,value="是否我的流程" , notes = "是否我的流程")
	private Boolean mine;
	
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
	public ProcessInstanceVO setPageIndex(Integer pageIndex) {
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
	public ProcessInstanceVO setPageSize(Integer pageSize) {
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
	public ProcessInstanceVO setSearchField(String searchField) {
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
	public ProcessInstanceVO setFuzzyField(String fuzzyField) {
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
	public ProcessInstanceVO setSearchValue(String searchValue) {
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
	public ProcessInstanceVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public ProcessInstanceVO addDirtyField(String... dirtyField) {
		if(this.dirtyFields==null) dirtyFields=new ArrayList<>();
		this.dirtyFields.addAll(Arrays.asList(dirtyField));
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
	public ProcessInstanceVO setSortField(String sortField) {
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
	public ProcessInstanceVO setSortType(String sortType) {
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
	public ProcessInstanceVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public ProcessInstanceVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
		return this;
	}
	
	/**
	 * 获得 已审批人ID清单<br>
	 * 查询已审批人ID清单
	 * @return 已审批人ID清单
	*/
	public List<String> getApprovedUserIds() {
		return approvedUserIds;
	}
	
	/**
	 * 设置 已审批人ID清单
	 * @param approvedUserIds 已审批人ID清单
	 * @return 当前对象
	*/
	public ProcessInstanceVO setApprovedUserIds(List<String> approvedUserIds) {
		this.approvedUserIds=approvedUserIds;
		return this;
	}
	
	/**
	 * 添加 已审批人ID清单
	 * @param approvedUserId 已审批人ID清单
	 * @return 当前对象
	*/
	public ProcessInstanceVO addApprovedUserId(String... approvedUserId) {
		if(this.approvedUserIds==null) approvedUserIds=new ArrayList<>();
		this.approvedUserIds.addAll(Arrays.asList(approvedUserId));
		return this;
	}
	
	/**
	 * 获得 待审批人ID清单<br>
	 * 查询待审批人ID清单
	 * @return 待审批人ID清单
	*/
	public List<String> getApprovingUserIds() {
		return approvingUserIds;
	}
	
	/**
	 * 设置 待审批人ID清单
	 * @param approvingUserIds 待审批人ID清单
	 * @return 当前对象
	*/
	public ProcessInstanceVO setApprovingUserIds(List<String> approvingUserIds) {
		this.approvingUserIds=approvingUserIds;
		return this;
	}
	
	/**
	 * 添加 待审批人ID清单
	 * @param approvingUserId 待审批人ID清单
	 * @return 当前对象
	*/
	public ProcessInstanceVO addApprovingUserId(String... approvingUserId) {
		if(this.approvingUserIds==null) approvingUserIds=new ArrayList<>();
		this.approvingUserIds.addAll(Arrays.asList(approvingUserId));
		return this;
	}
	
	/**
	 * 获得 是否我的流程<br>
	 * 是否我的流程
	 * @return 是否我的流程
	*/
	public Boolean isMine() {
		return mine;
	}
	
	/**
	 * 获得 是否我的流程<br>
	 * 等价于 isMine 方法，为兼容 Swagger 需要
	 * 属性说明 : 是否我的流程
	 * @return 是否我的流程
	*/
	public Boolean getMine() {
		return this.mine;
	}
	
	/**
	 * 设置 是否我的流程
	 * @param mine 是否我的流程
	 * @return 当前对象
	*/
	public ProcessInstanceVO setMine(Boolean mine) {
		this.mine=mine;
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