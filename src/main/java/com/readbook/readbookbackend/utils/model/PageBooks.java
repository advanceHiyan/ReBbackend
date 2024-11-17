package com.readbook.readbookbackend.utils.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBooks {
    private Integer total_count;
    private Integer limit;
    private List<BookWithCate> books;
}
