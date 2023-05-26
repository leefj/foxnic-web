package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.DemoBusinessCase;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import java.util.List;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-05-26 15:01:37
 * @sign C13DA9E088B96752C98AC55E9564FE7C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DemoBusinessCaseMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoBusinessCase,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoBusinessCase.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 案件情况 , 类型: java.lang.String
	*/
	public static final String FACT_NOTE="factNote";
	
	/**
	 * 案件情况 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoBusinessCase,java.lang.String> FACT_NOTE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoBusinessCase.class ,FACT_NOTE, java.lang.String.class, "案件情况", "案件情况", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoBusinessCase,java.lang.String> STATUS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoBusinessCase.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 已交底 , 类型: java.lang.Integer
	*/
	public static final String IS_GOT_BASE="isGotBase";
	
	/**
	 * 已交底 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoBusinessCase,java.lang.Integer> IS_GOT_BASE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoBusinessCase.class ,IS_GOT_BASE, java.lang.Integer.class, "已交底", "已交底", java.lang.Integer.class, null);
	
	/**
	 * 历史流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String HISTORIC_PROCESS_LIST="historicProcessList";
	
	/**
	 * 历史流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoBusinessCase,org.github.foxnic.web.domain.bpm.ProcessInstance> HISTORIC_PROCESS_LIST_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoBusinessCase.class ,HISTORIC_PROCESS_LIST, java.util.List.class, "历史流程清单", "历史流程清单", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 在批的流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String CURRENT_PROCESS_LIST="currentProcessList";
	
	/**
	 * 在批的流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoBusinessCase,org.github.foxnic.web.domain.bpm.ProcessInstance> CURRENT_PROCESS_LIST_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoBusinessCase.class ,CURRENT_PROCESS_LIST, java.util.List.class, "在批的流程清单", "在批的流程清单", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 默认流程 , 优先取在批的流程 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String DEFAULT_PROCESS="defaultProcess";
	
	/**
	 * 默认流程 , 优先取在批的流程 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.DemoBusinessCase,org.github.foxnic.web.domain.bpm.ProcessInstance> DEFAULT_PROCESS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.DemoBusinessCase.class ,DEFAULT_PROCESS, org.github.foxnic.web.domain.bpm.ProcessInstance.class, "默认流程", "优先取在批的流程", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , FACT_NOTE , STATUS , IS_GOT_BASE , HISTORIC_PROCESS_LIST , CURRENT_PROCESS_LIST , DEFAULT_PROCESS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.DemoBusinessCase {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public DemoBusinessCase setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 案件情况
		 * @param factNote 案件情况
		 * @return 当前对象
		*/
		public DemoBusinessCase setFactNote(String factNote) {
			super.change(FACT_NOTE,super.getFactNote(),factNote);
			super.setFactNote(factNote);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public DemoBusinessCase setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 已交底
		 * @param isGotBase 已交底
		 * @return 当前对象
		*/
		public DemoBusinessCase setIsGotBase(Integer isGotBase) {
			super.change(IS_GOT_BASE,super.getIsGotBase(),isGotBase);
			super.setIsGotBase(isGotBase);
			return this;
		}
		
		/**
		 * 设置 历史流程清单
		 * @param historicProcessList 历史流程清单
		 * @return 当前对象
		*/
		public DemoBusinessCase setHistoricProcessList(List<ProcessInstance> historicProcessList) {
			super.change(HISTORIC_PROCESS_LIST,super.getHistoricProcessList(),historicProcessList);
			super.setHistoricProcessList(historicProcessList);
			return this;
		}
		
		/**
		 * 设置 在批的流程清单
		 * @param currentProcessList 在批的流程清单
		 * @return 当前对象
		*/
		public DemoBusinessCase setCurrentProcessList(List<ProcessInstance> currentProcessList) {
			super.change(CURRENT_PROCESS_LIST,super.getCurrentProcessList(),currentProcessList);
			super.setCurrentProcessList(currentProcessList);
			return this;
		}
		
		/**
		 * 设置 默认流程
		 * @param defaultProcess 默认流程
		 * @return 当前对象
		*/
		public DemoBusinessCase setDefaultProcess(ProcessInstance defaultProcess) {
			super.change(DEFAULT_PROCESS,super.getDefaultProcess(),defaultProcess);
			super.setDefaultProcess(defaultProcess);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public DemoBusinessCase clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public DemoBusinessCase duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setFactNote(this.getFactNote());
			inst.setId(this.getId());
			inst.setIsGotBase(this.getIsGotBase());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setHistoricProcessList(this.getHistoricProcessList());
				inst.setCurrentProcessList(this.getCurrentProcessList());
				inst.setDefaultProcess(this.getDefaultProcess());
			}
			inst.clearModifies();
			return inst;
		}

	}
}