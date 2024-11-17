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
//CREATE TABLE book (
//                      book_id BIGINT UNSIGNED NOT NULL PRIMARY KEY,
//                      title VARCHAR(64) NOT NULL,
//                      content TEXT NOT NULL,
//                      heat INT NOT NULL,
//                      created_time DATETIME NOT NULL,
//                      updated_time DATETIME NOT NULL,
//                      creator_id BIGINT UNSIGNED NOT NULL,
//                      value INT NOT NULL,
//                      FOREIGN KEY (creator_id) REFERENCES user(user_id)
//);
public class OneBook {
    private BigInteger id;
    private String title;
    private String author;
    private String content;
    private Integer heat;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private BigInteger creatorId;
    private Integer value;
}