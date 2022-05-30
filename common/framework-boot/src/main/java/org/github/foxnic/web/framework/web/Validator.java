package org.github.foxnic.web.framework.web;

import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.springboot.spring.BeanScopes;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;


import java.util.ArrayList;
import java.util.List;

/**
 * 数据校验器
 * */
public class Validator {

    private static interface  ValidatorFunction {
        boolean validate();
    }

    public static class ValueWrapper {
        private Validator validator;
        private String subject;
        private Object value;
        private ValueWrapper(Validator validator,String subject,Object value) {
            this.validator=validator;
            this.subject=subject;
            this.value=value;
        }
        /**
         * 返回上层校验器
         * */
        public Validator validator() {
            return this.validator;
        }

        /**
         * 必填项，非 null 或 空白字符串
         * */
        public ValueWrapper require(String message) {
            Result result=null;
            if(value==null) {
                result = ErrorDesc.failure(CommonError.PARAM_IS_REQUIRED).subject(subject);
                if(StringUtil.hasContent(message)) {
                    result.message(message);
                }
                this.validator.errors.add(result);
            } else {
                if ((value instanceof CharSequence) && StringUtil.isBlank(value)) {
                    result = ErrorDesc.failure(CommonError.PARAM_IS_REQUIRED).subject(subject);
                    if(StringUtil.hasContent(message)) {
                        result.message(message);
                    }
                    this.validator.errors.add(result);
                }
            }
            return this;
        }

        /**
         * 必填项，非 null 或 空白字符串
         * */
        public ValueWrapper require() {
            return require(null);
        }


        public ValueWrapper validate(ValidatorFunction function) {
            return this;
        }

    }



    private List<Result> errors = new ArrayList<>();

    /**
     * 校验值，如 this.validator().forValue(instance.getTitle(),"标题(title)").require();
     * */
    public ValueWrapper forValue(Object value,String subject) {
        return new ValueWrapper(this,subject,value);
    }

    /**
     * 校验值，如 this.validator().forValue(instance.getTitle()).require();
     * */
    public ValueWrapper forValue(Object value) {
        return new ValueWrapper(this,null,value);
    }

    /**
     * 是否校验成功
     * */
    public boolean success() {
        return  errors.isEmpty();
    }

    /**
     * 是否校验失败
     * */
    public boolean failure() {
        return !success();
    }

    /**
     * 返回合并的校验结果
     * */
    public Result getMergedResult() {
        return getMergedResult(CommonError.PARAM_VALUE_INVALID,null);
    }

    /**
     * 返回合并的校验结果
     * */
    public Result getMergedResult(String code) {
        return getMergedResult(code,null);
    }

    /**
     * 返回合并的校验结果
     * */
    public Result getMergedResult(String code,String message) {
        Result result=new Result();
        result.success(this.success());
        result.code(code);
        if(StringUtil.hasContent(message)) {
            result.message(message);
        }
        for (Result error : errors) {
            result.addError(error);
        }
        return result;
    }

    /**
     * 获得所有的校验失败的结果
     * */
    public List<Result> getErrors() {
        return errors;
    }

    /**
     * 返回第一个校验错误的结果
     * */
    public Result getFirstResult() {
        if(this.errors.isEmpty()) return null;
        return errors.get(0);
    }

}
