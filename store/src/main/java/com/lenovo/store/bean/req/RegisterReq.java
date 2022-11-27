package com.lenovo.store.bean.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegisterReq {
    @NotBlank
    private String userName;

    @NotBlank
    private String pwd;

    @NotBlank
    private String location;
}
