/*
 * Copyright (c) 2024, advanceHiyan.
 *  This work is licensed under a license. For more information, please visit Hiyan525@163.com
 */

package com.readbook.readbookbackend.service.port;

import com.readbook.readbookbackend.utils.Result;

public interface NotificationService {
    Result addNotify(String receiverId, String content);

    Result checkNotify(String receiverid);
}
