package org.github.foxnic.web.domain.system.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.system.CodeExampleMulitPk;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-02-11 13:02:52
 * @sign B796FD90DD8B8105428CD5B50F78EFCD
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CodeExampleMulitPkMeta {
	
	/**
	 * 主键1 , 类型: java.lang.Long
	*/
	public static final String NID="nid";
	
	/**
	 * 主键1 , 类型: java.lang.Long
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleMulitPk,java.lang.Long> NID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleMulitPk.class ,NID, java.lang.Long.class, "主键1", "主键1", java.lang.Long.class, null);
	
	/**
	 * 主键2 , 类型: java.util.Date
	*/
	public static final String DAY="day";
	
	/**
	 * 主键2 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleMulitPk,java.util.Date> DAY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleMulitPk.class ,DAY, java.util.Date.class, "主键2", "主键2", java.util.Date.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleMulitPk,java.lang.String> CONTENT_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleMulitPk.class ,CONTENT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ NID , DAY , CONTENT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.CodeExampleMulitPk {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键1
		 * @param nid 主键1
		 * @return 当前对象
		*/
		public CodeExampleMulitPk setNid(Long nid) {
			super.change(NID,super.getNid(),nid);
			super.setNid(nid);
			return this;
		}
		
		/**
		 * 设置 主键2
		 * @param day 主键2
		 * @return 当前对象
		*/
		public CodeExampleMulitPk setDay(Date day) {
			super.change(DAY,super.getDay(),day);
			super.setDay(day);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param content 内容
		 * @return 当前对象
		*/
		public CodeExampleMulitPk setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
	}
}