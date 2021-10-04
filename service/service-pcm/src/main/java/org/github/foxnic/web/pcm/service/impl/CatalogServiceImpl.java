package org.github.foxnic.web.pcm.service.impl;


import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.busi.id.SequenceType;
import com.github.foxnic.commons.cache.Variable;
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
import com.github.foxnic.dao.spec.DBSequence;
import com.github.foxnic.dao.sql.expr.Template;
import com.github.foxnic.sql.data.DataNameFormat;
import com.github.foxnic.sql.expr.*;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.parameter.BatchParamBuilder;
import org.github.foxnic.web.constants.db.FoxnicWeb.PCM_CATALOG;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.meta.MenuMeta;
import org.github.foxnic.web.domain.pcm.*;
import org.github.foxnic.web.domain.pcm.meta.CatalogAllocationMeta;
import org.github.foxnic.web.domain.pcm.meta.CatalogAttributeMeta;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.pcm.service.ICatalogAllocationService;
import org.github.foxnic.web.pcm.service.ICatalogAttributeService;
import org.github.foxnic.web.pcm.service.ICatalogService;
import org.github.foxnic.web.pcm.storage.model.FieldManager;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private ICatalogAttributeService catalogAttributeService;

	@Autowired
	private ICatalogAllocationService catalogAllocationService;


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
		catalog.setValid(1);
		Result r=super.insert(catalog);
		catalog = this.getById(catalog.getId());
		if(StringUtil.isBlank(catalog.getCode())) {
			catalog.setCode(catalog.getId());
			this.updateDirtyFields(catalog);
		}
		if(r.success()) {
			this.fillHierarchy(false);
		}
		return r;
	}

	/**
	 * 批量插入实体，事务内
	 * @param catalogList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Catalog> catalogList) {
		Result r=super.insertList(catalogList);
		if(r.success()) {
			this.fillHierarchy(false);
		}
		return r;
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


	private RcdSet queryChildCatalogs(String parentId) {
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
	public List<ZTreeNode> queryRootNotes(String root) {
		Catalog catalog = null;
		if(StringUtil.isBlank(root)) {
			root=ICatalogService.ROOT_ID;
		} else {
			catalog=this.getById(root);
			if(catalog==null) {
				catalog=this.queryEntity(new ConditionExpr("code=?",root));
				if(catalog!=null) {
					root=catalog.getId();
				}
			}
			if(StringUtil.isBlank(root)) {
				root=ICatalogService.ROOT_ID;
			}
		}
		RcdSet catalogs = null;
		if(catalog!=null) {
			catalogs = queryChildCatalogs(catalog.getParentId());
			catalogs = catalogs.filter("id", catalog.getId());
		} else {
			catalogs = queryChildCatalogs(root);
		}
		List<ZTreeNode> nodes = toZTreeNodeList(catalogs);
		return nodes;
	}

	@Override
	public List<ZTreeNode> queryChildNodes(String parentId) {
		RcdSet menus= queryChildCatalogs(parentId);
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
			if(StringUtil.hasContent(node.getHierarchy())) {
				node.setDepth(node.getHierarchy().split("/").length);
			}
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
			ce.or(PCM_CATALOG.HIERARCHY.name()+" like ?",node.getHierarchy()+"/%");
		}
		ce.startWithSpace();
		Template template= dao.getTemplate("#query-descendants-catalogs");
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
			if (parent==null){
				continue;
			}
			parent.addChild(node);
		}

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

	@Override
	public List<String> search(String keyword) {
		String tenantId=SessionUser.getCurrent().getActivatedTenantId();
		RcdSet rs=dao().query("#search-catalog-hierarchy","%"+keyword+"%",tenantId,tenantId);
		return rs.getValueList("hierarchy",String.class);
	}

	private Variable storageTables=new Variable(null,1000*60*3);

	@Override
	public List<String> getStorageTables() {
		List<String> tables=(List)storageTables.getValue();
		if(tables!=null) return tables;
		tables=new ArrayList<>();
		for (String tableName : dao().getTableNames()) {
			if(tableName.toLowerCase().startsWith("pcm_data_")) {
				int count=dao().queryInteger("select count(1) from "+tableName);
				tables.add(tableName+","+count);
			}
		}
		storageTables.setValue(tables);
		return tables;
	}

	@Override
	public List<String> getVersions(String id) {
		return catalogAttributeService.getAllVersions(id);
	}

	/**
	 * 复制一个生效的版本用于编辑
	 * */
	@Override
	public Result createVersion(String catalogId) {
		//获得激活版本
		List<CatalogAttribute> activatedAttributes=catalogAttributeService.getAttributes(catalogId,ICatalogService.VERSION_ACTIVATED);
		catalogAttributeService.join(activatedAttributes, CatalogAllocation.class);
		//获得编辑版本
		List<CatalogAttribute> editingAttributes=catalogAttributeService.getAttributes(catalogId,ICatalogService.VERSION_EDITING);
		//如果激活版本缺少属性定义
		if(activatedAttributes.isEmpty()) return ErrorDesc.failure().message("当前版本缺少属性");
		if(editingAttributes.size()>0) {
			return ErrorDesc.failure().message("当前编辑版本已经存在属性,请删除后再创建");
		}
		List<CatalogAllocation> allocations=new ArrayList<>();
		for (CatalogAttribute attribute : activatedAttributes) {
			attribute.setVersionNo(ICatalogService.VERSION_EDITING);
			attribute.setSourceId(attribute.getId());
			attribute.setId(null);
			attribute.setCreateBy(null);
			attribute.setCreateTime(null);
			attribute.setUpdateBy(null);
			attribute.setUpdateTime(null);
			attribute.setDeleteBy(null);
			attribute.setDeleteTime(null);
			attribute.setVersion(0);
			//
			editingAttributes.add(attribute);

			//拷贝分配表
			CatalogAllocation allocation=attribute.getAllocation();
			if(allocation!=null) {
				allocation.setVersionNo(ICatalogService.VERSION_EDITING);
				allocation.setId(null);
				allocation.setCreateBy(null);
				allocation.setCreateTime(null);
				allocation.setUpdateBy(null);
				allocation.setUpdateTime(null);
				allocation.setDeleteBy(null);
				allocation.setDeleteTime(null);
				allocation.setVersion(0);
				allocations.add(allocation);
			}
		}
		catalogAttributeService.insertList(editingAttributes);
		catalogAllocationService.insertList(allocations);
		return ErrorDesc.success();
	}

	/**
	 * 把正在编辑的版本应用为生效的版本
	 * */
	@Override
	public synchronized Result applyVersion(String catalogId) {

		DBSequence sequence=dao().getSequence("pcm-catalog-version-no");
		if(!sequence.exists()){
			sequence.create(SequenceType.DAI,3);
		}
		Catalog catalog=this.getById(catalogId);
		if(StringUtil.isBlank(catalog.getDataTable())) {
			return ErrorDesc.failure().message("未指定存储表");
		}

		//获得来自父类目继承的属性
		List<CatalogAttribute> attributes=new ArrayList<>();
		String[] parentCatalogIds=catalog.getHierarchy().split("/");
		for (int i = 0; i < parentCatalogIds.length-1; i++) {
			attributes.addAll(catalogAttributeService.getAttributes(parentCatalogIds[i],ICatalogService.VERSION_ACTIVATED));
		}
		//归集到当前类目下
		for (CatalogAttribute attribute : attributes) {
			attribute.setCatalogId(catalogId);
			attribute.setVersionNo(ICatalogService.VERSION_EDITING);
		}

		//当前类目的属性
		List<CatalogAttribute> editingAttributes=catalogAttributeService.getAttributes(catalogId,ICatalogService.VERSION_EDITING);
		if(editingAttributes.size()==0) {
			return ErrorDesc.failure().message("缺少字段");
		}
		catalogAttributeService.join(editingAttributes, CatalogAttributeMeta.SOURCE_ATTR,CatalogAttributeMeta.ALLOCATION);
		attributes.addAll(editingAttributes);

		//分配存储字段
		FieldManager fieldManager=new FieldManager(this.dao(),catalog,attributes,catalogAttributeService,catalogAllocationService);
 		//校验并分配字段
		Result result=fieldManager.verifyAndAllotAttributes();
		if(result.failure()) {
			return result;
		}

		//变更当前激活的版本为历史版本
		String version=sequence.next();

		try {
			dao.beginTransaction();
			dao().execute("update pcm_catalog_attribute set version_no=?,update_time=? where catalog_id=? and version_no=?",version,new Date(),catalogId,ICatalogService.VERSION_ACTIVATED);
			dao().execute("update pcm_catalog_allocation set version_no=?,update_time=? where catalog_id=? and version_no=?",version,new Date(),catalogId,ICatalogService.VERSION_ACTIVATED);

			//变更当前编辑的版本为激活的版本
			dao().execute("update pcm_catalog_attribute set version_no=?,update_time=? where catalog_id=? and version_no=?",ICatalogService.VERSION_ACTIVATED,new Date(),catalogId,ICatalogService.VERSION_EDITING);
			dao().execute("update pcm_catalog_allocation set version_no=?,update_time=? where catalog_id=? and version_no=?",ICatalogService.VERSION_ACTIVATED,new Date(),catalogId,ICatalogService.VERSION_EDITING);
			dao.commit();
		} catch (Exception e) {
			dao.rollback();
			throw new RuntimeException(e);
		}

		//移除缓存
		this.cache().remove(catalogId);
		this.cache().remove(catalogId+":allocations");

		//
		return ErrorDesc.success().message("版本已生效");
	}

	private Catalog getCachedCatalog(String catalogId) {
		Catalog catalog=(Catalog)this.cache().get(catalogId);
		if(catalog!=null) return catalog;
		//
		catalog=this.getById(catalogId);
		if(catalog==null) return null;
		List<CatalogAttribute> attributes=catalogAttributeService.getAttributes(catalogId,ICatalogService.VERSION_ACTIVATED);
		catalogAttributeService.join(attributes,CatalogAttributeMeta.ALLOCATION);
		catalog.setAttributes(attributes);
		//
		this.cache().put(catalogId,catalog);
		//
		return catalog;
	}

	private List<CatalogAllocation> getCachedAllocations(String catalogId) {
		String key=catalogId+":allocations";
		List<CatalogAllocation> list=(List<CatalogAllocation>)this.cache().get(key);
		list=null;
		if(list!=null) return list;
		list=catalogAllocationService.queryList("catalog_id=? and version_no=?",catalogId,ICatalogService.VERSION_ACTIVATED);
		catalogAllocationService.join(list, CatalogAllocationMeta.ATTRIBUTE);
		this.cache().put(key,list);
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
	public Result queryData(DataQueryVo dataQueryVo) {

		Catalog catalog=this.getCachedCatalog(dataQueryVo.getCatalogId());
		if(catalog==null) {
			return ErrorDesc.failure().message("类目ID ["+dataQueryVo.getCatalogId()+"] 错误");
		}
		if(!catalog.getTenantId().equals(dataQueryVo.getTenantId())){
			return ErrorDesc.failure().message("类目ID ["+dataQueryVo.getCatalogId()+"] 未在指定的租户 ["+dataQueryVo.getTenantId()+"] 定义");
		}
		if(!catalogAttributeService.hasActivatedVersions(catalog.getId())){
			return ErrorDesc.failure().message("类目 ["+catalog.getName()+"] 缺少有效版本");
		}
		//构建查询语句需要的字段
		Select select=new Select(catalog.getDataTable());
		select.selects("id","tenant_id","catalog_id","owner_id")
		.selects("create_time","update_time","version");

		List<CatalogAllocation> allocations=this.getCachedAllocations(catalog.getId());

//		List<CatalogAttribute> attributes=catalog.getAttributes();
		for (CatalogAllocation allocation : allocations) {
			select.select(allocation.getColumnName(),allocation.getAttribute().getField());
		}

		//构建查询条件
		ConditionExpr ce=new ConditionExpr("tenant_id=? and catalog_id=? and deleted=0",dataQueryVo.getTenantId(),dataQueryVo.getCatalogId());
		In in=null;
		if(dataQueryVo.getIds()!=null && !dataQueryVo.getIds().isEmpty()) {
			in=new In("id",dataQueryVo.getIds());
		} else if(dataQueryVo.getOwnerIds()!=null && !dataQueryVo.getOwnerIds().isEmpty()) {
			in=new In("owner_id",dataQueryVo.getOwnerIds());
		}
		if(in!=null){
			select.where().and(ce).and(in);
		}
		//TODO 此处可能存在单次查询数据量过大的问题，晚些处理
		RcdSet rs= dao().query(select);
		rs.setDataNameFormat(DataNameFormat.NONE);
		return ErrorDesc.success().data(rs.toJSONArrayWithJSONObject());
	}

	@Override
	public Result saveDataList(List<CatalogData> catalogDataList) {

		Catalog catalog=null;

		Map<String,Object> data=null;
		List<SQL> sqls=new ArrayList<>();
		int i=0;
		for (CatalogData catalogData : catalogDataList) {
			catalog=this.getCachedCatalog(catalogData.getCatalogId());
			if(catalog==null) {
				return ErrorDesc.failure().message("类目ID ["+catalogData.getCatalogId()+"] 错误");
			}
			if(!catalog.getTenantId().equals(catalogData.getTenantId())){
				return ErrorDesc.failure().message("类目ID ["+catalogData.getCatalogId()+"] 未在指定的租户 ["+catalogData.getTenantId()+"] 定义");
			}
			if(!catalogAttributeService.hasActivatedVersions(catalog.getId())){
				return ErrorDesc.failure().message("类目 ["+catalog.getName()+"] 缺少有效版本");
			}
			List<CatalogAllocation> allocations=this.getCachedAllocations(catalog.getId());

			if(allocations==null || allocations.isEmpty()) {
				return ErrorDesc.failure().message("类目ID ["+catalogData.getCatalogId()+"] 存储未正确分配");
			}

			data=catalogData.getData();
			if(data==null || data.isEmpty()) {
				return ErrorDesc.failure().message((catalogDataList.size()>0?("第"+i+"行,"):"")+"缺少需要保存的data数据");
			}
			Setter setter=null;
			if(StringUtil.isBlank(catalogData.getId())){
				catalogData.setId(IDGenerator.getSnowflakeIdString());
				setter=new Insert(catalog.getDataTable());
				setter.set("id",catalogData.getId());
				setter.set("catalog_id",catalog.getId());
				setter.set("owner_id",catalogData.getOwnerId());
				setter.set("tenant_id",catalogData.getTenantId());
				setter.set("deleted",0);
				setter.set("version",1);
				setter.set("create_time",new Date());
			} else {
				Update update=new Update(catalog.getDataTable());
				update.where("id=?",catalogData.getId());
				update.setExpr("version","version+1");
				update.set("update_time",new Date());
				setter=update;
			}
			sqls.add((SQL)setter);
			for (CatalogAllocation allocation : allocations) {
				setter.set(allocation.getColumnName(),data.get(allocation.getAttribute().getField()));
			}
			i++;
		}
		//保存数据
		try {
			dao().batchExecute(sqls);
			return ErrorDesc.success().message("数据已保存").data(catalogDataList);
		} catch (Exception e) {
			return ErrorDesc.exception(e).message("数据保存失败");
		}
	}

	@Override
	public Result deleteData(DataQueryVo dataQueryVo) {
		if(dataQueryVo.getIds()==null || dataQueryVo.getIds().isEmpty()) {
			return ErrorDesc.failure(CommonError.PARAM_INVALID).message("至少指定一个id值");
		}
		if(dataQueryVo.getTenantId()==null || StringUtil.isBlank(dataQueryVo.getTenantId())) {
			return ErrorDesc.failure(CommonError.PARAM_INVALID).message("请指定租户ID");
		}
		Catalog catalog=this.getCachedCatalog(dataQueryVo.getCatalogId());
		if(catalog==null) {
			return ErrorDesc.failure().message("类目ID ["+dataQueryVo.getCatalogId()+"] 错误");
		}
		if(!catalog.getTenantId().equals(dataQueryVo.getTenantId())){
			return ErrorDesc.failure().message("类目ID ["+dataQueryVo.getCatalogId()+"] 未在指定的租户 ["+dataQueryVo.getTenantId()+"] 定义");
		}
		In in=new In("id",dataQueryVo.getIds());
		Expr expr=new Expr("update "+catalog.getDataTable()+" set deleted=1 , delete_time=? ",new Date());
		expr.append(in.toConditionExpr().startWithWhere());
		this.dao().execute(expr);
		return ErrorDesc.success();
	}

	@Override
	public int getDataCount(String id) {
		Catalog catalog=this.getCachedCatalog(id);
		if(StringUtil.isBlank(catalog.getDataTable())) return 0;
		 int count=dao().queryInteger("select count(1) from "+catalog.getDataTable()+" where catalog_id=? and deleted=0",id);
		 return count;
	}

	@Override
	public List<ZTreeNode> queryNodesFlatten(CatalogVO sample) {

		if (StringUtil.isBlank(sample.getTenantId())) {
			throw new IllegalArgumentException("请指定租户ID");
		}

		List<Catalog> catalogs=this.queryList(sample);
		Map<String,Catalog> orgMap= CollectorUtil.collectMap(catalogs,Catalog::getId,(org)->{return org;});
		if(catalogs.isEmpty()) return new ArrayList<>();
		Set<String> ids=new HashSet<>();
		for (Catalog org : catalogs) {
			ids.add(org.getId());
			String[] hierarchyArr=org.getHierarchy().split("/");
			for (String id : hierarchyArr) {
				ids.add(id);
			}
		}

		Expr expr=new Expr("select a.*,(select count(1) from "+this.table()+" b where a.parent_id=b.id and deleted=0) child_count from "+this.table()+" a where deleted=0 and tenant_id=?",sample.getTenantId());
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

			Catalog org=orgMap.get(node.getId());
			if(org!=null) {
				node.setData(org);
				list.add(node);
			}
		}
		return list;
	}


}