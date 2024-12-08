/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under a license. For more information, please visit Hiyan525@163.com
 */

package com.readbook.readbookbackend.service.impl;

import com.readbook.readbookbackend.mapper.UserMapper;
import com.readbook.readbookbackend.pojo.User;
import com.readbook.readbookbackend.service.port.UserService;
import com.readbook.readbookbackend.utils.filter.JwtUtils;
import com.readbook.readbookbackend.utils.Result;
import com.readbook.readbookbackend.utils.model.UserWithIsBan;
import com.readbook.readbookbackend.utils.model.UserWithJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result signUp(String username, String password, String email, Integer userRole) {
        if (userMapper.checkUsernameExists(username) != null) {
            return Result.error("Username already exists", "111");
        }
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setUserName(username);
        newUser.setFailuresOnLogin(0);
        if(userRole != null && userRole != 0) {
            newUser.setUserRole(userRole);
        } else {
            newUser.setUserRole(0);
        }
        newUser.setLastFailureOnLogin(LocalDateTime.now());
        newUser.setUploaded(0);
        newUser.setUpdatedTime(LocalDateTime.now());
        newUser.setCreatedTime(LocalDateTime.now());
        userMapper.insertUser(newUser);
        return Result.success("User created successfully", newUser);
    }

    @Override
    public Result login(String username, String password) {
        User getNameUser = userMapper.checkUsernameExists(username);
        if ( getNameUser== null) {
            return Result.error("Username not exists", "222");
        }
        int failuresOnLogin = getNameUser.getFailuresOnLogin();
        LocalDateTime lastWrongTime = getNameUser.getLastFailureOnLogin();
        Duration duration = Duration.between(lastWrongTime, LocalDateTime.now());
        long seconds = duration.toSecondsPart();
        if(failuresOnLogin >= 5 && seconds < 600) {
            int needSeconds = 600 - (int) seconds;
            return Result.error("too many failures, try again in #{needSeconds} minutes", "224");
        }
        if(userMapper.checkLoginCredentials(username, password) == null) {
            userMapper.updateLoginFailureInfo(username, LocalDateTime.now(),
                    failuresOnLogin + 1);
            return Result.error("Username or password incorrect", "223");
        }
        //登录成功
        userMapper.updateFailCountZero(username);
        User retUSer = userMapper.checkUsernameExists(username);
        //创建jwt
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", retUSer.getId());
        claims.put("userName", retUSer.getUserName());
        String jwt = JwtUtils.generateJwt(claims);
        //封装返回值
        UserWithJwt userWithJwt = new UserWithJwt(retUSer, jwt);
        return Result.success("User updated successfully", userWithJwt);
    }

    @Override
    public Result updatePassword(BigInteger userid, String curPassword, String newPassword, String confirmPassword) {
        if(!newPassword.equals(confirmPassword)) {
            return Result.error("New password and confirm password not equal", "333");
        }
        User user = userMapper.selectUserByIdAndPassword(userid, curPassword);
        if(user == null) {
            return Result.error("UserName(ID) or Current password is incorrect", "334");
        }
        userMapper.updatePassword(userid, newPassword, LocalDateTime.now());
        User retUser = userMapper.selectUserByIdAndPassword(userid, newPassword);
        return Result.success("User updated successfully", retUser);
    }

    @Override
    public Result updateEmail(BigInteger userid, String curPassword, String newEmail) {
        User user = userMapper.selectUserByIdAndPassword(userid, curPassword);
        if(user == null) {
            return Result.error("UserName(ID) or Current password is incorrect", "335");
        }
        userMapper.updateEmail(userid, newEmail, LocalDateTime.now());
        User retUser = userMapper.selectUserByIdAndPassword(userid, curPassword);
        return Result.success("User updated successfully", retUser);
    }

    @Override
    public Result getAllUsers() {
        List<User> users = userMapper.selectAllUsers();
        List<UserWithIsBan> userWithIsBans = new ArrayList<>();
        for(User user : users) {
            UserWithIsBan userWithIsBan = new UserWithIsBan(user);
            LocalDateTime banEndTime = userMapper.getLatestUnbanTimeByUserId(user.getId());
            if(banEndTime != null && LocalDateTime.now().isBefore(banEndTime)) {
                userWithIsBan.setIsBan(1);
            }
            userWithIsBans.add(userWithIsBan);
        }
        return Result.success("All users retrieved successfully", userWithIsBans);
    }
}
