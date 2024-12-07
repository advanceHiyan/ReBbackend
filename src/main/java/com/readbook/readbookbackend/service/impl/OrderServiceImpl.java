/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under the [License Name] license. For more information, please visit [License
 *   Link or Explanation URL].
 *   Unauthorized reproduction, distribution, display, performance, modification, adaptation, translation, creation of derivative works, or commercial use of this work in any form is prohibited without permission.
 */

package com.readbook.readbookbackend.service.impl;

import com.readbook.readbookbackend.mapper.OrderMapper;
import com.readbook.readbookbackend.pojo.OneBook;
import com.readbook.readbookbackend.pojo.OrderBookRela;
import com.readbook.readbookbackend.pojo.OrderInfo;
import com.readbook.readbookbackend.service.port.OrderService;
import com.readbook.readbookbackend.utils.Result;
import com.readbook.readbookbackend.utils.model.OrderToUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional()
    public OrderToUser addOrderBooksRelation(BigInteger userid, List<BigInteger> bookIdList) {
        List<OneBook> oneBookList = orderMapper.getBookListByIdList(bookIdList);
        int totalPrice = 0;
        for (OneBook oneBook : oneBookList) {
            if(orderMapper.getBamBookByBookId(oneBook.getId()) != null) {
                return null;
            }
            totalPrice += oneBook.getValue();
        }
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCreatedTime(LocalDateTime.now());
        orderInfo.setUpdatedTime(LocalDateTime.now());
        orderInfo.setValue(totalPrice);
        orderInfo.setStatus(0);
        orderInfo.setPayerId(userid);
        orderInfo.setPayeeId(userid);
        orderMapper.insertOrderInfo(orderInfo);
        OrderToUser orderToUser = new OrderToUser(orderInfo, oneBookList);
        for (OneBook oneBook : oneBookList) {
            OrderBookRela orderBookRela = new OrderBookRela();
            orderBookRela.setOrderInfoId(orderInfo.getId());
            orderBookRela.setBookId(oneBook.getId());
            orderMapper.insertOrderToBook(orderBookRela);
        }
        return orderToUser;
    }

    @Override
    public Result checkOrder(BigInteger userid, BigInteger orderid) {
        OrderInfo orderInfo = orderMapper.getOrderByUserIdAndOrderId(userid, orderid);
        if (orderInfo == null) {
            return Result.error("order not exist or not belong to user","888");
        }
        List<OneBook> oneBookList = orderMapper.getBookListByOrderInfoId(orderid);
        OrderToUser orderToUser = new OrderToUser(orderInfo, oneBookList);
        return Result.success("success get order",orderToUser);
    }

    @Transactional
    @Override
    public Result payOrder(BigInteger userid, BigInteger orderid) {

        if (orderMapper.getOrderByUserIdAndOrderId(userid, orderid) == null) {
            return Result.error("order not exist or not belong to user","889");
        }
        List<OneBook> oneBookList = orderMapper.getBookListByOrderInfoId(orderid);
        for (OneBook oneBook : oneBookList) {
            if(orderMapper.getOwnerShipByBookIdAndUserId(oneBook.getId(), userid) != null) {
                return Result.error("you already have payed this order or " +
                        "you have already owned this book don't pay again","887");
            }
        }
        orderMapper.setOrderStatusOne(orderid);
        orderMapper.updateUpdateTime(orderid);
        OrderInfo orderInfo = orderMapper.getOrderByUserIdAndOrderId(userid, orderid);
        OrderToUser orderToUser = new OrderToUser(orderInfo, oneBookList);
        for (OneBook oneBook : oneBookList) {
            orderMapper.insertOwnerShip(oneBook.getId(), userid);
        }
        return Result.success("success pay order",orderToUser);
    }
}
