package org.github.foxnic.web.domain.system.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.system.CodeExampleCarVO;
import java.util.List;
import org.github.foxnic.web.domain.system.CodeExampleCar;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Position;
import org.github.foxnic.web.domain.hrm.Employee;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-02-07 09:03:10
 * @sign D8350CA053B56F0520CCC379195D138F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CodeExampleCarVOMeta extends CodeExampleCarMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 属主ID , 类型: java.lang.String
	*/
	public static final String EXAMPLE_ID="exampleId";
	
	/**
	 * 属主ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> EXAMPLE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,EXAMPLE_ID, java.lang.String.class, "属主ID", "属主ID", java.lang.String.class, null);
	
	/**
	 * 车牌号 , 类型: java.lang.String
	*/
	public static final String PLATE_NUMBER="plateNumber";
	
	/**
	 * 车牌号 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> PLATE_NUMBER_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,PLATE_NUMBER, java.lang.String.class, "车牌号", "车牌号", java.lang.String.class, null);
	
	/**
	 * 颜色 , 类型: java.lang.String
	*/
	public static final String COLOR="color";
	
	/**
	 * 颜色 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> COLOR_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,COLOR, java.lang.String.class, "颜色", "颜色", java.lang.String.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 岗位单选 , 类型: java.lang.String
	*/
	public static final String POSITION_ID="positionId";
	
	/**
	 * 岗位单选 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> POSITION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,POSITION_ID, java.lang.String.class, "岗位单选", "岗位单选", java.lang.String.class, null);
	
	/**
	 * 组织单选 , 类型: java.lang.String
	*/
	public static final String ORG_ID="orgId";
	
	/**
	 * 组织单选 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> ORG_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,ORG_ID, java.lang.String.class, "组织单选", "组织单选", java.lang.String.class, null);
	
	/**
	 * 员工单选 , 类型: java.lang.String
	*/
	public static final String EMP_ID="empId";
	
	/**
	 * 员工单选 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> EMP_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,EMP_ID, java.lang.String.class, "员工单选", "员工单选", java.lang.String.class, null);
	
	/**
	 * 岗位多选 , 类型: java.lang.String
	*/
	public static final String POSITION_IDS="positionIds";
	
	/**
	 * 岗位多选 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> POSITION_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,POSITION_IDS, java.lang.String.class, "岗位多选", "岗位多选", java.lang.String.class, null);
	
	/**
	 * 组织多选 , 类型: java.lang.String
	*/
	public static final String ORG_IDS="orgIds";
	
	/**
	 * 组织多选 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> ORG_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,ORG_IDS, java.lang.String.class, "组织多选", "组织多选", java.lang.String.class, null);
	
	/**
	 * 员工多选 , 类型: java.lang.String
	*/
	public static final String EMP_IDS="empIds";
	
	/**
	 * 员工多选 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> EMP_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,EMP_IDS, java.lang.String.class, "员工多选", "员工多选", java.lang.String.class, null);
	
	/**
	 * 员工下拉 , 类型: java.lang.String
	*/
	public static final String SELECT_EMP_ID="selectEmpId";
	
	/**
	 * 员工下拉 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> SELECT_EMP_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,SELECT_EMP_ID, java.lang.String.class, "员工下拉", "员工下拉", java.lang.String.class, null);
	
	/**
	 * 公司单选 , 类型: java.lang.String
	*/
	public static final String COM_ID="comId";
	
	/**
	 * 公司单选 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> COM_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,COM_ID, java.lang.String.class, "公司单选", "公司单选", java.lang.String.class, null);
	
	/**
	 * 部门多选 , 类型: java.lang.String
	*/
	public static final String DEPT_IDS="deptIds";
	
	/**
	 * 部门多选 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> DEPT_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,DEPT_IDS, java.lang.String.class, "部门多选", "部门多选", java.lang.String.class, null);
	
	/**
	 * 限定上级 , 类型: java.lang.String
	*/
	public static final String SUB_ORG_ID="subOrgId";
	
	/**
	 * 限定上级 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,java.lang.String> SUB_ORG_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,SUB_ORG_ID, java.lang.String.class, "限定上级", "限定上级", java.lang.String.class, null);
	
	/**
	 * 关联组织 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String ORGANIZATION="organization";
	
	/**
	 * 关联组织 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,org.github.foxnic.web.domain.hrm.Organization> ORGANIZATION_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "关联组织", "关联组织", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 关联组织 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String SUB_ORGANIZATION="subOrganization";
	
	/**
	 * 关联组织 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,org.github.foxnic.web.domain.hrm.Organization> SUB_ORGANIZATION_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,SUB_ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "关联组织", "关联组织", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 关联公司 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String COMPANY="company";
	
	/**
	 * 关联公司 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,org.github.foxnic.web.domain.hrm.Organization> COMPANY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,COMPANY, org.github.foxnic.web.domain.hrm.Organization.class, "关联公司", "关联公司", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 关联岗位 , 类型: org.github.foxnic.web.domain.hrm.Position
	*/
	public static final String POSITION="position";
	
	/**
	 * 关联岗位 , 类型: org.github.foxnic.web.domain.hrm.Position
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,org.github.foxnic.web.domain.hrm.Position> POSITION_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,POSITION, org.github.foxnic.web.domain.hrm.Position.class, "关联岗位", "关联岗位", org.github.foxnic.web.domain.hrm.Position.class, null);
	
	/**
	 * 关联人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String EMPLOYEE="employee";
	
	/**
	 * 关联人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCarVO,org.github.foxnic.web.domain.hrm.Employee> EMPLOYEE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCarVO.class ,EMPLOYEE, org.github.foxnic.web.domain.hrm.Employee.class, "关联人员", "关联人员", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , EXAMPLE_ID , PLATE_NUMBER , COLOR , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , POSITION_ID , ORG_ID , EMP_ID , POSITION_IDS , ORG_IDS , EMP_IDS , SELECT_EMP_ID , COM_ID , DEPT_IDS , SUB_ORG_ID , ORGANIZATION , SUB_ORGANIZATION , COMPANY , POSITION , EMPLOYEE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.CodeExampleCarVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public CodeExampleCarVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public CodeExampleCarVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public CodeExampleCarVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public CodeExampleCarVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public CodeExampleCarVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public CodeExampleCarVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public CodeExampleCarVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public CodeExampleCarVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public CodeExampleCarVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CodeExampleCar setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 属主ID
		 * @param exampleId 属主ID
		 * @return 当前对象
		*/
		public CodeExampleCar setExampleId(String exampleId) {
			super.change(EXAMPLE_ID,super.getExampleId(),exampleId);
			super.setExampleId(exampleId);
			return this;
		}
		
		/**
		 * 设置 车牌号
		 * @param plateNumber 车牌号
		 * @return 当前对象
		*/
		public CodeExampleCar setPlateNumber(String plateNumber) {
			super.change(PLATE_NUMBER,super.getPlateNumber(),plateNumber);
			super.setPlateNumber(plateNumber);
			return this;
		}
		
		/**
		 * 设置 颜色
		 * @param color 颜色
		 * @return 当前对象
		*/
		public CodeExampleCar setColor(String color) {
			super.change(COLOR,super.getColor(),color);
			super.setColor(color);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public CodeExampleCar setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CodeExampleCar setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CodeExampleCar setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CodeExampleCar setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CodeExampleCar setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CodeExampleCar setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CodeExampleCar setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CodeExampleCar setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 岗位单选
		 * @param positionId 岗位单选
		 * @return 当前对象
		*/
		public CodeExampleCar setPositionId(String positionId) {
			super.change(POSITION_ID,super.getPositionId(),positionId);
			super.setPositionId(positionId);
			return this;
		}
		
		/**
		 * 设置 组织单选
		 * @param orgId 组织单选
		 * @return 当前对象
		*/
		public CodeExampleCar setOrgId(String orgId) {
			super.change(ORG_ID,super.getOrgId(),orgId);
			super.setOrgId(orgId);
			return this;
		}
		
		/**
		 * 设置 员工单选
		 * @param empId 员工单选
		 * @return 当前对象
		*/
		public CodeExampleCar setEmpId(String empId) {
			super.change(EMP_ID,super.getEmpId(),empId);
			super.setEmpId(empId);
			return this;
		}
		
		/**
		 * 设置 岗位多选
		 * @param positionIds 岗位多选
		 * @return 当前对象
		*/
		public CodeExampleCar setPositionIds(String positionIds) {
			super.change(POSITION_IDS,super.getPositionIds(),positionIds);
			super.setPositionIds(positionIds);
			return this;
		}
		
		/**
		 * 设置 组织多选
		 * @param orgIds 组织多选
		 * @return 当前对象
		*/
		public CodeExampleCar setOrgIds(String orgIds) {
			super.change(ORG_IDS,super.getOrgIds(),orgIds);
			super.setOrgIds(orgIds);
			return this;
		}
		
		/**
		 * 设置 员工多选
		 * @param empIds 员工多选
		 * @return 当前对象
		*/
		public CodeExampleCar setEmpIds(String empIds) {
			super.change(EMP_IDS,super.getEmpIds(),empIds);
			super.setEmpIds(empIds);
			return this;
		}
		
		/**
		 * 设置 员工下拉
		 * @param selectEmpId 员工下拉
		 * @return 当前对象
		*/
		public CodeExampleCar setSelectEmpId(String selectEmpId) {
			super.change(SELECT_EMP_ID,super.getSelectEmpId(),selectEmpId);
			super.setSelectEmpId(selectEmpId);
			return this;
		}
		
		/**
		 * 设置 公司单选
		 * @param comId 公司单选
		 * @return 当前对象
		*/
		public CodeExampleCar setComId(String comId) {
			super.change(COM_ID,super.getComId(),comId);
			super.setComId(comId);
			return this;
		}
		
		/**
		 * 设置 部门多选
		 * @param deptIds 部门多选
		 * @return 当前对象
		*/
		public CodeExampleCar setDeptIds(String deptIds) {
			super.change(DEPT_IDS,super.getDeptIds(),deptIds);
			super.setDeptIds(deptIds);
			return this;
		}
		
		/**
		 * 设置 限定上级
		 * @param subOrgId 限定上级
		 * @return 当前对象
		*/
		public CodeExampleCar setSubOrgId(String subOrgId) {
			super.change(SUB_ORG_ID,super.getSubOrgId(),subOrgId);
			super.setSubOrgId(subOrgId);
			return this;
		}
		
		/**
		 * 设置 关联组织
		 * @param organization 关联组织
		 * @return 当前对象
		*/
		public CodeExampleCar setOrganization(Organization organization) {
			super.change(ORGANIZATION,super.getOrganization(),organization);
			super.setOrganization(organization);
			return this;
		}
		
		/**
		 * 设置 关联组织
		 * @param subOrganization 关联组织
		 * @return 当前对象
		*/
		public CodeExampleCar setSubOrganization(Organization subOrganization) {
			super.change(SUB_ORGANIZATION,super.getSubOrganization(),subOrganization);
			super.setSubOrganization(subOrganization);
			return this;
		}
		
		/**
		 * 设置 关联公司
		 * @param company 关联公司
		 * @return 当前对象
		*/
		public CodeExampleCar setCompany(Organization company) {
			super.change(COMPANY,super.getCompany(),company);
			super.setCompany(company);
			return this;
		}
		
		/**
		 * 设置 关联岗位
		 * @param position 关联岗位
		 * @return 当前对象
		*/
		public CodeExampleCar setPosition(Position position) {
			super.change(POSITION,super.getPosition(),position);
			super.setPosition(position);
			return this;
		}
		
		/**
		 * 设置 关联人员
		 * @param employee 关联人员
		 * @return 当前对象
		*/
		public CodeExampleCar setEmployee(Employee employee) {
			super.change(EMPLOYEE,super.getEmployee(),employee);
			super.setEmployee(employee);
			return this;
		}
	}
}