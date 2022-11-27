package com.lenovo.store.handler;

import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.ComputerVO;
import com.lenovo.store.service.ComputerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/computer")
public class ComputerHandler {

    @Resource
    private ComputerService computerService;

    @PostMapping("/selectPage")
    public Result<List<ComputerVO>> selectPage(@RequestBody CommonSearchReq commonSearchReq){
        return computerService.selectPage(commonSearchReq);
    }

    @GetMapping("/selectById")
    public Result<ComputerVO> selectById(Long computerId){
        if(computerId == null){
            return Result.buildFailure("id不能为空");
        }
        return computerService.selectById(computerId);
    }
}
