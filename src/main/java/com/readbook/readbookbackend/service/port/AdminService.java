/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under the [License Name] license. For more information, please visit [License
 *   Link or Explanation URL].
 *   Unauthorized reproduction, distribution, display, performance, modification, adaptation, translation, creation of derivative works, or commercial use of this work in any form is prohibited without permission.
 */

package com.readbook.readbookbackend.service.port;

import com.readbook.readbookbackend.pojo.BanLog;
import com.readbook.readbookbackend.utils.Result;

import java.math.BigInteger;

public interface AdminService {
    Result banUser(BanLog banLog);

    Result banBook(BigInteger adminid, BigInteger bookid, String reason);

    Result endBanBook(BigInteger adminid, BigInteger bookid);
}
