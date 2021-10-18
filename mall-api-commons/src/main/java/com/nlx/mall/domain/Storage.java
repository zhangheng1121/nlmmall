package com.nlx.mall.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className: Storage
 * @description:
 * @author: liusCoding
 * @create: 2020-06-12 10:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_storage")
public class Storage implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
