package com.readbook.readbookbackend.controller;

import com.readbook.readbookbackend.service.port.NotificationService;
import com.readbook.readbookbackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping("/usercenter/addnotify")
    public Result addNotify(String receiverid,String content) {
        return notificationService.addNotify(receiverid,content);
    }

    @PostMapping("/usercenter/checknotify")
    public Result checkNotify(String receiverid) {
        return notificationService.checkNotify(receiverid);
    }
}
