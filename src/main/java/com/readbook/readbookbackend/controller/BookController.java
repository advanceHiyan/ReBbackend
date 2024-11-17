package com.readbook.readbookbackend.controller;

import com.readbook.readbookbackend.pojo.OneBook;
import com.readbook.readbookbackend.service.BookService;
import com.readbook.readbookbackend.service.CategoryService;
import com.readbook.readbookbackend.utils.model.BookWithCate;
import com.readbook.readbookbackend.utils.model.PageBooks;
import com.readbook.readbookbackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.readbook.readbookbackend.pojo.Category;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Transactional
    @PostMapping("/usercenter/newbook")
    public Result addNewBook(BigInteger userid, String title, String content, Integer value, String[] categories) {
        ArrayList<String> categoriesList = new ArrayList<>(Arrays.asList(categories));
        System.out.println(categoriesList);
        categoryService.addNewCategories(categoriesList);
        Result result = bookService.addNewBook(userid, title, content, value);
        if(result.getCode() != null) {
            return result;
        }
        return categoryService.addBookCategory(((OneBook) result.getData()), categoriesList);
    }

    @GetMapping("/usercenter/readbook")
    public Result readBook(BigInteger userid, BigInteger bookid) {
        return bookService.readBook(userid,bookid);
    }

    @PostMapping("/usercenter/modifybook")
    public Result modifyBook(BigInteger userid, BigInteger bookid, String content, Integer value) {
        return bookService.modifyBook(userid, bookid, content, value);
    }


    @PostMapping("/usercenter/bookmark")
    public Result bookmark(BigInteger userid, BigInteger bookid,String annotation) {
        return bookService.bookmark(userid, bookid,annotation);
    }

    @PostMapping("/usercenter/bookfilter")
    public Result bookfilter(BigInteger authorId, List<String> cates, Integer heatRequire) {
        List<BookWithCate> books = bookService.bookfilter(authorId, cates, heatRequire);
        if(books == null || books.size() == 0) {
            return Result.error("not found books that match the filter","446");
        }
        int total_count = books.size();
        int limit = total_count < 10 ? total_count : 10;
        if(total_count > 100) {
            limit = (total_count / 10) / 10 * 10;
        }
        if (limit >= 100) {
            limit = 100;
        }
        PageBooks pageBooks = new PageBooks();
        pageBooks.setBooks(books);
        pageBooks.setLimit(limit);
        pageBooks.setTotal_count(total_count);
        return Result.success("success",pageBooks);
    }
}