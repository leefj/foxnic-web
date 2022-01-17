package org.github.foxnic.web.framework.web;

import com.github.foxnic.commons.code.CodeBuilder;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.project.maven.MavenProject;
import com.github.foxnic.commons.reflect.ReflectUtil;
import com.github.foxnic.springboot.mvc.InvokeLogService;
import com.github.foxnic.springboot.mvc.RequestParameter;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
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
		int line=getLineNumber(method,null);
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


	private static ClassPool clsPool=null;

	/**
	 * 获得代码行号
	 * */
	private static int getLineNumber(Method m, MavenProject mp) {

		if(clsPool==null) {
			clsPool = ClassPool.getDefault();
		}
		CtClass cc = null;
		try {
			cc = clsPool.get(m.getDeclaringClass().getName());
			CtClass[] pTypes=new CtClass[m.getParameterTypes().length];
			for (int i = 0; i < pTypes.length; i++) {
				pTypes[i]=clsPool.get(m.getParameterTypes()[i].getName());
			}
			CtMethod methodX = cc.getDeclaredMethod(m.getName(), pTypes);
			return methodX.getMethodInfo().getLineNumber(0);
		} catch (Exception e) {
			Class type= ReflectUtil.forName(m.getDeclaringClass().getName());
			File file=mp.getSourceFile(type);
			try {
//				return  getLineNumber(m,file);
				return 0;
			} catch (Exception ex) {
				return 0;
			}
		}
	}

//	private  int getLineNumber(Method m,File file) throws Exception {
//		JavaParser javaParser=new JavaParser();
//
//		ParseResult<CompilationUnit> result = javaParser.parse(file);
//		CompilationUnit compilationUnit=result.getResult().get();
//
//		List<MethodDeclaration> ms=new ArrayList<>();
//		final Variable variable=new Variable(null,1000);
//		compilationUnit.findAll(MethodDeclaration.class).forEach(ae -> {
//			if(!m.getName().equals(ae.getName().getIdentifier())) return;
//			if(!m.getReturnType().getSimpleName().equals(ae.getType().asString())) return;
//			NodeList<Parameter> ps= ae.getParameters();
//			if(ps.size()!=m.getParameterCount()) return;
//			for (int i = 0; i < ps.size(); i++) {
//				java.lang.reflect.Parameter mp=m.getParameters()[i];
//				if(!ps.get(i).getType().asString().equals(mp.getType().getSimpleName())) {
//					return;
//				}
//			}
//			variable.setValue(ae);
//		});
//		MethodDeclaration methodDeclaration=(MethodDeclaration)variable.getValue();
//		return methodDeclaration.getRange().get().begin.line;
//	}

}
