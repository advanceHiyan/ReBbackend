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
//CREATE TABLE notification (
//                              notification_id BIGINT UNSIGNED NOT NULL PRIMARY KEY,
//                              receiver_id BIGINT UNSIGNED NOT NULL,
//                              status INT NOT NULL,
//                              context TEXT NOT NULL,
//                              created_time datetime NOT NULL ,
//                              updated_time datetime NOT NULL,
//                              FOREIGN KEY (receiver_id) REFERENCES user(user_id)
//);
public class Notification {
    private BigInteger id;
    private BigInteger receiverId;
    private Integer status;
    private String content;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
