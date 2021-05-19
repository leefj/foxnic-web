package com.scientific.tailoring.domain.system;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 10:53:40
 * @sign F9460BC70824A83C1479BB1EA5D78664
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class UserEditModel extends User {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 角色ID清单
	*/
	@ApiModelProperty(required = false,value="角色ID清单" , notes = "")
	private List<Integer> roleIds;
	
	/**
	 * 获得 角色ID清单<br>
	 * @return 角色ID清单
	*/
	public List<Integer> getRoleIds() {
		return roleIds;
	}
	
	/**
	 * 设置 角色ID清单
	 * @param roleIds 角色ID清单
	 * @return 当前对象
	*/
	public UserEditModel setRoleIds(List<Integer> roleIds) {
		this.roleIds=roleIds;
		return this;
	}
}