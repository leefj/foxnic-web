package com.scientific.tailoring.order.service;
import java.util.List;

import com.github.foxnic.dao.entity.ISuperService;
import com.scientific.tailoring.domain.order.MeasureFile;
import com.scientific.tailoring.domain.order.meta.MeasureFileMeta;

/**
 * <p>
 * 测量文件采集表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-25 08:57:39
*/

public interface IMeasureFileService extends ISuperService<MeasureFile> {

	/**
	 * 按主键删除测量文件采集
	 *
	 * @param id id , 详情 : id
	 * @return 查询结果 , MeasureFile对象
	 */
	boolean deleteByIdPhysical(Integer id);
	
	/**
	 * 按主键删除测量文件采集
	 *
	 * @param id id , 详情 : id
	 * @return 查询结果 , MeasureFile对象
	 */
	boolean deleteByIdLogical(Integer id);
	
	/**
	 * 按主键获取测量文件采集
	 *
	 * @param id id
	 * @return 查询结果 , MeasureFile对象
	 */
	MeasureFile getById(Integer id);

    boolean insertFiles(Long measureId,List<MeasureFile> measureFileVOs);
}