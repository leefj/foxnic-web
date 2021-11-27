package org.github.foxnic.web.system.service.impl;


import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_USER_TENANT;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.system.Tenant;
import org.github.foxnic.web.domain.system.UserTenant;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.system.service.IUserTenantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 账户租户关系表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-26 12:47:30
 * @version
*/


@Service("SysUserTenantService")
public class UserTenantServiceImpl extends SuperService<UserTenant> implements IUserTenantService {
	
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
	 * @param userTenant 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(UserTenant userTenant) {
		Result r=super.insert(userTenant);
		if(r.success()) {
			this.deactiveOthers(userTenant);
		}
		return r;
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param userTenantList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<UserTenant> userTenantList) {
		return super.insertList(userTenantList);
	}
	
	
	/**
	 * 按主键删除 账户租户关系
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		UserTenant userTenant = new UserTenant();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		userTenant.setId(id);
		try {
			boolean suc = dao.deleteEntity(userTenant);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 账户租户关系
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		UserTenant userTenant = new UserTenant();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		userTenant.setId(id);
		userTenant.setDeleted(dao.getDBTreaty().getTrueValue());
		userTenant.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		userTenant.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(userTenant,SaveMode.NOT_NULL_FIELDS);
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
	 * @param userTenant 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(UserTenant userTenant , SaveMode mode) {
		Result r=super.update(userTenant , mode);
		if(r.success()) {
			this.deactiveOthers(userTenant);
		}
		return r;
	}
	
	/**
	 * 更新实体集，事务内
	 * @param userTenantList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<UserTenant> userTenantList , SaveMode mode) {
		return super.updateList(userTenantList , mode);
	}
	
	
	/**
	 * 按主键更新字段 账户租户关系
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
	 * 按主键获取 账户租户关系
	 *
	 * @param id 主键
	 * @return UserTenant 数据对象
	 */
	public UserTenant getById(String id) {
		UserTenant sample = new UserTenant();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<UserTenant> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<UserTenant> queryList(UserTenant sample) {
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
	public PagedList<UserTenant> queryPagedList(UserTenant sample, int pageSize, int pageIndex) {
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
	public PagedList<UserTenant> queryPagedList(UserTenant sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param userTenant 数据对象
	 * @return 判断结果
	 */
	public Result<UserTenant> checkExists(UserTenant userTenant) {
		boolean exists=this.checkExists(userTenant, SYS_USER_TENANT.USER_ID,SYS_USER_TENANT.OWNER_TENANT_ID);
		if(exists) {
			return ErrorDesc.failure(CommonError.DATA_REPETITION);
		} else {
			return ErrorDesc.success();
		}
	}

	private void deactiveOthers(UserTenant userTenant) {
		userTenant=this.getById(userTenant.getId());
		if(userTenant.getActivated()==0) {
			//暂不处理
		} else {
			dao().update(table()).set(SYS_USER_TENANT.ACTIVATED, 0)
					.where("id!=?", userTenant.getId()).and("user_id=?", userTenant.getUserId())
					.top().execute();
		}
	}

	@Override
	public ExcelWriter exportExcel(UserTenant sample) {
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
     * @param userId 用户ID
     * @param ownerTenantIds 所属的租户ID清单
     */
	public void saveRelation(String userId,List<String> ownerTenantIds) {
		super.saveRelation(User.class,SYS_USER_TENANT.USER_ID,userId,Tenant.class,SYS_USER_TENANT.OWNER_TENANT_ID,ownerTenantIds,true);
	}

}