package com.scientific.tailoring.system.service.impl;
import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Function;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.lang.function.SetterFunction;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.scientific.tailoring.domain.system.Area;
import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.system.service.IAreaService;

/**
 * <p>
 * 区域表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-21 11:22:08
*/

@Service("SysAreaServiceImpl")
public class AreaServiceImpl extends SuperService<Area> implements IAreaService {
	
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
	 * 按主键删除区域
	 *
	 * @param id 区域ID , 详情 : 区域ID
	 * @return 查询结果 , Area对象
	 */
	public boolean deleteByIdPhysical(Integer id) {
		Area area = new Area();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		area.setId(id);
		return dao.deleteEntity(area);
	}
	
	/**
	 * 按主键获取区域
	 *
	 * @param id 区域ID
	 * @return 查询结果 , Area对象
	 */
	public Area getById(Integer id) {
		Area sample = new Area();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	private LocalCache<Integer,String> AREA_CACHE=new LocalCache<>();

	
	public <T> void translate(List<T> list, Function<? super T, Integer> getter, SetterFunction<T,String> setter) {

		Integer areaId=null;
		String name=null;
		for (T e : list) {
			areaId=getter.apply(e);
			name=AREA_CACHE.get(areaId);
			if(name==null) {
				Area area = this.getById(areaId);
				if (area != null) name = area.getName();
				else name = " - ";
				AREA_CACHE.put(areaId, name);
			}
			setter.apply(e,name);
		}
	}

}