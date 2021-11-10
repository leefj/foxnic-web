package org.github.foxnic.web.framework.change;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.reflect.ReflectUtil;
import com.github.foxnic.dao.entity.ISuperService;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.bpm.Appover;
import org.github.foxnic.web.domain.bpm.Role;
import org.github.foxnic.web.domain.changes.ChangeApproveBody;
import org.github.foxnic.web.domain.changes.ChangeEvent;
import org.github.foxnic.web.domain.changes.ChangeRequestBody;
import org.github.foxnic.web.domain.hrm.Employee;

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
    private static final String BPM_ROLE_PROXY_NAME ="org.github.foxnic.web.proxy.bpm.RoleServiceProxy";

    private DAO dao;
    private static Object changesProxy;
    private static Method changesRequestMethod =null;
    private static Method changesApproveMethod =null;
    //
    private static Object employeeProxy;
    private static Method employeeGetByIdsMethod =null;
    private static Object bpmRoleProxy;
    private static Method bpmRoleGetByIdsMethod =null;
    private static Method bpmRoleGetByCodesMethod =null;
    private static Method bpmRoleGetEmployeeRolesMethod =null;

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


        if(bpmRoleProxy ==null) {
            Class bpmRoleProxyType = ReflectUtil.forName(BPM_ROLE_PROXY_NAME);
            try {
                Method api = bpmRoleProxyType.getDeclaredMethod("api");
                bpmRoleProxy = api.invoke(null);
                bpmRoleGetByIdsMethod = bpmRoleProxy.getClass().getMethod("getByIds", List.class);
                bpmRoleGetByCodesMethod = bpmRoleProxy.getClass().getMethod("getByCodes", List.class);
                bpmRoleGetEmployeeRolesMethod = bpmRoleProxy.getClass().getMethod("getEmployeeRoles", String.class);
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
    public Appover getEmployeeApproverById(String id) {
        List<Appover> appovers=this.getEmployeeApproversById(id);
        if(appovers==null||appovers.isEmpty()) return null;
        return appovers.get(0);
    }

    /**
     * 获得审批人
     * */
    public List<Appover> getEmployeeApproversById(String... id) {
        List empIds= Arrays.asList(id);
        try {
            Result<List<Employee>> result= (Result<List<Employee>>)employeeGetByIdsMethod.invoke(employeeProxy,empIds);
            if(result.failure()) return null;
            List<Employee> emps=result.data();
            if(emps==null) return null;
            List<Appover> appovers=new ArrayList<>();
            for (Employee e : emps) {
                Appover appover=new Appover(e.getId(),e.getBadge(),e.getPerson().getName(), UnifiedUserType.employee);
                appovers.add(appover);
            }
            return appovers;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过获得审批角色
     * */
    public Appover getBpmRoleApproverById(String id) {
        List<Appover> appovers=getEmployeeApproversById(id);
        if(appovers==null || appovers.isEmpty()) return null;
        return appovers.get(0);
    }

    /**
     * 通过获得审批角色
     * */
    public List<Appover> getBpmRoleApproversById(String... id) {
        List roleIds= Arrays.asList(id);
        try {
            Result<List<Role>> result= (Result<List<Role>>)bpmRoleGetByIdsMethod.invoke(bpmRoleProxy,roleIds);
            if(result.failure()) return null;
            List<Role> roles=result.data();
            if(roles==null) return null;
            List<Appover> appovers=new ArrayList<>();
            for (Role e : roles) {
                Appover appover=new Appover(e.getId(),e.getCode(),e.getName(), UnifiedUserType.busi_role);
                appovers.add(appover);
            }
            return appovers;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过获得审批角色
     * */
    public Appover getBpmRoleApproverByCode(String code) {
        List<Appover> appovers=this.getBpmRoleApproversByCode(code);
        if(appovers==null || appovers.isEmpty()) return null;
        return appovers.get(0);
    }

    /**
     * 通过获得审批角色
     * */
    public List<Appover> getBpmRoleApproversByCode(String... code) {
        List roleCodes= Arrays.asList(code);
        try {
            Result<List<Role>> result= (Result<List<Role>>)bpmRoleGetByCodesMethod.invoke(bpmRoleProxy,roleCodes);
            if(result.failure()) return null;
            List<Role> roles=result.data();
            if(roles==null) return null;
            List<Appover> appovers=new ArrayList<>();
            for (Role e : roles) {
                Appover appover=new Appover(e.getId(),e.getCode(),e.getName(), UnifiedUserType.busi_role);
                appovers.add(appover);
            }
            return appovers;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 校验员工是否属于指定的流程角色
     */
    public boolean isEmployeeInBpmRole(String employeeId, List<String> roleIds) {
        try {
            Result<List<Role>> result= (Result<List<Role>>)bpmRoleGetEmployeeRolesMethod.invoke(bpmRoleProxy,employeeId);
            if(result.failure()) return false;
            List<Role> roles=result.data();
            if(roles==null) return false;
            for (Role e : roles) {
                 if(roleIds.contains(e.getId())) return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
