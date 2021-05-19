package com.scientific.tailoring.product.service.impl;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.mvc.Result;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.Expr;
import com.scientific.tailoring.domain.product.Fabric;
import com.scientific.tailoring.domain.product.Product;
import com.scientific.tailoring.domain.product.VirtualLibrary;
import com.scientific.tailoring.domain.product.VirtualLibraryModel;
import com.scientific.tailoring.domain.product.VirtualLibraryVO;
import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.product.service.IVirtualLibraryService;

/**
 * <p>
 * 虚拟试衣表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-04-08 03:46:44
*/

@Service("PrdVirtualLibraryServiceImpl")
public class VirtualLibraryServiceImpl extends SuperService<VirtualLibrary>  implements IVirtualLibraryService {
	
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
	
	/**
	 * 按主键删除虚拟试衣
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , VirtualLibrary对象
	 */
	public boolean deleteByIdPhysical(Long id) {
		VirtualLibrary virtualLibrary = new VirtualLibrary();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		virtualLibrary.setId(id);
		return dao.deleteEntity(virtualLibrary);
	}
	
	/**
	 * 按主键删除虚拟试衣
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , VirtualLibrary对象
	 */
	public boolean deleteByIdLogical(Long id) {
		VirtualLibrary virtualLibrary = new VirtualLibrary();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		virtualLibrary.setId(id);
		virtualLibrary.setDeleted(true);
		virtualLibrary.setDeleteBy((Long)dao.getDBTreaty().getLoginUserId());
		virtualLibrary.setDeleteTime(new Date());
		return dao.updateEntity(virtualLibrary,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 按主键获取虚拟试衣
	 *
	 * @param id ID
	 * @return 查询结果 , VirtualLibrary对象
	 */
	public VirtualLibrary getById(Long id) {
		VirtualLibrary sample = new VirtualLibrary();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		VirtualLibrary vl=dao.queryEntity(sample);
		dao.join(vl, Product.class);
		dao.join(vl, Fabric.class);
		return vl;
	}
	
	/**
	 * 检查 虚拟试衣 是否已经存在
	 *
	 * @param virtualLibraryVO 数据对象
	 * @return 判断结果
	 */
	public Result<VirtualLibrary> checkExists(VirtualLibraryVO virtualLibraryVO) {
		return ErrorDesc.success();
	}
	
	
	@Override
	public PagedList<VirtualLibraryModel> queryPagedListModel(VirtualLibraryVO sample, Integer pageSize, Integer pageIndex) {
		//执行数据插入
		dao.execute("#virtuallibrary.insert-data");
		//从模版文件载入语句
		Expr select=new Expr(dao.getSQL("#virtuallibrary.basic-join-select"));
		//根据传入的参数构建默认查询条件
		ConditionExpr ce=this.buildQueryCondition(sample, "a");
		//连入额外的查询条件
		if("productName".equals(sample.getSearchField())) {
			ce.andLike("p.name", sample.getSearchValue());
		}
		if("fabricName".equals(sample.getSearchField())) {
			ce.andLike("f.short_name", sample.getSearchValue());
		}
		//加入条件
		select.append(ce.startWithWhere());
		return dao.queryPagedEntities(VirtualLibraryModel.class,select, pageSize, pageIndex);
	}

 
	 

}