/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under the [License Name] license. For more information, please visit [License
 *   Link or Explanation URL].
 *   Unauthorized reproduction, distribution, display, performance, modification, adaptation, translation, creation of derivative works, or commercial use of this work in any form is prohibited without permission.
 */

package com.readbook.readbookbackend.service.port;

import com.readbook.readbookbackend.utils.model.BookWithCate;
import com.readbook.readbookbackend.utils.Result;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public interface BookService {

    Result bookmark(BigInteger userIdBigInteger, BigInteger bookIdBigInteger,String annotation);

    List<BookWithCate> bookfilter(BigInteger authorId, List<BigInteger> cateSelectBookIds, Integer heatRequire);


    Result addNewBook(BigInteger userid, String title, String content, Integer value,String description);

    Result modifyBook(BigInteger userid, BigInteger bookid, String content, Integer value,String description);

    Result readBook(BigInteger userid,BigInteger bookid);

    Result getMarkedBooks(BigInteger userid);

    Result getBookByAuthorId(BigInteger userid);

    Result getOwnedBooks(BigInteger userid);
}
