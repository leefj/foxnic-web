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
import org.github.foxnic.web.domain.system.meta.LangVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 语言条目VO类型
 * <p>语言条目 , 数据表 sys_lang 的通用VO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-11-03 08:59:17
 * @sign BA40CDF42C01C9095A6649D22DC40B24
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "语言条目VO类型 ; 语言条目 , 数据表 sys_lang 的通用VO类型" , parent = Lang.class)
public class LangVO extends Lang {

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
	private List<String> codes;
	
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
	public LangVO setPageIndex(Integer pageIndex) {
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
	public LangVO setPageSize(Integer pageSize) {
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
	public LangVO setSearchField(String searchField) {
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
	public LangVO setFuzzyField(String fuzzyField) {
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
	public LangVO setSearchValue(String searchValue) {
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
	public LangVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public LangVO addDirtyField(String... dirtyField) {
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
	public LangVO setSortField(String sortField) {
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
	public LangVO setSortType(String sortType) {
		this.sortType=sortType;
		return this;
	}
	
	/**
	 * 获得 主键清单<br>
	 * 用于接收批量主键参数
	 * @return 主键清单
	*/
	public List<String> getCodes() {
		return codes;
	}
	
	/**
	 * 设置 主键清单
	 * @param codes 主键清单
	 * @return 当前对象
	*/
	public LangVO setCodes(List<String> codes) {
		this.codes=codes;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param code 主键清单
	 * @return 当前对象
	*/
	public LangVO addCode(String... code) {
		if(this.codes==null) codes=new ArrayList<>();
		this.codes.addAll(Arrays.asList(code));
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
	 * @return LangVO , 转换好的 LangVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return LangVO , 转换好的 PoJo 对象
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
	public LangVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public LangVO duplicate(boolean all) {
		org.github.foxnic.web.domain.system.meta.LangVOMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.system.meta.LangVOMeta.$$proxy$$();
		inst.setZhCn(this.getZhCn());
		inst.setCode(this.getCode());
		inst.setZhHk(this.getZhHk());
		inst.setZhTw(this.getZhTw());
		inst.setEnUs(this.getEnUs());
		inst.setZhMo(this.getZhMo());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setEnGb(this.getEnGb());
		inst.setJaJp(this.getJaJp());
		inst.setVersion(this.getVersion());
		inst.setValid(this.getValid());
		inst.setConfuse(this.getConfuse());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setDefaults(this.getDefaults());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setContext(this.getContext());
		inst.setKoKr(this.getKoKr());
		inst.setDeleteBy(this.getDeleteBy());
		if(all) {
			inst.setCodes(this.getCodes());
			inst.setSearchField(this.getSearchField());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setPageSize(this.getPageSize());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public LangVO clone(boolean deep) {
		return EntityContext.clone(LangVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 LangVO
	 * @param langMap 包含实体信息的 Map 对象
	 * @return LangVO , 转换好的的 Lang 对象
	*/
	@Transient
	public static LangVO createFrom(Map<String,Object> langMap) {
		if(langMap==null) return null;
		LangVO vo = create();
		EntityContext.copyProperties(vo,langMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 LangVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return LangVO , 转换好的的 Lang 对象
	*/
	@Transient
	public static LangVO createFrom(Object pojo) {
		if(pojo==null) return null;
		LangVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 LangVO，等同于 new
	 * @return LangVO 对象
	*/
	@Transient
	public static LangVO create() {
		return new org.github.foxnic.web.domain.system.meta.LangVOMeta.$$proxy$$();
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
			this.setZhCn(DataParser.parse(String.class, map.get(LangVOMeta.ZH_CN)));
			this.setCode(DataParser.parse(String.class, map.get(LangVOMeta.CODE)));
			this.setZhHk(DataParser.parse(String.class, map.get(LangVOMeta.ZH_HK)));
			this.setZhTw(DataParser.parse(String.class, map.get(LangVOMeta.ZH_TW)));
			this.setEnUs(DataParser.parse(String.class, map.get(LangVOMeta.EN_US)));
			this.setZhMo(DataParser.parse(String.class, map.get(LangVOMeta.ZH_MO)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(LangVOMeta.UPDATE_TIME)));
			this.setEnGb(DataParser.parse(String.class, map.get(LangVOMeta.EN_GB)));
			this.setJaJp(DataParser.parse(String.class, map.get(LangVOMeta.JA_JP)));
			this.setVersion(DataParser.parse(Integer.class, map.get(LangVOMeta.VERSION)));
			this.setValid(DataParser.parse(Integer.class, map.get(LangVOMeta.VALID)));
			this.setConfuse(DataParser.parse(String.class, map.get(LangVOMeta.CONFUSE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(LangVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(LangVOMeta.DELETED)));
			this.setDefaults(DataParser.parse(String.class, map.get(LangVOMeta.DEFAULTS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(LangVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(LangVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(LangVOMeta.DELETE_TIME)));
			this.setContext(DataParser.parse(String.class, map.get(LangVOMeta.CONTEXT)));
			this.setKoKr(DataParser.parse(String.class, map.get(LangVOMeta.KO_KR)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(LangVOMeta.DELETE_BY)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(LangVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(LangVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(LangVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(LangVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(LangVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(LangVOMeta.PAGE_SIZE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(LangVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setZhCn( (String)map.get(LangVOMeta.ZH_CN));
				this.setCode( (String)map.get(LangVOMeta.CODE));
				this.setZhHk( (String)map.get(LangVOMeta.ZH_HK));
				this.setZhTw( (String)map.get(LangVOMeta.ZH_TW));
				this.setEnUs( (String)map.get(LangVOMeta.EN_US));
				this.setZhMo( (String)map.get(LangVOMeta.ZH_MO));
				this.setUpdateTime( (Date)map.get(LangVOMeta.UPDATE_TIME));
				this.setEnGb( (String)map.get(LangVOMeta.EN_GB));
				this.setJaJp( (String)map.get(LangVOMeta.JA_JP));
				this.setVersion( (Integer)map.get(LangVOMeta.VERSION));
				this.setValid( (Integer)map.get(LangVOMeta.VALID));
				this.setConfuse( (String)map.get(LangVOMeta.CONFUSE));
				this.setCreateBy( (String)map.get(LangVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(LangVOMeta.DELETED));
				this.setDefaults( (String)map.get(LangVOMeta.DEFAULTS));
				this.setCreateTime( (Date)map.get(LangVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(LangVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(LangVOMeta.DELETE_TIME));
				this.setContext( (String)map.get(LangVOMeta.CONTEXT));
				this.setKoKr( (String)map.get(LangVOMeta.KO_KR));
				this.setDeleteBy( (String)map.get(LangVOMeta.DELETE_BY));
				// others
				this.setSearchField( (String)map.get(LangVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(LangVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(LangVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(LangVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(LangVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(LangVOMeta.PAGE_SIZE));
				this.setSearchValue( (String)map.get(LangVOMeta.SEARCH_VALUE));
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
			this.setZhCn(DataParser.parse(String.class, r.getValue(LangVOMeta.ZH_CN)));
			this.setCode(DataParser.parse(String.class, r.getValue(LangVOMeta.CODE)));
			this.setZhHk(DataParser.parse(String.class, r.getValue(LangVOMeta.ZH_HK)));
			this.setZhTw(DataParser.parse(String.class, r.getValue(LangVOMeta.ZH_TW)));
			this.setEnUs(DataParser.parse(String.class, r.getValue(LangVOMeta.EN_US)));
			this.setZhMo(DataParser.parse(String.class, r.getValue(LangVOMeta.ZH_MO)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(LangVOMeta.UPDATE_TIME)));
			this.setEnGb(DataParser.parse(String.class, r.getValue(LangVOMeta.EN_GB)));
			this.setJaJp(DataParser.parse(String.class, r.getValue(LangVOMeta.JA_JP)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(LangVOMeta.VERSION)));
			this.setValid(DataParser.parse(Integer.class, r.getValue(LangVOMeta.VALID)));
			this.setConfuse(DataParser.parse(String.class, r.getValue(LangVOMeta.CONFUSE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(LangVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(LangVOMeta.DELETED)));
			this.setDefaults(DataParser.parse(String.class, r.getValue(LangVOMeta.DEFAULTS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(LangVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(LangVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(LangVOMeta.DELETE_TIME)));
			this.setContext(DataParser.parse(String.class, r.getValue(LangVOMeta.CONTEXT)));
			this.setKoKr(DataParser.parse(String.class, r.getValue(LangVOMeta.KO_KR)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(LangVOMeta.DELETE_BY)));
			return true;
		} else {
			try {
				this.setZhCn( (String)r.getValue(LangVOMeta.ZH_CN));
				this.setCode( (String)r.getValue(LangVOMeta.CODE));
				this.setZhHk( (String)r.getValue(LangVOMeta.ZH_HK));
				this.setZhTw( (String)r.getValue(LangVOMeta.ZH_TW));
				this.setEnUs( (String)r.getValue(LangVOMeta.EN_US));
				this.setZhMo( (String)r.getValue(LangVOMeta.ZH_MO));
				this.setUpdateTime( (Date)r.getValue(LangVOMeta.UPDATE_TIME));
				this.setEnGb( (String)r.getValue(LangVOMeta.EN_GB));
				this.setJaJp( (String)r.getValue(LangVOMeta.JA_JP));
				this.setVersion( (Integer)r.getValue(LangVOMeta.VERSION));
				this.setValid( (Integer)r.getValue(LangVOMeta.VALID));
				this.setConfuse( (String)r.getValue(LangVOMeta.CONFUSE));
				this.setCreateBy( (String)r.getValue(LangVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(LangVOMeta.DELETED));
				this.setDefaults( (String)r.getValue(LangVOMeta.DEFAULTS));
				this.setCreateTime( (Date)r.getValue(LangVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(LangVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(LangVOMeta.DELETE_TIME));
				this.setContext( (String)r.getValue(LangVOMeta.CONTEXT));
				this.setKoKr( (String)r.getValue(LangVOMeta.KO_KR));
				this.setDeleteBy( (String)r.getValue(LangVOMeta.DELETE_BY));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}