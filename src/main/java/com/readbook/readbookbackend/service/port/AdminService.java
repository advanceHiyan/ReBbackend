package com.readbook.readbookbackend.service.port;

import com.readbook.readbookbackend.pojo.BanLog;
import com.readbook.readbookbackend.utils.Result;

public interface AdminService {
    Result banUser(BanLog banLog);
}
