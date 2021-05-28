package org.github.foxnic.web.domain.oauth.meta;

import org.github.foxnic.web.domain.oauth.Menu;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-28 15:32:38
 * @sign D8446130ABCD72590077F41DBCBB6A33
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MenuMeta {
	
	/**
	 * ID
	*/
	public static final String ID="id";
	
	/**
	 * 批次号 , 自动生成时的批次号
	*/
	public static final String BATCH_ID="batchId";
	
	/**
	 * 图标
	*/
	public static final String ICON="icon";
	
	/**
	 * 是否隐藏
	*/
	public static final String HIDDEN="hidden";
	
	/**
	 * 样式
	*/
	public static final String CSS="css";
	
	/**
	 * 标签
	*/
	public static final String LABEL="label";
	
	/**
	 * 菜单类型
	*/
	public static final String TYPE="type";
	
	/**
	 * 模版路径
	*/
	public static final String PATH="path";
	
	/**
	 * 路由地址
	*/
	public static final String URL="url";
	
	/**
	 * 上级ID
	*/
	public static final String PARENT_ID="parentId";
	
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
	public static final String[] $PROPS={ ID , BATCH_ID , ICON , HIDDEN , CSS , LABEL , TYPE , PATH , URL , PARENT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.oauth.Menu {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public Menu setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 批次号
		 * @param batchId 批次号
		 * @return 当前对象
		*/
		public Menu setBatchId(String batchId) {
			super.change(BATCH_ID,super.getBatchId(),batchId);
			super.setBatchId(batchId);
			return this;
		}
		
		/**
		 * 设置 图标
		 * @param icon 图标
		 * @return 当前对象
		*/
		public Menu setIcon(String icon) {
			super.change(ICON,super.getIcon(),icon);
			super.setIcon(icon);
			return this;
		}
		
		/**
		 * 设置 是否隐藏
		 * @param hidden 是否隐藏
		 * @return 当前对象
		*/
		public Menu setHidden(Integer hidden) {
			super.change(HIDDEN,super.getHidden(),hidden);
			super.setHidden(hidden);
			return this;
		}
		
		/**
		 * 设置 样式
		 * @param css 样式
		 * @return 当前对象
		*/
		public Menu setCss(String css) {
			super.change(CSS,super.getCss(),css);
			super.setCss(css);
			return this;
		}
		
		/**
		 * 设置 标签
		 * @param label 标签
		 * @return 当前对象
		*/
		public Menu setLabel(String label) {
			super.change(LABEL,super.getLabel(),label);
			super.setLabel(label);
			return this;
		}
		
		/**
		 * 设置 菜单类型
		 * @param type 菜单类型
		 * @return 当前对象
		*/
		public Menu setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 模版路径
		 * @param path 模版路径
		 * @return 当前对象
		*/
		public Menu setPath(String path) {
			super.change(PATH,super.getPath(),path);
			super.setPath(path);
			return this;
		}
		
		/**
		 * 设置 路由地址
		 * @param url 路由地址
		 * @return 当前对象
		*/
		public Menu setUrl(String url) {
			super.change(URL,super.getUrl(),url);
			super.setUrl(url);
			return this;
		}
		
		/**
		 * 设置 上级ID
		 * @param parentId 上级ID
		 * @return 当前对象
		*/
		public Menu setParentId(String parentId) {
			super.change(PARENT_ID,super.getParentId(),parentId);
			super.setParentId(parentId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Menu setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Menu setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Menu setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Menu setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Menu setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Menu setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Menu setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Menu setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}