package org.github.foxnic.web.oauth.jwt;


import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.github.foxnic.commons.busi.id.IDGenerator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 构建 jwt payload
 *
 * @author 李方捷
 * @since  2021-06-02
 **/
public class JwtToken {
 
	private String jti;
	
	

    private Map<String, String> payload = new HashMap<>();
 
    /**
     * jwt签发者
     **/
    private String iss;
    /**
     * jwt所面向的用户
     **/
    private String sub;
    /**
     * 接收jwt的一方 姓名
     **/
    private String aud;
    /**
     * 接收jwt的一方 ID
     **/
    private String uid;
    /**
     * jwt的过期时间，这个过期时间必须要大于签发时间
     **/
    private LocalDateTime exp;
    /**
     * jwt的签发时间
     **/
    private LocalDateTime iat = LocalDateTime.now();
    
    /**
     * token 类型  access/refresh
     **/
    private String type;
    
    /**
     * token 结果
     **/
    private String token;
 
    public JwtToken type(String type) {
        this.type = type;
        return this;
    }
    
    public JwtToken jti(String jti) {
    	this.jti = jti;
    	return this;
	}
    
    public JwtToken uid(String uid) {
        this.uid = uid;
        return this;
    }
 
    public JwtToken iss(String iss) {
        this.iss = iss;
        return this;
    }
 
    public JwtToken sub(String sub) {
        this.sub = sub;
        return this;
    }

    public JwtToken aud(String aud) {
        this.aud = aud;
        return this;
    }
 
    public JwtToken expireSeconds(int seconds) {
        Assert.isTrue(seconds > 0, "jwt expire seconds must after now");
        this.exp = this.iat.plusSeconds(seconds);
        return this;
    }
    
    public LocalDateTime exp() {
    	return this.exp;
    }
    
  
    public String builder() {
    	
    	payload.put("iss", this.iss);
        payload.put("sub", this.sub);
        payload.put("uid", this.uid);
        payload.put("aud", this.aud);
        payload.put("exp", this.exp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        payload.put("iat", this.iat.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        payload.put("jti",this.jti);

        
        return JSON.toJSONString(payload);
    }

	public String token() {
		return token;
	}

	public void token(String token) {
		this.token = token;
	}

	public String uid() {
		return this.uid;
	}
 
}
