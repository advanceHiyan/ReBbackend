package com.readbook.readbookbackend.service.impl;

import com.readbook.readbookbackend.mapper.CommentMapper;
import com.readbook.readbookbackend.mapper.UserMapper;
import com.readbook.readbookbackend.pojo.Comment;
import com.readbook.readbookbackend.pojo.SecondComment;
import com.readbook.readbookbackend.pojo.User;
import com.readbook.readbookbackend.service.CommentService;
import com.readbook.readbookbackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result commentBook(BigInteger userid, BigInteger bookid, String content) {
        LocalDateTime banEndTime = userMapper.getLatestUnbanTimeByUserId(userid);
        if(banEndTime!= null && LocalDateTime.now().isBefore(banEndTime)) {
            return Result.error("User are banned Can't comment", "003");
        }
        Comment comment = new Comment();
        comment.setBookId(bookid);
        comment.setUserId(userid);
        comment.setContent(content);
        comment.setCreatedTime(LocalDateTime.now());
        comment.setUpdatedTime(LocalDateTime.now());
        commentMapper.insertComment(comment);
        return Result.success("Comment added successfully", comment);
    }

    @Override
    public Result replyComment(BigInteger userid, BigInteger commentid, String reply, BigInteger respondeeid) {
        LocalDateTime banEndTime = userMapper.getLatestUnbanTimeByUserId(userid);
        if(banEndTime!= null && LocalDateTime.now().isBefore(banEndTime)) {
            return Result.error("User are banned Can't reply", "004");
        }
        SecondComment secondComment = new SecondComment();
        secondComment.setCommentId(commentid);
        secondComment.setUserId(userid);
        secondComment.setContent(reply);
        secondComment.setRespondeeId(respondeeid);
        secondComment.setCreatedDate(LocalDateTime.now());
        secondComment.setUpdatedDate(LocalDateTime.now());
        commentMapper.insertSecondComment(secondComment);
        return Result.success("Comment added successfully", secondComment);
    }
}
