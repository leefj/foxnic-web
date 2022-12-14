package org.github.foxnic.web.hrm.service;


import com.alibaba.fastjson.JSONObject;
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
import org.github.foxnic.web.domain.hrm.FavouriteGroupItem;
import org.github.foxnic.web.domain.hrm.FavouriteGroupItemVO;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 常用人员分组条目表 服务接口
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-20 06:14:04
 * @version
*/

public interface IFavouriteGroupItemService extends ISuperService<FavouriteGroupItem> {
	
	/**
	 * 插入实体
	 * @param favouriteGroupItem 实体数据
	 * @return 插入是否成功
	 * */
	Result insert(FavouriteGroupItem favouriteGroupItem);
 
	/**
	 * 批量插入实体，事务内
	 * @param favouriteGroupItemList 实体数据清单
	 * @return 插入是否成功
	 * */
	Result insertList(List<FavouriteGroupItem> favouriteGroupItemList);
	
	
		
	/**
	 * 按主键删除 常用人员分组条目
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	Result deleteByIdPhysical(String id);
	
	/**
	 * 按主键删除 常用人员分组条目
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
	 * 按主键更新字段 常用人员分组条目
	 *
	 * @param id 主键
	 * @return 是否更新成功
	 */
	boolean update(DBField field,Object value , String id);
	
	/**
	 * 更新实体
	 * @param favouriteGroupItem 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result update(FavouriteGroupItem favouriteGroupItem , SaveMode mode);
	
	
	/**
	 * 更新实体集，事务内
	 * @param favouriteGroupItemList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result updateList(List<FavouriteGroupItem> favouriteGroupItemList, SaveMode mode);
	
	/**
	 * 保存实体，如果主键值不为 null，则更新，否则插入
	 * @param favouriteGroupItem 实体数据
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result save(FavouriteGroupItem favouriteGroupItem , SaveMode mode);
	
	/**
	 * 保存实体，如果主键值不为null，则更新，否则插入
	 * @param favouriteGroupItemList 实体数据清单
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result saveList(List<FavouriteGroupItem> favouriteGroupItemList , SaveMode mode);
	
	/**
	 * 检查实体中的数据字段是否已经存在
	 * @param favouriteGroupItem  实体对象
	 * @param field  字段清单，至少指定一个
	 * @return 是否已经存在
	 * */
	boolean checkExists(FavouriteGroupItem favouriteGroupItem,DBField... field);
 
		
	/**
	 * 按主键获取 常用人员分组条目
	 *
	 * @param id 主键
	 * @return FavouriteGroupItem 数据对象
	 */
	FavouriteGroupItem getById(String id);

	/**
	 * 转换数据
	 *
	 * @param info 主键
	 * @return FavouriteGroupItem 数据对象
	 */
	JSONObject translate(String info);
		
	/**
	 * 检查实体中的数据字段是否已经存在
	 * @param ids  主键清单
	 * @return 实体集
	 * */
	List<FavouriteGroupItem> getByIds(List<String> ids);

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param favouriteGroupItem 数据对象
	 * @return 判断结果
	 */
	Result<FavouriteGroupItem> checkExists(FavouriteGroupItem favouriteGroupItem);

	/**
	 * 根据实体数构建默认的条件表达式，字符串使用模糊匹配
	 * @param sample 数据样例
	 * @return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(FavouriteGroupItem sample);
	
	/**
	 * 根据实体数构建默认的条件表达式, 字符串是否使用模糊匹配
	 * @param sample 数据样例
	 * @param tableAliase 数据表别名
	 * 	@return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(FavouriteGroupItem sample,String tableAliase);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	List<FavouriteGroupItem> queryList(FavouriteGroupItem sample);
 
	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<FavouriteGroupItem> queryList(FavouriteGroupItem sample,ConditionExpr condition,OrderBy orderBy);
	
	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<FavouriteGroupItem> queryList(FavouriteGroupItem sample,OrderBy orderBy);
	
	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	List<FavouriteGroupItem> queryList(FavouriteGroupItem sample,ConditionExpr condition);
	
	/**
	 * 查询单个实体
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	FavouriteGroupItem queryEntity(FavouriteGroupItem sample);
	
	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	PagedList<FavouriteGroupItem> queryPagedList(FavouriteGroupItem sample,int pageSize,int pageIndex);
	
	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<FavouriteGroupItem> queryPagedList(FavouriteGroupItem sample,ConditionExpr condition,OrderBy orderBy,int pageSize,int pageIndex);
	
	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	PagedList<FavouriteGroupItem> queryPagedList(FavouriteGroupItem sample,ConditionExpr condition,int pageSize,int pageIndex);
	
	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<FavouriteGroupItem> queryPagedList(FavouriteGroupItem sample,OrderBy orderBy,int pageSize,int pageIndex);
 
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
	ExcelWriter exportExcel(FavouriteGroupItem sample);

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


    Result inserts(List<FavouriteGroupItemVO> list);

	Result removeAll(FavouriteGroupItemVO vo);

    void initEmployees(String initValue);
}