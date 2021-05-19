package com.scientific.tailoring.product.service.impl;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.scientific.tailoring.domain.product.Fabric;
import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.product.service.IFabricService;

/**
 * <p>
 * 面料表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-25 08:57:37
*/

@Service("PrdFabricServiceImpl")
public class FabricServiceImpl extends SuperService<Fabric> implements IFabricService {
	
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
	
	/**
	 * 按主键删除面料
	 *
	 * @param id id , 详情 : id
	 * @return 查询结果 , Fabric对象
	 */
	public boolean deleteByIdPhysical(Integer id) {
		Fabric fabric = new Fabric();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		fabric.setId(id);
		return dao.deleteEntity(fabric);
	}
	
	/**
	 * 按主键删除面料
	 *
	 * @param id id , 详情 : id
	 * @return 查询结果 , Fabric对象
	 */
	public boolean deleteByIdLogical(Integer id) {
		Fabric fabric = new Fabric();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		fabric.setId(id);
		fabric.setDeleted(true);
		fabric.setDeleteBy((Long)dao.getDBTreaty().getLoginUserId());
		fabric.setDeleteTime(new Date());
		return dao.updateEntity(fabric,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 按主键获取面料
	 *
	 * @param id id
	 * @return 查询结果 , Fabric对象
	 */
	public Fabric getById(Integer id) {
		Fabric sample = new Fabric();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

}