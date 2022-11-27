package com.lenovo.store.service;

import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.ConfigVO;

import java.util.List;

public interface ConfigService {
    Result<List<ConfigVO>> selectPage(CommonSearchReq searchReq);
}
