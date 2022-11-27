package com.lenovo.store.service.impl;

import com.lenovo.store.bean.entity.BuyDO;
import com.lenovo.store.bean.entity.CartDO;
import com.lenovo.store.bean.entity.ComputerDO;
import com.lenovo.store.bean.req.BuyAddReq;
import com.lenovo.store.bean.req.CartAddReq;
import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.BuyVO;
import com.lenovo.store.bean.vo.CartVO;
import com.lenovo.store.bean.vo.ComputerVO;
import com.lenovo.store.mapper.BuyMapper;
import com.lenovo.store.service.BuyService;
import com.lenovo.store.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class BuyServiceImpl implements BuyService {

    @Resource
    private BuyMapper buyMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(BuyAddReq buyAddReq){
        BuyDO buyDO =new BuyDO();
        BeanUtils.copyProperties(buyAddReq,buyDO);
        buyMapper.insert(buyDO);
    }

    @Override
    public Result<List<BuyVO>> selectPage(CommonSearchReq searchReq){
        PageUtil.startPage(searchReq.getPageNow(),searchReq.getPageSize());
        List<BuyVO> list = buyMapper.queryList(searchReq);
        return PageUtil.wrapPageData(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        buyMapper.deleteById(id);
    }

    @Override
    public Result<BuyVO> selectById(Long id){
        BuyDO buyDO = buyMapper.selectById(id);
        if(buyDO == null){
            return Result.buildEmptySuccess();
        }
        BuyVO vo = new BuyVO();
        BeanUtils.copyProperties(buyDO,vo);
        return  Result.buildSuccess(vo);
    }
}
