package org.github.foxnic.web.framework.bpm;

import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;

public class BpmDataPermission {

    /**
     * 获得用于判断是否是起草人的SQL语句
     * @param mainTableAlias 主表别名
     * @param drafterField 主表的起草人字段
     * @param drafterEmployeeId 指定的起草人员工ID，通常为当前登录账户对应的员工ID
     * @return 条件表达式
     * */
    public static ConditionExpr getDrafterLimitCondition(String mainTableAlias,DBField drafterField,String drafterEmployeeId) {
        ConditionExpr conditionExpr=new ConditionExpr(mainTableAlias+"."+drafterField.name()+" = ?",drafterEmployeeId);
        conditionExpr.startWithAnd();
        return conditionExpr;
    }

    /**
     * 获得用于判断是否是审批人的SQL语句
     * @param mainTableAlias 主表别名
     * @param drafterField 主表的起草人字段
     * @param approverEmployeeId 指定的起草人员工ID，通常为当前登录账户对应的员工ID
     * @return 条件表达式
     * */
    public static ConditionExpr getApproverLimitCondition(String mainTableAlias,DBField drafterField,String approverEmployeeId) {

//        "exists(sele)";

        ConditionExpr conditionExpr=new ConditionExpr(mainTableAlias+"."+drafterField.name()+" = ?",approverEmployeeId);
        conditionExpr.startWithAnd();
        return conditionExpr;
    }

}
