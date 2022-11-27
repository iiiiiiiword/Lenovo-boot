package com.lenovo.store.service;

import com.lenovo.store.bean.req.CommentAddReq;
import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.CartVO;
import com.lenovo.store.bean.vo.CommentVO;

import java.util.List;

public interface CommentService {
    void add(CommentAddReq commentAddReq);

    Result<List<CommentVO>> selectPage(CommonSearchReq searchReq);
}
