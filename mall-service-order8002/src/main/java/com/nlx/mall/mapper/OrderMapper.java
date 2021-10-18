package com.nlx.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nlx.mall.domain.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/10/8
 * @Version 1.0
 */
@Repository
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 创建订单
     * @param order
     */
    void create(Order order);

    /**
     * 修改订单状态 ，从0改到1
     * @param userId
     * @param status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);

}
