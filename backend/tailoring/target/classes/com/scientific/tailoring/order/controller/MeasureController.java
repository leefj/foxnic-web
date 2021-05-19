package com.scientific.tailoring.order.controller;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.io.StreamUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelReader;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.sql.SQLBuilder;
import com.github.foxnic.springboot.api.annotations.NotBlank;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.mvc.Result;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.Expr;
import com.github.foxnic.sql.expr.Insert;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.scientific.tailoring.constants.db.Tailoring.ODR_BODY;
import com.scientific.tailoring.constants.enums.dict.MeasureStatus;
import com.scientific.tailoring.domain.order.AppMeasureModel;
import com.scientific.tailoring.domain.order.Measure;
import com.scientific.tailoring.domain.order.MeasureData;
import com.scientific.tailoring.domain.order.MeasureDimensionModel;
import com.scientific.tailoring.domain.order.MeasureVO;
import com.scientific.tailoring.domain.order.meta.MeasureVOMeta;
import com.scientific.tailoring.domain.order.meta.ProductVOMeta;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.order.service.IBodyService;
import com.scientific.tailoring.order.service.IMeasureDataService;
import com.scientific.tailoring.order.service.IMeasureService;
import com.scientific.tailoring.proxy.order.MeasureServiceProxy;
import com.scientific.tailoring.system.service.IDictService;
import com.scientific.tailoring.system.service.ILangService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * @author 李方捷
 * @since 2021-03-22 04:19:26
*/

@Api(tags = "订单测量信息")
@ApiSort(1153)
@RestController("OdrMeasureController")
public class MeasureController extends SuperController {

	@Autowired
	private IMeasureService measureService;
	
	@Autowired
	private IBodyService bodyService;
	
	@Autowired
	private IMeasureDataService measureDataService;
	
