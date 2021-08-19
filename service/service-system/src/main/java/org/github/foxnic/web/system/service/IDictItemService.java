package org.github.foxnic.web.system.service;


import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.dao.entity.ISuperService;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.DictItemVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import java.io.InputStream;
import com.github.foxnic.sql.expr.OrderBy;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.data.SaveMode;

/**
 * <p>
 * 数据字典条目 服务接口
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-19 17:09:40
*/

public interface IDictItemService extends ISuperService<DictItem> {
	
	/**
	 * 插入实体
	 * @param dictItem 实体数据
	 * @return 插入是否成功
	 * */
	Result insert(DictItem dictItem);
 
	/**
	 * 批量插入实体，事务内
	 * @param dictItemList 实体数据清单
	 * @return 插入是否成功
	 * */
	Result insertList(List<DictItem> dictItemList);
	
	
		
	/**
	 * 按主键删除 数据字典条目
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	Result deleteByIdPhysical(String id);
	
	/**
	 * 按主键删除 数据字典条目
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
	 * 按主键更新字段 数据字典条目
	 *
	 * @param id ID
	 * @return 是否更新成功
	 */
	boolean update(DBField field,Object value , String id);
	
	/**
	 * 更新实体
	 * @param dictItem 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result update(DictItem dictItem , SaveMode mode);
	
	
	/**
	 * 更新实体集，事务内
	 * @param dictItemList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result updateList(List<DictItem> dictItemList, SaveMode mode);
	
	/**
	 * 保存实体，如果主键值不为 null，则更新，否则插入
	 * @param dictItem 实体数据
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result save(DictItem dictItem , SaveMode mode);
	
	/**
	 * 保存实体，如果主键值不为null，则更新，否则插入
	 * @param dictItemList 实体数据清单
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result saveList(List<DictItem> dictItemList , SaveMode mode);
	
	/**
	 * 检查实体中的数据字段是否已经存在
	 * @param dictItem  实体对象
	 * @param field  字段清单，至少指定一个
	 * @return 是否已经存在
	 * */
	boolean checkExists(DictItem dictItem,DBField... field);
 
		
	/**
	 * 按主键获取 数据字典条目
	 *
	 * @param id ID
	 * @return DictItem 数据对象
	 */
	DictItem getById(String id);
		
	/**
	 * 检查实体中的数据字段是否已经存在
	 * @param ids  主键清单
	 * @return 实体集
	 * */
	List<DictItem> getByIds(List<String> ids);

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param dictItem 数据对象
	 * @return 判断结果
	 */
	Result<DictItem> checkExists(DictItem dictItem);

	/**
	 * 根据实体数构建默认的条件表达式，字符串使用模糊匹配
	 * @param sample 数据样例
	 * @return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(DictItem sample);
	
	/**
	 * 根据实体数构建默认的条件表达式, 字符串是否使用模糊匹配
	 * @param sample 数据样例
	 * @param tableAliase 数据表别名
	 * 	@return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(DictItem sample,String tableAliase);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	List<DictItem> queryList(DictItem sample);
 
	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<DictItem> queryList(DictItem sample,ConditionExpr condition,OrderBy orderBy);
	
	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<DictItem> queryList(DictItem sample,OrderBy orderBy);
	
	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	List<DictItem> queryList(DictItem sample,ConditionExpr condition);
	
	/**
	 * 查询单个实体
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	DictItem queryEntity(DictItem sample);
	
	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	PagedList<DictItem> queryPagedList(DictItem sample,int pageSize,int pageIndex);
	
	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<DictItem> queryPagedList(DictItem sample,ConditionExpr condition,OrderBy orderBy,int pageSize,int pageIndex);
	
	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	PagedList<DictItem> queryPagedList(DictItem sample,ConditionExpr condition,int pageSize,int pageIndex);
	
	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<DictItem> queryPagedList(DictItem sample,OrderBy orderBy,int pageSize,int pageIndex);
 
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
	ExcelWriter exportExcel(DictItem sample);

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

 
}