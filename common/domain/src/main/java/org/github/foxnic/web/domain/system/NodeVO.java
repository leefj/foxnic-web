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
import org.github.foxnic.web.domain.system.meta.NodeVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 系统节点VO类型
 * <p>系统节点 , 数据表 sys_node 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:42:46
 * @sign 0FE3EBCDB1805FB52C3B243E3E1E1193
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "系统节点VO类型 ; 系统节点 , 数据表 sys_node 的通用VO类型" , parent = Node.class)
public class NodeVO extends Node {

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
	public NodeVO setPageIndex(Integer pageIndex) {
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
	public NodeVO setPageSize(Integer pageSize) {
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
	public NodeVO setSearchField(String searchField) {
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
	public NodeVO setFuzzyField(String fuzzyField) {
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
	public NodeVO setSearchValue(String searchValue) {
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
	public NodeVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public NodeVO addDirtyField(String... dirtyField) {
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
	public NodeVO setSortField(String sortField) {
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
	public NodeVO setSortType(String sortType) {
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
	public NodeVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public NodeVO addId(String... id) {
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
	 * @return NodeVO , 转换好的 NodeVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return NodeVO , 转换好的 PoJo 对象
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
	public NodeVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public NodeVO duplicate(boolean all) {
		org.github.foxnic.web.domain.system.meta.NodeVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.system.meta.NodeVOMeta.$$proxy$$();
		inst.setHostName(this.getHostName());
		inst.setWorkerId(this.getWorkerId());
		inst.setIp(this.getIp());
		inst.setDatacenterId(this.getDatacenterId());
		inst.setHostId(this.getHostId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setHeartBeatTime(this.getHeartBeatTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setIsUp(this.getIsUp());
		inst.setPort(this.getPort());
		inst.setProcessId(this.getProcessId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStartTime(this.getStartTime());
		inst.setId(this.getId());
		inst.setApplicationName(this.getApplicationName());
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
	public NodeVO clone(boolean deep) {
		return EntityContext.clone(NodeVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 NodeVO
	 * @param nodeMap 包含实体信息的 Map 对象
	 * @return NodeVO , 转换好的的 Node 对象
	*/
	@Transient
	public static NodeVO createFrom(Map<String,Object> nodeMap) {
		if(nodeMap==null) return null;
		NodeVO vo = create();
		EntityContext.copyProperties(vo,nodeMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 NodeVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return NodeVO , 转换好的的 Node 对象
	*/
	@Transient
	public static NodeVO createFrom(Object pojo) {
		if(pojo==null) return null;
		NodeVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 NodeVO，等同于 new
	 * @return NodeVO 对象
	*/
	@Transient
	public static NodeVO create() {
		return new org.github.foxnic.web.domain.system.meta.NodeVOMeta.$$proxy$$();
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
			this.setHostName(DataParser.parse(String.class, map.get(NodeVOMeta.HOST_NAME)));
			this.setWorkerId(DataParser.parse(Integer.class, map.get(NodeVOMeta.WORKER_ID)));
			this.setIp(DataParser.parse(String.class, map.get(NodeVOMeta.IP)));
			this.setDatacenterId(DataParser.parse(Integer.class, map.get(NodeVOMeta.DATACENTER_ID)));
			this.setHostId(DataParser.parse(String.class, map.get(NodeVOMeta.HOST_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(NodeVOMeta.UPDATE_TIME)));
			this.setHeartBeatTime(DataParser.parse(Date.class, map.get(NodeVOMeta.HEART_BEAT_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(NodeVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(NodeVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(NodeVOMeta.DELETED)));
			this.setIsUp(DataParser.parse(Integer.class, map.get(NodeVOMeta.IS_UP)));
			this.setPort(DataParser.parse(Integer.class, map.get(NodeVOMeta.PORT)));
			this.setProcessId(DataParser.parse(String.class, map.get(NodeVOMeta.PROCESS_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(NodeVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(NodeVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(NodeVOMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(NodeVOMeta.DELETE_BY)));
			this.setStartTime(DataParser.parse(Date.class, map.get(NodeVOMeta.START_TIME)));
			this.setId(DataParser.parse(String.class, map.get(NodeVOMeta.ID)));
			this.setApplicationName(DataParser.parse(String.class, map.get(NodeVOMeta.APPLICATION_NAME)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(NodeVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(NodeVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(NodeVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(NodeVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(NodeVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(NodeVOMeta.PAGE_SIZE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(NodeVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setHostName( (String)map.get(NodeVOMeta.HOST_NAME));
				this.setWorkerId( (Integer)map.get(NodeVOMeta.WORKER_ID));
				this.setIp( (String)map.get(NodeVOMeta.IP));
				this.setDatacenterId( (Integer)map.get(NodeVOMeta.DATACENTER_ID));
				this.setHostId( (String)map.get(NodeVOMeta.HOST_ID));
				this.setUpdateTime( (Date)map.get(NodeVOMeta.UPDATE_TIME));
				this.setHeartBeatTime( (Date)map.get(NodeVOMeta.HEART_BEAT_TIME));
				this.setVersion( (Integer)map.get(NodeVOMeta.VERSION));
				this.setCreateBy( (String)map.get(NodeVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(NodeVOMeta.DELETED));
				this.setIsUp( (Integer)map.get(NodeVOMeta.IS_UP));
				this.setPort( (Integer)map.get(NodeVOMeta.PORT));
				this.setProcessId( (String)map.get(NodeVOMeta.PROCESS_ID));
				this.setCreateTime( (Date)map.get(NodeVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(NodeVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(NodeVOMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(NodeVOMeta.DELETE_BY));
				this.setStartTime( (Date)map.get(NodeVOMeta.START_TIME));
				this.setId( (String)map.get(NodeVOMeta.ID));
				this.setApplicationName( (String)map.get(NodeVOMeta.APPLICATION_NAME));
				// others
				this.setSearchField( (String)map.get(NodeVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(NodeVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(NodeVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(NodeVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(NodeVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(NodeVOMeta.PAGE_SIZE));
				this.setSearchValue( (String)map.get(NodeVOMeta.SEARCH_VALUE));
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
			this.setHostName(DataParser.parse(String.class, r.getValue(NodeVOMeta.HOST_NAME)));
			this.setWorkerId(DataParser.parse(Integer.class, r.getValue(NodeVOMeta.WORKER_ID)));
			this.setIp(DataParser.parse(String.class, r.getValue(NodeVOMeta.IP)));
			this.setDatacenterId(DataParser.parse(Integer.class, r.getValue(NodeVOMeta.DATACENTER_ID)));
			this.setHostId(DataParser.parse(String.class, r.getValue(NodeVOMeta.HOST_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(NodeVOMeta.UPDATE_TIME)));
			this.setHeartBeatTime(DataParser.parse(Date.class, r.getValue(NodeVOMeta.HEART_BEAT_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(NodeVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(NodeVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(NodeVOMeta.DELETED)));
			this.setIsUp(DataParser.parse(Integer.class, r.getValue(NodeVOMeta.IS_UP)));
			this.setPort(DataParser.parse(Integer.class, r.getValue(NodeVOMeta.PORT)));
			this.setProcessId(DataParser.parse(String.class, r.getValue(NodeVOMeta.PROCESS_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(NodeVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(NodeVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(NodeVOMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(NodeVOMeta.DELETE_BY)));
			this.setStartTime(DataParser.parse(Date.class, r.getValue(NodeVOMeta.START_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(NodeVOMeta.ID)));
			this.setApplicationName(DataParser.parse(String.class, r.getValue(NodeVOMeta.APPLICATION_NAME)));
			return true;
		} else {
			try {
				this.setHostName( (String)r.getValue(NodeVOMeta.HOST_NAME));
				this.setWorkerId( (Integer)r.getValue(NodeVOMeta.WORKER_ID));
				this.setIp( (String)r.getValue(NodeVOMeta.IP));
				this.setDatacenterId( (Integer)r.getValue(NodeVOMeta.DATACENTER_ID));
				this.setHostId( (String)r.getValue(NodeVOMeta.HOST_ID));
				this.setUpdateTime( (Date)r.getValue(NodeVOMeta.UPDATE_TIME));
				this.setHeartBeatTime( (Date)r.getValue(NodeVOMeta.HEART_BEAT_TIME));
				this.setVersion( (Integer)r.getValue(NodeVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(NodeVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(NodeVOMeta.DELETED));
				this.setIsUp( (Integer)r.getValue(NodeVOMeta.IS_UP));
				this.setPort( (Integer)r.getValue(NodeVOMeta.PORT));
				this.setProcessId( (String)r.getValue(NodeVOMeta.PROCESS_ID));
				this.setCreateTime( (Date)r.getValue(NodeVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(NodeVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(NodeVOMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(NodeVOMeta.DELETE_BY));
				this.setStartTime( (Date)r.getValue(NodeVOMeta.START_TIME));
				this.setId( (String)r.getValue(NodeVOMeta.ID));
				this.setApplicationName( (String)r.getValue(NodeVOMeta.APPLICATION_NAME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}