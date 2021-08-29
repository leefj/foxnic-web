package org.github.foxnic.web.domain.pcm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-28 15:45:06
 * @sign 1CA6F28658CA8671CEBB6D9C06DB57CF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CatalogAttributeMeta {
	
	/**
	 * 主键 , 类型: java.lang.Integer
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttribute,java.lang.Integer> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttribute.class ,ID, java.lang.Integer.class, "主键", "主键", java.lang.Integer.class, null);
	
	/**
	 * 存储ID , 类型: java.lang.Integer
	*/
	public static final String STORAGE_ID="storageId";
	
	/**
	 * 存储ID , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttribute,java.lang.Integer> STORAGE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttribute.class ,STORAGE_ID, java.lang.Integer.class, "存储ID", "存储ID", java.lang.Integer.class, null);
	
	/**
	 * 字段名 , 在数据表中的真实字段名 , 类型: java.lang.String
	*/
	public static final String FIELD="field";
	
	/**
	 * 字段名 , 在数据表中的真实字段名 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttribute,java.lang.String> FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttribute.class ,FIELD, java.lang.String.class, "字段名", "在数据表中的真实字段名", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttribute,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttribute.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 说明 , 类型: java.lang.String
	*/
	public static final String DETAIL="detail";
	
	/**
	 * 说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttribute,java.lang.String> DETAIL_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttribute.class ,DETAIL, java.lang.String.class, "说明", "说明", java.lang.String.class, null);
	
	/**
	 * 数据类型 , 类型: java.lang.String
	*/
	public static final String DATA_TYPE="dataType";
	
	/**
	 * 数据类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttribute,java.lang.String> DATA_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttribute.class ,DATA_TYPE, java.lang.String.class, "数据类型", "数据类型", java.lang.String.class, null);
	
	/**
	 * 数据长度 , 类型: java.lang.Integer
	*/
	public static final String LENGTH="length";
	
	/**
	 * 数据长度 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttribute,java.lang.Integer> LENGTH_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttribute.class ,LENGTH, java.lang.Integer.class, "数据长度", "数据长度", java.lang.Integer.class, null);
	
	/**
	 * 数据精度 , 类型: java.lang.Integer
	*/
	public static final String PRECISION="precision";
	
	/**
	 * 数据精度 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttribute,java.lang.Integer> PRECISION_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttribute.class ,PRECISION, java.lang.Integer.class, "数据精度", "数据精度", java.lang.Integer.class, null);
	
	/**
	 * 小数位数 , 类型: java.lang.Integer
	*/
	public static final String SCALE="scale";
	
	/**
	 * 小数位数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttribute,java.lang.Integer> SCALE_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttribute.class ,SCALE, java.lang.Integer.class, "小数位数", "小数位数", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttribute,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttribute.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttribute,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttribute.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttribute,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttribute.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttribute,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttribute.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttribute,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttribute.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttribute,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttribute.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttribute,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttribute.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttribute,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttribute.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , STORAGE_ID , FIELD , NAME , DETAIL , DATA_TYPE , LENGTH , PRECISION , SCALE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.pcm.CatalogAttribute {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CatalogAttribute setId(Integer id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 存储ID
		 * @param storageId 存储ID
		 * @return 当前对象
		*/
		public CatalogAttribute setStorageId(Integer storageId) {
			super.change(STORAGE_ID,super.getStorageId(),storageId);
			super.setStorageId(storageId);
			return this;
		}
		
		/**
		 * 设置 字段名
		 * @param field 字段名
		 * @return 当前对象
		*/
		public CatalogAttribute setField(String field) {
			super.change(FIELD,super.getField(),field);
			super.setField(field);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public CatalogAttribute setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 说明
		 * @param detail 说明
		 * @return 当前对象
		*/
		public CatalogAttribute setDetail(String detail) {
			super.change(DETAIL,super.getDetail(),detail);
			super.setDetail(detail);
			return this;
		}
		
		/**
		 * 设置 数据类型
		 * @param dataType 数据类型
		 * @return 当前对象
		*/
		public CatalogAttribute setDataType(String dataType) {
			super.change(DATA_TYPE,super.getDataType(),dataType);
			super.setDataType(dataType);
			return this;
		}
		
		/**
		 * 设置 数据长度
		 * @param length 数据长度
		 * @return 当前对象
		*/
		public CatalogAttribute setLength(Integer length) {
			super.change(LENGTH,super.getLength(),length);
			super.setLength(length);
			return this;
		}
		
		/**
		 * 设置 数据精度
		 * @param precision 数据精度
		 * @return 当前对象
		*/
		public CatalogAttribute setPrecision(Integer precision) {
			super.change(PRECISION,super.getPrecision(),precision);
			super.setPrecision(precision);
			return this;
		}
		
		/**
		 * 设置 小数位数
		 * @param scale 小数位数
		 * @return 当前对象
		*/
		public CatalogAttribute setScale(Integer scale) {
			super.change(SCALE,super.getScale(),scale);
			super.setScale(scale);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CatalogAttribute setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CatalogAttribute setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CatalogAttribute setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CatalogAttribute setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CatalogAttribute setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CatalogAttribute setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CatalogAttribute setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public CatalogAttribute setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}