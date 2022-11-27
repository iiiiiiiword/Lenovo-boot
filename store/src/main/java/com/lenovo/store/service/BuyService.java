package com.lenovo.store.service;

import com.lenovo.store.bean.req.BuyAddReq;
import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.BuyVO;
import com.lenovo.store.bean.vo.CartVO;

import java.util.List;

public interface BuyService {
    void add(BuyAddReq buyAddReq);

    Result<List<BuyVO>> selectPage(CommonSearchReq searchReq);

    void deleteById(Long id);

    Result<BuyVO> selectById(Long id);
}
