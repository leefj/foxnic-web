package org.github.foxnic.web.domain.system.meta;

import org.github.foxnic.web.domain.system.DbCache;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-18 21:47:50
 * @sign 9E3EFC1C2B23901A495828F3F4C3D25C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DbCacheMeta {
	
	/**
	 * ID
	*/
	public static final String ID="id";
	
	/**
	 * 数据分类
	*/
	public static final String CATALOG="catalog";
	
	/**
	 * 数据分区
	*/
	public static final String AREA="area";
	
	/**
	 * 账户ID
	*/
	public static final String OWNER_TYPE="ownerType";
	
	/**
	 * 会话ID
	*/
	public static final String OWNER_ID="ownerId";
	
	/**
	 * 数据
	*/
	public static final String VALUE="value";
	
	/**
	 * 过期时间
	*/
	public static final String EXPIRE_TIME="expireTime";
	
	/**
	 * 创建人ID
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建时间
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 修改人ID
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改时间
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 是否已删除
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 删除人ID
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除时间
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 数据版本号
	*/
	public static final String VERSION="version";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CATALOG , AREA , OWNER_TYPE , OWNER_ID , VALUE , EXPIRE_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.DbCache {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public DbCache setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 数据分类
		 * @param catalog 数据分类
		 * @return 当前对象
		*/
		public DbCache setCatalog(String catalog) {
			super.change(CATALOG,super.getCatalog(),catalog);
			super.setCatalog(catalog);
			return this;
		}
		
		/**
		 * 设置 数据分区
		 * @param area 数据分区
		 * @return 当前对象
		*/
		public DbCache setArea(String area) {
			super.change(AREA,super.getArea(),area);
			super.setArea(area);
			return this;
		}
		
		/**
		 * 设置 账户ID
		 * @param ownerType 账户ID
		 * @return 当前对象
		*/
		public DbCache setOwnerType(String ownerType) {
			super.change(OWNER_TYPE,super.getOwnerType(),ownerType);
			super.setOwnerType(ownerType);
			return this;
		}
		
		/**
		 * 设置 会话ID
		 * @param ownerId 会话ID
		 * @return 当前对象
		*/
		public DbCache setOwnerId(String ownerId) {
			super.change(OWNER_ID,super.getOwnerId(),ownerId);
			super.setOwnerId(ownerId);
			return this;
		}
		
		/**
		 * 设置 数据
		 * @param value 数据
		 * @return 当前对象
		*/
		public DbCache setValue(String value) {
			super.change(VALUE,super.getValue(),value);
			super.setValue(value);
			return this;
		}
		
		/**
		 * 设置 过期时间
		 * @param expireTime 过期时间
		 * @return 当前对象
		*/
		public DbCache setExpireTime(Date expireTime) {
			super.change(EXPIRE_TIME,super.getExpireTime(),expireTime);
			super.setExpireTime(expireTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public DbCache setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public DbCache setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public DbCache setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public DbCache setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public DbCache setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public DbCache setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public DbCache setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public DbCache setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}