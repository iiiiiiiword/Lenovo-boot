package com.lenovo.store.bean.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CommentAddReq {
    @NotNull
    private Long userId;

    @NotNull
    private Long computerId;

    @NotBlank
    private String computerName;

    @NotBlank
    private String computerType;

    @NotBlank
    private String comment;

    @NotBlank
    private String computerConfig;
}
