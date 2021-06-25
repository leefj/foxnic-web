package org.github.foxnic.web.storage.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.sql.expr.Update;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.domain.storage.File;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.storage.service.IFileService;
import org.github.foxnic.web.storage.support.StorageSupport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-19 02:41:52
*/

@Service("SysFileServiceImpl")
public class FileServiceImpl extends SuperService<File> implements IFileService {
	
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;
	@Value("${storage.mode}")
	private String storageMode;

 	private StorageSupport storageSupport;


	private StorageSupport getStorageSupport() {
		if(storageSupport==null) {
			this.storageSupport = StorageSupport.getStorageSupport(this.storageMode);
		}
		return  this.storageSupport;
	}



	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
	
	/**
	 * 生成主键值
	 * */
	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}
	
	/**
	 * 按主键删除sys_file
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , File对象
	 */
	public boolean deleteByIdPhysical(String id) {
		File file = new File();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		file.setId(id);
		return dao.deleteEntity(file);
	}
	
	/**
	 * 按主键删除sys_file
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , File对象
	 */
	public boolean deleteByIdLogical(String id) {
		File file = new File();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		file.setId(id);
		file.setDeleted(1);
		return dao.updateEntity(file,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 按主键获取sys_file
	 *
	 * @param id ID
	 * @return 查询结果 , File对象
	 */
	public File getById(String id) {
		File sample = new File();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		File file=dao.queryEntity(sample);
		resurgence(id,false);
		return file;
	}

	private void resurgence(String fileId,boolean dowloads) {
		resurgence(Arrays.asList(fileId),dowloads);
	}

	/**
	 * 登记文件访问情况
	 * */
	private void resurgence(List<String> fileIds,boolean dowloads) {
		Update update=dao().update(this.table())
				.set(FoxnicWeb.SYS_FILE.DELETED,dao().getDBTreaty().getFalseValue())
				.set(FoxnicWeb.SYS_FILE.LATEST_VISIT_TIME,new Date()).where().andIn("id",fileIds).top();
		if(dowloads) {
			update.setExpr("downloads","downloads+1");
		}
		update.execute();
	}

	@Override
	public File uploadFile(MultipartFile multipartFile) {
		File fileinfo=new File();
		fileinfo.setDownloads(0);
		//获取源文件名称
		String originalFileName = multipartFile.getOriginalFilename();
		//获取文件后缀
		String extension = FileUtil.getExtName(originalFileName);

		fileinfo.setFileName(originalFileName);
		fileinfo.setFileType(extension);
		fileinfo=this.getStorageSupport().write(fileinfo,multipartFile);
		this.insert(fileinfo);
		return  fileinfo;
	}

	@Override
	public void downloadFile(String id,Boolean inline,HttpServletResponse response) {
		File fileInfo=this.getById(id);
		Result result=null;

		if(fileInfo==null) {
			Logger.error("文件不存在");
			result= ErrorDesc.failure(CommonError.DATA_NOT_EXISTS).message("文件不存在");
		}
		byte[] bytes=null;
		try {

			resurgence(id,true);

			bytes=this.getStorageSupport().read(fileInfo);
			DownloadUtil.writeToOutput(response,bytes,fileInfo.getFileName(),null,inline);
			return;
		}catch (Exception e) {
			Logger.error(e.getMessage(),e);
			result= ErrorDesc.failure(CommonError.FILE_INVALID).message(e.getMessage());
		}

		if(result!=null) {
			try {
				response.getWriter().write(JSON.toJSONString(result));
			} catch (IOException e) {
				Logger.error("下载失败，输出异常",e);
			}
		}

	}



}