package org.github.foxnic.web.system.test;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.ReflectUtil;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.Entity;
import com.github.foxnic.dao.entity.ISimpleIdService;
import com.github.foxnic.dao.relation.cache.PropertyCacheManager;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.mvc.RequestParameter;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.domain.oauth.*;
import org.github.foxnic.web.domain.oauth.meta.MenuMeta;
import org.github.foxnic.web.domain.oauth.meta.UserMeta;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController("JoinCacheTestController")
public class JoinCacheTestController {

    /**
     * 注入DAO对象
     * */
    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;

    ISimpleIdService<Role,String> roleService=null;
    ISimpleIdService<User,String> userService=null;
    ISimpleIdService<RoleUser,String> roleUserService=null;
    ISimpleIdService<Menu,String> menuService=null;

    private void initServiceIf() {
        if(roleService==null) {
            roleService = this.getService("org.github.foxnic.web.oauth.service.IRoleService");
        }
        if(userService==null) {
            userService = this.getService("org.github.foxnic.web.oauth.service.IUserService");
        }
        if(roleUserService==null) {
            roleUserService = this.getService("org.github.foxnic.web.oauth.service.IRoleUserService");
        }
        if(menuService==null) {
            menuService = this.getService("org.github.foxnic.web.oauth.service.IMenuService");
        }
    }

    private User getUserById(String id) {
        User user=new User();
        user.setId(id);
        return dao.queryEntity(user);
    }

    @PostMapping("/service-system/unit-test/join-menu-4-single-user")
    public Result joinMenu4SingleUser() {

        this.initServiceIf();

        PropertyCacheManager.IDS_FROM_CACHE.clear();
        String userId=RequestParameter.get().getString("userId");


//        User user=dao.queryEntity(User.create().setId(userId));
        User user=getUserById(userId);
        //User user1=dao.queryEntity(User.create().setId("515567129194397696"));
        if(user==null) return ErrorDesc.failure();
        //
        dao.fill(user).tag("login")
//                .with(UserMeta.ROLES)
                .with(UserMeta.ROLES,UserMeta.MENUS, MenuMeta.RESOURCES)
                .execute();

//        //
//        dao.fill(user1).with(UserMeta.MENUS)
//                .execute();
//
//        //
//        List<User> users=dao.queryEntities(User.class,"select * from sys_user where name like ?","%e%");
//        dao.fill(users).with(UserMeta.MENUS)
//                .execute();

        Map<String,Object> map=new HashMap<>();
        map.put("CACHED_IDS", PropertyCacheManager.IDS_FROM_CACHE);
        if(user.getRoles()!=null) {
            map.put("#roles", user.getRoles().size());
        }
        if(user.getMenus()!=null) {
            map.put("#menus", user.getMenus().size());
            int resourceSize=0;
            for (Menu menu : user.getMenus()) {
                if(menu.getResources()!=null) {
                    resourceSize+=menu.getResources().size();
                }
            }
            map.put("#resources", resourceSize);
        }
        return ErrorDesc.success().data(map);
    }




