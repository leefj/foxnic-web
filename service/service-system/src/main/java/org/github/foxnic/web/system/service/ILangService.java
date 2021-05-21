package org.github.foxnic.web.system.service;
import org.github.foxnic.web.domain.system.Lang;
import org.github.foxnic.web.domain.system.LangVO;
import org.github.foxnic.web.framework.language.LanguageService;

import com.github.foxnic.dao.entity.ISuperService;
import com.github.foxnic.springboot.mvc.Result;
/**
 * <p>
 * 语言条目表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-31 09:59:55
*/

public interface ILangService extends ISuperService<Lang>,LanguageService {

	
	/**
	 * 按主键删除语言条目
	 *
	 * @param key 键 , 详情 : 键
	 * @return 查询结果 , Lang对象
	 */
	boolean deleteByIdPhysical(String key);
	
	/**
	 * 按主键获取语言条目
	 *
	 * @param key 键
	 * @return 查询结果 , Lang对象
	 */
	Lang getById(String key);
	
	/**
	 * 检查 语言条目 是否已经存在
	 *
	 * @param langVO 数据对象
	 * @return 判断结果
	 */
	Result<Lang> checkExists(LangVO langVO);
	
 
	

}