package com.readbook.readbookbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfo {
    private BigInteger id;
    private float value;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private BigInteger payerId;
    private BigInteger payeeId;
    private Integer status;
}
