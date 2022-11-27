package com.lenovo.store.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("serve")
public class ServeDO {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String serveName;

    private String serveDetails;

    private String serveImg;

    private String servePrice;

}
