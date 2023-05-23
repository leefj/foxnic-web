package org.github.foxnic.web.system.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.cache.Cached;
import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.ReflectUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.meta.DBColumnMeta;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.In;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.enums.DictEnum;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.constants.enums.system.SystemConfigType;
import org.github.foxnic.web.constants.enums.system.YesNo;
import org.github.foxnic.web.domain.system.Config;
import org.github.foxnic.web.domain.system.ConfigVO;
import org.github.foxnic.web.domain.system.Profile;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.utils.DictProxyUtil;
import org.github.foxnic.web.system.service.IConfigService;
import org.github.foxnic.web.system.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * <p>
 * 系统配置表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-03 09:07:26
 * @version
*/


@Service("SysConfigService")
public class ConfigServiceImpl extends SuperService<Config> implements IConfigService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;

	@Autowired
	private IProfileService profileService;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }

	private List<String> appliedProfileIds;

	@Value("${foxnic.config.profiles:}")
	public void setAppliedProfileIds(String value) {
		appliedProfileIds = new ArrayList<>();
		appliedProfileIds.add(IConfigService.DEFAULT_PROFILE_ID);
		if(StringUtil.isBlank(value)) {
			return;
		}
 		String[] t=value.split(",");
		for (String s : t) {
			if(StringUtil.isBlank(s)) continue;
			s=s.trim();
			if(appliedProfileIds.contains(s)) continue;
			appliedProfileIds.add(s);
		}
		Collections.reverse(appliedProfileIds);
	}

	public List<String> getAppliedProfileIds() {
		return appliedProfileIds;
	}

	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param config  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(Config config,boolean throwsException) {
		Result r=super.insert(config,throwsException);
		return r.data(config);
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param config 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Config config) {
		return this.insert(config,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param configList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Config> configList) {
		return super.insertList(configList);
	}


	/**
	 * 按主键删除 系统配置
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Config config = new Config();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		config.setId(id);
		try {
			boolean suc = dao.deleteEntity(config);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 按主键删除 系统配置
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		Config config = new Config();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		int count=this.dao().queryInteger("select count(1) from "+table()+" where parent_id=? and deleted=0",id);
		if(count>0) {
			return ErrorDesc.failure().message("不允许删除当前节点，请先删除下级配置项。");
		}
		config.setId(id);
		config.setDeleted(true);
		config.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		config.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(config,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 更新，如果执行错误，则抛出异常
	 * @param config 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Config config , SaveMode mode) {
		return this.update(config,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param config 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Config config , SaveMode mode,boolean throwsException) {

		if(config instanceof ConfigVO) {
			ConfigVO vo=(ConfigVO) config;
			if("rename".equals(vo.getSearchField())) {
				return super.update(config , mode , throwsException);
			}
		}

		// 可编辑性校验
		Config configDB=this.getById(config.getId());
		if(configDB.getCode().equals(IConfigService.TOP_CODE)) {
			return ErrorDesc.failure().message("保存失败，当前节点不与许编辑。").messageLevel4Confirm().code(CommonError.PARAM_INVALID);
		}

		// code 规则校验
		if(!config.getCode().equals(configDB.getCode())) {
			int count = this.dao().queryInteger("select count(1) from " + table() + " where parent_id=? and deleted=0", config.getId());
			if (count > 0) {
				return ErrorDesc.failure().message("保存失败，不允许修改配置键，如要修改请先删除下级配置项。").messageLevel4Confirm();
			}
		}

		Config parent=this.getById(configDB.getParentId());

		if(!IConfigService.TOP_CODE.equals(parent.getCode()) && !config.getCode().startsWith(parent.getCode())) {
			return ErrorDesc.failure().message("保存失败，配置键格式错误，需要以上级节点配置键开头。").messageLevel4Confirm();
		}
		String localKey=config.getCode();
		if(!IConfigService.TOP_CODE.equals(parent.getCode())) {
			localKey=config.getCode().substring(parent.getCode().length());
		}
		localKey=StringUtil.removeFirst(localKey,".");
		localKey=localKey.trim();
		if(localKey.equals(IConfigService.TOP_CODE)) {
			return ErrorDesc.failure().message("保存失败，不允许使用 "+localKey+" 作为配置键").messageLevel4Confirm();
		}
		if(StringUtil.isBlank(localKey)) {
			return ErrorDesc.failure().message("保存失败，配置键不完整。").messageLevel4Confirm();
		}
		if(localKey.contains(".")) {
			return ErrorDesc.failure().message("保存失败，配置键 "+localKey+" 格式错误，不允许包含点号。").messageLevel4Confirm();
		}
		if(localKey.contains(".") || localKey.contains("\t") || localKey.contains(" ")) {
			return ErrorDesc.failure().message("保存失败，配置键 "+localKey+" 格式错误，不允许包含特殊符号。").messageLevel4Confirm();
		}
		String first=localKey.substring(0,1);
		if(DataParser.parseInteger(first)!=null) {
			return ErrorDesc.failure().message("保存失败，配置键 "+localKey+" 格式错误，不允许以数字开头。").messageLevel4Confirm();
		}

		SystemConfigType type=SystemConfigType.parseByCode(config.getType());

		// 设置默认值
		if(StringUtil.isBlank(config.getTypeDesc())) {
			if (type==SystemConfigType.ENUM) {
				config.setTypeDesc(YesNo.class.getName());
			}
			if (type==SystemConfigType.DICT) {
				config.setTypeDesc(DictEnum.SEX.code());
			}
		}

		if(!StringUtil.isBlank(config.getTypeDesc())) {
			if(type==SystemConfigType.ENUM) {
				Class typeDesc = ReflectUtil.forName(config.getTypeDesc());
				if (typeDesc == null) {
					return ErrorDesc.failure().message("保存失败，类型描述错误，类型未定义。").messageLevel4Confirm();
				}
				if (!ReflectUtil.isSubType(CodeTextEnum.class, typeDesc)) {
					return ErrorDesc.failure().message("保存失败，类型描述错误，当前类型不是 CodeTextEnum 类型。").messageLevel4Confirm();
				}
			} else if(type==SystemConfigType.DICT) {
				List list=DictProxyUtil.getList(config.getTypeDesc());
				if(list==null || list.isEmpty()) {
					return ErrorDesc.failure().message("保存失败，字典代码 " +config.getTypeDesc()+" 不存在。").messageLevel4Confirm();
				}
			}

		}
		Result r=super.update(config , mode , throwsException);
		return r.data(config);
	}

	/**
	 * 更新实体集，事务内
	 * @param configList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Config> configList , SaveMode mode) {
		return super.updateList(configList , mode);
	}


	/**
	 * 按主键更新字段 系统配置
	 *
	 * @param id 主键
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	}


	/**
	 * 按主键获取 系统配置
	 *
	 * @param id 主键
	 * @return Config 数据对象
	 */
	public Config getById(String id) {
		Config sample = new Config();
		if(id==null)
			throw new IllegalArgumentException("id 不允许为 null");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Config> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Config getByCode(SystemConfigEnum configEnum) {
		return getByCode(configEnum.code());
	}

	@Override
	@Cached("by-code")
	public Config getByCode(String code) {
		if(StringUtil.isBlank(code)) return null;
		Config sample=new Config();
		sample.setCode(code);
		sample.setValid(1);
		Config cata = null;
		for (String appliedProfileId : appliedProfileIds) {
			// if(IConfigService.DEFAULT_PROFILE_ID.equals(appliedProfileId)) continue;
			sample.setProfileId(appliedProfileId);
			cata=this.queryEntity(sample);
			if(cata!=null && cata.getValue()!=null){
				break;
			}
		}
		//识别未指定 profile 的情况
		if(cata==null || cata.getValue()==null) {
			sample.setProfileId(IConfigService.DEFAULT_PROFILE_ID);
			cata = this.queryEntity(sample);
		}
		return cata;
	}

	@Override
	public List<Config> getByCodes(List<String> codes) {
		List<Config> list = new ArrayList<>();
		for (String code : codes) {
			Config config =  this.getByCode(code);
			if(config!=null) {
				list.add(config);
			}
		}
		return list;
	}


	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Config> queryList(Config sample) {
		return super.queryList(sample);
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
	public PagedList<Config> queryPagedList(Config sample, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, new ConditionExpr("type!=?",SystemConfigType.DIR),pageSize, pageIndex);
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
	public PagedList<Config> queryPagedList(Config sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param config 数据对象
	 * @return 判断结果
	 */
	public Result<Config> checkExists(Config config) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(config, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
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
	public List<ValidateResult> importExcel(InputStream input,int sheetIndex,boolean batch) {
		return super.importExcel(input,sheetIndex,batch);
	}

	@Override
	public void makeDirsIf() {

//		dao().execute("delete from "+table()+" where type=?",SystemConfigType.DIR);
//		dao().execute("update "+table()+" set parent_id=null where parent_id is not null");

		DBColumnMeta parentId=this.dao().getTableColumnMeta(this.table(),"parent_id");
		Rcd exists=this.dao().queryRecord("select * from "+this.table()+" where type=? and deleted=0", SystemConfigType.DIR);
		if(parentId!=null && exists!=null) return;

		Config top=this.queryEntity("code=? and profile_id=?",IConfigService.TOP_CODE,IConfigService.DEFAULT_PROFILE_ID);
		if(top==null) {
			top=new Config();
			top.setParentId(IConfigService.ROOT_ID);
			top.setType(SystemConfigType.DIR.code());
			top.setProfileId(IConfigService.DEFAULT_PROFILE_ID);
			top.setName("Foxnic-Web");
			top.setCode(IConfigService.TOP_CODE);
			this.insert(top);
		}


		List<Config> defaultConfigList=this.queryList("profile_id=?",IConfigService.DEFAULT_PROFILE_ID);
		for (Config config : defaultConfigList) {
			String[] codes=config.getCode().split("\\.");
			String code=null;
			Config parent=null;
			Config node=null;
			for (String part : codes) {
				if(code==null) {
					code = part;
				} else {
					code=code+"."+part;
				}
				node=this.queryEntity("code=? and profile_id=?",code,config.getProfileId());
				if(node==null) {
					node = new Config();
					node.setCode(code);
					node.setProfileId(config.getProfileId());
					node.setName(part);
					node.setType(SystemConfigType.DIR.code());
					if (parent != null) {
						node.setParentId(parent.getId());
					} else {
						node.setParentId(top.getId());
					}
					node.setId(this.generateId(null).toString());
					dao.insertEntity(node);
				} else {
					if(parent!=null) {
						node.setParentId(parent.getId());
						dao().updateEntity(node,SaveMode.DIRTY_FIELDS);
					}
				}
				parent=node;
			}
		}

		//
		List<Config> otherConfigList=this.queryList("profile_id!=?",IConfigService.DEFAULT_PROFILE_ID);
		for (Config config : otherConfigList) {
			if(config.getCode().equals("system.title")) {
				System.out.println();
			}
			String[] codes = config.getCode().split("\\.");
			String code = null;
			Config parent = null;
			Config node = null;
			for (String part : codes) {
				if (code == null) {
					code = part;
				} else {
					code = code + "." + part;
				}
//				if("system".equals(code)) {
//					System.out.println();
//				}
				if(config.getCode().equals(code)) {
					node = this.queryEntity("code=? and profile_id=?", code, config.getProfileId());
				} else {
					node = this.queryEntity("code=? and profile_id=?", code, IConfigService.DEFAULT_PROFILE_ID);
					if(node==null) {
						node = this.queryEntity("code=? and profile_id=?", code, config.getProfileId());
					}
				}

				if(node==null) {
					node = new Config();
					node.setCode(code);
					node.setProfileId(config.getProfileId());
					node.setName(part);
					node.setType(SystemConfigType.DIR.code());
					if (parent != null) {
						node.setParentId(parent.getId());
					} else {
						node.setParentId(top.getId());
					}
					node.setId(this.generateId(null).toString());
					dao.insertEntity(node);
				} else {
					if(parent!=null) {
						node.setParentId(parent.getId());
						dao().updateEntity(node,SaveMode.DIRTY_FIELDS);
					}
				}
				parent=node;
			}
		}

	}



	private List<Rcd> queryChildConfigs(String profileId,String parentId) {
		RcdSet configs=null;
		if(parentId==null || parentId.equals(IConfigService.ROOT_ID)) {
			configs=dao.query("#query-root-configs",parentId,IConfigService.DEFAULT_PROFILE_ID,profileId);
			return configs.getRcdList();
		} else {
			configs=dao.query("#query-configs-by-parent-id",parentId,IConfigService.DEFAULT_PROFILE_ID,profileId);
			if(!profileId.equals(IConfigService.DEFAULT_PROFILE_ID)) {
				List<Rcd> list =new ArrayList<>();
				Map<String,List<Rcd>> grouped = configs.getGroupedMap("code",String.class);
				for (Rcd r : configs) {
					if(SystemConfigType.DIR.code().equals(r.getString("type"))) {
						list.add(r);
					} else {
						List<Rcd> rs=grouped.get(r.getString("code"));
						if(rs.size()==1) {
							list.add(r);
						} else {
							for (Rcd dr : rs) {
								if(dr.getString("id").equals(r.getString("id"))) {
									if(r.getString("profile_id").equals(profileId)) {
										list.add(r);
									}
								}
							}
						}
					}
				}
				return list;
			} else {
				return configs.getRcdList();
			}

		}

	}

	@Override
	public List<ZTreeNode> queryRootNotes(String profileId) {
		List<Rcd> menus=queryChildConfigs(profileId,IConfigService.ROOT_ID);
		List<ZTreeNode> roots = toZTreeNodeList(menus);
		for (ZTreeNode root : roots) {
			if(root.getHierarchy().equals(IConfigService.TOP_CODE)) {
				Profile profile = profileService.getById(profileId);
				root.setName(root.getName()+"@"+profile.getName());
			}
			root.setOpen(true);
			List<ZTreeNode> children=this.queryChildNodes(profileId,root.getId());
			for (ZTreeNode child : children) {
				root.addChild(child);
			}
		}

		return roots;
	}

	@Override
	public List<ZTreeNode> queryChildNodes(String profileId,String parentId) {
		List<Rcd> menus=queryChildConfigs(profileId,parentId);
		List<ZTreeNode> nodes = toZTreeNodeList(menus);
		return nodes;
	}


	private List<ZTreeNode> toZTreeNodeList(List<Rcd> configs) {
		List<ZTreeNode> nodes=new ArrayList<ZTreeNode>();
		for (Rcd m : configs) {
			ZTreeNode node=new ZTreeNode();
			node.setId(m.getString(FoxnicWeb.SYS_CONFIG.ID));
			node.setName(m.getString(FoxnicWeb.SYS_CONFIG.NAME));
			node.setParentId(m.getString(FoxnicWeb.SYS_CONFIG.PARENT_ID));
			node.setHierarchy(m.getString(FoxnicWeb.SYS_CONFIG.CODE));
			node.setIsParent(m.getInteger("child_count")>0);
			node.setType(m.getString("type"));
			node.setData(m.toJSONObject("profile_id"));
			nodes.add(node);

		}
		return nodes;
	}

	@Override
	public List<String> search(String profileId, String keyword) {
		RcdSet rs=dao().query("#search-catalog-hierarchy","%"+keyword+"%",profileId,profileId,profileId,profileId);
		List<String> parentCodes=rs.getValueList("code",String.class);
		List<String> parentIds=rs.getValueList("id",String.class);
		List<String> allParentCodes=new ArrayList<>();
		for (String code : parentCodes) {
			String[] parts=code.split("\\.");
			String pcode=null;
			for (int i = 0; i < parts.length-2; i++) {
				if(pcode==null) pcode=parts[i];
				else pcode=pcode+"."+parts[i];
				//
				if(!allParentCodes.contains(pcode)) {
					allParentCodes.add(pcode);
				}
			}
		}

		if(!allParentCodes.isEmpty()) {
			ConditionExpr conditionExpr = new ConditionExpr("deleted=0");
			In in = new In("code", allParentCodes);
			conditionExpr.andIf(in);
			conditionExpr.and("profile_id in(?,?)", IConfigService.DEFAULT_PROFILE_ID, profileId);
			List<String> pIds = dao().query("select distinct id from " + table() + " " + conditionExpr.startWithWhere().getListParameterSQL(), conditionExpr.getListParameters()).getValueList("id", String.class);
			parentIds.addAll(pIds);
		}
		return parentIds;
	}

	@Override
	public List<Config> queryDescendants(String code) {
		List<Config> parents = this.queryList(new ConditionExpr("code=?",code));
		Set<String> codes=new HashSet<>();
		for (Config parent : parents) {
			List<Rcd> children= this.queryChildConfigs(parent.getProfileId(),parent.getId());
			for (Rcd config : children) {
				codes.add(config.getString("code"));
			}
		}
		List<Config> configs=new ArrayList<>();
		for (String c : codes) {
			configs.add(this.getByCode(c));
		}
		return configs;


	}


	/**
	 * 批量检查引用
	 * @param ids  检查这些ID是否又被外部表引用
	 * */
	@Override
	public <T> Map<T, ReferCause> hasRefers(List<T> ids) {
		// 默认无业务逻辑，返回此行；有业务逻辑需要校验时，请修改并使用已注释的行代码！！！
		return MapUtil.asMap(ids,new ReferCause(false));
		// return super.hasRefers(FoxnicWeb.BPM_PROCESS_INSTANCE.FORM_DEFINITION_ID,ids);
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}
