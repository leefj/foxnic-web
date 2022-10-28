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
import org.github.foxnic.web.domain.system.meta.SequenceVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 序列VO类型
 * <p>序列 , 数据表 sys_sequence 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:38:51
 * @sign 92A7DFD2CDDC2E381BAD0CD21E42C25E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "序列VO类型 ; 序列 , 数据表 sys_sequence 的通用VO类型" , parent = Sequence.class)
public class SequenceVO extends Sequence {

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
	private List<String> pks;
	
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
	public SequenceVO setPageIndex(Integer pageIndex) {
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
	public SequenceVO setPageSize(Integer pageSize) {
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
	public SequenceVO setSearchField(String searchField) {
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
	public SequenceVO setFuzzyField(String fuzzyField) {
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
	public SequenceVO setSearchValue(String searchValue) {
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
	public SequenceVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public SequenceVO addDirtyField(String... dirtyField) {
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
	public SequenceVO setSortField(String sortField) {
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
	public SequenceVO setSortType(String sortType) {
		this.sortType=sortType;
		return this;
	}
	
	/**
	 * 获得 主键清单<br>
	 * 用于接收批量主键参数
	 * @return 主键清单
	*/
	public List<String> getPks() {
		return pks;
	}
	
	/**
	 * 设置 主键清单
	 * @param pks 主键清单
	 * @return 当前对象
	*/
	public SequenceVO setPks(List<String> pks) {
		this.pks=pks;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param pk 主键清单
	 * @return 当前对象
	*/
	public SequenceVO addPk(String... pk) {
		if(this.pks==null) pks=new ArrayList<>();
		this.pks.addAll(Arrays.asList(pk));
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
	 * @return SequenceVO , 转换好的 SequenceVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SequenceVO , 转换好的 PoJo 对象
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
	public SequenceVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SequenceVO duplicate(boolean all) {
		org.github.foxnic.web.domain.system.meta.SequenceVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.system.meta.SequenceVOMeta.$$proxy$$();
		inst.setFetchSize(this.getFetchSize());
		inst.setCatalog(this.getCatalog());
		inst.setName(this.getName());
		inst.setLength(this.getLength());
		inst.setTenantId(this.getTenantId());
		inst.setMemo(this.getMemo());
		inst.setPk(this.getPk());
		inst.setId(this.getId());
		inst.setType(this.getType());
		inst.setValue(this.getValue());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setPageSize(this.getPageSize());
			inst.setPks(this.getPks());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public SequenceVO clone(boolean deep) {
		return EntityContext.clone(SequenceVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SequenceVO
	 * @param sequenceMap 包含实体信息的 Map 对象
	 * @return SequenceVO , 转换好的的 Sequence 对象
	*/
	@Transient
	public static SequenceVO createFrom(Map<String,Object> sequenceMap) {
		if(sequenceMap==null) return null;
		SequenceVO vo = create();
		EntityContext.copyProperties(vo,sequenceMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 SequenceVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SequenceVO , 转换好的的 Sequence 对象
	*/
	@Transient
	public static SequenceVO createFrom(Object pojo) {
		if(pojo==null) return null;
		SequenceVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 SequenceVO，等同于 new
	 * @return SequenceVO 对象
	*/
	@Transient
	public static SequenceVO create() {
		return new org.github.foxnic.web.domain.system.meta.SequenceVOMeta.$$proxy$$();
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
			this.setFetchSize(DataParser.parse(Integer.class, map.get(SequenceVOMeta.FETCH_SIZE)));
			this.setCatalog(DataParser.parse(String.class, map.get(SequenceVOMeta.CATALOG)));
			this.setName(DataParser.parse(String.class, map.get(SequenceVOMeta.NAME)));
			this.setLength(DataParser.parse(Integer.class, map.get(SequenceVOMeta.LENGTH)));
			this.setTenantId(DataParser.parse(String.class, map.get(SequenceVOMeta.TENANT_ID)));
			this.setMemo(DataParser.parse(String.class, map.get(SequenceVOMeta.MEMO)));
			this.setPk(DataParser.parse(String.class, map.get(SequenceVOMeta.PK)));
			this.setId(DataParser.parse(String.class, map.get(SequenceVOMeta.ID)));
			this.setType(DataParser.parse(String.class, map.get(SequenceVOMeta.TYPE)));
			this.setValue(DataParser.parse(Long.class, map.get(SequenceVOMeta.VALUE)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(SequenceVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(SequenceVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(SequenceVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(SequenceVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(SequenceVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(SequenceVOMeta.PAGE_SIZE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(SequenceVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setFetchSize( (Integer)map.get(SequenceVOMeta.FETCH_SIZE));
				this.setCatalog( (String)map.get(SequenceVOMeta.CATALOG));
				this.setName( (String)map.get(SequenceVOMeta.NAME));
				this.setLength( (Integer)map.get(SequenceVOMeta.LENGTH));
				this.setTenantId( (String)map.get(SequenceVOMeta.TENANT_ID));
				this.setMemo( (String)map.get(SequenceVOMeta.MEMO));
				this.setPk( (String)map.get(SequenceVOMeta.PK));
				this.setId( (String)map.get(SequenceVOMeta.ID));
				this.setType( (String)map.get(SequenceVOMeta.TYPE));
				this.setValue( (Long)map.get(SequenceVOMeta.VALUE));
				// others
				this.setSearchField( (String)map.get(SequenceVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(SequenceVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(SequenceVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(SequenceVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(SequenceVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(SequenceVOMeta.PAGE_SIZE));
				this.setSearchValue( (String)map.get(SequenceVOMeta.SEARCH_VALUE));
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
			this.setFetchSize(DataParser.parse(Integer.class, r.getValue(SequenceVOMeta.FETCH_SIZE)));
			this.setCatalog(DataParser.parse(String.class, r.getValue(SequenceVOMeta.CATALOG)));
			this.setName(DataParser.parse(String.class, r.getValue(SequenceVOMeta.NAME)));
			this.setLength(DataParser.parse(Integer.class, r.getValue(SequenceVOMeta.LENGTH)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SequenceVOMeta.TENANT_ID)));
			this.setMemo(DataParser.parse(String.class, r.getValue(SequenceVOMeta.MEMO)));
			this.setPk(DataParser.parse(String.class, r.getValue(SequenceVOMeta.PK)));
			this.setId(DataParser.parse(String.class, r.getValue(SequenceVOMeta.ID)));
			this.setType(DataParser.parse(String.class, r.getValue(SequenceVOMeta.TYPE)));
			this.setValue(DataParser.parse(Long.class, r.getValue(SequenceVOMeta.VALUE)));
			return true;
		} else {
			try {
				this.setFetchSize( (Integer)r.getValue(SequenceVOMeta.FETCH_SIZE));
				this.setCatalog( (String)r.getValue(SequenceVOMeta.CATALOG));
				this.setName( (String)r.getValue(SequenceVOMeta.NAME));
				this.setLength( (Integer)r.getValue(SequenceVOMeta.LENGTH));
				this.setTenantId( (String)r.getValue(SequenceVOMeta.TENANT_ID));
				this.setMemo( (String)r.getValue(SequenceVOMeta.MEMO));
				this.setPk( (String)r.getValue(SequenceVOMeta.PK));
				this.setId( (String)r.getValue(SequenceVOMeta.ID));
				this.setType( (String)r.getValue(SequenceVOMeta.TYPE));
				this.setValue( (Long)r.getValue(SequenceVOMeta.VALUE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}