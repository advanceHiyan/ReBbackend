package com.readbook.readbookbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCategoryRela {
    private BigInteger id;
    private BigInteger cateId;
    private BigInteger bookId;
}
