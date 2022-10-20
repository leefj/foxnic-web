package org.github.foxnic.web.domain.oauth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.enums.system.LoginType;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.bean.BeanUtil;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;



/**
 * 用于App登录接口
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-20 15:07:07
 * @sign 67CB1F28B06642A43DD3CE559E713A6B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel()
public class LoginIdentityVO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 帐号或手机号等用于识别身份的标识
	*/
	@ApiModelProperty(required = false,value="帐号或手机号等用于识别身份的标识" , notes = "")
	private String identity;
	
	/**
	 * 密码
	*/
	@ApiModelProperty(required = false,value="密码" , notes = "")
	private String passwd;
	
	/**
	 * 随机ID：客户端产生的唯一ID，用于标识一次认证
	*/
	@ApiModelProperty(required = false,value="随机ID" , notes = "客户端产生的唯一ID，用于标识一次认证")
	private String browserId;
	
	/**
	 * 校验码/验证码：用户输入的校验码
	*/
	@ApiModelProperty(required = false,value="校验码/验证码" , notes = "用户输入的校验码")
	private String captcha;
	
	/**
	 * 登录方式：登录方式
	*/
	@ApiModelProperty(required = false,value="登录方式" , notes = "登录方式")
	private String loginType;
	@Transient
	private LoginType loginTypeEnum;
	
	/**
	 * 获得 帐号或手机号等用于识别身份的标识<br>
	 * @return 帐号或手机号等用于识别身份的标识
	*/
	public String getIdentity() {
		return identity;
	}
	
	/**
	 * 设置 帐号或手机号等用于识别身份的标识
	 * @param identity 帐号或手机号等用于识别身份的标识
	 * @return 当前对象
	*/
	public LoginIdentityVO setIdentity(String identity) {
		this.identity=identity;
		return this;
	}
	
	/**
	 * 获得 密码<br>
	 * @return 密码
	*/
	public String getPasswd() {
		return passwd;
	}
	
	/**
	 * 设置 密码
	 * @param passwd 密码
	 * @return 当前对象
	*/
	public LoginIdentityVO setPasswd(String passwd) {
		this.passwd=passwd;
		return this;
	}
	
	/**
	 * 获得 随机ID<br>
	 * 客户端产生的唯一ID，用于标识一次认证
	 * @return 随机ID
	*/
	public String getBrowserId() {
		return browserId;
	}
	
	/**
	 * 设置 随机ID
	 * @param browserId 随机ID
	 * @return 当前对象
	*/
	public LoginIdentityVO setBrowserId(String browserId) {
		this.browserId=browserId;
		return this;
	}
	
	/**
	 * 获得 校验码/验证码<br>
	 * 用户输入的校验码
	 * @return 校验码/验证码
	*/
	public String getCaptcha() {
		return captcha;
	}
	
	/**
	 * 设置 校验码/验证码
	 * @param captcha 校验码/验证码
	 * @return 当前对象
	*/
	public LoginIdentityVO setCaptcha(String captcha) {
		this.captcha=captcha;
		return this;
	}
	
	/**
	 * 获得 登录方式<br>
	 * 登录方式
	 * @return 登录方式
	*/
	public String getLoginType() {
		return loginType;
	}
	
	/**
	 * 获得 登录方式 的投影属性<br>
	 * 等价于 getLoginType 方法，获得对应的枚举类型
	 * @return 登录方式
	*/
	@Transient
	public LoginType getLoginTypeEnum() {
		if(this.loginTypeEnum==null) {
			this.loginTypeEnum = (LoginType) EnumUtil.parseByCode(LoginType.values(),loginType);
		}
		return this.loginTypeEnum ;
	}
	
	/**
	 * 设置 登录方式
	 * @param loginType 登录方式
	 * @return 当前对象
	*/
	@JsonProperty("loginType")
	public LoginIdentityVO setLoginType(String loginType) {
		this.loginType=loginType;
		this.loginTypeEnum= (LoginType) EnumUtil.parseByCode(LoginType.values(),loginType) ;
		if(StringUtil.hasContent(loginType) && this.loginTypeEnum==null) {
			throw new IllegalArgumentException( loginType + " is not one of LoginType");
		}
		return this;
	}
	
	/**
	 * 设置 登录方式的投影属性，等同于设置 登录方式
	 * @param loginTypeEnum 登录方式
	 * @return 当前对象
	*/
	@Transient
	public LoginIdentityVO setLoginTypeEnum(LoginType loginTypeEnum) {
		if(loginTypeEnum==null) {
			this.setLoginType(null);
		} else {
			this.setLoginType(loginTypeEnum.code());
		}
		this.loginTypeEnum=loginTypeEnum;
		return this;
	}

	/**
	 * 创建一个 LoginIdentityVO，等同于 new
	 * @return LoginIdentityVO 对象
	*/
	@Transient
	public static LoginIdentityVO create() {
		return new LoginIdentityVO();
	}

	/**
	 * 将 Map 转换成 LoginIdentityVO
	 * @param userMap 包含实体信息的 Map 对象
	 * @return LoginIdentityVO , 转换好的的 User 对象
	*/
	@Transient
	public static LoginIdentityVO createFrom(Map<String,Object> userMap) {
		if(userMap==null) return null;
		LoginIdentityVO po = new LoginIdentityVO();
		BeanUtil.copy(userMap,po);
		return po;
	}

	/**
	 * 将 Pojo 转换成 LoginIdentityVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return LoginIdentityVO , 转换好的的 User 对象
	*/
	@Transient
	public static LoginIdentityVO createFrom(Object pojo) {
		if(pojo==null) return null;
		LoginIdentityVO po = new LoginIdentityVO();
		BeanUtil.copy(pojo,po,true);
		return po;
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public LoginIdentityVO duplicate(boolean all) {
		LoginIdentityVO inst = new LoginIdentityVO();
		// others
			inst.setBrowserId(this.getBrowserId());
			inst.setPasswd(this.getPasswd());
			inst.setCaptcha(this.getCaptcha());
			inst.setLoginType(this.getLoginType());
			inst.setIdentity(this.getIdentity());
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public LoginIdentityVO clone() {
		return BeanUtil.clone(this,false);
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public LoginIdentityVO clone(boolean deep) {
		return BeanUtil.clone(this,deep);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return LoginIdentityVO , 转换好的 PoJo 对象
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