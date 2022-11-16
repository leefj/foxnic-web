package org.github.foxnic.web.relation;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.domain.system.DiscreteValue;

import java.util.List;
import java.util.Map;

public interface DiscreteService {

    public static final String DEFAULT_DISCRETE_KEY = "/";

    public static final String DISCRETE_TYPE_ENUM = "enum";

    public static final String DISCRETE_TYPE_DICT = "dict";

    /**
     * 保存枚举型离散数据
     * @param discreteKey 离散健
     * @param masterTableName  主表
     * @param masterId  主标主键值
     * @param enums 枚举清单
     * */
    boolean saveEnumValues(String discreteKey,String masterTableName, String masterId, CodeTextEnum... enums);

    /**
     * 保存枚举型离散数据
     * @param discreteKey 离散健
     * @param masterTable  主表
     * @param masterId  主标主键值
     * @param enums 枚举清单
     * */
    default boolean saveEnumValues(String discreteKey,DBTable masterTable, String masterId, CodeTextEnum... enums) {
        return saveEnumValues(discreteKey,masterTable.name(),masterId,enums);
    }

    /**
     * 保存枚举型离散数据
     * @param masterTable  主表
     * @param masterId  主标主键值
     * @param enums 枚举清单
     * */
    default boolean saveEnumValues(DBTable masterTable, String masterId, CodeTextEnum... enums) {
        return saveEnumValues(DEFAULT_DISCRETE_KEY,masterTable.name(),masterId,enums);
    }

    /**
     * 保存枚举型离散数据
     * @param masterTableName  主表
     * @param masterId  主标主键值
     * @param enums 枚举清单
     * */
    default boolean saveEnumValues(String masterTableName, String masterId, CodeTextEnum... enums) {
        return saveEnumValues(DEFAULT_DISCRETE_KEY,masterTableName,masterId,enums);
    }


    /**
     * 保存字典型离散数据
     * @param discreteKey 离散健
     * @param masterTableName  主表
     * @param masterId  主标主键值
     * @param dictCode 字典代码
     * @param dictItemCodes 字典条目代码
     * */
    boolean saveDictValues(String discreteKey, String masterTableName, String masterId, String dictCode,String[] dictItemCodes);


    /**
     * 保存字典型离散数据
     * @param discreteKey 离散健
     * @param masterTable  主表
     * @param masterId  主标主键值
     * @param dictCode 字典代码
     * @param dictItemCodes 字典条目代码
     * */
    default boolean saveDictValues(String discreteKey,DBTable masterTable, String masterId, String dictCode,String... dictItemCodes) {
        return saveDictValues(discreteKey,masterTable.name(),masterId,dictCode,dictItemCodes);
    }

    /**
     * 保存字典型离散数据
     * @param masterTable 离散健
     * @param masterId  主标主键值
     * @param dictCode 字典代码
     * @param dictItemCodes 字典条目代码
     * */
    default boolean saveDictValues(DBTable masterTable, String masterId, String dictCode,String... dictItemCodes) {
        return saveDictValues(DEFAULT_DISCRETE_KEY,masterTable.name(),masterId,dictCode,dictItemCodes);
    }

    /**
     * 保存字典型离散数据
     * @param masterTableName  主表
     * @param masterId  主标主键值
     * @param dictCode 字典代码
     * @param dictItemCodes 字典条目代码
     * */
    default boolean saveDictValues(String masterTableName, String masterId, String dictCode,String... dictItemCodes) {
        return saveDictValues(DEFAULT_DISCRETE_KEY,masterTableName,masterId,dictCode,dictItemCodes);
    }


    /**
     * 删除离散数据
     * @param discreteKey 离散健
     * @param masterTableName  主表
     * @param masterId  主标主键值
     * */
    boolean deleteValues(String discreteKey, String masterTableName, String masterId);

    /**
     * 删除离散数据
     * @param discreteKey 离散健
     * @param masterTable  主表
     * @param masterId  主标主键值
     * */
    default boolean deleteValues(String discreteKey, DBTable masterTable, String masterId) {
        return deleteValues(discreteKey,masterTable.name(),masterId);
    }

    /**
     * 删除离散数据
     * @param masterTableName  主表
     * @param masterId  主标主键值
     * */
    default boolean deleteValues(String masterTableName, String masterId) {
        return deleteValues(DEFAULT_DISCRETE_KEY,masterTableName,masterId);
    }

    /**
     * 删除离散数据
     * @param masterTable  主表
     * @param masterId  主标主键值
     * */
    default boolean deleteValues(DBTable masterTable, String masterId) {
        return deleteValues(DEFAULT_DISCRETE_KEY,masterTable.name(),masterId);
    }



    /**
     * 查询离散数据
     * @param discreteKey 离散健
     * @param masterTableName  主表
     * @param masterId  主标主键值
     * */
    List<DiscreteValue> queryValues(String discreteKey, String masterTableName, String masterId);

    /**
     * 查询离散数据
     * @param discreteKey 离散健
     * @param masterTable  主表
     * @param masterId  主标主键值
     * */
    default List<DiscreteValue> queryValues(String discreteKey, DBTable masterTable, String masterId) {
        return queryValues(discreteKey,masterTable.name(),masterId);
    }

    /**
     * 查询离散数据
     * @param masterTableName  主表
     * @param masterId  主标主键值
     * */
    default List<DiscreteValue> queryValues(String masterTableName, String masterId) {
        return queryValues(DEFAULT_DISCRETE_KEY,masterTableName,masterId);
    }

    /**
     * 查询离散数据
     * @param masterTable  主表
     * @param masterId  主标主键值
     * */
    default List<DiscreteValue> queryValues(DBTable masterTable, String masterId) {
        return queryValues(DEFAULT_DISCRETE_KEY,masterTable.name(),masterId);
    }



    /**
     * 查询离散数据
     * @param discreteKey 离散健
     * @param masterTableName  主表
     * @param masterIds  主标主键值
     * */
    Map<String,List<DiscreteValue>> queryValues(String discreteKey, String masterTableName, List<String> masterIds);

    /**
     * 查询离散数据
     * @param discreteKey 离散健
     * @param masterTable  主表
     * @param masterIds  主标主键值
     * */
    default Map<String,List<DiscreteValue>> queryValues(String discreteKey, DBTable masterTable, List<String> masterIds) {
        return queryValues(discreteKey,masterTable.name(),masterIds);
    }

    /**
     * 查询离散数据
     * @param masterTableName  主表
     * @param masterIds  主标主键值
     * */
    default Map<String,List<DiscreteValue>> queryValues(String masterTableName, List<String> masterIds) {
        return queryValues(DEFAULT_DISCRETE_KEY,masterTableName,masterIds);
    }

    /**
     * 查询离散数据
     * @param masterTable  主表
     * @param masterIds  主标主键值
     * */
    default Map<String,List<DiscreteValue>> queryValues(DBTable masterTable, List<String> masterIds) {
        return queryValues(DEFAULT_DISCRETE_KEY,masterTable.name(),masterIds);
    }



}
