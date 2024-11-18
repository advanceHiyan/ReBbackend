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
public class Notification {
    private BigInteger id;
    private BigInteger receiverId;
    private Integer status;
    private String content;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
