package com.nlx.mall.entities;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @className: Order
 * @description:
 * @author: liusCoding
 * @create: 2020-06-12 09:21
 */
@Data
public class OrderParam {

    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    // 订单状态：0：创建中；1：已完结
    private Integer status;

}
