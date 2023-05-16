package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_DEMO_LEAVE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.github.foxnic.web.constants.enums.bpm.DemoStatus;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.bpm.meta.DemoLeaveMeta;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 请假流程示例
 * <p>请假流程示例 , 数据表 bpm_demo_leave 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-05-16 11:38:39
 * @sign 436F0D583935E8FAFFCF1852DD2A2055
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_demo_leave")
@ApiModel(description = "请假流程示例 ; 请假流程示例 , 数据表 bpm_demo_leave 的PO类型")
public class DemoLeave extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_DEMO_LEAVE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "704326903833559040")
	private String id;
	
	/**
	 * 请假类型：请假类型
	*/
	@ApiModelProperty(required = false,value="请假类型" , notes = "请假类型" , example = "L01")
	private String type;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间" , example = "2023-04-28 12:00:00")
	private Date beginTime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间" , example = "2023-04-29 12:00:00")
	private Date endTime;
	
	/**
	 * 请假事由：请假事由
	*/
	@ApiModelProperty(required = false,value="请假事由" , notes = "请假事由" , example = "打架")
	private String reason;
	
	/**
	 * 申请人：员工ID
	*/
	@ApiModelProperty(required = false,value="申请人" , notes = "员工ID")
	private String applicantId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	@Transient
	@EnumFor("status")
	private DemoStatus statusEnum;
	
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
	public DemoLeave setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 请假类型<br>
	 * 请假类型
	 * @return 请假类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 请假类型
	 * @param type 请假类型
	 * @return 当前对象
	*/
	public DemoLeave setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getBeginTime() {
		return beginTime;
	}
	
	/**
	 * 设置 开始时间
	 * @param beginTime 开始时间
	 * @return 当前对象
	*/
	public DemoLeave setBeginTime(Date beginTime) {
		this.beginTime=beginTime;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Date getEndTime() {
		return endTime;
	}
	
	/**
	 * 设置 结束时间
	 * @param endTime 结束时间
	 * @return 当前对象
	*/
	public DemoLeave setEndTime(Date endTime) {
		this.endTime=endTime;
		return this;
	}
	
	/**
	 * 获得 请假事由<br>
	 * 请假事由
	 * @return 请假事由
	*/
	public String getReason() {
		return reason;
	}
	
	/**
	 * 设置 请假事由
	 * @param reason 请假事由
	 * @return 当前对象
	*/
	public DemoLeave setReason(String reason) {
		this.reason=reason;
		return this;
	}
	
	/**
	 * 获得 申请人<br>
	 * 员工ID
	 * @return 申请人
	*/
	public String getApplicantId() {
		return applicantId;
	}
	
	/**
	 * 设置 申请人
	 * @param applicantId 申请人
	 * @return 当前对象
	*/
	public DemoLeave setApplicantId(String applicantId) {
		this.applicantId=applicantId;
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
	 * 获得 状态 的投影属性<br>
	 * 等价于 getStatus 方法，获得对应的枚举类型
	 * @return 状态
	*/
	@Transient
	public DemoStatus getStatusEnum() {
		if(this.statusEnum==null) {
			this.statusEnum = (DemoStatus) EnumUtil.parseByCode(DemoStatus.values(),status);
		}
		return this.statusEnum ;
	}
	
	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	@JsonProperty("status")
	public DemoLeave setStatus(String status) {
		this.status=status;
		this.statusEnum= (DemoStatus) EnumUtil.parseByCode(DemoStatus.values(),status) ;
		if(StringUtil.hasContent(status) && this.statusEnum==null) {
			throw new IllegalArgumentException( status + " is not one of DemoStatus");
		}
		return this;
	}
	
	/**
	 * 设置 状态的投影属性，等同于设置 状态
	 * @param statusEnum 状态
	 * @return 当前对象
	*/
	@Transient
	public DemoLeave setStatusEnum(DemoStatus statusEnum) {
		if(statusEnum==null) {
			this.setStatus(null);
		} else {
			this.setStatus(statusEnum.code());
		}
		this.statusEnum=statusEnum;
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
	public DemoLeave setHistoricProcessList(List<ProcessInstance> historicProcessList) {
		this.historicProcessList=historicProcessList;
		return this;
	}
	
	/**
	 * 添加 历史流程清单
	 * @param historicProcess 历史流程清单
	 * @return 当前对象
	*/
	public DemoLeave addHistoricProcess(ProcessInstance... historicProcess) {
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
	public DemoLeave setCurrentProcessList(List<ProcessInstance> currentProcessList) {
		this.currentProcessList=currentProcessList;
		return this;
	}
	
	/**
	 * 添加 在批的流程清单
	 * @param currentProcess 在批的流程清单
	 * @return 当前对象
	*/
	public DemoLeave addCurrentProcess(ProcessInstance... currentProcess) {
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
	public DemoLeave setDefaultProcess(ProcessInstance defaultProcess) {
		this.defaultProcess=defaultProcess;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DemoLeave , 转换好的 DemoLeave 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DemoLeave , 转换好的 PoJo 对象
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
	public DemoLeave clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DemoLeave duplicate(boolean all) {
		org.github.foxnic.web.domain.bpm.meta.DemoLeaveMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.bpm.meta.DemoLeaveMeta.$$proxy$$();
		inst.setReason(this.getReason());
		inst.setId(this.getId());
		inst.setBeginTime(this.getBeginTime());
		inst.setEndTime(this.getEndTime());
		inst.setType(this.getType());
		inst.setApplicantId(this.getApplicantId());
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
	public DemoLeave clone(boolean deep) {
		return EntityContext.clone(DemoLeave.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DemoLeave
	 * @param demoLeaveMap 包含实体信息的 Map 对象
	 * @return DemoLeave , 转换好的的 DemoLeave 对象
	*/
	@Transient
	public static DemoLeave createFrom(Map<String,Object> demoLeaveMap) {
		if(demoLeaveMap==null) return null;
		DemoLeave po = create();
		EntityContext.copyProperties(po,demoLeaveMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DemoLeave
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DemoLeave , 转换好的的 DemoLeave 对象
	*/
	@Transient
	public static DemoLeave createFrom(Object pojo) {
		if(pojo==null) return null;
		DemoLeave po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DemoLeave，等同于 new
	 * @return DemoLeave 对象
	*/
	@Transient
	public static DemoLeave create() {
		return new org.github.foxnic.web.domain.bpm.meta.DemoLeaveMeta.$$proxy$$();
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
			this.setReason(DataParser.parse(String.class, map.get(DemoLeaveMeta.REASON)));
			this.setId(DataParser.parse(String.class, map.get(DemoLeaveMeta.ID)));
			this.setBeginTime(DataParser.parse(Date.class, map.get(DemoLeaveMeta.BEGIN_TIME)));
			this.setEndTime(DataParser.parse(Date.class, map.get(DemoLeaveMeta.END_TIME)));
			this.setType(DataParser.parse(String.class, map.get(DemoLeaveMeta.TYPE)));
			this.setApplicantId(DataParser.parse(String.class, map.get(DemoLeaveMeta.APPLICANT_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(DemoLeaveMeta.STATUS)));
			// others
			this.setDefaultProcess(DataParser.parse(ProcessInstance.class, map.get(DemoLeaveMeta.DEFAULT_PROCESS)));
			return true;
		} else {
			try {
				this.setReason( (String)map.get(DemoLeaveMeta.REASON));
				this.setId( (String)map.get(DemoLeaveMeta.ID));
				this.setBeginTime( (Date)map.get(DemoLeaveMeta.BEGIN_TIME));
				this.setEndTime( (Date)map.get(DemoLeaveMeta.END_TIME));
				this.setType( (String)map.get(DemoLeaveMeta.TYPE));
				this.setApplicantId( (String)map.get(DemoLeaveMeta.APPLICANT_ID));
				this.setStatus( (String)map.get(DemoLeaveMeta.STATUS));
				// others
				this.setDefaultProcess( (ProcessInstance)map.get(DemoLeaveMeta.DEFAULT_PROCESS));
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
			this.setReason(DataParser.parse(String.class, r.getValue(DemoLeaveMeta.REASON)));
			this.setId(DataParser.parse(String.class, r.getValue(DemoLeaveMeta.ID)));
			this.setBeginTime(DataParser.parse(Date.class, r.getValue(DemoLeaveMeta.BEGIN_TIME)));
			this.setEndTime(DataParser.parse(Date.class, r.getValue(DemoLeaveMeta.END_TIME)));
			this.setType(DataParser.parse(String.class, r.getValue(DemoLeaveMeta.TYPE)));
			this.setApplicantId(DataParser.parse(String.class, r.getValue(DemoLeaveMeta.APPLICANT_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(DemoLeaveMeta.STATUS)));
			return true;
		} else {
			try {
				this.setReason( (String)r.getValue(DemoLeaveMeta.REASON));
				this.setId( (String)r.getValue(DemoLeaveMeta.ID));
				this.setBeginTime( (Date)r.getValue(DemoLeaveMeta.BEGIN_TIME));
				this.setEndTime( (Date)r.getValue(DemoLeaveMeta.END_TIME));
				this.setType( (String)r.getValue(DemoLeaveMeta.TYPE));
				this.setApplicantId( (String)r.getValue(DemoLeaveMeta.APPLICANT_ID));
				this.setStatus( (String)r.getValue(DemoLeaveMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}