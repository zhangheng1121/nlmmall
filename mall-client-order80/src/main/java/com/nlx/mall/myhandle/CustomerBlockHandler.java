package com.nlx.mall.myhandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.nlx.mall.entities.CommonResult;

/**
 * @Project_Name: nlx2020
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/11/25 16:00
 * @Version 1.0
 */
public class CustomerBlockHandler {

    /**
     *
     * @param exception
     * @return
     */
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult("444", "查询自定义, global handlerException -- 1");
    }

    /**
     *
     * @param exception
     * @return
     */
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult("444", "查询自定义, global handlerException -- 2");
    }

}
