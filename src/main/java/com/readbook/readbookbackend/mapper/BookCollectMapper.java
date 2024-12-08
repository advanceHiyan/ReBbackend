/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under a license. For more information, please visit Hiyan525@163.com
 */

package com.readbook.readbookbackend.mapper;

import com.readbook.readbookbackend.utils.model.UserBookCollection;
import org.apache.ibatis.annotations.*;

import com.readbook.readbookbackend.pojo.OneBook;
import java.math.BigInteger;
import java.util.List;

@Mapper
public interface BookCollectMapper {
    @Select("SELECT user.username FROM user WHERE user.user_id = #{user_id}")
    String getUserNameById(BigInteger user_id);

    @Select("SELECT book.title FROM book WHERE book.book_id = #{book_id}")
    String getBookTitleById(BigInteger book_id);

    //收藏表
    @Select("SELECT * FROM h_db22371169.user_book_collection_relationship" +
            " WHERE  user_id = #{userId} and book_id = #{bookId}")
    @Result(column = "user_book_collection_relationship_id", property = "id")
    UserBookCollection getBookInUserCollection(BigInteger userId, BigInteger bookId);

    @Insert("INSERT INTO user_book_collection_relationship(user_id, book_id,created_time,updated_time,annotation) " +
            "VALUES (#{userId}, #{bookId},#{createdTime},#{updatedTime},#{annotation})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addBookToUserCollection(UserBookCollection ubc);

    @Select("SELECT * FROM book WHERE book.book_id IN " +
            "(SELECT book_id FROM user_book_collection_relationship WHERE user_id = #{userId})")
    @Result(column = "book_id", property = "id")
    List<OneBook> getMarkedBookByUser(BigInteger userId);
}
