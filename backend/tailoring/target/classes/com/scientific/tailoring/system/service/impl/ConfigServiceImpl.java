package com.scientific.tailoring.system.service.impl;
import java.lang.reflect.Field;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.scientific.tailoring.constants.enums.SystemEnum;
import com.scientific.tailoring.domain.system.Config;
import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.system.service.IConfigService;

/**
 * <p>
 * 系统配置表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-25 07:46:53
*/

@Service("SysConfigServiceImpl")
public class ConfigServiceImpl  extends SuperService<Config> implements IConfigService {
	
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
	
	/**
	 * 生成主键值
	 * */
	@Override
	public Object generateId(Field field) {
		return IDGenerator.getUUID();
	}
	
	/**
	 * 按主键删除系统配置
	 *
	 * @param code 配置键 , 详情 : 配置键
	 * @return 查询结果 , Config对象
	 */
	public boolean deleteByIdPhysical(String code) {
		Config config = new Config();
		if(code==null) throw new IllegalArgumentException("key 不允许为 null 。");
		config.setCode(code);
		return dao.deleteEntity(config);
	}
	
	/**
	 * 按主键删除系统配置
	 *
	 * @param code 配置键 , 详情 : 配置键
	 * @return 查询结果 , Config对象
	 */
	public boolean deleteByIdLogical(String code) {
		Config config = new Config();
		if(code==null) throw new IllegalArgumentException("key 不允许为 null 。");
		config.setCode(code);
		config.setDeleted(true);
		config.setDeleteBy((Long)dao.getDBTreaty().getLoginUserId());
		config.setDeleteTime(new Date());
		return dao.updateEntity(config,SaveMode.NOT_NULL_FIELDS);
	}
	
	private LocalCache<String, Config> cache=new LocalCache<>(1000*60*15);
	
	/**
	 * 按主键获取系统配置
	 *
	 * @param code 配置键
	 * @return 查询结果 , Config对象
	 */
	public Config getById(String code) {
		Config sample =cache.get(code);
		if(sample!=null) return sample;
		sample=new Config();
		if(code==null) throw new IllegalArgumentException("key 不允许为 null 。");
		sample.setCode(code);
		sample=dao.queryEntity(sample);
		cache.put(code,sample);
		return sample;
		
	}

	@Override
	public Config getById(SystemEnum cfg) {
		return this.getById(cfg.code());
	}
}