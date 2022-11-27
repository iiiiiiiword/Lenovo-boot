package com.lenovo.store.bean.vo;

import lombok.Data;

@Data
public class CartVO {
    private Long id;

    private Long userId;

    private Long computerId;

    private String computerName;

    private String computerType;

    private String computerConfig;
}
