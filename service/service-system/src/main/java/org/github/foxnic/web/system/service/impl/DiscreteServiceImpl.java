package org.github.foxnic.web.system.service.impl;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.In;
import com.github.foxnic.sql.expr.Insert;
import com.github.foxnic.sql.expr.SQL;
import com.github.foxnic.sql.expr.Where;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_DISCRETE_INFO;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_DISCRETE_VALUE;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.DiscreteValue;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.relation.DiscreteService;
import org.github.foxnic.web.system.service.IDictItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


@Service("DiscreteService")
public class DiscreteServiceImpl implements DiscreteService {

    /**
     * 注入DAO对象
     * */
    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;

    /**
     * 获得 DAO 对象
     * */
    public DAO dao() { return dao; }

    @Resource
    private IDictItemService dictItemService;

    @Override
    public boolean saveEnumValues(String discreteKey, String masterTableName, String masterId, CodeTextEnum... enums) {
        List<String[]> codeTexts=new ArrayList<>();
        for (CodeTextEnum e : enums) {
            codeTexts.add(new String[]{e.code(),e.text()});
        }
        return this.saveValues(discreteKey, masterTableName, masterId, DISCRETE_TYPE_ENUM,enums[0].getClass().getName(),codeTexts);
    }

    @Override
    public boolean saveDictValues(String discreteKey, String masterTableName, String masterId, String dictCode,String... dictItemCodes) {

        List<DictItem> items=dictItemService.queryList(DictItem.create().setDictCode(dictCode));
        if(items==null || items.isEmpty()) {
            throw new IllegalArgumentException("字典代码 "+dictCode+" 无效");
        }
        Map<String,String> itemMap=CollectorUtil.collectMap(items,DictItem::getCode,DictItem::getLabel);
        List<String> codes=Arrays.asList(dictItemCodes);

        List<String[]> codeTexts=new ArrayList<>();
        String text = null;
        for (String code : codes) {
            text=itemMap.get(code);
            if(text==null) {
                throw new IllegalArgumentException("条目代码 "+code+" 未在字典"+dictCode+" 中定义");
            }
            codeTexts.add(new String[]{code,text});
        }
        return this.saveValues(discreteKey, masterTableName, masterId, DISCRETE_TYPE_DICT,dictCode,codeTexts);
    }

    @Override
    public boolean deleteValues(String discreteKey, String masterTableName, String masterId) {
        masterTableName=masterTableName.trim().toLowerCase();
        Long discreteId=this.dao().queryLong("select id from sys_discrete_info where  discrete_key = ? and master_table = ? and deleted = 0",discreteKey,masterTableName);
        if(discreteId==null) return false;
        int  i=this.dao().execute("delete from sys_discrete_value where discrete_id=? and master_id=?",discreteId,masterId);
        return i>0;
    }

    @Override
    public List<DiscreteValue> queryValues(String discreteKey, String masterTableName, String masterId) {
        masterTableName=masterTableName.trim().toLowerCase();
        Long discreteId=this.dao().queryLong("select id from sys_discrete_info where  discrete_key = ? and master_table = ? and deleted = 0",discreteKey,masterTableName);
        if(discreteId==null) return null;
        RcdSet rs=this.dao().query("select id,code,text,sort,master_id from sys_discrete_value where  discrete_id = ? and master_id=? and deleted = 0 order by sort asc",discreteId,masterId);
        List<DiscreteValue> list=new ArrayList<>();
        for (Rcd r : rs) {
            DiscreteValue value=new DiscreteValue();
            value.setCode(r.getString("code"));
            value.setText(r.getString("text"));
            value.setSort(r.getInteger("sort"));
            value.setMasterId(r.getString("master_id"));
            list.add(value);
        }
        return list;
    }

    @Override
    public Map<String, List<DiscreteValue>> queryValues(String discreteKey, String masterTableName, List<String> masterIds) {
        if(masterIds==null || masterIds.isEmpty()) return new HashMap<>();
        masterTableName=masterTableName.trim().toLowerCase();
        Long discreteId=this.dao().queryLong("select id from sys_discrete_info where  discrete_key = ? and master_table = ? and deleted = 0",discreteKey,masterTableName);
        if(discreteId==null) return null;
        Where where = new Where("discrete_id = ? and deleted = 0",discreteId);
        In in=new In("master_id",masterIds);
        where.and(in);
        RcdSet rs=this.dao().query("select id,master_id,code,text,sort from sys_discrete_value  "+where.getListParameterSQL()+" order by  discrete_id,sort asc",where.getListParameters());
        List<DiscreteValue> list=new ArrayList<>();
        for (Rcd r : rs) {
            DiscreteValue value=new DiscreteValue();
            value.setCode(r.getString("code"));
            value.setText(r.getString("text"));
            value.setSort(r.getInteger("sort"));
            value.setMasterId(r.getString("master_id"));
            list.add(value);
        }
        return CollectorUtil.groupBy(list,DiscreteValue::getMasterId,(e)->{return e;});
    }


    public boolean saveValues(String discreteKey, String masterTableName, String masterId, String type , String source ,List<String[]> codeTexts) {
        try {
            dao.beginTransaction();
            masterTableName=masterTableName.trim().toLowerCase();
            Rcd info=this.dao().queryRecord("select id,discrete_key,master_table from sys_discrete_info where  discrete_key = ? and master_table = ? and deleted = 0",discreteKey,masterTableName);
            Long discreteId = null;
            if(info==null) {
                discreteId = IDGenerator.getSnowflakeId();
                Insert insert = new Insert(SYS_DISCRETE_INFO.$TABLE);
                insert.set(SYS_DISCRETE_INFO.ID, discreteId);
                insert.set(SYS_DISCRETE_INFO.TYPE, type);
                insert.set(SYS_DISCRETE_INFO.SOURCE, source);
                insert.set(SYS_DISCRETE_INFO.DISCRETE_KEY, discreteKey);
                insert.set(SYS_DISCRETE_INFO.MASTER_TABLE, masterTableName);
                insert.set(SYS_DISCRETE_INFO.CREATE_TIME, new Date());
                insert.set(SYS_DISCRETE_INFO.DELETED, 0);
                dao().execute(insert);
            } else {
                discreteId=info.getLong("id");
                this.dao().execute("delete from sys_discrete_value where discrete_id=? and master_id=?",discreteId,masterId);
            }
            List<SQL> inserts=new ArrayList<>();
            for (String[] e : codeTexts) {
                Insert insert = new Insert(SYS_DISCRETE_VALUE.$TABLE);
                insert.set(SYS_DISCRETE_VALUE.ID, IDGenerator.getSnowflakeId());
                insert.set(SYS_DISCRETE_VALUE.MASTER_TABLE, masterTableName);
                insert.set(SYS_DISCRETE_VALUE.MASTER_ID, masterId);
                insert.set(SYS_DISCRETE_VALUE.CODE, e[0]);
                insert.set(SYS_DISCRETE_VALUE.TEXT, e[1]);
                insert.set(SYS_DISCRETE_VALUE.SORT, inserts.size());
                insert.set(SYS_DISCRETE_VALUE.DISCRETE_ID, discreteId);
                insert.set(SYS_DISCRETE_VALUE.DISCRETE_KEY, discreteKey);
                insert.set(SYS_DISCRETE_VALUE.CREATE_TIME, new Date());
                insert.set(SYS_DISCRETE_VALUE.DELETED, 0);
                inserts.add(insert);
            }
            dao.batchExecute(inserts);
            dao.commit();
            return true;
        } catch (Exception e) {
            dao().rollback();
            Logger.exception(e);
            return false;
        }











    }

}
