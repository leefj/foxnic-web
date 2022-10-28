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
import org.github.foxnic.web.domain.oauth.meta.TokenVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * TokenVO类型
 * <p>Token , 数据表 sys_token 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 15:18:32
 * @sign 3D5BFA6CA800CF875AE6A42C60596A5D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "TokenVO类型 ; Token , 数据表 sys_token 的通用VO类型" , parent = Token.class)
public class TokenVO extends Token {

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
	public TokenVO setPageIndex(Integer pageIndex) {
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
	public TokenVO setPageSize(Integer pageSize) {
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
	public TokenVO setSearchField(String searchField) {
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
	public TokenVO setFuzzyField(String fuzzyField) {
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
	public TokenVO setSearchValue(String searchValue) {
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
	public TokenVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public TokenVO addDirtyField(String... dirtyField) {
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
	public TokenVO setSortField(String sortField) {
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
	public TokenVO setSortType(String sortType) {
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
	public TokenVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public TokenVO addId(String... id) {
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
	 * @return TokenVO , 转换好的 TokenVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return TokenVO , 转换好的 PoJo 对象
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
	public TokenVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public TokenVO duplicate(boolean all) {
		org.github.foxnic.web.domain.oauth.meta.TokenVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.oauth.meta.TokenVOMeta.$$proxy$$();
		inst.setAccessTokenExpireTime(this.getAccessTokenExpireTime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setAccessToken(this.getAccessToken());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setRefreshTokenExpireTime(this.getRefreshTokenExpireTime());
		inst.setRefreshTokenExpired(this.getRefreshTokenExpired());
		inst.setDeleted(this.getDeleted());
		inst.setAccessTokenExpired(this.getAccessTokenExpired());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setJti(this.getJti());
		inst.setRefreshToken(this.getRefreshToken());
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
	public TokenVO clone(boolean deep) {
		return EntityContext.clone(TokenVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 TokenVO
	 * @param tokenMap 包含实体信息的 Map 对象
	 * @return TokenVO , 转换好的的 Token 对象
	*/
	@Transient
	public static TokenVO createFrom(Map<String,Object> tokenMap) {
		if(tokenMap==null) return null;
		TokenVO vo = create();
		EntityContext.copyProperties(vo,tokenMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 TokenVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return TokenVO , 转换好的的 Token 对象
	*/
	@Transient
	public static TokenVO createFrom(Object pojo) {
		if(pojo==null) return null;
		TokenVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 TokenVO，等同于 new
	 * @return TokenVO 对象
	*/
	@Transient
	public static TokenVO create() {
		return new org.github.foxnic.web.domain.oauth.meta.TokenVOMeta.$$proxy$$();
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
			this.setAccessTokenExpireTime(DataParser.parse(Date.class, map.get(TokenVOMeta.ACCESS_TOKEN_EXPIRE_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(TokenVOMeta.UPDATE_TIME)));
			this.setAccessToken(DataParser.parse(String.class, map.get(TokenVOMeta.ACCESS_TOKEN)));
			this.setUserId(DataParser.parse(String.class, map.get(TokenVOMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(TokenVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(TokenVOMeta.CREATE_BY)));
			this.setRefreshTokenExpireTime(DataParser.parse(Date.class, map.get(TokenVOMeta.REFRESH_TOKEN_EXPIRE_TIME)));
			this.setRefreshTokenExpired(DataParser.parse(Integer.class, map.get(TokenVOMeta.REFRESH_TOKEN_EXPIRED)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(TokenVOMeta.DELETED)));
			this.setAccessTokenExpired(DataParser.parse(Integer.class, map.get(TokenVOMeta.ACCESS_TOKEN_EXPIRED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(TokenVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(TokenVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(TokenVOMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(TokenVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(TokenVOMeta.ID)));
			this.setJti(DataParser.parse(String.class, map.get(TokenVOMeta.JTI)));
			this.setRefreshToken(DataParser.parse(String.class, map.get(TokenVOMeta.REFRESH_TOKEN)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(TokenVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(TokenVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(TokenVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(TokenVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(TokenVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(TokenVOMeta.PAGE_SIZE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(TokenVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setAccessTokenExpireTime( (Date)map.get(TokenVOMeta.ACCESS_TOKEN_EXPIRE_TIME));
				this.setUpdateTime( (Date)map.get(TokenVOMeta.UPDATE_TIME));
				this.setAccessToken( (String)map.get(TokenVOMeta.ACCESS_TOKEN));
				this.setUserId( (String)map.get(TokenVOMeta.USER_ID));
				this.setVersion( (Integer)map.get(TokenVOMeta.VERSION));
				this.setCreateBy( (String)map.get(TokenVOMeta.CREATE_BY));
				this.setRefreshTokenExpireTime( (Date)map.get(TokenVOMeta.REFRESH_TOKEN_EXPIRE_TIME));
				this.setRefreshTokenExpired( (Integer)map.get(TokenVOMeta.REFRESH_TOKEN_EXPIRED));
				this.setDeleted( (Integer)map.get(TokenVOMeta.DELETED));
				this.setAccessTokenExpired( (Integer)map.get(TokenVOMeta.ACCESS_TOKEN_EXPIRED));
				this.setCreateTime( (Date)map.get(TokenVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(TokenVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(TokenVOMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(TokenVOMeta.DELETE_BY));
				this.setId( (String)map.get(TokenVOMeta.ID));
				this.setJti( (String)map.get(TokenVOMeta.JTI));
				this.setRefreshToken( (String)map.get(TokenVOMeta.REFRESH_TOKEN));
				// others
				this.setSearchField( (String)map.get(TokenVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(TokenVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(TokenVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(TokenVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(TokenVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(TokenVOMeta.PAGE_SIZE));
				this.setSearchValue( (String)map.get(TokenVOMeta.SEARCH_VALUE));
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
			this.setAccessTokenExpireTime(DataParser.parse(Date.class, r.getValue(TokenVOMeta.ACCESS_TOKEN_EXPIRE_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(TokenVOMeta.UPDATE_TIME)));
			this.setAccessToken(DataParser.parse(String.class, r.getValue(TokenVOMeta.ACCESS_TOKEN)));
			this.setUserId(DataParser.parse(String.class, r.getValue(TokenVOMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(TokenVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(TokenVOMeta.CREATE_BY)));
			this.setRefreshTokenExpireTime(DataParser.parse(Date.class, r.getValue(TokenVOMeta.REFRESH_TOKEN_EXPIRE_TIME)));
			this.setRefreshTokenExpired(DataParser.parse(Integer.class, r.getValue(TokenVOMeta.REFRESH_TOKEN_EXPIRED)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(TokenVOMeta.DELETED)));
			this.setAccessTokenExpired(DataParser.parse(Integer.class, r.getValue(TokenVOMeta.ACCESS_TOKEN_EXPIRED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(TokenVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(TokenVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(TokenVOMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(TokenVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(TokenVOMeta.ID)));
			this.setJti(DataParser.parse(String.class, r.getValue(TokenVOMeta.JTI)));
			this.setRefreshToken(DataParser.parse(String.class, r.getValue(TokenVOMeta.REFRESH_TOKEN)));
			return true;
		} else {
			try {
				this.setAccessTokenExpireTime( (Date)r.getValue(TokenVOMeta.ACCESS_TOKEN_EXPIRE_TIME));
				this.setUpdateTime( (Date)r.getValue(TokenVOMeta.UPDATE_TIME));
				this.setAccessToken( (String)r.getValue(TokenVOMeta.ACCESS_TOKEN));
				this.setUserId( (String)r.getValue(TokenVOMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(TokenVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(TokenVOMeta.CREATE_BY));
				this.setRefreshTokenExpireTime( (Date)r.getValue(TokenVOMeta.REFRESH_TOKEN_EXPIRE_TIME));
				this.setRefreshTokenExpired( (Integer)r.getValue(TokenVOMeta.REFRESH_TOKEN_EXPIRED));
				this.setDeleted( (Integer)r.getValue(TokenVOMeta.DELETED));
				this.setAccessTokenExpired( (Integer)r.getValue(TokenVOMeta.ACCESS_TOKEN_EXPIRED));
				this.setCreateTime( (Date)r.getValue(TokenVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(TokenVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(TokenVOMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(TokenVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(TokenVOMeta.ID));
				this.setJti( (String)r.getValue(TokenVOMeta.JTI));
				this.setRefreshToken( (String)r.getValue(TokenVOMeta.REFRESH_TOKEN));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}