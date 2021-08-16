package org.github.foxnic.web.relation.modules;

import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.domain.system.meta.DictMeta;

public class SystemRelationManager extends RelationManager {

	@Override
	protected void config() {
		this.setupProperties();
	}
 
	public void setupProperties() {


		//字典 - 模块关联关系
		this.property(DictMeta.MODULE_INFO_PROP)
				.using(FoxnicWeb.SYS_DICT.MODULE).join(FoxnicWeb.SYS_MENU.ID);

		//字典 - 下级条目关联关系
		this.property(DictMeta.ITEMS_PROP)
				.using(FoxnicWeb.SYS_DICT.ID).join(FoxnicWeb.SYS_DICT_ITEM.DICT_ID);




	}


}
