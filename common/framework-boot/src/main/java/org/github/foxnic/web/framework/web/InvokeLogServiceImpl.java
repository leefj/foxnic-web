package org.github.foxnic.web.framework.web;

import com.alibaba.fastjson.JSON;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.code.CodeBuilder;
import com.github.foxnic.commons.concurrent.task.SimpleTaskManager;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.network.Machine;
import com.github.foxnic.commons.project.maven.MavenProject;
import com.github.foxnic.commons.reflect.JavassistUtil;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.dao.sql.SQLBuilder;
import com.github.foxnic.springboot.application.aware.ApplicationReadyEvent;
import com.github.foxnic.springboot.mvc.InvokeLogService;
import com.github.foxnic.springboot.mvc.RequestParameter;
import com.github.foxnic.springboot.mvc.ResourceMatchService;
import com.github.foxnic.springboot.spring.SpringUtil;
import com.github.foxnic.springboot.web.WebContext;
import io.swagger.annotations.ApiOperation;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.apache.commons.compress.utils.Sets;
import org.github.foxnic.web.constants.enums.system.ResourceType;
import org.github.foxnic.web.domain.oauth.Resourze;
import org.github.foxnic.web.domain.system.InvokeLog;
import org.github.foxnic.web.proxy.storage.FileServiceProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.nio.file.FileSystems;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class InvokeLogServiceImpl implements InvokeLogService , ApplicationReadyEvent {

	private static final ThreadLocal<Long> logId=new ThreadLocal<Long>();

	private static final List<String> IGNORED_URIS= Arrays.asList(FileServiceProxy.DOWNLOAD,FileServiceProxy.IMAGE);

	@Value("${foxnic.api.log-enable}")
	private Boolean logEnable=true;

	@Autowired
	private DAO dao=null;


	@Autowired
	private ResourceMatchService resourceMatchService;

	private Map<Long, InvokeLog> cache=new ConcurrentHashMap<>();


	private void logRequest(Method method, String uri, String url, String body) {
		if(!logEnable) return;
		int line= JavassistUtil.getLineNumber(method);
		CodeBuilder cb = new CodeBuilder();
		cb.ln("┏━━━━━ REQUEST [ " + url + " ] ━━━━━ ");
		cb.ln("┣ URI：" +uri);
		cb.ln("┣ PARAMETER：" + body);
		if(method!=null) {
			cb.ln("┣ METHOD：" + " " + method.getDeclaringClass().getName() + "." + method.getName() + "(" + method.getDeclaringClass().getSimpleName() + ".java:" + line + ")");
		}
		//cb.ln("┣ LOCATION：" + " com.chinayie.web.controller.payment.CapitalAccountController.findTransRecords(CapitalAccountController.java:76)");
		cb.ln("┗━━━━━ REQUEST [ " + url + " ] ━━━━━ ");
		//
		Logger.info("request info:\n"+cb.toString());
	}

	@Override
	public void start(RequestParameter request, Method method, String uri, String url, String body) {
		start(null,request,method,uri,url,body);
	}

	public void start(String subject, RequestParameter request, Method method, String uri, String url, String body) {
		if(IGNORED_URIS.contains(uri)) return;
		List<Resourze> res = resourceMatchService.getMatched(RequestParameter.getRequest());
		HttpServletRequest httpServletRequest=RequestParameter.getRequest();
		if(httpServletRequest==null) return;
		// subject 没有；资源也没有，静态资源
		if(StringUtil.isBlank (subject) && (res==null || res.isEmpty() ) && WebContext.isStaticResource(httpServletRequest)) {
			return;
		}

		logRequest(method,uri,url,body);
		Long id= IDGenerator.getSnowflakeId();
		logId.set(id);
		InvokeLog invokeLog=InvokeLog.create();
		invokeLog.setId(id);
		invokeLog.setStep(0);
		invokeLog.setApplication(SpringUtil.getApplicationName());
		invokeLog.setHostName(Machine.getHostName());
		if(res!=null && !res.isEmpty()) {
			if(StringUtil.hasContent(subject)) {
				invokeLog.setSubject(subject);
			} else {
				invokeLog.setSubject(res.get(0).getName());
			}
			invokeLog.setTypeEnum(res.get(0).getTypeEnum());
		} else {
			if(method!=null) {
				ApiOperation operation=method.getAnnotation(ApiOperation.class);
				if(operation!=null) {
					invokeLog.setSubject(operation.value());
				}
			}
			invokeLog.setTypeEnum(ResourceType.other);
		}
		invokeLog.setUri(uri);
		invokeLog.setUserAgent(request.getUserAgent().toString());

		invokeLog.setClientIp(httpServletRequest.getRemoteHost());
		invokeLog.setHttpMethod(httpServletRequest.getMethod());

		//invokeLog.setToken(request.getHeader().get("Authorization"));

		if(RequestParameter.getSession(false)!=null) {
			invokeLog.setSessionId(RequestParameter.getSession(false).getId());
		}
		SessionUser user = SessionUser.getCurrent();
		if(user!=null) {
			invokeLog.setUserId(user.getUserId());
			invokeLog.setUserName(user.getRealName());
		}
		invokeLog.setTid(request.getTraceId());
		if(StringUtil.isBlank(body)) {
			body=request.getQueryString();
		}
		//invokeLog.setParameter(body);
		invokeLog.setStartTime(new Timestamp(System.currentTimeMillis()));
		cache.put(id,invokeLog);

	}

	public void exception(Throwable error) {
		try {
			if(logId.get()==null) return;
			InvokeLog invokeLog=cache.get(logId.get());
			if(invokeLog==null) return;
			invokeLog.setEndTime(new Timestamp(System.currentTimeMillis()));
			invokeLog.setException(StringUtil.toString(error));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void response(Object response) {
		try {
			if(logId.get()==null) return;
			InvokeLog invokeLog=cache.get(logId.get());
			if(invokeLog==null) return;
			invokeLog.setEndTime(new Timestamp(System.currentTimeMillis()));
			if(response!=null) {
				// invokeLog.setResponse(JSON.toJSONString(response));
			} else {
				invokeLog.setResponse("<NULL>");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	private void writeToDB() {

		List<InvokeLog> inserts=new ArrayList<>();
		List<InvokeLog> updates=new ArrayList<>();
		List<InvokeLog> removes=new ArrayList<>();
		for (InvokeLog value : cache.values()) {
			if(value.getStep()==0) {
				inserts.add(value);
			} else if(value.getStep()==1) {
				updates.add(value);
			} else {
				removes.add(value);
			}
		}

		boolean suc=this.dao.insertEntities(inserts);
		if(suc) {
			for (InvokeLog invokeLog : inserts) {
				invokeLog.setStep(1);
			}
		}
		suc=this.dao.updateEntities(updates, SaveMode.DIRTY_FIELDS);
		if(suc) {
			for (InvokeLog invokeLog : updates) {
				cache.remove(invokeLog.getId());
			}
		}
		for (InvokeLog invokeLog : removes) {
			cache.remove(invokeLog.getId());
		}
	}


	@Override
	public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
		SimpleTaskManager.getDefault().doIntervalTask(new Runnable() {
			@Override
			public void run() {
				writeToDB();
			}

		},3000);
	}


}
