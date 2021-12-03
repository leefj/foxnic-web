package org.github.foxnic.web.system.service.impl;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.domain.system.Config;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.system.service.IConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 系统配置表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-25 07:46:53
*/

@Service("SysConfigServiceImpl")
public class ConfigServiceImpl  extends SuperService<Config> implements IConfigService {

	@Resource(name= DBConfigs.PRIMARY_DAO)
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
		config.setDeleted(1);
		config.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
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
	public Config getById(SystemConfigEnum cfg) {
		return this.getById(cfg.code());
	}

	@Override
	public Result save(Config entity, SaveMode mode) {
		cache.remove(entity.getCode());
		return super.save(entity, mode);
	}

	@Override
	public Result update(Config entity, SaveMode mode) {
		cache.remove(entity.getCode());
		return super.update(entity, mode);
	}

	@Override
	public ExcelWriter exportExcel(Config sample) {
		return super.exportExcel(sample);
	}

	@Override
	public ExcelWriter exportExcelTemplate() {
		return super.exportExcelTemplate();
	}

	@Override
	public List<ValidateResult> importExcel(InputStream input, int sheetIndex, boolean batch) {
		return super.importExcel(input,sheetIndex,batch);
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}



}
