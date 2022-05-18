package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-18 08:51:55
 * @sign FD820CA158ABE822D575BA472DD95DCA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessStartVOMeta {
	
	/**
	 * 流程实例ID , 流程发起前先要暂存流程实例，返回流程实例ID , 类型: java.lang.String
	*/
	public static final String PROCESS_INSTANCE_ID="processInstanceId";
	
	/**
	 * 流程实例ID , 流程发起前先要暂存流程实例，返回流程实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessStartVO,java.lang.String> PROCESS_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessStartVO.class ,PROCESS_INSTANCE_ID, java.lang.String.class, "流程实例ID", "流程发起前先要暂存流程实例，返回流程实例ID", java.lang.String.class, null);
	
	/**
	 * 发起人账户ID , 如果不指定则默认为当前账户ID , 类型: java.lang.String
	*/
	public static final String DRAFTER_USER_ID="drafterUserId";
	
	/**
	 * 发起人账户ID , 如果不指定则默认为当前账户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessStartVO,java.lang.String> DRAFTER_USER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessStartVO.class ,DRAFTER_USER_ID, java.lang.String.class, "发起人账户ID", "如果不指定则默认为当前账户ID", java.lang.String.class, null);
	
	/**
	 * 发起人身份类型 , 发起人身份类型，UnifiedUserType.code()，如果未指定，则使用暂存值 , 类型: java.lang.String
	*/
	public static final String DRAFTER_TYPE="drafterType";
	
	/**
	 * 发起人身份类型 , 发起人身份类型，UnifiedUserType.code()，如果未指定，则使用暂存值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessStartVO,java.lang.String> DRAFTER_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessStartVO.class ,DRAFTER_TYPE, java.lang.String.class, "发起人身份类型", "发起人身份类型，UnifiedUserType.code()，如果未指定，则使用暂存值", java.lang.String.class, null);
	
	/**
	 * 发起人身份ID , 发起人身份ID，如果未指定，则使用暂存值 , 类型: java.lang.String
	*/
	public static final String DRAFTER_ID="drafterId";
	
	/**
	 * 发起人身份ID , 发起人身份ID，如果未指定，则使用暂存值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessStartVO,java.lang.String> DRAFTER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessStartVO.class ,DRAFTER_ID, java.lang.String.class, "发起人身份ID", "发起人身份ID，如果未指定，则使用暂存值", java.lang.String.class, null);
	
	/**
	 * 流程参数 , 集合类型: MAP , 类型: java.lang.Object
	*/
	public static final String VARIABLES="variables";
	
	/**
	 * 流程参数 , 集合类型: MAP , 类型: java.lang.Object
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessStartVO,java.lang.Object> VARIABLES_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessStartVO.class ,VARIABLES, java.util.Map.class, "流程参数", "流程参数", java.lang.Object.class, java.lang.String.class);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PROCESS_INSTANCE_ID , DRAFTER_USER_ID , DRAFTER_TYPE , DRAFTER_ID , VARIABLES };
}