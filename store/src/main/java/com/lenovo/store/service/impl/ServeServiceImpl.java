package com.lenovo.store.service.impl;

import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.AfterVO;
import com.lenovo.store.bean.vo.ServeVO;
import com.lenovo.store.mapper.ServeMapper;
import com.lenovo.store.service.ServeService;
import com.lenovo.store.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ServeServiceImpl implements ServeService {
    @Resource
    private ServeMapper serveMapper;

    @Override
    public Result<List<ServeVO>> selectPage(CommonSearchReq searchReq){
        PageUtil.startPage(searchReq.getPageNow(),searchReq.getPageSize());
        List<ServeVO> list = serveMapper.queryList(searchReq);
        return PageUtil.wrapPageData(list);
    }
}
