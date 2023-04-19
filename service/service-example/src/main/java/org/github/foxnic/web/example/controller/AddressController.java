package org.github.foxnic.web.example.controller;

import java.util.*;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.github.foxnic.web.proxy.example.AddressServiceProxy;
import org.github.foxnic.web.domain.example.meta.AddressVOMeta;
import org.github.foxnic.web.domain.example.Address;
import org.github.foxnic.web.domain.example.AddressVO;
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
import org.github.foxnic.web.domain.example.meta.AddressMeta;
import java.util.List;
import org.github.foxnic.web.domain.example.AddressModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.example.service.IAddressService;
import com.github.foxnic.api.validate.annotations.NotNull;
import org.github.foxnic.web.domain.example.AddressSubModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.github.foxnic.web.domain.example.AddressPureModel;
import org.github.foxnic.web.domain.oauth.User;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * <p>
 * 订单地址接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-19 14:40:34
*/

@InDoc
@Api(tags = "功能示例/订单地址")
@RestController("ExampleAddressController")
public class AddressController extends SuperController {

	@Autowired
	private IAddressService addressService;

	/**
	 * 添加订单地址
	*/
	@ApiOperation(value = "添加订单地址")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AddressVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028267108274176"),
		@ApiImplicitParam(name = AddressVOMeta.NAME , value = "收件人姓名" , required = false , dataTypeClass=String.class , example = "李方捷"),
		@ApiImplicitParam(name = AddressVOMeta.PHONE_NUMBER , value = "收件人手机" , required = false , dataTypeClass=String.class , example = "1234567333"),
		@ApiImplicitParam(name = AddressVOMeta.ADDRESS , value = "收件地址" , required = false , dataTypeClass=String.class , example = "浙江省宁波市鄞州区鄞县大道二号"),
		@ApiImplicitParam(name = AddressVOMeta.REGION_TYPE , value = "类型" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AddressVOMeta.REGION_LOCATION , value = "地区位置" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = AddressServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AddressServiceProxy.INSERT)
	public Result insert(AddressVO addressVO) {
		
		Result result=addressService.insert(addressVO,false);
		return result;
	}



