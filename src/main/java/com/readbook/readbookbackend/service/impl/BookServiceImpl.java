package com.readbook.readbookbackend.service.impl;

import com.readbook.readbookbackend.mapper.*;
import com.readbook.readbookbackend.pojo.Category;
import com.readbook.readbookbackend.pojo.OneBook;
import com.readbook.readbookbackend.utils.model.UserBookCollection;
import com.readbook.readbookbackend.service.BookService;
import com.readbook.readbookbackend.utils.model.BookWithCate;
import com.readbook.readbookbackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import static java.lang.Math.random;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookCollectMapper bookCollectMapper;
    @Autowired
    private BookOwnerMapper bookOwnerMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result bookmark(BigInteger userIdBigInteger, BigInteger bookIdBigInteger,String annotation) {
        String userName = bookCollectMapper.getUserNameById(userIdBigInteger);
        if(bookMapper.getBookById(bookIdBigInteger) == null) {
            return Result.error("Book not exist", "444");
        }
        if(bookCollectMapper.getBookInUserCollection(userIdBigInteger, bookIdBigInteger) != null) {
            return Result.error("Book is already bookmarked", "445");
        }
        String bookTitle = bookCollectMapper.getBookTitleById(bookIdBigInteger);
        UserBookCollection userBookCollection = new UserBookCollection();
        userBookCollection.setBookId(bookIdBigInteger);
        userBookCollection.setUserId(userIdBigInteger);
        userBookCollection.setAnnotation(annotation);
        userBookCollection.setUsername(userName);
        userBookCollection.setTitle(bookTitle);
        userBookCollection.setCreatedTime(LocalDateTime.now());
        userBookCollection.setUpdatedTime(LocalDateTime.now());
        bookCollectMapper.addBookToUserCollection(userBookCollection);
        return Result.success("User bookmark successfully",userBookCollection);
    }

    @Override
    public List<BookWithCate> bookfilter(BigInteger authorId, List<String> cates, Integer heatRequire) {
        return bookMapper.getBookByAuthorAndNeedCatesAndHeat(authorId, cates, heatRequire);
    }

    @Override
    public Result addNewBook(BigInteger userid, String title, String content, Integer value) {
        if(bookMapper.getBookByTitle(title)!= null) {
            return Result.error("Book already exist", "555");
        }
        OneBook oneBook = new OneBook();
        oneBook.setTitle(title);
        oneBook.setContent(content);
        oneBook.setValue(value);
        Random random = new Random();
        oneBook.setHeat((random.nextInt(100) + 1));
        oneBook.setCreatedTime(LocalDateTime.now());
        oneBook.setUpdatedTime(LocalDateTime.now());
        oneBook.setCreatorId(userid);
        String author = userMapper.getUserNameById(userid);
        oneBook.setAuthor(author);
        bookMapper.insertNewBook(oneBook);
        System.out.println(oneBook);
        return Result.success("New book added successfully", oneBook);//代表成功
    }

    @Override
    public Result modifyBook(BigInteger userid, BigInteger bookid, String content, Integer value) {
        OneBook oneBook = bookMapper.getBookById(bookid);
        if(oneBook == null) {
            return Result.error("Book not exist", "777");
        }
        boolean flag = true;
        if(content != null && !content.equals(oneBook.getContent())) {
            oneBook.setContent(content);
            oneBook.setUpdatedTime(LocalDateTime.now());
            flag = false;
        }
        if(value != null && !value.equals(oneBook.getValue())) {
            oneBook.setValue(value);
            oneBook.setUpdatedTime(LocalDateTime.now());
            flag = false;
        }
        if(flag) {
            return Result.error("Nothing to modify", "778");
        }
        if(!userid.equals(oneBook.getCreatorId())) {
            return Result.error("User not the creator of this book", "780");
        }
        bookMapper.updateBook(oneBook);
        OneBook returnBook = bookMapper.getBookById(bookid);
        List<Category> categories = bookMapper.findCategoriesByBookId(bookid);
        BookWithCate bookWithCate = new BookWithCate(returnBook, categories);
        return Result.success("Book modified successfully", bookWithCate);
    }

    @Override
    public Result readBook(BigInteger userid,BigInteger bookid) {
        if(bookMapper.getBookById(bookid) == null) {
            return Result.error("Book not exist", "779");
        }
        if(bookOwnerMapper.getBookOwnerByBookIdAndUserId(bookid, userid) == null) {
            return Result.error("User not own this book", "778");
        }
        OneBook oneBook = bookMapper.getBookById(bookid);
        List<Category> categories = bookMapper.findCategoriesByBookId(bookid);
        BookWithCate bookWithCate = new BookWithCate(oneBook, categories);
        return Result.success("Book read successfully", bookWithCate);
    }
}