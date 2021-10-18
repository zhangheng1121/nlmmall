package com.nlx.mall.controller;

import com.nlx.mall.domain.Order;
import com.nlx.mall.entities.CommonResult;
import com.nlx.mall.entities.OrderParam;
import com.nlx.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/10/8
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private OrderService orderService;

    @RequestMapping("/create")
    public CommonResult create(@RequestBody OrderParam orderParam) {
        CommonResult commonResult;
        try{
            orderService.create(orderParam);
            commonResult = new CommonResult("200", "成功 " + serverPort);
        }catch(Exception e){
            commonResult = new CommonResult("400", "失败 " + serverPort);
        }
        return commonResult;
    }

    @RequestMapping("/select-by-id")
    public CommonResult selectById(@RequestParam("id") Long id){
        CommonResult commonResult;
        try{
            Order order = orderService.selectById(id);
            commonResult = new CommonResult("200", "成功 " + serverPort, order);
        }catch(Exception e){
            commonResult = new CommonResult("400", "失败 " + serverPort);
        }
        return commonResult;
    }

}
