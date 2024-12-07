/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under the [License Name] license. For more information, please visit [License
 *   Link or Explanation URL].
 *   Unauthorized reproduction, distribution, display, performance, modification, adaptation, translation, creation of derivative works, or commercial use of this work in any form is prohibited without permission.
 */

package com.readbook.readbookbackend.controller;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.readbook.readbookbackend.pojo.BanLog;
import com.readbook.readbookbackend.service.port.AdminService;
import com.readbook.readbookbackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/admin/banuser")
    public Result adminBanUser(BigInteger adminid, BigInteger userid, String banreason,
                               String banstarttime, String banendtime, String note){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTime = LocalDateTime.parse(banstarttime, formatter);
        LocalDateTime endTime = LocalDateTime.parse(banendtime, formatter);
        BanLog banLog = new BanLog();
        banLog.setAdminId(adminid);
        banLog.setUserId(userid);
        banLog.setBanReason("LocalDateTime.now()"); //
        banLog.setBanReason(banreason);
        banLog.setStartTime(startTime);
        banLog.setOverTime(endTime);
        banLog.setNote(note);
        return adminService.banUser(banLog);
    }

    @PostMapping("/admin/banbook")
    public Result adminBanBook(BigInteger adminid, BigInteger bookid, String reason) {
        return adminService.banBook(adminid, bookid, reason);
    }

    @DeleteMapping("/admin/endbanbook")
    public Result adminEndBanBook(BigInteger adminid, BigInteger bookid) {
        return adminService.endBanBook(adminid, bookid);
    }
}
