package org.github.foxnic.web.domain.system.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.system.LangVO;
import java.util.List;
import org.github.foxnic.web.domain.system.Lang;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-25 11:24:19
 * @sign BA40CDF42C01C9095A6649D22DC40B24
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class LangVOMeta extends LangMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String CODES="codes";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.lang.String> CODES_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,CODES, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 编码键 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编码键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.lang.String> CODE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,CODE, java.lang.String.class, "编码键", "编码键", java.lang.String.class, null);
	
	/**
	 * 默认 , 类型: java.lang.String
	*/
	public static final String DEFAULTS="defaults";
	
	/**
	 * 默认 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.lang.String> DEFAULTS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,DEFAULTS, java.lang.String.class, "默认", "默认", java.lang.String.class, null);
	
	/**
	 * 简体中文(大陆) , 类型: java.lang.String
	*/
	public static final String ZH_CH="zhCh";
	
	/**
	 * 简体中文(大陆) , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.lang.String> ZH_CH_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,ZH_CH, java.lang.String.class, "简体中文(大陆)", "简体中文(大陆)", java.lang.String.class, null);
	
	/**
	 * 繁体中文(台湾) , 类型: java.lang.String
	*/
	public static final String ZH_TW="zhTw";
	
	/**
	 * 繁体中文(台湾) , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.lang.String> ZH_TW_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,ZH_TW, java.lang.String.class, "繁体中文(台湾)", "繁体中文(台湾)", java.lang.String.class, null);
	
	/**
	 * 英文美国 , 类型: java.lang.String
	*/
	public static final String EN_US="enUs";
	
	/**
	 * 英文美国 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.lang.String> EN_US_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,EN_US, java.lang.String.class, "英文美国", "英文美国", java.lang.String.class, null);
	
	/**
	 * 英文英国 , 类型: java.lang.String
	*/
	public static final String EN_UK="enUk";
	
	/**
	 * 英文英国 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.lang.String> EN_UK_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,EN_UK, java.lang.String.class, "英文英国", "英文英国", java.lang.String.class, null);
	
	/**
	 * 混淆专用 , 类型: java.lang.String
	*/
	public static final String CONFUSE="confuse";
	
	/**
	 * 混淆专用 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.lang.String> CONFUSE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,CONFUSE, java.lang.String.class, "混淆专用", "混淆专用", java.lang.String.class, null);
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final String VALID="valid";
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.lang.Integer> VALID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,VALID, java.lang.Integer.class, "是否有效", "是否有效", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.LangVO,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.system.LangVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , CODES , CODE , DEFAULTS , ZH_CH , ZH_TW , EN_US , EN_UK , CONFUSE , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.LangVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public LangVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public LangVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public LangVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public LangVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public LangVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public LangVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public LangVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public LangVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param codes 主键清单
		 * @return 当前对象
		*/
		public LangVO setCodes(List<String> codes) {
			super.change(CODES,super.getCodes(),codes);
			super.setCodes(codes);
			return this;
		}
		
		/**
		 * 设置 编码键
		 * @param code 编码键
		 * @return 当前对象
		*/
		public Lang setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 默认
		 * @param defaults 默认
		 * @return 当前对象
		*/
		public Lang setDefaults(String defaults) {
			super.change(DEFAULTS,super.getDefaults(),defaults);
			super.setDefaults(defaults);
			return this;
		}
		
		/**
		 * 设置 简体中文(大陆)
		 * @param zhCh 简体中文(大陆)
		 * @return 当前对象
		*/
		public Lang setZhCh(String zhCh) {
			super.change(ZH_CH,super.getZhCh(),zhCh);
			super.setZhCh(zhCh);
			return this;
		}
		
		/**
		 * 设置 繁体中文(台湾)
		 * @param zhTw 繁体中文(台湾)
		 * @return 当前对象
		*/
		public Lang setZhTw(String zhTw) {
			super.change(ZH_TW,super.getZhTw(),zhTw);
			super.setZhTw(zhTw);
			return this;
		}
		
		/**
		 * 设置 英文美国
		 * @param enUs 英文美国
		 * @return 当前对象
		*/
		public Lang setEnUs(String enUs) {
			super.change(EN_US,super.getEnUs(),enUs);
			super.setEnUs(enUs);
			return this;
		}
		
		/**
		 * 设置 英文英国
		 * @param enUk 英文英国
		 * @return 当前对象
		*/
		public Lang setEnUk(String enUk) {
			super.change(EN_UK,super.getEnUk(),enUk);
			super.setEnUk(enUk);
			return this;
		}
		
		/**
		 * 设置 混淆专用
		 * @param confuse 混淆专用
		 * @return 当前对象
		*/
		public Lang setConfuse(String confuse) {
			super.change(CONFUSE,super.getConfuse(),confuse);
			super.setConfuse(confuse);
			return this;
		}
		
		/**
		 * 设置 是否有效
		 * @param valid 是否有效
		 * @return 当前对象
		*/
		public Lang setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Lang setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Lang setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Lang setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Lang setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Lang setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Lang setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Lang setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Lang setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}