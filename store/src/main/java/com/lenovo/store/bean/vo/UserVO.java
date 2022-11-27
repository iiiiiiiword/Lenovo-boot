package com.lenovo.store.bean.vo;

import lombok.Data;

@Data
public class UserVO {

    private Long userId;

    private String userName;

    private String pwd;

    private String sex;

    private String mailBox;

    private String location;

    private String selfIntroduction;
}
