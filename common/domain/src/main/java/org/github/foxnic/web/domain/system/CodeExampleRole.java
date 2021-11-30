package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_CODE_EXAMPLE_ROLE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 代码示例主表角色关系
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-30 10:30:35
 * @sign 88E4B5119509855DBC4D298F418F2F89
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_code_example_role")
public class CodeExampleRole extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_CODE_EXAMPLE_ROLE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 属主ID：属主ID
	*/
	@ApiModelProperty(required = false,value="属主ID" , notes = "属主ID")
	private String exampleId;
	
	/**
	 * 角色ID：角色ID
	*/
	@ApiModelProperty(required = false,value="角色ID" , notes = "角色ID")
	private String roleId;
	
	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;
	
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
	public CodeExampleRole setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 属主ID<br>
	 * 属主ID
	 * @return 属主ID
	*/
	public String getExampleId() {
		return exampleId;
	}
	
	/**
	 * 设置 属主ID
	 * @param exampleId 属主ID
	 * @return 当前对象
	*/
	public CodeExampleRole setExampleId(String exampleId) {
		this.exampleId=exampleId;
		return this;
	}
	
	/**
	 * 获得 角色ID<br>
	 * 角色ID
	 * @return 角色ID
	*/
	public String getRoleId() {
		return roleId;
	}
	
	/**
	 * 设置 角色ID
	 * @param roleId 角色ID
	 * @return 当前对象
	*/
	public CodeExampleRole setRoleId(String roleId) {
		this.roleId=roleId;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public CodeExampleRole setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CodeExampleRole , 转换好的 CodeExampleRole 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CodeExampleRole , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 CodeExampleRole
	 * @param codeExampleRoleMap 包含实体信息的 Map 对象
	 * @return CodeExampleRole , 转换好的的 CodeExampleRole 对象
	*/
	@Transient
	public static CodeExampleRole createFrom(Map<String,Object> codeExampleRoleMap) {
		if(codeExampleRoleMap==null) return null;
		CodeExampleRole po = EntityContext.create(CodeExampleRole.class, codeExampleRoleMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 CodeExampleRole
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CodeExampleRole , 转换好的的 CodeExampleRole 对象
	*/
	@Transient
	public static CodeExampleRole createFrom(Object pojo) {
		if(pojo==null) return null;
		CodeExampleRole po = EntityContext.create(CodeExampleRole.class,pojo);
		return po;
	}

	/**
	 * 创建一个 CodeExampleRole，等同于 new
	 * @return CodeExampleRole 对象
	*/
	@Transient
	public static CodeExampleRole create() {
		return EntityContext.create(CodeExampleRole.class);
	}
}