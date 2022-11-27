package com.lenovo.store.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lenovo.store.bean.entity.BuyDO;
import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.vo.BuyVO;

import java.util.List;

public interface BuyMapper extends BaseMapper<BuyDO> {
    List<BuyVO> queryList(CommonSearchReq searchReq);
}
