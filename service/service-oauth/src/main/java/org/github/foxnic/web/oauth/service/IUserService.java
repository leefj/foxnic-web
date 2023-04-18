package org.github.foxnic.web.oauth.service;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ISimpleIdService;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.OrderBy;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.User;

import java.util.List;

/**
 * <p>
 * 账户表 服务接口
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-01 09:27:27
*/

public interface IUserService extends ISimpleIdService<User,String> {

	public static final String SYSTEM_ACCOUNT="system";

	public static final ThreadLocal<List<Menu>> LOGIN_USER_MENUS=new ThreadLocal<>();

	/**
	 * 插入实体
	 * @param user 实体数据
	 * @return 插入是否成功
	 * */
	Result insert(User user);

	/**
	 * 批量插入实体，事务内
	 * @param userList 实体数据清单
	 * @return 插入是否成功
	 * */
	Result insertList(List<User> userList);



	/**
	 * 按主键删除 账户
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	Result deleteByIdPhysical(String id);

	/**
	 * 按主键删除 账户
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	Result deleteByIdLogical(String id);


	/**
	 * 批量物理删除，仅支持单字段主键表
	 * @param ids 主键清单
	 * @return 是否删除成功
	 * */
	<T> Result deleteByIdsPhysical(List<T> ids);

	/**
	 * 批量逻辑删除，仅支持单字段主键表
	 * @param ids 主键清单
	 * @return 是否删除成功
	 * */
	<T> Result deleteByIdsLogical(List<T> ids);


	/**
	 * 按主键更新字段 账户
	 *
	 * @param id ID
	 * @return 是否更新成功
	 */
	boolean update(DBField field,Object value , String id);

	/**
	 * 更新实体
	 * @param user 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result update(User user , SaveMode mode);


	/**
	 * 更新实体集，事务内
	 * @param userList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result updateList(List<User> userList, SaveMode mode);

	/**
	 * 保存实体，如果主键值不为 null，则更新，否则插入
	 * @param user 实体数据
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result save(User user , SaveMode mode);

	/**
	 * 保存实体，如果主键值不为null，则更新，否则插入
	 * @param userList 实体数据清单
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result saveList(List<User> userList , SaveMode mode);

	/**
	 * 检查实体中的数据字段是否已经存在
	 * @param user  实体对象
	 * @param field  字段清单，至少指定一个
	 * @return  是否已经存在
	 * */
	boolean checkExists(User user,DBField... field);


	/**
	 * 按主键获取 账户
	 *
	 * @param id ID
	 * @return User 数据对象
	 */
	User getById(String id);

	User getByAccount(String account);

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param user 数据对象
	 * @return 判断结果
	 */

	Boolean checkExists(User user);



	/**
	 * 根据实体数构建默认的条件表达式，字符串使用模糊匹配
	 * @param sample 数据样例
	 * @return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(User sample);

	/**
	 * 根据实体数构建默认的条件表达式, 字符串是否使用模糊匹配
	 * @param sample 数据样例
	 * @param tableAliase 数据表别名
	 * 	@return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(User sample,String tableAliase);


	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
//	@PreAuthorize("hasAuthority('sys_user::api::save')")
	List<User> queryList(User sample);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<User> queryList(User sample,ConditionExpr condition,OrderBy orderBy);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<User> queryList(User sample,OrderBy orderBy);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	List<User> queryList(User sample,ConditionExpr condition);

	/**
	 * 查询单个实体
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	User queryEntity(User sample);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	PagedList<User> queryPagedList(User sample,int pageSize,int pageIndex);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<User> queryPagedList(User sample,ConditionExpr condition,OrderBy orderBy,int pageSize,int pageIndex);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	PagedList<User> queryPagedList(User sample,ConditionExpr condition,int pageSize,int pageIndex);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<User> queryPagedList(User sample,OrderBy orderBy,int pageSize,int pageIndex);

 	/**
	 * 查询指定字段的数据清单
	 * @param <T> 元素类型
	 * @param field 字段
	 * @param type 元素类型
	 * @param condition 条件表达式
	 * @return 列数据
	 * */
	<T> List<T> queryValues(DBField field,Class<T> type, ConditionExpr condition);

	/**
	 * 查询指定字段的数据清单
	 * @param <T> 元素类型
	 * @param field 字段
	 * @param type 元素类型
	 * @param condition 条件表达式
	 * @param ps 参数清单
	 * @return 列数据
	 * */
	<T> List<T> queryValues(DBField field, Class<T> type, String condition,Object... ps);


	/**
	 * 提供给 SpringSecurity 的查询接口
	 * @param identity 身份表示，账户、手机号等
	 * */
	User getUserByIdentity(String identity);

	/**
	 * 修改密码
	 * */
    Result changePasswd(String sessionUserId, String oldpwd, String newpwd);

	/***
	 * 管理员密码重置
	 * */
	Result resetPasswd(String userId, String adminPwd, String pwd);

	List<Menu> makeUserMenus(User user, boolean gerDyMenu);

	boolean isBuildIn(User user);
}
