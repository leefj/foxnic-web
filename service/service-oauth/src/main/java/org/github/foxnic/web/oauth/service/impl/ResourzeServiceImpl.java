package org.github.foxnic.web.oauth.service.impl;


import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.log.PerformanceLogger;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.FieldsBuilder;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.enums.system.AccessType;
import org.github.foxnic.web.domain.oauth.Resourze;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.oauth.service.IResourzeService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * <p>
 * 系统资源 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-07-03 18:46:21
*/


@Service("SysResourzeService")
public class ResourzeServiceImpl extends SuperService<Resourze> implements IResourzeService {



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
	 * @param resourze 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Resourze resourze) {
		Result result=super.insert(resourze,false);
		if(result.success()) {
			clearCatchedResourzes();
		}
		return result;
	}

	/**
	 * 批量插入实体，事务内
	 * @param resourzeList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Resourze> resourzeList) {
		Result result= super.insertList(resourzeList);
		if(result.success()) {
			clearCatchedResourzes();
		}
		return result;
	}


	/**
	 * 按主键删除 系统资源
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Resourze resourze = new Resourze();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		resourze.setId(id);
		try {
			boolean suc = dao.deleteEntity(resourze);
			if(suc) {
				clearCatchedResourzes();
			}
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 按主键删除 系统资源
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		Resourze resourze = new Resourze();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		resourze.setId(id);
		resourze.setDeleted(true);
		resourze.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		resourze.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(resourze,SaveMode.NOT_NULL_FIELDS);
			if(suc) {
				clearCatchedResourzes();
			}
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
	 * @param resourze 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Resourze resourze , SaveMode mode) {
		Result result=super.update(resourze , mode);
		if(result.success()) {
			clearCatchedResourzes();
		}
		return result;
	}

	/**
	 * 更新实体集，事务内
	 * @param resourzeList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Resourze> resourzeList , SaveMode mode) {
		Result result=super.updateList(resourzeList , mode);
		if(result.success()) {
			clearCatchedResourzes();
		}
		return result;
	}


	/**
	 * 按主键更新字段 系统资源
	 *
	 * @param id ID
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		if(suc>0) {
			clearCatchedResourzes();
		}
		return suc>0;
	}


	/**
	 * 按主键获取 系统资源
	 *
	 * @param id ID
	 * @return Resourze 数据对象
	 */
	public Resourze getById(String id) {
		Resourze sample = new Resourze();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Resourze> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Resourze> queryList(Resourze sample) {
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
	public PagedList<Resourze> queryPagedList(Resourze sample, int pageSize, int pageIndex) {
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
	public PagedList<Resourze> queryPagedList(Resourze sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param resourze 数据对象
	 * @return 判断结果
	 */
	public Result<Resourze> checkExists(Resourze resourze) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(resourze, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(Resourze sample) {
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

	private Map<String,Resourze>  catchedResourzes=new HashMap<>();
	// private List<AntPathRequestMatcher>  catchedAntPathRequestMatchers=null;
	private Map<String,AccessType>  catchedAccessTypes=new HashMap<>();

	private void clearCatchedResourzes() {
		this.catchedResourzes.clear();
		//this.catchedAntPathRequestMatchers=null;
		this.catchedAccessTypes.clear();
	}

	public List<Resourze> queryCachedResourzes(Collection<String> resIds) {
		initCache();
		List<Resourze> resourzes=new ArrayList<>(resIds.size());

		for (String resId : resIds) {
			Resourze resourze=catchedResourzes.get(resId);
			if(resourze!=null) {
				resourzes.add(resourze);
			}
		}
		return resourzes;
	}

	@Override
	public List<Resourze> getMatched(HttpServletRequest request) {

		initCache();

		PerformanceLogger logger=new PerformanceLogger(false);
		logger.collect("A");
		//
		AntPathRequestMatcher ant = null;
		RequestMatcher.MatchResult result=null;
		List<Resourze> matchs=new ArrayList<>();
		List<Resourze> all=new ArrayList<>();
		all.addAll(catchedResourzes.values());
		for (Resourze resourze : all) {

//		}
//		for (int i = 0; i < catchedResourzes.size(); i++) {
//			Resourze resourze =catchedResourzes.get(i);
			ant =new AntPathRequestMatcher(resourze.getUrl(),resourze.getMethod(),true);
			//AntPathRequestMatcher ant=catchedAntPathRequestMatchers.get(i);
			result=ant.matcher(request);
			if(result.isMatch()) {
				matchs.add(resourze);
			}
		}
		logger.collect("B:");
		logger.info("getMatched");

		return matchs;
	}

	private void initCache() {
		if(catchedResourzes.isEmpty()) {
			synchronized (catchedResourzes) {
				if(catchedResourzes.isEmpty()) {
					//载入所有资源
					FieldsBuilder fields = this.createFieldsBuilder();
					fields.removeAll().add(FoxnicWeb.SYS_RESOURZE.ID, FoxnicWeb.SYS_RESOURZE.URL, FoxnicWeb.SYS_RESOURZE.METHOD, FoxnicWeb.SYS_RESOURZE.ACCESS_TYPE, FoxnicWeb.SYS_RESOURZE.TYPE);
					List<Resourze> list = this.queryList(fields, new ConditionExpr("length(url)>0"));
					catchedResourzes = CollectorUtil.collectMap(list, Resourze::getId, r -> {
						if(r.getAccessTypeEnum()==null) {
							r.setAccessTypeEnum(AccessType.GRANT);
						}
						return r;
					});
					catchedAccessTypes.clear();
				}
			}
		}
	}

	public AccessType getAccessType(HttpServletRequest request) {
		AccessType accessType = null;
		String key=(request.getRequestURI()+request.getMethod()).toLowerCase();
		if(catchedAccessTypes!=null) {
			accessType = catchedAccessTypes.get(key);
			if (accessType != null) return accessType;
		}

		List<Resourze> resourzes=this.getMatched(request);
		if(resourzes==null || resourzes.isEmpty()) {
			return AccessType.GRANT;
		}
		List<AccessType> accessTypes=new ArrayList<>();
		for (Resourze resourze : resourzes) {
			if(accessTypes.contains(resourze.getAccessTypeEnum())) continue;
			accessTypes.add(resourze.getAccessTypeEnum());
		}
		if(accessTypes.size()==1) {
			accessType=accessTypes.get(0);
			catchedAccessTypes.put(key,accessType);
			return accessType;
		} else {
			throw new RuntimeException("资源授权类型不一致，无法处理");
		}
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}
