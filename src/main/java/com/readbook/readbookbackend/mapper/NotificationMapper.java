package com.readbook.readbookbackend.mapper;

import com.readbook.readbookbackend.pojo.Notification;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface NotificationMapper {
    void insertNotification(Notification notification);

    List<Notification> getNotificationsByReceiverId(BigInteger receiverId);
}
