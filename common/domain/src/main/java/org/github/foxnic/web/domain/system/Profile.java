package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_PROFILE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.system.meta.ProfileMeta;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * Profile
 * <p>Profile , 数据表 sys_profile 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:38:50
 * @sign 51A9C3F19F9FA5B9660014C6F8A281A3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_profile")
@ApiModel(description = "Profile ; Profile , 数据表 sys_profile 的PO类型")
public class Profile extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_PROFILE.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID" , example = "default")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "默认")
	private String name;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "默认 Profile 请勿删除")
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
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Profile duplicate(boolean all) {
		org.github.foxnic.web.domain.system.meta.ProfileMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.system.meta.ProfileMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setName(this.getName());
		inst.setId(this.getId());
		inst.clearModifies();
		return inst;
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
		Profile po = create();
		EntityContext.copyProperties(po,profileMap);
		po.clearModifies();
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
		Profile po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Profile，等同于 new
	 * @return Profile 对象
	*/
	@Transient
	public static Profile create() {
		return new org.github.foxnic.web.domain.system.meta.ProfileMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(ProfileMeta.NOTES)));
			this.setName(DataParser.parse(String.class, map.get(ProfileMeta.NAME)));
			this.setId(DataParser.parse(String.class, map.get(ProfileMeta.ID)));
			// others
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(ProfileMeta.NOTES));
				this.setName( (String)map.get(ProfileMeta.NAME));
				this.setId( (String)map.get(ProfileMeta.ID));
				// others
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
			this.setNotes(DataParser.parse(String.class, r.getValue(ProfileMeta.NOTES)));
			this.setName(DataParser.parse(String.class, r.getValue(ProfileMeta.NAME)));
			this.setId(DataParser.parse(String.class, r.getValue(ProfileMeta.ID)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(ProfileMeta.NOTES));
				this.setName( (String)r.getValue(ProfileMeta.NAME));
				this.setId( (String)r.getValue(ProfileMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}