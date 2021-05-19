package com.scientific.tailoring.order.service;
import com.github.foxnic.dao.entity.ISuperService;
import com.scientific.tailoring.domain.order.VirtualEffect;
import com.scientific.tailoring.domain.order.meta.VirtualEffectMeta;
/**
 * <p>
 * 虚拟效果视频展示表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-25 08:57:39
*/

public interface IVirtualEffectService extends ISuperService<VirtualEffect> {
	
	/**
	 * 按主键删除虚拟效果视频展示
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , VirtualEffect对象
	 */
	boolean deleteByIdPhysical(Integer id);
	
	/**
	 * 按主键删除虚拟效果视频展示
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , VirtualEffect对象
	 */
	boolean deleteByIdLogical(Integer id);
	
	/**
	 * 按主键获取虚拟效果视频展示
	 *
	 * @param id ID
	 * @return 查询结果 , VirtualEffect对象
	 */
	VirtualEffect getById(Integer id);

}