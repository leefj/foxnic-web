package org.github.foxnic.web.oauth.service;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ISimpleIdService;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.OrderBy;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.misc.ztree.ZTreeNode;

import java.util.List;

/**
 * <p>
 * 菜单表 服务接口
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-01 09:27:29
 * @version
*/

public interface IMenuService extends ISimpleIdService<Menu,String> {

	public static final String ROOT_ID="0";

	/**
	 * 插入实体
	 * @param menu 实体数据
	 * @return 插入是否成功
	 * */
	Result insert(Menu menu);

	/**
	 * 批量插入实体，事务内
	 * @param menuList 实体数据清单
	 * @return 插入是否成功
	 * */
	Result insertList(List<Menu> menuList);



	/**
	 * 按主键删除 菜单
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	Result deleteByIdPhysical(String id);

	/**
	 * 按主键删除 菜单
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
	 * 按主键更新字段 菜单
	 *
	 * @param id ID
	 * @return 是否更新成功
	 */
	boolean update(DBField field,Object value , String id);

	/**
	 * 更新实体
	 * @param menu 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result update(Menu menu , SaveMode mode);


	/**
	 * 更新实体集，事务内
	 * @param menuList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result updateList(List<Menu> menuList, SaveMode mode);

	/**
	 * 保存实体，如果主键值不为 null，则更新，否则插入
	 * @param menu 实体数据
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result save(Menu menu , SaveMode mode);

	/**
	 * 保存实体，如果主键值不为null，则更新，否则插入
	 * @param menuList 实体数据清单
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result saveList(List<Menu> menuList , SaveMode mode);

	/**
	 * 检查实体中的数据字段是否已经存在
	 * @param menu  实体对象
	 * @param field  字段清单，至少指定一个
	 * */
	boolean checkExists(Menu menu,DBField... field);


	/**
	 * 按主键获取 菜单
	 *
	 * @param id ID
	 * @return Menu 数据对象
	 */
	Menu getById(String id);

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param menu 数据对象
	 * @return 判断结果
	 */
	Result<Menu> checkExists(Menu menu);



	/**
	 * 根据实体数构建默认的条件表达式，字符串使用模糊匹配
	 * @param sample 数据样例
	 * @return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(Menu sample);

	/**
	 * 根据实体数构建默认的条件表达式, 字符串是否使用模糊匹配
	 * @param sample 数据样例
	 * @param tableAliase 数据表别名
	 * 	@return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(Menu sample,String tableAliase);



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	List<Menu> queryList(Menu sample);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<Menu> queryList(Menu sample,ConditionExpr condition,OrderBy orderBy);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<Menu> queryList(Menu sample,OrderBy orderBy);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	List<Menu> queryList(Menu sample,ConditionExpr condition);

	/**
	 * 查询单个实体
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	Menu queryEntity(Menu sample);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	PagedList<Menu> queryPagedList(Menu sample,int pageSize,int pageIndex);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<Menu> queryPagedList(Menu sample,ConditionExpr condition,OrderBy orderBy,int pageSize,int pageIndex);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	PagedList<Menu> queryPagedList(Menu sample,ConditionExpr condition,int pageSize,int pageIndex);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<Menu> queryPagedList(Menu sample,OrderBy orderBy,int pageSize,int pageIndex);

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
	 * 查询根节点
	 * */
	List<ZTreeNode> queryRootNotes(String roleId);

	/**
	 * 查询下级节点
	 * */
	List<ZTreeNode> queryChildNodes(String parentId,String roleId);

	/**
	 * 保存层级关系
	 * */
	Boolean saveHierarchy(List<String> ids, String parentId);

	/**
	 * 填充层级关系
	 * */
	int fillHierarchy(boolean reset);

	/**
	 * 构建层级关系
	 * */
	List<ZTreeNode> buildingHierarchicalRelationships(List<ZTreeNode> list,String roleId);

	List<Menu> getRelatedMenus(List<String> resourzeIds);

	/**
	 * 按关键字搜索，并返回匹配的层级
	 * */
	List<String> search(String keyword);
}
