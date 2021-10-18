package com.nlx.mall.service.impl;

import com.nlx.mall.entities.CommonResult;
import com.nlx.mall.entities.OrderParam;
import com.nlx.mall.service.OrderClientService;
import org.springframework.stereotype.Component;

/**
 * @Project_Name: lotte
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/12/1 15:05
 * @Version 1.0
 */
@Component
public class OrderClientFallbackServiceImpl implements OrderClientService {

    @Override
    public CommonResult getOrderById(Long id) {
        return new CommonResult<>("44444", "服务降级返回,---OrderClientFallbackService", null);
    }

    @Override
    public CommonResult create(OrderParam order) {
        return new CommonResult<>("44444", "服务降级返回,---OrderClientFallbackService", null);
    }

    @Override
    public CommonResult selectById(Long id) {
        return new CommonResult<>("44444", "服务降级返回,---OrderClientFallbackService", null);
    }

}
