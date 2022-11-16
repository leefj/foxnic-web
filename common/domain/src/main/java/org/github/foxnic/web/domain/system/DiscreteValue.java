package org.github.foxnic.web.domain.system;

public class DiscreteValue {


    private String masterId;
    private String code;
    private String text;
    private Integer sort;


    public String getCode() {
        return code;
    }



    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }





}
