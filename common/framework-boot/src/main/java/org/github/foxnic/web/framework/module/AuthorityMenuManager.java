package org.github.foxnic.web.framework.module;

import com.github.foxnic.commons.code.CodeBuilder;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.spring.SpringUtil;
import com.github.foxnic.springboot.starter.BootArgs;
import com.github.foxnic.sql.expr.Expr;
import com.github.foxnic.sql.expr.In;
import org.github.foxnic.web.domain.oauth.Menu;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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
//        if(menu.getId().equals("489922965769551872")) {
//            System.out.println();
//        }
        for (Map.Entry<String, AuthorityMenu> e : authorityMenuMap.entrySet()) {
//            if(menu.getId().equals("489922965769551872")) {
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

    private Set<String> allAuthorities = new HashSet<>();

    public boolean isModuleAuthKey(String key) {
        return allAuthorities.contains(key);
    }

    @PostConstruct
    private  synchronized void initDataIf() {
        if (authorityMenuMap != null) return;
        Set<String> mavenAuthorities = new HashSet<>();
        List<ModuleAuthority> beans = SpringUtil.getBeans(ModuleAuthority.class);
        for (ModuleAuthority bean : beans) {
            mavenAuthorities.addAll(Arrays.asList(bean.getAuthorities()));
        }
        allAuthorities.addAll(mavenAuthorities);

        CodeBuilder moduleAuthInfo=new CodeBuilder();
        moduleAuthInfo.ln("maven module authorities : "+StringUtil.join(mavenAuthorities));

        String configedAuthorities=SpringUtil.getEnvProperty("foxnic.config.module-authorities.auth-keys");
        moduleAuthInfo.ln("configed module authorities : "+configedAuthorities);
        if(StringUtil.hasContent(configedAuthorities)){
            String[] cfgAuth=configedAuthorities.split(",");
            allAuthorities.addAll(Arrays.asList(cfgAuth));
            for (String auth : cfgAuth) {
                if(!mavenAuthorities.contains(auth.trim())) {
                   throw new IllegalArgumentException("foxnic.config.module-authorities.auth-keys 中设置的 "+auth+" 不存在");
                }
            }
            //按配置重置
            mavenAuthorities.clear();
            for (String auth : cfgAuth) {
                mavenAuthorities.add(auth.trim());
            }
        }
        moduleAuthInfo.ln("applied module authorities : "+StringUtil.join(mavenAuthorities));

        Logger.info("\n"+moduleAuthInfo.toString());

        if(mavenAuthorities.isEmpty()) return;

        //
        DAO dao = SpringUtil.getBean(DAO.class);
        In in = new In("authority", mavenAuthorities);
        Expr select = new Expr("select id,authority,hierarchy from sys_menu where deleted=0 ");
        select.append(in.toConditionExpr().startWithAnd());
        List<AuthorityMenu> authorityMenuList = dao.query(select).toEntityList(AuthorityMenu.class);
        authorityMenuMap= CollectorUtil.collectMap(authorityMenuList,AuthorityMenu::getAuthority,e->{return e;});
    }


}
