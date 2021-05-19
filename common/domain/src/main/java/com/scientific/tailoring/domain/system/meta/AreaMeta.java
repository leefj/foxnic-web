package com.scientific.tailoring.domain.system.meta;

import com.scientific.tailoring.domain.system.Area;
import java.sql.Timestamp;



/**
 * @author 李方捷
 * @since 2021-05-17 01:05:53
 * @sign 5122728973FBBD3EB3DDA091EA7761F2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AreaMeta {
	
	/**
	 * 区域ID
	*/
	public static final String ID="id";
	
	/**
	 * 父级ID
	*/
	public static final String PARENT_ID="parentId";
	
	/**
	 * 区域名称
	*/
	public static final String NAME="name";
	
	/**
	 * 等级（深度）
	*/
	public static final String DEPTH="depth";
	
	/**
	 * 创建人id
	*/
	public static final String CREATED_BY="createdBy";
	
	/**
	 * 修改人id
	*/
	public static final String UPDATED_BY="updatedBy";
	
	/**
	 * 创建时间
	*/
	public static final String CREATE_DATE="createDate";
	
	/**
	 * 修改时间
	*/
	public static final String UPDATE_DATE="updateDate";
	
	/**
	 * 数据是否有效 , （0：无效 1：有效）
	*/
	public static final String VALID="valid";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PARENT_ID , NAME , DEPTH , CREATED_BY , UPDATED_BY , CREATE_DATE , UPDATE_DATE , VALID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.system.Area {
		
		/**
		 * 设置 区域ID
		 * @param id 区域ID
		 * @return 当前对象
		*/
		public Area setId(Integer id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
				return this;
		}
		
		/**
		 * 设置 父级ID
		 * @param parentId 父级ID
		 * @return 当前对象
		*/
		public Area setParentId(Integer parentId) {
			super.change(PARENT_ID,super.getParentId(),parentId);
			super.setParentId(parentId);
				return this;
		}
		
		/**
		 * 设置 区域名称
		 * @param name 区域名称
		 * @return 当前对象
		*/
		public Area setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
				return this;
		}
		
		/**
		 * 设置 等级（深度）
		 * @param depth 等级（深度）
		 * @return 当前对象
		*/
		public Area setDepth(Integer depth) {
			super.change(DEPTH,super.getDepth(),depth);
			super.setDepth(depth);
				return this;
		}
		
		/**
		 * 设置 创建人id
		 * @param createdBy 创建人id
		 * @return 当前对象
		*/
		public Area setCreatedBy(Long createdBy) {
			super.change(CREATED_BY,super.getCreatedBy(),createdBy);
			super.setCreatedBy(createdBy);
				return this;
		}
		
		/**
		 * 设置 修改人id
		 * @param updatedBy 修改人id
		 * @return 当前对象
		*/
		public Area setUpdatedBy(Long updatedBy) {
			super.change(UPDATED_BY,super.getUpdatedBy(),updatedBy);
			super.setUpdatedBy(updatedBy);
				return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createDate 创建时间
		 * @return 当前对象
		*/
		public Area setCreateDate(Timestamp createDate) {
			super.change(CREATE_DATE,super.getCreateDate(),createDate);
			super.setCreateDate(createDate);
				return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateDate 修改时间
		 * @return 当前对象
		*/
		public Area setUpdateDate(Timestamp updateDate) {
			super.change(UPDATE_DATE,super.getUpdateDate(),updateDate);
			super.setUpdateDate(updateDate);
				return this;
		}
		
		/**
		 * 设置 数据是否有效
		 * @param valid 数据是否有效
		 * @return 当前对象
		*/
		public Area setValid(Boolean valid) {
			super.change(VALID,super.isValid(),valid);
			super.setValid(valid);
				return this;
		}
}
}