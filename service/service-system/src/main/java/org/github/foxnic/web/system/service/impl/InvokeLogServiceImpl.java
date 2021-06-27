package org.github.foxnic.web.system.service.impl;


import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.github.foxnic.web.domain.system.InvokeLog;
import org.github.foxnic.web.domain.system.InvokeLogVO;
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
import org.github.foxnic.web.system.service.IInvokeLogService;
import org.github.foxnic.web.framework.dao.DBConfigs;

/**
 * <p>
 * 调用统计日志 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-26 10:48:09
*/


@Service("SysInvokeLogService")
public class InvokeLogServiceImpl extends SuperService<InvokeLog> implements IInvokeLogService {
	
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
	 * 插入实体
	 * @param invokeLog 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public boolean insert(InvokeLog invokeLog) {
		return super.insert(invokeLog);
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param invokeLogList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public boolean insertList(List<InvokeLog> invokeLogList) {
		return super.insertList(invokeLogList);
	}
	
	
	/**
	 * 按主键删除 调用统计日志
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public boolean deleteByIdPhysical(Long id) {
		InvokeLog invokeLog = new InvokeLog();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		invokeLog.setId(id);
		return dao.deleteEntity(invokeLog);
	}
	
	/**
	 * 更新实体
	 * @param invokeLog 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public boolean update(InvokeLog invokeLog , SaveMode mode) {
		return super.update(invokeLog , mode);
	}
	
	/**
	 * 更新实体集，事务内
	 * @param invokeLogList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public boolean updateList(List<InvokeLog> invokeLogList , SaveMode mode) {
		return super.updateList(invokeLogList , mode);
	}
	
	
	/**
	 * 按主键更新字段 调用统计日志
	 *
	 * @param id ID
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , Long id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	} 
	
	
	/**
	 * 按主键获取 调用统计日志
	 *
	 * @param id ID
	 * @return InvokeLog 数据对象
	 */
	public InvokeLog getById(Long id) {
		InvokeLog sample = new InvokeLog();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}
 
	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<InvokeLog> queryList(InvokeLog sample) {
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
	public PagedList<InvokeLog> queryPagedList(InvokeLog sample, int pageSize, int pageIndex) {
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
	public PagedList<InvokeLog> queryPagedList(InvokeLog sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param invokeLog 数据对象
	 * @return 判断结果
	 */
	public Result<InvokeLog> checkExists(InvokeLog invokeLog) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(invokeLog, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(InvokeLog sample) {
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