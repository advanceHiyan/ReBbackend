package com.readbook.readbookbackend.mapper;

import com.readbook.readbookbackend.pojo.Comment;
import com.readbook.readbookbackend.pojo.SecondComment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {

    void insertComment(Comment comment);

    void insertSecondComment(SecondComment secondComment);
}
