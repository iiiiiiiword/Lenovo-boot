package com.lenovo.store.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lenovo.store.bean.entity.CartDO;
import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.vo.CartVO;
import com.lenovo.store.bean.vo.ComputerVO;

import java.util.List;

public interface CartMapper extends BaseMapper<CartDO> {
    List<CartVO> queryList(CommonSearchReq searchReq);
}
