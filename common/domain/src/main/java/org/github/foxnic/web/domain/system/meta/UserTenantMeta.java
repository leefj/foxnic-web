package org.github.foxnic.web.domain.system.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.system.UserTenant;
import java.util.Date;
import org.github.foxnic.web.domain.system.Tenant;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-25 14:43:22
 * @sign 203475EC7211C05F19C60A5FDA28165B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class UserTenantMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenant,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenant.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 用户ID , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 用户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenant,java.lang.String> USER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenant.class ,USER_ID, java.lang.String.class, "用户ID", "用户ID", java.lang.String.class, null);
	
	/**
	 * 所属的租户ID , 类型: java.lang.String
	*/
	public static final String OWNER_TENANT_ID="ownerTenantId";
	
	/**
	 * 所属的租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenant,java.lang.String> OWNER_TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenant.class ,OWNER_TENANT_ID, java.lang.String.class, "所属的租户ID", "所属的租户ID", java.lang.String.class, null);
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final String VALID="valid";
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenant,java.lang.Integer> VALID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenant.class ,VALID, java.lang.Integer.class, "是否有效", "是否有效", java.lang.Integer.class, null);
	
	/**
	 * 是否激活 , 激活时为当前默认租户 , 类型: java.lang.Integer
	*/
	public static final String ACTIVATED="activated";
	
	/**
	 * 是否激活 , 激活时为当前默认租户 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenant,java.lang.Integer> ACTIVATED_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenant.class ,ACTIVATED, java.lang.Integer.class, "是否激活", "激活时为当前默认租户", java.lang.Integer.class, null);
	
	/**
	 * 顺序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 顺序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenant,java.lang.Integer> SORT_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenant.class ,SORT, java.lang.Integer.class, "顺序", "顺序", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenant,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenant.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenant,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenant.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenant,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenant.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenant,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenant.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenant,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenant.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenant,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenant.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenant,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenant.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenant,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenant.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户对象 , 类型: org.github.foxnic.web.domain.system.Tenant
	*/
	public static final String TENANT="tenant";
	
	/**
	 * 租户对象 , 类型: org.github.foxnic.web.domain.system.Tenant
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenant,org.github.foxnic.web.domain.system.Tenant> TENANT_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenant.class ,TENANT, org.github.foxnic.web.domain.system.Tenant.class, "租户对象", "租户对象", org.github.foxnic.web.domain.system.Tenant.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , USER_ID , OWNER_TENANT_ID , VALID , ACTIVATED , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.UserTenant {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public UserTenant setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 用户ID
		 * @param userId 用户ID
		 * @return 当前对象
		*/
		public UserTenant setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 所属的租户ID
		 * @param ownerTenantId 所属的租户ID
		 * @return 当前对象
		*/
		public UserTenant setOwnerTenantId(String ownerTenantId) {
			super.change(OWNER_TENANT_ID,super.getOwnerTenantId(),ownerTenantId);
			super.setOwnerTenantId(ownerTenantId);
			return this;
		}
		
		/**
		 * 设置 是否有效
		 * @param valid 是否有效
		 * @return 当前对象
		*/
		public UserTenant setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 是否激活
		 * @param activated 是否激活
		 * @return 当前对象
		*/
		public UserTenant setActivated(Integer activated) {
			super.change(ACTIVATED,super.getActivated(),activated);
			super.setActivated(activated);
			return this;
		}
		
		/**
		 * 设置 顺序
		 * @param sort 顺序
		 * @return 当前对象
		*/
		public UserTenant setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public UserTenant setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public UserTenant setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public UserTenant setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public UserTenant setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public UserTenant setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public UserTenant setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public UserTenant setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public UserTenant setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户对象
		 * @param tenant 租户对象
		 * @return 当前对象
		*/
		public UserTenant setTenant(Tenant tenant) {
			super.change(TENANT,super.getTenant(),tenant);
			super.setTenant(tenant);
			return this;
		}
	}
}