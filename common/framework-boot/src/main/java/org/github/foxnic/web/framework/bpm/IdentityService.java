package org.github.foxnic.web.framework.bpm;

import com.github.foxnic.springboot.spring.SpringUtil;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.Expr;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.bpm.Assignee;

import java.util.ArrayList;
import java.util.List;

public abstract class IdentityService {

    protected static List<IdentityService> services = new ArrayList<>();

    public static Expr getQueryConditionExprAll(String masterTableAlias, String masterField, String name) {
        Expr expr=new Expr("(");
        ConditionExpr conditionExpr=new ConditionExpr();
        for (IdentityService service : services) {
            conditionExpr.or(service.getQueryConditionExpr(masterTableAlias,masterField,name));
        }
        conditionExpr.startWithSpace();
        expr.append(conditionExpr);
        expr.append(")");
        return expr;
    }

    public  abstract List<Assignee> getAppoversByUserId(String userId);
    /**
     * 按用户类型获得不同的实现
     * */
    public static IdentityService getImpl(UnifiedUserType type) {
        IdentityService service= (IdentityService)SpringUtil.getBean("IdentityService-"+type.code());
        return service;
    }


    public  abstract List<Assignee> getAppoversById(List<String> ids);

    /**
     * 获得用于查询的条件表达式
     * */
    public abstract ConditionExpr getQueryConditionExpr(String masterTableAlias, String masterField, String name);


}
