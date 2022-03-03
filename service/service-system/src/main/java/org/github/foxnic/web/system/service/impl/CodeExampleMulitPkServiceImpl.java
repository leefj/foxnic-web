package org.github.foxnic.web.system.service.impl;


import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.github.foxnic.web.domain.system.CodeExampleMulitPk;
import org.github.foxnic.web.domain.system.CodeExampleMulitPkVO;
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
import org.github.foxnic.web.system.service.ICodeExampleMulitPkService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;

/**
 * <p>
 * 主键多字段测试表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-02-11 13:02:52
*/


@Service("SysCodeExampleMulitPkService")
public class CodeExampleMulitPkServiceImpl extends SuperService<CodeExampleMulitPk> implements ICodeExampleMulitPkService {

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
	 * @param codeExampleMulitPk  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(CodeExampleMulitPk codeExampleMulitPk,boolean throwsException) {
		Result r=super.insert(codeExampleMulitPk,throwsException);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param codeExampleMulitPk 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(CodeExampleMulitPk codeExampleMulitPk) {
		return this.insert(codeExampleMulitPk,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param codeExampleMulitPkList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<CodeExampleMulitPk> codeExampleMulitPkList) {
		return super.insertList(codeExampleMulitPkList);
	}

	
	/**
	 * 按主键删除 主键多字段测试
	 *
	 * @param nid 主键1
	 * @param day 主键2
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(Long nid , Date day) {
		CodeExampleMulitPk codeExampleMulitPk = new CodeExampleMulitPk();
		if(nid==null) return ErrorDesc.failure().message("nid 不允许为 null 。");
		if(day==null) return ErrorDesc.failure().message("day 不允许为 null 。");
		codeExampleMulitPk.setNid(nid);
		codeExampleMulitPk.setDay(day);
		try {
			boolean suc = dao.deleteEntity(codeExampleMulitPk);
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
	 * @param codeExampleMulitPk 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(CodeExampleMulitPk codeExampleMulitPk , SaveMode mode) {
		return this.update(codeExampleMulitPk,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param codeExampleMulitPk 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(CodeExampleMulitPk codeExampleMulitPk , SaveMode mode,boolean throwsException) {
		Result r=super.update(codeExampleMulitPk , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param codeExampleMulitPkList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<CodeExampleMulitPk> codeExampleMulitPkList , SaveMode mode) {
		return super.updateList(codeExampleMulitPkList , mode);
	}

	
	/**
	 * 按主键更新字段 主键多字段测试
	 *
	 * @param nid 主键1
	 * @param day 主键2
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , Long nid , Date day) {
		if(nid==null) throw new IllegalArgumentException("nid 不允许为 null ");
		if(day==null) throw new IllegalArgumentException("day 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("day = ? ",nid , day).top().execute();
		return suc>0;
	}

	
	/**
	 * 按主键获取 主键多字段测试
	 *
	 * @param nid 主键1
	 * @param day 主键2
	 * @return CodeExampleMulitPk 数据对象
	 */
	public CodeExampleMulitPk getById(Long nid , Date day) {
		CodeExampleMulitPk sample = new CodeExampleMulitPk();
		if(nid==null) throw new IllegalArgumentException("nid 不允许为 null ");
		if(day==null) throw new IllegalArgumentException("day 不允许为 null ");
		sample.setNid(nid);
		sample.setDay(day);
		return dao.queryEntity(sample);
	}




	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<CodeExampleMulitPk> queryList(CodeExampleMulitPk sample) {
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
	public PagedList<CodeExampleMulitPk> queryPagedList(CodeExampleMulitPk sample, int pageSize, int pageIndex) {
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
	public PagedList<CodeExampleMulitPk> queryPagedList(CodeExampleMulitPk sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param codeExampleMulitPk 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(CodeExampleMulitPk codeExampleMulitPk) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(codeExampleMulitPk, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(CodeExampleMulitPk sample) {
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


}