package org.github.foxnic.web.system.service.impl;


import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.github.foxnic.web.domain.system.CodeExampleRole;
import org.github.foxnic.web.domain.system.CodeExampleRoleVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import java.lang.reflect.Field;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.excel.ExcelStructure;
import java.io.InputStream;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.meta.DBColumnMeta;
import com.github.foxnic.sql.expr.Select;
import java.util.ArrayList;
import org.github.foxnic.web.system.service.ICodeExampleRoleService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.constants.db.FoxnicWeb.*;
import org.github.foxnic.web.domain.system.CodeExample;
import org.github.foxnic.web.domain.oauth.Role;

/**
 * <p>
 * 代码示例主表角色关系表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-02-07 09:03:09
*/


@Service("SysCodeExampleRoleService")
public class CodeExampleRoleServiceImpl extends SuperService<CodeExampleRole> implements ICodeExampleRoleService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }



	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param codeExampleRole  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(CodeExampleRole codeExampleRole,boolean throwsException) {
		Result r=super.insert(codeExampleRole,throwsException);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param codeExampleRole 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(CodeExampleRole codeExampleRole) {
		return this.insert(codeExampleRole,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param codeExampleRoleList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<CodeExampleRole> codeExampleRoleList) {
		return super.insertList(codeExampleRoleList);
	}

	
	/**
	 * 按主键删除 代码示例主表角色关系
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		CodeExampleRole codeExampleRole = new CodeExampleRole();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		codeExampleRole.setId(id);
		try {
			boolean suc = dao.deleteEntity(codeExampleRole);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 更新，如果执行错误，则抛出异常
	 * @param codeExampleRole 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(CodeExampleRole codeExampleRole , SaveMode mode) {
		return this.update(codeExampleRole,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param codeExampleRole 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(CodeExampleRole codeExampleRole , SaveMode mode,boolean throwsException) {
		Result r=super.update(codeExampleRole , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param codeExampleRoleList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<CodeExampleRole> codeExampleRoleList , SaveMode mode) {
		return super.updateList(codeExampleRoleList , mode);
	}

	
	/**
	 * 按主键更新字段 代码示例主表角色关系
	 *
	 * @param id 主键
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	}

	
	/**
	 * 按主键获取 代码示例主表角色关系
	 *
	 * @param id 主键
	 * @return CodeExampleRole 数据对象
	 */
	public CodeExampleRole getById(String id) {
		CodeExampleRole sample = new CodeExampleRole();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<CodeExampleRole> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<CodeExampleRole> queryList(CodeExampleRole sample) {
		return super.queryList(sample);
	}


	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<CodeExampleRole> queryPagedList(CodeExampleRole sample, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, pageSize, pageIndex);
	}

	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @param condition 其它条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<CodeExampleRole> queryPagedList(CodeExampleRole sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param codeExampleRole 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(CodeExampleRole codeExampleRole) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(codeExampleRole, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(CodeExampleRole sample) {
		return super.exportExcel(sample);
	}

	@Override
	public ExcelWriter exportExcelTemplate() {
		return super.exportExcelTemplate();
	}

	@Override
	public List<ValidateResult> importExcel(InputStream input,int sheetIndex,boolean batch) {
		return super.importExcel(input,sheetIndex,batch);
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}

	/**
     * 保存关系
     * @param exampleId 属主ID
     * @param roleIds 角色ID清单
     */
	public void saveRelation(String exampleId,List<String> roleIds) {
		super.saveRelation(CodeExample.class,SYS_CODE_EXAMPLE_ROLE.EXAMPLE_ID,exampleId,Role.class,SYS_CODE_EXAMPLE_ROLE.ROLE_ID,roleIds,true);
	}

}
