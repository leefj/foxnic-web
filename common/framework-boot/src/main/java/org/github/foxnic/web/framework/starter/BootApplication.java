package org.github.foxnic.web.framework.starter;

import com.github.foxnic.commons.code.CodeBuilder;
import com.github.foxnic.commons.environment.Environment;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.springboot.starter.FoxnicApplication;
import org.aspectj.weaver.ast.Test;
import org.github.foxnic.web.framework.FoxnicWebMeta;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;
import java.net.URL;
import java.util.Enumeration;


@ComponentScan(basePackages = {FoxnicWebMeta.FRAMEWORK_PACKAGE,FoxnicWebMeta.PROXY_PACKAGE,FoxnicWebMeta.ERRORS_PACKAGE})
public class BootApplication {

	public static ConfigurableApplicationContext run(Class<?> bootType, String... args) {
		Environment.getEnvironment().init();
		ConfigurableApplicationContext context=new SpringApplication(new Class[] {FoxnicApplication.class,BootApplication.class,bootType}).run(args);
		return context;
    }


	public static void printJar() throws Exception{

		CodeBuilder code=new CodeBuilder();
		ClassLoader classLoader = Test.class.getClassLoader();
		//只能搜索jar包内的字符，比如文件夹org,com，文件名a.xml
		Enumeration<URL> paths  = classLoader.getResources("META-INF");
		int count = 0;
		while (paths.hasMoreElements()){
			String path = paths.nextElement().toString();
			if (path.indexOf("jdk") == -1){
				count++;
				System.out.println(path);
				code.ln(path);
			}
		}
		System.out.println(count);
		FileUtil.writeText(new File("./jar.txt"),code.toString());

	}
}
