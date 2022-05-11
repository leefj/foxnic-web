package org.github.foxnic.web.framework.change;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.reflect.ReflectUtil;
import com.github.foxnic.dao.entity.ISuperService;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.bpm.Assignee;
import org.github.foxnic.web.domain.changes.ChangeApproveBody;
import org.github.foxnic.web.domain.changes.ChangeEvent;
import org.github.foxnic.web.domain.changes.ChangeRequestBody;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.BusiRole;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChangesAssistant {

    public static final long  EXPIRE_SECONDS=60 * 30;
    public static final String CHANGES_CHANNEL_EVENT_PREFIX = "foxnic:channel:changes:notify:";
    public static final String CHANGES_NOTIFY_PREFIX = "foxnic:changes:event:notify:";

    public static final String CHANGES_CHANNEL_RESPONSE_PREFIX = "foxnic:channel:changes:response:";
    public static final String CHANGES_RESPONSE_PREFIX = "foxnic:changes:event:response:";

    private static final String CHANGES_PROXY_NAME ="org.github.foxnic.web.proxy.changes.ChangeInstanceServiceProxy";


    private static final String EMPLOYEE_PROXY_NAME ="org.github.foxnic.web.proxy.hrm.EmployeeServiceProxy";
    private static final String BUSI_ROLE_PROXY_NAME ="org.github.foxnic.web.proxy.system.BusiRoleServiceProxy";

    private DAO dao;
    private static Object changesProxy;
    private static Method changesRequestMethod =null;
    private static Method changesApproveMethod =null;
    //
    private static Object employeeProxy;
    private static Method employeeGetByIdsMethod =null;
    private static Object busiRoleProxy;
    private static Method busiRoleGetByIdsMethod =null;
    private static Method busiRoleGetByCodesMethod =null;
    private static Method busiRoleGetEmployeeRolesMethod =null;

    /**
     * 从变更主表对用的 Service 创建变更工具
     * */
    public ChangesAssistant(ISuperService service) {
        this.dao=service.dao();

        if(changesProxy ==null) {
            Class changesProxyType = ReflectUtil.forName(CHANGES_PROXY_NAME);
            try {
                Method api = changesProxyType.getDeclaredMethod("api");
                changesProxy = api.invoke(null);
                changesRequestMethod = changesProxy.getClass().getMethod("request", ChangeRequestBody.class);
                changesApproveMethod = changesProxy.getClass().getMethod("approve", ChangeApproveBody.class);
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }

        if(employeeProxy ==null) {
            Class employeeProxyType = ReflectUtil.forName(EMPLOYEE_PROXY_NAME);
            try {
                Method api = employeeProxyType.getDeclaredMethod("api");
                employeeProxy = api.invoke(null);
                employeeGetByIdsMethod = employeeProxy.getClass().getMethod("getByIds", List.class);
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }


        if(busiRoleProxy ==null) {
            Class bpmRoleProxyType = ReflectUtil.forName(BUSI_ROLE_PROXY_NAME);
            try {
                Method api = bpmRoleProxyType.getDeclaredMethod("api");
                busiRoleProxy = api.invoke(null);
                busiRoleGetByIdsMethod = busiRoleProxy.getClass().getMethod("getByIds", List.class);
                busiRoleGetByCodesMethod = busiRoleProxy.getClass().getMethod("getByCodes", List.class);
                busiRoleGetEmployeeRolesMethod = busiRoleProxy.getClass().getMethod("getEmployeeRoles", String.class);
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    /**
     * 启动变更
     * */
    public Result<ChangeEvent> request(ChangeRequestBody request) {
        Result<ChangeEvent>  result = null;
        try {
            result = (Result<ChangeEvent>) changesRequestMethod.invoke(changesProxy,request);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 变更审批
     * */
    public Result<ChangeEvent> approve(ChangeApproveBody approveBody) {
        Result<ChangeEvent>  result = null;
        try {
            result = (Result<ChangeEvent>) changesApproveMethod.invoke(changesProxy,approveBody);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获得审批人
     * */
    public Assignee getEmployeeApproverById(String id) {
        List<Assignee> assignees =this.getEmployeeApproversById(id);
        if(assignees ==null|| assignees.isEmpty()) return null;
        return assignees.get(0);
    }

    /**
     * 获得审批人
     * */
    public List<Assignee> getEmployeeApproversById(String... id) {
        List empIds= Arrays.asList(id);
        try {
            Result<List<Employee>> result= (Result<List<Employee>>)employeeGetByIdsMethod.invoke(employeeProxy,empIds);
            if(result.failure()) return null;
            List<Employee> emps=result.data();
            if(emps==null) return null;
            List<Assignee> assignees =new ArrayList<>();
            for (Employee e : emps) {
                Assignee assignee =new Assignee(e.getId(),e.getBadge(),e.getPerson().getName(), UnifiedUserType.employee);
                assignees.add(assignee);
            }
            return assignees;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过获得审批角色
     * */
    public Assignee getBpmRoleApproverById(String id) {
        List<Assignee> assignees =getEmployeeApproversById(id);
        if(assignees ==null || assignees.isEmpty()) return null;
        return assignees.get(0);
    }

    /**
     * 通过获得审批角色
     * */
    public List<Assignee> getBpmRoleApproversById(String... id) {
        List roleIds= Arrays.asList(id);
        try {
            Result<List<BusiRole>> result= (Result<List<BusiRole>>) busiRoleGetByIdsMethod.invoke(busiRoleProxy,roleIds);
            if(result.failure()) return null;
            List<BusiRole> roles=result.data();
            if(roles==null) return null;
            List<Assignee> assignees =new ArrayList<>();
            for (BusiRole e : roles) {
                Assignee assignee =new Assignee(e.getId(),e.getCode(),e.getName(), UnifiedUserType.busi_role);
                assignees.add(assignee);
            }
            return assignees;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过获得审批角色
     * */
    public Assignee getBpmRoleApproverByCode(String code) {
        List<Assignee> assignees =this.getBpmRoleApproversByCode(code);
        if(assignees ==null || assignees.isEmpty()) return null;
        return assignees.get(0);
    }

    /**
     * 通过获得审批角色
     * */
    public List<Assignee> getBpmRoleApproversByCode(String... code) {
        List roleCodes= Arrays.asList(code);
        try {
            Result<List<BusiRole>> result= (Result<List<BusiRole>>) busiRoleGetByCodesMethod.invoke(busiRoleProxy,roleCodes);
            if(result.failure()) return null;
            List<BusiRole> roles=result.data();
            if(roles==null) return null;
            List<Assignee> assignees =new ArrayList<>();
            for (BusiRole e : roles) {
                Assignee assignee =new Assignee(e.getId(),e.getCode(),e.getName(), UnifiedUserType.busi_role);
                assignees.add(assignee);
            }
            return assignees;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 校验员工是否属于指定的流程角色
     */
    public boolean isEmployeeInBpmRole(String employeeId, List<String> roleIds) {
        try {
            Result<List<BusiRole>> result= (Result<List<BusiRole>>) busiRoleGetEmployeeRolesMethod.invoke(busiRoleProxy,employeeId);
            if(result.failure()) return false;
            List<BusiRole> roles=result.data();
            if(roles==null) return false;
            for (BusiRole e : roles) {
                 if(roleIds.contains(e.getId())) return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
