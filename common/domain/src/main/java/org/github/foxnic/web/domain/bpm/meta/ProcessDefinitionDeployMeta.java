package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionDeploy;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:42:52
 * @sign 6E31EE82A14316072562D8A59BBF540F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessDefinitionDeployMeta {
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionDeploy,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionDeploy.class ,ID, java.lang.String.class, "ID", "ID", java.lang.String.class, null);
	
	/**
	 * 流程定义ID , 类型: java.lang.String
	*/
	public static final String PROCESS_DEFINITION_ID="processDefinitionId";
	
	/**
	 * 流程定义ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionDeploy,java.lang.String> PROCESS_DEFINITION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionDeploy.class ,PROCESS_DEFINITION_ID, java.lang.String.class, "流程定义ID", "流程定义ID", java.lang.String.class, null);
	
	/**
	 * 流程文件ID , 类型: java.lang.String
	*/
	public static final String FILE_ID="fileId";
	
	/**
	 * 流程文件ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionDeploy,java.lang.String> FILE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionDeploy.class ,FILE_ID, java.lang.String.class, "流程文件ID", "流程文件ID", java.lang.String.class, null);
	
	/**
	 * 应用请求报文 , 类型: java.lang.String
	*/
	public static final String REQUEST="request";
	
	/**
	 * 应用请求报文 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionDeploy,java.lang.String> REQUEST_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionDeploy.class ,REQUEST, java.lang.String.class, "应用请求报文", "应用请求报文", java.lang.String.class, null);
	
	/**
	 * 应用结果 , 类型: java.lang.String
	*/
	public static final String RESULT="result";
	
	/**
	 * 应用结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionDeploy,java.lang.String> RESULT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionDeploy.class ,RESULT, java.lang.String.class, "应用结果", "应用结果", java.lang.String.class, null);
	
	/**
	 * 应用时间 , 类型: java.util.Date
	*/
	public static final String APPLY_TIME="applyTime";
	
	/**
	 * 应用时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionDeploy,java.util.Date> APPLY_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionDeploy.class ,APPLY_TIME, java.util.Date.class, "应用时间", "应用时间", java.util.Date.class, null);
	
	/**
	 * 异常信息 , 类型: java.lang.String
	*/
	public static final String EXCEPTION="exception";
	
	/**
	 * 异常信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionDeploy,java.lang.String> EXCEPTION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionDeploy.class ,EXCEPTION, java.lang.String.class, "异常信息", "异常信息", java.lang.String.class, null);
	
	/**
	 * 是否成功 , 类型: java.lang.Integer
	*/
	public static final String SUCCESS="success";
	
	/**
	 * 是否成功 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionDeploy,java.lang.Integer> SUCCESS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionDeploy.class ,SUCCESS, java.lang.Integer.class, "是否成功", "是否成功", java.lang.Integer.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionDeploy,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionDeploy.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PROCESS_DEFINITION_ID , FILE_ID , REQUEST , RESULT , APPLY_TIME , EXCEPTION , SUCCESS , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.ProcessDefinitionDeploy {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public ProcessDefinitionDeploy setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 流程定义ID
		 * @param processDefinitionId 流程定义ID
		 * @return 当前对象
		*/
		public ProcessDefinitionDeploy setProcessDefinitionId(String processDefinitionId) {
			super.change(PROCESS_DEFINITION_ID,super.getProcessDefinitionId(),processDefinitionId);
			super.setProcessDefinitionId(processDefinitionId);
			return this;
		}
		
		/**
		 * 设置 流程文件ID
		 * @param fileId 流程文件ID
		 * @return 当前对象
		*/
		public ProcessDefinitionDeploy setFileId(String fileId) {
			super.change(FILE_ID,super.getFileId(),fileId);
			super.setFileId(fileId);
			return this;
		}
		
		/**
		 * 设置 应用请求报文
		 * @param request 应用请求报文
		 * @return 当前对象
		*/
		public ProcessDefinitionDeploy setRequest(String request) {
			super.change(REQUEST,super.getRequest(),request);
			super.setRequest(request);
			return this;
		}
		
		/**
		 * 设置 应用结果
		 * @param result 应用结果
		 * @return 当前对象
		*/
		public ProcessDefinitionDeploy setResult(String result) {
			super.change(RESULT,super.getResult(),result);
			super.setResult(result);
			return this;
		}
		
		/**
		 * 设置 应用时间
		 * @param applyTime 应用时间
		 * @return 当前对象
		*/
		public ProcessDefinitionDeploy setApplyTime(Date applyTime) {
			super.change(APPLY_TIME,super.getApplyTime(),applyTime);
			super.setApplyTime(applyTime);
			return this;
		}
		
		/**
		 * 设置 异常信息
		 * @param exception 异常信息
		 * @return 当前对象
		*/
		public ProcessDefinitionDeploy setException(String exception) {
			super.change(EXCEPTION,super.getException(),exception);
			super.setException(exception);
			return this;
		}
		
		/**
		 * 设置 是否成功
		 * @param success 是否成功
		 * @return 当前对象
		*/
		public ProcessDefinitionDeploy setSuccess(Integer success) {
			super.change(SUCCESS,super.getSuccess(),success);
			super.setSuccess(success);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public ProcessDefinitionDeploy setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public ProcessDefinitionDeploy clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public ProcessDefinitionDeploy duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setResult(this.getResult());
			inst.setException(this.getException());
			inst.setProcessDefinitionId(this.getProcessDefinitionId());
			inst.setRequest(this.getRequest());
			inst.setSuccess(this.getSuccess());
			inst.setTenantId(this.getTenantId());
			inst.setId(this.getId());
			inst.setApplyTime(this.getApplyTime());
			inst.setFileId(this.getFileId());
			inst.clearModifies();
			return inst;
		}

	}
}