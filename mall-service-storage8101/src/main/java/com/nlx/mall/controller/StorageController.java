package com.nlx.mall.controller;

import com.nlx.mall.domain.Storage;
import com.nlx.mall.entities.CommonResult;
import com.nlx.mall.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project_Name: lotte
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/12/1 16:01
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    /**
     * 扣减库存
     */
    @RequestMapping("/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult("200","扣减库存成功！");
    }

    @RequestMapping("/select-by-id")
    public Storage selectById(@RequestParam("id") Long id){
        Storage storage = storageService.selectById(id);
        return storage;
    }
}
