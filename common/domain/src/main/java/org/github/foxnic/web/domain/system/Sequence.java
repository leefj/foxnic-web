package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_SEQUENCE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.system.meta.SequenceMeta;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 序列
 * <p>序列 , 数据表 sys_sequence 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:38:51
 * @sign C53230327A370931738A2F89D651168E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_sequence")
@ApiModel(description = "序列 ; 序列 , 数据表 sys_sequence 的PO类型")
public class Sequence extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_SEQUENCE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "493436270085668833")
	private String pk;
	
	/**
	 * 序列ID：序列ID
	*/
	@ApiModelProperty(required = true,value="序列ID" , notes = "序列ID" , example = "pcm-catalog-version-no")
	private String id;
	
	/**
	 * 序列名称：序列名称
	*/
	@ApiModelProperty(required = false,value="序列名称" , notes = "序列名称" , example = "PCM")
	private String name;
	
	/**
	 * 编码长度：编码长度
	*/
	@ApiModelProperty(required = false,value="编码长度" , notes = "编码长度" , example = "3")
	private Integer length;
	
	/**
	 * 编码分类：编码分类
	*/
	@ApiModelProperty(required = false,value="编码分类" , notes = "编码分类" , example = "20221025")
	private String catalog;
	
	/**
	 * 当前数值：当前数值
	*/
	@ApiModelProperty(required = false,value="当前数值" , notes = "当前数值" , example = "4")
	private Long value;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String memo;
	
	/**
	 * 编码类型：编码类型
	*/
	@ApiModelProperty(required = false,value="编码类型" , notes = "编码类型" , example = "DAI")
	private String type;
	
	/**
	 * 租户ID：租户ID
	*/
	@ApiModelProperty(required = true,value="租户ID" , notes = "租户ID" , example = "T001")
	private String tenantId;
	
	/**
	 * 每次取数的个数：每次取数的个数
	*/
	@ApiModelProperty(required = true,value="每次取数的个数" , notes = "每次取数的个数" , example = "4")
	private Integer fetchSize;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getPk() {
		return pk;
	}
	
	/**
	 * 设置 主键
	 * @param pk 主键
	 * @return 当前对象
	*/
	public Sequence setPk(String pk) {
		this.pk=pk;
		return this;
	}
	
	/**
	 * 获得 序列ID<br>
	 * 序列ID
	 * @return 序列ID
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 序列ID
	 * @param id 序列ID
	 * @return 当前对象
	*/
	public Sequence setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 序列名称<br>
	 * 序列名称
	 * @return 序列名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 序列名称
	 * @param name 序列名称
	 * @return 当前对象
	*/
	public Sequence setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 编码长度<br>
	 * 编码长度
	 * @return 编码长度
	*/
	public Integer getLength() {
		return length;
	}
	
	/**
	 * 设置 编码长度
	 * @param length 编码长度
	 * @return 当前对象
	*/
	public Sequence setLength(Integer length) {
		this.length=length;
		return this;
	}
	
	/**
	 * 获得 编码分类<br>
	 * 编码分类
	 * @return 编码分类
	*/
	public String getCatalog() {
		return catalog;
	}
	
	/**
	 * 设置 编码分类
	 * @param catalog 编码分类
	 * @return 当前对象
	*/
	public Sequence setCatalog(String catalog) {
		this.catalog=catalog;
		return this;
	}
	
	/**
	 * 获得 当前数值<br>
	 * 当前数值
	 * @return 当前数值
	*/
	public Long getValue() {
		return value;
	}
	
	/**
	 * 设置 当前数值
	 * @param value 当前数值
	 * @return 当前对象
	*/
	public Sequence setValue(Long value) {
		this.value=value;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getMemo() {
		return memo;
	}
	
	/**
	 * 设置 备注
	 * @param memo 备注
	 * @return 当前对象
	*/
	public Sequence setMemo(String memo) {
		this.memo=memo;
		return this;
	}
	
	/**
	 * 获得 编码类型<br>
	 * 编码类型
	 * @return 编码类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 编码类型
	 * @param type 编码类型
	 * @return 当前对象
	*/
	public Sequence setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 租户ID<br>
	 * 租户ID
	 * @return 租户ID
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户ID
	 * @param tenantId 租户ID
	 * @return 当前对象
	*/
	public Sequence setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 每次取数的个数<br>
	 * 每次取数的个数
	 * @return 每次取数的个数
	*/
	public Integer getFetchSize() {
		return fetchSize;
	}
	
	/**
	 * 设置 每次取数的个数
	 * @param fetchSize 每次取数的个数
	 * @return 当前对象
	*/
	public Sequence setFetchSize(Integer fetchSize) {
		this.fetchSize=fetchSize;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Sequence , 转换好的 Sequence 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Sequence , 转换好的 PoJo 对象
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
	public Sequence clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Sequence duplicate(boolean all) {
		org.github.foxnic.web.domain.system.meta.SequenceMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.system.meta.SequenceMeta.$$proxy$$();
		inst.setFetchSize(this.getFetchSize());
		inst.setCatalog(this.getCatalog());
		inst.setName(this.getName());
		inst.setLength(this.getLength());
		inst.setTenantId(this.getTenantId());
		inst.setMemo(this.getMemo());
		inst.setPk(this.getPk());
		inst.setId(this.getId());
		inst.setType(this.getType());
		inst.setValue(this.getValue());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Sequence clone(boolean deep) {
		return EntityContext.clone(Sequence.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Sequence
	 * @param sequenceMap 包含实体信息的 Map 对象
	 * @return Sequence , 转换好的的 Sequence 对象
	*/
	@Transient
	public static Sequence createFrom(Map<String,Object> sequenceMap) {
		if(sequenceMap==null) return null;
		Sequence po = create();
		EntityContext.copyProperties(po,sequenceMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Sequence
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Sequence , 转换好的的 Sequence 对象
	*/
	@Transient
	public static Sequence createFrom(Object pojo) {
		if(pojo==null) return null;
		Sequence po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Sequence，等同于 new
	 * @return Sequence 对象
	*/
	@Transient
	public static Sequence create() {
		return new org.github.foxnic.web.domain.system.meta.SequenceMeta.$$proxy$$();
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
			this.setFetchSize(DataParser.parse(Integer.class, map.get(SequenceMeta.FETCH_SIZE)));
			this.setCatalog(DataParser.parse(String.class, map.get(SequenceMeta.CATALOG)));
			this.setName(DataParser.parse(String.class, map.get(SequenceMeta.NAME)));
			this.setLength(DataParser.parse(Integer.class, map.get(SequenceMeta.LENGTH)));
			this.setTenantId(DataParser.parse(String.class, map.get(SequenceMeta.TENANT_ID)));
			this.setMemo(DataParser.parse(String.class, map.get(SequenceMeta.MEMO)));
			this.setPk(DataParser.parse(String.class, map.get(SequenceMeta.PK)));
			this.setId(DataParser.parse(String.class, map.get(SequenceMeta.ID)));
			this.setType(DataParser.parse(String.class, map.get(SequenceMeta.TYPE)));
			this.setValue(DataParser.parse(Long.class, map.get(SequenceMeta.VALUE)));
			// others
			return true;
		} else {
			try {
				this.setFetchSize( (Integer)map.get(SequenceMeta.FETCH_SIZE));
				this.setCatalog( (String)map.get(SequenceMeta.CATALOG));
				this.setName( (String)map.get(SequenceMeta.NAME));
				this.setLength( (Integer)map.get(SequenceMeta.LENGTH));
				this.setTenantId( (String)map.get(SequenceMeta.TENANT_ID));
				this.setMemo( (String)map.get(SequenceMeta.MEMO));
				this.setPk( (String)map.get(SequenceMeta.PK));
				this.setId( (String)map.get(SequenceMeta.ID));
				this.setType( (String)map.get(SequenceMeta.TYPE));
				this.setValue( (Long)map.get(SequenceMeta.VALUE));
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
			this.setFetchSize(DataParser.parse(Integer.class, r.getValue(SequenceMeta.FETCH_SIZE)));
			this.setCatalog(DataParser.parse(String.class, r.getValue(SequenceMeta.CATALOG)));
			this.setName(DataParser.parse(String.class, r.getValue(SequenceMeta.NAME)));
			this.setLength(DataParser.parse(Integer.class, r.getValue(SequenceMeta.LENGTH)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SequenceMeta.TENANT_ID)));
			this.setMemo(DataParser.parse(String.class, r.getValue(SequenceMeta.MEMO)));
			this.setPk(DataParser.parse(String.class, r.getValue(SequenceMeta.PK)));
			this.setId(DataParser.parse(String.class, r.getValue(SequenceMeta.ID)));
			this.setType(DataParser.parse(String.class, r.getValue(SequenceMeta.TYPE)));
			this.setValue(DataParser.parse(Long.class, r.getValue(SequenceMeta.VALUE)));
			return true;
		} else {
			try {
				this.setFetchSize( (Integer)r.getValue(SequenceMeta.FETCH_SIZE));
				this.setCatalog( (String)r.getValue(SequenceMeta.CATALOG));
				this.setName( (String)r.getValue(SequenceMeta.NAME));
				this.setLength( (Integer)r.getValue(SequenceMeta.LENGTH));
				this.setTenantId( (String)r.getValue(SequenceMeta.TENANT_ID));
				this.setMemo( (String)r.getValue(SequenceMeta.MEMO));
				this.setPk( (String)r.getValue(SequenceMeta.PK));
				this.setId( (String)r.getValue(SequenceMeta.ID));
				this.setType( (String)r.getValue(SequenceMeta.TYPE));
				this.setValue( (Long)r.getValue(SequenceMeta.VALUE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}