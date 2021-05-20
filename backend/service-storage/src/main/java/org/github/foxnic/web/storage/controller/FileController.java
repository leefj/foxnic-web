package org.github.foxnic.web.storage.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.proxy.storage.FileServiceProxy;
import org.github.foxnic.web.storage.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.springboot.api.error.CommonError;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.mvc.Result;
import com.github.xiaoymin.knife4j.annotations.ApiSort;

import io.swagger.annotations.Api;


/**
 * @author 李方捷
 * @since 2021-03-19 02:41:52
*/

@Api(tags = "sys_file")
@ApiSort(1006)
@Controller("SysFileController")
public class FileController extends SuperController {
	
	@Autowired
	private IFileService fileService;

	
	
	@PostMapping(FileServiceProxy.API_PREFIX+"upload")
	public void upload(MultipartHttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		Map<String, MultipartFile> map = request.getFileMap();
//		response.setCharacterEncoding("GBK");
		if(map==null || map.size()==0) {
			response.getWriter().write(JSON.toJSONString(ErrorDesc.failure(CommonError.FILE_INVALID)));
			return ;
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
			Long id = fileService.uploadFile(mf);
			ret.put("fileId",id);
			ret.put("fileName", mf.getOriginalFilename());
			ret.put("field",mf.getName());
			list.add(ret);
		}
		response.getWriter().write(JSON.toJSONString(ErrorDesc.success().data(list)));
	}
	
	@RequestMapping(FileServiceProxy.API_PREFIX+"download")
	public void download(HttpServletRequest request,HttpServletResponse response,Long id) throws Exception {
 
		fileService.downloadFile(id, response);
 
    }
}