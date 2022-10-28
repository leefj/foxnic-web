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
import org.github.foxnic.web.domain.oauth.meta.SessionOnlineVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 在线会话VO类型
 * <p>在线会话 , 数据表 sys_session_online 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 15:18:31
 * @sign FE98016781F1D2B503D626A0F384FF8F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "在线会话VO类型 ; 在线会话 , 数据表 sys_session_online 的通用VO类型" , parent = SessionOnline.class)
public class SessionOnlineVO extends SessionOnline {

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
	public SessionOnlineVO setPageIndex(Integer pageIndex) {
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
	public SessionOnlineVO setPageSize(Integer pageSize) {
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
	public SessionOnlineVO setSearchField(String searchField) {
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
	public SessionOnlineVO setFuzzyField(String fuzzyField) {
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
	public SessionOnlineVO setSearchValue(String searchValue) {
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
	public SessionOnlineVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public SessionOnlineVO addDirtyField(String... dirtyField) {
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
	public SessionOnlineVO setSortField(String sortField) {
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
	public SessionOnlineVO setSortType(String sortType) {
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
	public SessionOnlineVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public SessionOnlineVO addId(String... id) {
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
	 * @return SessionOnlineVO , 转换好的 SessionOnlineVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SessionOnlineVO , 转换好的 PoJo 对象
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
	public SessionOnlineVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SessionOnlineVO duplicate(boolean all) {
		org.github.foxnic.web.domain.oauth.meta.SessionOnlineVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.oauth.meta.SessionOnlineVOMeta.$$proxy$$();
		inst.setInteractTime(this.getInteractTime());
		inst.setHostId(this.getHostId());
		inst.setSessionTime(this.getSessionTime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSessionId(this.getSessionId());
		inst.setAccessToken(this.getAccessToken());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setLogoutTime(this.getLogoutTime());
		inst.setCreateBy(this.getCreateBy());
		inst.setLoginTime(this.getLoginTime());
		inst.setInteractUrl(this.getInteractUrl());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setOnline(this.getOnline());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setNodeId(this.getNodeId());
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
			inst.setUser(this.getUser());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public SessionOnlineVO clone(boolean deep) {
		return EntityContext.clone(SessionOnlineVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SessionOnlineVO
	 * @param sessionOnlineMap 包含实体信息的 Map 对象
	 * @return SessionOnlineVO , 转换好的的 SessionOnline 对象
	*/
	@Transient
	public static SessionOnlineVO createFrom(Map<String,Object> sessionOnlineMap) {
		if(sessionOnlineMap==null) return null;
		SessionOnlineVO vo = create();
		EntityContext.copyProperties(vo,sessionOnlineMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 SessionOnlineVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SessionOnlineVO , 转换好的的 SessionOnline 对象
	*/
	@Transient
	public static SessionOnlineVO createFrom(Object pojo) {
		if(pojo==null) return null;
		SessionOnlineVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 SessionOnlineVO，等同于 new
	 * @return SessionOnlineVO 对象
	*/
	@Transient
	public static SessionOnlineVO create() {
		return new org.github.foxnic.web.domain.oauth.meta.SessionOnlineVOMeta.$$proxy$$();
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
			this.setInteractTime(DataParser.parse(Date.class, map.get(SessionOnlineVOMeta.INTERACT_TIME)));
			this.setHostId(DataParser.parse(String.class, map.get(SessionOnlineVOMeta.HOST_ID)));
			this.setSessionTime(DataParser.parse(Integer.class, map.get(SessionOnlineVOMeta.SESSION_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SessionOnlineVOMeta.UPDATE_TIME)));
			this.setSessionId(DataParser.parse(String.class, map.get(SessionOnlineVOMeta.SESSION_ID)));
			this.setAccessToken(DataParser.parse(String.class, map.get(SessionOnlineVOMeta.ACCESS_TOKEN)));
			this.setUserId(DataParser.parse(String.class, map.get(SessionOnlineVOMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SessionOnlineVOMeta.VERSION)));
			this.setLogoutTime(DataParser.parse(Date.class, map.get(SessionOnlineVOMeta.LOGOUT_TIME)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SessionOnlineVOMeta.CREATE_BY)));
			this.setLoginTime(DataParser.parse(Date.class, map.get(SessionOnlineVOMeta.LOGIN_TIME)));
			this.setInteractUrl(DataParser.parse(String.class, map.get(SessionOnlineVOMeta.INTERACT_URL)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SessionOnlineVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SessionOnlineVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SessionOnlineVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SessionOnlineVOMeta.DELETE_TIME)));
			this.setOnline(DataParser.parse(Integer.class, map.get(SessionOnlineVOMeta.ONLINE)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SessionOnlineVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(SessionOnlineVOMeta.ID)));
			this.setNodeId(DataParser.parse(String.class, map.get(SessionOnlineVOMeta.NODE_ID)));
			this.setRefreshToken(DataParser.parse(String.class, map.get(SessionOnlineVOMeta.REFRESH_TOKEN)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(SessionOnlineVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(SessionOnlineVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(SessionOnlineVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(SessionOnlineVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(SessionOnlineVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(SessionOnlineVOMeta.PAGE_SIZE)));
			this.setUser(DataParser.parse(User.class, map.get(SessionOnlineVOMeta.USER)));
			this.setSearchValue(DataParser.parse(String.class, map.get(SessionOnlineVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setInteractTime( (Date)map.get(SessionOnlineVOMeta.INTERACT_TIME));
				this.setHostId( (String)map.get(SessionOnlineVOMeta.HOST_ID));
				this.setSessionTime( (Integer)map.get(SessionOnlineVOMeta.SESSION_TIME));
				this.setUpdateTime( (Date)map.get(SessionOnlineVOMeta.UPDATE_TIME));
				this.setSessionId( (String)map.get(SessionOnlineVOMeta.SESSION_ID));
				this.setAccessToken( (String)map.get(SessionOnlineVOMeta.ACCESS_TOKEN));
				this.setUserId( (String)map.get(SessionOnlineVOMeta.USER_ID));
				this.setVersion( (Integer)map.get(SessionOnlineVOMeta.VERSION));
				this.setLogoutTime( (Date)map.get(SessionOnlineVOMeta.LOGOUT_TIME));
				this.setCreateBy( (String)map.get(SessionOnlineVOMeta.CREATE_BY));
				this.setLoginTime( (Date)map.get(SessionOnlineVOMeta.LOGIN_TIME));
				this.setInteractUrl( (String)map.get(SessionOnlineVOMeta.INTERACT_URL));
				this.setDeleted( (Integer)map.get(SessionOnlineVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(SessionOnlineVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(SessionOnlineVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(SessionOnlineVOMeta.DELETE_TIME));
				this.setOnline( (Integer)map.get(SessionOnlineVOMeta.ONLINE));
				this.setDeleteBy( (String)map.get(SessionOnlineVOMeta.DELETE_BY));
				this.setId( (String)map.get(SessionOnlineVOMeta.ID));
				this.setNodeId( (String)map.get(SessionOnlineVOMeta.NODE_ID));
				this.setRefreshToken( (String)map.get(SessionOnlineVOMeta.REFRESH_TOKEN));
				// others
				this.setSearchField( (String)map.get(SessionOnlineVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(SessionOnlineVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(SessionOnlineVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(SessionOnlineVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(SessionOnlineVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(SessionOnlineVOMeta.PAGE_SIZE));
				this.setUser( (User)map.get(SessionOnlineVOMeta.USER));
				this.setSearchValue( (String)map.get(SessionOnlineVOMeta.SEARCH_VALUE));
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
			this.setInteractTime(DataParser.parse(Date.class, r.getValue(SessionOnlineVOMeta.INTERACT_TIME)));
			this.setHostId(DataParser.parse(String.class, r.getValue(SessionOnlineVOMeta.HOST_ID)));
			this.setSessionTime(DataParser.parse(Integer.class, r.getValue(SessionOnlineVOMeta.SESSION_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SessionOnlineVOMeta.UPDATE_TIME)));
			this.setSessionId(DataParser.parse(String.class, r.getValue(SessionOnlineVOMeta.SESSION_ID)));
			this.setAccessToken(DataParser.parse(String.class, r.getValue(SessionOnlineVOMeta.ACCESS_TOKEN)));
			this.setUserId(DataParser.parse(String.class, r.getValue(SessionOnlineVOMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SessionOnlineVOMeta.VERSION)));
			this.setLogoutTime(DataParser.parse(Date.class, r.getValue(SessionOnlineVOMeta.LOGOUT_TIME)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SessionOnlineVOMeta.CREATE_BY)));
			this.setLoginTime(DataParser.parse(Date.class, r.getValue(SessionOnlineVOMeta.LOGIN_TIME)));
			this.setInteractUrl(DataParser.parse(String.class, r.getValue(SessionOnlineVOMeta.INTERACT_URL)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SessionOnlineVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SessionOnlineVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SessionOnlineVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SessionOnlineVOMeta.DELETE_TIME)));
			this.setOnline(DataParser.parse(Integer.class, r.getValue(SessionOnlineVOMeta.ONLINE)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SessionOnlineVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(SessionOnlineVOMeta.ID)));
			this.setNodeId(DataParser.parse(String.class, r.getValue(SessionOnlineVOMeta.NODE_ID)));
			this.setRefreshToken(DataParser.parse(String.class, r.getValue(SessionOnlineVOMeta.REFRESH_TOKEN)));
			return true;
		} else {
			try {
				this.setInteractTime( (Date)r.getValue(SessionOnlineVOMeta.INTERACT_TIME));
				this.setHostId( (String)r.getValue(SessionOnlineVOMeta.HOST_ID));
				this.setSessionTime( (Integer)r.getValue(SessionOnlineVOMeta.SESSION_TIME));
				this.setUpdateTime( (Date)r.getValue(SessionOnlineVOMeta.UPDATE_TIME));
				this.setSessionId( (String)r.getValue(SessionOnlineVOMeta.SESSION_ID));
				this.setAccessToken( (String)r.getValue(SessionOnlineVOMeta.ACCESS_TOKEN));
				this.setUserId( (String)r.getValue(SessionOnlineVOMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(SessionOnlineVOMeta.VERSION));
				this.setLogoutTime( (Date)r.getValue(SessionOnlineVOMeta.LOGOUT_TIME));
				this.setCreateBy( (String)r.getValue(SessionOnlineVOMeta.CREATE_BY));
				this.setLoginTime( (Date)r.getValue(SessionOnlineVOMeta.LOGIN_TIME));
				this.setInteractUrl( (String)r.getValue(SessionOnlineVOMeta.INTERACT_URL));
				this.setDeleted( (Integer)r.getValue(SessionOnlineVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(SessionOnlineVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(SessionOnlineVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(SessionOnlineVOMeta.DELETE_TIME));
				this.setOnline( (Integer)r.getValue(SessionOnlineVOMeta.ONLINE));
				this.setDeleteBy( (String)r.getValue(SessionOnlineVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(SessionOnlineVOMeta.ID));
				this.setNodeId( (String)r.getValue(SessionOnlineVOMeta.NODE_ID));
				this.setRefreshToken( (String)r.getValue(SessionOnlineVOMeta.REFRESH_TOKEN));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}