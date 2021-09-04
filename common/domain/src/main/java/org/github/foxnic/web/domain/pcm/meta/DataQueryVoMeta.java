package org.github.foxnic.web.domain.pcm.meta;

import com.github.foxnic.api.bean.BeanProperty;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-04 12:08:37
 * @sign 894B3A54E71CCDFDE72909E263659396
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DataQueryVoMeta {
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.DataQueryVo,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.DataQueryVo.class ,TENANT_ID, java.lang.String.class, "租户ID", "", java.lang.String.class, null);
	
	/**
	 * 类目ID , 类型: java.lang.String
	*/
	public static final String CATALOG_ID="catalogId";
	
	/**
	 * 类目ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.DataQueryVo,java.lang.String> CATALOG_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.DataQueryVo.class ,CATALOG_ID, java.lang.String.class, "类目ID", "", java.lang.String.class, null);
	
	/**
	 * 数据的ID清单 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 数据的ID清单 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.DataQueryVo,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.DataQueryVo.class ,IDS, java.util.List.class, "数据的ID清单", "", java.lang.String.class, null);
	
	/**
	 * 所有者单据ID清单 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String OWNER_IDS="ownerIds";
	
	/**
	 * 所有者单据ID清单 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.DataQueryVo,java.lang.String> OWNER_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.DataQueryVo.class ,OWNER_IDS, java.util.List.class, "所有者单据ID清单", "", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ TENANT_ID , CATALOG_ID , IDS , OWNER_IDS };
}