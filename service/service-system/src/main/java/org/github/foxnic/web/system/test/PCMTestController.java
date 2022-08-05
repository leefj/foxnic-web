package org.github.foxnic.web.system.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.collection.MapUtil;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.framework.web.Validator;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;
import org.github.foxnic.web.framework.pcm.PcmCatalogDelegate;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("PCMMTestController")
public class PCMTestController {

    private boolean useCatalogCode() {
        return true;
    }

    private String getCatalogIdentity(String catalogId) {

        if(useCatalogCode()) {
            Result<Catalog> result = CatalogServiceProxy.api().getById(catalogId);
            if(result.failure()) {
                throw new IllegalArgumentException(result.message());
            }
            return result.data().getCode();
        } else {
            return catalogId;
        }
    }

    public PcmCatalogDelegate createPcmCatalogDelegate(String identity) {
        SessionUser sessionUser=SessionUser.getCurrent();
        if(useCatalogCode()) {
            return new PcmCatalogDelegate(sessionUser.getActivatedTenantId(),identity);
        } else {
            return new PcmCatalogDelegate(sessionUser.getUserId(),identity);
        }
    }




    /**
     * 查询类目树
     * */
    @PostMapping("/service-system/unit-test/pcm/catalog-nodes")
    public Result catalogNodesTree() {
        SessionUser sessionUser=SessionUser.getCurrent();
        if(sessionUser==null) {
            return ErrorDesc.failure(CommonError.SESSION_INVALID);
        }
        PcmCatalogDelegate delegate=this.createPcmCatalogDelegate(getCatalogIdentity("484764976855126017"));
        // 查询橡胶下的类目树
        Result<List<ZTreeNode>> result1= delegate.queryNodesTree(true);
        Result<List<ZTreeNode>> result2= delegate.queryNodesTree(false);
        Map map=MapUtil.asMap("All-Descendants",result1.data(),"No-Descendants",result2.data());
        return ErrorDesc.success().data(map);
    }


    /**
     * 查询类目下的所有子类目
     * */
    @PostMapping("/service-system/unit-test/pcm/catalog-nodes-flatten")
    public Result catalogNodesFlatten() {
        SessionUser sessionUser=SessionUser.getCurrent();
        if(sessionUser==null) {
            return ErrorDesc.failure(CommonError.SESSION_INVALID);
        }

        // 海南橡胶
         String catalogId="606503724902256641";
        // 金杰的
//        String catalogId="486917609841758209";

        PcmCatalogDelegate delegate=this.createPcmCatalogDelegate(getCatalogIdentity(catalogId));

        Validator validator=new Validator();

        // 查询橡胶下的类目
        Result<List<ZTreeNode>> result1= delegate.queryNodesFlatten(true,true);
        validator.asserts(result1.data().size(),"祖先和子孙都加载时数量错误").mustInList(5);


        Result<List<ZTreeNode>> result2= delegate.queryNodesFlatten(false,false);
        validator.asserts(result2.data().size(),"祖先和子孙都不加载是数量错误").mustInList(2);


        if(validator.failure()) {
            return validator.getMergedResult();
        }


        Map map=MapUtil.asMap(
                "Ancestors:true,Descendants:true",result1.data(),
                "Ancestors:false,Descendants:false",result2.data()
        );
        return ErrorDesc.success().data(map);
    }


    /**
     * 查询类目下的所有字段
     * */
    @PostMapping("/service-system/unit-test/pcm/catalog-fields")
    public Result catalogFields() {
        SessionUser sessionUser=SessionUser.getCurrent();
        if(sessionUser==null) {
            return ErrorDesc.failure(CommonError.SESSION_INVALID);
        }

        PcmCatalogDelegate delegate1=this.createPcmCatalogDelegate(getCatalogIdentity("484764976855126017"));
        PcmCatalogDelegate delegate2=this.createPcmCatalogDelegate(getCatalogIdentity("606503724902256641"));

        Result<List<CatalogAttribute>> fields1= delegate1.queryFields();
        Result<List<CatalogAttribute>> fields2= delegate2.queryFields();

        Map<String,List<CatalogAttribute>> map=new HashMap<>();
        map.put("橡胶(484764976855126017)",fields1.data());
        map.put("海南橡胶(606503724902256641)",fields2.data());

        return  ErrorDesc.success().data(map);
    }


