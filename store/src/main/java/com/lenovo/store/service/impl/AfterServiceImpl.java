package com.lenovo.store.service.impl;

import com.lenovo.store.bean.entity.AfterDO;
import com.lenovo.store.bean.req.AfterAddReq;
import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.AfterVO;
import com.lenovo.store.bean.vo.BuyVO;
import com.lenovo.store.mapper.AfterMapper;
import com.lenovo.store.service.AfterService;
import com.lenovo.store.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class AfterServiceImpl implements AfterService {
    @Resource
    private AfterMapper afterMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(AfterAddReq afterAddReq){
        AfterDO afterDO =new AfterDO();
        BeanUtils.copyProperties(afterAddReq,afterDO);
        afterMapper.insert(afterDO);
    }

    @Override
    public Result<List<AfterVO>> selectPage(CommonSearchReq searchReq){
        PageUtil.startPage(searchReq.getPageNow(),searchReq.getPageSize());
        List<AfterVO> list = afterMapper.queryList(searchReq);
        return PageUtil.wrapPageData(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        afterMapper.deleteById(id);
    }
}
