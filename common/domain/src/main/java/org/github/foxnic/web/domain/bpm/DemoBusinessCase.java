package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_DEMO_BUSINESS_CASE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.bpm.meta.DemoBusinessCaseMeta;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 商务来案
 * <p>商务来案 , 数据表 bpm_demo_business_case 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-05-24 14:46:54
 * @sign C13DA9E088B96752C98AC55E9564FE7C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_demo_business_case")
@ApiModel(description = "商务来案 ; 商务来案 , 数据表 bpm_demo_business_case 的PO类型")
public class DemoBusinessCase extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_DEMO_BUSINESS_CASE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "711508487120617472")
	private String id;
	
	/**
	 * 案件情况：案件情况
	*/
	@ApiModelProperty(required = false,value="案件情况" , notes = "案件情况" , example = "2342343")
	private String factNote;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "N1 : 商务来案")
	private String status;
	
	/**
	 * 已交底：已交底
	*/
	@ApiModelProperty(required = false,value="已交底" , notes = "已交底" , example = "1")
	private Integer isGotBase;
	
	/**
	 * 历史流程清单：历史流程清单
	*/
	@ApiModelProperty(required = false,value="历史流程清单" , notes = "历史流程清单")
	private List<ProcessInstance> historicProcessList;
	
	/**
	 * 在批的流程清单：在批的流程清单
	*/
	@ApiModelProperty(required = false,value="在批的流程清单" , notes = "在批的流程清单")
	private List<ProcessInstance> currentProcessList;
	
	/**
	 * 默认流程：优先取在批的流程
	*/
	@ApiModelProperty(required = false,value="默认流程" , notes = "优先取在批的流程")
	private ProcessInstance defaultProcess;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public DemoBusinessCase setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 案件情况<br>
	 * 案件情况
	 * @return 案件情况
	*/
	public String getFactNote() {
		return factNote;
	}
	
	/**
	 * 设置 案件情况
	 * @param factNote 案件情况
	 * @return 当前对象
	*/
	public DemoBusinessCase setFactNote(String factNote) {
		this.factNote=factNote;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	public DemoBusinessCase setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 已交底<br>
	 * 已交底
	 * @return 已交底
	*/
	public Integer getIsGotBase() {
		return isGotBase;
	}
	
	/**
	 * 设置 已交底
	 * @param isGotBase 已交底
	 * @return 当前对象
	*/
	public DemoBusinessCase setIsGotBase(Integer isGotBase) {
		this.isGotBase=isGotBase;
		return this;
	}
	
	/**
	 * 获得 历史流程清单<br>
	 * 历史流程清单
	 * @return 历史流程清单
	*/
	public List<ProcessInstance> getHistoricProcessList() {
		return historicProcessList;
	}
	
	/**
	 * 设置 历史流程清单
	 * @param historicProcessList 历史流程清单
	 * @return 当前对象
	*/
	public DemoBusinessCase setHistoricProcessList(List<ProcessInstance> historicProcessList) {
		this.historicProcessList=historicProcessList;
		return this;
	}
	
	/**
	 * 添加 历史流程清单
	 * @param historicProcess 历史流程清单
	 * @return 当前对象
	*/
	public DemoBusinessCase addHistoricProcess(ProcessInstance... historicProcess) {
		if(this.historicProcessList==null) historicProcessList=new ArrayList<>();
		this.historicProcessList.addAll(Arrays.asList(historicProcess));
		return this;
	}
	
	/**
	 * 获得 在批的流程清单<br>
	 * 在批的流程清单
	 * @return 在批的流程清单
	*/
	public List<ProcessInstance> getCurrentProcessList() {
		return currentProcessList;
	}
	
	/**
	 * 设置 在批的流程清单
	 * @param currentProcessList 在批的流程清单
	 * @return 当前对象
	*/
	public DemoBusinessCase setCurrentProcessList(List<ProcessInstance> currentProcessList) {
		this.currentProcessList=currentProcessList;
		return this;
	}
	
	/**
	 * 添加 在批的流程清单
	 * @param currentProcess 在批的流程清单
	 * @return 当前对象
	*/
	public DemoBusinessCase addCurrentProcess(ProcessInstance... currentProcess) {
		if(this.currentProcessList==null) currentProcessList=new ArrayList<>();
		this.currentProcessList.addAll(Arrays.asList(currentProcess));
		return this;
	}
	
	/**
	 * 获得 默认流程<br>
	 * 优先取在批的流程
	 * @return 默认流程
	*/
	public ProcessInstance getDefaultProcess() {
		return defaultProcess;
	}
	
	/**
	 * 设置 默认流程
	 * @param defaultProcess 默认流程
	 * @return 当前对象
	*/
	public DemoBusinessCase setDefaultProcess(ProcessInstance defaultProcess) {
		this.defaultProcess=defaultProcess;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DemoBusinessCase , 转换好的 DemoBusinessCase 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DemoBusinessCase , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
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
		org.github.foxnic.web.domain.bpm.meta.DemoBusinessCaseMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.bpm.meta.DemoBusinessCaseMeta.$$proxy$$();
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

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DemoBusinessCase clone(boolean deep) {
		return EntityContext.clone(DemoBusinessCase.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DemoBusinessCase
	 * @param demoBusinessCaseMap 包含实体信息的 Map 对象
	 * @return DemoBusinessCase , 转换好的的 DemoBusinessCase 对象
	*/
	@Transient
	public static DemoBusinessCase createFrom(Map<String,Object> demoBusinessCaseMap) {
		if(demoBusinessCaseMap==null) return null;
		DemoBusinessCase po = create();
		EntityContext.copyProperties(po,demoBusinessCaseMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DemoBusinessCase
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DemoBusinessCase , 转换好的的 DemoBusinessCase 对象
	*/
	@Transient
	public static DemoBusinessCase createFrom(Object pojo) {
		if(pojo==null) return null;
		DemoBusinessCase po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DemoBusinessCase，等同于 new
	 * @return DemoBusinessCase 对象
	*/
	@Transient
	public static DemoBusinessCase create() {
		return new org.github.foxnic.web.domain.bpm.meta.DemoBusinessCaseMeta.$$proxy$$();
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setFactNote(DataParser.parse(String.class, map.get(DemoBusinessCaseMeta.FACT_NOTE)));
			this.setId(DataParser.parse(String.class, map.get(DemoBusinessCaseMeta.ID)));
			this.setIsGotBase(DataParser.parse(Integer.class, map.get(DemoBusinessCaseMeta.IS_GOT_BASE)));
			this.setStatus(DataParser.parse(String.class, map.get(DemoBusinessCaseMeta.STATUS)));
			// others
			this.setDefaultProcess(DataParser.parse(ProcessInstance.class, map.get(DemoBusinessCaseMeta.DEFAULT_PROCESS)));
			return true;
		} else {
			try {
				this.setFactNote( (String)map.get(DemoBusinessCaseMeta.FACT_NOTE));
				this.setId( (String)map.get(DemoBusinessCaseMeta.ID));
				this.setIsGotBase( (Integer)map.get(DemoBusinessCaseMeta.IS_GOT_BASE));
				this.setStatus( (String)map.get(DemoBusinessCaseMeta.STATUS));
				// others
				this.setDefaultProcess( (ProcessInstance)map.get(DemoBusinessCaseMeta.DEFAULT_PROCESS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setFactNote(DataParser.parse(String.class, r.getValue(DemoBusinessCaseMeta.FACT_NOTE)));
			this.setId(DataParser.parse(String.class, r.getValue(DemoBusinessCaseMeta.ID)));
			this.setIsGotBase(DataParser.parse(Integer.class, r.getValue(DemoBusinessCaseMeta.IS_GOT_BASE)));
			this.setStatus(DataParser.parse(String.class, r.getValue(DemoBusinessCaseMeta.STATUS)));
			return true;
		} else {
			try {
				this.setFactNote( (String)r.getValue(DemoBusinessCaseMeta.FACT_NOTE));
				this.setId( (String)r.getValue(DemoBusinessCaseMeta.ID));
				this.setIsGotBase( (Integer)r.getValue(DemoBusinessCaseMeta.IS_GOT_BASE));
				this.setStatus( (String)r.getValue(DemoBusinessCaseMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}