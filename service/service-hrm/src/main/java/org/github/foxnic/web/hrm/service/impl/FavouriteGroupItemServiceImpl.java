package org.github.foxnic.web.hrm.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.CollectorUtil;
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
import com.github.foxnic.sql.parameter.BatchParamBuilder;
import org.github.foxnic.web.constants.enums.hrm.FavouriteItemType;
import org.github.foxnic.web.domain.bpm.Role;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.FavouriteGroupItem;
import org.github.foxnic.web.domain.hrm.FavouriteGroupItemVO;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.hrm.service.IEmployeeService;
import org.github.foxnic.web.hrm.service.IFavouriteGroupItemService;
import org.github.foxnic.web.hrm.service.IPositionService;
import org.github.foxnic.web.proxy.bpm.RoleServiceProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * <p>
 * 常用人员分组条目表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-20 06:14:04
 * @version
*/


@Service("HrmFavouriteGroupItemService")
public class FavouriteGroupItemServiceImpl extends SuperService<FavouriteGroupItem> implements IFavouriteGroupItemService {

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
	private IEmployeeService employeeService;

	@Autowired
	private IPositionService positionService;


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 插入实体
	 * @param favouriteGroupItem 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(FavouriteGroupItem favouriteGroupItem) {
		Result r=super.insert(favouriteGroupItem);
		return r;
	}

	/**
	 * 批量插入实体，事务内
	 * @param favouriteGroupItemList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<FavouriteGroupItem> favouriteGroupItemList) {
		return super.insertList(favouriteGroupItemList);
	}


	/**
	 * 按主键删除 常用人员分组条目
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		FavouriteGroupItem favouriteGroupItem = new FavouriteGroupItem();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		favouriteGroupItem.setId(id);
		try {
			boolean suc = dao.deleteEntity(favouriteGroupItem);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 按主键删除 常用人员分组条目
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		FavouriteGroupItem favouriteGroupItem = new FavouriteGroupItem();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		favouriteGroupItem.setId(id);
		favouriteGroupItem.setDeleted(dao.getDBTreaty().getTrueValue());
		favouriteGroupItem.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		favouriteGroupItem.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(favouriteGroupItem,SaveMode.NOT_NULL_FIELDS);
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
	 * @param favouriteGroupItem 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(FavouriteGroupItem favouriteGroupItem , SaveMode mode) {
		Result r=super.update(favouriteGroupItem , mode);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param favouriteGroupItemList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<FavouriteGroupItem> favouriteGroupItemList , SaveMode mode) {
		return super.updateList(favouriteGroupItemList , mode);
	}


	/**
	 * 按主键更新字段 常用人员分组条目
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
	 * 按主键获取 常用人员分组条目
	 *
	 * @param id 主键
	 * @return FavouriteGroupItem 数据对象
	 */
	public FavouriteGroupItem getById(String id) {
		return null;
	}

	@Override
	public JSONObject translate(String info) {
		//转换成对象列表
		JSONObject map=JSONObject.parseObject(info);
		List<FavouriteGroupItem> allItems=new ArrayList<>();
		Map<String,List<String>> elIdMap=new HashMap<>();
		for (String key : map.keySet()) {
			JSONArray arr=map.getJSONArray(key);
			List<String> ids=new ArrayList<>();
			elIdMap.put(key,ids);
			for (Object o : arr) {
				if(o instanceof String) {
					FavouriteGroupItem fii=new FavouriteGroupItem();
					fii.setTargetType(FavouriteItemType.employee.code());
					fii.setTargetId((String)o);
					allItems.add(fii);
					ids.add(fii.getTargetId());
				} else if(o instanceof JSONObject) {
					JSONObject jo=(JSONObject)o;
					FavouriteGroupItem fii=new FavouriteGroupItem();
					fii.setTargetType(FavouriteItemType.parseByCode(jo.getString("targetType")).code());
					fii.setTargetId(jo.getString("targetId"));
					allItems.add(fii);
					ids.add(fii.getTargetId());
				}
			}
		}
		//对象查询
		Map<String,String> names=translateNames(allItems);

		//结果汇总
		JSONObject result=new JSONObject();
		String name=null;
		for (Map.Entry<String, List<String>> e : elIdMap.entrySet()) {
			List<String> ids=e.getValue();
			List<String> idNames=new ArrayList<>();
			for (String id : ids) {
				name=names.get(id);
				if(name==null) name=id;
				idNames.add(name);
			}
			result.put(e.getKey(),idNames);
		}

		return result;
	}

