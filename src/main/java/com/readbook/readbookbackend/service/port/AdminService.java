/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under a license. For more information, please visit Hiyan525@163.com
 */

package com.readbook.readbookbackend.service.port;

import com.readbook.readbookbackend.pojo.BanLog;
import com.readbook.readbookbackend.utils.Result;

import java.math.BigInteger;

public interface AdminService {
    Result banUser(BanLog banLog);

    Result banBook(BigInteger adminid, BigInteger bookid, String reason);

    Result endBanBook(BigInteger adminid, BigInteger bookid);

    Result endBanUser(BigInteger adminid, BigInteger userid);
}
