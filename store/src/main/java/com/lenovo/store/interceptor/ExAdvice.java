package com.lenovo.store.interceptor;

import com.lenovo.store.bean.enums.CodeEnum;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.ex.BizEx;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class ExAdvice {

    @ExceptionHandler(BindException.class)
    public Result<String> handleEx(BindException e) {
        log.error("参数绑定异常",e);
        List<FieldError> fieldErrors = e.getFieldErrors();
        return Result.buildFailure(spliceErrMsg(fieldErrors));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> handleEx(MethodArgumentNotValidException e) {
        log.error("入参校验失败",e);
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        return Result.buildFailure(spliceErrMsg(fieldErrors));
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public Result<String> handleEx(IllegalArgumentException e) {
        log.error("参数非法",e);
        return Result.buildFailure(CodeEnum.PARAM_ERR);
    }
    @ExceptionHandler(BadSqlGrammarException.class)
    public Result<String> handleEx(BadSqlGrammarException e) {
        log.error("数据库异常",e);
        return Result.buildFailure(CodeEnum.DB_ERR);
    }
    @ExceptionHandler(DuplicateKeyException.class)
    public Result<String> handleEx(DuplicateKeyException e) {
        log.error("唯一性约束校验失败",e);
        return Result.buildFailure(CodeEnum.DUPLICATE_KEY_ERR);
    }
    @ExceptionHandler(BizEx.class)
    public Result<String> handleEx(BizEx e) {
        log.error("业务异常",e);
        return Result.buildFailure(e.getCode(),e.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public Result<String> handleEx(Exception e) {
        log.error("处理未精准匹配的异常",e);
        return Result.buildFailure(CodeEnum.SYS_ERR);
    }
    private String spliceErrMsg(List<FieldError> fieldErrors) {
        return fieldErrors.stream().map(fieldError -> {
            StringBuilder sb = new StringBuilder();
            sb.append("属性:").append(fieldError.getField())
                    .append(",传来的值是:").append(fieldError.getRejectedValue())
                    .append(",校验不通过,原因:").append(fieldError.getDefaultMessage());
            return sb.toString();
        }).collect(Collectors.joining(";"));
    }


}
