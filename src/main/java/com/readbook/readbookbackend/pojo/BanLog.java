package com.readbook.readbookbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

//CREATE TABLE ban_log (
//                         id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
//                         user_id BIGINT UNSIGNED NOT NULL,
//                         admin_id BIGINT UNSIGNED NOT NULL,
//                         startTime DATETIME NOT NULL,
//                         overTime DATETIME NOT NULL,
//                         banReason VARCHAR(255) NOT NULL,
//                         note VARCHAR(255) NULL,
//                         FOREIGN KEY (user_id) REFERENCES user(user_id),
//                         FOREIGN KEY (admin_id) REFERENCES user(user_id)
//);
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BanLog {
    private BigInteger id;
    private BigInteger userId;
    private BigInteger adminId;
    private LocalDateTime startTime;
    private LocalDateTime overTime;
    private String banReason;
    private String note;
}
