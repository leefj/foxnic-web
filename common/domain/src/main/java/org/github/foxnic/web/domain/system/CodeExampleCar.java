package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_CODE_EXAMPLE_CAR;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-22 08:53:46
 * @sign 9E7731103783872C579AD050FA29D1B1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_code_example_car")
public class CodeExampleCar extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_CODE_EXAMPLE_CAR.$TABLE;
	
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
	 * 车牌号：车牌号
	*/
	@ApiModelProperty(required = false,value="车牌号" , notes = "车牌号")
	private String plateNumber;
	
	/**
	 * 颜色：颜色
	*/
	@ApiModelProperty(required = false,value="颜色" , notes = "颜色")
	private String color;
	
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
	public CodeExampleCar setId(String id) {
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
	public CodeExampleCar setExampleId(String exampleId) {
		this.exampleId=exampleId;
		return this;
	}
	
	/**
	 * 获得 车牌号<br>
	 * 车牌号
	 * @return 车牌号
	*/
	public String getPlateNumber() {
		return plateNumber;
	}
	
	/**
	 * 设置 车牌号
	 * @param plateNumber 车牌号
	 * @return 当前对象
	*/
	public CodeExampleCar setPlateNumber(String plateNumber) {
		this.plateNumber=plateNumber;
		return this;
	}
	
	/**
	 * 获得 颜色<br>
	 * 颜色
	 * @return 颜色
	*/
	public String getColor() {
		return color;
	}
	
	/**
	 * 设置 颜色
	 * @param color 颜色
	 * @return 当前对象
	*/
	public CodeExampleCar setColor(String color) {
		this.color=color;
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
	public CodeExampleCar setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CodeExampleCar , 转换好的 CodeExampleCar 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CodeExampleCar , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 CodeExampleCar
	 * @param codeExampleCarMap 包含实体信息的 Map 对象
	 * @return CodeExampleCar , 转换好的的 CodeExampleCar 对象
	*/
	@Transient
	public static CodeExampleCar createFrom(Map<String,Object> codeExampleCarMap) {
		if(codeExampleCarMap==null) return null;
		CodeExampleCar po = EntityContext.create(CodeExampleCar.class, codeExampleCarMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 CodeExampleCar
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CodeExampleCar , 转换好的的 CodeExampleCar 对象
	*/
	@Transient
	public static CodeExampleCar createFrom(Object pojo) {
		if(pojo==null) return null;
		CodeExampleCar po = EntityContext.create(CodeExampleCar.class,pojo);
		return po;
	}

	/**
	 * 创建一个 CodeExampleCar，等同于 new
	 * @return CodeExampleCar 对象
	*/
	@Transient
	public static CodeExampleCar create() {
		return EntityContext.create(CodeExampleCar.class);
	}
}