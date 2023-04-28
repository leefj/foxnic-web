package org.github.foxnic.web.framework.busi.role;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.framework.busi.role.BusiRoleMemberRouter;
import org.github.foxnic.web.proxy.hrm.EmployeeServiceProxy;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 当前登录人的直属领导
 * */
@Component
public class SessionUserDirectLeader implements BusiRoleMemberRouter {

    @Override
    public List<Employee> getMembers(Context context) {
        List<Employee> employees = new ArrayList<>();

        SessionUser user=SessionUser.getCurrent();
        if(user==null) {
            return employees;
        }
        Result<Employee> empResult = EmployeeServiceProxy.api().getById(user.getActivatedEmployeeId());
        if(empResult.success() && empResult.data()!=null) {
            employees.add(empResult.data().getDirectLeader());
        }
        return employees;
    }
}
