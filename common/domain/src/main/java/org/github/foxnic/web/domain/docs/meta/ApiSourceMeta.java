package org.github.foxnic.web.domain.docs.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.docs.ApiSource;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-25 16:22:59
 * @sign 5F09DC83B848B0926C46186D5C8EEC08
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ApiSourceMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.docs.ApiSource,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.docs.ApiSource.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.docs.ApiSource,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.docs.ApiSource.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 接口地址 , 类型: java.lang.String
	*/
	public static final String API_URL="apiUrl";
	
	/**
	 * 接口地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.docs.ApiSource,java.lang.String> API_URL_PROP = new BeanProperty(org.github.foxnic.web.domain.docs.ApiSource.class ,API_URL, java.lang.String.class, "接口地址", "接口地址", java.lang.String.class, null);
	
	/**
	 * 账户 , 类型: java.lang.String
	*/
	public static final String USER_NAME="userName";
	
	/**
	 * 账户 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.docs.ApiSource,java.lang.String> USER_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.docs.ApiSource.class ,USER_NAME, java.lang.String.class, "账户", "账户", java.lang.String.class, null);
	
	/**
	 * 密码 , 类型: java.lang.String
	*/
	public static final String PASSWORD="password";
	
	/**
	 * 密码 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.docs.ApiSource,java.lang.String> PASSWORD_PROP = new BeanProperty(org.github.foxnic.web.domain.docs.ApiSource.class ,PASSWORD, java.lang.String.class, "密码", "密码", java.lang.String.class, null);
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final String VALID="valid";
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.docs.ApiSource,java.lang.Integer> VALID_PROP = new BeanProperty(org.github.foxnic.web.domain.docs.ApiSource.class ,VALID, java.lang.Integer.class, "是否有效", "是否有效", java.lang.Integer.class, null);
	
	/**
	 * API数据 , 类型: java.lang.String
	*/
	public static final String API_DATA="apiData";
	
	/**
	 * API数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.docs.ApiSource,java.lang.String> API_DATA_PROP = new BeanProperty(org.github.foxnic.web.domain.docs.ApiSource.class ,API_DATA, java.lang.String.class, "API数据", "API数据", java.lang.String.class, null);
	
	/**
	 * 目录结构 , 类型: java.lang.String
	*/
	public static final String NAV_DIR="navDir";
	
	/**
	 * 目录结构 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.docs.ApiSource,java.lang.String> NAV_DIR_PROP = new BeanProperty(org.github.foxnic.web.domain.docs.ApiSource.class ,NAV_DIR, java.lang.String.class, "目录结构", "目录结构", java.lang.String.class, null);
	
	/**
	 * 取数时间 , 类型: java.util.Date
	*/
	public static final String FETCH_TIME="fetchTime";
	
	/**
	 * 取数时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.docs.ApiSource,java.util.Date> FETCH_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.docs.ApiSource.class ,FETCH_TIME, java.util.Date.class, "取数时间", "取数时间", java.util.Date.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.docs.ApiSource,java.lang.String> NOTES_PROP = new BeanProperty(org.github.foxnic.web.domain.docs.ApiSource.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.docs.ApiSource,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.docs.ApiSource.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.docs.ApiSource,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.docs.ApiSource.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.docs.ApiSource,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.docs.ApiSource.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.docs.ApiSource,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.docs.ApiSource.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.docs.ApiSource,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.docs.ApiSource.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.docs.ApiSource,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.docs.ApiSource.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.docs.ApiSource,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.docs.ApiSource.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.docs.ApiSource,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.docs.ApiSource.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , API_URL , USER_NAME , PASSWORD , VALID , API_DATA , NAV_DIR , FETCH_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.docs.ApiSource {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ApiSource setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public ApiSource setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 接口地址
		 * @param apiUrl 接口地址
		 * @return 当前对象
		*/
		public ApiSource setApiUrl(String apiUrl) {
			super.change(API_URL,super.getApiUrl(),apiUrl);
			super.setApiUrl(apiUrl);
			return this;
		}
		
		/**
		 * 设置 账户
		 * @param userName 账户
		 * @return 当前对象
		*/
		public ApiSource setUserName(String userName) {
			super.change(USER_NAME,super.getUserName(),userName);
			super.setUserName(userName);
			return this;
		}
		
		/**
		 * 设置 密码
		 * @param password 密码
		 * @return 当前对象
		*/
		public ApiSource setPassword(String password) {
			super.change(PASSWORD,super.getPassword(),password);
			super.setPassword(password);
			return this;
		}
		
		/**
		 * 设置 是否有效
		 * @param valid 是否有效
		 * @return 当前对象
		*/
		public ApiSource setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 API数据
		 * @param apiData API数据
		 * @return 当前对象
		*/
		public ApiSource setApiData(String apiData) {
			super.change(API_DATA,super.getApiData(),apiData);
			super.setApiData(apiData);
			return this;
		}
		
		/**
		 * 设置 目录结构
		 * @param navDir 目录结构
		 * @return 当前对象
		*/
		public ApiSource setNavDir(String navDir) {
			super.change(NAV_DIR,super.getNavDir(),navDir);
			super.setNavDir(navDir);
			return this;
		}
		
		/**
		 * 设置 取数时间
		 * @param fetchTime 取数时间
		 * @return 当前对象
		*/
		public ApiSource setFetchTime(Date fetchTime) {
			super.change(FETCH_TIME,super.getFetchTime(),fetchTime);
			super.setFetchTime(fetchTime);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public ApiSource setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ApiSource setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ApiSource setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ApiSource setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ApiSource setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ApiSource setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ApiSource setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ApiSource setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public ApiSource setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public ApiSource clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public ApiSource duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setApiData(this.getApiData());
			inst.setNavDir(this.getNavDir());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setUserName(this.getUserName());
			inst.setVersion(this.getVersion());
			inst.setValid(this.getValid());
			inst.setPassword(this.getPassword());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setApiUrl(this.getApiUrl());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setFetchTime(this.getFetchTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.clearModifies();
			return inst;
		}

	}
}