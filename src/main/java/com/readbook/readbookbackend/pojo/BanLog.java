/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under a license. For more information, please visit Hiyan525@163.com
 */

package com.readbook.readbookbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

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
