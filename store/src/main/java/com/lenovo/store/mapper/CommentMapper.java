package com.lenovo.store.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lenovo.store.bean.entity.CommentDO;
import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.vo.CommentVO;

import java.util.List;

public interface CommentMapper extends BaseMapper<CommentDO> {
    List<CommentVO> queryList(CommonSearchReq searchReq);
}
