package org.github.foxnic.web.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2023-04-20 04:11:36
 * @author 李方捷 , leefangjie@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class FoxnicWeb {
	
	/**
	 * 流程分类
	*/
	public static class BPM_CATALOG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_catalog";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * PC端图标
		*/
		public static final DBField ICON_FILE_PC = new DBField(DBDataType.STRING , "icon_file_pc","iconFilePc","PC端图标","PC端图标",false,false,true);
		
		/**
		 * 移动端图标
		*/
		public static final DBField ICON_FILE_MOBILE = new DBField(DBDataType.STRING , "icon_file_mobile","iconFileMobile","移动端图标","移动端图标",false,false,true);
		
		/**
		 * 序号
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","序号","序号",false,false,true);
		
		/**
		 * 生效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","生效","生效",false,false,true);
		
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
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,false);
		
		public BPM_CATALOG() {
			this.init($NAME,"流程分类" , ID , NAME , NOTES , ICON_FILE_PC , ICON_FILE_MOBILE , SORT , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final BPM_CATALOG $TABLE=new BPM_CATALOG();
	}
	
	/**
	 * 商务来案
	*/
	public static class BPM_DEMO_BUSINESS_CASE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_demo_business_case";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 案件情况
		*/
		public static final DBField FACT_NOTE = new DBField(DBDataType.STRING , "fact_note","factNote","案件情况","案件情况",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 已交底
		*/
		public static final DBField IS_GOT_BASE = new DBField(DBDataType.INTEGER , "is_got_base","isGotBase","已交底","已交底",false,false,true);
		
		public BPM_DEMO_BUSINESS_CASE() {
			this.init($NAME,"商务来案" , ID , FACT_NOTE , STATUS , IS_GOT_BASE);
		}
		public static final BPM_DEMO_BUSINESS_CASE $TABLE=new BPM_DEMO_BUSINESS_CASE();
	}
	
	/**
	 * 通用审批表单
	*/
	public static class BPM_DEMO_COMMON extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_demo_common";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 标题
		*/
		public static final DBField SUBJECT = new DBField(DBDataType.STRING , "subject","subject","标题","标题",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		public BPM_DEMO_COMMON() {
			this.init($NAME,"通用审批表单" , ID , SUBJECT , CONTENT , STATUS);
		}
		public static final BPM_DEMO_COMMON $TABLE=new BPM_DEMO_COMMON();
	}
	
	/**
	 * 请假流程示例表
	*/
	public static class BPM_DEMO_LEAVE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_demo_leave";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 请假类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","请假类型","请假类型",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField BEGIN_TIME = new DBField(DBDataType.DATE , "begin_time","beginTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField END_TIME = new DBField(DBDataType.DATE , "end_time","endTime","结束时间","结束时间",false,false,true);
		
		/**
		 * 请假事由
		*/
		public static final DBField REASON = new DBField(DBDataType.STRING , "reason","reason","请假事由","请假事由",false,false,true);
		
		/**
		 * 申请人，员工ID
		*/
		public static final DBField APPLICANT_ID = new DBField(DBDataType.STRING , "applicant_id","applicantId","申请人","员工ID",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		public BPM_DEMO_LEAVE() {
			this.init($NAME,"请假流程示例表" , ID , TYPE , BEGIN_TIME , END_TIME , REASON , APPLICANT_ID , STATUS);
		}
		public static final BPM_DEMO_LEAVE $TABLE=new BPM_DEMO_LEAVE();
	}
	
	/**
	 * 表单定义表
	*/
	public static class BPM_FORM_DEFINITION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_form_definition";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 表单代码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","表单代码","表单代码",false,false,false);
		
		/**
		 * 表单名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","表单名称","表单名称",false,false,true);
		
		/**
		 * 表单类型
		*/
		public static final DBField FORM_TYPE = new DBField(DBDataType.STRING , "form_type","formType","表单类型","表单类型",false,false,true);
		
		/**
		 * 起草页地址
		*/
		public static final DBField DRAFT_PAGE_URL = new DBField(DBDataType.STRING , "draft_page_url","draftPageUrl","起草页地址","起草页地址",false,false,true);
		
		/**
		 * 审批页地址
		*/
		public static final DBField APPROVAL_PAGE_URL = new DBField(DBDataType.STRING , "approval_page_url","approvalPageUrl","审批页地址","审批页地址",false,false,true);
		
		/**
		 * 生效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","生效","生效",false,false,true);
		
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
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,false);
		
		/**
		 * 回调控制器，完整类名
		*/
		public static final DBField CALLBACK_CONTROLLER = new DBField(DBDataType.STRING , "callback_controller","callbackController","回调控制器","完整类名",false,false,true);
		
		/**
		 * 是否可关联多个流程
		*/
		public static final DBField MULITI_PROCESS = new DBField(DBDataType.INTEGER , "muliti_process","mulitiProcess","是否可关联多个流程","是否可关联多个流程",false,false,false);
		
		/**
		 * 分类ID
		*/
		public static final DBField CATALOG_ID = new DBField(DBDataType.STRING , "catalog_id","catalogId","分类ID","分类ID",false,false,true);
		
		public BPM_FORM_DEFINITION() {
			this.init($NAME,"表单定义表" , ID , CODE , NAME , FORM_TYPE , DRAFT_PAGE_URL , APPROVAL_PAGE_URL , VALID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , CALLBACK_CONTROLLER , MULITI_PROCESS , CATALOG_ID);
		}
		public static final BPM_FORM_DEFINITION $TABLE=new BPM_FORM_DEFINITION();
	}
	
	/**
	 * 流程实例表单表
	*/
	public static class BPM_FORM_INSTANCE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_form_instance";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 流程定义ID
		*/
		public static final DBField PROCESS_DEFINITION_ID = new DBField(DBDataType.STRING , "process_definition_id","processDefinitionId","流程定义ID","流程定义ID",false,false,true);
		
		/**
		 * 流程实例ID
		*/
		public static final DBField PROCESS_INSTANCE_ID = new DBField(DBDataType.STRING , "process_instance_id","processInstanceId","流程实例ID","流程实例ID",false,false,true);
		
		/**
		 * 表单定义ID
		*/
		public static final DBField FORM_DEFINITION_ID = new DBField(DBDataType.STRING , "form_definition_id","formDefinitionId","表单定义ID","表单定义ID",false,false,true);
		
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
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,false);
		
		public BPM_FORM_INSTANCE() {
			this.init($NAME,"流程实例表单表" , ID , PROCESS_DEFINITION_ID , PROCESS_INSTANCE_ID , FORM_DEFINITION_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final BPM_FORM_INSTANCE $TABLE=new BPM_FORM_INSTANCE();
	}
	
	/**
	 * 流程单据表
	*/
	public static class BPM_FORM_INSTANCE_BILL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_form_instance_bill";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 表单实例ID
		*/
		public static final DBField FORM_INSTANCE_ID = new DBField(DBDataType.STRING , "form_instance_id","formInstanceId","表单实例ID","表单实例ID",false,false,true);
		
		/**
		 * 业务单据号
		*/
		public static final DBField BILL_ID = new DBField(DBDataType.STRING , "bill_id","billId","业务单据号","业务单据号",false,false,false);
		
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
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,false);
		
		public BPM_FORM_INSTANCE_BILL() {
			this.init($NAME,"流程单据表" , ID , FORM_INSTANCE_ID , BILL_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final BPM_FORM_INSTANCE_BILL $TABLE=new BPM_FORM_INSTANCE_BILL();
	}
	
	/**
	 * 流程定义表
	*/
	public static class BPM_PROCESS_DEFINITION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_process_definition";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 流程代码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","流程代码","流程代码",false,false,false);
		
		/**
		 * 关联表单，表单定义ID
		*/
		public static final DBField FORM_DEFINITION_ID = new DBField(DBDataType.STRING , "form_definition_id","formDefinitionId","关联表单","表单定义ID",false,false,true);
		
		/**
		 * 驳回配置，流程在驳回时的表现
		*/
		public static final DBField REJECT_OPTION = new DBField(DBDataType.STRING , "reject_option","rejectOption","驳回配置","流程在驳回时的表现",false,false,true);
		
		/**
		 * 审批人身份范围，审批人身份类型的范围
		*/
		public static final DBField ASSIGNEE_TYPE_RANGE = new DBField(DBDataType.STRING , "assignee_type_range","assigneeTypeRange","审批人身份范围","审批人身份类型的范围",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 生效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","生效","生效",false,false,true);
		
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
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,false);
		
		/**
		 * 流程ID，在 camunda 中的流程定义ID
		*/
		public static final DBField CAMUNDA_DEFINITION_ID = new DBField(DBDataType.STRING , "camunda_definition_id","camundaDefinitionId","流程ID","在 camunda 中的流程定义ID",false,false,true);
		
		/**
		 * 流程Key，在 camunda 中的流程定义KEY
		*/
		public static final DBField CAMUNDA_DEFINITION_KEY = new DBField(DBDataType.STRING , "camunda_definition_key","camundaDefinitionKey","流程Key","在 camunda 中的流程定义KEY",false,false,true);
		
		/**
		 * PC端图标
		*/
		public static final DBField ICON_FILE_PC = new DBField(DBDataType.STRING , "icon_file_pc","iconFilePc","PC端图标","PC端图标",false,false,true);
		
		/**
		 * 移动端图标
		*/
		public static final DBField ICON_FILE_MOBILE = new DBField(DBDataType.STRING , "icon_file_mobile","iconFileMobile","移动端图标","移动端图标",false,false,true);
		
		/**
		 * 序号
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","序号","序号",false,false,true);
		
		/**
		 * 分类ID
		*/
		public static final DBField CATALOG_ID = new DBField(DBDataType.STRING , "catalog_id","catalogId","分类ID","分类ID",false,false,true);
		
		public BPM_PROCESS_DEFINITION() {
			this.init($NAME,"流程定义表" , ID , CODE , FORM_DEFINITION_ID , REJECT_OPTION , ASSIGNEE_TYPE_RANGE , NAME , VALID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , CAMUNDA_DEFINITION_ID , CAMUNDA_DEFINITION_KEY , ICON_FILE_PC , ICON_FILE_MOBILE , SORT , CATALOG_ID);
		}
		public static final BPM_PROCESS_DEFINITION $TABLE=new BPM_PROCESS_DEFINITION();
	}
	
	/**
	 * 流程应用登记表
	*/
	public static class BPM_PROCESS_DEFINITION_DEPLOY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_process_definition_deploy";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 流程定义ID
		*/
		public static final DBField PROCESS_DEFINITION_ID = new DBField(DBDataType.STRING , "process_definition_id","processDefinitionId","流程定义ID","流程定义ID",false,false,true);
		
		/**
		 * 流程文件ID
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","流程文件ID","流程文件ID",false,false,true);
		
		/**
		 * 应用请求报文
		*/
		public static final DBField REQUEST = new DBField(DBDataType.STRING , "request","request","应用请求报文","应用请求报文",false,false,true);
		
		/**
		 * 应用结果
		*/
		public static final DBField RESULT = new DBField(DBDataType.STRING , "result","result","应用结果","应用结果",false,false,true);
		
		/**
		 * 应用时间
		*/
		public static final DBField APPLY_TIME = new DBField(DBDataType.DATE , "apply_time","applyTime","应用时间","应用时间",false,false,true);
		
		/**
		 * 异常信息
		*/
		public static final DBField EXCEPTION = new DBField(DBDataType.STRING , "exception","exception","异常信息","异常信息",false,false,true);
		
		/**
		 * 是否成功
		*/
		public static final DBField SUCCESS = new DBField(DBDataType.INTEGER , "success","success","是否成功","是否成功",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,false);
		
		public BPM_PROCESS_DEFINITION_DEPLOY() {
			this.init($NAME,"流程应用登记表" , ID , PROCESS_DEFINITION_ID , FILE_ID , REQUEST , RESULT , APPLY_TIME , EXCEPTION , SUCCESS , TENANT_ID);
		}
		public static final BPM_PROCESS_DEFINITION_DEPLOY $TABLE=new BPM_PROCESS_DEFINITION_DEPLOY();
	}
	
	/**
	 * 流程定义文件表
	*/
	public static class BPM_PROCESS_DEFINITION_FILE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_process_definition_file";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 流程定义ID
		*/
		public static final DBField PROCESS_DEFINITION_ID = new DBField(DBDataType.STRING , "process_definition_id","processDefinitionId","流程定义ID","流程定义ID",false,false,false);
		
		/**
		 * 流程文件ID
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","流程文件ID","流程文件ID",false,false,true);
		
		/**
		 * 流程模型XML
		*/
		public static final DBField MODEL_XML = new DBField(DBDataType.STRING , "model_xml","modelXml","流程模型XML","流程模型XML",false,false,true);
		
		/**
		 * 版本号
		*/
		public static final DBField VERSION_NO = new DBField(DBDataType.STRING , "version_no","versionNo","版本号","版本号",false,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 是否激活，只能有一个版本是激活的
		*/
		public static final DBField ACTIVATED = new DBField(DBDataType.INTEGER , "activated","activated","是否激活","只能有一个版本是激活的",false,false,true);
		
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
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,false);
		
		/**
		 * 部署结果
		*/
		public static final DBField DEPLOY_RESULT = new DBField(DBDataType.STRING , "deploy_result","deployResult","部署结果","部署结果",false,false,true);
		
		/**
		 * 部署成功，逻辑值
		*/
		public static final DBField DEPLOY_SUCCESS = new DBField(DBDataType.INTEGER , "deploy_success","deploySuccess","部署成功","逻辑值",false,false,true);
		
		/**
		 * 提示信息
		*/
		public static final DBField DEPLOY_ERROR = new DBField(DBDataType.STRING , "deploy_error","deployError","提示信息","提示信息",false,false,true);
		
		public BPM_PROCESS_DEFINITION_FILE() {
			this.init($NAME,"流程定义文件表" , ID , PROCESS_DEFINITION_ID , FILE_ID , MODEL_XML , VERSION_NO , NAME , ACTIVATED , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , DEPLOY_RESULT , DEPLOY_SUCCESS , DEPLOY_ERROR);
		}
		public static final BPM_PROCESS_DEFINITION_FILE $TABLE=new BPM_PROCESS_DEFINITION_FILE();
	}
	
	/**
	 * 流程定义节点表
	*/
	public static class BPM_PROCESS_DEFINITION_NODE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_process_definition_node";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 流程定义ID
		*/
		public static final DBField PROCESS_DEFINITION_ID = new DBField(DBDataType.STRING , "process_definition_id","processDefinitionId","流程定义ID","流程定义ID",false,false,false);
		
		/**
		 * 流程文件ID
		*/
		public static final DBField PROCESS_DEFINITION_FILE_ID = new DBField(DBDataType.STRING , "process_definition_file_id","processDefinitionFileId","流程文件ID","流程文件ID",false,false,false);
		
		/**
		 * 节点ID
		*/
		public static final DBField CAMUNDA_NODE_ID = new DBField(DBDataType.STRING , "camunda_node_id","camundaNodeId","节点ID","节点ID",false,false,false);
		
		/**
		 * 节点类型
		*/
		public static final DBField NODE_TYPE = new DBField(DBDataType.STRING , "node_type","nodeType","节点类型","节点类型",false,false,true);
		
		/**
		 * 节点名称
		*/
		public static final DBField NODE_NAME = new DBField(DBDataType.STRING , "node_name","nodeName","节点名称","节点名称",false,false,true);
		
		/**
		 * 人工节点类型
		*/
		public static final DBField USER_TASK_TYPE = new DBField(DBDataType.STRING , "user_task_type","userTaskType","人工节点类型","人工节点类型",false,false,true);
		
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
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,false);
		
		/**
		 * 序号
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","序号","序号",false,false,true);
		
		/**
		 * 会审的循环基数
		*/
		public static final DBField LOOP_CARDINALITY = new DBField(DBDataType.INTEGER , "loop_cardinality","loopCardinality","会审的循环基数","会审的循环基数",false,false,true);
		
		public BPM_PROCESS_DEFINITION_NODE() {
			this.init($NAME,"流程定义节点表" , ID , PROCESS_DEFINITION_ID , PROCESS_DEFINITION_FILE_ID , CAMUNDA_NODE_ID , NODE_TYPE , NODE_NAME , USER_TASK_TYPE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SORT , LOOP_CARDINALITY);
		}
		public static final BPM_PROCESS_DEFINITION_NODE $TABLE=new BPM_PROCESS_DEFINITION_NODE();
	}
	
	/**
	 * 流程审批人表
	*/
	public static class BPM_PROCESS_DEFINITION_NODE_ASSIGNEE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_process_definition_node_assignee";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 流程节点ID
		*/
		public static final DBField NODE_ID = new DBField(DBDataType.STRING , "node_id","nodeId","流程节点ID","流程节点ID",false,false,true);
		
		/**
		 * 审批人类型
		*/
		public static final DBField ASSIGNEE_TYPE = new DBField(DBDataType.STRING , "assignee_type","assigneeType","审批人类型","审批人类型",false,false,true);
		
		/**
		 * 审批人ID
		*/
		public static final DBField ASSIGNEE_ID = new DBField(DBDataType.STRING , "assignee_id","assigneeId","审批人ID","审批人ID",false,false,true);
		
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
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,false);
		
		/**
		 * 序号
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","序号","序号",false,false,true);
		
		public BPM_PROCESS_DEFINITION_NODE_ASSIGNEE() {
			this.init($NAME,"流程审批人表" , ID , NODE_ID , ASSIGNEE_TYPE , ASSIGNEE_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SORT);
		}
		public static final BPM_PROCESS_DEFINITION_NODE_ASSIGNEE $TABLE=new BPM_PROCESS_DEFINITION_NODE_ASSIGNEE();
	}
	
	/**
	 * 流程错误信息
	*/
	public static class BPM_PROCESS_ERROR extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_process_error";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 流程ID
		*/
		public static final DBField PROCESS_INSTANCE_ID = new DBField(DBDataType.STRING , "process_instance_id","processInstanceId","流程ID","流程ID",false,false,true);
		
		/**
		 * 审批节点
		*/
		public static final DBField APPROVAL_NODE_ID = new DBField(DBDataType.STRING , "approval_node_id","approvalNodeId","审批节点","审批节点",false,false,true);
		
		/**
		 * 错误节点
		*/
		public static final DBField ERROR_NODE_ID = new DBField(DBDataType.STRING , "error_node_id","errorNodeId","错误节点","错误节点",false,false,true);
		
		/**
		 * 错误消息
		*/
		public static final DBField ERROR_MESSAGE = new DBField(DBDataType.STRING , "error_message","errorMessage","错误消息","错误消息",false,false,true);
		
		/**
		 * 错误时间
		*/
		public static final DBField ERROR_TIME = new DBField(DBDataType.DATE , "error_time","errorTime","错误时间","错误时间",false,false,true);
		
		/**
		 * 原始 incident id
		*/
		public static final DBField CAMUNDA_INCIDENT_ID = new DBField(DBDataType.STRING , "camunda_incident_id","camundaIncidentId","原始","incident id",false,false,true);
		
		/**
		 * 错误类型
		*/
		public static final DBField ERROR_TYPE = new DBField(DBDataType.STRING , "error_type","errorType","错误类型","错误类型",false,false,true);
		
		public BPM_PROCESS_ERROR() {
			this.init($NAME,"流程错误信息" , ID , PROCESS_INSTANCE_ID , APPROVAL_NODE_ID , ERROR_NODE_ID , ERROR_MESSAGE , ERROR_TIME , CAMUNDA_INCIDENT_ID , ERROR_TYPE);
		}
		public static final BPM_PROCESS_ERROR $TABLE=new BPM_PROCESS_ERROR();
	}
	
	/**
	 * 流程发起人权限表
	*/
	public static class BPM_PROCESS_INITIATOR extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_process_initiator";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 流程定义ID
		*/
		public static final DBField DEFINITION_ID = new DBField(DBDataType.STRING , "definition_id","definitionId","流程定义ID","流程定义ID",false,false,true);
		
		/**
		 * 发起人ID
		*/
		public static final DBField INITIATOR_ID = new DBField(DBDataType.STRING , "initiator_id","initiatorId","发起人ID","发起人ID",false,false,true);
		
		/**
		 * 发起类型，参考枚举 InitiatorType
		*/
		public static final DBField INITIATOR_TYPE = new DBField(DBDataType.STRING , "initiator_type","initiatorType","发起类型","参考枚举 InitiatorType",false,false,true);
		
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
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,false);
		
		public BPM_PROCESS_INITIATOR() {
			this.init($NAME,"流程发起人权限表" , ID , DEFINITION_ID , INITIATOR_ID , INITIATOR_TYPE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final BPM_PROCESS_INITIATOR $TABLE=new BPM_PROCESS_INITIATOR();
	}
	
	/**
	 * 流程实例表
	*/
	public static class BPM_PROCESS_INSTANCE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_process_instance";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 起草人账户ID
		*/
		public static final DBField DRAFTER_USER_ID = new DBField(DBDataType.STRING , "drafter_user_id","drafterUserId","起草人账户ID","起草人账户ID",false,false,false);
		
		/**
		 * 起草人ID,可以是账户ID、员工ID、职位ID、系统角色ID、业务角色ID
		*/
		public static final DBField DRAFTER_ID = new DBField(DBDataType.STRING , "drafter_id","drafterId","起草人ID","可以是账户ID、员工ID、职位ID、系统角色ID、业务角色ID",false,false,false);
		
		/**
		 * 起草人类型
		*/
		public static final DBField DRAFTER_TYPE = new DBField(DBDataType.STRING , "drafter_type","drafterType","起草人类型","起草人类型",false,false,false);
		
		/**
		 * 表单实例ID
		*/
		public static final DBField FORM_INSTANCE_ID = new DBField(DBDataType.STRING , "form_instance_id","formInstanceId","表单实例ID","表单实例ID",false,false,true);
		
		/**
		 * 流程定义ID
		*/
		public static final DBField PROCESS_DEFINITION_ID = new DBField(DBDataType.STRING , "process_definition_id","processDefinitionId","流程定义ID","流程定义ID",false,false,false);
		
		/**
		 * 流程定义文件ID
		*/
		public static final DBField PROCESS_DEFINITION_FILE_ID = new DBField(DBDataType.STRING , "process_definition_file_id","processDefinitionFileId","流程定义文件ID","流程定义文件ID",false,false,true);
		
		/**
		 * 表单定义ID
		*/
		public static final DBField FORM_DEFINITION_ID = new DBField(DBDataType.STRING , "form_definition_id","formDefinitionId","表单定义ID","表单定义ID",false,false,false);
		
		/**
		 * 流程标题
		*/
		public static final DBField TITLE = new DBField(DBDataType.STRING , "title","title","流程标题","流程标题",false,false,true);
		
		/**
		 * 紧急程度
		*/
		public static final DBField PRIORITY = new DBField(DBDataType.STRING , "priority","priority","紧急程度","紧急程度",false,false,true);
		
		/**
		 * 流程说明
		*/
		public static final DBField COMMENT = new DBField(DBDataType.STRING , "comment","comment","流程说明","流程说明",false,false,true);
		
		/**
		 * 审批状态
		*/
		public static final DBField APPROVAL_STATUS = new DBField(DBDataType.STRING , "approval_status","approvalStatus","审批状态","审批状态",false,false,true);
		
		/**
		 * camunda流程实例ID
		*/
		public static final DBField CAMUNDA_INSTANCE_ID = new DBField(DBDataType.STRING , "camunda_instance_id","camundaInstanceId","camunda流程实例ID","camunda流程实例ID",false,false,true);
		
		/**
		 * 提交时间
		*/
		public static final DBField COMMIT_TIME = new DBField(DBDataType.DATE , "commit_time","commitTime","提交时间","提交时间",false,false,true);
		
		/**
		 * 废弃人账户ID
		*/
		public static final DBField ABANDON_USER_ID = new DBField(DBDataType.STRING , "abandon_user_id","abandonUserId","废弃人账户ID","废弃人账户ID",false,false,true);
		
		/**
		 * 流程废弃时间
		*/
		public static final DBField ABANDON_TIME = new DBField(DBDataType.DATE , "abandon_time","abandonTime","流程废弃时间","流程废弃时间",false,false,true);
		
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
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,false);
		
		/**
		 * 流程完成时间
		*/
		public static final DBField END_TIME = new DBField(DBDataType.DATE , "end_time","endTime","流程完成时间","流程完成时间",false,false,true);
		
		/**
		 * 是否需要同步
		*/
		public static final DBField NEED_SYNC = new DBField(DBDataType.INTEGER , "need_sync","needSync","是否需要同步","是否需要同步",false,false,true);
		
		/**
		 * 状态同步时间
		*/
		public static final DBField SYNC_TIME = new DBField(DBDataType.DATE , "sync_time","syncTime","状态同步时间","状态同步时间",false,false,true);
		
		public BPM_PROCESS_INSTANCE() {
			this.init($NAME,"流程实例表" , ID , DRAFTER_USER_ID , DRAFTER_ID , DRAFTER_TYPE , FORM_INSTANCE_ID , PROCESS_DEFINITION_ID , PROCESS_DEFINITION_FILE_ID , FORM_DEFINITION_ID , TITLE , PRIORITY , COMMENT , APPROVAL_STATUS , CAMUNDA_INSTANCE_ID , COMMIT_TIME , ABANDON_USER_ID , ABANDON_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , END_TIME , NEED_SYNC , SYNC_TIME);
		}
		public static final BPM_PROCESS_INSTANCE $TABLE=new BPM_PROCESS_INSTANCE();
	}
	
	/**
	 * 流程实例提醒
	*/
	public static class BPM_PROCESS_INSTANCE_REMIND extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_process_instance_remind";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 流程实例ID
		*/
		public static final DBField PROCESS_INSTANCE_ID = new DBField(DBDataType.STRING , "process_instance_id","processInstanceId","流程实例ID","流程实例ID",false,false,true);
		
		/**
		 * 监控的目标节点ID
		*/
		public static final DBField TARGET_NODE_ID = new DBField(DBDataType.STRING , "target_node_id","targetNodeId","监控的目标节点ID","监控的目标节点ID",false,false,true);
		
		/**
		 * 设置提醒的节点ID
		*/
		public static final DBField SOURCE_NODE_ID = new DBField(DBDataType.STRING , "source_node_id","sourceNodeId","设置提醒的节点ID","设置提醒的节点ID",false,false,true);
		
		/**
		 * 提醒内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","提醒内容","提醒内容",false,false,true);
		
		/**
		 * 提醒时间
		*/
		public static final DBField REMIND_TIME = new DBField(DBDataType.STRING , "remind_time","remindTime","提醒时间","提醒时间",false,false,true);
		
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
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 提醒时长
		*/
		public static final DBField REMIND_TERM = new DBField(DBDataType.INTEGER , "remind_term","remindTerm","提醒时长","提醒时长",false,false,true);
		
		/**
		 * 提醒时长单位
		*/
		public static final DBField REMIND_TERM_UNIT = new DBField(DBDataType.STRING , "remind_term_unit","remindTermUnit","提醒时长单位","提醒时长单位",false,false,true);
		
		public BPM_PROCESS_INSTANCE_REMIND() {
			this.init($NAME,"流程实例提醒" , ID , PROCESS_INSTANCE_ID , TARGET_NODE_ID , SOURCE_NODE_ID , CONTENT , REMIND_TIME , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , STATUS , REMIND_TERM , REMIND_TERM_UNIT);
		}
		public static final BPM_PROCESS_INSTANCE_REMIND $TABLE=new BPM_PROCESS_INSTANCE_REMIND();
	}
	
	/**
	 * 流程实例提醒人员
	*/
	public static class BPM_PROCESS_INSTANCE_REMIND_RECEIVER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_process_instance_remind_receiver";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 流程实例ID
		*/
		public static final DBField REMIND_ID = new DBField(DBDataType.STRING , "remind_id","remindId","流程实例ID","流程实例ID",false,false,true);
		
		/**
		 * 需要提醒的接收人ID
		*/
		public static final DBField RECEIVER_ID = new DBField(DBDataType.STRING , "receiver_id","receiverId","需要提醒的接收人ID","需要提醒的接收人ID",false,false,true);
		
		/**
		 * 接收人类型
		*/
		public static final DBField RECEIVER_TYPE = new DBField(DBDataType.STRING , "receiver_type","receiverType","接收人类型","接收人类型",false,false,true);
		
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
		
		public BPM_PROCESS_INSTANCE_REMIND_RECEIVER() {
			this.init($NAME,"流程实例提醒人员" , ID , REMIND_ID , RECEIVER_ID , RECEIVER_TYPE , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final BPM_PROCESS_INSTANCE_REMIND_RECEIVER $TABLE=new BPM_PROCESS_INSTANCE_REMIND_RECEIVER();
	}
	
	/**
	 * 流程任务表
	*/
	public static class BPM_TASK extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_task";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","id","id",true,false,false);
		
		/**
		 * 流程定义ID
		*/
		public static final DBField PROCESS_DEFINITION_ID = new DBField(DBDataType.STRING , "process_definition_id","processDefinitionId","流程定义ID","流程定义ID",false,false,true);
		
		/**
		 * 节点ID
		*/
		public static final DBField NODE_ID = new DBField(DBDataType.STRING , "node_id","nodeId","节点ID","节点ID",false,false,true);
		
		/**
		 * 节点名称
		*/
		public static final DBField NODE_NAME = new DBField(DBDataType.STRING , "node_name","nodeName","节点名称","节点名称",false,false,true);
		
		/**
		 * 流程实例ID
		*/
		public static final DBField PROCESS_INSTANCE_ID = new DBField(DBDataType.STRING , "process_instance_id","processInstanceId","流程实例ID","流程实例ID",false,false,true);
		
		/**
		 * 任务状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","任务状态","任务状态",false,false,true);
		
		/**
		 * 原因，状态变更的原因
		*/
		public static final DBField STATUS_REASON = new DBField(DBDataType.STRING , "status_reason","statusReason","原因","状态变更的原因",false,false,true);
		
		/**
		 * 最后处理时间
		*/
		public static final DBField APPROVAL_TIME = new DBField(DBDataType.DATE , "approval_time","approvalTime","最后处理时间","最后处理时间",false,false,true);
		
		/**
		 * 任务ID，Camunda 任务ID
		*/
		public static final DBField CAMUNDA_TASK_ID = new DBField(DBDataType.STRING , "camunda_task_id","camundaTaskId","任务ID","Camunda 任务ID",false,false,false);
		
		/**
		 * cam中指定的审批人
		*/
		public static final DBField CAMUNDA_ASSIGNEE = new DBField(DBDataType.STRING , "camunda_assignee","camundaAssignee","cam中指定的审批人","cam中指定的审批人",false,false,true);
		
		/**
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","create_by","create_by",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","update_by","update_by",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","delete_by","delete_by",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","tenant_id","tenant_id",false,false,true);
		
		public BPM_TASK() {
			this.init($NAME,"流程任务表" , ID , PROCESS_DEFINITION_ID , NODE_ID , NODE_NAME , PROCESS_INSTANCE_ID , STATUS , STATUS_REASON , APPROVAL_TIME , CAMUNDA_TASK_ID , CAMUNDA_ASSIGNEE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final BPM_TASK $TABLE=new BPM_TASK();
	}
	
	/**
	 * 流程任务审批结果表
	*/
	public static class BPM_TASK_APPROVAL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_task_approval";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","id","id",true,false,false);
		
		/**
		 * 任务ID
		*/
		public static final DBField TASK_ID = new DBField(DBDataType.STRING , "task_id","taskId","任务ID","任务ID",false,false,true);
		
		/**
		 * 流程实例ID
		*/
		public static final DBField PROCESS_INSTANCE_ID = new DBField(DBDataType.STRING , "process_instance_id","processInstanceId","流程实例ID","流程实例ID",false,false,true);
		
		/**
		 * 审批人账户ID，实际的审批人
		*/
		public static final DBField APPROVAL_USER_ID = new DBField(DBDataType.STRING , "approval_user_id","approvalUserId","审批人账户ID","实际的审批人",false,false,true);
		
		/**
		 * 处理时间
		*/
		public static final DBField APPROVAL_TIME = new DBField(DBDataType.DATE , "approval_time","approvalTime","处理时间","处理时间",false,false,true);
		
		/**
		 * 审批结果
		*/
		public static final DBField APPROVAL_RESULT = new DBField(DBDataType.STRING , "approval_result","approvalResult","审批结果","审批结果",false,false,true);
		
		/**
		 * 审批意见
		*/
		public static final DBField APPROVAL_COMMENT = new DBField(DBDataType.STRING , "approval_comment","approvalComment","审批意见","审批意见",false,false,true);
		
		/**
		 * 审批人类型，预计的审批人类型
		*/
		public static final DBField ASSIGNEE_TYPE = new DBField(DBDataType.STRING , "assignee_type","assigneeType","审批人类型","预计的审批人类型",false,false,true);
		
		/**
		 * 审批人ID，预计的审批人
		*/
		public static final DBField ASSIGNEE_ID = new DBField(DBDataType.STRING , "assignee_id","assigneeId","审批人ID","预计的审批人",false,false,true);
		
		/**
		 * 变量数据
		*/
		public static final DBField VARIABLES = new DBField(DBDataType.STRING , "variables","variables","变量数据","变量数据",false,false,true);
		
		/**
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","create_by","create_by",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","update_by","update_by",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","delete_by","delete_by",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","tenant_id","tenant_id",false,false,true);
		
		/**
		 * CAM结果，Camunda返回的结果
		*/
		public static final DBField CAMUNDA_RESULT = new DBField(DBDataType.STRING , "camunda_result","camundaResult","CAM结果","Camunda返回的结果",false,false,true);
		
		/**
		 * CAM成功，Camunda处理是否成功
		*/
		public static final DBField CAMUNDA_SUCCESS = new DBField(DBDataType.INTEGER , "camunda_success","camundaSuccess","CAM成功","Camunda处理是否成功",false,false,true);
		
		public BPM_TASK_APPROVAL() {
			this.init($NAME,"流程任务审批结果表" , ID , TASK_ID , PROCESS_INSTANCE_ID , APPROVAL_USER_ID , APPROVAL_TIME , APPROVAL_RESULT , APPROVAL_COMMENT , ASSIGNEE_TYPE , ASSIGNEE_ID , VARIABLES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , CAMUNDA_RESULT , CAMUNDA_SUCCESS);
		}
		public static final BPM_TASK_APPROVAL $TABLE=new BPM_TASK_APPROVAL();
	}
	
	/**
	 * 流程任务处理人表
	*/
	public static class BPM_TASK_ASSIGNEE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_task_assignee";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","id","id",true,false,false);
		
		/**
		 * 流程实例ID
		*/
		public static final DBField PROCESS_INSTANCE_ID = new DBField(DBDataType.STRING , "process_instance_id","processInstanceId","流程实例ID","流程实例ID",false,false,true);
		
		/**
		 * 任务ID
		*/
		public static final DBField TASK_ID = new DBField(DBDataType.STRING , "task_id","taskId","任务ID","任务ID",false,false,true);
		
		/**
		 * 审批人类型，预计的审批人类型
		*/
		public static final DBField ASSIGNEE_TYPE = new DBField(DBDataType.STRING , "assignee_type","assigneeType","审批人类型","预计的审批人类型",false,false,true);
		
		/**
		 * 审批人ID，预计的审批人
		*/
		public static final DBField ASSIGNEE_ID = new DBField(DBDataType.STRING , "assignee_id","assigneeId","审批人ID","预计的审批人",false,false,true);
		
		/**
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","create_by","create_by",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","update_by","update_by",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","delete_by","delete_by",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","tenant_id","tenant_id",false,false,true);
		
		public BPM_TASK_ASSIGNEE() {
			this.init($NAME,"流程任务处理人表" , ID , PROCESS_INSTANCE_ID , TASK_ID , ASSIGNEE_TYPE , ASSIGNEE_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final BPM_TASK_ASSIGNEE $TABLE=new BPM_TASK_ASSIGNEE();
	}
	
	/**
	 * 流程任务已阅表
	*/
	public static class BPM_TASK_READ extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_task_read";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","id","id",true,false,false);
		
		/**
		 * 流程实例ID
		*/
		public static final DBField PROCESS_INSTANCE_ID = new DBField(DBDataType.STRING , "process_instance_id","processInstanceId","流程实例ID","流程实例ID",false,false,true);
		
		/**
		 * 任务ID
		*/
		public static final DBField TASK_ID = new DBField(DBDataType.STRING , "task_id","taskId","任务ID","任务ID",false,false,true);
		
		/**
		 * 确认时间，已阅确认时间
		*/
		public static final DBField CONFIRM_TIME = new DBField(DBDataType.DATE , "confirm_time","confirmTime","确认时间","已阅确认时间",false,false,true);
		
		/**
		 * 评论
		*/
		public static final DBField COMMENT = new DBField(DBDataType.STRING , "comment","comment","评论","评论",false,false,true);
		
		/**
		 * 阅读状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","阅读状态","阅读状态",false,false,true);
		
		/**
		 * 创建人，阅读人
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人","阅读人",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","tenant_id","tenant_id",false,false,true);
		
		/**
		 * 持续阅读时间
		*/
		public static final DBField LATEST_TIME = new DBField(DBDataType.DATE , "latest_time","latestTime","持续阅读时间","持续阅读时间",false,false,true);
		
		public BPM_TASK_READ() {
			this.init($NAME,"流程任务已阅表" , ID , PROCESS_INSTANCE_ID , TASK_ID , CONFIRM_TIME , COMMENT , STATUS , CREATE_BY , CREATE_TIME , VERSION , TENANT_ID , LATEST_TIME);
		}
		public static final BPM_TASK_READ $TABLE=new BPM_TASK_READ();
	}
	
	/**
	 * 用户流程统计
	*/
	public static class BPM_USER_STATISTICS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "bpm_user_statistics";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 流程定义ID
		*/
		public static final DBField PROCESS_DEFINITION_ID = new DBField(DBDataType.STRING , "process_definition_id","processDefinitionId","流程定义ID","流程定义ID",false,false,true);
		
		/**
		 * 账户ID
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","账户ID","账户ID",false,false,true);
		
		/**
		 * 使用次数
		*/
		public static final DBField USES_NUMBER = new DBField(DBDataType.INTEGER , "uses_number","usesNumber","使用次数","使用次数",false,false,false);
		
		/**
		 * 最近使用时间
		*/
		public static final DBField LATEST_USE_TIME = new DBField(DBDataType.DATE , "latest_use_time","latestUseTime","最近使用时间","最近使用时间",false,false,false);
		
		/**
		 * 创建人
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人","创建人",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 更新人
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","更新人","更新人",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人","删除人",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","tenant_id","tenant_id",false,false,true);
		
		public BPM_USER_STATISTICS() {
			this.init($NAME,"用户流程统计" , ID , PROCESS_DEFINITION_ID , USER_ID , USES_NUMBER , LATEST_USE_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final BPM_USER_STATISTICS $TABLE=new BPM_USER_STATISTICS();
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
		public static final DBField NOTIFY_TIME = new DBField(DBDataType.TIMESTAMP , "notify_time","notifyTime","通知发送时间","通知发送时间",false,false,true);
		
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
		public static final DBField RESPONSE_TIME = new DBField(DBDataType.TIMESTAMP , "response_time","responseTime","回调接收时间","回调接收时间",false,false,true);
		
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
		
		/**
		 * 类型，字典代码：employee_code
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","字典代码：employee_code",false,false,true);
		
		public HRM_EMPLOYEE() {
			this.init($NAME,"员工表" , ID , BADGE , PHONE , PERSON_ID , COMPANY_ID , STATUS , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TYPE);
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
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		public HRM_ORGANIZATION() {
			this.init($NAME,"组织层级表" , ID , CODE , SHORT_NAME , FULL_NAME , TYPE , PARENT_ID , VALID , HIERARCHY , SORT , COMPANY_ID , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , NOTES);
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
	 * 接口数据来源定义
	*/
	public static class SYS_API_SOURCE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_api_source";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 接口地址
		*/
		public static final DBField API_URL = new DBField(DBDataType.STRING , "api_url","apiUrl","接口地址","接口地址",false,false,true);
		
		/**
		 * 账户
		*/
		public static final DBField USER_NAME = new DBField(DBDataType.STRING , "user_name","userName","账户","账户",false,false,true);
		
		/**
		 * 密码
		*/
		public static final DBField PASSWORD = new DBField(DBDataType.STRING , "password","password","密码","密码",false,false,true);
		
		/**
		 * 是否有效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","是否有效","是否有效",false,false,true);
		
		/**
		 * API数据
		*/
		public static final DBField API_DATA = new DBField(DBDataType.STRING , "api_data","apiData","API数据","API数据",false,false,true);
		
		/**
		 * 目录结构
		*/
		public static final DBField NAV_DIR = new DBField(DBDataType.STRING , "nav_dir","navDir","目录结构","目录结构",false,false,true);
		
		/**
		 * 取数时间
		*/
		public static final DBField FETCH_TIME = new DBField(DBDataType.DATE , "fetch_time","fetchTime","取数时间","取数时间",false,false,true);
		
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
		
		public SYS_API_SOURCE() {
			this.init($NAME,"接口数据来源定义" , ID , NAME , API_URL , USER_NAME , PASSWORD , VALID , API_DATA , NAV_DIR , FETCH_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_API_SOURCE $TABLE=new SYS_API_SOURCE();
	}
	
	/**
	 * 中国行政地区表
	*/
	public static class SYS_AREA extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_area";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.INTEGER , "id","id","id","id",true,true,false);
		
		/**
		 * 层级
		*/
		public static final DBField LEVEL = new DBField(DBDataType.INTEGER , "level","level","层级","层级",false,false,false);
		
		/**
		 * 父级行政代码
		*/
		public static final DBField PARENT_CODE = new DBField(DBDataType.LONG , "parent_code","parentCode","父级行政代码","父级行政代码",false,false,false);
		
		/**
		 * 行政代码
		*/
		public static final DBField AREA_CODE = new DBField(DBDataType.LONG , "area_code","areaCode","行政代码","行政代码",false,false,false);
		
		/**
		 * 邮政编码
		*/
		public static final DBField ZIP_CODE = new DBField(DBDataType.INTEGER , "zip_code","zipCode","邮政编码","邮政编码",false,false,false);
		
		/**
		 * 区号
		*/
		public static final DBField CITY_CODE = new DBField(DBDataType.STRING , "city_code","cityCode","区号","区号",false,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,false);
		
		/**
		 * 简称
		*/
		public static final DBField SHORT_NAME = new DBField(DBDataType.STRING , "short_name","shortName","简称","简称",false,false,false);
		
		/**
		 * 组合名
		*/
		public static final DBField MERGER_NAME = new DBField(DBDataType.STRING , "merger_name","mergerName","组合名","组合名",false,false,false);
		
		/**
		 * 拼音
		*/
		public static final DBField PINYIN = new DBField(DBDataType.STRING , "pinyin","pinyin","拼音","拼音",false,false,false);
		
		/**
		 * 经度
		*/
		public static final DBField LNG = new DBField(DBDataType.DECIMAL , "lng","lng","经度","经度",false,false,false);
		
		/**
		 * 纬度
		*/
		public static final DBField LAT = new DBField(DBDataType.DECIMAL , "lat","lat","纬度","纬度",false,false,false);
		
		/**
		 * 层级路径
		*/
		public static final DBField HIERARCHY = new DBField(DBDataType.STRING , "hierarchy","hierarchy","层级路径","层级路径",false,false,true);
		
		public SYS_AREA() {
			this.init($NAME,"中国行政地区表" , ID , LEVEL , PARENT_CODE , AREA_CODE , ZIP_CODE , CITY_CODE , NAME , SHORT_NAME , MERGER_NAME , PINYIN , LNG , LAT , HIERARCHY);
		}
		public static final SYS_AREA $TABLE=new SYS_AREA();
	}
	
	/**
	 * 模块角色
	*/
	public static class SYS_AUTO_MODULE_ROLE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_auto_module_role";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 模块
		*/
		public static final DBField MODULE = new DBField(DBDataType.STRING , "module","module","模块","模块",false,false,true);
		
		/**
		 * 类型,role|data_role|busi_role
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","role|data_role|busi_role",false,false,true);
		
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
		
		public SYS_AUTO_MODULE_ROLE() {
			this.init($NAME,"模块角色" , ID , NAME , STATUS , MODULE , TYPE , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_AUTO_MODULE_ROLE $TABLE=new SYS_AUTO_MODULE_ROLE();
	}
	
	/**
	 * 赋权明细
	*/
	public static class SYS_AUTO_MODULE_ROLE_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_auto_module_role_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 模块
		*/
		public static final DBField MODULE_ROLE_ID = new DBField(DBDataType.STRING , "module_role_id","moduleRoleId","模块","模块",false,false,true);
		
		/**
		 * 角色
		*/
		public static final DBField ROLE_ID = new DBField(DBDataType.STRING , "role_id","roleId","角色","角色",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField ROLE_NAME = new DBField(DBDataType.STRING , "role_name","roleName","名称","名称",false,false,true);
		
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
		
		public SYS_AUTO_MODULE_ROLE_ITEM() {
			this.init($NAME,"赋权明细" , ID , MODULE_ROLE_ID , ROLE_ID , ROLE_NAME , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_AUTO_MODULE_ROLE_ITEM $TABLE=new SYS_AUTO_MODULE_ROLE_ITEM();
	}
	
	/**
	 * 操作日志
	*/
	public static class SYS_AUTO_ROLE_GRANT_RCD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_auto_role_grant_rcd";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 模块
		*/
		public static final DBField MODULE_ROLE_ID = new DBField(DBDataType.STRING , "module_role_id","moduleRoleId","模块","模块",false,false,true);
		
		/**
		 * 角色
		*/
		public static final DBField ROLE_ID = new DBField(DBDataType.STRING , "role_id","roleId","角色","角色",false,false,true);
		
		/**
		 * 用户
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","用户","用户",false,false,true);
		
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
		
		public SYS_AUTO_ROLE_GRANT_RCD() {
			this.init($NAME,"操作日志" , ID , MODULE_ROLE_ID , ROLE_ID , USER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_AUTO_ROLE_GRANT_RCD $TABLE=new SYS_AUTO_ROLE_GRANT_RCD();
	}
	
	/**
	 * 预定用户
	*/
	public static class SYS_AUTO_USER_PREDEFINED extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_auto_user_predefined";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 用户
		*/
		public static final DBField ACCOUNT = new DBField(DBDataType.STRING , "account","account","用户","用户",false,false,true);
		
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
		
		public SYS_AUTO_USER_PREDEFINED() {
			this.init($NAME,"预定用户" , ID , ACCOUNT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_AUTO_USER_PREDEFINED $TABLE=new SYS_AUTO_USER_PREDEFINED();
	}
	
	/**
	 * 备份记录
	*/
	public static class SYS_BACKUP_DB extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_backup_db";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField DB_NAME = new DBField(DBDataType.STRING , "db_name","dbName","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 备份文件
		*/
		public static final DBField FILE_ROUTE = new DBField(DBDataType.STRING , "file_route","fileRoute","备份文件","备份文件",false,false,true);
		
		/**
		 * 大小
		*/
		public static final DBField FILE_SIZE = new DBField(DBDataType.DECIMAL , "file_size","fileSize","大小","大小",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField START_TIME = new DBField(DBDataType.DATE , "start_time","startTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField END_TIME = new DBField(DBDataType.DATE , "end_time","endTime","结束时间","结束时间",false,false,true);
		
		/**
		 * 失效日期
		*/
		public static final DBField INVALID_TIME = new DBField(DBDataType.DATE , "invalid_time","invalidTime","失效日期","失效日期",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
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
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public SYS_BACKUP_DB() {
			this.init($NAME,"备份记录" , ID , DB_NAME , STATUS , FILE_ROUTE , FILE_SIZE , START_TIME , END_TIME , INVALID_TIME , CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_BACKUP_DB $TABLE=new SYS_BACKUP_DB();
	}
	
	/**
	 * 备份策略
	*/
	public static class SYS_BACKUP_DB_STRATEGY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_backup_db_strategy";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 启用状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","启用状态","启用状态",false,false,true);
		
		/**
		 * 备份路径
		*/
		public static final DBField DATA_PATH = new DBField(DBDataType.STRING , "data_path","dataPath","备份路径","备份路径",false,false,true);
		
		/**
		 * 备份保留
		*/
		public static final DBField DATA_KEEP = new DBField(DBDataType.INTEGER , "data_keep","dataKeep","备份保留","备份保留",false,false,true);
		
		/**
		 * 备份周期
		*/
		public static final DBField CRONTAB = new DBField(DBDataType.STRING , "crontab","crontab","备份周期","备份周期",false,false,true);
		
		/**
		 * 邮件
		*/
		public static final DBField MAIL = new DBField(DBDataType.STRING , "mail","mail","邮件","邮件",false,false,true);
		
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
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public SYS_BACKUP_DB_STRATEGY() {
			this.init($NAME,"备份策略" , ID , STATUS , DATA_PATH , DATA_KEEP , CRONTAB , MAIL , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_BACKUP_DB_STRATEGY $TABLE=new SYS_BACKUP_DB_STRATEGY();
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
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 成员路由，Java类型用于检索扩展成员
		*/
		public static final DBField MEMBER_ROUTER = new DBField(DBDataType.STRING , "member_router","memberRouter","成员路由","Java类型用于检索扩展成员",false,false,true);
		
		/**
		 * 内置角色，系统内置角色
		*/
		public static final DBField BUILD_IN = new DBField(DBDataType.INTEGER , "build_in","buildIn","内置角色","系统内置角色",false,false,false);
		
		/**
		 * 成员路由规则
		*/
		public static final DBField MEMBER_RULE = new DBField(DBDataType.STRING , "member_rule","memberRule","成员路由规则","成员路由规则",false,false,true);
		
		/**
		 * 分类
		*/
		public static final DBField CATALOG = new DBField(DBDataType.STRING , "catalog","catalog","分类","分类",false,false,true);
		
		public SYS_BUSI_ROLE() {
			this.init($NAME,"业务角色表" , ID , ORG_ID , CODE , NAME , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , NOTES , MEMBER_ROUTER , BUILD_IN , MEMBER_RULE , CATALOG);
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
		public static final DBField RADIO_ENUM = new DBField(DBDataType.STRING , "radio_enum","radioEnum","单选框","枚举)",false,false,true);
		
		/**
		 * 单选框(字典)
		*/
		public static final DBField RADIO_DICT = new DBField(DBDataType.STRING , "radio_dict","radioDict","单选框","字典)",false,false,true);
		
		/**
		 * 复选框(枚举)
		*/
		public static final DBField CHECK_ENUM = new DBField(DBDataType.STRING , "check_enum","checkEnum","复选框","枚举)",false,false,true);
		
		/**
		 * 复选框(字典)
		*/
		public static final DBField CHECK_DICT = new DBField(DBDataType.STRING , "check_dict","checkDict","复选框","字典)",false,false,true);
		
		/**
		 * 选择框(枚举)
		*/
		public static final DBField SELECT_ENUM = new DBField(DBDataType.STRING , "select_enum","selectEnum","选择框","枚举)",false,false,true);
		
		/**
		 * 选择框(字典)
		*/
		public static final DBField SELECT_DICT = new DBField(DBDataType.STRING , "select_dict","selectDict","选择框","字典)",false,false,true);
		
		/**
		 * 选择框(查询)
		*/
		public static final DBField RESOURCE_ID = new DBField(DBDataType.STRING , "resource_id","resourceId","选择框","查询)",false,false,true);
		
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
	 * 主键多字段测试表
	*/
	public static class SYS_CODE_EXAMPLE_MULIT_PK extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_code_example_mulit_pk";
		
		/**
		 * 主键1
		*/
		public static final DBField NID = new DBField(DBDataType.LONG , "nid","nid","主键1","主键1",true,false,false);
		
		/**
		 * 主键2
		*/
		public static final DBField DAY = new DBField(DBDataType.DATE , "day","day","主键2","主键2",true,false,false);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		public SYS_CODE_EXAMPLE_MULIT_PK() {
			this.init($NAME,"主键多字段测试表" , NID , DAY , CONTENT);
		}
		public static final SYS_CODE_EXAMPLE_MULIT_PK $TABLE=new SYS_CODE_EXAMPLE_MULIT_PK();
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
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * Profile,Profile Id 
		*/
		public static final DBField PROFILE_ID = new DBField(DBDataType.STRING , "profile_id","profileId","Profile","Profile Id",false,false,false);
		
		/**
		 * 分类代码,关联 sys_config_catalog 数据字典
		*/
		public static final DBField CATALOG_CODE = new DBField(DBDataType.STRING , "catalog_code","catalogCode","分类代码","关联 sys_config_catalog 数据字典",false,false,true);
		
		/**
		 * 配置键
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","配置键","配置键",false,false,false);
		
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
		
		/**
		 * 上级ID
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","上级ID","上级ID",false,false,true);
		
		public SYS_CONFIG() {
			this.init($NAME,"系统配置表" , ID , PROFILE_ID , CATALOG_CODE , CODE , NAME , TYPE , TYPE_DESC , VALUE , VALID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , PARENT_ID);
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
		
		/**
		 * 有效，是否有效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","有效","是否有效",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		public SYS_DICT_ITEM() {
			this.init($NAME,"数据字典条目" , ID , DICT_ID , DICT_CODE , PARENT_ID , CODE , LABEL , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , VALID , NOTES);
		}
		public static final SYS_DICT_ITEM $TABLE=new SYS_DICT_ITEM();
	}
	
	/**
	 * 离散值信息表
	*/
	public static class SYS_DISCRETE_INFO extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_discrete_info";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.LONG , "id","id","主键","主键",true,false,false);
		
		/**
		 * 离散键
		*/
		public static final DBField DISCRETE_KEY = new DBField(DBDataType.STRING , "discrete_key","discreteKey","离散键","离散键",false,false,true);
		
		/**
		 * 主表
		*/
		public static final DBField MASTER_TABLE = new DBField(DBDataType.STRING , "master_table","masterTable","主表","主表",false,false,true);
		
		/**
		 * 类型：字典,dict;枚举,enum
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","字典,dict;枚举,enum",false,false,true);
		
		/**
		 * 来源，如果是字典填写代码，如果枚举则填写类名
		*/
		public static final DBField SOURCE = new DBField(DBDataType.STRING , "source","source","来源","如果是字典填写代码，如果枚举则填写类名",false,false,true);
		
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
		
		public SYS_DISCRETE_INFO() {
			this.init($NAME,"离散值信息表" , ID , DISCRETE_KEY , MASTER_TABLE , TYPE , SOURCE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_DISCRETE_INFO $TABLE=new SYS_DISCRETE_INFO();
	}
	
	/**
	 * 离散值存储表
	*/
	public static class SYS_DISCRETE_VALUE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_discrete_value";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.LONG , "id","id","主键","主键",true,false,false);
		
		/**
		 * sys_discrete_info表的ID
		*/
		public static final DBField DISCRETE_ID = new DBField(DBDataType.STRING , "discrete_id","discreteId","sys","discrete_info表的ID",false,false,true);
		
		/**
		 * 离散键
		*/
		public static final DBField DISCRETE_KEY = new DBField(DBDataType.STRING , "discrete_key","discreteKey","离散键","离散键",false,false,true);
		
		/**
		 * 主表
		*/
		public static final DBField MASTER_TABLE = new DBField(DBDataType.STRING , "master_table","masterTable","主表","主表",false,false,true);
		
		/**
		 * 主表ID
		*/
		public static final DBField MASTER_ID = new DBField(DBDataType.STRING , "master_id","masterId","主表ID","主表ID",false,false,true);
		
		/**
		 * 代码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","代码","代码",false,false,true);
		
		/**
		 * 文本
		*/
		public static final DBField TEXT = new DBField(DBDataType.STRING , "text","text","文本","文本",false,false,true);
		
		/**
		 * 排序，优先级
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","优先级",false,false,true);
		
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
		
		public SYS_DISCRETE_VALUE() {
			this.init($NAME,"离散值存储表" , ID , DISCRETE_ID , DISCRETE_KEY , MASTER_TABLE , MASTER_ID , CODE , TEXT , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_DISCRETE_VALUE $TABLE=new SYS_DISCRETE_VALUE();
	}
	
	/**
	*/
	public static class SYS_DOCS_DB_UPDATE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_docs_db_update";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.INTEGER , "id","id","主键","主键",true,true,false);
		
		/**
		 * 操作名称；升级操作的名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","操作名称","升级操作的名称",false,false,true);
		
		/**
		 * 表归属，字符串值 foxnic-web、foxnic-eam
		*/
		public static final DBField BELONGS = new DBField(DBDataType.STRING , "belongs","belongs","表归属","字符串值 foxnic-web、foxnic-eam",false,false,false);
		
		/**
		 * 程序版本
		*/
		public static final DBField PROG_VERSION = new DBField(DBDataType.STRING , "prog_version","progVersion","程序版本","程序版本",false,false,true);
		
		/**
		 * Git分支
		*/
		public static final DBField GIT_BRANCH = new DBField(DBDataType.STRING , "git_branch","gitBranch","Git分支","Git分支",false,false,true);
		
		/**
		 * 语句
		*/
		public static final DBField STATEMEMT = new DBField(DBDataType.STRING , "statememt","statememt","语句","语句",false,false,true);
		
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
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,false);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,false);
		
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
		
		public SYS_DOCS_DB_UPDATE() {
			this.init($NAME,"" , ID , NAME , BELONGS , PROG_VERSION , GIT_BRANCH , STATEMEMT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_DOCS_DB_UPDATE $TABLE=new SYS_DOCS_DB_UPDATE();
	}
	
	/**
	*/
	public static class SYS_DOCS_TABLE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_docs_table";
		
		/**
		 * 表名
		*/
		public static final DBField TABLE_NAME = new DBField(DBDataType.STRING , "table_name","tableName","表名","表名",true,false,false);
		
		/**
		 * 表归属，字符串值 foxnic-web、foxnic-eam
		*/
		public static final DBField BELONGS = new DBField(DBDataType.STRING , "belongs","belongs","表归属","字符串值 foxnic-web、foxnic-eam",false,false,false);
		
		public SYS_DOCS_TABLE() {
			this.init($NAME,"" , TABLE_NAME , BELONGS);
		}
		public static final SYS_DOCS_TABLE $TABLE=new SYS_DOCS_TABLE();
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
		public static final DBField START_TIME = new DBField(DBDataType.TIMESTAMP , "start_time","startTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField END_TIME = new DBField(DBDataType.TIMESTAMP , "end_time","endTime","结束时间","结束时间",false,false,true);
		
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
	 * 定时任务配置表
	*/
	public static class SYS_JOB extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_job";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 代码，任务代码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","代码","任务代码",false,false,true);
		
		/**
		 * 任务名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","任务名称","任务名称",false,false,true);
		
		/**
		 * 组别
		*/
		public static final DBField GROUP_TAG = new DBField(DBDataType.STRING , "group_tag","groupTag","组别","组别",false,false,true);
		
		/**
		 * 执行类ID
		*/
		public static final DBField WORKER_ID = new DBField(DBDataType.STRING , "worker_id","workerId","执行类ID","执行类ID",false,false,true);
		
		/**
		 * cron表达式
		*/
		public static final DBField CRON_EXPR = new DBField(DBDataType.STRING , "cron_expr","cronExpr","cron表达式","cron表达式",false,false,true);
		
		/**
		 * 执行参数，JSON对象格式
		*/
		public static final DBField PARAMETER = new DBField(DBDataType.STRING , "parameter","parameter","执行参数","JSON对象格式",false,false,true);
		
		/**
		 * 是否并发执行（0允许 1禁止）
		*/
		public static final DBField CONCURRENT = new DBField(DBDataType.INTEGER , "concurrent","concurrent","是否并发执行","0允许 1禁止）",false,false,false);
		
		/**
		 * 遗漏执行的策略
		*/
		public static final DBField MISFIRE_POLICY = new DBField(DBDataType.STRING , "misfire_policy","misfirePolicy","遗漏执行的策略","遗漏执行的策略",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
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
		
		public SYS_JOB() {
			this.init($NAME,"定时任务配置表" , ID , CODE , NAME , GROUP_TAG , WORKER_ID , CRON_EXPR , PARAMETER , CONCURRENT , MISFIRE_POLICY , STATUS , NOTES , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_JOB $TABLE=new SYS_JOB();
	}
	
	/**
	*/
	public static class SYS_JOB_BLOB_TRIGGERS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_job_blob_triggers";
		
		/**
		*/
		public static final DBField SCHED_NAME = new DBField(DBDataType.STRING , "sched_name","schedName","sched_name","sched_name",true,false,false);
		
		/**
		*/
		public static final DBField TRIGGER_NAME = new DBField(DBDataType.STRING , "trigger_name","triggerName","trigger_name","trigger_name",true,false,false);
		
		/**
		*/
		public static final DBField TRIGGER_GROUP = new DBField(DBDataType.STRING , "trigger_group","triggerGroup","trigger_group","trigger_group",true,false,false);
		
		/**
		*/
		public static final DBField BLOB_DATA = new DBField(DBDataType.BLOB , "blob_data","blobData","blob_data","blob_data",false,false,true);
		
		public SYS_JOB_BLOB_TRIGGERS() {
			this.init($NAME,"" , SCHED_NAME , TRIGGER_NAME , TRIGGER_GROUP , BLOB_DATA);
		}
		public static final SYS_JOB_BLOB_TRIGGERS $TABLE=new SYS_JOB_BLOB_TRIGGERS();
	}
	
	/**
	*/
	public static class SYS_JOB_CALENDARS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_job_calendars";
		
		/**
		*/
		public static final DBField SCHED_NAME = new DBField(DBDataType.STRING , "sched_name","schedName","sched_name","sched_name",true,false,false);
		
		/**
		*/
		public static final DBField CALENDAR_NAME = new DBField(DBDataType.STRING , "calendar_name","calendarName","calendar_name","calendar_name",true,false,false);
		
		/**
		*/
		public static final DBField CALENDAR = new DBField(DBDataType.BLOB , "calendar","calendar","calendar","calendar",false,false,false);
		
		public SYS_JOB_CALENDARS() {
			this.init($NAME,"" , SCHED_NAME , CALENDAR_NAME , CALENDAR);
		}
		public static final SYS_JOB_CALENDARS $TABLE=new SYS_JOB_CALENDARS();
	}
	
	/**
	*/
	public static class SYS_JOB_CRON_TRIGGERS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_job_cron_triggers";
		
		/**
		*/
		public static final DBField SCHED_NAME = new DBField(DBDataType.STRING , "sched_name","schedName","sched_name","sched_name",true,false,false);
		
		/**
		*/
		public static final DBField TRIGGER_NAME = new DBField(DBDataType.STRING , "trigger_name","triggerName","trigger_name","trigger_name",true,false,false);
		
		/**
		*/
		public static final DBField TRIGGER_GROUP = new DBField(DBDataType.STRING , "trigger_group","triggerGroup","trigger_group","trigger_group",true,false,false);
		
		/**
		*/
		public static final DBField CRON_EXPRESSION = new DBField(DBDataType.STRING , "cron_expression","cronExpression","cron_expression","cron_expression",false,false,false);
		
		/**
		*/
		public static final DBField TIME_ZONE_ID = new DBField(DBDataType.STRING , "time_zone_id","timeZoneId","time_zone_id","time_zone_id",false,false,true);
		
		public SYS_JOB_CRON_TRIGGERS() {
			this.init($NAME,"" , SCHED_NAME , TRIGGER_NAME , TRIGGER_GROUP , CRON_EXPRESSION , TIME_ZONE_ID);
		}
		public static final SYS_JOB_CRON_TRIGGERS $TABLE=new SYS_JOB_CRON_TRIGGERS();
	}
	
	/**
	*/
	public static class SYS_JOB_FIRED_TRIGGERS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_job_fired_triggers";
		
		/**
		*/
		public static final DBField SCHED_NAME = new DBField(DBDataType.STRING , "sched_name","schedName","sched_name","sched_name",true,false,false);
		
		/**
		*/
		public static final DBField ENTRY_ID = new DBField(DBDataType.STRING , "entry_id","entryId","entry_id","entry_id",true,false,false);
		
		/**
		*/
		public static final DBField TRIGGER_NAME = new DBField(DBDataType.STRING , "trigger_name","triggerName","trigger_name","trigger_name",false,false,false);
		
		/**
		*/
		public static final DBField TRIGGER_GROUP = new DBField(DBDataType.STRING , "trigger_group","triggerGroup","trigger_group","trigger_group",false,false,false);
		
		/**
		*/
		public static final DBField INSTANCE_NAME = new DBField(DBDataType.STRING , "instance_name","instanceName","instance_name","instance_name",false,false,false);
		
		/**
		*/
		public static final DBField FIRED_TIME = new DBField(DBDataType.LONG , "fired_time","firedTime","fired_time","fired_time",false,false,false);
		
		/**
		*/
		public static final DBField SCHED_TIME = new DBField(DBDataType.LONG , "sched_time","schedTime","sched_time","sched_time",false,false,false);
		
		/**
		*/
		public static final DBField PRIORITY = new DBField(DBDataType.INTEGER , "priority","priority","priority","priority",false,false,false);
		
		/**
		*/
		public static final DBField STATE = new DBField(DBDataType.STRING , "state","state","state","state",false,false,false);
		
		/**
		*/
		public static final DBField JOB_NAME = new DBField(DBDataType.STRING , "job_name","jobName","job_name","job_name",false,false,true);
		
		/**
		*/
		public static final DBField JOB_GROUP = new DBField(DBDataType.STRING , "job_group","jobGroup","job_group","job_group",false,false,true);
		
		/**
		*/
		public static final DBField IS_NONCONCURRENT = new DBField(DBDataType.STRING , "is_nonconcurrent","isNonconcurrent","is_nonconcurrent","is_nonconcurrent",false,false,true);
		
		/**
		*/
		public static final DBField REQUESTS_RECOVERY = new DBField(DBDataType.STRING , "requests_recovery","requestsRecovery","requests_recovery","requests_recovery",false,false,true);
		
		public SYS_JOB_FIRED_TRIGGERS() {
			this.init($NAME,"" , SCHED_NAME , ENTRY_ID , TRIGGER_NAME , TRIGGER_GROUP , INSTANCE_NAME , FIRED_TIME , SCHED_TIME , PRIORITY , STATE , JOB_NAME , JOB_GROUP , IS_NONCONCURRENT , REQUESTS_RECOVERY);
		}
		public static final SYS_JOB_FIRED_TRIGGERS $TABLE=new SYS_JOB_FIRED_TRIGGERS();
	}
	
	/**
	*/
	public static class SYS_JOB_JOB_DETAILS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_job_job_details";
		
		/**
		*/
		public static final DBField SCHED_NAME = new DBField(DBDataType.STRING , "sched_name","schedName","sched_name","sched_name",true,false,false);
		
		/**
		*/
		public static final DBField JOB_NAME = new DBField(DBDataType.STRING , "job_name","jobName","job_name","job_name",true,false,false);
		
		/**
		*/
		public static final DBField JOB_GROUP = new DBField(DBDataType.STRING , "job_group","jobGroup","job_group","job_group",true,false,false);
		
		/**
		*/
		public static final DBField DESCRIPTION = new DBField(DBDataType.STRING , "description","description","description","description",false,false,true);
		
		/**
		*/
		public static final DBField JOB_CLASS_NAME = new DBField(DBDataType.STRING , "job_class_name","jobClassName","job_class_name","job_class_name",false,false,false);
		
		/**
		*/
		public static final DBField IS_DURABLE = new DBField(DBDataType.STRING , "is_durable","isDurable","is_durable","is_durable",false,false,false);
		
		/**
		*/
		public static final DBField IS_NONCONCURRENT = new DBField(DBDataType.STRING , "is_nonconcurrent","isNonconcurrent","is_nonconcurrent","is_nonconcurrent",false,false,false);
		
		/**
		*/
		public static final DBField IS_UPDATE_DATA = new DBField(DBDataType.STRING , "is_update_data","isUpdateData","is_update_data","is_update_data",false,false,false);
		
		/**
		*/
		public static final DBField REQUESTS_RECOVERY = new DBField(DBDataType.STRING , "requests_recovery","requestsRecovery","requests_recovery","requests_recovery",false,false,false);
		
		/**
		*/
		public static final DBField JOB_DATA = new DBField(DBDataType.BLOB , "job_data","jobData","job_data","job_data",false,false,true);
		
		public SYS_JOB_JOB_DETAILS() {
			this.init($NAME,"" , SCHED_NAME , JOB_NAME , JOB_GROUP , DESCRIPTION , JOB_CLASS_NAME , IS_DURABLE , IS_NONCONCURRENT , IS_UPDATE_DATA , REQUESTS_RECOVERY , JOB_DATA);
		}
		public static final SYS_JOB_JOB_DETAILS $TABLE=new SYS_JOB_JOB_DETAILS();
	}
	
	/**
	*/
	public static class SYS_JOB_LOCKS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_job_locks";
		
		/**
		*/
		public static final DBField SCHED_NAME = new DBField(DBDataType.STRING , "sched_name","schedName","sched_name","sched_name",true,false,false);
		
		/**
		*/
		public static final DBField LOCK_NAME = new DBField(DBDataType.STRING , "lock_name","lockName","lock_name","lock_name",true,false,false);
		
		public SYS_JOB_LOCKS() {
			this.init($NAME,"" , SCHED_NAME , LOCK_NAME);
		}
		public static final SYS_JOB_LOCKS $TABLE=new SYS_JOB_LOCKS();
	}
	
	/**
	 * 定时任务执行日志表
	*/
	public static class SYS_JOB_LOG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_job_log";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 组别
		*/
		public static final DBField JOB_ID = new DBField(DBDataType.STRING , "job_id","jobId","组别","组别",false,false,true);
		
		/**
		 * 日志分类
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","日志分类","日志分类",false,false,true);
		
		/**
		 * 任务名称
		*/
		public static final DBField JOB_NAME = new DBField(DBDataType.STRING , "job_name","jobName","任务名称","任务名称",false,false,true);
		
		/**
		 * 本次执行类
		*/
		public static final DBField CLASS_NAME = new DBField(DBDataType.STRING , "class_name","className","本次执行类","本次执行类",false,false,true);
		
		/**
		 * 本次执行cron表达式
		*/
		public static final DBField CRON_EXPR = new DBField(DBDataType.STRING , "cron_expr","cronExpr","本次执行cron表达式","本次执行cron表达式",false,false,true);
		
		/**
		 * 本次执行参数
		*/
		public static final DBField PARAMETER = new DBField(DBDataType.STRING , "parameter","parameter","本次执行参数","本次执行参数",false,false,true);
		
		/**
		 * 是否成功执行
		*/
		public static final DBField SUCCESS = new DBField(DBDataType.INTEGER , "success","success","是否成功执行","是否成功执行",false,false,true);
		
		/**
		 * 执行结果，可记录大文本信息
		*/
		public static final DBField RESULT = new DBField(DBDataType.STRING , "result","result","执行结果","可记录大文本信息",false,false,true);
		
		/**
		 * 开始执行的时间
		*/
		public static final DBField BEGIN_TIME = new DBField(DBDataType.TIMESTAMP , "begin_time","beginTime","开始执行的时间","开始执行的时间",false,false,true);
		
		/**
		 * 结束执行的时间
		*/
		public static final DBField END_TIME = new DBField(DBDataType.TIMESTAMP , "end_time","endTime","结束执行的时间","结束执行的时间",false,false,true);
		
		/**
		 * 执行耗时
		*/
		public static final DBField COST = new DBField(DBDataType.LONG , "cost","cost","执行耗时","执行耗时",false,false,true);
		
		/**
		 * 异常信息
		*/
		public static final DBField EXCEPTION = new DBField(DBDataType.STRING , "exception","exception","异常信息","异常信息",false,false,true);
		
		/**
		 * 日志信息
		*/
		public static final DBField LOG_TEXT = new DBField(DBDataType.STRING , "log_text","logText","日志信息","日志信息",false,false,true);
		
		/**
		 * 账户ID，操作人ID
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","账户ID","操作人ID",false,false,true);
		
		/**
		 * 是否是手动执行
		*/
		public static final DBField IS_MANUAL = new DBField(DBDataType.INTEGER , "is_manual","isManual","是否是手动执行","是否是手动执行",false,false,true);
		
		/**
		 * 是否为丢失补充执行
		*/
		public static final DBField IS_MISSFIRE = new DBField(DBDataType.INTEGER , "is_missfire","isMissfire","是否为丢失补充执行","是否为丢失补充执行",false,false,true);
		
		/**
		 * 是否并发执行（0允许 1禁止）
		*/
		public static final DBField CONCURRENT = new DBField(DBDataType.INTEGER , "concurrent","concurrent","是否并发执行","0允许 1禁止）",false,false,true);
		
		/**
		 * 遗漏执行的策略
		*/
		public static final DBField MISFIRE_POLICY = new DBField(DBDataType.STRING , "misfire_policy","misfirePolicy","遗漏执行的策略","遗漏执行的策略",false,false,true);
		
		/**
		 * 日志跟踪ID
		*/
		public static final DBField TID = new DBField(DBDataType.STRING , "tid","tid","日志跟踪ID","日志跟踪ID",false,false,true);
		
		/**
		 * 节点ID，job实际运行的节点ID
		*/
		public static final DBField NODE_ID = new DBField(DBDataType.STRING , "node_id","nodeId","节点ID","job实际运行的节点ID",false,false,true);
		
		public SYS_JOB_LOG() {
			this.init($NAME,"定时任务执行日志表" , ID , JOB_ID , TYPE , JOB_NAME , CLASS_NAME , CRON_EXPR , PARAMETER , SUCCESS , RESULT , BEGIN_TIME , END_TIME , COST , EXCEPTION , LOG_TEXT , USER_ID , IS_MANUAL , IS_MISSFIRE , CONCURRENT , MISFIRE_POLICY , TID , NODE_ID);
		}
		public static final SYS_JOB_LOG $TABLE=new SYS_JOB_LOG();
	}
	
	/**
	*/
	public static class SYS_JOB_PAUSED_TRIGGER_GRPS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_job_paused_trigger_grps";
		
		/**
		*/
		public static final DBField SCHED_NAME = new DBField(DBDataType.STRING , "sched_name","schedName","sched_name","sched_name",true,false,false);
		
		/**
		*/
		public static final DBField TRIGGER_GROUP = new DBField(DBDataType.STRING , "trigger_group","triggerGroup","trigger_group","trigger_group",true,false,false);
		
		public SYS_JOB_PAUSED_TRIGGER_GRPS() {
			this.init($NAME,"" , SCHED_NAME , TRIGGER_GROUP);
		}
		public static final SYS_JOB_PAUSED_TRIGGER_GRPS $TABLE=new SYS_JOB_PAUSED_TRIGGER_GRPS();
	}
	
	/**
	*/
	public static class SYS_JOB_SCHEDULER_STATE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_job_scheduler_state";
		
		/**
		*/
		public static final DBField SCHED_NAME = new DBField(DBDataType.STRING , "sched_name","schedName","sched_name","sched_name",true,false,false);
		
		/**
		*/
		public static final DBField INSTANCE_NAME = new DBField(DBDataType.STRING , "instance_name","instanceName","instance_name","instance_name",true,false,false);
		
		/**
		*/
		public static final DBField LAST_CHECKIN_TIME = new DBField(DBDataType.LONG , "last_checkin_time","lastCheckinTime","last_checkin_time","last_checkin_time",false,false,false);
		
		/**
		*/
		public static final DBField CHECKIN_INTERVAL = new DBField(DBDataType.LONG , "checkin_interval","checkinInterval","checkin_interval","checkin_interval",false,false,false);
		
		public SYS_JOB_SCHEDULER_STATE() {
			this.init($NAME,"" , SCHED_NAME , INSTANCE_NAME , LAST_CHECKIN_TIME , CHECKIN_INTERVAL);
		}
		public static final SYS_JOB_SCHEDULER_STATE $TABLE=new SYS_JOB_SCHEDULER_STATE();
	}
	
	/**
	*/
	public static class SYS_JOB_SIMPLE_TRIGGERS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_job_simple_triggers";
		
		/**
		*/
		public static final DBField SCHED_NAME = new DBField(DBDataType.STRING , "sched_name","schedName","sched_name","sched_name",true,false,false);
		
		/**
		*/
		public static final DBField TRIGGER_NAME = new DBField(DBDataType.STRING , "trigger_name","triggerName","trigger_name","trigger_name",true,false,false);
		
		/**
		*/
		public static final DBField TRIGGER_GROUP = new DBField(DBDataType.STRING , "trigger_group","triggerGroup","trigger_group","trigger_group",true,false,false);
		
		/**
		*/
		public static final DBField REPEAT_COUNT = new DBField(DBDataType.LONG , "repeat_count","repeatCount","repeat_count","repeat_count",false,false,false);
		
		/**
		*/
		public static final DBField REPEAT_INTERVAL = new DBField(DBDataType.LONG , "repeat_interval","repeatInterval","repeat_interval","repeat_interval",false,false,false);
		
		/**
		*/
		public static final DBField TIMES_TRIGGERED = new DBField(DBDataType.LONG , "times_triggered","timesTriggered","times_triggered","times_triggered",false,false,false);
		
		public SYS_JOB_SIMPLE_TRIGGERS() {
			this.init($NAME,"" , SCHED_NAME , TRIGGER_NAME , TRIGGER_GROUP , REPEAT_COUNT , REPEAT_INTERVAL , TIMES_TRIGGERED);
		}
		public static final SYS_JOB_SIMPLE_TRIGGERS $TABLE=new SYS_JOB_SIMPLE_TRIGGERS();
	}
	
	/**
	*/
	public static class SYS_JOB_SIMPROP_TRIGGERS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_job_simprop_triggers";
		
		/**
		*/
		public static final DBField SCHED_NAME = new DBField(DBDataType.STRING , "sched_name","schedName","sched_name","sched_name",true,false,false);
		
		/**
		*/
		public static final DBField TRIGGER_NAME = new DBField(DBDataType.STRING , "trigger_name","triggerName","trigger_name","trigger_name",true,false,false);
		
		/**
		*/
		public static final DBField TRIGGER_GROUP = new DBField(DBDataType.STRING , "trigger_group","triggerGroup","trigger_group","trigger_group",true,false,false);
		
		/**
		*/
		public static final DBField STR_PROP_1 = new DBField(DBDataType.STRING , "str_prop_1","strProp1","str_prop_1","str_prop_1",false,false,true);
		
		/**
		*/
		public static final DBField STR_PROP_2 = new DBField(DBDataType.STRING , "str_prop_2","strProp2","str_prop_2","str_prop_2",false,false,true);
		
		/**
		*/
		public static final DBField STR_PROP_3 = new DBField(DBDataType.STRING , "str_prop_3","strProp3","str_prop_3","str_prop_3",false,false,true);
		
		/**
		*/
		public static final DBField INT_PROP_1 = new DBField(DBDataType.INTEGER , "int_prop_1","intProp1","int_prop_1","int_prop_1",false,false,true);
		
		/**
		*/
		public static final DBField INT_PROP_2 = new DBField(DBDataType.INTEGER , "int_prop_2","intProp2","int_prop_2","int_prop_2",false,false,true);
		
		/**
		*/
		public static final DBField LONG_PROP_1 = new DBField(DBDataType.LONG , "long_prop_1","longProp1","long_prop_1","long_prop_1",false,false,true);
		
		/**
		*/
		public static final DBField LONG_PROP_2 = new DBField(DBDataType.LONG , "long_prop_2","longProp2","long_prop_2","long_prop_2",false,false,true);
		
		/**
		*/
		public static final DBField DEC_PROP_1 = new DBField(DBDataType.DECIMAL , "dec_prop_1","decProp1","dec_prop_1","dec_prop_1",false,false,true);
		
		/**
		*/
		public static final DBField DEC_PROP_2 = new DBField(DBDataType.DECIMAL , "dec_prop_2","decProp2","dec_prop_2","dec_prop_2",false,false,true);
		
		/**
		*/
		public static final DBField BOOL_PROP_1 = new DBField(DBDataType.STRING , "bool_prop_1","boolProp1","bool_prop_1","bool_prop_1",false,false,true);
		
		/**
		*/
		public static final DBField BOOL_PROP_2 = new DBField(DBDataType.STRING , "bool_prop_2","boolProp2","bool_prop_2","bool_prop_2",false,false,true);
		
		public SYS_JOB_SIMPROP_TRIGGERS() {
			this.init($NAME,"" , SCHED_NAME , TRIGGER_NAME , TRIGGER_GROUP , STR_PROP_1 , STR_PROP_2 , STR_PROP_3 , INT_PROP_1 , INT_PROP_2 , LONG_PROP_1 , LONG_PROP_2 , DEC_PROP_1 , DEC_PROP_2 , BOOL_PROP_1 , BOOL_PROP_2);
		}
		public static final SYS_JOB_SIMPROP_TRIGGERS $TABLE=new SYS_JOB_SIMPROP_TRIGGERS();
	}
	
	/**
	*/
	public static class SYS_JOB_TRIGGERS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_job_triggers";
		
		/**
		*/
		public static final DBField SCHED_NAME = new DBField(DBDataType.STRING , "sched_name","schedName","sched_name","sched_name",true,false,false);
		
		/**
		*/
		public static final DBField TRIGGER_NAME = new DBField(DBDataType.STRING , "trigger_name","triggerName","trigger_name","trigger_name",true,false,false);
		
		/**
		*/
		public static final DBField TRIGGER_GROUP = new DBField(DBDataType.STRING , "trigger_group","triggerGroup","trigger_group","trigger_group",true,false,false);
		
		/**
		*/
		public static final DBField JOB_NAME = new DBField(DBDataType.STRING , "job_name","jobName","job_name","job_name",false,false,false);
		
		/**
		*/
		public static final DBField JOB_GROUP = new DBField(DBDataType.STRING , "job_group","jobGroup","job_group","job_group",false,false,false);
		
		/**
		*/
		public static final DBField DESCRIPTION = new DBField(DBDataType.STRING , "description","description","description","description",false,false,true);
		
		/**
		*/
		public static final DBField NEXT_FIRE_TIME = new DBField(DBDataType.LONG , "next_fire_time","nextFireTime","next_fire_time","next_fire_time",false,false,true);
		
		/**
		*/
		public static final DBField PREV_FIRE_TIME = new DBField(DBDataType.LONG , "prev_fire_time","prevFireTime","prev_fire_time","prev_fire_time",false,false,true);
		
		/**
		*/
		public static final DBField PRIORITY = new DBField(DBDataType.INTEGER , "priority","priority","priority","priority",false,false,true);
		
		/**
		*/
		public static final DBField TRIGGER_STATE = new DBField(DBDataType.STRING , "trigger_state","triggerState","trigger_state","trigger_state",false,false,false);
		
		/**
		*/
		public static final DBField TRIGGER_TYPE = new DBField(DBDataType.STRING , "trigger_type","triggerType","trigger_type","trigger_type",false,false,false);
		
		/**
		*/
		public static final DBField START_TIME = new DBField(DBDataType.LONG , "start_time","startTime","start_time","start_time",false,false,false);
		
		/**
		*/
		public static final DBField END_TIME = new DBField(DBDataType.LONG , "end_time","endTime","end_time","end_time",false,false,true);
		
		/**
		*/
		public static final DBField CALENDAR_NAME = new DBField(DBDataType.STRING , "calendar_name","calendarName","calendar_name","calendar_name",false,false,true);
		
		/**
		*/
		public static final DBField MISFIRE_INSTR = new DBField(DBDataType.INTEGER , "misfire_instr","misfireInstr","misfire_instr","misfire_instr",false,false,true);
		
		/**
		*/
		public static final DBField JOB_DATA = new DBField(DBDataType.BLOB , "job_data","jobData","job_data","job_data",false,false,true);
		
		public SYS_JOB_TRIGGERS() {
			this.init($NAME,"" , SCHED_NAME , TRIGGER_NAME , TRIGGER_GROUP , JOB_NAME , JOB_GROUP , DESCRIPTION , NEXT_FIRE_TIME , PREV_FIRE_TIME , PRIORITY , TRIGGER_STATE , TRIGGER_TYPE , START_TIME , END_TIME , CALENDAR_NAME , MISFIRE_INSTR , JOB_DATA);
		}
		public static final SYS_JOB_TRIGGERS $TABLE=new SYS_JOB_TRIGGERS();
	}
	
	/**
	 * 任务执行器
	*/
	public static class SYS_JOB_WORKER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_job_worker";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 类名
		*/
		public static final DBField CLASS_NAME = new DBField(DBDataType.STRING , "class_name","className","类名","类名",false,false,true);
		
		/**
		 * 有效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","有效","有效",false,false,true);
		
		public SYS_JOB_WORKER() {
			this.init($NAME,"任务执行器" , ID , NAME , CLASS_NAME , VALID);
		}
		public static final SYS_JOB_WORKER $TABLE=new SYS_JOB_WORKER();
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
		public static final DBField DEFAULTS = new DBField(DBDataType.STRING , "defaults","defaults","默认","默认",false,false,false);
		
		/**
		 * 语境
		*/
		public static final DBField CONTEXT = new DBField(DBDataType.STRING , "context","context","语境","语境",false,false,false);
		
		/**
		 * 简体中文
		*/
		public static final DBField ZH_CN = new DBField(DBDataType.STRING , "zh_cn","zhCn","简体中文","简体中文",false,false,true);
		
		/**
		 * 中文(香港)
		*/
		public static final DBField ZH_HK = new DBField(DBDataType.STRING , "zh_hk","zhHk","中文","香港)",false,false,true);
		
		/**
		 * 中文(澳门)
		*/
		public static final DBField ZH_MO = new DBField(DBDataType.STRING , "zh_mo","zhMo","中文","澳门)",false,false,true);
		
		/**
		 * 中文(台湾)
		*/
		public static final DBField ZH_TW = new DBField(DBDataType.STRING , "zh_tw","zhTw","中文","台湾)",false,false,true);
		
		/**
		 * 英文美国
		*/
		public static final DBField EN_US = new DBField(DBDataType.STRING , "en_us","enUs","英文美国","英文美国",false,false,true);
		
		/**
		 * 英文英国
		*/
		public static final DBField EN_GB = new DBField(DBDataType.STRING , "en_gb","enGb","英文英国","英文英国",false,false,true);
		
		/**
		 * 韩语
		*/
		public static final DBField KO_KR = new DBField(DBDataType.STRING , "ko_kr","koKr","韩语","韩语",false,false,true);
		
		/**
		 * 日语
		*/
		public static final DBField JA_JP = new DBField(DBDataType.STRING , "ja_jp","jaJp","日语","日语",false,false,true);
		
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
		
		/**
		 * 已翻译
		*/
		public static final DBField AUTO_TRANSLATED = new DBField(DBDataType.INTEGER , "auto_translated","autoTranslated","已翻译","已翻译",false,false,true);
		
		public SYS_LANG() {
			this.init($NAME,"语言条目表" , CODE , DEFAULTS , CONTEXT , ZH_CN , ZH_HK , ZH_MO , ZH_TW , EN_US , EN_GB , KO_KR , JA_JP , CONFUSE , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , AUTO_TRANSLATED);
		}
		public static final SYS_LANG $TABLE=new SYS_LANG();
	}
	
	/**
	 * Licence授权配置表
	*/
	public static class SYS_LICENCE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_licence";
		
		/**
		 * 键
		*/
		public static final DBField XKEY = new DBField(DBDataType.STRING , "xkey","xkey","键","键",true,false,false);
		
		/**
		 * 值
		*/
		public static final DBField DATA = new DBField(DBDataType.STRING , "data","data","值","值",false,false,true);
		
		/**
		 * 导入时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","导入时间","导入时间",false,false,true);
		
		public SYS_LICENCE() {
			this.init($NAME,"Licence授权配置表" , XKEY , DATA , CREATE_TIME);
		}
		public static final SYS_LICENCE $TABLE=new SYS_LICENCE();
	}
	
	/**
	*/
	public static class SYS_LICENCE_COM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_licence_com";
		
		/**
		 * 键
		*/
		public static final DBField XKEY = new DBField(DBDataType.STRING , "xkey","xkey","键","键",false,false,false);
		
		/**
		 * 值
		*/
		public static final DBField DATA = new DBField(DBDataType.STRING , "data","data","值","值",false,false,true);
		
		/**
		 * 导入时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","导入时间","导入时间",false,false,true);
		
		public SYS_LICENCE_COM() {
			this.init($NAME,"" , XKEY , DATA , CREATE_TIME);
		}
		public static final SYS_LICENCE_COM $TABLE=new SYS_LICENCE_COM();
	}
	
	/**
	*/
	public static class SYS_LICENCE_DEV extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_licence_dev";
		
		/**
		 * 键
		*/
		public static final DBField XKEY = new DBField(DBDataType.STRING , "xkey","xkey","键","键",false,false,false);
		
		/**
		 * 值
		*/
		public static final DBField DATA = new DBField(DBDataType.STRING , "data","data","值","值",false,false,true);
		
		/**
		 * 导入时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","导入时间","导入时间",false,false,true);
		
		public SYS_LICENCE_DEV() {
			this.init($NAME,"" , XKEY , DATA , CREATE_TIME);
		}
		public static final SYS_LICENCE_DEV $TABLE=new SYS_LICENCE_DEV();
	}
	
	/**
	*/
	public static class SYS_LICENCE_FREE_FULL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_licence_free_full";
		
		/**
		 * 键
		*/
		public static final DBField XKEY = new DBField(DBDataType.STRING , "xkey","xkey","键","键",false,false,false);
		
		/**
		 * 值
		*/
		public static final DBField DATA = new DBField(DBDataType.STRING , "data","data","值","值",false,false,true);
		
		/**
		 * 导入时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","导入时间","导入时间",false,false,true);
		
		public SYS_LICENCE_FREE_FULL() {
			this.init($NAME,"" , XKEY , DATA , CREATE_TIME);
		}
		public static final SYS_LICENCE_FREE_FULL $TABLE=new SYS_LICENCE_FREE_FULL();
	}
	
	/**
	 * 版本切换
	*/
	public static class SYS_LICENCE_SWITCH extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_licence_switch";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 许可版本
		*/
		public static final DBField LICENCE_TAB = new DBField(DBDataType.STRING , "licence_tab","licenceTab","许可版本","许可版本",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 动作
		*/
		public static final DBField ACTION_CONTENT = new DBField(DBDataType.STRING , "action_content","actionContent","动作","动作",false,false,true);
		
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
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public SYS_LICENCE_SWITCH() {
			this.init($NAME,"版本切换" , ID , LICENCE_TAB , STATUS , ACTION_CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_LICENCE_SWITCH $TABLE=new SYS_LICENCE_SWITCH();
	}
	
	/**
	*/
	public static class SYS_LICENCE_TRY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_licence_try";
		
		/**
		 * 键
		*/
		public static final DBField XKEY = new DBField(DBDataType.STRING , "xkey","xkey","键","键",false,false,false);
		
		/**
		 * 值
		*/
		public static final DBField DATA = new DBField(DBDataType.STRING , "data","data","值","值",false,false,true);
		
		/**
		 * 导入时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","导入时间","导入时间",false,false,true);
		
		public SYS_LICENCE_TRY() {
			this.init($NAME,"" , XKEY , DATA , CREATE_TIME);
		}
		public static final SYS_LICENCE_TRY $TABLE=new SYS_LICENCE_TRY();
	}
	
	/**
	 * 日志收集
	*/
	public static class SYS_LOG_COLLECT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_log_collect";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 范围
		*/
		public static final DBField COLLECT_RANGE = new DBField(DBDataType.STRING , "collect_range","collectRange","范围","范围",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
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
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public SYS_LOG_COLLECT() {
			this.init($NAME,"日志收集" , ID , COLLECT_RANGE , STATUS , FILE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_LOG_COLLECT $TABLE=new SYS_LOG_COLLECT();
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
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 连接类型，外部链接、内部链接等
		*/
		public static final DBField LINK_TYPE = new DBField(DBDataType.STRING , "link_type","linkType","连接类型","外部链接、内部链接等",false,false,true);
		
		/**
		 * 打开方式，Tab页或新窗口等
		*/
		public static final DBField OPEN_TYPE = new DBField(DBDataType.STRING , "open_type","openType","打开方式","Tab页或新窗口等",false,false,true);
		
		/**
		 * 外部链接
		*/
		public static final DBField EXTRA_URL = new DBField(DBDataType.STRING , "extra_url","extraUrl","外部链接","外部链接",false,false,true);
		
		public SYS_MENU() {
			this.init($NAME,"菜单表" , ID , BATCH_ID , AUTHORITY , HIDDEN , CSS , LABEL , TYPE , PATH_RESOURCE_ID , URL , PARAMS , PARENT_ID , DYNAMIC_HANDLER , HIERARCHY , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , NOTES , LINK_TYPE , OPEN_TYPE , EXTRA_URL);
		}
		public static final SYS_MENU $TABLE=new SYS_MENU();
	}
	
	/**
	 * 菜单功能分版本实现配置表
	*/
	public static class SYS_MENU_FORK extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_menu_fork";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 菜单ID
		*/
		public static final DBField MENU_ID = new DBField(DBDataType.STRING , "menu_id","menuId","菜单ID","菜单ID",false,false,true);
		
		/**
		 * 目录名称
		*/
		public static final DBField DIR = new DBField(DBDataType.STRING , "dir","dir","目录名称","目录名称",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
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
		
		public SYS_MENU_FORK() {
			this.init($NAME,"菜单功能分版本实现配置表" , ID , MENU_ID , DIR , NAME , NOTES , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_MENU_FORK $TABLE=new SYS_MENU_FORK();
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
	 * MQ日志表
	*/
	public static class SYS_MQ_LOG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_mq_log";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.LONG , "id","id","主键","主键",true,false,false);
		
		/**
		 * MQ队列名；或主题名
		*/
		public static final DBField DESTINATION = new DBField(DBDataType.STRING , "destination","destination","MQ队列名","或主题名",false,false,true);
		
		/**
		 * MQ消息类型
		*/
		public static final DBField MESSAGE_TYPE = new DBField(DBDataType.STRING , "message_type","messageType","MQ消息类型","MQ消息类型",false,false,true);
		
		/**
		 * 消息内容
		*/
		public static final DBField MESSAGE = new DBField(DBDataType.STRING , "message","message","消息内容","消息内容",false,false,true);
		
		/**
		*/
		public static final DBField RECEIVE_TIME = new DBField(DBDataType.TIMESTAMP , "receive_time","receiveTime","receive_time","receive_time",false,false,true);
		
		/**
		*/
		public static final DBField FINISH_TIME = new DBField(DBDataType.TIMESTAMP , "finish_time","finishTime","finish_time","finish_time",false,false,true);
		
		/**
		 * 是否处理成功
		*/
		public static final DBField SUCCESS = new DBField(DBDataType.INTEGER , "success","success","是否处理成功","是否处理成功",false,false,true);
		
		/**
		 * 处理结果
		*/
		public static final DBField RESULT = new DBField(DBDataType.STRING , "result","result","处理结果","处理结果",false,false,true);
		
		/**
		 * 异常信息
		*/
		public static final DBField ERRORS = new DBField(DBDataType.STRING , "errors","errors","异常信息","异常信息",false,false,true);
		
		public SYS_MQ_LOG() {
			this.init($NAME,"MQ日志表" , ID , DESTINATION , MESSAGE_TYPE , MESSAGE , RECEIVE_TIME , FINISH_TIME , SUCCESS , RESULT , ERRORS);
		}
		public static final SYS_MQ_LOG $TABLE=new SYS_MQ_LOG();
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
	 * 节点负载
	*/
	public static class SYS_NODE_LOAD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_node_load";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 节点
		*/
		public static final DBField NODE = new DBField(DBDataType.STRING , "node","node","节点","节点",false,false,true);
		
		/**
		 * IP
		*/
		public static final DBField IP = new DBField(DBDataType.STRING , "ip","ip","IP","IP",false,false,true);
		
		/**
		 * 用户使用率
		*/
		public static final DBField USER = new DBField(DBDataType.DECIMAL , "user","user","用户使用率","用户使用率",false,false,true);
		
		/**
		 * 系统使用率
		*/
		public static final DBField SYS = new DBField(DBDataType.DECIMAL , "sys","sys","系统使用率","系统使用率",false,false,true);
		
		/**
		 * 空闲使用率
		*/
		public static final DBField IDLE = new DBField(DBDataType.DECIMAL , "idle","idle","空闲使用率","空闲使用率",false,false,true);
		
		/**
		 * wio
		*/
		public static final DBField WIO = new DBField(DBDataType.DECIMAL , "wio","wio","wio","wio",false,false,true);
		
		/**
		 * load1
		*/
		public static final DBField LOAD1 = new DBField(DBDataType.DECIMAL , "load1","load1","load1","load1",false,false,true);
		
		/**
		 * load5
		*/
		public static final DBField LOAD5 = new DBField(DBDataType.DECIMAL , "load5","load5","load5","load5",false,false,true);
		
		/**
		 * load15
		*/
		public static final DBField LOAD15 = new DBField(DBDataType.DECIMAL , "load15","load15","load15","load15",false,false,true);
		
		/**
		 * 内存使用
		*/
		public static final DBField MEMORY_USED = new DBField(DBDataType.DECIMAL , "memory_used","memoryUsed","内存使用","内存使用",false,false,true);
		
		/**
		 * 内存使用率
		*/
		public static final DBField MEMORY_USED_PCT = new DBField(DBDataType.DECIMAL , "memory_used_pct","memoryUsedPct","内存使用率","内存使用率",false,false,true);
		
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
		
		public SYS_NODE_LOAD() {
			this.init($NAME,"节点负载" , ID , NODE , IP , USER , SYS , IDLE , WIO , LOAD1 , LOAD5 , LOAD15 , MEMORY_USED , MEMORY_USED_PCT , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_NODE_LOAD $TABLE=new SYS_NODE_LOAD();
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
	 * Profile
	*/
	public static class SYS_PROFILE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_profile";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,false);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
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
		
		public SYS_PROFILE() {
			this.init($NAME,"Profile" , ID , NAME , NOTES , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_PROFILE $TABLE=new SYS_PROFILE();
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
		public static final DBField ACCESS_TYPE = new DBField(DBDataType.STRING , "access_type","accessType","访问控制类型","访问控制类型",false,false,false);
		
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
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 内置角色，是否内置角色
		*/
		public static final DBField BUILD_IN = new DBField(DBDataType.INTEGER , "build_in","buildIn","内置角色","是否内置角色",false,false,false);
		
		public SYS_ROLE() {
			this.init($NAME,"角色表" , ID , CODE , NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , NOTES , TYPE , BUILD_IN);
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
	 * 序列测试表
	*/
	public static class SYS_SEQUENCE_TEST extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_sequence_test";
		
		/**
		*/
		public static final DBField SEQUENCE_ID = new DBField(DBDataType.STRING , "sequence_id","sequenceId","sequence_id","sequence_id",false,false,false);
		
		/**
		*/
		public static final DBField SEQUENCE_VALUE = new DBField(DBDataType.STRING , "sequence_value","sequenceValue","sequence_value","sequence_value",false,false,true);
		
		/**
		*/
		public static final DBField EXCEPTION = new DBField(DBDataType.STRING , "exception","exception","exception","exception",false,false,true);
		
		/**
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","create_time","create_time",false,false,true);
		
		public SYS_SEQUENCE_TEST() {
			this.init($NAME,"序列测试表" , SEQUENCE_ID , SEQUENCE_VALUE , EXCEPTION , CREATE_TIME);
		}
		public static final SYS_SEQUENCE_TEST $TABLE=new SYS_SEQUENCE_TEST();
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
		
		/**
		 * accessToken
		*/
		public static final DBField ACCESS_TOKEN = new DBField(DBDataType.STRING , "access_token","accessToken","accessToken","accessToken",false,false,true);
		
		/**
		 * refreshToken
		*/
		public static final DBField REFRESH_TOKEN = new DBField(DBDataType.STRING , "refresh_token","refreshToken","refreshToken","refreshToken",false,false,true);
		
		public SYS_SESSION_ONLINE() {
			this.init($NAME,"在线会话表" , ID , SESSION_ID , USER_ID , LOGIN_TIME , INTERACT_TIME , INTERACT_URL , LOGOUT_TIME , SESSION_TIME , ONLINE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , HOST_ID , VERSION , NODE_ID , ACCESS_TOKEN , REFRESH_TOKEN);
		}
		public static final SYS_SESSION_ONLINE $TABLE=new SYS_SESSION_ONLINE();
	}
	
	/**
	 * 短信日志
	*/
	public static class SYS_SMS_LOG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_sms_log";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.INTEGER , "id","id","id","id",true,false,false);
		
		/**
		 * 模版ID
		*/
		public static final DBField TEMPLATE_ID = new DBField(DBDataType.STRING , "template_id","templateId","模版ID","模版ID",false,false,true);
		
		/**
		 * 短信通道
		*/
		public static final DBField CHANEL = new DBField(DBDataType.STRING , "chanel","chanel","短信通道","短信通道",false,false,true);
		
		/**
		 * 账户
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","账户","账户",false,false,true);
		
		/**
		 * 参数
		*/
		public static final DBField PARAMS = new DBField(DBDataType.STRING , "params","params","参数","参数",false,false,true);
		
		/**
		 * 手机号
		*/
		public static final DBField PHONE = new DBField(DBDataType.STRING , "phone","phone","手机号","手机号",false,false,true);
		
		/**
		 * 短信内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","短信内容","短信内容",false,false,true);
		
		/**
		 * 是否成功
		*/
		public static final DBField SUCCESS = new DBField(DBDataType.INTEGER , "success","success","是否成功","是否成功",false,false,true);
		
		/**
		 * 相应
		*/
		public static final DBField RESPONSE = new DBField(DBDataType.STRING , "response","response","相应","相应",false,false,true);
		
		/**
		 * 异常
		*/
		public static final DBField ERROR = new DBField(DBDataType.STRING , "error","error","异常","异常",false,false,true);
		
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
		
		public SYS_SMS_LOG() {
			this.init($NAME,"短信日志" , ID , TEMPLATE_ID , CHANEL , USER_ID , PARAMS , PHONE , CONTENT , SUCCESS , RESPONSE , ERROR , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_SMS_LOG $TABLE=new SYS_SMS_LOG();
	}
	
	/**
	 * 短信模版
	*/
	public static class SYS_SMS_TEMPLATE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_sms_template";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","id","id",true,false,false);
		
		/**
		 * 模版代码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","模版代码","模版代码",false,false,true);
		
		/**
		 * 模版名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","模版名称","模版名称",false,false,true);
		
		/**
		 * 短信通道
		*/
		public static final DBField CHANEL_TYPE = new DBField(DBDataType.STRING , "chanel_type","chanelType","短信通道","短信通道",false,false,true);
		
		/**
		 * 通道代码
		*/
		public static final DBField CHANEL_CODE = new DBField(DBDataType.STRING , "chanel_code","chanelCode","通道代码","通道代码",false,false,true);
		
		/**
		 * 模版内容
		*/
		public static final DBField TEMPLATE = new DBField(DBDataType.STRING , "template","template","模版内容","模版内容",false,false,true);
		
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
		
		public SYS_SMS_TEMPLATE() {
			this.init($NAME,"短信模版" , ID , CODE , NAME , CHANEL_TYPE , CHANEL_CODE , TEMPLATE , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_SMS_TEMPLATE $TABLE=new SYS_SMS_TEMPLATE();
	}
	
	/**
	 * 短信验证码
	*/
	public static class SYS_SMS_VERIFICATION_CODE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_sms_verification_code";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 验证主题
		*/
		public static final DBField TOPIC = new DBField(DBDataType.STRING , "topic","topic","验证主题","验证主题",false,false,true);
		
		/**
		 * 短信通道
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","短信通道","短信通道",false,false,true);
		
		/**
		 * 手机号
		*/
		public static final DBField PHONE = new DBField(DBDataType.STRING , "phone","phone","手机号","手机号",false,false,true);
		
		/**
		 * 短信内容
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","短信内容","短信内容",false,false,true);
		
		/**
		 * 过期时间
		*/
		public static final DBField EXPIRE_TIME = new DBField(DBDataType.DATE , "expire_time","expireTime","过期时间","过期时间",false,false,true);
		
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
		
		public SYS_SMS_VERIFICATION_CODE() {
			this.init($NAME,"短信验证码" , ID , TOPIC , USER_ID , PHONE , CODE , EXPIRE_TIME , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_SMS_VERIFICATION_CODE $TABLE=new SYS_SMS_VERIFICATION_CODE();
	}
	
	/**
	 * 升级服务
	*/
	public static class SYS_SYSTEM_UPDATE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_system_update";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","名称","名称",false,false,true);
		
		/**
		 * 升级版本号
		*/
		public static final DBField UPDATE_VERSION = new DBField(DBDataType.STRING , "update_version","updateVersion","升级版本号","升级版本号",false,false,true);
		
		/**
		 * 验证
		*/
		public static final DBField VERIFICATION = new DBField(DBDataType.STRING , "verification","verification","验证","验证",false,false,true);
		
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
		
		public SYS_SYSTEM_UPDATE() {
			this.init($NAME,"升级服务" , ID , NAME , STATUS , UPDATE_VERSION , VERIFICATION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_SYSTEM_UPDATE $TABLE=new SYS_SYSTEM_UPDATE();
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
		 * 会话ID
		*/
		public static final DBField SESSION_ID = new DBField(DBDataType.STRING , "session_id","sessionId","会话ID","会话ID",false,false,true);
		
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
			this.init($NAME,"Token表" , ID , SESSION_ID , USER_ID , JTI , ACCESS_TOKEN , REFRESH_TOKEN , ACCESS_TOKEN_EXPIRE_TIME , ACCESS_TOKEN_EXPIRED , REFRESH_TOKEN_EXPIRE_TIME , REFRESH_TOKEN_EXPIRED , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		public static final DBField ACCOUNT = new DBField(DBDataType.STRING , "account","account","账户","账户",false,false,false);
		
		/**
		 * 姓名
		*/
		public static final DBField REAL_NAME = new DBField(DBDataType.STRING , "real_name","realName","姓名","姓名",false,false,false);
		
		/**
		 * 密码
		*/
		public static final DBField PASSWD = new DBField(DBDataType.STRING , "passwd","passwd","密码","密码",false,false,false);
		
		/**
		 * 手机号码
		*/
		public static final DBField PHONE = new DBField(DBDataType.STRING , "phone","phone","手机号码","手机号码",false,false,false);
		
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
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 内置账户，系统内置账户
		*/
		public static final DBField BUILD_IN = new DBField(DBDataType.INTEGER , "build_in","buildIn","内置账户","系统内置账户",false,false,false);
		
		public SYS_USER() {
			this.init($NAME,"账户表" , ID , ACCOUNT , REAL_NAME , PASSWD , PHONE , PORTRAIT_ID , LANGUAGE , VALID , CACHE_KEY , LAST_LOGIN_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , NOTES , BUILD_IN);
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