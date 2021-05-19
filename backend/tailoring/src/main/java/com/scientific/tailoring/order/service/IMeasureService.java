package com.scientific.tailoring.order.service;
import java.util.List;
import java.util.Map;

import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.ISuperService;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.OrderBy;
import com.scientific.tailoring.domain.order.AppMeasureModel;
import com.scientific.tailoring.domain.order.Measure;
import com.scientific.tailoring.domain.order.MeasureDimensionModel;
import com.scientific.tailoring.domain.order.MeasureVO;

/**
 * <p>
 * 订单测量信息表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-22 04:19:26
*/

public interface IMeasureService extends ISuperService<Measure> {

	/**
	 * 按主键删除订单测量信息
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , Measure对象
	 */
	boolean deleteByIdPhysical(Long id);
	
	/**
	 * 按主键删除订单测量信息
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , Measure对象
	 */
	boolean deleteByIdLogical(Long id);
	
	/**
	 * 按主键获取订单测量信息
	 *
	 * @param id ID
	 * @return 查询结果 , Measure对象
	 */
	Measure getById(Long id);
	
	
	/**
	 * 查询实体集合
	 * */
	List<Measure> queryList(Measure sample);
	
	
	/**
	 * 查询实体集合
	 * */
	List<Measure> queryList(Measure sample,ConditionExpr condition,OrderBy orderBy);
	
	/**
	 * 查询实体集合
	 * */
	List<Measure> queryList(Measure sample,OrderBy orderBy);
	
	/**
	 * 查询实体集合
	 * */
	List<Measure> queryList(Measure sample,ConditionExpr condition);
	
	/**
	 * 查询单个实体
	 * */
	Measure queryEntity(Measure sample);
	
	/**
	 * 分页查询实体集
	 * */
	PagedList<Measure> queryPagedList(Measure sample,int pageSize,int pageIndex);
	
	/**
	 * 分页查询实体集
	 * */
	PagedList<Measure> queryPagedList(Measure sample,ConditionExpr condition,OrderBy orderBy,int pageSize,int pageIndex);
	
	/**
	 * 分页查询实体集
	 * */
	PagedList<Measure> queryPagedList(Measure sample,ConditionExpr condition,int pageSize,int pageIndex);
	
	/**
	 * 分页查询实体集
	 * */
	PagedList<Measure> queryPagedList(Measure sample,OrderBy orderBy,int pageSize,int pageIndex);
	
	/**
	 * 分页查询实体集
	 * */
	PagedList<MeasureVO> queryPagedList(MeasureVO sample,int pageSize,int pageIndex);

	/**
	 * 按订单ID分组后再按测量状态统计汇总数量
	 * */
    Map<Long, Map<String, Integer>> groupByOrderStatus(List<Long> orderIds);

	PagedList<AppMeasureModel> queryPagedEntities4App(Long orderId, List<String> status, Integer pageSize, Integer pageIndex);

	List<MeasureDimensionModel> getMeasureDimensions();

    void updateStatus(Long measureId, String status);
}