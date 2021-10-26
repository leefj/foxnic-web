package org.github.foxnic.web.dataperm.service;


import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ISuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.OrderBy;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.domain.dataperm.RuleCondition;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.misc.ztree.ZTreeNode;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 数据权限规则范围条件表 服务接口
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-26 14:45:04
 * @version
*/

public interface IRuleConditionService extends ISuperService<RuleCondition> {

	public static final String ROOT_ID="0";

	/**
	 * 插入实体
	 * @param ruleCondition 实体数据
	 * @return 插入是否成功
	 * */
	Result insert(RuleCondition ruleCondition);

	/**
	 * 批量插入实体，事务内
	 * @param ruleConditionList 实体数据清单
	 * @return 插入是否成功
	 * */
	Result insertList(List<RuleCondition> ruleConditionList);



	/**
	 * 按主键删除 数据权限规则范围条件
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	Result deleteByIdPhysical(String id);

	/**
	 * 按主键删除 数据权限规则范围条件
	 *
	 * @param id 主键
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
	 * 按主键更新字段 数据权限规则范围条件
	 *
	 * @param id 主键
	 * @return 是否更新成功
	 */
	boolean update(DBField field,Object value , String id);

	/**
	 * 更新实体
	 * @param ruleCondition 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result update(RuleCondition ruleCondition , SaveMode mode);


	/**
	 * 更新实体集，事务内
	 * @param ruleConditionList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result updateList(List<RuleCondition> ruleConditionList, SaveMode mode);

	/**
	 * 保存实体，如果主键值不为 null，则更新，否则插入
	 * @param ruleCondition 实体数据
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result save(RuleCondition ruleCondition , SaveMode mode);

	/**
	 * 保存实体，如果主键值不为null，则更新，否则插入
	 * @param ruleConditionList 实体数据清单
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result saveList(List<RuleCondition> ruleConditionList , SaveMode mode);

	/**
	 * 检查实体中的数据字段是否已经存在
	 * @param ruleCondition  实体对象
	 * @param field  字段清单，至少指定一个
	 * @return 是否已经存在
	 * */
	boolean checkExists(RuleCondition ruleCondition,DBField... field);


	/**
	 * 按主键获取 数据权限规则范围条件
	 *
	 * @param id 主键
	 * @return RuleCondition 数据对象
	 */
	RuleCondition getById(String id);

	/**
	 * 检查实体中的数据字段是否已经存在
	 * @param ids  主键清单
	 * @return 实体集
	 * */
	List<RuleCondition> getByIds(List<String> ids);

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param ruleCondition 数据对象
	 * @return 判断结果
	 */
	Result<RuleCondition> checkExists(RuleCondition ruleCondition);

	/**
	 * 根据实体数构建默认的条件表达式, 不支持 Join 其它表
	 * @param sample 数据样例
	 * @return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(RuleCondition sample);

	/**
	 * 根据实体数构建默认的条件表达式, 不支持 Join 其它表
	 * @param sample 数据样例
	 * @param tableAliase 数据表别名
	 * 	@return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(RuleCondition sample,String tableAliase);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	List<RuleCondition> queryList(RuleCondition sample);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<RuleCondition> queryList(RuleCondition sample,ConditionExpr condition,OrderBy orderBy);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<RuleCondition> queryList(RuleCondition sample,OrderBy orderBy);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	List<RuleCondition> queryList(RuleCondition sample,ConditionExpr condition);

	/**
	 * 查询单个实体
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	RuleCondition queryEntity(RuleCondition sample);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	PagedList<RuleCondition> queryPagedList(RuleCondition sample,int pageSize,int pageIndex);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<RuleCondition> queryPagedList(RuleCondition sample,ConditionExpr condition,OrderBy orderBy,int pageSize,int pageIndex);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	PagedList<RuleCondition> queryPagedList(RuleCondition sample,ConditionExpr condition,int pageSize,int pageIndex);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<RuleCondition> queryPagedList(RuleCondition sample,OrderBy orderBy,int pageSize,int pageIndex);

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
	 * 导出 Excel
	 * */
	ExcelWriter exportExcel(RuleCondition sample);

	/**
	 * 导出用于数据导入的 Excel 模版
	 * */
	ExcelWriter  exportExcelTemplate();

	/**
	 * 构建 Excel 结构
	 * @param  isForExport 是否用于数据导出
	 * @return   ExcelStructure
	 * */
	ExcelStructure buildExcelStructure(boolean isForExport);

	/**
	 * 导入 Excel 数据
	 * @return  错误信息，成功时返回 null
	 * */
	List<ValidateResult> importExcel(InputStream input,int sheetIndex,boolean batch);

	/**
	 * 查询根节点
	 * */
	List<ZTreeNode> queryRootNotes(String roleId);

	/**
	 * 查询下级节点
	 * */
	List<ZTreeNode> queryChildNodes(String parentId, String roleId);

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
