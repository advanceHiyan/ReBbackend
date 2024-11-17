package com.readbook.readbookbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
//CREATE TABLE category (
//                          category_id BIGINT UNSIGNED NOT NULL PRIMARY KEY,
//                          cate_name VARCHAR(16) NOT NULL,
//                          reference_number INT NOT NULL
//);
public class Category {
    private BigInteger id;
    private String cateName;
    private Integer referenceNumber;
}
