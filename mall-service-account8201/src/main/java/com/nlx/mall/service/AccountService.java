package com.nlx.mall.service;

import com.nlx.mall.domain.Account;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Project_Name: lotte
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/12/1 16:09
 * @Version 1.0
 */
public interface AccountService {

    /**
     * 扣减账户余额
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);

    Account selectById(Long id);

}
