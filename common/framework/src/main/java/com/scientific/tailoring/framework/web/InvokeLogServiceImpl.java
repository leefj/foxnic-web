package com.scientific.tailoring.framework.web;

import java.sql.Timestamp;

import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_INVOKE_LOG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.mvc.InvokeLogService;
import com.github.foxnic.springboot.mvc.RequestParameter;

@Service
public class InvokeLogServiceImpl implements InvokeLogService {

	private static final ThreadLocal<Long> logId=new ThreadLocal<Long>();
	
	@Autowired
	private DAO dao=null;
	
//	@Autowired
//	private ISecurityService securityService;
	
	public void start(RequestParameter request) {
//		Insert insert=new Insert(SYS_INVOKE_LOG.$NAME);
//		insert
//		.set(SYS_INVOKE_LOG.HOST_NAME, Machine.getHostName())
//		.set(SYS_INVOKE_LOG.URI,request.getRequest().getRequestURI())
//		.set(SYS_INVOKE_LOG.CLIENT_IP, request.getRequest().getRemoteHost())
//		.set(SYS_INVOKE_LOG.START_TIME,new Timestamp(System.currentTimeMillis()))
//		.set(SYS_INVOKE_LOG.USER_AGENT,request.getRequest().getHeader("User-Agent"))
//		.set(SYS_INVOKE_LOG.PARAMETER, request.getRequestBody());
//		.set(SYS_INVOKE_LOG.TOKEN, securityService.getToken());
		
//		if(securityService.getSessionSubject()!=null && securityService.getSessionSubject().getUser()!=null) {
//			insert
//			.set(SYS_INVOKE_LOG.USER_ID, securityService.getSessionSubject().getUser().getId())
//			.set(SYS_INVOKE_LOG.USER_NAME,securityService.getSessionSubject().getUser().getName());
//		}
//		boolean isPrintSQL=dao.isPrintSQL();
//		dao.setPrintThreadSQL(false);
//		Long id=dao.insertAndReturnKey(insert);
//		dao.setPrintThreadSQL(isPrintSQL);
//		logId.set(id);
	}
	
	public void exception(Throwable error) {
		boolean isPrintSQL=dao.isPrintSQL();
		dao.setPrintThreadSQL(false);
		dao.execute("update "+SYS_INVOKE_LOG.$NAME+" set "+SYS_INVOKE_LOG.EXCEPTION+"=?,end_time=? where id=?",StringUtil.toString(error),new Timestamp(System.currentTimeMillis()),logId.get());
		dao.setPrintThreadSQL(isPrintSQL);
	}
	
	public void response(Object response) {
		response=JSON.toJSONString(response);
		boolean isPrintSQL=dao.isPrintSQL();
		dao.setPrintThreadSQL(false);
		dao.execute("update "+SYS_INVOKE_LOG.$NAME+" set "+SYS_INVOKE_LOG.RESPONSE+"=?,end_time=? where id=?",response,new Timestamp(System.currentTimeMillis()),logId.get());
		dao.setPrintThreadSQL(isPrintSQL);
	}
	
}
