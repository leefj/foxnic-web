package org.github.foxnic.web.system.service.impl;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.io.InputStream;


import javax.annotation.Resource;

import com.github.foxnic.api.transter.Result;
import org.springframework.stereotype.Service;

import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;


import org.github.foxnic.web.domain.system.Dict;
import org.github.foxnic.web.system.service.IDictService;
import org.github.foxnic.web.framework.dao.DBConfigs;

/**
 * <p>
 * 数据字典 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-17 16:41:53
*/


@Service("SysDictService")
public class DictServiceImpl extends SuperService<Dict> implements IDictService {
	
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
	 * @param dict 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public boolean insert(Dict dict) {
		return super.insert(dict);
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param dictList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public boolean insertList(List<Dict> dictList) {
		return super.insertList(dictList);
	}
	
	
	/**
	 * 按主键删除 数据字典
	 *
	 * @param id 字典ID
	 * @return 删除是否成功
	 */
	public boolean deleteByIdPhysical(String id) {
		Dict dict = new Dict();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		dict.setId(id);
		return dao.deleteEntity(dict);
	}
	
	/**
	 * 按主键删除 数据字典
	 *
	 * @param id 字典ID
	 * @return 删除是否成功
	 */
	public boolean deleteByIdLogical(String id) {
		Dict dict = new Dict();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		dict.setId(id);
		dict.setDeleted(dao.getDBTreaty().getTrueValue());
		dict.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		dict.setDeleteTime(new Date());
		return dao.updateEntity(dict,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 更新实体
	 * @param dict 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public boolean update(Dict dict , SaveMode mode) {
		return super.update(dict , mode);
	}
	
	/**
	 * 更新实体集，事务内
	 * @param dictList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public boolean updateList(List<Dict> dictList , SaveMode mode) {
		return super.updateList(dictList , mode);
	}
	
	
	/**
	 * 按主键更新字段 数据字典
	 *
	 * @param id 字典ID
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	} 
	
	
	/**
	 * 按主键获取 数据字典
	 *
	 * @param id 字典ID
	 * @return Dict 数据对象
	 */
	public Dict getById(String id) {
		Dict sample = new Dict();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}
 
	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Dict> queryList(Dict sample) {
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
	public PagedList<Dict> queryPagedList(Dict sample, int pageSize, int pageIndex) {
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
	public PagedList<Dict> queryPagedList(Dict sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param dict 数据对象
	 * @return 判断结果
	 */
	public Result<Dict> checkExists(Dict dict) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(dict, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(Dict sample) {
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