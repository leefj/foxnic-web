package org.github.foxnic.web.hrm.service.impl;


import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.CollectorUtil;
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
import com.github.foxnic.sql.expr.Expr;
import com.github.foxnic.sql.expr.In;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.parameter.BatchParamBuilder;
import org.github.foxnic.web.constants.db.FoxnicWeb.HRM_ORGANIZATION;
import org.github.foxnic.web.constants.enums.dict.OrgNodeType;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.OrganizationVO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.hrm.service.IOrganizationService;
import org.github.foxnic.web.hrm.service.IPositionService;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * <p>
 * 组织层级表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-13 15:09:51
 * @version
*/


@Service("HrmOrganizationService")
public class OrganizationServiceImpl extends SuperService<Organization> implements IOrganizationService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }


	@Autowired
	private IPositionService positionService;


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 插入实体
	 * @param organization 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Organization organization) {

		if(StringUtil.isBlank(organization.getParentId())) {
			organization.setParentId(IOrganizationService.ROOT_ID);
		}
		if(StringUtil.isBlank(organization.getType())) {
			organization.setType(OrgNodeType.DEPT.code());
		}
		organization.setCompanyId(SessionUser.getCurrent().getActivatedCompanyId());
		if(StringUtil.isBlank(organization.getFullName())) {
			organization.setFullName("新节点");
		}
		Result r=super.insert(organization);
		this.fillHierarchy(false);
		return r;
	}

	/**
	 * 批量插入实体，事务内
	 * @param organizationList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Organization> organizationList) {
		return super.insertList(organizationList);
	}


	/**
	 * 按主键删除 组织层级
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Organization organization = new Organization();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		organization.setId(id);
		try {
			boolean suc = dao.deleteEntity(organization);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 按主键删除 组织层级
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		Organization organization = new Organization();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		organization.setId(id);
		organization.setDeleted(dao.getDBTreaty().getTrueValue());
		organization.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		organization.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(organization,SaveMode.NOT_NULL_FIELDS);
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
	 * @param organization 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Organization organization , SaveMode mode) {
		if(StringUtil.isBlank(organization.getCode())) {
			organization.setCode(null);
		}
		//如果上级是部门，那么不允许下级勾选公司
		Organization org=this.getById(organization.getId());
		if(org.getParentId()!=null) {
			Organization parent = this.getById(org.getParentId());
			if (OrgNodeType.COM.code().equals(organization.getType()) && (parent != null && OrgNodeType.DEPT.code().equals(parent.getType()))) {
				return ErrorDesc.failure().message("部门下不允许设置公司");
			}
		}
		Result r=super.update(organization , mode);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param organizationList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Organization> organizationList , SaveMode mode) {
		return super.updateList(organizationList , mode);
	}


	/**
	 * 按主键更新字段 组织层级
	 *
	 * @param id ID
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	}


	/**
	 * 按主键获取 组织层级
	 *
	 * @param id ID
	 * @return Organization 数据对象
	 */
	public Organization getById(String id) {
		Organization sample = new Organization();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Organization> getByIds(List<String> ids) {
		return super.queryListByUKeys(ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Organization> queryList(Organization sample) {
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
	public PagedList<Organization> queryPagedList(Organization sample, int pageSize, int pageIndex) {
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
	public PagedList<Organization> queryPagedList(Organization sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param organization 数据对象
	 * @return 判断结果
	 */
	public Result<Organization> checkExists(Organization organization) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(organization, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(Organization sample) {
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

	@Override
	public List<String> search(String keyword) {
		String tenantId= SessionUser.getCurrent().getActivatedTenantId();
		RcdSet rs=dao().query("#search-org-hierarchy","%"+keyword+"%","%"+keyword+"%",tenantId,"%"+keyword+"%","%"+keyword+"%",tenantId,tenantId);
		return rs.getValueList("hierarchy",String.class);
	}

	@Override
	public List<ZTreeNode> queryNodesFlatten(OrganizationVO sample) {

		if (StringUtil.isBlank(sample.getTenantId())) {
			throw new IllegalArgumentException("请指定租户ID");
		}

		List<Organization> orgs=this.queryList(sample);
		Map<String,Organization> orgMap=CollectorUtil.collectMap(orgs,Organization::getId,(org)->{return org;});
		if(orgs.isEmpty()) return new ArrayList<>();
		Set<String> ids=new HashSet<>();
		for (Organization org : orgs) {
			ids.add(org.getId());
			String[] hierarchyArr=org.getHierarchy().split("/");
			for (String id : hierarchyArr) {
				ids.add(id);
			}
		}

		Expr expr=new Expr("select a.*,(select count(1) from hrm_organization b where a.parent_id=b.id and deleted=0) child_count from hrm_organization a where deleted=0 and tenant_id=?",sample.getTenantId());
		In in=new In("id",ids);
		expr.append(in.toConditionExpr().startWithAnd());
		RcdSet rs=dao().query(expr);
		List<ZTreeNode> nodes=toZTreeNodeList(rs);
		List<ZTreeNode> list=new ArrayList<>();
		Map<String,ZTreeNode> nodeMap= CollectorUtil.collectMap(nodes,ZTreeNode::getId,(node)->{return node;});

		//构建路径
		for (ZTreeNode node : nodes) {
			ZTreeNode n=node;
			while (true) {
				node.addNamePath(n.getName());
				n=nodeMap.get(n.getParentId());
				if(n==null) break;
			}
			Collections.reverse(node.getNamePathArray());
			node.setNamePath(StringUtil.join(node.getNamePathArray(),"/"));

			Organization org=orgMap.get(node.getId());
			if(org!=null) {
				node.setData(org);
				list.add(node);
			}
		}
		return list;
	}

	private RcdSet queryChildOrgs(String parentId,String targetType) {
		RcdSet nodes=null;
		String tenantId= SessionUser.getCurrent().getActivatedTenantId();
		String companyId=SessionUser.getCurrent().getActivatedCompanyId();
		if(parentId==null || parentId.equals(IOrganizationService.ROOT_ID)) {
			nodes=dao.query("#query-root-orgs",companyId,tenantId);
		} else {
			nodes=dao.query("#query-orgs-by-parent-id",companyId,tenantId,parentId);
		}
		return nodes;
	}

	@Override
	public List<ZTreeNode> queryRootNotes(String root,String targetType) {
		Organization organization=null;
		if(StringUtil.isBlank(root)) {
			root=IOrganizationService.ROOT_ID;
		} else {
			organization=this.getById(root);
			if(organization==null) {
				organization=this.queryEntity(new ConditionExpr("code=?",root));
				if(organization!=null) {
					root=organization.getId();
				}
			}
			if(StringUtil.isBlank(root)) {
				root=IOrganizationService.ROOT_ID;
			}
		}

		RcdSet orgs = null;
		if (organization != null) {
			orgs = queryChildOrgs(organization.getParentId(), targetType);
			orgs = orgs.filter("id", organization.getId());
		} else {
			orgs = queryChildOrgs(root, targetType);
		}
		List<ZTreeNode> nodes = toZTreeNodeList(orgs);
		return nodes;
	}

	@Override
	public List<ZTreeNode> queryChildNodes(String parentId,String targetType) {
		RcdSet menus= queryChildOrgs(parentId,targetType);
		List<ZTreeNode> nodes = toZTreeNodeList(menus);
		//如果未指定或指定岗位模式时查询岗位信息
		if(StringUtil.isBlank(targetType) || "pos".equals(targetType)) {
			List<ZTreeNode> positionNodes = positionService.queryGroupedPositionNodes(parentId);
			nodes.addAll(positionNodes);
		}
		return nodes;
	}

	private List<ZTreeNode> toZTreeNodeList(RcdSet menus) {
		List<ZTreeNode> nodes=new ArrayList<ZTreeNode>();
		for (Rcd m : menus) {
			ZTreeNode node=new ZTreeNode();
			node.setId(m.getString(HRM_ORGANIZATION.ID));
			String shortName=m.getString(HRM_ORGANIZATION.SHORT_NAME);
			String fullName=m.getString(HRM_ORGANIZATION.FULL_NAME);

			node.setName(fullName);
			if(StringUtil.hasContent(shortName)){
				node.setName(shortName);
			}
			node.setExtra("fullName",fullName);
			node.setExtra("shortName",shortName);
			node.setExtra("originalName",node.getName());
			node.setParentId(m.getString(HRM_ORGANIZATION.PARENT_ID));
			node.setHierarchy(m.getString(HRM_ORGANIZATION.HIERARCHY));
			if(StringUtil.hasContent(node.getHierarchy())) {
				node.setDepth(node.getHierarchy().split("/").length);
			}
			Integer nc=m.getInteger("child_count");
			if(nc==null) nc=0;
			Integer pc=m.getInteger("position_count");
			if(pc==null) pc=0;
			node.setIsParent((nc+pc)>0);
			node.setType(m.getString(HRM_ORGANIZATION.TYPE));
			nodes.add(node);
		}
		return nodes;
	}

	@Override
	public Boolean saveHierarchy(List<String> ids, String parentId) {

		List<String> orgIds=new ArrayList<>();
		List<String> posIds=new ArrayList<>();
		for (String id : ids) {
			String[] tmp=id.split(",");
			if(OrgNodeType.DEPT.code().equals(tmp[1])){
				orgIds.add(tmp[0]);
			} else if(OrgNodeType.COM.code().equals(tmp[1])){
				orgIds.add(tmp[0]);
			} else if("pos".equals(tmp[1])){
				posIds.add(tmp[0]);
			}
		}


		BatchParamBuilder pb=new BatchParamBuilder();
		if(parentId==null) parentId=IOrganizationService.ROOT_ID;
		int sort=0;
		for (String orgId : orgIds) {
			pb.add(parentId,sort,orgId);
			sort++;
		}
		dao.batchExecute("update "+table()+" set parent_id=?,hierarchy=null,sort=? where id=?",pb.getBatchList());
		this.fillHierarchy(false);

		//
		pb=new BatchParamBuilder();
		sort=0;
		for (String posId : posIds) {
			pb.add(parentId,sort,posId);
			sort++;
		}
		dao.batchExecute("update "+positionService.table()+" set org_id=?,sort=? where id=?",pb.getBatchList());

		return true;
	}

	@Override
	public int fillHierarchy(boolean reset) {
		String tenantId=SessionUser.getCurrent().getActivatedTenantId();
		if(reset) {
			dao().execute("#reset-org-hierarchy",tenantId);
		}
		int total=dao().execute("#update-org-hierarchy-step1",IOrganizationService.ROOT_ID,tenantId);
		while (true) {
			int i=dao().execute("#update-org-hierarchy-step2",tenantId);
			total+=i;
			if(i==0) break;
		}
		return total;
	}

	@Override
	public List<ZTreeNode> buildingHierarchicalRelationships(List<ZTreeNode> list,String targetType) {
		if(list.isEmpty()) return  list;
		//构建查询
		ConditionExpr ce=new ConditionExpr();
		ConditionExpr ors=new ConditionExpr();
		for (ZTreeNode node : list) {
			ors.or(HRM_ORGANIZATION.HIERARCHY.name()+" like ?",node.getHierarchy()+"/%");
		}
		ce.and(ors);
		ce.startWithSpace();

		if("com".equals(targetType)) {
			ce.and("type=?",targetType);
		}
		if("dept".equals(targetType)) {
			ce.and("type=?",targetType);
		}

		Template template= dao.getTemplate("#query-descendants-orgs");
		template.put("descendants_condition",ce);
		//查询所有子孙节点
		RcdSet descendantRs=dao().query(template);
		List<ZTreeNode> nodes= toZTreeNodeList(descendantRs);

		Map<String,List<ZTreeNode>> posNodes = null;
		//判断是否需要岗位数据
		if(StringUtil.isBlank(targetType) || "pos".equals(targetType)) {
			posNodes = positionService.queryGroupedPositionNodes();
		}
		//构建层级关系
		nodes.addAll(list);
		Map<String, ZTreeNode> map=new HashMap<>();
		for (ZTreeNode node : nodes) {
			node.setIsParent(false);
			map.put(node.getId(),node);
		}
		ZTreeNode parent=null;
		for (ZTreeNode node : nodes) {

			parent=map.get(node.getParentId());
			if (parent==null){
				continue;
			}
			parent.addChild(node);
			parent.setIsParent(true);
		}
		//追加岗位
		if(posNodes!=null) {
			for (Map.Entry<String, List<ZTreeNode>> e : posNodes.entrySet()) {
				parent = map.get(e.getKey());
				if (parent == null) continue;
				if (e.getValue() != null && !e.getValue().isEmpty()) {
					parent.getChildren().addAll(e.getValue());
					parent.setIsParent(true);
				}
			}
		}

		//构建路径
		for (ZTreeNode node : nodes) {
			ZTreeNode n=node;
			while (true) {
				node.addNamePath(n.getName());
				n=map.get(n.getParentId());
				if(n==null) break;
			}
			Collections.reverse(node.getNamePathArray());
			node.setNamePath(StringUtil.join(node.getNamePathArray(),"/"));
		}



		return list;
	}


}
