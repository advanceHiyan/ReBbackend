/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under a license. For more information, please visit Hiyan525@163.com
 */

package com.readbook.readbookbackend.service.port;

import com.readbook.readbookbackend.utils.Result;

import java.math.BigInteger;

public interface CommentService {

    Result commentBook(BigInteger userid, BigInteger bookid, String content);

    Result replyComment(BigInteger userid, BigInteger commentid, String reply, BigInteger respondeeid);

    Result getComments(BigInteger bookid);

    Result deleteReply(BigInteger userid, BigInteger replyid);

    Result deleteComment(BigInteger userid, BigInteger commentid);
}
