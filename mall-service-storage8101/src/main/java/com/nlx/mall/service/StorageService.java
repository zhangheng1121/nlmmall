package com.nlx.mall.service;

import com.nlx.mall.domain.Storage;
import org.apache.ibatis.annotations.Param;

/**
 * @Project_Name: lotte
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/12/1 15:53
 * @Version 1.0
 */
public interface StorageService {

    //扣减库存
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

    Storage selectById(Long id);

}
