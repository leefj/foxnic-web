package org.github.foxnic.web.domain.bpm;

import org.github.foxnic.web.constants.enums.system.UnifiedUserType;

/**
 * 审批人对象
 * */
public class Appover {

    private String id;
    private String code;
    private String name;
    private UnifiedUserType type;

    public Appover(String id, String code, String name, UnifiedUserType type) {
        this.id=id;
        this.type=type;
        this.name=name;
        this.code=code;
    }

    public String getId() {
        return id;
    }

    public UnifiedUserType getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
