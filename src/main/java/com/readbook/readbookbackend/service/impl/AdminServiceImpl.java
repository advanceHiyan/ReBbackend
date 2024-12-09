/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under a license. For more information, please visit Hiyan525@163.com
 */

package com.readbook.readbookbackend.service.impl;

import com.readbook.readbookbackend.mapper.BookMapper;
import com.readbook.readbookbackend.mapper.CategoryMapper;
import com.readbook.readbookbackend.mapper.UserMapper;
import com.readbook.readbookbackend.pojo.BanBook;
import com.readbook.readbookbackend.pojo.BanLog;
import com.readbook.readbookbackend.pojo.User;
import com.readbook.readbookbackend.service.port.AdminService;
import com.readbook.readbookbackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Result banUser(BanLog banLog) {
        BigInteger adminId = banLog.getAdminId();
        User user = userMapper.getUserById(adminId);
        if(user.getUserRole() != 1) {
            return Result.error("You are not an admin","005");
        }
        userMapper.banUser(banLog);
        return Result.success("Ban user success",banLog);
    }

    @Override
    public Result banBook(BigInteger adminid, BigInteger bookid, String reason) {
        User user = userMapper.getUserById(adminid);
        if(user.getUserRole() != 1) {
            return Result.error("You are not an admin","008");
        }
        BanBook banBook = new BanBook();
        banBook.setBookId(bookid);
        banBook.setReason(reason);
        bookMapper.banBook(banBook);
        return Result.success("Ban book success",banBook);
    }

    @Override
    public Result endBanBook(BigInteger adminid, BigInteger bookid) {
        User user = userMapper.getUserById(adminid);
        if(user.getUserRole() != 1) {
            return Result.error("You are not an admin","009");
        }
        bookMapper.deleteBanBook(bookid);
        return Result.success("End ban book success",bookid+" book successfully end banned");
    }

    @Override
    public Result endBanUser(BigInteger adminid, BigInteger userid) {
        User user = userMapper.getUserById(adminid);
        if(user.getUserRole() != 1) {
            return Result.error("You are not an admin","010");
        }
        LocalDateTime banEndTime = userMapper.getLatestUnbanTimeByUserId(userid);
        if(banEndTime == null || !LocalDateTime.now().isBefore(banEndTime)) {
            return Result.success("User are not banned or already end banned do not need to end ban");
        }
        userMapper.deleteBanUser(userid);
        return Result.success("End ban user success",userid+" user successfully end banned");
    }
}
