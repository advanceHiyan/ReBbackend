package com.readbook.readbookbackend.controller;

import com.readbook.readbookbackend.service.port.CommentService;
import com.readbook.readbookbackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
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

}
