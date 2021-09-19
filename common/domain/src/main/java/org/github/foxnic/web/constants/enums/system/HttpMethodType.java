package org.github.foxnic.web.constants.enums.system;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum HttpMethodType implements CodeTextEnum {
	GET("向特定的资源发出请求。"),
	POST("向指定资源提交数据进行处理请求，数据被包含在请求体中，POST请求可能会导致新的资源的创建和/或已有资源的修改。"),
	PUT("向指定资源位置上传其最新内容。"),
	OPTIONS("返回服务器针对特定资源所支持的HTTP请求方法。也可以利用向Web服务器发送'*'的请求来测试服务器的功能性。"),
	HEAD("向服务器索要与GET请求相一致的响应，只不过响应体将不会被返回。这一方法可以在不必传输整个响应内容的情况下，就可以获取包含在响应消息头中的元信息。"),
	TRACE("回显服务器收到的请求，主要用于测试或诊断。 "),
	DELETE("请求服务器删除 Request-URI 所标识的资源。");

	private String desc;
	private HttpMethodType(String desc) {
		this.desc=desc;
	}

	public String code() {
		return this.name();
	}
	
	public String text() {
		return this.name();
	}

	@Override
	public String description() {
		return this.desc;
	}
}
