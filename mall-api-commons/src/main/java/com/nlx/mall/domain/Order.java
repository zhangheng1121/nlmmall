package com.nlx.mall.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @className: Order
 * @description:
 * @author: liusCoding
 * @create: 2020-06-12 09:21
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    // 订单状态：0：创建中；1：已完结
    private Integer status;

}
