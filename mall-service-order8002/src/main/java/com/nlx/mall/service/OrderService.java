package com.nlx.mall.service;

import com.nlx.mall.domain.Order;
import com.nlx.mall.entities.OrderParam;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/10/8
 * @Version 1.0
 */
public interface OrderService {

    void create(OrderParam orderParam);

    Order selectById(Long id);

}
