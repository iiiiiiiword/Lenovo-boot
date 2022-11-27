package com.lenovo.store.bean.res;

import com.lenovo.store.bean.enums.CodeEnum;
import lombok.Data;

@Data
public class Result<T> {
    private Integer code = CodeEnum.SUCCESS.getCode();

    private String msg = CodeEnum.SUCCESS.getMsg();
    private Boolean success = Boolean.TRUE;

    private T data;

    private Long total;

    private Result(){}

    public static <T> Result<T> buildEmptySuccess() {
        return new Result<>();
    }
    public static <T> Result<T> buildSuccess(T t) {
        Result<T> result = buildEmptySuccess();
        result.setData(t);
        return result;
    }
    public static <T> Result<T> buildSuccess(T t,Long total) {
        Result<T> result = buildSuccess(t);
        result.setTotal(total);
        return result;
    }

    public static <T> Result<T> buildFailure(String msg) {
        Result<T> result = new Result<>();
        result.setCode(null);
        result.setMsg(msg);
        result.setSuccess(false);
        return result;
    }

    public static <T> Result<T> buildFailure(Integer code,String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setSuccess(false);
        return result;
    }

    public static <T> Result<T> buildFailure(CodeEnum codeEnum) {
        Result<T> result = new Result<>();
        result.setCode(codeEnum.getCode());
        result.setMsg(codeEnum.getMsg());
        result.setSuccess(false);
        return result;
    }


    public boolean isSuccess() {
        return success;
    }

    public boolean isFailed() {
        return !isSuccess();
    }
}
