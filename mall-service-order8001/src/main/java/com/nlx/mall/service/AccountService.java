package com.nlx.mall.service;

import com.nlx.mall.constants.ServiceNameCons;
import com.nlx.mall.domain.Account;
import com.nlx.mall.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Project_Name: lotte
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/12/1 16:17
 * @Version 1.0
 */
@FeignClient(value = ServiceNameCons.SERVICE_ACCOUNT)
@Component
public interface AccountService {

    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

    @RequestMapping("/account/select-by-id")
    Account selectById(@RequestParam("id") Long id);

}
