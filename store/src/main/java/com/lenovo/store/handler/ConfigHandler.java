package com.lenovo.store.handler;

import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.BuyVO;
import com.lenovo.store.bean.vo.ConfigVO;
import com.lenovo.store.service.ConfigService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/config")
public class ConfigHandler {

    @Resource
    private ConfigService configService;

    @PostMapping("/selectPage")
    public Result<List<ConfigVO>> selectPage(@RequestBody CommonSearchReq searchReq){
        return configService.selectPage(searchReq);
    }
}
