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
import org.github.foxnic.web.domain.bpm.meta.ProcessDefinitionVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.User;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 流程定义VO类型
 * <p>流程定义 , 数据表 bpm_process_definition 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-05-04 17:13:59
 * @sign F1102AEA99CE04092FD9D852373AA545
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "流程定义VO类型 ; 流程定义 , 数据表 bpm_process_definition 的通用VO类型" , parent = ProcessDefinition.class)
public class ProcessDefinitionVO extends ProcessDefinition {

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
	 * 表单定义代码：表单定义代码
	*/
	@ApiModelProperty(required = false,value="表单定义代码" , notes = "表单定义代码")
	private String formDefinitionCode;
	
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
	public ProcessDefinitionVO setPageIndex(Integer pageIndex) {
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
	public ProcessDefinitionVO setPageSize(Integer pageSize) {
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
	public ProcessDefinitionVO setSearchField(String searchField) {
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
	public ProcessDefinitionVO setFuzzyField(String fuzzyField) {
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
	public ProcessDefinitionVO setSearchValue(String searchValue) {
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
	public ProcessDefinitionVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public ProcessDefinitionVO addDirtyField(String... dirtyField) {
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
	public ProcessDefinitionVO setSortField(String sortField) {
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
	public ProcessDefinitionVO setSortType(String sortType) {
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
	public ProcessDefinitionVO setDataOrigin(String dataOrigin) {
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
	public ProcessDefinitionVO setQueryLogic(String queryLogic) {
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
	public ProcessDefinitionVO setRequestAction(String requestAction) {
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
	public ProcessDefinitionVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public ProcessDefinitionVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
		return this;
	}
	
	/**
	 * 获得 表单定义代码<br>
	 * 表单定义代码
	 * @return 表单定义代码
	*/
	public String getFormDefinitionCode() {
		return formDefinitionCode;
	}
	
	/**
	 * 设置 表单定义代码
	 * @param formDefinitionCode 表单定义代码
	 * @return 当前对象
	*/
	public ProcessDefinitionVO setFormDefinitionCode(String formDefinitionCode) {
		this.formDefinitionCode=formDefinitionCode;
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
	 * @return ProcessDefinitionVO , 转换好的 ProcessDefinitionVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProcessDefinitionVO , 转换好的 PoJo 对象
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
	public ProcessDefinitionVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ProcessDefinitionVO duplicate(boolean all) {
		org.github.foxnic.web.domain.bpm.meta.ProcessDefinitionVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.bpm.meta.ProcessDefinitionVOMeta.$$proxy$$();
		inst.setAssigneeTypeRange(this.getAssigneeTypeRange());
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setAllowSkip(this.getAllowSkip());
		inst.setCamundaDefinitionId(this.getCamundaDefinitionId());
		inst.setIconFileMobile(this.getIconFileMobile());
		inst.setAllowFetchBack(this.getAllowFetchBack());
		inst.setValid(this.getValid());
		inst.setAllowReject(this.getAllowReject());
		inst.setCatalogId(this.getCatalogId());
		inst.setAllowApproveAttachment(this.getAllowApproveAttachment());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setFormDefinitionId(this.getFormDefinitionId());
		inst.setId(this.getId());
		inst.setAllowDraftingAttachment(this.getAllowDraftingAttachment());
		inst.setRejectOption(this.getRejectOption());
		inst.setCamundaDefinitionKey(this.getCamundaDefinitionKey());
		inst.setDrafterRange(this.getDrafterRange());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setVersion(this.getVersion());
		inst.setAllowAgreeWithCondition(this.getAllowAgreeWithCondition());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAllowAbandon(this.getAllowAbandon());
		inst.setAllowApproveComment(this.getAllowApproveComment());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setAllowDraftingComment(this.getAllowDraftingComment());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setIconFilePc(this.getIconFilePc());
		if(all) {
			inst.setFormDefinitionCode(this.getFormDefinitionCode());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setCatalog(this.getCatalog());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setFormDefinition(this.getFormDefinition());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDefinitionFile(this.getDefinitionFile());
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
	public ProcessDefinitionVO clone(boolean deep) {
		return EntityContext.clone(ProcessDefinitionVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ProcessDefinitionVO
	 * @param processDefinitionMap 包含实体信息的 Map 对象
	 * @return ProcessDefinitionVO , 转换好的的 ProcessDefinition 对象
	*/
	@Transient
	public static ProcessDefinitionVO createFrom(Map<String,Object> processDefinitionMap) {
		if(processDefinitionMap==null) return null;
		ProcessDefinitionVO vo = create();
		EntityContext.copyProperties(vo,processDefinitionMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 ProcessDefinitionVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProcessDefinitionVO , 转换好的的 ProcessDefinition 对象
	*/
	@Transient
	public static ProcessDefinitionVO createFrom(Object pojo) {
		if(pojo==null) return null;
		ProcessDefinitionVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 ProcessDefinitionVO，等同于 new
	 * @return ProcessDefinitionVO 对象
	*/
	@Transient
	public static ProcessDefinitionVO create() {
		return new org.github.foxnic.web.domain.bpm.meta.ProcessDefinitionVOMeta.$$proxy$$();
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
			this.setAssigneeTypeRange(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.ASSIGNEE_TYPE_RANGE)));
			this.setCode(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.NOTES)));
			this.setAllowSkip(DataParser.parse(Integer.class, map.get(ProcessDefinitionVOMeta.ALLOW_SKIP)));
			this.setCamundaDefinitionId(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.CAMUNDA_DEFINITION_ID)));
			this.setIconFileMobile(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.ICON_FILE_MOBILE)));
			this.setAllowFetchBack(DataParser.parse(Integer.class, map.get(ProcessDefinitionVOMeta.ALLOW_FETCH_BACK)));
			this.setValid(DataParser.parse(Integer.class, map.get(ProcessDefinitionVOMeta.VALID)));
			this.setAllowReject(DataParser.parse(Integer.class, map.get(ProcessDefinitionVOMeta.ALLOW_REJECT)));
			this.setCatalogId(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.CATALOG_ID)));
			this.setAllowApproveAttachment(DataParser.parse(Integer.class, map.get(ProcessDefinitionVOMeta.ALLOW_APPROVE_ATTACHMENT)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.UPDATE_BY)));
			this.setFormDefinitionId(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.FORM_DEFINITION_ID)));
			this.setId(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.ID)));
			this.setAllowDraftingAttachment(DataParser.parse(Integer.class, map.get(ProcessDefinitionVOMeta.ALLOW_DRAFTING_ATTACHMENT)));
			this.setRejectOption(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.REJECT_OPTION)));
			this.setCamundaDefinitionKey(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.CAMUNDA_DEFINITION_KEY)));
			this.setDrafterRange(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.DRAFTER_RANGE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ProcessDefinitionVOMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, map.get(ProcessDefinitionVOMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ProcessDefinitionVOMeta.VERSION)));
			this.setAllowAgreeWithCondition(DataParser.parse(Integer.class, map.get(ProcessDefinitionVOMeta.ALLOW_AGREE_WITH_CONDITION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ProcessDefinitionVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ProcessDefinitionVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ProcessDefinitionVOMeta.DELETE_TIME)));
			this.setAllowAbandon(DataParser.parse(Integer.class, map.get(ProcessDefinitionVOMeta.ALLOW_ABANDON)));
			this.setAllowApproveComment(DataParser.parse(Integer.class, map.get(ProcessDefinitionVOMeta.ALLOW_APPROVE_COMMENT)));
			this.setName(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.TENANT_ID)));
			this.setAllowDraftingComment(DataParser.parse(Integer.class, map.get(ProcessDefinitionVOMeta.ALLOW_DRAFTING_COMMENT)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.DELETE_BY)));
			this.setIconFilePc(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.ICON_FILE_PC)));
			// others
			this.setFormDefinitionCode(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.FORM_DEFINITION_CODE)));
			this.setSearchField(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.REQUEST_ACTION)));
			this.setCatalog(DataParser.parse(Catalog.class, map.get(ProcessDefinitionVOMeta.CATALOG)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(ProcessDefinitionVOMeta.PAGE_SIZE)));
			this.setFormDefinition(DataParser.parse(FormDefinition.class, map.get(ProcessDefinitionVOMeta.FORM_DEFINITION)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(ProcessDefinitionVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.SORT_TYPE)));
			this.setDefinitionFile(DataParser.parse(ProcessDefinitionFile.class, map.get(ProcessDefinitionVOMeta.DEFINITION_FILE)));
			this.setSortField(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.SORT_FIELD)));
			this.setLastUpdateUser(DataParser.parse(User.class, map.get(ProcessDefinitionVOMeta.LAST_UPDATE_USER)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(ProcessDefinitionVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setAssigneeTypeRange( (String)map.get(ProcessDefinitionVOMeta.ASSIGNEE_TYPE_RANGE));
				this.setCode( (String)map.get(ProcessDefinitionVOMeta.CODE));
				this.setNotes( (String)map.get(ProcessDefinitionVOMeta.NOTES));
				this.setAllowSkip( (Integer)map.get(ProcessDefinitionVOMeta.ALLOW_SKIP));
				this.setCamundaDefinitionId( (String)map.get(ProcessDefinitionVOMeta.CAMUNDA_DEFINITION_ID));
				this.setIconFileMobile( (String)map.get(ProcessDefinitionVOMeta.ICON_FILE_MOBILE));
				this.setAllowFetchBack( (Integer)map.get(ProcessDefinitionVOMeta.ALLOW_FETCH_BACK));
				this.setValid( (Integer)map.get(ProcessDefinitionVOMeta.VALID));
				this.setAllowReject( (Integer)map.get(ProcessDefinitionVOMeta.ALLOW_REJECT));
				this.setCatalogId( (String)map.get(ProcessDefinitionVOMeta.CATALOG_ID));
				this.setAllowApproveAttachment( (Integer)map.get(ProcessDefinitionVOMeta.ALLOW_APPROVE_ATTACHMENT));
				this.setUpdateBy( (String)map.get(ProcessDefinitionVOMeta.UPDATE_BY));
				this.setFormDefinitionId( (String)map.get(ProcessDefinitionVOMeta.FORM_DEFINITION_ID));
				this.setId( (String)map.get(ProcessDefinitionVOMeta.ID));
				this.setAllowDraftingAttachment( (Integer)map.get(ProcessDefinitionVOMeta.ALLOW_DRAFTING_ATTACHMENT));
				this.setRejectOption( (String)map.get(ProcessDefinitionVOMeta.REJECT_OPTION));
				this.setCamundaDefinitionKey( (String)map.get(ProcessDefinitionVOMeta.CAMUNDA_DEFINITION_KEY));
				this.setDrafterRange( (String)map.get(ProcessDefinitionVOMeta.DRAFTER_RANGE));
				this.setUpdateTime( (Date)map.get(ProcessDefinitionVOMeta.UPDATE_TIME));
				this.setSort( (Integer)map.get(ProcessDefinitionVOMeta.SORT));
				this.setVersion( (Integer)map.get(ProcessDefinitionVOMeta.VERSION));
				this.setAllowAgreeWithCondition( (Integer)map.get(ProcessDefinitionVOMeta.ALLOW_AGREE_WITH_CONDITION));
				this.setCreateBy( (String)map.get(ProcessDefinitionVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ProcessDefinitionVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(ProcessDefinitionVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(ProcessDefinitionVOMeta.DELETE_TIME));
				this.setAllowAbandon( (Integer)map.get(ProcessDefinitionVOMeta.ALLOW_ABANDON));
				this.setAllowApproveComment( (Integer)map.get(ProcessDefinitionVOMeta.ALLOW_APPROVE_COMMENT));
				this.setName( (String)map.get(ProcessDefinitionVOMeta.NAME));
				this.setTenantId( (String)map.get(ProcessDefinitionVOMeta.TENANT_ID));
				this.setAllowDraftingComment( (Integer)map.get(ProcessDefinitionVOMeta.ALLOW_DRAFTING_COMMENT));
				this.setDeleteBy( (String)map.get(ProcessDefinitionVOMeta.DELETE_BY));
				this.setIconFilePc( (String)map.get(ProcessDefinitionVOMeta.ICON_FILE_PC));
				// others
				this.setFormDefinitionCode( (String)map.get(ProcessDefinitionVOMeta.FORM_DEFINITION_CODE));
				this.setSearchField( (String)map.get(ProcessDefinitionVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(ProcessDefinitionVOMeta.REQUEST_ACTION));
				this.setCatalog( (Catalog)map.get(ProcessDefinitionVOMeta.CATALOG));
				this.setFuzzyField( (String)map.get(ProcessDefinitionVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(ProcessDefinitionVOMeta.PAGE_SIZE));
				this.setFormDefinition( (FormDefinition)map.get(ProcessDefinitionVOMeta.FORM_DEFINITION));
				this.setPageIndex( (Integer)map.get(ProcessDefinitionVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(ProcessDefinitionVOMeta.SORT_TYPE));
				this.setDefinitionFile( (ProcessDefinitionFile)map.get(ProcessDefinitionVOMeta.DEFINITION_FILE));
				this.setSortField( (String)map.get(ProcessDefinitionVOMeta.SORT_FIELD));
				this.setLastUpdateUser( (User)map.get(ProcessDefinitionVOMeta.LAST_UPDATE_USER));
				this.setDataOrigin( (String)map.get(ProcessDefinitionVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(ProcessDefinitionVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(ProcessDefinitionVOMeta.SEARCH_VALUE));
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
			this.setAssigneeTypeRange(DataParser.parse(String.class, r.getValue(ProcessDefinitionVOMeta.ASSIGNEE_TYPE_RANGE)));
			this.setCode(DataParser.parse(String.class, r.getValue(ProcessDefinitionVOMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(ProcessDefinitionVOMeta.NOTES)));
			this.setAllowSkip(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionVOMeta.ALLOW_SKIP)));
			this.setCamundaDefinitionId(DataParser.parse(String.class, r.getValue(ProcessDefinitionVOMeta.CAMUNDA_DEFINITION_ID)));
			this.setIconFileMobile(DataParser.parse(String.class, r.getValue(ProcessDefinitionVOMeta.ICON_FILE_MOBILE)));
			this.setAllowFetchBack(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionVOMeta.ALLOW_FETCH_BACK)));
			this.setValid(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionVOMeta.VALID)));
			this.setAllowReject(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionVOMeta.ALLOW_REJECT)));
			this.setCatalogId(DataParser.parse(String.class, r.getValue(ProcessDefinitionVOMeta.CATALOG_ID)));
			this.setAllowApproveAttachment(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionVOMeta.ALLOW_APPROVE_ATTACHMENT)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ProcessDefinitionVOMeta.UPDATE_BY)));
			this.setFormDefinitionId(DataParser.parse(String.class, r.getValue(ProcessDefinitionVOMeta.FORM_DEFINITION_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(ProcessDefinitionVOMeta.ID)));
			this.setAllowDraftingAttachment(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionVOMeta.ALLOW_DRAFTING_ATTACHMENT)));
			this.setRejectOption(DataParser.parse(String.class, r.getValue(ProcessDefinitionVOMeta.REJECT_OPTION)));
			this.setCamundaDefinitionKey(DataParser.parse(String.class, r.getValue(ProcessDefinitionVOMeta.CAMUNDA_DEFINITION_KEY)));
			this.setDrafterRange(DataParser.parse(String.class, r.getValue(ProcessDefinitionVOMeta.DRAFTER_RANGE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ProcessDefinitionVOMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionVOMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionVOMeta.VERSION)));
			this.setAllowAgreeWithCondition(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionVOMeta.ALLOW_AGREE_WITH_CONDITION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ProcessDefinitionVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ProcessDefinitionVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ProcessDefinitionVOMeta.DELETE_TIME)));
			this.setAllowAbandon(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionVOMeta.ALLOW_ABANDON)));
			this.setAllowApproveComment(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionVOMeta.ALLOW_APPROVE_COMMENT)));
			this.setName(DataParser.parse(String.class, r.getValue(ProcessDefinitionVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ProcessDefinitionVOMeta.TENANT_ID)));
			this.setAllowDraftingComment(DataParser.parse(Integer.class, r.getValue(ProcessDefinitionVOMeta.ALLOW_DRAFTING_COMMENT)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ProcessDefinitionVOMeta.DELETE_BY)));
			this.setIconFilePc(DataParser.parse(String.class, r.getValue(ProcessDefinitionVOMeta.ICON_FILE_PC)));
			return true;
		} else {
			try {
				this.setAssigneeTypeRange( (String)r.getValue(ProcessDefinitionVOMeta.ASSIGNEE_TYPE_RANGE));
				this.setCode( (String)r.getValue(ProcessDefinitionVOMeta.CODE));
				this.setNotes( (String)r.getValue(ProcessDefinitionVOMeta.NOTES));
				this.setAllowSkip( (Integer)r.getValue(ProcessDefinitionVOMeta.ALLOW_SKIP));
				this.setCamundaDefinitionId( (String)r.getValue(ProcessDefinitionVOMeta.CAMUNDA_DEFINITION_ID));
				this.setIconFileMobile( (String)r.getValue(ProcessDefinitionVOMeta.ICON_FILE_MOBILE));
				this.setAllowFetchBack( (Integer)r.getValue(ProcessDefinitionVOMeta.ALLOW_FETCH_BACK));
				this.setValid( (Integer)r.getValue(ProcessDefinitionVOMeta.VALID));
				this.setAllowReject( (Integer)r.getValue(ProcessDefinitionVOMeta.ALLOW_REJECT));
				this.setCatalogId( (String)r.getValue(ProcessDefinitionVOMeta.CATALOG_ID));
				this.setAllowApproveAttachment( (Integer)r.getValue(ProcessDefinitionVOMeta.ALLOW_APPROVE_ATTACHMENT));
				this.setUpdateBy( (String)r.getValue(ProcessDefinitionVOMeta.UPDATE_BY));
				this.setFormDefinitionId( (String)r.getValue(ProcessDefinitionVOMeta.FORM_DEFINITION_ID));
				this.setId( (String)r.getValue(ProcessDefinitionVOMeta.ID));
				this.setAllowDraftingAttachment( (Integer)r.getValue(ProcessDefinitionVOMeta.ALLOW_DRAFTING_ATTACHMENT));
				this.setRejectOption( (String)r.getValue(ProcessDefinitionVOMeta.REJECT_OPTION));
				this.setCamundaDefinitionKey( (String)r.getValue(ProcessDefinitionVOMeta.CAMUNDA_DEFINITION_KEY));
				this.setDrafterRange( (String)r.getValue(ProcessDefinitionVOMeta.DRAFTER_RANGE));
				this.setUpdateTime( (Date)r.getValue(ProcessDefinitionVOMeta.UPDATE_TIME));
				this.setSort( (Integer)r.getValue(ProcessDefinitionVOMeta.SORT));
				this.setVersion( (Integer)r.getValue(ProcessDefinitionVOMeta.VERSION));
				this.setAllowAgreeWithCondition( (Integer)r.getValue(ProcessDefinitionVOMeta.ALLOW_AGREE_WITH_CONDITION));
				this.setCreateBy( (String)r.getValue(ProcessDefinitionVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ProcessDefinitionVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ProcessDefinitionVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(ProcessDefinitionVOMeta.DELETE_TIME));
				this.setAllowAbandon( (Integer)r.getValue(ProcessDefinitionVOMeta.ALLOW_ABANDON));
				this.setAllowApproveComment( (Integer)r.getValue(ProcessDefinitionVOMeta.ALLOW_APPROVE_COMMENT));
				this.setName( (String)r.getValue(ProcessDefinitionVOMeta.NAME));
				this.setTenantId( (String)r.getValue(ProcessDefinitionVOMeta.TENANT_ID));
				this.setAllowDraftingComment( (Integer)r.getValue(ProcessDefinitionVOMeta.ALLOW_DRAFTING_COMMENT));
				this.setDeleteBy( (String)r.getValue(ProcessDefinitionVOMeta.DELETE_BY));
				this.setIconFilePc( (String)r.getValue(ProcessDefinitionVOMeta.ICON_FILE_PC));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}