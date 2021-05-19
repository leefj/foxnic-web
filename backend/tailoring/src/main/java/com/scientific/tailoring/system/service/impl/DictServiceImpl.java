package com.scientific.tailoring.system.service.impl;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.commons.lang.function.SetterFunction;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.CollectorUtil;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.scientific.tailoring.domain.system.Dict;
import com.scientific.tailoring.domain.system.DictItem;
import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.system.service.IDictItemService;
import com.scientific.tailoring.system.service.IDictService;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-22 01:32:50
*/

@Service("SysDictServiceImpl")
public class DictServiceImpl extends SuperService<Dict> implements IDictService {
	
	@Autowired
	private IDictItemService dictItemService;
	
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
	
	/**
	 * 按主键删除数据字典
	 *
	 * @param id 字典ID , 详情 : 字典ID
	 * @return 查询结果 , Dict对象
	 */
	public boolean deleteByIdPhysical(Integer id) {
		Dict dict = new Dict();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		dict.setId(id);
		return dao.deleteEntity(dict);
	}
	
	/**
	 * 按主键删除数据字典
	 *
	 * @param id 字典ID , 详情 : 字典ID
	 * @return 查询结果 , Dict对象
	 */
	public boolean deleteByIdLogical(Integer id) {
		Dict dict = new Dict();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		dict.setId(id);
		dict.setDeleted(true);
		dict.setDeleteBy((Long)dao.getDBTreaty().getLoginUserId());
		dict.setDeleteTime(new Date());
		return dao.updateEntity(dict,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 按主键获取数据字典
	 *
	 * @param id 字典ID
	 * @return 查询结果 , Dict对象
	 */
	public Dict getById(Integer id) {
		Dict sample = new Dict();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	private LocalCache<String,Map<String,String>> LABEL_CACHE=new LocalCache<>();

	public Map<String,String> getDictItems(String dictCode){
		Map<String,String> labels=LABEL_CACHE.get(dictCode);
		if(labels==null) {
			List<DictItem> items= dictItemService.queryByDictCode(dictCode);
			labels=CollectorUtil.collectMap(items, DictItem::getCode, DictItem::getLabel);
			LABEL_CACHE.put(dictCode, labels);
		}
		return labels;
	}

	@Override
	public <T> void translate(String dictCode,List<T> list,Function<? super T, String> getter,SetterFunction<T,String> setter) { //
		Map<String,String> labels=getDictItems(dictCode);
		if(labels==null) {
			throw new IllegalArgumentException("数据字典 "+dictCode+" 未定义");
		}
		String itemCode=null;
		String label=null;
		for (T e : list) {
			itemCode=getter.apply(e);
			label=labels.get(itemCode);
			setter.apply(e,label);
		}
 
	}

	@Override
	public JSONObject queryAll4JsDict() {
		RcdSet rs=dao.query("select code,label,dict_code from sys_dict_item a where deleted=0 and exists( select 1 from sys_dict b where deleted=0 and a.dict_code=b.code) ORDER BY dict_code,sort asc ");
		Map<String, List<Rcd>>  map=rs.getGroupedMap("dict_code",String.class);
		JSONObject dictJson=new JSONObject();
		for (Entry<String, List<Rcd>> e : map.entrySet()) {
			JSONObject items=new JSONObject();
			for (Rcd r : e.getValue()) {
				items.put(r.getString("code"), r.getString("label"));
			}
			dictJson.put(e.getKey(), items);
		}
		return dictJson;
	}
 

}