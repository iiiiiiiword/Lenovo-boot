package com.lenovo.store.service;

import com.lenovo.store.bean.req.AfterAddReq;
import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.AfterVO;
import com.lenovo.store.bean.vo.BuyVO;

import java.util.List;

public interface AfterService {
    void add(AfterAddReq afterAddReq);

    Result<List<AfterVO>> selectPage(CommonSearchReq searchReq);

    void deleteById(Long id);
}
