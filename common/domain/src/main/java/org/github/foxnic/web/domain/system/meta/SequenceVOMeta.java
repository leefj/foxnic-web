package org.github.foxnic.web.domain.system.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.system.SequenceVO;
import java.util.List;
import org.github.foxnic.web.domain.system.Sequence;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:18:43
 * @sign 92A7DFD2CDDC2E381BAD0CD21E42C25E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SequenceVOMeta extends SequenceMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.SequenceVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.system.SequenceVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.SequenceVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.SequenceVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.SequenceVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.system.SequenceVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.SequenceVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.system.SequenceVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.SequenceVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.SequenceVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.SequenceVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.SequenceVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.SequenceVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.system.SequenceVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.SequenceVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.SequenceVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String PKS="pks";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.SequenceVO,java.lang.String> PKS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.SequenceVO.class ,PKS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String PK="pk";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.SequenceVO,java.lang.String> PK_PROP = new BeanProperty(org.github.foxnic.web.domain.system.SequenceVO.class ,PK, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 序列ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 序列ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.SequenceVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.SequenceVO.class ,ID, java.lang.String.class, "序列ID", "序列ID", java.lang.String.class, null);
	
	/**
	 * 序列名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 序列名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.SequenceVO,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.SequenceVO.class ,NAME, java.lang.String.class, "序列名称", "序列名称", java.lang.String.class, null);
	
	/**
	 * 编码长度 , 类型: java.lang.Integer
	*/
	public static final String LENGTH="length";
	
	/**
	 * 编码长度 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.SequenceVO,java.lang.Integer> LENGTH_PROP = new BeanProperty(org.github.foxnic.web.domain.system.SequenceVO.class ,LENGTH, java.lang.Integer.class, "编码长度", "编码长度", java.lang.Integer.class, null);
	
	/**
	 * 编码分类 , 类型: java.lang.String
	*/
	public static final String CATALOG="catalog";
	
	/**
	 * 编码分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.SequenceVO,java.lang.String> CATALOG_PROP = new BeanProperty(org.github.foxnic.web.domain.system.SequenceVO.class ,CATALOG, java.lang.String.class, "编码分类", "编码分类", java.lang.String.class, null);
	
	/**
	 * 当前数值 , 类型: java.lang.Long
	*/
	public static final String VALUE="value";
	
	/**
	 * 当前数值 , 类型: java.lang.Long
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.SequenceVO,java.lang.Long> VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.SequenceVO.class ,VALUE, java.lang.Long.class, "当前数值", "当前数值", java.lang.Long.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String MEMO="memo";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.SequenceVO,java.lang.String> MEMO_PROP = new BeanProperty(org.github.foxnic.web.domain.system.SequenceVO.class ,MEMO, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 编码类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 编码类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.SequenceVO,java.lang.String> TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.SequenceVO.class ,TYPE, java.lang.String.class, "编码类型", "编码类型", java.lang.String.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.SequenceVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.SequenceVO.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 每次取数的个数 , 类型: java.lang.Integer
	*/
	public static final String FETCH_SIZE="fetchSize";
	
	/**
	 * 每次取数的个数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.SequenceVO,java.lang.Integer> FETCH_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.SequenceVO.class ,FETCH_SIZE, java.lang.Integer.class, "每次取数的个数", "每次取数的个数", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , PKS , PK , ID , NAME , LENGTH , CATALOG , VALUE , MEMO , TYPE , TENANT_ID , FETCH_SIZE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.SequenceVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public SequenceVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public SequenceVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public SequenceVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public SequenceVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public SequenceVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public SequenceVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public SequenceVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public SequenceVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param pks 主键清单
		 * @return 当前对象
		*/
		public SequenceVO setPks(List<String> pks) {
			super.change(PKS,super.getPks(),pks);
			super.setPks(pks);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param pk 主键
		 * @return 当前对象
		*/
		public Sequence setPk(String pk) {
			super.change(PK,super.getPk(),pk);
			super.setPk(pk);
			return this;
		}
		
		/**
		 * 设置 序列ID
		 * @param id 序列ID
		 * @return 当前对象
		*/
		public Sequence setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 序列名称
		 * @param name 序列名称
		 * @return 当前对象
		*/
		public Sequence setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 编码长度
		 * @param length 编码长度
		 * @return 当前对象
		*/
		public Sequence setLength(Integer length) {
			super.change(LENGTH,super.getLength(),length);
			super.setLength(length);
			return this;
		}
		
		/**
		 * 设置 编码分类
		 * @param catalog 编码分类
		 * @return 当前对象
		*/
		public Sequence setCatalog(String catalog) {
			super.change(CATALOG,super.getCatalog(),catalog);
			super.setCatalog(catalog);
			return this;
		}
		
		/**
		 * 设置 当前数值
		 * @param value 当前数值
		 * @return 当前对象
		*/
		public Sequence setValue(Long value) {
			super.change(VALUE,super.getValue(),value);
			super.setValue(value);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param memo 备注
		 * @return 当前对象
		*/
		public Sequence setMemo(String memo) {
			super.change(MEMO,super.getMemo(),memo);
			super.setMemo(memo);
			return this;
		}
		
		/**
		 * 设置 编码类型
		 * @param type 编码类型
		 * @return 当前对象
		*/
		public Sequence setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public Sequence setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 每次取数的个数
		 * @param fetchSize 每次取数的个数
		 * @return 当前对象
		*/
		public Sequence setFetchSize(Integer fetchSize) {
			super.change(FETCH_SIZE,super.getFetchSize(),fetchSize);
			super.setFetchSize(fetchSize);
			return this;
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
			$$proxy$$ inst=new $$proxy$$();
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

	}
}