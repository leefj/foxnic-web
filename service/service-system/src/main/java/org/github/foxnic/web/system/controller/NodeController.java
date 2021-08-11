package org.github.foxnic.web.system.controller;

 
import java.util.List;

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


import org.github.foxnic.web.proxy.system.NodeServiceProxy;
import org.github.foxnic.web.domain.system.meta.NodeVOMeta;
import org.github.foxnic.web.domain.system.Node;
import org.github.foxnic.web.domain.system.NodeVO;
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
import org.github.foxnic.web.domain.system.meta.NodeMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.github.foxnic.web.system.service.INodeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 *  接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-11 17:11:20
*/

@Api(tags = "sys_node")
@ApiSort(0)
@RestController("SysNodeController")
public class NodeController extends SuperController {

	@Autowired
	private INodeService nodeService;

	
	/**
	 * 添加sys_node
	*/
	@ApiOperation(value = "添加sys_node")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NodeVOMeta.ID , value = "实例id" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NodeVOMeta.HOST_ID , value = "主机ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NodeVOMeta.APPLICATION_NAME , value = "应用名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NodeVOMeta.PORT , value = "端口" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = NodeVOMeta.PROCESS_ID , value = "进程号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NodeVOMeta.START_TIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = NodeVOMeta.IS_UP , value = "是否启动" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = NodeVOMeta.HEART_BEAT_TIME , value = "心跳时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = NodeVOMeta.ID)
	@SentinelResource(value = NodeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NodeServiceProxy.INSERT)
	public Result insert(NodeVO nodeVO) {
		Result result=nodeService.insert(nodeVO);
		return result;
	}

	
	/**
	 * 删除sys_node
	*/
	@ApiOperation(value = "删除sys_node")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NodeVOMeta.ID , value = "实例id" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = NodeVOMeta.ID)
	@SentinelResource(value = NodeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NodeServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=nodeService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除sys_node <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除sys_node")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NodeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = NodeVOMeta.IDS)
	@SentinelResource(value = NodeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NodeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=nodeService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新sys_node
	*/
	@ApiOperation(value = "更新sys_node")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NodeVOMeta.ID , value = "实例id" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NodeVOMeta.HOST_ID , value = "主机ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NodeVOMeta.APPLICATION_NAME , value = "应用名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NodeVOMeta.PORT , value = "端口" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = NodeVOMeta.PROCESS_ID , value = "进程号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NodeVOMeta.START_TIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = NodeVOMeta.IS_UP , value = "是否启动" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = NodeVOMeta.HEART_BEAT_TIME , value = "心跳时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { NodeVOMeta.PAGE_INDEX , NodeVOMeta.PAGE_SIZE , NodeVOMeta.SEARCH_FIELD , NodeVOMeta.FUZZY_FIELD , NodeVOMeta.SEARCH_VALUE , NodeVOMeta.SORT_FIELD , NodeVOMeta.SORT_TYPE , NodeVOMeta.IDS } ) 
	@NotNull(name = NodeVOMeta.ID)
	@SentinelResource(value = NodeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NodeServiceProxy.UPDATE)
	public Result update(NodeVO nodeVO) {
		Result result=nodeService.update(nodeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存sys_node
	*/
	@ApiOperation(value = "保存sys_node")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NodeVOMeta.ID , value = "实例id" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NodeVOMeta.HOST_ID , value = "主机ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NodeVOMeta.APPLICATION_NAME , value = "应用名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NodeVOMeta.PORT , value = "端口" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = NodeVOMeta.PROCESS_ID , value = "进程号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NodeVOMeta.START_TIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = NodeVOMeta.IS_UP , value = "是否启动" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = NodeVOMeta.HEART_BEAT_TIME , value = "心跳时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { NodeVOMeta.PAGE_INDEX , NodeVOMeta.PAGE_SIZE , NodeVOMeta.SEARCH_FIELD , NodeVOMeta.FUZZY_FIELD , NodeVOMeta.SEARCH_VALUE , NodeVOMeta.SORT_FIELD , NodeVOMeta.SORT_TYPE , NodeVOMeta.IDS } )
	@NotNull(name = NodeVOMeta.ID)
	@SentinelResource(value = NodeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NodeServiceProxy.SAVE)
	public Result save(NodeVO nodeVO) {
		Result result=nodeService.save(nodeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取sys_node
	*/
	@ApiOperation(value = "获取sys_node")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = NodeVOMeta.ID)
	@SentinelResource(value = NodeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NodeServiceProxy.GET_BY_ID)
	public Result<Node> getById(String id) {
		Result<Node> result=new Result<>();
		Node node=nodeService.getById(id);
		result.success(true).data(node);
		return result;
	}


	/**
	 * 批量删除sys_node <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除sys_node")
		@ApiImplicitParams({
				@ApiImplicitParam(name = NodeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = NodeVOMeta.IDS)
		@SentinelResource(value = NodeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NodeServiceProxy.GET_BY_IDS)
	public Result<List<Node>> getByIds(List<String> ids) {
		Result<List<Node>> result=new Result<>();
		List<Node> list=nodeService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询sys_node
	*/
	@ApiOperation(value = "查询sys_node")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NodeVOMeta.ID , value = "实例id" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NodeVOMeta.HOST_ID , value = "主机ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NodeVOMeta.APPLICATION_NAME , value = "应用名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NodeVOMeta.PORT , value = "端口" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = NodeVOMeta.PROCESS_ID , value = "进程号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NodeVOMeta.START_TIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = NodeVOMeta.IS_UP , value = "是否启动" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = NodeVOMeta.HEART_BEAT_TIME , value = "心跳时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { NodeVOMeta.PAGE_INDEX , NodeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = NodeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NodeServiceProxy.QUERY_LIST)
	public Result<List<Node>> queryList(NodeVO sample) {
		Result<List<Node>> result=new Result<>();
		List<Node> list=nodeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询sys_node
	*/
	@ApiOperation(value = "分页查询sys_node")
	@ApiImplicitParams({
		@ApiImplicitParam(name = NodeVOMeta.ID , value = "实例id" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = NodeVOMeta.HOST_ID , value = "主机ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NodeVOMeta.APPLICATION_NAME , value = "应用名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NodeVOMeta.PORT , value = "端口" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = NodeVOMeta.PROCESS_ID , value = "进程号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = NodeVOMeta.START_TIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = NodeVOMeta.IS_UP , value = "是否启动" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = NodeVOMeta.HEART_BEAT_TIME , value = "心跳时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = NodeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(NodeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Node>> queryPagedList(NodeVO sample) {
		Result<PagedList<Node>> result=new Result<>();
		PagedList<Node> list=nodeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = NodeServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(NodeServiceProxy.EXPORT_EXCEL)
	public void exportExcel(NodeVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=nodeService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = NodeServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(NodeServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=nodeService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = NodeServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(NodeServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=nodeService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}