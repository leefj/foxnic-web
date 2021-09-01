package org.github.foxnic.web.domain.pcm;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum DataType implements CodeTextEnum {

    STRING("字符串"),INTEGER("整数"),DECIMAL("小数"),
    DATE_TIME("日期时间"),LOGIC("逻辑值");

    private String text;

    private DataType(String text)  {
        this.text=text;
    }

    public String code() {
        return this.name();
    }

    public String text() {
        return text;
    }

}
