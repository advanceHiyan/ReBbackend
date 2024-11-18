package com.readbook.readbookbackend.service.impl;

import com.readbook.readbookbackend.mapper.NotificationMapper;
import com.readbook.readbookbackend.pojo.Notification;
import com.readbook.readbookbackend.service.port.NotificationService;
import com.readbook.readbookbackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationMapper notificationMapper;

    @Override
    public Result addNotify(String receiverId, String content) {
        Notification notification = new Notification();
        notification.setReceiverId(new BigInteger(receiverId));
        notification.setContent(content);
        notificationMapper.insertNotification(notification);
    }
}
