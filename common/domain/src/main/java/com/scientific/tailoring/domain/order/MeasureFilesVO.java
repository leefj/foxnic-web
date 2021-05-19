package com.scientific.tailoring.domain.order;

import io.swagger.annotations.ApiModelProperty;



/**
 * 多个测量文件单次提交的数据
 * @author 李方捷
 * @since 2021-05-17 01:24:39
 * @sign 77D618F67A7DF9CE22273F0BB1F0ED9E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MeasureFilesVO extends Measure {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 测量ID
	*/
	@ApiModelProperty(required = false,value="测量ID" , notes = "")
	private Long measureId;
	
	/**
	 * 文件清单
	*/
	@ApiModelProperty(required = false,value="文件清单" , notes = "")
	private MeasureFile measureFiles;
	
	/**
	 * 获得 测量ID<br>
	 * @return 测量ID
	*/
	public Long getMeasureId() {
		return measureId;
	}
	
	/**
	 * 设置 测量ID
	 * @param measureId 测量ID
	 * @return 当前对象
	*/
	public MeasureFilesVO setMeasureId(Long measureId) {
		this.measureId=measureId;
		return this;
	}
	
	/**
	 * 添加 测量ID
	 * @param measureId 测量ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 文件清单<br>
	 * @return 文件清单
	*/
	public MeasureFile getMeasureFiles() {
		return measureFiles;
	}
	
	/**
	 * 设置 文件清单
	 * @param measureFiles 文件清单
	 * @return 当前对象
	*/
	public MeasureFilesVO setMeasureFiles(MeasureFile measureFiles) {
		this.measureFiles=measureFiles;
		return this;
	}
	
	/**
	 * 添加 文件清单
	 * @param measureFiles 文件清单
	 * @return 当前对象
	*/
}