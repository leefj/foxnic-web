package org.github.foxnic.web.domain.oauth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.github.foxnic.api.model.CompositeParameter;
import javax.persistence.Transient;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;
import java.util.Map;
import org.github.foxnic.web.domain.oauth.meta.OauthClientVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 认证客户端VO类型
 * <p>认证客户端 , 数据表 sys_oauth_client 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 15:18:30
 * @sign E52EC3770C9F13BDDEFD22A75F7ED55C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "认证客户端VO类型 ; 认证客户端 , 数据表 sys_oauth_client 的通用VO类型" , parent = OauthClient.class)
public class OauthClientVO extends OauthClient {

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
	public OauthClientVO setPageIndex(Integer pageIndex) {
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
	public OauthClientVO setPageSize(Integer pageSize) {
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
	public OauthClientVO setSearchField(String searchField) {
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
	public OauthClientVO setFuzzyField(String fuzzyField) {
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
	public OauthClientVO setSearchValue(String searchValue) {
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
	public OauthClientVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public OauthClientVO addDirtyField(String... dirtyField) {
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
	public OauthClientVO setSortField(String sortField) {
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
	public OauthClientVO setSortType(String sortType) {
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
	public OauthClientVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public OauthClientVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
		return this;
	}
	@Transient
	private transient CompositeParameter $compositeParameter;
	/**
	 * 获得解析后的复合查询参数
	 */
	@Transient
	public CompositeParameter getCompositeParameter() {
		if($compositeParameter!=null) return  $compositeParameter;
		$compositeParameter=new CompositeParameter(this.getSearchValue(),BeanUtil.toMap(this));
		return  $compositeParameter;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return OauthClientVO , 转换好的 OauthClientVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return OauthClientVO , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public OauthClientVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public OauthClientVO duplicate(boolean all) {
		org.github.foxnic.web.domain.oauth.meta.OauthClientVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.oauth.meta.OauthClientVOMeta.$$proxy$$();
		inst.setAuthorizedGrantTypes(this.getAuthorizedGrantTypes());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setAuthorities(this.getAuthorities());
		inst.setAccessTokenValidity(this.getAccessTokenValidity());
		inst.setAutoApprove(this.getAutoApprove());
		inst.setValid(this.getValid());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setTrusted(this.getTrusted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setRefreshTokenValidity(this.getRefreshTokenValidity());
		inst.setScope(this.getScope());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setClientSecret(this.getClientSecret());
		inst.setWebServerRedirectUri(this.getWebServerRedirectUri());
		inst.setId(this.getId());
		inst.setResourceIds(this.getResourceIds());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setPageSize(this.getPageSize());
			inst.setIds(this.getIds());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public OauthClientVO clone(boolean deep) {
		return EntityContext.clone(OauthClientVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 OauthClientVO
	 * @param oauthClientMap 包含实体信息的 Map 对象
	 * @return OauthClientVO , 转换好的的 OauthClient 对象
	*/
	@Transient
	public static OauthClientVO createFrom(Map<String,Object> oauthClientMap) {
		if(oauthClientMap==null) return null;
		OauthClientVO vo = create();
		EntityContext.copyProperties(vo,oauthClientMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 OauthClientVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return OauthClientVO , 转换好的的 OauthClient 对象
	*/
	@Transient
	public static OauthClientVO createFrom(Object pojo) {
		if(pojo==null) return null;
		OauthClientVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 OauthClientVO，等同于 new
	 * @return OauthClientVO 对象
	*/
	@Transient
	public static OauthClientVO create() {
		return new org.github.foxnic.web.domain.oauth.meta.OauthClientVOMeta.$$proxy$$();
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setAuthorizedGrantTypes(DataParser.parse(String.class, map.get(OauthClientVOMeta.AUTHORIZED_GRANT_TYPES)));
			this.setNotes(DataParser.parse(String.class, map.get(OauthClientVOMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(OauthClientVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(OauthClientVOMeta.VERSION)));
			this.setAuthorities(DataParser.parse(String.class, map.get(OauthClientVOMeta.AUTHORITIES)));
			this.setAccessTokenValidity(DataParser.parse(Integer.class, map.get(OauthClientVOMeta.ACCESS_TOKEN_VALIDITY)));
			this.setAutoApprove(DataParser.parse(Integer.class, map.get(OauthClientVOMeta.AUTO_APPROVE)));
			this.setValid(DataParser.parse(Integer.class, map.get(OauthClientVOMeta.VALID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(OauthClientVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(OauthClientVOMeta.DELETED)));
			this.setTrusted(DataParser.parse(Integer.class, map.get(OauthClientVOMeta.TRUSTED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(OauthClientVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(OauthClientVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(OauthClientVOMeta.DELETE_TIME)));
			this.setRefreshTokenValidity(DataParser.parse(Integer.class, map.get(OauthClientVOMeta.REFRESH_TOKEN_VALIDITY)));
			this.setScope(DataParser.parse(String.class, map.get(OauthClientVOMeta.SCOPE)));
			this.setName(DataParser.parse(String.class, map.get(OauthClientVOMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(OauthClientVOMeta.DELETE_BY)));
			this.setClientSecret(DataParser.parse(String.class, map.get(OauthClientVOMeta.CLIENT_SECRET)));
			this.setWebServerRedirectUri(DataParser.parse(String.class, map.get(OauthClientVOMeta.WEB_SERVER_REDIRECT_URI)));
			this.setId(DataParser.parse(String.class, map.get(OauthClientVOMeta.ID)));
			this.setResourceIds(DataParser.parse(String.class, map.get(OauthClientVOMeta.RESOURCE_IDS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(OauthClientVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(OauthClientVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(OauthClientVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(OauthClientVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(OauthClientVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(OauthClientVOMeta.PAGE_SIZE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(OauthClientVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setAuthorizedGrantTypes( (String)map.get(OauthClientVOMeta.AUTHORIZED_GRANT_TYPES));
				this.setNotes( (String)map.get(OauthClientVOMeta.NOTES));
				this.setUpdateTime( (Date)map.get(OauthClientVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(OauthClientVOMeta.VERSION));
				this.setAuthorities( (String)map.get(OauthClientVOMeta.AUTHORITIES));
				this.setAccessTokenValidity( (Integer)map.get(OauthClientVOMeta.ACCESS_TOKEN_VALIDITY));
				this.setAutoApprove( (Integer)map.get(OauthClientVOMeta.AUTO_APPROVE));
				this.setValid( (Integer)map.get(OauthClientVOMeta.VALID));
				this.setCreateBy( (String)map.get(OauthClientVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(OauthClientVOMeta.DELETED));
				this.setTrusted( (Integer)map.get(OauthClientVOMeta.TRUSTED));
				this.setCreateTime( (Date)map.get(OauthClientVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(OauthClientVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(OauthClientVOMeta.DELETE_TIME));
				this.setRefreshTokenValidity( (Integer)map.get(OauthClientVOMeta.REFRESH_TOKEN_VALIDITY));
				this.setScope( (String)map.get(OauthClientVOMeta.SCOPE));
				this.setName( (String)map.get(OauthClientVOMeta.NAME));
				this.setDeleteBy( (String)map.get(OauthClientVOMeta.DELETE_BY));
				this.setClientSecret( (String)map.get(OauthClientVOMeta.CLIENT_SECRET));
				this.setWebServerRedirectUri( (String)map.get(OauthClientVOMeta.WEB_SERVER_REDIRECT_URI));
				this.setId( (String)map.get(OauthClientVOMeta.ID));
				this.setResourceIds( (String)map.get(OauthClientVOMeta.RESOURCE_IDS));
				// others
				this.setSearchField( (String)map.get(OauthClientVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(OauthClientVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(OauthClientVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(OauthClientVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(OauthClientVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(OauthClientVOMeta.PAGE_SIZE));
				this.setSearchValue( (String)map.get(OauthClientVOMeta.SEARCH_VALUE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setAuthorizedGrantTypes(DataParser.parse(String.class, r.getValue(OauthClientVOMeta.AUTHORIZED_GRANT_TYPES)));
			this.setNotes(DataParser.parse(String.class, r.getValue(OauthClientVOMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(OauthClientVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(OauthClientVOMeta.VERSION)));
			this.setAuthorities(DataParser.parse(String.class, r.getValue(OauthClientVOMeta.AUTHORITIES)));
			this.setAccessTokenValidity(DataParser.parse(Integer.class, r.getValue(OauthClientVOMeta.ACCESS_TOKEN_VALIDITY)));
			this.setAutoApprove(DataParser.parse(Integer.class, r.getValue(OauthClientVOMeta.AUTO_APPROVE)));
			this.setValid(DataParser.parse(Integer.class, r.getValue(OauthClientVOMeta.VALID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(OauthClientVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(OauthClientVOMeta.DELETED)));
			this.setTrusted(DataParser.parse(Integer.class, r.getValue(OauthClientVOMeta.TRUSTED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(OauthClientVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(OauthClientVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(OauthClientVOMeta.DELETE_TIME)));
			this.setRefreshTokenValidity(DataParser.parse(Integer.class, r.getValue(OauthClientVOMeta.REFRESH_TOKEN_VALIDITY)));
			this.setScope(DataParser.parse(String.class, r.getValue(OauthClientVOMeta.SCOPE)));
			this.setName(DataParser.parse(String.class, r.getValue(OauthClientVOMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(OauthClientVOMeta.DELETE_BY)));
			this.setClientSecret(DataParser.parse(String.class, r.getValue(OauthClientVOMeta.CLIENT_SECRET)));
			this.setWebServerRedirectUri(DataParser.parse(String.class, r.getValue(OauthClientVOMeta.WEB_SERVER_REDIRECT_URI)));
			this.setId(DataParser.parse(String.class, r.getValue(OauthClientVOMeta.ID)));
			this.setResourceIds(DataParser.parse(String.class, r.getValue(OauthClientVOMeta.RESOURCE_IDS)));
			return true;
		} else {
			try {
				this.setAuthorizedGrantTypes( (String)r.getValue(OauthClientVOMeta.AUTHORIZED_GRANT_TYPES));
				this.setNotes( (String)r.getValue(OauthClientVOMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(OauthClientVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(OauthClientVOMeta.VERSION));
				this.setAuthorities( (String)r.getValue(OauthClientVOMeta.AUTHORITIES));
				this.setAccessTokenValidity( (Integer)r.getValue(OauthClientVOMeta.ACCESS_TOKEN_VALIDITY));
				this.setAutoApprove( (Integer)r.getValue(OauthClientVOMeta.AUTO_APPROVE));
				this.setValid( (Integer)r.getValue(OauthClientVOMeta.VALID));
				this.setCreateBy( (String)r.getValue(OauthClientVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(OauthClientVOMeta.DELETED));
				this.setTrusted( (Integer)r.getValue(OauthClientVOMeta.TRUSTED));
				this.setCreateTime( (Date)r.getValue(OauthClientVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(OauthClientVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(OauthClientVOMeta.DELETE_TIME));
				this.setRefreshTokenValidity( (Integer)r.getValue(OauthClientVOMeta.REFRESH_TOKEN_VALIDITY));
				this.setScope( (String)r.getValue(OauthClientVOMeta.SCOPE));
				this.setName( (String)r.getValue(OauthClientVOMeta.NAME));
				this.setDeleteBy( (String)r.getValue(OauthClientVOMeta.DELETE_BY));
				this.setClientSecret( (String)r.getValue(OauthClientVOMeta.CLIENT_SECRET));
				this.setWebServerRedirectUri( (String)r.getValue(OauthClientVOMeta.WEB_SERVER_REDIRECT_URI));
				this.setId( (String)r.getValue(OauthClientVOMeta.ID));
				this.setResourceIds( (String)r.getValue(OauthClientVOMeta.RESOURCE_IDS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}