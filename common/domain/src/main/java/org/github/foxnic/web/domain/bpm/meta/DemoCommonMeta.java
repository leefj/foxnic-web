package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.DemoCommon;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-06-10 16:19:31
 * @sign B5FA5B033F9B62477AC6989F22197570
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DemoCommonMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoCommon,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoCommon.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 标题 , 类型: java.lang.String
	*/
	public static final String SUBJECT="subject";
	
	/**
	 * 标题 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoCommon,java.lang.String> SUBJECT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoCommon.class ,SUBJECT, java.lang.String.class, "标题", "标题", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoCommon,java.lang.String> CONTENT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoCommon.class ,CONTENT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , SUBJECT , CONTENT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.DemoCommon {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public DemoCommon setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 标题
		 * @param subject 标题
		 * @return 当前对象
		*/
		public DemoCommon setSubject(String subject) {
			super.change(SUBJECT,super.getSubject(),subject);
			super.setSubject(subject);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param content 内容
		 * @return 当前对象
		*/
		public DemoCommon setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
	}
}