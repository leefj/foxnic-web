package org.github.foxnic.web.domain.bpm;

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
import org.github.foxnic.web.domain.bpm.meta.FormDefinitionVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.User;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 表单定义VO类型
 * <p>表单定义 , 数据表 bpm_form_definition 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-03-23 14:48:00
 * @sign 83DD7FEBBA994A33EDF0C96F677A4A38
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "表单定义VO类型 ; 表单定义 , 数据表 bpm_form_definition 的通用VO类型" , parent = FormDefinition.class)
public class FormDefinitionVO extends FormDefinition {

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
	 * 数据来源：前端指定不同的来源，后端可按来源执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="数据来源" , notes = "前端指定不同的来源，后端可按来源执行不同的逻辑")
	private String dataOrigin;
	
	/**
	 * 查询逻辑：默认and，可指定 or 
	*/
	@ApiModelProperty(required = false,value="查询逻辑" , notes = "默认and，可指定 or ")
	private String queryLogic;
	
	/**
	 * 请求动作：前端指定不同的Action，后端可Action执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="请求动作" , notes = "前端指定不同的Action，后端可Action执行不同的逻辑")
	private String requestAction;
	
	/**
	 * 主键清单：用于接收批量主键参数
	*/
	@ApiModelProperty(required = false,value="主键清单" , notes = "用于接收批量主键参数")
	private List<String> ids;
	
	/**
	 * 是否已经绑定流程：查询条件，null:不控制;1绑定流程:0:未绑定流程
	*/
	@ApiModelProperty(required = false,value="是否已经绑定流程" , notes = "查询条件，null:不控制;1绑定流程:0:未绑定流程")
	private Integer isBindProcess;
	
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
	public FormDefinitionVO setPageIndex(Integer pageIndex) {
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
	public FormDefinitionVO setPageSize(Integer pageSize) {
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
	public FormDefinitionVO setSearchField(String searchField) {
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
	public FormDefinitionVO setFuzzyField(String fuzzyField) {
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
	public FormDefinitionVO setSearchValue(String searchValue) {
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
	public FormDefinitionVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public FormDefinitionVO addDirtyField(String... dirtyField) {
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
	public FormDefinitionVO setSortField(String sortField) {
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
	public FormDefinitionVO setSortType(String sortType) {
		this.sortType=sortType;
		return this;
	}
	
	/**
	 * 获得 数据来源<br>
	 * 前端指定不同的来源，后端可按来源执行不同的逻辑
	 * @return 数据来源
	*/
	public String getDataOrigin() {
		return dataOrigin;
	}
	
	/**
	 * 设置 数据来源
	 * @param dataOrigin 数据来源
	 * @return 当前对象
	*/
	public FormDefinitionVO setDataOrigin(String dataOrigin) {
		this.dataOrigin=dataOrigin;
		return this;
	}
	
	/**
	 * 获得 查询逻辑<br>
	 * 默认and，可指定 or 
	 * @return 查询逻辑
	*/
	public String getQueryLogic() {
		return queryLogic;
	}
	
	/**
	 * 设置 查询逻辑
	 * @param queryLogic 查询逻辑
	 * @return 当前对象
	*/
	public FormDefinitionVO setQueryLogic(String queryLogic) {
		this.queryLogic=queryLogic;
		return this;
	}
	
	/**
	 * 获得 请求动作<br>
	 * 前端指定不同的Action，后端可Action执行不同的逻辑
	 * @return 请求动作
	*/
	public String getRequestAction() {
		return requestAction;
	}
	
	/**
	 * 设置 请求动作
	 * @param requestAction 请求动作
	 * @return 当前对象
	*/
	public FormDefinitionVO setRequestAction(String requestAction) {
		this.requestAction=requestAction;
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
	public FormDefinitionVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public FormDefinitionVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
		return this;
	}
	
	/**
	 * 获得 是否已经绑定流程<br>
	 * 查询条件，null:不控制;1绑定流程:0:未绑定流程
	 * @return 是否已经绑定流程
	*/
	public Integer getIsBindProcess() {
		return isBindProcess;
	}
	
	/**
	 * 设置 是否已经绑定流程
	 * @param isBindProcess 是否已经绑定流程
	 * @return 当前对象
	*/
	public FormDefinitionVO setIsBindProcess(Integer isBindProcess) {
		this.isBindProcess=isBindProcess;
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
	 * @return FormDefinitionVO , 转换好的 FormDefinitionVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return FormDefinitionVO , 转换好的 PoJo 对象
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
	public FormDefinitionVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public FormDefinitionVO duplicate(boolean all) {
		org.github.foxnic.web.domain.bpm.meta.FormDefinitionVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.bpm.meta.FormDefinitionVOMeta.$$proxy$$();
		inst.setApprovalPageUrl(this.getApprovalPageUrl());
		inst.setFormType(this.getFormType());
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setCallbackController(this.getCallbackController());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setMulitiProcess(this.getMulitiProcess());
		inst.setDraftPageUrl(this.getDraftPageUrl());
		inst.setValid(this.getValid());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCatalogId(this.getCatalogId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setIsBindProcess(this.getIsBindProcess());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setLastUpdateUser(this.getLastUpdateUser());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public FormDefinitionVO clone(boolean deep) {
		return EntityContext.clone(FormDefinitionVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 FormDefinitionVO
	 * @param formDefinitionMap 包含实体信息的 Map 对象
	 * @return FormDefinitionVO , 转换好的的 FormDefinition 对象
	*/
	@Transient
	public static FormDefinitionVO createFrom(Map<String,Object> formDefinitionMap) {
		if(formDefinitionMap==null) return null;
		FormDefinitionVO vo = create();
		EntityContext.copyProperties(vo,formDefinitionMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 FormDefinitionVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return FormDefinitionVO , 转换好的的 FormDefinition 对象
	*/
	@Transient
	public static FormDefinitionVO createFrom(Object pojo) {
		if(pojo==null) return null;
		FormDefinitionVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 FormDefinitionVO，等同于 new
	 * @return FormDefinitionVO 对象
	*/
	@Transient
	public static FormDefinitionVO create() {
		return new org.github.foxnic.web.domain.bpm.meta.FormDefinitionVOMeta.$$proxy$$();
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
			this.setApprovalPageUrl(DataParser.parse(String.class, map.get(FormDefinitionVOMeta.APPROVAL_PAGE_URL)));
			this.setFormType(DataParser.parse(String.class, map.get(FormDefinitionVOMeta.FORM_TYPE)));
			this.setCode(DataParser.parse(String.class, map.get(FormDefinitionVOMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(FormDefinitionVOMeta.NOTES)));
			this.setCallbackController(DataParser.parse(String.class, map.get(FormDefinitionVOMeta.CALLBACK_CONTROLLER)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(FormDefinitionVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(FormDefinitionVOMeta.VERSION)));
			this.setMulitiProcess(DataParser.parse(Integer.class, map.get(FormDefinitionVOMeta.MULITI_PROCESS)));
			this.setDraftPageUrl(DataParser.parse(String.class, map.get(FormDefinitionVOMeta.DRAFT_PAGE_URL)));
			this.setValid(DataParser.parse(Integer.class, map.get(FormDefinitionVOMeta.VALID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(FormDefinitionVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(FormDefinitionVOMeta.DELETED)));
			this.setCatalogId(DataParser.parse(String.class, map.get(FormDefinitionVOMeta.CATALOG_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(FormDefinitionVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(FormDefinitionVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(FormDefinitionVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(FormDefinitionVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(FormDefinitionVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(FormDefinitionVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(FormDefinitionVOMeta.ID)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(FormDefinitionVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(FormDefinitionVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(FormDefinitionVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(FormDefinitionVOMeta.PAGE_SIZE)));
			this.setIsBindProcess(DataParser.parse(Integer.class, map.get(FormDefinitionVOMeta.IS_BIND_PROCESS)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(FormDefinitionVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(FormDefinitionVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(FormDefinitionVOMeta.SORT_FIELD)));
			this.setLastUpdateUser(DataParser.parse(User.class, map.get(FormDefinitionVOMeta.LAST_UPDATE_USER)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(FormDefinitionVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(FormDefinitionVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(FormDefinitionVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setApprovalPageUrl( (String)map.get(FormDefinitionVOMeta.APPROVAL_PAGE_URL));
				this.setFormType( (String)map.get(FormDefinitionVOMeta.FORM_TYPE));
				this.setCode( (String)map.get(FormDefinitionVOMeta.CODE));
				this.setNotes( (String)map.get(FormDefinitionVOMeta.NOTES));
				this.setCallbackController( (String)map.get(FormDefinitionVOMeta.CALLBACK_CONTROLLER));
				this.setUpdateTime( (Date)map.get(FormDefinitionVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(FormDefinitionVOMeta.VERSION));
				this.setMulitiProcess( (Integer)map.get(FormDefinitionVOMeta.MULITI_PROCESS));
				this.setDraftPageUrl( (String)map.get(FormDefinitionVOMeta.DRAFT_PAGE_URL));
				this.setValid( (Integer)map.get(FormDefinitionVOMeta.VALID));
				this.setCreateBy( (String)map.get(FormDefinitionVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(FormDefinitionVOMeta.DELETED));
				this.setCatalogId( (String)map.get(FormDefinitionVOMeta.CATALOG_ID));
				this.setCreateTime( (Date)map.get(FormDefinitionVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(FormDefinitionVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(FormDefinitionVOMeta.DELETE_TIME));
				this.setName( (String)map.get(FormDefinitionVOMeta.NAME));
				this.setTenantId( (String)map.get(FormDefinitionVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(FormDefinitionVOMeta.DELETE_BY));
				this.setId( (String)map.get(FormDefinitionVOMeta.ID));
				// others
				this.setSearchField( (String)map.get(FormDefinitionVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(FormDefinitionVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(FormDefinitionVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(FormDefinitionVOMeta.PAGE_SIZE));
				this.setIsBindProcess( (Integer)map.get(FormDefinitionVOMeta.IS_BIND_PROCESS));
				this.setPageIndex( (Integer)map.get(FormDefinitionVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(FormDefinitionVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(FormDefinitionVOMeta.SORT_FIELD));
				this.setLastUpdateUser( (User)map.get(FormDefinitionVOMeta.LAST_UPDATE_USER));
				this.setDataOrigin( (String)map.get(FormDefinitionVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(FormDefinitionVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(FormDefinitionVOMeta.SEARCH_VALUE));
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
			this.setApprovalPageUrl(DataParser.parse(String.class, r.getValue(FormDefinitionVOMeta.APPROVAL_PAGE_URL)));
			this.setFormType(DataParser.parse(String.class, r.getValue(FormDefinitionVOMeta.FORM_TYPE)));
			this.setCode(DataParser.parse(String.class, r.getValue(FormDefinitionVOMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(FormDefinitionVOMeta.NOTES)));
			this.setCallbackController(DataParser.parse(String.class, r.getValue(FormDefinitionVOMeta.CALLBACK_CONTROLLER)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(FormDefinitionVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(FormDefinitionVOMeta.VERSION)));
			this.setMulitiProcess(DataParser.parse(Integer.class, r.getValue(FormDefinitionVOMeta.MULITI_PROCESS)));
			this.setDraftPageUrl(DataParser.parse(String.class, r.getValue(FormDefinitionVOMeta.DRAFT_PAGE_URL)));
			this.setValid(DataParser.parse(Integer.class, r.getValue(FormDefinitionVOMeta.VALID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(FormDefinitionVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(FormDefinitionVOMeta.DELETED)));
			this.setCatalogId(DataParser.parse(String.class, r.getValue(FormDefinitionVOMeta.CATALOG_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(FormDefinitionVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(FormDefinitionVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(FormDefinitionVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(FormDefinitionVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(FormDefinitionVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(FormDefinitionVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(FormDefinitionVOMeta.ID)));
			return true;
		} else {
			try {
				this.setApprovalPageUrl( (String)r.getValue(FormDefinitionVOMeta.APPROVAL_PAGE_URL));
				this.setFormType( (String)r.getValue(FormDefinitionVOMeta.FORM_TYPE));
				this.setCode( (String)r.getValue(FormDefinitionVOMeta.CODE));
				this.setNotes( (String)r.getValue(FormDefinitionVOMeta.NOTES));
				this.setCallbackController( (String)r.getValue(FormDefinitionVOMeta.CALLBACK_CONTROLLER));
				this.setUpdateTime( (Date)r.getValue(FormDefinitionVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(FormDefinitionVOMeta.VERSION));
				this.setMulitiProcess( (Integer)r.getValue(FormDefinitionVOMeta.MULITI_PROCESS));
				this.setDraftPageUrl( (String)r.getValue(FormDefinitionVOMeta.DRAFT_PAGE_URL));
				this.setValid( (Integer)r.getValue(FormDefinitionVOMeta.VALID));
				this.setCreateBy( (String)r.getValue(FormDefinitionVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(FormDefinitionVOMeta.DELETED));
				this.setCatalogId( (String)r.getValue(FormDefinitionVOMeta.CATALOG_ID));
				this.setCreateTime( (Date)r.getValue(FormDefinitionVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(FormDefinitionVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(FormDefinitionVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(FormDefinitionVOMeta.NAME));
				this.setTenantId( (String)r.getValue(FormDefinitionVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(FormDefinitionVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(FormDefinitionVOMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}