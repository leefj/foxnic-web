package com.scientific.tailoring.domain.product.meta;

import com.scientific.tailoring.domain.product.LabelNodeModel;
import java.util.List;



/**
 * @author 李方捷
 * @since 2021-05-17 01:18:17
 * @sign BF494BE5A05705CDD729BE396DE80844
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class LabelNodeModelMeta {
	
	/**
	 * 下级标签
	*/
	public static final String SUB_LABELS="subLabels";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ SUB_LABELS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.product.LabelNodeModel {
		
		/**
		 * 设置 下级标签
		 * @param subLabels 下级标签
		 * @return 当前对象
		*/
		public LabelNodeModel setSubLabels(List<LabelNodeModel> subLabels) {
			super.change(SUB_LABELS,super.getSubLabels(),subLabels);
			super.setSubLabels(subLabels);
			return this;
		}
}
}