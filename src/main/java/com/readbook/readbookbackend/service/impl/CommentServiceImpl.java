/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under the [License Name] license. For more information, please visit [License
 *   Link or Explanation URL].
 *   Unauthorized reproduction, distribution, display, performance, modification, adaptation, translation, creation of derivative works, or commercial use of this work in any form is prohibited without permission.
 */

package com.readbook.readbookbackend.service.impl;

import com.readbook.readbookbackend.mapper.CommentMapper;
import com.readbook.readbookbackend.mapper.UserMapper;
import com.readbook.readbookbackend.pojo.Comment;
import com.readbook.readbookbackend.pojo.SecondComment;
import com.readbook.readbookbackend.pojo.User;
import com.readbook.readbookbackend.service.port.CommentService;
import com.readbook.readbookbackend.utils.Result;
import com.readbook.readbookbackend.utils.model.CommentAndSecond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        String username = userMapper.getUserById(userid).getUserName();
        comment.setUsername(username);
        comment.setContent("LocalDataTime.now()"); //
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
        String username = userMapper.getUserById(userid).getUserName();
        SecondComment secondComment = new SecondComment();
        secondComment.setCommentId(commentid);
        secondComment.setUserId(userid);
        secondComment.setUsername(username);
        secondComment.setContent(reply);
        secondComment.setRespondeeId(respondeeid);
        secondComment.setCreatedDate(LocalDateTime.now());
        secondComment.setUpdatedDate(LocalDateTime.now());
        commentMapper.insertSecondComment(secondComment);
        return Result.success("Comment added successfully", secondComment);
    }

    @Override
    public Result getComments(BigInteger bookid) {
        List<CommentAndSecond> retComments = new ArrayList<>();
        List<Comment> comments = commentMapper.getCommentsByBookId(bookid);
        for (Comment comment : comments) {
            List<SecondComment> secondComments = commentMapper.getSecondCommentsByCommentId(comment.getId());
            String username = userMapper.getUserById(comment.getUserId()).getUserName();
            for (SecondComment secondComment : secondComments) {
                String repliedUsername = userMapper.getUserById(secondComment.getUserId()).getUserName();
                secondComment.setUsername(repliedUsername);
            }
            retComments.add(new CommentAndSecond(comment, secondComments, username));
        }
        return Result.success("Comments fetched successfully", retComments);
    }

    @Override
    public Result deleteReply(BigInteger userid, BigInteger replyid) {
        User user = userMapper.getUserById(userid);
        SecondComment secondComment = commentMapper.getSecondCommentsByreplyId(replyid);
        if(user.getUserRole() != 1 && !secondComment.getUserId().equals(userid)) {
            return Result.error("User is not authorized to delete this comment", "006");
        }
        commentMapper.deleteSecondComment(replyid);
        return Result.success("Reply deleted successfully","already deleted");
    }

    @Transactional
    @Override
    public Result deleteComment(BigInteger userid, BigInteger commentid) {
        User user = userMapper.getUserById(userid);
        Comment comment = commentMapper.getCommentById(commentid);
        if(user.getUserRole() != 1 && !comment.getUserId().equals(userid)) {
            return Result.error("User is not authorized to delete this comment", "007");
        }
        List<SecondComment> secondComments = commentMapper.getSecondCommentsByCommentId(commentid);
        String plagiarize = "";
        for (SecondComment secondComment : secondComments) {
            plagiarize += secondComment.getUsername() + " : " + secondComment.getContent() + "\n";
            commentMapper.deleteSecondComment(secondComment.getId());
        }
        String donNotPlagiarize = comment.getUsername() + " : " + comment.getContent() + plagiarize; //
        commentMapper.deleteComment(commentid);
        return Result.success("Comment deleted successfully and its replies also deleted",
                "already deleted");
    }
}
