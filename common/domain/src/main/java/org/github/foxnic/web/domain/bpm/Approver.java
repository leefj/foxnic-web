package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Position;
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.system.BusiRole;

/**
 * 审批人对象
 */
public class Approver {

    private String id;
    private String code;
    private String name;
    private UnifiedUserType type;

    public Approver(String id, String code, String name, UnifiedUserType type) {
        this.applyProps(id,code,name,type);
    }

    public void applyProps(String id, String code, String name, UnifiedUserType type) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.code = code;
    }

    /**
     * 从系统账户创建审批人
     * @param  user 系统账户
     * */
    public Approver(User user) {
        this.applyProps(user.getId(), user.getAccount(), user.getRealName() + "(" + user.getAccount() + ")", UnifiedUserType.user);
    }

    /**
     * 从员工创建审批人
     * @param  employee 员工
     * */
    public Approver(Employee employee) {
        String name = employee.getName();
        if (!StringUtil.isBlank(employee.getBadge())) {
            name += "(" + employee.getBadge() + ")";
        }
        this.applyProps(employee.getId(), employee.getBadge(), name, UnifiedUserType.employee);
    }

    /**
     * 从岗位创建审批人
     * @param  position 岗位
     * @return    Appover 审批人
     * */
    public Approver(Position position) {
        String name=position.getShortName();
        if(!StringUtil.isBlank(position.getCode())) {
            name+="("+position.getCode()+")";
        }
        if(StringUtil.isBlank(name)) {
            name = position.getFullName();
        }
        this.applyProps(position.getId(),position.getCode(),name,UnifiedUserType.position);
    }

    /**
     * 从系统角色创建审批人
     * @param  role 系统角色
     * */
    public Approver(Role role) {
        this.applyProps(role.getId(),role.getCode(),role.getName()+"("+role.getCode()+")",UnifiedUserType.sys_role);
    }

    /**
     * 从业务角色创建审批人
     * @param  role 业务角色
     * @return    Appover 审批人
     * */
    public Approver(BusiRole role) {
        this.applyProps(role.getId(),role.getCode(),role.getName()+"("+role.getCode()+")",UnifiedUserType.busi_role);
    }




    public String getId() {
        return id;
    }

    public UnifiedUserType getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }




}
