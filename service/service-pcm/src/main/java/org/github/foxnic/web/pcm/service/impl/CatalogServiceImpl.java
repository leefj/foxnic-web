package org.github.foxnic.web.pcm.service.impl;


import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
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
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.parameter.BatchParamBuilder;
import org.github.foxnic.web.constants.db.FoxnicWeb.*;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.meta.MenuMeta;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.pcm.service.ICatalogService;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * <p>
 * 数据存储表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-28 15:45:05
 * @version  20210829
*/


@Service("PcmCatalogService")
public class CatalogServiceImpl extends SuperService<Catalog> implements ICatalogService {

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
	 * @param catalog 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Catalog catalog) {
		Result r=super.insert(catalog);
		return r;
	}

	/**
	 * 批量插入实体，事务内
	 * @param catalogList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Catalog> catalogList) {
		return super.insertList(catalogList);
	}


	/**
	 * 按主键删除 数据存储
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Catalog catalog = new Catalog();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		catalog.setId(id);
		try {
			boolean suc = dao.deleteEntity(catalog);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 按主键删除 数据存储
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		Catalog catalog = new Catalog();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		catalog.setId(id);
		catalog.setDeleted(dao.getDBTreaty().getTrueValue());
		catalog.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		catalog.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(catalog,SaveMode.NOT_NULL_FIELDS);
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
	 * @param catalog 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Catalog catalog , SaveMode mode) {
		Result r=super.update(catalog , mode);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param catalogList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Catalog> catalogList , SaveMode mode) {
		return super.updateList(catalogList , mode);
	}


	/**
	 * 按主键更新字段 数据存储
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
	 * 按主键获取 数据存储
	 *
	 * @param id 主键
	 * @return Catalog 数据对象
	 */
	public Catalog getById(String id) {
		Catalog sample = new Catalog();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Catalog> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Catalog> queryList(Catalog sample) {
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
	public PagedList<Catalog> queryPagedList(Catalog sample, int pageSize, int pageIndex) {
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
	public PagedList<Catalog> queryPagedList(Catalog sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param catalog 数据对象
	 * @return 判断结果
	 */
	public Result<Catalog> checkExists(Catalog catalog) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(catalog, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(Catalog sample) {
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


	private RcdSet queryChildMenus(String parentId) {
		RcdSet nodes=null;
		if(parentId==null || parentId.equals(ICatalogService.ROOT_ID)) {
			String tenantId= SessionUser.getCurrent().getActivatedTenantId();
			nodes=dao.query("#query-root-catalogs",tenantId);
		} else {
			nodes=dao.query("#query-catalogs-by-parent-id",parentId);
		}
		return nodes;
	}

	@Override
	public List<ZTreeNode> queryRootNotes() {
		RcdSet menus=queryChildMenus(ICatalogService.ROOT_ID);
		List<ZTreeNode> nodes = toZTreeNodeList(menus);
		return nodes;
	}

	@Override
	public List<ZTreeNode> queryChildNodes(String parentId) {
		RcdSet menus=queryChildMenus(parentId);
		List<ZTreeNode> nodes = toZTreeNodeList(menus);
		return nodes;
	}

	private List<ZTreeNode> toZTreeNodeList(RcdSet menus) {
		List<ZTreeNode> nodes=new ArrayList<ZTreeNode>();
		for (Rcd m : menus) {
			ZTreeNode node=new ZTreeNode();
			node.setId(m.getString(PCM_CATALOG.ID));
			node.setName(m.getString(PCM_CATALOG.NAME));
			node.setParentId(m.getString(PCM_CATALOG.PARENT_ID));
			node.setHierarchy(m.getString(PCM_CATALOG.HIERARCHY));
			node.setIsParent(m.getInteger("child_count")>0);
			nodes.add(node);
		}
		return nodes;
	}

	@Override
	public Boolean saveHierarchy(List<String> ids, String parentId) {
		BatchParamBuilder pb=new BatchParamBuilder();
		if(parentId==null) parentId=ICatalogService.ROOT_ID;
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
	public int fillHierarchy(boolean reset) {
		String tenantId=SessionUser.getCurrent().getActivatedTenantId();
		if(reset) {
			dao().execute("#reset-catalog-hierarchy",tenantId);
		}
		int total=dao().execute("#update-catalog-hierarchy-step1",ICatalogService.ROOT_ID,tenantId);
		while (true) {
			int i=dao().execute("#update-catalog-hierarchy-step2",tenantId);
			total+=i;
			if(i==0) break;
		}
		return total;
	}

	@Override
	public List<ZTreeNode> buildingHierarchicalRelationships(List<ZTreeNode> list) {
		if(list.isEmpty()) return  list;
		//构建查询
		ConditionExpr ce=new ConditionExpr();
		for (ZTreeNode node : list) {
			ce.or(SYS_MENU.HIERARCHY.name()+" like ?",node.getHierarchy()+"/%");
		}
		ce.startWithSpace();
		Template template= dao.getTemplate("#query-descendants-menus");
		template.put("descendants_condition",ce);
		//查询所有子孙节点
		RcdSet descendantRs=dao().query(template);
		List<ZTreeNode> nodes= toZTreeNodeList(descendantRs);
		//构建层级关系
		nodes.addAll(list);
		Map<String, ZTreeNode> map=new HashMap<>();
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

	@Override
	public List<String> search(String keyword) {
		String tenantId=SessionUser.getCurrent().getActivatedTenantId();
		RcdSet rs=dao().query("#search-catalog-hierarchy","%"+keyword+"%",tenantId,tenantId);
		return rs.getValueList("hierarchy",String.class);
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


}