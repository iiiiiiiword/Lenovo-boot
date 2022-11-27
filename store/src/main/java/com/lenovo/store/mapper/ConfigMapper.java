package com.lenovo.store.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lenovo.store.bean.entity.ConfigDO;
import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.vo.ComputerVO;
import com.lenovo.store.bean.vo.ConfigVO;

import java.util.List;

public interface ConfigMapper extends BaseMapper<ConfigDO> {
    List<ConfigVO> queryList(CommonSearchReq commonSearchReq);
}
