package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_PROFILE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * Profile
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-22 09:58:04
 * @sign 51A9C3F19F9FA5B9660014C6F8A281A3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_profile")
public class Profile extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_PROFILE.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 获得 ID<br>
	 * ID
	 * @return ID
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 ID
	 * @param id ID
	 * @return 当前对象
	*/
	public Profile setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public Profile setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 备注
	 * @param notes 备注
	 * @return 当前对象
	*/
	public Profile setNotes(String notes) {
		this.notes=notes;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Profile , 转换好的 Profile 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Profile , 转换好的 PoJo 对象
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
	public Profile clone() {
		return EntityContext.clone(Profile.class,this);
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Profile clone(boolean deep) {
		return EntityContext.clone(Profile.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Profile
	 * @param profileMap 包含实体信息的 Map 对象
	 * @return Profile , 转换好的的 Profile 对象
	*/
	@Transient
	public static Profile createFrom(Map<String,Object> profileMap) {
		if(profileMap==null) return null;
		Profile po = EntityContext.create(Profile.class, profileMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Profile
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Profile , 转换好的的 Profile 对象
	*/
	@Transient
	public static Profile createFrom(Object pojo) {
		if(pojo==null) return null;
		Profile po = EntityContext.create(Profile.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Profile，等同于 new
	 * @return Profile 对象
	*/
	@Transient
	public static Profile create() {
		return EntityContext.create(Profile.class);
	}
}