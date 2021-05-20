package org.github.foxnic.web.domain.system.meta;

import org.github.foxnic.web.domain.system.Lang;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-20 04:34:14
 * @sign FC78F8F8135E306AEFE5E7CE54407725
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class LangMeta {
	
	/**
	 * 编码键
	*/
	public static final String CODE="code";
	
	/**
	 * 默认
	*/
	public static final String DEFAULTS="defaults";
	
	/**
	 * 简体中文(大陆)
	*/
	public static final String ZH_CH="zhCh";
	
	/**
	 * 繁体中文(台湾)
	*/
	public static final String ZH_TW="zhTw";
	
	/**
	 * 英文美国
	*/
	public static final String EN_US="enUs";
	
	/**
	 * 英文英国
	*/
	public static final String EN_UK="enUk";
	
	/**
	 * 混淆专用
	*/
	public static final String CONFUSE="confuse";
	
	/**
	 * 是否有效
	*/
	public static final String VALID="valid";
	
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
	public static final String[] $PROPS={ CODE , DEFAULTS , ZH_CH , ZH_TW , EN_US , EN_UK , CONFUSE , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.Lang {
		
		/**
		 * 设置 编码键
		 * @param code 编码键
		 * @return 当前对象
		*/
		public Lang setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 默认
		 * @param defaults 默认
		 * @return 当前对象
		*/
		public Lang setDefaults(String defaults) {
			super.change(DEFAULTS,super.getDefaults(),defaults);
			super.setDefaults(defaults);
			return this;
		}
		
		/**
		 * 设置 简体中文(大陆)
		 * @param zhCh 简体中文(大陆)
		 * @return 当前对象
		*/
		public Lang setZhCh(String zhCh) {
			super.change(ZH_CH,super.getZhCh(),zhCh);
			super.setZhCh(zhCh);
			return this;
		}
		
		/**
		 * 设置 繁体中文(台湾)
		 * @param zhTw 繁体中文(台湾)
		 * @return 当前对象
		*/
		public Lang setZhTw(String zhTw) {
			super.change(ZH_TW,super.getZhTw(),zhTw);
			super.setZhTw(zhTw);
			return this;
		}
		
		/**
		 * 设置 英文美国
		 * @param enUs 英文美国
		 * @return 当前对象
		*/
		public Lang setEnUs(String enUs) {
			super.change(EN_US,super.getEnUs(),enUs);
			super.setEnUs(enUs);
			return this;
		}
		
		/**
		 * 设置 英文英国
		 * @param enUk 英文英国
		 * @return 当前对象
		*/
		public Lang setEnUk(String enUk) {
			super.change(EN_UK,super.getEnUk(),enUk);
			super.setEnUk(enUk);
			return this;
		}
		
		/**
		 * 设置 混淆专用
		 * @param confuse 混淆专用
		 * @return 当前对象
		*/
		public Lang setConfuse(String confuse) {
			super.change(CONFUSE,super.getConfuse(),confuse);
			super.setConfuse(confuse);
			return this;
		}
		
		/**
		 * 设置 是否有效
		 * @param valid 是否有效
		 * @return 当前对象
		*/
		public Lang setValid(Boolean valid) {
			super.change(VALID,super.isValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Lang setCreateBy(Long createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Lang setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Lang setUpdateBy(Long updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Lang setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Lang setDeleted(Boolean deleted) {
			super.change(DELETED,super.isDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Lang setDeleteBy(Long deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Lang setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Lang setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
}
}