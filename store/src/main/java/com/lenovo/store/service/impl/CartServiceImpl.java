package com.lenovo.store.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lenovo.store.bean.entity.CartDO;
import com.lenovo.store.bean.req.CartAddReq;
import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.CartVO;
import com.lenovo.store.ex.BizEx;
import com.lenovo.store.mapper.CartMapper;
import com.lenovo.store.service.CartService;
import com.lenovo.store.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class CartServiceImpl implements CartService {

    @Resource
    private CartMapper cartMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(CartAddReq cartAddReq){
        CartDO cartDO =new CartDO();
        BeanUtils.copyProperties(cartAddReq,cartDO);
        cartMapper.insert(cartDO);
    }

    @Override
    public Result<List<CartVO>> selectPage(CommonSearchReq searchReq){
        PageUtil.startPage(searchReq.getPageNow(),searchReq.getPageSize());
        List<CartVO> list = cartMapper.queryList(searchReq);
        return PageUtil.wrapPageData(list);
    }

    @Override
    public void deleteById(Long id){cartMapper.deleteById(id);}

    @Override
    public Result<CartVO> selectById(Long id) {
        CartDO cartDO = cartMapper.selectById(id);
        if(cartDO == null) {
            return Result.buildEmptySuccess();
        }
        CartVO vo = new CartVO();
        BeanUtils.copyProperties(cartDO,vo);
        return Result.buildSuccess(vo);
    }
}
