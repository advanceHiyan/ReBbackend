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
}
