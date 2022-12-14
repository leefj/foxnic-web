package org.github.foxnic.web.system.service.impl;


import com.github.foxnic.api.cache.Cached;
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
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.domain.system.Config;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.system.service.IConfigService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 系统配置表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-03 09:07:26
 * @version
*/


@Service("SysConfigService")
public class ConfigServiceImpl extends SuperService<Config> implements IConfigService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }

	private List<String> appliedProfileIds;

	@Value("${foxnic.config.profiles:}")
	public void setAppliedProfileIds(String value) {
		appliedProfileIds = new ArrayList<>();
		appliedProfileIds.add(IConfigService.DEFAULT_PROFILE_ID);
		if(StringUtil.isBlank(value)) {
			return;
		}
 		String[] t=value.split(",");
		for (String s : t) {
			if(StringUtil.isBlank(s)) continue;
			s=s.trim();
			if(appliedProfileIds.contains(s)) continue;
			appliedProfileIds.add(s);
		}
		Collections.reverse(appliedProfileIds);
	}

	public List<String> getAppliedProfileIds() {
		return appliedProfileIds;
	}

	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param config  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(Config config,boolean throwsException) {
		Result r=super.insert(config,throwsException);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param config 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Config config) {
		return this.insert(config,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param configList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Config> configList) {
		return super.insertList(configList);
	}


	/**
	 * 按主键删除 系统配置
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Config config = new Config();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		config.setId(id);
		try {
			boolean suc = dao.deleteEntity(config);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 按主键删除 系统配置
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		Config config = new Config();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		config.setId(id);
		config.setDeleted(true);
		config.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		config.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(config,SaveMode.NOT_NULL_FIELDS);
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
	 * @param config 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Config config , SaveMode mode) {
		return this.update(config,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param config 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Config config , SaveMode mode,boolean throwsException) {
		Result r=super.update(config , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param configList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Config> configList , SaveMode mode) {
		return super.updateList(configList , mode);
	}


	/**
	 * 按主键更新字段 系统配置
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
	 * 按主键获取 系统配置
	 *
	 * @param id 主键
	 * @return Config 数据对象
	 */
	public Config getById(String id) {
		Config sample = new Config();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Config> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Config getByCode(SystemConfigEnum configEnum) {
		return getByCode(configEnum.code());
	}

	@Override
	@Cached("by-code")
	public Config getByCode(String code) {
		if(StringUtil.isBlank(code)) return null;
		Config sample=new Config();
		sample.setCode(code);
		Config cata = null;
		for (String appliedProfileId : appliedProfileIds) {
			if(IConfigService.DEFAULT_PROFILE_ID.equals(appliedProfileId)) continue;
			sample.setProfileId(appliedProfileId);
			cata=this.queryEntity(sample);
			if(cata!=null && cata.getValue()!=null){
				break;
			}
		}
		//识别未指定 profile 的情况
		if(cata==null || cata.getValue()==null) {
			sample.setProfileId(null);
			cata = this.queryEntity(sample);
		}
		return cata;
	}

	@Override
	public List<Config> getByCodes(List<String> codes) {
		List<Config> list = new ArrayList<>();
		for (String code : codes) {
			Config config =  this.getByCode(code);
			if(config!=null) {
				list.add(config);
			}
		}
		return list;
	}


	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Config> queryList(Config sample) {
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
	public PagedList<Config> queryPagedList(Config sample, int pageSize, int pageIndex) {
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
	public PagedList<Config> queryPagedList(Config sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param config 数据对象
	 * @return 判断结果
	 */
	public Result<Config> checkExists(Config config) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(config, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(Config sample) {
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
