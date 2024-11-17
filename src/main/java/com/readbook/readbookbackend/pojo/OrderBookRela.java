package com.readbook.readbookbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
//CREATE TABLE order_book_relationship (
//                                         order_book_relationship_id BIGINT UNSIGNED NOT NULL PRIMARY KEY,
//                                         order_info_id BIGINT UNSIGNED NOT NULL,
//                                         book_id BIGINT UNSIGNED NOT NULL,
//                                         FOREIGN KEY (order_info_id) REFERENCES order_info(order_info_id),
//                                         FOREIGN KEY (book_id) REFERENCES book(book_id)
//);
public class OrderBookRela {
    private BigInteger id;
    private BigInteger orderInfoId;
    private BigInteger bookId;
}
