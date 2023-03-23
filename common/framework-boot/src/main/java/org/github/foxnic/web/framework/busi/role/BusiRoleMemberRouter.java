package org.github.foxnic.web.framework.busi.role;

import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.ReflectUtil;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.domain.bpm.FormDefinition;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionNodeAssignee;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import org.github.foxnic.web.domain.bpm.Task;
import org.github.foxnic.web.domain.hrm.Employee;

import java.util.List;

/**
 * 业务角色动态返回成员
 * */
public interface BusiRoleMemberRouter {

   public static class Context {

      /**
       * 流程实例
       * */
      private ProcessInstance processInstance;
      /**
       * 审批任务
       * */
      private Task processTask;
      /**
       * 业务单据ID
       * */
      private List<String> billIds;
      /**
       * 表单定义
       * */
      private FormDefinition formDefinition;
      /**
       * 在模型中配置的当前节点的所有审批人
       * */
      List<ProcessDefinitionNodeAssignee> taskAssignees;
      /**
       * 当前审批人
       * */
      private ProcessDefinitionNodeAssignee currentAssignee;
      public ProcessInstance getProcessInstance() {
         return processInstance;
      }

      public void setProcessInstance(ProcessInstance processInstance) {
         this.processInstance = processInstance;
      }

      public Task getProcessTask() {
         return processTask;
      }

      public void setProcessTask(Task processTask) {
         this.processTask = processTask;
      }

      public List<String> getBillIds() {
         return billIds;
      }

      public void setBillIds(List<String> billIds) {
         this.billIds = billIds;
      }

      public FormDefinition getFormDefinition() {
         return formDefinition;
      }

      public void setFormDefinition(FormDefinition formDefinition) {
         this.formDefinition = formDefinition;
      }

      public List<ProcessDefinitionNodeAssignee> getTaskAssignees() {
         return taskAssignees;
      }

      public void setTaskAssignees(List<ProcessDefinitionNodeAssignee> taskAssignees) {
         this.taskAssignees = taskAssignees;
      }

      public ProcessDefinitionNodeAssignee getCurrentAssignee() {
         return currentAssignee;
      }

      public void setCurrentAssignee(ProcessDefinitionNodeAssignee currentAssignee) {
         this.currentAssignee = currentAssignee;
      }


   }

   public static BusiRoleMemberRouter getByClassName(String name) {
      if(StringUtil.isBlank(name)) return null;
      Class<? extends BusiRoleMemberRouter> type= ReflectUtil.forName(name);
      BusiRoleMemberRouter router= SpringUtil.getBean(type);
      return router;
   }

   List<Employee> getMembers(Context context);
}
