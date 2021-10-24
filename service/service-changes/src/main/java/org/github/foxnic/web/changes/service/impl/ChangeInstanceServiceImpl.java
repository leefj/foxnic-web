package org.github.foxnic.web.changes.service.impl;


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
import org.github.foxnic.web.changes.service.*;
import org.github.foxnic.web.changes.service.approval.BpmApproval;
import org.github.foxnic.web.changes.service.approval.SimpleApproval;
import org.github.foxnic.web.constants.enums.changes.ApprovalMode;
import org.github.foxnic.web.domain.changes.*;
import org.github.foxnic.web.framework.cache.RedisUtil;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 变更实例表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-29 10:50:33
 * @version
*/


@Service("ChsChangeInstanceService")
public class ChangeInstanceServiceImpl extends SuperService<ChangeInstance> implements IChangeInstanceService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }

	@Autowired
	private IChangeDefinitionService definitionService;


	@Autowired
	private SimpleApproval simpleApproval;

	@Autowired
	private BpmApproval bpmApproval;

	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}


	@Autowired
	private  RedisUtil redis;

	/**
	 * 插入实体
	 * @param changeInstance 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(ChangeInstance changeInstance) {
		Result r=super.insert(changeInstance);
		return r;
	}

	/**
	 * 批量插入实体，事务内
	 * @param changeInstanceList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<ChangeInstance> changeInstanceList) {
		return super.insertList(changeInstanceList);
	}


	/**
	 * 按主键删除 变更实例
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		ChangeInstance changeInstance = new ChangeInstance();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		changeInstance.setId(id);
		try {
			boolean suc = dao.deleteEntity(changeInstance);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 按主键删除 变更实例
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		ChangeInstance changeInstance = new ChangeInstance();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		changeInstance.setId(id);
		changeInstance.setDeleted(dao.getDBTreaty().getTrueValue());
		changeInstance.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		changeInstance.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(changeInstance,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 更新实体
	 * @param changeInstance 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(ChangeInstance changeInstance , SaveMode mode) {
		Result r=super.update(changeInstance , mode);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param changeInstanceList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<ChangeInstance> changeInstanceList , SaveMode mode) {
		return super.updateList(changeInstanceList , mode);
	}


	/**
	 * 按主键更新字段 变更实例
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
	 * 按主键获取 变更实例
	 *
	 * @param id 主键
	 * @return ChangeInstance 数据对象
	 */
	public ChangeInstance getById(String id) {
		ChangeInstance sample = new ChangeInstance();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<ChangeInstance> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<ChangeInstance> queryList(ChangeInstance sample) {
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
	public PagedList<ChangeInstance> queryPagedList(ChangeInstance sample, int pageSize, int pageIndex) {
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
	public PagedList<ChangeInstance> queryPagedList(ChangeInstance sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param changeInstance 数据对象
	 * @return 判断结果
	 */
	public Result<ChangeInstance> checkExists(ChangeInstance changeInstance) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(changeInstance, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(ChangeInstance sample) {
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

	/**
	 * 发起变更请求
	 * */
	@Override
	public Result<ChangeEvent> request(ChangeRequestBody request) {
		Result<ChangeEvent> result=new Result<>();

		//基本的校验
		if(StringUtil.isBlank(request.getApproverId()) || StringUtil.isBlank(request.getApproverName())) {
			result.success(false).message("未指定当前审批人");
			return result;
		}
		//获得变更定义
		ChangeDefinition definition=definitionService.getByCode(request.getChangeDefinitionCode());
		// 校验变更定义
		if(definition==null) {
			result.success(false).message("变更 "+request.getChangeDefinitionCode()+" 未定义");
			return result;
		}
		if(definition.getValid()==0) {
			result.success(false).message("变更 "+request.getChangeDefinitionCode()+" 未启用");
			return result;
		}
		//不同的模式调用不同的对象执行审批逻辑
		if(definition.getModeEnum()==ApprovalMode.simple) {
			return simpleApproval.request(request,definition);
		} else if(definition.getModeEnum()==ApprovalMode.bpm) {
			return bpmApproval.request(request,definition);
		} else {
			result.success(false).message("不支持的审批模式");
			return result;
		}

	}

	@Override
	public Result<ChangeEvent> approve(ChangeApproveBody request) {

		Result<ChangeEvent> result=new Result<>();
		//基本的校验
		ChangeInstance instance=this.getById(request.getChangeInstanceId());
		if(instance==null) {
			return result.success(false).message("流程实例不存在");
		}
		//获得变更定义
		ChangeDefinition definition=definitionService.getByCode(request.getChangeDefinitionCode());
		// 校验变更定义
		if(definition==null) {
			result.success(false).message("变更 "+request.getChangeDefinitionCode()+" 未定义");
			return result;
		}
		if(definition.getValid()==0) {
			result.success(false).message("变更 "+request.getChangeDefinitionCode()+" 未启用");
			return result;
		}
		//不同的模式调用不同的对象执行审批逻辑
		if(definition.getModeEnum()==ApprovalMode.simple) {
			return simpleApproval.approve(request,definition,instance);
		} else if(definition.getModeEnum()==ApprovalMode.bpm) {
			return bpmApproval.approve(request,definition,instance);
		} else {
			result.success(false).message("不支持的审批模式");
			return result;
		}

	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}
