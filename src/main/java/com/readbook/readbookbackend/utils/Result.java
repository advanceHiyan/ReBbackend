/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under the [License Name] license. For more information, please visit [License
 *   Link or Explanation URL].
 *   Unauthorized reproduction, distribution, display, performance, modification, adaptation, translation, creation of derivative works, or commercial use of this work in any form is prohibited without permission.
 */

package com.readbook.readbookbackend.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private String status;//响应码，true 代表成功; false 代表失败
    private String message;  //响应信息 描述字符串
    private Object data; //返回的数据
    private String code; //错误码

    //增删改 成功响应
    public static Result success(String message){
        return new Result("success",message,null,null);
    }
    //查询 成功响应
    public static Result success(String message,Object data){
        return new Result("success",message,data,null);
    }
    //失败响应
    public static Result error(String msg,String code){
        return new Result("error",msg,null,code);
    }
}
