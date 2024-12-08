/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under a license. For more information, please visit Hiyan525@163.com
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
