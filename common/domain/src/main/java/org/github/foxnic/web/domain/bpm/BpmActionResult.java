package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.api.transter.Result;

import java.util.HashMap;
import java.util.Map;

public class BpmActionResult extends Result {

    private Map<String, Object> variables=new HashMap<>();

    public Map<String, Object> getVariables() {
        return this.variables;
    }

    public BpmActionResult setVariables(Map<String, Object> variables) {
        this.variables=variables;
        return this;
    }

    public BpmActionResult putVariable(String name, Object value) {
        variables.put(name,value);
        return this;
    }

}
