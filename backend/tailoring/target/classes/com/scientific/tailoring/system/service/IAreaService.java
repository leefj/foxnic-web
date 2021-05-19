package com.scientific.tailoring.system.service;
import java.util.List;
import java.util.function.Function;

import com.github.foxnic.commons.lang.function.SetterFunction;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.ISuperService;
import com.scientific.tailoring.domain.system.Area;
import com.scientific.tailoring.domain.system.meta.AreaMeta;

/**
 * <p>
 * 区域表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-21 11:22:08
*/

public interface IAreaService extends ISuperService<Area> {
 
	/**
	 * 按主键删除区域
	 *
	 * @param id 区域ID , 详情 : 区域ID
	 * @return 查询结果 , Area对象
	 */
	boolean deleteByIdPhysical(Integer id);
	
	/**
	 * 按主键获取区域
	 *
	 * @param id 区域ID
	 * @return 查询结果 , Area对象
	 */
	Area getById(Integer id);

	/**
	 * 把 通过 getter 获得的区域ID转换成地名文本，并通过 setter 方法设置到 list 内的元素中 <br>
	 * 如:  areaService.translate(list,AppOrderModel::getProvinceId,AppOrderModel::setProvinceName);
	 * @param list  实体集合
	 * @param getter  获得区域 ID 的 get 方法
	 * @param setter  设置区域名称的 set 方法
	 * */
	<T> void translate(List<T> list, Function<? super T, Integer> getter, SetterFunction<T,String> setter);


	/**
	 * 把 通过 getter 获得的区域ID转换成地名文本，并通过 setter 方法设置到 list 内的元素中 <br>
	 * 如:  areaService.translate(list,AppOrderModel::getProvinceId,AppOrderModel::setProvinceName);
	 * @param list  实体集合
	 * @param getter  获得区域 ID 的 get 方法
	 * @param setter  设置区域名称的 set 方法
	 * */
	default <T> void translate(PagedList<T> list,Function<T,Integer> getter, SetterFunction<T,String> setter) {
		translate(list.getList(),getter,setter);
	}


}