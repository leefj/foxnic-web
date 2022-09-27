package org.github.foxnic.web.example.controller;


import java.util.List;
import java.util.ArrayList;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


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
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.github.foxnic.web.domain.example.AddressPureModel;
import org.github.foxnic.web.domain.oauth.User;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * <p>
 * 订单地址接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-27 16:03:25
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
	@ApiOperationSupport(order=1)
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
	@ApiOperationSupport(order=2)
	@NotNull(name = AddressVOMeta.ID)
	@SentinelResource(value = AddressServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AddressServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		Boolean hasRefer = addressService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(hasRefer).requireEqual("不允许删除当前记录",false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
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
	@ApiOperationSupport(order=3) 
	@NotNull(name = AddressVOMeta.IDS)
	@SentinelResource(value = AddressServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AddressServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, Boolean> hasRefersMap = addressService.hasRefers(ids);
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
			Result result=addressService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=addressService.deleteByIdsLogical(canDeleteIds);
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
	@ApiOperationSupport( order=4 , ignoreParameters = { AddressVOMeta.PAGE_INDEX , AddressVOMeta.PAGE_SIZE , AddressVOMeta.SEARCH_FIELD , AddressVOMeta.FUZZY_FIELD , AddressVOMeta.SEARCH_VALUE , AddressVOMeta.DIRTY_FIELDS , AddressVOMeta.SORT_FIELD , AddressVOMeta.SORT_TYPE , AddressVOMeta.IDS } )
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
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AddressVOMeta.PAGE_INDEX , AddressVOMeta.PAGE_SIZE , AddressVOMeta.SEARCH_FIELD , AddressVOMeta.FUZZY_FIELD , AddressVOMeta.SEARCH_VALUE , AddressVOMeta.DIRTY_FIELDS , AddressVOMeta.SORT_FIELD , AddressVOMeta.SORT_TYPE , AddressVOMeta.IDS } )
	@NotNull(name = AddressVOMeta.ID)
	@NotNull(name = AddressVOMeta.REGION_TYPE)
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
	@ApiOperationSupport(order=6)
	@NotNull(name = AddressVOMeta.ID)
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
	@ApiOperationSupport(order=8)
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
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AddressServiceProxy.NEW_API_NAME_2 , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AddressServiceProxy.NEW_API_NAME_2)
	public Result<List<AddressPureModel>> newApiName2(AddressVO address , List<AddressModel> model , Map<String,User> userMap) {
		Result<List<AddressPureModel>> result = new Result<>();
		// TODO 实现 方法描述 逻辑
		return result;
	}


}