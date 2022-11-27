package com.lenovo.store.handler;

import com.lenovo.store.bean.req.CartAddReq;
import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.CartVO;
import com.lenovo.store.service.CartService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartHandler {

    @Resource
    private CartService cartService;

    @PostMapping("/add")
    public Result<String> add(@RequestBody @Validated CartAddReq cartAddReq){
        cartService.add(cartAddReq);
        return Result.buildSuccess("添加成功");
    }

    @PostMapping("/selectPage")
    public Result<List<CartVO>> selectPage(@RequestBody CommonSearchReq searchReq){
        return cartService.selectPage(searchReq);
    }

    @GetMapping("/deleteById")
    public Result<String> deleteById(Long id) {
        if (id == null) {
            return Result.buildFailure("id不能为空");
        }
        cartService.deleteById(id);
        return Result.buildSuccess("删除成功");
    }

    @GetMapping("/selectById")
    public Result<CartVO> selectById(Long id) {
        if (id == null) {
            return Result.buildFailure("id不能为空");
        }
        return cartService.selectById(id);
    }
}
