package com.scientific.tailoring.order.service;
import com.github.foxnic.dao.entity.ISuperService;
import com.scientific.tailoring.domain.order.MeasureData;
import com.scientific.tailoring.domain.order.meta.MeasureDataMeta;
/**
 * <p>
 * 测量数据发聩表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-24 02:45:09
*/

public interface IMeasureDataService extends ISuperService<MeasureData> {

	/**
	 * 按主键删除测量数据发聩
	 *
	 * @param id id , 详情 : id
	 * @return 查询结果 , MeasureData对象
	 */
	boolean deleteByIdPhysical(Long id);
	
	/**
	 * 按主键删除测量数据发聩
	 *
	 * @param id id , 详情 : id
	 * @return 查询结果 , MeasureData对象
	 */
	boolean deleteByIdLogical(Long id);
	
	/**
	 * 按主键获取测量数据发聩
	 *
	 * @param id id
	 * @return 查询结果 , MeasureData对象
	 */
	MeasureData getById(Long id);
	
	MeasureData getByMeasureId(Long measureId,String measureType);

}