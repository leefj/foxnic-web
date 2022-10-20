package org.github.foxnic.web.storage.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.api.validate.annotations.NotNull;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.dao.data.PagedList;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.constants.enums.system.FileCatalog;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author 李方捷
 * @since 2021-03-19 02:41:52
*/

@InDoc
@Api(tags = "存储服务/存储接口")
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
			File fileInfo=fileService.uploadFile(mf);
			String id = fileInfo.getId();
			ret.put("fileId",id);
			ret.put("fileName", mf.getOriginalFilename());
			ret.put("field",mf.getName());
			list.add(ret);
		}
		response.getWriter().write(JSON.toJSONString(ErrorDesc.success().data(list)));
	}

	@SentinelResource(value = FileServiceProxy.DOWNLOAD)
	@RequestMapping(FileServiceProxy.DOWNLOAD)
	public void download(HttpServletRequest request,HttpServletResponse response,String id,String inline,String catalog) throws Exception {
		Boolean il= DataParser.parseBoolean(inline);
		FileCatalog fileCatalog=FileCatalog.parseByCode(catalog);
		if(fileCatalog==null) {
			fileCatalog=FileCatalog.FILE;
		}
		fileService.downloadFile(id,il,response,fileCatalog);
    }

	@RequestMapping(FileServiceProxy.IMAGE)
	public void image(HttpServletRequest request,HttpServletResponse response,String id,String catalog) throws Exception {
		FileCatalog fileCatalog=FileCatalog.parseByCode(catalog);
		if(fileCatalog==null) {
			fileCatalog=FileCatalog.FILE;
		}
		fileService.downloadFile(id,true,response,fileCatalog);
	}




	/**
	 * 删除附件
	*/
	@ApiOperation(value = "删除系统文件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FileVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "10"),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = FileVOMeta.ID)
	@SentinelResource(value = FileServiceProxy.DELETE)
	@PostMapping(FileServiceProxy.DELETE)
	public Result<File> deleteById(String id) {
		Result<File> result=new Result<>();
		fileService.deleteByIdLogical(id);
		result.success(true);
		return result;
	}


	/**
	 * 批量删除附件 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除附件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FileVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3)
	@NotNull(name = FileVOMeta.IDS)
	@SentinelResource(value = FileServiceProxy.BATCH_DELETE)
	@PostMapping(FileServiceProxy.BATCH_DELETE)
	public Result deleteByIds(List<String> ids) {
		Result result=fileService.deleteByIdsLogical(ids);
		return result;
	}


	/**
	 * 获取附件信息
	*/
	@ApiOperation(value = "获取附件信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FileVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=String.class , example = "1,2"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = FileVOMeta.IDS)
	@SentinelResource(value = FileServiceProxy.GET_BY_IDS)
	@PostMapping(FileServiceProxy.GET_BY_IDS)
	public Result<List<File>> getByIds(List<String> ids) {
		Result<List<File>> result=new Result<>();
		List<File> files=fileService.getByIds(ids);
		result.success(true).data(files);
		return result;
	}

	/**
	 * 获取附件信息
	 */
	@ApiOperation(value = "获取附件信息")
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
	 * 获取附件Base64数据
	 */
	@ApiOperation(value = "获取附件Base64数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = FileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = FileVOMeta.ID)
	@SentinelResource(value = FileServiceProxy.FILE_DATA)
	@RequestMapping(FileServiceProxy.FILE_DATA)
	public Result<String> getFileData(String id) {
		return fileService.getFileData(id);
	}

	/**
	 * 查询附件信息
	*/
	@ApiOperation(value = "查询系统文件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FileVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "10"),
		@ApiImplicitParam(name = FileVOMeta.FILE_NAME , value = "文件名" , required = false , dataTypeClass=String.class , example = "0273663d4b44e40d086420e6b59dd768.jpeg"),
		@ApiImplicitParam(name = FileVOMeta.LOCATION , value = "存储位置" , required = false , dataTypeClass=String.class , example = "/20210319/425396608000065536.jpeg"),
		@ApiImplicitParam(name = FileVOMeta.SIZE , value = "文件大小" , required = false , dataTypeClass=Long.class , example = "44781"),
		@ApiImplicitParam(name = FileVOMeta.MEDIA_TYPE , value = "媒体类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FileVOMeta.FILE_TYPE , value = "文件类型" , required = false , dataTypeClass=String.class , example = "jpeg"),
		@ApiImplicitParam(name = FileVOMeta.DOWNLOAD_URL , value = "可直接下载的地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FileVOMeta.LATEST_VISIT_TIME , value = "最后访问时间" , required = false , dataTypeClass= Date.class),
		@ApiImplicitParam(name = FileVOMeta.DOWNLOADS , value = "下载次数" , required = true , dataTypeClass=Integer.class , example = "0"),
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
	 * 分页查询附件
	*/
	@ApiOperation(value = "分页查询系统文件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FileVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class , example = "10"),
		@ApiImplicitParam(name = FileVOMeta.FILE_NAME , value = "文件名" , required = false , dataTypeClass=String.class , example = "0273663d4b44e40d086420e6b59dd768.jpeg"),
		@ApiImplicitParam(name = FileVOMeta.LOCATION , value = "存储位置" , required = false , dataTypeClass=String.class , example = "/20210319/425396608000065536.jpeg"),
		@ApiImplicitParam(name = FileVOMeta.SIZE , value = "文件大小" , required = false , dataTypeClass=Long.class , example = "44781"),
		@ApiImplicitParam(name = FileVOMeta.MEDIA_TYPE , value = "媒体类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FileVOMeta.FILE_TYPE , value = "文件类型" , required = false , dataTypeClass=String.class , example = "jpeg"),
		@ApiImplicitParam(name = FileVOMeta.DOWNLOAD_URL , value = "可直接下载的地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FileVOMeta.LATEST_VISIT_TIME , value = "最后访问时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = FileVOMeta.DOWNLOADS , value = "下载次数" , required = true , dataTypeClass=Integer.class , example = "0"),
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
