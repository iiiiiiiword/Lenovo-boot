package com.lenovo.store.bean.enums;

public enum CodeEnum {
    SUCCESS(200,"成功"),

    PARAM_ERR(10000,"参数不正确"),

    DB_ERR(20000,"数据库异常"),

    DUPLICATE_KEY_ERR(20001,"唯一性约束校验失败"),

    BIZ_ERR(30000,"业务异常"),

    AUTH_ERR(30001,"权限不足"),

    SYS_ERR(90000,"系统异常"),
    ;
    CodeEnum(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }
    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
