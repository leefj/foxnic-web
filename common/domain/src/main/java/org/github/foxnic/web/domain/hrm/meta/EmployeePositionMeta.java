package org.github.foxnic.web.domain.hrm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.hrm.EmployeePosition;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-14 15:44:29
 * @sign A18AF0E2C35B082207814ED6F30A2145
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class EmployeePositionMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.EmployeePosition,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.EmployeePosition.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 员工ID , 类型: java.lang.String
	*/
	public static final String EMPLOYEE_ID="employeeId";
	
	/**
	 * 员工ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.EmployeePosition,java.lang.String> EMPLOYEE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.EmployeePosition.class ,EMPLOYEE_ID, java.lang.String.class, "员工ID", "员工ID", java.lang.String.class, null);
	
	/**
	 * 岗位ID , 类型: java.lang.String
	*/
	public static final String POSITION_ID="positionId";
	
	/**
	 * 岗位ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.EmployeePosition,java.lang.String> POSITION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.EmployeePosition.class ,POSITION_ID, java.lang.String.class, "岗位ID", "岗位ID", java.lang.String.class, null);
	
	/**
	 * 是否主岗 , 类型: java.lang.Integer
	*/
	public static final String IS_PRIMARY="isPrimary";
	
	/**
	 * 是否主岗 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.EmployeePosition,java.lang.Integer> IS_PRIMARY_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.EmployeePosition.class ,IS_PRIMARY, java.lang.Integer.class, "是否主岗", "是否主岗", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.EmployeePosition,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.EmployeePosition.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.EmployeePosition,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.EmployeePosition.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.EmployeePosition,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.EmployeePosition.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.EmployeePosition,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.EmployeePosition.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.EmployeePosition,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.EmployeePosition.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.EmployeePosition,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.EmployeePosition.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.EmployeePosition,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.EmployeePosition.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.EmployeePosition,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.EmployeePosition.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , EMPLOYEE_ID , POSITION_ID , IS_PRIMARY , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.hrm.EmployeePosition {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public EmployeePosition setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 员工ID
		 * @param employeeId 员工ID
		 * @return 当前对象
		*/
		public EmployeePosition setEmployeeId(String employeeId) {
			super.change(EMPLOYEE_ID,super.getEmployeeId(),employeeId);
			super.setEmployeeId(employeeId);
			return this;
		}
		
		/**
		 * 设置 岗位ID
		 * @param positionId 岗位ID
		 * @return 当前对象
		*/
		public EmployeePosition setPositionId(String positionId) {
			super.change(POSITION_ID,super.getPositionId(),positionId);
			super.setPositionId(positionId);
			return this;
		}
		
		/**
		 * 设置 是否主岗
		 * @param isPrimary 是否主岗
		 * @return 当前对象
		*/
		public EmployeePosition setIsPrimary(Integer isPrimary) {
			super.change(IS_PRIMARY,super.getIsPrimary(),isPrimary);
			super.setIsPrimary(isPrimary);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public EmployeePosition setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public EmployeePosition setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public EmployeePosition setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public EmployeePosition setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public EmployeePosition setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public EmployeePosition setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public EmployeePosition setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public EmployeePosition setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}