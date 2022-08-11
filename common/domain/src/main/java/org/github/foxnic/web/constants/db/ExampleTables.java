package org.github.foxnic.web.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2022-08-06 06:43:56
 * @author 李方捷 , leefangjie@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class ExampleTables {
	
	/**
	 * 订单地址
	*/
	public static class EXAMPLE_ADDRESS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "example_address";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 收件人姓名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","收件人姓名","收件人姓名",false,false,true);
		
		/**
		 * 收件人手机
		*/
		public static final DBField PHONE_NUMBER = new DBField(DBDataType.STRING , "phone_number","phoneNumber","收件人手机","收件人手机",false,false,true);
		
		/**
		 * 收件地址
		*/
		public static final DBField ADDRESS = new DBField(DBDataType.STRING , "address","address","收件地址","收件地址",false,false,true);
		
		/**
		 * 类型，A:国内；B:国外
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","A:国内；B:国外",false,false,false);
		
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
		
		public EXAMPLE_ADDRESS() {
			this.init($NAME,"订单地址" , ID , NAME , PHONE_NUMBER , ADDRESS , TYPE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EXAMPLE_ADDRESS $TABLE=new EXAMPLE_ADDRESS();
	}
	
	/**
	*/
	public static class EXAMPLE_GOODS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "example_goods";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 商品名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","商品名","商品名",false,false,true);
		
		/**
		 * 单价
		*/
		public static final DBField PRICE = new DBField(DBDataType.DECIMAL , "price","price","单价","单价",false,false,true);
		
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
		
		public EXAMPLE_GOODS() {
			this.init($NAME,"" , ID , NAME , PRICE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EXAMPLE_GOODS $TABLE=new EXAMPLE_GOODS();
	}
	
	/**
	 * 示例新闻
	*/
	public static class EXAMPLE_NEWS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "example_news";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 标题
		*/
		public static final DBField TITLE = new DBField(DBDataType.STRING , "title","title","标题","标题",false,false,true);
		
		/**
		 * 内容,长度不超过500
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","长度不超过500",false,false,true);
		
		/**
		 * 作者
		*/
		public static final DBField AUTHOR = new DBField(DBDataType.STRING , "author","author","作者","作者",false,false,true);
		
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
		
		/**
		 * 过期时间
		*/
		public static final DBField EXPIRE_DATE = new DBField(DBDataType.DATE , "expire_date","expireDate","过期时间","过期时间",false,false,true);
		
		public EXAMPLE_NEWS() {
			this.init($NAME,"示例新闻" , ID , TITLE , CONTENT , AUTHOR , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , EXPIRE_DATE);
		}
		public static final EXAMPLE_NEWS $TABLE=new EXAMPLE_NEWS();
	}
	
	/**
	*/
	public static class EXAMPLE_ORDER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "example_order";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 订单编号
		*/
		public static final DBField ORDER_NO = new DBField(DBDataType.STRING , "order_no","orderNo","订单编号","订单编号",false,false,true);
		
		/**
		 * 订单金额
		*/
		public static final DBField AMOUNT = new DBField(DBDataType.DECIMAL , "amount","amount","订单金额","订单金额",false,false,true);
		
		/**
		 * 收件地址ID
		*/
		public static final DBField ADDRESS_ID = new DBField(DBDataType.STRING , "address_id","addressId","收件地址ID","收件地址ID",false,false,true);
		
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
		
		public EXAMPLE_ORDER() {
			this.init($NAME,"" , ID , ORDER_NO , AMOUNT , ADDRESS_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EXAMPLE_ORDER $TABLE=new EXAMPLE_ORDER();
	}
	
	/**
	*/
	public static class EXAMPLE_ORDER_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "example_order_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 订单ID
		*/
		public static final DBField ORDER_ID = new DBField(DBDataType.STRING , "order_id","orderId","订单ID","订单ID",false,false,true);
		
		/**
		 * 商品ID
		*/
		public static final DBField GOODS_ID = new DBField(DBDataType.STRING , "goods_id","goodsId","商品ID","商品ID",false,false,true);
		
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
		
		public EXAMPLE_ORDER_ITEM() {
			this.init($NAME,"" , ID , ORDER_ID , GOODS_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EXAMPLE_ORDER_ITEM $TABLE=new EXAMPLE_ORDER_ITEM();
	}
}