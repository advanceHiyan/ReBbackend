package com.readbook.readbookbackend.service.port;

import com.readbook.readbookbackend.utils.Result;

public interface NotificationService {
    Result addNotify(String receiverId, String content);

    Result checkNotify(String receiverid);
}
