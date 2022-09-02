package org.github.foxnic.web.system.test;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.dao.spec.DBSequence;
import com.github.foxnic.springboot.mvc.ParameterFilter;
import com.github.foxnic.springboot.mvc.Validator;
import com.github.foxnic.springboot.spring.SpringUtil;
import io.undertow.servlet.core.ManagedFilters;
import org.github.foxnic.web.domain.oauth.LoginIdentityVO;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.oauth.UserVO;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.DictItemVO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.framework.licence.LicenceProxy;
import org.github.foxnic.web.proxy.camunda.CamundaUserServiceProxy;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.github.foxnic.web.proxy.utils.DictProxyUtil;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

@RestController("UnitTestController")
public class UnitTestController {

    /**
     * 注入DAO对象
     * */
    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;

    @PostMapping("/service-system/unit-test/sequence")
    public Result sequence() {
//        String sequenceId="qualityReportId";
        String sequenceId="TEST-004";



//        File file=new File("D:\\leefj\\workspace\\git-base\\foxnic-grant\\licence\\community\\community.lic");
//        LicenceProxy.LICENCE_DATA= FileUtil.readText(file);

        String val = null;
        try {
            DBSequence sequence=dao.getSequence(sequenceId);
            val=sequence.next();
            dao.execute("insert into sys_sequence_test (sequence_id,sequence_value,create_time) values(?,?,?)",sequenceId,val,new Date());
            return ErrorDesc.success().data(val);
        } catch (Exception e) {
            val = "error:"+ IDGenerator.getSnowflakeIdString();
            dao.execute("insert into sys_sequence_test (sequence_id,sequence_value,exception,create_time) values(?,?,?,?)",sequenceId,val, StringUtil.toString(e),new Date());
            return ErrorDesc.exception(e);
        }
    }



    @PostMapping("/service-system/unit-test/cluster-1")
    public Result cluster1() {
        SessionUser user=SessionUser.getCurrent();
        Result result= CamundaUserServiceProxy.api().getById("123");
        return ErrorDesc.success().data(result.data());
    }

    @PostMapping("/service-system/unit-test/update-licence-local")
    public Result updateLicenceLocal() {
        File file=new File("D:\\leefj\\workspace\\git-base\\foxnic-grant\\licence\\community\\community.lic");

        LicenceProxy.LICENCE_DATA= FileUtil.readText(file);
        while (LicenceProxy.LICENCE_DATA!=null) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
        LicenceProxy.reset();

        JSONObject licence=LicenceProxy.getLicence();

        return ErrorDesc.success().data(licence);
    }

    @PostMapping("/service-system/unit-test/dict-1")
    public Result dict1() {
        List<DictItem> items = DictProxyUtil.getList("ops_host_type");
        int i= (int) (Math.random() * items.size());
        System.out.println("i="+i);
        DictItem itemSource=items.get(i);
        DictItem itemTarget=DictProxyUtil.getDictItem(itemSource.getDictCode(),itemSource.getCode());
        Map map= MapUtil.asMap("items",items,"itemSource",itemSource,"itemTarget",itemTarget);
        return ErrorDesc.success().data(map);
    }


    @PostMapping("/service-system/unit-test/lic")
    public Result lic() {

//        System.out.println("KE-11="+LicenceProxy.DP_CODE);
//        try {
//            LicenceProxy.DP_CODE = null;
//        } catch (Throwable t) {
//            t.printStackTrace();
//        }
//        System.out.println("KE-22="+LicenceProxy.DP_CODE);

        ParameterFilter p=ParameterFilter.getInstance();

//        ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        ServletContext context=request.getServletContext();
        Object deployment= BeanUtil.getFieldValue(context,"deployment");
        Object managedFilters=BeanUtil.getFieldValue(deployment,"filters");
        Map map=BeanUtil.getFieldValue(managedFilters,"managedFilterMap",Map.class);
        List filters=new ArrayList();
        for (Object value : map.values()) {
            filters.add(value);
        }
        Boolean isInLimitGoods=LicenceProxy.isInDataLimit("goodsLimit");
        Boolean isInLimitNews=LicenceProxy.isInDataLimit("newsLimit");

        Map<String,Boolean> map2=MapUtil.asMap("isInLimitGoods",isInLimitGoods,"isInLimitNews",isInLimitNews);

        if(isInLimitNews) {
            return ErrorDesc.failure().message("数据超出许可限制");
        }

        return ErrorDesc.success().data(map2);

    }

    @PostMapping("/service-system/unit-test/lic-sample")
    public Result licSample() {
        Boolean isInLimitGoods=LicenceProxy.isInDataLimit("goodsLimit");

        if(isInLimitGoods) {
            return ErrorDesc.failure().message("数据超出许可限制");
        }

        dao.execute("insert xxxx");

        return ErrorDesc.success();

    }


    @PostMapping("/service-system/unit-test/bean")
    public Result beanTest(UserVO userParam, LoginIdentityVO loginIdentityParam) {

        Validator validator=new Validator();

        validator.asserts(EntityContext.isManaged(userParam)).requireEqual("userParam 需要被 Manage",true);
        validator.asserts(EntityContext.isManaged(loginIdentityParam)).requireEqual("userParam 不需要被 Manage",false);

        User user= UserServiceProxy.api().getByAccount("admin").data();
        validator.asserts(EntityContext.isManaged(user)).requireEqual("user 需要被 Manage",true);

        UserVO userVO=user.toPojo(UserVO.class);
        validator.asserts(EntityContext.isManaged(userVO)).requireEqual("userVO 需要被 Manage",true);

        return validator.getMergedResult();

    }


}
