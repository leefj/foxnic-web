package org.github.foxnic.web.domain.example.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.example.AddressModel;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-09 11:40:57
 * @sign E2D824C5CB2F6ACE316A8F27860252DB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AddressModelMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.AddressModel,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.example.AddressModel.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 收件人姓名 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 收件人姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.AddressModel,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.example.AddressModel.class ,NAME, java.lang.String.class, "收件人姓名", "收件人姓名", java.lang.String.class, null);
	
	/**
	 * 收件人手机 , 类型: java.lang.String
	*/
	public static final String PHONE_NUMBER="phoneNumber";
	
	/**
	 * 收件人手机 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.AddressModel,java.lang.String> PHONE_NUMBER_PROP = new BeanProperty(org.github.foxnic.web.domain.example.AddressModel.class ,PHONE_NUMBER, java.lang.String.class, "收件人手机", "收件人手机", java.lang.String.class, null);
	
	/**
	 * 收件地址 , 类型: java.lang.String
	*/
	public static final String ADDRESS="address";
	
	/**
	 * 收件地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.AddressModel,java.lang.String> ADDRESS_PROP = new BeanProperty(org.github.foxnic.web.domain.example.AddressModel.class ,ADDRESS, java.lang.String.class, "收件地址", "收件地址", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型，A:国内；B:国外 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 类型，A:国内；B:国外 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.AddressModel,java.lang.String> TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.example.AddressModel.class ,TYPE, java.lang.String.class, "类型", "类型，A:国内；B:国外", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , PHONE_NUMBER , ADDRESS , TYPE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.example.AddressModel {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AddressModel setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 收件人姓名
		 * @param name 收件人姓名
		 * @return 当前对象
		*/
		public AddressModel setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 收件人手机
		 * @param phoneNumber 收件人手机
		 * @return 当前对象
		*/
		public AddressModel setPhoneNumber(String phoneNumber) {
			super.change(PHONE_NUMBER,super.getPhoneNumber(),phoneNumber);
			super.setPhoneNumber(phoneNumber);
			return this;
		}
		
		/**
		 * 设置 收件地址
		 * @param address 收件地址
		 * @return 当前对象
		*/
		public AddressModel setAddress(String address) {
			super.change(ADDRESS,super.getAddress(),address);
			super.setAddress(address);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public AddressModel setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
	}
}