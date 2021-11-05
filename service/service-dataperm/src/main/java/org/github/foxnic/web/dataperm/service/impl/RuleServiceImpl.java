package org.github.foxnic.web.dataperm.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.github.foxnic.api.dataperm.ConditionNodeType;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanNameUtil;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.concurrent.task.SimpleTaskManager;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.reflect.ReflectUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.dataperm.model.DataPermCondition;
import com.github.foxnic.dao.dataperm.model.DataPermRange;
import com.github.foxnic.dao.dataperm.model.DataPermRule;
import com.github.foxnic.dao.entity.Entity;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.meta.DBColumnMeta;
import com.github.foxnic.dao.meta.DBTableMeta;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.entity.EntityUtil;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.dataperm.service.IRuleRangeService;
import org.github.foxnic.web.dataperm.service.IRuleService;
import org.github.foxnic.web.domain.dataperm.PropertyItem;
import org.github.foxnic.web.domain.dataperm.Rule;
import org.github.foxnic.web.domain.dataperm.RuleCondition;
import org.github.foxnic.web.domain.dataperm.RuleRange;
import org.github.foxnic.web.domain.dataperm.meta.RuleMeta;
import org.github.foxnic.web.domain.dataperm.meta.RuleRangeMeta;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * <p>
 * 数据权限规则表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-25 17:06:04
 * @version
*/


