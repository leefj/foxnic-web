package org.github.foxnic.web.framework.web;

import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.springboot.spring.BeanScopes;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 数据校验器
 * */
public class Validator {

    private static interface  SingleValueValidatorFunction<T> {
        Result validate(T value);
    }

    public static class ValueWrapper<T> {
        private Validator validator;
        private String subject;
        private T value;
        private ValueWrapper(Validator validator,String subject,T value) {
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
        public ValueWrapper<T> require(String message) {
            Result result=null;
            if(value==null) {
                result = ErrorDesc.failure(CommonError.PARAM_IS_REQUIRED).subject(subject);
                if(StringUtil.hasContent(message)) {
                    result.message(message);
                }
                this.validator.errors.add(result);
            } else {
                boolean failure =false;
                if ((value instanceof CharSequence) && StringUtil.isBlank(value)) {
                   failure =true;
                } else if ((value instanceof Collection) && ((Collection)value).isEmpty()) {
                    failure =true;
                }
                if(failure) {
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
        public ValueWrapper<T> require() {
            return require(null);
        }

        /**
         *  值必须在指定的列表范围内
         * */
        public ValueWrapper<T> canNotInList(T... value) {
            return canNotInList("",value);
        }

        /**
         * 值必须在指定的列表范围内
         */
        public ValueWrapper<T> canNotInList(String message, T... value) {
            for (T o : value) {
                if (o == null) continue;
                if (o.equals(this.value)) {
                    Result result = ErrorDesc.failure(CommonError.VALUE_CAN_NOT_IN_LIST).subject(subject);
                    if (StringUtil.hasContent(message)) {
                        result.message(message);
                    }
                    this.validator.errors.add(result);
                    break;
                }
            }
            return this;
        }

        /**
         *  值必须在指定的列表范围内
         * */
        public ValueWrapper<T> mustInList(T... value) {
            return  mustInList("",value);
        }

        /**
         *  值必须在指定的列表范围内
         * */
        public ValueWrapper<T> mustInList(String message, T... value) {
            for (T o : value) {
                if(o==null) continue;
                if(!o.equals(this.value)) {
                    Result result = ErrorDesc.failure(CommonError.VALUE_MUST_IN_LIST).subject(subject);
                    if (StringUtil.hasContent(message)) {
                        result.message(message);
                    }
                    this.validator.errors.add(result);
                    break;
                }
            }
            return this;
        }


        public ValueWrapper<T> validate(SingleValueValidatorFunction function) {
            Result result=function.validate(this.value);
            if(result.success()) return this;
            else {
                this.validator.errors.add(result);
            }
            return this;
        }

        public ValueWrapper<T> greaterThan(T value) {
            return greaterThan("",value);
        }
        public ValueWrapper<T> greaterThan(String message, T value) {
            boolean r=true;
            String msg=null;
            if(this.value==null || value==null) {
                r=false;
                msg = "比较值不允许为null";
            }
            else {
                BigDecimal a= DataParser.parseBigDecimal(this.value);
                BigDecimal b= DataParser.parseBigDecimal(value);
                if(a.compareTo(b)!=1) {
                    r=false;
                    msg = "必须大于 "+value;
                }
            }
            if(!r) {
                Result result = ErrorDesc.failure(CommonError.VALUE_MUST_IN_LIST).subject(subject).message(msg);
                this.validator.errors.add(result);
            }
            return this;
        }



        /**
         * 校验值，如 this.validator().forValue(instance.getTitle(),"标题(title)").require();
         * */
        public <T> ValueWrapper asserts(T value,String subject) {
            return this.validator().asserts(value,subject);
        }

        /**
         * 校验值，如 this.validator().forValue(instance.getTitle()).require();
         * */
        public <T> ValueWrapper asserts(T value) {
            return this.validator().asserts(value);
        }

        public boolean failure() {
            return this.validator().failure();
        }

    }



    private List<Result> errors = new ArrayList<>();

    /**
     * 校验值，如 this.validator().forValue(instance.getTitle(),"标题(title)").require();
     * */
    public <T> ValueWrapper asserts(T value,String subject) {
        return new ValueWrapper(this,subject,value);
    }

    /**
     * 校验值，如 this.validator().forValue(instance.getTitle()).require();
     * */
    public <T> ValueWrapper asserts(T value) {
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
