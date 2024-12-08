/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under a license. For more information, please visit Hiyan525@163.com
 */

package com.readbook.readbookbackend.service.port;

import com.readbook.readbookbackend.pojo.User;
import com.readbook.readbookbackend.utils.Result;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public interface UserService {
    Result getAllUsers();

    Result signUp(String username, String password, String email,Integer userRole);

    Result login(String username, String password);

    Result updatePassword(BigInteger userid, String curPassword,
                          String newPassword, String confirmPassword);

    Result updateEmail(BigInteger userid, String curPassword, String newEmail);
}
