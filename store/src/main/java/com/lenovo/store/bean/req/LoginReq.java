package com.lenovo.store.bean.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginReq {
    @NotBlank
    private String userName;

    @NotBlank
    private String pwd;
}
