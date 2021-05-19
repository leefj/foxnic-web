package com.scientific.tailoring.domain.product;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 01:20:30
 * @sign C1D0612971CBE6382AC7BA5820A25F78
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProductVO extends Product {

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
	 * 标签ID：指定需要传入的标签ID数组
	*/
	@ApiModelProperty(required = false,value="标签ID" , notes = "指定需要传入的标签ID数组")
	private List<Integer> labelIds;
	
	/**
	 * 图片ID：指定需要传入的图片ID数组，其中第一个为主图
	*/
	@ApiModelProperty(required = false,value="图片ID" , notes = "指定需要传入的图片ID数组，其中第一个为主图")
	private List<Long> imageIds;
	
	/**
	 * 面料ID：指定需要传入的面料ID数组
	*/
	@ApiModelProperty(required = false,value="面料ID" , notes = "指定需要传入的面料ID数组")
	private List<Integer> fabricIds;
	
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
	public ProductVO setPageIndex(Integer pageIndex) {
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
	public ProductVO setPageSize(Integer pageSize) {
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
	public ProductVO setSearchField(String searchField) {
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
	public ProductVO setSearchValue(String searchValue) {
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
	public ProductVO setIds(List<Long> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param ids 主键清单
	 * @return 当前对象
	*/
	public ProductVO addId(Long id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.add(id);
		return this;
	}
	
	/**
	 * 获得 标签ID<br>
	 * 属性说明 : 指定需要传入的标签ID数组
	 * @return 标签ID
	*/
	public List<Integer> getLabelIds() {
		return labelIds;
	}
	
	/**
	 * 设置 标签ID
	 * @param labelIds 标签ID
	 * @return 当前对象
	*/
	public ProductVO setLabelIds(List<Integer> labelIds) {
		this.labelIds=labelIds;
		return this;
	}
	
	/**
	 * 添加 标签ID
	 * @param labelIds 标签ID
	 * @return 当前对象
	*/
	public ProductVO addLabelId(Integer labelId) {
		if(this.labelIds==null) labelIds=new ArrayList<>();
		this.labelIds.add(labelId);
		return this;
	}
	
	/**
	 * 获得 图片ID<br>
	 * 属性说明 : 指定需要传入的图片ID数组，其中第一个为主图
	 * @return 图片ID
	*/
	public List<Long> getImageIds() {
		return imageIds;
	}
	
	/**
	 * 设置 图片ID
	 * @param imageIds 图片ID
	 * @return 当前对象
	*/
	public ProductVO setImageIds(List<Long> imageIds) {
		this.imageIds=imageIds;
		return this;
	}
	
	/**
	 * 添加 图片ID
	 * @param imageIds 图片ID
	 * @return 当前对象
	*/
	public ProductVO addImageId(Long imageId) {
		if(this.imageIds==null) imageIds=new ArrayList<>();
		this.imageIds.add(imageId);
		return this;
	}
	
	/**
	 * 获得 面料ID<br>
	 * 属性说明 : 指定需要传入的面料ID数组
	 * @return 面料ID
	*/
	public List<Integer> getFabricIds() {
		return fabricIds;
	}
	
	/**
	 * 设置 面料ID
	 * @param fabricIds 面料ID
	 * @return 当前对象
	*/
	public ProductVO setFabricIds(List<Integer> fabricIds) {
		this.fabricIds=fabricIds;
		return this;
	}
	
	/**
	 * 添加 面料ID
	 * @param fabricIds 面料ID
	 * @return 当前对象
	*/
	public ProductVO addFabricId(Integer fabricId) {
		if(this.fabricIds==null) fabricIds=new ArrayList<>();
		this.fabricIds.add(fabricId);
		return this;
	}
}