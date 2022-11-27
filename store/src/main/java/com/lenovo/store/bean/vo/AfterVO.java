package com.lenovo.store.bean.vo;

import lombok.Data;

@Data
public class AfterVO {
    private Long id;

    private Long userId;

    private Long computerId;

    private String computerName;

    private String computerType;

    private String computerConfig;

    private String service;

    private String apply;

    private String state;
}
