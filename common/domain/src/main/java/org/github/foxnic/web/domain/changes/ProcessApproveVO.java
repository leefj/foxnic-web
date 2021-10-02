package org.github.foxnic.web.domain.changes;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;



/**
 * 用于流程审批
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-02 17:59:45
 * @sign EDEDBDDB3A81539A5829EA1F7B5FAE7E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessApproveVO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 业务单据号
	*/
	@ApiModelProperty(required = false,value="业务单据号" , notes = "")
	private List<String> instanceIds;
	
	/**
	 * 审批意见
	*/
	@ApiModelProperty(required = false,value="审批意见" , notes = "")
	private String opinion;
	
	/**
	 * 审批动作：ApprovalAction的一种
	*/
	@ApiModelProperty(required = false,value="审批动作" , notes = "ApprovalAction的一种")
	private String action;
	
	/**
	 * 获得 业务单据号<br>
	 * @return 业务单据号
	*/
	public List<String> getInstanceIds() {
		return instanceIds;
	}
	
	/**
	 * 设置 业务单据号
	 * @param instanceIds 业务单据号
	 * @return 当前对象
	*/
	public ProcessApproveVO setInstanceIds(List<String> instanceIds) {
		this.instanceIds=instanceIds;
		return this;
	}
	
	/**
	 * 添加 业务单据号
	 * @param instanceId 业务单据号
	 * @return 当前对象
	*/
	public ProcessApproveVO addInstanceId(String instanceId) {
		if(this.instanceIds==null) instanceIds=new ArrayList<>();
		this.instanceIds.add(instanceId);
		return this;
	}
	
	/**
	 * 获得 审批意见<br>
	 * @return 审批意见
	*/
	public String getOpinion() {
		return opinion;
	}
	
	/**
	 * 设置 审批意见
	 * @param opinion 审批意见
	 * @return 当前对象
	*/
	public ProcessApproveVO setOpinion(String opinion) {
		this.opinion=opinion;
		return this;
	}
	
	/**
	 * 获得 审批动作<br>
	 * ApprovalAction的一种
	 * @return 审批动作
	*/
	public String getAction() {
		return action;
	}
	
	/**
	 * 设置 审批动作
	 * @param action 审批动作
	 * @return 当前对象
	*/
	public ProcessApproveVO setAction(String action) {
		this.action=action;
		return this;
	}
}