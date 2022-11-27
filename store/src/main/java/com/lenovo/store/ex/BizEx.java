package com.lenovo.store.ex;

import com.lenovo.store.bean.enums.CodeEnum;
import lombok.Data;

@Data
public class BizEx extends RuntimeException {
    private Integer code;
    public BizEx(String msg) {
        super(msg);
    }
    public BizEx(CodeEnum codeEnum) {
        super(codeEnum.getMsg());
        this.code = codeEnum.getCode();
    }

}
