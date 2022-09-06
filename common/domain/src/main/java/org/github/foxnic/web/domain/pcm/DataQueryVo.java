package org.github.foxnic.web.domain.pcm;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import javax.persistence.Transient;
import com.github.foxnic.commons.bean.BeanUtil;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;



/**
 * 用于PCM数据查询
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:40:33
 * @sign 381635824706D05458C1CB34FACEC93A
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
	 * 分页大小：为 null 时不分页
	*/
	@ApiModelProperty(required = false,value="分页大小" , notes = "为 null 时不分页")
	private Integer pageSize;
	
	/**
	 * 分页页码：为 null 时不分页
	*/
	@ApiModelProperty(required = false,value="分页页码" , notes = "为 null 时不分页")
	private Integer pageIndex;
	
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
	public DataQueryVo addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
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
	public DataQueryVo addOwnerId(String... ownerId) {
		if(this.ownerIds==null) ownerIds=new ArrayList<>();
		this.ownerIds.addAll(Arrays.asList(ownerId));
		return this;
	}
	
	/**
	 * 获得 分页大小<br>
	 * 为 null 时不分页
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
	public DataQueryVo setPageSize(Integer pageSize) {
		this.pageSize=pageSize;
		return this;
	}
	
	/**
	 * 获得 分页页码<br>
	 * 为 null 时不分页
	 * @return 分页页码
	*/
	public Integer getPageIndex() {
		return pageIndex;
	}
	
	/**
	 * 设置 分页页码
	 * @param pageIndex 分页页码
	 * @return 当前对象
	*/
	public DataQueryVo setPageIndex(Integer pageIndex) {
		this.pageIndex=pageIndex;
		return this;
	}

	/**
	 * 创建一个 DataQueryVo，等同于 new
	 * @return DataQueryVo 对象
	*/
	@Transient
	public static DataQueryVo create() {
		return new DataQueryVo();
	}

	/**
	 * 将 Map 转换成 DataQueryVo
	 * @param catalogMap 包含实体信息的 Map 对象
	 * @return DataQueryVo , 转换好的的 Catalog 对象
	*/
	@Transient
	public static DataQueryVo createFrom(Map<String,Object> catalogMap) {
		if(catalogMap==null) return null;
		DataQueryVo po = new DataQueryVo();
		BeanUtil.copy(catalogMap,po);
		return po;
	}

	/**
	 * 将 Pojo 转换成 DataQueryVo
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DataQueryVo , 转换好的的 Catalog 对象
	*/
	@Transient
	public static DataQueryVo createFrom(Object pojo) {
		if(pojo==null) return null;
		DataQueryVo po = new DataQueryVo();
		BeanUtil.copy(pojo,po,true);
		return po;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DataQueryVo clone() {
		return BeanUtil.clone(this,false);
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DataQueryVo clone(boolean deep) {
		return BeanUtil.clone(this,deep);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DataQueryVo , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)EntityContext.create((Class<? extends Entity>) pojoType,this);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}