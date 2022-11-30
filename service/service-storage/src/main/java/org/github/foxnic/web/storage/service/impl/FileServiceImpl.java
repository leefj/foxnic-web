package org.github.foxnic.web.storage.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.encrypt.Base64Util;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.meta.DBColumnMeta;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.sql.expr.Expr;
import com.github.foxnic.sql.expr.In;
import com.github.foxnic.sql.expr.Update;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.enums.system.FileCatalog;
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
import java.util.Map;

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
	@Value("${foxnic.storage.mode}")
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

	@Override
	public <T> Map<T, ReferCause> hasRefers(List<T> ids) {
		// 默认无业务逻辑，返回此行；有业务逻辑需要校验时，请修改并使用已注释的行代码！！！
		return MapUtil.asMap(ids,new ReferCause(false));
		// return super.hasRefers(FoxnicWeb.BPM_PROCESS_INSTANCE.FORM_DEFINITION_ID,ids);
	}

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
		if(file!=null) {
			Logger.info("Get File : "+JSON.toJSON(file));
		} else {
			Logger.info("No File : "+id);
		}
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
		fileinfo.setMediaType(multipartFile.getContentType());
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
	public byte[] getBytes(File fileInfo) {
		byte[] bytes=null;
		try {
			resurgence(fileInfo.getId(),true);
			bytes=this.getStorageSupport().read(fileInfo);
		} catch (Exception e) {
			Logger.error("文件读取失败,fileId="+fileInfo.getId());
		}
		return bytes;
	}

	@Override
	public Result<String> getFileData(String id) {
		File fileInfo=this.getById(id);
		if(fileInfo==null) {
			return ErrorDesc.failure(CommonError.FILE_INVALID,"文件信息不存在");
		}
		byte[] data=this.getBytes(fileInfo);
		if(data==null) {
			return ErrorDesc.failure(CommonError.FILE_INVALID,"文件不存在");
		}
		Result<String> result=new Result<>();
		result.success(true);
		result.data(Base64Util.encodeToString(data));
		return result;
	}

	@Override
	public void downloadFile(String id, Boolean inline, HttpServletResponse response, FileCatalog catalog) {
		File fileInfo=this.getById(id);
		Result result=null;

		if(fileInfo==null) {
			Logger.error("文件不存在");
			result= ErrorDesc.failure(CommonError.DATA_NOT_EXISTS).message("file is not exists");
		}
		byte[] bytes=null;
		try {
			if(fileInfo!=null) {
				bytes = this.getBytes(fileInfo);
				if (bytes == null) {
					result = ErrorDesc.failure(CommonError.FILE_INVALID).message("file read error");
				} else {
					DownloadUtil.writeToOutput(response, bytes, fileInfo.getFileName(), null, inline? DownloadUtil.DownloadMode.INLINE: DownloadUtil.DownloadMode.ATTACHMENT);
				}
				return;
			}
		}catch (Exception e) {
			Logger.error("文件下载失败 , fileId="+fileInfo.getId());
			result= ErrorDesc.failure(CommonError.FILE_INVALID).message(e.getMessage());
		}

		if(result!=null) {
			try {
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(JSON.toJSONString(result));
			} catch (IOException e) {
				Logger.error("下载失败，输出异常 , fileId="+fileInfo.getId());
			}
		}

	}

	@Override
	public List<File> getByIds(List<String> ids) {
		DBColumnMeta pk=dao().getTableMeta(table()).getPKColumns().get(0);
		In in=new In(pk.getColumn(),ids);
		Expr select =new Expr("select * from "+table());
		select.append(in.toConditionExpr().startWithWhere());
		List<File> files=dao().queryEntities(File.class,select);
		for (File file : files) {
			file.setExists(this.getStorageSupport().isFileExists(file));
		}

		return files;
	}




}
