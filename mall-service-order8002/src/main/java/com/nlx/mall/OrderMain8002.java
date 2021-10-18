package com.nlx.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/10/9
 * @Version 1.0
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // 取消数据源的自动创建
public class OrderMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain8002.class, args);
    }

}
