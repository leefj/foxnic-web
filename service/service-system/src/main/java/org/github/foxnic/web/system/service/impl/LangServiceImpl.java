package org.github.foxnic.web.system.service.impl;

import java.lang.reflect.Field;

import javax.annotation.Resource;

import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_LANG;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.domain.system.Lang;
import org.github.foxnic.web.domain.system.LangVO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.system.service.IConfigService;
import org.github.foxnic.web.system.service.ILangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.api.error.CommonError;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.mvc.Result;

/**
 * <p>
 * 语言条目表 服务实现类
 * </p>
 * 
 * @author 李方捷
 * @since 2021-03-31 09:59:55
 */

@Service("SysLangServiceImpl")
public class LangServiceImpl extends SuperService<Lang> implements ILangService {

	@Autowired
	private IConfigService configService;

	@Resource(name = DBConfigs.PRIMARY_DAO)
	private DAO dao = null;

	/**
	 * 获得 DAO 对象
	 */
	public DAO dao() {
		return dao;
	}

	/**
	 * 生成主键值
	 */
	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSUID(true);
	}

	/**
	 * 按主键删除语言条目
	 *
	 * @param key 键 , 详情 : 键
	 * @return 查询结果 , Lang对象
	 */
	public boolean deleteByIdPhysical(String code) {
		Lang lang = new Lang();
		if (code == null)
			throw new IllegalArgumentException("code 不允许为 null 。");
		lang.setCode(code);
		return dao.deleteEntity(lang);
	}

	/**
	 * 按主键获取语言条目
	 *
	 * @param code 键
	 * @return 查询结果 , Lang对象
	 */
	public Lang getById(String code) {
		Lang sample = new Lang();
		if (code == null)
			throw new IllegalArgumentException("key 不允许为 null 。");
		sample.setCode(code);
		return dao.queryEntity(sample);
	}

	/**
	 * 检查 语言条目 是否已经存在
	 *
	 * @param langVO 数据对象
	 * @return 判断结果
	 */
	public Result<Lang> checkExists(LangVO langVO) {
		if (langVO.getCode() == null) {
			if (this.checkExists(langVO, SYS_LANG.DEFAULTS)) {
				return ErrorDesc.failureMessage("词条已经存在", CommonError.DATA_REPETITION);
			}
		}
		return ErrorDesc.success();
	}

	private LocalCache<String, String> itemCache = new LocalCache<String, String>();

	@Override
	public String translate(Language language, String defaults, String code) {

		String cacheKey = language.name() + ":";
		if (StringUtil.isBlank(code)) {
			cacheKey += defaults;
		} else {
			cacheKey += code;
		}
		// 获取缓存数据
		String item = itemCache.get(cacheKey);
		if (item != null) {
			return item;
		}
		// 获取数据库中的配置
		Rcd r = null;
		if (item == null) {
			if (StringUtil.isBlank(code)) {
				r = dao.queryRecord("select " + language.name() + " item from " + table()
						+ " where defaults=? and deleted=0 and valid=1", defaults);
			} else {
				r = dao.queryRecord("select " + language.name() + " item from " + table()
						+ " where key=? and deleted=0 and valid=1", code);
			}
		}
		// 如果还是null，登记
		if (r == null) {
			if (StringUtil.isBlank(code)) {
				code = IDGenerator.getSUID(true);
			}
			Lang lang = new Lang();
			lang.setCode(code);
			lang.setDefaults(defaults);
			lang.setValid(1);
			this.insert(lang);
		} else {
			item = r.getString("item");
			if (item != null) {
				itemCache.put(cacheKey, item);
				return item;
			}
		}

		return StringUtil.isBlank(defaults) ? code : defaults;
	}

	@Override
	public String translate(String defaults, String key) {
		String sysLangValue = configService.getById(SystemConfigEnum.SYSTEM_LANGUAGE).getValue();
		// 调试写死
//		sysLangValue = "confuse";
		Language sysLang = Language.valueOf(sysLangValue);
		return this.translate(sysLang, defaults, key);
	}

	@Override
	public String translate(String defaults) {
		return translate(defaults, null);
	}

}