package com.scientific.tailoring.system.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.scientific.tailoring.domain.system.Menu;
import com.scientific.tailoring.domain.system.MenuNodeModel;
import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.system.service.ILangService;
import com.scientific.tailoring.system.service.IMenuService;


/**
 * <p>
 * 功能菜单表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-18 11:06:17
*/

@Service("SysMenuServiceImpl")
public class MenuServiceImpl extends SuperService<Menu> implements IMenuService {
	
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
	
	@Autowired
	private ILangService langService;
	
	/**
	 * 按主键删除功能菜单
	 *
	 * @param id id , 详情 : id
	 * @return 查询结果 , Menu对象
	 */
	public boolean deleteByIdPhysical(Integer id) {
		Menu menu = new Menu();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		menu.setId(id);
		return dao.deleteEntity(menu);
	}
	
	/**
	 * 按主键删除功能菜单
	 *
	 * @param id id , 详情 : id
	 * @return 查询结果 , Menu对象
	 */
	public boolean deleteByIdLogical(Integer id) {
		Menu menu = new Menu();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		menu.setId(id);
		menu.setDeleted(true);
		return dao.updateEntity(menu,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 按主键获取功能菜单
	 *
	 * @param id id
	 * @return 查询结果 , Menu对象
	 */
	public Menu getById(Integer id) {
		Menu sample = new Menu();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}
 
	@Override
	public List<MenuNodeModel> getMenuTree(Long userId) {
		//查询所有节点
		List<Menu> all=this.queryList(Menu.create());
 
		List<MenuNodeModel> allm=new ArrayList<>();
		List<MenuNodeModel> roots=new ArrayList<>();
		all.forEach(m->{
			MenuNodeModel n=m.toPojo(MenuNodeModel.class);
			n.setHidden(false);
			if(StringUtil.isBlank(n.getUrl())) {
				n.setUrl("javascript:");
			}
			allm.add(n);
			if(m.getParentId()==null) {
				roots.add(n);
			}
			n.setLabel(langService.translate(n.getLabel()));
		});
		//构架树形结构
		Map<Integer,MenuNodeModel> map= allm.stream().collect(Collectors.toMap(MenuNodeModel::getId, m->m));
		for (Entry<Integer,MenuNodeModel> e : map.entrySet()) {
			MenuNodeModel p=map.get(e.getValue().getParentId());
			if(p!=null) {
				p.addSubMenu(e.getValue());
			}
		}
 
		return roots;
	}

}