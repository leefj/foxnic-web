package org.github.foxnic.web.framework.busi.role;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.framework.busi.role.BusiRoleMemberRouter;
import org.github.foxnic.web.proxy.hrm.EmployeeServiceProxy;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 流程起草人的直属领导
 * */
@Component
public class DrafterDirectLeader implements BusiRoleMemberRouter {

    @Override
    public List<Employee> getMembers(Context context) {
        List<Employee> employees = new ArrayList<>();
        ProcessInstance processInstance=context.getProcessInstance();
        Result<Employee> empResult = null;
        // 如果起草人身份是员工
        if(processInstance.getDrafterTypeEnum()== UnifiedUserType.employee) {
            empResult= EmployeeServiceProxy.api().getById(processInstance.getDrafterId());
            if(empResult.success() && empResult.data()!=null) {
                employees.add(empResult.data().getDirectLeader());
            }
        }
        // 按审批账户逻辑找到直属领导
        if(employees.isEmpty()) {
            Result<User> userResult= UserServiceProxy.api().getById(processInstance.getDrafterUserId());
            if(userResult.success() && userResult.data()!=null) {
                empResult= EmployeeServiceProxy.api().getById(userResult.data().getActivatedEmployeeId());
                if(empResult.success() && empResult.data()!=null) {
                    employees.add(empResult.data().getDirectLeader());
                }
            }
        }

        return employees;
    }
}
