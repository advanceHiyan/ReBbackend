package com.readbook.readbookbackend.service;

import com.readbook.readbookbackend.utils.Result;

import java.math.BigInteger;

public interface CommentService {

    Result commentBook(BigInteger userid, BigInteger bookid, String content);

    Result replyComment(BigInteger userid, BigInteger commentid, String reply, BigInteger respondeeid);
}
