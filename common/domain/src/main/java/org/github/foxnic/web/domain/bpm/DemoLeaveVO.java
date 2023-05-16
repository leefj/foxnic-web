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
import org.github.foxnic.web.domain.bpm.meta.DemoLeaveVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 请假流程示例VO类型
 * <p>请假流程示例 , 数据表 bpm_demo_leave 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-05-16 11:38:39
 * @sign 8DB5C927B04C1ECC2DA296C94284B08D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "请假流程示例VO类型 ; 请假流程示例 , 数据表 bpm_demo_leave 的通用VO类型" , parent = DemoLeave.class)
public class DemoLeaveVO extends DemoLeave {

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
	public DemoLeaveVO setPageIndex(Integer pageIndex) {
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
	public DemoLeaveVO setPageSize(Integer pageSize) {
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
	public DemoLeaveVO setSearchField(String searchField) {
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
	public DemoLeaveVO setFuzzyField(String fuzzyField) {
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
	public DemoLeaveVO setSearchValue(String searchValue) {
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
	public DemoLeaveVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public DemoLeaveVO addDirtyField(String... dirtyField) {
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
	public DemoLeaveVO setSortField(String sortField) {
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
	public DemoLeaveVO setSortType(String sortType) {
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
	public DemoLeaveVO setDataOrigin(String dataOrigin) {
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
	public DemoLeaveVO setQueryLogic(String queryLogic) {
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
	public DemoLeaveVO setRequestAction(String requestAction) {
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
	public DemoLeaveVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public DemoLeaveVO addId(String... id) {
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
	 * @return DemoLeaveVO , 转换好的 DemoLeaveVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DemoLeaveVO , 转换好的 PoJo 对象
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
	public DemoLeaveVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DemoLeaveVO duplicate(boolean all) {
		org.github.foxnic.web.domain.bpm.meta.DemoLeaveVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.bpm.meta.DemoLeaveVOMeta.$$proxy$$();
		inst.setReason(this.getReason());
		inst.setId(this.getId());
		inst.setBeginTime(this.getBeginTime());
		inst.setEndTime(this.getEndTime());
		inst.setType(this.getType());
		inst.setApplicantId(this.getApplicantId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setHistoricProcessList(this.getHistoricProcessList());
			inst.setCurrentProcessList(this.getCurrentProcessList());
			inst.setDefaultProcess(this.getDefaultProcess());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
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
	public DemoLeaveVO clone(boolean deep) {
		return EntityContext.clone(DemoLeaveVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DemoLeaveVO
	 * @param demoLeaveMap 包含实体信息的 Map 对象
	 * @return DemoLeaveVO , 转换好的的 DemoLeave 对象
	*/
	@Transient
	public static DemoLeaveVO createFrom(Map<String,Object> demoLeaveMap) {
		if(demoLeaveMap==null) return null;
		DemoLeaveVO vo = create();
		EntityContext.copyProperties(vo,demoLeaveMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 DemoLeaveVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DemoLeaveVO , 转换好的的 DemoLeave 对象
	*/
	@Transient
	public static DemoLeaveVO createFrom(Object pojo) {
		if(pojo==null) return null;
		DemoLeaveVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 DemoLeaveVO，等同于 new
	 * @return DemoLeaveVO 对象
	*/
	@Transient
	public static DemoLeaveVO create() {
		return new org.github.foxnic.web.domain.bpm.meta.DemoLeaveVOMeta.$$proxy$$();
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
			this.setReason(DataParser.parse(String.class, map.get(DemoLeaveVOMeta.REASON)));
			this.setId(DataParser.parse(String.class, map.get(DemoLeaveVOMeta.ID)));
			this.setBeginTime(DataParser.parse(Date.class, map.get(DemoLeaveVOMeta.BEGIN_TIME)));
			this.setEndTime(DataParser.parse(Date.class, map.get(DemoLeaveVOMeta.END_TIME)));
			this.setType(DataParser.parse(String.class, map.get(DemoLeaveVOMeta.TYPE)));
			this.setApplicantId(DataParser.parse(String.class, map.get(DemoLeaveVOMeta.APPLICANT_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(DemoLeaveVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(DemoLeaveVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(DemoLeaveVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(DemoLeaveVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(DemoLeaveVOMeta.PAGE_SIZE)));
			this.setDefaultProcess(DataParser.parse(ProcessInstance.class, map.get(DemoLeaveVOMeta.DEFAULT_PROCESS)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(DemoLeaveVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(DemoLeaveVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(DemoLeaveVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(DemoLeaveVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(DemoLeaveVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(DemoLeaveVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setReason( (String)map.get(DemoLeaveVOMeta.REASON));
				this.setId( (String)map.get(DemoLeaveVOMeta.ID));
				this.setBeginTime( (Date)map.get(DemoLeaveVOMeta.BEGIN_TIME));
				this.setEndTime( (Date)map.get(DemoLeaveVOMeta.END_TIME));
				this.setType( (String)map.get(DemoLeaveVOMeta.TYPE));
				this.setApplicantId( (String)map.get(DemoLeaveVOMeta.APPLICANT_ID));
				this.setStatus( (String)map.get(DemoLeaveVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(DemoLeaveVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(DemoLeaveVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(DemoLeaveVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(DemoLeaveVOMeta.PAGE_SIZE));
				this.setDefaultProcess( (ProcessInstance)map.get(DemoLeaveVOMeta.DEFAULT_PROCESS));
				this.setPageIndex( (Integer)map.get(DemoLeaveVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(DemoLeaveVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(DemoLeaveVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(DemoLeaveVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(DemoLeaveVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(DemoLeaveVOMeta.SEARCH_VALUE));
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
			this.setReason(DataParser.parse(String.class, r.getValue(DemoLeaveVOMeta.REASON)));
			this.setId(DataParser.parse(String.class, r.getValue(DemoLeaveVOMeta.ID)));
			this.setBeginTime(DataParser.parse(Date.class, r.getValue(DemoLeaveVOMeta.BEGIN_TIME)));
			this.setEndTime(DataParser.parse(Date.class, r.getValue(DemoLeaveVOMeta.END_TIME)));
			this.setType(DataParser.parse(String.class, r.getValue(DemoLeaveVOMeta.TYPE)));
			this.setApplicantId(DataParser.parse(String.class, r.getValue(DemoLeaveVOMeta.APPLICANT_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(DemoLeaveVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setReason( (String)r.getValue(DemoLeaveVOMeta.REASON));
				this.setId( (String)r.getValue(DemoLeaveVOMeta.ID));
				this.setBeginTime( (Date)r.getValue(DemoLeaveVOMeta.BEGIN_TIME));
				this.setEndTime( (Date)r.getValue(DemoLeaveVOMeta.END_TIME));
				this.setType( (String)r.getValue(DemoLeaveVOMeta.TYPE));
				this.setApplicantId( (String)r.getValue(DemoLeaveVOMeta.APPLICANT_ID));
				this.setStatus( (String)r.getValue(DemoLeaveVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}