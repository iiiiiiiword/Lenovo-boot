package com.lenovo.store.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lenovo.store.bean.entity.ServeDO;
import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.vo.ServeVO;

import java.util.List;

public interface ServeMapper extends BaseMapper<ServeDO> {
    List<ServeVO> queryList(CommonSearchReq commonSearchReq);
}
