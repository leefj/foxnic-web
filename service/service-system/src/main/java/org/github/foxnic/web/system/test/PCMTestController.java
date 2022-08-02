package org.github.foxnic.web.system.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.collection.MapUtil;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.domain.pcm.CatalogData;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.utils.PcmProxyUtil;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("PCMMTestController")
public class PCMTestController {

    /**
     * 查询类目树
     * */
    @PostMapping("/service-system/unit-test/pcm/catalog-nodes")
    public Result catalogNodesTree() {
        SessionUser sessionUser=SessionUser.getCurrent();
        if(sessionUser==null) {
            return ErrorDesc.failure(CommonError.SESSION_INVALID);
        }
        // 查询橡胶下的类目树
        Result<List<ZTreeNode>> tree= PcmProxyUtil.queryCatalogNodesTree("484764976855126017",true);
        return tree;
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
        // 查询橡胶下的类目
        Result<List<ZTreeNode>> tree= PcmProxyUtil.queryCatalogChildNodes("484764976855126017");
        return tree;
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
        Result<List<CatalogAttribute>> fields1= PcmProxyUtil.queryCatalogFields("484764976855126017");
        Result<List<CatalogAttribute>> fields2= PcmProxyUtil.queryCatalogFields("606503724902256641");

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
        Result result =PcmProxyUtil.save("606503724902256641",sessionUser.getUserId(),data);




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

        Result result=PcmProxyUtil.save("606503724902256641",sessionUser.getUserId(),list);

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

        Map<String,Object> map = new HashMap<>();

        Result result1=PcmProxyUtil.queryDataByOwnerId("606503724902256641",10,1,sessionUser.getUserId());
        JSONObject data=(JSONObject)result1.data();
        JSONArray list=data.getJSONArray("list");
        if(!list.isEmpty()) {
            Map<String,Object> data0=list.getJSONObject(0);
            String id=(String) data0.get("id");
            Result result2 = PcmProxyUtil.queryDataById("606503724902256641", id);
            map.put("queryDataById",result2.data());

            data0.put("MiD",null);
            PcmProxyUtil.save("606503724902256641",sessionUser.getUserId(),data0);
            Result result3 = PcmProxyUtil.queryDataById("606503724902256641", id);
            map.put("queryDataByIdNull",result3.data());


        }
        Result result3=PcmProxyUtil.queryDataInCatalog("606503724902256641",10,1);


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

        Result result1=PcmProxyUtil.queryDataByOwnerId("606503724902256641",10,1,sessionUser.getUserId());
        JSONObject data=(JSONObject)result1.data();
        JSONArray list=data.getJSONArray("list");
        if(!list.isEmpty()) {
            String id = list.getJSONObject(0).getString("id");
            Result result = PcmProxyUtil.deleteData("606503724902256641",id);
            return  result;
        } else {
            return ErrorDesc.failure().message("没有可删除的数据");
        }




    }








}
