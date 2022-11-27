package com.lenovo.store.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lenovo.store.bean.dto.JwtUserDTO;
import com.lenovo.store.bean.entity.UserDO;
import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.req.LoginReq;
import com.lenovo.store.bean.req.RegisterReq;
import com.lenovo.store.bean.req.UserUpdateReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.JwtUserVO;
import com.lenovo.store.bean.vo.UserVO;
import com.lenovo.store.ex.BizEx;
import com.lenovo.store.mapper.UserMapper;
import com.lenovo.store.service.UserService;
import com.lenovo.store.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Result<JwtUserVO> login(LoginReq loginReq) {
        LambdaQueryWrapper<UserDO> qw = new LambdaQueryWrapper<>();
        qw.eq(UserDO::getUserName,loginReq.getUserName())
                .eq(UserDO::getPwd,loginReq.getPwd());
        UserDO userDO = userMapper.selectOne(qw);
        if (userDO == null) {
            return Result.buildFailure("用户名或密码不正确");
        }
        JwtUserVO vo = generateToken(userDO);
        return Result.buildSuccess(vo);
    }

    private JwtUserVO generateToken(UserDO userDO) {
        JwtUserDTO jwtUserDTO = new JwtUserDTO();
        BeanUtils.copyProperties(userDO,jwtUserDTO);
        String token = JwtUtil.getToken(jwtUserDTO);
        JwtUserVO vo = new JwtUserVO();
        BeanUtils.copyProperties(jwtUserDTO,vo);
        vo.setToken(token);
        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(RegisterReq registerReq){
        LambdaQueryWrapper<UserDO> qw = new LambdaQueryWrapper<>();
        qw.eq(UserDO::getUserName,registerReq.getUserName());
        Long count = userMapper.selectCount(qw);
        if(count > 0){
            throw new BizEx("用户名已存在");
        }
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(registerReq,userDO);
        userMapper.insert(userDO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(UserUpdateReq updataUserReq){
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(updataUserReq,userDO);
        userMapper.updateById(userDO);
    }

    @Override
    public Result<List<UserVO>> selectAll(){
        List<UserVO> list = userMapper.queryList(new CommonSearchReq());
        return Result.buildSuccess(list);
    }

    @Override
    public Result<UserVO> selectById(Long userId){
        UserDO userDO = userMapper.selectById(userId);
        if(userDO == null){
            return Result.buildEmptySuccess();
        }
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(userDO,vo);
        return Result.buildSuccess(vo);
    }
}
