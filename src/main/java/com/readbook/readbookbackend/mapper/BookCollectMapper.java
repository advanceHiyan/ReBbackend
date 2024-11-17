package com.readbook.readbookbackend.mapper;

import com.readbook.readbookbackend.utils.model.UserBookCollection;
import org.apache.ibatis.annotations.*;

import com.readbook.readbookbackend.pojo.OneBook;
import java.math.BigInteger;

@Mapper
public interface BookCollectMapper {
    @Select("SELECT user.username FROM user WHERE user.user_id = #{user_id}")
    String getUserNameById(BigInteger user_id);

    @Select("SELECT book.title FROM book WHERE book.book_id = #{book_id}")
    String getBookTitleById(BigInteger book_id);

    //收藏表
    @Select("SELECT * FROM h_db22371169.user_book_collection_relationship" +
            " WHERE  user_id = #{userId} and book_id = #{bookId}")
    @Result(column = "user.user_id", property = "id")
    UserBookCollection getBookInUserCollection(BigInteger userId, BigInteger bookId);

    @Insert("INSERT INTO user_book_collection_relationship(user_id, book_id,created_time,updated_time,annotation) " +
            "VALUES (#{userId}, #{bookId},#{createdTime},#{updatedTime},#{annotation})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addBookToUserCollection(UserBookCollection ubc);
}
