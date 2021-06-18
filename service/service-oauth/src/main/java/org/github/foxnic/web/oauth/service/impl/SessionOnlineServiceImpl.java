package org.github.foxnic.web.oauth.service.impl;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.github.foxnic.springboot.mvc.Result;
import org.github.foxnic.web.oauth.login.SessionCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;


import org.github.foxnic.web.domain.oauth.SessionOnline;
import org.github.foxnic.web.oauth.service.ISessionOnlineService;
import org.github.foxnic.web.framework.dao.DBConfigs;

/**
 * <p>
 * 在线会话表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-01 09:27:28
*/


@Service("SysSessionOnlineService")
public class SessionOnlineServiceImpl extends SuperService<SessionOnline> implements ISessionOnlineService {
	
	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;


	@Autowired
	private SessionCache sessionCache;
	
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
	 * @param sessionOnline 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public boolean insert(SessionOnline sessionOnline) {
		return super.insert(sessionOnline);
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param sessionOnlineList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public boolean insertList(List<SessionOnline> sessionOnlineList) {
		return super.insertList(sessionOnlineList);
	}
	
	
	/**
	 * 按主键删除 在线会话
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public boolean deleteByIdPhysical(String id) {
		SessionOnline sessionOnline = new SessionOnline();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sessionOnline.setId(id);
		return dao.deleteEntity(sessionOnline);
	}
	
	/**
	 * 按主键删除 在线会话
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public boolean deleteByIdLogical(String id) {
		SessionOnline sessionOnline = new SessionOnline();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sessionOnline.setId(id);
		sessionOnline.setDeleted(dao.getDBTreaty().getTrueValue());
		sessionOnline.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		sessionOnline.setDeleteTime(new Date());
		return dao.updateEntity(sessionOnline,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 更新实体
	 * @param sessionOnline 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public boolean update(SessionOnline sessionOnline , SaveMode mode) {
		return super.update(sessionOnline , mode);
	}
	
	/**
	 * 更新实体集，事务内
	 * @param sessionOnlineList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public boolean updateList(List<SessionOnline> sessionOnlineList , SaveMode mode) {
		return super.updateList(sessionOnlineList , mode);
	}
	
	
	/**
	 * 按主键更新字段 在线会话
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
	 * 按主键获取 在线会话
	 *
	 * @param id ID
	 * @return SessionOnline 数据对象
	 */
	public SessionOnline getById(String id) {
		SessionOnline sample = new SessionOnline();
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
	public List<SessionOnline> queryList(SessionOnline sample) {
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
	public PagedList<SessionOnline> queryPagedList(SessionOnline sample, int pageSize, int pageIndex) {
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
	public PagedList<SessionOnline> queryPagedList(SessionOnline sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param role 数据对象
	 * @return 判断结果
	 */
	public Result<SessionOnline> checkExists(SessionOnline role) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(role, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public void offline(String sessionId) {
		dao.setPrintThreadSQL(false);
		dao.execute("update "+this.table()+" set online=0 , logout_time=now() where session_id=?",sessionId);
		sessionCache.remove(sessionId);
	}

}