package com.lenovo.store.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lenovo.store.bean.res.Result;

import java.util.List;

public class PageUtil {
    public static void startPage(Integer pageNow,Integer pageSize) {
        PageHelper.startPage(pageNow,pageSize);
    }
    public static <T> Result<List<T>> wrapPageData(List<T> queryList) {
        PageInfo<T> pageInfo = new PageInfo<>(queryList);
        return Result.buildSuccess(queryList,pageInfo.getTotal());
    }
}
