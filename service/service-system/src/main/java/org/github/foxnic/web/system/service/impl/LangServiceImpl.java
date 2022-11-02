package org.github.foxnic.web.system.service.impl;

import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.language.AcceptLanguages;
import com.github.foxnic.commons.language.GlobalLanguage;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.FieldsBuilder;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.mvc.RequestParameter;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.Expr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.language.Language;
import org.github.foxnic.web.domain.system.Lang;
import org.github.foxnic.web.domain.system.LangVO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.session.SessionUser;
import org.github.foxnic.web.system.service.IConfigService;
import org.github.foxnic.web.system.service.ILangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 语言条目表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-17 11:58:03
*/


@Service("SysLangService")
public class LangServiceImpl extends SuperService<Lang> implements ILangService {

	private static final String NOT_SET = ":ns;";


	@Value("${develop.language:}")
	private String devLang;

	@Autowired
	private IConfigService configService;
	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }

	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 插入实体
	 * @param lang 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Lang lang) {
		boolean ex=this.checkExists(lang, FoxnicWeb.SYS_LANG.DEFAULTS);
		if(ex) return ErrorDesc.success();
		Result r=super.insert(lang,false);
		if(r.success()) {
			invalidItemCache(lang.getCode());
		}
		return r;
	}

	/**
	 * 批量插入实体，事务内
	 * @param langList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Lang> langList) {
		return super.insertList(langList);
	}


	/**
	 * 按主键删除 语言条目
	 *
	 * @param code 编码键
	 * @return 删除是否成功
	 */
	public boolean deleteByIdPhysical(String code) {
		Lang lang = new Lang();
		if(code==null) throw new IllegalArgumentException("code 不允许为 null ");
		lang.setCode(code);
		return dao.deleteEntity(lang);
	}

	/**
	 * 按主键删除 语言条目
	 *
	 * @param code 编码键
	 * @return 删除是否成功
	 */
	public boolean deleteByIdLogical(String code) {
		Lang lang = new Lang();
		if(code==null) throw new IllegalArgumentException("code 不允许为 null 。");
		lang.setCode(code);
		lang.setDeleted(true);
		lang.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		lang.setDeleteTime(new Date());
		return dao.updateEntity(lang,SaveMode.NOT_NULL_FIELDS);
	}

	/**
	 * 更新实体
	 * @param lang 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Lang lang , SaveMode mode) {
		Result r=super.update(lang , mode);
		if(r.success()) {
			invalidItemCache(lang.getCode());
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param langList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Lang> langList , SaveMode mode) {
		return super.updateList(langList , mode);
	}


	/**
	 * 按主键更新字段 语言条目
	 *
	 * @param code 编码键
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String code) {
		if(code==null) throw new IllegalArgumentException("code 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("code = ? ",code).top().execute();
		return suc>0;
	}


	/**
	 * 按主键获取 语言条目
	 *
	 * @param code 编码键
	 * @return Lang 数据对象
	 */
	public Lang getById(String code) {
		Lang sample = new Lang();
		if(code==null) throw new IllegalArgumentException("code 不允许为 null ");
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
			if (this.checkExists(langVO, FoxnicWeb.SYS_LANG.DEFAULTS)) {
				return ErrorDesc.failureMessage("词条已经存在", CommonError.DATA_REPETITION);
			}
		}
		return ErrorDesc.success();
	}

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Lang> queryList(Lang sample,Language... langs) {
		FieldsBuilder fieldsBuilder=this.createFieldsBuilder();
		fieldsBuilder.removeAll();
		fieldsBuilder.add(FoxnicWeb.SYS_LANG.CODE);
		boolean isDefaultsExists=false;
		for (Language lang : langs) {
			if(lang==Language.defaults) {
				isDefaultsExists=true;
			}
			fieldsBuilder.add(lang.code());
		}
		if(!isDefaultsExists) {
			fieldsBuilder.add(Language.defaults.code());
		}
		List<Lang> list=super.queryList(sample,fieldsBuilder);
		return list;
	}


	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<Lang> queryPagedList(Lang sample, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, pageSize, pageIndex);
	}

	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @param condition 其它条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<Lang> queryPagedList(Lang sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 语言条目 是否已经存在
	 *
	 * @param lang 数据对象
	 * @return 判断结果
	 */
	public Result<Lang> checkExists(Lang lang) {
		if (lang.getCode() == null) {
			if (this.checkExists(lang, FoxnicWeb.SYS_LANG.DEFAULTS)) {
				return ErrorDesc.failureMessage("词条已经存在", CommonError.DATA_REPETITION);
			}
		}
		return ErrorDesc.success();
	}

	private LocalCache<String, String> itemCache = new LocalCache<String, String>();

	private void invalidItemCache(String code) {
		Lang lang=this.getById(code);
		if(lang==null) return;
		String key= null;
		for (Language language : Language.values()) {
			key = makeCacheKey(language,lang.getDefaults(),null);
			itemCache.remove(key);
			key = makeCacheKey(language,null,lang.getCode());
			itemCache.remove(key);
		}
	}

	private String makeCacheKey(Language language, String defaults, String code) {
		String cacheKey = language.name() + ":";
		if (StringUtil.isBlank(code)) {
			cacheKey += defaults;
		} else {
			cacheKey += code;
		}
		return cacheKey;
	}

	@Override
	public String translate(Language language, String defaults, String code) {

		String cacheKey = makeCacheKey(language,defaults,code);
		// 获取缓存数据
		String item = itemCache.get(cacheKey);
		if(defaults.equals("账号")) {
			item=null;
		}
		if (item != null) {
			if(NOT_SET.equals(item)) {
				return StringUtil.isBlank(defaults) ? code : defaults;
			}
			return item;
		}
		// 获取数据库中的配置
		Rcd r = null;
		if (item == null) {
			Expr expr = null;
			if (StringUtil.isBlank(code)) {
				expr =new Expr("select " + language.name() + " item from " + table()
						+ " where defaults=? and deleted=0 and valid=1", defaults);
			} else {
				expr =new Expr("select " + language.name() + " item from " + table()
						+ " where key=? and deleted=0 and valid=1", code);
			}
			r = dao.queryRecord(expr);
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
			if (!StringUtil.isBlank(item)) {
				itemCache.put(cacheKey, item);
				return item;
			} else {
				itemCache.put(cacheKey, NOT_SET);
			}
		}

		return StringUtil.isBlank(defaults) ? code : defaults;
	}


	public Language getAutoLanguage() {
		AcceptLanguages acceptLanguages = RequestParameter.get().getAcceptLanguages();
		for (GlobalLanguage gLan : acceptLanguages.getPriorityLanguages()) {
			Language userLanguage = Language.parseByGlobalLanguage(gLan);
			if(userLanguage!=null) {
				return userLanguage;
			}
		}
		return null;
	}


	public Language getUserLanguage() {

		RequestParameter requestParameter=RequestParameter.get();
		HttpSession session = requestParameter.getSession(false);

		// 第一步从会话获取语言
		Language userLanguage=(Language)session.getAttribute(USER_LANGUAGE);
		if(userLanguage!=null) return userLanguage;

		// 优先考虑账户指定的语言
		SessionUser user=SessionUser.getCurrent();
		if(user!=null) {
			// 考虑账户指定的语言，如果未指定，则默认 Auto
			userLanguage=Language.parseByCode(user.getLanguage());
			if(userLanguage==null) {
				userLanguage=Language.auto;
			}
		}

		// 自动识别语言
		if(userLanguage==null || userLanguage==Language.auto) {
			userLanguage = getAutoLanguage();
		}

		// 按 profile 配置获取语言
		if (userLanguage==null) {
			userLanguage=Language.parseByCode(configService.getByCode(SystemConfigEnum.SYSTEM_LANGUAGE).getValue());
		}

		// 如果指定开发模式的语言，用开发模式的语言覆盖
		if(!StringUtil.isBlank(devLang)) {
			userLanguage=Language.parseByCode(devLang);
		}

		// 若最终未识别，指定为默认语言
		if(userLanguage==null) {
			userLanguage = Language.defaults;
		}

		session.setAttribute(USER_LANGUAGE,userLanguage);
		return userLanguage;
	}



	@Override
	public String translate(String defaults, String key) {
		return this.translate(getUserLanguage(), defaults, key);
	}

	@Override
	public String translate(String defaults) {
			return translate(defaults, null);
	}

	@Override
	public ExcelWriter exportExcel(Lang sample) {
		return super.exportExcel(sample);
	}

	@Override
	public ExcelWriter exportExcelTemplate() {
		return super.exportExcelTemplate();
	}

	@Override
	public List<ValidateResult> importExcel(InputStream input, int sheetIndex,boolean batch) {
		return super.importExcel(input,sheetIndex,batch);
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}

}
