package com.nlx.mall.controller;

import com.nlx.mall.domain.Account;
import com.nlx.mall.entities.CommonResult;
import com.nlx.mall.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Project_Name: lotte
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/12/1 16:12
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Resource
    AccountService accountService;

    /**
     * 扣减账户余额
     */
    @RequestMapping("/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        accountService.decrease(userId,money);
        return new CommonResult("200","扣减账户余额成功！");
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @RequestMapping("/select-by-id")
    public Account selectById(@RequestParam("id") Long id){
        Account account = accountService.selectById(id);
        return account;
    }

}
