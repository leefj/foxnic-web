package org.github.foxnic.web.proxy.utils;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.domain.pcm.*;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.pcm.CatalogAttributeServiceProxy;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PcmProxyUtil {

    /**
     * 查询类目节点树
     * */
    public static Result<List<ZTreeNode>> queryCatalogNodesTree(String catalogId,boolean isLoadAllDescendants) {
        CatalogVO catalog=new CatalogVO();
        catalog.setRoot(catalogId);
        catalog.setIsLoadAllDescendants(isLoadAllDescendants?1:0);
        return CatalogServiceProxy.api().queryNodes(catalog);
    }

    /**
     * 查询类目下节点清单
     * */
    public static Result<List<ZTreeNode>> queryCatalogChildNodes(String catalogId) {
        CatalogVO catalog=new CatalogVO();
        catalog.setParentId(catalogId);
        return CatalogServiceProxy.api().queryNodesFlatten(catalog);
    }


    /**
     * 查询类目下节点
     * */
    public static Result<List<CatalogAttribute>> queryCatalogFields(String catalogId) {
        CatalogAttributeVO catalog=new CatalogAttributeVO();
        catalog.setCatalogId(catalogId);
        return CatalogAttributeServiceProxy.api().queryList(catalog);
    }

    /**
     * 保存单个
     * */
    public static Result save(String catalogId,String ownerId,Map<String,Object> data) {
        CatalogData catalogData=new CatalogData();
        catalogData.setData(data);
        catalogData.setCatalogId(catalogId);
        catalogData.setOwnerId(ownerId);
        catalogData.setId((String) data.get("id"));
        return  CatalogServiceProxy.api().saveData(catalogData);
    }

    /**
     * 保存列表
     * */
    public static Result save(String catalogId,String ownerId,List<Map<String,Object>> list) {
        List<CatalogData> dataList=new ArrayList<>();
        for (Map<String, Object> map : list) {
            CatalogData catalogData=new CatalogData();
            catalogData.setCatalogId(catalogId);
            catalogData.setData(map);
            catalogData.setOwnerId(ownerId);
            catalogData.setId((String) map.get("id"));
            dataList.add(catalogData);
        }
        return  CatalogServiceProxy.api().saveDataList(dataList);
    }

    /**
     * 查询数据
     * */
    public static Result queryData(String catalogId,String[] ids,String[] ownerIds,Integer pageSize,Integer pageIndex) {
        DataQueryVo vo=new DataQueryVo();
        vo.setCatalogId(catalogId);
        vo.setIds(Arrays.asList(ids));
        vo.setPageIndex(pageIndex);
        vo.setPageSize(pageSize);
        vo.setOwnerIds(Arrays.asList(ownerIds));
        return CatalogServiceProxy.api().queryData(vo);
    }

    /**
     * 查询数据
     * */
    public static Result queryData(String catalogId,String[] ids,String[] ownerIds) {
        return queryData(catalogId,ids,ownerIds,null,null);
    }

    /**
     * 按ID查询数据
     * */
    public static Result queryDataById(String catalogId,String... id) {
         return queryData(catalogId,id,new String[0]);
    }

    /**
     * 按所有者查询数据
     * */
    public static Result queryDataByOwnerId(String catalogId,Integer pageSize,Integer pageIndex,String... ownerId) {
        return queryData(catalogId,new String[0],ownerId,pageSize,pageIndex);
    }

    /**
     * 按类目查询数据
     * */
    public static Result queryDataInCatalog(String catalogId,Integer pageSize,Integer pageIndex) {
        return queryData(catalogId,new String[0],new String[0],pageSize,pageIndex);
    }

    /**
     * 按ID删除数据
     * */
    public static Result deleteData(String catalogId, String... id) {
        DataQueryVo vo=new DataQueryVo();
        vo.setCatalogId(catalogId);
        vo.setIds(Arrays.asList(id));
        return CatalogServiceProxy.api().deleteData(vo);
    }

    /**
     * 按ID删除数据
     * */
    public static Result deleteData(String catalogId, List<String> ids) {
        DataQueryVo vo=new DataQueryVo();
        vo.setCatalogId(catalogId);
        vo.setIds(ids);
        return CatalogServiceProxy.api().deleteData(vo);
    }

}
