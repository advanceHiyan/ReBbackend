package com.readbook.readbookbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
//CREATE TABLE user (
//                      user_id BIGINT UNSIGNED NOT NULL PRIMARY KEY,
//                      username VARCHAR(20) NOT NULL UNIQUE,
//                      email VARCHAR(64) NOT NULL,
//                      password VARCHAR(32) NOT NULL,
//                      failures_on_login INT NOT NULL,
//                      last_failure_on_login DATETIME NOT NULL,
//                      uploaded INT NOT NULL,
//                      user_role INT NOT NULL,
//                      created_time DATETIME NOT NULL,
//                      updated_time DATETIME NOT NULL
//);
public class User {
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
}
