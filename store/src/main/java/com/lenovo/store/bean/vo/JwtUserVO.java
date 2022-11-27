package com.lenovo.store.bean.vo;

import com.lenovo.store.bean.dto.JwtUserDTO;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class JwtUserVO extends JwtUserDTO {
    private String token;
}
