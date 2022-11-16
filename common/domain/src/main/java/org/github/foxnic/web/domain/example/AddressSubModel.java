package org.github.foxnic.web.domain.example;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;
import org.github.foxnic.web.domain.example.meta.AddressSubModelMeta;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * AddressModel 模型
 * <p>用于 AddressModel 的保存</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-11-16 16:47:32
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

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setPhoneNumber(DataParser.parse(String.class, map.get(AddressSubModelMeta.PHONE_NUMBER)));
			this.setAddress(DataParser.parse(String.class, map.get(AddressSubModelMeta.ADDRESS)));
			this.setRegionType(DataParser.parse(String.class, map.get(AddressSubModelMeta.REGION_TYPE)));
			this.setName(DataParser.parse(String.class, map.get(AddressSubModelMeta.NAME)));
			this.setId(DataParser.parse(String.class, map.get(AddressSubModelMeta.ID)));
			this.setRegionLocation(DataParser.parse(String.class, map.get(AddressSubModelMeta.REGION_LOCATION)));
			// others
			this.setPostCode2(DataParser.parse(String.class, map.get(AddressSubModelMeta.POST_CODE2)));
			this.setOther(DataParser.parse(String.class, map.get(AddressSubModelMeta.OTHER)));
			this.setPostCode(DataParser.parse(String.class, map.get(AddressSubModelMeta.POST_CODE)));
			this.setAddressX(DataParser.parse(Address.class, map.get(AddressSubModelMeta.ADDRESS_X)));
			return true;
		} else {
			try {
				this.setPhoneNumber( (String)map.get(AddressSubModelMeta.PHONE_NUMBER));
				this.setAddress( (String)map.get(AddressSubModelMeta.ADDRESS));
				this.setRegionType( (String)map.get(AddressSubModelMeta.REGION_TYPE));
				this.setName( (String)map.get(AddressSubModelMeta.NAME));
				this.setId( (String)map.get(AddressSubModelMeta.ID));
				this.setRegionLocation( (String)map.get(AddressSubModelMeta.REGION_LOCATION));
				// others
				this.setPostCode2( (String)map.get(AddressSubModelMeta.POST_CODE2));
				this.setOther( (String)map.get(AddressSubModelMeta.OTHER));
				this.setPostCode( (String)map.get(AddressSubModelMeta.POST_CODE));
				this.setAddressX( (Address)map.get(AddressSubModelMeta.ADDRESS_X));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setPhoneNumber(DataParser.parse(String.class, r.getValue(AddressSubModelMeta.PHONE_NUMBER)));
			this.setAddress(DataParser.parse(String.class, r.getValue(AddressSubModelMeta.ADDRESS)));
			this.setRegionType(DataParser.parse(String.class, r.getValue(AddressSubModelMeta.REGION_TYPE)));
			this.setName(DataParser.parse(String.class, r.getValue(AddressSubModelMeta.NAME)));
			this.setId(DataParser.parse(String.class, r.getValue(AddressSubModelMeta.ID)));
			this.setRegionLocation(DataParser.parse(String.class, r.getValue(AddressSubModelMeta.REGION_LOCATION)));
			return true;
		} else {
			try {
				this.setPhoneNumber( (String)r.getValue(AddressSubModelMeta.PHONE_NUMBER));
				this.setAddress( (String)r.getValue(AddressSubModelMeta.ADDRESS));
				this.setRegionType( (String)r.getValue(AddressSubModelMeta.REGION_TYPE));
				this.setName( (String)r.getValue(AddressSubModelMeta.NAME));
				this.setId( (String)r.getValue(AddressSubModelMeta.ID));
				this.setRegionLocation( (String)r.getValue(AddressSubModelMeta.REGION_LOCATION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}