package org.github.foxnic.web.oauth.service.impl;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.concurrent.task.SimpleTaskManager;
import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.commons.network.Machine;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.spring.SpringUtil;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.parameter.BatchParamBuilder;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.domain.oauth.SessionOnline;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.framework.starter.StartupRegister;
import org.github.foxnic.web.oauth.service.ISessionOnlineService;
import org.github.foxnic.web.oauth.session.SessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.util.*;

/**
 * <p>
 * 在线会话表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-01 09:27:28
*/


@Service("SysSessionOnlineService")
public class SessionOnlineServiceImpl extends SuperService<SessionOnline> implements ISessionOnlineService, ApplicationListener<ApplicationStartedEvent> {

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
	 * @param sessionOnline 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(SessionOnline sessionOnline) {
		return super.insert(sessionOnline);
	}

	/**
	 * 批量插入实体，事务内
	 * @param sessionOnlineList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<SessionOnline> sessionOnlineList) {
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
		sessionOnline.setDeleted(true);
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
	public Result update(SessionOnline sessionOnline , SaveMode mode) {
		return super.update(sessionOnline , mode);
	}

	/**
	 * 更新实体集，事务内
	 * @param sessionOnlineList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<SessionOnline> sessionOnlineList , SaveMode mode) {
		return super.updateList(sessionOnlineList , mode);
	}

	@Override
	public <T> Map<T, ReferCause> hasRefers(List<T> ids) {
		// 默认无业务逻辑，返回此行；有业务逻辑需要校验时，请修改并使用已注释的行代码！！！
		return MapUtil.asMap(ids,new ReferCause(false));
		// return super.hasRefers(FoxnicWeb.BPM_PROCESS_INSTANCE.FORM_DEFINITION_ID,ids);
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

	private SimpleTaskManager tm=new SimpleTaskManager(2,"session-interactive");
	private LocalCache<String, Object[]>  interactiveInfo=new LocalCache<>();
	public  void  interactive(String onlineId,HttpServletRequest request) {
		String uri=request.getRequestURI().toString();
		interactiveInfo.put(onlineId,new Object[]{uri,new Date()});
		if(interactiveInfo.size()>512) {
			doSessionJob();
		}
	}

	private void doSessionJob() {
		this.dao().pausePrintThreadSQL();
		//记录交互，如果有交互，记录交互，并标记在线
		Set<String> keys=interactiveInfo.keys();
		Object[] value=null;
		BatchParamBuilder pb=new BatchParamBuilder();
		Set<String> keysWillRemove=new HashSet<>();
		for (String key : keys) {
			value=interactiveInfo.get(key);
			keysWillRemove.add(key);
			pb.add(value[0],value[1],key);
		}
		interactiveInfo.removeAll(keysWillRemove);
		dao.batchExecute("update "+ FoxnicWeb.SYS_SESSION_ONLINE.$NAME+" set "+FoxnicWeb.SYS_SESSION_ONLINE.INTERACT_URL+"=?,"+ FoxnicWeb.SYS_SESSION_ONLINE.INTERACT_TIME+"=?,"+FoxnicWeb.SYS_SESSION_ONLINE.ONLINE+"=1,"+FoxnicWeb.SYS_SESSION_ONLINE.LOGOUT_TIME+"=null  where id=?", pb.getBatchList());
		//
		dao.execute("update "+ FoxnicWeb.SYS_SESSION_ONLINE.$NAME+" set "+FoxnicWeb.SYS_SESSION_ONLINE.ONLINE+"=0,"+FoxnicWeb.SYS_SESSION_ONLINE.LOGOUT_TIME+"="+FoxnicWeb.SYS_SESSION_ONLINE.INTERACT_TIME+" where online=1 and interact_time<?",DateUtil.addMinutes(new Date(),-5));
		this.dao().resumePrintThreadSQL();
	}

	@Override
	public void offline(String onlineSessionId,HttpSession session) {

		if(session!=null) {
			SessionContext.remove(session.getId());
		}

		dao.pausePrintThreadSQL();
		if(onlineSessionId!=null) {
			dao.execute("update " + this.table() + " set online=0 , logout_time=? where id=?", new Date(),onlineSessionId);
		} else {
			dao.execute("update " + this.table() + " set online=0 , logout_time=? where session_id=?", new Date(),session.getId());
		}

	}

	@Override
	public void onlineAnon(HttpSession session) {

		SessionOnline sessionOnline  = new SessionOnline();
		sessionOnline.setId(session.getId()).setSessionId(session.getId()).setOnline(1).setSessionTime(session.getMaxInactiveInterval());
		sessionOnline.setHostId(Machine.getIdentity());
		sessionOnline.setNodeId(SpringUtil.getNodeInstanceId());
		this.insert(sessionOnline);



	}

	@Override
	public void changeSessionId(String oldSessionId, HttpSession session) {

		SessionContext.changeSessionId(oldSessionId,session);

		SessionOnline sessionOnline=this.getById(SessionContext.getCurrentOnlineSessionId());
		if(sessionOnline==null) {
			throw new RuntimeException("缺少会话记录");
		}
		sessionOnline.setSessionId(session.getId());
		this.updateDirtyFields(sessionOnline);

	}

	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		tm.doIntervalTask(new Runnable() {
			@Override
			public void run() {
				doSessionJob();
			}
		}, StartupRegister.HEART_BEAT_INTERVAL);
	}

}