	@Autowired
	private IDictService dictService;
	
	
	@Autowired
	private ILangService langService;

	
	/**
	 * 添加订单测量信息
	*/
	@RequiresPermissions("OdrMeasure:insert")
	@ApiOperation(value = "添加订单测量信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeasureVOMeta.ORDER_ID , value = "订单ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = MeasureVOMeta.BODY_ID , value = "被测量人员ID" , required = false , dataTypeClass=Long.class , example = "47"),
		@ApiImplicitParam(name = MeasureVOMeta.METHOD , value = "测量方法" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeasureVOMeta.STATUS , value = "测量状态" , required = true , dataTypeClass=String.class , example = "todo"),
		@ApiImplicitParam(name = MeasureVOMeta.VIDEO_ID , value = "视频效果" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureVOMeta.BODY_EFFECT_FILE_ID , value = "净体3D效果文件ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureVOMeta.OUTFIT_EFFECT_FILE_ID , value = "着装3D效果文件ID" , required = false , dataTypeClass=Long.class),
	})
	@NotNull(name = MeasureVOMeta.ORDER_ID)
	@ApiOperationSupport(ignoreParameters = {MeasureVOMeta.PAGE_INDEX , MeasureVOMeta.PAGE_SIZE},order=1)
	@SentinelResource(value = MeasureServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureServiceProxy.INSERT)
	public  Result<Measure> insert(MeasureVO measureVO) {
		Result<Measure> result=new Result<>();
		measureVO.setStatus(MeasureStatus.TODO.code());
		boolean suc=measureService.insert(measureVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除订单测量信息
	*/
	@RequiresPermissions("OdrMeasure:deleteById")
	@ApiOperation(value = "按主键删除订单测量信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeasureVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "47"),
	})
	@NotNull(name = MeasureVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = MeasureServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureServiceProxy.DELETE)
	public  Result deleteById(Long id) {
		Result result=new Result();
		boolean suc=measureService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 按主键批量删除产品标签
	 */
	@RequiresPermissions("OdrProduct:deleteByIds")
	@ApiOperation(value = "按主键批量删除测量人员")
	@ApiImplicitParams({
			@ApiImplicitParam(name = ProductVOMeta.ID , value = "编号" , required = true , dataTypeClass=Integer.class , example = "1")
	})
	@NotNull(name = ProductVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = MeasureServiceProxy.BATCH_DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureServiceProxy.BATCH_DELETE)
	public  Result deleteByIds(List<Integer> id) {
		Result result=new Result();
		boolean suc=measureService.deleteByIdsPhysical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新订单测量信息
	*/
	@RequiresPermissions("OdrMeasure:update")
	@ApiOperation(value = "更新订单测量信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeasureVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "47"),
		@ApiImplicitParam(name = MeasureVOMeta.ORDER_ID , value = "订单ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = MeasureVOMeta.BODY_ID , value = "被测量人员ID" , required = false , dataTypeClass=Long.class , example = "47"),
		@ApiImplicitParam(name = MeasureVOMeta.METHOD , value = "测量方法" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeasureVOMeta.STATUS , value = "测量状态" , required = true , dataTypeClass=String.class , example = "todo"),
		@ApiImplicitParam(name = MeasureVOMeta.VIDEO_ID , value = "视频效果" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureVOMeta.BODY_EFFECT_FILE_ID , value = "净体3D效果文件ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureVOMeta.OUTFIT_EFFECT_FILE_ID , value = "着装3D效果文件ID" , required = false , dataTypeClass=Long.class),
	})
	@NotNull(name = MeasureVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {MeasureVOMeta.PAGE_INDEX , MeasureVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = MeasureServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureServiceProxy.UPDATE)
	public  Result<Measure> update(MeasureVO measureVO) {
		Result<Measure> result=new Result<>();
		boolean suc=measureService.update(measureVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取订单测量信息
	*/
	@RequiresPermissions("OdrMeasure:getById")
	@ApiOperation(value = "按主键获取订单测量信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeasureVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class , example = "47"),
	})
	@NotNull(name = MeasureVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = MeasureServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureServiceProxy.GET_BY_ID)
	public  Result<Measure> getById(Long id) {
		Result<Measure> result=new Result<>();
		Measure measure=measureService.getById(id);
		result.success(true).data(measure);
		return result;
	}

	
	/**
	 * 查询全部符合条件的订单测量信息
	*/
	@RequiresPermissions("OdrMeasure:queryList")
	@ApiOperation(value = "查询全部符合条件的订单测量信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeasureVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "47"),
		@ApiImplicitParam(name = MeasureVOMeta.ORDER_ID , value = "订单ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = MeasureVOMeta.BODY_ID , value = "被测量人员ID" , required = false , dataTypeClass=Long.class , example = "47"),
		@ApiImplicitParam(name = MeasureVOMeta.METHOD , value = "测量方法" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeasureVOMeta.STATUS , value = "测量状态" , required = false , dataTypeClass=String.class , example = "todo"),
		@ApiImplicitParam(name = MeasureVOMeta.VIDEO_ID , value = "视频效果" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureVOMeta.BODY_EFFECT_FILE_ID , value = "净体3D效果文件ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureVOMeta.OUTFIT_EFFECT_FILE_ID , value = "着装3D效果文件ID" , required = false , dataTypeClass=Long.class),
	})
	@ApiOperationSupport(ignoreParameters = {MeasureVOMeta.PAGE_INDEX , MeasureVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = MeasureServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureServiceProxy.QUERY_LIST)
	public  Result<List<Measure>> queryList(MeasureVO sample) {
		Result<List<Measure>> result=new Result<>();
		List<Measure> list=measureService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询符合条件的订单测量信息
	*/
	@RequiresPermissions("OdrMeasure:queryPagedList")
	@ApiOperation(value = "分页查询符合条件的订单测量信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeasureVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "47"),
		@ApiImplicitParam(name = MeasureVOMeta.ORDER_ID , value = "订单ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = MeasureVOMeta.BODY_ID , value = "被测量人员ID" , required = false , dataTypeClass=Long.class , example = "47"),
		@ApiImplicitParam(name = MeasureVOMeta.METHOD , value = "测量方法" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeasureVOMeta.STATUS , value = "测量状态" , required = false , dataTypeClass=String.class , example = "todo"),
		@ApiImplicitParam(name = MeasureVOMeta.VIDEO_ID , value = "视频效果" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureVOMeta.BODY_EFFECT_FILE_ID , value = "净体3D效果文件ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureVOMeta.OUTFIT_EFFECT_FILE_ID , value = "着装3D效果文件ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MeasureVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = MeasureServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<MeasureVO>> queryPagedList(MeasureVO sample) {
		Result<PagedList<MeasureVO>> result=new Result<>();
		PagedList<MeasureVO> list=measureService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}
	
	
	
	/**
	 * 分页查询符合条件的订单测量信息
	 * @throws IOException 
	*/
	@RequiresPermissions("OdrMeasure:queryPagedList")
	@ApiOperation(value = "导出Excel")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeasureVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class , example = "47"),
		@ApiImplicitParam(name = MeasureVOMeta.ORDER_ID , value = "订单ID" , required = false , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = MeasureVOMeta.STATUS , value = "测量状态" , required = false , dataTypeClass=String.class , example = "todo"),
		@ApiImplicitParam(name = MeasureVOMeta.VIDEO_ID , value = "视频效果" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureVOMeta.BODY_EFFECT_FILE_ID , value = "净体3D效果文件ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureVOMeta.OUTFIT_EFFECT_FILE_ID , value = "着装3D效果文件ID" , required = false , dataTypeClass=Long.class),
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = MeasureServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@RequestMapping(MeasureServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MeasureVO sample,HttpServletResponse response) throws Exception {
		
		//拼接语句
		Expr select=new Expr("select id,body_name,body_dept,body_sex,body_height,create_time from "+bodyService.table());
		ConditionExpr condition = measureService.buildQueryCondition(sample);
		select.append(condition.startWithWhere());
		//查询数据
		RcdSet rs=measureService.dao().query(select);
		//写入
		ExcelWriter ew=new ExcelWriter();
		ExcelStructure es=ExcelStructure.parse(rs,true);
		ew.fillSheet(rs, "清单",es);
		//下载
		DownloadUtil.writeToOutput(response, ew.getWorkBook(), "测量人员清单.xlsx");

	}
	
	
	/**
	 * 分页查询符合条件的订单测量信息
	 * @throws IOException 
	*/
	@RequiresPermissions("OdrMeasure:queryPagedList")
	@ApiOperation(value = "导入Excel")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeasureVOMeta.ORDER_ID , value = "订单ID" , required = false , dataTypeClass=Long.class , example = "1")
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = MeasureServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@RequestMapping(MeasureServiceProxy.IMPORT_EXCEL)
	public Result importExcel(MultipartHttpServletRequest request,HttpServletResponse response) throws Exception {
		
		//获得订单ID
		String orderId=request.getParameter("orderId");
		
		//获得上传的文件
		Map<String, MultipartFile> map = request.getFileMap();
		ExcelReader er=null;
		for (MultipartFile mf : map.values()) {
			er=new ExcelReader(StreamUtil.bytes2input(mf.getBytes()));
			break;
		}
		
		if(er==null) {
			return ErrorDesc.failure().message("缺少上传的文件");
		}
		
		//定义Excel结构
		ExcelStructure es=new ExcelStructure();
		es.addColumn("A", "body_name");
		es.addColumn("B", "body_dept");
		es.addColumn("C", "body_sex");
		es.addColumn("D", "body_height");
		//数据起始行
		es.setDataRowBegin(2);
		//装换成记录集
		RcdSet rs=null;
		try {
			rs=er.read(es);
		} catch (Exception e) {
			return ErrorDesc.failure().message("Excel读取失败");
		}
		
		//从记录集插入表
		for (Rcd r : rs) {
			//跳过无法转换成数字的人员
			if(r.getInteger("body_height")==null) continue;
			Insert insert=SQLBuilder.buildInsert(r,bodyService.table(),measureService.dao(),true);
			insert.set(ODR_BODY.ORDER_ID, orderId);
			insert.set(ODR_BODY.CREATE_TIME,new Date()).set(ODR_BODY.CREATE_BY,this.getSessionUserId());
			measureService.dao().execute(insert);
		}
 
		return ErrorDesc.success();
	}
	
	
	
	/**
	 * 分页查询符合条件的订单测量信息
	*/
	@RequiresPermissions("OdrMeasure:queryPagedList4App")
	@ApiOperation(value = "分页查询符合条件的订单测量信息(App)")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeasureVOMeta.ORDER_ID , value = "订单ID" , required = true , dataTypeClass=Long.class , example = "1"),
		@ApiImplicitParam(name = MeasureVOMeta.STATUS_LIST , value = "测量状态清单" , required = false , dataTypeClass=List.class , example = "todo,done"),
		@ApiImplicitParam(name = MeasureVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MeasureVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@NotBlank(name = MeasureVOMeta.ORDER_ID)
	@ApiOperationSupport(order=7)
	@SentinelResource(value = MeasureServiceProxy.QUERY_PAGED_LIST_4_APP, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureServiceProxy.QUERY_PAGED_LIST_4_APP)
	public  Result<PagedList<AppMeasureModel>> queryPagedList4App(MeasureVO sample) {
		Result<PagedList<AppMeasureModel>> result=new Result<>();
		PagedList<AppMeasureModel> list=measureService.queryPagedEntities4App(sample.getOrderId(),sample.getStatusList(),sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询全部符合条件的订单测量信息
	*/
	@RequiresPermissions("OdrMeasure:MeasureTypes")
	@ApiOperation(value = "测量方式清单")
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MeasureServiceProxy.QUERY_MEASURE_TYPE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureServiceProxy.QUERY_MEASURE_TYPE)
	public  Result<Map<String,String>> queryMeasureTypes(MeasureVO sample) {
		Result<Map<String,String>> result=new Result<>();
		Map<String,String> map=dictService.getDictItems("measure_file_type");
		result.success(true).data(map).refer("dict", "measure_file_type");
		return result;
	}
	
	
	/**
	 * 查询全部符合条件的订单测量信息
	*/
	@RequiresPermissions("OdrMeasure:MeasureDimensions")
	@ApiOperation(value = "测量维度清单")
	@ApiOperationSupport(order=9)
	@SentinelResource(value = MeasureServiceProxy.QUERY_MEASURE_DIMENSIONS, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureServiceProxy.QUERY_MEASURE_DIMENSIONS)
	public  Result<List<MeasureDimensionModel>> queryMeasureDimensions(MeasureVO sample) {
		Result<List<MeasureDimensionModel>> result=new Result<>();
		List<MeasureDimensionModel> map=measureService.getMeasureDimensions();
		result.success(true).data(map);
		return result;
	}
	
	
	/**
	 * 查询全部符合条件的订单测量信息
	*/
	@RequiresPermissions("OdrMeasure:MeasureDimensions")
	@ApiOperation(value = "测量维度清单")
	@ApiOperationSupport(order=9)
	@SentinelResource(value = MeasureServiceProxy.QUERY_MEASURE_DIMENSIONS_AND_DATA, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureServiceProxy.QUERY_MEASURE_DIMENSIONS_AND_DATA)
	public  Result<List<MeasureDimensionModel>> queryMeasureDimensionsAndData(MeasureVO sample) {
		Result<List<MeasureDimensionModel>> result=new Result<>();
		List<MeasureDimensionModel> list=measureService.getMeasureDimensions();
		MeasureData data= measureDataService.getByMeasureId(sample.getId(),sample.getMeasureType()); 
		if(data!=null) {
			for (MeasureDimensionModel m : list) {
				BigDecimal value=BeanUtil.getFieldValue(data, m.getProperty(), BigDecimal.class);
				m.setValue(value);
			}
		}
		result.success(true).data(list);
		return result;
	}
	
	
	
}