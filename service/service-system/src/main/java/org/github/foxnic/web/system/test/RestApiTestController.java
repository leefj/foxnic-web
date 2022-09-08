package org.github.foxnic.web.system.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.mvc.RequestParameter;
import com.github.foxnic.springboot.spring.SpringUtil;
import com.github.foxnic.springboot.web.WebContext;
import org.github.foxnic.web.domain.bpm.ProcessStartVO;
import org.github.foxnic.web.domain.oauth.RoleVO;
import org.github.foxnic.web.domain.oauth.UserVO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.RequestParamMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.PathVariableMethodArgumentResolver;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("RestApiTestController")
public class RestApiTestController {

    /**
     * 注入DAO对象
     * */
    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;

    @PostMapping("/service-system/unit-test/rest/io/simple")
    public Result simple(Integer id,String name) {
        Result result=ErrorDesc.success();
        Map<String,Object> data=new HashMap<>();
        data.put("id",id);
        data.put("name",name);
        Logger.info("这是日志");
        result.data(data);
        return result;
    }


    @PostMapping("/service-system/unit-test/rest/io/simple/{id},{name}")
    public Result simple4Path(@PathVariable Integer id, @PathVariable String name) {
        RequestParameter ps=RequestParameter.get();

        Result result=ErrorDesc.success();
        Map<String,Object> data=new HashMap<>();
        data.put("id",id);
        data.put("name",name);

        data.put("id2",ps.get("id"));
        data.put("name2",ps.get("name"));

        Logger.info("这是日志");
        result.data(data);
        return result;
    }

    @PostMapping("/service-system/unit-test/rest/io/array")
    public Result array(Integer id,String name,Integer[] ids,String[] names) {
        Result result=ErrorDesc.success();
        Map<String,Object> data=new HashMap<>();
        data.put("id",id);
        data.put("name",name);
        data.put("ids",ids);
        data.put("names",names);
        result.data(data);
        return result;
    }

    @PostMapping("/service-system/unit-test/rest/io/list")
    public Result list(Integer id, String name, List<Integer>ids, List<String> names) {
        Result result=ErrorDesc.success();
        Map<String,Object> data=new HashMap<>();
        data.put("id",id);
        data.put("name",name);
        data.put("ids",ids);
        data.put("names",names);
        result.data(data);
        return result;
    }

    @PostMapping("/service-system/unit-test/rest/io/map")
    public Result map(Integer id, String name, Map<Integer,String> ids, Map<String, BigDecimal> names) {
        Result result=ErrorDesc.success();
        Map<String,Object> data=new HashMap<>();
        data.put("id",id);
        data.put("name",name);
        data.put("ids",ids);
        data.put("names",names);
        result.data(data);
        return result;
    }

    @PostMapping("/service-system/unit-test/rest/io/list-map")
    public Result listmap(Integer id, String name, List<String> ids, Map<String,String> names) {
        Result result=ErrorDesc.success();
        Map<String,Object> data=new HashMap<>();
        data.put("id",id);
        data.put("name",name);
        data.put("ids",ids);
        data.put("names",names);
        result.data(data);
        return result;
    }

    /**
     * 有异常，待解决
     * */
    @PostMapping("/service-system/unit-test/rest/io/json")
    public Result json(Integer id, String name, JSONArray ids, @RequestBody JSONObject names) {
        org.springframework.validation.support.BindingAwareModelMap map=null;
        Result result=ErrorDesc.success();
        Map<String,Object> data=new HashMap<>();
        data.put("id",id);
        data.put("name",name);
        data.put("ids",ids);
        data.put("names",names);
        result.data(data);
        return result;
    }

    @PostMapping("/service-system/unit-test/rest/io/vo1")
    public Result vo1(UserVO userVO) {
        Result result=ErrorDesc.success();
        Map<String,Object> data=new HashMap<>();
//        List<Role> roles=userVO.getRoles();
//        List<Menu> menus=roles.get(0).getMenus();
//        for (Menu menu : menus) {
//            System.out.println(menu.getId());
//        }
        data.put("userVO",userVO);
        result.data(data);
        return result;
    }

    @PostMapping("/service-system/unit-test/rest/io/vo1-list")
    public Result vo1List(List<UserVO> userVOList) {
        Result result=ErrorDesc.success();
        Map<String,Object> data=new HashMap<>();
//        List<Role> roles=userVO.getRoles();
//        List<Menu> menus=roles.get(0).getMenus();
//        三层 model 转换失败
//        for (Menu menu : menus) {
//            System.out.println(menu.getId());
//        }
        data.put("userVOList",userVOList);
        result.data(data);
        return result;
    }

    @PostMapping("/service-system/unit-test/rest/io/vo2")
    public Result vo2(UserVO userVO, RoleVO roleVO) {
        Result result=ErrorDesc.success();
        Map<String,Object> data=new HashMap<>();
        data.put("userVO",userVO);
        data.put("roleVO",roleVO);
        result.data(data);
        return result;
    }

    @PostMapping("/service-system/unit-test/rest/io/vo2-list")
    public Result vo2list(UserVO userVO, RoleVO roleVO,List<UserVO> userVOList, List<RoleVO> roleVOList) {
        Result result=ErrorDesc.success();
        Map<String,Object> data=new HashMap<>();
        data.put("userVO",userVO);
        data.put("roleVO",roleVO);
        data.put("userVOList",userVOList);
        data.put("roleVOList",roleVOList);
        result.data(data);
        return result;
    }

    @PostMapping("/service-system/unit-test/rest/io/vo2-arr")
    public Result vo2arr(UserVO userVO, RoleVO roleVO,UserVO[] userVOArr, RoleVO[] roleVOArr) {
        Result result=ErrorDesc.success();
        Map<String,Object> data=new HashMap<>();
        data.put("userVO",userVO);
        data.put("roleVO",roleVO);
        data.put("userVOArr",userVOArr);
        data.put("roleVOArr",roleVOArr);
        result.data(data);
        return result;
    }

    @PostMapping("/service-system/unit-test/rest/io/vo2-map")
    public Result vo2map(UserVO userVO, RoleVO roleVO,Map<String,UserVO> userVOMap, Map<Integer,RoleVO> roleVOMap) {
        Result result=ErrorDesc.success();
        Map<String,Object> data=new HashMap<>();
        data.put("userVO",userVO);
        data.put("roleVO",roleVO);
        data.put("userVOMap",userVOMap);
        data.put("roleVOMap",roleVOMap);
        result.data(data);
        return result;
    }

    @PostMapping("/service-system/unit-test/rest/io/map-prop")
    public Result vo2map(ProcessStartVO startVO) {
        Result result=ErrorDesc.success();
        Map<String,Object> data=new HashMap<>();
        data.put("startVO",startVO);
        result.data(data);
        return result;
    }


}
