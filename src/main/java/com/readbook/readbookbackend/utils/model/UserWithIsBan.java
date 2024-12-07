package com.readbook.readbookbackend.utils.model;

import com.readbook.readbookbackend.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithIsBan {
    private BigInteger id;
    private String userName;
    private Integer isBan;
    private String email;

    public UserWithIsBan(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.isBan = 0;
    }
}
