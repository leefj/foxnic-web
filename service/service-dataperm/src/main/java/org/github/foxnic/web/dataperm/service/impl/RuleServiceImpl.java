package org.github.foxnic.web.dataperm.service.impl;


import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.meta.DBTableMeta;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.dataperm.service.IRuleService;
import org.github.foxnic.web.domain.dataperm.Rule;
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
 * 数据权限规则表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-25 17:06:04
 * @version
*/


@Service("DpRuleService")
public class RuleServiceImpl extends SuperService<Rule> implements IRuleService {

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
	 * @param rule 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Rule rule) {
		DBTableMeta tm=this.dao().getTableMeta(rule.getDataTable());
		if(tm==null) {
			return  ErrorDesc.failure().message("数据表不存在");
		}
		if(StringUtil.isBlank(rule.getCode())) {
			rule.setCode(tm.getTableName().toUpperCase());
		}
		if(StringUtil.isBlank(rule.getName())) {
			rule.setCode(tm.getTopic());
		}
		Result r=super.insert(rule);
		return r;
	}

	/**
	 * 批量插入实体，事务内
	 * @param ruleList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Rule> ruleList) {
		return super.insertList(ruleList);
	}


	/**
	 * 按主键删除 数据权限规则
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Rule rule = new Rule();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		rule.setId(id);
		try {
			boolean suc = dao.deleteEntity(rule);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 按主键删除 数据权限规则
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		Rule rule = new Rule();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		rule.setId(id);
		rule.setDeleted(dao.getDBTreaty().getTrueValue());
		rule.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		rule.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(rule,SaveMode.NOT_NULL_FIELDS);
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
	 * @param rule 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Rule rule , SaveMode mode) {
		Result r=super.update(rule , mode);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param ruleList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Rule> ruleList , SaveMode mode) {
		return super.updateList(ruleList , mode);
	}


	/**
	 * 按主键更新字段 数据权限规则
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
	 * 按主键获取 数据权限规则
	 *
	 * @param id 主键
	 * @return Rule 数据对象
	 */
	public Rule getById(String id) {
		Rule sample = new Rule();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Rule> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Rule> queryList(Rule sample) {
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
	public PagedList<Rule> queryPagedList(Rule sample, int pageSize, int pageIndex) {
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
	public PagedList<Rule> queryPagedList(Rule sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param rule 数据对象
	 * @return 判断结果
	 */
	public Result<Rule> checkExists(Rule rule) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(rule, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(Rule sample) {
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
