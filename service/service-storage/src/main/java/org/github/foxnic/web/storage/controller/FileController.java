package org.github.foxnic.web.storage.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.domain.storage.File;
import org.github.foxnic.web.domain.storage.FileVO;
import org.github.foxnic.web.domain.storage.meta.FileVOMeta;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.proxy.storage.FileServiceProxy;
import org.github.foxnic.web.storage.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.springboot.api.error.CommonError;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * @author 李方捷
 * @since 2021-03-19 02:41:52
*/

@Api(tags = "sys_file")
@ApiSort(1006)
@RestController("SysFileController")
public class FileController extends SuperController {
	
	@Autowired
	private IFileService fileService;

	
	
	@PostMapping(FileServiceProxy.UPLOAD)
	public void upload(MultipartHttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		Map<String, MultipartFile> map = request.getFileMap();
//		response.setCharacterEncoding("GBK");
		if(map==null || map.size()==0) {
			response.getWriter().write(JSON.toJSONString(ErrorDesc.failure(CommonError.FILE_INVALID)));
			return;
		}
		//校验文件清单
		List<Result> subs=new ArrayList<Result>();
		for (String f : map.keySet()) {
			MultipartFile mf = map.get(f);
			if(mf.getSize()<=0) {
				subs.add(ErrorDesc.failure(CommonError.FILE_INVALID).data(mf.getName()));
			}
		}
		if(subs.size()>0) {
			response.getWriter().write(JSON.toJSONString(ErrorDesc.failure(CommonError.FILE_INVALID)));
			return ;
		}
		//
		JSONArray list=new JSONArray();
		JSONObject ret=new JSONObject();
		for (String f : map.keySet()) {
			MultipartFile mf = map.get(f);
			String id = fileService.uploadFile(mf);
			ret.put("fileId",id);
			ret.put("fileName", mf.getOriginalFilename());
			ret.put("field",mf.getName());
			list.add(ret);
		}
		response.getWriter().write(JSON.toJSONString(ErrorDesc.success().data(list)));
	}
	
	@RequestMapping(FileServiceProxy.DOWNLOAD)
	public void download(HttpServletRequest request,HttpServletResponse response,String id) throws Exception {
 
		fileService.downloadFile(id, response);
 
    }

