package com.lenovo.store.interceptor;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.lenovo.store.bean.constants.Constants;
import com.lenovo.store.bean.dto.JwtUserDTO;
import com.lenovo.store.bean.enums.CodeEnum;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.context.ManagerContext;
import com.lenovo.store.util.JwtUtil;
import com.lenovo.store.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class AuthrizationInterceptor implements HandlerInterceptor {


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ManagerContext.remove();
    }
}
