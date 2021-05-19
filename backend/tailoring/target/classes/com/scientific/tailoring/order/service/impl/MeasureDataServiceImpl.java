package com.scientific.tailoring.order.service.impl;
import java.lang.reflect.Field;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.scientific.tailoring.domain.order.MeasureData;
import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.order.service.IMeasureDataService;

/**
 * <p>
 * 测量数据发聩表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-24 02:45:09
*/

@Service("OdrMeasureDataServiceImpl")
public class MeasureDataServiceImpl extends SuperService<MeasureData> implements IMeasureDataService {
	
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
	
	/**
	 * 生成主键值
	 * */
	@Override
	public Object generateId(Field field) {
		return null;
	}
	
	/**
	 * 按主键删除测量数据发聩
	 *
	 * @param id id , 详情 : id
	 * @return 查询结果 , MeasureData对象
	 */
	public boolean deleteByIdPhysical(Long id) {
		MeasureData measureData = new MeasureData();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		measureData.setId(id);
		return dao.deleteEntity(measureData);
	}
	
	/**
	 * 按主键删除测量数据发聩
	 *
	 * @param id id , 详情 : id
	 * @return 查询结果 , MeasureData对象
	 */
	public boolean deleteByIdLogical(Long id) {
		MeasureData measureData = new MeasureData();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		measureData.setId(id);
		measureData.setDeleted(true);
		measureData.setDeleteBy((Long)dao.getDBTreaty().getLoginUserId());
		measureData.setDeleteTime(new Date());
		return dao.updateEntity(measureData,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 按主键获取测量数据发聩
	 *
	 * @param id id
	 * @return 查询结果 , MeasureData对象
	 */
	public MeasureData getById(Long id) {
		MeasureData sample = new MeasureData();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public MeasureData getByMeasureId(Long measureId,String measureType) { 
		return this.queryEntity("measure_id=? and result_type=?",measureId,measureType);
	}

}