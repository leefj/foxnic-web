package org.github.foxnic.web.domain.example;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;



/**
 * AddressModel 模型
 * <p>用于 AddressModel 的保存</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-29 17:09:47
 * @sign 9E592FF32177CCE731954B80F8619340
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "AddressModel 模型 ; 用于 AddressModel 的保存" , parent = AddressModel.class)
public class AddressSubModel extends AddressModel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 邮编：邮编
	*/
	@ApiModelProperty(required = false,value="邮编" , notes = "邮编")
	private String postCode;
	
	/**
	 * 邮编：邮编
	*/
	@ApiModelProperty(required = false,value="邮编" , notes = "邮编")
	private String postCode2;
	
	/**
	 * 获得 邮编<br>
	 * 邮编
	 * @return 邮编
	*/
	public String getPostCode() {
		return postCode;
	}
	
	/**
	 * 设置 邮编
	 * @param postCode 邮编
	 * @return 当前对象
	*/
	public AddressSubModel setPostCode(String postCode) {
		this.postCode=postCode;
		return this;
	}
	
	/**
	 * 获得 邮编<br>
	 * 邮编
	 * @return 邮编
	*/
	public String getPostCode2() {
		return postCode2;
	}
	
	/**
	 * 设置 邮编
	 * @param postCode2 邮编
	 * @return 当前对象
	*/
	public AddressSubModel setPostCode2(String postCode2) {
		this.postCode2=postCode2;
		return this;
	}

	/**
	 * 将 Map 转换成 AddressSubModel
	 * @param addressMap 包含实体信息的 Map 对象
	 * @return AddressSubModel , 转换好的的 Address 对象
	*/
	@Transient
	public static AddressSubModel createFrom(Map<String,Object> addressMap) {
		if(addressMap==null) return null;
		AddressSubModel po = create();
		EntityContext.copyProperties(po,addressMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AddressSubModel
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AddressSubModel , 转换好的的 Address 对象
	*/
	@Transient
	public static AddressSubModel createFrom(Object pojo) {
		if(pojo==null) return null;
		AddressSubModel po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AddressSubModel duplicate(boolean all) {
		org.github.foxnic.web.domain.example.meta.AddressSubModelMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.example.meta.AddressSubModelMeta.$$proxy$$();
		inst.setPhoneNumber(this.getPhoneNumber());
		inst.setAddress(this.getAddress());
		inst.setRegionType(this.getRegionType());
		inst.setName(this.getName());
		inst.setId(this.getId());
		inst.setRegionLocation(this.getRegionLocation());
		if(all) {
			inst.setPostCode2(this.getPostCode2());
			inst.setOther(this.getOther());
			inst.setPostCode(this.getPostCode());
			inst.setAddressX(this.getAddressX());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AddressSubModel clone() {
		return duplicate(true);
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AddressSubModel clone(boolean deep) {
		return EntityContext.clone(AddressSubModel.class,this,deep);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AddressSubModel , 转换好的 PoJo 对象
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

	/**
	 * 创建一个 AddressSubModel，等同于 new
	 * @return AddressSubModel 对象
	*/
	@Transient
	public static AddressSubModel create() {
		return new org.github.foxnic.web.domain.example.meta.AddressSubModelMeta.$$proxy$$();
	}
}