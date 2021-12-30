package org.github.foxnic.web.domain.pcm;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;



/**
 * 用于PCM数据查询
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-29 16:34:36
 * @sign 894B3A54E71CCDFDE72909E263659396
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DataQueryVo {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 租户ID
	*/
	@ApiModelProperty(required = false,value="租户ID" , notes = "")
	private String tenantId;
	
	/**
	 * 类目ID
	*/
	@ApiModelProperty(required = false,value="类目ID" , notes = "")
	private String catalogId;
	
	/**
	 * 数据的ID清单
	*/
	@ApiModelProperty(required = false,value="数据的ID清单" , notes = "")
	private List<String> ids;
	
	/**
	 * 所有者单据ID清单
	*/
	@ApiModelProperty(required = false,value="所有者单据ID清单" , notes = "")
	private List<String> ownerIds;
	
	/**
	 * 获得 租户ID<br>
	 * @return 租户ID
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户ID
	 * @param tenantId 租户ID
	 * @return 当前对象
	*/
	public DataQueryVo setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 类目ID<br>
	 * @return 类目ID
	*/
	public String getCatalogId() {
		return catalogId;
	}
	
	/**
	 * 设置 类目ID
	 * @param catalogId 类目ID
	 * @return 当前对象
	*/
	public DataQueryVo setCatalogId(String catalogId) {
		this.catalogId=catalogId;
		return this;
	}
	
	/**
	 * 获得 数据的ID清单<br>
	 * @return 数据的ID清单
	*/
	public List<String> getIds() {
		return ids;
	}
	
	/**
	 * 设置 数据的ID清单
	 * @param ids 数据的ID清单
	 * @return 当前对象
	*/
	public DataQueryVo setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 数据的ID清单
	 * @param id 数据的ID清单
	 * @return 当前对象
	*/
	public DataQueryVo addId(String id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.add(id);
		return this;
	}
	
	/**
	 * 获得 所有者单据ID清单<br>
	 * @return 所有者单据ID清单
	*/
	public List<String> getOwnerIds() {
		return ownerIds;
	}
	
	/**
	 * 设置 所有者单据ID清单
	 * @param ownerIds 所有者单据ID清单
	 * @return 当前对象
	*/
	public DataQueryVo setOwnerIds(List<String> ownerIds) {
		this.ownerIds=ownerIds;
		return this;
	}
	
	/**
	 * 添加 所有者单据ID清单
	 * @param ownerId 所有者单据ID清单
	 * @return 当前对象
	*/
	public DataQueryVo addOwnerId(String ownerId) {
		if(this.ownerIds==null) ownerIds=new ArrayList<>();
		this.ownerIds.add(ownerId);
		return this;
	}
}