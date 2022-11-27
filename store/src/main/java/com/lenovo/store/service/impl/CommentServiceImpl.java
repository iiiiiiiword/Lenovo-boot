package com.lenovo.store.service.impl;

import com.lenovo.store.bean.entity.CartDO;
import com.lenovo.store.bean.entity.CommentDO;
import com.lenovo.store.bean.req.CartAddReq;
import com.lenovo.store.bean.req.CommentAddReq;
import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.CartVO;
import com.lenovo.store.bean.vo.CommentVO;
import com.lenovo.store.mapper.CommentMapper;
import com.lenovo.store.service.CommentService;
import com.lenovo.store.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(CommentAddReq commentAddReq){
        CommentDO commentDO =new CommentDO();
        BeanUtils.copyProperties(commentAddReq,commentDO);
        commentMapper.insert(commentDO);
    }

    @Override
    public Result<List<CommentVO>> selectPage(CommonSearchReq searchReq){
        PageUtil.startPage(searchReq.getPageNow(),searchReq.getPageSize());
        List<CommentVO> list = commentMapper.queryList(searchReq);
        return PageUtil.wrapPageData(list);
    }
}
