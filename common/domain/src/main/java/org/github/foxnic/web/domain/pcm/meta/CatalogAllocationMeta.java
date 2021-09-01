package org.github.foxnic.web.domain.pcm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.pcm.CatalogAllocation;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-01 21:44:30
 * @sign 35A00AC6CAB108A1448FD61C289F7B8F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CatalogAllocationMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAllocation,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAllocation.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 分类ID , 类型: java.lang.String
	*/
	public static final String CATALOG_ID="catalogId";
	
	/**
	 * 分类ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAllocation,java.lang.String> CATALOG_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAllocation.class ,CATALOG_ID, java.lang.String.class, "分类ID", "分类ID", java.lang.String.class, null);
	
	/**
	 * 属性ID , 类型: java.lang.String
	*/
	public static final String ATTRIBUTE_ID="attributeId";
	
	/**
	 * 属性ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAllocation,java.lang.String> ATTRIBUTE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAllocation.class ,ATTRIBUTE_ID, java.lang.String.class, "属性ID", "属性ID", java.lang.String.class, null);
	
	/**
	 * 字段名 , 数据库字段名 , 类型: java.lang.String
	*/
	public static final String COLUMN="column";
	
	/**
	 * 字段名 , 数据库字段名 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAllocation,java.lang.String> COLUMN_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAllocation.class ,COLUMN, java.lang.String.class, "字段名", "数据库字段名", java.lang.String.class, null);
	
	/**
	 * 是否分配 , 或分配是否有效 , 类型: java.lang.Integer
	*/
	public static final String ALLOTTED="allotted";
	
	/**
	 * 是否分配 , 或分配是否有效 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAllocation,java.lang.Integer> ALLOTTED_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAllocation.class ,ALLOTTED, java.lang.Integer.class, "是否分配", "或分配是否有效", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAllocation,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAllocation.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAllocation,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAllocation.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAllocation,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAllocation.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAllocation,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAllocation.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAllocation,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAllocation.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAllocation,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAllocation.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAllocation,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAllocation.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAllocation,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAllocation.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CATALOG_ID , ATTRIBUTE_ID , COLUMN , ALLOTTED , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.pcm.CatalogAllocation {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CatalogAllocation setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 分类ID
		 * @param catalogId 分类ID
		 * @return 当前对象
		*/
		public CatalogAllocation setCatalogId(String catalogId) {
			super.change(CATALOG_ID,super.getCatalogId(),catalogId);
			super.setCatalogId(catalogId);
			return this;
		}
		
		/**
		 * 设置 属性ID
		 * @param attributeId 属性ID
		 * @return 当前对象
		*/
		public CatalogAllocation setAttributeId(String attributeId) {
			super.change(ATTRIBUTE_ID,super.getAttributeId(),attributeId);
			super.setAttributeId(attributeId);
			return this;
		}
		
		/**
		 * 设置 字段名
		 * @param column 字段名
		 * @return 当前对象
		*/
		public CatalogAllocation setColumn(String column) {
			super.change(COLUMN,super.getColumn(),column);
			super.setColumn(column);
			return this;
		}
		
		/**
		 * 设置 是否分配
		 * @param allotted 是否分配
		 * @return 当前对象
		*/
		public CatalogAllocation setAllotted(Integer allotted) {
			super.change(ALLOTTED,super.getAllotted(),allotted);
			super.setAllotted(allotted);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CatalogAllocation setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CatalogAllocation setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CatalogAllocation setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CatalogAllocation setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CatalogAllocation setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CatalogAllocation setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CatalogAllocation setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public CatalogAllocation setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}