package org.github.foxnic.web.system.service.impl;


import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.domain.bpm.ProcessDefinition;
import org.github.foxnic.web.domain.system.Profile;
import org.github.foxnic.web.domain.system.ProfileVO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.system.service.IConfigService;
import org.github.foxnic.web.system.service.IProfileService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-03 13:54:38
 * @version
*/


@Service("SysProfileService")
@Primary
public class ProfileServiceImpl extends SuperService<Profile> implements IProfileService {

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
	 * @param profile  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(Profile profile,boolean throwsException) {
		Result r=super.insert(profile,throwsException);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param profile 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Profile profile) {
		return this.insert(profile,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param profileList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Profile> profileList) {
		return super.insertList(profileList);
	}


	/**
	 * 按主键删除 sys_profile
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Profile profile = new Profile();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		profile.setId(id);
		if(IConfigService.DEFAULT_PROFILE_ID.equals(id)) {
			return ErrorDesc.failure().message("不允许删除默认的 Profile");
		}
		try {
			boolean suc = dao.deleteEntity(profile);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	@Override
	public Result deleteByIdLogical(String id) {
		Profile profile = new Profile();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		profile.setId(id);
		profile.setDeleted(true);
		profile.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		profile.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(profile,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		} catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 更新，如果执行错误，则抛出异常
	 * @param profile 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Profile profile , SaveMode mode) {
		return this.update(profile,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param profile 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Profile profile , SaveMode mode,boolean throwsException) {
		Result r=super.update(profile , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param profileList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Profile> profileList , SaveMode mode) {
		return super.updateList(profileList , mode);
	}


	/**
	 * 按主键更新字段 sys_profile
	 *
	 * @param id ID
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	}


	/**
	 * 按主键获取 sys_profile
	 *
	 * @param id ID
	 * @return Profile 数据对象
	 */
	public Profile getById(String id) {
		Profile sample = new Profile();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}


	@Override
	public List<Profile> queryListByIds(List<String> ids) {
		return null;
	}

	@Override
	public Map<String, Profile> queryMapByIds(List<String> ids) {
		return null;
	}

	@Override
	public List<Profile> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Profile> queryList(Profile sample) {
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
	public PagedList<Profile> queryPagedList(Profile sample, int pageSize, int pageIndex) {
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
	public PagedList<Profile> queryPagedList(Profile sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param profile 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(Profile profile) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(profile, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public List<Profile> queryList(ProfileVO sample) {
		return super.queryList(sample);
	}

	@Override
	public PagedList<Profile> queryPagedList(ProfileVO sample, int pageSize, int pageIndex) {
		return super.queryPagedList(sample,pageSize,pageIndex);
	}

	@Override
	public ExcelWriter exportExcel(Profile sample) {
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
	public <T> Map<T, ReferCause> hasRefers(List<T> ids) {
		// 默认无业务逻辑，返回此行；有业务逻辑需要校验时，请修改并使用已注释的行代码！！！
		return MapUtil.asMap(ids,new ReferCause(false));
		// return super.hasRefers(FoxnicWeb.BPM_PROCESS_INSTANCE.FORM_DEFINITION_ID,ids);
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}
