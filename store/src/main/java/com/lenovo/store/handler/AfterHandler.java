package com.lenovo.store.handler;

import com.lenovo.store.bean.req.AfterAddReq;
import com.lenovo.store.bean.req.BuyAddReq;
import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.AfterVO;
import com.lenovo.store.bean.vo.BuyVO;
import com.lenovo.store.service.AfterService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/after")
public class AfterHandler {
    @Resource
    private AfterService afterService;

    @PostMapping("/add")
    public Result<String> add(@RequestBody @Validated AfterAddReq afterAddReq){
        afterService.add(afterAddReq);
        return Result.buildSuccess("提交成功");
    }

    @PostMapping("/selectPage")
    public Result<List<AfterVO>> selectPage(@RequestBody CommonSearchReq searchReq){
        return afterService.selectPage(searchReq);
    }

    @GetMapping("/deleteById")
    public Result<String> deleteById(Long id) {
        if (id == null) {
            return Result.buildFailure("id不能为空");
        }
        afterService.deleteById(id);
        return Result.buildSuccess("删除成功");
    }
}
