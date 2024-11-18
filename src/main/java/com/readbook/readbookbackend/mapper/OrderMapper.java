package com.readbook.readbookbackend.mapper;

import com.readbook.readbookbackend.pojo.OneBook;
import com.readbook.readbookbackend.pojo.OrderBookRela;
import com.readbook.readbookbackend.pojo.OrderInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface OrderMapper {

    List<OneBook> getBookListByIdList(List<BigInteger> bookIdList);

    void insertOrderInfo(OrderInfo orderInfo);

    void insertOrderToBook(OrderBookRela orderBookRela);
}
