package com.readbook.readbookbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
//CREATE TABLE order_info (
//                            order_info_id BIGINT UNSIGNED NOT NULL PRIMARY KEY,
//                            value FLOAT NOT NULL,
//                            created_time DATETIME NOT NULL,
//                            payer_id BIGINT UNSIGNED NOT NULL,
//                            payee_id BIGINT UNSIGNED NOT NULL ,
//                            status INT NOT NULL,
//                            FOREIGN KEY (payer_id) REFERENCES user(user_id),
//                            FOREIGN KEY (payee_id) REFERENCES user(user_id)
//);
public class OrderInfo {
    private BigInteger id;
    private float value;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private BigInteger payerId;
    private BigInteger payeeId;
    private Integer status;
}
