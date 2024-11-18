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


    Result addNewBook(BigInteger userid, String title, String content, Integer value);

    Result modifyBook(BigInteger userid, BigInteger bookid, String content, Integer value);

    Result readBook(BigInteger userid,BigInteger bookid);
}
