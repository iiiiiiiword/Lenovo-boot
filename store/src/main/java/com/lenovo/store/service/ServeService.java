package com.lenovo.store.service;

import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.ConfigVO;
import com.lenovo.store.bean.vo.ServeVO;

import java.util.List;

public interface ServeService {
    Result<List<ServeVO>> selectPage(CommonSearchReq searchReq);
}
