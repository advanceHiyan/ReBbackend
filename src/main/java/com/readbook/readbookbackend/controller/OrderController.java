package com.readbook.readbookbackend.controller;

import com.readbook.readbookbackend.service.port.OrderService;
import com.readbook.readbookbackend.utils.Result;
import com.readbook.readbookbackend.utils.model.OrderToUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;
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
        return Result.success("success create order",orderToUser);
    }
}
