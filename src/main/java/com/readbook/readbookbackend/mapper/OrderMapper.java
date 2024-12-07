/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under the [License Name] license. For more information, please visit [License
 *   Link or Explanation URL].
 *   Unauthorized reproduction, distribution, display, performance, modification, adaptation, translation, creation of derivative works, or commercial use of this work in any form is prohibited without permission.
 */

package com.readbook.readbookbackend.mapper;

import com.readbook.readbookbackend.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface OrderMapper {

    List<OneBook> getBookListByIdList(List<BigInteger> bookIdList);

    void insertOrderInfo(OrderInfo orderInfo);

    void insertOrderToBook(OrderBookRela orderBookRela);

    OrderInfo getOrderByUserIdAndOrderId(BigInteger userId, BigInteger orderId);

    List<OneBook> getBookListByOrderInfoId(BigInteger orderid);

    UserBookOwner getOwnerShipByBookIdAndUserId(BigInteger bookId, BigInteger userId);

    void setOrderStatusOne(BigInteger orderId);

    void insertOwnerShip(BigInteger bookId, BigInteger userId);

    void updateUpdateTime(BigInteger orderId);

    BanBook getBamBookByBookId(BigInteger bookId);
}