    @PostMapping("/service-system/unit-test/invalid-user-menu")
    public Result invalidUserMenu() {

        this.initServiceIf();

        //
        String act = RequestParameter.get().getString("act");
        String userId=RequestParameter.get().getString("userId");
        String ids=RequestParameter.get().getString("ids");
        if(act.equals("reset")) {
            PropertyCacheManager.instance().reset();
        }
        // 更新指定用户信息
       else if(act.equals("sys_user:insert")) {
            User user=userService.getById("477842557343105024");
            user.setId(null);
            user.setPhone(IDGenerator.getSUID(false));
            user.setAccount("JC-"+IDGenerator.getSnowflakeIdString());
            user.setLastLoginTime(new Date());
            user.setCreateBy("$JC-TEST$");
            userService.insert(user);
        }
        else if(act.equals("sys_user:update")) {
            User user=dao.queryEntity(User.create().setId(userId));
            user.setLastLoginTime(new Date());
            dao.updateEntity(user, SaveMode.DIRTY_FIELDS);
        }
        else if(act.equals("sys_user:delete:logical")) {
            // 如果为指定账户
            if(StringUtil.isBlank(userId)) {
                User user=dao.queryEntity(User.create().setCreateBy("$JC-TEST$"));
                if(user!=null) {
                    userService.deleteByIdLogical(user.getId());
                }
            }
            // 如果指定账户
            else {
                userService.deleteByIdLogical(userId);
            }


        }
        else if(act.equals("sys_user:delete:physical")) {
            User user=null;
            if(StringUtil.isBlank(userId)) {
                user=dao.queryEntity(User.create().setCreateBy("$JC-TEST$"));
            } else {
                user=userService.getById(userId);
            }
            if(user!=null) {
                userService.deleteByIdPhysical(user.getId());
            }
        }
        else if(act.equals("sys_user:reset:physical")) {
            // 目前仅限 admin
            User user=dao.queryEntity(User.class,"select * from sys_user where id=?","110588348101165911");
            if(user==null) {
                dao.execute("insert into sys_user (id, name, passwd, phone, portrait_id, language, valid, cache_key, last_login_time, create_by, create_time, update_by, update_time, deleted, delete_by, delete_time, version) VALUES ('110588348101165911', 'admin', '{bcrypt}$2a$10$.k23oAcH5.YzdwAj6OIxZuMPrvWRsOAX.tOgeRTqwaW0OIAiN2Zni', '15365254842', '465814972102868992', 'zh_ch', 1, '443c1', '2022-01-26 22:05:17', '', '2021-06-09 16:52:05', null, '2022-01-26 19:46:48', 0, '', null, 139)");
            }
        }
        else if(act.equals("sys_user:reset:logical")) {
            dao.execute("update sys_user set deleted=0 where id=?",userId);
        }
        //
        else if(act.equals("sys_role_user:update")) {
            String[] idArr=ids.split(",");
            for (String id : idArr) {
                RoleUser roleUser=dao.queryEntityById(RoleUser.class,id);
                roleUser.setUpdateBy(IDGenerator.getRandomDigits(8));
                dao.updateEntity(roleUser,SaveMode.DIRTY_FIELDS);
            }
        }
        else if(act.equals("sys_role_user:insert")) {
            // 清除无关的测试用角色授权关系
            int z=dao.execute("delete from sys_role_user where create_by=?","$JC$");
            User user=userService.getById(userId);
            RcdSet rs=dao.query("select id from sys_role where id not in (select role_id from sys_role_user where user_id=?)",user.getId());
            String roleId=rs.getRcd(0).getString("id");
            // 随便取一个改改
            RoleUser roleUser=roleUserService.getById("533986028713672704");
            roleUser.setId(null).setUserId(user.getId()).setRoleId(roleId).setCreateBy("$JC$");
            roleUserService.insert(roleUser);
            return ErrorDesc.success().data(roleUser);
        }
        else if(act.equals("sys_role_user:reset:logical")) {
            String id=RequestParameter.get().getString("id");
            dao.execute("update sys_role_user set deleted=0 where id=?",id);
        }
        else if(act.equals("sys_role_user:delete:logical")) {
            String id=RequestParameter.get().getString("id");
            roleUserService.deleteByIdLogical(id);
        }
        else if(act.equals("sys_role_user:delete:physical")) {
            String id=RequestParameter.get().getString("id");
            roleUserService.deleteByIdPhysical(id);
        }
        else if(act.equals("sys_role_user:reset:physical")) {
            // 限定超级管理员角色的授权
            RoleUser roleUser=dao.queryEntity(RoleUser.class,"select * from sys_role_user where id=?","477840690055741440");
            if(roleUser==null) {
                dao.execute("insert into sys_role_user (id, role_id, user_id, create_by, create_time, update_by, update_time, deleted, delete_by, delete_time, version) VALUES ('477840690055741440', '110352963290923110', '110588348101165911', '110588348101165911', '2021-08-11 14:08:18', '32339451', '2022-01-28 10:11:27', 0, null, null, 96)");
            }
        }

        //
        else if(act.equals("sys_role:update")) {
            String[] idArr=ids.split(",");
            for (String id : idArr) {
                Role role=dao.queryEntityById(Role.class,id);
                role.setUpdateBy(IDGenerator.getRandomDigits(8));
                dao.updateEntity(role,SaveMode.DIRTY_FIELDS);
            }
        }
        else if(act.equals("sys_role:insert")) {
            Role role=roleService.getById("471287790022164480");
            role.setId(null);
            role.setCode(IDGenerator.getSnowflakeIdString());
            role.setName("缓存测试-"+System.currentTimeMillis());
            role.setCreateBy("$JC-TEST$");
            roleService.insert(role);
            return ErrorDesc.success().data(role);
        }
        else if(act.equals("sys_role:delete:physical")) {
            String id=RequestParameter.get().getString("id");
            roleService.deleteByIdPhysical(id);
        }
        else if(act.equals("sys_role:delete:logical")) {
            String id=RequestParameter.get().getString("id");
            roleService.deleteByIdLogical(id);
        }
        else if(act.equals("sys_role:reset:logical")) {
            String id=RequestParameter.get().getString("id");
            Menu menu=dao.queryEntity(Menu.class,"select * from sys_role where id=?",id);
            dao.execute("update sys_role set deleted=0 where id=?",menu.getId());
        }  else if(act.equals("sys_role:reset:physical")) {
            // 限定超级管理员角色的菜单
            Menu menu=dao.queryEntity(Menu.class,"select * from sys_role where id=?","110352963290923110");
            if(menu==null) {
                dao.execute("INSERT INTO `sys_role` (`id`, `code`, `name`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`) VALUES ('110352963290923110', 'super_admin', '超级管理员', '', NULL, '18144621', '2022-02-08 09:03:48', 0, '', NULL, 122)");
            }

        }



        //
        else if(act.equals("sys_role_menu:update")) {
            String[] idArr=ids.split(",");
            for (String id : idArr) {
                RoleMenu roleMenu=dao.queryEntityById(RoleMenu.class,id);
                roleMenu.setUpdateBy(IDGenerator.getRandomDigits(8));
                dao.updateEntity(roleMenu,SaveMode.DIRTY_FIELDS);
            }
        }

        //
        else if(act.equals("sys_menu:update")) {
            String[] idArr=ids.split(",");
            for (String id : idArr) {
                Menu menu=dao.queryEntityById(Menu.class,id);
                menu.setUpdateBy(IDGenerator.getRandomDigits(8));
                dao.updateEntity(menu,SaveMode.DIRTY_FIELDS);
            }
        }
        else if(act.equals("sys_menu:insert")) {
            Menu menu=menuService.getById("538796787289292800");
            menu.setId(null);
            menu.setLabel("缓存测试-临时");
            menu.setAuthority(IDGenerator.getSUID(false));
            menu.setCreateBy("$JC-TEST$");
            menuService.insert(menu);
            return ErrorDesc.success().data(menu);
        }
        else if(act.equals("sys_menu:delete:physical")) {
            String id=RequestParameter.get().getString("id");
            menuService.deleteByIdPhysical(id);
        }
        else if(act.equals("sys_menu:delete:logical")) {
            String id=RequestParameter.get().getString("id");
            menuService.deleteByIdLogical(id);
        }
        else if(act.equals("sys_menu:reset:logical")) {
            String id=RequestParameter.get().getString("id");
            Menu menu=dao.queryEntity(Menu.class,"select * from sys_menu where id=?",id);
            dao.execute("update sys_menu set deleted=0 where id=?",menu.getId());
        }  else if(act.equals("sys_menu:reset:physical")) {
            // 限定超级管理员角色的菜单
            Menu menu=dao.queryEntity(Menu.class,"select * from sys_menu where id=?","481749751037952000");
            if(menu==null) {
                dao.execute("insert into sys_menu (id, batch_id, authority, hidden, css, label, type, path_resource_id, url, params, parent_id, dynamic_handler, hierarchy, sort, create_by, create_time, update_by, update_time, deleted, delete_by, delete_time, version) VALUES ('481749751037952000', '481749735057653760', 'sys_code_example_car:delete', 0, null, '删除', 'function', null, null, null, '481749745337892864', null, '463397133957988352/system_config/481749745337892864/481749751037952000', 1, null, '2021-08-22 09:01:31', null, null, 0, null, null, 1)");
            }

        }


        return ErrorDesc.success();
    }

    private <E extends Entity> ISimpleIdService<E,String> getService(String type) {
        Class clz= ReflectUtil.forName(type);
        return  (ISimpleIdService<E,String>) SpringUtil.getBean(clz);
    }

}
