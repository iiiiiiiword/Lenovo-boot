package com.lenovo.store.service;

import com.lenovo.store.bean.req.LoginReq;
import com.lenovo.store.bean.req.RegisterReq;
import com.lenovo.store.bean.req.UserUpdateReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.JwtUserVO;
import com.lenovo.store.bean.vo.UserVO;

import java.util.List;

public interface UserService {
    Result<UserVO> selectById(Long userId);

    Result<JwtUserVO> login(LoginReq loginReq);

    void add(RegisterReq registerReq);

    void updateById(UserUpdateReq userUpdateReq);

    Result<List<UserVO>> selectAll();
}
