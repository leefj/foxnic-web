package org.github.foxnic.web.system.service;


import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.dao.entity.ISuperService;
import org.github.foxnic.web.domain.system.CodeExampleMulitPk;
import org.github.foxnic.web.domain.system.CodeExampleMulitPkVO;
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
import java.util.Date;

/**
 * <p>
 * 主键多字段测试表 服务接口
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-02-11 13:02:52
*/

public interface ICodeExampleMulitPkService extends ISuperService<CodeExampleMulitPk> {

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param codeExampleMulitPk 数据对象
	 * @return 插入是否成功
	 * */
	Result insert(CodeExampleMulitPk codeExampleMulitPk);

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param codeExampleMulitPk  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	Result insert(CodeExampleMulitPk codeExampleMulitPk,boolean throwsException);

	/**
	 * 批量插入实体，事务内
	 * @param codeExampleMulitPkList 实体数据清单
	 * @return 插入是否成功
	 * */
	Result insertList(List<CodeExampleMulitPk> codeExampleMulitPkList);


		
	/**
	 * 按主键删除 主键多字段测试
	 *
	 * @param nid 主键1
	 * @param day 主键2
	 * @return 删除是否成功
	 */
	Result deleteByIdPhysical(Long nid , Date day);


		
	/**
	 * 按主键更新字段 主键多字段测试
	 *
	 * @param nid 主键1
	 * @param day 主键2
	 * @return 是否更新成功
	 */
	boolean update(DBField field,Object value , Long nid , Date day);

	/**
	 * 更新，如果执行错误，则抛出异常
	 * @param codeExampleMulitPk 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result update(CodeExampleMulitPk codeExampleMulitPk , SaveMode mode);


	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param codeExampleMulitPk 数据对象
	 * @param mode SaveMode,数据更新的模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果
	 */
	Result update(CodeExampleMulitPk codeExampleMulitPk , SaveMode mode,boolean throwsException);


	/**
	 * 更新实体集，事务内
	 * @param codeExampleMulitPkList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result updateList(List<CodeExampleMulitPk> codeExampleMulitPkList, SaveMode mode);

	/**
	 * 保存实体，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param codeExampleMulitPk 实体数据
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	Result save(CodeExampleMulitPk codeExampleMulitPk , SaveMode mode,boolean throwsException);

	/**
	 * 保存实体，如果语句错误，则抛出异常
	 * @param codeExampleMulitPk 实体数据
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result save(CodeExampleMulitPk codeExampleMulitPk , SaveMode mode);

	/**
	 * 保存实体，如果主键值不为null，则更新，否则插入
	 * @param codeExampleMulitPkList 实体数据清单
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result saveList(List<CodeExampleMulitPk> codeExampleMulitPkList , SaveMode mode);

	/**
	 * 检查实体中的数据字段是否已经存在 . 判断 主键值不同，但指定字段的值相同的记录是否存在
	 * @param codeExampleMulitPk  实体对象
	 * @param field  字段清单，至少指定一个
	 * @return 是否已经存在
	 * */
	boolean checkExists(CodeExampleMulitPk codeExampleMulitPk,DBField... field);

		
	/**
	 * 按主键获取 主键多字段测试
	 *
	 * @param nid 主键1
	 * @param day 主键2
	 * @return CodeExampleMulitPk 数据对象
	 */
	CodeExampleMulitPk getById(Long nid , Date day);

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param codeExampleMulitPk 数据对象
	 * @return 判断结果
	 */
	Boolean checkExists(CodeExampleMulitPk codeExampleMulitPk);

	/**
	 * 根据实体数构建默认的条件表达式, 不支持 Join 其它表
	 * @param sample 数据样例
	 * @return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(CodeExampleMulitPk sample);

	/**
	 * 根据实体数构建默认的条件表达式, 不支持 Join 其它表
	 * @param sample 数据样例
	 * @param tableAliase 数据表别名
	 * 	@return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(CodeExampleMulitPk sample,String tableAliase);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	List<CodeExampleMulitPk> queryList(CodeExampleMulitPk sample);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<CodeExampleMulitPk> queryList(CodeExampleMulitPk sample,ConditionExpr condition,OrderBy orderBy);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<CodeExampleMulitPk> queryList(CodeExampleMulitPk sample,OrderBy orderBy);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	List<CodeExampleMulitPk> queryList(CodeExampleMulitPk sample,ConditionExpr condition);

	/**
	 * 查询单个实体
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	CodeExampleMulitPk queryEntity(CodeExampleMulitPk sample);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	PagedList<CodeExampleMulitPk> queryPagedList(CodeExampleMulitPk sample,int pageSize,int pageIndex);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<CodeExampleMulitPk> queryPagedList(CodeExampleMulitPk sample,ConditionExpr condition,OrderBy orderBy,int pageSize,int pageIndex);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	PagedList<CodeExampleMulitPk> queryPagedList(CodeExampleMulitPk sample,ConditionExpr condition,int pageSize,int pageIndex);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<CodeExampleMulitPk> queryPagedList(CodeExampleMulitPk sample,OrderBy orderBy,int pageSize,int pageIndex);

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
	ExcelWriter exportExcel(CodeExampleMulitPk sample);

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