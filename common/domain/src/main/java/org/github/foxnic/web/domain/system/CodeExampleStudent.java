package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_CODE_EXAMPLE_STUDENT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 代码生成主表学生
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-02-07 09:03:09
 * @sign 178E1493E89880B5965EAEF5A93FD159
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_code_example_student")
public class CodeExampleStudent extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_CODE_EXAMPLE_STUDENT.$TABLE;
	
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
	 * 学生姓名：学生姓名
	*/
	@ApiModelProperty(required = false,value="学生姓名" , notes = "学生姓名")
	private String name;
	
	/**
	 * 年龄：年龄
	*/
	@ApiModelProperty(required = false,value="年龄" , notes = "年龄")
	private String age;
	
	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
	private Integer deleted;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
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
	public CodeExampleStudent setId(String id) {
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
	public CodeExampleStudent setExampleId(String exampleId) {
		this.exampleId=exampleId;
		return this;
	}
	
	/**
	 * 获得 学生姓名<br>
	 * 学生姓名
	 * @return 学生姓名
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 学生姓名
	 * @param name 学生姓名
	 * @return 当前对象
	*/
	public CodeExampleStudent setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 年龄<br>
	 * 年龄
	 * @return 年龄
	*/
	public String getAge() {
		return age;
	}
	
	/**
	 * 设置 年龄
	 * @param age 年龄
	 * @return 当前对象
	*/
	public CodeExampleStudent setAge(String age) {
		this.age=age;
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
	public CodeExampleStudent setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public CodeExampleStudent setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public CodeExampleStudent setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public CodeExampleStudent setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public CodeExampleStudent setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public CodeExampleStudent setDeleted(Integer deleted) {
		this.deleted=deleted;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public CodeExampleStudent setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public CodeExampleStudent setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CodeExampleStudent , 转换好的 CodeExampleStudent 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CodeExampleStudent , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 CodeExampleStudent
	 * @param codeExampleStudentMap 包含实体信息的 Map 对象
	 * @return CodeExampleStudent , 转换好的的 CodeExampleStudent 对象
	*/
	@Transient
	public static CodeExampleStudent createFrom(Map<String,Object> codeExampleStudentMap) {
		if(codeExampleStudentMap==null) return null;
		CodeExampleStudent po = EntityContext.create(CodeExampleStudent.class, codeExampleStudentMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 CodeExampleStudent
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CodeExampleStudent , 转换好的的 CodeExampleStudent 对象
	*/
	@Transient
	public static CodeExampleStudent createFrom(Object pojo) {
		if(pojo==null) return null;
		CodeExampleStudent po = EntityContext.create(CodeExampleStudent.class,pojo);
		return po;
	}

	/**
	 * 创建一个 CodeExampleStudent，等同于 new
	 * @return CodeExampleStudent 对象
	*/
	@Transient
	public static CodeExampleStudent create() {
		return EntityContext.create(CodeExampleStudent.class);
	}
}