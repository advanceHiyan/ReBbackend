/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under the [License Name] license. For more information, please visit [License
 *   Link or Explanation URL].
 *   Unauthorized reproduction, distribution, display, performance, modification, adaptation, translation, creation of derivative works, or commercial use of this work in any form is prohibited without permission.
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
