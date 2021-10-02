package org.github.foxnic.web.domain.changes.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.changes.ChangeBill;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-02 11:15:23
 * @sign CA8B46E07BA709674E24B11CB4D68C59
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ChangeBillMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeBill,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeBill.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 变更定义ID , 类型: java.lang.String
	*/
	public static final String DEFINITION_ID="definitionId";
	
	/**
	 * 变更定义ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeBill,java.lang.String> DEFINITION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeBill.class ,DEFINITION_ID, java.lang.String.class, "变更定义ID", "变更定义ID", java.lang.String.class, null);
	
	/**
	 * 变更实例ID , 类型: java.lang.String
	*/
	public static final String INSTANCE_ID="instanceId";
	
	/**
	 * 变更实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeBill,java.lang.String> INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeBill.class ,INSTANCE_ID, java.lang.String.class, "变更实例ID", "变更实例ID", java.lang.String.class, null);
	
	/**
	 * 变更单据ID , 类型: java.lang.String
	*/
	public static final String BILL_ID="billId";
	
	/**
	 * 变更单据ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeBill,java.lang.String> BILL_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeBill.class ,BILL_ID, java.lang.String.class, "变更单据ID", "变更单据ID", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , DEFINITION_ID , INSTANCE_ID , BILL_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.changes.ChangeBill {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ChangeBill setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 变更定义ID
		 * @param definitionId 变更定义ID
		 * @return 当前对象
		*/
		public ChangeBill setDefinitionId(String definitionId) {
			super.change(DEFINITION_ID,super.getDefinitionId(),definitionId);
			super.setDefinitionId(definitionId);
			return this;
		}
		
		/**
		 * 设置 变更实例ID
		 * @param instanceId 变更实例ID
		 * @return 当前对象
		*/
		public ChangeBill setInstanceId(String instanceId) {
			super.change(INSTANCE_ID,super.getInstanceId(),instanceId);
			super.setInstanceId(instanceId);
			return this;
		}
		
		/**
		 * 设置 变更单据ID
		 * @param billId 变更单据ID
		 * @return 当前对象
		*/
		public ChangeBill setBillId(String billId) {
			super.change(BILL_ID,super.getBillId(),billId);
			super.setBillId(billId);
			return this;
		}
	}
}