package org.github.foxnic.web.changes.service.impl;


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
import org.github.foxnic.web.changes.service.IChangeDataService;
import org.github.foxnic.web.domain.changes.ChangeData;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 变更数据表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-30 11:31:52
*/


@Service("ChsChangeDataService")
public class ChangeDataServiceImpl extends SuperService<ChangeData> implements IChangeDataService {
	
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
	 * @param changeData 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(ChangeData changeData) {
		Result r=super.insert(changeData);
		return r;
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param changeDataList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<ChangeData> changeDataList) {
		return super.insertList(changeDataList);
	}
	
	
	/**
	 * 按主键删除 变更
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		ChangeData changeData = new ChangeData();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		changeData.setId(id);
		try {
			boolean suc = dao.deleteEntity(changeData);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 变更
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		ChangeData changeData = new ChangeData();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		changeData.setId(id);
		changeData.setDeleted(dao.getDBTreaty().getTrueValue());
		changeData.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		changeData.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(changeData,SaveMode.NOT_NULL_FIELDS);
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
	 * @param changeData 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(ChangeData changeData , SaveMode mode) {
		Result r=super.update(changeData , mode);
		return r;
	}
	
	/**
	 * 更新实体集，事务内
	 * @param changeDataList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<ChangeData> changeDataList , SaveMode mode) {
		return super.updateList(changeDataList , mode);
	}
	
	
	/**
	 * 按主键更新字段 变更
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
	 * 按主键获取 变更
	 *
	 * @param id 主键
	 * @return ChangeData 数据对象
	 */
	public ChangeData getById(String id) {
		ChangeData sample = new ChangeData();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<ChangeData> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<ChangeData> queryList(ChangeData sample) {
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
	public PagedList<ChangeData> queryPagedList(ChangeData sample, int pageSize, int pageIndex) {
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
	public PagedList<ChangeData> queryPagedList(ChangeData sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param changeData 数据对象
	 * @return 判断结果
	 */
	public Result<ChangeData> checkExists(ChangeData changeData) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(changeData, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(ChangeData sample) {
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
	public List<ChangeData> getListByInstanceId(String instanceId) {
		return this.queryList(ChangeData.create().setInstanceId(instanceId));
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}