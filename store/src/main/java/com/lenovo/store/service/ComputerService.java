package com.lenovo.store.service;

import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.ComputerVO;

import java.util.List;

public interface ComputerService {
    Result<List<ComputerVO>> selectPage(CommonSearchReq commonSearchReq);

    Result<ComputerVO> selectById(Long computerId);
}
