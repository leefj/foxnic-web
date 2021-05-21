package org.github.foxnic.web.storage.service;
import javax.servlet.http.HttpServletResponse;

import org.github.foxnic.web.domain.storage.File;
import org.springframework.web.multipart.MultipartFile;

import com.github.foxnic.dao.entity.ISuperService;
/**
 * <p>
 *  服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-19 02:41:52
*/

public interface IFileService extends ISuperService<File> {

	/**
	 * 按主键删除sys_file
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , File对象
	 */
	boolean deleteByIdPhysical(String id);
	
	/**
	 * 按主键删除sys_file
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , File对象
	 */
	boolean deleteByIdLogical(String id);
	
	/**
	 * 按主键获取sys_file
	 *
	 * @param id ID
	 * @return 查询结果 , File对象
	 */
	File getById(String id);

	/**
	 * 保存文件
	 * */
	String uploadFile(MultipartFile mf);
	
	/**
	 * 文件下载
	 * */
	void downloadFile(String id,HttpServletResponse response);

}