package com.readbook.readbookbackend.utils.model;

import com.readbook.readbookbackend.pojo.Comment;
import com.readbook.readbookbackend.pojo.SecondComment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentAndSecond {
    private BigInteger id;
    private String content;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private BigInteger userId;
    private BigInteger bookId;
    private List<SecondComment> secondComments;

    public CommentAndSecond(Comment comment, List<SecondComment> secondComments) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.createdTime = comment.getCreatedTime();
        this.updatedTime = comment.getUpdatedTime();
        this.userId = comment.getUserId();
        this.bookId = comment.getBookId();
        this.secondComments = secondComments;
    }
}
