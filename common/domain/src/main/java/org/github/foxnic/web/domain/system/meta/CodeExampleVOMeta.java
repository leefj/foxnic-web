package org.github.foxnic.web.domain.system.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.system.CodeExampleVO;
import java.util.List;
import org.github.foxnic.web.domain.system.CodeExample;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.Resourze;
import org.github.foxnic.web.domain.oauth.Role;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-26 09:22:50
 * @sign 18729F2CDDBC6E22EC7B8D69A06D53E7
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CodeExampleVOMeta extends CodeExampleMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,ID, java.lang.String.class, "ID", "ID", java.lang.String.class, null);
	
	/**
	 * 单行文本 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 单行文本 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,NAME, java.lang.String.class, "单行文本", "单行文本", java.lang.String.class, null);
	
	/**
	 * 多行文本 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 多行文本 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> NOTES_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,NOTES, java.lang.String.class, "多行文本", "多行文本", java.lang.String.class, null);
	
	/**
	 * 图片上传 , 类型: java.lang.String
	*/
	public static final String IMAGE_ID="imageId";
	
	/**
	 * 图片上传 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> IMAGE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,IMAGE_ID, java.lang.String.class, "图片上传", "图片上传", java.lang.String.class, null);
	
	/**
	 * 多文件上传 , 类型: java.lang.String
	*/
	public static final String FILE_IDS="fileIds";
	
	/**
	 * 多文件上传 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> FILE_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,FILE_IDS, java.lang.String.class, "多文件上传", "多文件上传", java.lang.String.class, null);
	
	/**
	 * 整数输入 , 类型: java.lang.Integer
	*/
	public static final String AREA="area";
	
	/**
	 * 整数输入 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.Integer> AREA_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,AREA, java.lang.Integer.class, "整数输入", "整数输入", java.lang.Integer.class, null);
	
	/**
	 * 小数输入 , 类型: java.lang.Double
	*/
	public static final String WEIGHT="weight";
	
	/**
	 * 小数输入 , 类型: java.lang.Double
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.Double> WEIGHT_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,WEIGHT, java.lang.Double.class, "小数输入", "小数输入", java.lang.Double.class, null);
	
	/**
	 * 逻辑值 , 类型: java.lang.Integer
	*/
	public static final String VALID="valid";
	
	/**
	 * 逻辑值 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.Integer> VALID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,VALID, java.lang.Integer.class, "逻辑值", "逻辑值", java.lang.Integer.class, null);
	
	/**
	 * 对话框 , 类型: java.lang.String
	*/
	public static final String BUTTON_INPUT="buttonInput";
	
	/**
	 * 对话框 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> BUTTON_INPUT_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,BUTTON_INPUT, java.lang.String.class, "对话框", "对话框", java.lang.String.class, null);
	
	/**
	 * 单选框(枚举) , 类型: java.lang.String
	*/
	public static final String RADIO_ENUM="radioEnum";
	
	/**
	 * 单选框(枚举) , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> RADIO_ENUM_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,RADIO_ENUM, java.lang.String.class, "单选框(枚举)", "单选框(枚举)", java.lang.String.class, null);
	
	/**
	 * 单选框(字典) , 类型: java.lang.String
	*/
	public static final String RADIO_DICT="radioDict";
	
	/**
	 * 单选框(字典) , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> RADIO_DICT_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,RADIO_DICT, java.lang.String.class, "单选框(字典)", "单选框(字典)", java.lang.String.class, null);
	
	/**
	 * 复选框(枚举) , 类型: java.lang.String
	*/
	public static final String CHECK_ENUM="checkEnum";
	
	/**
	 * 复选框(枚举) , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> CHECK_ENUM_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,CHECK_ENUM, java.lang.String.class, "复选框(枚举)", "复选框(枚举)", java.lang.String.class, null);
	
	/**
	 * 复选框(字典) , 类型: java.lang.String
	*/
	public static final String CHECK_DICT="checkDict";
	
	/**
	 * 复选框(字典) , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> CHECK_DICT_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,CHECK_DICT, java.lang.String.class, "复选框(字典)", "复选框(字典)", java.lang.String.class, null);
	
	/**
	 * 选择框(枚举) , 类型: java.lang.String
	*/
	public static final String SELECT_ENUM="selectEnum";
	
	/**
	 * 选择框(枚举) , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> SELECT_ENUM_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,SELECT_ENUM, java.lang.String.class, "选择框(枚举)", "选择框(枚举)", java.lang.String.class, null);
	
	/**
	 * 选择框(字典) , 类型: java.lang.String
	*/
	public static final String SELECT_DICT="selectDict";
	
	/**
	 * 选择框(字典) , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> SELECT_DICT_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,SELECT_DICT, java.lang.String.class, "选择框(字典)", "选择框(字典)", java.lang.String.class, null);
	
	/**
	 * 选择框(查询) , 类型: java.lang.String
	*/
	public static final String RESOURCE_ID="resourceId";
	
	/**
	 * 选择框(查询) , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> RESOURCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,RESOURCE_ID, java.lang.String.class, "选择框(查询)", "选择框(查询)", java.lang.String.class, null);
	
	/**
	 * 日期 , 类型: java.util.Date
	*/
	public static final String BIRTHDAY="birthday";
	
	/**
	 * 日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.util.Date> BIRTHDAY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,BIRTHDAY, java.util.Date.class, "日期", "日期", java.util.Date.class, null);
	
	/**
	 * 工作时间 , 类型: java.util.Date
	*/
	public static final String WORK_TIME="workTime";
	
	/**
	 * 工作时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.util.Date> WORK_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,WORK_TIME, java.util.Date.class, "工作时间", "工作时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 关联一个资源 , 一对一关系属性拓展 , 类型: org.github.foxnic.web.domain.oauth.Resourze
	*/
	public static final String RESOURZE="resourze";
	
	/**
	 * 关联一个资源 , 一对一关系属性拓展 , 类型: org.github.foxnic.web.domain.oauth.Resourze
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,org.github.foxnic.web.domain.oauth.Resourze> RESOURZE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,RESOURZE, org.github.foxnic.web.domain.oauth.Resourze.class, "关联一个资源", "一对一关系属性拓展", org.github.foxnic.web.domain.oauth.Resourze.class, null);
	
	/**
	 * 关联多个角色 , 一对多关系属性拓展 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.oauth.Role
	*/
	public static final String ROLES="roles";
	
	/**
	 * 关联多个角色 , 一对多关系属性拓展 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.oauth.Role
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,org.github.foxnic.web.domain.oauth.Role> ROLES_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,ROLES, java.util.List.class, "关联多个角色", "一对多关系属性拓展", org.github.foxnic.web.domain.oauth.Role.class, null);
	
	/**
	 * 角色的数量(Java) , 关联角色数量JAva统计 , 类型: java.lang.Integer
	*/
	public static final String ROLE_COUNT_BY_AFTER="roleCountByAfter";
	
	/**
	 * 角色的数量(Java) , 关联角色数量JAva统计 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.Integer> ROLE_COUNT_BY_AFTER_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,ROLE_COUNT_BY_AFTER, java.lang.Integer.class, "角色的数量(Java)", "关联角色数量JAva统计", java.lang.Integer.class, null);
	
	/**
	 * 角色的数量(Join) , 关联角色数量Join统计 , 类型: java.lang.Integer
	*/
	public static final String ROLE_COUNT_BY_JOIN="roleCountByJoin";
	
	/**
	 * 角色的数量(Join) , 关联角色数量Join统计 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.Integer> ROLE_COUNT_BY_JOIN_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,ROLE_COUNT_BY_JOIN, java.lang.Integer.class, "角色的数量(Join)", "关联角色数量Join统计", java.lang.Integer.class, null);
	
	/**
	 * 角色ID列表 , 用于表单角色ID提交到后端 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ROLE_IDS="roleIds";
	
	/**
	 * 角色ID列表 , 用于表单角色ID提交到后端 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleVO,java.lang.String> ROLE_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleVO.class ,ROLE_IDS, java.util.List.class, "角色ID列表", "用于表单角色ID提交到后端", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , NAME , NOTES , IMAGE_ID , FILE_IDS , AREA , WEIGHT , VALID , BUTTON_INPUT , RADIO_ENUM , RADIO_DICT , CHECK_ENUM , CHECK_DICT , SELECT_ENUM , SELECT_DICT , RESOURCE_ID , BIRTHDAY , WORK_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , RESOURZE , ROLES , ROLE_COUNT_BY_AFTER , ROLE_COUNT_BY_JOIN , ROLE_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.CodeExampleVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public CodeExampleVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public CodeExampleVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public CodeExampleVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public CodeExampleVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public CodeExampleVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public CodeExampleVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public CodeExampleVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public CodeExampleVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public CodeExampleVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public CodeExample setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 单行文本
		 * @param name 单行文本
		 * @return 当前对象
		*/
		public CodeExample setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 多行文本
		 * @param notes 多行文本
		 * @return 当前对象
		*/
		public CodeExample setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 图片上传
		 * @param imageId 图片上传
		 * @return 当前对象
		*/
		public CodeExample setImageId(String imageId) {
			super.change(IMAGE_ID,super.getImageId(),imageId);
			super.setImageId(imageId);
			return this;
		}
		
		/**
		 * 设置 多文件上传
		 * @param fileIds 多文件上传
		 * @return 当前对象
		*/
		public CodeExample setFileIds(String fileIds) {
			super.change(FILE_IDS,super.getFileIds(),fileIds);
			super.setFileIds(fileIds);
			return this;
		}
		
		/**
		 * 设置 整数输入
		 * @param area 整数输入
		 * @return 当前对象
		*/
		public CodeExample setArea(Integer area) {
			super.change(AREA,super.getArea(),area);
			super.setArea(area);
			return this;
		}
		
		/**
		 * 设置 小数输入
		 * @param weight 小数输入
		 * @return 当前对象
		*/
		public CodeExample setWeight(Double weight) {
			super.change(WEIGHT,super.getWeight(),weight);
			super.setWeight(weight);
			return this;
		}
		
		/**
		 * 设置 逻辑值
		 * @param valid 逻辑值
		 * @return 当前对象
		*/
		public CodeExample setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 对话框
		 * @param buttonInput 对话框
		 * @return 当前对象
		*/
		public CodeExample setButtonInput(String buttonInput) {
			super.change(BUTTON_INPUT,super.getButtonInput(),buttonInput);
			super.setButtonInput(buttonInput);
			return this;
		}
		
		/**
		 * 设置 单选框(枚举)
		 * @param radioEnum 单选框(枚举)
		 * @return 当前对象
		*/
		public CodeExample setRadioEnum(String radioEnum) {
			super.change(RADIO_ENUM,super.getRadioEnum(),radioEnum);
			super.setRadioEnum(radioEnum);
			return this;
		}
		
		/**
		 * 设置 单选框(字典)
		 * @param radioDict 单选框(字典)
		 * @return 当前对象
		*/
		public CodeExample setRadioDict(String radioDict) {
			super.change(RADIO_DICT,super.getRadioDict(),radioDict);
			super.setRadioDict(radioDict);
			return this;
		}
		
		/**
		 * 设置 复选框(枚举)
		 * @param checkEnum 复选框(枚举)
		 * @return 当前对象
		*/
		public CodeExample setCheckEnum(String checkEnum) {
			super.change(CHECK_ENUM,super.getCheckEnum(),checkEnum);
			super.setCheckEnum(checkEnum);
			return this;
		}
		
		/**
		 * 设置 复选框(字典)
		 * @param checkDict 复选框(字典)
		 * @return 当前对象
		*/
		public CodeExample setCheckDict(String checkDict) {
			super.change(CHECK_DICT,super.getCheckDict(),checkDict);
			super.setCheckDict(checkDict);
			return this;
		}
		
		/**
		 * 设置 选择框(枚举)
		 * @param selectEnum 选择框(枚举)
		 * @return 当前对象
		*/
		public CodeExample setSelectEnum(String selectEnum) {
			super.change(SELECT_ENUM,super.getSelectEnum(),selectEnum);
			super.setSelectEnum(selectEnum);
			return this;
		}
		
		/**
		 * 设置 选择框(字典)
		 * @param selectDict 选择框(字典)
		 * @return 当前对象
		*/
		public CodeExample setSelectDict(String selectDict) {
			super.change(SELECT_DICT,super.getSelectDict(),selectDict);
			super.setSelectDict(selectDict);
			return this;
		}
		
		/**
		 * 设置 选择框(查询)
		 * @param resourceId 选择框(查询)
		 * @return 当前对象
		*/
		public CodeExample setResourceId(String resourceId) {
			super.change(RESOURCE_ID,super.getResourceId(),resourceId);
			super.setResourceId(resourceId);
			return this;
		}
		
		/**
		 * 设置 日期
		 * @param birthday 日期
		 * @return 当前对象
		*/
		public CodeExample setBirthday(Date birthday) {
			super.change(BIRTHDAY,super.getBirthday(),birthday);
			super.setBirthday(birthday);
			return this;
		}
		
		/**
		 * 设置 工作时间
		 * @param workTime 工作时间
		 * @return 当前对象
		*/
		public CodeExample setWorkTime(Date workTime) {
			super.change(WORK_TIME,super.getWorkTime(),workTime);
			super.setWorkTime(workTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CodeExample setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CodeExample setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CodeExample setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CodeExample setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CodeExample setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CodeExample setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CodeExample setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public CodeExample setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 关联一个资源
		 * @param resourze 关联一个资源
		 * @return 当前对象
		*/
		public CodeExample setResourze(Resourze resourze) {
			super.change(RESOURZE,super.getResourze(),resourze);
			super.setResourze(resourze);
			return this;
		}
		
		/**
		 * 设置 关联多个角色
		 * @param roles 关联多个角色
		 * @return 当前对象
		*/
		public CodeExample setRoles(List<Role> roles) {
			super.change(ROLES,super.getRoles(),roles);
			super.setRoles(roles);
			return this;
		}
		
		/**
		 * 设置 角色的数量(Java)
		 * @param roleCountByAfter 角色的数量(Java)
		 * @return 当前对象
		*/
		public CodeExample setRoleCountByAfter(Integer roleCountByAfter) {
			super.change(ROLE_COUNT_BY_AFTER,super.getRoleCountByAfter(),roleCountByAfter);
			super.setRoleCountByAfter(roleCountByAfter);
			return this;
		}
		
		/**
		 * 设置 角色的数量(Join)
		 * @param roleCountByJoin 角色的数量(Join)
		 * @return 当前对象
		*/
		public CodeExample setRoleCountByJoin(Integer roleCountByJoin) {
			super.change(ROLE_COUNT_BY_JOIN,super.getRoleCountByJoin(),roleCountByJoin);
			super.setRoleCountByJoin(roleCountByJoin);
			return this;
		}
		
		/**
		 * 设置 角色ID列表
		 * @param roleIds 角色ID列表
		 * @return 当前对象
		*/
		public CodeExample setRoleIds(List<String> roleIds) {
			super.change(ROLE_IDS,super.getRoleIds(),roleIds);
			super.setRoleIds(roleIds);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public CodeExampleVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public CodeExampleVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setBirthday(this.getBirthday());
			inst.setResourceId(this.getResourceId());
			inst.setNotes(this.getNotes());
			inst.setValid(this.getValid());
			inst.setButtonInput(this.getButtonInput());
			inst.setCheckEnum(this.getCheckEnum());
			inst.setFileIds(this.getFileIds());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setSelectDict(this.getSelectDict());
			inst.setSelectEnum(this.getSelectEnum());
			inst.setId(this.getId());
			inst.setArea(this.getArea());
			inst.setImageId(this.getImageId());
			inst.setCheckDict(this.getCheckDict());
			inst.setWeight(this.getWeight());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setWorkTime(this.getWorkTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setRadioDict(this.getRadioDict());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setRadioEnum(this.getRadioEnum());
			inst.setDeleteBy(this.getDeleteBy());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setRoles(this.getRoles());
				inst.setPageSize(this.getPageSize());
				inst.setRoleCountByJoin(this.getRoleCountByJoin());
				inst.setRoleCountByAfter(this.getRoleCountByAfter());
				inst.setRoleIds(this.getRoleIds());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setIds(this.getIds());
				inst.setResourze(this.getResourze());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}