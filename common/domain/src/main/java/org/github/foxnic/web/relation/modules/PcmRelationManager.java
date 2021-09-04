package org.github.foxnic.web.relation.modules;

import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb.PCM_CATALOG;
import org.github.foxnic.web.constants.db.FoxnicWeb.PCM_CATALOG_ALLOCATION;
import org.github.foxnic.web.constants.db.FoxnicWeb.PCM_CATALOG_ATTRIBUTE;
import org.github.foxnic.web.domain.pcm.meta.CatalogAllocationMeta;
import org.github.foxnic.web.domain.pcm.meta.CatalogAttributeMeta;
import org.github.foxnic.web.domain.pcm.meta.CatalogMeta;

public class PcmRelationManager extends RelationManager {

	@Override
	protected void config() {

		//分类的属性清单
		this.property(CatalogMeta.ATTRIBUTES_PROP)
		.using(PCM_CATALOG.ID).join(PCM_CATALOG_ATTRIBUTE.CATALOG_ID);


		//属性 - 属性分类来源
		this.property(CatalogAttributeMeta.CATALOG_PROP)
				.using(PCM_CATALOG_ATTRIBUTE.CATALOG_ID).join(PCM_CATALOG.ID);

		//属性 - 属性来源
		this.property(CatalogAttributeMeta.SOURCE_ATTR_PROP)
				.using(PCM_CATALOG_ATTRIBUTE.SOURCE_ID).join(PCM_CATALOG_ATTRIBUTE.ID);

		//属性对应的字段分配
		this.property(CatalogAttributeMeta.ALLOCATION_PROP)
				.using(PCM_CATALOG_ATTRIBUTE.CATALOG_ID,PCM_CATALOG_ATTRIBUTE.VERSION_NO, PCM_CATALOG_ATTRIBUTE.ID)
				.join(PCM_CATALOG_ALLOCATION.CATALOG_ID,PCM_CATALOG_ALLOCATION.VERSION_NO,PCM_CATALOG_ALLOCATION.ATTRIBUTE_ID);

		//字段分配 - 属性定义
		this.property(CatalogAllocationMeta.ATTRIBUTE_PROP)
				.using(PCM_CATALOG_ALLOCATION.ATTRIBUTE_ID).join(PCM_CATALOG_ATTRIBUTE.ID);

	}
 



}