@Service("DpRuleService")
public class RuleServiceImpl extends SuperService<Rule> implements IRuleService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;

	@Autowired
	private IRuleRangeService ruleRangeService;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }

	@PostConstruct
	private void init() {
		SimpleTaskManager.doParallelTask(new Runnable() {
			@Override
			public void run() {
				applyAll();
			}
		});
	}



	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 插入实体
	 * @param rule 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	@Transactional
	public Result insert(Rule rule) {
		rule.setVersionNo(1);
		if(rule.getValid()==1) {
			rule.setValid(0);
		}
		Result r=super.insert(rule);
		if(r.success()) {
			RuleRange range=new RuleRange();
			range.setRuleId(rule.getId());
			range.setValid(1);
			range.setName("默认范围");
			ruleRangeService.insert(range);
		}
		return r;
	}

	/**
	 * 批量插入实体，事务内
	 * @param ruleList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Rule> ruleList) {
		return super.insertList(ruleList);
	}


	/**
	 * 按主键删除 数据权限规则
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Rule rule = new Rule();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		rule.setId(id);
		try {
			boolean suc = dao.deleteEntity(rule);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 按主键删除 数据权限规则
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		Rule rule = new Rule();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		rule.setId(id);
		rule.setDeleted(dao.getDBTreaty().getTrueValue());
		rule.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		rule.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(rule,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 更新实体
	 * @param rule 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Rule rule , SaveMode mode) {
		Result r=super.update(rule , mode);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param ruleList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Rule> ruleList , SaveMode mode) {
		return super.updateList(ruleList , mode);
	}


	/**
	 * 按主键更新字段 数据权限规则
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
	 * 按主键获取 数据权限规则
	 *
	 * @param id 主键
	 * @return Rule 数据对象
	 */
	public Rule getById(String id) {
		Rule sample = new Rule();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Rule> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Rule> queryList(Rule sample) {
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
	public PagedList<Rule> queryPagedList(Rule sample, int pageSize, int pageIndex) {
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
	public PagedList<Rule> queryPagedList(Rule sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param rule 数据对象
	 * @return 判断结果
	 */
	public Result<Rule> checkExists(Rule rule) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(rule, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(Rule sample) {
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
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}

	private LocalCache<String,List<ZTreeNode>> properties =new LocalCache<>();
	private LocalCache<String, Map<String,PropertyItem>> propertiesMap=new LocalCache<>();

	private void initPoPropertiesIf(String poTypName) {

		List<ZTreeNode> roots= properties.get(poTypName);
		roots=null;

		if(roots!=null && !roots.isEmpty()) return;
		roots=new ArrayList<>();
		List<PropertyItem> list=new ArrayList<>();
		Class poType = ReflectUtil.forName(poTypName);
		if (poType == null) return;

		this.collectPoFields(null,poType,list);

		Map<String,ZTreeNode> map=new HashMap<>();
		List<ZTreeNode> nodes=new ArrayList<>();
		for (PropertyItem p : list) {
			ZTreeNode node=new ZTreeNode();
			node.setId(p.getFullProperty());
			String label=p.getLabel();
			if(!label.equals(p.getProperty())) {
				label+="("+p.getProperty()+")";
			}
			if(p.getParent()!=null) {
				node.setParentId(p.getParent().getFullProperty());
			}

			if(ReflectUtil.isSubType(List.class,p.getType())) {
				node.setName(label + ":" + p.getType().getSimpleName()+"<"+ReflectUtil.getListComponentType(p.getField()).getSimpleName()+">");
			} else {
				node.setName(label + ":" + p.getType().getSimpleName());
			}
			map.put(node.getId(),node);
			nodes.add(node);
		}
		ZTreeNode root=new ZTreeNode();
		root.setId(poTypName);
		root.setName(poTypName);
		root.setOpen(true);

		Set<List<ZTreeNode>> childrens=new HashSet<>();
		for (ZTreeNode node : nodes) {
			ZTreeNode parent=map.get(node.getParentId());
			if(parent==null) {
				root.addChild(node);
				childrens.add(root.getChildren());
				continue;
			}
			parent.addChild(node);
			childrens.add(parent.getChildren());
			parent.setIsParent(true);
		}
		roots.add(root);

		for (List<ZTreeNode> children : childrens) {
			children.sort(new Comparator<ZTreeNode>() {
				@Override
				public int compare(ZTreeNode o1, ZTreeNode o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});
		}

		properties.put(poTypName,roots);

		//
		Map<String,PropertyItem> pMap= CollectorUtil.collectMap(list,(item)->{return item.getFullProperty();},(item)->{return item;});
		propertiesMap.put(poTypName,pMap);
	}

	@Override
	public List<ZTreeNode> queryFieldList(String ruleId, String searchValue) {
		List<ZTreeNode> array=new ArrayList<>();
		if(ruleId==null) {
			return array;
		}
		Rule rule=this.getById(ruleId);
		if(rule==null) return null;
		if(StringUtil.isBlank(rule.getPoType())) return null;
		initPoPropertiesIf(rule.getPoType());
		array= properties.get(rule.getPoType());
		return  array;
	}

	@Override
	public PropertyItem getPropertyItem(String ruleId, String fullProperty) {
		Rule rule=this.getById(ruleId);
		if(rule==null) return null;
		this.initPoPropertiesIf(rule.getPoType());
		Map<String,PropertyItem> map=this.propertiesMap.get(rule.getPoType());
		return map.get(fullProperty);
	}

	@Override
	public Result apply(String id) {
		Rule rule=getById(id);
		dao().fill(rule).with(RuleMeta.RANGES, RuleRangeMeta.CONDITIONS).execute();
		return apply(rule);
	}

	public void applyAll() {
		Rule sample=new Rule();
		sample.setValid(1).setDeleted(0);
		List<Rule> rules=this.queryList(sample);
		dao().fill(rules).with(RuleMeta.RANGES, RuleRangeMeta.CONDITIONS).execute();
		int success=0;
		for (Rule rule : rules) {
			Result result=apply(rule);
			if(result.success()) {
				success++;
				Logger.info("注册数据权限:"+rule.getName()+"("+rule.getCode()+") 成功");
			} else {
				Logger.info("注册数据权限:"+rule.getName()+"("+rule.getCode()+") 失败 : "+result.message());
			}

		}
	}

	public Result apply(Rule rule) {

		//校验规则
		if(rule.getRanges()==null || rule.getRanges().isEmpty()) {
			return ErrorDesc.failure().message("范围未定义");
		}

		//转成规则对象
		DataPermRule dataPermRule=new DataPermRule();
		dataPermRule.setId(rule.getId());
		dataPermRule.setCode(rule.getCode());
		dataPermRule.setName(rule.getName());
		dataPermRule.setPoType(rule.getPoType());
		dataPermRule.setApplyTime(new Date());

		for (RuleRange range : rule.getRanges()) {
			if(range.getValid()==0) {
				continue;
			}
			//校验范围配置
			if(range.getConditions()==null || range.getConditions().size()<=1) {
				return ErrorDesc.failure().message(range.getName() + "条件未定义");
			}
			DataPermRange dataPermRange=new DataPermRange();
			dataPermRange.setId(range.getId());
			dataPermRange.setName(range.getName());
			dataPermRule.addRanges(dataPermRange);

			for (RuleCondition condition : range.getConditions()) {
				if(condition.getValid()==0) {
					continue;
				}

				//如果是表达式，校验相关属性是否定义
				if(condition.getTypeEnum()== ConditionNodeType.expr) {
					if (StringUtil.isBlank(condition.getQueryProperty())) {
						return ErrorDesc.failure().message(range.getName() + "下存在查询属性未定义的条目");
					}
					if (condition.getExprTypeEnum() == null) {
						return ErrorDesc.failure().message(range.getName() + "下存在条件类型未定义的条目");
					}
					if (StringUtil.isBlank(condition.getVariables())) {
						return ErrorDesc.failure().message(range.getName() + "下存在变量未定义的条目");
					}
				}
				//
				DataPermCondition dataPermCondition=new DataPermCondition();
				dataPermCondition.setId(condition.getId());
				dataPermCondition.setParentId(condition.getParentId());
				dataPermCondition.setLogicType(condition.getLogicEnum());
				dataPermCondition.setExprType(condition.getExprTypeEnum());
				dataPermCondition.setNodeType(condition.getTypeEnum());
				dataPermCondition.setQueryField(condition.getQueryField());
				dataPermCondition.setQueryProperty(condition.getQueryProperty());
				dataPermCondition.setSort(condition.getSort());
				dataPermCondition.setTitle(condition.getTitle());
				dataPermCondition.setNotes(condition.getNotes());
				dataPermCondition.setConditionExpr(condition.getConditionExpr());
				//如果是表达式，转换变量
				if(condition.getTypeEnum()==ConditionNodeType.expr) {
					if(!StringUtil.isBlank(condition.getVariables())) {
						JSONArray vars = JSONArray.parseArray(condition.getVariables());
						dataPermCondition.setVaribales(vars);
					}
				}
				dataPermRange.addConditions(dataPermCondition);
			}
			//校验条件数量
			if(dataPermRange.getConditions().size()<=1) {
				return ErrorDesc.failure().message(range.getName() + "缺少有效的条件");
			}
		}

		if(dataPermRule.getRanges().isEmpty()) {
			return ErrorDesc.failure().message("缺少有效的范围");
		}

		dao().getDataPermManager().apply(dataPermRule);

		return ErrorDesc.success();
	}

	private void collectPoFields(PropertyItem parent,Class poType,List<PropertyItem> list) {
		String table= EntityUtil.getAnnotationTable(poType);
		if(table==null) return;
		DBTableMeta tm=this.dao().getTableMeta(table);
		if(tm==null) return;
		for (Field field : poType.getDeclaredFields()) {
			if(Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers())) continue;



			//
			PropertyItem item=new PropertyItem();
			item.setParent(parent);
			item.setField(field);
			item.setProperty(field.getName());
			item.setLabel(field.getName());

			if(parent!=null) {
				item.setFullProperty(parent.getFullProperty()+"."+item.getProperty());
			} else {
				item.setFullProperty(item.getProperty());
			}
			item.setType(field.getType());
			item.setQueryTable(table);


			//
			if(DataParser.isSimpleType(field.getType())) {

				//判断是否表字段
				String fieldName=field.getName();
				DBColumnMeta cm=tm.getColumn(fieldName);
				if(cm==null) {
					fieldName= BeanNameUtil.instance().depart(fieldName);
					cm=tm.getColumn(fieldName);
					if(cm==null) {
						continue;
					}
				}

				item.setQueryField(fieldName);
				item.setLabel(cm.getLabel());

				if(parent!=null) {
					if(StringUtil.isBlank(parent.getFullLabel())) {
						item.setFullLabel(parent.getFullProperty() + "." + item.getLabel());
					} else {
						item.setFullLabel(parent.getFullLabel() + "." + item.getLabel());
					}
				} else {
					item.setFullLabel(item.getLabel());
				}

				list.add(item);
			} else if(field.getType().equals(List.class)) {
				Class cmpType= ReflectUtil.getListComponentType(field);
				list.add(item);
				if(ReflectUtil.isSubType(Entity.class,cmpType)) {
					collectPoFields(item, cmpType, list);
				}
			} else if(ReflectUtil.isSubType(Entity.class,field.getType())) {
				list.add(item);
				collectPoFields(item, field.getType(), list);
			} else {
				//其他类型暂不支持
			}
		}

	}


}
