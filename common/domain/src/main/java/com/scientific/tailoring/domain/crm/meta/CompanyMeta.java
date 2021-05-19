package com.scientific.tailoring.domain.crm.meta;

import com.scientific.tailoring.domain.crm.Company;
import java.util.Date;



/**
 * @author 李方捷
 * @since 2021-05-17 01:13:37
 * @sign 53D2C66F4638DF83F5A839EE92C03263
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CompanyMeta {
	
	/**
	 * ID
	*/
	public static final String ID="id";
	
	/**
	 * 公司名称
	*/
	public static final String NAME="name";
	
	/**
	 * 统一社会信用代码
	*/
	public static final String UNIFY_SOCIAL_CODE="unifySocialCode";
	
	/**
	 * 营业执照图片地址
	*/
	public static final String LICENSE_PHOTO="licensePhoto";
	
	/**
	 * 经营范围
	*/
	public static final String BUSINESS_RANGE="businessRange";
	
	/**
	 * 营业期限开始日期
	*/
	public static final String TERM_START_DATE="termStartDate";
	
	/**
	 * 营业期限结束日期
	*/
	public static final String TERM_END_DATE="termEndDate";
	
	/**
	 * 合同生效时间
	*/
	public static final String CONTRACT_START_DATE="contractStartDate";
	
	/**
	 * 合同状态
	*/
	public static final String CONTRACT_STATUS="contractStatus";
	
	/**
	 * 公司类型 , 供应商/客户
	*/
	public static final String TYPE="type";
	
	/**
	 * 创建人ID
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建时间
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 修改人ID
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改时间
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 是否已删除
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 删除人ID
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除时间
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 数据版本号
	*/
	public static final String VERSION="version";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , UNIFY_SOCIAL_CODE , LICENSE_PHOTO , BUSINESS_RANGE , TERM_START_DATE , TERM_END_DATE , CONTRACT_START_DATE , CONTRACT_STATUS , TYPE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.crm.Company {
		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public Company setId(Long id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 公司名称
		 * @param name 公司名称
		 * @return 当前对象
		*/
		public Company setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 统一社会信用代码
		 * @param unifySocialCode 统一社会信用代码
		 * @return 当前对象
		*/
		public Company setUnifySocialCode(String unifySocialCode) {
			super.change(UNIFY_SOCIAL_CODE,super.getUnifySocialCode(),unifySocialCode);
			super.setUnifySocialCode(unifySocialCode);
			return this;
		}
		
		/**
		 * 设置 营业执照图片地址
		 * @param licensePhoto 营业执照图片地址
		 * @return 当前对象
		*/
		public Company setLicensePhoto(String licensePhoto) {
			super.change(LICENSE_PHOTO,super.getLicensePhoto(),licensePhoto);
			super.setLicensePhoto(licensePhoto);
			return this;
		}
		
		/**
		 * 设置 经营范围
		 * @param businessRange 经营范围
		 * @return 当前对象
		*/
		public Company setBusinessRange(String businessRange) {
			super.change(BUSINESS_RANGE,super.getBusinessRange(),businessRange);
			super.setBusinessRange(businessRange);
			return this;
		}
		
		/**
		 * 设置 营业期限开始日期
		 * @param termStartDate 营业期限开始日期
		 * @return 当前对象
		*/
		public Company setTermStartDate(String termStartDate) {
			super.change(TERM_START_DATE,super.getTermStartDate(),termStartDate);
			super.setTermStartDate(termStartDate);
			return this;
		}
		
		/**
		 * 设置 营业期限结束日期
		 * @param termEndDate 营业期限结束日期
		 * @return 当前对象
		*/
		public Company setTermEndDate(Date termEndDate) {
			super.change(TERM_END_DATE,super.getTermEndDate(),termEndDate);
			super.setTermEndDate(termEndDate);
			return this;
		}
		
		/**
		 * 设置 合同生效时间
		 * @param contractStartDate 合同生效时间
		 * @return 当前对象
		*/
		public Company setContractStartDate(Date contractStartDate) {
			super.change(CONTRACT_START_DATE,super.getContractStartDate(),contractStartDate);
			super.setContractStartDate(contractStartDate);
			return this;
		}
		
		/**
		 * 设置 合同状态
		 * @param contractStatus 合同状态
		 * @return 当前对象
		*/
		public Company setContractStatus(String contractStatus) {
			super.change(CONTRACT_STATUS,super.getContractStatus(),contractStatus);
			super.setContractStatus(contractStatus);
			return this;
		}
		
		/**
		 * 设置 公司类型
		 * @param type 公司类型
		 * @return 当前对象
		*/
		public Company setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Company setCreateBy(Long createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Company setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Company setUpdateBy(Long updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Company setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Company setDeleted(Boolean deleted) {
			super.change(DELETED,super.isDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Company setDeleteBy(Long deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Company setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Company setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
}
}