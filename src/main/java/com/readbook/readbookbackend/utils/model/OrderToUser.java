/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under the [License Name] license. For more information, please visit [License
 *   Link or Explanation URL].
 *   Unauthorized reproduction, distribution, display, performance, modification, adaptation, translation, creation of derivative works, or commercial use of this work in any form is prohibited without permission.
 */

package com.readbook.readbookbackend.utils.model;

import com.readbook.readbookbackend.pojo.OneBook;
import com.readbook.readbookbackend.pojo.OrderInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderToUser {
    private BigInteger id;
    private LocalDateTime createdTime;
    private BigInteger payerId;
    private Integer status;
    private LocalDateTime payTime;

    private float totalValue;
    private Integer bookCount;
    private List<OneBook> books;
    public OrderToUser(OrderInfo orderInfo, List<OneBook> books) {
        this.id = orderInfo.getId();
        this.totalValue = orderInfo.getValue();
        this.createdTime = orderInfo.getCreatedTime();
        this.payerId = orderInfo.getPayerId();
        this.status = orderInfo.getStatus();
        this.books = books;
        this.bookCount = books.size();
        if(status == 0) {
            this.payTime = null;
        } else {
            this.payTime = orderInfo.getUpdatedTime();
        }
    }
}
