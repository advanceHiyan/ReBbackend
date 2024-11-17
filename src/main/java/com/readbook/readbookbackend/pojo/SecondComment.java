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
//CREATE TABLE second_level_comment (
//                                      second_comment_id BIGINT UNSIGNED NOT NULL PRIMARY KEY,
//                                      content TEXT NOT NULL,
//                                      created_time DATETIME NOT NULL,
//                                      user_id BIGINT UNSIGNED NOT NULL,
//                                      comment_id BIGINT UNSIGNED NOT NULL,
//                                      FOREIGN KEY (user_id) REFERENCES user(user_id),
//                                      FOREIGN KEY (comment_id) REFERENCES first_level_comment(comment_id)
//);
public class SecondComment {
    private BigInteger id;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private BigInteger userId;
    private BigInteger commentId;
}
