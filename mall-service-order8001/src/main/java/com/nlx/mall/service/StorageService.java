package com.nlx.mall.service;

import com.nlx.mall.constants.ServiceNameCons;
import com.nlx.mall.domain.Storage;
import com.nlx.mall.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Project_Name: lotte
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2020/12/1 16:16
 * @Version 1.0
 */
@FeignClient(value = ServiceNameCons.SERVICE_STORAGE)
@Component
public interface StorageService {

    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

    @RequestMapping("/storage/select-by-id")
    Storage selectById(@RequestParam("id") Long id);

}
