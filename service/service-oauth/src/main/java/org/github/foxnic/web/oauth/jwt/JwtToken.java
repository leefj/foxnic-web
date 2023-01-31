package org.github.foxnic.web.oauth.jwt;


import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.commons.lang.StringUtil;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.github.foxnic.commons.busi.id.IDGenerator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 构建 jwt payload
 *
 * @author 李方捷
 * @since  2021-06-02
 **/
public class JwtToken {

	private String jti;

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
    private TokenType type;

    /**
     * token 结果
     **/
    private String token;

    public  JwtToken (JSONObject data) {
        if(data!=null) {
            read(data);
        }
    }

    public void read(JSONObject data) {
        this.exp = DataParser.parseLocalDateTime(data.getString("exp"));
        String typeStr = data.getString("type");
        if (StringUtil.hasContent(typeStr)) {
            this.type = TokenType.valueOf(typeStr);
        } else {
            this.type = TokenType.access;
        }
        this.jti = data.getString("jti");
        this.uid = data.getString("uid");
        this.iss = data.getString("iss");
        this.sub = data.getString("sub");
        this.aud = data.getString("aud");
        this.token = data.getString("token");
        this.iat = DataParser.parseLocalDateTime(data.getString("iat"));
    }

    public JSONObject toJSON() {
        JSONObject payload = new JSONObject();
        payload.put("iss", this.iss);
        payload.put("sub", this.sub);
        payload.put("uid", this.uid);
        payload.put("aud", this.aud);
        if(this.type!=null) {
            payload.put("type", this.type.name());
        }
        if(this.exp!=null) {
            payload.put("exp", this.exp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        if(this.iat!=null) {
            payload.put("iat", this.iat.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        payload.put("jti",this.jti);
        payload.put("token",this.token);
        return payload;
    }

    public JwtToken type(TokenType type) {
        this.type = type;
        return this;
    }

    public TokenType type() {
        return this.type;
    }

    public JwtToken jti(String jti) {
    	this.jti = jti;
    	return this;
	}

    public String jti() {
        return this.jti;
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

    public String aud() {
        return aud;
    }

    public JwtToken expireSeconds(int seconds) {
        Assert.isTrue(seconds > 0, "jwt expire seconds must after now");
        this.exp = this.iat.plusSeconds(seconds);
        return this;
    }




    public String builder() {
        return toJSON().toJSONString();
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

    public LocalDateTime exp() {
        return exp;
    }

    public void exp(String exp) {
        this.exp = DataParser.parse(LocalDateTime.class,exp);
    }

    public void exp(Date exp) {
        this.exp = DataParser.parse(LocalDateTime.class,exp);
    }

    /**
     * 判断jwt token是否过期.
     *
     * @return the boolean
     */
    public boolean isExpire() {
        if(this.exp==null) {
            throw new IllegalArgumentException("缺少 exp 值");
        }
        return LocalDateTime.now().isAfter(this.exp);
    }


}
