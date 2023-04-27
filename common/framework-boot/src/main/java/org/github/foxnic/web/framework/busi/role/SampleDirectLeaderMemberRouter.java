package org.github.foxnic.web.framework.busi.role;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.proxy.hrm.EmployeeServiceProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class SampleDirectLeaderMemberRouter implements BusiRoleMemberRouter {

    @Override
    public List<Employee> getMembers(Context context) {

        String[] empIds = {"586965217661943808", "586965315200483328", "586966688780517376"};
        int i = (int) (Math.round((empIds.length - 1) * Math.random()));
        // 此处根据上下文，按一定的业务逻辑查找
        String empId = empIds[i];
        Result<Employee> result = EmployeeServiceProxy.api().getById(empId);
        // 随机
        return Arrays.asList(result.data());
    }
}
