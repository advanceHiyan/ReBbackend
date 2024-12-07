/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under the [License Name] license. For more information, please visit [License
 *   Link or Explanation URL].
 *   Unauthorized reproduction, distribution, display, performance, modification, adaptation, translation, creation of derivative works, or commercial use of this work in any form is prohibited without permission.
 */

package com.readbook.readbookbackend.mapper;

import com.readbook.readbookbackend.pojo.Comment;
import com.readbook.readbookbackend.pojo.SecondComment;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface CommentMapper {

    void insertComment(Comment comment);

    void insertSecondComment(SecondComment secondComment);

    List<Comment> getCommentsByBookId(BigInteger bookid);

    List<SecondComment> getSecondCommentsByCommentId(BigInteger commentId);

    SecondComment getSecondCommentsByreplyId(BigInteger replyId);

    void deleteSecondComment(BigInteger replyId);

    Comment getCommentById(BigInteger commentId);

    void deleteComment(BigInteger commentId);
}
