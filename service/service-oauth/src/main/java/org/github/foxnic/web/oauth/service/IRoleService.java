package org.github.foxnic.web.oauth.service;
import java.util.List;

import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ISuperService;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.OrderBy;
import com.github.foxnic.sql.meta.DBField;

import org.github.foxnic.web.domain.oauth.Role;

/**
 * <p>
 * 角色表 服务接口
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-01 09:27:28
*/

public interface IRoleService extends ISuperService<Role> {
	
	/**
	 * 插入实体
	 * @param role 实体数据
	 * @return 插入是否成功
	 * */
	boolean insert(Role role);
 
	/**
	 * 批量插入实体，事务内
	 * @param roleList 实体数据清单
	 * @return 插入是否成功
	 * */
	boolean insertList(List<Role> roleList);
	
	
		
	/**
	 * 按主键删除 角色
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	boolean deleteByIdPhysical(String id);
	
	/**
	 * 按主键删除 角色
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	boolean deleteByIdLogical(String id);
	
	
	/**
	 * 批量物理删除，仅支持单字段主键表
	 * @param ids 主键清单
	 * @return 是否删除成功
	 * */
	<T> boolean deleteByIdsPhysical(List<T> ids);
	
	/**
	 * 批量逻辑删除，仅支持单字段主键表
	 * @param ids 主键清单
	 * @return 是否删除成功
	 * */
	<T> boolean deleteByIdsLogical(List<T> ids);
	
		
	/**
	 * 按主键更新字段 角色
	 *
	 * @param id ID
	 * @return 是否更新成功
	 */
	boolean update(DBField field,Object value , String id);
	
	/**
	 * 更新实体
	 * @param role 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	boolean update(Role role , SaveMode mode);
	
	
	/**
	 * 更新实体集，事务内
	 * @param roleList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	boolean updateList(List<Role> roleList, SaveMode mode);
	
	/**
	 * 保存实体，如果主键值不为 null，则更新，否则插入
	 * @param entity 实体数据
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	boolean save(Role role , SaveMode mode);
	
	/**
	 * 保存实体，如果主键值不为null，则更新，否则插入
	 * @param roleList 实体数据清单
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	boolean saveList(List<Role> roleList , SaveMode mode);
	
	/**
	 * 检查实体中的数据字段是否已经存在
	 * @param role  实体对象
	 * @param field  字段清单，至少指定一个
	 * @param 是否已经存在
	 * */
	boolean checkExists(Role role,DBField... field);
 
		
	/**
	 * 按主键获取 角色
	 *
	 * @param id ID
	 * @return Role 数据对象
	 */
	Role getById(String id);
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param role 数据对象
	 * @return 判断结果
	 */
	Result<Role> checkExists(Role role);
 
	/**
	 * 根据实体数构建默认的条件表达式
	 * @param sample 数据样例
	 * @param stringFuzzy 字符串是否使用模糊匹配
	 * @return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(Role sample,boolean stringFuzzy);
	
	/**
	 * 根据实体数构建默认的条件表达式，字符串使用模糊匹配
	 * @param sample 数据样例
	 * @return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(Role sample);
	
	/**
	 * 根据实体数构建默认的条件表达式, 字符串是否使用模糊匹配
	 * @param sample 数据样例
	 * @param tableAliase 数据表别名
	 * 	@return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(Role sample,String tableAliase);
	
	/**
	 * 根据实体数构建默认的条件表达式
	 * @param sample 数据样例
	 * @param stringFuzzy 字符串是否使用模糊匹配
	 * @param tableAliase 数据表别名
	 * @return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(Role sample,boolean stringFuzzy,String tableAliase);
	
	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	List<Role> queryList(Role sample);
 
	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<Role> queryList(Role sample,ConditionExpr condition,OrderBy orderBy);
	
	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<Role> queryList(Role sample,OrderBy orderBy);
	
	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	List<Role> queryList(Role sample,ConditionExpr condition);
	
	/**
	 * 查询单个实体
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	Role queryEntity(Role sample);
	
	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	PagedList<Role> queryPagedList(Role sample,int pageSize,int pageIndex);
	
	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<Role> queryPagedList(Role sample,ConditionExpr condition,OrderBy orderBy,int pageSize,int pageIndex);
	
	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	PagedList<Role> queryPagedList(Role sample,ConditionExpr condition,int pageSize,int pageIndex);
	
	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<Role> queryPagedList(Role sample,OrderBy orderBy,int pageSize,int pageIndex);
 
 	/**
	 * 查询指定字段的数据清单
	 * @param T 元素类型
	 * @param field 字段
	 * @param type 元素类型
	 * @param condition 条件表达式
	 * @return 列数据
	 * */
	<T> List<T> queryValues(DBField field,Class<T> type, ConditionExpr condition);
 
	/**
	 * 查询指定字段的数据清单
	 * @param T 元素类型
	 * @param field 字段
	 * @param type 元素类型
	 * @param condition 条件表达式
	 * @param ps 参数清单
	 * @return 列数据
	 * */
	<T> List<T> queryValues(DBField field, Class<T> type, String condition,Object... ps);

	/**
	 * 获得系统的所有角色代码
	 * */
	List<String> queryAllRoleCode();
 
}