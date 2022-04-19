package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.DemoLeave;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-04-19 11:03:26
 * @sign 26B2D791DC1C9321B5C9D60C2C911689
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DemoLeaveMeta {
	
	/**
	 * 主键 , 类型: java.lang.Integer
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeave,java.lang.Integer> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeave.class ,ID, java.lang.Integer.class, "主键", "主键", java.lang.Integer.class, null);
	
	/**
	 * 请假类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 请假类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeave,java.lang.String> TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeave.class ,TYPE, java.lang.String.class, "请假类型", "请假类型", java.lang.String.class, null);
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final String BEGIN_TIME="beginTime";
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeave,java.util.Date> BEGIN_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeave.class ,BEGIN_TIME, java.util.Date.class, "开始时间", "开始时间", java.util.Date.class, null);
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final String END_TIME="endTime";
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeave,java.util.Date> END_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeave.class ,END_TIME, java.util.Date.class, "结束时间", "结束时间", java.util.Date.class, null);
	
	/**
	 * 请假原因 , 类型: java.lang.String
	*/
	public static final String REASON="reason";
	
	/**
	 * 请假原因 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeave,java.lang.String> REASON_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeave.class ,REASON, java.lang.String.class, "请假原因", "请假原因", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TYPE , BEGIN_TIME , END_TIME , REASON };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.DemoLeave {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public DemoLeave setId(Integer id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 请假类型
		 * @param type 请假类型
		 * @return 当前对象
		*/
		public DemoLeave setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 开始时间
		 * @param beginTime 开始时间
		 * @return 当前对象
		*/
		public DemoLeave setBeginTime(Date beginTime) {
			super.change(BEGIN_TIME,super.getBeginTime(),beginTime);
			super.setBeginTime(beginTime);
			return this;
		}
		
		/**
		 * 设置 结束时间
		 * @param endTime 结束时间
		 * @return 当前对象
		*/
		public DemoLeave setEndTime(Date endTime) {
			super.change(END_TIME,super.getEndTime(),endTime);
			super.setEndTime(endTime);
			return this;
		}
		
		/**
		 * 设置 请假原因
		 * @param reason 请假原因
		 * @return 当前对象
		*/
		public DemoLeave setReason(String reason) {
			super.change(REASON,super.getReason(),reason);
			super.setReason(reason);
			return this;
		}
	}
}