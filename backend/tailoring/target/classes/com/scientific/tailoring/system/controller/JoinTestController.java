package com.scientific.tailoring.system.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.foxnic.commons.environment.RunEnv;
import com.github.foxnic.dao.relation.JoinResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.domain.system.Dict;
import com.scientific.tailoring.domain.system.Menu;
import com.scientific.tailoring.domain.system.Role;
import com.scientific.tailoring.domain.system.User;
import com.scientific.tailoring.system.service.IDictItemService;
import com.scientific.tailoring.system.service.IDictService;
import com.scientific.tailoring.system.service.IMenuService;
import com.scientific.tailoring.system.service.IRoleService;
import com.scientific.tailoring.system.service.IUserService;

@RestController
@RequestMapping("join")
public class JoinTestController {
	@Autowired
	private DAO dao;
	@Autowired
	private IMenuService menuService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IDictService dictService;
	@Autowired
	private IDictItemService dictItemService;
	

	
	@RequestMapping("menu-1")
	public  Result<List<Menu>> menu_1() {
		List<Menu> menus= menuService.queryList(Menu.create());
		
		System.out.println(RunEnv.isRunInIDE(getClass()));
		
//		Map<String,JoinResult<Menu,Menu>> map= dao.join(menus, "allChildren");
//		dao.join(menus, "validChildren");
		dao.join(menus, "parent","ss");
		
		Result<List<Menu>> r=new Result<List<Menu>>();
		r.data(menus);
		return r;
	}
	
	@RequestMapping("menu-2")
	public  Result<List<Menu>> menu_2() {
		List<Menu> menus= menuService.queryList(Menu.create());
		
		dao.join(menus, Menu.class);
		
		Result<List<Menu>> r=new Result<List<Menu>>();
		r.data(menus);
		return r;
	}
	
	@RequestMapping("role-1")
	public  Result<List<Role>>  role_1() {
		List<Role> roles= roleService.queryList(Role.create());
		dao.join(roles, User.class);
		Result<List<Role>> r=new Result<List<Role>>();
		r.data(roles);
		return r;
	}
	
	@RequestMapping("user-1")
	public  Result<List<User>>  user_1() {
		List<User> users= userService.queryList(User.create());
		dao.join(users, Role.class);
		Result<List<User>> r=new Result<List<User>>();
		r.data(users);
		return r;
	}
	
	@RequestMapping("dict-1")
	public  Result<List<Dict>>  dict_1() {
		List<Dict> menus= dictService.queryList(Dict.create());
		Result<List<Dict>> r=new Result<List<Dict>>();
		r.data(menus);
		return r;
	}
	
	
	@RequestMapping("dict-2")
	public  Result<List<Dict>>  dict_2() {
		List<Dict> menus= dictService.queryList(Dict.create());
		Result<List<Dict>> r=new Result<List<Dict>>();
		r.data(menus);
		return r;
	}
	
	

}
