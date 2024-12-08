/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under a license. For more information, please visit Hiyan525@163.com
 */

package com.readbook.readbookbackend.controller;

import com.readbook.readbookbackend.service.port.OrderService;
import com.readbook.readbookbackend.utils.Result;
import com.readbook.readbookbackend.utils.model.OrderToUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/usercenter/neworder")
    public Result submitOrder(BigInteger userid,String[] bookids) {
        List<BigInteger> bookIdList = new ArrayList<>();
        for (int i=0;i<bookids.length;i++) {
            BigInteger bookid = BigInteger.valueOf(Long.parseLong(bookids[i]));
            bookIdList.add(bookid);
        }
        OrderToUser orderToUser = orderService.addOrderBooksRelation(userid,bookIdList);
        if (orderToUser == null) {
            return Result.error("can not buy banned books","899");
        }
        return Result.success("success create order",orderToUser);
    }

    @PostMapping("/usercenter/checkorder")
    public Result checkOrder(BigInteger userid,BigInteger orderid) {
        return orderService.checkOrder(userid,orderid);
    }

    @PostMapping("/usercenter/payorder")
    public Result payOrder(BigInteger userid,BigInteger orderid) {
        return orderService.payOrder(userid,orderid);
    }
}
