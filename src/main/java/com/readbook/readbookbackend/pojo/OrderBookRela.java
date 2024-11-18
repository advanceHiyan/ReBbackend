package com.readbook.readbookbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderBookRela {
    private BigInteger id;
    private BigInteger orderInfoId;
    private BigInteger bookId;
}
