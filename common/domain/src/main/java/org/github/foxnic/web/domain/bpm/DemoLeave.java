package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_DEMO_LEAVE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 请假流程示例
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-06 14:20:12
 * @sign BC4BF98F9EBF60B0B19091EF153B130C
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