package org.github.foxnic.web.domain.system;

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
import org.github.foxnic.web.domain.system.meta.CodeExampleCarVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Position;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 代码生成拥有的车辆VO类型
 * <p>代码生成拥有的车辆 , 数据表 sys_code_example_car 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-05-18 16:40:48
 * @sign A47CDCD41BB935EC3ED73C6DEADBAC16
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "代码生成拥有的车辆VO类型 ; 代码生成拥有的车辆 , 数据表 sys_code_example_car 的通用VO类型" , parent = CodeExampleCar.class)
public class CodeExampleCarVO extends CodeExampleCar {

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
	public CodeExampleCarVO setPageIndex(Integer pageIndex) {
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
	public CodeExampleCarVO setPageSize(Integer pageSize) {
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
	public CodeExampleCarVO setSearchField(String searchField) {
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
	public CodeExampleCarVO setFuzzyField(String fuzzyField) {
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
	public CodeExampleCarVO setSearchValue(String searchValue) {
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
	public CodeExampleCarVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public CodeExampleCarVO addDirtyField(String... dirtyField) {
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
	public CodeExampleCarVO setSortField(String sortField) {
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
	public CodeExampleCarVO setSortType(String sortType) {
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
	public CodeExampleCarVO setDataOrigin(String dataOrigin) {
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
	public CodeExampleCarVO setQueryLogic(String queryLogic) {
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
	public CodeExampleCarVO setRequestAction(String requestAction) {
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
	public CodeExampleCarVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public CodeExampleCarVO addId(String... id) {
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
	 * @return CodeExampleCarVO , 转换好的 CodeExampleCarVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CodeExampleCarVO , 转换好的 PoJo 对象
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
	public CodeExampleCarVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CodeExampleCarVO duplicate(boolean all) {
		org.github.foxnic.web.domain.system.meta.CodeExampleCarVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.system.meta.CodeExampleCarVOMeta.$$proxy$$();
		inst.setEmpId(this.getEmpId());
		inst.setPositionIds(this.getPositionIds());
		inst.setSelectEmpId(this.getSelectEmpId());
		inst.setExampleId(this.getExampleId());
		inst.setColor(this.getColor());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setPlateNumber(this.getPlateNumber());
		inst.setVersion(this.getVersion());
		inst.setOrgId(this.getOrgId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPositionId(this.getPositionId());
		inst.setOrgIds(this.getOrgIds());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setSubOrgId(this.getSubOrgId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setComId(this.getComId());
		inst.setDeptIds(this.getDeptIds());
		inst.setEmpIds(this.getEmpIds());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setEmployee(this.getEmployee());
			inst.setSubOrganization(this.getSubOrganization());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setOrganization(this.getOrganization());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setCompany(this.getCompany());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setPosition(this.getPosition());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CodeExampleCarVO clone(boolean deep) {
		return EntityContext.clone(CodeExampleCarVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CodeExampleCarVO
	 * @param codeExampleCarMap 包含实体信息的 Map 对象
	 * @return CodeExampleCarVO , 转换好的的 CodeExampleCar 对象
	*/
	@Transient
	public static CodeExampleCarVO createFrom(Map<String,Object> codeExampleCarMap) {
		if(codeExampleCarMap==null) return null;
		CodeExampleCarVO vo = create();
		EntityContext.copyProperties(vo,codeExampleCarMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 CodeExampleCarVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CodeExampleCarVO , 转换好的的 CodeExampleCar 对象
	*/
	@Transient
	public static CodeExampleCarVO createFrom(Object pojo) {
		if(pojo==null) return null;
		CodeExampleCarVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 CodeExampleCarVO，等同于 new
	 * @return CodeExampleCarVO 对象
	*/
	@Transient
	public static CodeExampleCarVO create() {
		return new org.github.foxnic.web.domain.system.meta.CodeExampleCarVOMeta.$$proxy$$();
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
			this.setEmpId(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.EMP_ID)));
			this.setPositionIds(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.POSITION_IDS)));
			this.setSelectEmpId(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.SELECT_EMP_ID)));
			this.setExampleId(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.EXAMPLE_ID)));
			this.setColor(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.COLOR)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CodeExampleCarVOMeta.UPDATE_TIME)));
			this.setPlateNumber(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.PLATE_NUMBER)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CodeExampleCarVOMeta.VERSION)));
			this.setOrgId(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.ORG_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CodeExampleCarVOMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.POSITION_ID)));
			this.setOrgIds(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.ORG_IDS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CodeExampleCarVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CodeExampleCarVOMeta.DELETE_TIME)));
			this.setSubOrgId(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.SUB_ORG_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.ID)));
			this.setComId(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.COM_ID)));
			this.setDeptIds(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.DEPT_IDS)));
			this.setEmpIds(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.EMP_IDS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(CodeExampleCarVOMeta.PAGE_SIZE)));
			this.setEmployee(DataParser.parse(Employee.class, map.get(CodeExampleCarVOMeta.EMPLOYEE)));
			this.setSubOrganization(DataParser.parse(Organization.class, map.get(CodeExampleCarVOMeta.SUB_ORGANIZATION)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(CodeExampleCarVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.SORT_TYPE)));
			this.setOrganization(DataParser.parse(Organization.class, map.get(CodeExampleCarVOMeta.ORGANIZATION)));
			this.setSortField(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.DATA_ORIGIN)));
			this.setCompany(DataParser.parse(Organization.class, map.get(CodeExampleCarVOMeta.COMPANY)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.QUERY_LOGIC)));
			this.setPosition(DataParser.parse(Position.class, map.get(CodeExampleCarVOMeta.POSITION)));
			this.setSearchValue(DataParser.parse(String.class, map.get(CodeExampleCarVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setEmpId( (String)map.get(CodeExampleCarVOMeta.EMP_ID));
				this.setPositionIds( (String)map.get(CodeExampleCarVOMeta.POSITION_IDS));
				this.setSelectEmpId( (String)map.get(CodeExampleCarVOMeta.SELECT_EMP_ID));
				this.setExampleId( (String)map.get(CodeExampleCarVOMeta.EXAMPLE_ID));
				this.setColor( (String)map.get(CodeExampleCarVOMeta.COLOR));
				this.setUpdateTime( (Date)map.get(CodeExampleCarVOMeta.UPDATE_TIME));
				this.setPlateNumber( (String)map.get(CodeExampleCarVOMeta.PLATE_NUMBER));
				this.setVersion( (Integer)map.get(CodeExampleCarVOMeta.VERSION));
				this.setOrgId( (String)map.get(CodeExampleCarVOMeta.ORG_ID));
				this.setCreateBy( (String)map.get(CodeExampleCarVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(CodeExampleCarVOMeta.DELETED));
				this.setPositionId( (String)map.get(CodeExampleCarVOMeta.POSITION_ID));
				this.setOrgIds( (String)map.get(CodeExampleCarVOMeta.ORG_IDS));
				this.setCreateTime( (Date)map.get(CodeExampleCarVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CodeExampleCarVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CodeExampleCarVOMeta.DELETE_TIME));
				this.setSubOrgId( (String)map.get(CodeExampleCarVOMeta.SUB_ORG_ID));
				this.setDeleteBy( (String)map.get(CodeExampleCarVOMeta.DELETE_BY));
				this.setId( (String)map.get(CodeExampleCarVOMeta.ID));
				this.setComId( (String)map.get(CodeExampleCarVOMeta.COM_ID));
				this.setDeptIds( (String)map.get(CodeExampleCarVOMeta.DEPT_IDS));
				this.setEmpIds( (String)map.get(CodeExampleCarVOMeta.EMP_IDS));
				// others
				this.setSearchField( (String)map.get(CodeExampleCarVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(CodeExampleCarVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(CodeExampleCarVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(CodeExampleCarVOMeta.PAGE_SIZE));
				this.setEmployee( (Employee)map.get(CodeExampleCarVOMeta.EMPLOYEE));
				this.setSubOrganization( (Organization)map.get(CodeExampleCarVOMeta.SUB_ORGANIZATION));
				this.setPageIndex( (Integer)map.get(CodeExampleCarVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(CodeExampleCarVOMeta.SORT_TYPE));
				this.setOrganization( (Organization)map.get(CodeExampleCarVOMeta.ORGANIZATION));
				this.setSortField( (String)map.get(CodeExampleCarVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(CodeExampleCarVOMeta.DATA_ORIGIN));
				this.setCompany( (Organization)map.get(CodeExampleCarVOMeta.COMPANY));
				this.setQueryLogic( (String)map.get(CodeExampleCarVOMeta.QUERY_LOGIC));
				this.setPosition( (Position)map.get(CodeExampleCarVOMeta.POSITION));
				this.setSearchValue( (String)map.get(CodeExampleCarVOMeta.SEARCH_VALUE));
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
			this.setEmpId(DataParser.parse(String.class, r.getValue(CodeExampleCarVOMeta.EMP_ID)));
			this.setPositionIds(DataParser.parse(String.class, r.getValue(CodeExampleCarVOMeta.POSITION_IDS)));
			this.setSelectEmpId(DataParser.parse(String.class, r.getValue(CodeExampleCarVOMeta.SELECT_EMP_ID)));
			this.setExampleId(DataParser.parse(String.class, r.getValue(CodeExampleCarVOMeta.EXAMPLE_ID)));
			this.setColor(DataParser.parse(String.class, r.getValue(CodeExampleCarVOMeta.COLOR)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CodeExampleCarVOMeta.UPDATE_TIME)));
			this.setPlateNumber(DataParser.parse(String.class, r.getValue(CodeExampleCarVOMeta.PLATE_NUMBER)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CodeExampleCarVOMeta.VERSION)));
			this.setOrgId(DataParser.parse(String.class, r.getValue(CodeExampleCarVOMeta.ORG_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CodeExampleCarVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CodeExampleCarVOMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, r.getValue(CodeExampleCarVOMeta.POSITION_ID)));
			this.setOrgIds(DataParser.parse(String.class, r.getValue(CodeExampleCarVOMeta.ORG_IDS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CodeExampleCarVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CodeExampleCarVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CodeExampleCarVOMeta.DELETE_TIME)));
			this.setSubOrgId(DataParser.parse(String.class, r.getValue(CodeExampleCarVOMeta.SUB_ORG_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CodeExampleCarVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(CodeExampleCarVOMeta.ID)));
			this.setComId(DataParser.parse(String.class, r.getValue(CodeExampleCarVOMeta.COM_ID)));
			this.setDeptIds(DataParser.parse(String.class, r.getValue(CodeExampleCarVOMeta.DEPT_IDS)));
			this.setEmpIds(DataParser.parse(String.class, r.getValue(CodeExampleCarVOMeta.EMP_IDS)));
			return true;
		} else {
			try {
				this.setEmpId( (String)r.getValue(CodeExampleCarVOMeta.EMP_ID));
				this.setPositionIds( (String)r.getValue(CodeExampleCarVOMeta.POSITION_IDS));
				this.setSelectEmpId( (String)r.getValue(CodeExampleCarVOMeta.SELECT_EMP_ID));
				this.setExampleId( (String)r.getValue(CodeExampleCarVOMeta.EXAMPLE_ID));
				this.setColor( (String)r.getValue(CodeExampleCarVOMeta.COLOR));
				this.setUpdateTime( (Date)r.getValue(CodeExampleCarVOMeta.UPDATE_TIME));
				this.setPlateNumber( (String)r.getValue(CodeExampleCarVOMeta.PLATE_NUMBER));
				this.setVersion( (Integer)r.getValue(CodeExampleCarVOMeta.VERSION));
				this.setOrgId( (String)r.getValue(CodeExampleCarVOMeta.ORG_ID));
				this.setCreateBy( (String)r.getValue(CodeExampleCarVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(CodeExampleCarVOMeta.DELETED));
				this.setPositionId( (String)r.getValue(CodeExampleCarVOMeta.POSITION_ID));
				this.setOrgIds( (String)r.getValue(CodeExampleCarVOMeta.ORG_IDS));
				this.setCreateTime( (Date)r.getValue(CodeExampleCarVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CodeExampleCarVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CodeExampleCarVOMeta.DELETE_TIME));
				this.setSubOrgId( (String)r.getValue(CodeExampleCarVOMeta.SUB_ORG_ID));
				this.setDeleteBy( (String)r.getValue(CodeExampleCarVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(CodeExampleCarVOMeta.ID));
				this.setComId( (String)r.getValue(CodeExampleCarVOMeta.COM_ID));
				this.setDeptIds( (String)r.getValue(CodeExampleCarVOMeta.DEPT_IDS));
				this.setEmpIds( (String)r.getValue(CodeExampleCarVOMeta.EMP_IDS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}