package com.lenovo.store.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lenovo.store.bean.entity.UserDO;
import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.vo.UserVO;

import java.util.List;

public interface UserMapper extends BaseMapper<UserDO> {
    List<UserVO> queryList(CommonSearchReq searchReq);
}