	/**
	 * 添加系统文件
	*/
	@ApiOperation(value = "添加系统文件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FileVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "10"),
		@ApiImplicitParam(name = FileVOMeta.FILE_NAME , value = "文件名" , required = false , dataTypeClass=String.class , example = "0273663d4b44e40d086420e6b59dd768.jpeg"),
		@ApiImplicitParam(name = FileVOMeta.LOCATION , value = "存储位置" , required = false , dataTypeClass=String.class , example = "/20210319/425396608000065536.jpeg"),
		@ApiImplicitParam(name = FileVOMeta.SIZE , value = "文件大小" , required = false , dataTypeClass=Long.class , example = "44781"),
		@ApiImplicitParam(name = FileVOMeta.FILE_TYPE , value = "文件类型" , required = false , dataTypeClass=String.class , example = "jpeg"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = FileVOMeta.ID)
	@SentinelResource(value = FileServiceProxy.INSERT)
	@PostMapping(FileServiceProxy.INSERT)
	public Result<File> insert(FileVO fileVO) {
		Result<File> result=new Result<>();
		boolean suc=fileService.insert(fileVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 删除系统文件
	*/
	@ApiOperation(value = "删除系统文件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FileVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "10")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = FileVOMeta.ID)
	@SentinelResource(value = FileServiceProxy.DELETE)
	@PostMapping(FileServiceProxy.DELETE)
	public Result<File> deleteById(String id) {
		Result<File> result=new Result<>();
		boolean suc=fileService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 批量删除系统文件 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除系统文件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FileVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = FileVOMeta.IDS)
	@SentinelResource(value = FileServiceProxy.BATCH_DELETE)
	@PostMapping(FileServiceProxy.BATCH_DELETE)
	public Result<File> deleteByIds(List<String> ids) {
		Result<File> result=new Result<>();
		boolean suc=fileService.deleteByIdsLogical(ids);
		result.success(suc);
		return result;
	}
	
	/**
	 * 更新系统文件
	*/
	@ApiOperation(value = "更新系统文件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FileVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "10"),
		@ApiImplicitParam(name = FileVOMeta.FILE_NAME , value = "文件名" , required = false , dataTypeClass=String.class , example = "0273663d4b44e40d086420e6b59dd768.jpeg"),
		@ApiImplicitParam(name = FileVOMeta.LOCATION , value = "存储位置" , required = false , dataTypeClass=String.class , example = "/20210319/425396608000065536.jpeg"),
		@ApiImplicitParam(name = FileVOMeta.SIZE , value = "文件大小" , required = false , dataTypeClass=Long.class , example = "44781"),
		@ApiImplicitParam(name = FileVOMeta.FILE_TYPE , value = "文件类型" , required = false , dataTypeClass=String.class , example = "jpeg"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { FileVOMeta.PAGE_INDEX , FileVOMeta.PAGE_SIZE , FileVOMeta.SEARCH_FIELD , FileVOMeta.SEARCH_VALUE , FileVOMeta.IDS } ) 
	@NotNull(name = FileVOMeta.ID)
	@SentinelResource(value = FileServiceProxy.UPDATE)
	@PostMapping(FileServiceProxy.UPDATE)
	public Result<File> update(FileVO fileVO) {
		Result<File> result=new Result<>();
		boolean suc=fileService.update(fileVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 保存系统文件
	*/
	@ApiOperation(value = "保存系统文件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FileVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "10"),
		@ApiImplicitParam(name = FileVOMeta.FILE_NAME , value = "文件名" , required = false , dataTypeClass=String.class , example = "0273663d4b44e40d086420e6b59dd768.jpeg"),
		@ApiImplicitParam(name = FileVOMeta.LOCATION , value = "存储位置" , required = false , dataTypeClass=String.class , example = "/20210319/425396608000065536.jpeg"),
		@ApiImplicitParam(name = FileVOMeta.SIZE , value = "文件大小" , required = false , dataTypeClass=Long.class , example = "44781"),
		@ApiImplicitParam(name = FileVOMeta.FILE_TYPE , value = "文件类型" , required = false , dataTypeClass=String.class , example = "jpeg"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { FileVOMeta.PAGE_INDEX , FileVOMeta.PAGE_SIZE , FileVOMeta.SEARCH_FIELD , FileVOMeta.SEARCH_VALUE , FileVOMeta.IDS } )
	@NotNull(name = FileVOMeta.ID)
	@SentinelResource(value = FileServiceProxy.SAVE)
	@PostMapping(FileServiceProxy.SAVE)
	public Result<File> save(FileVO fileVO) {
		Result<File> result=new Result<>();
		boolean suc=fileService.save(fileVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 获取系统文件
	*/
	@ApiOperation(value = "获取系统文件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = FileVOMeta.ID)
	@SentinelResource(value = FileServiceProxy.GET_BY_ID)
	@PostMapping(FileServiceProxy.GET_BY_ID)
	public Result<File> getById(String id) {
		Result<File> result=new Result<>();
		File role=fileService.getById(id);
		result.success(true).data(role);
		return result;
	}

	
	/**
	 * 查询系统文件
	*/
	@ApiOperation(value = "查询系统文件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FileVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "10"),
		@ApiImplicitParam(name = FileVOMeta.FILE_NAME , value = "文件名" , required = false , dataTypeClass=String.class , example = "0273663d4b44e40d086420e6b59dd768.jpeg"),
		@ApiImplicitParam(name = FileVOMeta.LOCATION , value = "存储位置" , required = false , dataTypeClass=String.class , example = "/20210319/425396608000065536.jpeg"),
		@ApiImplicitParam(name = FileVOMeta.SIZE , value = "文件大小" , required = false , dataTypeClass=Long.class , example = "44781"),
		@ApiImplicitParam(name = FileVOMeta.FILE_TYPE , value = "文件类型" , required = false , dataTypeClass=String.class , example = "jpeg"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { FileVOMeta.PAGE_INDEX , FileVOMeta.PAGE_SIZE } )
	@SentinelResource(value = FileServiceProxy.QUERY_LIST)
	@PostMapping(FileServiceProxy.QUERY_LIST)
	public Result<List<File>> queryList(FileVO sample) {
		Result<List<File>> result=new Result<>();
		List<File> list=fileService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询系统文件
	*/
	@ApiOperation(value = "分页查询系统文件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FileVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "10"),
		@ApiImplicitParam(name = FileVOMeta.FILE_NAME , value = "文件名" , required = false , dataTypeClass=String.class , example = "0273663d4b44e40d086420e6b59dd768.jpeg"),
		@ApiImplicitParam(name = FileVOMeta.LOCATION , value = "存储位置" , required = false , dataTypeClass=String.class , example = "/20210319/425396608000065536.jpeg"),
		@ApiImplicitParam(name = FileVOMeta.SIZE , value = "文件大小" , required = false , dataTypeClass=Long.class , example = "44781"),
		@ApiImplicitParam(name = FileVOMeta.FILE_TYPE , value = "文件类型" , required = false , dataTypeClass=String.class , example = "jpeg"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = FileServiceProxy.QUERY_PAGED_LIST)
	@PostMapping(FileServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<File>> queryPagedList(FileVO sample) {
		Result<PagedList<File>> result=new Result<>();
		PagedList<File> list=fileService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}

}