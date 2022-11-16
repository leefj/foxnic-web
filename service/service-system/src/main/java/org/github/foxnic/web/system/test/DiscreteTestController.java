package org.github.foxnic.web.system.test;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.domain.system.DiscreteValue;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.language.Language;
import org.github.foxnic.web.relation.DiscreteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController("DiscreteTestController")
public class DiscreteTestController {


    /**
     * 注入DAO对象
     * */
    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;

    @Resource
    private DiscreteService discreteService=null;

    @PostMapping("/service-system/unit-test/discrete-test-1")
    public Result test1() {


        // 保存枚举
        boolean suc = false;
        suc=discreteService.saveEnumValues("sys_user","633227879517257728", Language.defaults,Language.en_gb);
        suc=discreteService.saveEnumValues("sys_user","617804446981685248", Language.zh_cn,Language.en_gb);

        // 查询单个
        List<DiscreteValue> values =  discreteService.queryValues("sys_user","633227879517257728");

        // 查询多个
        Map<String,List<DiscreteValue>> map =  discreteService.queryValues("sys_user", Arrays.asList("633227879517257728","617804446981685248"));

        // 保存字典
        suc=discreteService.saveDictValues("sys_role","633227879517257728", "ops_voucher_type","app","vmware");

        // 清除数据
        suc= discreteService.deleteValues("t1","001");


        // 表关联
        RcdSet rs=dao.query("select a.id,a.account,a.real_name,b.code,b.text,b.sort from sys_user a join sys_discrete_value b on b.discrete_key='/' and  b.master_table='sys_user' and b.master_id=a.id and b.deleted=0");

        return ErrorDesc.success().data(values);

    }


}
