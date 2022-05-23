package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Position;
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.system.BusiRole;

/**
 * 审批代理人
 */
public class Assignee {

    private String id;
    private String code;
    private String name;
    private String nameWithCode;
    private UnifiedUserType type;

    private String typeName;

    public Assignee(String id, String code, String name, UnifiedUserType type) {
        this.applyProps(id,code,name,type);
    }

    public void applyProps(String id, String code, String name, UnifiedUserType type) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.code = code;
        this.nameWithCode=name;
        if(!StringUtil.isBlank(this.code)) {
            this.nameWithCode+="("+this.code+")";
        }
        this.typeName=this.type.text();
    }

    /**
     * 从系统账户创建审批人
     * @param  user 系统账户
     * */
    public Assignee(User user) {
        this.applyProps(user.getId(), user.getAccount(), user.getRealName(), UnifiedUserType.user);
    }

    /**
     * 从员工创建审批人
     * @param  employee 员工
     * */
    public Assignee(Employee employee) {
        String name = employee.getName();
        this.applyProps(employee.getId(), employee.getBadge(), name, UnifiedUserType.employee);
    }

    /**
     * 从岗位创建审批人
     * @param  position 岗位
     * @return    Appover 审批人
     * */
    public Assignee(Position position) {
        String name=position.getShortName();
        if(StringUtil.isBlank(name)) {
            name = position.getFullName();
        }
        this.applyProps(position.getId(),position.getCode(),name,UnifiedUserType.position);
    }

    /**
     * 从系统角色创建审批人
     * @param  role 系统角色
     * */
    public Assignee(Role role) {
        this.applyProps(role.getId(),role.getCode(),role.getName(),UnifiedUserType.sys_role);
    }

    /**
     * 从业务角色创建审批人
     * @param  role 业务角色
     * @return    Appover 审批人
     * */
    public Assignee(BusiRole role) {
        this.applyProps(role.getId(),role.getCode(),role.getName(),UnifiedUserType.busi_role);
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

    public String getNameWithCode() {
        return nameWithCode;
    }

    public String getTypeName() {
        return typeName;
    }
}
