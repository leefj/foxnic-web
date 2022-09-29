package org.github.foxnic.web.domain.example.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.example.AddressSubModel;
import org.github.foxnic.web.domain.example.AddressModel;
import org.github.foxnic.web.domain.example.Address;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-29 17:09:47
 * @sign 9E592FF32177CCE731954B80F8619340
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AddressSubModelMeta {
	
	/**
	 * 邮编 , 类型: java.lang.String
	*/
	public static final String POST_CODE="postCode";
	
	/**
	 * 邮编 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.AddressSubModel,java.lang.String> POST_CODE_PROP = new BeanProperty(org.github.foxnic.web.domain.example.AddressSubModel.class ,POST_CODE, java.lang.String.class, "邮编", "邮编", java.lang.String.class, null);
	
	/**
	 * 邮编 , 类型: java.lang.String
	*/
	public static final String POST_CODE2="postCode2";
	
	/**
	 * 邮编 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.AddressSubModel,java.lang.String> POST_CODE2_PROP = new BeanProperty(org.github.foxnic.web.domain.example.AddressSubModel.class ,POST_CODE2, java.lang.String.class, "邮编", "邮编", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.AddressSubModel,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.example.AddressSubModel.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 收件人姓名 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 收件人姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.AddressSubModel,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.example.AddressSubModel.class ,NAME, java.lang.String.class, "收件人姓名", "收件人姓名", java.lang.String.class, null);
	
	/**
	 * 收件人手机 , 类型: java.lang.String
	*/
	public static final String PHONE_NUMBER="phoneNumber";
	
	/**
	 * 收件人手机 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.AddressSubModel,java.lang.String> PHONE_NUMBER_PROP = new BeanProperty(org.github.foxnic.web.domain.example.AddressSubModel.class ,PHONE_NUMBER, java.lang.String.class, "收件人手机", "收件人手机", java.lang.String.class, null);
	
	/**
	 * 收件地址 , 类型: java.lang.String
	*/
	public static final String ADDRESS="address";
	
	/**
	 * 收件地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.AddressSubModel,java.lang.String> ADDRESS_PROP = new BeanProperty(org.github.foxnic.web.domain.example.AddressSubModel.class ,ADDRESS, java.lang.String.class, "收件地址", "收件地址", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型，A:国内；B:国外 , 类型: java.lang.String
	*/
	public static final String REGION_TYPE="regionType";
	
	/**
	 * 类型 , 类型，A:国内；B:国外 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.AddressSubModel,java.lang.String> REGION_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.example.AddressSubModel.class ,REGION_TYPE, java.lang.String.class, "类型", "类型，A:国内；B:国外", java.lang.String.class, null);
	
	/**
	 * 地区位置 , 地区位置，东北、华北等 , 类型: java.lang.String
	*/
	public static final String REGION_LOCATION="regionLocation";
	
	/**
	 * 地区位置 , 地区位置，东北、华北等 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.AddressSubModel,java.lang.String> REGION_LOCATION_PROP = new BeanProperty(org.github.foxnic.web.domain.example.AddressSubModel.class ,REGION_LOCATION, java.lang.String.class, "地区位置", "地区位置，东北、华北等", java.lang.String.class, null);
	
	/**
	 * 其它 , 类型: java.lang.String
	*/
	public static final String OTHER="other";
	
	/**
	 * 其它 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.AddressSubModel,java.lang.String> OTHER_PROP = new BeanProperty(org.github.foxnic.web.domain.example.AddressSubModel.class ,OTHER, java.lang.String.class, "其它", "其它", java.lang.String.class, null);
	
	/**
	 * 引用2 , 类型: org.github.foxnic.web.domain.example.Address
	*/
	public static final String ADDRESS_X="addressX";
	
	/**
	 * 引用2 , 类型: org.github.foxnic.web.domain.example.Address
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.AddressSubModel,org.github.foxnic.web.domain.example.Address> ADDRESS_X_PROP = new BeanProperty(org.github.foxnic.web.domain.example.AddressSubModel.class ,ADDRESS_X, org.github.foxnic.web.domain.example.Address.class, "引用2", "引用2", org.github.foxnic.web.domain.example.Address.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ POST_CODE , POST_CODE2 , ID , NAME , PHONE_NUMBER , ADDRESS , REGION_TYPE , REGION_LOCATION , OTHER , ADDRESS_X };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.example.AddressSubModel {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 邮编
		 * @param postCode 邮编
		 * @return 当前对象
		*/
		public AddressSubModel setPostCode(String postCode) {
			super.change(POST_CODE,super.getPostCode(),postCode);
			super.setPostCode(postCode);
			return this;
		}
		
		/**
		 * 设置 邮编
		 * @param postCode2 邮编
		 * @return 当前对象
		*/
		public AddressSubModel setPostCode2(String postCode2) {
			super.change(POST_CODE2,super.getPostCode2(),postCode2);
			super.setPostCode2(postCode2);
			return this;
		}
		
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
		 * @param regionType 类型
		 * @return 当前对象
		*/
		public AddressModel setRegionType(String regionType) {
			super.change(REGION_TYPE,super.getRegionType(),regionType);
			super.setRegionType(regionType);
			return this;
		}
		
		/**
		 * 设置 地区位置
		 * @param regionLocation 地区位置
		 * @return 当前对象
		*/
		public AddressModel setRegionLocation(String regionLocation) {
			super.change(REGION_LOCATION,super.getRegionLocation(),regionLocation);
			super.setRegionLocation(regionLocation);
			return this;
		}
		
		/**
		 * 设置 其它
		 * @param other 其它
		 * @return 当前对象
		*/
		public AddressModel setOther(String other) {
			super.change(OTHER,super.getOther(),other);
			super.setOther(other);
			return this;
		}
		
		/**
		 * 设置 引用2
		 * @param addressX 引用2
		 * @return 当前对象
		*/
		public AddressModel setAddressX(Address addressX) {
			super.change(ADDRESS_X,super.getAddressX(),addressX);
			super.setAddressX(addressX);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AddressSubModel clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AddressSubModel duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
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

	}
}