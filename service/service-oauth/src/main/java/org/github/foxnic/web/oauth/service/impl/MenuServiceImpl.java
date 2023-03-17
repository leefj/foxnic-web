package org.github.foxnic.web.oauth.service.impl;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.Entity;
import com.github.foxnic.dao.entity.FieldsBuilder;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.relation.cache.CacheInvalidEventType;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.starter.BootArgs;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.In;
import com.github.foxnic.sql.expr.SQLTpl;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.parameter.BatchParamBuilder;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_MENU;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.constants.enums.system.MenuType;
import org.github.foxnic.web.constants.enums.system.YesNo;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.Resourze;
import org.github.foxnic.web.domain.oauth.meta.MenuMeta;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.framework.module.AuthorityMenuManager;
import org.github.foxnic.web.framework.module.ICachedMenuService;
import org.github.foxnic.web.language.LanguageService;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.oauth.service.IMenuResourceService;
import org.github.foxnic.web.oauth.service.IMenuService;
import org.github.foxnic.web.oauth.service.IResourzeService;
import org.github.foxnic.web.proxy.utils.SystemConfigProxyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.*;

/**
 * <p>
 * 菜单表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-01 09:27:29
 * @version
*/


@Service("SysMenuService")
public class MenuServiceImpl extends SuperService<Menu> implements IMenuService, ICachedMenuService {


	@Autowired
	private AuthorityMenuManager authorityMenuManager = null;
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
	private IMenuResourceService menuResourceService;

	private Map<String,Menu>  catchedMenus= new HashMap<>();

	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	@Autowired
	private LanguageService languageService;

	@Autowired
	private IResourzeService resourzeService;


	private void clearMenuCache() {
		catchedMenus.clear();
	}

	/**
	 * 插入实体
	 * @param menu 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Menu menu) {
		if(StringUtil.isBlank(menu.getAuthority())) {
			menu.setAuthority(IDGenerator.getSUID(true));
		}
		Result result=super.insert(menu);
		if(result.success()) {
			clearMenuCache();
			fillHierarchy(false);
		}
		return result;
	}

	/**
	 * 批量插入实体，事务内
	 * @param menuList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Menu> menuList) {
		Result result=super.insertList(menuList);
		fillHierarchy(false);
		clearMenuCache();
		return result;

	}


	/**
	 * 按主键删除 菜单
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Menu menu = new Menu();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		menu.setId(id);
		boolean suc = dao.deleteEntity(menu);
		if(suc) {
			clearMenuCache();
		}
		return ErrorDesc.create(suc);
	}

	/**
	 * 按主键删除 菜单
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {

		Menu menu=this.getById(id);
		if(menu==null) {
			return ErrorDesc.success();
		}

		int z=dao().execute("delete from "+table()+" where "+SYS_MENU.AUTHORITY.name()+" = ? and deleted=1",menu.getAuthority());

		menu = new Menu();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		menu.setId(id);
		menu.setDeleted(true);
		menu.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		menu.setDeleteTime(new Date());
		boolean suc = dao.updateEntity(menu,SaveMode.NOT_NULL_FIELDS);
		if(suc) {
			clearMenuCache();
		}
		return ErrorDesc.create(suc);
	}

	/**
	 * 更新实体
	 * @param menu 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	@Transactional
	public Result update(Menu menu , SaveMode mode) {

		Menu menuInDB=this.getById(menu.getId());

		if(authorityMenuManager.isModuleAuthKey(menuInDB.getAuthority())) {
			return ErrorDesc.failure().message("当前节点不允许修改权限Key").messageLevel4Confirm();
		}

		if(!IMenuService.ROOT_ID.equals(menuInDB.getParentId())) {
			if(MenuType.subsys.equals(menu.getTypeEnum())) {
				return ErrorDesc.failure().message("当前节点不允许设置为"+MenuType.subsys.name()).messageLevel4Confirm();
			}
		}

		Result r=super.update(menu , mode);
		if(r.success()) {
			menuResourceService.saveResourceIds(menu);
			clearMenuCache();
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param menuList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Menu> menuList , SaveMode mode) {
		Result result= super.updateList(menuList , mode);
		if(result.success()) {
			clearMenuCache();
		}
		return result;
	}

	@Override
	public <T> Map<T, ReferCause> hasRefers(List<T> ids) {
		 return super.hasRefers(FoxnicWeb.SYS_ROLE_MENU.MENU_ID,ids,FoxnicWeb.SYS_ROLE.$NAME);
	}


	/**
	 * 按主键更新字段 菜单
	 *
	 * @param id ID
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		if(suc>0) {
			clearMenuCache();
		}
		return suc>0;
	}


	/**
	 * 按主键获取 菜单
	 *
	 * @param id ID
	 * @return Menu 数据对象
	 */
	public Menu getById(String id) {
		Menu sample = new Menu();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		Menu menu = dao.queryEntity(sample);
		dao.join(menu,Resourze.class);
//		dao.join(menu, MenuMeta.RESOURCES);
		return menu;
	}


