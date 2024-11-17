package com.readbook.readbookbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

import java.math.BigInteger;
import java.sql.Clob;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
//CREATE TABLE first_level_comment (
//                                     comment_id BIGINT UNSIGNED NOT NULL PRIMARY KEY,
//                                     content TEXT NOT NULL,
//                                     created_time DATETIME NOT NULL,
//                                     user_id BIGINT UNSIGNED NOT NULL,
//                                     book_id BIGINT UNSIGNED NOT NULL,
//                                     FOREIGN KEY (user_id) REFERENCES user(user_id),
//                                     FOREIGN KEY (book_id) REFERENCES book(book_id)
//);
public class Comment {
    private BigInteger id;
    private String content;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private BigInteger userId;
    private BigInteger bookId;
}
