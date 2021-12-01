package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_CODE_EXAMPLE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.Resourze;
import org.github.foxnic.web.domain.oauth.Role;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 代码生成示例主
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-01 16:21:18
 * @sign 7BD1AD1C1873179E4C5895D8CF8F4C32
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_code_example")
public class CodeExample extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_CODE_EXAMPLE.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID")
	private String id;
	
	/**
	 * 单行文本：单行文本
	*/
	@ApiModelProperty(required = false,value="单行文本" , notes = "单行文本")
	private String name;
	
	/**
	 * 多行文本：多行文本
	*/
	@ApiModelProperty(required = false,value="多行文本" , notes = "多行文本")
	private String notes;
	
	/**
	 * 图片上传：图片上传
	*/
	@ApiModelProperty(required = false,value="图片上传" , notes = "图片上传")
	private String imageId;
	
	/**
	 * 多文件上传：多文件上传
	*/
	@ApiModelProperty(required = false,value="多文件上传" , notes = "多文件上传")
	private String fileIds;
	
	/**
	 * 整数输入：整数输入
	*/
	@ApiModelProperty(required = false,value="整数输入" , notes = "整数输入")
	private Integer area;
	
	/**
	 * 小数输入：小数输入
	*/
	@ApiModelProperty(required = false,value="小数输入" , notes = "小数输入")
	private Double weight;
	
	/**
	 * 逻辑值：逻辑值
	*/
	@ApiModelProperty(required = false,value="逻辑值" , notes = "逻辑值")
	private Integer valid;
	
	/**
	 * 对话框：对话框
	*/
	@ApiModelProperty(required = false,value="对话框" , notes = "对话框")
	private String buttonInput;
	
	/**
	 * 单选框(枚举)：单选框(枚举)
	*/
	@ApiModelProperty(required = false,value="单选框(枚举)" , notes = "单选框(枚举)")
	private String radioEnum;
	
	/**
	 * 单选框(字典)：单选框(字典)
	*/
	@ApiModelProperty(required = false,value="单选框(字典)" , notes = "单选框(字典)")
	private String radioDict;
	
	/**
	 * 复选框(枚举)：复选框(枚举)
	*/
	@ApiModelProperty(required = false,value="复选框(枚举)" , notes = "复选框(枚举)")
	private String checkEnum;
	
	/**
	 * 复选框(字典)：复选框(字典)
	*/
	@ApiModelProperty(required = false,value="复选框(字典)" , notes = "复选框(字典)")
	private String checkDict;
	
	/**
	 * 选择框(枚举)：选择框(枚举)
	*/
	@ApiModelProperty(required = false,value="选择框(枚举)" , notes = "选择框(枚举)")
	private String selectEnum;
	
	/**
	 * 选择框(字典)：选择框(字典)
	*/
	@ApiModelProperty(required = false,value="选择框(字典)" , notes = "选择框(字典)")
	private String selectDict;
	
	/**
	 * 选择框(查询)：选择框(查询)
	*/
	@ApiModelProperty(required = false,value="选择框(查询)" , notes = "选择框(查询)")
	private String resourceId;
	
	/**
	 * 日期：日期
	*/
	@ApiModelProperty(required = false,value="日期" , notes = "日期")
	private Date birthday;
	
	/**
	 * 工作时间：工作时间
	*/
	@ApiModelProperty(required = false,value="工作时间" , notes = "工作时间")
	private Date workTime;
	
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
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;
	
	/**
	 * 关联一个资源：一对一关系属性拓展
	*/
	@ApiModelProperty(required = false,value="关联一个资源" , notes = "一对一关系属性拓展")
	private Resourze resourze;
	
	/**
	 * 关联多个角色：一对多关系属性拓展
	*/
	@ApiModelProperty(required = false,value="关联多个角色" , notes = "一对多关系属性拓展")
	private List<Role> roles;
	
	/**
	 * 角色的数量(Java)：关联角色数量JAva统计
	*/
	@ApiModelProperty(required = false,value="角色的数量(Java)" , notes = "关联角色数量JAva统计")
	private Integer roleCountByAfter;
	
	/**
	 * 角色的数量(Join)：关联角色数量Join统计
	*/
	@ApiModelProperty(required = false,value="角色的数量(Join)" , notes = "关联角色数量Join统计")
	private Integer roleCountByJoin;
	
	/**
	 * 角色ID列表：用于表单角色ID提交到后端
	*/
	@ApiModelProperty(required = false,value="角色ID列表" , notes = "用于表单角色ID提交到后端")
	private List<String> roleIds;
	
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
	public CodeExample setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 单行文本<br>
	 * 单行文本
	 * @return 单行文本
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 单行文本
	 * @param name 单行文本
	 * @return 当前对象
	*/
	public CodeExample setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 多行文本<br>
	 * 多行文本
	 * @return 多行文本
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 多行文本
	 * @param notes 多行文本
	 * @return 当前对象
	*/
	public CodeExample setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 图片上传<br>
	 * 图片上传
	 * @return 图片上传
	*/
	public String getImageId() {
		return imageId;
	}
	
	/**
	 * 设置 图片上传
	 * @param imageId 图片上传
	 * @return 当前对象
	*/
	public CodeExample setImageId(String imageId) {
		this.imageId=imageId;
		return this;
	}
	
	/**
	 * 获得 多文件上传<br>
	 * 多文件上传
	 * @return 多文件上传
	*/
	public String getFileIds() {
		return fileIds;
	}
	
	/**
	 * 设置 多文件上传
	 * @param fileIds 多文件上传
	 * @return 当前对象
	*/
	public CodeExample setFileIds(String fileIds) {
		this.fileIds=fileIds;
		return this;
	}
	
	/**
	 * 获得 整数输入<br>
	 * 整数输入
	 * @return 整数输入
	*/
	public Integer getArea() {
		return area;
	}
	
	/**
	 * 设置 整数输入
	 * @param area 整数输入
	 * @return 当前对象
	*/
	public CodeExample setArea(Integer area) {
		this.area=area;
		return this;
	}
	
	/**
	 * 获得 小数输入<br>
	 * 小数输入
	 * @return 小数输入
	*/
	public Double getWeight() {
		return weight;
	}
	
	/**
	 * 设置 小数输入
	 * @param weight 小数输入
	 * @return 当前对象
	*/
	public CodeExample setWeight(Double weight) {
		this.weight=weight;
		return this;
	}
	
	/**
	 * 获得 逻辑值<br>
	 * 逻辑值
	 * @return 逻辑值
	*/
	public Integer getValid() {
		return valid;
	}
	
	/**
	 * 设置 逻辑值
	 * @param valid 逻辑值
	 * @return 当前对象
	*/
	public CodeExample setValid(Integer valid) {
		this.valid=valid;
		return this;
	}
	
	/**
	 * 获得 对话框<br>
	 * 对话框
	 * @return 对话框
	*/
	public String getButtonInput() {
		return buttonInput;
	}
	
	/**
	 * 设置 对话框
	 * @param buttonInput 对话框
	 * @return 当前对象
	*/
	public CodeExample setButtonInput(String buttonInput) {
		this.buttonInput=buttonInput;
		return this;
	}
	
	/**
	 * 获得 单选框(枚举)<br>
	 * 单选框(枚举)
	 * @return 单选框(枚举)
	*/
	public String getRadioEnum() {
		return radioEnum;
	}
	
	/**
	 * 设置 单选框(枚举)
	 * @param radioEnum 单选框(枚举)
	 * @return 当前对象
	*/
	public CodeExample setRadioEnum(String radioEnum) {
		this.radioEnum=radioEnum;
		return this;
	}
	
	/**
	 * 获得 单选框(字典)<br>
	 * 单选框(字典)
	 * @return 单选框(字典)
	*/
	public String getRadioDict() {
		return radioDict;
	}
	
	/**
	 * 设置 单选框(字典)
	 * @param radioDict 单选框(字典)
	 * @return 当前对象
	*/
	public CodeExample setRadioDict(String radioDict) {
		this.radioDict=radioDict;
		return this;
	}
	
	/**
	 * 获得 复选框(枚举)<br>
	 * 复选框(枚举)
	 * @return 复选框(枚举)
	*/
	public String getCheckEnum() {
		return checkEnum;
	}
	
	/**
	 * 设置 复选框(枚举)
	 * @param checkEnum 复选框(枚举)
	 * @return 当前对象
	*/
	public CodeExample setCheckEnum(String checkEnum) {
		this.checkEnum=checkEnum;
		return this;
	}
	
	/**
	 * 获得 复选框(字典)<br>
	 * 复选框(字典)
	 * @return 复选框(字典)
	*/
	public String getCheckDict() {
		return checkDict;
	}
	
	/**
	 * 设置 复选框(字典)
	 * @param checkDict 复选框(字典)
	 * @return 当前对象
	*/
	public CodeExample setCheckDict(String checkDict) {
		this.checkDict=checkDict;
		return this;
	}
	
	/**
	 * 获得 选择框(枚举)<br>
	 * 选择框(枚举)
	 * @return 选择框(枚举)
	*/
	public String getSelectEnum() {
		return selectEnum;
	}
	
	/**
	 * 设置 选择框(枚举)
	 * @param selectEnum 选择框(枚举)
	 * @return 当前对象
	*/
	public CodeExample setSelectEnum(String selectEnum) {
		this.selectEnum=selectEnum;
		return this;
	}
	
	/**
	 * 获得 选择框(字典)<br>
	 * 选择框(字典)
	 * @return 选择框(字典)
	*/
	public String getSelectDict() {
		return selectDict;
	}
	
	/**
	 * 设置 选择框(字典)
	 * @param selectDict 选择框(字典)
	 * @return 当前对象
	*/
	public CodeExample setSelectDict(String selectDict) {
		this.selectDict=selectDict;
		return this;
	}
	
	/**
	 * 获得 选择框(查询)<br>
	 * 选择框(查询)
	 * @return 选择框(查询)
	*/
	public String getResourceId() {
		return resourceId;
	}
	
	/**
	 * 设置 选择框(查询)
	 * @param resourceId 选择框(查询)
	 * @return 当前对象
	*/
	public CodeExample setResourceId(String resourceId) {
		this.resourceId=resourceId;
		return this;
	}
	
	/**
	 * 获得 日期<br>
	 * 日期
	 * @return 日期
	*/
	public Date getBirthday() {
		return birthday;
	}
	
	/**
	 * 设置 日期
	 * @param birthday 日期
	 * @return 当前对象
	*/
	public CodeExample setBirthday(Date birthday) {
		this.birthday=birthday;
		return this;
	}
	
	/**
	 * 获得 工作时间<br>
	 * 工作时间
	 * @return 工作时间
	*/
	public Date getWorkTime() {
		return workTime;
	}
	
	/**
	 * 设置 工作时间
	 * @param workTime 工作时间
	 * @return 当前对象
	*/
	public CodeExample setWorkTime(Date workTime) {
		this.workTime=workTime;
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
	public CodeExample setCreateBy(String createBy) {
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
	public CodeExample setCreateTime(Date createTime) {
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
	public CodeExample setUpdateBy(String updateBy) {
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
	public CodeExample setUpdateTime(Date updateTime) {
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
	public CodeExample setDeleted(Integer deleted) {
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
	public CodeExample setDeleteBy(String deleteBy) {
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
	public CodeExample setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
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
	public CodeExample setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 关联一个资源<br>
	 * 一对一关系属性拓展
	 * @return 关联一个资源
	*/
	public Resourze getResourze() {
		return resourze;
	}
	
	/**
	 * 设置 关联一个资源
	 * @param resourze 关联一个资源
	 * @return 当前对象
	*/
	public CodeExample setResourze(Resourze resourze) {
		this.resourze=resourze;
		return this;
	}
	
	/**
	 * 获得 关联多个角色<br>
	 * 一对多关系属性拓展
	 * @return 关联多个角色
	*/
	public List<Role> getRoles() {
		return roles;
	}
	
	/**
	 * 设置 关联多个角色
	 * @param roles 关联多个角色
	 * @return 当前对象
	*/
	public CodeExample setRoles(List<Role> roles) {
		this.roles=roles;
		return this;
	}
	
	/**
	 * 添加 关联多个角色
	 * @param role 关联多个角色
	 * @return 当前对象
	*/
	public CodeExample addRole(Role role) {
		if(this.roles==null) roles=new ArrayList<>();
		this.roles.add(role);
		return this;
	}
	
	/**
	 * 获得 角色的数量(Java)<br>
	 * 关联角色数量JAva统计
	 * @return 角色的数量(Java)
	*/
	public Integer getRoleCountByAfter() {
		return roleCountByAfter;
	}
	
	/**
	 * 设置 角色的数量(Java)
	 * @param roleCountByAfter 角色的数量(Java)
	 * @return 当前对象
	*/
	public CodeExample setRoleCountByAfter(Integer roleCountByAfter) {
		this.roleCountByAfter=roleCountByAfter;
		return this;
	}
	
	/**
	 * 获得 角色的数量(Join)<br>
	 * 关联角色数量Join统计
	 * @return 角色的数量(Join)
	*/
	public Integer getRoleCountByJoin() {
		return roleCountByJoin;
	}
	
	/**
	 * 设置 角色的数量(Join)
	 * @param roleCountByJoin 角色的数量(Join)
	 * @return 当前对象
	*/
	public CodeExample setRoleCountByJoin(Integer roleCountByJoin) {
		this.roleCountByJoin=roleCountByJoin;
		return this;
	}
	
	/**
	 * 获得 角色ID列表<br>
	 * 用于表单角色ID提交到后端
	 * @return 角色ID列表
	*/
	public List<String> getRoleIds() {
		return roleIds;
	}
	
	/**
	 * 设置 角色ID列表
	 * @param roleIds 角色ID列表
	 * @return 当前对象
	*/
	public CodeExample setRoleIds(List<String> roleIds) {
		this.roleIds=roleIds;
		return this;
	}
	
	/**
	 * 添加 角色ID列表
	 * @param roleId 角色ID列表
	 * @return 当前对象
	*/
	public CodeExample addRoleId(String roleId) {
		if(this.roleIds==null) roleIds=new ArrayList<>();
		this.roleIds.add(roleId);
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CodeExample , 转换好的 CodeExample 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CodeExample , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 CodeExample
	 * @param codeExampleMap 包含实体信息的 Map 对象
	 * @return CodeExample , 转换好的的 CodeExample 对象
	*/
	@Transient
	public static CodeExample createFrom(Map<String,Object> codeExampleMap) {
		if(codeExampleMap==null) return null;
		CodeExample po = EntityContext.create(CodeExample.class, codeExampleMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 CodeExample
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CodeExample , 转换好的的 CodeExample 对象
	*/
	@Transient
	public static CodeExample createFrom(Object pojo) {
		if(pojo==null) return null;
		CodeExample po = EntityContext.create(CodeExample.class,pojo);
		return po;
	}

	/**
	 * 创建一个 CodeExample，等同于 new
	 * @return CodeExample 对象
	*/
	@Transient
	public static CodeExample create() {
		return EntityContext.create(CodeExample.class);
	}
}