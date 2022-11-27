package com.lenovo.store.handler;

import com.lenovo.store.bean.req.BuyAddReq;
import com.lenovo.store.bean.req.CartAddReq;
import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.BuyVO;
import com.lenovo.store.bean.vo.CartVO;
import com.lenovo.store.bean.vo.ComputerVO;
import com.lenovo.store.service.BuyService;
import com.lenovo.store.service.CartService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/buy")
public class BuyHandler {
    @Resource
    private BuyService buyService;

    @PostMapping("/add")
    public Result<String> add(@RequestBody @Validated BuyAddReq buyAddReq){
        buyService.add(buyAddReq);
        return Result.buildSuccess("添加成功");
    }

    @PostMapping("/selectPage")
    public Result<List<BuyVO>> selectPage(@RequestBody CommonSearchReq searchReq){
        return buyService.selectPage(searchReq);
    }

    @GetMapping("/deleteById")
    public Result<String> deleteById(Long id) {
        if (id == null) {
            return Result.buildFailure("id不能为空");
        }
        buyService.deleteById(id);
        return Result.buildSuccess("删除成功");
    }

    @GetMapping("/selectById")
    public Result<BuyVO> selectById(Long id){
        if(id == null){
            return Result.buildFailure("id不能为空");
        }
        return buyService.selectById(id);
    }
}
