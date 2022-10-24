package org.github.foxnic.web.domain.oauth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Transient;
import com.github.foxnic.commons.bean.BeanUtil;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;



/**
 * Token模型
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-24 13:52:09
 * @sign 23CDE697EC92B4743B0A12B929D8E1AF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "Token模型")
public class TokenModel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * accessToken
	*/
	@ApiModelProperty(required = false,value="accessToken" , notes = "")
	private String accessToken;
	
	/**
	 * refreshToken
	*/
	@ApiModelProperty(required = false,value="refreshToken" , notes = "")
	private String refreshToken;
	
	/**
	 * 获得 accessToken<br>
	 * @return accessToken
	*/
	public String getAccessToken() {
		return accessToken;
	}
	
	/**
	 * 设置 accessToken
	 * @param accessToken accessToken
	 * @return 当前对象
	*/
	public TokenModel setAccessToken(String accessToken) {
		this.accessToken=accessToken;
		return this;
	}
	
	/**
	 * 获得 refreshToken<br>
	 * @return refreshToken
	*/
	public String getRefreshToken() {
		return refreshToken;
	}
	
	/**
	 * 设置 refreshToken
	 * @param refreshToken refreshToken
	 * @return 当前对象
	*/
	public TokenModel setRefreshToken(String refreshToken) {
		this.refreshToken=refreshToken;
		return this;
	}

	/**
	 * 创建一个 TokenModel，等同于 new
	 * @return TokenModel 对象
	*/
	@Transient
	public static TokenModel create() {
		return new TokenModel();
	}

	/**
	 * 将 Map 转换成 TokenModel
	 * @param userMap 包含实体信息的 Map 对象
	 * @return TokenModel , 转换好的的 User 对象
	*/
	@Transient
	public static TokenModel createFrom(Map<String,Object> userMap) {
		if(userMap==null) return null;
		TokenModel po = new TokenModel();
		BeanUtil.copy(userMap,po);
		return po;
	}

	/**
	 * 将 Pojo 转换成 TokenModel
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return TokenModel , 转换好的的 User 对象
	*/
	@Transient
	public static TokenModel createFrom(Object pojo) {
		if(pojo==null) return null;
		TokenModel po = new TokenModel();
		BeanUtil.copy(pojo,po,true);
		return po;
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public TokenModel duplicate(boolean all) {
		TokenModel inst = new TokenModel();
		// others
			inst.setAccessToken(this.getAccessToken());
			inst.setRefreshToken(this.getRefreshToken());
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public TokenModel clone() {
		return BeanUtil.clone(this,false);
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public TokenModel clone(boolean deep) {
		return BeanUtil.clone(this,deep);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return TokenModel , 转换好的 PoJo 对象
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
}