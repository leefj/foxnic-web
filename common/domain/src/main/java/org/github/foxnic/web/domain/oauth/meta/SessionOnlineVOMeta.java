package org.github.foxnic.web.domain.oauth.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.oauth.SessionOnlineVO;
import java.util.List;
import org.github.foxnic.web.domain.oauth.SessionOnline;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.User;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-07-25 14:02:27
 * @sign 3AE9BF86BDA18A45915A3C4E096AD454
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SessionOnlineVOMeta extends SessionOnlineMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,ID, java.lang.String.class, "ID", "ID", java.lang.String.class, null);
	
	/**
	 * 会话ID , 类型: java.lang.String
	*/
	public static final String SESSION_ID="sessionId";
	
	/**
	 * 会话ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.String> SESSION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,SESSION_ID, java.lang.String.class, "会话ID", "会话ID", java.lang.String.class, null);
	
	/**
	 * 账户ID , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 账户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.String> USER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,USER_ID, java.lang.String.class, "账户ID", "账户ID", java.lang.String.class, null);
	
	/**
	 * 登录时间 , 类型: java.util.Date
	*/
	public static final String LOGIN_TIME="loginTime";
	
	/**
	 * 登录时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.util.Date> LOGIN_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,LOGIN_TIME, java.util.Date.class, "登录时间", "登录时间", java.util.Date.class, null);
	
	/**
	 * 最近一次交互时间 , 类型: java.util.Date
	*/
	public static final String INTERACT_TIME="interactTime";
	
	/**
	 * 最近一次交互时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.util.Date> INTERACT_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,INTERACT_TIME, java.util.Date.class, "最近一次交互时间", "最近一次交互时间", java.util.Date.class, null);
	
	/**
	 * 最后访问的地址 , 类型: java.lang.String
	*/
	public static final String INTERACT_URL="interactUrl";
	
	/**
	 * 最后访问的地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.String> INTERACT_URL_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,INTERACT_URL, java.lang.String.class, "最后访问的地址", "最后访问的地址", java.lang.String.class, null);
	
	/**
	 * 登出时间 , 类型: java.util.Date
	*/
	public static final String LOGOUT_TIME="logoutTime";
	
	/**
	 * 登出时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.util.Date> LOGOUT_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,LOGOUT_TIME, java.util.Date.class, "登出时间", "登出时间", java.util.Date.class, null);
	
	/**
	 * 会话时长 , 单位秒 , 类型: java.lang.Integer
	*/
	public static final String SESSION_TIME="sessionTime";
	
	/**
	 * 会话时长 , 单位秒 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.Integer> SESSION_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,SESSION_TIME, java.lang.Integer.class, "会话时长", "单位秒", java.lang.Integer.class, null);
	
	/**
	 * 是否在线 , 类型: java.lang.Integer
	*/
	public static final String ONLINE="online";
	
	/**
	 * 是否在线 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.Integer> ONLINE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,ONLINE, java.lang.Integer.class, "是否在线", "是否在线", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 主机ID , 类型: java.lang.String
	*/
	public static final String HOST_ID="hostId";
	
	/**
	 * 主机ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.String> HOST_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,HOST_ID, java.lang.String.class, "主机ID", "主机ID", java.lang.String.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 节点实例ID , 类型: java.lang.String
	*/
	public static final String NODE_ID="nodeId";
	
	/**
	 * 节点实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.String> NODE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,NODE_ID, java.lang.String.class, "节点实例ID", "节点实例ID", java.lang.String.class, null);
	
	/**
	 * accessToken , 类型: java.lang.String
	*/
	public static final String ACCESS_TOKEN="accessToken";
	
	/**
	 * accessToken , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.String> ACCESS_TOKEN_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,ACCESS_TOKEN, java.lang.String.class, "accessToken", "accessToken", java.lang.String.class, null);
	
	/**
	 * refreshToken , 类型: java.lang.String
	*/
	public static final String REFRESH_TOKEN="refreshToken";
	
	/**
	 * refreshToken , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,java.lang.String> REFRESH_TOKEN_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,REFRESH_TOKEN, java.lang.String.class, "refreshToken", "refreshToken", java.lang.String.class, null);
	
	/**
	 * 账户 , 类型: org.github.foxnic.web.domain.oauth.User
	*/
	public static final String USER="user";
	
	/**
	 * 账户 , 类型: org.github.foxnic.web.domain.oauth.User
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnlineVO,org.github.foxnic.web.domain.oauth.User> USER_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnlineVO.class ,USER, org.github.foxnic.web.domain.oauth.User.class, "账户", "", org.github.foxnic.web.domain.oauth.User.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , SESSION_ID , USER_ID , LOGIN_TIME , INTERACT_TIME , INTERACT_URL , LOGOUT_TIME , SESSION_TIME , ONLINE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , HOST_ID , VERSION , NODE_ID , ACCESS_TOKEN , REFRESH_TOKEN , USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.oauth.SessionOnlineVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public SessionOnlineVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public SessionOnlineVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public SessionOnlineVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public SessionOnlineVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public SessionOnlineVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public SessionOnlineVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public SessionOnlineVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public SessionOnlineVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public SessionOnlineVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public SessionOnline setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 会话ID
		 * @param sessionId 会话ID
		 * @return 当前对象
		*/
		public SessionOnline setSessionId(String sessionId) {
			super.change(SESSION_ID,super.getSessionId(),sessionId);
			super.setSessionId(sessionId);
			return this;
		}
		
		/**
		 * 设置 账户ID
		 * @param userId 账户ID
		 * @return 当前对象
		*/
		public SessionOnline setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 登录时间
		 * @param loginTime 登录时间
		 * @return 当前对象
		*/
		public SessionOnline setLoginTime(Date loginTime) {
			super.change(LOGIN_TIME,super.getLoginTime(),loginTime);
			super.setLoginTime(loginTime);
			return this;
		}
		
		/**
		 * 设置 最近一次交互时间
		 * @param interactTime 最近一次交互时间
		 * @return 当前对象
		*/
		public SessionOnline setInteractTime(Date interactTime) {
			super.change(INTERACT_TIME,super.getInteractTime(),interactTime);
			super.setInteractTime(interactTime);
			return this;
		}
		
		/**
		 * 设置 最后访问的地址
		 * @param interactUrl 最后访问的地址
		 * @return 当前对象
		*/
		public SessionOnline setInteractUrl(String interactUrl) {
			super.change(INTERACT_URL,super.getInteractUrl(),interactUrl);
			super.setInteractUrl(interactUrl);
			return this;
		}
		
		/**
		 * 设置 登出时间
		 * @param logoutTime 登出时间
		 * @return 当前对象
		*/
		public SessionOnline setLogoutTime(Date logoutTime) {
			super.change(LOGOUT_TIME,super.getLogoutTime(),logoutTime);
			super.setLogoutTime(logoutTime);
			return this;
		}
		
		/**
		 * 设置 会话时长
		 * @param sessionTime 会话时长
		 * @return 当前对象
		*/
		public SessionOnline setSessionTime(Integer sessionTime) {
			super.change(SESSION_TIME,super.getSessionTime(),sessionTime);
			super.setSessionTime(sessionTime);
			return this;
		}
		
		/**
		 * 设置 是否在线
		 * @param online 是否在线
		 * @return 当前对象
		*/
		public SessionOnline setOnline(Integer online) {
			super.change(ONLINE,super.getOnline(),online);
			super.setOnline(online);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public SessionOnline setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public SessionOnline setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public SessionOnline setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public SessionOnline setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public SessionOnline setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public SessionOnline setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public SessionOnline setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 主机ID
		 * @param hostId 主机ID
		 * @return 当前对象
		*/
		public SessionOnline setHostId(String hostId) {
			super.change(HOST_ID,super.getHostId(),hostId);
			super.setHostId(hostId);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public SessionOnline setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 节点实例ID
		 * @param nodeId 节点实例ID
		 * @return 当前对象
		*/
		public SessionOnline setNodeId(String nodeId) {
			super.change(NODE_ID,super.getNodeId(),nodeId);
			super.setNodeId(nodeId);
			return this;
		}
		
		/**
		 * 设置 accessToken
		 * @param accessToken accessToken
		 * @return 当前对象
		*/
		public SessionOnline setAccessToken(String accessToken) {
			super.change(ACCESS_TOKEN,super.getAccessToken(),accessToken);
			super.setAccessToken(accessToken);
			return this;
		}
		
		/**
		 * 设置 refreshToken
		 * @param refreshToken refreshToken
		 * @return 当前对象
		*/
		public SessionOnline setRefreshToken(String refreshToken) {
			super.change(REFRESH_TOKEN,super.getRefreshToken(),refreshToken);
			super.setRefreshToken(refreshToken);
			return this;
		}
		
		/**
		 * 设置 账户
		 * @param user 账户
		 * @return 当前对象
		*/
		public SessionOnline setUser(User user) {
			super.change(USER,super.getUser(),user);
			super.setUser(user);
			return this;
		}
	}
}