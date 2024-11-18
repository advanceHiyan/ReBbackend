package com.readbook.readbookbackend.service.impl;

import com.readbook.readbookbackend.mapper.BookMapper;
import com.readbook.readbookbackend.mapper.CategoryMapper;
import com.readbook.readbookbackend.mapper.UserMapper;
import com.readbook.readbookbackend.pojo.BanLog;
import com.readbook.readbookbackend.pojo.User;
import com.readbook.readbookbackend.service.port.AdminService;
import com.readbook.readbookbackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

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
}
