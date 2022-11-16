package org.github.foxnic.web.system.service.impl;


import com.github.foxnic.api.cache.Cached;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.domain.system.Dict;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.system.service.IDictItemService;
import org.github.foxnic.web.system.service.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * <p>
 * 数据字典条目 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-20 01:06:36
*/


@Service("SysDictItemService")
public class DictItemServiceImpl extends SuperService<DictItem> implements IDictItemService {

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
	private IDictService dictService;


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 插入实体
	 * @param dictItem 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(DictItem dictItem) {
		Dict dict=dictService.getById(dictItem.getDictId());
		dictItem.setDictCode(dict.getCode());
		return super.insert(dictItem,false);
	}

	/**
	 * 批量插入实体，事务内
	 * @param dictItemList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<DictItem> dictItemList) {
		return super.insertList(dictItemList);
	}


	/**
	 * 按主键删除 数据字典条目
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		DictItem dictItem = this.getById(id);
		if(dictItem==null) return ErrorDesc.success();
		try {
			boolean suc = dao.deleteEntity(dictItem);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	@Override
	public <T> Result deleteByIdsPhysical(List<T> ids) {
		return super.deleteByIdsPhysical(ids);
	}

	@Override
	public <T> Result deleteByIdsLogical(List<T> ids) {
		return super.deleteByIdsLogical(ids);
	}

	/**
	 * 按主键删除 数据字典条目
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		DictItem dictItem = new DictItem();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		dictItem.setId(id);
		dictItem.setDeleted(true);
		dictItem.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		dictItem.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(dictItem,SaveMode.NOT_NULL_FIELDS);
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
	 * @param dictItem 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(DictItem dictItem , SaveMode mode) {
		return super.update(dictItem , mode);
	}



	/**
	 * 更新实体集，事务内
	 * @param dictItemList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<DictItem> dictItemList , SaveMode mode) {
		return super.updateList(dictItemList , mode);
	}


	/**
	 * 按主键更新字段 数据字典条目
	 *
	 * @param id ID
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	}


	/**
	 * 按主键获取 数据字典条目
	 *
	 * @param id ID
	 * @return DictItem 数据对象
	 */
	public DictItem getById(String id) {
		DictItem sample = new DictItem();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<DictItem> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}


	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	@Cached(strategies = {"query-list","query-code"})
	public List<DictItem> queryList(DictItem sample) {
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
	public PagedList<DictItem> queryPagedList(DictItem sample, int pageSize, int pageIndex) {
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
	public PagedList<DictItem> queryPagedList(DictItem sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param dictItem 数据对象
	 * @return 判断结果
	 */
	public Result<DictItem> checkExists(DictItem dictItem) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(dictItem, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(DictItem sample) {
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
	public <T> Map<T, ReferCause> hasRefers(List<T> ids) {
		return null;
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}
