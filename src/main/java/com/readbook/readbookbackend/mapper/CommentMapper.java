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
