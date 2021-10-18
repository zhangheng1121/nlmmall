package com.nlx.mall.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Introduce:
 * @Author: zhangheng
 * @Date: 2021/9/9
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {

   private String code;

   private String message;

   private T data;

   public CommonResult(String code, String message){
       this(code, message, null);
   }

}
