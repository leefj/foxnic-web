package org.github.foxnic.web.domain.bpm;

import io.swagger.annotations.ApiModel;
import java.util.Map;
import java.util.HashMap;
import javax.persistence.Transient;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;
import org.github.foxnic.web.domain.bpm.meta.ProcessFetchBackVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 流程撤回参数
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-05-16 16:41:04
 * @sign 35419B72D668F904DEF61EFEDEC3491C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel()
public class ProcessFetchBackVO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 流程实例ID：流程实例ID
	*/
	private String processInstanceId;
	
	/**
	 * 撤回原因：撤回原因
	*/
	private String reason;
	
	/**
	 * 流程参数：流程参数
	*/
	private Map<String,Object> variables;
	
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
	public ProcessFetchBackVO setProcessInstanceId(String processInstanceId) {
		this.processInstanceId=processInstanceId;
		return this;
	}
	
	/**
	 * 获得 撤回原因<br>
	 * 撤回原因
	 * @return 撤回原因
	*/
	public String getReason() {
		return reason;
	}
	
	/**
	 * 设置 撤回原因
	 * @param reason 撤回原因
	 * @return 当前对象
	*/
	public ProcessFetchBackVO setReason(String reason) {
		this.reason=reason;
		return this;
	}
	
	/**
	 * 获得 流程参数<br>
	 * 流程参数
	 * @return 流程参数
	*/
	public Map<String,Object> getVariables() {
		return variables;
	}
	
	/**
	 * 设置 流程参数
	 * @param variables 流程参数
	 * @return 当前对象
	*/
	public ProcessFetchBackVO setVariables(Map<String,Object> variables) {
		this.variables=variables;
		return this;
	}
	
	/**
	 * 添加 流程参数
	 * @param key 键
	 * @param variable 流程参数
	 * @return 当前对象
	*/
	public ProcessFetchBackVO putVariable(String key,Object variable) {
		if(this.variables==null) this.variables=new HashMap<>();
		this.variables.put(key ,variable);
		return this;
	}

	/**
	 * 创建一个 ProcessFetchBackVO，等同于 new
	 * @return ProcessFetchBackVO 对象
	*/
	@Transient
	public static ProcessFetchBackVO create() {
		return new ProcessFetchBackVO();
	}

	/**
	 * 将 Map 转换成 ProcessFetchBackVO
	 * @param processInstanceMap 包含实体信息的 Map 对象
	 * @return ProcessFetchBackVO , 转换好的的 ProcessInstance 对象
	*/
	@Transient
	public static ProcessFetchBackVO createFrom(Map<String,Object> processInstanceMap) {
		if(processInstanceMap==null) return null;
		ProcessFetchBackVO po = new ProcessFetchBackVO();
		BeanUtil.copy(processInstanceMap,po);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ProcessFetchBackVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProcessFetchBackVO , 转换好的的 ProcessInstance 对象
	*/
	@Transient
	public static ProcessFetchBackVO createFrom(Object pojo) {
		if(pojo==null) return null;
		ProcessFetchBackVO po = new ProcessFetchBackVO();
		BeanUtil.copy(pojo,po,true);
		return po;
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ProcessFetchBackVO duplicate(boolean all) {
		ProcessFetchBackVO inst = new ProcessFetchBackVO();
		// others
			inst.setProcessInstanceId(this.getProcessInstanceId());
			inst.setReason(this.getReason());
			inst.setVariables(this.getVariables());
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ProcessFetchBackVO clone() {
		return BeanUtil.clone(this,false);
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ProcessFetchBackVO clone(boolean deep) {
		return BeanUtil.clone(this,deep);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProcessFetchBackVO , 转换好的 PoJo 对象
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
			this.setProcessInstanceId(DataParser.parse(String.class, map.get(ProcessFetchBackVOMeta.PROCESS_INSTANCE_ID)));
			this.setReason(DataParser.parse(String.class, map.get(ProcessFetchBackVOMeta.REASON)));
			return true;
		} else {
			try {
				// others
				this.setProcessInstanceId( (String)map.get(ProcessFetchBackVOMeta.PROCESS_INSTANCE_ID));
				this.setReason( (String)map.get(ProcessFetchBackVOMeta.REASON));
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