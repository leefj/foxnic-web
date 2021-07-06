package org.github.foxnic.web.oauth.service.impl;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.dao.sql.expr.Template;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.In;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.parameter.BatchParamBuilder;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_MENU;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.Resourze;
import org.github.foxnic.web.domain.oauth.meta.MenuMeta;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.language.LanguageService;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.oauth.service.IMenuResourceService;
import org.github.foxnic.web.oauth.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 菜单表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-01 09:27:29
*/


@Service("SysMenuService")
public class MenuServiceImpl extends SuperService<Menu> implements IMenuService {



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
	
	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}
	
	@Autowired
	private LanguageService languageService;
	
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
		return super.insert(menu);
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param menuList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Menu> menuList) {
		return super.insertList(menuList);
	}
	
	
	/**
	 * 按主键删除 菜单
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public boolean deleteByIdPhysical(String id) {
		Menu menu = new Menu();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		menu.setId(id);
		return dao.deleteEntity(menu);
	}
	
	/**
	 * 按主键删除 菜单
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public boolean deleteByIdLogical(String id) {

		Menu menu=this.getById(id);
		if(menu==null) {
			return true;
		}

		int z=dao().execute("delete from "+table()+" where "+SYS_MENU.AUTHORITY.name()+" = ? and deleted=1",menu.getAuthority());

		menu = new Menu();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		menu.setId(id);
		menu.setDeleted(dao.getDBTreaty().getTrueValue());
		menu.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		menu.setDeleteTime(new Date());
		return dao.updateEntity(menu,SaveMode.NOT_NULL_FIELDS);
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
		Result r=super.update(menu , mode);
		if(r.success()) {
			menuResourceService.saveResourceIds(menu);
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
		return super.updateList(menuList , mode);
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
	
	private RcdSet queryChildMenus(String parentId) {
		RcdSet menus=null;
		if(parentId==null) {
			menus=dao.query("select m.*,(select count(1) from sys_menu cm  where m.id=cm.parent_id and cm.deleted=0) child_count from sys_menu m where (m.parent_id is null or m.parent_id='') and m.deleted=0 order by sort asc");
		} else {
			menus=dao.query("select m.*,(select count(1) from sys_menu cm  where m.id=cm.parent_id and cm.deleted=0) child_count from sys_menu m where m.parent_id=? and m.deleted=0 order by sort asc",parentId);
		}
		return menus;
	}

	@Override
	public List<ZTreeNode> queryRootNotes() {
		
		RcdSet menus=queryChildMenus(null);
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
			node.setId(m.getString(SYS_MENU.ID));
			node.setName(m.getString(SYS_MENU.LABEL));
			node.setParentId(m.getString(SYS_MENU.PARENT_ID));
			node.setIsParent(m.getInteger("child_count")>0);
			nodes.add(node);
		}
		return nodes;
	}

	@Override
	public Boolean saveHierarchy(List<String> ids, String parentId) {	
		BatchParamBuilder pb=new BatchParamBuilder();
		int sort=0;
		for (String menuId : ids) {
			pb.add(parentId,sort,menuId);
			sort++;
		}
		dao.batchExecute("update "+table()+" set parent_id=?,sort=? where id=?",pb.getBatchList());
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