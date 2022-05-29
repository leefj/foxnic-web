package org.github.foxnic.web.example.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.api.validate.annotations.NotNull;
import com.github.foxnic.commons.io.StreamUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.domain.example.Address;
import org.github.foxnic.web.domain.example.AddressVO;
import org.github.foxnic.web.domain.example.meta.AddressMeta;
import org.github.foxnic.web.domain.example.meta.AddressVOMeta;
import org.github.foxnic.web.domain.example.meta.OrderItemMeta;
import org.github.foxnic.web.domain.example.meta.OrderMeta;
import org.github.foxnic.web.example.service.IAddressService;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.proxy.example.AddressServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-29 07:30:45
*/

@Api(tags = "example_address")
@ApiSort(0)
@RestController("ExampleAddressController")
public class AddressController extends SuperController {

	@Autowired
	private IAddressService addressService;


	/**
	 * 添加example_address
	*/
	@ApiOperation(value = "添加example_address")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AddressVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028267108274176"),
		@ApiImplicitParam(name = AddressVOMeta.NAME , value = "收件人姓名" , required = false , dataTypeClass=String.class , example = "李方捷"),
		@ApiImplicitParam(name = AddressVOMeta.PHONE_NUMBER , value = "收件人手机" , required = false , dataTypeClass=String.class , example = "1234567333"),
		@ApiImplicitParam(name = AddressVOMeta.ADDRESS , value = "收件地址" , required = false , dataTypeClass=String.class , example = "浙江省宁波市鄞州区鄞县大道二号"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AddressServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AddressServiceProxy.INSERT)
	public Result insert(AddressVO addressVO) {
		Result result=addressService.insert(addressVO,false);
		return result;
	}



