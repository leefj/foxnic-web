package com.scientific.tailoring.system.service;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.lang.function.SetterFunction;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.ISuperService;
import com.scientific.tailoring.domain.system.Dict;
import com.scientific.tailoring.domain.system.meta.DictMeta;
/**
 * <p>
 * 数据字典 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-22 01:32:50
*/

public interface IDictService extends ISuperService<Dict> {

	/**
	 * 按主键删除数据字典
	 *
	 * @param id 字典ID , 详情 : 字典ID
	 * @return 查询结果 , Dict对象
	 */
	boolean deleteByIdPhysical(Integer id);
	
	/**
	 * 按主键删除数据字典
	 *
	 * @param id 字典ID , 详情 : 字典ID
	 * @return 查询结果 , Dict对象
	 */
	boolean deleteByIdLogical(Integer id);
	
	/**
	 * 按主键获取数据字典
	 *
	 * @param id 字典ID
	 * @return 查询结果 , Dict对象
	 */
	Dict getById(Integer id);

	Map<String,String> getDictItems(String dictCode);

	
	/**
	 * 把 通过 getter 获得的字典代码转换成标签文本，并通过 setter 方法设置到 list 内的元素中 <br>
	 * 如:  dictService.translate("order_status",list,AppOrderModel::getStatus,AppOrderModel::setStatusName); 
	 * @param dictCode  字典代码
	 * @param list  实体集合
	 * @param getter  获得字典条目代码的 get 方法
	 * @param setter  设置字典标签的 set 方法
	 * */
	<T> void translate(String dictCode,List<T> list,Function<? super T, String> getter,SetterFunction<T,String> setter);
	
	
	/**
	 * 把 通过 getter 获得的字典代码转换成标签文本，并通过 setter 方法设置到 list 内的元素中 <br>
	 * 如:  dictService.translate("order_status",list,AppOrderModel::getStatus,AppOrderModel::setStatusName); 
	 * @param dictCode  字典代码
	 * @param list  实体集合
	 * @param getter  获得字典条目代码的 get 方法
	 * @param setter  设置字典标签的 set 方法
	 * */
	default <T> void translate(String dictCode,PagedList<T> list,Function<? super T, String> getter,SetterFunction<T,String> setter) {
		translate(dictCode, list.getList(), getter, setter);
		
	}

	JSONObject queryAll4JsDict();
 
}