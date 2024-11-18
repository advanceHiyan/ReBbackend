package com.readbook.readbookbackend.mapper;

import com.readbook.readbookbackend.pojo.BanBook;
import com.readbook.readbookbackend.pojo.Category;
import com.readbook.readbookbackend.utils.model.BookWithCate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import com.readbook.readbookbackend.pojo.OneBook;
import java.math.BigInteger;
import java.util.List;

@Mapper
public interface BookMapper {


    OneBook getBookById(BigInteger id); //必须设置类id和数据库主键映射

    List<OneBook> getBookByAuthorAndNeedCatesAndHeat(@Param("authorId") BigInteger authorId,
                                                          @Param("cateSelectedIds") List<BigInteger> cateSelectedIds,
                                                          @Param("heatRequire") Integer heatRequire);

    void insertNewBook(OneBook oneBook);

    OneBook getBookByTitle(String title);//必须设置类id和数据库主键映射

    int updateBook(OneBook oneBook);

    List<Category> findCategoriesByBookId(BigInteger bookId);//必须设置类id和数据库主键映射

    List<OneBook> getAllBooks(); //必须设置类id和数据库主键映射

    void insertOwnShip(BigInteger userId, BigInteger bookId);

    void banBook(BanBook banBook);

    void deleteBanBook(BigInteger bookId);
}
