package com.scientific.tailoring.domain.system.meta;

import com.scientific.tailoring.domain.system.DictItem;
import java.util.Date;



/**
 * @author 李方捷
 * @since 2021-05-17 01:08:24
 * @sign 919C200E0759AF5B7F2EEF237E15E532
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DictItemMeta {
	
	/**
	 * ID
	*/
	public static final String ID="id";
	
	/**
	 * 字典ID
	*/
	public static final String DICT_ID="dictId";
	
	/**
	 * 字典代码
	*/
	public static final String DICT_CODE="dictCode";
	
	/**
	 * 代码
	*/
	public static final String CODE="code";
	
	/**
	 * 标签
	*/
	public static final String LABEL="label";
	
	/**
	 * 排序
	*/
	public static final String SORT="sort";
	
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
	public static final String[] $PROPS={ ID , DICT_ID , DICT_CODE , CODE , LABEL , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.system.DictItem {
		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public DictItem setId(Integer id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
				return this;
		}
		
		/**
		 * 设置 字典ID
		 * @param dictId 字典ID
		 * @return 当前对象
		*/
		public DictItem setDictId(String dictId) {
			super.change(DICT_ID,super.getDictId(),dictId);
			super.setDictId(dictId);
				return this;
		}
		
		/**
		 * 设置 字典代码
		 * @param dictCode 字典代码
		 * @return 当前对象
		*/
		public DictItem setDictCode(String dictCode) {
			super.change(DICT_CODE,super.getDictCode(),dictCode);
			super.setDictCode(dictCode);
				return this;
		}
		
		/**
		 * 设置 代码
		 * @param code 代码
		 * @return 当前对象
		*/
		public DictItem setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
				return this;
		}
		
		/**
		 * 设置 标签
		 * @param label 标签
		 * @return 当前对象
		*/
		public DictItem setLabel(String label) {
			super.change(LABEL,super.getLabel(),label);
			super.setLabel(label);
				return this;
		}
		
		/**
		 * 设置 排序
		 * @param sort 排序
		 * @return 当前对象
		*/
		public DictItem setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
				return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public DictItem setCreateBy(Long createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
				return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public DictItem setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
				return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public DictItem setUpdateBy(Long updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
				return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public DictItem setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
				return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public DictItem setDeleted(Boolean deleted) {
			super.change(DELETED,super.isDeleted(),deleted);
			super.setDeleted(deleted);
				return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public DictItem setDeleteBy(Long deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
				return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public DictItem setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
				return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public DictItem setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
				return this;
		}
}
}