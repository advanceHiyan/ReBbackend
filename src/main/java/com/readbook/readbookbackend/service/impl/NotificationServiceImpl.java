package com.readbook.readbookbackend.service.impl;

import com.readbook.readbookbackend.mapper.NotificationMapper;
import com.readbook.readbookbackend.pojo.Notification;
import com.readbook.readbookbackend.service.port.NotificationService;
import com.readbook.readbookbackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationMapper notificationMapper;

    @Override
    public Result addNotify(String receiverId, String content) {
        Notification notification = new Notification();
        notification.setReceiverId(new BigInteger(receiverId));
        notification.setContent(content);
        notification.setUpdatedTime(LocalDateTime.now());
        notification.setCreatedTime(LocalDateTime.now());
        notification.setStatus(0);
        notificationMapper.insertNotification(notification);
        return Result.success("add notify success", notification);
    }

    @Override
    public Result checkNotify(String receiverid) {
        List<Notification> notifications = notificationMapper.getNotificationsByReceiverId(new BigInteger(receiverid));
        return Result.success("get notify success", notifications);
    }
}
