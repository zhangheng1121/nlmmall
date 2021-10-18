package com.nlx.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nlx.mall.domain.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/10/8
 * @Version 1.0
 */
@Mapper
public interface StorageMapper extends BaseMapper<Storage> {

    //扣减库存
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
