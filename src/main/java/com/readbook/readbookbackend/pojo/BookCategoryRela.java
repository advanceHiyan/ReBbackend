package com.readbook.readbookbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
//CREATE TABLE book_category_relationship (
//                                            book_category_relationship_id BIGINT UNSIGNED NOT NULL PRIMARY KEY,
//                                            cate_id BIGINT UNSIGNED NOT NULL,
//                                            book_id BIGINT UNSIGNED NOT NULL,
//                                            FOREIGN KEY (cate_id) REFERENCES category(category_id),
//                                            FOREIGN KEY (book_id) REFERENCES book(book_id)
//);
public class BookCategoryRela {
    private BigInteger id;
    private BigInteger cateId;
    private BigInteger bookId;
}
