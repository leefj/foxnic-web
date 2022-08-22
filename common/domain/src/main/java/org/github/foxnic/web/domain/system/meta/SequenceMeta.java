package org.github.foxnic.web.domain.system.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.system.Sequence;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-22 09:59:28
 * @sign C53230327A370931738A2F89D651168E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SequenceMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String PK="pk";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Sequence,java.lang.String> PK_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Sequence.class ,PK, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 序列ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 序列ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Sequence,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Sequence.class ,ID, java.lang.String.class, "序列ID", "序列ID", java.lang.String.class, null);
	
	/**
	 * 序列名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 序列名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Sequence,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Sequence.class ,NAME, java.lang.String.class, "序列名称", "序列名称", java.lang.String.class, null);
	
	/**
	 * 编码长度 , 类型: java.lang.Integer
	*/
	public static final String LENGTH="length";
	
	/**
	 * 编码长度 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Sequence,java.lang.Integer> LENGTH_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Sequence.class ,LENGTH, java.lang.Integer.class, "编码长度", "编码长度", java.lang.Integer.class, null);
	
	/**
	 * 编码分类 , 类型: java.lang.String
	*/
	public static final String CATALOG="catalog";
	
	/**
	 * 编码分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Sequence,java.lang.String> CATALOG_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Sequence.class ,CATALOG, java.lang.String.class, "编码分类", "编码分类", java.lang.String.class, null);
	
	/**
	 * 当前数值 , 类型: java.lang.Long
	*/
	public static final String VALUE="value";
	
	/**
	 * 当前数值 , 类型: java.lang.Long
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Sequence,java.lang.Long> VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Sequence.class ,VALUE, java.lang.Long.class, "当前数值", "当前数值", java.lang.Long.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String MEMO="memo";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Sequence,java.lang.String> MEMO_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Sequence.class ,MEMO, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 编码类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 编码类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Sequence,java.lang.String> TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Sequence.class ,TYPE, java.lang.String.class, "编码类型", "编码类型", java.lang.String.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Sequence,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Sequence.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 每次取数的个数 , 类型: java.lang.Integer
	*/
	public static final String FETCH_SIZE="fetchSize";
	
	/**
	 * 每次取数的个数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Sequence,java.lang.Integer> FETCH_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Sequence.class ,FETCH_SIZE, java.lang.Integer.class, "每次取数的个数", "每次取数的个数", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PK , ID , NAME , LENGTH , CATALOG , VALUE , MEMO , TYPE , TENANT_ID , FETCH_SIZE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.Sequence {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param pk 主键
		 * @return 当前对象
		*/
		public Sequence setPk(String pk) {
			super.change(PK,super.getPk(),pk);
			super.setPk(pk);
			return this;
		}
		
		/**
		 * 设置 序列ID
		 * @param id 序列ID
		 * @return 当前对象
		*/
		public Sequence setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 序列名称
		 * @param name 序列名称
		 * @return 当前对象
		*/
		public Sequence setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 编码长度
		 * @param length 编码长度
		 * @return 当前对象
		*/
		public Sequence setLength(Integer length) {
			super.change(LENGTH,super.getLength(),length);
			super.setLength(length);
			return this;
		}
		
		/**
		 * 设置 编码分类
		 * @param catalog 编码分类
		 * @return 当前对象
		*/
		public Sequence setCatalog(String catalog) {
			super.change(CATALOG,super.getCatalog(),catalog);
			super.setCatalog(catalog);
			return this;
		}
		
		/**
		 * 设置 当前数值
		 * @param value 当前数值
		 * @return 当前对象
		*/
		public Sequence setValue(Long value) {
			super.change(VALUE,super.getValue(),value);
			super.setValue(value);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param memo 备注
		 * @return 当前对象
		*/
		public Sequence setMemo(String memo) {
			super.change(MEMO,super.getMemo(),memo);
			super.setMemo(memo);
			return this;
		}
		
		/**
		 * 设置 编码类型
		 * @param type 编码类型
		 * @return 当前对象
		*/
		public Sequence setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public Sequence setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 每次取数的个数
		 * @param fetchSize 每次取数的个数
		 * @return 当前对象
		*/
		public Sequence setFetchSize(Integer fetchSize) {
			super.change(FETCH_SIZE,super.getFetchSize(),fetchSize);
			super.setFetchSize(fetchSize);
			return this;
		}
	}
}