package org.github.foxnic.web.system.test;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.relation.cache2.CacheMetaManager;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.mvc.RequestParameter;
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


    @PostMapping("/service-system/unit-test/join-menu-4-single-user")
    public Result joinMenu4SingleUser() {

        CacheMetaManager.IDS_FROM_CACHE.set(null);
        String userId=RequestParameter.get().getString("userId");

        User admin=dao.queryEntity(User.create().setId(userId));
        //User user1=dao.queryEntity(User.create().setId("515567129194397696"));

        //
        dao.fill(admin)
                .with(UserMeta.MENUS)
                .with(UserMeta.MENUS, MenuMeta.RESOURCES)
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
        map.put("CACHED_IDS", CacheMetaManager.IDS_FROM_CACHE.get());
        map.put("menus",admin.getMenus());
        return ErrorDesc.success().data(map);
    }

    @PostMapping("/service-system/unit-test/invalid-user-menu")
    public Result invalidUserMenu() {
        //
        String act = RequestParameter.get().getString("act");
        String userId=RequestParameter.get().getString("userId");
        String ids=RequestParameter.get().getString("ids");
        // 更新指定用户信息
        if(act.equals("sys_user:update")) {
            User user=dao.queryEntity(User.create().setId(userId));
            user.setLastLoginTime(new Date());
            dao.updateEntity(user, SaveMode.DIRTY_FIELDS);
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
        //
        else if(act.equals("sys_role:update")) {
            String[] idArr=ids.split(",");
            for (String id : idArr) {
                Role role=dao.queryEntityById(Role.class,id);
                role.setUpdateBy(IDGenerator.getRandomDigits(8));
                dao.updateEntity(role,SaveMode.DIRTY_FIELDS);
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

        return ErrorDesc.success();
    }

}
