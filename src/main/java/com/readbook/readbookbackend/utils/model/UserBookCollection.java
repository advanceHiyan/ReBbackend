/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under a license. For more information, please visit Hiyan525@163.com
 */

package com.readbook.readbookbackend.utils.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
//CREATE TABLE user_book_collection_relationship (
//                                                   user_book_collection_relationship_id BIGINT UNSIGNED NOT NULL PRIMARY KEY,
//                                                   created_time DATETIME NOT NULL,
//                                                   annotation text,
//                                                   user_id BIGINT UNSIGNED NOT NULL,
//                                                   book_id BIGINT UNSIGNED NOT NULL,
//                                                   FOREIGN KEY (user_id) REFERENCES user(user_id),
//                                                   FOREIGN KEY (book_id) REFERENCES book(book_id)
//);
public class UserBookCollection {
    private BigInteger id;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private String annotation;
    private BigInteger userId;
    private BigInteger bookId;
    private String title;
    private String username;
}
