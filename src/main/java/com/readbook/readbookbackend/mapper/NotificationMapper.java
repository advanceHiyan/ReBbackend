package com.readbook.readbookbackend.mapper;

import com.readbook.readbookbackend.pojo.Notification;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NotificationMapper {
    void insertNotification(Notification notification);
}
