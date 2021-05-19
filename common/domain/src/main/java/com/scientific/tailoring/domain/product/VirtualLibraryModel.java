package com.scientific.tailoring.domain.product;

import io.swagger.annotations.ApiModelProperty;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 01:18:17
 * @sign 0BB2BDCC607BC8F4830E8CA73087C92A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class VirtualLibraryModel extends VirtualLibrary {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 商品名称
	*/
	@ApiModelProperty(required = false,value="商品名称" , notes = "")
	private String productName;
	
	/**
	 * 面料名称
	*/
	@ApiModelProperty(required = false,value="面料名称" , notes = "")
	private String fabricName;
	
	/**
	 * 获得 商品名称<br>
	 * @return 商品名称
	*/
	public String getProductName() {
		return productName;
	}
	
	/**
	 * 设置 商品名称
	 * @param productName 商品名称
	 * @return 当前对象
	*/
	public VirtualLibraryModel setProductName(String productName) {
		this.productName=productName;
		return this;
	}
	
	/**
	 * 添加 商品名称
	 * @param productName 商品名称
	 * @return 当前对象
	*/
	
	/**
	 * 获得 面料名称<br>
	 * @return 面料名称
	*/
	public String getFabricName() {
		return fabricName;
	}
	
	/**
	 * 设置 面料名称
	 * @param fabricName 面料名称
	 * @return 当前对象
	*/
	public VirtualLibraryModel setFabricName(String fabricName) {
		this.fabricName=fabricName;
		return this;
	}
	
	/**
	 * 添加 面料名称
	 * @param fabricName 面料名称
	 * @return 当前对象
	*/
}