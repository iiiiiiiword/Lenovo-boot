package com.lenovo.store.bean.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserUpdateReq {

    @NotNull(message = "更新用户时,用户id必须指定")
    private Long userId;

    @NotBlank
    private String userName;

    @NotBlank
    private String pwd;

    private String sex;

    private String mailBox;

    private String location;

    private String selfIntroduction;
}
