package org.github.foxnic.web.framework.web;

import com.github.foxnic.commons.code.CodeBuilder;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.project.maven.MavenProject;
import com.github.foxnic.commons.reflect.JavassistUtil;
import com.github.foxnic.springboot.mvc.InvokeLogService;
import com.github.foxnic.springboot.mvc.RequestParameter;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Service
public class InvokeLogServiceImpl implements InvokeLogService {

	private static final ThreadLocal<Long> logId=new ThreadLocal<Long>();

	@Value("${foxnic.api.log-enable}")
	private Boolean logEnable=true;

//	@Autowired
//	private DAO dao=null;

	@Override
	public void logRequest(Method method,String uri, String url,String body) {
		if(!logEnable) return;
		int line= JavassistUtil.getLineNumber(method);
		CodeBuilder cb = new CodeBuilder();
		cb.ln("┏━━━━━ REQUEST [ " + url + " ] ━━━━━ ");
		cb.ln("┣ URI：" +uri);
		cb.ln("┣ PARAMETER：" + body);
		cb.ln("┣ METHOD：" + " "+method.getDeclaringClass().getName() + "." + method.getName()+"("+method.getDeclaringClass().getSimpleName()+".java:"+line+")");
		//cb.ln("┣ LOCATION：" + " com.chinayie.web.controller.payment.CapitalAccountController.findTransRecords(CapitalAccountController.java:76)");
		cb.ln("┗━━━━━ REQUEST [ " + url + " ] ━━━━━ ");
		//
		Logger.info("request info:\n"+cb.toString());
	}

	public void start(RequestParameter request) {
//		Insert insert=new Insert(SYS_INVOKE_LOG.$NAME);
//		insert
//		.set(SYS_INVOKE_LOG.ID, IDGenerator.getSnowflakeIdString())
//		.set(SYS_INVOKE_LOG.APPLICATION, SpringUtil.getApplicationName())
//		.set(SYS_INVOKE_LOG.HOST_NAME, Machine.getHostName())
//		.set(SYS_INVOKE_LOG.URI,request.getRequest().getRequestURI())
//		.set(SYS_INVOKE_LOG.USER_AGENT,request.getRequest().getHeader("User-Agent"))
//		.set(SYS_INVOKE_LOG.CLIENT_IP, request.getRequest().getRemoteHost())
//		.set(SYS_INVOKE_LOG.START_TIME,new Timestamp(System.currentTimeMillis()))
//		set(SYS_INVOKE_LOG.ID)
//		.set(SYS_INVOKE_LOG.PARAMETER, request.getRequestBody());
//		.set(SYS_INVOKE_LOG.TOKEN, securityService.getToken());
//
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
//		boolean isPrintSQL=dao.isPrintSQL();
//		dao.setPrintThreadSQL(false);
//		dao.execute("update "+SYS_INVOKE_LOG.$NAME+" set "+SYS_INVOKE_LOG.EXCEPTION+"=?,end_time=? where id=?",StringUtil.toString(error),new Timestamp(System.currentTimeMillis()),logId.get());
//		dao.setPrintThreadSQL(isPrintSQL);
	}

	public void response(Object response) {
//		response=JSON.toJSONString(response);
//		boolean isPrintSQL=dao.isPrintSQL();
//		dao.setPrintThreadSQL(false);
//		dao.execute("update "+SYS_INVOKE_LOG.$NAME+" set "+SYS_INVOKE_LOG.RESPONSE+"=?,end_time=? where id=?",response,new Timestamp(System.currentTimeMillis()),logId.get());
//		dao.setPrintThreadSQL(isPrintSQL);
	}






}
