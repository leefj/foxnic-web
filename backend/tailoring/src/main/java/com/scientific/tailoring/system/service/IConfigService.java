package com.scientific.tailoring.system.service;
import com.github.foxnic.dao.entity.ISuperService;
import com.scientific.tailoring.constants.enums.SystemEnum;
import com.scientific.tailoring.domain.system.Config;
/**
 * <p>
 * 系统配置表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-25 07:46:53
*/

public interface IConfigService extends ISuperService<Config> {
	
	

	/**
	 * 按主键删除系统配置
	 *
	 * @param key 配置键 , 详情 : 配置键
	 * @return 查询结果 , Config对象
	 */
	boolean deleteByIdPhysical(String key);
	
	/**
	 * 按主键删除系统配置
	 *
	 * @param key 配置键 , 详情 : 配置键
	 * @return 查询结果 , Config对象
	 */
	boolean deleteByIdLogical(String key);
	
	/**
	 * 按主键获取系统配置
	 *
	 * @param key 配置键
	 * @return 查询结果 , Config对象
	 */
	Config getById(String key);

	Config getById(SystemEnum key);

}