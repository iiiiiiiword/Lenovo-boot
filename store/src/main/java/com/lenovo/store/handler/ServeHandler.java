package com.lenovo.store.handler;

import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.ConfigVO;
import com.lenovo.store.bean.vo.ServeVO;
import com.lenovo.store.mapper.ServeMapper;
import com.lenovo.store.service.ServeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/serve")
public class ServeHandler {
    @Resource
    private ServeService serveService;

    @PostMapping("/selectPage")
    public Result<List<ServeVO>> selectPage(@RequestBody CommonSearchReq searchReq){
        return serveService.selectPage(searchReq);
    }
}
