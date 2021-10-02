package org.github.foxnic.web.domain.changes;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.CHS_CHANGE_BILL;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * chs_change_bill
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-02 11:15:23
 * @sign CA8B46E07BA709674E24B11CB4D68C59
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "chs_change_bill")
public class ChangeBill extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =CHS_CHANGE_BILL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 变更定义ID：变更定义ID
	*/
	@ApiModelProperty(required = false,value="变更定义ID" , notes = "变更定义ID")
	private String definitionId;
	
	/**
	 * 变更实例ID：变更实例ID
	*/
	@ApiModelProperty(required = false,value="变更实例ID" , notes = "变更实例ID")
	private String instanceId;
	
	/**
	 * 变更单据ID：变更单据ID
	*/
	@ApiModelProperty(required = false,value="变更单据ID" , notes = "变更单据ID")
	private String billId;
	
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
	public ChangeBill setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 变更定义ID<br>
	 * 变更定义ID
	 * @return 变更定义ID
	*/
	public String getDefinitionId() {
		return definitionId;
	}
	
	/**
	 * 设置 变更定义ID
	 * @param definitionId 变更定义ID
	 * @return 当前对象
	*/
	public ChangeBill setDefinitionId(String definitionId) {
		this.definitionId=definitionId;
		return this;
	}
	
	/**
	 * 获得 变更实例ID<br>
	 * 变更实例ID
	 * @return 变更实例ID
	*/
	public String getInstanceId() {
		return instanceId;
	}
	
	/**
	 * 设置 变更实例ID
	 * @param instanceId 变更实例ID
	 * @return 当前对象
	*/
	public ChangeBill setInstanceId(String instanceId) {
		this.instanceId=instanceId;
		return this;
	}
	
	/**
	 * 获得 变更单据ID<br>
	 * 变更单据ID
	 * @return 变更单据ID
	*/
	public String getBillId() {
		return billId;
	}
	
	/**
	 * 设置 变更单据ID
	 * @param billId 变更单据ID
	 * @return 当前对象
	*/
	public ChangeBill setBillId(String billId) {
		this.billId=billId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ChangeBill , 转换好的 ChangeBill 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ChangeBill , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ChangeBill
	 * @param changeBillMap 包含实体信息的 Map 对象
	 * @return ChangeBill , 转换好的的 ChangeBill 对象
	*/
	@Transient
	public static ChangeBill createFrom(Map<String,Object> changeBillMap) {
		if(changeBillMap==null) return null;
		ChangeBill po = EntityContext.create(ChangeBill.class, changeBillMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ChangeBill
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ChangeBill , 转换好的的 ChangeBill 对象
	*/
	@Transient
	public static ChangeBill createFrom(Object pojo) {
		if(pojo==null) return null;
		ChangeBill po = EntityContext.create(ChangeBill.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ChangeBill，等同于 new
	 * @return ChangeBill 对象
	*/
	@Transient
	public static ChangeBill create() {
		return EntityContext.create(ChangeBill.class);
	}
}