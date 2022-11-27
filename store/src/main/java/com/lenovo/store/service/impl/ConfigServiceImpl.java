package com.lenovo.store.service.impl;

import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.CartVO;
import com.lenovo.store.bean.vo.ConfigVO;
import com.lenovo.store.mapper.ConfigMapper;
import com.lenovo.store.service.ConfigService;
import com.lenovo.store.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ConfigServiceImpl implements ConfigService {

    @Resource
    private ConfigMapper configMapper;

    @Override
    public Result<List<ConfigVO>> selectPage(CommonSearchReq searchReq){
        PageUtil.startPage(searchReq.getPageNow(),searchReq.getPageSize());
        List<ConfigVO> list = configMapper.queryList(searchReq);
        return PageUtil.wrapPageData(list);
    }
}
