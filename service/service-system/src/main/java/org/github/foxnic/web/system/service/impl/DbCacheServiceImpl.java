package org.github.foxnic.web.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.foxnic.api.cache.Cached;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.domain.system.DbCache;
import org.github.foxnic.web.domain.system.DbCacheVO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.session.SessionUser;
import org.github.foxnic.web.system.service.IDbCacheService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 数据库缓存表，内存表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-18 13:12:07
 * @version
*/


@Service("SysDbCacheService")
public class DbCacheServiceImpl extends SuperService<DbCache> implements IDbCacheService {

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


	private DbCacheVO processVO(DbCacheVO dbCacheVO) {
		SessionUser user=SessionUser.getCurrent();
		if("user".equalsIgnoreCase(dbCacheVO.getOwnerType())) {
			if(user!=null) {
				dbCacheVO.setOwnerId(user.getUserId());
			}
		} else if("session".equalsIgnoreCase(dbCacheVO.getOwnerType())) {
			if(user!=null) {
				dbCacheVO.setOwnerId(user.getSessionOnlineId());
			}
		}

		if(dbCacheVO.getSeconds()!=null) {
			Date expire= DateUtil.addSeconds(new Date(),dbCacheVO.getSeconds());
			dbCacheVO.setExpireTime(expire);
		}

		return dbCacheVO;
	}

	/**
	 * 插入实体
	 * @param dbCache 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(DbCache dbCache) {

		if(dbCache instanceof  DbCacheVO) {
			dbCache=processVO((DbCacheVO) dbCache);
		}
		return super.insert(dbCache);
	}

	/**
	 * 批量插入实体，事务内
	 * @param dbCacheList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<DbCache> dbCacheList) {
		return super.insertList(dbCacheList);
	}


	/**
	 * 按主键删除 数据库缓存
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public boolean deleteByIdPhysical(String id) {
		DbCache dbCache = new DbCache();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		dbCache.setId(id);
		return dao.deleteEntity(dbCache);
	}

	/**
	 * 按主键删除 数据库缓存
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		DbCache dbCache = new DbCache();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		dbCache.setId(id);
		dbCache.setDeleted(dao.getDBTreaty().getTrueValue());
		dbCache.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		dbCache.setDeleteTime(new Date());
		boolean suc= dao.updateEntity(dbCache,SaveMode.NOT_NULL_FIELDS);
		return suc?ErrorDesc.success():ErrorDesc.failure();
	}

	/**
	 * 更新实体
	 * @param dbCache 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(DbCache dbCache , SaveMode mode) {
		if(dbCache instanceof  DbCacheVO) {
			dbCache=processVO((DbCacheVO) dbCache);
		}
		return super.update(dbCache , mode);
	}

	@Override
	public Result save(DbCache dbCache, SaveMode mode) {
		if(dbCache instanceof  DbCacheVO) {
			dbCache=processVO((DbCacheVO) dbCache);
		}
		DbCache sample=new DbCache();
		sample.setCatalog(dbCache.getCatalog());
		sample.setArea(dbCache.getArea());
		sample.setOwnerType(dbCache.getOwnerType());
		if("user".equalsIgnoreCase(dbCache.getOwnerType())) {
			sample.setOwnerId(SessionUser.getCurrent().getUserId());
		}
		Result r=null;
		DbCache ex=this.queryEntity(sample);
		if(ex!=null) {
			ex.setValue(dbCache.getValue());
			r=super.update(ex, mode);
		} else {
			r=this.insert(dbCache);
		}

		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param dbCacheList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<DbCache> dbCacheList , SaveMode mode) {
		for (DbCache dbCache : dbCacheList) {
			if(dbCache instanceof  DbCacheVO) {
				processVO((DbCacheVO) dbCache);
			}
		}
		return super.updateList(dbCacheList , mode);
	}


	/**
	 * 按主键更新字段 数据库缓存
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
	 * 按主键获取 数据库缓存
	 *
	 * @param id ID
	 * @return DbCache 数据对象
	 */
	public DbCache getById(String id) {
		DbCache sample = new DbCache();
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
	@Cached({"query-list-1","query-list-2"})
	public List<DbCache> queryList(DbCache sample) {
		System.out.println(JSON.toJSONString(sample));
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
	public PagedList<DbCache> queryPagedList(DbCache sample, int pageSize, int pageIndex) {
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
	public PagedList<DbCache> queryPagedList(DbCache sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param dbCache 数据对象
	 * @return 判断结果
	 */
	public Result<DbCache> checkExists(DbCache dbCache) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(dbCache, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(DbCache sample) {
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
