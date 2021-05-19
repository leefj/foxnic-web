package com.scientific.tailoring.product.service;
import com.github.foxnic.dao.entity.ISuperService;
import com.scientific.tailoring.domain.product.Fabric;
import com.scientific.tailoring.domain.product.meta.FabricMeta;
/**
 * <p>
 * 面料表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-25 08:57:37
*/

public interface IFabricService extends ISuperService<Fabric> {

	/**
	 * 按主键删除面料
	 *
	 * @param id id , 详情 : id
	 * @return 查询结果 , Fabric对象
	 */
	boolean deleteByIdPhysical(Integer id);
	
	/**
	 * 按主键删除面料
	 *
	 * @param id id , 详情 : id
	 * @return 查询结果 , Fabric对象
	 */
	boolean deleteByIdLogical(Integer id);
	
	/**
	 * 按主键获取面料
	 *
	 * @param id id
	 * @return 查询结果 , Fabric对象
	 */
	Fabric getById(Integer id);

}