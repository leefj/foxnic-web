package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.EventCallback;
import java.sql.Timestamp;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-06-20 15:57:40
 * @sign 87F9D4611C01BF53624A98CBF11E2C1B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class EventCallbackMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallback,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallback.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * BPM流程ID , 类型: java.lang.String
	*/
	public static final String BPM_PROCESS_INSTANCE_ID="bpmProcessInstanceId";
	
	/**
	 * BPM流程ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallback,java.lang.String> BPM_PROCESS_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallback.class ,BPM_PROCESS_INSTANCE_ID, java.lang.String.class, "BPM流程ID", "BPM流程ID", java.lang.String.class, null);
	
	/**
	 * 变量 , 类型: java.lang.String
	*/
	public static final String VARIABLES="variables";
	
	/**
	 * 变量 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallback,java.lang.String> VARIABLES_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallback.class ,VARIABLES, java.lang.String.class, "变量", "变量", java.lang.String.class, null);
	
	/**
	 * camunda流程ID , 类型: java.lang.String
	*/
	public static final String CAMUNDA_PROCESS_INSTANCE_ID="camundaProcessInstanceId";
	
	/**
	 * camunda流程ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallback,java.lang.String> CAMUNDA_PROCESS_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallback.class ,CAMUNDA_PROCESS_INSTANCE_ID, java.lang.String.class, "camunda流程ID", "camunda流程ID", java.lang.String.class, null);
	
	/**
	 * 事件类型 , 类型: java.lang.String
	*/
	public static final String EVENT_TYPE="eventType";
	
	/**
	 * 事件类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallback,java.lang.String> EVENT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallback.class ,EVENT_TYPE, java.lang.String.class, "事件类型", "事件类型", java.lang.String.class, null);
	
	/**
	 * 节点ID , 类型: java.lang.String
	*/
	public static final String NODE_ID="nodeId";
	
	/**
	 * 节点ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallback,java.lang.String> NODE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallback.class ,NODE_ID, java.lang.String.class, "节点ID", "节点ID", java.lang.String.class, null);
	
	/**
	 * 节点名称 , 类型: java.lang.String
	*/
	public static final String NODE_NAME="nodeName";
	
	/**
	 * 节点名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallback,java.lang.String> NODE_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallback.class ,NODE_NAME, java.lang.String.class, "节点名称", "节点名称", java.lang.String.class, null);
	
	/**
	 * 异常信息 , 类型: java.lang.String
	*/
	public static final String ERROR="error";
	
	/**
	 * 异常信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallback,java.lang.String> ERROR_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallback.class ,ERROR, java.lang.String.class, "异常信息", "异常信息", java.lang.String.class, null);
	
	/**
	 * 处理结果 , 类型: java.lang.String
	*/
	public static final String RESULT="result";
	
	/**
	 * 处理结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallback,java.lang.String> RESULT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallback.class ,RESULT, java.lang.String.class, "处理结果", "处理结果", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallback,java.lang.String> STATUS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallback.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 调用时间 , 类型: java.sql.Timestamp
	*/
	public static final String INVOKE_TIME="invokeTime";
	
	/**
	 * 调用时间 , 类型: java.sql.Timestamp
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallback,java.sql.Timestamp> INVOKE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallback.class ,INVOKE_TIME, java.sql.Timestamp.class, "调用时间", "调用时间", java.sql.Timestamp.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallback,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallback.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 失败重试次数 , 类型: java.lang.Integer
	*/
	public static final String RETRYS="retrys";
	
	/**
	 * 失败重试次数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallback,java.lang.Integer> RETRYS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallback.class ,RETRYS, java.lang.Integer.class, "失败重试次数", "失败重试次数", java.lang.Integer.class, null);
	
	/**
	 * 节点类型 , 类型: java.lang.String
	*/
	public static final String NODE_TYPE="nodeType";
	
	/**
	 * 节点类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallback,java.lang.String> NODE_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallback.class ,NODE_TYPE, java.lang.String.class, "节点类型", "节点类型", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BPM_PROCESS_INSTANCE_ID , VARIABLES , CAMUNDA_PROCESS_INSTANCE_ID , EVENT_TYPE , NODE_ID , NODE_NAME , ERROR , RESULT , STATUS , INVOKE_TIME , CREATE_TIME , RETRYS , NODE_TYPE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.EventCallback {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public EventCallback setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 BPM流程ID
		 * @param bpmProcessInstanceId BPM流程ID
		 * @return 当前对象
		*/
		public EventCallback setBpmProcessInstanceId(String bpmProcessInstanceId) {
			super.change(BPM_PROCESS_INSTANCE_ID,super.getBpmProcessInstanceId(),bpmProcessInstanceId);
			super.setBpmProcessInstanceId(bpmProcessInstanceId);
			return this;
		}
		
		/**
		 * 设置 变量
		 * @param variables 变量
		 * @return 当前对象
		*/
		public EventCallback setVariables(String variables) {
			super.change(VARIABLES,super.getVariables(),variables);
			super.setVariables(variables);
			return this;
		}
		
		/**
		 * 设置 camunda流程ID
		 * @param camundaProcessInstanceId camunda流程ID
		 * @return 当前对象
		*/
		public EventCallback setCamundaProcessInstanceId(String camundaProcessInstanceId) {
			super.change(CAMUNDA_PROCESS_INSTANCE_ID,super.getCamundaProcessInstanceId(),camundaProcessInstanceId);
			super.setCamundaProcessInstanceId(camundaProcessInstanceId);
			return this;
		}
		
		/**
		 * 设置 事件类型
		 * @param eventType 事件类型
		 * @return 当前对象
		*/
		public EventCallback setEventType(String eventType) {
			super.change(EVENT_TYPE,super.getEventType(),eventType);
			super.setEventType(eventType);
			return this;
		}
		
		/**
		 * 设置 节点ID
		 * @param nodeId 节点ID
		 * @return 当前对象
		*/
		public EventCallback setNodeId(String nodeId) {
			super.change(NODE_ID,super.getNodeId(),nodeId);
			super.setNodeId(nodeId);
			return this;
		}
		
		/**
		 * 设置 节点名称
		 * @param nodeName 节点名称
		 * @return 当前对象
		*/
		public EventCallback setNodeName(String nodeName) {
			super.change(NODE_NAME,super.getNodeName(),nodeName);
			super.setNodeName(nodeName);
			return this;
		}
		
		/**
		 * 设置 异常信息
		 * @param error 异常信息
		 * @return 当前对象
		*/
		public EventCallback setError(String error) {
			super.change(ERROR,super.getError(),error);
			super.setError(error);
			return this;
		}
		
		/**
		 * 设置 处理结果
		 * @param result 处理结果
		 * @return 当前对象
		*/
		public EventCallback setResult(String result) {
			super.change(RESULT,super.getResult(),result);
			super.setResult(result);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public EventCallback setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 调用时间
		 * @param invokeTime 调用时间
		 * @return 当前对象
		*/
		public EventCallback setInvokeTime(Timestamp invokeTime) {
			super.change(INVOKE_TIME,super.getInvokeTime(),invokeTime);
			super.setInvokeTime(invokeTime);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public EventCallback setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 失败重试次数
		 * @param retrys 失败重试次数
		 * @return 当前对象
		*/
		public EventCallback setRetrys(Integer retrys) {
			super.change(RETRYS,super.getRetrys(),retrys);
			super.setRetrys(retrys);
			return this;
		}
		
		/**
		 * 设置 节点类型
		 * @param nodeType 节点类型
		 * @return 当前对象
		*/
		public EventCallback setNodeType(String nodeType) {
			super.change(NODE_TYPE,super.getNodeType(),nodeType);
			super.setNodeType(nodeType);
			return this;
		}
	}
}