    /**
     * 保存单个数据
     * */
    @PostMapping("/service-system/unit-test/pcm/single-save")
    public Result singleSave() {
        SessionUser sessionUser=SessionUser.getCurrent();
        if(sessionUser==null) {
            return ErrorDesc.failure(CommonError.SESSION_INVALID);
        }

        Map<String,Object> data= MapUtil.asMap(
                "ChenF","橡胶",
                "DaiM","HNXJ-001",
                "MingC","海南橡胶-001",
                "TanXJB",8.6,
                "MiD",7.2
        );

        PcmCatalogDelegate delegate=this.createPcmCatalogDelegate(getCatalogIdentity("606503724902256641"));
        Result result = delegate.saveData(sessionUser.getUserId(),data);

        return  result;
    }


    /**
     * 保存多个数据
     * */
    @PostMapping("/service-system/unit-test/pcm/batch-save")
    public Result batchSave() {
        SessionUser sessionUser=SessionUser.getCurrent();
        if(sessionUser==null) {
            return ErrorDesc.failure(CommonError.SESSION_INVALID);
        }

        List<Map<String,Object>> list=new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Map<String,Object> data= MapUtil.asMap(
                    "ChenF","橡胶",
                    "DaiM","HNXJ-001",
                    "MingC","海南橡胶-001",
                    "TanXJB",8.6,
                    "MiD",7.2
            );
            list.add(data);
        }

        PcmCatalogDelegate delegate=this.createPcmCatalogDelegate(getCatalogIdentity("606503724902256641"));

        Result result= delegate.saveData(sessionUser.getUserId(),list);
        return  result;
    }

    /**
     * 获得数据
     * */
    @PostMapping("/service-system/unit-test/pcm/get-data")
    public Result getData() {
        SessionUser sessionUser=SessionUser.getCurrent();
        if(sessionUser==null) {
            return ErrorDesc.failure(CommonError.SESSION_INVALID);
        }

        PcmCatalogDelegate delegate=this.createPcmCatalogDelegate(getCatalogIdentity("606503724902256641"));

        Map<String,Object> map = new HashMap<>();

        Result result1= delegate.queryDataByOwnerId(10,1,sessionUser.getUserId());
        JSONObject data=(JSONObject)result1.data();
        JSONArray list=data.getJSONArray("list");
        if(!list.isEmpty()) {
            Map<String,Object> data0=list.getJSONObject(0);
            String id=(String) data0.get("id");
            Result result2 = delegate.queryDataById(id);
            map.put("queryDataById",result2.data());

            data0.put("MiD",null);
            delegate.saveData(sessionUser.getUserId(),data0);
            Result result3 = delegate.queryDataById("606503724902256641", id);
            map.put("queryDataByIdNull",result3.data());


        }
        Result result3= delegate.queryDataInCatalog(10,1);


        map.put("queryDataByOwnerId",result1.data());
        map.put("queryDataInCatalog",result3.data());

        return ErrorDesc.success().data(map);
    }

    /**
     * 获得数据
     * */
    @PostMapping("/service-system/unit-test/pcm/delete-data")
    public Result deleteData() {
        SessionUser sessionUser=SessionUser.getCurrent();
        if(sessionUser==null) {
            return ErrorDesc.failure(CommonError.SESSION_INVALID);
        }

        PcmCatalogDelegate delegate=this.createPcmCatalogDelegate(getCatalogIdentity("606503724902256641"));


        Result result1= delegate.queryDataByOwnerId(10,1,sessionUser.getUserId());
        JSONObject data=(JSONObject)result1.data();
        JSONArray list=data.getJSONArray("list");
        if(!list.isEmpty()) {
            String id = list.getJSONObject(0).getString("id");
            Result result = delegate.deleteData(id);
            return  result;
        } else {
            return ErrorDesc.failure().message("没有可删除的数据");
        }




    }








}
