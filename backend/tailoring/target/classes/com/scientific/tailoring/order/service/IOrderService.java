package com.scientific.tailoring.order.service;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.ISuperService;
import com.scientific.tailoring.domain.order.AppOrderModel;
import com.scientific.tailoring.domain.order.Order;
import com.scientific.tailoring.domain.order.OrderVO;
import com.scientific.tailoring.domain.order.meta.OrderMeta;
/**
 * <p>
 * 订单表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-22 01:32:54
*/

public interface IOrderService extends ISuperService<Order> {

	/**
	 * 按主键删除订单
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , Order对象
	 */
	boolean deleteByIdPhysical(Long id);
	
	/**
	 * 按主键删除订单
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , Order对象
	 */
	boolean deleteByIdLogical(Long id);
	
	/**
	 * 按主键获取订单
	 *
	 * @param id ID
	 * @return 查询结果 , Order对象
	 */
	Order getById(Long id);

	PagedList<AppOrderModel> queryPagedEntities4App(Long companyId, OrderVO sample, Integer pageSize, Integer pageIndex);

}