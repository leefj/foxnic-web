package org.github.foxnic.web.job.controller;


import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import org.github.foxnic.web.proxy.job.JobLogServiceProxy;
import org.github.foxnic.web.domain.job.meta.JobLogVOMeta;
import org.github.foxnic.web.domain.job.JobLog;
import org.github.foxnic.web.domain.job.JobLogVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.dao.data.PagedList;
import java.util.Date;
import java.sql.Timestamp;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.commons.io.StreamUtil;
import java.util.Map;
import com.github.foxnic.dao.excel.ValidateResult;
import java.io.InputStream;
import org.github.foxnic.web.domain.job.meta.JobLogMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.job.service.IJobLogService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 定时任务执行日志表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-25 13:14:14
*/

@Api(tags = "定时任务执行日志")
@ApiSort(0)
@RestController("SysJobLogController")
public class JobLogController extends SuperController {

	@Autowired
	private IJobLogService jobLogService;


	/**
	 * 添加定时任务执行日志
	*/
	@ApiOperation(value = "添加定时任务执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "597691387701362688"),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_ID , value = "组别" , required = false , dataTypeClass=String.class , example = "547506505981624320"),
		@ApiImplicitParam(name = JobLogVOMeta.TYPE , value = "日志分类" , required = false , dataTypeClass=String.class , example = "config"),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_NAME , value = "任务名称" , required = false , dataTypeClass=String.class , example = "监控zabbix客户端数据采集"),
		@ApiImplicitParam(name = JobLogVOMeta.CLASS_NAME , value = "本次执行类" , required = false , dataTypeClass=String.class , example = "com.dt.platform.job.ops.MonitorZabbixAgentCollectDataExecutor"),
		@ApiImplicitParam(name = JobLogVOMeta.CRON_EXPR , value = "本次执行cron表达式" , required = false , dataTypeClass=String.class , example = "0 0/2 * * * ?"),
		@ApiImplicitParam(name = JobLogVOMeta.PARAMETER , value = "本次执行参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.SUCCESS , value = "是否成功执行" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = JobLogVOMeta.RESULT , value = "执行结果" , required = false , dataTypeClass=String.class , example = "update , before : {\"concurrent\":0,\"createBy\":\"110588348101165911\",\"createTime\":1645271723000,\"cronExpr\":\"0 0/2 * * * ?\",\"deleted\":0,\"id\":\"547506505981624320\",\"misfirePolicy\":\"do_nothing\",\"misfirePolicyEnum\":\"DO_NOTHING\",\"name\":\"监控zabbix客户端数据采集\",\"notes\":\"\",\"parameter\":\"\",\"status\":\"paused\",\"statusEnum\":\"PAUSED\",\"tenantId\":\"T001\",\"updateBy\":\"110588348101165911\",\"updateTime\":1646196190000,\"version\":4,\"workerId\":\"547502957910818816\"} , after : {\"code\":\"\",\"concurrent\":0,\"createBy\":\"110588348101165911\",\"createTime\":1645271723000,\"cronExpr\":\"0 0/2 * * * ?\",\"deleted\":0,\"id\":\"547506505981624320\",\"misfirePolicy\":\"do_nothing\",\"misfirePolicyEnum\":\"DO_NOTHING\",\"name\":\"监控zabbix客户端数据采集\",\"notes\":\"\",\"parameter\":\"\",\"status\":\"paused\",\"statusEnum\":\"PAUSED\",\"tenantId\":\"T001\",\"updateBy\":\"110588348101165911\",\"updateTime\":1657236730000,\"version\":5,\"worker\":{\"className\":\"com.dt.platform.job.ops.MonitorZabbixAgentCollectDataExecutor\",\"id\":\"597670498230337536\",\"name\":\"MonitorZabbixAgentCollectDataExecutor\",\"valid\":1},\"workerId\":\"597670498230337536\"}"),
		@ApiImplicitParam(name = JobLogVOMeta.BEGIN_TIME , value = "开始执行的时间" , required = false , dataTypeClass=Timestamp.class , example = "2022-07-08 07:32:11.395"),
		@ApiImplicitParam(name = JobLogVOMeta.END_TIME , value = "结束执行的时间" , required = false , dataTypeClass=Timestamp.class , example = "2022-07-08 07:32:11.503"),
		@ApiImplicitParam(name = JobLogVOMeta.COST , value = "执行耗时" , required = false , dataTypeClass=Long.class , example = "108"),
		@ApiImplicitParam(name = JobLogVOMeta.EXCEPTION , value = "异常信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.LOG_TEXT , value = "日志信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.USER_ID , value = "账户ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MANUAL , value = "是否是手动执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MISSFIRE , value = "是否为丢失补充执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.CONCURRENT , value = "是否并发执行（0允许" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = JobLogVOMeta.MISFIRE_POLICY , value = "遗漏执行的策略" , required = false , dataTypeClass=String.class , example = "do_nothing"),
		@ApiImplicitParam(name = JobLogVOMeta.TID , value = "日志跟踪ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.NODE_ID , value = "节点ID" , required = false , dataTypeClass=String.class , example = "8a-780717dbc5-9e58")
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = JobLogServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobLogServiceProxy.INSERT)
	public Result insert(JobLogVO jobLogVO) {
		Result result=jobLogService.insert(jobLogVO,false);
		return result;
	}



	/**
	 * 删除定时任务执行日志
	*/
	@ApiOperation(value = "删除定时任务执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "597691387701362688")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = JobLogVOMeta.ID)
	@SentinelResource(value = JobLogServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobLogServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		Boolean hasRefer = jobLogService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(hasRefer).requireEqual("不允许删除当前记录",false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=jobLogService.deleteByIdPhysical(id);
		return result;
	}


	/**
	 * 批量删除定时任务执行日志 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除定时任务执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = JobLogVOMeta.IDS)
	@SentinelResource(value = JobLogServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobLogServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, Boolean> hasRefersMap = jobLogService.hasRefers(ids);
		// 收集可以删除的ID值
		List<String> canDeleteIds = new ArrayList<>();
		for (Map.Entry<String, Boolean> e : hasRefersMap.entrySet()) {
			if (!e.getValue()) {
				canDeleteIds.add(e.getKey());
			}
		}

		// 执行删除
		if (canDeleteIds.isEmpty()) {
			// 如果没有一行可以被删除
			return ErrorDesc.failure().message("无法删除您选中的数据行");
		} else if (canDeleteIds.size() == ids.size()) {
			// 如果全部可以删除
			Result result=jobLogService.deleteByIdsPhysical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=jobLogService.deleteByIdsPhysical(canDeleteIds);
			if (result.failure()) {
				return result;
			} else {
				return ErrorDesc.success().message("已删除 " + canDeleteIds.size() + " 行，但另有 " + (ids.size() - canDeleteIds.size()) + " 行数据无法删除").messageLevel4Confirm();
			}
		} else {
			// 理论上，这个分支不存在
			return ErrorDesc.success().message("数据删除未处理");
		}
	}

	/**
	 * 更新定时任务执行日志
	*/
	@ApiOperation(value = "更新定时任务执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "597691387701362688"),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_ID , value = "组别" , required = false , dataTypeClass=String.class , example = "547506505981624320"),
		@ApiImplicitParam(name = JobLogVOMeta.TYPE , value = "日志分类" , required = false , dataTypeClass=String.class , example = "config"),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_NAME , value = "任务名称" , required = false , dataTypeClass=String.class , example = "监控zabbix客户端数据采集"),
		@ApiImplicitParam(name = JobLogVOMeta.CLASS_NAME , value = "本次执行类" , required = false , dataTypeClass=String.class , example = "com.dt.platform.job.ops.MonitorZabbixAgentCollectDataExecutor"),
		@ApiImplicitParam(name = JobLogVOMeta.CRON_EXPR , value = "本次执行cron表达式" , required = false , dataTypeClass=String.class , example = "0 0/2 * * * ?"),
		@ApiImplicitParam(name = JobLogVOMeta.PARAMETER , value = "本次执行参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.SUCCESS , value = "是否成功执行" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = JobLogVOMeta.RESULT , value = "执行结果" , required = false , dataTypeClass=String.class , example = "update , before : {\"concurrent\":0,\"createBy\":\"110588348101165911\",\"createTime\":1645271723000,\"cronExpr\":\"0 0/2 * * * ?\",\"deleted\":0,\"id\":\"547506505981624320\",\"misfirePolicy\":\"do_nothing\",\"misfirePolicyEnum\":\"DO_NOTHING\",\"name\":\"监控zabbix客户端数据采集\",\"notes\":\"\",\"parameter\":\"\",\"status\":\"paused\",\"statusEnum\":\"PAUSED\",\"tenantId\":\"T001\",\"updateBy\":\"110588348101165911\",\"updateTime\":1646196190000,\"version\":4,\"workerId\":\"547502957910818816\"} , after : {\"code\":\"\",\"concurrent\":0,\"createBy\":\"110588348101165911\",\"createTime\":1645271723000,\"cronExpr\":\"0 0/2 * * * ?\",\"deleted\":0,\"id\":\"547506505981624320\",\"misfirePolicy\":\"do_nothing\",\"misfirePolicyEnum\":\"DO_NOTHING\",\"name\":\"监控zabbix客户端数据采集\",\"notes\":\"\",\"parameter\":\"\",\"status\":\"paused\",\"statusEnum\":\"PAUSED\",\"tenantId\":\"T001\",\"updateBy\":\"110588348101165911\",\"updateTime\":1657236730000,\"version\":5,\"worker\":{\"className\":\"com.dt.platform.job.ops.MonitorZabbixAgentCollectDataExecutor\",\"id\":\"597670498230337536\",\"name\":\"MonitorZabbixAgentCollectDataExecutor\",\"valid\":1},\"workerId\":\"597670498230337536\"}"),
		@ApiImplicitParam(name = JobLogVOMeta.BEGIN_TIME , value = "开始执行的时间" , required = false , dataTypeClass=Timestamp.class , example = "2022-07-08 07:32:11.395"),
		@ApiImplicitParam(name = JobLogVOMeta.END_TIME , value = "结束执行的时间" , required = false , dataTypeClass=Timestamp.class , example = "2022-07-08 07:32:11.503"),
		@ApiImplicitParam(name = JobLogVOMeta.COST , value = "执行耗时" , required = false , dataTypeClass=Long.class , example = "108"),
		@ApiImplicitParam(name = JobLogVOMeta.EXCEPTION , value = "异常信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.LOG_TEXT , value = "日志信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.USER_ID , value = "账户ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MANUAL , value = "是否是手动执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MISSFIRE , value = "是否为丢失补充执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.CONCURRENT , value = "是否并发执行（0允许" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = JobLogVOMeta.MISFIRE_POLICY , value = "遗漏执行的策略" , required = false , dataTypeClass=String.class , example = "do_nothing"),
		@ApiImplicitParam(name = JobLogVOMeta.TID , value = "日志跟踪ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.NODE_ID , value = "节点ID" , required = false , dataTypeClass=String.class , example = "8a-780717dbc5-9e58")
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { JobLogVOMeta.PAGE_INDEX , JobLogVOMeta.PAGE_SIZE , JobLogVOMeta.SEARCH_FIELD , JobLogVOMeta.FUZZY_FIELD , JobLogVOMeta.SEARCH_VALUE , JobLogVOMeta.DIRTY_FIELDS , JobLogVOMeta.SORT_FIELD , JobLogVOMeta.SORT_TYPE , JobLogVOMeta.IDS } )
	@SentinelResource(value = JobLogServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobLogServiceProxy.UPDATE)
	public Result update(JobLogVO jobLogVO) {
		Result result=jobLogService.update(jobLogVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存定时任务执行日志
	*/
	@ApiOperation(value = "保存定时任务执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "597691387701362688"),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_ID , value = "组别" , required = false , dataTypeClass=String.class , example = "547506505981624320"),
		@ApiImplicitParam(name = JobLogVOMeta.TYPE , value = "日志分类" , required = false , dataTypeClass=String.class , example = "config"),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_NAME , value = "任务名称" , required = false , dataTypeClass=String.class , example = "监控zabbix客户端数据采集"),
		@ApiImplicitParam(name = JobLogVOMeta.CLASS_NAME , value = "本次执行类" , required = false , dataTypeClass=String.class , example = "com.dt.platform.job.ops.MonitorZabbixAgentCollectDataExecutor"),
		@ApiImplicitParam(name = JobLogVOMeta.CRON_EXPR , value = "本次执行cron表达式" , required = false , dataTypeClass=String.class , example = "0 0/2 * * * ?"),
		@ApiImplicitParam(name = JobLogVOMeta.PARAMETER , value = "本次执行参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.SUCCESS , value = "是否成功执行" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = JobLogVOMeta.RESULT , value = "执行结果" , required = false , dataTypeClass=String.class , example = "update , before : {\"concurrent\":0,\"createBy\":\"110588348101165911\",\"createTime\":1645271723000,\"cronExpr\":\"0 0/2 * * * ?\",\"deleted\":0,\"id\":\"547506505981624320\",\"misfirePolicy\":\"do_nothing\",\"misfirePolicyEnum\":\"DO_NOTHING\",\"name\":\"监控zabbix客户端数据采集\",\"notes\":\"\",\"parameter\":\"\",\"status\":\"paused\",\"statusEnum\":\"PAUSED\",\"tenantId\":\"T001\",\"updateBy\":\"110588348101165911\",\"updateTime\":1646196190000,\"version\":4,\"workerId\":\"547502957910818816\"} , after : {\"code\":\"\",\"concurrent\":0,\"createBy\":\"110588348101165911\",\"createTime\":1645271723000,\"cronExpr\":\"0 0/2 * * * ?\",\"deleted\":0,\"id\":\"547506505981624320\",\"misfirePolicy\":\"do_nothing\",\"misfirePolicyEnum\":\"DO_NOTHING\",\"name\":\"监控zabbix客户端数据采集\",\"notes\":\"\",\"parameter\":\"\",\"status\":\"paused\",\"statusEnum\":\"PAUSED\",\"tenantId\":\"T001\",\"updateBy\":\"110588348101165911\",\"updateTime\":1657236730000,\"version\":5,\"worker\":{\"className\":\"com.dt.platform.job.ops.MonitorZabbixAgentCollectDataExecutor\",\"id\":\"597670498230337536\",\"name\":\"MonitorZabbixAgentCollectDataExecutor\",\"valid\":1},\"workerId\":\"597670498230337536\"}"),
		@ApiImplicitParam(name = JobLogVOMeta.BEGIN_TIME , value = "开始执行的时间" , required = false , dataTypeClass=Timestamp.class , example = "2022-07-08 07:32:11.395"),
		@ApiImplicitParam(name = JobLogVOMeta.END_TIME , value = "结束执行的时间" , required = false , dataTypeClass=Timestamp.class , example = "2022-07-08 07:32:11.503"),
		@ApiImplicitParam(name = JobLogVOMeta.COST , value = "执行耗时" , required = false , dataTypeClass=Long.class , example = "108"),
		@ApiImplicitParam(name = JobLogVOMeta.EXCEPTION , value = "异常信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.LOG_TEXT , value = "日志信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.USER_ID , value = "账户ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MANUAL , value = "是否是手动执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MISSFIRE , value = "是否为丢失补充执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.CONCURRENT , value = "是否并发执行（0允许" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = JobLogVOMeta.MISFIRE_POLICY , value = "遗漏执行的策略" , required = false , dataTypeClass=String.class , example = "do_nothing"),
		@ApiImplicitParam(name = JobLogVOMeta.TID , value = "日志跟踪ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.NODE_ID , value = "节点ID" , required = false , dataTypeClass=String.class , example = "8a-780717dbc5-9e58")
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { JobLogVOMeta.PAGE_INDEX , JobLogVOMeta.PAGE_SIZE , JobLogVOMeta.SEARCH_FIELD , JobLogVOMeta.FUZZY_FIELD , JobLogVOMeta.SEARCH_VALUE , JobLogVOMeta.DIRTY_FIELDS , JobLogVOMeta.SORT_FIELD , JobLogVOMeta.SORT_TYPE , JobLogVOMeta.IDS } )
	@NotNull(name = JobLogVOMeta.ID)
	@SentinelResource(value = JobLogServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobLogServiceProxy.SAVE)
	public Result save(JobLogVO jobLogVO) {
		Result result=jobLogService.save(jobLogVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取定时任务执行日志
	*/
	@ApiOperation(value = "获取定时任务执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = JobLogVOMeta.ID)
	@SentinelResource(value = JobLogServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobLogServiceProxy.GET_BY_ID)
	public Result<JobLog> getById(String id) {
		Result<JobLog> result=new Result<>();
		JobLog jobLog=jobLogService.getById(id);
		result.success(true).data(jobLog);
		return result;
	}


	/**
	 * 批量获取定时任务执行日志 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取定时任务执行日志")
		@ApiImplicitParams({
				@ApiImplicitParam(name = JobLogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = JobLogVOMeta.IDS)
		@SentinelResource(value = JobLogServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobLogServiceProxy.GET_BY_IDS)
	public Result<List<JobLog>> getByIds(List<String> ids) {
		Result<List<JobLog>> result=new Result<>();
		List<JobLog> list=jobLogService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询定时任务执行日志
	*/
	@ApiOperation(value = "查询定时任务执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "597691387701362688"),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_ID , value = "组别" , required = false , dataTypeClass=String.class , example = "547506505981624320"),
		@ApiImplicitParam(name = JobLogVOMeta.TYPE , value = "日志分类" , required = false , dataTypeClass=String.class , example = "config"),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_NAME , value = "任务名称" , required = false , dataTypeClass=String.class , example = "监控zabbix客户端数据采集"),
		@ApiImplicitParam(name = JobLogVOMeta.CLASS_NAME , value = "本次执行类" , required = false , dataTypeClass=String.class , example = "com.dt.platform.job.ops.MonitorZabbixAgentCollectDataExecutor"),
		@ApiImplicitParam(name = JobLogVOMeta.CRON_EXPR , value = "本次执行cron表达式" , required = false , dataTypeClass=String.class , example = "0 0/2 * * * ?"),
		@ApiImplicitParam(name = JobLogVOMeta.PARAMETER , value = "本次执行参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.SUCCESS , value = "是否成功执行" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = JobLogVOMeta.RESULT , value = "执行结果" , required = false , dataTypeClass=String.class , example = "update , before : {\"concurrent\":0,\"createBy\":\"110588348101165911\",\"createTime\":1645271723000,\"cronExpr\":\"0 0/2 * * * ?\",\"deleted\":0,\"id\":\"547506505981624320\",\"misfirePolicy\":\"do_nothing\",\"misfirePolicyEnum\":\"DO_NOTHING\",\"name\":\"监控zabbix客户端数据采集\",\"notes\":\"\",\"parameter\":\"\",\"status\":\"paused\",\"statusEnum\":\"PAUSED\",\"tenantId\":\"T001\",\"updateBy\":\"110588348101165911\",\"updateTime\":1646196190000,\"version\":4,\"workerId\":\"547502957910818816\"} , after : {\"code\":\"\",\"concurrent\":0,\"createBy\":\"110588348101165911\",\"createTime\":1645271723000,\"cronExpr\":\"0 0/2 * * * ?\",\"deleted\":0,\"id\":\"547506505981624320\",\"misfirePolicy\":\"do_nothing\",\"misfirePolicyEnum\":\"DO_NOTHING\",\"name\":\"监控zabbix客户端数据采集\",\"notes\":\"\",\"parameter\":\"\",\"status\":\"paused\",\"statusEnum\":\"PAUSED\",\"tenantId\":\"T001\",\"updateBy\":\"110588348101165911\",\"updateTime\":1657236730000,\"version\":5,\"worker\":{\"className\":\"com.dt.platform.job.ops.MonitorZabbixAgentCollectDataExecutor\",\"id\":\"597670498230337536\",\"name\":\"MonitorZabbixAgentCollectDataExecutor\",\"valid\":1},\"workerId\":\"597670498230337536\"}"),
		@ApiImplicitParam(name = JobLogVOMeta.BEGIN_TIME , value = "开始执行的时间" , required = false , dataTypeClass=Timestamp.class , example = "2022-07-08 07:32:11.395"),
		@ApiImplicitParam(name = JobLogVOMeta.END_TIME , value = "结束执行的时间" , required = false , dataTypeClass=Timestamp.class , example = "2022-07-08 07:32:11.503"),
		@ApiImplicitParam(name = JobLogVOMeta.COST , value = "执行耗时" , required = false , dataTypeClass=Long.class , example = "108"),
		@ApiImplicitParam(name = JobLogVOMeta.EXCEPTION , value = "异常信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.LOG_TEXT , value = "日志信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.USER_ID , value = "账户ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MANUAL , value = "是否是手动执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MISSFIRE , value = "是否为丢失补充执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.CONCURRENT , value = "是否并发执行（0允许" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = JobLogVOMeta.MISFIRE_POLICY , value = "遗漏执行的策略" , required = false , dataTypeClass=String.class , example = "do_nothing"),
		@ApiImplicitParam(name = JobLogVOMeta.TID , value = "日志跟踪ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.NODE_ID , value = "节点ID" , required = false , dataTypeClass=String.class , example = "8a-780717dbc5-9e58")
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { JobLogVOMeta.PAGE_INDEX , JobLogVOMeta.PAGE_SIZE } )
	@SentinelResource(value = JobLogServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobLogServiceProxy.QUERY_LIST)
	public Result<List<JobLog>> queryList(JobLogVO sample) {
		Result<List<JobLog>> result=new Result<>();
		List<JobLog> list=jobLogService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询定时任务执行日志
	*/
	@ApiOperation(value = "分页查询定时任务执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = JobLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "597691387701362688"),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_ID , value = "组别" , required = false , dataTypeClass=String.class , example = "547506505981624320"),
		@ApiImplicitParam(name = JobLogVOMeta.TYPE , value = "日志分类" , required = false , dataTypeClass=String.class , example = "config"),
		@ApiImplicitParam(name = JobLogVOMeta.JOB_NAME , value = "任务名称" , required = false , dataTypeClass=String.class , example = "监控zabbix客户端数据采集"),
		@ApiImplicitParam(name = JobLogVOMeta.CLASS_NAME , value = "本次执行类" , required = false , dataTypeClass=String.class , example = "com.dt.platform.job.ops.MonitorZabbixAgentCollectDataExecutor"),
		@ApiImplicitParam(name = JobLogVOMeta.CRON_EXPR , value = "本次执行cron表达式" , required = false , dataTypeClass=String.class , example = "0 0/2 * * * ?"),
		@ApiImplicitParam(name = JobLogVOMeta.PARAMETER , value = "本次执行参数" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.SUCCESS , value = "是否成功执行" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = JobLogVOMeta.RESULT , value = "执行结果" , required = false , dataTypeClass=String.class , example = "update , before : {\"concurrent\":0,\"createBy\":\"110588348101165911\",\"createTime\":1645271723000,\"cronExpr\":\"0 0/2 * * * ?\",\"deleted\":0,\"id\":\"547506505981624320\",\"misfirePolicy\":\"do_nothing\",\"misfirePolicyEnum\":\"DO_NOTHING\",\"name\":\"监控zabbix客户端数据采集\",\"notes\":\"\",\"parameter\":\"\",\"status\":\"paused\",\"statusEnum\":\"PAUSED\",\"tenantId\":\"T001\",\"updateBy\":\"110588348101165911\",\"updateTime\":1646196190000,\"version\":4,\"workerId\":\"547502957910818816\"} , after : {\"code\":\"\",\"concurrent\":0,\"createBy\":\"110588348101165911\",\"createTime\":1645271723000,\"cronExpr\":\"0 0/2 * * * ?\",\"deleted\":0,\"id\":\"547506505981624320\",\"misfirePolicy\":\"do_nothing\",\"misfirePolicyEnum\":\"DO_NOTHING\",\"name\":\"监控zabbix客户端数据采集\",\"notes\":\"\",\"parameter\":\"\",\"status\":\"paused\",\"statusEnum\":\"PAUSED\",\"tenantId\":\"T001\",\"updateBy\":\"110588348101165911\",\"updateTime\":1657236730000,\"version\":5,\"worker\":{\"className\":\"com.dt.platform.job.ops.MonitorZabbixAgentCollectDataExecutor\",\"id\":\"597670498230337536\",\"name\":\"MonitorZabbixAgentCollectDataExecutor\",\"valid\":1},\"workerId\":\"597670498230337536\"}"),
		@ApiImplicitParam(name = JobLogVOMeta.BEGIN_TIME , value = "开始执行的时间" , required = false , dataTypeClass=Timestamp.class , example = "2022-07-08 07:32:11.395"),
		@ApiImplicitParam(name = JobLogVOMeta.END_TIME , value = "结束执行的时间" , required = false , dataTypeClass=Timestamp.class , example = "2022-07-08 07:32:11.503"),
		@ApiImplicitParam(name = JobLogVOMeta.COST , value = "执行耗时" , required = false , dataTypeClass=Long.class , example = "108"),
		@ApiImplicitParam(name = JobLogVOMeta.EXCEPTION , value = "异常信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.LOG_TEXT , value = "日志信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.USER_ID , value = "账户ID" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MANUAL , value = "是否是手动执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.IS_MISSFIRE , value = "是否为丢失补充执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = JobLogVOMeta.CONCURRENT , value = "是否并发执行（0允许" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = JobLogVOMeta.MISFIRE_POLICY , value = "遗漏执行的策略" , required = false , dataTypeClass=String.class , example = "do_nothing"),
		@ApiImplicitParam(name = JobLogVOMeta.TID , value = "日志跟踪ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = JobLogVOMeta.NODE_ID , value = "节点ID" , required = false , dataTypeClass=String.class , example = "8a-780717dbc5-9e58")
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = JobLogServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(JobLogServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<JobLog>> queryPagedList(JobLogVO sample) {
		Result<PagedList<JobLog>> result=new Result<>();
		PagedList<JobLog> list=jobLogService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}