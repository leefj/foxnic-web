package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.DemoLeave;
import java.util.Date;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import java.util.List;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-06-22 17:21:42
 * @sign 43E2D8332620B955587E290952968272
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DemoLeaveMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeave,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeave.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
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
	 * 请假事由 , 类型: java.lang.String
	*/
	public static final String REASON="reason";
	
	/**
	 * 请假事由 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeave,java.lang.String> REASON_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeave.class ,REASON, java.lang.String.class, "请假事由", "请假事由", java.lang.String.class, null);
	
	/**
	 * 申请人 , 员工ID , 类型: java.lang.String
	*/
	public static final String APPLICANT_ID="applicantId";
	
	/**
	 * 申请人 , 员工ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeave,java.lang.String> APPLICANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeave.class ,APPLICANT_ID, java.lang.String.class, "申请人", "员工ID", java.lang.String.class, null);
	
	/**
	 * 历史流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String HISTORIC_PROCESS_LIST="historicProcessList";
	
	/**
	 * 历史流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeave,org.github.foxnic.web.domain.bpm.ProcessInstance> HISTORIC_PROCESS_LIST_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeave.class ,HISTORIC_PROCESS_LIST, java.util.List.class, "历史流程清单", "历史流程清单", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 在批的流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String CURRENT_PROCESS_LIST="currentProcessList";
	
	/**
	 * 在批的流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoLeave,org.github.foxnic.web.domain.bpm.ProcessInstance> CURRENT_PROCESS_LIST_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoLeave.class ,CURRENT_PROCESS_LIST, java.util.List.class, "在批的流程清单", "在批的流程清单", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TYPE , BEGIN_TIME , END_TIME , REASON , APPLICANT_ID , HISTORIC_PROCESS_LIST , CURRENT_PROCESS_LIST };
	
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
		public DemoLeave setId(String id) {
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
		 * 设置 请假事由
		 * @param reason 请假事由
		 * @return 当前对象
		*/
		public DemoLeave setReason(String reason) {
			super.change(REASON,super.getReason(),reason);
			super.setReason(reason);
			return this;
		}
		
		/**
		 * 设置 申请人
		 * @param applicantId 申请人
		 * @return 当前对象
		*/
		public DemoLeave setApplicantId(String applicantId) {
			super.change(APPLICANT_ID,super.getApplicantId(),applicantId);
			super.setApplicantId(applicantId);
			return this;
		}
		
		/**
		 * 设置 历史流程清单
		 * @param historicProcessList 历史流程清单
		 * @return 当前对象
		*/
		public DemoLeave setHistoricProcessList(List<ProcessInstance> historicProcessList) {
			super.change(HISTORIC_PROCESS_LIST,super.getHistoricProcessList(),historicProcessList);
			super.setHistoricProcessList(historicProcessList);
			return this;
		}
		
		/**
		 * 设置 在批的流程清单
		 * @param currentProcessList 在批的流程清单
		 * @return 当前对象
		*/
		public DemoLeave setCurrentProcessList(List<ProcessInstance> currentProcessList) {
			super.change(CURRENT_PROCESS_LIST,super.getCurrentProcessList(),currentProcessList);
			super.setCurrentProcessList(currentProcessList);
			return this;
		}
	}
}