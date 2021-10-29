package org.github.foxnic.web.dataperm.service.impl;


import com.github.foxnic.api.dataperm.ConditionNodeType;
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
import org.github.foxnic.web.dataperm.service.IRuleConditionService;
import org.github.foxnic.web.dataperm.service.IRuleRangeService;
import org.github.foxnic.web.domain.dataperm.RuleCondition;
import org.github.foxnic.web.domain.dataperm.RuleRange;
import org.github.foxnic.web.framework.dao.DBConfigs;
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
 * 数据权限规则范围表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-29 13:21:30
 * @version
*/


@Service("DpRuleRangeService")
public class RuleRangeServiceImpl extends SuperService<RuleRange> implements IRuleRangeService {

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
	private IRuleConditionService ruleConditionService;


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param ruleRange  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	@Transactional
	public Result insert(RuleRange ruleRange,boolean throwsException) {
		Result r=super.insert(ruleRange,throwsException);
		if(r.success()) {
			RuleCondition condition=new RuleCondition();
			condition.setRuleId(ruleRange.getRuleId());
			condition.setRangeId(ruleRange.getId());
			condition.setParentId(IRuleConditionService.ROOT_ID);
			condition.setTypeEnum(ConditionNodeType.group);
			ruleConditionService.insert(condition);
		}
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param ruleRange 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(RuleRange ruleRange) {
		return this.insert(ruleRange,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param ruleRangeList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<RuleRange> ruleRangeList) {
		return super.insertList(ruleRangeList);
	}


	/**
	 * 按主键删除 数据权限规则范围
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		RuleRange ruleRange = new RuleRange();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		ruleRange.setId(id);
		try {
			boolean suc = dao.deleteEntity(ruleRange);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 按主键删除 数据权限规则范围
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		RuleRange ruleRange = new RuleRange();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		ruleRange.setId(id);
		ruleRange.setDeleted(dao.getDBTreaty().getTrueValue());
		ruleRange.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		ruleRange.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(ruleRange,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 更新，如果执行错误，则抛出异常
	 * @param ruleRange 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(RuleRange ruleRange , SaveMode mode) {
		return this.update(ruleRange,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param ruleRange 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(RuleRange ruleRange , SaveMode mode,boolean throwsException) {
		Result r=super.update(ruleRange , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param ruleRangeList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<RuleRange> ruleRangeList , SaveMode mode) {
		return super.updateList(ruleRangeList , mode);
	}


	/**
	 * 按主键更新字段 数据权限规则范围
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
	 * 按主键获取 数据权限规则范围
	 *
	 * @param id 主键
	 * @return RuleRange 数据对象
	 */
	public RuleRange getById(String id) {
		RuleRange sample = new RuleRange();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<RuleRange> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<RuleRange> queryList(RuleRange sample) {
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
	public PagedList<RuleRange> queryPagedList(RuleRange sample, int pageSize, int pageIndex) {
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
	public PagedList<RuleRange> queryPagedList(RuleRange sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param ruleRange 数据对象
	 * @return 判断结果
	 */
	public Result<RuleRange> checkExists(RuleRange ruleRange) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(ruleRange, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(RuleRange sample) {
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
