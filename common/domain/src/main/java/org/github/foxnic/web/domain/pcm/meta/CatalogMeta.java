package org.github.foxnic.web.domain.pcm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.pcm.Catalog;
import java.util.Date;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import java.util.List;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-05 15:25:29
 * @sign 5EAEFC868DC72ED8B851F49646EE7541
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CatalogMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.Catalog,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.Catalog.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 代码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 代码 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.Catalog,java.lang.String> CODE_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.Catalog.class ,CODE, java.lang.String.class, "代码", "代码", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.Catalog,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.Catalog.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 上级ID , 类型: java.lang.String
	*/
	public static final String PARENT_ID="parentId";
	
	/**
	 * 上级ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.Catalog,java.lang.String> PARENT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.Catalog.class ,PARENT_ID, java.lang.String.class, "上级ID", "上级ID", java.lang.String.class, null);
	
	/**
	 * 顺序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 顺序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.Catalog,java.lang.Integer> SORT_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.Catalog.class ,SORT, java.lang.Integer.class, "顺序", "顺序", java.lang.Integer.class, null);
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final String VALID="valid";
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.Catalog,java.lang.Integer> VALID_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.Catalog.class ,VALID, java.lang.Integer.class, "是否有效", "是否有效", java.lang.Integer.class, null);
	
	/**
	 * 层级路径 , 类型: java.lang.String
	*/
	public static final String HIERARCHY="hierarchy";
	
	/**
	 * 层级路径 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.Catalog,java.lang.String> HIERARCHY_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.Catalog.class ,HIERARCHY, java.lang.String.class, "层级路径", "层级路径", java.lang.String.class, null);
	
	/**
	 * 存储表 , 类型: java.lang.String
	*/
	public static final String DATA_TABLE="dataTable";
	
	/**
	 * 存储表 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.Catalog,java.lang.String> DATA_TABLE_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.Catalog.class ,DATA_TABLE, java.lang.String.class, "存储表", "存储表", java.lang.String.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.Catalog,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.Catalog.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.Catalog,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.Catalog.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.Catalog,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.Catalog.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.Catalog,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.Catalog.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.Catalog,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.Catalog.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.Catalog,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.Catalog.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.Catalog,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.Catalog.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.Catalog,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.Catalog.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.Catalog,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.Catalog.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 当前有效的属性清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.pcm.CatalogAttribute
	*/
	public static final String ATTRIBUTES="attributes";
	
	/**
	 * 当前有效的属性清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.pcm.CatalogAttribute
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.Catalog,org.github.foxnic.web.domain.pcm.CatalogAttribute> ATTRIBUTES_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.Catalog.class ,ATTRIBUTES, java.util.List.class, "当前有效的属性清单", "当前有效的属性清单", org.github.foxnic.web.domain.pcm.CatalogAttribute.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , NAME , PARENT_ID , SORT , VALID , HIERARCHY , DATA_TABLE , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , ATTRIBUTES };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.pcm.Catalog {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Catalog setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 代码
		 * @param code 代码
		 * @return 当前对象
		*/
		public Catalog setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public Catalog setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 上级ID
		 * @param parentId 上级ID
		 * @return 当前对象
		*/
		public Catalog setParentId(String parentId) {
			super.change(PARENT_ID,super.getParentId(),parentId);
			super.setParentId(parentId);
			return this;
		}
		
		/**
		 * 设置 顺序
		 * @param sort 顺序
		 * @return 当前对象
		*/
		public Catalog setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 是否有效
		 * @param valid 是否有效
		 * @return 当前对象
		*/
		public Catalog setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 层级路径
		 * @param hierarchy 层级路径
		 * @return 当前对象
		*/
		public Catalog setHierarchy(String hierarchy) {
			super.change(HIERARCHY,super.getHierarchy(),hierarchy);
			super.setHierarchy(hierarchy);
			return this;
		}
		
		/**
		 * 设置 存储表
		 * @param dataTable 存储表
		 * @return 当前对象
		*/
		public Catalog setDataTable(String dataTable) {
			super.change(DATA_TABLE,super.getDataTable(),dataTable);
			super.setDataTable(dataTable);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public Catalog setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Catalog setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Catalog setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Catalog setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Catalog setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Catalog setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Catalog setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Catalog setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Catalog setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 当前有效的属性清单
		 * @param attributes 当前有效的属性清单
		 * @return 当前对象
		*/
		public Catalog setAttributes(List<CatalogAttribute> attributes) {
			super.change(ATTRIBUTES,super.getAttributes(),attributes);
			super.setAttributes(attributes);
			return this;
		}
	}
}