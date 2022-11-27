package com.lenovo.store.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lenovo.store.bean.entity.AfterDO;
import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.vo.AfterVO;

import java.util.List;

public interface AfterMapper extends BaseMapper<AfterDO> {
    List<AfterVO> queryList(CommonSearchReq searchReq);
}
