package com.lenovo.store.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class UserDO {

    @TableId(type = IdType.AUTO)
    private Long userId;

    private String userName;

    private String pwd;

    private String sex;

    private String mailBox;

    private String location;

    private String selfIntroduction;
}
