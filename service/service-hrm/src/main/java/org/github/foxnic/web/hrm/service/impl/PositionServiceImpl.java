package org.github.foxnic.web.hrm.service.impl;


import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.OrderBy;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.domain.hrm.Position;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.hrm.service.IPositionService;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * <p>
 * 岗位表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-13 19:48:15
 * @version
*/


@Service("HrmPositionService")
public class PositionServiceImpl extends SuperService<Position> implements IPositionService {

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
	 * @param position 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Position position) {
		if(StringUtil.isBlank(position.getOrgId())) {
			return  ErrorDesc.failure().message("请指定上级组织节点");
		}
		if(StringUtil.isBlank(position.getFullName())) {
			position.setFullName("新岗位");
		}
		if(position.getValid()==null) {
			position.setValid(1);
		}
		position.setCompanyId(SessionUser.getCurrent().getActivatedCompanyId());
		Result r=super.insert(position);
		position=this.getById(position.getId());
		r.data(position);
		return r;
	}

	/**
	 * 批量插入实体，事务内
	 * @param positionList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Position> positionList) {
		return super.insertList(positionList);
	}


	/**
	 * 按主键删除 岗位
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Position position = new Position();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		position.setId(id);
		try {
			boolean suc = dao.deleteEntity(position);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 按主键删除 岗位
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		Position position = new Position();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		position.setId(id);
		position.setDeleted(true);
		position.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		position.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(position,SaveMode.NOT_NULL_FIELDS);
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
	 * @param position 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Position position , SaveMode mode) {
		Result r=super.update(position , mode);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param positionList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Position> positionList , SaveMode mode) {
		return super.updateList(positionList , mode);
	}


	/**
	 * 按主键更新字段 岗位
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
	 * 按主键获取 岗位
	 *
	 * @param id 主键
	 * @return Position 数据对象
	 */
	public Position getById(String id) {
		Position sample = new Position();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Position> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Position> queryList(Position sample) {
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
	public PagedList<Position> queryPagedList(Position sample, int pageSize, int pageIndex) {
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
	public PagedList<Position> queryPagedList(Position sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param position 数据对象
	 * @return 判断结果
	 */
	public Result<Position> checkExists(Position position) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(position, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(Position sample) {
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
	public List<Position> queryPositions(String orgId) {
		return this.queryList(new ConditionExpr("company_id=? and org_id=? and deleted=0",SessionUser.getCurrent().getActivatedCompanyId(), orgId), OrderBy.byAscNullsLast("sort"));
	}

	@Override
	public List<ZTreeNode> queryGroupedPositionNodes(String orgId) {
		List<Position> positions=queryPositions(orgId);
		return toZTreeNodeList(positions);
	}

	private List<ZTreeNode> toZTreeNodeList(List<Position> positions) {
		List<ZTreeNode> nodes=new ArrayList<ZTreeNode>();
		for (Position position : positions) {
			ZTreeNode node=new ZTreeNode();
			node.setId(position.getId());
			node.setName(position.getFullName());
			if(StringUtil.hasContent(position.getShortName())){
				node.setName(position.getShortName());
			}
			node.setExtra("fullName",position.getFullName());
			node.setExtra("shortName",position.getShortName());
			node.setExtra("originalName",node.getName());
			node.setParentId(position.getOrgId());
			node.setIsParent(false);
			node.setType("pos");
			nodes.add(node);
		}
		return  nodes;
	}

	@Override
	public Map<String, List<ZTreeNode>> queryGroupedPositionNodes() {
		ConditionExpr expr=new ConditionExpr("company_id=? and deleted=0",SessionUser.getCurrent().getActivatedCompanyId());
//		In in=new In("org_id",orgIds);
//		expr.and(in);
		List<Position> positions = this.queryList(expr, OrderBy.byAscNullsLast("sort"));
		List<ZTreeNode> nodes=toZTreeNodeList(positions);
		return CollectorUtil.groupBy(nodes,ZTreeNode::getParentId);
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}




	/**
	 * 批量检查引用
	 * @param ids  检查这些ID是否又被外部表引用
	 * */
	@Override
	public <T> Map<T, ReferCause> hasRefers(List<T> ids) {
		return super.hasRefers(ids,
				FoxnicWeb.HRM_EMPLOYEE_POSITION.POSITION_ID,
				FoxnicWeb.SYS_BUSI_ROLE_MEMBER.MEMBER_ID,FoxnicWeb.BPM_TASK_ASSIGNEE.ASSIGNEE_ID,
				FoxnicWeb.BPM_TASK_APPROVAL.ASSIGNEE_ID);
	}

}
