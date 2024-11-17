package com.readbook.readbookbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
//CREATE TABLE user_book_ownership_relationship (
//                                                  user_book_ownership_relationship_id BIGINT UNSIGNED NOT NULL PRIMARY KEY,
//                                                  user_id BIGINT UNSIGNED NOT NULL,
//                                                  book_id BIGINT UNSIGNED NOT NULL,
//                                                  FOREIGN KEY (user_id) REFERENCES user(user_id),
//                                                  FOREIGN KEY (book_id) REFERENCES book(book_id)
//);
public class UserBookOwner {
    private BigInteger id;
    private BigInteger userId;
    private BigInteger bookId;
}
