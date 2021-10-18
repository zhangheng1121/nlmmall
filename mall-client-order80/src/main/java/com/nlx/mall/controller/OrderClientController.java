package com.nlx.mall.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.nlx.mall.entities.CommonResult;
import com.nlx.mall.entities.OrderParam;
import com.nlx.mall.myhandle.CustomerBlockHandler;
import com.nlx.mall.service.OrderClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Project_Name: lotte
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/12/1 14:56
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/client")
public class OrderClientController {


    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.add("string");

        System. out. println(queue. remove());
        System. out. println(queue. poll());
        System. out. println(queue. size());

    }


    @Resource
    private OrderClientService orderClientService;

    @GetMapping("/order/create/{id}")
    public CommonResult getOrderById(@PathVariable(value = "id") Long id){
        return orderClientService.getOrderById(id);
    }

    @PostMapping("/order/create")
    public CommonResult create(@RequestBody OrderParam order){
        return orderClientService.create(order);
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping("/select-by-id")
    @SentinelResource(value = "select-by-id", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException")
    public CommonResult selectById(@RequestParam("id") Long id){
        return orderClientService.selectById(id);
    }
    public CommonResult handlerException(BlockException exception){
        return new CommonResult("444", "服务不可用");
    }

}

