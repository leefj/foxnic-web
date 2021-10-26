package org.github.foxnic.web.dataperm.service.impl;


import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.dao.sql.expr.Template;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.In;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.parameter.BatchParamBuilder;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.DP_RULE_CONDITION;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_MENU;
import org.github.foxnic.web.dataperm.service.IRuleConditionService;
import org.github.foxnic.web.domain.dataperm.RuleCondition;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.meta.MenuMeta;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * <p>
 * 数据权限规则范围条件表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-26 14:45:05
 * @version
*/


@Service("DpRuleConditionService")
public class RuleConditionServiceImpl extends SuperService<RuleCondition> implements IRuleConditionService {

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
	 * @param ruleCondition 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(RuleCondition ruleCondition) {
		Result r=super.insert(ruleCondition);
		return r;
	}

	/**
	 * 批量插入实体，事务内
	 * @param ruleConditionList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<RuleCondition> ruleConditionList) {
		return super.insertList(ruleConditionList);
	}


	/**
	 * 按主键删除 数据权限规则范围条件
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		RuleCondition ruleCondition = new RuleCondition();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		ruleCondition.setId(id);
		try {
			boolean suc = dao.deleteEntity(ruleCondition);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 按主键删除 数据权限规则范围条件
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		RuleCondition ruleCondition = new RuleCondition();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		ruleCondition.setId(id);
		ruleCondition.setDeleted(dao.getDBTreaty().getTrueValue());
		ruleCondition.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		ruleCondition.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(ruleCondition,SaveMode.NOT_NULL_FIELDS);
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
	 * @param ruleCondition 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(RuleCondition ruleCondition , SaveMode mode) {
		Result r=super.update(ruleCondition , mode);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param ruleConditionList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<RuleCondition> ruleConditionList , SaveMode mode) {
		return super.updateList(ruleConditionList , mode);
	}


	/**
	 * 按主键更新字段 数据权限规则范围条件
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
	 * 按主键获取 数据权限规则范围条件
	 *
	 * @param id 主键
	 * @return RuleCondition 数据对象
	 */
	public RuleCondition getById(String id) {
		RuleCondition sample = new RuleCondition();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<RuleCondition> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<RuleCondition> queryList(RuleCondition sample) {
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
	public PagedList<RuleCondition> queryPagedList(RuleCondition sample, int pageSize, int pageIndex) {
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
	public PagedList<RuleCondition> queryPagedList(RuleCondition sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param ruleCondition 数据对象
	 * @return 判断结果
	 */
	public Result<RuleCondition> checkExists(RuleCondition ruleCondition) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(ruleCondition, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(RuleCondition sample) {
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

	private RcdSet queryChildMenus(String parentId,String roleId) {
		RcdSet menus=null;
		if(parentId==null || parentId.equals(IRuleConditionService.ROOT_ID)) {
			menus=dao.query("#query-root-menus",roleId);
		} else {
			menus=dao.query("#query-menus-by-parent-id",roleId,parentId);
		}
		return menus;
	}

	@Override
	public List<ZTreeNode> queryRootNotes(String rangeId) {
		RcdSet menus=queryChildMenus(IRuleConditionService.ROOT_ID, rangeId);
		List<ZTreeNode> nodes = toZTreeNodeList(menus);
		return nodes;
	}

	@Override
	public List<ZTreeNode> queryChildNodes(String parentId,String rangeId) {
		RcdSet menus=queryChildMenus(parentId, rangeId);
		List<ZTreeNode> nodes = toZTreeNodeList(menus);
		return nodes;
	}

	private List<ZTreeNode> toZTreeNodeList(RcdSet menus) {
		List<ZTreeNode> nodes=new ArrayList<ZTreeNode>();
		for (Rcd m : menus) {
			ZTreeNode node=new ZTreeNode();
			node.setId(m.getString(DP_RULE_CONDITION.ID));
//			node.setName(m.getString(DP_RULE_CONDITION.LABEL));
			node.setParentId(m.getString(DP_RULE_CONDITION.PARENT_ID));
			node.setHierarchy(m.getString(DP_RULE_CONDITION.HIERARCHY));
			node.setIsParent(m.getInteger("child_count")>0);
			if(m.getValue("checked")!=null) {
				node.setChecked(true);
			}
			nodes.add(node);
		}
		return nodes;
	}

	@Override
	public Boolean saveHierarchy(List<String> ids, String parentId) {
		BatchParamBuilder pb=new BatchParamBuilder();
		if(parentId==null) parentId=IRuleConditionService.ROOT_ID;
		int sort=0;
		for (String menuId : ids) {
			pb.add(parentId,sort,menuId);
			sort++;
		}
		dao.batchExecute("update "+table()+" set parent_id=?,hierarchy=null,sort=? where id=?",pb.getBatchList());
		this.fillHierarchy(false);
		return true;
	}

	@Override
	public List<Menu> getRelatedMenus(List<String> resourzeIds) {
		//In语句构建
		In pathResourceIds=new In(SYS_MENU.PATH_RESOURCE_ID,resourzeIds);
		In resourceIds=new In(FoxnicWeb.SYS_MENU_RESOURCE.RESOURCE_ID,resourzeIds);
		//模版渲染
		Template template=dao().getTemplate("#resource-related-menus",1,2)
				.put("path_resource_ids",pathResourceIds)
				.put("resource_ids",resourceIds).build();
		//执行
		List<Menu> menus=dao().queryEntities(Menu.class,template);
		//关联所有上级菜单
		joinAncestors(menus);
		for (Menu menu : menus) {
			List<String> path=new ArrayList<>();
			Menu p=menu;
			while (true) {
				path.add(p.getLabel());
				p=p.getParent();
				if(p==null) break;
			}
			Collections.reverse(path);
			menu.setAncestorsNamePath(StringUtil.join(path,"/"));
		}
		return menus;
	}

	@Override
	public int fillHierarchy(boolean reset) {
		if(reset) {
			dao().execute("#reset-menu-hierarchy");
		}
		int total=dao().execute("#update-menu-hierarchy-step1");
		while (true) {
			int i=dao().execute("#update-menu-hierarchy-step2");
			total+=i;
			if(i==0) break;
		}
		return total;
	}

	@Override
	public List<ZTreeNode> buildingHierarchicalRelationships(List<ZTreeNode> list,String roleId) {
		if(list.isEmpty()) return  list;
		//构建查询
		ConditionExpr ce=new ConditionExpr();
		for (ZTreeNode node : list) {
			ce.or(SYS_MENU.HIERARCHY.name()+" like ?",node.getHierarchy()+"/%");
		}
		ce.startWithSpace();
		Template template= dao.getTemplate("#query-descendants-menus",roleId);
		template.put("descendants_condition",ce);
		//查询所有子孙节点
		RcdSet descendantRs=dao().query(template);
		List<ZTreeNode> nodes= toZTreeNodeList(descendantRs);
		//构建层级关系
		nodes.addAll(list);
		Map<String,ZTreeNode> map=new HashMap<>();
		for (ZTreeNode node : nodes) {
			map.put(node.getId(),node);
		}
		ZTreeNode parent=null;
		for (ZTreeNode node : nodes) {
			parent=map.get(node.getParentId());
			if (parent==null) continue;
			parent.addChild(node);
		}


		return list;
	}

	private void joinAncestors(List<Menu> menus) {
		List<Menu> parents=new ArrayList<>();
		dao().join(menus, MenuMeta.PARENT);
		for (Menu menu : menus) {
			if(menu.getParent()!=null) {
				parents.add(menu.getParent());
			}
		}
		if(!parents.isEmpty()) {
			joinAncestors(parents);
		}
	}

	@Override
	public List<String> search(String keyword) {
		RcdSet rs=dao().query("#search-catalog-hierarchy","%"+keyword+"%");
		return rs.getValueList("hierarchy",String.class);
	}


}