	@Override
	public List<FavouriteGroupItem> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<FavouriteGroupItem> queryList(FavouriteGroupItem sample) {
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
	public PagedList<FavouriteGroupItem> queryPagedList(FavouriteGroupItem sample, int pageSize, int pageIndex) {
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
	public PagedList<FavouriteGroupItem> queryPagedList(FavouriteGroupItem sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param favouriteGroupItem 数据对象
	 * @return 判断结果
	 */
	public Result<FavouriteGroupItem> checkExists(FavouriteGroupItem favouriteGroupItem) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(favouriteGroupItem, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(FavouriteGroupItem sample) {
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
	public Result inserts(List<FavouriteGroupItemVO> list) {
		// 目前仅针对临时分组，后续改进
		String temporaryGroupId=SessionUser.getCurrent().getActivatedEmployeeId()+"-temporary";
		List<FavouriteGroupItem> exList=this.queryList(FavouriteGroupItem.create().setGroupId(temporaryGroupId));
		Map<String,FavouriteGroupItem> exMap= CollectorUtil.collectMap(exList,FavouriteGroupItem::getTargetId,itm->{return itm;});
		BatchParamBuilder pb=new BatchParamBuilder();
		for (FavouriteGroupItemVO item : list) {
			//如果已经存在，则不处理
			if(exMap.get(item.getTargetId())!=null) continue;
			if(item.getTemporary()==1){
				item.setGroupId(temporaryGroupId);
			}
//			item.setCompanyId(SessionUser.getCurrent().getActivatedCompanyId());
//			FavouriteGroupItem exItem=this.queryEntity(item);
//			if(exItem==null) {
//				this.insert(item);
//			}
			pb.add(IDGenerator.getSnowflakeIdString(),item.getTargetId(),item.getTargetType(),item.getTargetName(),item.getGroupId(),SessionUser.getCurrent().getActivatedEmployeeId(),
			item.getTemporary(),SessionUser.getCurrent().getActivatedCompanyId(),SessionUser.getCurrent().getActivatedTenantId()
					,SessionUser.getCurrent().getUserId(),new Date()
			);
		}
		if(pb.size()>0) {
			dao().batchExecute("INSERT INTO hrm_favourite_group_item " +
					"(id, target_id, target_type, target_name, group_id, employee_id, temporary, company_id, tenant_id, create_by, create_time, deleted,version) " +
					"VALUES (?,?,?,?,?,?,?,?,?,?,?,0,1)", pb.getBatchList());
		}
		return ErrorDesc.success();
	}

	@Override
	public Result removeAll(FavouriteGroupItemVO vo) {
		// 目前仅针对临时分组，后续改进
		String temporaryGroupId=SessionUser.getCurrent().getActivatedEmployeeId()+"-temporary";
		vo.setGroupId(temporaryGroupId);
		vo.setTargetId(SessionUser.getCurrent().getActivatedTenantId());
		this.dao().execute("delete from hrm_favourite_group_item where temporary=1 and group_id=? and tenant_id=?",temporaryGroupId,SessionUser.getCurrent().getActivatedTenantId());
		return ErrorDesc.success();
	}

	@Override
	@Transactional
	public void initEmployees(String initValue) {

		if(StringUtil.isBlank(initValue)) return;

		FavouriteGroupItemVO vo=new FavouriteGroupItemVO();
		vo.setTemporary(1);
		this.removeAll(vo);



//		List<Employee> emps=employeeService.getByIds(null);
//		employeeService.join(emps, EmployeeMeta.PERSON);
//		List<FavouriteGroupItemVO> items=new ArrayList<>();
//		for (Employee emp : emps) {
//			FavouriteGroupItemVO itm=new FavouriteGroupItemVO();
//			itm.setTemporary(1);
//			itm.setTargetId(emp.getId());
//			if(emp.getPerson()!=null) {
//				itm.setTargetName(emp.getPerson().getName());
//			} else {
//				itm.setTargetName(emp.getId());
//			}
//			itm.setTargetType(FavouriteItemType.employee.code());
//			items.add(itm);
//		}
//		this.inserts(items);


		//转换成对象列表
		JSONArray arr=JSONArray.parseArray(initValue);
		List<FavouriteGroupItem> allItems=new ArrayList<>();
		String temporaryGroupId=SessionUser.getCurrent().getActivatedEmployeeId()+"-temporary";
		for (Object o : arr) {
			if(o instanceof String) {
				FavouriteGroupItem fii=new FavouriteGroupItem();
				fii.setId(IDGenerator.getSnowflakeIdString());
				fii.setTargetType(FavouriteItemType.employee.code());
				fii.setTargetId((String)o);
				fii.setTemporary(1);
				fii.setGroupId(temporaryGroupId);
				allItems.add(fii);
			} else if(o instanceof JSONObject) {
				JSONObject jo=(JSONObject)o;
				FavouriteGroupItem fii=new FavouriteGroupItem();
				fii.setId(IDGenerator.getSnowflakeIdString());
				fii.setTargetType(FavouriteItemType.parseByCode(jo.getString("targetType")).code());
				fii.setTargetId(jo.getString("targetId"));
				fii.setTemporary(1);
				fii.setGroupId(temporaryGroupId);
				allItems.add(fii);
			}
		}

		//获得名称对照
		Map<String,String> names=translateNames(allItems);
		//填充名称
		String name=null;
		for (FavouriteGroupItem item : allItems) {
			name=names.get(item.getTargetId());
			if(name==null) name=item.getTargetId();
			item.setTargetName(name);
		}
		//执行插入
		this.insertList(allItems);

	}

	private Map<String,String> translateNames(List<FavouriteGroupItem> allItems) {
		//分组
		Map<String,List<FavouriteGroupItem>> gMap=CollectorUtil.groupBy(allItems,FavouriteGroupItem::getTargetType);
		//对象查询
		Map<String,String> names=new HashMap<>();
		for (String targetTypeStr : gMap.keySet()) {
			FavouriteItemType targetType=FavouriteItemType.parseByCode(targetTypeStr);
			List<FavouriteGroupItem> items=gMap.get(targetTypeStr);
			List<String> ids=CollectorUtil.collectList(items,FavouriteGroupItem::getTargetId);
			if(targetType==FavouriteItemType.employee){
				List<Employee> employees=employeeService.getByIds(ids);
				employeeService.join(employees,EmployeeMeta.PERSON);
				for (Employee employee : employees) {
					names.put(employee.getId(),employee.getPerson().getName());
				}
			} else if(targetType==FavouriteItemType.bpm_role){
				Result<List<Role>> rr= RoleServiceProxy.api().getByIds(ids);
				List<Role> roles=rr.data();
				for (Role role : roles) {
					names.put(role.getId(),role.getName());
				}
			}
		}
		return names;
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {

		return super.buildExcelStructure(isForExport);
	}


}
