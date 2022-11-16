package org.github.foxnic.web.oauth.service.impl;


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
import com.github.foxnic.dao.relation.cache.CacheInvalidEventType;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.MenuResource;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.oauth.service.IMenuResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-29 10:51:09
*/


@Service("SysMenuResourceService")
public class MenuResourceServiceImpl extends SuperService<MenuResource> implements IMenuResourceService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;

	@Autowired
	private ResourzeServiceImpl resourzeService;

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
	 * @param menuResource 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(MenuResource menuResource) {
		return super.insert(menuResource);
	}

	/**
	 * 批量插入实体，事务内
	 * @param menuResourceList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<MenuResource> menuResourceList) {
		return super.insertList(menuResourceList);
	}


	/**
	 * 按主键删除 sys_menu_resource
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public boolean deleteByIdPhysical(String id) {
		MenuResource menuResource = new MenuResource();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		menuResource.setId(id);
		return dao.deleteEntity(menuResource);
	}

	/**
	 * 按主键删除 sys_menu_resource
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public boolean deleteByIdLogical(String id) {
		MenuResource menuResource = new MenuResource();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		menuResource.setId(id);
		menuResource.setDeleted(true);
		menuResource.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		menuResource.setDeleteTime(new Date());
		return dao.updateEntity(menuResource,SaveMode.NOT_NULL_FIELDS);
	}

	/**
	 * 更新实体
	 * @param menuResource 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(MenuResource menuResource , SaveMode mode) {
		return super.update(menuResource , mode);
	}

	/**
	 * 更新实体集，事务内
	 * @param menuResourceList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<MenuResource> menuResourceList , SaveMode mode) {
		return super.updateList(menuResourceList , mode);
	}


	/**
	 * 按主键更新字段 sys_menu_resource
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
	 * 按主键获取 sys_menu_resource
	 *
	 * @param id ID
	 * @return MenuResource 数据对象
	 */
	public MenuResource getById(String id) {
		MenuResource sample = new MenuResource();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<MenuResource> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<MenuResource> queryList(MenuResource sample) {
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
	public PagedList<MenuResource> queryPagedList(MenuResource sample, int pageSize, int pageIndex) {
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
	public PagedList<MenuResource> queryPagedList(MenuResource sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param menuResource 数据对象
	 * @return 判断结果
	 */
	public Result<MenuResource> checkExists(MenuResource menuResource) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(menuResource, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(MenuResource sample) {
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
	public void saveResourceIds(Menu menu) {
		if(menu.getResourceIds()!=null) {
			List<MenuResource> valuesBefore=null;
			if(this.isSupportCache()) {
				valuesBefore=dao().queryEntities(MenuResource.class,"select * from "+table()+" where menu_id=?",menu.getId());
			}
			dao().execute("delete from "+table()+" where menu_id=?",menu.getId());
			List<MenuResource> valuesAfter=new ArrayList<>();
			for (String resourceId : menu.getResourceIds()) {
				MenuResource mr=new MenuResource();
				mr.setMenuId(menu.getId()).setResourceId(resourceId);
				this.insert(mr);
				valuesAfter.add(mr);
			}

 			if(this.isSupportCache()) {
				this.dispatchJoinCacheInvalidEvent(CacheInvalidEventType.UPDATE, valuesBefore, valuesAfter);
			}

		}
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}

}
