package com.scientific.tailoring.domain.product;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 01:18:17
 * @sign BF494BE5A05705CDD729BE396DE80844
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class LabelNodeModel extends Label {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 下级标签
	*/
	@ApiModelProperty(required = false,value="下级标签" , notes = "")
	private List<LabelNodeModel> subLabels;
	
	/**
	 * 获得 下级标签<br>
	 * @return 下级标签
	*/
	public List<LabelNodeModel> getSubLabels() {
		return subLabels;
	}
	
	/**
	 * 设置 下级标签
	 * @param subLabels 下级标签
	 * @return 当前对象
	*/
	public LabelNodeModel setSubLabels(List<LabelNodeModel> subLabels) {
		this.subLabels=subLabels;
		return this;
	}
	
	/**
	 * 添加 下级标签
	 * @param subLabels 下级标签
	 * @return 当前对象
	*/
	public LabelNodeModel addSubLabel(LabelNodeModel subLabel) {
		if(this.subLabels==null) subLabels=new ArrayList<>();
		this.subLabels.add(subLabel);
		return this;
	}
}