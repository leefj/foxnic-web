package org.github.foxnic.web.framework.bpm;

import com.github.foxnic.commons.lang.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class BpmConfigs {

    @Value("${foxnic.bpm.enable:false}")
    private Boolean enable;

    @Value("${foxnic.bpm.debug.enable:false}")
    private Boolean enableDebug;

    @Value("${foxnic.bpm.debug.process-definition-code-list}")
    private String processDefinitionCodeList=null;

    /**
     * 是否开启 BPM
     * */
    public boolean isEnableBpm() {
        return enable;
    }

    /**
     * 是否开启 BPM 调试
     * */
    public boolean isEnableBpmDebug() {
        return enableDebug;
    }


    private Set<String> processDefinitionCodeSet = null;
    /**
     * 是否在调试范围内
     * */
    public boolean isInRange(String processDefinitionCode) {
        // 如果未开启调试，全部在范围内
        if(!isEnableBpmDebug()) return true;
        if(StringUtil.isBlank(processDefinitionCodeList)) return true;
        initCodeSet();
        return  processDefinitionCodeSet.contains(processDefinitionCode);
    }

    private void initCodeSet() {
        if(processDefinitionCodeSet==null) {
            processDefinitionCodeSet = new HashSet<>();
            String[] tmp=processDefinitionCodeList.split(",");
            for (String s : tmp) {
                processDefinitionCodeSet.add(s.trim());
            }
        }
    }

    public List<String> getProcessDefinitionCodeInRange() {
        initCodeSet();
        List<String> list=new ArrayList<>();
        list.addAll(processDefinitionCodeSet);
        return list;
    }


}
