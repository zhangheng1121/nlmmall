package com.nlx.mall.service;

import com.nlx.mall.constants.ServiceNameCons;
import com.nlx.mall.entities.CommonResult;
import com.nlx.mall.entities.OrderParam;
import com.nlx.mall.service.impl.OrderClientFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @Project_Name: lotte
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/12/1 14:47
 * @Version 1.0
 */
@Component
@FeignClient(value = ServiceNameCons.SERVICE_ORDER, fallback = OrderClientFallbackServiceImpl.class)
public interface OrderClientService {

    @GetMapping("/order/create/{id}")
    CommonResult getOrderById(@PathVariable(value = "id") Long id);

    @PostMapping("/order/create")
    CommonResult create(OrderParam order);

    @RequestMapping("/order/select-by-id")
    CommonResult selectById(@RequestParam("id") Long id);

}