	/**
	 * 删除订单地址
	*/
	@ApiOperation(value = "删除订单地址")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AddressVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028267108274176")
	})
	@ApiOperationSupport(order=2 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = AddressServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AddressServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  addressService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=addressService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除订单地址 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除订单地址")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AddressVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
	@SentinelResource(value = AddressServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AddressServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = addressService.hasRefers(ids);
		// 收集可以删除的ID值
		List<String> canDeleteIds = new ArrayList<>();
		for (Map.Entry<String, ReferCause> e : causeMap.entrySet()) {
			if (!e.getValue().hasRefer()) {
				canDeleteIds.add(e.getKey());
			}
		}

		// 执行删除
		if (canDeleteIds.isEmpty()) {
			// 如果没有一行可以被删除
			return ErrorDesc.failure().message("无法删除您选中的数据行：").data(0)
				.addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(),(e)->{return e.hasRefer();}),ReferCause::message,String.class))
				.messageLevel4Confirm();
		} else if (canDeleteIds.size() == ids.size()) {
			// 如果全部可以删除
			Result result=addressService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=addressService.deleteByIdsLogical(canDeleteIds);
			if (result.failure()) {
				return result;
			} else {
				return ErrorDesc.success().message("已删除 " + canDeleteIds.size() + " 行，但另有 " + (ids.size() - canDeleteIds.size()) + " 行数据无法删除").data(canDeleteIds.size())
				.addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(),(e)->{return e.hasRefer();}),ReferCause::message,String.class))
				.messageLevel4Confirm();
			}
		} else {
			// 理论上，这个分支不存在
			return ErrorDesc.success().message("数据删除未处理");
		}
	}

	/**
	 * 更新订单地址
	*/
	@ApiOperation(value = "更新订单地址")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AddressVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028267108274176"),
		@ApiImplicitParam(name = AddressVOMeta.NAME , value = "收件人姓名" , required = false , dataTypeClass=String.class , example = "李方捷"),
		@ApiImplicitParam(name = AddressVOMeta.PHONE_NUMBER , value = "收件人手机" , required = false , dataTypeClass=String.class , example = "1234567333"),
		@ApiImplicitParam(name = AddressVOMeta.ADDRESS , value = "收件地址" , required = false , dataTypeClass=String.class , example = "浙江省宁波市鄞州区鄞县大道二号"),
		@ApiImplicitParam(name = AddressVOMeta.REGION_TYPE , value = "类型" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AddressVOMeta.REGION_LOCATION , value = "地区位置" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { AddressVOMeta.PAGE_INDEX , AddressVOMeta.PAGE_SIZE , AddressVOMeta.SEARCH_FIELD , AddressVOMeta.FUZZY_FIELD , AddressVOMeta.SEARCH_VALUE , AddressVOMeta.DIRTY_FIELDS , AddressVOMeta.SORT_FIELD , AddressVOMeta.SORT_TYPE , AddressVOMeta.DATA_ORIGIN , AddressVOMeta.QUERY_LOGIC , AddressVOMeta.REQUEST_ACTION , AddressVOMeta.IDS } )
	@SentinelResource(value = AddressServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AddressServiceProxy.UPDATE)
	public Result update(AddressVO addressVO) {
		
		Result result=addressService.update(addressVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存订单地址
	*/
	@ApiOperation(value = "保存订单地址")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AddressVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028267108274176"),
		@ApiImplicitParam(name = AddressVOMeta.NAME , value = "收件人姓名" , required = false , dataTypeClass=String.class , example = "李方捷"),
		@ApiImplicitParam(name = AddressVOMeta.PHONE_NUMBER , value = "收件人手机" , required = false , dataTypeClass=String.class , example = "1234567333"),
		@ApiImplicitParam(name = AddressVOMeta.ADDRESS , value = "收件地址" , required = false , dataTypeClass=String.class , example = "浙江省宁波市鄞州区鄞县大道二号"),
		@ApiImplicitParam(name = AddressVOMeta.REGION_TYPE , value = "类型" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AddressVOMeta.REGION_LOCATION , value = "地区位置" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AddressVOMeta.PAGE_INDEX , AddressVOMeta.PAGE_SIZE , AddressVOMeta.SEARCH_FIELD , AddressVOMeta.FUZZY_FIELD , AddressVOMeta.SEARCH_VALUE , AddressVOMeta.DIRTY_FIELDS , AddressVOMeta.SORT_FIELD , AddressVOMeta.SORT_TYPE , AddressVOMeta.DATA_ORIGIN , AddressVOMeta.QUERY_LOGIC , AddressVOMeta.REQUEST_ACTION , AddressVOMeta.IDS } )
	@SentinelResource(value = AddressServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AddressServiceProxy.SAVE)
	public Result save(AddressVO addressVO) {
		
		Result result=addressService.save(addressVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取订单地址
	*/
	@ApiOperation(value = "获取订单地址")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AddressVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = AddressServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AddressServiceProxy.GET_BY_ID)
	public Result<Address> getById(String id) {
		
		Result<Address> result=new Result<>();
		Address address=addressService.getById(id);
		result.success(true).data(address);
		return result;
	}


	/**
	 * 批量获取订单地址 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取订单地址")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AddressVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
		@SentinelResource(value = AddressServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AddressServiceProxy.GET_BY_IDS)
	public Result<List<Address>> getByIds(List<String> ids) {
		
		Result<List<Address>> result=new Result<>();
		List<Address> list=addressService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询订单地址
	*/
	@ApiOperation(value = "查询订单地址")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AddressVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028267108274176"),
		@ApiImplicitParam(name = AddressVOMeta.NAME , value = "收件人姓名" , required = false , dataTypeClass=String.class , example = "李方捷"),
		@ApiImplicitParam(name = AddressVOMeta.PHONE_NUMBER , value = "收件人手机" , required = false , dataTypeClass=String.class , example = "1234567333"),
		@ApiImplicitParam(name = AddressVOMeta.ADDRESS , value = "收件地址" , required = false , dataTypeClass=String.class , example = "浙江省宁波市鄞州区鄞县大道二号"),
		@ApiImplicitParam(name = AddressVOMeta.REGION_TYPE , value = "类型" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AddressVOMeta.REGION_LOCATION , value = "地区位置" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { AddressVOMeta.PAGE_INDEX , AddressVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AddressServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AddressServiceProxy.QUERY_LIST)
	public Result<List<Address>> queryList(AddressVO sample) {
		
		Result<List<Address>> result=new Result<>();
		List<Address> list=addressService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询订单地址
	*/
	@ApiOperation(value = "分页查询订单地址")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AddressVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583028267108274176"),
		@ApiImplicitParam(name = AddressVOMeta.NAME , value = "收件人姓名" , required = false , dataTypeClass=String.class , example = "李方捷"),
		@ApiImplicitParam(name = AddressVOMeta.PHONE_NUMBER , value = "收件人手机" , required = false , dataTypeClass=String.class , example = "1234567333"),
		@ApiImplicitParam(name = AddressVOMeta.ADDRESS , value = "收件地址" , required = false , dataTypeClass=String.class , example = "浙江省宁波市鄞州区鄞县大道二号"),
		@ApiImplicitParam(name = AddressVOMeta.REGION_TYPE , value = "类型" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AddressVOMeta.REGION_LOCATION , value = "地区位置" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="李方捷 , leefangjie@qq.com")
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
	@PostMapping(AddressServiceProxy.IMPORT_EXCEL)
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
	/**
	  * Get-示例
	  * <p>方法描述</p>
      * @param name 姓名 , 所有者的姓名
      * @param memberIds 成员ID集合 , 指定成员的ID清单
      * @param ageMap 年龄表 , 成员年龄表
      * @return  Result&lt;AddressSubModel&gt; 结果
	  */
	@ApiOperation(value = "Get-示例",notes = "方法描述")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "name" , value = "姓名" , required = true , dataTypeClass=String.class , example = "LeeFJ"),
        @ApiImplicitParam(name = "memberIds" , value = "成员ID集合" , required = false , dataTypeClass=List.class , example = "[1,2,3]"),
        @ApiImplicitParam(name = "ageMap" , value = "年龄表" , required = false , dataTypeClass=Map.class , example = "{\"LeeFJ\":28}"),
    })
	@ApiOperationSupport(order=16,author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = AddressServiceProxy.NEW_API_NAME_1 , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@GetMapping(AddressServiceProxy.NEW_API_NAME_1)
	public Result<AddressSubModel> newApiName1(String name , List<String> memberIds , Map<String,Integer> ageMap) {
		Result<AddressSubModel> result = new Result<>();
		// TODO 实现 方法描述 逻辑
		return result;
	}
	/**
	  * Post-示例
	  * <p>方法描述</p>
      * @param address 地址对象 , 地址基本信息
      * @param model 地址模型 , 地址的扩展信息
      * @param userMap 账户对象Map
      * @return  Result&lt;List&lt;AddressPureModel&gt;&gt; 地址列表
	  */
	@ApiOperation(value = "Post-示例",notes = "方法描述")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "address" , value = "地址对象" , required = true , dataTypeClass=AddressVO.class , example = "{}"),
        @ApiImplicitParam(name = "model" , value = "地址模型" , required = false , dataTypeClass=List.class , example = "[]"),
        @ApiImplicitParam(name = "userMap" , value = "账户对象Map" , required = false , dataTypeClass=Map.class , example = "{}"),
    })
	@ApiOperationSupport(order=16,author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = AddressServiceProxy.NEW_API_NAME_2 , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AddressServiceProxy.NEW_API_NAME_2)
	public Result<List<AddressPureModel>> newApiName2(AddressVO address , List<AddressModel> model , Map<String,User> userMap) {
		Result<List<AddressPureModel>> result = new Result<>();
		// TODO 实现 方法描述 逻辑
		return result;
	}
}