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
public class UserWithJwt {
    private BigInteger id;
    private String userName;
    private String email;
    private String password;
    private Integer failuresOnLogin;
    private LocalDateTime lastFailureOnLogin;
    private Integer uploaded;
    private Integer userRole;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private String jwt;

    public UserWithJwt(User user, String jwt) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.failuresOnLogin = user.getFailuresOnLogin();
        this.lastFailureOnLogin = user.getLastFailureOnLogin();
        this.uploaded = user.getUploaded();
        this.userRole = user.getUserRole();
        this.createdTime = user.getCreatedTime();
        this.updatedTime = user.getUpdatedTime();
        this.jwt = jwt;
    }
}
