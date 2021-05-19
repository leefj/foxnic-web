package com.scientific.tailoring.order.service.impl;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.scientific.tailoring.domain.order.VirtualEffect;
import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.order.service.IVirtualEffectService;

/**
 * <p>
 * 虚拟效果视频展示表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-25 08:57:39
*/

@Service("OdrVirtualEffectServiceImpl")
public class VirtualEffectServiceImpl extends SuperService<VirtualEffect> implements IVirtualEffectService {
	
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
	
	/**
	 * 按主键删除虚拟效果视频展示
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , VirtualEffect对象
	 */
	public boolean deleteByIdPhysical(Integer id) {
		VirtualEffect virtualEffect = new VirtualEffect();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		virtualEffect.setId(id);
		return dao.deleteEntity(virtualEffect);
	}
	
	/**
	 * 按主键删除虚拟效果视频展示
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , VirtualEffect对象
	 */
	public boolean deleteByIdLogical(Integer id) {
		VirtualEffect virtualEffect = new VirtualEffect();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		virtualEffect.setId(id);
		virtualEffect.setDeleted(true);
		virtualEffect.setDeleteBy((Long)dao.getDBTreaty().getLoginUserId());
		virtualEffect.setDeleteTime(new Date());
		return dao.updateEntity(virtualEffect,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 按主键获取虚拟效果视频展示
	 *
	 * @param id ID
	 * @return 查询结果 , VirtualEffect对象
	 */
	public VirtualEffect getById(Integer id) {
		VirtualEffect sample = new VirtualEffect();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

}