package com.scientific.tailoring.order.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.dao.data.PagedList;
import com.scientific.tailoring.domain.order.MeasureDataVO;
import com.scientific.tailoring.order.service.IMeasureService;
import com.scientific.tailoring.proxy.order.MeasureDataServiceProxy;

import io.swagger.annotations.Api;
import com.scientific.tailoring.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.springboot.mvc.Result;
import java.math.BigDecimal;

import com.scientific.tailoring.domain.order.meta.MeasureDataVOMeta;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import org.springframework.beans.factory.annotation.Autowired;

import com.scientific.tailoring.domain.order.MeasureData;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.scientific.tailoring.order.service.IMeasureDataService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;


/**
 * @author 李方捷
 * @since 2021-03-24 02:45:09
*/

@Api(tags = "测量数据发聩")
@ApiSort(1155)
@RestController("OdrMeasureDataController")
public class MeasureDataController extends SuperController {

	@Autowired
	private IMeasureDataService measureDataService;

	@Autowired
	private IMeasureService measureService;

	
	/**
	 * 添加测量数据发聩
	*/
	@RequiresPermissions("OdrMeasureData:insert")
	@ApiOperation(value = "添加测量数据发聩")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeasureDataVOMeta.MEASURE_ID , value = "测量ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.RESULT_TYPE , value = "测量类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.LING_WEI , value = "领围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.XIONG_WEI , value = "胸围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YAO_WEI , value = "腰围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.FU_WEI , value = "腹围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_SHANG_BI_WEI , value = "右上臂围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_XIA_BI_WEI , value = "右下臂围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_SHANG_BI_WEI , value = "左上臂围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_XIA_BI_WEI , value = "左下臂围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_SHANG_TUI_WEI , value = "右上腿围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_XIA_TUI_WEI , value = "右下腿围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_SHANG_TUI_WEI , value = "左上腿围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_XIA_TUI_WEI , value = "左下腿围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.SHEN_GAO , value = "身高" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.JIAN_KUAN , value = "肩宽" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.BEI_CHANG , value = "背长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.JING_ZHUI_DIAN_GAO , value = "颈椎点高" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YAO_WEI_GAO , value = "腰围高" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.TUN_GAO , value = "臀高" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.TUN_WEI , value = "臀围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.KU_CHANG , value = "裤长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_BI_CHANG , value = "左臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_BI_CHANG , value = "右臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_SHANG_BI_CHANG , value = "右上臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_XIA_BI_CHANG , value = "右下臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_SHANG_BI_CHANG , value = "左上臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_XIA_BI_CHANG , value = "左下臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_TUI_CHANG , value = "右腿长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_TUI_CHANG , value = "左腿长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_SHANG_TUI_CHANG , value = "右上腿长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_XIA_TUI_CHANG , value = "右下腿长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_SHANG_TUI_CHANG , value = "左上腿长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_XIA_TUI_CHANG , value = "左下腿长" , required = false , dataTypeClass=BigDecimal.class),
	})
	@ApiOperationSupport(ignoreParameters = {MeasureDataVOMeta.ID,MeasureDataVOMeta.PAGE_INDEX , MeasureDataVOMeta.PAGE_SIZE},order=1)
	@SentinelResource(value = MeasureDataServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureDataServiceProxy.INSERT)
	public  Result<MeasureData> insert(MeasureDataVO measureDataVO) {
		Result<MeasureData> result=new Result<>();
		boolean suc=measureDataService.insert(measureDataVO);
		measureService.updateStatus(measureDataVO.getMeasureId(),"report");
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键删除测量数据发聩
	*/
	@RequiresPermissions("OdrMeasureData:deleteById")
	@ApiOperation(value = "删除测量数据发聩")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeasureDataVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class),
	})
	@NotNull(name = MeasureDataVOMeta.ID)
	@ApiOperationSupport(order=2)
	@SentinelResource(value = MeasureDataServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureDataServiceProxy.DELETE)
	public  Result deleteById(Long id) {
		Result result=new Result();
		boolean suc=measureDataService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}

	
	/**
	 * 更新测量数据发聩
	*/
	@RequiresPermissions("OdrMeasureData:update")
	@ApiOperation(value = "更新测量数据发聩")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeasureDataVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.MEASURE_ID , value = "测量ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.RESULT_TYPE , value = "测量类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.LING_WEI , value = "领围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.XIONG_WEI , value = "胸围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YAO_WEI , value = "腰围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.FU_WEI , value = "腹围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_SHANG_BI_WEI , value = "右上臂围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_XIA_BI_WEI , value = "右下臂围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_SHANG_BI_WEI , value = "左上臂围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_XIA_BI_WEI , value = "左下臂围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_SHANG_TUI_WEI , value = "右上腿围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_XIA_TUI_WEI , value = "右下腿围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_SHANG_TUI_WEI , value = "左上腿围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_XIA_TUI_WEI , value = "左下腿围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.SHEN_GAO , value = "身高" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.JIAN_KUAN , value = "肩宽" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.BEI_CHANG , value = "背长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.JING_ZHUI_DIAN_GAO , value = "颈椎点高" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YAO_WEI_GAO , value = "腰围高" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.TUN_GAO , value = "臀高" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.TUN_WEI , value = "臀围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.KU_CHANG , value = "裤长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_BI_CHANG , value = "左臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_BI_CHANG , value = "右臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_SHANG_BI_CHANG , value = "右上臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_XIA_BI_CHANG , value = "右下臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_SHANG_BI_CHANG , value = "左上臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_XIA_BI_CHANG , value = "左下臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_TUI_CHANG , value = "右腿长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_TUI_CHANG , value = "左腿长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_SHANG_TUI_CHANG , value = "右上腿长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_XIA_TUI_CHANG , value = "右下腿长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_SHANG_TUI_CHANG , value = "左上腿长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_XIA_TUI_CHANG , value = "左下腿长" , required = false , dataTypeClass=BigDecimal.class),
	})
	@NotNull(name = MeasureDataVOMeta.ID)
	@ApiOperationSupport(ignoreParameters = {MeasureDataVOMeta.PAGE_INDEX , MeasureDataVOMeta.PAGE_SIZE},order=3)
	@SentinelResource(value = MeasureDataServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureDataServiceProxy.UPDATE)
	public  Result<MeasureData> update(MeasureDataVO measureDataVO) {
		Result<MeasureData> result=new Result<>();
		boolean suc=measureDataService.update(measureDataVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 按主键获取测量数据发聩
	*/
	@RequiresPermissions("OdrMeasureData:getById")
	@ApiOperation(value = "按主键获取测量数据发聩")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeasureDataVOMeta.ID , value = "ID" , required = true , dataTypeClass=Long.class),
	})
	@NotNull(name = MeasureDataVOMeta.ID)
	@ApiOperationSupport(order=4)
	@SentinelResource(value = MeasureDataServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureDataServiceProxy.GET_BY_ID)
	public  Result<MeasureData> getById(Long id) {
		Result<MeasureData> result=new Result<>();
		MeasureData measureData=measureDataService.getById(id);
		result.success(true).data(measureData);
		return result;
	}

	
	/**
	 * 查询全部符合条件的测量数据发聩
	*/
	@RequiresPermissions("OdrMeasureData:queryList")
	@ApiOperation(value = "查询测量数据发聩")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeasureDataVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.MEASURE_ID , value = "测量ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.RESULT_TYPE , value = "测量类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.LING_WEI , value = "领围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.XIONG_WEI , value = "胸围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YAO_WEI , value = "腰围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.FU_WEI , value = "腹围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_SHANG_BI_WEI , value = "右上臂围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_XIA_BI_WEI , value = "右下臂围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_SHANG_BI_WEI , value = "左上臂围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_XIA_BI_WEI , value = "左下臂围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_SHANG_TUI_WEI , value = "右上腿围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_XIA_TUI_WEI , value = "右下腿围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_SHANG_TUI_WEI , value = "左上腿围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_XIA_TUI_WEI , value = "左下腿围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.SHEN_GAO , value = "身高" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.JIAN_KUAN , value = "肩宽" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.BEI_CHANG , value = "背长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.JING_ZHUI_DIAN_GAO , value = "颈椎点高" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YAO_WEI_GAO , value = "腰围高" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.TUN_GAO , value = "臀高" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.TUN_WEI , value = "臀围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.KU_CHANG , value = "裤长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_BI_CHANG , value = "左臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_BI_CHANG , value = "右臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_SHANG_BI_CHANG , value = "右上臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_XIA_BI_CHANG , value = "右下臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_SHANG_BI_CHANG , value = "左上臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_XIA_BI_CHANG , value = "左下臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_TUI_CHANG , value = "右腿长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_TUI_CHANG , value = "左腿长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_SHANG_TUI_CHANG , value = "右上腿长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_XIA_TUI_CHANG , value = "右下腿长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_SHANG_TUI_CHANG , value = "左上腿长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_XIA_TUI_CHANG , value = "左下腿长" , required = false , dataTypeClass=BigDecimal.class),
	})
	@ApiOperationSupport(ignoreParameters = {MeasureDataVOMeta.PAGE_INDEX , MeasureDataVOMeta.PAGE_SIZE},order=5)
	@SentinelResource(value = MeasureDataServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureDataServiceProxy.QUERY_LIST)
	public  Result<List<MeasureData>> queryList(MeasureDataVO sample) {
		Result<List<MeasureData>> result=new Result<>();
		List<MeasureData> list=measureDataService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询符合条件的测量数据发聩
	*/
	@RequiresPermissions("OdrMeasureData:queryPagedList")
	@ApiOperation(value = "分页查询测量数据发聩")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MeasureDataVOMeta.ID , value = "ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.MEASURE_ID , value = "测量ID" , required = false , dataTypeClass=Long.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.RESULT_TYPE , value = "测量类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.LING_WEI , value = "领围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.XIONG_WEI , value = "胸围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YAO_WEI , value = "腰围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.FU_WEI , value = "腹围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_SHANG_BI_WEI , value = "右上臂围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_XIA_BI_WEI , value = "右下臂围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_SHANG_BI_WEI , value = "左上臂围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_XIA_BI_WEI , value = "左下臂围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_SHANG_TUI_WEI , value = "右上腿围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_XIA_TUI_WEI , value = "右下腿围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_SHANG_TUI_WEI , value = "左上腿围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_XIA_TUI_WEI , value = "左下腿围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.SHEN_GAO , value = "身高" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.JIAN_KUAN , value = "肩宽" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.BEI_CHANG , value = "背长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.JING_ZHUI_DIAN_GAO , value = "颈椎点高" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YAO_WEI_GAO , value = "腰围高" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.TUN_GAO , value = "臀高" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.TUN_WEI , value = "臀围" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.KU_CHANG , value = "裤长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_BI_CHANG , value = "左臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_BI_CHANG , value = "右臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_SHANG_BI_CHANG , value = "右上臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_XIA_BI_CHANG , value = "右下臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_SHANG_BI_CHANG , value = "左上臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_XIA_BI_CHANG , value = "左下臂长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_TUI_CHANG , value = "右腿长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_TUI_CHANG , value = "左腿长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_SHANG_TUI_CHANG , value = "右上腿长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.YOU_XIA_TUI_CHANG , value = "右下腿长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_SHANG_TUI_CHANG , value = "左上腿长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.ZUO_XIA_TUI_CHANG , value = "左下腿长" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.PAGE_INDEX , value = "页码" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MeasureDataVOMeta.PAGE_SIZE , value = "分页大小" , required = false , dataTypeClass=Integer.class)
	})
	@ApiOperationSupport(order=6)
	@SentinelResource(value = MeasureDataServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class },blockHandler = SentinelExceptionUtil.HANDLER)
	@PostMapping(MeasureDataServiceProxy.QUERY_PAGED_LIST)
	public  Result<PagedList<MeasureData>> queryPagedList(MeasureDataVO sample) {
		Result<PagedList<MeasureData>> result=new Result<>();
		PagedList<MeasureData> list=measureDataService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}