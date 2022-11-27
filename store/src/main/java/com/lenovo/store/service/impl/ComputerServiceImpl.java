package com.lenovo.store.service.impl;


import com.lenovo.store.bean.entity.ComputerDO;
import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.ComputerVO;
import com.lenovo.store.mapper.ComputerMapper;
import com.lenovo.store.service.ComputerService;
import com.lenovo.store.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ComputerServiceImpl implements ComputerService {

    @Resource
    private ComputerMapper computerMapper;

    @Override
    public Result<List<ComputerVO>> selectPage(CommonSearchReq commonSearchReq){
        PageUtil.startPage(commonSearchReq.getPageNow(),commonSearchReq.getPageSize());
        List<ComputerVO> list = computerMapper.queryList(commonSearchReq);
        return PageUtil.wrapPageData(list);
    }

    @Override
    public Result<ComputerVO> selectById(Long computerId){
        ComputerDO computerDO = computerMapper.selectById(computerId);
        if(computerDO == null){
            return Result.buildEmptySuccess();
        }
        ComputerVO vo = new ComputerVO();
        BeanUtils.copyProperties(computerDO,vo);
        return  Result.buildSuccess(vo);
    }
}
