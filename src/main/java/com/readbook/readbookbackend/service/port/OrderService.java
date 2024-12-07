/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under the [License Name] license. For more information, please visit [License
 *   Link or Explanation URL].
 *   Unauthorized reproduction, distribution, display, performance, modification, adaptation, translation, creation of derivative works, or commercial use of this work in any form is prohibited without permission.
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
