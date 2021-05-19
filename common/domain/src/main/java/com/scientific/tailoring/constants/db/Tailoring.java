package com.scientific.tailoring.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2021-05-12 09:22:24
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class Tailoring {
	
	/**
	 * 客户公司表
	*/
	public static class CRM_COMPANY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "crm_company";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.LONG , "id","id","ID","ID",true,true,false);
		
		/**
		 * 公司名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","公司名称","公司名称",false,false,true);
		
		/**
		 * 统一社会信用代码
		*/
		public static final DBField UNIFY_SOCIAL_CODE = new DBField(DBDataType.STRING , "unify_social_code","unifySocialCode","统一社会信用代码","统一社会信用代码",false,false,true);
		
		/**
		 * 营业执照图片地址
		*/
		public static final DBField LICENSE_PHOTO = new DBField(DBDataType.STRING , "license_photo","licensePhoto","营业执照图片地址","营业执照图片地址",false,false,true);
		
		/**
		 * 经营范围
		*/
		public static final DBField BUSINESS_RANGE = new DBField(DBDataType.STRING , "business_range","businessRange","经营范围","经营范围",false,false,true);
		
		/**
		 * 营业期限开始日期
		*/
		public static final DBField TERM_START_DATE = new DBField(DBDataType.STRING , "term_start_date","termStartDate","营业期限开始日期","营业期限开始日期",false,false,true);
		
		/**
		 * 营业期限结束日期
		*/
		public static final DBField TERM_END_DATE = new DBField(DBDataType.DATE , "term_end_date","termEndDate","营业期限结束日期","营业期限结束日期",false,false,true);
		
		/**
		 * 合同生效时间
		*/
		public static final DBField CONTRACT_START_DATE = new DBField(DBDataType.DATE , "contract_start_date","contractStartDate","合同生效时间","合同生效时间",false,false,true);
		
		/**
		 * 合同状态
		*/
		public static final DBField CONTRACT_STATUS = new DBField(DBDataType.STRING , "contract_status","contractStatus","合同状态","合同状态",false,false,true);
		
		/**
		 * 公司类型，供应商/客户
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","公司类型","供应商/客户",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public CRM_COMPANY() {
			this.init($NAME,"客户公司表" , ID , NAME , UNIFY_SOCIAL_CODE , LICENSE_PHOTO , BUSINESS_RANGE , TERM_START_DATE , TERM_END_DATE , CONTRACT_START_DATE , CONTRACT_STATUS , TYPE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CRM_COMPANY $TABLE=new CRM_COMPANY();
	}
	
	/**
	 * 客户部门表
	*/
	public static class CRM_DEPARTMENT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "crm_department";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.LONG , "id","id","ID","ID",true,true,false);
		
		/**
		 * 部门名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","部门名称","部门名称",false,false,true);
		
		/**
		 * 所属公司ID
		*/
		public static final DBField COMPANY_ID = new DBField(DBDataType.LONG , "company_id","companyId","所属公司ID","所属公司ID",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 上级部门ID
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.LONG , "parent_id","parentId","上级部门ID","上级部门ID",false,false,true);
		
		public CRM_DEPARTMENT() {
			this.init($NAME,"客户部门表" , ID , NAME , COMPANY_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , PARENT_ID);
		}
		public static final CRM_DEPARTMENT $TABLE=new CRM_DEPARTMENT();
	}
	
	/**
	 * 公司员工关系表
	*/
	public static class CRM_EMPLOYEE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "crm_employee";
		
		/**
		 * ID 
		*/
		public static final DBField ID = new DBField(DBDataType.LONG , "id","id","ID","ID",true,true,false);
		
		/**
		 * 所属部门ID
		*/
		public static final DBField DEPARTMENT_ID = new DBField(DBDataType.LONG , "department_id","departmentId","所属部门ID","所属部门ID",false,false,true);
		
		/**
		 * 公司ID
		*/
		public static final DBField COMPANY_ID = new DBField(DBDataType.LONG , "company_id","companyId","公司ID","公司ID",false,false,true);
		
		/**
		 * 用户ID
		*/
		public static final DBField USER_ID = new DBField(DBDataType.LONG , "user_id","userId","用户ID","用户ID",false,false,true);
		
		/**
		 * 员工姓名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","员工姓名","员工姓名",false,false,true);
		
		/**
		 * 员工性别
		*/
		public static final DBField SEX = new DBField(DBDataType.STRING , "sex","sex","员工性别","员工性别",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public CRM_EMPLOYEE() {
			this.init($NAME,"公司员工关系表" , ID , DEPARTMENT_ID , COMPANY_ID , USER_ID , NAME , SEX , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CRM_EMPLOYEE $TABLE=new CRM_EMPLOYEE();
	}
	
	/**
	 * 商品收藏分类表
	*/
	public static class CRM_FAVORITE_FOLDER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "crm_favorite_folder";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.LONG , "id","id","ID","ID",true,true,false);
		
		/**
		 * 上级目录ID
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.LONG , "parent_id","parentId","上级目录ID","上级目录ID",false,false,true);
		
		/**
		 * 用户ID
		*/
		public static final DBField USER_ID = new DBField(DBDataType.LONG , "user_id","userId","用户ID","用户ID",false,false,true);
		
		/**
		 * 目录名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","目录名称","目录名称",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public CRM_FAVORITE_FOLDER() {
			this.init($NAME,"商品收藏分类表" , ID , PARENT_ID , USER_ID , NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CRM_FAVORITE_FOLDER $TABLE=new CRM_FAVORITE_FOLDER();
	}
	
	/**
	 * 商品收藏表
	*/
	public static class CRM_FAVORITE_PRODUCT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "crm_favorite_product";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.LONG , "id","id","ID","ID",true,true,false);
		
		/**
		 * 用户ID
		*/
		public static final DBField USER_ID = new DBField(DBDataType.LONG , "user_id","userId","用户ID","用户ID",false,false,false);
		
		/**
		 * 商品ID
		*/
		public static final DBField PRODUCT_ID = new DBField(DBDataType.LONG , "product_id","productId","商品ID","商品ID",false,false,false);
		
		/**
		 * 材料ID
		*/
		public static final DBField FABRIC_ID = new DBField(DBDataType.LONG , "fabric_id","fabricId","材料ID","材料ID",false,false,false);
		
		/**
		 * 目录ID
		*/
		public static final DBField FOLDER_ID = new DBField(DBDataType.LONG , "folder_id","folderId","目录ID","目录ID",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public CRM_FAVORITE_PRODUCT() {
			this.init($NAME,"商品收藏表" , ID , USER_ID , PRODUCT_ID , FABRIC_ID , FOLDER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CRM_FAVORITE_PRODUCT $TABLE=new CRM_FAVORITE_PRODUCT();
	}
	
	/**
	 * 订单测量人员表
	*/
	public static class ODR_BODY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "odr_body";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.LONG , "id","id","ID","ID",true,true,false);
		
		/**
		 * 订单ID
		*/
		public static final DBField ORDER_ID = new DBField(DBDataType.LONG , "order_id","orderId","订单ID","订单ID",false,false,false);
		
		/**
		 * 被测量人姓名
		*/
		public static final DBField BODY_NAME = new DBField(DBDataType.STRING , "body_name","bodyName","被测量人姓名","被测量人姓名",false,false,true);
		
		/**
		 * 被测量人部门
		*/
		public static final DBField BODY_DEPT = new DBField(DBDataType.STRING , "body_dept","bodyDept","被测量人部门","被测量人部门",false,false,true);
		
		/**
		 * 被测量人性别
		*/
		public static final DBField BODY_SEX = new DBField(DBDataType.STRING , "body_sex","bodySex","被测量人性别","被测量人性别",false,false,true);
		
		/**
		 * 被测量人身高，单位厘米cm
		*/
		public static final DBField BODY_HEIGHT = new DBField(DBDataType.INTEGER , "body_height","bodyHeight","被测量人身高","单位厘米cm",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public ODR_BODY() {
			this.init($NAME,"订单测量人员表" , ID , ORDER_ID , BODY_NAME , BODY_DEPT , BODY_SEX , BODY_HEIGHT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final ODR_BODY $TABLE=new ODR_BODY();
	}
	
	/**
	 * 订单测量信息表
	*/
	public static class ODR_MEASURE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "odr_measure";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.LONG , "id","id","ID","ID",true,true,false);
		
		/**
		 * 订单ID
		*/
		public static final DBField ORDER_ID = new DBField(DBDataType.LONG , "order_id","orderId","订单ID","订单ID",false,false,false);
		
		/**
		 * 被测量人员ID
		*/
		public static final DBField BODY_ID = new DBField(DBDataType.LONG , "body_id","bodyId","被测量人员ID","被测量人员ID",false,false,true);
		
		/**
		 * 测量方法
		*/
		public static final DBField METHOD = new DBField(DBDataType.STRING , "method","method","测量方法","测量方法",false,false,true);
		
		/**
		 * 测量状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","测量状态","测量状态",false,false,false);
		
		/**
		 * 视频效果，最终视频效果文件ID
		*/
		public static final DBField VIDEO_ID = new DBField(DBDataType.LONG , "video_id","videoId","视频效果","最终视频效果文件ID",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 净体3D效果文件ID
		*/
		public static final DBField BODY_EFFECT_FILE_ID = new DBField(DBDataType.LONG , "body_effect_file_id","bodyEffectFileId","净体3D效果文件ID","净体3D效果文件ID",false,false,true);
		
		/**
		 * 着装3D效果文件ID
		*/
		public static final DBField OUTFIT_EFFECT_FILE_ID = new DBField(DBDataType.LONG , "outfit_effect_file_id","outfitEffectFileId","着装3D效果文件ID","着装3D效果文件ID",false,false,true);
		
		public ODR_MEASURE() {
			this.init($NAME,"订单测量信息表" , ID , ORDER_ID , BODY_ID , METHOD , STATUS , VIDEO_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , BODY_EFFECT_FILE_ID , OUTFIT_EFFECT_FILE_ID);
		}
		public static final ODR_MEASURE $TABLE=new ODR_MEASURE();
	}
	
	/**
	 * 测量数据发聩表
	*/
	public static class ODR_MEASURE_DATA extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "odr_measure_data";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.LONG , "id","id","ID","ID",true,true,false);
		
		/**
		 * 测量ID
		*/
		public static final DBField MEASURE_ID = new DBField(DBDataType.LONG , "measure_id","measureId","测量ID","测量ID",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 测量类型，净体 body , 着装 outfit
		*/
		public static final DBField RESULT_TYPE = new DBField(DBDataType.STRING , "result_type","resultType","测量类型","净体 body , 着装 outfit",false,false,false);
		
		/**
		 * 领围
		*/
		public static final DBField LING_WEI = new DBField(DBDataType.DECIMAL , "ling_wei","lingWei","领围","领围",false,false,true);
		
		/**
		 * 胸围
		*/
		public static final DBField XIONG_WEI = new DBField(DBDataType.DECIMAL , "xiong_wei","xiongWei","胸围","胸围",false,false,true);
		
		/**
		 * 腰围
		*/
		public static final DBField YAO_WEI = new DBField(DBDataType.DECIMAL , "yao_wei","yaoWei","腰围","腰围",false,false,true);
		
		/**
		 * 腹围
		*/
		public static final DBField FU_WEI = new DBField(DBDataType.DECIMAL , "fu_wei","fuWei","腹围","腹围",false,false,true);
		
		/**
		 * 右上臂围
		*/
		public static final DBField YOU_SHANG_BI_WEI = new DBField(DBDataType.DECIMAL , "you_shang_bi_wei","youShangBiWei","右上臂围","右上臂围",false,false,true);
		
		/**
		 * 右下臂围
		*/
		public static final DBField YOU_XIA_BI_WEI = new DBField(DBDataType.DECIMAL , "you_xia_bi_wei","youXiaBiWei","右下臂围","右下臂围",false,false,true);
		
		/**
		 * 左上臂围
		*/
		public static final DBField ZUO_SHANG_BI_WEI = new DBField(DBDataType.DECIMAL , "zuo_shang_bi_wei","zuoShangBiWei","左上臂围","左上臂围",false,false,true);
		
		/**
		 * 左下臂围
		*/
		public static final DBField ZUO_XIA_BI_WEI = new DBField(DBDataType.DECIMAL , "zuo_xia_bi_wei","zuoXiaBiWei","左下臂围","左下臂围",false,false,true);
		
		/**
		 * 右上腿围
		*/
		public static final DBField YOU_SHANG_TUI_WEI = new DBField(DBDataType.DECIMAL , "you_shang_tui_wei","youShangTuiWei","右上腿围","右上腿围",false,false,true);
		
		/**
		 * 右下腿围
		*/
		public static final DBField YOU_XIA_TUI_WEI = new DBField(DBDataType.DECIMAL , "you_xia_tui_wei","youXiaTuiWei","右下腿围","右下腿围",false,false,true);
		
		/**
		 * 左上腿围
		*/
		public static final DBField ZUO_SHANG_TUI_WEI = new DBField(DBDataType.DECIMAL , "zuo_shang_tui_wei","zuoShangTuiWei","左上腿围","左上腿围",false,false,true);
		
		/**
		 * 左下腿围
		*/
		public static final DBField ZUO_XIA_TUI_WEI = new DBField(DBDataType.DECIMAL , "zuo_xia_tui_wei","zuoXiaTuiWei","左下腿围","左下腿围",false,false,true);
		
		/**
		 * 身高
		*/
		public static final DBField SHEN_GAO = new DBField(DBDataType.DECIMAL , "shen_gao","shenGao","身高","身高",false,false,true);
		
		/**
		 * 肩宽
		*/
		public static final DBField JIAN_KUAN = new DBField(DBDataType.DECIMAL , "jian_kuan","jianKuan","肩宽","肩宽",false,false,true);
		
		/**
		 * 背长
		*/
		public static final DBField BEI_CHANG = new DBField(DBDataType.DECIMAL , "bei_chang","beiChang","背长","背长",false,false,true);
		
		/**
		 * 颈椎点高
		*/
		public static final DBField JING_ZHUI_DIAN_GAO = new DBField(DBDataType.DECIMAL , "jing_zhui_dian_gao","jingZhuiDianGao","颈椎点高","颈椎点高",false,false,true);
		
		/**
		 * 腰围高
		*/
		public static final DBField YAO_WEI_GAO = new DBField(DBDataType.DECIMAL , "yao_wei_gao","yaoWeiGao","腰围高","腰围高",false,false,true);
		
		/**
		 * 臀高
		*/
		public static final DBField TUN_GAO = new DBField(DBDataType.DECIMAL , "tun_gao","tunGao","臀高","臀高",false,false,true);
		
		/**
		 * 臀围
		*/
		public static final DBField TUN_WEI = new DBField(DBDataType.DECIMAL , "tun_wei","tunWei","臀围","臀围",false,false,true);
		
		/**
		 * 裤长
		*/
		public static final DBField KU_CHANG = new DBField(DBDataType.DECIMAL , "ku_chang","kuChang","裤长","裤长",false,false,true);
		
		/**
		 * 左臂长
		*/
		public static final DBField ZUO_BI_CHANG = new DBField(DBDataType.DECIMAL , "zuo_bi_chang","zuoBiChang","左臂长","左臂长",false,false,true);
		
		/**
		 * 右臂长
		*/
		public static final DBField YOU_BI_CHANG = new DBField(DBDataType.DECIMAL , "you_bi_chang","youBiChang","右臂长","右臂长",false,false,true);
		
		/**
		 * 右上臂长
		*/
		public static final DBField YOU_SHANG_BI_CHANG = new DBField(DBDataType.DECIMAL , "you_shang_bi_chang","youShangBiChang","右上臂长","右上臂长",false,false,true);
		
		/**
		 * 右下臂长
		*/
		public static final DBField YOU_XIA_BI_CHANG = new DBField(DBDataType.DECIMAL , "you_xia_bi_chang","youXiaBiChang","右下臂长","右下臂长",false,false,true);
		
		/**
		 * 左上臂长
		*/
		public static final DBField ZUO_SHANG_BI_CHANG = new DBField(DBDataType.DECIMAL , "zuo_shang_bi_chang","zuoShangBiChang","左上臂长","左上臂长",false,false,true);
		
		/**
		 * 左下臂长
		*/
		public static final DBField ZUO_XIA_BI_CHANG = new DBField(DBDataType.DECIMAL , "zuo_xia_bi_chang","zuoXiaBiChang","左下臂长","左下臂长",false,false,true);
		
		/**
		 * 右腿长
		*/
		public static final DBField YOU_TUI_CHANG = new DBField(DBDataType.DECIMAL , "you_tui_chang","youTuiChang","右腿长","右腿长",false,false,true);
		
		/**
		 * 左腿长
		*/
		public static final DBField ZUO_TUI_CHANG = new DBField(DBDataType.DECIMAL , "zuo_tui_chang","zuoTuiChang","左腿长","左腿长",false,false,true);
		
		/**
		 * 右上腿长
		*/
		public static final DBField YOU_SHANG_TUI_CHANG = new DBField(DBDataType.DECIMAL , "you_shang_tui_chang","youShangTuiChang","右上腿长","右上腿长",false,false,true);
		
		/**
		 * 右下腿长
		*/
		public static final DBField YOU_XIA_TUI_CHANG = new DBField(DBDataType.DECIMAL , "you_xia_tui_chang","youXiaTuiChang","右下腿长","右下腿长",false,false,true);
		
		/**
		 * 左上腿长
		*/
		public static final DBField ZUO_SHANG_TUI_CHANG = new DBField(DBDataType.DECIMAL , "zuo_shang_tui_chang","zuoShangTuiChang","左上腿长","左上腿长",false,false,true);
		
		/**
		 * 左下腿长
		*/
		public static final DBField ZUO_XIA_TUI_CHANG = new DBField(DBDataType.DECIMAL , "zuo_xia_tui_chang","zuoXiaTuiChang","左下腿长","左下腿长",false,false,true);
		
		public ODR_MEASURE_DATA() {
			this.init($NAME,"测量数据发聩表" , ID , MEASURE_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , RESULT_TYPE , LING_WEI , XIONG_WEI , YAO_WEI , FU_WEI , YOU_SHANG_BI_WEI , YOU_XIA_BI_WEI , ZUO_SHANG_BI_WEI , ZUO_XIA_BI_WEI , YOU_SHANG_TUI_WEI , YOU_XIA_TUI_WEI , ZUO_SHANG_TUI_WEI , ZUO_XIA_TUI_WEI , SHEN_GAO , JIAN_KUAN , BEI_CHANG , JING_ZHUI_DIAN_GAO , YAO_WEI_GAO , TUN_GAO , TUN_WEI , KU_CHANG , ZUO_BI_CHANG , YOU_BI_CHANG , YOU_SHANG_BI_CHANG , YOU_XIA_BI_CHANG , ZUO_SHANG_BI_CHANG , ZUO_XIA_BI_CHANG , YOU_TUI_CHANG , ZUO_TUI_CHANG , YOU_SHANG_TUI_CHANG , YOU_XIA_TUI_CHANG , ZUO_SHANG_TUI_CHANG , ZUO_XIA_TUI_CHANG);
		}
		public static final ODR_MEASURE_DATA $TABLE=new ODR_MEASURE_DATA();
	}
	
	/**
	 * 测量文件采集表
	*/
	public static class ODR_MEASURE_FILE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "odr_measure_file";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.INTEGER , "id","id","id","id",true,true,false);
		
		/**
		 * 订单测量ID
		*/
		public static final DBField MEASURE_ID = new DBField(DBDataType.LONG , "measure_id","measureId","订单测量ID","订单测量ID",false,false,true);
		
		/**
		 * 文件ID
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.LONG , "file_id","fileId","文件ID","文件ID",false,false,true);
		
		/**
		 * 测量类型，image/video/manual
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","测量类型","image/video/manual",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 数据是否已经处理
		*/
		public static final DBField PROCESSED = new DBField(DBDataType.INTEGER , "processed","processed","数据是否已经处理","数据是否已经处理",false,false,true);
		
		/**
		 * 处理时间
		*/
		public static final DBField PROCESS_TIME = new DBField(DBDataType.DATE , "process_time","processTime","处理时间","处理时间",false,false,true);
		
		public ODR_MEASURE_FILE() {
			this.init($NAME,"测量文件采集表" , ID , MEASURE_ID , FILE_ID , TYPE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , PROCESSED , PROCESS_TIME);
		}
		public static final ODR_MEASURE_FILE $TABLE=new ODR_MEASURE_FILE();
	}
	
	/**
	 * 订单表
	*/
	public static class ODR_ORDER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "odr_order";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.LONG , "id","id","ID","ID",true,true,false);
		
		/**
		 * 订单号
		*/
		public static final DBField ORDER_NO = new DBField(DBDataType.STRING , "order_no","orderNo","订单号","订单号",false,false,false);
		
		/**
		 * 公司ID
		*/
		public static final DBField COMPANY_ID = new DBField(DBDataType.LONG , "company_id","companyId","公司ID","公司ID",false,false,true);
		
		/**
		 * 预约时间
		*/
		public static final DBField APPOINTMENT_TIME = new DBField(DBDataType.DATE , "appointment_time","appointmentTime","预约时间","预约时间",false,false,true);
		
		/**
		 * 订单状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","订单状态","订单状态",false,false,false);
		
		/**
		 * 城市ID
		*/
		public static final DBField CITY_ID = new DBField(DBDataType.INTEGER , "city_id","cityId","城市ID","城市ID",false,false,true);
		
		/**
		 * 省份ID
		*/
		public static final DBField PROVINCE_ID = new DBField(DBDataType.INTEGER , "province_id","provinceId","省份ID","省份ID",false,false,true);
		
		/**
		 * 区县ID
		*/
		public static final DBField AREA_ID = new DBField(DBDataType.INTEGER , "area_id","areaId","区县ID","区县ID",false,false,true);
		
		/**
		 * 镇ID
		*/
		public static final DBField TOWN_ID = new DBField(DBDataType.INTEGER , "town_id","townId","镇ID","镇ID",false,false,true);
		
		/**
		 * 详细地址
		*/
		public static final DBField ADDRESS_DETAIL = new DBField(DBDataType.STRING , "address_detail","addressDetail","详细地址","详细地址",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public ODR_ORDER() {
			this.init($NAME,"订单表" , ID , ORDER_NO , COMPANY_ID , APPOINTMENT_TIME , STATUS , CITY_ID , PROVINCE_ID , AREA_ID , TOWN_ID , ADDRESS_DETAIL , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final ODR_ORDER $TABLE=new ODR_ORDER();
	}
	
	/**
	 * 订单商品关系表
	*/
	public static class ODR_PRODUCT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "odr_product";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.LONG , "id","id","ID","ID",true,true,false);
		
		/**
		 * 订单ID
		*/
		public static final DBField ORDER_ID = new DBField(DBDataType.LONG , "order_id","orderId","订单ID","订单ID",false,false,false);
		
		/**
		 * 商品ID
		*/
		public static final DBField PRODUCT_ID = new DBField(DBDataType.INTEGER , "product_id","productId","商品ID","商品ID",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public ODR_PRODUCT() {
			this.init($NAME,"订单商品关系表" , ID , ORDER_ID , PRODUCT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final ODR_PRODUCT $TABLE=new ODR_PRODUCT();
	}
	
	/**
	 * 虚拟效果视频展示表
	*/
	public static class ODR_VIRTUAL_EFFECT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "odr_virtual_effect";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.INTEGER , "id","id","ID","ID",true,true,false);
		
		/**
		 * 订单ID
		*/
		public static final DBField ORDER_ID = new DBField(DBDataType.INTEGER , "order_id","orderId","订单ID","订单ID",false,false,true);
		
		/**
		 * 测量ID
		*/
		public static final DBField MEASURE_ID = new DBField(DBDataType.INTEGER , "measure_id","measureId","测量ID","测量ID",false,false,true);
		
		/**
		 * 商品ID
		*/
		public static final DBField PRODUCT_ID = new DBField(DBDataType.INTEGER , "product_id","productId","商品ID","商品ID",false,false,true);
		
		/**
		 * 视频地址
		*/
		public static final DBField VIDEO_LOCATION = new DBField(DBDataType.STRING , "video_location","videoLocation","视频地址","视频地址",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public ODR_VIRTUAL_EFFECT() {
			this.init($NAME,"虚拟效果视频展示表" , ID , ORDER_ID , MEASURE_ID , PRODUCT_ID , VIDEO_LOCATION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final ODR_VIRTUAL_EFFECT $TABLE=new ODR_VIRTUAL_EFFECT();
	}
	
	/**
	 * 面料表
	*/
	public static class PRD_FABRIC extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "prd_fabric";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.INTEGER , "id","id","id","id",true,true,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField FULL_NAME = new DBField(DBDataType.STRING , "full_name","fullName","名称","名称",false,false,false);
		
		/**
		 * 简称
		*/
		public static final DBField SHORT_NAME = new DBField(DBDataType.STRING , "short_name","shortName","简称","简称",false,false,true);
		
		/**
		 * 图片ID
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.INTEGER , "file_id","fileId","图片ID","图片ID",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public PRD_FABRIC() {
			this.init($NAME,"面料表" , ID , CODE , FULL_NAME , SHORT_NAME , FILE_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final PRD_FABRIC $TABLE=new PRD_FABRIC();
	}
	
	/**
	 * 产品标签表
	*/
	public static class PRD_LABEL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "prd_label";
		
		/**
		 * 编号
		*/
		public static final DBField ID = new DBField(DBDataType.INTEGER , "id","id","编号","编号",true,true,false);
		
		/**
		 * 标签
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","标签","标签",false,false,true);
		
		/**
		 * 上级ID
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.INTEGER , "parent_id","parentId","上级ID","上级ID",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public PRD_LABEL() {
			this.init($NAME,"产品标签表" , ID , LABEL , PARENT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final PRD_LABEL $TABLE=new PRD_LABEL();
	}
	
	/**
	 * 商品表
	*/
	public static class PRD_PRODUCT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "prd_product";
		
		/**
		 * 商品编号
		*/
		public static final DBField ID = new DBField(DBDataType.LONG , "id","id","商品编号","商品编号",true,true,false);
		
		/**
		 * 商品名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","商品名称","商品名称",false,false,false);
		
		/**
		 * 是否上架
		*/
		public static final DBField IS_ON_SHELF = new DBField(DBDataType.BOOL , "is_on_shelf","isOnShelf","是否上架","是否上架",false,false,false);
		
		/**
		 * 商品详情
		*/
		public static final DBField DETAIL = new DBField(DBDataType.STRING , "detail","detail","商品详情","商品详情",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public PRD_PRODUCT() {
			this.init($NAME,"商品表" , ID , NAME , IS_ON_SHELF , DETAIL , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final PRD_PRODUCT $TABLE=new PRD_PRODUCT();
	}
	
	/**
	 * 商品面料关系表
	*/
	public static class PRD_PRODUCT_FABRIC extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "prd_product_fabric";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.LONG , "id","id","ID","ID",true,true,false);
		
		/**
		 * 商品ID
		*/
		public static final DBField PRODUCT_ID = new DBField(DBDataType.LONG , "product_id","productId","商品ID","商品ID",false,false,true);
		
		/**
		 * 标签ID
		*/
		public static final DBField FABRIC_ID = new DBField(DBDataType.INTEGER , "fabric_id","fabricId","标签ID","标签ID",false,false,true);
		
		/**
		 * 效果图，面料+商品的效果图
		*/
		public static final DBField EFFECT_ID = new DBField(DBDataType.INTEGER , "effect_id","effectId","效果图","面料+商品的效果图",false,false,true);
		
		/**
		 * 虚拟试衣ID
		*/
		public static final DBField VIRTUAL_ID = new DBField(DBDataType.LONG , "virtual_id","virtualId","虚拟试衣ID","虚拟试衣ID",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public PRD_PRODUCT_FABRIC() {
			this.init($NAME,"商品面料关系表" , ID , PRODUCT_ID , FABRIC_ID , EFFECT_ID , VIRTUAL_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final PRD_PRODUCT_FABRIC $TABLE=new PRD_PRODUCT_FABRIC();
	}
	
	/**
	 * 商品图片表
	*/
	public static class PRD_PRODUCT_IMAGE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "prd_product_image";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.LONG , "id","id","ID","ID",true,true,false);
		
		/**
		 * 商品ID
		*/
		public static final DBField PRODUCT_ID = new DBField(DBDataType.LONG , "product_id","productId","商品ID","商品ID",false,false,true);
		
		/**
		 * 图片地址
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.LONG , "file_id","fileId","图片地址","图片地址",false,false,true);
		
		/**
		 * 是否主图
		*/
		public static final DBField IS_CHIEF = new DBField(DBDataType.BOOL , "is_chief","isChief","是否主图","是否主图",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public PRD_PRODUCT_IMAGE() {
			this.init($NAME,"商品图片表" , ID , PRODUCT_ID , FILE_ID , IS_CHIEF , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final PRD_PRODUCT_IMAGE $TABLE=new PRD_PRODUCT_IMAGE();
	}
	
	/**
	 * 商品标签关系表
	*/
	public static class PRD_PRODUCT_LABEL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "prd_product_label";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.LONG , "id","id","ID","ID",true,true,false);
		
		/**
		 * 商品ID
		*/
		public static final DBField PRODUCT_ID = new DBField(DBDataType.LONG , "product_id","productId","商品ID","商品ID",false,false,true);
		
		/**
		 * 标签ID
		*/
		public static final DBField LABEL_ID = new DBField(DBDataType.INTEGER , "label_id","labelId","标签ID","标签ID",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public PRD_PRODUCT_LABEL() {
			this.init($NAME,"商品标签关系表" , ID , PRODUCT_ID , LABEL_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final PRD_PRODUCT_LABEL $TABLE=new PRD_PRODUCT_LABEL();
	}
	
	/**
	 * 虚拟试衣表
	*/
	public static class PRD_VIRTUAL_LIBRARY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "prd_virtual_library";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.LONG , "id","id","ID","ID",true,true,false);
		
		/**
		 * 商品ID
		*/
		public static final DBField PRODUCT_ID = new DBField(DBDataType.LONG , "product_id","productId","商品ID","商品ID",false,false,true);
		
		/**
		 * 面料ID
		*/
		public static final DBField FABRIC_ID = new DBField(DBDataType.INTEGER , "fabric_id","fabricId","面料ID","面料ID",false,false,true);
		
		/**
		 * 虚拟试衣效果图ID
		*/
		public static final DBField EFFECT_FILE_ID = new DBField(DBDataType.LONG , "effect_file_id","effectFileId","虚拟试衣效果图ID","虚拟试衣效果图ID",false,false,true);
		
		/**
		 * 是否有效
		*/
		public static final DBField VALID = new DBField(DBDataType.BOOL , "valid","valid","是否有效","是否有效",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public PRD_VIRTUAL_LIBRARY() {
			this.init($NAME,"虚拟试衣表" , ID , PRODUCT_ID , FABRIC_ID , EFFECT_FILE_ID , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final PRD_VIRTUAL_LIBRARY $TABLE=new PRD_VIRTUAL_LIBRARY();
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

		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","区域名称","区域名称",false,false,false);
		
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
		public static final DBField VALID = new DBField(DBDataType.BOOL , "valid","valid","数据是否有效","（0：无效 1：有效）",false,false,false);
		
		public SYS_AREA() {
			this.init($NAME,"区域表" , ID , PARENT_ID , NAME , DEPTH , CREATED_BY , UPDATED_BY , CREATE_DATE , UPDATE_DATE , VALID);
		}
		public static final SYS_AREA $TABLE=new SYS_AREA();
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
		 * 配置值
		*/
		public static final DBField VALUE = new DBField(DBDataType.STRING , "value","value","配置值","配置值",false,false,true);
		
		/**
		 * 是否生效
		*/
		public static final DBField VALID = new DBField(DBDataType.BOOL , "valid","valid","是否生效","是否生效",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_CONFIG() {
			this.init($NAME,"系统配置表" , CODE , NAME , VALUE , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_CONFIG $TABLE=new SYS_CONFIG();
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
		public static final DBField ID = new DBField(DBDataType.INTEGER , "id","id","字典ID","字典ID",true,true,false);
		
		/**
		 * 字典名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","字典名称","字典名称",false,false,false);
		
		/**
		 * 字典代码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","字典代码","字典代码",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_DICT() {
			this.init($NAME,"数据字典" , ID , NAME , CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		public static final DBField ID = new DBField(DBDataType.INTEGER , "id","id","ID","ID",true,true,false);
		
		/**
		 * 字典ID
		*/
		public static final DBField DICT_ID = new DBField(DBDataType.STRING , "dict_id","dictId","字典ID","字典ID",false,false,false);
		
		/**
		 * 字典代码
		*/
		public static final DBField DICT_CODE = new DBField(DBDataType.STRING , "dict_code","dictCode","字典代码","字典代码",false,false,false);
		
		/**
		 * 代码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","代码","代码",false,false,false);
		
		/**
		 * 标签
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","标签","标签",false,false,false);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_DICT_ITEM() {
			this.init($NAME,"数据字典条目" , ID , DICT_ID , DICT_CODE , CODE , LABEL , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		public static final DBField ID = new DBField(DBDataType.LONG , "id","id","ID","ID",true,true,false);
		
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
		 * 文件类型，存放文件扩展名
		*/
		public static final DBField FILE_TYPE = new DBField(DBDataType.STRING , "file_type","fileType","文件类型","存放文件扩展名",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_FILE() {
			this.init($NAME,"系统文件" , ID , FILE_NAME , LOCATION , SIZE , FILE_TYPE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		 * 用户ID
		*/
		public static final DBField USER_ID = new DBField(DBDataType.LONG , "user_id","userId","用户ID","用户ID",false,false,true);
		
		/**
		 * 用户姓名
		*/
		public static final DBField USER_NAME = new DBField(DBDataType.STRING , "user_name","userName","用户姓名","用户姓名",false,false,true);
		
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
			this.init($NAME,"调用统计日志" , ID , HOST_NAME , URI , USER_AGENT , CLIENT_IP , TOKEN , USER_ID , USER_NAME , PARAMETER , RESPONSE , START_TIME , END_TIME , EXCEPTION);
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
		public static final DBField VALID = new DBField(DBDataType.BOOL , "valid","valid","是否有效","是否有效",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
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
	 * 功能菜单表
	*/
	public static class SYS_MENU extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_menu";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.INTEGER , "id","id","id","id",true,true,false);
		
		/**
		 * 图标
		*/
		public static final DBField ICON = new DBField(DBDataType.STRING , "icon","icon","图标","图标",false,false,true);
		
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
		public static final DBField TYPE = new DBField(DBDataType.INTEGER , "type","type","菜单类型","菜单类型",false,false,true);
		
		/**
		 * 模版路径
		*/
		public static final DBField PATH = new DBField(DBDataType.STRING , "path","path","模版路径","模版路径",false,false,true);
		
		/**
		 * 路由地址
		*/
		public static final DBField URL = new DBField(DBDataType.STRING , "url","url","路由地址","路由地址",false,false,true);
		
		/**
		 * 上级ID
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.INTEGER , "parent_id","parentId","上级ID","上级ID",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_MENU() {
			this.init($NAME,"功能菜单表" , ID , ICON , CSS , LABEL , TYPE , PATH , URL , PARENT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_MENU $TABLE=new SYS_MENU();
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
		 * 编号
		*/
		public static final DBField ID = new DBField(DBDataType.INTEGER , "id","id","编号","编号",true,true,false);
		
		/**
		 * 代码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","代码","代码",false,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 是否有效
		*/
		public static final DBField VALID = new DBField(DBDataType.BOOL , "valid","valid","是否有效","是否有效",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_ROLE() {
			this.init($NAME,"角色表" , ID , CODE , NAME , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_ROLE $TABLE=new SYS_ROLE();
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
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","id","id",true,false,false);
		
		/**
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","name","name",false,false,true);
		
		/**
		*/
		public static final DBField LENGTH = new DBField(DBDataType.INTEGER , "length","length","length","length",false,false,true);
		
		/**
		*/
		public static final DBField CATALOG = new DBField(DBDataType.STRING , "catalog","catalog","catalog","catalog",false,false,true);
		
		/**
		*/
		public static final DBField VALUE = new DBField(DBDataType.LONG , "value","value","value","value",false,false,true);
		
		/**
		*/
		public static final DBField MEMO = new DBField(DBDataType.STRING , "memo","memo","memo","memo",false,false,true);
		
		/**
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","type","type",false,false,true);
		
		public SYS_SEQUENCE() {
			this.init($NAME,"序列表" , ID , NAME , LENGTH , CATALOG , VALUE , MEMO , TYPE);
		}
		public static final SYS_SEQUENCE $TABLE=new SYS_SEQUENCE();
	}
	
	/**
	 * 用户表
	*/
	public static class SYS_USER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_user";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.LONG , "id","id","ID","ID",true,true,false);
		
		/**
		 * 登录帐号
		*/
		public static final DBField ACCOUNT = new DBField(DBDataType.STRING , "account","account","登录帐号","登录帐号",false,false,false);
		
		/**
		 * 姓名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","姓名","姓名",false,false,false);
		
		/**
		 * 登录密码
		*/
		public static final DBField PASSWORD = new DBField(DBDataType.STRING , "password","password","登录密码","登录密码",false,false,true);
		
		/**
		 * 手机号码
		*/
		public static final DBField MOBILE = new DBField(DBDataType.STRING , "mobile","mobile","手机号码","手机号码",false,false,true);
		
		/**
		 * 头像文件ID
		*/
		public static final DBField PORTRAIT_ID = new DBField(DBDataType.LONG , "portrait_id","portraitId","头像文件ID","头像文件ID",false,false,true);
		
		/**
		 * 最近登录时间
		*/
		public static final DBField LATEST_LOGIN_TIME = new DBField(DBDataType.DATE , "latest_login_time","latestLoginTime","最近登录时间","最近登录时间",false,false,true);
		
		/**
		 * 是否有效，禁用:0/启用:1
		*/
		public static final DBField VALID = new DBField(DBDataType.BOOL , "valid","valid","是否有效","禁用:0/启用:1",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_USER() {
			this.init($NAME,"用户表" , ID , ACCOUNT , NAME , PASSWORD , MOBILE , PORTRAIT_ID , LATEST_LOGIN_TIME , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_USER $TABLE=new SYS_USER();
	}
	
	/**
	 * 用户角色关系表
	*/
	public static class SYS_USER_ROLE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_user_role";
		
		/**
		 * 编号
		*/
		public static final DBField ID = new DBField(DBDataType.INTEGER , "id","id","编号","编号",true,true,false);
		
		/**
		 * 用户ID
		*/
		public static final DBField USER_ID = new DBField(DBDataType.LONG , "user_id","userId","用户ID","用户ID",false,false,false);
		
		/**
		 * 角色ID
		*/
		public static final DBField ROLE_ID = new DBField(DBDataType.INTEGER , "role_id","roleId","角色ID","角色ID",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.LONG , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.LONG , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.BOOL , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.LONG , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_USER_ROLE() {
			this.init($NAME,"用户角色关系表" , ID , USER_ID , ROLE_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_USER_ROLE $TABLE=new SYS_USER_ROLE();
	}
}