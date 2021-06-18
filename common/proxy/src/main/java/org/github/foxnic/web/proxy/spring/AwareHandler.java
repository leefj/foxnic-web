package org.github.foxnic.web.proxy.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
public class AwareHandler implements ApplicationContextAware {

	private static ApplicationContext context = null;

	/**
	 *  通过name获取 Bean.
	 * @param name
	 * @return
	 */
	public static Object getBean(String name) {
		return context.getBean(name);
	}

	/**
	 * 通过class获取Bean.
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz) {
		try {
			return context.getBean(clazz);
		} catch (BeansException e) {
			return null;
		}
	}

	/**
	 * 通过name,以及Clazz返回指定的Bean
	 * @param name
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(String name, Class<T> clazz) {
		return context.getBean(name, clazz);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}


	
	

 
}
