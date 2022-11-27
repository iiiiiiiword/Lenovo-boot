package com.lenovo.store.handler;

import com.lenovo.store.bean.req.CartAddReq;
import com.lenovo.store.bean.req.CommentAddReq;
import com.lenovo.store.bean.req.CommonSearchReq;
import com.lenovo.store.bean.res.Result;
import com.lenovo.store.bean.vo.CartVO;
import com.lenovo.store.bean.vo.CommentVO;
import com.lenovo.store.service.CommentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentHandler {

    @Resource
    private CommentService commentService;

    @PostMapping("/add")
    public Result<String> add(@RequestBody @Validated CommentAddReq commentAddReq){
        commentService.add(commentAddReq);
        return Result.buildSuccess("添加成功");
    }

    @PostMapping("/selectPage")
    public Result<List<CommentVO>> selectPage(@RequestBody CommonSearchReq searchReq){
        return commentService.selectPage(searchReq);
    }
}
