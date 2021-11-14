package org.github.foxnic.web.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2021-11-14 11:37:42
 * @author 李方捷 , leefangjie@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class FoxnicWeb {
	
	/**
	 * 流程角色表
	*/
	public static class BPM_ROLE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_role";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 角色代码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","角色代码","角色代码",false,false,true);
		
		/**
		 * 角色名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","角色名称","角色名称",false,false,true);
		
		/**
		 * 是否有效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","是否有效","是否有效",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public BPM_ROLE() {
			this.init($NAME,"流程角色表" , ID , CODE , NAME , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final BPM_ROLE $TABLE=new BPM_ROLE();
	}
	
	/**
	 * 流程角色员工关系表
	*/
	public static class BPM_ROLE_EMPLOYEE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_role_employee";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 角色ID
		*/
		public static final DBField ROLE_ID = new DBField(DBDataType.STRING , "role_id","roleId","角色ID","角色ID",false,false,true);
		
		/**
		 * 员工ID
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","员工ID","员工ID",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		public BPM_ROLE_EMPLOYEE() {
			this.init($NAME,"流程角色员工关系表" , ID , ROLE_ID , EMPLOYEE_ID , CREATE_BY , CREATE_TIME);
		}
		public static final BPM_ROLE_EMPLOYEE $TABLE=new BPM_ROLE_EMPLOYEE();
	}
	
	/**
	 * 变更单据关系表
	*/
	public static class CHS_CHANGE_APPROVER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "chs_change_approver";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 变更定义ID
		*/
		public static final DBField DEFINITION_ID = new DBField(DBDataType.STRING , "definition_id","definitionId","变更定义ID","变更定义ID",false,false,true);
		
		/**
		 * 变更实例ID
		*/
		public static final DBField INSTANCE_ID = new DBField(DBDataType.STRING , "instance_id","instanceId","变更实例ID","变更实例ID",false,false,true);
		
		/**
		 * 审批人ID
		*/
		public static final DBField APPROVER_ID = new DBField(DBDataType.STRING , "approver_id","approverId","审批人ID","审批人ID",false,false,true);
		
		/**
		 * 审批人类型，参考枚举 ApproverType
		*/
		public static final DBField APPROVER_TYPE = new DBField(DBDataType.STRING , "approver_type","approverType","审批人类型","参考枚举 ApproverType",false,false,true);
		
		/**
		 * 节点ID
		*/
		public static final DBField NODE_ID = new DBField(DBDataType.STRING , "node_id","nodeId","节点ID","节点ID",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public CHS_CHANGE_APPROVER() {
			this.init($NAME,"变更单据关系表" , ID , DEFINITION_ID , INSTANCE_ID , APPROVER_ID , APPROVER_TYPE , NODE_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CHS_CHANGE_APPROVER $TABLE=new CHS_CHANGE_APPROVER();
	}
	
	/**
	 * 变更单据关系表
	*/
	public static class CHS_CHANGE_BILL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "chs_change_bill";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 变更定义ID
		*/
		public static final DBField DEFINITION_ID = new DBField(DBDataType.STRING , "definition_id","definitionId","变更定义ID","变更定义ID",false,false,true);
		
		/**
		 * 变更实例ID
		*/
		public static final DBField INSTANCE_ID = new DBField(DBDataType.STRING , "instance_id","instanceId","变更实例ID","变更实例ID",false,false,true);
		
		/**
		 * 变更单据ID
		*/
		public static final DBField BILL_ID = new DBField(DBDataType.STRING , "bill_id","billId","变更单据ID","变更单据ID",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public CHS_CHANGE_BILL() {
			this.init($NAME,"变更单据关系表" , ID , DEFINITION_ID , INSTANCE_ID , BILL_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CHS_CHANGE_BILL $TABLE=new CHS_CHANGE_BILL();
	}
	
	/**
	 * 变更数据表
	*/
	public static class CHS_CHANGE_DATA extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "chs_change_data";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 变更ID
		*/
		public static final DBField INSTANCE_ID = new DBField(DBDataType.STRING , "instance_id","instanceId","变更ID","变更ID",false,false,true);
		
		/**
		 * 实体类名
		*/
		public static final DBField DATA_TYPE = new DBField(DBDataType.STRING , "data_type","dataType","实体类名","实体类名",false,false,true);
		
		/**
		 * 变更时间点，0，变更前；1，变更后
		*/
		public static final DBField TIME_POINT = new DBField(DBDataType.INTEGER , "time_point","timePoint","变更时间点","0，变更前；1，变更后",false,false,true);
		
		/**
		 * 数据，JSON格式
		*/
		public static final DBField DATA = new DBField(DBDataType.STRING , "data","data","数据","JSON格式",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public CHS_CHANGE_DATA() {
			this.init($NAME,"变更数据表" , ID , INSTANCE_ID , DATA_TYPE , TIME_POINT , DATA , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CHS_CHANGE_DATA $TABLE=new CHS_CHANGE_DATA();
	}
	
	/**
	 * 变更定义表
	*/
	public static class CHS_CHANGE_DEFINITION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "chs_change_definition";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 代码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","代码","代码",false,false,true);
		
		/**
		 * 审批模式
		*/
		public static final DBField MODE = new DBField(DBDataType.STRING , "mode","mode","审批模式","审批模式",false,false,true);
		
		/**
		 * 默认审批人信息JSONArray格式，适用于简单审批模式
		*/
		public static final DBField SIMPLE_APPROVERS = new DBField(DBDataType.STRING , "simple_approvers","simpleApprovers","默认审批人信息JSONArray格式","适用于简单审批模式",false,false,true);
		
		/**
		 * 是否有效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","是否有效","是否有效",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public CHS_CHANGE_DEFINITION() {
			this.init($NAME,"变更定义表" , ID , NAME , CODE , MODE , SIMPLE_APPROVERS , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CHS_CHANGE_DEFINITION $TABLE=new CHS_CHANGE_DEFINITION();
	}
	
	/**
	 * 变更事件表
	*/
	public static class CHS_CHANGE_EVENT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "chs_change_event";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 变更ID
		*/
		public static final DBField INSTANCE_ID = new DBField(DBDataType.STRING , "instance_id","instanceId","变更ID","变更ID",false,false,true);
		
		/**
		 * 事件类型
		*/
		public static final DBField EVENT_TYPE = new DBField(DBDataType.STRING , "event_type","eventType","事件类型","事件类型",false,false,true);
		
		/**
		 * 请求的数据
		*/
		public static final DBField REQUEST_DATA = new DBField(DBDataType.STRING , "request_data","requestData","请求的数据","请求的数据",false,false,true);
		
		/**
		 * 通知发送时间
		*/
		public static final DBField NOTIFY_TIME = new DBField(DBDataType.TIMESTAME , "notify_time","notifyTime","通知发送时间","通知发送时间",false,false,true);
		
		/**
		 * 数据，通知到消费方的数据，JSON格式
		*/
		public static final DBField NOTIFY_DATA = new DBField(DBDataType.STRING , "notify_data","notifyData","数据","通知到消费方的数据，JSON格式",false,false,true);
		
		/**
		 * 响应的数据
		*/
		public static final DBField RESPONSE_DATA = new DBField(DBDataType.STRING , "response_data","responseData","响应的数据","响应的数据",false,false,true);
		
		/**
		 * 回调接收时间
		*/
		public static final DBField RESPONSE_TIME = new DBField(DBDataType.TIMESTAME , "response_time","responseTime","回调接收时间","回调接收时间",false,false,true);
		
		/**
		 * 审批人账户ID，执行操作的账户ID
		*/
		public static final DBField APPROVER_ID = new DBField(DBDataType.STRING , "approver_id","approverId","审批人账户ID","执行操作的账户ID",false,false,true);
		
		/**
		 * 审批人姓名，执行操作的人的姓名
		*/
		public static final DBField APPROVER_NAME = new DBField(DBDataType.STRING , "approver_name","approverName","审批人姓名","执行操作的人的姓名",false,false,true);
		
		/**
		 * 审批意见
		*/
		public static final DBField OPINION = new DBField(DBDataType.STRING , "opinion","opinion","审批意见","审批意见",false,false,true);
		
		/**
		 * 审批动作
		*/
		public static final DBField APPROVE_ACTION = new DBField(DBDataType.STRING , "approve_action","approveAction","审批动作","审批动作",false,false,true);
		
		/**
		 * 下一个审批节点审批人账户ID，用逗号隔开
		*/
		public static final DBField SIMPLE_NEXT_APPROVER_IDS = new DBField(DBDataType.STRING , "simple_next_approver_ids","simpleNextApproverIds","下一个审批节点审批人账户ID","用逗号隔开",false,false,true);
		
		/**
		 * 下一个审批节点审批人姓名，用逗号隔开
		*/
		public static final DBField SIMPLE_NEXT_APPROVER_NAMES = new DBField(DBDataType.STRING , "simple_next_approver_names","simpleNextApproverNames","下一个审批节点审批人姓名","用逗号隔开",false,false,true);
		
		/**
		 * 是否成功，失败时查看 response_data 
		*/
		public static final DBField SUCCESS = new DBField(DBDataType.INTEGER , "success","success","是否成功","失败时查看 response_data",false,false,true);
		
		/**
		 * 错误信息
		*/
		public static final DBField ERRORS = new DBField(DBDataType.STRING , "errors","errors","错误信息","错误信息",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 简单模式的节点ID
		*/
		public static final DBField SIMPLE_NODE_ID = new DBField(DBDataType.STRING , "simple_node_id","simpleNodeId","简单模式的节点ID","简单模式的节点ID",false,false,true);
		
		public CHS_CHANGE_EVENT() {
			this.init($NAME,"变更事件表" , ID , INSTANCE_ID , EVENT_TYPE , REQUEST_DATA , NOTIFY_TIME , NOTIFY_DATA , RESPONSE_DATA , RESPONSE_TIME , APPROVER_ID , APPROVER_NAME , OPINION , APPROVE_ACTION , SIMPLE_NEXT_APPROVER_IDS , SIMPLE_NEXT_APPROVER_NAMES , SUCCESS , ERRORS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , SIMPLE_NODE_ID);
		}
		public static final CHS_CHANGE_EVENT $TABLE=new CHS_CHANGE_EVENT();
	}
	
	/**
	 * 变更实例表
	*/
	public static class CHS_CHANGE_INSTANCE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "chs_change_instance";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 变更定义ID
		*/
		public static final DBField DEFINITION_ID = new DBField(DBDataType.STRING , "definition_id","definitionId","变更定义ID","变更定义ID",false,false,true);
		
		/**
		 * 审批模式
		*/
		public static final DBField MODE = new DBField(DBDataType.STRING , "mode","mode","审批模式","审批模式",false,false,true);
		
		/**
		 * 起草人ID,员工ID
		*/
		public static final DBField DRAFTER_ID = new DBField(DBDataType.STRING , "drafter_id","drafterId","起草人ID","员工ID",false,false,true);
		
		/**
		 * 起草人姓名
		*/
		public static final DBField DRAFTER_NAME = new DBField(DBDataType.STRING , "drafter_name","drafterName","起草人姓名","起草人姓名",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 变更状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","变更状态","变更状态",false,false,true);
		
		/**
		 * 变更类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","变更类型","变更类型",false,false,true);
		
		/**
		 * 流程ID
		*/
		public static final DBField PROCESS_ID = new DBField(DBDataType.STRING , "process_id","processId","流程ID","流程ID",false,false,true);
		
		/**
		 * 当前审批节点，对于当前审批节点的描述性信息
		*/
		public static final DBField PROCESS_NODE_SUMMARY = new DBField(DBDataType.STRING , "process_node_summary","processNodeSummary","当前审批节点","对于当前审批节点的描述性信息",false,false,true);
		
		/**
		 * 流程概要，针对流程审批的概要描述
		*/
		public static final DBField PROCESS_SUMMARY = new DBField(DBDataType.STRING , "process_summary","processSummary","流程概要","针对流程审批的概要描述",false,false,true);
		
		/**
		 * 变更开始时间
		*/
		public static final DBField START_TIME = new DBField(DBDataType.DATE , "start_time","startTime","变更开始时间","变更开始时间",false,false,true);
		
		/**
		 * 变更结束时间
		*/
		public static final DBField FINISH_TIME = new DBField(DBDataType.DATE , "finish_time","finishTime","变更结束时间","变更结束时间",false,false,true);
		
		/**
		 * 默认审批人信息JSONArray格式，适用于简单审批模式
		*/
		public static final DBField SIMPLE_APPROVERS = new DBField(DBDataType.STRING , "simple_approvers","simpleApprovers","默认审批人信息JSONArray格式","适用于简单审批模式",false,false,true);
		
		/**
		 * 简单模式的节点ID
		*/
		public static final DBField SIMPLE_NODE_ID = new DBField(DBDataType.STRING , "simple_node_id","simpleNodeId","简单模式的节点ID","简单模式的节点ID",false,false,true);
		
		public CHS_CHANGE_INSTANCE() {
			this.init($NAME,"变更实例表" , ID , DEFINITION_ID , MODE , DRAFTER_ID , DRAFTER_NAME , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , STATUS , TYPE , PROCESS_ID , PROCESS_NODE_SUMMARY , PROCESS_SUMMARY , START_TIME , FINISH_TIME , SIMPLE_APPROVERS , SIMPLE_NODE_ID);
		}
		public static final CHS_CHANGE_INSTANCE $TABLE=new CHS_CHANGE_INSTANCE();
	}
	
	/**
	 * 变更示例订单表
	*/
	public static class CHS_EXAMPLE_ORDER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "chs_example_order";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 标题
		*/
		public static final DBField TITLE = new DBField(DBDataType.STRING , "title","title","标题","标题",false,false,true);
		
		/**
		 * 订单编号
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","订单编号","订单编号",false,false,true);
		
		/**
		 * 下单时间
		*/
		public static final DBField ORDER_TIME = new DBField(DBDataType.DATE , "order_time","orderTime","下单时间","下单时间",false,false,true);
		
		/**
		 * 买家ID
		*/
		public static final DBField BUYER_ID = new DBField(DBDataType.STRING , "buyer_id","buyerId","买家ID","买家ID",false,false,true);
		
		/**
		 * 收件地址
		*/
		public static final DBField ADDRESS = new DBField(DBDataType.STRING , "address","address","收件地址","收件地址",false,false,true);
		
		/**
		 * 总金额
		*/
		public static final DBField AMOUNT = new DBField(DBDataType.DECIMAL , "amount","amount","总金额","总金额",false,false,true);
		
		/**
		 * 变更类型
		*/
		public static final DBField CHS_TYPE = new DBField(DBDataType.STRING , "chs_type","chsType","变更类型","变更类型",false,false,true);
		
		/**
		 * 变更状态
		*/
		public static final DBField CHS_STATUS = new DBField(DBDataType.STRING , "chs_status","chsStatus","变更状态","变更状态",false,false,true);
		
		/**
		 * 变更版本号
		*/
		public static final DBField CHS_VERSION = new DBField(DBDataType.INTEGER , "chs_version","chsVersion","变更版本号","变更版本号",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 来源ID
		*/
		public static final DBField SOURCE_ID = new DBField(DBDataType.STRING , "source_id","sourceId","来源ID","来源ID",false,false,true);
		
		/**
		 * 变更ID
		*/
		public static final DBField CHANGE_INSTANCE_ID = new DBField(DBDataType.STRING , "change_instance_id","changeInstanceId","变更ID","变更ID",false,false,true);
		
		/**
		 * 流程概要
		*/
		public static final DBField SUMMARY = new DBField(DBDataType.STRING , "summary","summary","流程概要","流程概要",false,false,true);
		
		/**
		 * 最后审批人账户ID
		*/
		public static final DBField LATEST_APPROVER_ID = new DBField(DBDataType.STRING , "latest_approver_id","latestApproverId","最后审批人账户ID","最后审批人账户ID",false,false,true);
		
		/**
		 * 最后审批人姓名
		*/
		public static final DBField LATEST_APPROVER_NAME = new DBField(DBDataType.STRING , "latest_approver_name","latestApproverName","最后审批人姓名","最后审批人姓名",false,false,true);
		
		/**
		 * 下一节点审批人
		*/
		public static final DBField NEXT_APPROVER_IDS = new DBField(DBDataType.STRING , "next_approver_ids","nextApproverIds","下一节点审批人","下一节点审批人",false,false,true);
		
		/**
		 * 下一个审批节点审批人姓名，用逗号隔开
		*/
		public static final DBField NEXT_APPROVER_NAMES = new DBField(DBDataType.STRING , "next_approver_names","nextApproverNames","下一个审批节点审批人姓名","用逗号隔开",false,false,true);
		
		public CHS_EXAMPLE_ORDER() {
			this.init($NAME,"变更示例订单表" , ID , TITLE , CODE , ORDER_TIME , BUYER_ID , ADDRESS , AMOUNT , CHS_TYPE , CHS_STATUS , CHS_VERSION , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , SOURCE_ID , CHANGE_INSTANCE_ID , SUMMARY , LATEST_APPROVER_ID , LATEST_APPROVER_NAME , NEXT_APPROVER_IDS , NEXT_APPROVER_NAMES);
		}
		public static final CHS_EXAMPLE_ORDER $TABLE=new CHS_EXAMPLE_ORDER();
	}
	
	/**
	 * 变更示例订单明细表
	*/
	public static class CHS_EXAMPLE_ORDER_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "chs_example_order_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 订单ID
		*/
		public static final DBField ORDER_ID = new DBField(DBDataType.STRING , "order_id","orderId","订单ID","订单ID",false,false,true);
		
		/**
		 * 商品名称
		*/
		public static final DBField PRODUCT_NAME = new DBField(DBDataType.STRING , "product_name","productName","商品名称","商品名称",false,false,true);
		
		/**
		 * 单价
		*/
		public static final DBField PRICE = new DBField(DBDataType.DECIMAL , "price","price","单价","单价",false,false,true);
		
		/**
		 * 数量
		*/
		public static final DBField QUANTITY = new DBField(DBDataType.INTEGER , "quantity","quantity","数量","数量",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public CHS_EXAMPLE_ORDER_ITEM() {
			this.init($NAME,"变更示例订单明细表" , ID , ORDER_ID , PRODUCT_NAME , PRICE , QUANTITY , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CHS_EXAMPLE_ORDER_ITEM $TABLE=new CHS_EXAMPLE_ORDER_ITEM();
	}
	
	/**
	 * 商品品牌表
	*/
	public static class DP_EXAMPLE_BRAND extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "dp_example_brand";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public DP_EXAMPLE_BRAND() {
			this.init($NAME,"商品品牌表" , ID , NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final DP_EXAMPLE_BRAND $TABLE=new DP_EXAMPLE_BRAND();
	}
	
	/**
	 * 商品分类表
	*/
	public static class DP_EXAMPLE_CATALOG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "dp_example_catalog";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 上级ID
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","上级ID","上级ID",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public DP_EXAMPLE_CATALOG() {
			this.init($NAME,"商品分类表" , ID , PARENT_ID , NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final DP_EXAMPLE_CATALOG $TABLE=new DP_EXAMPLE_CATALOG();
	}
	
	/**
	 * 销售订单表
	*/
	public static class DP_EXAMPLE_ORDER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "dp_example_order";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 商品ID
		*/
		public static final DBField PRODUCT_ID = new DBField(DBDataType.STRING , "product_id","productId","商品ID","商品ID",false,false,true);
		
		/**
		 * 售价
		*/
		public static final DBField PRICE = new DBField(DBDataType.DECIMAL , "price","price","售价","售价",false,false,true);
		
		/**
		 * 数量
		*/
		public static final DBField QUANTITY = new DBField(DBDataType.INTEGER , "quantity","quantity","数量","数量",false,false,true);
		
		/**
		 * 金额
		*/
		public static final DBField AMOUNT = new DBField(DBDataType.DECIMAL , "amount","amount","金额","金额",false,false,true);
		
		/**
		 * 店铺ID
		*/
		public static final DBField SHOP_ID = new DBField(DBDataType.STRING , "shop_id","shopId","店铺ID","店铺ID",false,false,true);
		
		/**
		 * 销售人员ID
		*/
		public static final DBField SALES_ID = new DBField(DBDataType.STRING , "sales_id","salesId","销售人员ID","销售人员ID",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public DP_EXAMPLE_ORDER() {
			this.init($NAME,"销售订单表" , ID , PRODUCT_ID , PRICE , QUANTITY , AMOUNT , SHOP_ID , SALES_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final DP_EXAMPLE_ORDER $TABLE=new DP_EXAMPLE_ORDER();
	}
	
	/**
	 * 销售订单表
	*/
	public static class DP_EXAMPLE_PRODUCT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "dp_example_product";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 品牌ID
		*/
		public static final DBField BRAND_ID = new DBField(DBDataType.STRING , "brand_id","brandId","品牌ID","品牌ID",false,false,true);
		
		/**
		 * 大类ID
		*/
		public static final DBField BIG_CATA_ID = new DBField(DBDataType.STRING , "big_cata_id","bigCataId","大类ID","大类ID",false,false,true);
		
		/**
		 * 小类ID
		*/
		public static final DBField SML_CATA_ID = new DBField(DBDataType.STRING , "sml_cata_id","smlCataId","小类ID","小类ID",false,false,true);
		
		/**
		 * 售价
		*/
		public static final DBField PRICE = new DBField(DBDataType.DECIMAL , "price","price","售价","售价",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public DP_EXAMPLE_PRODUCT() {
			this.init($NAME,"销售订单表" , ID , NAME , BRAND_ID , BIG_CATA_ID , SML_CATA_ID , PRICE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final DP_EXAMPLE_PRODUCT $TABLE=new DP_EXAMPLE_PRODUCT();
	}
	
	/**
	 * 销售门店表
	*/
	public static class DP_EXAMPLE_SHOP extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "dp_example_shop";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 上级ID
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.STRING , "org_id","orgId","上级ID","上级ID",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 是否旗舰店
		*/
		public static final DBField FLAG = new DBField(DBDataType.INTEGER , "flag","flag","是否旗舰店","是否旗舰店",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public DP_EXAMPLE_SHOP() {
			this.init($NAME,"销售门店表" , ID , ORG_ID , NAME , FLAG , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final DP_EXAMPLE_SHOP $TABLE=new DP_EXAMPLE_SHOP();
	}
	
	/**
	 * 数据权限规则表
	*/
	public static class DP_RULE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "dp_rule";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * po类型
		*/
		public static final DBField PO_TYPE = new DBField(DBDataType.STRING , "po_type","poType","po类型","po类型",false,false,true);
		
		/**
		 * 代码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","代码","代码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 规则版本号
		*/
		public static final DBField VERSION_NO = new DBField(DBDataType.INTEGER , "version_no","versionNo","规则版本号","规则版本号",false,false,true);
		
		/**
		 * 是否生效,相同的代码仅可以有一个是生效的
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","是否生效","相同的代码仅可以有一个是生效的",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public DP_RULE() {
			this.init($NAME,"数据权限规则表" , ID , PO_TYPE , CODE , NAME , VERSION_NO , VALID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final DP_RULE $TABLE=new DP_RULE();
	}
	
	/**
	 * 数据权限规则范围条件表
	*/
	public static class DP_RULE_CONDITION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "dp_rule_condition";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 抬头
		*/
		public static final DBField TITLE = new DBField(DBDataType.STRING , "title","title","抬头","抬头",false,false,true);
		
		/**
		 * 应用条件，SpringEL表达式，返回 true / false
		*/
		public static final DBField CONDITION_EXPR = new DBField(DBDataType.STRING , "condition_expr","conditionExpr","应用条件","SpringEL表达式，返回 true / false",false,false,true);
		
		/**
		 * 应用条件测试值，JSON 
		*/
		public static final DBField CONDITION_TEST_VALUE = new DBField(DBDataType.STRING , "condition_test_value","conditionTestValue","应用条件测试值","JSON",false,false,true);
		
		/**
		 * 规则ID
		*/
		public static final DBField RULE_ID = new DBField(DBDataType.STRING , "rule_id","ruleId","规则ID","规则ID",false,false,true);
		
		/**
		 * range_id
		*/
		public static final DBField RANGE_ID = new DBField(DBDataType.STRING , "range_id","rangeId","range","id",false,false,true);
		
		/**
		 * 上级ID
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","上级ID","上级ID",false,false,true);
		
		/**
		 * 查询的属性路径
		*/
		public static final DBField QUERY_PROPERTY = new DBField(DBDataType.STRING , "query_property","queryProperty","查询的属性路径","查询的属性路径",false,false,true);
		
		/**
		 * 查询字段
		*/
		public static final DBField QUERY_FIELD = new DBField(DBDataType.STRING , "query_field","queryField","查询字段","查询字段",false,false,true);
		
		/**
		 * 节点类型，逻辑组/表达式
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","节点类型","逻辑组/表达式",false,false,false);
		
		/**
		 * 前置逻辑关系  and/or
		*/
		public static final DBField LOGIC = new DBField(DBDataType.STRING , "logic","logic","前置逻辑关系","and/or",false,false,true);
		
		/**
		 * 表达式类型
		*/
		public static final DBField EXPR_TYPE = new DBField(DBDataType.STRING , "expr_type","exprType","表达式类型","表达式类型",false,false,true);
		
		/**
		 * 是否生效,相同的代码仅可以有一个是生效的
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","是否生效","相同的代码仅可以有一个是生效的",false,false,true);
		
		/**
		 * 变量，数组或Map结构
		*/
		public static final DBField VARIABLES = new DBField(DBDataType.STRING , "variables","variables","变量","数组或Map结构",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public DP_RULE_CONDITION() {
			this.init($NAME,"数据权限规则范围条件表" , ID , TITLE , CONDITION_EXPR , CONDITION_TEST_VALUE , RULE_ID , RANGE_ID , PARENT_ID , QUERY_PROPERTY , QUERY_FIELD , TYPE , LOGIC , EXPR_TYPE , VALID , VARIABLES , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final DP_RULE_CONDITION $TABLE=new DP_RULE_CONDITION();
	}
	
	/**
	 * 数据权限规则范围表
	*/
	public static class DP_RULE_RANGE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "dp_rule_range";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 规则ID
		*/
		public static final DBField RULE_ID = new DBField(DBDataType.STRING , "rule_id","ruleId","规则ID","规则ID",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 是否生效,相同的代码仅可以有一个是生效的
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","是否生效","相同的代码仅可以有一个是生效的",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public DP_RULE_RANGE() {
			this.init($NAME,"数据权限规则范围表" , ID , RULE_ID , NAME , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final DP_RULE_RANGE $TABLE=new DP_RULE_RANGE();
	}
	
	/**
	 * 公司表
	*/
	public static class HRM_COMPANY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hrm_company";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 公司名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","公司名称","公司名称",false,false,true);
		
		/**
		 * 社会信用代码
		*/
		public static final DBField SOCIAL_CREDIT_CODE = new DBField(DBDataType.STRING , "social_credit_code","socialCreditCode","社会信用代码","社会信用代码",false,false,true);
		
		/**
		 * 是否有效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","是否有效","是否有效",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public HRM_COMPANY() {
			this.init($NAME,"公司表" , ID , NAME , SOCIAL_CREDIT_CODE , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HRM_COMPANY $TABLE=new HRM_COMPANY();
	}
	
	/**
	 * 员工表
	*/
	public static class HRM_EMPLOYEE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hrm_employee";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 工号
		*/
		public static final DBField BADGE = new DBField(DBDataType.STRING , "badge","badge","工号","工号",false,false,true);
		
		/**
		 * 手机号
		*/
		public static final DBField PHONE = new DBField(DBDataType.STRING , "phone","phone","手机号","手机号",false,false,true);
		
		/**
		 * 人员ID
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员ID","人员ID",false,false,true);
		
		/**
		 * 公司ID
		*/
		public static final DBField COMPANY_ID = new DBField(DBDataType.STRING , "company_id","companyId","公司ID","公司ID",false,false,true);
		
		/**
		 * 状态，字典代码：employee_status
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","字典代码：employee_status",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public HRM_EMPLOYEE() {
			this.init($NAME,"员工表" , ID , BADGE , PHONE , PERSON_ID , COMPANY_ID , STATUS , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HRM_EMPLOYEE $TABLE=new HRM_EMPLOYEE();
	}
	
	/**
	 * 员工岗位关系表
	*/
	public static class HRM_EMPLOYEE_POSITION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hrm_employee_position";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 员工ID
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","员工ID","员工ID",false,false,false);
		
		/**
		 * 岗位ID
		*/
		public static final DBField POSITION_ID = new DBField(DBDataType.STRING , "position_id","positionId","岗位ID","岗位ID",false,false,false);
		
		/**
		 * 是否主岗
		*/
		public static final DBField IS_PRIMARY = new DBField(DBDataType.INTEGER , "is_primary","isPrimary","是否主岗","是否主岗",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public HRM_EMPLOYEE_POSITION() {
			this.init($NAME,"员工岗位关系表" , ID , EMPLOYEE_ID , POSITION_ID , IS_PRIMARY , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HRM_EMPLOYEE_POSITION $TABLE=new HRM_EMPLOYEE_POSITION();
	}
	
	/**
	 * 常用人员分组表
	*/
	public static class HRM_FAVOURITE_GROUP extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hrm_favourite_group";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 组名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","组名","组名",false,false,false);
		
		/**
		 * 上级ID
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","上级ID","上级ID",false,false,false);
		
		/**
		 * 所有者ID
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","所有者ID","所有者ID",false,false,false);
		
		/**
		 * 层级路径
		*/
		public static final DBField HIERARCHY = new DBField(DBDataType.STRING , "hierarchy","hierarchy","层级路径","层级路径",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 总公司ID
		*/
		public static final DBField COMPANY_ID = new DBField(DBDataType.STRING , "company_id","companyId","总公司ID","总公司ID",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public HRM_FAVOURITE_GROUP() {
			this.init($NAME,"常用人员分组表" , ID , NAME , PARENT_ID , EMPLOYEE_ID , HIERARCHY , SORT , COMPANY_ID , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HRM_FAVOURITE_GROUP $TABLE=new HRM_FAVOURITE_GROUP();
	}
	
	/**
	 * 常用人员分组条目表
	*/
	public static class HRM_FAVOURITE_GROUP_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hrm_favourite_group_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 对象ID
		*/
		public static final DBField TARGET_ID = new DBField(DBDataType.STRING , "target_id","targetId","对象ID","对象ID",false,false,false);
		
		/**
		 * 对象类型
		*/
		public static final DBField TARGET_TYPE = new DBField(DBDataType.STRING , "target_type","targetType","对象类型","对象类型",false,false,false);
		
		/**
		 * 对象名称
		*/
		public static final DBField TARGET_NAME = new DBField(DBDataType.STRING , "target_name","targetName","对象名称","对象名称",false,false,true);
		
		/**
		 * 层级路径
		*/
		public static final DBField GROUP_ID = new DBField(DBDataType.STRING , "group_id","groupId","层级路径","层级路径",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 所有者ID
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","所有者ID","所有者ID",false,false,true);
		
		/**
		 * 是否临时
		*/
		public static final DBField TEMPORARY = new DBField(DBDataType.INTEGER , "temporary","temporary","是否临时","是否临时",false,false,false);
		
		/**
		 * 总公司ID
		*/
		public static final DBField COMPANY_ID = new DBField(DBDataType.STRING , "company_id","companyId","总公司ID","总公司ID",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public HRM_FAVOURITE_GROUP_ITEM() {
			this.init($NAME,"常用人员分组条目表" , ID , TARGET_ID , TARGET_TYPE , TARGET_NAME , GROUP_ID , SORT , EMPLOYEE_ID , TEMPORARY , COMPANY_ID , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HRM_FAVOURITE_GROUP_ITEM $TABLE=new HRM_FAVOURITE_GROUP_ITEM();
	}
	
	/**
	 * 组织层级表
	*/
	public static class HRM_ORGANIZATION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hrm_organization";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 代码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","代码","代码",false,false,true);
		
		/**
		 * 简称
		*/
		public static final DBField SHORT_NAME = new DBField(DBDataType.STRING , "short_name","shortName","简称","简称",false,false,true);
		
		/**
		 * 全称
		*/
		public static final DBField FULL_NAME = new DBField(DBDataType.STRING , "full_name","fullName","全称","全称",false,false,false);
		
		/**
		 * 组织类型,公司(com)或部门(dept)
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","组织类型","公司(com)或部门(dept)",false,false,false);
		
		/**
		 * 上级ID
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","上级ID","上级ID",false,false,true);
		
		/**
		 * 是否有效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","是否有效","是否有效",false,false,true);
		
		/**
		 * 层级路径
		*/
		public static final DBField HIERARCHY = new DBField(DBDataType.STRING , "hierarchy","hierarchy","层级路径","层级路径",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 总公司ID
		*/
		public static final DBField COMPANY_ID = new DBField(DBDataType.STRING , "company_id","companyId","总公司ID","总公司ID",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public HRM_ORGANIZATION() {
			this.init($NAME,"组织层级表" , ID , CODE , SHORT_NAME , FULL_NAME , TYPE , PARENT_ID , VALID , HIERARCHY , SORT , COMPANY_ID , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HRM_ORGANIZATION $TABLE=new HRM_ORGANIZATION();
	}
	
	/**
	 * 人员表
	*/
	public static class HRM_PERSON extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hrm_person";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 姓名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","姓名","姓名",false,false,true);
		
		/**
		 * 性别
		*/
		public static final DBField SEX = new DBField(DBDataType.STRING , "sex","sex","性别","性别",false,false,true);
		
		/**
		 * 来源，PersonSource枚举
		*/
		public static final DBField SOURCE = new DBField(DBDataType.STRING , "source","source","来源","PersonSource枚举",false,false,false);
		
		/**
		 * 身份证号码
		*/
		public static final DBField IDENTITY = new DBField(DBDataType.STRING , "identity","identity","身份证号码","身份证号码",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public HRM_PERSON() {
			this.init($NAME,"人员表" , ID , NAME , SEX , SOURCE , IDENTITY , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HRM_PERSON $TABLE=new HRM_PERSON();
	}
	
	/**
	 * 岗位表
	*/
	public static class HRM_POSITION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hrm_position";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 所属组织ID
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.STRING , "org_id","orgId","所属组织ID","所属组织ID",false,false,true);
		
		/**
		 * 岗位代码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","岗位代码","岗位代码",false,false,true);
		
		/**
		 * 全称
		*/
		public static final DBField FULL_NAME = new DBField(DBDataType.STRING , "full_name","fullName","全称","全称",false,false,false);
		
		/**
		 * 简称
		*/
		public static final DBField SHORT_NAME = new DBField(DBDataType.STRING , "short_name","shortName","简称","简称",false,false,true);
		
		/**
		 * 是否有效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","是否有效","是否有效",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 总公司ID
		*/
		public static final DBField COMPANY_ID = new DBField(DBDataType.STRING , "company_id","companyId","总公司ID","总公司ID",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 岗位类型，关联字典 position_type
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","岗位类型","关联字典 position_type",false,false,true);
		
		public HRM_POSITION() {
			this.init($NAME,"岗位表" , ID , ORG_ID , CODE , FULL_NAME , SHORT_NAME , VALID , SORT , COMPANY_ID , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TYPE);
		}
		public static final HRM_POSITION $TABLE=new HRM_POSITION();
	}
	
	/**
	 * 数据存储表
	*/
	public static class PCM_CATALOG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "pcm_catalog";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 代码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","代码","代码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 上级ID
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","上级ID","上级ID",false,false,true);
		
		/**
		 * 顺序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","顺序","顺序",false,false,true);
		
		/**
		 * 是否有效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","是否有效","是否有效",false,false,false);
		
		/**
		 * 层级路径
		*/
		public static final DBField HIERARCHY = new DBField(DBDataType.STRING , "hierarchy","hierarchy","层级路径","层级路径",false,false,true);
		
		/**
		 * 存储表
		*/
		public static final DBField DATA_TABLE = new DBField(DBDataType.STRING , "data_table","dataTable","存储表","存储表",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public PCM_CATALOG() {
			this.init($NAME,"数据存储表" , ID , CODE , NAME , PARENT_ID , SORT , VALID , HIERARCHY , DATA_TABLE , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final PCM_CATALOG $TABLE=new PCM_CATALOG();
	}
	
	/**
	 * 分类属性分配表
	*/
	public static class PCM_CATALOG_ALLOCATION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "pcm_catalog_allocation";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 配置版本号
		*/
		public static final DBField VERSION_NO = new DBField(DBDataType.STRING , "version_no","versionNo","配置版本号","配置版本号",false,false,false);
		
		/**
		 * 分类ID
		*/
		public static final DBField CATALOG_ID = new DBField(DBDataType.STRING , "catalog_id","catalogId","分类ID","分类ID",false,false,false);
		
		/**
		 * 属性ID
		*/
		public static final DBField ATTRIBUTE_ID = new DBField(DBDataType.STRING , "attribute_id","attributeId","属性ID","属性ID",false,false,false);
		
		/**
		 * 字段名，数据库字段名
		*/
		public static final DBField COLUMN_NAME = new DBField(DBDataType.STRING , "column_name","columnName","字段名","数据库字段名",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public PCM_CATALOG_ALLOCATION() {
			this.init($NAME,"分类属性分配表" , ID , VERSION_NO , CATALOG_ID , ATTRIBUTE_ID , COLUMN_NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final PCM_CATALOG_ALLOCATION $TABLE=new PCM_CATALOG_ALLOCATION();
	}
	
	/**
	 * 分类属性表
	*/
	public static class PCM_CATALOG_ATTRIBUTE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "pcm_catalog_attribute";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 存储ID
		*/
		public static final DBField CATALOG_ID = new DBField(DBDataType.STRING , "catalog_id","catalogId","存储ID","存储ID",false,false,false);
		
		/**
		 * 字段名，自定义的字段别名
		*/
		public static final DBField FIELD = new DBField(DBDataType.STRING , "field","field","字段名","自定义的字段别名",false,false,false);
		
		/**
		 * 是否必填
		*/
		public static final DBField NOT_NULL = new DBField(DBDataType.INTEGER , "not_null","notNull","是否必填","是否必填",false,false,false);
		
		/**
		 * 配置版本号
		*/
		public static final DBField VERSION_NO = new DBField(DBDataType.STRING , "version_no","versionNo","配置版本号","配置版本号",false,false,false);
		
		/**
		 * 数据类型
		*/
		public static final DBField DATA_TYPE = new DBField(DBDataType.STRING , "data_type","dataType","数据类型","数据类型",false,false,false);
		
		/**
		 * 数据长度
		*/
		public static final DBField LENGTH = new DBField(DBDataType.INTEGER , "length","length","数据长度","数据长度",false,false,true);
		
		/**
		 * 数据精度
		*/
		public static final DBField ACCURACY = new DBField(DBDataType.INTEGER , "accuracy","accuracy","数据精度","数据精度",false,false,true);
		
		/**
		 * 小数位数
		*/
		public static final DBField SCALE = new DBField(DBDataType.INTEGER , "scale","scale","小数位数","小数位数",false,false,true);
		
		/**
		 * 简称
		*/
		public static final DBField SHORT_NAME = new DBField(DBDataType.STRING , "short_name","shortName","简称","简称",false,false,false);
		
		/**
		 * 全称
		*/
		public static final DBField FULL_NAME = new DBField(DBDataType.STRING , "full_name","fullName","全称","全称",false,false,false);
		
		/**
		 * 提示信息
		*/
		public static final DBField HINT = new DBField(DBDataType.STRING , "hint","hint","提示信息","提示信息",false,false,true);
		
		/**
		 * 说明
		*/
		public static final DBField DETAIL = new DBField(DBDataType.STRING , "detail","detail","说明","说明",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTE = new DBField(DBDataType.STRING , "note","note","备注","备注",false,false,true);
		
		/**
		 * 是否有效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","是否有效","是否有效",false,false,false);
		
		/**
		 * 原属性ID
		*/
		public static final DBField SOURCE_ID = new DBField(DBDataType.STRING , "source_id","sourceId","原属性ID","原属性ID",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public PCM_CATALOG_ATTRIBUTE() {
			this.init($NAME,"分类属性表" , ID , CATALOG_ID , FIELD , NOT_NULL , VERSION_NO , DATA_TYPE , LENGTH , ACCURACY , SCALE , SHORT_NAME , FULL_NAME , HINT , DETAIL , NOTE , VALID , SOURCE_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final PCM_CATALOG_ATTRIBUTE $TABLE=new PCM_CATALOG_ATTRIBUTE();
	}
	
	/**
	 * 区域表
	*/
	public static class SYS_AREA extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_area";
		
		/**
		 * 区域ID
		*/
		public static final DBField ID = new DBField(DBDataType.INTEGER , "id","id","区域ID","区域ID",true,false,false);
		
		/**
		 * 父级ID

		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.INTEGER , "parent_id","parentId","父级ID","父级ID",false,false,false);
		
		/**
		 * 区域名称
↵
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","区域名称","↵",false,false,true);
		
		/**
		 * 等级（深度）
		*/
		public static final DBField DEPTH = new DBField(DBDataType.INTEGER , "depth","depth","等级（深度）","等级（深度）",false,false,false);
		
		/**
		 * 创建人id
		*/
		public static final DBField CREATED_BY = new DBField(DBDataType.LONG , "created_by","createdBy","创建人id","创建人id",false,false,true);
		
		/**
		 * 修改人id
		*/
		public static final DBField UPDATED_BY = new DBField(DBDataType.LONG , "updated_by","updatedBy","修改人id","修改人id",false,false,true);
		
		/**
		 * 创建时间

		*/
		public static final DBField CREATE_DATE = new DBField(DBDataType.TIMESTAME , "create_date","createDate","创建时间","创建时间",false,false,false);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_DATE = new DBField(DBDataType.TIMESTAME , "update_date","updateDate","修改时间","修改时间",false,false,false);
		
		/**
		 * 数据是否有效 （0：无效 1：有效）
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","数据是否有效","（0：无效 1：有效）",false,false,false);
		
		public SYS_AREA() {
			this.init($NAME,"区域表" , ID , PARENT_ID , NAME , DEPTH , CREATED_BY , UPDATED_BY , CREATE_DATE , UPDATE_DATE , VALID);
		}
		public static final SYS_AREA $TABLE=new SYS_AREA();
	}
	
	/**
	 * 业务角色表
	*/
	public static class SYS_BUSI_ROLE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_busi_role";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 所属组织ID
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.INTEGER , "org_id","orgId","所属组织ID","所属组织ID",false,false,true);
		
		/**
		 * 角色代码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","角色代码","角色代码",false,false,true);
		
		/**
		 * 角色名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","角色名称","角色名称",false,false,true);
		
		/**
		 * 是否有效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","是否有效","是否有效",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_BUSI_ROLE() {
			this.init($NAME,"业务角色表" , ID , ORG_ID , CODE , NAME , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_BUSI_ROLE $TABLE=new SYS_BUSI_ROLE();
	}
	
	/**
	 * 业务角色成员关系表
	*/
	public static class SYS_BUSI_ROLE_MEMBER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_busi_role_member";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 角色ID
		*/
		public static final DBField ROLE_ID = new DBField(DBDataType.STRING , "role_id","roleId","角色ID","角色ID",false,false,true);
		
		/**
		 * 成员ID
		*/
		public static final DBField MEMBER_ID = new DBField(DBDataType.STRING , "member_id","memberId","成员ID","成员ID",false,false,true);
		
		/**
		 * 成员类型，UnifiedUserType枚举
		*/
		public static final DBField MEMBER_TYPE = new DBField(DBDataType.STRING , "member_type","memberType","成员类型","UnifiedUserType枚举",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		public SYS_BUSI_ROLE_MEMBER() {
			this.init($NAME,"业务角色成员关系表" , ID , ROLE_ID , MEMBER_ID , MEMBER_TYPE , CREATE_BY , CREATE_TIME);
		}
		public static final SYS_BUSI_ROLE_MEMBER $TABLE=new SYS_BUSI_ROLE_MEMBER();
	}
	
	/**
	 * 编码分配
	*/
	public static class SYS_CODE_ALLOCATION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_code_allocation";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","业务编码","业务编码",false,false,true);
		
		/**
		 * 规则ID
		*/
		public static final DBField RULE_ID = new DBField(DBDataType.STRING , "rule_id","ruleId","规则ID","规则ID",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		public SYS_CODE_ALLOCATION() {
			this.init($NAME,"编码分配" , ID , CODE , RULE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_CODE_ALLOCATION $TABLE=new SYS_CODE_ALLOCATION();
	}
	
	/**
	 * 编码属性
	*/
	public static class SYS_CODE_ATTR extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_code_attr";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","编码名称","编码名称",false,false,true);
		
		/**
		 * 编码类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","编码类型","编码类型",false,false,true);
		
		/**
		 * 占位符
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","占位符","占位符",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		public SYS_CODE_ATTR() {
			this.init($NAME,"编码属性" , ID , NAME , TYPE , CODE , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_CODE_ATTR $TABLE=new SYS_CODE_ATTR();
	}
	
	/**
	 * 代码生成示例主表
	*/
	public static class SYS_CODE_EXAMPLE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_code_example";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 单行文本
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","单行文本","单行文本",false,false,true);
		
		/**
		 * 多行文本
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","多行文本","多行文本",false,false,true);
		
		/**
		 * 图片上传
		*/
		public static final DBField IMAGE_ID = new DBField(DBDataType.STRING , "image_id","imageId","图片上传","图片上传",false,false,true);
		
		/**
		 * 多文件上传
		*/
		public static final DBField FILE_IDS = new DBField(DBDataType.STRING , "file_ids","fileIds","多文件上传","多文件上传",false,false,true);
		
		/**
		 * 整数输入
		*/
		public static final DBField AREA = new DBField(DBDataType.INTEGER , "area","area","整数输入","整数输入",false,false,true);
		
		/**
		 * 小数输入
		*/
		public static final DBField WEIGHT = new DBField(DBDataType.DOUBLE , "weight","weight","小数输入","小数输入",false,false,true);
		
		/**
		 * 逻辑值
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","逻辑值","逻辑值",false,false,true);
		
		/**
		 * 对话框
		*/
		public static final DBField BUTTON_INPUT = new DBField(DBDataType.STRING , "button_input","buttonInput","对话框","对话框",false,false,true);
		
		/**
		 * 单选框(枚举)
		*/
		public static final DBField RADIO_ENUM = new DBField(DBDataType.STRING , "radio_enum","radioEnum","单选框(枚举)","单选框(枚举)",false,false,true);
		
		/**
		 * 单选框(字典)
		*/
		public static final DBField RADIO_DICT = new DBField(DBDataType.STRING , "radio_dict","radioDict","单选框(字典)","单选框(字典)",false,false,true);
		
		/**
		 * 复选框(枚举)
		*/
		public static final DBField CHECK_ENUM = new DBField(DBDataType.STRING , "check_enum","checkEnum","复选框(枚举)","复选框(枚举)",false,false,true);
		
		/**
		 * 复选框(字典)
		*/
		public static final DBField CHECK_DICT = new DBField(DBDataType.STRING , "check_dict","checkDict","复选框(字典)","复选框(字典)",false,false,true);
		
		/**
		 * 选择框(枚举)
		*/
		public static final DBField SELECT_ENUM = new DBField(DBDataType.STRING , "select_enum","selectEnum","选择框(枚举)","选择框(枚举)",false,false,true);
		
		/**
		 * 选择框(字典)
		*/
		public static final DBField SELECT_DICT = new DBField(DBDataType.STRING , "select_dict","selectDict","选择框(字典)","选择框(字典)",false,false,true);
		
		/**
		 * 选择框(查询)
		*/
		public static final DBField RESOURCE_ID = new DBField(DBDataType.STRING , "resource_id","resourceId","选择框(查询)","选择框(查询)",false,false,true);
		
		/**
		 * 日期
		*/
		public static final DBField BIRTHDAY = new DBField(DBDataType.DATE , "birthday","birthday","日期","日期",false,false,true);
		
		/**
		 * 工作时间
		*/
		public static final DBField WORK_TIME = new DBField(DBDataType.DATE , "work_time","workTime","工作时间","工作时间",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_CODE_EXAMPLE() {
			this.init($NAME,"代码生成示例主表" , ID , NAME , NOTES , IMAGE_ID , FILE_IDS , AREA , WEIGHT , VALID , BUTTON_INPUT , RADIO_ENUM , RADIO_DICT , CHECK_ENUM , CHECK_DICT , SELECT_ENUM , SELECT_DICT , RESOURCE_ID , BIRTHDAY , WORK_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_CODE_EXAMPLE $TABLE=new SYS_CODE_EXAMPLE();
	}
	
	/**
	 * 代码生成拥有的车辆
	*/
	public static class SYS_CODE_EXAMPLE_CAR extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_code_example_car";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 属主ID
		*/
		public static final DBField EXAMPLE_ID = new DBField(DBDataType.STRING , "example_id","exampleId","属主ID","属主ID",false,false,true);
		
		/**
		 * 车牌号
		*/
		public static final DBField PLATE_NUMBER = new DBField(DBDataType.STRING , "plate_number","plateNumber","车牌号","车牌号",false,false,true);
		
		/**
		 * 颜色
		*/
		public static final DBField COLOR = new DBField(DBDataType.STRING , "color","color","颜色","颜色",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 岗位单选
		*/
		public static final DBField POSITION_ID = new DBField(DBDataType.STRING , "position_id","positionId","岗位单选","岗位单选",false,false,true);
		
		/**
		 * 组织单选
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.STRING , "org_id","orgId","组织单选","组织单选",false,false,true);
		
		/**
		 * 员工单选
		*/
		public static final DBField EMP_ID = new DBField(DBDataType.STRING , "emp_id","empId","员工单选","员工单选",false,false,true);
		
		/**
		 * 岗位多选
		*/
		public static final DBField POSITION_IDS = new DBField(DBDataType.STRING , "position_ids","positionIds","岗位多选","岗位多选",false,false,true);
		
		/**
		 * 组织多选
		*/
		public static final DBField ORG_IDS = new DBField(DBDataType.STRING , "org_ids","orgIds","组织多选","组织多选",false,false,true);
		
		/**
		 * 员工多选
		*/
		public static final DBField EMP_IDS = new DBField(DBDataType.STRING , "emp_ids","empIds","员工多选","员工多选",false,false,true);
		
		/**
		 * 员工下拉
		*/
		public static final DBField SELECT_EMP_ID = new DBField(DBDataType.STRING , "select_emp_id","selectEmpId","员工下拉","员工下拉",false,false,true);
		
		/**
		 * 公司单选
		*/
		public static final DBField COM_ID = new DBField(DBDataType.STRING , "com_id","comId","公司单选","公司单选",false,false,true);
		
		/**
		 * 部门多选
		*/
		public static final DBField DEPT_IDS = new DBField(DBDataType.STRING , "dept_ids","deptIds","部门多选","部门多选",false,false,true);
		
		/**
		 * 限定上级
		*/
		public static final DBField SUB_ORG_ID = new DBField(DBDataType.STRING , "sub_org_id","subOrgId","限定上级","限定上级",false,false,true);
		
		public SYS_CODE_EXAMPLE_CAR() {
			this.init($NAME,"代码生成拥有的车辆" , ID , EXAMPLE_ID , PLATE_NUMBER , COLOR , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , POSITION_ID , ORG_ID , EMP_ID , POSITION_IDS , ORG_IDS , EMP_IDS , SELECT_EMP_ID , COM_ID , DEPT_IDS , SUB_ORG_ID);
		}
		public static final SYS_CODE_EXAMPLE_CAR $TABLE=new SYS_CODE_EXAMPLE_CAR();
	}
	
	/**
	 * 代码示例主表角色关系表
	*/
	public static class SYS_CODE_EXAMPLE_ROLE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_code_example_role";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 属主ID
		*/
		public static final DBField EXAMPLE_ID = new DBField(DBDataType.STRING , "example_id","exampleId","属主ID","属主ID",false,false,true);
		
		/**
		 * 角色ID
		*/
		public static final DBField ROLE_ID = new DBField(DBDataType.STRING , "role_id","roleId","角色ID","角色ID",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_CODE_EXAMPLE_ROLE() {
			this.init($NAME,"代码示例主表角色关系表" , ID , EXAMPLE_ID , ROLE_ID , VERSION);
		}
		public static final SYS_CODE_EXAMPLE_ROLE $TABLE=new SYS_CODE_EXAMPLE_ROLE();
	}
	
	/**
	 * 代码生成主表学生
	*/
	public static class SYS_CODE_EXAMPLE_STUDENT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_code_example_student";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 属主ID
		*/
		public static final DBField EXAMPLE_ID = new DBField(DBDataType.STRING , "example_id","exampleId","属主ID","属主ID",false,false,true);
		
		/**
		 * 学生姓名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","学生姓名","学生姓名",false,false,true);
		
		/**
		 * 年龄
		*/
		public static final DBField AGE = new DBField(DBDataType.STRING , "age","age","年龄","年龄",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		public SYS_CODE_EXAMPLE_STUDENT() {
			this.init($NAME,"代码生成主表学生" , ID , EXAMPLE_ID , NAME , AGE , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME);
		}
		public static final SYS_CODE_EXAMPLE_STUDENT $TABLE=new SYS_CODE_EXAMPLE_STUDENT();
	}
	
	/**
	 * 业务编码
	*/
	public static class SYS_CODE_REGISTER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_code_register";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","业务编码","业务编码",false,false,true);
		
		/**
		 * 编码类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","编码类型","编码类型",false,false,true);
		
		/**
		 * 业务名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","业务名称","业务名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public SYS_CODE_REGISTER() {
			this.init($NAME,"业务编码" , ID , CODE , TYPE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final SYS_CODE_REGISTER $TABLE=new SYS_CODE_REGISTER();
	}
	
	/**
	 * 编码规则
	*/
	public static class SYS_CODE_RULE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_code_rule";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","编码名称","编码名称",false,false,true);
		
		/**
		 * 业务模块
		*/
		public static final DBField MODULE_ID = new DBField(DBDataType.STRING , "module_id","moduleId","业务模块","业务模块",false,false,true);
		
		/**
		 * 编码规则
		*/
		public static final DBField RULE = new DBField(DBDataType.STRING , "rule","rule","编码规则","编码规则",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		public SYS_CODE_RULE() {
			this.init($NAME,"编码规则" , ID , NAME , MODULE_ID , RULE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_CODE_RULE $TABLE=new SYS_CODE_RULE();
	}
	
	/**
	 * 系统配置表
	*/
	public static class SYS_CONFIG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_config";
		
		/**
		 * 配置键
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","配置键","配置键",true,false,false);
		
		/**
		 * 配置名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","配置名","配置名",false,false,true);
		
		/**
		 * 数据类型，由开发人员在库中指定，包括 String,Integer,DateTime,Double,Enum,Dict
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","数据类型","由开发人员在库中指定，包括 String,Integer,DateTime,Double,Enum,Dict",false,false,true);
		
		/**
		 * 类型描述
		*/
		public static final DBField TYPE_DESC = new DBField(DBDataType.STRING , "type_desc","typeDesc","类型描述","类型描述",false,false,true);
		
		/**
		 * 配置值
		*/
		public static final DBField VALUE = new DBField(DBDataType.STRING , "value","value","配置值","配置值",false,false,true);
		
		/**
		 * 是否生效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","是否生效","是否生效",false,false,false);
		
		/**
		 * 说明
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","说明","说明",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_CONFIG() {
			this.init($NAME,"系统配置表" , CODE , NAME , TYPE , TYPE_DESC , VALUE , VALID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_CONFIG $TABLE=new SYS_CONFIG();
	}
	
	/**
	 * 数据库缓存表，内存表
	*/
	public static class SYS_DB_CACHE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_db_cache";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 数据分类
		*/
		public static final DBField CATALOG = new DBField(DBDataType.STRING , "catalog","catalog","数据分类","数据分类",false,false,true);
		
		/**
		 * 数据分区
		*/
		public static final DBField AREA = new DBField(DBDataType.STRING , "area","area","数据分区","数据分区",false,false,true);
		
		/**
		 * 所有者类型
		*/
		public static final DBField OWNER_TYPE = new DBField(DBDataType.STRING , "owner_type","ownerType","所有者类型","所有者类型",false,false,true);
		
		/**
		 * 所有者ID
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","所有者ID","所有者ID",false,false,true);
		
		/**
		 * 数据
		*/
		public static final DBField VALUE = new DBField(DBDataType.STRING , "value","value","数据","数据",false,false,true);
		
		/**
		 * 过期时间
		*/
		public static final DBField EXPIRE_TIME = new DBField(DBDataType.DATE , "expire_time","expireTime","过期时间","过期时间",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_DB_CACHE() {
			this.init($NAME,"数据库缓存表，内存表" , ID , CATALOG , AREA , OWNER_TYPE , OWNER_ID , VALUE , EXPIRE_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_DB_CACHE $TABLE=new SYS_DB_CACHE();
	}
	
	/**
	 * 数据字典
	*/
	public static class SYS_DICT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_dict";
		
		/**
		 * 字典ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","字典ID","字典ID",true,false,false);
		
		/**
		 * 是否树形结构
		*/
		public static final DBField IS_TREE = new DBField(DBDataType.INTEGER , "is_tree","isTree","是否树形结构","是否树形结构",false,false,false);
		
		/**
		 * 字典名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","字典名称","字典名称",false,false,true);
		
		/**
		 * 字典代码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","字典代码","字典代码",false,false,true);
		
		/**
		 * 所属模块
		*/
		public static final DBField MODULE = new DBField(DBDataType.STRING , "module","module","所属模块","所属模块",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_DICT() {
			this.init($NAME,"数据字典" , ID , IS_TREE , NAME , CODE , MODULE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_DICT $TABLE=new SYS_DICT();
	}
	
	/**
	 * 数据字典条目
	*/
	public static class SYS_DICT_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_dict_item";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 字典ID
		*/
		public static final DBField DICT_ID = new DBField(DBDataType.STRING , "dict_id","dictId","字典ID","字典ID",false,false,true);
		
		/**
		 * 字典代码
		*/
		public static final DBField DICT_CODE = new DBField(DBDataType.STRING , "dict_code","dictCode","字典代码","字典代码",false,false,false);
		
		/**
		 * 上级条目ID
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","上级条目ID","上级条目ID",false,false,true);
		
		/**
		 * 代码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","代码","代码",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","标签","标签",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_DICT_ITEM() {
			this.init($NAME,"数据字典条目" , ID , DICT_ID , DICT_CODE , PARENT_ID , CODE , LABEL , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_DICT_ITEM $TABLE=new SYS_DICT_ITEM();
	}
	
	/**
	 * 系统文件
	*/
	public static class SYS_FILE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_file";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 文件名
		*/
		public static final DBField FILE_NAME = new DBField(DBDataType.STRING , "file_name","fileName","文件名","文件名",false,false,true);
		
		/**
		 * 存储位置
		*/
		public static final DBField LOCATION = new DBField(DBDataType.STRING , "location","location","存储位置","存储位置",false,false,true);
		
		/**
		 * 文件大小，单位KB
		*/
		public static final DBField SIZE = new DBField(DBDataType.LONG , "size","size","文件大小","单位KB",false,false,true);
		
		/**
		 * 媒体类型
		*/
		public static final DBField MEDIA_TYPE = new DBField(DBDataType.STRING , "media_type","mediaType","媒体类型","媒体类型",false,false,true);
		
		/**
		 * 文件类型，存放文件扩展名
		*/
		public static final DBField FILE_TYPE = new DBField(DBDataType.STRING , "file_type","fileType","文件类型","存放文件扩展名",false,false,true);
		
		/**
		 * 可直接下载的地址
		*/
		public static final DBField DOWNLOAD_URL = new DBField(DBDataType.STRING , "download_url","downloadUrl","可直接下载的地址","可直接下载的地址",false,false,true);
		
		/**
		 * 最后访问时间
		*/
		public static final DBField LATEST_VISIT_TIME = new DBField(DBDataType.DATE , "latest_visit_time","latestVisitTime","最后访问时间","最后访问时间",false,false,true);
		
		/**
		 * 下载次数
		*/
		public static final DBField DOWNLOADS = new DBField(DBDataType.INTEGER , "downloads","downloads","下载次数","下载次数",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_FILE() {
			this.init($NAME,"系统文件" , ID , FILE_NAME , LOCATION , SIZE , MEDIA_TYPE , FILE_TYPE , DOWNLOAD_URL , LATEST_VISIT_TIME , DOWNLOADS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_FILE $TABLE=new SYS_FILE();
	}
	
	/**
	 * 调用统计日志
	*/
	public static class SYS_INVOKE_LOG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_invoke_log";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.LONG , "id","id","ID","ID",true,true,false);
		
		/**
		 * 应用名称
		*/
		public static final DBField APPLICATION = new DBField(DBDataType.STRING , "application","application","应用名称","应用名称",false,false,true);
		
		/**
		 * 主机名称
		*/
		public static final DBField HOST_NAME = new DBField(DBDataType.STRING , "host_name","hostName","主机名称","主机名称",false,false,true);
		
		/**
		 * 请求的URI
		*/
		public static final DBField URI = new DBField(DBDataType.STRING , "uri","uri","请求的URI","请求的URI",false,false,true);
		
		/**
		 * UserAgent
		*/
		public static final DBField USER_AGENT = new DBField(DBDataType.STRING , "user_agent","userAgent","UserAgent","UserAgent",false,false,true);
		
		/**
		 * 客户端IP
		*/
		public static final DBField CLIENT_IP = new DBField(DBDataType.STRING , "client_ip","clientIp","客户端IP","客户端IP",false,false,true);
		
		/**
		 * token值
		*/
		public static final DBField TOKEN = new DBField(DBDataType.STRING , "token","token","token值","token值",false,false,true);
		
		/**
		 * 会话ID
		*/
		public static final DBField SESSION_ID = new DBField(DBDataType.STRING , "session_id","sessionId","会话ID","会话ID",false,false,true);
		
		/**
		 * 用户ID
		*/
		public static final DBField USER_ID = new DBField(DBDataType.LONG , "user_id","userId","用户ID","用户ID",false,false,true);
		
		/**
		 * 用户姓名
		*/
		public static final DBField USER_NAME = new DBField(DBDataType.STRING , "user_name","userName","用户姓名","用户姓名",false,false,true);
		
		/**
		 * 日志跟踪ID
		*/
		public static final DBField TID = new DBField(DBDataType.STRING , "tid","tid","日志跟踪ID","日志跟踪ID",false,false,true);
		
		/**
		 * 请求参数
		*/
		public static final DBField PARAMETER = new DBField(DBDataType.STRING , "parameter","parameter","请求参数","请求参数",false,false,true);
		
		/**
		 * 响应数据
		*/
		public static final DBField RESPONSE = new DBField(DBDataType.STRING , "response","response","响应数据","响应数据",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField START_TIME = new DBField(DBDataType.TIMESTAME , "start_time","startTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField END_TIME = new DBField(DBDataType.TIMESTAME , "end_time","endTime","结束时间","结束时间",false,false,true);
		
		/**
		 * 异常信息
		*/
		public static final DBField EXCEPTION = new DBField(DBDataType.STRING , "exception","exception","异常信息","异常信息",false,false,true);
		
		public SYS_INVOKE_LOG() {
			this.init($NAME,"调用统计日志" , ID , APPLICATION , HOST_NAME , URI , USER_AGENT , CLIENT_IP , TOKEN , SESSION_ID , USER_ID , USER_NAME , TID , PARAMETER , RESPONSE , START_TIME , END_TIME , EXCEPTION);
		}
		public static final SYS_INVOKE_LOG $TABLE=new SYS_INVOKE_LOG();
	}
	
	/**
	 * 语言条目表
	*/
	public static class SYS_LANG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_lang";
		
		/**
		 * 编码键
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码键","编码键",true,false,false);
		
		/**
		 * 默认
		*/
		public static final DBField DEFAULTS = new DBField(DBDataType.STRING , "defaults","defaults","默认","默认",false,false,true);
		
		/**
		 * 简体中文(大陆)
		*/
		public static final DBField ZH_CH = new DBField(DBDataType.STRING , "zh_ch","zhCh","简体中文(大陆)","简体中文(大陆)",false,false,true);
		
		/**
		 * 繁体中文(台湾)
		*/
		public static final DBField ZH_TW = new DBField(DBDataType.STRING , "zh_tw","zhTw","繁体中文(台湾)","繁体中文(台湾)",false,false,true);
		
		/**
		 * 英文美国
		*/
		public static final DBField EN_US = new DBField(DBDataType.STRING , "en_us","enUs","英文美国","英文美国",false,false,true);
		
		/**
		 * 英文英国
		*/
		public static final DBField EN_UK = new DBField(DBDataType.STRING , "en_uk","enUk","英文英国","英文英国",false,false,true);
		
		/**
		 * 混淆专用
		*/
		public static final DBField CONFUSE = new DBField(DBDataType.STRING , "confuse","confuse","混淆专用","混淆专用",false,false,true);
		
		/**
		 * 是否有效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","是否有效","是否有效",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_LANG() {
			this.init($NAME,"语言条目表" , CODE , DEFAULTS , ZH_CH , ZH_TW , EN_US , EN_UK , CONFUSE , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_LANG $TABLE=new SYS_LANG();
	}
	
	/**
	 * 菜单表
	*/
	public static class SYS_MENU extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_menu";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 批次号，自动生成时的批次号
		*/
		public static final DBField BATCH_ID = new DBField(DBDataType.STRING , "batch_id","batchId","批次号","自动生成时的批次号",false,false,true);
		
		/**
		 * 权限，权限标识
		*/
		public static final DBField AUTHORITY = new DBField(DBDataType.STRING , "authority","authority","权限","权限标识",false,false,true);
		
		/**
		 * 是否隐藏
		*/
		public static final DBField HIDDEN = new DBField(DBDataType.INTEGER , "hidden","hidden","是否隐藏","是否隐藏",false,false,false);
		
		/**
		 * 样式
		*/
		public static final DBField CSS = new DBField(DBDataType.STRING , "css","css","样式","样式",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","标签","标签",false,false,true);
		
		/**
		 * 菜单类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","菜单类型","菜单类型",false,false,true);
		
		/**
		 * 菜单路径的资源
		*/
		public static final DBField PATH_RESOURCE_ID = new DBField(DBDataType.STRING , "path_resource_id","pathResourceId","菜单路径的资源","菜单路径的资源",false,false,true);
		
		/**
		 * 路由地址
		*/
		public static final DBField URL = new DBField(DBDataType.STRING , "url","url","路由地址","路由地址",false,false,true);
		
		/**
		 * 页面参数
		*/
		public static final DBField PARAMS = new DBField(DBDataType.STRING , "params","params","页面参数","页面参数",false,false,true);
		
		/**
		 * 上级ID
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","上级ID","上级ID",false,false,true);
		
		/**
		 * 动态控制类
		*/
		public static final DBField DYNAMIC_HANDLER = new DBField(DBDataType.STRING , "dynamic_handler","dynamicHandler","动态控制类","动态控制类",false,false,true);
		
		/**
		 * 层级路径
		*/
		public static final DBField HIERARCHY = new DBField(DBDataType.STRING , "hierarchy","hierarchy","层级路径","层级路径",false,false,true);
		
		/**
		 * 显示顺序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","显示顺序","显示顺序",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_MENU() {
			this.init($NAME,"菜单表" , ID , BATCH_ID , AUTHORITY , HIDDEN , CSS , LABEL , TYPE , PATH_RESOURCE_ID , URL , PARAMS , PARENT_ID , DYNAMIC_HANDLER , HIERARCHY , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_MENU $TABLE=new SYS_MENU();
	}
	
	/**
	 * 菜单资源关系表
	*/
	public static class SYS_MENU_RESOURCE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_menu_resource";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 菜单ID
		*/
		public static final DBField MENU_ID = new DBField(DBDataType.STRING , "menu_id","menuId","菜单ID","菜单ID",false,false,true);
		
		/**
		 * 资源ID
		*/
		public static final DBField RESOURCE_ID = new DBField(DBDataType.STRING , "resource_id","resourceId","资源ID","资源ID",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_MENU_RESOURCE() {
			this.init($NAME,"菜单资源关系表" , ID , MENU_ID , RESOURCE_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_MENU_RESOURCE $TABLE=new SYS_MENU_RESOURCE();
	}
	
	/**
	 * 系统节点表
	*/
	public static class SYS_NODE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_node";
		
		/**
		 * 实例id
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","实例id","实例id",true,false,false);
		
		/**
		 * 主机ID
		*/
		public static final DBField HOST_ID = new DBField(DBDataType.STRING , "host_id","hostId","主机ID","主机ID",false,false,true);
		
		/**
		 * 应用名称
		*/
		public static final DBField APPLICATION_NAME = new DBField(DBDataType.STRING , "application_name","applicationName","应用名称","应用名称",false,false,true);
		
		/**
		 * 端口
		*/
		public static final DBField PORT = new DBField(DBDataType.INTEGER , "port","port","端口","端口",false,false,true);
		
		/**
		 * 进程号
		*/
		public static final DBField PROCESS_ID = new DBField(DBDataType.STRING , "process_id","processId","进程号","进程号",false,false,true);
		
		/**
		 * 启动时间
		*/
		public static final DBField START_TIME = new DBField(DBDataType.DATE , "start_time","startTime","启动时间","启动时间",false,false,true);
		
		/**
		 * 是否启动
		*/
		public static final DBField IS_UP = new DBField(DBDataType.INTEGER , "is_up","isUp","是否启动","是否启动",false,false,true);
		
		/**
		 * 心跳时间
		*/
		public static final DBField HEART_BEAT_TIME = new DBField(DBDataType.DATE , "heart_beat_time","heartBeatTime","心跳时间","心跳时间",false,false,true);
		
		/**
		 * 主机名称
		*/
		public static final DBField HOST_NAME = new DBField(DBDataType.STRING , "host_name","hostName","主机名称","主机名称",false,false,true);
		
		/**
		 * IP地址
		*/
		public static final DBField IP = new DBField(DBDataType.STRING , "ip","ip","IP地址","IP地址",false,false,true);
		
		/**
		 * 雪花DCId
		*/
		public static final DBField DATACENTER_ID = new DBField(DBDataType.INTEGER , "datacenter_id","datacenterId","雪花DCId","雪花DCId",false,false,true);
		
		/**
		 * 雪花WKId
		*/
		public static final DBField WORKER_ID = new DBField(DBDataType.INTEGER , "worker_id","workerId","雪花WKId","雪花WKId",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_NODE() {
			this.init($NAME,"系统节点表" , ID , HOST_ID , APPLICATION_NAME , PORT , PROCESS_ID , START_TIME , IS_UP , HEART_BEAT_TIME , HOST_NAME , IP , DATACENTER_ID , WORKER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_NODE $TABLE=new SYS_NODE();
	}
	
	/**
	 * 认证客户端
	*/
	public static class SYS_OAUTH_CLIENT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_oauth_client";
		
		/**
		 * 客户端标识
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","客户端标识","客户端标识",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 资源集合，用逗号隔开
		*/
		public static final DBField RESOURCE_IDS = new DBField(DBDataType.STRING , "resource_ids","resourceIds","资源集合","用逗号隔开",false,false,true);
		
		/**
		 * 访问密匙
		*/
		public static final DBField CLIENT_SECRET = new DBField(DBDataType.STRING , "client_secret","clientSecret","访问密匙","访问密匙",false,false,true);
		
		/**
		 * 权限范围
		*/
		public static final DBField SCOPE = new DBField(DBDataType.STRING , "scope","scope","权限范围","权限范围",false,false,true);
		
		/**
		 * 授权类型
		*/
		public static final DBField AUTHORIZED_GRANT_TYPES = new DBField(DBDataType.STRING , "authorized_grant_types","authorizedGrantTypes","授权类型","授权类型",false,false,true);
		
		/**
		 * 重定向URI
		*/
		public static final DBField WEB_SERVER_REDIRECT_URI = new DBField(DBDataType.STRING , "web_server_redirect_uri","webServerRedirectUri","重定向URI","重定向URI",false,false,true);
		
		/**
		 * 权限值列表
		*/
		public static final DBField AUTHORITIES = new DBField(DBDataType.STRING , "authorities","authorities","权限值列表","权限值列表",false,false,true);
		
		/**
		 * access_token时长(秒)
		*/
		public static final DBField ACCESS_TOKEN_VALIDITY = new DBField(DBDataType.INTEGER , "access_token_validity","accessTokenValidity","access","token时长(秒)",false,false,true);
		
		/**
		 * refresh_token时长(秒)
		*/
		public static final DBField REFRESH_TOKEN_VALIDITY = new DBField(DBDataType.INTEGER , "refresh_token_validity","refreshTokenValidity","refresh","token时长(秒)",false,false,true);
		
		/**
		 * 备注信息
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注信息","备注信息",false,false,true);
		
		/**
		 * 是否有效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","是否有效","是否有效",false,false,true);
		
		/**
		 * 是否自动Approval操作
		*/
		public static final DBField AUTO_APPROVE = new DBField(DBDataType.INTEGER , "auto_approve","autoApprove","是否自动Approval操作","是否自动Approval操作",false,false,true);
		
		/**
		 * 是否信任
		*/
		public static final DBField TRUSTED = new DBField(DBDataType.INTEGER , "trusted","trusted","是否信任","是否信任",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_OAUTH_CLIENT() {
			this.init($NAME,"认证客户端" , ID , NAME , RESOURCE_IDS , CLIENT_SECRET , SCOPE , AUTHORIZED_GRANT_TYPES , WEB_SERVER_REDIRECT_URI , AUTHORITIES , ACCESS_TOKEN_VALIDITY , REFRESH_TOKEN_VALIDITY , NOTES , VALID , AUTO_APPROVE , TRUSTED , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_OAUTH_CLIENT $TABLE=new SYS_OAUTH_CLIENT();
	}
	
	/**
	 * 系统资源
	*/
	public static class SYS_RESOURZE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_resourze";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 类型，api/page
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","api/page",false,false,false);
		
		/**
		 * 访问控制类型
		*/
		public static final DBField ACCESS_TYPE = new DBField(DBDataType.STRING , "access_type","accessType","访问控制类型","访问控制类型",false,false,true);
		
		/**
		 * 地址
		*/
		public static final DBField URL = new DBField(DBDataType.STRING , "url","url","地址","地址",false,false,false);
		
		/**
		 * HttpMethod
		*/
		public static final DBField METHOD = new DBField(DBDataType.STRING , "method","method","HttpMethod","HttpMethod",false,false,false);
		
		/**
		 * 批次号
		*/
		public static final DBField BATCH_ID = new DBField(DBDataType.STRING , "batch_id","batchId","批次号","批次号",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 来源表
		*/
		public static final DBField TABLE_NAME = new DBField(DBDataType.STRING , "table_name","tableName","来源表","来源表",false,false,true);
		
		/**
		 * 来源模块
		*/
		public static final DBField MODULE = new DBField(DBDataType.STRING , "module","module","来源模块","来源模块",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_RESOURZE() {
			this.init($NAME,"系统资源" , ID , NAME , TYPE , ACCESS_TYPE , URL , METHOD , BATCH_ID , CREATE_BY , TABLE_NAME , MODULE , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_RESOURZE $TABLE=new SYS_RESOURZE();
	}
	
	/**
	 * 角色表
	*/
	public static class SYS_ROLE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_role";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 代码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","代码","代码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_ROLE() {
			this.init($NAME,"角色表" , ID , CODE , NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_ROLE $TABLE=new SYS_ROLE();
	}
	
	/**
	 * 角色账户关系表
	*/
	public static class SYS_ROLE_MENU extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_role_menu";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","id","id",true,false,false);
		
		/**
		 * 角色ID
		*/
		public static final DBField ROLE_ID = new DBField(DBDataType.STRING , "role_id","roleId","角色ID","角色ID",false,false,true);
		
		/**
		 * 菜单ID
		*/
		public static final DBField MENU_ID = new DBField(DBDataType.STRING , "menu_id","menuId","菜单ID","菜单ID",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_ROLE_MENU() {
			this.init($NAME,"角色账户关系表" , ID , ROLE_ID , MENU_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_ROLE_MENU $TABLE=new SYS_ROLE_MENU();
	}
	
	/**
	 * 角色账户关系表
	*/
	public static class SYS_ROLE_USER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_role_user";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","id","id",true,false,false);
		
		/**
		 * 角色ID
		*/
		public static final DBField ROLE_ID = new DBField(DBDataType.STRING , "role_id","roleId","角色ID","角色ID",false,false,true);
		
		/**
		 * 账户ID
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","账户ID","账户ID",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_ROLE_USER() {
			this.init($NAME,"角色账户关系表" , ID , ROLE_ID , USER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_ROLE_USER $TABLE=new SYS_ROLE_USER();
	}
	
	/**
	 * 序列表
	*/
	public static class SYS_SEQUENCE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_sequence";
		
		/**
		 * 主键
		*/
		public static final DBField PK = new DBField(DBDataType.STRING , "pk","pk","主键","主键",true,false,false);
		
		/**
		 * 序列ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","序列ID","序列ID",false,false,false);
		
		/**
		 * 序列名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","序列名称","序列名称",false,false,true);
		
		/**
		 * 编码长度
		*/
		public static final DBField LENGTH = new DBField(DBDataType.INTEGER , "length","length","编码长度","编码长度",false,false,true);
		
		/**
		 * 编码分类
		*/
		public static final DBField CATALOG = new DBField(DBDataType.STRING , "catalog","catalog","编码分类","编码分类",false,false,true);
		
		/**
		 * 当前数值
		*/
		public static final DBField VALUE = new DBField(DBDataType.LONG , "value","value","当前数值","当前数值",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField MEMO = new DBField(DBDataType.STRING , "memo","memo","备注","备注",false,false,true);
		
		/**
		 * 编码类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","编码类型","编码类型",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,false);
		
		/**
		 * 每次取数的个数
		*/
		public static final DBField FETCH_SIZE = new DBField(DBDataType.INTEGER , "fetch_size","fetchSize","每次取数的个数","每次取数的个数",false,false,false);
		
		public SYS_SEQUENCE() {
			this.init($NAME,"序列表" , PK , ID , NAME , LENGTH , CATALOG , VALUE , MEMO , TYPE , TENANT_ID , FETCH_SIZE);
		}
		public static final SYS_SEQUENCE $TABLE=new SYS_SEQUENCE();
	}
	
	/**
	 * 在线会话表
	*/
	public static class SYS_SESSION_ONLINE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_session_online";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 会话ID
		*/
		public static final DBField SESSION_ID = new DBField(DBDataType.STRING , "session_id","sessionId","会话ID","会话ID",false,false,true);
		
		/**
		 * 账户ID
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","账户ID","账户ID",false,false,true);
		
		/**
		 * 登录时间
		*/
		public static final DBField LOGIN_TIME = new DBField(DBDataType.DATE , "login_time","loginTime","登录时间","登录时间",false,false,true);
		
		/**
		 * 最近一次交互时间
		*/
		public static final DBField INTERACT_TIME = new DBField(DBDataType.DATE , "interact_time","interactTime","最近一次交互时间","最近一次交互时间",false,false,true);
		
		/**
		 * 最后访问的地址
		*/
		public static final DBField INTERACT_URL = new DBField(DBDataType.STRING , "interact_url","interactUrl","最后访问的地址","最后访问的地址",false,false,true);
		
		/**
		 * 登出时间
		*/
		public static final DBField LOGOUT_TIME = new DBField(DBDataType.DATE , "logout_time","logoutTime","登出时间","登出时间",false,false,true);
		
		/**
		 * 会话时长，单位秒
		*/
		public static final DBField SESSION_TIME = new DBField(DBDataType.INTEGER , "session_time","sessionTime","会话时长","单位秒",false,false,true);
		
		/**
		 * 是否在线
		*/
		public static final DBField ONLINE = new DBField(DBDataType.INTEGER , "online","online","是否在线","是否在线",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 主机ID
		*/
		public static final DBField HOST_ID = new DBField(DBDataType.STRING , "host_id","hostId","主机ID","主机ID",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 节点实例ID
		*/
		public static final DBField NODE_ID = new DBField(DBDataType.STRING , "node_id","nodeId","节点实例ID","节点实例ID",false,false,true);
		
		public SYS_SESSION_ONLINE() {
			this.init($NAME,"在线会话表" , ID , SESSION_ID , USER_ID , LOGIN_TIME , INTERACT_TIME , INTERACT_URL , LOGOUT_TIME , SESSION_TIME , ONLINE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , HOST_ID , VERSION , NODE_ID);
		}
		public static final SYS_SESSION_ONLINE $TABLE=new SYS_SESSION_ONLINE();
	}
	
	/**
	 * 租户表
	*/
	public static class SYS_TENANT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_tenant";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 别名
		*/
		public static final DBField ALIAS = new DBField(DBDataType.STRING , "alias","alias","别名","别名",false,false,true);
		
		/**
		 * 是否有效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","是否有效","是否有效",false,false,true);
		
		/**
		 * 公司ID
		*/
		public static final DBField COMPANY_ID = new DBField(DBDataType.STRING , "company_id","companyId","公司ID","公司ID",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_TENANT() {
			this.init($NAME,"租户表" , ID , ALIAS , VALID , COMPANY_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_TENANT $TABLE=new SYS_TENANT();
	}
	
	/**
	 * Token表
	*/
	public static class SYS_TOKEN extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_token";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","id","id",true,false,false);
		
		/**
		 * 账户ID
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","账户ID","账户ID",false,false,true);
		
		/**
		 * Token标识
		*/
		public static final DBField JTI = new DBField(DBDataType.STRING , "jti","jti","Token标识","Token标识",false,false,true);
		
		/**
		 * 访问用Token
		*/
		public static final DBField ACCESS_TOKEN = new DBField(DBDataType.STRING , "access_token","accessToken","访问用Token","访问用Token",false,false,true);
		
		/**
		 * 刷新用Token
		*/
		public static final DBField REFRESH_TOKEN = new DBField(DBDataType.STRING , "refresh_token","refreshToken","刷新用Token","刷新用Token",false,false,true);
		
		/**
		 * 访问用Token过期时间
		*/
		public static final DBField ACCESS_TOKEN_EXPIRE_TIME = new DBField(DBDataType.DATE , "access_token_expire_time","accessTokenExpireTime","访问用Token过期时间","访问用Token过期时间",false,false,true);
		
		/**
		 * 访问用Token是否过期
		*/
		public static final DBField ACCESS_TOKEN_EXPIRED = new DBField(DBDataType.INTEGER , "access_token_expired","accessTokenExpired","访问用Token是否过期","访问用Token是否过期",false,false,false);
		
		/**
		 * 刷新用Token过期时间
		*/
		public static final DBField REFRESH_TOKEN_EXPIRE_TIME = new DBField(DBDataType.DATE , "refresh_token_expire_time","refreshTokenExpireTime","刷新用Token过期时间","刷新用Token过期时间",false,false,true);
		
		/**
		 * 刷新用Token是否过期
		*/
		public static final DBField REFRESH_TOKEN_EXPIRED = new DBField(DBDataType.INTEGER , "refresh_token_expired","refreshTokenExpired","刷新用Token是否过期","刷新用Token是否过期",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_TOKEN() {
			this.init($NAME,"Token表" , ID , USER_ID , JTI , ACCESS_TOKEN , REFRESH_TOKEN , ACCESS_TOKEN_EXPIRE_TIME , ACCESS_TOKEN_EXPIRED , REFRESH_TOKEN_EXPIRE_TIME , REFRESH_TOKEN_EXPIRED , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_TOKEN $TABLE=new SYS_TOKEN();
	}
	
	/**
	 * 模板文件
	*/
	public static class SYS_TPL_FILE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_tpl_file";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 模板类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","模板类型","模板类型",false,false,true);
		
		/**
		 * 业务编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","业务编码","业务编码",false,false,true);
		
		/**
		 * 模板文件类型
		*/
		public static final DBField TPL_FILE_TYPE = new DBField(DBDataType.STRING , "tpl_file_type","tplFileType","模板文件类型","模板文件类型",false,false,true);
		
		/**
		 * 文件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","文件","文件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public SYS_TPL_FILE() {
			this.init($NAME,"模板文件" , ID , NAME , TYPE , CODE , TPL_FILE_TYPE , FILE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final SYS_TPL_FILE $TABLE=new SYS_TPL_FILE();
	}
	
	/**
	 * 账户表
	*/
	public static class SYS_USER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_user";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 账户
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","账户","账户",false,false,true);
		
		/**
		 * 密码
		*/
		public static final DBField PASSWD = new DBField(DBDataType.STRING , "passwd","passwd","密码","密码",false,false,true);
		
		/**
		 * 手机号码
		*/
		public static final DBField PHONE = new DBField(DBDataType.STRING , "phone","phone","手机号码","手机号码",false,false,true);
		
		/**
		 * 头像ID
		*/
		public static final DBField PORTRAIT_ID = new DBField(DBDataType.STRING , "portrait_id","portraitId","头像ID","头像ID",false,false,true);
		
		/**
		 * 语言
		*/
		public static final DBField LANGUAGE = new DBField(DBDataType.STRING , "language","language","语言","语言",false,false,true);
		
		/**
		 * 是否有效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","是否有效","是否有效",false,false,false);
		
		/**
		 * 缓存键，改变这个值，可使浏览器重新请求静态资源
		*/
		public static final DBField CACHE_KEY = new DBField(DBDataType.STRING , "cache_key","cacheKey","缓存键","改变这个值，可使浏览器重新请求静态资源",false,false,true);
		
		/**
		 * 最后登录时间
		*/
		public static final DBField LAST_LOGIN_TIME = new DBField(DBDataType.DATE , "last_login_time","lastLoginTime","最后登录时间","最后登录时间",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_USER() {
			this.init($NAME,"账户表" , ID , NAME , PASSWD , PHONE , PORTRAIT_ID , LANGUAGE , VALID , CACHE_KEY , LAST_LOGIN_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_USER $TABLE=new SYS_USER();
	}
	
	/**
	 * 账户租户关系表
	*/
	public static class SYS_USER_TENANT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_user_tenant";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 用户ID
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","用户ID","用户ID",false,false,true);
		
		/**
		 * 所属的租户ID
		*/
		public static final DBField OWNER_TENANT_ID = new DBField(DBDataType.STRING , "owner_tenant_id","ownerTenantId","所属的租户ID","所属的租户ID",false,false,true);
		
		/**
		 * 是否有效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","是否有效","是否有效",false,false,true);
		
		/**
		 * 是否激活，激活时为当前默认租户
		*/
		public static final DBField ACTIVATED = new DBField(DBDataType.INTEGER , "activated","activated","是否激活","激活时为当前默认租户",false,false,true);
		
		/**
		 * 员工ID,账户在指定租户下的员工ID
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","员工ID","账户在指定租户下的员工ID",false,false,true);
		
		/**
		 * 顺序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","顺序","顺序",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_USER_TENANT() {
			this.init($NAME,"账户租户关系表" , ID , USER_ID , OWNER_TENANT_ID , VALID , ACTIVATED , EMPLOYEE_ID , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_USER_TENANT $TABLE=new SYS_USER_TENANT();
	}
}