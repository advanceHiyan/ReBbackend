/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under the [License Name] license. For more information, please visit [License
 *   Link or Explanation URL].
 *   Unauthorized reproduction, distribution, display, performance, modification, adaptation, translation, creation of derivative works, or commercial use of this work in any form is prohibited without permission.
 */

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
    private String username;
    private BigInteger bookId;
    private List<SecondComment> secondComments;

    public CommentAndSecond(Comment comment, List<SecondComment> secondComments,String username) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.createdTime = comment.getCreatedTime();
        this.updatedTime = comment.getUpdatedTime();
        this.userId = comment.getUserId();
        this.bookId = comment.getBookId();
        this.secondComments = secondComments;
        this.username = username;
    }
}
