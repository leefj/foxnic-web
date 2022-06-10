package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_DEMO_COMMON;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 通用审批表单
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-06-10 16:19:31
 * @sign B5FA5B033F9B62477AC6989F22197570
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_demo_common")
public class DemoCommon extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_DEMO_COMMON.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 标题：标题
	*/
	@ApiModelProperty(required = false,value="标题" , notes = "标题")
	private String subject;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String content;
	
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
	public DemoCommon setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 标题<br>
	 * 标题
	 * @return 标题
	*/
	public String getSubject() {
		return subject;
	}
	
	/**
	 * 设置 标题
	 * @param subject 标题
	 * @return 当前对象
	*/
	public DemoCommon setSubject(String subject) {
		this.subject=subject;
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
	public DemoCommon setContent(String content) {
		this.content=content;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DemoCommon , 转换好的 DemoCommon 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DemoCommon , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 DemoCommon
	 * @param demoCommonMap 包含实体信息的 Map 对象
	 * @return DemoCommon , 转换好的的 DemoCommon 对象
	*/
	@Transient
	public static DemoCommon createFrom(Map<String,Object> demoCommonMap) {
		if(demoCommonMap==null) return null;
		DemoCommon po = EntityContext.create(DemoCommon.class, demoCommonMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 DemoCommon
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DemoCommon , 转换好的的 DemoCommon 对象
	*/
	@Transient
	public static DemoCommon createFrom(Object pojo) {
		if(pojo==null) return null;
		DemoCommon po = EntityContext.create(DemoCommon.class,pojo);
		return po;
	}

	/**
	 * 创建一个 DemoCommon，等同于 new
	 * @return DemoCommon 对象
	*/
	@Transient
	public static DemoCommon create() {
		return EntityContext.create(DemoCommon.class);
	}
}