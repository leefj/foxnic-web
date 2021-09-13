package org.github.foxnic.web.domain.hrm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.hrm.Position;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-13 15:09:52
 * @sign F73FD3507684E9F98EC495C697EEDEC1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PositionMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Position,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Position.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 所属组织ID , 类型: java.lang.String
	*/
	public static final String ORG_ID="orgId";
	
	/**
	 * 所属组织ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Position,java.lang.String> ORG_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Position.class ,ORG_ID, java.lang.String.class, "所属组织ID", "所属组织ID", java.lang.String.class, null);
	
	/**
	 * 岗位代码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 岗位代码 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Position,java.lang.String> CODE_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Position.class ,CODE, java.lang.String.class, "岗位代码", "岗位代码", java.lang.String.class, null);
	
	/**
	 * 全称 , 类型: java.lang.String
	*/
	public static final String FULL_NAME="fullName";
	
	/**
	 * 全称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Position,java.lang.String> FULL_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Position.class ,FULL_NAME, java.lang.String.class, "全称", "全称", java.lang.String.class, null);
	
	/**
	 * 简称 , 类型: java.lang.String
	*/
	public static final String SHORT_NAME="shortName";
	
	/**
	 * 简称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Position,java.lang.String> SHORT_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Position.class ,SHORT_NAME, java.lang.String.class, "简称", "简称", java.lang.String.class, null);
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final String VALID="valid";
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Position,java.lang.Integer> VALID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Position.class ,VALID, java.lang.Integer.class, "是否有效", "是否有效", java.lang.Integer.class, null);
	
	/**
	 * 总公司ID , 类型: java.lang.String
	*/
	public static final String COMPANY_ID="companyId";
	
	/**
	 * 总公司ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Position,java.lang.String> COMPANY_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Position.class ,COMPANY_ID, java.lang.String.class, "总公司ID", "总公司ID", java.lang.String.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Position,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Position.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Position,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Position.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Position,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Position.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Position,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Position.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Position,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Position.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Position,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Position.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Position,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Position.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Position,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Position.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Position,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Position.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , ORG_ID , CODE , FULL_NAME , SHORT_NAME , VALID , COMPANY_ID , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.hrm.Position {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Position setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 所属组织ID
		 * @param orgId 所属组织ID
		 * @return 当前对象
		*/
		public Position setOrgId(String orgId) {
			super.change(ORG_ID,super.getOrgId(),orgId);
			super.setOrgId(orgId);
			return this;
		}
		
		/**
		 * 设置 岗位代码
		 * @param code 岗位代码
		 * @return 当前对象
		*/
		public Position setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 全称
		 * @param fullName 全称
		 * @return 当前对象
		*/
		public Position setFullName(String fullName) {
			super.change(FULL_NAME,super.getFullName(),fullName);
			super.setFullName(fullName);
			return this;
		}
		
		/**
		 * 设置 简称
		 * @param shortName 简称
		 * @return 当前对象
		*/
		public Position setShortName(String shortName) {
			super.change(SHORT_NAME,super.getShortName(),shortName);
			super.setShortName(shortName);
			return this;
		}
		
		/**
		 * 设置 是否有效
		 * @param valid 是否有效
		 * @return 当前对象
		*/
		public Position setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 总公司ID
		 * @param companyId 总公司ID
		 * @return 当前对象
		*/
		public Position setCompanyId(String companyId) {
			super.change(COMPANY_ID,super.getCompanyId(),companyId);
			super.setCompanyId(companyId);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public Position setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Position setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Position setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Position setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Position setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Position setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Position setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Position setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Position setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}