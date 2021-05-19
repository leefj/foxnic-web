package com.scientific.tailoring.system.service.impl;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.environment.OSType;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.spring.SpringUtil;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.springboot.web.MimeUtil;
import com.scientific.tailoring.domain.system.File;
import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.system.service.IFileService;

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
	
 
	private String uploadDir;
	
	@PostConstruct
	private void init() {
		uploadDir=SpringUtil.getEnvProperty("upload."+OSType.getOSType().name().toLowerCase());
		Logger.info("uploadDir = "+uploadDir);
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
		return null;
	}
	
	/**
	 * 按主键删除sys_file
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , File对象
	 */
	public boolean deleteByIdPhysical(Long id) {
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
	public boolean deleteByIdLogical(Long id) {
		File file = new File();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		file.setId(id);
		file.setDeleted(true);
		return dao.updateEntity(file,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 按主键获取sys_file
	 *
	 * @param id ID
	 * @return 查询结果 , File对象
	 */
	public File getById(Long id) {
		File sample = new File();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public Long uploadFile(MultipartFile file) {
		byte[] bytes=new byte[0];
        try {
            bytes = file.getBytes();
        } catch (Exception e) {
            Logger.error("文件字节错误",e);
        }
        File fileinfo=new File();
        //获取源文件名称
        String originalFileName = file.getOriginalFilename();
        //获取文件后缀
        String extension = FileUtil.getExtName(originalFileName);
       
        fileinfo.setFileName(originalFileName);
        fileinfo.setFileType(extension);
        
        String url=null;
		try {
			java.io.File f=FileUtil.resolveByPath(uploadDir, DateUtil.format(new Date(), "yyyyMMdd"),IDGenerator.getSnowflakeId()+"."+extension);
			url=f.getAbsolutePath().substring(uploadDir.length());
			fileinfo.setLocation(url);
			if(!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}
			FileOutputStream out=new FileOutputStream(f);
			fileinfo.setSize(new Long(bytes.length));
			IOUtils.write(bytes, out);
			
			this.insert(fileinfo);
			
		} catch (Exception e) {
			Logger.error("文件写入错误",e);
		}
        return fileinfo.getId();
	}
	
	/**
     *  文件下载
     * @param fileUrl 当前对象文件路径
     * @param response   HttpServletResponse 内置对象
     * @throws IOException
     */
    public void downloadFile(Long id,HttpServletResponse response)  {
        byte[] bytes=null;
        File file=this.getById(id);
        if(file==null) {
        	Logger.error("文件不存在");
			return;
        }
		try {
			if(!OSType.isWindows()){
				file.setLocation(file.getLocation().replace('\\','/'));
			}
			java.io.File f=FileUtil.resolveByPath(uploadDir, file.getLocation());
			Logger.info(f.getAbsolutePath());
			if(!f.exists()) {
				Logger.error("文件不存在");
				return;
			}
			FileInputStream in=new FileInputStream(f);
			bytes =IOUtils.readFully(in, in.available());
		} catch (IOException e) {
			Logger.error("文件下载异常",e);
		}
		
        try {
        	OutputStream toClient = response.getOutputStream();
 
    		String contentType=MimeUtil.getFileMime(file.getFileName());
    		 
    		response.setContentType(contentType);
    		response.setContentLength(bytes.length);
    		response.setHeader("Content-Disposition",
    				"attachment; filename=" + new String(file.getFileName().getBytes("UTF-8"), "ISO8859-1"));
    		toClient.write(bytes);
    		toClient.flush();
    		toClient.close();
 
		} catch (Exception e) {
			Logger.error("文件下载异常", e);
		}
    }


	 

}