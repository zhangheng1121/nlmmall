package com.nlx.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nlx.mall.domain.Account;
import com.nlx.mall.mapper.AccountMapper;
import com.nlx.mall.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Project_Name: lotte
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/12/1 16:10
 * @Version 1.0
 */
@Slf4j
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
        //模拟超时异常，全局事务回滚
        //暂停几秒钟线程
        //try { TimeUnit.SECONDS.sleep(7); } catch (InterruptedException e) { e.printStackTrace(); }
        accountMapper.decrease(userId, money);
        log.info("------->account-service中扣减账户余额结束");
    }

    @Override
    public Account selectById(Long id) {
        Account account = accountMapper.selectById(id);
        return account;
    }

}
