package com.lenovo.store.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("buy")
public class BuyDO {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Long computerId;

    private String computerName;

    private String computerType;

    private String computerConfig;
}
