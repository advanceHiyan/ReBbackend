package com.readbook.readbookbackend.service.port;

import com.readbook.readbookbackend.pojo.BanLog;
import com.readbook.readbookbackend.utils.Result;

import java.math.BigInteger;

public interface AdminService {
    Result banUser(BanLog banLog);

    Result banBook(BigInteger adminid, BigInteger bookid, String reason);

    Result endBanBook(BigInteger adminid, BigInteger bookid);
}
