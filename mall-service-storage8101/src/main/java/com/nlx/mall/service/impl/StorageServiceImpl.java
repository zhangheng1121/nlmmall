package com.nlx.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nlx.mall.domain.Storage;
import com.nlx.mall.mapper.StorageMapper;
import com.nlx.mall.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Project_Name: lotte
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/12/1 15:53
 * @Version 1.0
 */
@Service
@Slf4j
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("-------> storage-service 中扣减库存开始");
        storageMapper.decrease(productId, count);
        log.info("-------> storage-service 中扣减库存结束");
    }

    @Override
    public Storage selectById(Long id) {
        Storage storage = storageMapper.selectById(id);
        return storage;
    }
}
