package org.github.foxnic.web.domain.system.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.system.CodeExampleCar;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Position;
import org.github.foxnic.web.domain.hrm.Employee;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-02-07 09:03:10
 * @sign 200EBBE1F5C5228B9E91FB19A6ABC9B1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CodeExampleCarMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 属主ID , 类型: java.lang.String
	*/
	public static final String EXAMPLE_ID="exampleId";
	
	/**
	 * 属主ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.String> EXAMPLE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,EXAMPLE_ID, java.lang.String.class, "属主ID", "属主ID", java.lang.String.class, null);
	
	/**
	 * 车牌号 , 类型: java.lang.String
	*/
	public static final String PLATE_NUMBER="plateNumber";
	
	/**
	 * 车牌号 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.String> PLATE_NUMBER_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,PLATE_NUMBER, java.lang.String.class, "车牌号", "车牌号", java.lang.String.class, null);
	
	/**
	 * 颜色 , 类型: java.lang.String
	*/
	public static final String COLOR="color";
	
	/**
	 * 颜色 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.String> COLOR_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,COLOR, java.lang.String.class, "颜色", "颜色", java.lang.String.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 岗位单选 , 类型: java.lang.String
	*/
	public static final String POSITION_ID="positionId";
	
	/**
	 * 岗位单选 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.String> POSITION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,POSITION_ID, java.lang.String.class, "岗位单选", "岗位单选", java.lang.String.class, null);
	
	/**
	 * 组织单选 , 类型: java.lang.String
	*/
	public static final String ORG_ID="orgId";
	
	/**
	 * 组织单选 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.String> ORG_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,ORG_ID, java.lang.String.class, "组织单选", "组织单选", java.lang.String.class, null);
	
	/**
	 * 员工单选 , 类型: java.lang.String
	*/
	public static final String EMP_ID="empId";
	
	/**
	 * 员工单选 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.String> EMP_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,EMP_ID, java.lang.String.class, "员工单选", "员工单选", java.lang.String.class, null);
	
	/**
	 * 岗位多选 , 类型: java.lang.String
	*/
	public static final String POSITION_IDS="positionIds";
	
	/**
	 * 岗位多选 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.String> POSITION_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,POSITION_IDS, java.lang.String.class, "岗位多选", "岗位多选", java.lang.String.class, null);
	
	/**
	 * 组织多选 , 类型: java.lang.String
	*/
	public static final String ORG_IDS="orgIds";
	
	/**
	 * 组织多选 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.String> ORG_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,ORG_IDS, java.lang.String.class, "组织多选", "组织多选", java.lang.String.class, null);
	
	/**
	 * 员工多选 , 类型: java.lang.String
	*/
	public static final String EMP_IDS="empIds";
	
	/**
	 * 员工多选 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.String> EMP_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,EMP_IDS, java.lang.String.class, "员工多选", "员工多选", java.lang.String.class, null);
	
	/**
	 * 员工下拉 , 类型: java.lang.String
	*/
	public static final String SELECT_EMP_ID="selectEmpId";
	
	/**
	 * 员工下拉 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.String> SELECT_EMP_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,SELECT_EMP_ID, java.lang.String.class, "员工下拉", "员工下拉", java.lang.String.class, null);
	
	/**
	 * 公司单选 , 类型: java.lang.String
	*/
	public static final String COM_ID="comId";
	
	/**
	 * 公司单选 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.String> COM_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,COM_ID, java.lang.String.class, "公司单选", "公司单选", java.lang.String.class, null);
	
	/**
	 * 部门多选 , 类型: java.lang.String
	*/
	public static final String DEPT_IDS="deptIds";
	
	/**
	 * 部门多选 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.String> DEPT_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,DEPT_IDS, java.lang.String.class, "部门多选", "部门多选", java.lang.String.class, null);
	
	/**
	 * 限定上级 , 类型: java.lang.String
	*/
	public static final String SUB_ORG_ID="subOrgId";
	
	/**
	 * 限定上级 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.String> SUB_ORG_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,SUB_ORG_ID, java.lang.String.class, "限定上级", "限定上级", java.lang.String.class, null);
	
	/**
	 * 关联组织 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String ORGANIZATION="organization";
	
	/**
	 * 关联组织 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,org.github.foxnic.web.domain.hrm.Organization> ORGANIZATION_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "关联组织", "关联组织", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 关联组织 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String SUB_ORGANIZATION="subOrganization";
	
	/**
	 * 关联组织 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,org.github.foxnic.web.domain.hrm.Organization> SUB_ORGANIZATION_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,SUB_ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "关联组织", "关联组织", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 关联公司 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String COMPANY="company";
	
	/**
	 * 关联公司 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,org.github.foxnic.web.domain.hrm.Organization> COMPANY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,COMPANY, org.github.foxnic.web.domain.hrm.Organization.class, "关联公司", "关联公司", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 关联岗位 , 类型: org.github.foxnic.web.domain.hrm.Position
	*/
	public static final String POSITION="position";
	
	/**
	 * 关联岗位 , 类型: org.github.foxnic.web.domain.hrm.Position
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,org.github.foxnic.web.domain.hrm.Position> POSITION_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,POSITION, org.github.foxnic.web.domain.hrm.Position.class, "关联岗位", "关联岗位", org.github.foxnic.web.domain.hrm.Position.class, null);
	
	/**
	 * 关联人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String EMPLOYEE="employee";
	
	/**
	 * 关联人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,org.github.foxnic.web.domain.hrm.Employee> EMPLOYEE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,EMPLOYEE, org.github.foxnic.web.domain.hrm.Employee.class, "关联人员", "关联人员", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , EXAMPLE_ID , PLATE_NUMBER , COLOR , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , POSITION_ID , ORG_ID , EMP_ID , POSITION_IDS , ORG_IDS , EMP_IDS , SELECT_EMP_ID , COM_ID , DEPT_IDS , SUB_ORG_ID , ORGANIZATION , SUB_ORGANIZATION , COMPANY , POSITION , EMPLOYEE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.CodeExampleCar {

		private static final long serialVersionUID = 1L;

		
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