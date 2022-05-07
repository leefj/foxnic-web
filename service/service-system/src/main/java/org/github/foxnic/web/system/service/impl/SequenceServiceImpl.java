package org.github.foxnic.web.system.service.impl;


import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.domain.system.Sequence;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.system.service.ISequenceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 序列表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-11 16:08:44
 * @version
*/


@Service("SysSequenceService")
public class SequenceServiceImpl extends SuperService<Sequence> implements ISequenceService {

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
	 * @param sequence 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Sequence sequence) {
		Result r=super.insert(sequence);
		return r;
	}

	/**
	 * 批量插入实体，事务内
	 * @param sequenceList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Sequence> sequenceList) {
		return super.insertList(sequenceList);
	}


	/**
	 * 按主键删除 序列
	 *
	 * @param pk 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String pk) {

		if(pk==null) return ErrorDesc.failure().message("pk 不允许为 null 。");
		Sequence sequence = this.getById(pk);
		Integer max=this.dao().queryInteger("select max(value) from "+table()+" where id=?",sequence.getId());
		String seq=sequence.getId();
		if(!StringUtil.isBlank(sequence.getName())){
			seq+="("+sequence.getName()+")";
		}
		if(max!=null && max>0) {
			return ErrorDesc.failure().message("删除["+seq+"]序列不安全，若确实要删除，请联系开发人员从数据库表删除!");
		}
		try {
			int suc = this.dao().execute("delete from "+table()+" where id=?",sequence.getId());
			return suc>0?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	public <T> Result deleteByIdsLogical(List<T> ids) {
		Result result=new Result();
		Result r;
		for (T id : ids) {
			r=deleteByIdPhysical((String)id);
			if(r.failure()) {
				result.addError(r);
			}
		}
		return result;
	}

	/**
	 * 更新实体
	 * @param sequence 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Sequence sequence , SaveMode mode) {
		Result r=super.update(sequence , mode);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param sequenceList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Sequence> sequenceList , SaveMode mode) {
		return super.updateList(sequenceList , mode);
	}


	/**
	 * 按主键更新字段 序列
	 *
	 * @param pk 主键
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String pk) {
		if(pk==null) throw new IllegalArgumentException("pk 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("pk = ? ",pk).top().execute();
		return suc>0;
	}


	/**
	 * 按主键获取 序列
	 *
	 * @param pk 主键
	 * @return Sequence 数据对象
	 */
	public Sequence getById(String pk) {
		Sequence sample = new Sequence();
		if(pk==null) throw new IllegalArgumentException("pk 不允许为 null ");
		sample.setPk(pk);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Sequence> getByIds(List<String> pks) {
		return super.queryListByUKeys(pks);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Sequence> queryList(Sequence sample) {
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
	public PagedList<Sequence> queryPagedList(Sequence sample, int pageSize, int pageIndex) {
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
	public PagedList<Sequence> queryPagedList(Sequence sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param sequence 数据对象
	 * @return 判断结果
	 */
	public Result<Sequence> checkExists(Sequence sequence) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(sequence, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(Sequence sample) {
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
