package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.api.transter.Result;

import java.util.HashMap;
import java.util.Map;

public class BpmActionResult extends Result<Map<String,Object>> {



    public Map<String, Object> getVariables() {
        return this.data();
    }

    public BpmActionResult setVariables(Map<String, Object> variables) {
        this.data(variables);
        return this;
    }

    public BpmActionResult putVariable(String name, Object value) {
        Map<String, Object> variables=this.data();
        if(variables==null) variables=new HashMap<>();
        variables.put(name,value);
        this.data(variables);
        return this;
    }


}
