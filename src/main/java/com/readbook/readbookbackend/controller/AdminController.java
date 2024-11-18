package com.readbook.readbookbackend.controller;

import com.readbook.readbookbackend.pojo.BanLog;
import com.readbook.readbookbackend.service.AdminService;
import com.readbook.readbookbackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
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
        banLog.setBanReason(banreason);
        banLog.setStartTime(startTime);
        banLog.setOverTime(endTime);
        banLog.setNote(note);
        return adminService.banUser(banLog);
    }
}
