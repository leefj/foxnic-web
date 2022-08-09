package org.github.foxnic.web.domain.example;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Transient;
import com.github.foxnic.commons.bean.BeanUtil;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;



/**
 * 订单地址
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-09 11:40:57
 * @sign EA8C001BEF5A7135FE7CF51F1BD72C4A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AddressPureModel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键：主键
	*/
	@ApiModelProperty(required = false,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 收件人姓名：收件人姓名
	*/
	@ApiModelProperty(required = false,value="收件人姓名" , notes = "收件人姓名")
	private String name;
	
	/**
	 * 收件人手机：收件人手机
	*/
	@ApiModelProperty(required = false,value="收件人手机" , notes = "收件人手机")
	private String phoneNumber;
	
	/**
	 * 收件地址：收件地址
	*/
	@ApiModelProperty(required = false,value="收件地址" , notes = "收件地址")
	private String address;
	
	/**
	 * 类型：类型，A:国内；B:国外
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型，A:国内；B:国外")
	private String type;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public AddressPureModel setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 收件人姓名<br>
	 * 收件人姓名
	 * @return 收件人姓名
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 收件人姓名
	 * @param name 收件人姓名
	 * @return 当前对象
	*/
	public AddressPureModel setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 收件人手机<br>
	 * 收件人手机
	 * @return 收件人手机
	*/
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * 设置 收件人手机
	 * @param phoneNumber 收件人手机
	 * @return 当前对象
	*/
	public AddressPureModel setPhoneNumber(String phoneNumber) {
		this.phoneNumber=phoneNumber;
		return this;
	}
	
	/**
	 * 获得 收件地址<br>
	 * 收件地址
	 * @return 收件地址
	*/
	public String getAddress() {
		return address;
	}
	
	/**
	 * 设置 收件地址
	 * @param address 收件地址
	 * @return 当前对象
	*/
	public AddressPureModel setAddress(String address) {
		this.address=address;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型，A:国内；B:国外
	 * @return 类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 类型
	 * @param type 类型
	 * @return 当前对象
	*/
	public AddressPureModel setType(String type) {
		this.type=type;
		return this;
	}

	/**
	 * 创建一个 AddressPureModel，等同于 new
	 * @return AddressPureModel 对象
	*/
	@Transient
	public static AddressPureModel create() {
		return new AddressPureModel();
	}

	/**
	 * 将 Map 转换成 AddressPureModel
	 * @param addressMap 包含实体信息的 Map 对象
	 * @return AddressPureModel , 转换好的的 Address 对象
	*/
	@Transient
	public static AddressPureModel createFrom(Map<String,Object> addressMap) {
		if(addressMap==null) return null;
		AddressPureModel po = new AddressPureModel();
		BeanUtil.copy(addressMap,po);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AddressPureModel
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AddressPureModel , 转换好的的 Address 对象
	*/
	@Transient
	public static AddressPureModel createFrom(Object pojo) {
		if(pojo==null) return null;
		AddressPureModel po = new AddressPureModel();
		BeanUtil.copy(pojo,po,true);
		return po;
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AddressPureModel , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)EntityContext.create((Class<? extends Entity>) pojoType,this);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}