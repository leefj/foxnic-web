package org.github.foxnic.web.domain.changes.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.changes.ExampleOrder;
import java.util.Date;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.changes.ExampleOrderItem;
import java.util.List;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-30 16:34:12
 * @sign 9B0D224725AE9D00DE96DB8F8D493737
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ExampleOrderMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 标题 , 类型: java.lang.String
	*/
	public static final String TITLE="title";
	
	/**
	 * 标题 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.lang.String> TITLE_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,TITLE, java.lang.String.class, "标题", "标题", java.lang.String.class, null);
	
	/**
	 * 订单编号 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 订单编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.lang.String> CODE_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,CODE, java.lang.String.class, "订单编号", "订单编号", java.lang.String.class, null);
	
	/**
	 * 下单时间 , 类型: java.util.Date
	*/
	public static final String ORDER_TIME="orderTime";
	
	/**
	 * 下单时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.util.Date> ORDER_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,ORDER_TIME, java.util.Date.class, "下单时间", "下单时间", java.util.Date.class, null);
	
	/**
	 * 买家ID , 类型: java.lang.String
	*/
	public static final String BUYER_ID="buyerId";
	
	/**
	 * 买家ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.lang.String> BUYER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,BUYER_ID, java.lang.String.class, "买家ID", "买家ID", java.lang.String.class, null);
	
	/**
	 * 收件地址 , 类型: java.lang.String
	*/
	public static final String ADDRESS="address";
	
	/**
	 * 收件地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.lang.String> ADDRESS_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,ADDRESS, java.lang.String.class, "收件地址", "收件地址", java.lang.String.class, null);
	
	/**
	 * 总金额 , 类型: java.math.BigDecimal
	*/
	public static final String AMOUNT="amount";
	
	/**
	 * 总金额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.math.BigDecimal> AMOUNT_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,AMOUNT, java.math.BigDecimal.class, "总金额", "总金额", java.math.BigDecimal.class, null);
	
	/**
	 * 变更类型 , 类型: java.lang.String
	*/
	public static final String CHS_TYPE="chsType";
	
	/**
	 * 变更类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.lang.String> CHS_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,CHS_TYPE, java.lang.String.class, "变更类型", "变更类型", java.lang.String.class, null);
	
	/**
	 * 变更状态 , 类型: java.lang.String
	*/
	public static final String CHS_STATUS="chsStatus";
	
	/**
	 * 变更状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.lang.String> CHS_STATUS_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,CHS_STATUS, java.lang.String.class, "变更状态", "变更状态", java.lang.String.class, null);
	
	/**
	 * 变更版本号 , 类型: java.lang.Integer
	*/
	public static final String CHS_VERSION="chsVersion";
	
	/**
	 * 变更版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.lang.Integer> CHS_VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,CHS_VERSION, java.lang.Integer.class, "变更版本号", "变更版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 来源ID , 类型: java.lang.String
	*/
	public static final String SOURCE_ID="sourceId";
	
	/**
	 * 来源ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.lang.String> SOURCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,SOURCE_ID, java.lang.String.class, "来源ID", "来源ID", java.lang.String.class, null);
	
	/**
	 * 变更ID , 类型: java.lang.String
	*/
	public static final String CHS_ID="chsId";
	
	/**
	 * 变更ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.lang.String> CHS_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,CHS_ID, java.lang.String.class, "变更ID", "变更ID", java.lang.String.class, null);
	
	/**
	 * 流程ID , 类型: java.lang.String
	*/
	public static final String PROC_ID="procId";
	
	/**
	 * 流程ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.lang.String> PROC_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,PROC_ID, java.lang.String.class, "流程ID", "流程ID", java.lang.String.class, null);
	
	/**
	 * 流程概要 , 类型: java.lang.String
	*/
	public static final String PROC_SUMMARY="procSummary";
	
	/**
	 * 流程概要 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.lang.String> PROC_SUMMARY_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,PROC_SUMMARY, java.lang.String.class, "流程概要", "流程概要", java.lang.String.class, null);
	
	/**
	 * 审批节点概要 , 类型: java.lang.String
	*/
	public static final String PROC_NODE_SUMMARY="procNodeSummary";
	
	/**
	 * 审批节点概要 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,java.lang.String> PROC_NODE_SUMMARY_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,PROC_NODE_SUMMARY, java.lang.String.class, "审批节点概要", "审批节点概要", java.lang.String.class, null);
	
	/**
	 * 订单明细 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.changes.ExampleOrderItem
	*/
	public static final String ITEMS="items";
	
	/**
	 * 订单明细 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.changes.ExampleOrderItem
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrder,org.github.foxnic.web.domain.changes.ExampleOrderItem> ITEMS_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrder.class ,ITEMS, java.util.List.class, "订单明细", "订单明细", org.github.foxnic.web.domain.changes.ExampleOrderItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TITLE , CODE , ORDER_TIME , BUYER_ID , ADDRESS , AMOUNT , CHS_TYPE , CHS_STATUS , CHS_VERSION , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , SOURCE_ID , CHS_ID , PROC_ID , PROC_SUMMARY , PROC_NODE_SUMMARY , ITEMS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.changes.ExampleOrder {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ExampleOrder setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 标题
		 * @param title 标题
		 * @return 当前对象
		*/
		public ExampleOrder setTitle(String title) {
			super.change(TITLE,super.getTitle(),title);
			super.setTitle(title);
			return this;
		}
		
		/**
		 * 设置 订单编号
		 * @param code 订单编号
		 * @return 当前对象
		*/
		public ExampleOrder setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 下单时间
		 * @param orderTime 下单时间
		 * @return 当前对象
		*/
		public ExampleOrder setOrderTime(Date orderTime) {
			super.change(ORDER_TIME,super.getOrderTime(),orderTime);
			super.setOrderTime(orderTime);
			return this;
		}
		
		/**
		 * 设置 买家ID
		 * @param buyerId 买家ID
		 * @return 当前对象
		*/
		public ExampleOrder setBuyerId(String buyerId) {
			super.change(BUYER_ID,super.getBuyerId(),buyerId);
			super.setBuyerId(buyerId);
			return this;
		}
		
		/**
		 * 设置 收件地址
		 * @param address 收件地址
		 * @return 当前对象
		*/
		public ExampleOrder setAddress(String address) {
			super.change(ADDRESS,super.getAddress(),address);
			super.setAddress(address);
			return this;
		}
		
		/**
		 * 设置 总金额
		 * @param amount 总金额
		 * @return 当前对象
		*/
		public ExampleOrder setAmount(BigDecimal amount) {
			super.change(AMOUNT,super.getAmount(),amount);
			super.setAmount(amount);
			return this;
		}
		
		/**
		 * 设置 变更类型
		 * @param chsType 变更类型
		 * @return 当前对象
		*/
		public ExampleOrder setChsType(String chsType) {
			super.change(CHS_TYPE,super.getChsType(),chsType);
			super.setChsType(chsType);
			return this;
		}
		
		/**
		 * 设置 变更状态
		 * @param chsStatus 变更状态
		 * @return 当前对象
		*/
		public ExampleOrder setChsStatus(String chsStatus) {
			super.change(CHS_STATUS,super.getChsStatus(),chsStatus);
			super.setChsStatus(chsStatus);
			return this;
		}
		
		/**
		 * 设置 变更版本号
		 * @param chsVersion 变更版本号
		 * @return 当前对象
		*/
		public ExampleOrder setChsVersion(Integer chsVersion) {
			super.change(CHS_VERSION,super.getChsVersion(),chsVersion);
			super.setChsVersion(chsVersion);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public ExampleOrder setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ExampleOrder setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ExampleOrder setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ExampleOrder setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ExampleOrder setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ExampleOrder setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ExampleOrder setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ExampleOrder setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public ExampleOrder setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 来源ID
		 * @param sourceId 来源ID
		 * @return 当前对象
		*/
		public ExampleOrder setSourceId(String sourceId) {
			super.change(SOURCE_ID,super.getSourceId(),sourceId);
			super.setSourceId(sourceId);
			return this;
		}
		
		/**
		 * 设置 变更ID
		 * @param chsId 变更ID
		 * @return 当前对象
		*/
		public ExampleOrder setChsId(String chsId) {
			super.change(CHS_ID,super.getChsId(),chsId);
			super.setChsId(chsId);
			return this;
		}
		
		/**
		 * 设置 流程ID
		 * @param procId 流程ID
		 * @return 当前对象
		*/
		public ExampleOrder setProcId(String procId) {
			super.change(PROC_ID,super.getProcId(),procId);
			super.setProcId(procId);
			return this;
		}
		
		/**
		 * 设置 流程概要
		 * @param procSummary 流程概要
		 * @return 当前对象
		*/
		public ExampleOrder setProcSummary(String procSummary) {
			super.change(PROC_SUMMARY,super.getProcSummary(),procSummary);
			super.setProcSummary(procSummary);
			return this;
		}
		
		/**
		 * 设置 审批节点概要
		 * @param procNodeSummary 审批节点概要
		 * @return 当前对象
		*/
		public ExampleOrder setProcNodeSummary(String procNodeSummary) {
			super.change(PROC_NODE_SUMMARY,super.getProcNodeSummary(),procNodeSummary);
			super.setProcNodeSummary(procNodeSummary);
			return this;
		}
		
		/**
		 * 设置 订单明细
		 * @param items 订单明细
		 * @return 当前对象
		*/
		public ExampleOrder setItems(List<ExampleOrderItem> items) {
			super.change(ITEMS,super.getItems(),items);
			super.setItems(items);
			return this;
		}
	}
}