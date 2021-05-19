package com.scientific.tailoring.domain.system;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 10:53:40
 * @sign 3FA5CF2226CBD6353EDB86F1B0D5A218
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class UserVO extends User {

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
	 * 角色ID清单
	*/
	@ApiModelProperty(required = false,value="角色ID清单" , notes = "")
	private List<Integer> roleIds;
	
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
	public UserVO setPageIndex(Integer pageIndex) {
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
	public UserVO setPageSize(Integer pageSize) {
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
	public UserVO setSearchField(String searchField) {
		this.searchField=searchField;
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
	public UserVO setSearchValue(String searchValue) {
		this.searchValue=searchValue;
		return this;
	}
	
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
	public UserVO setIds(List<Long> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 获得 角色ID清单<br>
	 * @return 角色ID清单
	*/
	public List<Integer> getRoleIds() {
		return roleIds;
	}
	
	/**
	 * 设置 角色ID清单
	 * @param roleIds 角色ID清单
	 * @return 当前对象
	*/
	public UserVO setRoleIds(List<Integer> roleIds) {
		this.roleIds=roleIds;
		return this;
	}
}