package com.scientific.tailoring.system.service.impl;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.Expr;
import com.scientific.tailoring.domain.system.DictItem;
import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.system.service.IDictItemService;

/**
 * <p>
 * 数据字典条目 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-22 01:32:50
*/

@Service("SysDictItemServiceImpl")
public class DictItemServiceImpl extends SuperService<DictItem> implements IDictItemService {
	
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
	
	/**
	 * 按主键删除数据字典条目
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , DictItem对象
	 */
	public boolean deleteByIdPhysical(Integer id) {
		DictItem dictItem = new DictItem();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		dictItem.setId(id);
		return dao.deleteEntity(dictItem);
	}
	
	/**
	 * 按主键删除数据字典条目
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , DictItem对象
	 */
	public boolean deleteByIdLogical(Integer id) {
		DictItem dictItem = new DictItem();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		dictItem.setId(id);
		dictItem.setDeleted(true);
		dictItem.setDeleteBy((Long)dao.getDBTreaty().getLoginUserId());
		dictItem.setDeleteTime(new Date());
		return dao.updateEntity(dictItem,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 按主键获取数据字典条目
	 *
	 * @param id ID
	 * @return 查询结果 , DictItem对象
	 */
	public DictItem getById(Integer id) {
		DictItem sample = new DictItem();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<DictItem> queryByDictCode(String dictCode) {
		return dao.queryEntities(DictItem.class,new Expr("select * from sys_dict_item where dict_code=? and deleted=0 order by sort asc",dictCode));
	}

}