package com.lenovo.store.service;

import com.lenovo.store.bean.req.CartAddReq;
import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.CartVO;

import java.util.List;

public interface CartService {
    void add(CartAddReq cartAddReq);
    Result<List<CartVO>> selectPage(CommonSearchReq searchReq);

    void deleteById(Long id);

    Result<CartVO> selectById(Long id);
}
