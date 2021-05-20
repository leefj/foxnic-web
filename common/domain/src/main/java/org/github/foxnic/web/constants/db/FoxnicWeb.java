package org.github.foxnic.web.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2021-05-20 03:37:54
 * @author 李方捷 , leefangjie@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class FoxnicWeb {
	
	/**
	 * 公司表
	*/
	public static class HRM_COMPANY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hrm_company";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","id","id",true,false,false);
		
		public HRM_COMPANY() {
			this.init($NAME,"公司表" , ID);
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
		
		public HRM_EMPLOYEE() {
			this.init($NAME,"员工表" , ID);
		}
		public static final HRM_EMPLOYEE $TABLE=new HRM_EMPLOYEE();
	}
	
	/**
	 * 组织层级表
	*/
	public static class HRM_ORGNIZATION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hrm_orgnization";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",false,false,true);
		
		public HRM_ORGNIZATION() {
			this.init($NAME,"组织层级表" , ID);
		}
		public static final HRM_ORGNIZATION $TABLE=new HRM_ORGNIZATION();
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
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 身份证号
		*/
		public static final DBField IDENTITY = new DBField(DBDataType.STRING , "identity","identity","身份证号","身份证号",false,false,true);
		
		/**
		 * 姓名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","姓名","姓名",false,false,true);
		
		/**
		 * 性别
		*/
		public static final DBField SEX = new DBField(DBDataType.STRING , "sex","sex","性别","性别",false,false,true);
		
		public HRM_PERSON() {
			this.init($NAME,"人员表" , ID , IDENTITY , NAME , SEX);
		}
		public static final HRM_PERSON $TABLE=new HRM_PERSON();
	}
	
	/**
	 * 租户表
	*/
	public static class HRM_TENANT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hrm_tenant";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","id","id",true,false,false);
		
		public HRM_TENANT() {
			this.init($NAME,"租户表" , ID);
		}
		public static final HRM_TENANT $TABLE=new HRM_TENANT();
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
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","字典ID","字典ID",true,false,false);
		
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
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
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
			this.init($NAME,"菜单表" , ID , ICON , CSS , LABEL , TYPE , PATH , URL , PARENT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
			this.init($NAME,"角色表" , ID , CODE , NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		public static final DBField MOBILE = new DBField(DBDataType.STRING , "mobile","mobile","手机号码","手机号码",false,false,true);
		
		/**
		 * 人员ID
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员ID","人员ID",false,false,true);
		
		/**
		 * 员工ID
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","员工ID","员工ID",false,false,true);
		
		public SYS_USER() {
			this.init($NAME,"账户表" , ID , NAME , PASSWD , MOBILE , PERSON_ID , EMPLOYEE_ID);
		}
		public static final SYS_USER $TABLE=new SYS_USER();
	}
}