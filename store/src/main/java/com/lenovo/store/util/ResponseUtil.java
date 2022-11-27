package com.lenovo.store.util;

import com.alibaba.fastjson.JSON;
import com.lenovo.store.bean.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class ResponseUtil {
    public static void respAppJson(HttpServletResponse response, Object obj) {
        response.setCharacterEncoding(Constants.UTF_8_NAME);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        try(PrintWriter pw = response.getWriter()) {
            pw.print(JSON.toJSONString(obj));
            pw.flush();
        }catch (IOException e) {
            log.error("写到前端异常",e);
        }
    }
}

