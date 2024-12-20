/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under a license. For more information, please visit Hiyan525@163.com
 */

package com.readbook.readbookbackend.service.port;

import com.readbook.readbookbackend.utils.Result;
import com.readbook.readbookbackend.utils.model.OrderToUser;

import java.math.BigInteger;
import java.util.List;

public interface OrderService {

    OrderToUser addOrderBooksRelation(BigInteger userid, List<BigInteger> bookIdList);

    Result checkOrder(BigInteger userid, BigInteger orderid);

    Result payOrder(BigInteger userid, BigInteger orderid);
}
