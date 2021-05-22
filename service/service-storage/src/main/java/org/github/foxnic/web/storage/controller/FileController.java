package org.github.foxnic.web.storage.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.springboot.api.error.CommonError;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.mvc.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
import java.util.List;
import java.util.Map;


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
	 * 获取系统配置
	 */
	@ApiOperation(value = "获取附件详情")
	@ApiImplicitParams({
			@ApiImplicitParam(name = FileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = FileVOMeta.ID)
	@SentinelResource(value = FileServiceProxy.GET_BY_ID)
	@PostMapping(FileServiceProxy.GET_BY_ID)
	public Result<File> getById(String id) {
		Result<File> result=new Result<>();
		File file=fileService.getById(id);
		result.success(true).data(file);
		return result;
	}



	/**
	 * 分页查询系统配置
	 */
	@ApiOperation(value = "分页查询系统配置")
	@ApiImplicitParams({
			@ApiImplicitParam(name = FileVOMeta.ID , value = "文件ID" , required = true , dataTypeClass=String.class , example = "2152"),
			@ApiImplicitParam(name = FileVOMeta.FILE_NAME , value = "文件名" , required = false , dataTypeClass=String.class , example = "某某方案"),
			@ApiImplicitParam(name = FileVOMeta.FILE_TYPE , value = "文件类型" , required = false , dataTypeClass=String.class , example = ".jpg"),
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