	@Override
	public List<Menu> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Menu> queryList(Menu sample) {
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
	public PagedList<Menu> queryPagedList(Menu sample, int pageSize, int pageIndex) {
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
	public PagedList<Menu> queryPagedList(Menu sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param menu 数据对象
	 * @return 判断结果
	 */
	public Result<Menu> checkExists(Menu menu) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(role, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	private RcdSet queryChildMenus(String parentId,String roleId) {
		RcdSet menus=null;
		if(parentId==null || parentId.equals(IMenuService.ROOT_ID)) {
			menus=dao.query("#query-root-menus",roleId);
		} else {
			menus=dao.query("#query-menus-by-parent-id",roleId,parentId);
		}
		return menus;
	}

	@Override
	public List<ZTreeNode> queryRootNotes(String roleId) {
		RcdSet menus=queryChildMenus(IMenuService.ROOT_ID,roleId);
		List<ZTreeNode> nodes = toZTreeNodeList(menus);
		return nodes;
	}

	@Override
	public List<ZTreeNode> queryChildNodes(String parentId,String roleId) {
		RcdSet menus=queryChildMenus(parentId,roleId);
		List<ZTreeNode> nodes = toZTreeNodeList(menus);
		return nodes;
	}

	@Value("${foxnic.config.module-authorities.apply-menu-tree}")
	private Boolean ctrlAuthForMenuTree=null;

	private List<ZTreeNode> toZTreeNodeList(RcdSet menus) {
		List<ZTreeNode> nodes=new ArrayList<ZTreeNode>();
		for (Rcd m : menus) {
			if(ctrlAuthForMenuTree!=null && ctrlAuthForMenuTree==true) {
				Menu menu = this.catchedMenus.get(m.getString(SYS_MENU.ID));
				if (menu!=null && !menu.isInModuleRange()) {
					continue;
				}
			}
			ZTreeNode node=new ZTreeNode();
			node.setId(m.getString(SYS_MENU.ID));
			node.setName(m.getString(SYS_MENU.LABEL));
			node.setParentId(m.getString(SYS_MENU.PARENT_ID));
			node.setHierarchy(m.getString(SYS_MENU.HIERARCHY));
			node.setIsParent(m.getInteger("child_count")>0);
			node.setType(m.getString("type"));
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
		if(parentId==null) parentId=IMenuService.ROOT_ID;
		int sort=0;
		for (String menuId : ids) {
			pb.add(parentId,sort,menuId);
			sort++;
		}

		// 搜集修改前的值
		List<Menu> menusBefore = this.getByIds(ids);
		Map<String,Menu> mapBefore= CollectorUtil.collectMap(menusBefore,(m)->{return m.getId();},(m)->{return m;});

		// 修改
		this.dao().batchExecute("update "+table()+" set parent_id=?,hierarchy=null,sort=? where id=?",pb.getBatchList());
		this.fillHierarchy(false);


		// 搜集修改后的值
		List<Menu> menusAfter = this.getByIds(ids);
		Map<String,Menu> mapAfter= CollectorUtil.collectMap(menusAfter,(m)->{return m.getId();},(m)->{return m;});

		// 触发变更
		for (Map.Entry<String, Menu> entry : mapBefore.entrySet()) {
			Menu entity=mapAfter.get(entry.getKey());
			this.dao().getDataCacheManager().dispatchJoinCacheInvalidEvent(CacheInvalidEventType.UPDATE,this.dao().getDataCacheManager(),table(),entry.getValue(),(Entity) entity);
		}

		return true;
	}

	@Override
	public List<Menu> getRelatedMenus(List<String> resourzeIds) {
		//In语句构建
		In pathResourceIds=new In(SYS_MENU.PATH_RESOURCE_ID,resourzeIds);
		In resourceIds=new In(FoxnicWeb.SYS_MENU_RESOURCE.RESOURCE_ID,resourzeIds);
		//模版渲染
		SQLTpl template=dao().getTemplate("#resource-related-menus")
				.setParameters(1,2)
				.putVar("path_resource_ids",pathResourceIds)
				.putVar("resource_ids",resourceIds);
		//执行
		List<Menu> menus = null ;
		try {
			menus = dao().queryEntities(Menu.class, template);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		clearNoParentMenus();
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

	private void clearNoParentMenus() {
		String[] ids=dao().query("select id from "+table()+" a where not exists(select 1 from "+table()+" b where a.parent_id=b.id) and a.parent_id!=?",IMenuService.ROOT_ID).getValueArray("id",String.class);
		if(ids!=null && ids.length>0) {
			In in = new In("id", ids);
			dao.execute("delete from "+table()+" "+in.toConditionExpr().startWithWhere().getListParameterSQL(),in.getListParameters());
		}
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
		SQLTpl template= dao.getTemplate("#query-descendants-menus");
		template.setParameters(roleId);
		template.putVar("descendants_condition",ce);
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

	private void initCache() {
		if (catchedMenus.isEmpty()) {
			synchronized (catchedMenus) {
				if (catchedMenus.isEmpty()) {
					Logger.info("正在初始化菜单数据...");
					this.fillHierarchy(true);
					FieldsBuilder menuFields = FieldsBuilder.build(this.dao(), FoxnicWeb.SYS_MENU.$TABLE)
							.addAll()
							.removeDBTreatyFields()
							.remove(FoxnicWeb.SYS_MENU.BATCH_ID);
					//
					List<Menu> all = this.queryList(new Menu(), menuFields);
					FieldsBuilder resourzeFields = FieldsBuilder.build(this.dao(), FoxnicWeb.SYS_RESOURZE.$TABLE)
							.add(FoxnicWeb.SYS_RESOURZE.ID).add(FoxnicWeb.SYS_RESOURZE.URL);
					//
					this.dao().fill(all).with(MenuMeta.PATH_RESOURCE).with(MenuMeta.RESOURCES).with(MenuMeta.FORKS).fields(resourzeFields).execute();


//					for (Menu menu : all) {
//						List<String> ids = CollectorUtil.collectList(menu.getResources(), Resourze::getId);
//						menu.setResources(resourzeService.queryCachedResourzes(ids));
//						if(menu.getPathResource()!=null) {
//							menu.setPathResource(resourzeService.queryCachedResourzes(Arrays.asList(menu.getPathResource().getId())).get(0));
//						}
//						// 打标记
//						menu.setInModuleRange(authorityMenuManager.isInModuleRange(menu));
//						menu.setHierarchy(null);
//					}
					if(BootArgs.isBootInIDE()) {
						Logger.info("cancel module authority in develop environment, and include all modules");
					}
					// 并行处理
					all.parallelStream().forEach(menu -> {
						List<String> ids = CollectorUtil.collectList(menu.getResources(), Resourze::getId);
						menu.setResources(resourzeService.queryCachedResourzes(ids));
						if(menu.getPathResource()!=null) {
							menu.setPathResource(resourzeService.queryCachedResourzes(Arrays.asList(menu.getPathResource().getId())).get(0));
						}
						// 打标记
						if(BootArgs.isBootInIDE()) {
							menu.setInModuleRange(true);
						} else {
							menu.setInModuleRange(authorityMenuManager.isInModuleRange(menu));
						}
						menu.setHierarchy(null);
					});


					catchedMenus = CollectorUtil.collectMap(all, Menu::getId, m -> {
						return m;
					});
					Logger.info("菜单数据初始化完毕");
				}
			}
		}
	}

	/**
	 * @param  inRange  null 时返回全部，true 是返回范围内，false 时返回范围外
	 * */
	public List<Menu> queryCachedMenus(Collection<String> menuIds,Boolean inRange) {

		initCache();

		List<Menu> menus=new ArrayList<>(menuIds.size());

		for (String menuId : menuIds) {
//			if(menuId.equals("463397133957988352")) {
//                System.out.println();
//            }
			Menu menu=catchedMenus.get(menuId);
			if(menu!=null) {
				if(inRange==null) {
					menus.add(menu);
				} else if(inRange==true) {
					if(menu.isInModuleRange()) {
						menus.add(menu);
					}
				} else if(inRange==false) {
					if(!menu.isInModuleRange()) {
						menus.add(menu);
					}
				}
			}
		}
		return menus;
	}

}
