package com.lenovo.store.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("config")
public class ConfigDO {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long computerId;

    private String computerConfig;
}
