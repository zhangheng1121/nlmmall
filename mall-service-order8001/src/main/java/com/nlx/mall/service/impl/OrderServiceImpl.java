package com.nlx.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nlx.mall.domain.Account;
import com.nlx.mall.domain.Order;
import com.nlx.mall.domain.Storage;
import com.nlx.mall.entities.OrderParam;
import com.nlx.mall.mapper.OrderMapper;
import com.nlx.mall.service.AccountService;
import com.nlx.mall.service.OrderService;
import com.nlx.mall.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/10/8
 * @Version 1.0
 */
@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Value("${mybatis-plus.mapper-locations}")
    private String mapperLocations;

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说：下订单->扣库存->减余额->改状态
     */
    @Override
    @GlobalTransactional(name = "fsp-create-mall", rollbackFor = Exception.class)
    public void create(OrderParam orderParam) {
        log.info("----->开始新建订单");
        Order order = new Order();
        BeanUtils.copyProperties(orderParam, order);
        //1 新建订单
        orderMapper.insert(order);

        //2 扣减库存
        log.info("----->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");

        //3 扣减账户
        log.info("----->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->订单微服务开始调用账户，做扣减end");

        //4 修改订单状态，从零到1,1代表已经完成
        log.info("----->修改订单状态开始");
        orderMapper.update(order.getUserId(),0);
        log.info("----->修改订单状态结束");

        // int x = 10/0;

        log.info("----->下订单结束了，O(∩_∩)O哈哈~");
    }

    @Override
    public Order selectById(Long id) {
        System.out.println("****" + mapperLocations);
        Order order = orderMapper.selectById(id);
        Storage storage = storageService.selectById(id);
        System.out.println(storage);
        Account account = accountService.selectById(id);
        System.out.println(account);
        return order;
    }

}
