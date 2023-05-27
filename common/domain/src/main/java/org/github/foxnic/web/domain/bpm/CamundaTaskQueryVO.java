package org.github.foxnic.web.domain.bpm;

import io.swagger.annotations.ApiModel;
import javax.persistence.Transient;
import com.github.foxnic.commons.bean.BeanUtil;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;
import org.github.foxnic.web.domain.bpm.meta.CamundaTaskQueryVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 任务查询参数
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-05-28 06:40:58
 * @sign EC59EB2536FBEF14E94455AFB8D5F356
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel()
public class CamundaTaskQueryVO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 流程实例ID：流程实例ID
	*/
	private String processInstanceId;
	
	/**
	 * 委托人、审批人账户ID：委托人、审批人账户
	*/
	private String assigneeUserId;
	
	/**
	 * 分页大小：分页大小
	*/
	private Integer pageSize;
	
	/**
	 * 页码：页码
	*/
	private Integer pageIndex;
	
	/**
	 * 获得 流程实例ID<br>
	 * 流程实例ID
	 * @return 流程实例ID
	*/
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	
	/**
	 * 设置 流程实例ID
	 * @param processInstanceId 流程实例ID
	 * @return 当前对象
	*/
	public CamundaTaskQueryVO setProcessInstanceId(String processInstanceId) {
		this.processInstanceId=processInstanceId;
		return this;
	}
	
	/**
	 * 获得 委托人、审批人账户ID<br>
	 * 委托人、审批人账户
	 * @return 委托人、审批人账户ID
	*/
	public String getAssigneeUserId() {
		return assigneeUserId;
	}
	
	/**
	 * 设置 委托人、审批人账户ID
	 * @param assigneeUserId 委托人、审批人账户ID
	 * @return 当前对象
	*/
	public CamundaTaskQueryVO setAssigneeUserId(String assigneeUserId) {
		this.assigneeUserId=assigneeUserId;
		return this;
	}
	
	/**
	 * 获得 分页大小<br>
	 * 分页大小
	 * @return 分页大小
	*/
	public Integer getPageSize() {
		return pageSize;
	}
	
	/**
	 * 设置 分页大小
	 * @param pageSize 分页大小
	 * @return 当前对象
	*/
	public CamundaTaskQueryVO setPageSize(Integer pageSize) {
		this.pageSize=pageSize;
		return this;
	}
	
	/**
	 * 获得 页码<br>
	 * 页码
	 * @return 页码
	*/
	public Integer getPageIndex() {
		return pageIndex;
	}
	
	/**
	 * 设置 页码
	 * @param pageIndex 页码
	 * @return 当前对象
	*/
	public CamundaTaskQueryVO setPageIndex(Integer pageIndex) {
		this.pageIndex=pageIndex;
		return this;
	}

	/**
	 * 创建一个 CamundaTaskQueryVO，等同于 new
	 * @return CamundaTaskQueryVO 对象
	*/
	@Transient
	public static CamundaTaskQueryVO create() {
		return new CamundaTaskQueryVO();
	}

	/**
	 * 将 Map 转换成 CamundaTaskQueryVO
	 * @param taskMap 包含实体信息的 Map 对象
	 * @return CamundaTaskQueryVO , 转换好的的 Task 对象
	*/
	@Transient
	public static CamundaTaskQueryVO createFrom(Map<String,Object> taskMap) {
		if(taskMap==null) return null;
		CamundaTaskQueryVO po = new CamundaTaskQueryVO();
		BeanUtil.copy(taskMap,po);
		return po;
	}

	/**
	 * 将 Pojo 转换成 CamundaTaskQueryVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CamundaTaskQueryVO , 转换好的的 Task 对象
	*/
	@Transient
	public static CamundaTaskQueryVO createFrom(Object pojo) {
		if(pojo==null) return null;
		CamundaTaskQueryVO po = new CamundaTaskQueryVO();
		BeanUtil.copy(pojo,po,true);
		return po;
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CamundaTaskQueryVO duplicate(boolean all) {
		CamundaTaskQueryVO inst = new CamundaTaskQueryVO();
		// others
			inst.setProcessInstanceId(this.getProcessInstanceId());
			inst.setAssigneeUserId(this.getAssigneeUserId());
			inst.setPageIndex(this.getPageIndex());
			inst.setPageSize(this.getPageSize());
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CamundaTaskQueryVO clone() {
		return BeanUtil.clone(this,false);
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CamundaTaskQueryVO clone(boolean deep) {
		return BeanUtil.clone(this,deep);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CamundaTaskQueryVO , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)EntityContext.create((Class<? extends Entity>) pojoType,this);
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
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			// others
			this.setProcessInstanceId(DataParser.parse(String.class, map.get(CamundaTaskQueryVOMeta.PROCESS_INSTANCE_ID)));
			this.setAssigneeUserId(DataParser.parse(String.class, map.get(CamundaTaskQueryVOMeta.ASSIGNEE_USER_ID)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(CamundaTaskQueryVOMeta.PAGE_INDEX)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(CamundaTaskQueryVOMeta.PAGE_SIZE)));
			return true;
		} else {
			try {
				// others
				this.setProcessInstanceId( (String)map.get(CamundaTaskQueryVOMeta.PROCESS_INSTANCE_ID));
				this.setAssigneeUserId( (String)map.get(CamundaTaskQueryVOMeta.ASSIGNEE_USER_ID));
				this.setPageIndex( (Integer)map.get(CamundaTaskQueryVOMeta.PAGE_INDEX));
				this.setPageSize( (Integer)map.get(CamundaTaskQueryVOMeta.PAGE_SIZE));
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
			return true;
		} else {
			try {
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}