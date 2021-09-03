package org.github.foxnic.web.pcm.service.impl;


import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.domain.pcm.CatalogAllocation;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.pcm.service.ICatalogAllocationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 分类属性分配表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-02 14:29:59
 * @version
*/


@Service("PcmCatalogAllocationService")
public class CatalogAllocationServiceImpl extends SuperService<CatalogAllocation> implements ICatalogAllocationService {
	
	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }


	
	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}
	
	/**
	 * 插入实体
	 * @param catalogAllocation 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(CatalogAllocation catalogAllocation) {
		Result r=super.insert(catalogAllocation);
		return r;
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param catalogAllocationList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<CatalogAllocation> catalogAllocationList) {
		return super.insertList(catalogAllocationList);
	}
	
	
	/**
	 * 按主键删除 分类属性分配
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		CatalogAllocation catalogAllocation = new CatalogAllocation();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		catalogAllocation.setId(id);
		try {
			boolean suc = dao.deleteEntity(catalogAllocation);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 分类属性分配
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		CatalogAllocation catalogAllocation = new CatalogAllocation();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		catalogAllocation.setId(id);
		catalogAllocation.setDeleted(dao.getDBTreaty().getTrueValue());
		catalogAllocation.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		catalogAllocation.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(catalogAllocation,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 更新实体
	 * @param catalogAllocation 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(CatalogAllocation catalogAllocation , SaveMode mode) {
		Result r=super.update(catalogAllocation , mode);
		return r;
	}
	
	/**
	 * 更新实体集，事务内
	 * @param catalogAllocationList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<CatalogAllocation> catalogAllocationList , SaveMode mode) {
		return super.updateList(catalogAllocationList , mode);
	}
	
	
	/**
	 * 按主键更新字段 分类属性分配
	 *
	 * @param id 主键
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	} 
	
	
	/**
	 * 按主键获取 分类属性分配
	 *
	 * @param id 主键
	 * @return CatalogAllocation 数据对象
	 */
	public CatalogAllocation getById(String id) {
		CatalogAllocation sample = new CatalogAllocation();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<CatalogAllocation> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<CatalogAllocation> queryList(CatalogAllocation sample) {
		return super.queryList(sample);
	}
	
	
	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<CatalogAllocation> queryPagedList(CatalogAllocation sample, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, pageSize, pageIndex);
	}
	
	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @param condition 其它条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<CatalogAllocation> queryPagedList(CatalogAllocation sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param catalogAllocation 数据对象
	 * @return 判断结果
	 */
	public Result<CatalogAllocation> checkExists(CatalogAllocation catalogAllocation) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(catalogAllocation, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(CatalogAllocation sample) {
		return super.exportExcel(sample);
	}

	@Override
	public ExcelWriter exportExcelTemplate() {
		return super.exportExcelTemplate();
	}

	@Override
	public List<ValidateResult> importExcel(InputStream input,int sheetIndex,boolean batch) {
		return super.importExcel(input,sheetIndex,batch);
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}