package org.github.foxnic.web.framework.busi.role;

import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.ReflectUtil;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.domain.hrm.Employee;

import java.util.List;
import java.util.Map;

/**
 * 业务角色动态返回成员
 * */
public interface BusiRoleMemberRouter {

   public static BusiRoleMemberRouter getByClassName(String name) {
      if(StringUtil.isBlank(name)) return null;
      Class<? extends BusiRoleMemberRouter> type= ReflectUtil.forName(name);
      BusiRoleMemberRouter router= SpringUtil.getBean(type);
      return router;
   }

   List<Employee> getMembers(Map<String,Object> context);
}
