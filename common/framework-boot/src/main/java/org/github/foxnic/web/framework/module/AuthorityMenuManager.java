package org.github.foxnic.web.framework.module;

import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.spring.SpringUtil;
import com.github.foxnic.sql.expr.Expr;
import com.github.foxnic.sql.expr.In;
import org.github.foxnic.web.domain.oauth.Menu;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.*;

@Component
public class AuthorityMenuManager {

    private Map<String, AuthorityMenu> authorityMenuMap = null;

    /**
     * 判断菜单是否在模块指定的菜单范围内  <br/>
     * 菜单位置包括：首页、菜单管理、角色授权
     * */
    public boolean isInModuleRange(Menu menu) {
        initDataIf();
//        if(menu.getId().equals("463397133957988352")) {
//            System.out.println();
//        }
        for (Map.Entry<String, AuthorityMenu> e : authorityMenuMap.entrySet()) {
//            if(menu.getId().equals("463397133957988352")) {
//                System.out.println();
//            }
            // 当前菜单
            if(     // 自身在范围内
                    e.getKey().equals(menu.getAuthority())
                    // 下级节点在范围内
                    || menu.getHierarchy().startsWith(e.getValue().getHierarchy())
                    // 上级节点在范围内
                    || e.getValue().getHierarchy().startsWith(menu.getHierarchy())
            ) {
                return true;
            }
        }
        return false;
    }

    private  synchronized void initDataIf() {
         if (authorityMenuMap != null) return;
        Set<String> authorities = new HashSet<>();
        List<ModuleAuthority> beans = SpringUtil.getBeans(ModuleAuthority.class);
        for (ModuleAuthority bean : beans) {
            authorities.addAll(Arrays.asList(bean.getAuthorities()));
        }

        String global=SpringUtil.getEnvProperty("foxnic.config.authorities");
        if(StringUtil.hasContent(global)){
            String[] cfgAuth=global.split(",");
            for (String auth : cfgAuth) {
                if(!authorities.contains(auth.trim())) {
                   throw new IllegalArgumentException("foxnic.config.authorities 中设置的 "+auth+" 不存在");
                }
            }
            //按配置重置
            authorities.clear();
            for (String auth : cfgAuth) {
                authorities.add(auth.trim());
            }
        }

        //
        DAO dao = SpringUtil.getBean(DAO.class);
        In in = new In("authority", authorities);
        Expr select = new Expr("select id,authority,hierarchy from sys_menu where deleted=0 ");
        select.append(in.toConditionExpr().startWithAnd());
        List<AuthorityMenu> authorityMenuList = dao.query(select).toEntityList(AuthorityMenu.class);
        authorityMenuMap= CollectorUtil.collectMap(authorityMenuList,AuthorityMenu::getAuthority,e->{return e;});
    }


}
