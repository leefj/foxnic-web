package org.github.foxnic.web.domain.changes;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;



/**
 * 用于流程提交
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-07-28 13:39:20
 * @sign 2F9700BA3CA5CDAA05601FF6387341FB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessStartVO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 业务单据号
	*/
	@ApiModelProperty(required = false,value="业务单据号" , notes = "")
	private List<String> billIds;
	
	/**
	 * 审批意见
	*/
	@ApiModelProperty(required = false,value="审批意见" , notes = "")
	private String opinion;
	
	/**
	 * 获得 业务单据号<br>
	 * @return 业务单据号
	*/
	public List<String> getBillIds() {
		return billIds;
	}
	
	/**
	 * 设置 业务单据号
	 * @param billIds 业务单据号
	 * @return 当前对象
	*/
	public ProcessStartVO setBillIds(List<String> billIds) {
		this.billIds=billIds;
		return this;
	}
	
	/**
	 * 添加 业务单据号
	 * @param billId 业务单据号
	 * @return 当前对象
	*/
	public ProcessStartVO addBillId(String... billId) {
		if(this.billIds==null) billIds=new ArrayList<>();
		this.billIds.addAll(Arrays.asList(billId));
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
	public ProcessStartVO setOpinion(String opinion) {
		this.opinion=opinion;
		return this;
	}
}