package org.github.foxnic.web.pcm.service.impl;


import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.In;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.domain.pcm.CatalogAllocation;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.pcm.service.ICatalogAllocationService;
import org.github.foxnic.web.pcm.service.ICatalogAttributeService;
import org.github.foxnic.web.pcm.service.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 数据存储分配表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-01 21:26:45
 * @version 20210901
*/


@Service("PcmCatalogAttributeService")
public class CatalogAttributeServiceImpl extends SuperService<CatalogAttribute> implements ICatalogAttributeService {
	
	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }

	@Autowired
	private ICatalogService catalogService;

	@Autowired
	private ICatalogAllocationService allocationService;


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 查询目录下的字段
	 * */
	public List<CatalogAttribute> getCatalogAttribute(String catalogId,String excludeAttributeId) {
		List<CatalogAttribute> list=this.queryList("catalog_id=? and id!=?",catalogId,excludeAttributeId);
		this.join(list, CatalogAllocation.class);
		return list;
	}

	/**
	 * 插入实体
	 * @param catalogAttribute 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(CatalogAttribute catalogAttribute) {
		catalogAttribute.setVersionNo(ICatalogService.VERSION_EDITING);
		Result r=super.insert(catalogAttribute);
		return r;
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param catalogAttributeList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<CatalogAttribute> catalogAttributeList) {
		return super.insertList(catalogAttributeList);
	}
	
	
	/**
	 * 按主键删除 数据存储分配
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		CatalogAttribute catalogAttribute = this.getById(id);
		try {
			if(catalogAttribute!=null){

				CatalogAllocation allocation=CatalogAllocation.create()
						.setVersionNo(catalogAttribute.getVersionNo())
						.setCatalogId(catalogAttribute.getCatalogId())
						.setAttributeId(catalogAttribute.getId());
				allocation=allocationService.queryEntity(allocation);
				if(allocation!=null) {
					allocationService.deleteByIdPhysical(allocation.getId());
				}

			}

			boolean suc = dao.deleteEntity(catalogAttribute);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 按主键批量删除产品标签
	 *
	 * @param ids 编号 , 详情 : 编号
	 * @return 删除完成情况
	 */
	@Transactional
	public <T> Result deleteByIdsPhysical(List<T> ids) {
		if(ids.isEmpty()) {
			return ErrorDesc.failure().message("至少指定一个ID");
		}
		String idField=validateIds(ids);
		In in=new In(idField,ids);
		List<CatalogAttribute> attrs = this.queryList(in.toConditionExpr());
		this.join(attrs,CatalogAllocation.class);

		List<CatalogAllocation> allos= CollectorUtil.collectList(attrs,CatalogAttribute::getAllocation);
		List<String> allosIds=new ArrayList<>();
		for (CatalogAllocation allo : allos) {
			if(allo==null) continue;
			allosIds.add(allo.getId());
		}

		catalogService.deleteByIdsPhysical(allosIds);

		Integer i=dao().execute("delete from "+table()+" "+in.toConditionExpr().startWithWhere().getListParameterSQL(),in.getListParameters());
		boolean suc= i!=null && i>0;
		if(suc) return ErrorDesc.success();
		else return ErrorDesc.failure();
	}
	
	/**
	 * 按主键删除 数据存储分配
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		CatalogAttribute catalogAttribute = new CatalogAttribute();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		catalogAttribute.setId(id);
		catalogAttribute.setDeleted(dao.getDBTreaty().getTrueValue());
		catalogAttribute.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		catalogAttribute.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(catalogAttribute,SaveMode.NOT_NULL_FIELDS);
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
	 * @param catalogAttribute 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(CatalogAttribute catalogAttribute , SaveMode mode) {
		Result r=super.update(catalogAttribute , mode);
		return r;
	}
	
	/**
	 * 更新实体集，事务内
	 * @param catalogAttributeList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<CatalogAttribute> catalogAttributeList , SaveMode mode) {
		return super.updateList(catalogAttributeList , mode);
	}
	
	
	/**
	 * 按主键更新字段 数据存储分配
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
	 * 按主键获取 数据存储分配
	 *
	 * @param id 主键
	 * @return CatalogAttribute 数据对象
	 */
	public CatalogAttribute getById(String id) {
		CatalogAttribute sample = new CatalogAttribute();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<CatalogAttribute> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<CatalogAttribute> queryList(CatalogAttribute sample) {
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
	public PagedList<CatalogAttribute> queryPagedList(CatalogAttribute sample, int pageSize, int pageIndex) {
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
	public PagedList<CatalogAttribute> queryPagedList(CatalogAttribute sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param catalogAttribute 数据对象
	 * @return 判断结果
	 */
	public Result<CatalogAttribute> checkExists(CatalogAttribute catalogAttribute) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(catalogAttribute, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(CatalogAttribute sample) {
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
	public List<CatalogAttribute> getAttributes(String catalogId, String versionNo) {
		return this.queryList(CatalogAttribute.create().setCatalogId(catalogId).setVersionNo(versionNo));
	}

	@Override
	public List<String> getAllVersions(String catalogId) {
		RcdSet rs=dao().query("select distinct version_no from "+table()+" where catalog_id=? order by version_no desc",catalogId);
		List<String> versions=rs.getValueList("version_no",String.class);
		return versions;
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}