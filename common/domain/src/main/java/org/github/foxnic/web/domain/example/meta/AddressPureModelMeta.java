package org.github.foxnic.web.domain.example.meta;

import com.github.foxnic.api.bean.BeanProperty;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-09 11:40:57
 * @sign EA8C001BEF5A7135FE7CF51F1BD72C4A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AddressPureModelMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.AddressPureModel,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.example.AddressPureModel.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 收件人姓名 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 收件人姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.AddressPureModel,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.example.AddressPureModel.class ,NAME, java.lang.String.class, "收件人姓名", "收件人姓名", java.lang.String.class, null);
	
	/**
	 * 收件人手机 , 类型: java.lang.String
	*/
	public static final String PHONE_NUMBER="phoneNumber";
	
	/**
	 * 收件人手机 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.AddressPureModel,java.lang.String> PHONE_NUMBER_PROP = new BeanProperty(org.github.foxnic.web.domain.example.AddressPureModel.class ,PHONE_NUMBER, java.lang.String.class, "收件人手机", "收件人手机", java.lang.String.class, null);
	
	/**
	 * 收件地址 , 类型: java.lang.String
	*/
	public static final String ADDRESS="address";
	
	/**
	 * 收件地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.AddressPureModel,java.lang.String> ADDRESS_PROP = new BeanProperty(org.github.foxnic.web.domain.example.AddressPureModel.class ,ADDRESS, java.lang.String.class, "收件地址", "收件地址", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型，A:国内；B:国外 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 类型，A:国内；B:国外 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.AddressPureModel,java.lang.String> TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.example.AddressPureModel.class ,TYPE, java.lang.String.class, "类型", "类型，A:国内；B:国外", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , PHONE_NUMBER , ADDRESS , TYPE };
}