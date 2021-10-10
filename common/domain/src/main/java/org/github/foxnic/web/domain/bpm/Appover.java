package org.github.foxnic.web.domain.bpm;

import org.github.foxnic.web.constants.enums.bpm.ApproverType;

/**
 * 审批人对象
 * */
public class Appover {

    private String id;
    private String name;
    private ApproverType type;

    public Appover(String id,String name,ApproverType type) {
        this.id=id;
        this.type=type;
        this.name=name;
    }

    public String getId() {
        return id;
    }

    public ApproverType getType() {
        return type;
    }

}
