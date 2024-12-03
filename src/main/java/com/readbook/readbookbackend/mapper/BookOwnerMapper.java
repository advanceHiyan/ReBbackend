package com.readbook.readbookbackend.mapper;

import com.readbook.readbookbackend.pojo.OneBook;
import com.readbook.readbookbackend.pojo.UserBookOwner;
import org.apache.ibatis.annotations.*;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface BookOwnerMapper {

    @Select("SELECT * FROM user_book_ownership_relationship WHERE book_id = #{bookid} " +
            "AND user_id = #{userid}")
    @Result(property = "id", column = "user_book_ownership_relationship_id")
    UserBookOwner getBookOwnerByBookIdAndUserId(BigInteger bookid, BigInteger userid);

    @Insert("INSERT INTO user_book_ownership_relationship (book_id, user_id)"
            + " VALUES (#{bookid}, #{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertBookOwner(UserBookOwner userBookOwner);

    @Select("SELECT * FROM book WHERE book.book_id IN " +
            "(SELECT book_id FROM user_book_ownership_relationship WHERE user_id = #{userId})")
    @Result(property = "id",column = "book_id")
    List<OneBook> getOwnedBookByUser(BigInteger userId);
}
