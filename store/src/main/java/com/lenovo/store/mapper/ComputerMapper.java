package com.lenovo.store.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lenovo.store.bean.entity.ComputerDO;
import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.vo.ComputerVO;

import java.util.List;

public interface ComputerMapper extends BaseMapper<ComputerDO>{
    List<ComputerVO> queryList(CommonSearchReq commonSearchReq);
}
