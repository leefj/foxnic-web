package org.github.foxnic.web.job.service.impl;


import com.alibaba.fastjson.JSON;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.constants.enums.job.LogType;
import org.github.foxnic.web.domain.job.Job;
import org.github.foxnic.web.domain.job.JobLog;
import org.github.foxnic.web.domain.job.meta.JobMeta;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.job.service.IJobLogService;
import org.github.foxnic.web.job.service.IJobService;
import org.github.foxnic.web.job.utils.ScheduleUtils;
import org.quartz.CronExpression;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 定时任务配置表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-31 11:54:54
 * @version
*/


@Service("SysJobService")
public class JobServiceImpl extends SuperService<Job> implements IJobService {

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
	private IJobLogService logService;



	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param job  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(Job job,boolean throwsException) {
		Result r=super.insert(job,throwsException);
		if(r.success()) {
			this.join(job, JobMeta.WORKER);
			try {
				ScheduleUtils.createScheduleJob(job);
			} catch (Exception e) {
				return ErrorDesc.failure().message("数据保存成功，但调度计划保存失败");
			}
		}

		// 记录配置日志
		JobLog log=logService.startLog(job);
		log.setTypeEnum(LogType.CONFIG);
		log.setSuccess(1);
		log.setResult("insert , data : "+JSON.toJSONString(job));
		logService.updateLog(log);

		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param job 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Job job) {
		return this.insert(job,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param jobList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Job> jobList) {
		return super.insertList(jobList);
	}


	/**
	 * 按主键删除 定时任务配置
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {

		Job before=this.getById(id);
		this.join(before, JobMeta.WORKER);

		Job job = new Job();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		job.setId(id);
		try {
			boolean suc = dao.deleteEntity(job);

			// 记录配置日志
			JobLog log=logService.startLog(before);
			log.setTypeEnum(LogType.CONFIG);
			log.setSuccess(1);
			log.setResult("delete , before : "+JSON.toJSONString(before));
			logService.updateLog(log);

			if(suc) {
				try {
					ScheduleUtils.deleteScheduleJob(id);
				} catch (Exception e) {
					return ErrorDesc.failure().message("调度配置删除成功，但调度计划删除失败");
				}
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
	 * 按主键删除 定时任务配置
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {

		Job before=this.getById(id);
		this.join(before, JobMeta.WORKER);

		Job job = new Job();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		job.setId(id);
		job.setDeleted(dao.getDBTreaty().getTrueValue());
		job.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		job.setDeleteTime(new Date());



		try {
			boolean suc = dao.updateEntity(job,SaveMode.NOT_NULL_FIELDS);

			// 记录配置日志
			JobLog log=logService.startLog(before);
			log.setTypeEnum(LogType.CONFIG);
			log.setSuccess(1);
			log.setResult("delete , before : "+JSON.toJSONString(before));
			logService.updateLog(log);

			if(suc) {
				try {
					ScheduleUtils.deleteScheduleJob(id);
				} catch (Exception e) {
					return ErrorDesc.failure().message("调度配置删除成功，但调度计划删除失败");
				}
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
	 * 更新，如果执行错误，则抛出异常
	 * @param job 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Job job , SaveMode mode) {
		return this.update(job,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param job 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Job job , SaveMode mode,boolean throwsException) {

		Job before=this.getById(job.getId());
		this.join(before, JobMeta.WORKER);

		Result r=super.update(job , mode , throwsException);
		if(r.success()) {
			job=this.getById(job.getId());
			this.join(job, JobMeta.WORKER);
			try {
				ScheduleUtils.updateScheduleJob(job);
			} catch (Exception e) {
				return ErrorDesc.failure().message("数据保存成功，但调度计划保存失败");
			}
		}

		// 记录配置日志
		JobLog log=logService.startLog(job);
		log.setTypeEnum(LogType.CONFIG);
		log.setSuccess(1);
		log.setResult("update , before : "+JSON.toJSONString(before)+" , after : "+JSON.toJSONString(job));
		logService.updateLog(log);

		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param jobList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Job> jobList , SaveMode mode) {
		return super.updateList(jobList , mode);
	}


	/**
	 * 按主键更新字段 定时任务配置
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
	 * 按主键获取 定时任务配置
	 *
	 * @param id 主键
	 * @return Job 数据对象
	 */
	public Job getById(String id) {
		Job sample = new Job();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Job> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Job> queryList(Job sample) {
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
	public PagedList<Job> queryPagedList(Job sample, int pageSize, int pageIndex) {
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
	public PagedList<Job> queryPagedList(Job sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param job 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(Job job) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(job, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(Job sample) {
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
	public Result invoke(String id) {
		Job job=this.getById(id);
		this.join(job,JobMeta.WORKER);
		try {
			ScheduleUtils.run(job,true);
		} catch (SchedulerException e) {
			Logger.exception("调度失败 , "+JSON.toJSONString(job),e);
			return ErrorDesc.exception(e).message("调度失败");
		}
		return ErrorDesc.success().message("调度成功，可前往日志查看执行情况");
	}

	@Override
	public Result simulate(String cronExpr) {

//		CronSequenceGenerator generator = null;
		CronExpression expression = null;
		try {
			expression=new CronExpression(cronExpr);
//			generator = new CronSequenceGenerator(cronExpr);
		} catch (Exception e) {
			return ErrorDesc.failure().message(e.getMessage());
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<String> list = new ArrayList<>(10);
		Date nextTimePoint = new Date();

		for (int i = 0; i < 10; i++) {
			// 计算下次时间点的开始时间
//			nextTimePoint = generator.next(nextTimePoint);
			nextTimePoint = expression.getNextValidTimeAfter(nextTimePoint);
			String w=DateUtil.getChineseWeek(nextTimePoint,true);
			String time = sdf.format(nextTimePoint);
			time=time.replace(" "," , "+w+"&nbsp;");
			list.add(time);
		}

		return ErrorDesc.success().data(list);
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}
