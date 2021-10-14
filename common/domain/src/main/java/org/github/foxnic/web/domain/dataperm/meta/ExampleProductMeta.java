package org.github.foxnic.web.domain.dataperm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.dataperm.ExampleProduct;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.dataperm.ExampleCatalog;
import org.github.foxnic.web.domain.dataperm.ExampleBrand;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-14 16:09:14
 * @sign 6E09C0F5C26E1090EF92CF9A85188AA3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ExampleProductMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleProduct,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleProduct.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleProduct,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleProduct.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 品牌ID , 类型: java.lang.String
	*/
	public static final String BRAND_ID="brandId";
	
	/**
	 * 品牌ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleProduct,java.lang.String> BRAND_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleProduct.class ,BRAND_ID, java.lang.String.class, "品牌ID", "品牌ID", java.lang.String.class, null);
	
	/**
	 * 大类ID , 类型: java.lang.String
	*/
	public static final String BIG_CATA_ID="bigCataId";
	
	/**
	 * 大类ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleProduct,java.lang.String> BIG_CATA_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleProduct.class ,BIG_CATA_ID, java.lang.String.class, "大类ID", "大类ID", java.lang.String.class, null);
	
	/**
	 * 小类ID , 类型: java.lang.String
	*/
	public static final String SML_CATA_ID="smlCataId";
	
	/**
	 * 小类ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleProduct,java.lang.String> SML_CATA_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleProduct.class ,SML_CATA_ID, java.lang.String.class, "小类ID", "小类ID", java.lang.String.class, null);
	
	/**
	 * 售价 , 类型: java.math.BigDecimal
	*/
	public static final String PRICE="price";
	
	/**
	 * 售价 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleProduct,java.math.BigDecimal> PRICE_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleProduct.class ,PRICE, java.math.BigDecimal.class, "售价", "售价", java.math.BigDecimal.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleProduct,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleProduct.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleProduct,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleProduct.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleProduct,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleProduct.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleProduct,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleProduct.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleProduct,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleProduct.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleProduct,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleProduct.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleProduct,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleProduct.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleProduct,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleProduct.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 小类 , 商品小类 , 类型: org.github.foxnic.web.domain.dataperm.ExampleCatalog
	*/
	public static final String SML_CATALOG="smlCatalog";
	
	/**
	 * 小类 , 商品小类 , 类型: org.github.foxnic.web.domain.dataperm.ExampleCatalog
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleProduct,org.github.foxnic.web.domain.dataperm.ExampleCatalog> SML_CATALOG_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleProduct.class ,SML_CATALOG, org.github.foxnic.web.domain.dataperm.ExampleCatalog.class, "小类", "商品小类", org.github.foxnic.web.domain.dataperm.ExampleCatalog.class, null);
	
	/**
	 * 大类 , 商品大类 , 类型: org.github.foxnic.web.domain.dataperm.ExampleCatalog
	*/
	public static final String BIG_CATALOG="bigCatalog";
	
	/**
	 * 大类 , 商品大类 , 类型: org.github.foxnic.web.domain.dataperm.ExampleCatalog
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleProduct,org.github.foxnic.web.domain.dataperm.ExampleCatalog> BIG_CATALOG_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleProduct.class ,BIG_CATALOG, org.github.foxnic.web.domain.dataperm.ExampleCatalog.class, "大类", "商品大类", org.github.foxnic.web.domain.dataperm.ExampleCatalog.class, null);
	
	/**
	 * 品牌 , 商品品牌 , 类型: org.github.foxnic.web.domain.dataperm.ExampleBrand
	*/
	public static final String BRAND="brand";
	
	/**
	 * 品牌 , 商品品牌 , 类型: org.github.foxnic.web.domain.dataperm.ExampleBrand
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleProduct,org.github.foxnic.web.domain.dataperm.ExampleBrand> BRAND_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleProduct.class ,BRAND, org.github.foxnic.web.domain.dataperm.ExampleBrand.class, "品牌", "商品品牌", org.github.foxnic.web.domain.dataperm.ExampleBrand.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , BRAND_ID , BIG_CATA_ID , SML_CATA_ID , PRICE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , SML_CATALOG , BIG_CATALOG , BRAND };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.dataperm.ExampleProduct {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ExampleProduct setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public ExampleProduct setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 品牌ID
		 * @param brandId 品牌ID
		 * @return 当前对象
		*/
		public ExampleProduct setBrandId(String brandId) {
			super.change(BRAND_ID,super.getBrandId(),brandId);
			super.setBrandId(brandId);
			return this;
		}
		
		/**
		 * 设置 大类ID
		 * @param bigCataId 大类ID
		 * @return 当前对象
		*/
		public ExampleProduct setBigCataId(String bigCataId) {
			super.change(BIG_CATA_ID,super.getBigCataId(),bigCataId);
			super.setBigCataId(bigCataId);
			return this;
		}
		
		/**
		 * 设置 小类ID
		 * @param smlCataId 小类ID
		 * @return 当前对象
		*/
		public ExampleProduct setSmlCataId(String smlCataId) {
			super.change(SML_CATA_ID,super.getSmlCataId(),smlCataId);
			super.setSmlCataId(smlCataId);
			return this;
		}
		
		/**
		 * 设置 售价
		 * @param price 售价
		 * @return 当前对象
		*/
		public ExampleProduct setPrice(BigDecimal price) {
			super.change(PRICE,super.getPrice(),price);
			super.setPrice(price);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ExampleProduct setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ExampleProduct setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ExampleProduct setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ExampleProduct setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ExampleProduct setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ExampleProduct setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ExampleProduct setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public ExampleProduct setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 小类
		 * @param smlCatalog 小类
		 * @return 当前对象
		*/
		public ExampleProduct setSmlCatalog(ExampleCatalog smlCatalog) {
			super.change(SML_CATALOG,super.getSmlCatalog(),smlCatalog);
			super.setSmlCatalog(smlCatalog);
			return this;
		}
		
		/**
		 * 设置 大类
		 * @param bigCatalog 大类
		 * @return 当前对象
		*/
		public ExampleProduct setBigCatalog(ExampleCatalog bigCatalog) {
			super.change(BIG_CATALOG,super.getBigCatalog(),bigCatalog);
			super.setBigCatalog(bigCatalog);
			return this;
		}
		
		/**
		 * 设置 品牌
		 * @param brand 品牌
		 * @return 当前对象
		*/
		public ExampleProduct setBrand(ExampleBrand brand) {
			super.change(BRAND,super.getBrand(),brand);
			super.setBrand(brand);
			return this;
		}
	}
}