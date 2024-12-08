/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under a license. For more information, please visit Hiyan525@163.com
 */

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
public class OneBook {
    private BigInteger id;
    private String title;
    private String author;
    private String description;
    private String content;
    private Integer heat;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private BigInteger creatorId;
    private Integer value;
}