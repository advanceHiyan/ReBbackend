/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under a license. For more information, please visit Hiyan525@163.com
 */

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
