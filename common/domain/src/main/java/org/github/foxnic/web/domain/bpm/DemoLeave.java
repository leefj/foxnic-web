package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_DEMO_LEAVE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 请假流程示例
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-06-22 17:21:42
 * @sign 43E2D8332620B955587E290952968272
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_demo_leave")
public class DemoLeave extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_DEMO_LEAVE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 请假类型：请假类型
	*/
	@ApiModelProperty(required = false,value="请假类型" , notes = "请假类型")
	private String type;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间")
	private Date beginTime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间")
	private Date endTime;
	
	/**
	 * 请假事由：请假事由
	*/
	@ApiModelProperty(required = false,value="请假事由" , notes = "请假事由")
	private String reason;
	
	/**
	 * 申请人：员工ID
	*/
	@ApiModelProperty(required = false,value="申请人" , notes = "员工ID")
	private String applicantId;
	
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
	 * 将 Map 转换成 DemoLeave
	 * @param demoLeaveMap 包含实体信息的 Map 对象
	 * @return DemoLeave , 转换好的的 DemoLeave 对象
	*/
	@Transient
	public static DemoLeave createFrom(Map<String,Object> demoLeaveMap) {
		if(demoLeaveMap==null) return null;
		DemoLeave po = EntityContext.create(DemoLeave.class, demoLeaveMap);
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
		DemoLeave po = EntityContext.create(DemoLeave.class,pojo);
		return po;
	}

	/**
	 * 创建一个 DemoLeave，等同于 new
	 * @return DemoLeave 对象
	*/
	@Transient
	public static DemoLeave create() {
		return EntityContext.create(DemoLeave.class);
	}
}