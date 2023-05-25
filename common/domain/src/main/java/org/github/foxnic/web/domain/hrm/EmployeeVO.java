package org.github.foxnic.web.domain.hrm;

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
import org.github.foxnic.web.domain.hrm.meta.EmployeeVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 员工VO类型
 * <p>员工 , 数据表 hrm_employee 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-05-25 13:54:38
 * @sign BA9BEE8F3845A306E7D3EE965A8DA70A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "员工VO类型 ; 员工 , 数据表 hrm_employee 的通用VO类型" , parent = Employee.class)
public class EmployeeVO extends Employee {

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
	 * 所属组织ID
	*/
	@ApiModelProperty(required = false,value="所属组织ID" , notes = "")
	private String orgId;
	
	/**
	 * 岗位ID
	*/
	@ApiModelProperty(required = false,value="岗位ID" , notes = "")
	private String positionId;
	
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
	public EmployeeVO setPageIndex(Integer pageIndex) {
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
	public EmployeeVO setPageSize(Integer pageSize) {
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
	public EmployeeVO setSearchField(String searchField) {
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
	public EmployeeVO setFuzzyField(String fuzzyField) {
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
	public EmployeeVO setSearchValue(String searchValue) {
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
	public EmployeeVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public EmployeeVO addDirtyField(String... dirtyField) {
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
	public EmployeeVO setSortField(String sortField) {
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
	public EmployeeVO setSortType(String sortType) {
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
	public EmployeeVO setDataOrigin(String dataOrigin) {
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
	public EmployeeVO setQueryLogic(String queryLogic) {
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
	public EmployeeVO setRequestAction(String requestAction) {
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
	public EmployeeVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public EmployeeVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
		return this;
	}
	
	/**
	 * 获得 所属组织ID<br>
	 * @return 所属组织ID
	*/
	public String getOrgId() {
		return orgId;
	}
	
	/**
	 * 设置 所属组织ID
	 * @param orgId 所属组织ID
	 * @return 当前对象
	*/
	public EmployeeVO setOrgId(String orgId) {
		this.orgId=orgId;
		return this;
	}
	
	/**
	 * 获得 岗位ID<br>
	 * @return 岗位ID
	*/
	public String getPositionId() {
		return positionId;
	}
	
	/**
	 * 设置 岗位ID
	 * @param positionId 岗位ID
	 * @return 当前对象
	*/
	public EmployeeVO setPositionId(String positionId) {
		this.positionId=positionId;
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
	 * @return EmployeeVO , 转换好的 EmployeeVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return EmployeeVO , 转换好的 PoJo 对象
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
	public EmployeeVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public EmployeeVO duplicate(boolean all) {
		org.github.foxnic.web.domain.hrm.meta.EmployeeVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.hrm.meta.EmployeeVOMeta.$$proxy$$();
		inst.setDirectLeaderId(this.getDirectLeaderId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setBadge(this.getBadge());
		inst.setCompanyId(this.getCompanyId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPhone(this.getPhone());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setVicePositions(this.getVicePositions());
			inst.setSource(this.getSource());
			inst.setOrgId(this.getOrgId());
			inst.setPrimaryPosition(this.getPrimaryPosition());
			inst.setExtInfo(this.getExtInfo());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setIdentity(this.getIdentity());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setCompany(this.getCompany());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setId(this.getId());
			inst.setRequestAction(this.getRequestAction());
			inst.setSex(this.getSex());
			inst.setDirectLeader(this.getDirectLeader());
			inst.setPrimaryPositionId(this.getPrimaryPositionId());
			inst.setPositions(this.getPositions());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setVicePositionIds(this.getVicePositionIds());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setPositionId(this.getPositionId());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setPerson(this.getPerson());
			inst.setNameAndBadge(this.getNameAndBadge());
			inst.setOrganizations(this.getOrganizations());
			inst.setName(this.getName());
			inst.setBusiRoles(this.getBusiRoles());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setIds(this.getIds());
			inst.setPrimaryOrganization(this.getPrimaryOrganization());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public EmployeeVO clone(boolean deep) {
		return EntityContext.clone(EmployeeVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 EmployeeVO
	 * @param employeeMap 包含实体信息的 Map 对象
	 * @return EmployeeVO , 转换好的的 Employee 对象
	*/
	@Transient
	public static EmployeeVO createFrom(Map<String,Object> employeeMap) {
		if(employeeMap==null) return null;
		EmployeeVO vo = create();
		EntityContext.copyProperties(vo,employeeMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 EmployeeVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return EmployeeVO , 转换好的的 Employee 对象
	*/
	@Transient
	public static EmployeeVO createFrom(Object pojo) {
		if(pojo==null) return null;
		EmployeeVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 EmployeeVO，等同于 new
	 * @return EmployeeVO 对象
	*/
	@Transient
	public static EmployeeVO create() {
		return new org.github.foxnic.web.domain.hrm.meta.EmployeeVOMeta.$$proxy$$();
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
			this.setDirectLeaderId(DataParser.parse(String.class, map.get(EmployeeVOMeta.DIRECT_LEADER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(EmployeeVOMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, map.get(EmployeeVOMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(EmployeeVOMeta.VERSION)));
			this.setBadge(DataParser.parse(String.class, map.get(EmployeeVOMeta.BADGE)));
			this.setCompanyId(DataParser.parse(String.class, map.get(EmployeeVOMeta.COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(EmployeeVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(EmployeeVOMeta.DELETED)));
			this.setPhone(DataParser.parse(String.class, map.get(EmployeeVOMeta.PHONE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(EmployeeVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(EmployeeVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(EmployeeVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(EmployeeVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(EmployeeVOMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(EmployeeVOMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, map.get(EmployeeVOMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(EmployeeVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(EmployeeVOMeta.SEARCH_FIELD)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(EmployeeVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(EmployeeVOMeta.PAGE_SIZE)));
			this.setSource(DataParser.parse(String.class, map.get(EmployeeVOMeta.SOURCE)));
			this.setOrgId(DataParser.parse(String.class, map.get(EmployeeVOMeta.ORG_ID)));
			this.setPrimaryPosition(DataParser.parse(Position.class, map.get(EmployeeVOMeta.PRIMARY_POSITION)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(EmployeeVOMeta.UPDATE_BY)));
			this.setIdentity(DataParser.parse(String.class, map.get(EmployeeVOMeta.IDENTITY)));
			this.setSortField(DataParser.parse(String.class, map.get(EmployeeVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(EmployeeVOMeta.DATA_ORIGIN)));
			this.setCompany(DataParser.parse(Company.class, map.get(EmployeeVOMeta.COMPANY)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(EmployeeVOMeta.QUERY_LOGIC)));
			this.setId(DataParser.parse(String.class, map.get(EmployeeVOMeta.ID)));
			this.setRequestAction(DataParser.parse(String.class, map.get(EmployeeVOMeta.REQUEST_ACTION)));
			this.setSex(DataParser.parse(String.class, map.get(EmployeeVOMeta.SEX)));
			this.setDirectLeader(DataParser.parse(Employee.class, map.get(EmployeeVOMeta.DIRECT_LEADER)));
			this.setPrimaryPositionId(DataParser.parse(String.class, map.get(EmployeeVOMeta.PRIMARY_POSITION_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(EmployeeVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(EmployeeVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(EmployeeVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(EmployeeVOMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, map.get(EmployeeVOMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(EmployeeVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(EmployeeVOMeta.DELETE_TIME)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(EmployeeVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(EmployeeVOMeta.SORT_TYPE)));
			this.setPerson(DataParser.parse(Person.class, map.get(EmployeeVOMeta.PERSON)));
			this.setNameAndBadge(DataParser.parse(String.class, map.get(EmployeeVOMeta.NAME_AND_BADGE)));
			this.setName(DataParser.parse(String.class, map.get(EmployeeVOMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(EmployeeVOMeta.DELETE_BY)));
			this.setPrimaryOrganization(DataParser.parse(Organization.class, map.get(EmployeeVOMeta.PRIMARY_ORGANIZATION)));
			this.setSearchValue(DataParser.parse(String.class, map.get(EmployeeVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setDirectLeaderId( (String)map.get(EmployeeVOMeta.DIRECT_LEADER_ID));
				this.setUpdateTime( (Date)map.get(EmployeeVOMeta.UPDATE_TIME));
				this.setType( (String)map.get(EmployeeVOMeta.TYPE));
				this.setVersion( (Integer)map.get(EmployeeVOMeta.VERSION));
				this.setBadge( (String)map.get(EmployeeVOMeta.BADGE));
				this.setCompanyId( (String)map.get(EmployeeVOMeta.COMPANY_ID));
				this.setCreateBy( (String)map.get(EmployeeVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(EmployeeVOMeta.DELETED));
				this.setPhone( (String)map.get(EmployeeVOMeta.PHONE));
				this.setCreateTime( (Date)map.get(EmployeeVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(EmployeeVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(EmployeeVOMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(EmployeeVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(EmployeeVOMeta.DELETE_BY));
				this.setPersonId( (String)map.get(EmployeeVOMeta.PERSON_ID));
				this.setId( (String)map.get(EmployeeVOMeta.ID));
				this.setStatus( (String)map.get(EmployeeVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(EmployeeVOMeta.SEARCH_FIELD));
				this.setFuzzyField( (String)map.get(EmployeeVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(EmployeeVOMeta.PAGE_SIZE));
				this.setSource( (String)map.get(EmployeeVOMeta.SOURCE));
				this.setOrgId( (String)map.get(EmployeeVOMeta.ORG_ID));
				this.setPrimaryPosition( (Position)map.get(EmployeeVOMeta.PRIMARY_POSITION));
				this.setUpdateBy( (String)map.get(EmployeeVOMeta.UPDATE_BY));
				this.setIdentity( (String)map.get(EmployeeVOMeta.IDENTITY));
				this.setSortField( (String)map.get(EmployeeVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(EmployeeVOMeta.DATA_ORIGIN));
				this.setCompany( (Company)map.get(EmployeeVOMeta.COMPANY));
				this.setQueryLogic( (String)map.get(EmployeeVOMeta.QUERY_LOGIC));
				this.setId( (String)map.get(EmployeeVOMeta.ID));
				this.setRequestAction( (String)map.get(EmployeeVOMeta.REQUEST_ACTION));
				this.setSex( (String)map.get(EmployeeVOMeta.SEX));
				this.setDirectLeader( (Employee)map.get(EmployeeVOMeta.DIRECT_LEADER));
				this.setPrimaryPositionId( (String)map.get(EmployeeVOMeta.PRIMARY_POSITION_ID));
				this.setUpdateTime( (Date)map.get(EmployeeVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(EmployeeVOMeta.VERSION));
				this.setCreateBy( (String)map.get(EmployeeVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(EmployeeVOMeta.DELETED));
				this.setPositionId( (String)map.get(EmployeeVOMeta.POSITION_ID));
				this.setCreateTime( (Date)map.get(EmployeeVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(EmployeeVOMeta.DELETE_TIME));
				this.setPageIndex( (Integer)map.get(EmployeeVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(EmployeeVOMeta.SORT_TYPE));
				this.setPerson( (Person)map.get(EmployeeVOMeta.PERSON));
				this.setNameAndBadge( (String)map.get(EmployeeVOMeta.NAME_AND_BADGE));
				this.setName( (String)map.get(EmployeeVOMeta.NAME));
				this.setDeleteBy( (String)map.get(EmployeeVOMeta.DELETE_BY));
				this.setPrimaryOrganization( (Organization)map.get(EmployeeVOMeta.PRIMARY_ORGANIZATION));
				this.setSearchValue( (String)map.get(EmployeeVOMeta.SEARCH_VALUE));
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
			this.setDirectLeaderId(DataParser.parse(String.class, r.getValue(EmployeeVOMeta.DIRECT_LEADER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(EmployeeVOMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, r.getValue(EmployeeVOMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(EmployeeVOMeta.VERSION)));
			this.setBadge(DataParser.parse(String.class, r.getValue(EmployeeVOMeta.BADGE)));
			this.setCompanyId(DataParser.parse(String.class, r.getValue(EmployeeVOMeta.COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(EmployeeVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(EmployeeVOMeta.DELETED)));
			this.setPhone(DataParser.parse(String.class, r.getValue(EmployeeVOMeta.PHONE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(EmployeeVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(EmployeeVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(EmployeeVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(EmployeeVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(EmployeeVOMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(EmployeeVOMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(EmployeeVOMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(EmployeeVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setDirectLeaderId( (String)r.getValue(EmployeeVOMeta.DIRECT_LEADER_ID));
				this.setUpdateTime( (Date)r.getValue(EmployeeVOMeta.UPDATE_TIME));
				this.setType( (String)r.getValue(EmployeeVOMeta.TYPE));
				this.setVersion( (Integer)r.getValue(EmployeeVOMeta.VERSION));
				this.setBadge( (String)r.getValue(EmployeeVOMeta.BADGE));
				this.setCompanyId( (String)r.getValue(EmployeeVOMeta.COMPANY_ID));
				this.setCreateBy( (String)r.getValue(EmployeeVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(EmployeeVOMeta.DELETED));
				this.setPhone( (String)r.getValue(EmployeeVOMeta.PHONE));
				this.setCreateTime( (Date)r.getValue(EmployeeVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(EmployeeVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(EmployeeVOMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(EmployeeVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(EmployeeVOMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(EmployeeVOMeta.PERSON_ID));
				this.setId( (String)r.getValue(EmployeeVOMeta.ID));
				this.setStatus( (String)r.getValue(EmployeeVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}