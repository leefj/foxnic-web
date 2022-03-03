package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_CODE_EXAMPLE_MULIT_PK;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 主键多字段测试
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-02-11 13:02:52
 * @sign B796FD90DD8B8105428CD5B50F78EFCD
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_code_example_mulit_pk")
public class CodeExampleMulitPk extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_CODE_EXAMPLE_MULIT_PK.$TABLE;
	
	/**
	 * 主键1：主键1
	*/
	@Id
	@ApiModelProperty(required = true,value="主键1" , notes = "主键1")
	private Long nid;
	
	/**
	 * 主键2：主键2
	*/
	@Id
	@ApiModelProperty(required = true,value="主键2" , notes = "主键2")
	private Date day;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String content;
	
	/**
	 * 获得 主键1<br>
	 * 主键1
	 * @return 主键1
	*/
	public Long getNid() {
		return nid;
	}
	
	/**
	 * 设置 主键1
	 * @param nid 主键1
	 * @return 当前对象
	*/
	public CodeExampleMulitPk setNid(Long nid) {
		this.nid=nid;
		return this;
	}
	
	/**
	 * 获得 主键2<br>
	 * 主键2
	 * @return 主键2
	*/
	public Date getDay() {
		return day;
	}
	
	/**
	 * 设置 主键2
	 * @param day 主键2
	 * @return 当前对象
	*/
	public CodeExampleMulitPk setDay(Date day) {
		this.day=day;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 内容
	 * @param content 内容
	 * @return 当前对象
	*/
	public CodeExampleMulitPk setContent(String content) {
		this.content=content;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CodeExampleMulitPk , 转换好的 CodeExampleMulitPk 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CodeExampleMulitPk , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 CodeExampleMulitPk
	 * @param codeExampleMulitPkMap 包含实体信息的 Map 对象
	 * @return CodeExampleMulitPk , 转换好的的 CodeExampleMulitPk 对象
	*/
	@Transient
	public static CodeExampleMulitPk createFrom(Map<String,Object> codeExampleMulitPkMap) {
		if(codeExampleMulitPkMap==null) return null;
		CodeExampleMulitPk po = EntityContext.create(CodeExampleMulitPk.class, codeExampleMulitPkMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 CodeExampleMulitPk
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CodeExampleMulitPk , 转换好的的 CodeExampleMulitPk 对象
	*/
	@Transient
	public static CodeExampleMulitPk createFrom(Object pojo) {
		if(pojo==null) return null;
		CodeExampleMulitPk po = EntityContext.create(CodeExampleMulitPk.class,pojo);
		return po;
	}

	/**
	 * 创建一个 CodeExampleMulitPk，等同于 new
	 * @return CodeExampleMulitPk 对象
	*/
	@Transient
	public static CodeExampleMulitPk create() {
		return EntityContext.create(CodeExampleMulitPk.class);
	}
}