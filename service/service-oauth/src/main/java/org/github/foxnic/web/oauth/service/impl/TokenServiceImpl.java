package org.github.foxnic.web.oauth.service.impl;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.domain.oauth.Token;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.oauth.service.ITokenService;
import org.springframework.stereotype.Service;

import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.Expr;
import com.github.foxnic.sql.meta.DBField;

/**
 * <p>
 * Token表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-02 15:02:42
*/


@Service("SysTokenService")
public class TokenServiceImpl extends SuperService<Token> implements ITokenService {
	
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
	 * @param role 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Token token) {
		return super.insert(token);
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param roleList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Token> tokenList) {
		return super.insertList(tokenList);
	}
	
	
	/**
	 * 按主键删除 Token
	 *
	 * @param id id
	 * @return 删除是否成功
	 */
	public boolean deleteByIdPhysical(String id) {
		Token token = new Token();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		token.setId(id);
		return dao.deleteEntity(token);
	}
	
	/**
	 * 按主键删除 Token
	 *
	 * @param id id
	 * @return 删除是否成功
	 */
	public boolean deleteByIdLogical(String id) {
		Token token = new Token();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		token.setId(id);
		token.setDeleted(dao.getDBTreaty().getTrueValue());
		token.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		token.setDeleteTime(new Date());
		return dao.updateEntity(token,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 更新实体
	 * @param role 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Token token , SaveMode mode) {
		return super.update(token , mode);
	}
	
	/**
	 * 更新实体集，事务内
	 * @param roleList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Token> tokenList , SaveMode mode) {
		return super.updateList(tokenList , mode);
	}
	
	
	/**
	 * 按主键更新字段 Token
	 *
	 * @param id id
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	} 
	
	
	/**
	 * 按主键获取 Token
	 *
	 * @param id id
	 * @return Token 数据对象
	 */
	public Token getById(String id) {
		Token sample = new Token();
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
	public List<Token> queryList(Token sample) {
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
	public PagedList<Token> queryPagedList(Token sample, int pageSize, int pageIndex) {
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
	public PagedList<Token> queryPagedList(Token sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param roleVO 数据对象
	 * @return 判断结果
	 */
	public Result<Token> checkExists(Token role) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(role, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public List<Token> queryValidTokens() {
		return dao.queryEntities(Token.class,new Expr("select * from sys_token where refresh_token_expire_time>now() or access_token_expire_time>now()"));
	}
 

}