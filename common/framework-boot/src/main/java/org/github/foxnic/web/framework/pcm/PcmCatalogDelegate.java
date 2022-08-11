package org.github.foxnic.web.framework.pcm;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.domain.pcm.*;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.pcm.CatalogAttributeServiceProxy;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PcmCatalogDelegate {


    private String catalogId;
    public PcmCatalogDelegate(String catalogId) {
        this.catalogId=catalogId;
        Result<Catalog> result = CatalogServiceProxy.api().getById(catalogId);
        if(result.failure()) {
            throw new IllegalArgumentException(result.message());
        }
    }

    public PcmCatalogDelegate(String tenantId,String catalogCode) {

        CatalogVO vo=new CatalogVO();
        vo.setCode(catalogCode);
        vo.setTenantId(tenantId);
        Result<List<Catalog>> result = CatalogServiceProxy.api().queryList(vo);
        if(result.failure()) {
            throw new IllegalArgumentException(result.message());
        }
        if(result.data()==null || result.data().isEmpty()) {
            throw new IllegalArgumentException("类目 "+catalogCode+" 不存在");
        }
        this.catalogId=result.data().get(0).getId();
    }


    /**
     * 查询类目节点树
     * */
    public Result<List<ZTreeNode>> queryNodesTree(boolean isLoadAllDescendants) {
        CatalogVO catalog=new CatalogVO();
        catalog.setRoot(catalogId);
        catalog.setIsLoadAllDescendants(isLoadAllDescendants?1:0);
        return CatalogServiceProxy.api().queryNodes(catalog);
    }

    /**
     * 查询类目下节点清单
     * */
    public Result<List<ZTreeNode>> queryNodesFlatten(boolean isLoadAllAncestors,boolean isLoadAllDescendants) {
        CatalogVO catalog=new CatalogVO();
        catalog.setParentId(catalogId);
        catalog.setIsLoadAllDescendants(isLoadAllDescendants?1:0);
        catalog.setIsLoadAllAncestors(isLoadAllAncestors?1:0);
        return CatalogServiceProxy.api().queryNodesFlatten(catalog);
    }


    /**
     * 查询类目下节点
     * */
    public Result<List<CatalogAttribute>> queryFields() {
        CatalogAttributeVO catalog=new CatalogAttributeVO();
        catalog.setCatalogId(catalogId);
        return CatalogAttributeServiceProxy.api().queryList(catalog);
    }

    /**
     * 保存单个
     * */
    public Result saveData(String ownerId,Map<String,Object> data) {
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
    public Result saveData(String ownerId,List<Map<String,Object>> list) {
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
    public Result queryData(String[] ids,String[] ownerIds,Integer pageSize,Integer pageIndex) {
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
    public Result queryData(String[] ids,String[] ownerIds) {
        return queryData(ids,ownerIds,null,null);
    }

    /**
     * 按ID查询数据
     * */
    public Result queryDataById(String... id) {
         return queryData(id,new String[0]);
    }

    /**
     * 按所有者查询数据
     * */
    public Result queryDataByOwnerId(Integer pageSize,Integer pageIndex,String... ownerId) {
        return queryData(new String[0],ownerId,pageSize,pageIndex);
    }

    /**
     * 按类目查询数据
     * */
    public Result queryDataInCatalog(Integer pageSize,Integer pageIndex) {
        return queryData(new String[0],new String[0],pageSize,pageIndex);
    }

    /**
     * 按ID删除数据
     * */
    public Result deleteData(String... id) {
        DataQueryVo vo=new DataQueryVo();
        vo.setCatalogId(catalogId);
        vo.setIds(Arrays.asList(id));
        return CatalogServiceProxy.api().deleteData(vo);
    }

    /**
     * 按ID删除数据
     * */
    public Result deleteData(List<String> ids) {
        DataQueryVo vo=new DataQueryVo();
        vo.setCatalogId(catalogId);
        vo.setIds(ids);
        return CatalogServiceProxy.api().deleteData(vo);
    }

}
