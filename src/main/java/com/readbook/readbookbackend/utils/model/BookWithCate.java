package com.readbook.readbookbackend.utils.model;

import com.readbook.readbookbackend.pojo.Category;
import com.readbook.readbookbackend.pojo.OneBook;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookWithCate {
    private BigInteger id;
    private String title;
    private String author;

    private List<Category> cate;

    private Integer heat;
    private String description;
    private String content;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private BigInteger creatorId;
    private Integer value;

    public BookWithCate(OneBook book, List<Category> cate) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.cate = cate;
        this.heat = book.getHeat();
        this.content = book.getContent();
        this.createdTime = book.getCreatedTime();
        this.updatedTime = book.getUpdatedTime();
        this.creatorId = book.getCreatorId();
        this.value = book.getValue();
        this.description = book.getDescription();
    }
}
