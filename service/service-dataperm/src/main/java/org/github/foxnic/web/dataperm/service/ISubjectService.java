package org.github.foxnic.web.dataperm.service;


import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.dao.entity.ISuperService;
import org.github.foxnic.web.domain.dataperm.Subject;
import org.github.foxnic.web.domain.dataperm.SubjectVO;
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
 * 数据权限主体表 服务接口
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-02 14:49:22
*/

public interface ISubjectService extends ISuperService<Subject> {

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param subject 数据对象
	 * @return 插入是否成功
	 * */
	Result insert(Subject subject);

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param subject  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	Result insert(Subject subject,boolean throwsException);

	/**
	 * 批量插入实体，事务内
	 * @param subjectList 实体数据清单
	 * @return 插入是否成功
	 * */
	Result insertList(List<Subject> subjectList);


		
	/**
	 * 按主键删除 数据权限主体
	 *
	 * @param code 代码
	 * @return 删除是否成功
	 */
	Result deleteByIdPhysical(String code);
	
	/**
	 * 按主键删除 数据权限主体
	 *
	 * @param code 代码
	 * @return 删除是否成功
	 */
	Result deleteByIdLogical(String code);

	/**
	 * 批量物理删除，仅支持单字段主键表
	 * @param codes 主键清单
	 * @return 是否删除成功
	 * */
	<T> Result deleteByIdsPhysical(List<T> codes);

	/**
	 * 批量逻辑删除，仅支持单字段主键表
	 * @param codes 主键清单
	 * @return 是否删除成功
	 * */
	<T> Result deleteByIdsLogical(List<T> codes);

		
	/**
	 * 按主键更新字段 数据权限主体
	 *
	 * @param code 代码
	 * @return 是否更新成功
	 */
	boolean update(DBField field,Object value , String code);

	/**
	 * 更新，如果执行错误，则抛出异常
	 * @param subject 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result update(Subject subject , SaveMode mode);


	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param subject 数据对象
	 * @param mode SaveMode,数据更新的模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果
	 */
	Result update(Subject subject , SaveMode mode,boolean throwsException);


	/**
	 * 更新实体集，事务内
	 * @param subjectList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result updateList(List<Subject> subjectList, SaveMode mode);

	/**
	 * 保存实体，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param subject 实体数据
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	Result save(Subject subject , SaveMode mode,boolean throwsException);

	/**
	 * 保存实体，如果语句错误，则抛出异常
	 * @param subject 实体数据
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result save(Subject subject , SaveMode mode);

	/**
	 * 保存实体，如果主键值不为null，则更新，否则插入
	 * @param subjectList 实体数据清单
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result saveList(List<Subject> subjectList , SaveMode mode);

	/**
	 * 检查实体中的数据字段是否已经存在
	 * @param subject  实体对象
	 * @param field  字段清单，至少指定一个
	 * @return 是否已经存在
	 * */
	boolean checkExists(Subject subject,DBField... field);

		
	/**
	 * 按主键获取 数据权限主体
	 *
	 * @param code 代码
	 * @return Subject 数据对象
	 */
	Subject getById(String code);

	/**
	 * 检查实体中的数据字段是否已经存在
	 * @param codes  主键清单
	 * @return 实体集
	 * */
	List<Subject> getByIds(List<String> codes);

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param subject 数据对象
	 * @return 判断结果
	 */
	Result<Subject> checkExists(Subject subject);

	/**
	 * 根据实体数构建默认的条件表达式, 不支持 Join 其它表
	 * @param sample 数据样例
	 * @return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(Subject sample);

	/**
	 * 根据实体数构建默认的条件表达式, 不支持 Join 其它表
	 * @param sample 数据样例
	 * @param tableAliase 数据表别名
	 * 	@return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(Subject sample,String tableAliase);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	List<Subject> queryList(Subject sample);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<Subject> queryList(Subject sample,ConditionExpr condition,OrderBy orderBy);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<Subject> queryList(Subject sample,OrderBy orderBy);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	List<Subject> queryList(Subject sample,ConditionExpr condition);

	/**
	 * 查询单个实体
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	Subject queryEntity(Subject sample);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	PagedList<Subject> queryPagedList(Subject sample,int pageSize,int pageIndex);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<Subject> queryPagedList(Subject sample,ConditionExpr condition,OrderBy orderBy,int pageSize,int pageIndex);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	PagedList<Subject> queryPagedList(Subject sample,ConditionExpr condition,int pageSize,int pageIndex);

	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<Subject> queryPagedList(Subject sample,OrderBy orderBy,int pageSize,int pageIndex);

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
	ExcelWriter exportExcel(Subject sample);

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