package org.github.foxnic.web.domain.changes.meta;

import com.github.foxnic.api.bean.BeanProperty;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-07-28 13:39:20
 * @sign EDEDBDDB3A81539A5829EA1F7B5FAE7E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessApproveVOMeta {
	
	/**
	 * 业务单据号 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String INSTANCE_IDS="instanceIds";
	
	/**
	 * 业务单据号 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ProcessApproveVO,java.lang.String> INSTANCE_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ProcessApproveVO.class ,INSTANCE_IDS, java.util.List.class, "业务单据号", "", java.lang.String.class, null);
	
	/**
	 * 审批意见 , 类型: java.lang.String
	*/
	public static final String OPINION="opinion";
	
	/**
	 * 审批意见 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ProcessApproveVO,java.lang.String> OPINION_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ProcessApproveVO.class ,OPINION, java.lang.String.class, "审批意见", "", java.lang.String.class, null);
	
	/**
	 * 审批动作 , ApprovalAction的一种 , 类型: java.lang.String
	*/
	public static final String ACTION="action";
	
	/**
	 * 审批动作 , ApprovalAction的一种 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ProcessApproveVO,java.lang.String> ACTION_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ProcessApproveVO.class ,ACTION, java.lang.String.class, "审批动作", "ApprovalAction的一种", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ INSTANCE_IDS , OPINION , ACTION };
}