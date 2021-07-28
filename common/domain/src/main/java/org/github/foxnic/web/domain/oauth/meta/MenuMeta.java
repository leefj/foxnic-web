package org.github.foxnic.web.domain.oauth.meta;

import org.github.foxnic.web.domain.oauth.Menu;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.Resourze;
import java.util.List;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-07-28 19:46:14
 * @sign DCBE371ABBE01889672F8E7C47DD6A7D
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
	 * 权限 , 权限标识
	*/
	public static final String AUTHORITY="authority";
	
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
	 * 菜单路径的资源
	*/
	public static final String PATH_RESOURCE_ID="pathResourceId";
	
	/**
	 * 路由地址
	*/
	public static final String URL="url";
	
	/**
	 * 上级ID
	*/
	public static final String PARENT_ID="parentId";
	
	/**
	 * 层级路径
	*/
	public static final String HIERARCHY="hierarchy";
	
	/**
	 * 显示顺序
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
	 * 路径资源
	*/
	public static final String PATH_RESOURCE="pathResource";
	
	/**
	 * 菜单包含的资源清单
	*/
	public static final String RESOURCES="resources";
	
	/**
	 * 上级菜单
	*/
	public static final String PARENT="parent";
	
	/**
	 * 页面路径
	*/
	public static final String PATH="path";
	
	/**
	 * 资源ID清单
	*/
	public static final String RESOURCE_IDS="resourceIds";
	
	/**
	 * 祖先名称路径 , 用斜杠隔开
	*/
	public static final String ANCESTORS_NAME_PATH="ancestorsNamePath";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BATCH_ID , AUTHORITY , HIDDEN , CSS , LABEL , TYPE , PATH_RESOURCE_ID , URL , PARENT_ID , HIERARCHY , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , PATH_RESOURCE , RESOURCES , PARENT , PATH , RESOURCE_IDS , ANCESTORS_NAME_PATH };
	
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
		 * 设置 权限
		 * @param authority 权限
		 * @return 当前对象
		*/
		public Menu setAuthority(String authority) {
			super.change(AUTHORITY,super.getAuthority(),authority);
			super.setAuthority(authority);
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
		 * 设置 菜单路径的资源
		 * @param pathResourceId 菜单路径的资源
		 * @return 当前对象
		*/
		public Menu setPathResourceId(String pathResourceId) {
			super.change(PATH_RESOURCE_ID,super.getPathResourceId(),pathResourceId);
			super.setPathResourceId(pathResourceId);
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
		 * 设置 层级路径
		 * @param hierarchy 层级路径
		 * @return 当前对象
		*/
		public Menu setHierarchy(String hierarchy) {
			super.change(HIERARCHY,super.getHierarchy(),hierarchy);
			super.setHierarchy(hierarchy);
			return this;
		}
		
		/**
		 * 设置 显示顺序
		 * @param sort 显示顺序
		 * @return 当前对象
		*/
		public Menu setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
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
		
		/**
		 * 设置 路径资源
		 * @param pathResource 路径资源
		 * @return 当前对象
		*/
		public Menu setPathResource(Resourze pathResource) {
			super.change(PATH_RESOURCE,super.getPathResource(),pathResource);
			super.setPathResource(pathResource);
			return this;
		}
		
		/**
		 * 设置 菜单包含的资源清单
		 * @param resources 菜单包含的资源清单
		 * @return 当前对象
		*/
		public Menu setResources(List<Resourze> resources) {
			super.change(RESOURCES,super.getResources(),resources);
			super.setResources(resources);
			return this;
		}
		
		/**
		 * 设置 上级菜单
		 * @param parent 上级菜单
		 * @return 当前对象
		*/
		public Menu setParent(Menu parent) {
			super.change(PARENT,super.getParent(),parent);
			super.setParent(parent);
			return this;
		}
		
		/**
		 * 设置 页面路径
		 * @param path 页面路径
		 * @return 当前对象
		*/
		public Menu setPath(String path) {
			super.change(PATH,super.getPath(),path);
			super.setPath(path);
			return this;
		}
		
		/**
		 * 设置 资源ID清单
		 * @param resourceIds 资源ID清单
		 * @return 当前对象
		*/
		public Menu setResourceIds(List<String> resourceIds) {
			super.change(RESOURCE_IDS,super.getResourceIds(),resourceIds);
			super.setResourceIds(resourceIds);
			return this;
		}
		
		/**
		 * 设置 祖先名称路径
		 * @param ancestorsNamePath 祖先名称路径
		 * @return 当前对象
		*/
		public Menu setAncestorsNamePath(String ancestorsNamePath) {
			super.change(ANCESTORS_NAME_PATH,super.getAncestorsNamePath(),ancestorsNamePath);
			super.setAncestorsNamePath(ancestorsNamePath);
			return this;
		}
	}
}