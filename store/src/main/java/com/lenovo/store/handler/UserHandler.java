package com.lenovo.store.handler;

import com.lenovo.store.bean.req.LoginReq;
import com.lenovo.store.bean.req.RegisterReq;
import com.lenovo.store.bean.req.UserUpdateReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.JwtUserVO;
import com.lenovo.store.bean.vo.UserVO;
import com.lenovo.store.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserHandler {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<JwtUserVO> login(@RequestBody @Validated LoginReq loginReq) {
        log.info("login params:{}",loginReq);
        return userService.login(loginReq);
    }

    @PostMapping("/register")
    public Result<String> add(@RequestBody @Validated RegisterReq registerReq){
        userService.add(registerReq);
        return Result.buildSuccess("添加成功");
    }

    @PostMapping("/updateById")
    public Result<String> updateById(@RequestBody @Validated UserUpdateReq userUpdateReq){
        userService.updateById(userUpdateReq);
        return Result.buildSuccess("修改成功");
    }

    @GetMapping("/selectAll")
    public Result<List<UserVO>> selectAll(){return userService.selectAll();}

    @GetMapping("/selectById")
    public Result<UserVO> selectById(Long userId){
        if(userId == null){
            return Result.buildFailure("id不能为空");
        }
        return userService.selectById(userId);
    }
}
