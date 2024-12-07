/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under the [License Name] license. For more information, please visit [License
 *   Link or Explanation URL].
 *   Unauthorized reproduction, distribution, display, performance, modification, adaptation, translation, creation of derivative works, or commercial use of this work in any form is prohibited without permission.
 */

package com.readbook.readbookbackend.controller;

import com.readbook.readbookbackend.service.port.CommentService;
import com.readbook.readbookbackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/usercenter/commentbook")
    public Result commentBook(BigInteger userid, BigInteger bookid, String comment) {
        return commentService.commentBook(userid, bookid, comment);
    }

    @PostMapping("/usercenter/replycomment")
    public Result replyComment(BigInteger userid, BigInteger commentid, String reply,BigInteger respondeeid) {
        return commentService.replyComment(userid, commentid, reply,respondeeid);
    }

    @GetMapping("/usercenter/getcomments")
    public Result getComments(BigInteger bookid) {
        return commentService.getComments(bookid);
    }

    @DeleteMapping("/usercenter/deletereply")
    public Result deleteReply(BigInteger userid, BigInteger replyid) {
        return commentService.deleteReply(userid, replyid);
    }

    @DeleteMapping("/usercenter/deletecomment")
    public Result deleteComment(BigInteger userid, BigInteger commentid) {
        return commentService.deleteComment(userid, commentid);
    }
}
