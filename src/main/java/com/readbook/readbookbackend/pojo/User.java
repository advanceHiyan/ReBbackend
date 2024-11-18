package com.readbook.readbookbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