	/**
	 * 删除example_address
	*/
	@ApiOperation(value = "删除example_address")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AddressVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028267108274176")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AddressVOMeta.ID)
	@SentinelResource(value = AddressServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AddressServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=addressService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除example_address <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除example_address")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AddressVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AddressVOMeta.IDS)
	@SentinelResource(value = AddressServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AddressServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=addressService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新example_address
	*/
	@ApiOperation(value = "更新example_address")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AddressVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028267108274176"),
		@ApiImplicitParam(name = AddressVOMeta.NAME , value = "收件人姓名" , required = false , dataTypeClass=String.class , example = "李方捷"),
		@ApiImplicitParam(name = AddressVOMeta.PHONE_NUMBER , value = "收件人手机" , required = false , dataTypeClass=String.class , example = "1234567333"),
		@ApiImplicitParam(name = AddressVOMeta.ADDRESS , value = "收件地址" , required = false , dataTypeClass=String.class , example = "浙江省宁波市鄞州区鄞县大道二号"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AddressVOMeta.PAGE_INDEX , AddressVOMeta.PAGE_SIZE , AddressVOMeta.SEARCH_FIELD , AddressVOMeta.FUZZY_FIELD , AddressVOMeta.SEARCH_VALUE , AddressVOMeta.DIRTY_FIELDS , AddressVOMeta.SORT_FIELD , AddressVOMeta.SORT_TYPE , AddressVOMeta.IDS } )
	@NotNull(name = AddressVOMeta.ID)
	@SentinelResource(value = AddressServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AddressServiceProxy.UPDATE)
	public Result update(AddressVO addressVO) {
		Result result=addressService.update(addressVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存example_address
	*/
	@ApiOperation(value = "保存example_address")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AddressVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028267108274176"),
		@ApiImplicitParam(name = AddressVOMeta.NAME , value = "收件人姓名" , required = false , dataTypeClass=String.class , example = "李方捷"),
		@ApiImplicitParam(name = AddressVOMeta.PHONE_NUMBER , value = "收件人手机" , required = false , dataTypeClass=String.class , example = "1234567333"),
		@ApiImplicitParam(name = AddressVOMeta.ADDRESS , value = "收件地址" , required = false , dataTypeClass=String.class , example = "浙江省宁波市鄞州区鄞县大道二号"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AddressVOMeta.PAGE_INDEX , AddressVOMeta.PAGE_SIZE , AddressVOMeta.SEARCH_FIELD , AddressVOMeta.FUZZY_FIELD , AddressVOMeta.SEARCH_VALUE , AddressVOMeta.DIRTY_FIELDS , AddressVOMeta.SORT_FIELD , AddressVOMeta.SORT_TYPE , AddressVOMeta.IDS } )
	@NotNull(name = AddressVOMeta.ID)
	@SentinelResource(value = AddressServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AddressServiceProxy.SAVE)
	public Result save(AddressVO addressVO) {
		Result result=addressService.save(addressVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取example_address
	*/
	@ApiOperation(value = "获取example_address")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AddressVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AddressVOMeta.ID)
	@SentinelResource(value = AddressServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AddressServiceProxy.GET_BY_ID)
	public Result<Address> getById(String id) {
		Result<Address> result=new Result<>();
		Address address=addressService.getById(id);
		addressService.dao().fill(address)
				.with(AddressMeta.ORDER_LIST, OrderMeta.ADDRESS)
				.with(AddressMeta.ORDER_LIST, OrderMeta.GOODS_LIST)
//				.with(AddressMeta.ITEM_LIST, OrderItemMeta.ADDRESS_LIST)
				.with(AddressMeta.ITEM_LIST, OrderItemMeta.GOODS)
				.with(AddressMeta.GOODS_LIST)
				.execute();
		result.success(true).data(address);
		return result;
	}


	/**
	 * 批量获取example_address <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取example_address")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AddressVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AddressVOMeta.IDS)
		@SentinelResource(value = AddressServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AddressServiceProxy.GET_BY_IDS)
	public Result<List<Address>> getByIds(List<String> ids) {
		Result<List<Address>> result=new Result<>();
		List<Address> list=addressService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询example_address
	*/
	@ApiOperation(value = "查询example_address")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AddressVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028267108274176"),
		@ApiImplicitParam(name = AddressVOMeta.NAME , value = "收件人姓名" , required = false , dataTypeClass=String.class , example = "李方捷"),
		@ApiImplicitParam(name = AddressVOMeta.PHONE_NUMBER , value = "收件人手机" , required = false , dataTypeClass=String.class , example = "1234567333"),
		@ApiImplicitParam(name = AddressVOMeta.ADDRESS , value = "收件地址" , required = false , dataTypeClass=String.class , example = "浙江省宁波市鄞州区鄞县大道二号"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AddressVOMeta.PAGE_INDEX , AddressVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AddressServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AddressServiceProxy.QUERY_LIST)
	public Result<List<Address>> queryList(AddressVO sample) {
		Result<List<Address>> result=new Result<>();
		List<Address> list=addressService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询example_address
	*/
	@ApiOperation(value = "分页查询example_address")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AddressVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028267108274176"),
		@ApiImplicitParam(name = AddressVOMeta.NAME , value = "收件人姓名" , required = false , dataTypeClass=String.class , example = "李方捷"),
		@ApiImplicitParam(name = AddressVOMeta.PHONE_NUMBER , value = "收件人手机" , required = false , dataTypeClass=String.class , example = "1234567333"),
		@ApiImplicitParam(name = AddressVOMeta.ADDRESS , value = "收件地址" , required = false , dataTypeClass=String.class , example = "浙江省宁波市鄞州区鄞县大道二号"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AddressServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AddressServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Address>> queryPagedList(AddressVO sample) {
		Result<PagedList<Address>> result=new Result<>();
		PagedList<Address> list=addressService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AddressServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AddressServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AddressVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=addressService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AddressServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AddressServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=addressService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AddressServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AddressServiceProxy.IMPORT_EXCEL)
	public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {

		//获得上传的文件
		Map<String, MultipartFile> map = request.getFileMap();
		InputStream input=null;
		for (MultipartFile mf : map.values()) {
			input=StreamUtil.bytes2input(mf.getBytes());
			break;
		}

		if(input==null) {
			return ErrorDesc.failure().message("缺少上传的文件");
		}

		List<ValidateResult> errors=addressService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}