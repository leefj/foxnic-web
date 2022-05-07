package org.github.foxnic.web.job.service.impl;


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
import com.github.foxnic.springboot.spring.SpringUtil;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.constants.enums.job.LogType;
import org.github.foxnic.web.domain.job.Job;
import org.github.foxnic.web.domain.job.JobLog;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.job.service.IJobLogService;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 定时任务执行日志表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-01-05 16:46:32
 * @version
*/


@Service("SysJobLogService")
public class JobLogServiceImpl extends SuperService<JobLog> implements IJobLogService {

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
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param jobLog  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(JobLog jobLog,boolean throwsException) {
		Result r=super.insert(jobLog,throwsException);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param jobLog 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(JobLog jobLog) {
		return this.insert(jobLog,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param jobLogList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<JobLog> jobLogList) {
		return super.insertList(jobLogList);
	}


	/**
	 * 按主键删除 定时任务执行日志
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		JobLog jobLog = new JobLog();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		jobLog.setId(id);
		try {
			boolean suc = dao.deleteEntity(jobLog);
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
	 * @param jobLog 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(JobLog jobLog , SaveMode mode) {
		return this.update(jobLog,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param jobLog 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(JobLog jobLog , SaveMode mode,boolean throwsException) {
		Result r=super.update(jobLog , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param jobLogList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<JobLog> jobLogList , SaveMode mode) {
		return super.updateList(jobLogList , mode);
	}


	/**
	 * 按主键更新字段 定时任务执行日志
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
	 * 按主键获取 定时任务执行日志
	 *
	 * @param id 主键
	 * @return JobLog 数据对象
	 */
	public JobLog getById(String id) {
		JobLog sample = new JobLog();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<JobLog> getByIds(List<String> ids) {
		return super.queryListByUKeys(ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<JobLog> queryList(JobLog sample) {
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
	public PagedList<JobLog> queryPagedList(JobLog sample, int pageSize, int pageIndex) {
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
	public PagedList<JobLog> queryPagedList(JobLog sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param jobLog 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(JobLog jobLog) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(jobLog, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(JobLog sample) {
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
	public JobLog startLog(Job job, String tid, LogType logType) {
		JobLog log=JobLog.create();
		log.setClassName(job.getWorker().getClassName());
		log.setCronExpr(job.getCronExpr());
		log.setJobId(job.getId());
		log.setConcurrent(job.getConcurrent());
		log.setMisfirePolicy(job.getMisfirePolicy());
		log.setTypeEnum(logType);
		log.setNodeId(SpringUtil.getNodeInstanceId());
		log.setTid(tid);
		if(SessionUser.getCurrent()!=null) {
			log.setUserId(SessionUser.getCurrent().getUserId());
		}
		log.setBeginTime(new Timestamp(System.currentTimeMillis()));
		log.setJobName(job.getName());
		log.setSuccess(0);
		this.dao().pausePrintThreadSQL();
		this.insert(log);
		this.dao().resumePrintThreadSQL();
		return log;
	}

	@Override
	public JobLog startLog(Job job) {
		return startLog(job,null,null);
	}


	@Override
	public void updateLog(JobLog log) {
		if(log.getEndTime()==null) {
			log.setEndTime(new Timestamp(System.currentTimeMillis()));
		}
		if(log.getBeginTime()!=null) {
			log.setCost(log.getEndTime().getTime() - log.getBeginTime().getTime());
		}
		this.dao().pausePrintThreadSQL();
		this.updateDirtyFields(log);
		this.dao().resumePrintThreadSQL();
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}
